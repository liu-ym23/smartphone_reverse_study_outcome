package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.profile.UserProfileViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class UserProfileHeaderInfoPresenter extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final String e;
    public final ConstraintLayout f;
    public final DmtTextView g;
    public final DmtTextView h;
    public final DmtTextView i;
    public final DmtTextView j;
    public final ProfileSignatureView k;
    public final AoImageView l;
    public final View m;
    public final FrameLayout n;
    public final AoAnimationLottieView o;
    public boolean p;
    public r14.g0 q;
    public final w r;
    public final x s;
    public final y t;
    public final z u;
    public final a34.a v;
    public final Lazy w;
    public final a0 x;
    public final b0 y;

    @Override // f04.a
    public final void k() {
        UserProfileViewModel r0 = this.d.b;
        r0.getUserName().removeObserver(this.r);
        r0.getUserDesc().removeObserver(this.s);
        r0.getHeaderImage().removeObserver(this.t);
        r0.getServerUserInfo().removeObserver(this.y);
        r0.getUserVerifyInfo().removeObserver(this.u);
        ((c14.a) ((UserProfileHeaderInfoPresenter$liveStatusDetectScheduler$2.a) this.w.getValue())).b.removeMessages(1);
        this.v.s1(this.x);
    }

    public final long m() {
        User r0 = (User) this.d.b.getServerUserInfo().getValue();
        if (AoLive.b() == false) goto L19;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.M() == true) goto L22;
        String r1 = this.d.b.getProfileIds().b;
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L18;
        this.v.r0(r1);
    L18:
        return r0.z();
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L15
    L22:
        return 0;
    L19:
        return 0;
    }

    public final void n() {
        long r1 = m();
        if (r1 == 0) goto L35;
        AosEventReporter r6 = AosEventReporter.a;
        String r3 = this.d.b.getProfileIds().b;
        if (r3 != null) goto L7;
        String r12 = "";
    L8:
        String r13 = String.valueOf(r1);
        User r2 = (User) this.d.b.getServerUserInfo().getValue();
        if (r2 == null) goto L16;
        r14.a0 r4 = r2.b;
        if (r4 == null) goto L16;
        String r5 = r4.a();
        if (r5 == null) goto L16;
        String r14 = r5;
    L17:
        r14.g0 r7 = this.q;
        if (r7 == null) goto L23;
        String r8 = Long.valueOf(r7.appId).toString();
        if (r8 == null) goto L23;
        String r15 = r8;
    L24:
        r14.g0 r9 = this.q;
        if (r9 == null) goto L32;
        r14.g0.a r10 = r9.extra;
        if (r10 == null) goto L32;
        String r11 = Long.valueOf(r10.xgUid).toString();
        if (r11 == null) goto L32;
        String r16 = r11;
    L33:
        AosEventReporter.H(r6, "others_homepage", "others_photo", "others_homepage", "others_photo", PinchEnterMethod.CLICK, r12, r13, r14, r15, r16);
        return;
    L32:
        r16 = "";
    L23:
        r15 = "";
    L16:
        r14 = "";
        goto L17
    L7:
        r12 = r3;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v34, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.w] */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.x] */
    /* JADX WARN: Type inference failed for: r2v36, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.y] */
    /* JADX WARN: Type inference failed for: r2v37, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.z] */
    /* JADX WARN: Type inference failed for: r2v44, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.a0] */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.b0] */
    public UserProfileHeaderInfoPresenter(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = "HeaderInfoPresenter";
        this.f = i(2131392031);
        this.g = (DmtTextView) i(2131392055);
        this.h = (DmtTextView) i(2131392075);
        this.i = (DmtTextView) i(2131392074);
        this.j = (DmtTextView) i(2131364098);
        this.k = (ProfileSignatureView) i(2131392019);
        this.l = i(2131374294);
        this.m = i(2131374309);
        this.n = (FrameLayout) i(2131374304);
        this.o = i(2131374303);
        LinearLayout r3 = (LinearLayout) i(2131383220);
        this.r = new w(this);
        this.s = new x(this);
        this.t = new y(this);
        this.u = new z(this);
        d14.a r4 = b14.a.a;
        this.v = b14.a.a(a34.a.class);
        this.w = LazyKt.lazy(new UserProfileHeaderInfoPresenter$liveStatusDetectScheduler$2(this));
        this.x = new a0(this);
        this.y = new b0(this);
    }

    @Override // f04.a
    public final void j(Unit r8) {
        Intrinsics.checkNotNullParameter(r8, "unit");
        String r2 = com.bytedance.awemeopen.infra.util.f.b(this.d.a.getContext().getAssets().open("aos_anim_profile_live_head.json"));
        this.o.setRepeatCount(-1);
        this.o.setRepeatMode(1);
        this.o.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, r2, null, new UserProfileHeaderInfoPresenter$initLiveHead$1(this), 20));
        this.v.O2(this.x);
        this.n.setOnClickListener(new v(this));
        UserProfileViewModel r9 = this.d.b;
        r9.getUserName().observe(this.d.c, this.r);
        r9.getUserVerifyInfo().observe(this.d.c, this.u);
        r9.getUserDesc().observe(this.d.c, this.s);
        r9.getHeaderImage().observe(this.d.c, this.t);
        r9.getServerUserInfo().observe(this.d.c, this.y);
    }

    public final void o(boolean r3) {
        if (r3 == false) goto L5;
        this.m.setVisibility(4);
        this.n.setVisibility(0);
        this.o.start();
        return;
    L5:
        this.m.setVisibility(0);
        this.n.setVisibility(4);
        this.o.stop();
    }
}
