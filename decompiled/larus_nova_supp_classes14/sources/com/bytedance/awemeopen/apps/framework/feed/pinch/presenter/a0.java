package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.PinchPlayPauseView;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.PinchSpeedView;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.VideoPinchBar;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 extends b implements rz3.a {
    public final ViewGroup h;
    public VideoPinchBar i;
    public FrameLayout j;
    public final View k;
    public a l;
    public z m;
    public y n;

    public static final class a implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ a0 a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public a(a0 r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            r14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            String r1 = r0.c();
        L7:
            if (Intrinsics.areEqual(r2, r1) == false) goto L12;
            VideoPinchBar r3 = this.a.i;
            if (r3 == null) goto L13;
            r3.a(false);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public final void onPlaying(String r2) {
            r14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            String r1 = r0.c();
        L7:
            if (Intrinsics.areEqual(r2, r1) == false) goto L12;
            VideoPinchBar r3 = this.a.i;
            if (r3 == null) goto L13;
            r3.a(true);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }
    }

    @Override // rz3.a
    public final void a() {
        View r0 = this.k.findViewById(2131384556);
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131235341);
    L5:
        View r1 = this.k.findViewById(2131366984);
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131235341);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.y, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void c() {
        if (this.n == null) goto L5;
        return;
    L5:
        ?? r0 = new y(this);
        this.n = r0;
        sz3.c r1 = this.b;
        if (r1 == null) goto L11;
        qz3.a r2 = r1.h;
        if (r2 == 0) goto L12;
        LifecycleOwner r3 = r1.b;
        Intrinsics.checkNotNull(r0);
        r2.a(r3, r0);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.z, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void d() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L16;
        LifecycleOwner r1 = r0.b;
        if (r1 == null) goto L19;
        ?? r2 = new z(this);
        this.m = r2;
        this.l = new a(this);
        qz3.b r3 = r0.i;
        if (r3 == 0) goto L10;
        Intrinsics.checkNotNull(r2);
        r3.C(r1, r2);
    L10:
        sz3.c r4 = this.b;
        if (r4 == null) goto L17;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r5 = r4.c;
        if (r5 == null) goto L18;
        a r6 = this.l;
        Intrinsics.checkNotNull(r6);
        r5.addPlayStateListener(r6);
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        boolean r1 = false;
        this.h.setVisibility(0);
        VideoPinchBar r0 = (VideoPinchBar) this.k.findViewById(2131392341);
        this.i = r0;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        sz3.c r2 = this.b;
        if (r2 == null) goto L13;
        r0 r3 = r2.d;
        if (r3 == null) goto L13;
        VideoPinchBar r4 = this.i;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "handler");
        PinchPlayPauseView.j(r4.e, r3);
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r3, "handler");
    L13:
        sz3.c r5 = this.b;
        if (r5 == null) goto L18;
        VideoPinchBar r6 = this.i;
        if (r6 == null) goto L18;
        r6.b(r5);
    L18:
        FrameLayout r7 = (FrameLayout) this.k.findViewById(2131366985);
        this.j = r7;
        if (r7 == null) goto L21;
        r7.setOnClickListener(new x(this));
    L21:
        FrameLayout r8 = this.j;
        if (r8 == null) goto L24;
        r8.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    L24:
        FrameLayout r9 = this.j;
        if (r9 == null) goto L29;
        float r10 = 12;
        float r11 = 7;
        r9.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r10, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r11, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r10, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r11, g(Resources.getSystem()))));
        Resources r12 = Resources.getSystem();
        int r13 = (int) (WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density * 11.0f);
        AppCompatImageView r14 = r9.findViewById(2131366984);
        if (r14 == null) goto L29;
        r14.setPadding(r13, r13, r13, r13);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        r15.width = MathKt.roundToInt(TypedValue.applyDimension(1, 44, g(Resources.getSystem())));
        r15.height = -1;
        r14.setLayoutParams(r15);
    L29:
        FrameLayout r16 = (FrameLayout) this.k.findViewById(2131384556);
        if (r16 == null) goto L34;
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, g(Resources.getSystem())));
        Intrinsics.checkNotNullParameter(r16, "<this>");
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        ((ViewGroup.MarginLayoutParams) r18).setMarginEnd(r17);
        r16.setLayoutParams(r18);
    L34:
        VideoPinchBar r19 = this.i;
        if (r19 == null) goto L47;
        LinearLayout r20 = (LinearLayout) r19.findViewById(2131382319);
        if (r20 == null) goto L39;
        r20.setPadding(0, 0, 0, 0);
    L39:
        AppCompatImageView r21 = (PinchPlayPauseView) r19.findViewById(2131382455);
        if (r21 == null) goto L43;
        r21.setVisibility(0);
    L43:
        AppCompatImageView r22 = (PinchSpeedView) r19.findViewById(2131387091);
        if (r22 == null) goto L47;
        r22.setVisibility(0);
    L47:
        VideoPinchBar r23 = this.i;
        if (r23 == null) goto L51;
        r23.setOnSpeedChangeCallback(new PinchVideoButtonBarPresenterV2$initVideoPinchBarView$4(this));
    L51:
        sz3.c r24 = this.b;
        if (r24 == null) goto L58;
        com.bytedance.awemeopen.infra.base.player.g r25 = r24.l;
        if (r25 == null) goto L58;
        if (r25.isPlaying() != true) goto L58;
        r1 = true;
    L58:
        VideoPinchBar r26 = this.i;
        if (r26 == null) goto L62;
        r26.a(r1);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        this.h.setVisibility(8);
        sz3.c r0 = this.b;
        if (r0 == null) goto L9;
        VideoPinchBar r1 = this.i;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r0, "params");
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r2 = r0.c;
        if (r2 == null) goto L9;
        r2.removePlayStateListener(r1.h);
    L9:
        z r3 = this.m;
        if (r3 == null) goto L16;
        sz3.c r4 = this.b;
        if (r4 == null) goto L16;
        qz3.b r5 = r4.i;
        if (r5 == null) goto L16;
        r5.q(r3);
    L16:
        a r6 = this.l;
        if (r6 == null) goto L23;
        sz3.c r7 = this.b;
        if (r7 == null) goto L23;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r8 = r7.c;
        if (r8 == null) goto L23;
        r8.removePlayStateListener(r6);
    L23:
        y r9 = this.n;
        if (r9 == null) goto L31;
        sz3.c r10 = this.b;
        if (r10 == null) goto L32;
        qz3.a r11 = r10.h;
        if (r11 == null) goto L33;
        r11.b(r9);
        return;
    L33:
        return;
    L32:
        return;
    }

    public static DisplayMetrics g(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public a0(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        super(r2);
        this.h = r3;
        this.k = LayoutInflater.from(getContext()).inflate(2131561092, r3);
    }
}
