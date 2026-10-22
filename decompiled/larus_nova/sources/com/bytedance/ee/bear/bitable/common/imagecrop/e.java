package com.bytedance.ee.bear.bitable.common.imagecrop;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageCropFragment f209850a;

    public e(ImageCropFragment r100) {
        this.f209850a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("ImageCropFragment", "Save failed : " + ((Throwable) r100));
        ImageCropFragment.b r101 = this.f209850a.f209840h;
        if (r101 == null) goto L6;
        r101.c(UIHelper.getString(R.string.Lark_Legacy_UcropUploadingAvatarFail));
        return;
    }
}
