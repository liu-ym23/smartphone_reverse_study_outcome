package com.bytedance.ee.bear.bitable.common.imagecrop;

import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VFSPath f209847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f209848b;

    public c(VFSPath r100, Bitmap r101) {
        this.f209847a = r100;
        this.f209848b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<VFSFile> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        OutputStream r101 = null;
        Log.d("ImageCropFragment", "result file isExit = " + com.suite.lark.component.storage.ext.b.b(this.f209847a));     // Catch: Throwable -> L11 Exception -> L13
        if (com.suite.lark.component.storage.ext.b.b(this.f209847a) == true) goto L6;
        com.suite.lark.component.storage.ext.b.a(this.f209847a);     // Catch: Throwable -> L11 Exception -> L13
    L6:
        Bitmap r102 = this.f209848b;     // Catch: Throwable -> L11 Exception -> L13
        VFSPath r103 = this.f209847a;     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L11 Exception -> L13
        VFSFiles.f444819b.getClass();     // Catch: Throwable -> L11 Exception -> L13
        r101 = VFSFiles.a(r103).s(r103, false);     // Catch: Throwable -> L11 Exception -> L13
        r102.compress(Bitmap.CompressFormat.JPEG, 75, r101);     // Catch: Throwable -> L11 Exception -> L13
        r101.flush();     // Catch: Throwable -> L11 Exception -> L13
        r100.onNext(this.f209847a.toFile());     // Catch: Throwable -> L11 Exception -> L13
        r100.onComplete();     // Catch: Throwable -> L11 Exception -> L13
    L34:
        r101.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        Throwable r104 = new Throwable(e);
    L20:
        r100.onError(r104);
        return;
    L11:
        th = move-exception;
        if (r101 != null) goto L30;
    L27:
        throw th;
    L30:
        r101.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        r100.onError(new Throwable(e));
    L13:
        e = move-exception;
        r100.onError(new Throwable(e));     // Catch: Throwable -> L11
        if (r101 == null) goto L36;
        r101.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        r104 = new Throwable(e);
        goto L20
    }
}
