package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar;

import a04.d;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.j;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect.CollectElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share.ShareElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import l14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RightBarGroup extends BaseGroup<b, LinearLayout, tz3.a, jz3.a> {
    public final Activity j;
    public final o k;
    public final c l;
    public final j m;
    public final d n;
    public final zz3.d o;
    public final ShareElement p;
    public final CollectElement q;
    public final b04.b r;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> c() {
        return CollectionsKt.arrayListOf(new BaseElement[]{this.m, this.n, this.o, this.r, this.p, this.q});
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void j() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d a() {
        return new b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void h() {
        b r0 = d();
        Function0<Integer> r1 = new RightBarGroup$onCreate$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
    }

    public final Activity getActivity() {
        return this.j;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ViewGroup b(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-2, -2);
        Resources r2 = Resources.getSystem();
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        Resources r4 = Resources.getSystem();
        r0.setMargins(0, 0, r1, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()))));
        r0.bottomToTop = 2131363067;
        r0.rightToRight = 0;
        LinearLayout r3 = new LinearLayout(r7);
        r3.setLayoutParams(r0);
        r3.setOrientation(1);
        r3.setGravity(1);
        r3.setClipChildren(false);
        return r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void g(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public RightBarGroup(Activity r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, o r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.j = r2;
        this.k = r4;
        this.l = r5;
        this.m = new j(r2, r3, r4, r5);
        this.n = new d(r2, r4);
        this.o = new zz3.d(r2, r4, r3);
        this.p = new ShareElement(r2, r4);
        this.q = new CollectElement(r2, r4, r3);
        this.r = new b04.b(r2, r4);
    }
}
