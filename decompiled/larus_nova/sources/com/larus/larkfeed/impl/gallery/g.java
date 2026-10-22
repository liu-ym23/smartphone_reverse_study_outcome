package com.larus.larkfeed.impl.gallery;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.larus.larkfeed.impl.databinding.LarusSocialGalleryLarkImageViewBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class g implements kza.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkImageView f355215a;

    @Override // kza.j
    public final void onLoadSuccess() {
        FLogger.f375446a.i("LarkImageView", "loadDefault success");
        LarusSocialGalleryLarkImageViewBinding r100 = this.f355215a.f355172c;
        if (r100 == null) goto L7;
        ProgressBar r101 = r100.f355154b;
        if (r101 == null) goto L7;
        e1.o(r101);
    L7:
        LarusSocialGalleryLarkImageViewBinding r102 = this.f355215a.f355172c;
        if (r102 == null) goto L13;
        RelativeLayout r103 = r102.f355155c;
        if (r103 == null) goto L14;
        e1.o(r103);
        return;
    L14:
        return;
    }

    public g(LarkImageView r100) {
        this.f355215a = r100;
    }

    @Override // kza.j
    public final void a(String r100) {
        FLogger.f375446a.i("LarkImageView", "loadDefault failed, errorCode: -1, errorMsg: ".concat(r100));
        LarusSocialGalleryLarkImageViewBinding r101 = this.f355215a.f355172c;
        if (r101 == null) goto L7;
        ProgressBar r102 = r101.f355154b;
        if (r102 == null) goto L7;
        e1.o(r102);
    L7:
        LarusSocialGalleryLarkImageViewBinding r103 = this.f355215a.f355172c;
        if (r103 == null) goto L13;
        RelativeLayout r104 = r103.f355155c;
        if (r104 == null) goto L14;
        e1.x(r104);
        return;
    L14:
        return;
    }
}
