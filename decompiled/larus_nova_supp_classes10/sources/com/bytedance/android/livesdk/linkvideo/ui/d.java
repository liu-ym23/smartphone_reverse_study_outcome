package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.utils.v6;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback {
    public final /* synthetic */ LinkVideoDialog a;

    public final void onDismiss() {
    }

    public final void onPausePlay(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public final void onPlayCompletedFirstTime(String r1) {
    }

    public final void onPlayFailed(String r1, String r2) {
    }

    public final void onResumePlay(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void onShow() {
    }

    public d(LinkVideoDialog r1) {
        this.a = r1;
    }

    public final void onPlaying(String r6) {
        LinkVideoDialog r7 = this.a;
        if (r7.D != 3) goto L9;
        if (r7.O == false) goto L9;
        r7.O = false;
        return;
    L9:
        if (r7.Q == false) goto L21;
        IRoomModuleService r8 = k.f(IRoomModuleService.class);
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.linkvideo.b r9 = r8.getLinkVideoTea();
        if (r9 == null) goto L19;
        if (this.a.D != 2) goto L17;
        String r0 = "related_video";
    L18:
        r9.l(r0, v6.a(), String.valueOf(this.a.P));
        goto L19
    L17:
        r0 = "related_video_done";
    L19:
        this.a.Q = false;
        return;
    }

    public final void onRenderFirstFrame(String r3) {
        LinkVideoDialog r4 = this.a;
        r4.w = LinkVideoDialog.S90(r4.u);
        LinkVideoDialog r5 = this.a;
        if (r5.D != 3) goto L16;
        View r6 = r5.w;
        Object r0 = null;
        if (r6 == null) goto L7;
        ViewParent r7 = r6.getParent();
    L9:
        if ((r7 instanceof View) == false) goto L12;
        r0 = r7;
    L12:
        View r1 = (View) r0;
        if (r1 == null) goto L17;
        r1.performClick();
        return;
    L17:
        return;
    L7:
        r7 = null;
        goto L9
    }
}
