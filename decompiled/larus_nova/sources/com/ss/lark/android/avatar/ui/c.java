package com.ss.lark.android.avatar.ui;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes40.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarCropFragment f456752a;

    public c(AvatarCropFragment r100) {
        this.f456752a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VFSFile r101 = (VFSFile) r100;
        Log.i("AvatarCropFragment", "Save succeed after edit: " + r101.getAbsolutePath());
        AvatarCropFragment.b r102 = this.f456752a.f456672h;
        if (r102 == null) goto L6;
        r102.d(r101.getAbsolutePath());
        return;
    }
}
