package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends f04.a<Unit> {
    public static final /* synthetic */ int n = 0;
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final LinearLayout e;
    public final ImageView f;
    public final DmtTextView g;
    public final DmtTextView h;
    public final y24.d i;
    public q04.a j;
    public j k;
    public final l l;
    public final b m;

    public static final class a {
    }

    public static final class b implements y24.c {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        public final void a(String r2, int r3) {
            t r4 = this.a;
            q04.a r0 = r4.j;
            if (r0 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r0.a, r2) == false) goto L14;
            r4.r(true);
            if (r4.k != null) goto L9;
            r4.k = (j) r4.g(j.class);
        L9:
            j r5 = r4.k;
            if (r5 == null) goto L15;
            r5.m();
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // f04.a
    public final void k() {
        this.i.r2(this.m);
        this.d.b.getFollowModel().removeObserver(this.l);
    }

    public final void n() {
        ProfilePageConfig r0 = this.d.b.getPageConfig();
        AosEventReporter r1 = AosEventReporter.a;
        HostEventParameters r2 = r0.getHostEventParameters();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getEnterFromMerge();
    L6:
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        HostEventParameters r6 = r0.getHostEventParameters();
        if (r6 == null) goto L12;
        String r7 = r6.getEnterMethod();
    L13:
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        User r8 = (User) this.d.b.getServerUserInfo().getValue();
        if (r8 == null) goto L18;
        r3 = r8.u();
    L18:
        if (r3 == null) goto L21;
        r5 = r3;
    L21:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        d14.a r9 = b14.a.a;
        b14.a.a(t24.a.class).N0(r4, r7, r5);
        return;
    L12:
        r7 = null;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.l] */
    public t(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = (LinearLayout) i(2131383199);
        this.f = (ImageView) i(2131383198);
        this.g = (DmtTextView) i(2131383200);
        this.h = (DmtTextView) i(2131383201);
        d14.a r3 = b14.a.a;
        this.i = b14.a.a(y24.d.class);
        this.l = new l(this);
        this.m = new b(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        m(true);
        this.d.b.getFollowModel().observe(this.d.c, this.l);
        this.e.setOnClickListener(new u(this));
        this.h.setOnClickListener(new k(this));
        this.i.R2(this.m);
    }

    public final void m(boolean r2) {
        this.e.setClickable(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r(final boolean r5) {
        if (AosExtConfig.b.A().a == true) goto L5;
        x54.b.d(this.e);
        x54.b.d(this.f);
        this.g.setTextColor(getContext().getResources().getColor(2131100271));
        this.g.setText(getContext().getText(2131894208));
        this.e.setBackgroundResource(2131231585);
        return;
    L5:
        final q04.a r0 = this.j;
        if (r0 != null) goto L9;
        this.a.post(new m(this));
        return;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        if (p0.e(r0.a) == false) goto L14;
        x54.b.a(this.e);
        return;
    L14:
        if (this.i.q2(r0.a, r0.b) == false) goto L18;
        if (r5 == false) goto L17;
        q(r0, r5);
        return;
    L17:
        this.a.post(new n(this, r0, r5));
        return;
    L18:
        if (r5 == false) goto L20;
        p(r0, r5);
        return;
    L20:
        this.a.post(new o(this, r0, r5));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s(boolean r6) {
        if (r6 == false) goto L8;
        n();
        int r7 = this.a.getWidth();
        Resources r2 = Resources.getSystem();
        int r8 = (r7 - MathKt.roundToInt(TypedValue.applyDimension(1, 38, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())))) / 2;
        o(this.e, r8);
        o(this.h, r8);
        this.h.setText(getContext().getText(2131894211).toString());
        if (com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext()) == false) goto L7;
        this.h.setTextColor(getContext().getResources().getColor(2131100272));
        this.h.setBackgroundResource(2131231582);
        return;
    L7:
        this.h.setTextColor(getContext().getResources().getColor(2131100357));
        this.h.setBackgroundResource(2131231583);
        return;
    L8:
        LinearLayout r9 = this.e;
        int r1 = this.a.getWidth();
        Resources r3 = Resources.getSystem();
        o(r9, r1 - MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
        this.h.setText("");
        o(this.h, 0);
    }

    public static void o(View r2, int r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r1).width = r3;
        r2.setLayoutParams(r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void p(q04.a r6, boolean r7) {
        boolean r0 = r6.d;
        if (r0 == false) goto L8;
        if (r7 == false) goto L8;
        if (r6.e == true) goto L8;
        boolean r3 = true;
    L9:
        if (r0 == false) goto L14;
        if (r7 == true) goto L14;
        if (r6.e == false) goto L14;
        s(true);
    L14:
        x54.b.d(this.e);
        x54.b.d(this.f);
        this.g.setTextColor(getContext().getResources().getColor(2131100271));
        this.g.setText(getContext().getText(2131894203));
        this.e.setBackgroundResource(2131231585);
        if (r3 == false) goto L17;
        int r8 = this.a.getWidth();
        Resources r1 = Resources.getSystem();
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{this.e.getWidth(), r8 - MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())))});
        r9.setDuration(300);
        r9.addUpdateListener(new p(this));
        r9.start();
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{this.h.getWidth(), 0});
        r10.setDuration(300);
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        r10.addUpdateListener(new q(this, r11));
        r10.start();
    L17:
        AosEventReporter r12 = AosEventReporter.a;
        jz3.a r13 = this.d.b.getCachedFeedItemEntity();
        if (r13 == null) goto L20;
        r14.c r14 = r13.a;
    L21:
        AosEventReporter.FollowType r2 = AosEventReporter.FollowType.from_profile;
        r12.getClass();
        AosEventReporter.B("others_homepage", "", r14, r2, "");
        return;
    L20:
        r14 = null;
    L8:
        r3 = false;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void q(q04.a r7, boolean r8) {
        boolean r0 = r7.d;
        if (r0 == false) goto L8;
        if (r8 == false) goto L8;
        if (r7.e == true) goto L8;
        boolean r9 = true;
    L9:
        if (r0 == false) goto L12;
        if (r8 == true) goto L12;
        s(true);
    L12:
        x54.b.d(this.e);
        x54.b.a(this.f);
        boolean r10 = com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext());
        this.g.setText(2131894148);
        if (r10 == false) goto L15;
        this.g.setTextColor(getContext().getResources().getColor(2131100272));
        this.e.setBackgroundResource(2131231582);
        this.h.setTextColor(getContext().getResources().getColor(2131100272));
        this.h.setBackgroundResource(2131231582);
    L16:
        if (r9 == false) goto L19;
        int r11 = this.a.getWidth();
        Resources r1 = Resources.getSystem();
        int r12 = (r11 - MathKt.roundToInt(TypedValue.applyDimension(1, 38, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())))) / 2;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{this.e.getWidth(), r12});
        r2.setDuration(300);
        r2.addUpdateListener(new r(this));
        r2.start();
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{this.h.getWidth(), r12});
        r13.setDuration(300);
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r13.addUpdateListener(new s(this, r14));
        r13.start();
        n();
        return;
    L19:
        return;
    L15:
        this.g.setTextColor(getContext().getResources().getColor(2131100357));
        this.e.setBackgroundResource(2131231583);
        this.h.setTextColor(getContext().getResources().getColor(2131100357));
        this.h.setBackgroundResource(2131231583);
    L8:
        r9 = false;
        goto L9
    }
}
