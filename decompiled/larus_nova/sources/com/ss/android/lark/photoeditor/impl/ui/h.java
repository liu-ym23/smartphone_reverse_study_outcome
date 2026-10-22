package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h extends BaseModel implements a {
    public h() {
    }

    public static boolean h(h r110, Bitmap r111) {
        r110.getClass();
        if (p0c.a.a() != null) goto L5;
    L7:
        if (r111 != null) goto L9;
        return false;
    L9:
        if (r111.hasAlpha() == false) goto L26;
        int r112 = r111.getWidth();
        int r100 = r111.getHeight();
        int[] r113 = new int[r112];
        int r114 = 0;
    L12:
        if (r114 >= r100) goto L27;
        r111.getPixels(r113, 0, r112, 0, r114, r112, 1);
        int r101 = 0;
    L14:
        if (r101 >= r112) goto L19;
        if ((r113[r101] >>> 24) != 255) goto L17;
        r101 = r101 + 1;
        goto L14
    L17:
        return true;
    L19:
        r114 = r114 + 1;
        goto L12
    L27:
        return false;
    L26:
        return false;
    L5:
        if (p0c.a.a().isFeatureGatingEnable("image_editor.photo_png_compress_reverse") == false) goto L7;
        return false;
    }

    public static void k(h r100, VFSFile r101) {
        r100.getClass();
        CipherManager.c(r101);     // Catch: EncryptException -> L5
        Log.i("PhotoEditorModel", "[cipher] file encrypt success, path = " + r101.getAbsolutePath());     // Catch: EncryptException -> L5
        return;
    L5:
        Log.e("PhotoEditorModel", "[cipher] file encrypt failed, path = " + r101.getAbsolutePath());
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void g5(File r100, l r101) {
        int r102 = CipherManager.f456788a;
        Intrinsics.checkNotNullParameter(r100, "file");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.lark.android.encryption.a(r100, false, r101));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void n0(final Bitmap r100, final vfc.d r101) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(this, r100, r101));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void m1(Bitmap r100, String r101, m.a r102) {
        Observable.create(new g(this, r101, r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r102), new f(r102));
    }
}
