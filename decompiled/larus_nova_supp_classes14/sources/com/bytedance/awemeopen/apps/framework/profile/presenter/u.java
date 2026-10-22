package com.bytedance.awemeopen.apps.framework.profile.presenter;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.UserLoginUtil;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u extends com.bytedance.awemeopen.apps.framework.utils.o {
    public final /* synthetic */ t d;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        final t r1 = this.d;
        r1.getClass();
        if (AosExtConfig.b.A().a == true) goto L5;
        String r2 = com.bytedance.awemeopen.apps.framework.utils.m0.b;
        com.bytedance.awemeopen.apps.framework.utils.m0.a(r1.getContext(), 2131894208);
        return;
    L5:
        q04.a r3 = r1.j;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r1.i.q2(r3.a, r3.b) == false) goto L29;
        final q04.a r4 = r1.j;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r1.i.q2(r4.a, r4.b) == false) goto L55;
        AosEventReporter r7 = AosEventReporter.a;
        jz3.a r12 = r1.d.b.getCachedFeedItemEntity();
        if (r12 == null) goto L17;
        r14.c r13 = r12.a;
    L18:
        AosEventReporter.FollowType r14 = AosEventReporter.FollowType.from_group;
        boolean r15 = r1.d.b.getPageConfig().isCardMode();
        jz3.a r5 = r1.d.b.getCachedFeedItemEntity();
        if (r5 == null) goto L27;
        r14.c r6 = r5.a;
        if (r6 == null) goto L27;
        User r8 = r6.f();
        if (r8 == null) goto L27;
        if (r8.R() != true) goto L27;
        boolean r16 = true;
    L28:
        JSONObject r17 = r1.d.b.getPageConfig().getHostExtraParams();
        r7.getClass();
        AosEventReporter.o("click_follow_cancel", "others_homepage", "", "", r13, r14, "", r15, r16, r17);
        Lazy r9 = UserLoginUtil.a;
        FragmentActivity r10 = r1.d.getActivity();
        Intrinsics.checkNotNull(r10);
        int r11 = com.bytedance.awemeopen.bizmodels.user.a.a;
        UserLoginUtil.a(r10, "profile_follow", null, new UserProfileFollowPresenter$doUnFollow$1$1(r1, r4));
        return;
    L27:
        r16 = false;
        goto L28
    L17:
        r13 = null;
        goto L18
    L55:
        return;
    L29:
        final q04.a r18 = r1.j;
        if (r18 != null) goto L32;
        return;
    L32:
        if (r1.i.q2(r18.a, r18.b) == true) goto L56;
        AosEventReporter r19 = AosEventReporter.a;
        jz3.a r20 = r1.d.b.getCachedFeedItemEntity();
        if (r20 == null) goto L37;
        r14.c r21 = r20.a;
    L38:
        AosEventReporter.FollowType r22 = AosEventReporter.FollowType.from_group;
        boolean r24 = r1.d.b.getPageConfig().isCardMode();
        jz3.a r23 = r1.d.b.getCachedFeedItemEntity();
        if (r23 == null) goto L47;
        r14.c r25 = r23.a;
        if (r25 == null) goto L47;
        User r26 = r25.f();
        if (r26 == null) goto L47;
        if (r26.R() != true) goto L47;
        boolean r27 = true;
    L48:
        JSONObject r28 = r1.d.b.getPageConfig().getHostExtraParams();
        r19.getClass();
        AosEventReporter.o("click_follow", "others_homepage", "", "", r21, r22, "", r24, r27, r28);
        Lazy r29 = UserLoginUtil.a;
        FragmentActivity r30 = r1.d.getActivity();
        Intrinsics.checkNotNull(r30);
        int r31 = com.bytedance.awemeopen.bizmodels.user.a.a;
        UserLoginUtil.a(r30, "profile_follow", null, new UserProfileFollowPresenter$doFollow$1$1(r1, r18));
        return;
    L47:
        r27 = false;
        goto L48
    L37:
        r21 = null;
        goto L38
    }

    public u(t r1) {
        this.d = r1;
    }
}
