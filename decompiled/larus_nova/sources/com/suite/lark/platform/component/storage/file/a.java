package com.suite.lark.platform.component.storage.file;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.FileAccessCompatManager;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements FileAccessCompatManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f460630a;

    public a() {
        this.f460630a = true;
    }

    @Override // com.ss.android.lark.vfs.FileAccessCompatManager.b
    public final File a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    L7:
        e = move-exception;
        Log.e("LarkFileStorage", "[cipher] file encrypt failed, original path = " + r100.getAbsolutePath() + ", " + e.getErrorCode());
    L9:
        return r100;
    L4:
        if (this.f460630a == false) goto L9;
        CipherManager.c(r100);     // Catch: EncryptException -> L7
        goto L9
    }

    @Override // com.ss.android.lark.vfs.FileAccessCompatManager.b
    public final void accept(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
    }

    @Override // com.ss.android.lark.vfs.FileAccessCompatManager.b
    public final File b(File r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return CipherManager.e(r100, false);
    L5:
        e = move-exception;
        Log.e("LarkFileStorage", "[cipher] file decrypt failed, original path = " + r100.getAbsolutePath() + ", " + e.getErrorCode());
        return r100;
    }
}
