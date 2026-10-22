package q7a;

import android.os.Handler;
import android.os.Looper;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import t7a.d;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, WeakReference<p7a.a>> f531989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList<p7a.a> f531990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList<p7a.a> f531991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f531992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s7a.b f531993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f531994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p7a.a f531995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f531996h;

    public b() {
        this.f531992d = new Handler(Looper.getMainLooper());
    }

    public final void b() {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f531996h == null) goto L12;
        Handler r100 = this.f531992d;
        if (r100 == null) goto L13;
        r100.post(new a(this));
        return;
    L13:
        return;
    }

    public final boolean d() {
        if (LynxLiteConfigs.enableNewGesture() == true) goto L7;
        return false;
    L7:
        return this.f531994f;
    }

    public final int a(p7a.a r100) {
        if (d() == false) goto L29;
        if (r100 == null) goto L36;
        Map<Integer, WeakReference<p7a.a>> r101 = this.f531989a;
        if (r101 == null) goto L37;
        HashMap r102 = (HashMap) r101;
        r102.put(Integer.valueOf(r100.getSign()), new WeakReference(r100));
        int r103 = r100.getSign();
        Map<Integer, s7a.a> r104 = r100.getGestureDetectorMap();
        if (d() == false) goto L28;
        if (r104 == null) goto L28;
        if (r104.isEmpty() == true) goto L28;
        if (this.f531993e == null) goto L28;
        Iterator<Map.Entry<Integer, s7a.a>> r105 = r104.entrySet().iterator();
    L19:
        if (r105.hasNext() == false) goto L28;
        s7a.a r106 = r105.next().getValue();
        s7a.b r107 = this.f531993e;
        r107.getClass();
        if (r106 == null) goto L19;
        int r108 = r106.f540932a;
        Map<Integer, Set<Integer>> r109 = r107.f540937a;
        HashMap r110 = (HashMap) r109;
        if (r110.get(Integer.valueOf(r108)) != null) goto L26;
        Map<Integer, Set<Integer>> r111 = r107.f540937a;
        HashMap r112 = (HashMap) r111;
        r112.put(Integer.valueOf(r108), new HashSet());
    L26:
        Map<Integer, Set<Integer>> r113 = r107.f540937a;
        HashMap r114 = (HashMap) r113;
        ((Set) r114.get(Integer.valueOf(r108))).add(Integer.valueOf(r103));
    L28:
        return r100.getSign();
    L37:
        return 0;
    L36:
        return 0;
    L29:
        return 0;
    }

    public final boolean e(int r100) {
        if (d() == false) goto L9;
        Map<Integer, WeakReference<p7a.a>> r101 = this.f531989a;
        if (r101 == null) goto L11;
        HashMap r102 = (HashMap) r101;
        return r102.containsKey(Integer.valueOf(r100));
    L11:
        return false;
    L9:
        return false;
    }

    public final void f(p7a.a r100) {
        if (d() == false) goto L33;
        if (r100 == null) goto L47;
        Map<Integer, WeakReference<p7a.a>> r101 = this.f531989a;
        if (r101 == null) goto L50;
        HashMap r102 = (HashMap) r101;
        r102.remove(Integer.valueOf(r100.getGestureArenaMemberId()));
        int r103 = r100.getGestureArenaMemberId();
        Map<Integer, s7a.a> r104 = r100.getGestureDetectorMap();
        if (d() == false) goto L51;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.isEmpty() == false) goto L16;
        return;
    L16:
        if (this.f531993e == null) goto L49;
        Iterator<Map.Entry<Integer, s7a.a>> r105 = r104.entrySet().iterator();
    L19:
        if (r105.hasNext() == false) goto L53;
        s7a.a r106 = r105.next().getValue();
        s7a.b r107 = this.f531993e;
        r107.getClass();
        if (r106 == null) goto L19;
        int r108 = r106.f540932a;
        Map<Integer, Set<Integer>> r109 = r107.f540937a;
        HashMap r110 = (HashMap) r109;
        Set r111 = (Set) r110.get(Integer.valueOf(r108));
        if (r111 == null) goto L19;
        if (r111.isEmpty() == true) goto L19;
        if (r111.contains(Integer.valueOf(r103)) == false) goto L19;
        r111.remove(Integer.valueOf(r103));
        if (r111.isEmpty() == false) goto L19;
        Map<Integer, Set<Integer>> r112 = r107.f540937a;
        HashMap r113 = (HashMap) r112;
        r113.remove(Integer.valueOf(r108));
        goto L19
    L53:
        return;
    L49:
        return;
    L51:
        return;
    L50:
        return;
    L47:
        return;
    }

    public final void c(String r110, LynxTouchEvent r111) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f531996h == null) goto L84;
        LinkedList<p7a.a> r100 = this.f531991c;
        if (this.f531995g != null) goto L11;
        return;
    L11:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r110) == false) goto L13;
    L19:
        int r101 = 0;
    L21:
        if (r101 >= r100.size()) goto L87;
        Map<Integer, t7a.a> r102 = r100.get(r101).getGestureHandlers();
        if (r102 == null) goto L61;
        Iterator<t7a.a> r103 = r102.values().iterator();
    L27:
        if (r103.hasNext() == false) goto L61;
        t7a.a r104 = r103.next();
        byte r112 = -1;
        switch(r110.hashCode()) {
            case -1578593149: goto L44;
            case -819532484: goto L40;
            case 364536720: goto L36;
            case 2127979129: goto L32;
            default: goto L47;
        };
    L47:
        switch(r112) {
            case 0: goto L59;
            case 1: goto L56;
            case 2: goto L53;
            case 3: goto L50;
            default: goto L27;
        };
    L50:
        if (((Boolean) ((HashMap) r104.f544906d).get("onTouchesCancel")).booleanValue() == false) goto L27;
        r104.n("onTouchesCancel", r104.f(r111));
        goto L27
    L53:
        if (((Boolean) ((HashMap) r104.f544906d).get("onTouchesMove")).booleanValue() == false) goto L27;
        r104.n("onTouchesMove", r104.f(r111));
        goto L27
    L56:
        if (((Boolean) ((HashMap) r104.f544906d).get("onTouchesUp")).booleanValue() == false) goto L27;
        r104.n("onTouchesUp", r104.f(r111));
        goto L27
    L59:
        if (((Boolean) ((HashMap) r104.f544906d).get("onTouchesDown")).booleanValue() == false) goto L27;
        r104.n("onTouchesDown", r104.f(r111));
        goto L27
    L32:
        if (r110.equals(LynxTouchEvent.EVENT_TOUCH_CANCEL) == false) goto L47;
        r112 = 3;
        goto L47
    L36:
        if (r110.equals(LynxTouchEvent.EVENT_TOUCH_MOVE) == false) goto L47;
        r112 = 2;
        goto L47
    L40:
        if (r110.equals(LynxTouchEvent.EVENT_TOUCH_END) == false) goto L47;
        r112 = 1;
        goto L47
    L44:
        if (r110.equals(LynxTouchEvent.EVENT_TOUCH_START) == false) goto L47;
        r112 = 0;
    L61:
        r101 = r101 + 1;
        goto L21
    L87:
        return;
    L13:
        if (LynxTouchEvent.EVENT_TOUCH_MOVE.equals(r110) == true) goto L19;
        if (LynxTouchEvent.EVENT_TOUCH_CANCEL.equals(r110) == true) goto L19;
        if (LynxTouchEvent.EVENT_TOUCH_END.equals(r110) == true) goto L19;
        return;
    }
}
