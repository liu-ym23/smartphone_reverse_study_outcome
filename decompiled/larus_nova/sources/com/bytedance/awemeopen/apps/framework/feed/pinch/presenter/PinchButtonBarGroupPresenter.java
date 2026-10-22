package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.content.ComponentCallbacks2;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class PinchButtonBarGroupPresenter extends com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f195675i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f195676j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f195677k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f195678l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SingleVideoSeekBarHelper f195679m;

    public static final class a implements SingleVideoSeekBarHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f195680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SingleVideoSeekBarHelper f195681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PinchButtonBarGroupPresenter f195682c;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper.b
        public final void a() {
            this.f195680a = this.f195681b.f();
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper.b
        public final void b() {
            float r100 = this.f195681b.f();
            PinchButtonBarGroupPresenter r101 = this.f195682c;
            if (r100 <= this.f195680a) goto L5;
            String r102 = NewBroadcastMonitor.CAPTURE.FRONT;
        L6:
            r101.getClass();
            LinkedHashMap r103 = new LinkedHashMap();
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r104 = r101.f195703c;
            String r105 = "";
            if (r104 == null) goto L12;
            sz3.c r106 = r104.f195843d;
            if (r106 == null) goto L12;
            String r107 = r106.f543929e;
            if (r107 == null) goto L12;
        L13:
            r103.put("enter_from", r107);
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r108 = r101.f195703c;
            if (r108 == null) goto L21;
            sz3.c r109 = r108.f195843d;
            if (r109 == null) goto L21;
            r14.c r110 = r109.f543930f;
            if (r110 == null) goto L21;
            String r111 = r110.c();
            if (r111 == null) goto L21;
        L22:
            r103.put("group_id", r111);
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r112 = r101.f195703c;
            if (r112 == null) goto L34;
            sz3.c r113 = r112.f195843d;
            if (r113 == null) goto L34;
            r14.c r114 = r113.f543930f;
            if (r114 == null) goto L34;
            User r115 = r114.f();
            if (r115 == null) goto L34;
            String r116 = r115.u();
            if (r116 == null) goto L34;
            r105 = r116;
        L34:
            r103.put("author_id", r105);
            r103.put("pinch_zoom", "1");
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r117 = r101.f195703c;
            if (r117 == null) goto L41;
            sz3.c r118 = r117.f195843d;
            if (r118 == null) goto L41;
            r14.c r119 = r118.f543930f;
            if (r119 == null) goto L41;
            int r120 = r119.i();
        L42:
            r103.put("aweme_type", Integer.valueOf(r120));
            r103.put("action_type", r102);
            AosEventReporter.s(AosEventReporter.f194596a, "click_progress_bar", r103, null, null, null, 28);
            return;
        L41:
            r120 = 0;
        L21:
            r111 = "";
        L12:
            r107 = "";
            goto L13
        L5:
            r102 = "back";
            goto L6
        }

        public a(SingleVideoSeekBarHelper r100, PinchButtonBarGroupPresenter r101) {
            this.f195681b = r100;
            this.f195682c = r101;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void c() {
    }

    public final void a() {
        ViewGroup.LayoutParams r100 = this.f195675i.getLayoutParams();
        rz3.a r101 = null;
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r102 == null) goto L9;
        r102.bottomMargin = 0;
    L9:
        this.f195675i.requestLayout();
        this.f195675i.setBackgroundColor(-16777216);
        Object r103 = this.f195676j;
        if ((r103 instanceof rz3.a) == false) goto L12;
        r101 = (rz3.a) r103;
    L12:
        if (r101 == null) goto L15;
        r101.a();
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.l] */
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
        if (r100 == null) goto L7;
        qz3.b r101 = r100.f543933i;
        if (r101 == null) goto L7;
        r101.C(r100.f543926b, new k(this));
    L7:
        sz3.c r102 = this.f195702b;
        if (r102 == null) goto L12;
        qz3.b r103 = r102.f543933i;
        if (r103 == 0) goto L12;
        r103.g(r102.f543926b, new l(this));
    L12:
        sz3.c r104 = this.f195702b;
        if (r104 == null) goto L28;
        LifecycleOwner r105 = r104.f543926b;
        if (r105 == null) goto L29;
        FeedSpeedControlViewModel.a r106 = FeedSpeedControlViewModel.Companion;
        ComponentCallbacks2 r107 = r104.getActivity();
        if ((r107 instanceof LifecycleOwner) == false) goto L19;
        LifecycleOwner r108 = (LifecycleOwner) r107;
    L20:
        if (r108 != null) goto L22;
        r108 = r105;
    L22:
        r106.getClass();
        FeedSpeedControlViewModel r109 = FeedSpeedControlViewModel.a.a(r108, "");
        if (r109 == null) goto L30;
        MutableLiveData<Pair<String, Boolean>> r110 = r109.getFastSpeedModeEvent();
        if (r110 == null) goto L31;
        final Function1<Pair<? extends String, ? extends Boolean>, Unit> r111 = new PinchButtonBarGroupPresenter$initObserverOnce$3$1(this);
        r110.observe(r105, new m(r111));
        return;
    L31:
        return;
    L30:
        return;
    L19:
        r108 = null;
        goto L20
    L29:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        this.f195675i.setOnTouchListener(new n());
        sz3.c r100 = this.f195702b;
        if (r100 == null) goto L9;
        qz3.b r101 = r100.f543933i;
        if (r101 == null) goto L9;
        if (r101.B() == true) goto L9;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        g(8);
    L13:
        this.f195675i.findViewById(R.id.slides_btn_bar).setVisibility(8);
        this.f195675i.findViewById(R.id.video_btn_bar).setVisibility(8);
        this.f195675i.findViewById(R.id.video_btn_bar_long_video).setVisibility(8);
        Iterator<b> r103 = this.f195692h.iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        r103.next().f();
        goto L15
    L17:
        this.f195692h.clear();
        int r104 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.f195706f) == false) goto L20;
        b r105 = (w) this.f195677k.getValue();
    L21:
        this.f195676j = r105;
        if (r105 == null) goto L24;
        this.f195692h.add(r105);
    L24:
        a();
        if (this.f195679m != null) goto L85;
        sz3.c r106 = this.f195702b;
        if (r106 == null) goto L33;
        r14.c r107 = r106.f543930f;
        if (r107 == null) goto L33;
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r107) != 1) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L86;
        sz3.c r109 = this.f195702b;
        ViewGroup r110 = null;
        if (r109 == null) goto L40;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r111 = r109.f543927c;
        if (r111 == null) goto L40;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r112 = r111.getISeekBar();
    L42:
        if ((r112 instanceof FeedSeekBarHelper) == false) goto L44;
        FeedSeekBarHelper r113 = (FeedSeekBarHelper) r112;
    L45:
        if (r113 == null) goto L48;
        FeedPlayerHelper r114 = r113.f196721b;
        if (r114 == null) goto L48;
    L61:
        if (r114 == null) goto L63;
        SingleVideoSeekBarHelper r115 = new SingleVideoSeekBarHelper(new WeakReference(this.f195675i.getContext()), r114, false, 12);
        a r116 = new a(r115, this);
        Intrinsics.checkNotNull(r116);
        Intrinsics.checkNotNullParameter(r116, "callback");
        r115.F = r116;
        this.f195679m = r115;
    L63:
        SingleVideoSeekBarHelper r117 = this.f195679m;
        if (r117 == null) goto L70;
        sz3.c r118 = this.f195702b;
        if (r118 == null) goto L68;
        r14.c r119 = r118.f543930f;
    L69:
        r117.i(r119);
        goto L70
    L68:
        r119 = null;
    L70:
        SingleVideoSeekBarHelper r120 = this.f195679m;
        if (r120 == null) goto L73;
        r120.e();
    L73:
        View r121 = this.f195701a;
        if ((r121 instanceof ViewGroup) == false) goto L76;
        r110 = (ViewGroup) r121;
    L76:
        if (r110 == null) goto L87;
        SingleVideoSeekBarHelper r122 = this.f195679m;
        if (r122 == null) goto L80;
        Resources r123 = Resources.getSystem();
        r122.h(r110, MathKt.roundToInt(TypedValue.applyDimension(1, 62, WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics()))));
    L80:
        SingleVideoSeekBarHelper r124 = this.f195679m;
        if (r124 == null) goto L88;
        float r125 = 4;
        r124.f196757h.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r125, SingleVideoSeekBarHelper.d(Resources.getSystem()))), r124.f196757h.getPaddingTop(), MathKt.roundToInt(TypedValue.applyDimension(1, r125, SingleVideoSeekBarHelper.d(Resources.getSystem()))), r124.f196757h.getPaddingBottom());
        return;
    L88:
        return;
    L87:
        return;
    L48:
        sz3.c r126 = this.f195702b;
        if (r126 == null) goto L53;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r127 = r126.f543927c;
        if (r127 == null) goto L53;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r128 = r127.getISeekBar();
    L55:
        if ((r128 instanceof SingleVideoSeekBarHelper) == false) goto L57;
        SingleVideoSeekBarHelper r129 = (SingleVideoSeekBarHelper) r128;
    L58:
        if (r129 == null) goto L60;
        r114 = r129.f196751b;
        goto L61
    L60:
        r114 = null;
        goto L61
    L57:
        r129 = null;
    L53:
        r128 = null;
        goto L55
    L44:
        r113 = null;
    L40:
        r112 = null;
        goto L42
    L86:
        return;
    L33:
        r108 = false;
        goto L34
    L85:
        return;
    L20:
        r105 = (b) this.f195678l.getValue();
    L9:
        r102 = false;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.a, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        super.f();
        g(8);
        this.f195692h.clear();
        SingleVideoSeekBarHelper r100 = this.f195679m;
        if (r100 == null) goto L7;
        r100.A = false;
        r100.removeSeekBarChangeListener(r100.G);
        r100.I.clear();
        r100.f196766q.removeCallbacksAndMessages(null);
        r100.m(MapMonitorConst.EVENT_DESTROY);
        r100.f196751b.g(r100.H);
        ViewGroup r101 = (ViewGroup) r100.f196754e.getParent();
        if (r101 == null) goto L7;
        r101.removeView(r100.f196754e);
    L7:
        this.f195679m = null;
    }

    public final void g(int r100) {
        this.f195675i.setVisibility(r100);
        if (r100 != 0) goto L7;
        SingleVideoSeekBarHelper r101 = this.f195679m;
        if (r101 == null) goto L11;
        r101.a();
        return;
    L11:
        return;
    L7:
        SingleVideoSeekBarHelper r102 = this.f195679m;
        if (r102 == null) goto L13;
        r102.b();
        return;
    }

    public PinchButtonBarGroupPresenter(final View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100);
        this.f195675i = r101;
        this.f195677k = LazyKt.lazy(new PinchButtonBarGroupPresenter$slidesBarPresenter$2(r100, this));
        this.f195678l = LazyKt.lazy(new PinchButtonBarGroupPresenter$videoBarPresenterV2$2(r100, this));
    }
}
