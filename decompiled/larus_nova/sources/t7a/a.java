package t7a;

import android.content.res.Resources;
import android.view.MotionEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f544904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxContext f544905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Boolean> f544906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s7a.a f544907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p7a.a f544908f;

    public void a() {
        this.f544904b = 2;
        p7a.a r100 = this.f544908f;
        if (r100 == null) goto L6;
        r100.onPlatformGestureStatusChanged(2);
        return;
    }

    public final void b() {
        this.f544904b = 1;
        p7a.a r100 = this.f544908f;
        if (r100 == null) goto L6;
        r100.onPlatformGestureStatusChanged(1);
        return;
    }

    public void d() {
        this.f544904b = 5;
        p7a.a r100 = this.f544908f;
        if (r100 == null) goto L6;
        r100.onPlatformGestureStatusChanged(5);
        return;
    }

    public abstract void k(MotionEvent r100, LynxTouchEvent r101, float r102, float r103, boolean r104, r7a.a r105);

    public void m() {
        this.f544904b = 0;
    }

    public void e() {
        int r100 = this.f544904b;
        if (r100 != 5) goto L5;
    L8:
        p7a.a r101 = this.f544908f;
        if (r101 == null) goto L12;
        r101.onPlatformGestureStatusChanged(this.f544904b);
        return;
    L12:
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f544904b = 4;
        goto L8
    L7:
        this.f544904b = 3;
        goto L8
    }

    public final boolean g() {
        return ((Boolean) ((HashMap) this.f544906d).get("onBegin")).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) ((HashMap) this.f544906d).get("onEnd")).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) ((HashMap) this.f544906d).get(WidgetCostModule.TYPE_ON_START)).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) ((HashMap) this.f544906d).get("onUpdate")).booleanValue();
    }

    public final HashMap<String, Object> f(LynxTouchEvent r100) {
        HashMap<String, Object> r101 = new HashMap();
        if (r100 == null) goto L13;
        r101.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r101.put("type", r100.getName());
        if (r100.getViewPoint() == null) goto L8;
        r101.put("x", Integer.valueOf(l(r100.getViewPoint().f383322a)));
        r101.put("y", Integer.valueOf(l(r100.getViewPoint().f383323b)));
    L8:
        if (r100.getPagePoint() == null) goto L11;
        r101.put("pageX", Integer.valueOf(l(r100.getPagePoint().f383322a)));
        r101.put("pageY", Integer.valueOf(l(r100.getPagePoint().f383323b)));
    L11:
        if (r100.getClientPoint() == null) goto L13;
        r101.put("clientX", Integer.valueOf(l(r100.getClientPoint().f383322a)));
        r101.put("clientY", Integer.valueOf(l(r100.getClientPoint().f383323b)));
    L13:
        return r101;
    }

    public final int l(float r100) {
        LynxContext r101 = this.f544905c;
        if (r101 == null) goto L12;
        if (r101.getResources() == null) goto L12;
        Resources r102 = r101.getResources();
        if (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()) == null) goto L12;
        Resources r103 = r101.getResources();
        return (int) (((double) (r100 / WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density)) + 0.5d);
    L12:
        return (int) r100;
    }

    public final void n(String r100, HashMap<String, Object> r101) {
        if (this.f544907e != null) goto L5;
        return;
    L5:
        com.lynx.tasm.event.a r102 = new com.lynx.tasm.event.a(this.f544903a, r100, r101);
        this.f544905c.getEventEmitter().sendGestureEvent(this.f544907e.f540932a, r102);
    }

    public a(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        this.f544904b = 0;
        this.f544903a = r100;
        this.f544905c = r101;
        this.f544907e = r102;
        this.f544908f = r103;
        HashMap r104 = new HashMap();
        this.f544906d = r104;
        List<String> r105 = r102.f540934c;
        Boolean r106 = Boolean.FALSE;
        r104.put("onTouchesDown", r106);
        r104.put("onTouchesMove", r106);
        r104.put("onTouchesUp", r106);
        r104.put("onTouchesCancel", r106);
        r104.put("onBegin", r106);
        r104.put("onUpdate", r106);
        r104.put(WidgetCostModule.TYPE_ON_START, r106);
        r104.put("onEnd", r106);
        if (r105 == null) goto L10;
        Iterator r107 = ((ArrayList) r105).iterator();
    L6:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        if (((HashMap) this.f544906d).containsKey(r108) == false) goto L6;
        Map<String, Boolean> r109 = this.f544906d;
        HashMap r110 = (HashMap) r109;
        r110.put(r108, Boolean.TRUE);
        goto L6
    L16:
        return;
    }

    public static Map<Integer, a> c(int r100, LynxContext r101, p7a.a r102, Map<Integer, s7a.a> r103) {
        HashMap r104 = new HashMap();
        Iterator<Integer> r105 = r103.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L26;
        s7a.a r106 = r103.get(Integer.valueOf(r105.next().intValue()));
        if (r106 == null) goto L4;
        int r107 = r106.f540933b;
        if (r107 == 0) goto L10;
        if (r107 == 2) goto L13;
        if (r107 == 1) goto L16;
        if (r107 == 3) goto L19;
        if (r107 == 4) goto L22;
        if (r107 != 7) goto L4;
        r104.put(Integer.valueOf(r107), new g(r100, r101, r106, r102));
        goto L4
    L22:
        r104.put(Integer.valueOf(r107), new f(r100, r101, r106, r102));
        goto L4
    L19:
        r104.put(Integer.valueOf(r107), new j(r100, r101, r106, r102));
        goto L4
    L16:
        r104.put(Integer.valueOf(r107), new c(r100, r101, r106, r102));
        goto L4
    L13:
        r104.put(Integer.valueOf(r107), new b(r100, r101, r106, r102));
        goto L4
    L10:
        r104.put(Integer.valueOf(r107), new h(r100, r101, r106, r102));
        goto L4
    L26:
        return r104;
    }
}
