package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import ea5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VideoResolutionAdapter b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        VideoResolutionAdapter r5 = this.b;
        VideoResolutionAdapter.a r0 = r5.c;
        if (r0 == null) goto L11;
        String r6 = ((ja5.a) ListProtector.get(r5.a, this.a)).b;
        String r1 = ((ja5.a) ListProtector.get(this.b.a, this.a)).c;
        h r2 = (h) r0;
        if (TextUtils.equals(r2.b.t, r6) == true) goto L13;
        r2.b.e.setResolution(r1);
        TTVideoView r3 = r2.b;
        r3.F(r3.Q.get(r6));
        r2.b.t = r6;
        ResolutionPopupWindow r7 = r2.a.d;
        if (r7 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r7);
        r7.dismiss();
        return;
    L12:
        return;
    L13:
        return;
    }

    public b(VideoResolutionAdapter r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
