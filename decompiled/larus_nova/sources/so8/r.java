package so8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.block.newheader.foldcontainer.FolderContainerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f542769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f542770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f542771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public so8.b f542772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f542773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f542774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f542775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f542776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public so8.a f542777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DeepThinkFoldStatus f542778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<ZoomInAnimationAction, k> f542779k;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f542780a = null;

        static {
            int[] r100 = new int[ZoomInAnimationState.values().length];
            r100[ZoomInAnimationState.ZOOM_IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ZoomInAnimationState.STAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ZoomInAnimationState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ZoomInAnimationState.ZOOM_OUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f542780a = r100;
        }
    }

    static {
    }

    public r() {
        this.f542769a = new v();
        this.f542772d = new so8.b(0);
        this.f542776h = LazyKt.lazy(new l());
        this.f542778j = DeepThinkFoldStatus.HalfFold;
        this.f542779k = new LinkedHashMap();
    }

    public final void a(ZoomInAnimationState r100) {
        FLogger.f375446a.d("ZoomInAnimationManager", "changeAnimationState:" + r100);
        this.f542772d = new so8.b(r100, AppHost.f326268a.getAppClock().currentTimeMillis());
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, so8.o] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, so8.p] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object, so8.q] */
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
    public final void b(FrameLayout r110) {
        this.f542770b = r110;
        ZoomInAnimationState r100 = this.f542772d.f542737a;
        FLogger r101 = FLogger.f375446a;
        r101.d("ZoomInAnimationManager", "consumeAnimation  currentState:" + r100 + "== wait list：" + ((ArrayList) this.f542769a.f542788a).size() + "====executing list：" + this.f542779k.size());
        int r102 = b.f542780a[r100.ordinal()];
        jc8.a r111 = null;
        Context r112 = null;
        r111 = null;
        if (r102 == 1) goto L89;
        if (r102 == 2) goto L89;
        if (r102 != 3) goto L7;
        v r103 = this.f542769a;
        k r104 = (k) CollectionsKt.removeFirstOrNull(r103.f542788a);
        if (r104 == null) goto L17;
        Set r105 = (Set) ((LinkedHashMap) r103.f542789b).get(r104.f542759c);
        if (r105 != null) goto L16;
        r105 = new LinkedHashSet();
    L16:
        r105.remove(r104.f542757a);
    L17:
        if (r104 == null) goto L145;
        ZoomInAnimationEndStrategy r106 = r104.f542761e.f542742d;
        if (r106 != ZoomInAnimationEndStrategy.TIMER_CONTROL) goto L21;
    L41:
        boolean r107 = true;
    L42:
        if (r107 == false) goto L48;
        long r108 = r104.f542761e.f542740b + 200;
        final k r109 = k.a(r104, ZoomInAnimationAction.HIDE);
        Runnable r113 = this.f542775g;
        if (r113 == null) goto L46;
        SoftReference<Handler> r114 = y.f375498a;
        Intrinsics.checkNotNullParameter(r113, "action");
        y.a(r113);
    L46:
        Runnable r115 = new m(this, r109);
        this.f542775g = r115;
        SoftReference<Handler> r116 = y.f375498a;
        Intrinsics.checkNotNullParameter(r115, "action");
        y.d(r115, r108);
    L48:
        FLogger r117 = FLogger.f375446a;
        r117.d("ZoomInAnimationManager", "startZoomIn:" + r104.f542757a + "===zoomInItem:" + r104);
        StringBuilder r118 = new StringBuilder("startZoomIn:");
        r118.append(r104.f542757a);
        r118.append("===============");
        r117.d("ZoomInAnimationManager", r118.toString());
        if (r110 == null) goto L153;
        View r119 = r104.f542760d.c(r110.getContext(), r104.f542758b.f542756a);
        this.f542771c = r119;
        a(ZoomInAnimationState.ZOOM_IN);
        this.f542773e = r104;
        r104.f542760d.d(r119, r104.f542758b.f542756a);
        s r120 = this.f542774f;
        if (r120 == null) goto L56;
        Function1<j, Unit> r121 = r120.f542781a;
        if (r121 == null) goto L56;
        r121.invoke(r104.f542758b);
    L56:
        int r122 = r104.f542761e.f542739a;
        final f r123 = (f) this.f542776h.getValue();
        Context r124 = r110.getContext();
        String r125 = r104.f542757a;
        boolean r126 = ic8.q.a(this.f542778j);
        Rect r127 = r104.f542761e.f542743e;
        ?? r128 = new o(this);
        final ?? r129 = new p(this);
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r125, "animationId");
        Intrinsics.checkNotNullParameter(r119, "view");
        Intrinsics.checkNotNullParameter(r127, "marginRect");
        Intrinsics.checkNotNullParameter(r128, "onZoomInEnd");
        Intrinsics.checkNotNullParameter(r129, "onZoomInUpdate");
        r123.f542748b.removeCallbacksAndMessages(null);
        AnimatorSet r130 = r123.f542747a;
        if (r130 == null) goto L59;
        r130.end();
    L59:
        FrameLayout r131 = r123.f542749c;
        if (r131 == null) goto L62;
        r131.removeAllViews();
    L62:
        FrameLayout r132 = r123.f542749c;
        if (r132 == null) goto L65;
        e1.x(r132);
    L65:
        FrameLayout r133 = r123.f542749c;
        if (r133 == null) goto L68;
        View r134 = new View(r124);
        e1.q(r134);
        r133.addView(r134, new ViewGroup.LayoutParams(m0.b(r124), i5.b()));
    L68:
        FrameLayout r135 = r123.f542749c;
        if (r135 == null) goto L71;
        r135.addView(r119);
    L71:
        FrameLayout r136 = r123.f542749c;
        if (r136 == null) goto L78;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (r137 == null) goto L77;
        ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
        r138.setMargins(r127.left, r127.top, r127.right, r127.bottom);
        r136.setLayoutParams(r138);
        goto L78
    L77:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L78:
        FrameLayout r139 = r123.f542749c;
        if (r139 == null) goto L81;
        r139.setBackground(null);
    L81:
        ObjectAnimator r140 = ObjectAnimator.ofFloat(r123.f542749c, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r141 = ObjectAnimator.ofFloat(r123.f542750d, "alpha", new float[]{1.0f, 0.0f});
        if (r126 == true) goto L87;
        ViewGroup r142 = r123.f542750d;
        if (r142 == null) goto L87;
        int r143 = r142.getMeasuredHeight();
    L88:
        ValueAnimator r144 = ValueAnimator.ofInt(new int[]{r143, r122});
        r144.addUpdateListener(new d(r123, r129));
        AnimatorSet r145 = new AnimatorSet();
        r145.playTogether(new Animator[]{r140, r141, r144});
        r145.setDuration(200);
        r145.addListener(new g(r128, r125));
        r145.start();
        r123.f542747a = r145;
        return;
    L87:
        r143 = 0;
        goto L88
    L153:
        return;
    L21:
        if (r106 != ZoomInAnimationEndStrategy.PASSIVE_WAIT) goto L40;
        List<k> r146 = this.f542769a.f542788a;
        if ((r146 instanceof Collection) == true) goto L25;
    L27:
        Iterator r147 = ((ArrayList) r146).iterator();
    L29:
        if (r147.hasNext() == false) goto L37;
        if (((k) r147.next()).f542759c != ZoomInAnimationAction.SHOW) goto L33;
        boolean r148 = true;
    L34:
        if (r148 == false) goto L29;
        boolean r149 = true;
    L38:
        if (r149 == false) goto L40;
    L33:
        r148 = false;
    L37:
        r149 = false;
        goto L38
    L25:
        if (((ArrayList) r146).isEmpty() == false) goto L27;
    L40:
        r107 = false;
        goto L42
    L145:
        return;
    L7:
        if (r102 != 4) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    L89:
        k r150 = (k) ((LinkedHashMap) this.f542779k).get(ZoomInAnimationAction.HIDE);
        k r151 = (k) ((LinkedHashMap) this.f542779k).get(ZoomInAnimationAction.SHOW);
        if (r150 == null) goto L127;
        StringBuilder r152 = new StringBuilder("startZoomOut:");
        k r153 = this.f542773e;
        if (r153 == null) goto L94;
        String r154 = r153.f542757a;
    L95:
        r152.append(r154);
        r152.append("===============");
        r101.d("ZoomInAnimationManager", r152.toString());
        a(ZoomInAnimationState.ZOOM_OUT);
        Set<String> r155 = w.f542790a;
        k r156 = this.f542773e;
        String r157 = "";
        if (r156 == null) goto L99;
        String r158 = r156.f542757a;
        if (r158 == null) goto L99;
    L100:
        w.a(r158);
        final f r159 = (f) this.f542776h.getValue();
        boolean r160 = ic8.q.a(this.f542778j);
        k r161 = this.f542773e;
        if (r161 == null) goto L103;
        String r162 = r161.f542757a;
    L104:
        if (r162 == null) goto L107;
        r157 = r162;
    L107:
        if (r161 == null) goto L111;
        c r163 = r161.f542761e;
        if (r163 == null) goto L111;
        int r164 = r163.f542739a;
    L112:
        ?? r165 = new q(this);
        r159.getClass();
        Intrinsics.checkNotNullParameter(r157, "animationId");
        Intrinsics.checkNotNullParameter(r165, "onZoomOutEnd");
        ObjectAnimator r166 = ObjectAnimator.ofFloat(r159.f542749c, "alpha", new float[]{1.0f, 0.0f});
        r166.addListener(new h(r159));
        ObjectAnimator r167 = ObjectAnimator.ofFloat(r159.f542750d, "alpha", new float[]{0.0f, 1.0f});
        ViewGroup r168 = r159.f542750d;
        if (r168 == null) goto L116;
        Context r169 = r168.getContext();
        if (r169 == null) goto L116;
    L122:
        if (r160 == false) goto L124;
        int r170 = 0;
    L125:
        ValueAnimator r171 = ValueAnimator.ofInt(new int[]{r164, r170});
        r171.addUpdateListener(new e(r159));
        AnimatorSet r172 = new AnimatorSet();
        r172.playTogether(new Animator[]{r166, r167, r171});
        r172.setDuration(200);
        r172.addListener(new i(r165, r157));
        r172.start();
        r159.f542747a = r172;
        return;
    L124:
        int r173 = FolderContainerView.f296321o;
        Intrinsics.checkNotNullParameter(r169, PerfLog.PARAM_KEY_CONTEXT_ID);
        dh8.b.f468639a.getClass();
        Intrinsics.checkNotNullParameter(r169, PerfLog.PARAM_KEY_CONTEXT_ID);
        r170 = dh8.b.e(dh8.b.b(r169));
    L116:
        FrameLayout r174 = r159.f542749c;
        if (r174 == null) goto L119;
        r112 = r174.getContext();
    L119:
        if (r112 != null) goto L121;
        r169 = AppHost.f326268a.getApplication();
        goto L122
    L121:
        r169 = r112;
    L111:
        r164 = 0;
        goto L112
    L103:
        r162 = null;
    L99:
        r158 = "";
        goto L100
    L94:
        r154 = null;
        goto L95
    L127:
        if (r151 == null) goto L147;
        View r175 = this.f542771c;
        if (r175 == null) goto L148;
        jc8.a r176 = r151.f542758b.f542756a;
        k r177 = this.f542773e;
        if (r177 == null) goto L136;
        j r178 = r177.f542758b;
        if (r178 == null) goto L136;
        r111 = r178.f542756a;
    L136:
        if (r176.e(r111) == true) goto L149;
        this.f542773e = r151;
        r151.f542760d.d(r175, r151.f542758b.f542756a);
        s r179 = this.f542774f;
        if (r179 == null) goto L150;
        Function1<j, Unit> r180 = r179.f542784d;
        if (r180 == null) goto L151;
        r180.invoke(r151.f542758b);
        return;
    L151:
        return;
    L150:
        return;
    L149:
        return;
    L148:
        return;
    }

    public final void c(k r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("enqueue executing animation queue==item action:");
        String r104 = null;
        if (r100 == null) goto L5;
        ZoomInAnimationAction r105 = r100.f542759c;
    L6:
        r103.append(r105);
        r103.append(" animationid:");
        if (r100 == null) goto L9;
        String r106 = r100.f542757a;
    L10:
        r103.append(r106);
        r103.append("===from:");
        r103.append(r101);
        r102.d("ZoomInAnimationManager", r103.toString());
        if (r100 != null) goto L13;
        return;
    L13:
        String r107 = r100.f542757a;
        k r108 = this.f542773e;
        if (r108 == null) goto L17;
        r104 = r108.f542757a;
    L17:
        if (Intrinsics.areEqual(r107, r104) == true) goto L19;
        return;
    L19:
        ZoomInAnimationAction r109 = r100.f542759c;
        ZoomInAnimationAction r110 = ZoomInAnimationAction.HIDE;
        if (r109 != r110) goto L23;
        ((LinkedHashMap) this.f542779k).clear();
        this.f542779k.put(r110, r100);
        return;
    L23:
        if (this.f542779k.containsKey(r110) == false) goto L25;
        return;
    L25:
        this.f542779k.put(r100.f542759c, r100);
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
