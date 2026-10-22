package com.bytedance.android.livesdk.linkvideo;

import com.bytedance.android.livesdk.log.j0;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements b {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void c(String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_introduction_button_click", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void g(String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_reselect", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void h(String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_cancel", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void i(String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_introduction_button_show", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void a(String r4, String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_confirm_live_related_video_button_show", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void d(String r4, String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_introduction_return", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void f(boolean r4, String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r6 = "live_related_video_reselect";
    L6:
        r1.put("enter_from", r6);
        r1.put("anchor_id", r5);
        Unit r7 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_show_empty", r1, new Object[]{null});
        return;
    L5:
        r6 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void k(String r4, String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_introduction_show", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void m(String r4, String r5) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_introduction_show_bottom", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void b(boolean r4, String r5, String r6) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r7 = "live_related_video_reselect";
    L6:
        r1.put("enter_from", r7);
        r1.put("anchor_id", r5);
        r1.put("video_id", r6);
        Unit r8 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_show", r1, new Object[]{null});
        return;
    L5:
        r7 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void e(boolean r4, String r5, String r6) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r7 = "live_related_video_reselect";
    L6:
        r1.put("enter_from", r7);
        r1.put("anchor_id", r5);
        r1.put("video_id", r6);
        Unit r8 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_click", r1, new Object[]{null});
        return;
    L5:
        r7 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void j(String r4, String r5, String r6) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        r1.put("video_id", r6);
        Unit r7 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_confirm_live_related_video_button_click", r1, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void l(String r4, String r5, String r6) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from", r4);
        r1.put("anchor_id", r5);
        r1.put("video_id", r6);
        Unit r7 = Unit.INSTANCE;
        r0.sendLog("livesdk_takepag_live_related_video_play", r1, new Object[]{null});
    }
}
