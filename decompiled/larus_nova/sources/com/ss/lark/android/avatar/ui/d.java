package com.ss.lark.android.avatar.ui;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes40.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarCropFragment f456753a;

    public d(AvatarCropFragment r100) {
        this.f456753a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("AvatarCropFragment", "Save failed : " + ((Throwable) r100));
        AvatarCropFragment.b r101 = this.f456753a.f456672h;
        if (r101 == null) goto L6;
        r101.c(UIHelper.getString(R.string.Lark_Legacy_UcropUploadingAvatarFail));
        return;
    }
}
