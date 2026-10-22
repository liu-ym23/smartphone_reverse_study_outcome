package com.larus.uaigc.service;

import android.content.Context;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$resolveShareUri$2", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaMenuShareHelper$resolveShareUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $preferPublicDownload;
    final /* synthetic */ String $rawSource;
    int label;

    public LocalMediaMenuShareHelper$resolveShareUri$2(String r100, Context r101, boolean r102, Continuation<? super LocalMediaMenuShareHelper$resolveShareUri$2> r103) {
        this.$rawSource = r100;
        this.$context = r101;
        this.$preferPublicDownload = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LocalMediaMenuShareHelper$resolveShareUri$2(this.$rawSource, this.$context, this.$preferPublicDownload, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Uri> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Uri> r101) {
        return ((LocalMediaMenuShareHelper$resolveShareUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L30:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        u r103 = u.f373992a;
        String r104 = this.$rawSource;
        r103.getClass();
        if (r104 != null) goto L11;
    L24:
        Uri r105 = null;
    L25:
        if (r105 != null) goto L27;
        return null;
    L27:
        Context r106 = this.$context;
        boolean r107 = this.$preferPublicDownload;
        this.label = 1;
        r100 = u.a(r103, r106, r105, r107, this);
        if (r100 != r101) goto L30;
        return r101;
    L11:
        if ((!StringsKt.isBlank(r104)) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L24;
        if (StringsKt.startsWith$default(r104, HTTP.URL_DEFAULT, false, 2, null) == false) goto L20;
        r105 = Uri.fromFile(new PolarisFileWrapper(r104));
        goto L25
    L20:
        if (StringsKt.startsWith$default(r104, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == false) goto L22;
    L23:
        r105 = UriProtector.parse(r104);
        goto L25
    L22:
        if (StringsKt.startsWith$default(r104, "content://", false, 2, null) == false) goto L24;
        goto L23
    }
}
