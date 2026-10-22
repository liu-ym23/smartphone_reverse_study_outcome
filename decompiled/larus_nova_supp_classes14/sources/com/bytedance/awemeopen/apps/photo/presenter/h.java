package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ CameraWeekPresenter b;
    public final /* synthetic */ r14.w c;

    public h(View r1, CameraWeekPresenter r2, r14.w r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.a) == false) goto L5;
        return;
    L5:
        AosExtConfig r1 = AosExtConfig.b;
        Activity r2 = this.b.d.getActivity();
        String r3 = this.c.d();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r1.P1(r2, r3, new JSONObject().put("anchor_position", "above_comment").put("enter_from", this.b.d.c.sceneId()));
        AosEventReporter r4 = AosEventReporter.a;
        String r5 = this.b.d.c.sceneId();
        AosPictureDetailConfig r6 = this.b.d.c.getPageConfig();
        if (r6 == null) goto L11;
        String r7 = r6.getPreviousPage();
    L12:
        r14.c r8 = this.b.d.a;
        String r9 = this.c.i();
        if (r9 != null) goto L15;
        String r15 = "";
    L16:
        String r10 = String.valueOf(this.c.b());
        String r11 = this.c.a();
        if (r11 != null) goto L19;
        String r14 = "";
    L20:
        JSONObject r19 = new JSONObject().put("host_expand_raw_data", this.c.f());
        r4.getClass();
        Intrinsics.checkNotNullParameter(r15, "bar_name");
        Intrinsics.checkNotNullParameter("topic", "bar_type");
        Intrinsics.checkNotNullParameter(r10, "topic_id");
        Intrinsics.checkNotNullParameter(r14, "topic_name");
        if (r8 != null) goto L23;
        return;
    L23:
        if (r8.W() == false) goto L25;
        String r12 = "origin";
    L26:
        String r13 = r12;
        d14.a r16 = b14.a.a;
        t24.a r17 = b14.a.a(t24.a.class);
        if (r5 != null) goto L29;
        String r18 = "";
    L30:
        User r20 = r8.f();
        if (r20 == null) goto L36;
        String r22 = r20.u();
        if (r22 == null) goto L36;
        String r23 = r22;
    L37:
        String r110 = r8.c();
        r14.a0 r24 = r8.d;
        if (r24 == null) goto L43;
        String r25 = r24.a();
        if (r25 == null) goto L43;
        String r111 = r25;
    L44:
        String r112 = AosEventReporter.c(r8);
        if (r7 != null) goto L47;
        r7 = "";
    L47:
        String r26 = r14;
        String r113 = r7;
        r17.L2(r18, r23, r110, r111, r112, r13, r113, r15, r10, r26, r8.u(), r19);
        return;
    L43:
        r111 = "";
    L36:
        r23 = "";
        goto L37
    L29:
        r18 = r5;
        goto L30
    L25:
        r12 = "sdk";
        goto L26
    L19:
        r14 = r11;
        goto L20
    L15:
        r15 = r9;
        goto L16
    L11:
        r7 = null;
        goto L12
    }
}
