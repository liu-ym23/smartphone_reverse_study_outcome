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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 extends b implements rz3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f195693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoPinchBar f195694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f195695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f195696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f195697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z f195698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y f195699n;

    public static final class a implements com.bytedance.awemeopen.infra.base.player.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f195700a;

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void c(String r100) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void d(String r100, long r101, int r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void e(String r100, int r101, String r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void f(String r100, boolean r101, int r102, int r103) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void g(String r100, boolean r101, String r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void onPlayPrepare(String r100) {
        }

        public a(a0 r100) {
            this.f195700a = r100;
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void h(String r100) {
            r14.c r101 = this.f195700a.f195706f;
            if (r101 == null) goto L5;
            String r102 = r101.c();
        L7:
            if (Intrinsics.areEqual(r100, r102) == false) goto L12;
            VideoPinchBar r103 = this.f195700a.f195694i;
            if (r103 == null) goto L13;
            r103.a(false);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r102 = null;
            goto L7
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void onPlaying(String r100) {
            r14.c r101 = this.f195700a.f195706f;
            if (r101 == null) goto L5;
            String r102 = r101.c();
        L7:
            if (Intrinsics.areEqual(r100, r102) == false) goto L12;
            VideoPinchBar r103 = this.f195700a.f195694i;
            if (r103 == null) goto L13;
            r103.a(true);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r102 = null;
            goto L7
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void l(String r100, com.bytedance.awemeopen.infra.base.player.l r101) {
            Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
        }
    }

    @Override // rz3.a
    public final void a() {
        View r100 = this.f195696k.findViewById(R.id.right_btn_layout);
        if (r100 == null) goto L5;
        r100.setBackgroundResource(R.drawable.familiar_pinch_view_btn_bg);
    L5:
        View r101 = this.f195696k.findViewById(R.id.close_btn);
        if (r101 == null) goto L9;
        r101.setBackgroundResource(R.drawable.familiar_pinch_view_btn_bg);
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
        if (this.f195699n == null) goto L5;
        return;
    L5:
        ?? r100 = new y(this);
        this.f195699n = r100;
        sz3.c r101 = this.f195702b;
        if (r101 == null) goto L11;
        qz3.a r102 = r101.f543932h;
        if (r102 == 0) goto L12;
        LifecycleOwner r103 = r101.f543926b;
        Intrinsics.checkNotNull(r100);
        r102.a(r103, r100);
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
        sz3.c r100 = this.f195702b;
        if (r100 == null) goto L16;
        LifecycleOwner r101 = r100.f543926b;
        if (r101 == null) goto L19;
        ?? r102 = new z(this);
        this.f195698m = r102;
        this.f195697l = new a(this);
        qz3.b r103 = r100.f543933i;
        if (r103 == 0) goto L10;
        Intrinsics.checkNotNull(r102);
        r103.C(r101, r102);
    L10:
        sz3.c r104 = this.f195702b;
        if (r104 == null) goto L17;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r105 = r104.f543927c;
        if (r105 == null) goto L18;
        a r106 = this.f195697l;
        Intrinsics.checkNotNull(r106);
        r105.addPlayStateListener(r106);
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
        boolean r100 = false;
        this.f195693h.setVisibility(0);
        VideoPinchBar r101 = (VideoPinchBar) this.f195696k.findViewById(R.id.video_pinch_bar);
        this.f195694i = r101;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        sz3.c r102 = this.f195702b;
        if (r102 == null) goto L13;
        r0 r103 = r102.f543928d;
        if (r103 == null) goto L13;
        VideoPinchBar r104 = this.f195694i;
        if (r104 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "handler");
        PinchPlayPauseView.j(r104.f195775e, r103);
        Intrinsics.checkNotNullParameter(r103, "handler");
        Intrinsics.checkNotNullParameter(r103, "handler");
    L13:
        sz3.c r105 = this.f195702b;
        if (r105 == null) goto L18;
        VideoPinchBar r106 = this.f195694i;
        if (r106 == null) goto L18;
        r106.b(r105);
    L18:
        FrameLayout r107 = (FrameLayout) this.f195696k.findViewById(R.id.close_btn_container);
        this.f195695j = r107;
        if (r107 == null) goto L21;
        r107.setOnClickListener(new x(this));
    L21:
        FrameLayout r108 = this.f195695j;
        if (r108 == null) goto L24;
        r108.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    L24:
        FrameLayout r109 = this.f195695j;
        if (r109 == null) goto L29;
        float r110 = 12;
        float r111 = 7;
        r109.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r110, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r110, g(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111, g(Resources.getSystem()))));
        Resources r112 = Resources.getSystem();
        int r113 = (int) (WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density * 11.0f);
        AppCompatImageView r114 = (AppCompatImageView) r109.findViewById(R.id.close_btn);
        if (r114 == null) goto L29;
        r114.setPadding(r113, r113, r113, r113);
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        r115.width = MathKt.roundToInt(TypedValue.applyDimension(1, 44, g(Resources.getSystem())));
        r115.height = -1;
        r114.setLayoutParams(r115);
    L29:
        FrameLayout r116 = (FrameLayout) this.f195696k.findViewById(R.id.right_btn_layout);
        if (r116 == null) goto L34;
        int r117 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, g(Resources.getSystem())));
        Intrinsics.checkNotNullParameter(r116, "<this>");
        ViewGroup.LayoutParams r118 = r116.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        ((ViewGroup.MarginLayoutParams) r118).setMarginEnd(r117);
        r116.setLayoutParams(r118);
    L34:
        VideoPinchBar r119 = this.f195694i;
        if (r119 == null) goto L47;
        LinearLayout r120 = (LinearLayout) r119.findViewById(R.id.pinch_bar_container);
        if (r120 == null) goto L39;
        r120.setPadding(0, 0, 0, 0);
    L39:
        PinchPlayPauseView r121 = (PinchPlayPauseView) r119.findViewById(R.id.play_view);
        if (r121 == null) goto L43;
        r121.setVisibility(0);
    L43:
        PinchSpeedView r122 = (PinchSpeedView) r119.findViewById(R.id.speed_btn);
        if (r122 == null) goto L47;
        r122.setVisibility(0);
    L47:
        VideoPinchBar r123 = this.f195694i;
        if (r123 == null) goto L51;
        r123.setOnSpeedChangeCallback(new PinchVideoButtonBarPresenterV2$initVideoPinchBarView$4(this));
    L51:
        sz3.c r124 = this.f195702b;
        if (r124 == null) goto L58;
        com.bytedance.awemeopen.infra.base.player.g r125 = r124.f543936l;
        if (r125 == null) goto L58;
        if (r125.isPlaying() != true) goto L58;
        r100 = true;
    L58:
        VideoPinchBar r126 = this.f195694i;
        if (r126 == null) goto L62;
        r126.a(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        this.f195693h.setVisibility(8);
        sz3.c r100 = this.f195702b;
        if (r100 == null) goto L9;
        VideoPinchBar r101 = this.f195694i;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r102 = r100.f543927c;
        if (r102 == null) goto L9;
        r102.removePlayStateListener(r101.f195787h);
    L9:
        z r103 = this.f195698m;
        if (r103 == null) goto L16;
        sz3.c r104 = this.f195702b;
        if (r104 == null) goto L16;
        qz3.b r105 = r104.f543933i;
        if (r105 == null) goto L16;
        r105.q(r103);
    L16:
        a r106 = this.f195697l;
        if (r106 == null) goto L23;
        sz3.c r107 = this.f195702b;
        if (r107 == null) goto L23;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r108 = r107.f543927c;
        if (r108 == null) goto L23;
        r108.removePlayStateListener(r106);
    L23:
        y r109 = this.f195699n;
        if (r109 == null) goto L31;
        sz3.c r110 = this.f195702b;
        if (r110 == null) goto L32;
        qz3.a r111 = r110.f543932h;
        if (r111 == null) goto L33;
        r111.b(r109);
        return;
    L33:
        return;
    L32:
        return;
    }

    public static DisplayMetrics g(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public a0(View r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "parentView");
        super(r100);
        this.f195693h = r101;
        this.f195696k = LayoutInflater.from(getContext()).inflate(R.layout.familiar_pinch_btn_opt_bar, r101);
    }
}
