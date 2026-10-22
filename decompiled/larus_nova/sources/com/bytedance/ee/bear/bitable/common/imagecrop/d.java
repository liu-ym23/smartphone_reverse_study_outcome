package com.bytedance.ee.bear.bitable.common.imagecrop;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageCropFragment f209849a;

    public d(ImageCropFragment r100) {
        this.f209849a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VFSFile r101 = (VFSFile) r100;
        Log.i("ImageCropFragment", "Save succeed after edit: " + r101.getAbsolutePath());
        ImageCropFragment.b r102 = this.f209849a.f209840h;
        if (r102 == null) goto L6;
        r102.d(r101.getAbsolutePath());
        return;
    }
}
