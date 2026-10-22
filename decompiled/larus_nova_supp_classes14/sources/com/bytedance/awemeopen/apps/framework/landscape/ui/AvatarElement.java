package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.AvatarModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AvatarElement {
    public final r14.c a;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a b;
    public final AoImageView c;
    public final TextView d;
    public final AoAnimationLottieView e;
    public final o f;
    public final Context g;
    public boolean h;
    public final y24.d i;

    public final void b() {
        this.h = false;
        d14.a r0 = b14.a.a;
        b14.a.a(l24.c.class).a(this.a);
        TextView r1 = this.d;
        User r2 = this.a.f();
        List r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.t();
    L6:
        r1.setText(r4);
        AoImageView r5 = this.c;
        User r6 = this.a.f();
        if (r6 == null) goto L11;
        t14.a r7 = r6.a();
        if (r7 == null) goto L11;
        r3 = r7.g();
    L11:
        com.bytedance.awemeopen.infra.base.image.b r8 = new com.bytedance.awemeopen.infra.base.image.b(r3);
        r8.b(2131231483);
        r8.r = true;
        r8.m = ImageView.ScaleType.CENTER_CROP;
        Resources r9 = Resources.getSystem();
        r8.t = MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        r8.u = -1;
        r5.j(r8);
        this.e.setOnClickListener(new a(this));
        if (x54.b.c(this.e) == false) goto L22;
        AosEventReporter r10 = AosEventReporter.a;
        String r11 = this.f.sceneId();
        String r12 = "";
        if (Intrinsics.areEqual(this.f.getPageConfig().getEnterAid(), this.a.c()) == false) goto L16;
        String r13 = this.f.getPageConfig().getEnterHostGid();
    L17:
        r14.c r14 = this.a;
        AosEventReporter.FollowType r15 = AosEventReporter.FollowType.from_group;
        String r16 = this.f.getPageConfig().getPreviousPage();
        if (r16 == null) goto L21;
        r12 = r16;
    L21:
        r10.getClass();
        AosEventReporter.B(r11, r13, r14, r15, r12);
        goto L22
    L16:
        r13 = "";
    L22:
        final Function1<View, Unit> r17 = new AvatarElement$bind$clickUserListener$1(this);
        this.c.setOnClickListener(new b(r17));
        this.d.setOnClickListener(new c(r17));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c() {
        if (AosExtConfig.b.A().a == true) goto L6;
        AvatarModel.FollowStatus r0 = AvatarModel.FollowStatus.UNSHOWFOLLOW;
    L13:
        if (r0 != AvatarModel.FollowStatus.UNFOLLOWED) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        x54.b.d(this.e);
        this.e.setImageResource(2131231411);
        return;
    L18:
        x54.b.a(this.e);
        return;
    L15:
        r1 = false;
        goto L16
    L6:
        if (p0.e(this.a.r().b) == false) goto L9;
        r0 = AvatarModel.FollowStatus.MYSELF;
        goto L13
    L9:
        if (this.i.E1(this.a) == true) goto L11;
        r0 = AvatarModel.FollowStatus.UNFOLLOWED;
        goto L13
    L11:
        r0 = AvatarModel.FollowStatus.FOLLOWED;
        goto L13
    }

    public static final String a(AvatarElement r0) {
        User r1 = r0.a.f();
        if (r1 == null) goto L6;
        String r2 = r1.u();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    public AvatarElement(r14.c r7, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r8, AoImageView r9, TextView r10, AoAnimationLottieView r11) {
        Intrinsics.checkNotNullParameter(r7, "aweme");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "avatar");
        Intrinsics.checkNotNullParameter(r10, "tvNickName");
        Intrinsics.checkNotNullParameter(r11, "lottieFollow");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r8.c;
        Context r12 = r9.getContext();
        this.g = r12;
        d14.a r13 = b14.a.a;
        this.i = b14.a.a(y24.d.class);
        String r2 = com.bytedance.awemeopen.infra.util.f.b(r12.getAssets().open("aos_anim_follow_add_v2.json"));
        r11.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, r2, new d(this), AvatarElement$initFollowLottieView$config$2.INSTANCE, 4));
        c();
    }
}
