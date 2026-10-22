package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import ea5.h;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f225613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoResolutionAdapter f225614b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VideoResolutionAdapter r101 = this.f225614b;
        VideoResolutionAdapter.a r102 = r101.f225601c;
        if (r102 == null) goto L11;
        String r103 = ((ja5.a) ListProtector.get(r101.f225599a, this.f225613a)).f497884b;
        String r104 = ((ja5.a) ListProtector.get(this.f225614b.f225599a, this.f225613a)).f497885c;
        h r105 = (h) r102;
        if (TextUtils.equals(r105.f471589b.f225519t, r103) == true) goto L13;
        r105.f471589b.f225504e.setResolution(r104);
        TTVideoView r106 = r105.f471589b;
        r106.F(r106.Q.get(r103));
        r105.f471589b.f225519t = r103;
        ResolutionPopupWindow r107 = r105.f471588a.f225609d;
        if (r107 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r107);
        r107.dismiss();
        return;
    L12:
        return;
    L13:
        return;
    }

    public b(VideoResolutionAdapter r100, int r101) {
        this.f225614b = r100;
        this.f225613a = r101;
    }
}
