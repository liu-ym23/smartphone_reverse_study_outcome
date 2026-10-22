package com.larus.camera.impl.result;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.result.CameraResultFirstFlow$canReadUri$2", f = "CameraResultFirstFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CameraResultFirstFlow$canReadUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public CameraResultFirstFlow$canReadUri$2(Uri r100, Context r101, Continuation<? super CameraResultFirstFlow$canReadUri$2> r102) {
        this.$uri = r100;
        this.$context = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CameraResultFirstFlow$canReadUri$2 r102 = new CameraResultFirstFlow$canReadUri$2(this.$uri, this.$context, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((CameraResultFirstFlow$canReadUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$uri.getScheme();
        if (r102 == null) goto L34;
        int r103 = r102.hashCode();
        boolean r104 = false;
        boolean r105 = true;
        if (r103 == 3143036) goto L27;
        if (r103 != 951530617) goto L36;
        if (r102.equals("content") == false) goto L36;
        Context r106 = this.$context;
        Uri r107 = this.$uri;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        ParcelFileDescriptor r109 = a(r106.getContentResolver(), r107);     // Catch: Throwable -> L20
        if (r109 == null) goto L17;
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L20
    L18:
        Object r110 = Result.m9449constructorimpl(Boxing.boxBoolean(r105));     // Catch: Throwable -> L20
    L22:
        Boolean r111 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r110) == false) goto L25;
        r110 = r111;
    L25:
        r104 = ((Boolean) r110).booleanValue();
        goto L36
    L17:
        r105 = false;
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        return Boxing.boxBoolean(r104);
    L27:
        if (r102.equals("file") == false) goto L36;
        String r113 = this.$uri.getPath();
        if (r113 == null) goto L36;
        if (new PolarisFileWrapper(r113).canRead() != true) goto L36;
        r104 = true;
        goto L36
    L34:
        r104 = new PolarisFileWrapper(this.$uri.toString()).canRead();
        goto L36
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
