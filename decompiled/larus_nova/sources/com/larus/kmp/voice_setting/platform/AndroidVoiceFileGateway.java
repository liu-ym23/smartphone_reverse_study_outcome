package com.larus.kmp.voice_setting.platform;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class AndroidVoiceFileGateway implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f351661a;

    public AndroidVoiceFileGateway(Context r100) {
        this.f351661a = r100;
    }

    @Override // com.larus.kmp.voice_setting.platform.b0
    public final c0 a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Context r101 = this.f351661a;
        if (r101 == null) goto L8;
        File r102 = r101.getCacheDir();
        if (r102 == null) goto L8;
        String r103 = new PolarisFileWrapper(r102, r100).getPath();
        if (r103 == null) goto L8;
    L9:
        Intrinsics.checkNotNull(r103);
        return new c0(r103);
    L8:
        r103 = new PolarisFileWrapper(r100).getPath();
        goto L9
    }

    @Override // com.larus.kmp.voice_setting.platform.b0
    public final boolean c(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return new PolarisFileWrapper(r100.f351673a).exists();
    }

    @Override // com.larus.kmp.voice_setting.platform.b0
    public final c0 d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Context r101 = this.f351661a;
        if (r101 == null) goto L8;
        File r102 = r101.getCacheDir();
        if (r102 == null) goto L8;
        String r103 = new PolarisFileWrapper(r102, r100).getPath();
        if (r103 == null) goto L8;
    L9:
        Intrinsics.checkNotNull(r103);
        return new c0(r103);
    L8:
        r103 = new PolarisFileWrapper(r100).getPath();
        goto L9
    }

    @Override // com.larus.kmp.voice_setting.platform.b0
    public final Object b(String r100, c0 r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof AndroidVoiceFileGateway$copyAsset$1) == false) goto L7;
        AndroidVoiceFileGateway$copyAsset$1 r103 = (AndroidVoiceFileGateway$copyAsset$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L24
    L22:
        Object r108 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L24
    L26:
        Boolean r109 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r108) == true) goto L29;
        return r108;
    L29:
        return r109;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        Context r110 = this.f351661a;
        if (r110 == null) goto L18;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L24
        PolarisFileWrapper r112 = new PolarisFileWrapper(r101.f351673a);     // Catch: Throwable -> L24
        r103.label = 1;     // Catch: Throwable -> L24
        if (com.larus.kmp.voice_setting.voice.utils.a.a(r100, r110, r112, r103) != r106) goto L22;
        return r106;
    L18:
        return Boxing.boxBoolean(false);
    L24:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new AndroidVoiceFileGateway$copyAsset$1(this, r102);
        goto L8
    }
}
