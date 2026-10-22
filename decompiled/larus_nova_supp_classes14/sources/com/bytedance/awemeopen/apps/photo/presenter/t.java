package com.bytedance.awemeopen.apps.photo.presenter;

import android.widget.FrameLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.collect.serviceapi.AoViewInjectService;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends f04.a<Unit> {
    public final a14.a d;
    public final FrameLayout e;

    @Override // f04.a
    public final void k() {
    }

    public t(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = (FrameLayout) i(2131372214);
    }

    @Override // f04.a
    public final void j(Unit r7) {
        Intrinsics.checkNotNullParameter(r7, "unit");
        r14.c r8 = this.d.a;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.j == false) goto L38;
        d14.a r0 = b14.a.a;
        User r1 = b14.a.a(k34.b.class).b();
        if (r1 == null) goto L7;
        String r2 = r1.u();
    L9:
        if (com.bytedance.awemeopen.bizmodels.user.d.c(r8, r2) == true) goto L40;
        AoViewInjectService r3 = j64.a.a(AoViewInjectService.class);
        if (r3 == null) goto L41;
        AosPictureDetailConfig r4 = this.d.c.getPageConfig();
        String r5 = "";
        if (r4 == null) goto L18;
        String r6 = r4.getHostEnterFrom();
        if (r6 == null) goto L18;
    L19:
        String r9 = this.d.c.sceneId();
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("enter_from", r9);
        r10.put("host_enter_from", r6);
        String r11 = r8.l;
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        r10.put("request_id", r11);
        r14.a0 r12 = r8.d;
        if (r12 == null) goto L28;
        String r13 = r12.a();
        if (r13 == null) goto L28;
        r5 = r13;
    L28:
        r10.put("impr_id", r5);
        this.d.c.sceneId();
        List r14 = r8.v();
        if (r14 == null) goto L31;
        r14.size();
    L31:
        Integer r15 = r3.e2();
        if (r15 != null) goto L34;
        return;
    L34:
        if (r15.intValue() < 0) goto L42;
        new FeedbackCardPresenter$onBind$1(this);
        r3.n0();
        return;
    L42:
        return;
    L18:
        r6 = "";
        goto L19
    L41:
        return;
    L40:
        return;
    L7:
        r2 = null;
        goto L9
    }
}
