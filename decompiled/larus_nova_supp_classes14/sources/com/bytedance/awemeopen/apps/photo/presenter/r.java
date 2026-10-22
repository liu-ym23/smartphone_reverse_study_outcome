package com.bytedance.awemeopen.apps.photo.presenter;

import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements q24.a {
    public final /* synthetic */ q a;

    public final void b() {
    }

    public final void a() {
        zx3.a.b(this.a.d.getActivity(), 2131894241).d();
        this.a.j = false;
    }

    public final void onFail() {
        zx3.a.b(this.a.d.getActivity(), 2131894246).d();
        this.a.j = false;
    }

    public r(q r1) {
        this.a = r1;
    }

    public final void onSuccess(String r21) {
        Intrinsics.checkNotNullParameter(r21, "aid");
        Intrinsics.checkNotNullParameter(r21, "aid");
        if (Intrinsics.areEqual(r21, this.a.d.a.c()) == false) goto L29;
        this.a.n();
        q r1 = this.a;
        r1.j = false;
        com.bytedance.awemeopen.apps.photo.utils.a r2 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        a14.a r3 = r1.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "pictureDetailParameters");
        d14.a r4 = b14.a.a;
        t24.a r5 = b14.a.a(t24.a.class);
        String r6 = r3.c.sceneId();
        String r7 = r3.a.c();
        String r8 = r3.a.c();
        r14.a0 r9 = r3.a.d;
        if (r9 == null) goto L8;
        String r10 = r9.a();
        if (r10 == null) goto L8;
    L9:
        String r11 = GsonProtectorUtils.toJson(GsonHolder.a(), r3.a.d);
        AosEventReporter r12 = AosEventReporter.a;
        r14.c r13 = r3.a;
        r12.getClass();
        boolean r14 = AosEventReporter.e(r13);
        String r15 = r3.a.u();
        User r16 = r3.a.f();
        if (r16 == null) goto L15;
        String r17 = r16.u();
        if (r17 == null) goto L15;
        String r18 = r17;
    L16:
        AosPictureDetailConfig r19 = r3.c.getPageConfig();
        if (r19 == null) goto L22;
        String r110 = r19.getPreviousPage();
        if (r110 == null) goto L22;
        String r111 = r110;
    L24:
        if (r3.a.W() == false) goto L26;
        String r20 = "origin";
    L27:
        String r112 = r20;
        String r22 = r10;
        r5.e2(r6, r7, r8, r22, r11, r14, false, false, new com.bytedance.awemeopen.apps.framework.utils.e(r3.a), r15, r18, r111, r112, null, false, null);
        return;
    L26:
        r20 = "sdk";
    L22:
        r111 = "";
    L15:
        r18 = "";
    L8:
        r10 = "";
        goto L9
    }
}
