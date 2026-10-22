package com.ss.android.lark.newemoji.emojioptions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import z5c.i3;

/* JADX INFO: loaded from: classes36.dex */
public final class OptionsSelectPopupMenu<T> implements i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Handler f432963x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<T> f432965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f432966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f432967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<? extends IBinder> f432968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f432969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f432970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f432971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f432972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f432973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f432974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f432975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f432976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f432977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<T, IntRange> f432978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f432979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function2<? super T, ? super SelectWay, Unit> f432980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f432981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<T, View> f432982s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.ss.android.lark.newemoji.emojioptions.b f432983t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final UDShadowLayout f432984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OptionsSelectPopupMenu<T>.e f432985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WindowManager f432986w;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/newemoji/emojioptions/OptionsSelectPopupMenu$SelectWay;", "", "value", "Lcom/ss/android/lark/statistics/extensions/IParam;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/statistics/extensions/IParam;)V", "getValue", "()Lcom/ss/android/lark/statistics/extensions/IParam;", "SLIDE", "CLICK", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SelectWay extends Enum<SelectWay> {
        public static final SelectWay CLICK = null;
        public static final SelectWay SLIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SelectWay[] f432987a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f432988b = null;
        private final s5c.d value;

        public static EnumEntries<SelectWay> getEntries() {
            return f432988b;
        }

        static {
            SelectWay r100 = new SelectWay("SLIDE", 0, i3.f570222c);
            SLIDE = r100;
            SelectWay r101 = new SelectWay("CLICK", 1, i3.f570223d);
            CLICK = r101;
            SelectWay[] r102 = {r100, r101};
            f432987a = r102;
            f432988b = EnumEntriesKt.enumEntries(r102);
        }

        public static SelectWay[] values() {
            return (SelectWay[]) f432987a.clone();
        }

        public final s5c.d getValue() {
            return this.value;
        }

        public static SelectWay valueOf(String r100) {
            return (SelectWay) r27.a.a(SelectWay.class, r100);
        }

        public SelectWay(String r100, int r101, s5c.a r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c<T> {
    }

    public interface d<T> {
        View a(T r100);
    }

    public final class e extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OptionsSelectPopupMenu<T> f432989a;

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent r100) {
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            if (r101 == false) goto L15;
            if (r100.getAction() != 1) goto L15;
            OptionsSelectPopupMenu<T> r102 = this.f432989a;
            if (r102.f432972i == false) goto L15;
            r102.d(true);
            return true;
        L15:
            return super.dispatchKeyEvent(r100);
        L5:
            if (r100.getKeyCode() != 4) goto L7;
            r101 = true;
            goto L7
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNull(r100);
            int r101 = (int) r100.getX();
            int r102 = (int) r100.getY();
            if (r100.getAction() != 0) goto L12;
            if (r101 >= 0) goto L6;
        L10:
            this.f432989a.d(true);
            return true;
        L6:
            if (r101 >= getWidth()) goto L10;
            if (r102 < 0) goto L10;
            if (r102 >= getHeight()) goto L10;
        L12:
            if (r100.getAction() != 4) goto L15;
            this.f432989a.d(true);
            return true;
        L15:
            return super.onTouchEvent(r100);
        }

        public e(OptionsSelectPopupMenu r100, Context r101, UDShadowLayout r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            this.f432989a = r100;
            super(r101);
            addView(r102, -2, -2);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OptionsSelectPopupMenu<T> f432990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f432991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f432992c;

        public f(OptionsSelectPopupMenu<T> r100, int r101, int r102) {
            this.f432990a = r100;
            this.f432991b = r101;
            this.f432992c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f432990a.f(this.f432991b, this.f432992c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f432963x = new Handler(Looper.getMainLooper());
    }

    public final void e() {
        Iterator<Map.Entry<T, View>> r100 = this.f432982s.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().setSelected(false);
        goto L4
    L6:
        View r101 = this.f432982s.get(this.f432966c);
        if (r101 == null) goto L11;
        r101.setSelected(true);
        return;
    }

    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        return this.f432964a;
    }

    public final int b(int r100) {
        return MathKt.roundToInt(c(r100));
    }

    public final float c(int r100) {
        return i.a.a(this, r100);
    }

    public final void d(boolean r100) {
        if (this.f432972i == true) goto L5;
        return;
    L5:
        this.f432986w.removeView(this.f432985v);
        this.f432972i = false;
        this.f432979p.invoke();
        if (r100 == false) goto L8;
        return;
    L8:
        if (this.f432973j == false) goto L10;
        SelectWay r101 = SelectWay.SLIDE;
    L11:
        this.f432980q.invoke(this.f432966c, r101);
        return;
    L10:
        r101 = SelectWay.CLICK;
        goto L11
    }

    public final void f(int r100, int r101) {
        if (this.f432970g == false) goto L5;
        int r102 = 2;
    L6:
        WindowManager.LayoutParams r103 = new WindowManager.LayoutParams(r102);
        r103.width = -2;
        r103.height = -2;
        r103.flags = (r103.flags | 262144) | 32;
        r103.format = -3;
        r103.x = r100;
        if (this.f432970g == false) goto L9;
        int r104 = r101 - ((Number) this.f432981r.getValue()).intValue();
    L10:
        r103.y = r104;
        r103.gravity = 51;
        if ((this.f432964a instanceof Activity) == true) goto L24;
        Log.i("OptionsPopupMenu", "showAtLocation: current context is not activity, trying to get window token");
        r103.token = this.f432968e.invoke();
    L24:
    L21:
        e = move-exception;
        Log.e("OptionsPopupMenu", "showAtLocation: " + e.getMessage());
        return;
    L14:
        if (this.f432985v.isAttachedToWindow() == false) goto L19;
        this.f432986w.removeViewImmediate(this.f432985v);     // Catch: Exception -> L21
        View r105 = this.f432971h;     // Catch: Exception -> L21
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");     // Catch: Exception -> L21
        r105 = null;
    L18:
        r105.post(new f(this, r100, r101));     // Catch: Exception -> L21
        return;
    L19:
        WindowManager r106 = this.f432986w;     // Catch: Exception -> L21
        OptionsSelectPopupMenu<T>.e r107 = this.f432985v;     // Catch: Exception -> L21
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r107, r103);     // Catch: Exception -> L21
        r106.addView(r107, r103);     // Catch: Exception -> L21
        return;
    L9:
        r104 = r101;
        goto L10
    L5:
        r102 = 1000;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OptionsSelectPopupMenu(Context r100, com.ss.android.lark.newemoji.emojioptions.a r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "optionAdapter");
        this.f432964a = r100;
        this.f432965b = r101;
        this.f432966c = r102;
        this.f432967d = null;
        this.f432968e = OptionsSelectPopupMenu$windowTokenProvider$1.INSTANCE;
        this.f432977n = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f432978o = new LinkedHashMap();
        this.f432979p = OptionsSelectPopupMenu$onCloseHandler$1.INSTANCE;
        this.f432980q = OptionsSelectPopupMenu$onSelectHandler$1.INSTANCE;
        this.f432981r = LazyKt.lazy(LazyThreadSafetyMode.NONE, new OptionsSelectPopupMenu$statusBarHeight$2(this));
        Collection<String> r103 = r101.f432994b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        T r106 = r105.next();
        View r107 = this.f432965b.a(r106);
        FrameLayout r108 = new FrameLayout(this.f432964a);
        r108.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r108.setBackgroundResource(R.drawable.bg_select_option_icon);
        int r109 = b(4);
        r108.setPadding(r109, r109, r109, r109);
        r108.addView(r107);
        r108.setOnClickListener(new h(this, r106));
        r104.add(TuplesKt.to(r106, r108));
        goto L4
    L6:
        Map<T, View> r110 = MapsKt.toMap(r104);
        this.f432982s = r110;
        com.ss.android.lark.newemoji.emojioptions.b r111 = new com.ss.android.lark.newemoji.emojioptions.b(this.f432964a);
        r111.setOrientation(0);
        int r112 = MathKt.roundToInt(i.a.a(r111, 6));
        r111.setPadding(r112, r112, r112, r112);
        Iterator<Map.Entry<T, View>> r113 = r110.entrySet().iterator();
    L8:
        if (r113.hasNext() == false) goto L10;
        r111.addView(r113.next().getValue());
        goto L8
    L10:
        this.f432983t = r111;
        UDShadowLayout r114 = new UDShadowLayout(this.f432964a);
        r114.c(R.style.UDShadow_S2_Down);
        r114.addView(r111, new UDShadowLayout.LayoutParams(-2, -2));
        this.f432984u = r114;
        OptionsSelectPopupMenu<T>.e r115 = new e(this, this.f432964a, r114);
        this.f432985v = r115;
        Object r116 = this.f432964a.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r117 = (WindowManager) r116;
        this.f432986w = r117;
        e();
        int r118 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        r114.measure(r118, r118);
        this.f432974k = r117.getDefaultDisplay().getOrientation();
        r115.addOnLayoutChangeListener(new com.ss.android.lark.newemoji.emojioptions.d(this));
        Resources r119 = this.f432964a.getResources();
        int r120 = WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics()).widthPixels;
    }
}
