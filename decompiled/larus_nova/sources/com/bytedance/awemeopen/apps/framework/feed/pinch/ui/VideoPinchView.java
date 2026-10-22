package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SupportSeekBarFrameLayout;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.e0;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/VideoPinchView;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SupportSeekBarFrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/utils/r0$a;", "", "enterMethod", "", "setEnterMethod", "Landroid/view/View;", "getMOriginView", "()Landroid/view/View;", "mOriginView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoPinchView extends SupportSeekBarFrameLayout implements r0.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f195789s = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f195790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f195791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f195792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f195793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f195794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qz3.b f195795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qz3.a f195796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f195797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r0 f195798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f195799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public sz3.c f195800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f195801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f195802o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e0 f195803p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f195804q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f195805r;

    public static final class a {
    }

    static {
    }

    public VideoPinchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoPinchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void c() {
        this.f195797j = true;
        qz3.b r100 = this.f195795h;
        if (r100 == null) goto L5;
        r100.o(true);
    L5:
        View r101 = this.f195793f;
        if (r101 == null) goto L8;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(r101, 0);
    L8:
        requestFocus();
        m r102 = this.f195801n;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r102 = null;
    L11:
        r102.f195851l = true;
    }

    private final View getMOriginView() {
        sz3.c r100 = this.f195800m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r100 = null;
    L5:
        Function0<? extends View> r101 = r100.f543934j;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.invoke();
    }

    public final void d() {
        if (this.f195797j == true) goto L5;
        return;
    L5:
        qz3.a r100 = this.f195796i;
        if (r100 == null) goto L8;
        r100.e();
    L8:
        qz3.b r101 = this.f195795h;
        if (r101 == null) goto L15;
        sz3.c r102 = this.f195800m;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r102 = null;
    L13:
        r101.l(r102.f543930f);
        return;
    }

    public final boolean e() {
        if (getParent() != null) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public static void g(VideoPinchView r100) {
        if (r100.e() == false) goto L10;
        h(r100);
        qz3.b r101 = r100.f195795h;
        if (r101 == null) goto L9;
        r101.v(false);
        return;
    L9:
        return;
    }

    public static void h(final VideoPinchView r100) {
        if (r100.e() == false) goto L32;
        ViewParent r101 = r100.getParent();
        sz3.c r102 = null;
        if ((r101 instanceof ViewGroup) == false) goto L8;
        final ViewGroup r103 = (ViewGroup) r101;
    L9:
        if (r103 == null) goto L11;
        r103.post(new d(r103, r100));
    L11:
        r100.f195803p.f();
        ((ImageCanvasView) r100.f195802o.findViewById(R.id.image_view)).setTranslationY(0.0f);
        ViewGroup r104 = r100.f195790c;
        if (r104 == null) goto L14;
        r104.setBackgroundColor(0);
    L14:
        m r105 = r100.f195801n;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r105 = null;
    L17:
        r105.f195851l = false;
        r100.f195797j = false;
        qz3.b r106 = r100.f195795h;
        if (r106 == null) goto L20;
        r106.o(false);
    L20:
        sz3.c r107 = r100.f195800m;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
    L24:
        Function0<Unit> r108 = r102.f543941q;
        if (r108 == null) goto L27;
        r108.invoke();
    L27:
        qz3.b r109 = r100.f195795h;
        if (r109 == null) goto L31;
        r109.f();
        return;
    L31:
        return;
    L23:
        r102 = r107;
        goto L24
    L8:
        r103 = null;
        goto L9
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "exitMethod");
        LinkedHashMap r101 = new LinkedHashMap();
        m r102 = this.f195801n;
        m r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r102 = null;
    L5:
        sz3.c r104 = r102.f195843d;
        String r105 = "";
        if (r104 == null) goto L10;
        r14.c r106 = r104.f543930f;
        if (r106 == null) goto L10;
        Comparable r107 = Integer.valueOf(r106.i());
    L11:
        r101.put("aweme_type", r107);
        m r108 = this.f195801n;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r108 = null;
    L14:
        sz3.c r109 = r108.f195843d;
        if (r109 == null) goto L18;
        String r110 = r109.f543929e;
        if (r110 == null) goto L18;
    L19:
        r101.put("enter_from", r110);
        m r111 = this.f195801n;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r111 = null;
    L22:
        sz3.c r112 = r111.f195843d;
        if (r112 == null) goto L28;
        r14.c r113 = r112.f543930f;
        if (r113 == null) goto L28;
        String r114 = r113.c();
        if (r114 == null) goto L28;
    L29:
        r101.put("group_id", r114);
        m r115 = this.f195801n;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r115 = null;
    L32:
        sz3.c r116 = r115.f195843d;
        if (r116 == null) goto L42;
        r14.c r117 = r116.f543930f;
        if (r117 == null) goto L42;
        User r118 = r117.f();
        if (r118 == null) goto L42;
        String r119 = r118.u();
        if (r119 == null) goto L42;
        r105 = r119;
    L42:
        r101.put("author_id", r105);
        r101.put("enter_method", this.f195804q);
        r101.put("exit_method", r100);
        m r120 = this.f195801n;
        if (r120 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
    L46:
        sz3.c r121 = r103.f195843d;
        if (r121 == null) goto L51;
        r14.c r122 = r121.f543930f;
        if (r122 == null) goto L51;
        int r123 = r122.q();
    L52:
        r101.put("item_duration", Integer.valueOf(r123));
        r101.put("duration", Long.valueOf(System.currentTimeMillis() - this.f195805r));
        AosEventReporter.s(AosEventReporter.f194596a, "quit_clear_screen_mode", r101, null, null, null, 28);
        return;
    L51:
        r123 = 0;
        goto L52
    L45:
        r103 = r120;
    L28:
        r114 = "";
    L18:
        r110 = "";
    L10:
        r107 = "";
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
    L15:
        if (r101 != null) goto L18;
        return;
    L18:
        if (r101.intValue() != 3) goto L23;
        e();
        return;
    L23:
        return;
    L13:
        if (r101.intValue() != 1) goto L15;
        d();
        return;
    L8:
        if (r101.intValue() != 0) goto L10;
        d();
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        this.f195804q = r100;
        this.f195805r = System.currentTimeMillis();
    }

    public static void a(VideoPinchView r100, Triple r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r100.isAttachedToWindow() == false) goto L98;
        Object r102 = r101.getFirst();
        View r103 = r100.getMOriginView();
        Integer r104 = null;
        if (r103 == null) goto L7;
        Integer r105 = Integer.valueOf(r103.hashCode());
    L9:
        if (Intrinsics.areEqual(r102, r105) == true) goto L11;
        return;
    L11:
        if (r101.getFirst() == null) goto L13;
    L15:
        boolean r106 = ((Boolean) r101.getSecond()).booleanValue();
        r100.f195799l = r106;
        if (r106 == true) goto L24;
        sz3.c r107 = r100.f195800m;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r107 = null;
    L21:
        if ((!Intrinsics.areEqual(r107.f543938n, Boolean.FALSE)) == true) goto L24;
        g(r100);
    L56:
        sz3.c r108 = r100.f195800m;
        if (r108 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r108 = null;
    L60:
        if (TextUtils.equals(r108.f543929e, "graphic_detail") == true) goto L62;
        return;
    L62:
        if (r100.f195799l == false) goto L75;
        m r109 = r100.f195801n;
        if (r109 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r109 = null;
    L67:
        if (r109.f195852m == true) goto L75;
        qz3.b r110 = r100.f195795h;
        if (r110 == null) goto L101;
        View r111 = r100.getMOriginView();
        if (r111 == null) goto L73;
        r104 = Integer.valueOf(r111.hashCode());
    L73:
        r110.d(r104, true);
        return;
    L101:
        return;
    L75:
        if (r100.f195799l == true) goto L103;
        m r112 = r100.f195801n;
        if (r112 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r112 = null;
    L80:
        if (r112.f195849j.f195753o >= 1.0f) goto L104;
        m r113 = r100.f195801n;
        if (r113 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r113 = null;
    L85:
        if (r113.f195852m == false) goto L105;
        m r114 = r100.f195801n;
        if (r114 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r114 = null;
    L90:
        if (r114.f195853n == false) goto L106;
        qz3.b r115 = r100.f195795h;
        if (r115 == null) goto L107;
        View r116 = r100.getMOriginView();
        if (r116 == null) goto L96;
        r104 = Integer.valueOf(r116.hashCode());
    L96:
        r115.d(r104, false);
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L24:
        if (r100.f195799l == true) goto L44;
        m r117 = r100.f195801n;
        if (r117 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r117 = null;
    L29:
        if (r117.f195851l == false) goto L44;
        m r118 = r100.f195801n;
        if (r118 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r118 = null;
    L34:
        if (r118.f195849j.f195755q != 1.0f) goto L36;
        boolean r119 = true;
    L37:
        if (r119 == false) goto L44;
        m r120 = r100.f195801n;
        if (r120 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r120 = null;
    L42:
        if (r120.f195849j.f195753o >= 1.0f) goto L44;
        r100.f("zoom_in");
        g(r100);
        goto L56
    L36:
        r119 = false;
    L44:
        boolean r121 = r100.f195799l;
        if (r121 == true) goto L47;
        r100.c();
        goto L56
    L47:
        if (r121 == false) goto L56;
        m r122 = r100.f195801n;
        if (r122 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r122 = null;
    L52:
        if (r122.f195851l == false) goto L56;
        r100.f195797j = false;
        qz3.b r123 = r100.f195795h;
        if (r123 == null) goto L56;
        r123.o(false);
        goto L56
    L13:
        if (r100.getMOriginView() != null) goto L15;
        return;
    L7:
        r105 = null;
        goto L9
    }

    public final void b(sz3.c r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "videoPinchParams");
        Intrinsics.checkNotNullParameter(r101, "pinchUtil");
        this.f195800m = r100;
        r100.f543928d = this.f195798k;
        this.f195801n = r101;
        this.f195803p.b(r100, r101);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L18;
        qz3.b r102 = this.f195795h;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L15;
        qz3.b r104 = this.f195795h;
        if (r104 == null) goto L16;
        r104.e(TuplesKt.to(Boolean.FALSE, "back"));
    L16:
        return true;
    L15:
        f("back");
        g(this);
        goto L16
    L7:
        if (r102.A() != true) goto L9;
        r103 = true;
        goto L11
    L18:
        return super.onKeyDown(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.ui.g] */
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
    public VideoPinchView(Context r100, sz3.c r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "videoPinchParams");
        Intrinsics.checkNotNullParameter(r102, "pinchUtil");
        sz3.c r103 = null;
        this(r100, 0 == true ? 1 : 0, 6, 0);
        this.f195800m = r101;
        r101.f543928d = this.f195798k;
        this.f195801n = r102;
        this.f195790c = (ViewGroup) this.f195802o.findViewById(R.id.container);
        this.f195792e = (FrameLayout) this.f195802o.findViewById(R.id.click_container);
        this.f195791d = (ViewGroup) this.f195802o.findViewById(R.id.pinch_container);
        this.f195793f = this.f195802o.findViewById(R.id.bottom_view);
        this.f195794g = this.f195802o.findViewById(R.id.button_bar);
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        FrameLayout r106 = this.f195792e;
        if (r106 == null) goto L5;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L7:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
    L10:
        if (r108 == null) goto L15;
        r108.bottomMargin = r105;
        FrameLayout r109 = this.f195792e;
        if (r109 == null) goto L15;
        r109.setLayoutParams(r108);
    L15:
        View r110 = this.f195794g;
        if (r110 == null) goto L18;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(r110, r105);
    L18:
        FrameLayout r111 = this.f195792e;
        if (r111 == null) goto L21;
        r111.setOnTouchListener(new e());
    L21:
        sz3.c r112 = this.f195800m;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r112 = null;
    L24:
        LifecycleOwner r113 = r112.f543926b;
        sz3.c r114 = this.f195800m;
        if (r114 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r114 = null;
    L27:
        this.f195795h = r114.f543933i;
        sz3.c r115 = this.f195800m;
        if (r115 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
    L31:
        this.f195796i = r103.f543932h;
        qz3.b r116 = this.f195795h;
        if (r116 == null) goto L34;
        r116.i(r113, new f(this));
    L34:
        qz3.b r117 = this.f195795h;
        if (r117 == null) goto L37;
        r117.n();
    L37:
        qz3.b r118 = this.f195795h;
        if (r118 == 0) goto L40;
        r118.s(r113, new g(this));
    L40:
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        return;
    L30:
        r103 = r115;
        goto L31
    L9:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L7
    }

    public VideoPinchView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195798k = new r0(this);
        this.f195799l = true;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.familiar_surface_dialog, this);
        this.f195802o = r103;
        this.f195803p = new e0(r103);
        this.f195804q = PinchEnterMethod.PINCH;
    }

    public /* synthetic */ VideoPinchView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
