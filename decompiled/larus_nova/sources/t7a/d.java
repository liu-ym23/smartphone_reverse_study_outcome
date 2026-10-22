package t7a;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.OverScroller;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f544920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxContext f544921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f544922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f544923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f544924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f544925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashSet<p7a.a> f544926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashSet<Integer> f544927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p7a.a f544928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p7a.a f544929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p7a.a f544930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p7a.a f544931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s7a.b f544932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r7a.a f544933n;

    public static void f(p7a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<Integer, a> r101 = r100.getGestureHandlers();
        if (r101 != null) goto L7;
        return;
    L7:
        Iterator<a> r102 = r101.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().m();
        goto L9
    }

    public final int d(p7a.a r100) {
        if (r100 != null) goto L5;
        return 3;
    L5:
        Map<Integer, a> r101 = r100.getGestureHandlers();
        if (r101 != null) goto L8;
        return 3;
    L8:
        Iterator<a> r102 = r101.values().iterator();
        int r103 = -1;
    L10:
        if (r102.hasNext() == false) goto L39;
        a r104 = r102.next();
        int r105 = r104.f544904b;
        boolean r106 = true;
        if (r105 != 5) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L16;
        if (r105 == 2) goto L22;
        r106 = false;
    L22:
        if (r106 == true) goto L23;
        if (r103 < 0) goto L36;
        if (r103 <= r105) goto L10;
    L36:
        r103 = r105;
        goto L10
    L23:
        int r108 = r104.f544907e.f540932a;
        HashSet<Integer> r109 = this.f544927h;
        Map<Integer, a> r110 = r100.getGestureHandlers();
        if (r110 == null) goto L34;
        Iterator<a> r111 = r110.values().iterator();
    L28:
        if (r111.hasNext() == false) goto L34;
        a r112 = r111.next();
        int r113 = r112.f544907e.f540932a;
        if (r113 == r108) goto L28;
        if (r109.contains(Integer.valueOf(r113)) == true) goto L28;
        r112.e();
    L34:
        return 2;
    L16:
        g(r100);
        this.f544930k = null;
        return 5;
    L14:
        r107 = false;
        goto L15
    L39:
        return r103;
    }

    public final void g(p7a.a r100) {
        f(r100);
        HashSet<p7a.a> r101 = this.f544926g;
        if (r101 == null) goto L8;
        Iterator<p7a.a> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        f(r102.next());
        goto L6
    L10:
        return;
    }

    public final void h(p7a.a r110) {
        s7a.b r100 = this.f544932m;
        Pair r101 = null;
        if (r110 != null) goto L5;
        r100.getClass();
    L48:
        if (r101 != null) goto L50;
        return;
    L50:
        this.f544926g = (HashSet) r101.first;
        this.f544927h = (HashSet) r101.second;
        return;
    L5:
        if (r100.f540938b == null) goto L48;
        Map<Integer, s7a.a> r102 = r110.getGestureDetectorMap();
        if (r102 == null) goto L48;
        HashSet r103 = new HashSet();
        HashSet r104 = new HashSet();
        HashSet r105 = new HashSet();
        Iterator<Map.Entry<Integer, s7a.a>> r106 = r102.entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r104.add(Integer.valueOf(r106.next().getValue().f540932a));
        goto L12
    L14:
        Iterator<Map.Entry<Integer, s7a.a>> r107 = r102.entrySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L46;
        Map.Entry<Integer, s7a.a> r108 = r107.next();
        if (r108.getValue() == null) goto L16;
        List r109 = (List) ((HashMap) r108.getValue().f540935d).get("simultaneous");
        if (r109 == null) goto L16;
        if (r109.isEmpty() == true) goto L16;
        Iterator r111 = r109.iterator();
    L27:
        if (r111.hasNext() == false) goto L16;
        int r112 = ((Integer) r111.next()).intValue();
        if (r104.contains(Integer.valueOf(r112)) == true) goto L30;
        Set r113 = (Set) ((HashMap) r100.f540937a).get(Integer.valueOf(r112));
        if (r113 == null) goto L27;
        Iterator r114 = r113.iterator();
    L36:
        if (r114.hasNext() == false) goto L27;
        int r115 = ((Integer) r114.next()).intValue();
        WeakReference r116 = (WeakReference) ((HashMap) r100.f540938b.f531989a).get(Integer.valueOf(r115));
        if (r116 == null) goto L40;
        p7a.a r117 = (p7a.a) r116.get();
    L41:
        if (r117 == null) goto L36;
        if (r117.getGestureArenaMemberId() == r110.getGestureArenaMemberId()) goto L36;
        r103.add(r117);
        goto L36
    L40:
        r117 = null;
        goto L41
    L30:
        r105.add(Integer.valueOf(r112));
        goto L27
    L46:
        r101 = new Pair(r103, r105);
        goto L48
    }

    public d(LynxContext r100, s7a.b r101) {
        this.f544920a = new OverScroller(r100);
        this.f544921b = r100;
        this.f544932m = r101;
    }

    public final p7a.a e(LinkedList<p7a.a> r100, p7a.a r110) {
        if (r110 == null) goto L5;
    L6:
        if (r100 != null) goto L8;
    L7:
        return null;
    L8:
        int r101 = 0;
        if (r110 != null) goto L13;
        p7a.a r102 = this.f544930k;
        if (r102 == null) goto L13;
        g(r102);
        r110 = r102;
        boolean r103 = true;
    L14:
        int r104 = d(r110);
        if (r104 > 2) goto L18;
        return r110;
    L18:
        if (r104 != 5) goto L20;
        return null;
    L20:
        if (r103 == false) goto L22;
        return null;
    L22:
        int r105 = r100.indexOf(r110);
        int r111 = r100.lastIndexOf(r110);
        if (r105 == r111) goto L28;
        p7a.a r106 = this.f544928i;
        if (r106 == null) goto L27;
        g(r106);
        r105 = r111;
        goto L28
    L27:
        this.f544928i = r100.get(r105);
    L28:
        if (r105 >= 0) goto L30;
    L66:
        return null;
    L30:
        if (r105 >= r100.size()) goto L66;
        int r112 = r100.get(r105).getGestureArenaMemberId();
        int r107 = r105 + 1;
    L34:
        if (r107 >= r100.size()) goto L50;
        p7a.a r108 = r100.get(r107);
        if (r108.getGestureArenaMemberId() == r112) goto L49;
        if (this.f544928i != r108) goto L42;
        this.f544928i = null;
    L44:
        int r109 = d(r108);
        if (r109 <= 2) goto L46;
        if (r109 != 5) goto L49;
        return null;
    L46:
        return r108;
    L42:
        if (d(r108) == 5) goto L44;
        g(r108);
    L49:
        r107 = r107 + 1;
    L50:
        if (r101 >= r105) goto L66;
        p7a.a r113 = r100.get(r101);
        if (r113.getGestureArenaMemberId() == r112) goto L65;
        if (this.f544928i != r113) goto L58;
        this.f544928i = null;
    L60:
        int r114 = d(r113);
        if (r114 <= 2) goto L62;
        if (r114 != 5) goto L65;
        return null;
    L62:
        return r113;
    L58:
        if (d(r113) == 5) goto L60;
        g(r113);
    L65:
        r101 = r101 + 1;
    L13:
        r103 = false;
        goto L14
    L5:
        if (this.f544930k == null) goto L7;
        goto L6
    }

    public final void c(LynxTouchEvent r110, LinkedList<p7a.a> r111, float r112, float r113, MotionEvent r114) {
        int r100 = 0;
    L4:
        if (r100 >= r111.size()) goto L13;
        p7a.a r101 = this.f544929j;
        p7a.a r102 = this.f544930k;
        if (r101 == r102) goto L12;
        if (r101 == null) goto L20;
        if (r102 == r101) goto L11;
        this.f544930k = r101;
    L11:
        h(r101);
        b(this.f544929j, r112, r113, r110, r111, r114);
        r100 = r100 + 1;
        goto L4
    L20:
        return;
    L12:
        return;
    L13:
        b(this.f544930k, r112, r113, r110, r111, r114);
    }

    public final void b(p7a.a r100, float r110, float r111, LynxTouchEvent r112, LinkedList<p7a.a> r113, MotionEvent r114) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r114, r100, r112, r110, r111, false, this.f544933n);
        HashSet<p7a.a> r101 = this.f544926g;
        if (r101 == null) goto L11;
        Iterator<p7a.a> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        a(r114, r102.next(), r112, r110, r111, true, this.f544933n);
        goto L8
    L10:
        r7a.a r103 = this.f544933n;
        r103.f536475b = 0.0f;
        r103.f536476c = 0.0f;
        r103.f536477d = false;
    L11:
        if (r113 == null) goto L15;
        this.f544929j = e(r113, this.f544929j);
        return;
    }

    public static void a(MotionEvent r100, p7a.a r101, LynxTouchEvent r110, float r111, float r112, boolean r113, r7a.a r114) {
        if (r101 != null) goto L4;
        return;
    L4:
        Map<Integer, a> r102 = r101.getGestureHandlers();
        if (r102 != null) goto L7;
        return;
    L7:
        Iterator<a> r103 = r102.values().iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().k(r100, r110, r111, r112, r113, r114);
        goto L9
    }
}
