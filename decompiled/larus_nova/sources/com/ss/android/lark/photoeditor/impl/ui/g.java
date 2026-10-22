package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements ObservableOnSubscribe<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f438578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f438579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f438580c;

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<File> r100) throws Exception {
        OutputStream r101 = null;
        VFSFiles.f444819b.getClass();     // Catch: Throwable -> L15 Exception -> L17
        VFSFile r102 = VFSFiles.b(true).i(this.f438578a);     // Catch: Throwable -> L15 Exception -> L17
        Log.i("PhotoEditorModel", "result file isExit = " + r102.exists());     // Catch: Throwable -> L15 Exception -> L17
        if (r102.exists() == true) goto L6;
        r102.createNewFile();     // Catch: Throwable -> L15 Exception -> L17
    L6:
        r101 = VFSFiles.b(true).s(r102.getVfsPath(), false);     // Catch: Throwable -> L15 Exception -> L17
        if (h.h(this.f438580c, this.f438579b) == false) goto L9;
        Bitmap.CompressFormat r103 = Bitmap.CompressFormat.PNG;     // Catch: Throwable -> L15 Exception -> L17
    L10:
        Log.i("PhotoEditorModel", "result file bitmap compress format = " + r103 + ", isSuccessful = " + this.f438579b.compress(r103, 100, r101));     // Catch: Throwable -> L15 Exception -> L17
        r101.flush();     // Catch: Throwable -> L15 Exception -> L17
        h.k(this.f438580c, r102);     // Catch: Throwable -> L15 Exception -> L17
        r100.onNext(r102);     // Catch: Throwable -> L15 Exception -> L17
        r100.onComplete();     // Catch: Throwable -> L15 Exception -> L17
    L39:
        r101.close();     // Catch: IOException -> L13
        return;
    L13:
        e = move-exception;
        Throwable r104 = new Throwable(e);
    L24:
        r100.onError(r104);
        return;
    L9:
        r103 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = move-exception;
        r100.onError(new Throwable(e));     // Catch: Throwable -> L15
        if (r101 == null) goto L41;
        r101.close();     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        r104 = new Throwable(e);
        goto L24
    L41:
        return;
    L15:
        th = move-exception;
        if (r101 != null) goto L34;
    L31:
        throw th;
    L34:
        r101.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        r100.onError(new Throwable(e));
        goto L31
    }

    public g(h r100, String r101, Bitmap r102) {
        this.f438580c = r100;
        this.f438578a = r101;
        this.f438579b = r102;
    }
}
