package com.bytedance.dux.font;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uy5.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.dux.font.DuxFontHelper$getFont$2", f = "DuxFontHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DuxFontHelper$getFont$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DuxFontHelper.a $callback;
    final /* synthetic */ String $channel;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fontName;
    final /* synthetic */ long $timeout;
    int label;

    public DuxFontHelper$getFont$2(Context r100, String r101, long r102, DuxFontHelper.a r103, String r104, Continuation<? super DuxFontHelper$getFont$2> r105) {
        this.$context = r100;
        this.$channel = r101;
        this.$timeout = r102;
        this.$fontName = r104;
        super(2, r105);
    }

    public static /* synthetic */ Typeface access$000(String r100) {
        return Typeface.createFromFile(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new DuxFontHelper$getFont$2(this.$context, this.$channel, this.$timeout, null, this.$fontName, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DuxFontHelper$getFont$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static Typeface INVOKESTATIC_com_bytedance_dux_font_DuxFontHelper$getFont$2_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r100) == true) goto L8;
        Typeface r101 = access$000(r100);
        if (r101 == null) goto L14;
        TypeFaceLancet.cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r100);
    L14:
        return access$000(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$context.getFilesDir().getCanonicalPath() + "/offlineX/";     // Catch: Throwable -> L28
        Context r102 = this.$context;     // Catch: Throwable -> L28
        Lazy r103 = DuxFontHelper.f205084a;     // Catch: Throwable -> L28
        c r104 = new c(r102, (String) DuxFontHelper.f205085b.getValue(), new PolarisFileWrapper(r101));     // Catch: Throwable -> L28
        String r105 = this.$channel + File.separator;     // Catch: Throwable -> L36
        boolean r106 = false;
        boolean r107 = r104.f552136a.a(r105);     // Catch: Throwable -> L10
    L12:
        if (r107 == false) goto L14;
    L20:
        Typeface r108 = INVOKESTATIC_com_bytedance_dux_font_DuxFontHelper$getFont$2_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(r104.a(r105 + this.$fontName));     // Catch: Throwable -> L36
        if ((!Intrinsics.areEqual(r108, Typeface.DEFAULT)) == true) goto L24;
        r108 = null;
    L24:
        if (r108 == null) goto L26;
        throw null;     // Catch: Throwable -> L36
    L26:
        new Exception("[DuxFont] Get null.");     // Catch: Throwable -> L36
        throw null;     // Catch: Throwable -> L36
    L14:
        if (DuxFontHelper.f205087d.contains(this.$channel) == true) goto L16;
        r106 = DuxFontHelper.b(this.$channel, this.$timeout);     // Catch: Throwable -> L36
    L16:
        if (r106 == true) goto L20;
        new Exception("[DuxFont] Channel not exist.");     // Catch: Throwable -> L36
        throw null;     // Catch: Throwable -> L36
    L10:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L36
        r107 = false;
    L42:
        throw null;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        if (r104 == null) goto L33;
        r104.b();
    L33:
        throw th;
    L28:
        r104 = null;
        goto L42
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
