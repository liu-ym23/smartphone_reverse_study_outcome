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
public final class g implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ CameraStrongPresenter b;
    public final /* synthetic */ r14.w c;

    public g(View r1, CameraStrongPresenter r2, r14.w r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r24) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.a) == false) goto L5;
        return;
    L5:
        AosExtConfig r1 = AosExtConfig.b;
        Activity r2 = this.b.d.getActivity();
        String r3 = this.c.d();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r1.P1(r2, r3, new JSONObject().put("anchor_position", "pic_bottom_out").put("enter_from", this.b.d.c.sceneId()));
        AosEventReporter r4 = AosEventReporter.a;
        String r5 = this.b.d.c.sceneId();
        AosPictureDetailConfig r6 = this.b.d.c.getPageConfig();
        if (r6 == null) goto L11;
        String r7 = r6.getPreviousPage();
    L12:
        r14.c r8 = this.b.d.a;
        String r9 = String.valueOf(this.c.getType());
        String r15 = String.valueOf(this.c.b());
        r14.w r10 = this.c;
        String r11 = r10.a;
        if (r11 != null) goto L15;
        r11 = "go_to";
    L15:
        String r14 = r11;
        int r18 = r10.g();
        JSONObject r22 = new JSONObject().put("host_expand_raw_data", this.c.f());
        r4.getClass();
        Intrinsics.checkNotNullParameter(r9, "component_type");
        Intrinsics.checkNotNullParameter(r15, "content_id");
        Intrinsics.checkNotNullParameter(r14, "click_area");
        if (r8 == null) goto L44;
        d14.a r12 = b14.a.a;
        t24.a r13 = b14.a.a(t24.a.class);
        if (r5 != null) goto L20;
        String r16 = "";
    L21:
        User r17 = r8.f();
        if (r17 == null) goto L27;
        String r19 = r17.u();
        if (r19 == null) goto L27;
        String r20 = r19;
    L28:
        String r110 = r8.c();
        r14.a0 r21 = r8.d;
        if (r21 == null) goto L34;
        String r23 = r21.a();
        if (r23 == null) goto L34;
        String r111 = r23;
    L35:
        String r112 = AosEventReporter.c(r8);
        if (r8.W() == false) goto L38;
        String r25 = "origin";
    L39:
        String r113 = r25;
        if (r7 != null) goto L42;
        r7 = "";
    L42:
        String r114 = r7;
        r13.y2(r16, r20, r110, r111, r112, r113, r114, "", r9, r15, r18, -1, r14, r8.u(), r22);
        return;
    L38:
        r25 = "sdk";
    L34:
        r111 = "";
    L27:
        r20 = "";
        goto L28
    L20:
        r16 = r5;
        goto L21
    L44:
        return;
    L11:
        r7 = null;
        goto L12
    }
}
