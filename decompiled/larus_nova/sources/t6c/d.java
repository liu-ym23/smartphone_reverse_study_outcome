package t6c;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.tangram.engine.TangramNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements t6c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6c.c f544843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f544844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f544847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s6c.a f544848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f<s6c.a> f544849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f544850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f544851i;

    public static final class a {
    }

    public interface b {
        void a();

        void b(q6c.c r100);
    }

    static {
    }

    public final void f() {
        View r100 = this.f544851i;
        if (r100 != null) goto L9;
        b r101 = this.f544844b;
        if (r101 == null) goto L14;
        r101.a();
        return;
    L14:
        return;
    L9:
        if (this.f544849g.f544853a.f540886g == false) goto L12;
        Intrinsics.checkNotNull(r100);
        r100.setVisibility(8);
        return;
    L12:
        Intrinsics.checkNotNull(r100);
        r100.setVisibility(0);
        int r102 = c.f544842a;
        f<s6c.a> r103 = this.f544849g;
        View r104 = this.f544851i;
        Intrinsics.checkNotNull(r104);
        c.a.a(r103, r104, false);
    }

    public final void g() {
        this.f544848f.i();
        LinkedList r100 = new LinkedList();
        r100.addAll(this.f544848f.f540888i);
    L4:
        if (r100.isEmpty() == true) goto L6;
        s6c.a r101 = (s6c.a) r100.removeFirst();
        r101.i();
        r100.addAll(r101.f540888i);
        goto L4
    }

    public final void j() {
        long r100 = this.f544848f.c(this.f544845c);
        i(this.f544848f, r100);
        float[] r101 = TangramNative.calculateLayout(r100, this.f544845c, this.f544846d);
        this.f544848f.j(new RectF(0.0f, 0.0f, r101[0], r101[1]));
        h(r100, this.f544848f);
        TangramNative.deepFreeNode(r100);
        TangramNative.hashMap.remove(this.f544848f.f540880a);
    }

    public final f<s6c.a> c() {
        j();
        s6c.a r100 = this.f544848f.b();
        int r101 = c.f544842a;
        f<s6c.a> r102 = c.a.b(r100);
        this.f544849g = r102;
        this.f544850h = r102.f544853a.a();
        return this.f544849g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(f r100) {
        s6c.b r101 = ((s6c.a) r100.f544853a).f540882c;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        Iterator r102 = r100.f544854b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        b((f) r102.next());
        goto L7
    }

    public static void e(s6c.a r100) {
        Iterator<s6c.a> r101 = r100.f540888i.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        s6c.a r102 = r101.next();
        r102.getClass();
        e(r102);
        goto L4
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        HashMap<Integer, WeakReference<d>> r101 = e.f544852a;
        WeakReference<d> r102 = r101.get(Integer.valueOf(r100.hashCode()));
        if (r102 == null) goto L5;
        d r103 = r102.get();
    L6:
        Objects.toString(r103);
        if (r103 == null) goto L9;
        r103.f544851i = null;
    L9:
        this.f544851i = r100;
        Intrinsics.checkNotNull(r100);
        r100.setTag(R.id.virtual_node_id, this.f544847e);
        r101.put(Integer.valueOf(r100.hashCode()), new WeakReference(this));
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t6c.b
    public void update(q6c.c r110) {
        Intrinsics.checkNotNullParameter(r110, "component");
        if (Intrinsics.areEqual(r110.getUniqueId(), this.f544848f.f540880a) == false) goto L5;
        r110.getStyle();
    L5:
        s6c.a r100 = r110.c();
        s6c.a r101 = this.f544848f;
        View r102 = null;
        if (Intrinsics.areEqual(r101.f540880a, r100.f540880a) == false) goto L8;
        s6c.a r103 = this.f544848f;
        this.f544848f = r100;
    L18:
        if (r103 != null) goto L24;
        b r104 = this.f544844b;
        if (r104 == null) goto L117;
        r104.b(r110);
        return;
    L117:
        return;
    L24:
        if (Intrinsics.areEqual(r103.f540880a, r100.f540880a) == true) goto L26;
    L28:
        d(r103, r100);
        this.f544849g = c();
        g();
        f<s6c.a> r105 = this.f544849g;
        String r111 = r110.getUniqueId();
        s6c.a r106 = r105.f544853a;
        if (Intrinsics.areEqual(r106.f540880a, r111) == false) goto L31;
    L64:
        f<s6c.a> r112 = r105;
    L65:
        View r107 = this.f544851i;
        if (r112 == null) goto L70;
        s6c.a r108 = r112.f544853a;
        if (r108 == null) goto L70;
        String r109 = r108.f540880a;
    L71:
        if (r109 == null) goto L91;
        if (r107 == null) goto L91;
        if (Intrinsics.areEqual(r107.getTag(R.id.virtual_node_id), r109) == false) goto L79;
    L77:
        r102 = r107;
        goto L91
    L79:
        if ((r107 instanceof ViewGroup) == false) goto L91;
        LinkedList r113 = new LinkedList();
        r113.add(r107);
    L82:
        if (r113.isEmpty() == true) goto L91;
        r107 = (View) r113.removeFirst();
        if (Intrinsics.areEqual(r107.getTag(R.id.virtual_node_id), r109) == true) goto L77;
        if ((r107 instanceof ViewGroup) == false) goto L82;
        ViewGroup r114 = (ViewGroup) r107;
        int r115 = r114.getChildCount();
        int r116 = 0;
    L89:
        if (r116 >= r115) goto L82;
        r113.add(r114.getChildAt(r116));
        r116 = r116 + 1;
    L91:
        if (r112 == null) goto L96;
        if (r102 == null) goto L96;
        int r117 = c.f544842a;
        c.a.a(r112, r102, true);
        return;
    L96:
        if (this.f544851i == null) goto L118;
        f();
        return;
    L118:
        return;
    L70:
        r109 = null;
        goto L71
    L31:
        if (r106.h() == true) goto L64;
        ArrayList<s6c.a> r118 = r106.f540888i;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L34:
        if (r120.hasNext() == false) goto L37;
        r119.add(((s6c.a) r120.next()).f540880a);
        goto L34
    L37:
        if (r119.contains(r111) == true) goto L64;
        ArrayList<s6c.a> r121 = r106.f540888i;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L40:
        if (r123.hasNext() == false) goto L43;
        r122.add(Boolean.valueOf(((s6c.a) r123.next()).h()));
        goto L40
    L43:
        if (r122.contains(Boolean.TRUE) == true) goto L64;
        ArrayList r124 = new ArrayList();
        r124.addAll(r105.f544854b);
        int r125 = 0;
    L47:
        if (r125 >= r124.size()) goto L63;
        ArrayList<f<TreeNode>> r126 = ((f) ListProtector.get(r124, r125)).f544854b;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L50:
        if (r128.hasNext() == false) goto L53;
        r127.add(((s6c.a) ((f) r128.next()).f544853a).f540880a);
        goto L50
    L53:
        if (r127.contains(r111) == true) goto L62;
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r130 = r126.iterator();
    L56:
        if (r130.hasNext() == false) goto L59;
        r129.add(Boolean.valueOf(((s6c.a) ((f) r130.next()).f544853a).h()));
        goto L56
    L59:
        if (r129.contains(Boolean.TRUE) == true) goto L62;
        r124.addAll(r126);
        r125 = r125 + 1;
    L62:
        r112 = (f) ListProtector.get(r124, r125);
        goto L65
    L63:
        r105 = null;
        goto L64
    L26:
        if (r100.g(r103) == true) goto L28;
        s6c.b.a r131 = r103.f540890k;
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        r100.f540890k = r131;
        s6c.b.a r132 = r103.f540889j;
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        r100.f540889j = r132;
        r100.j(r103.f540893n);
        r100.i();
        goto L28
    L8:
        LinkedList r133 = new LinkedList();
        r133.add(r101);
    L10:
        if (r133.isEmpty() == true) goto L17;
        s6c.a r134 = (s6c.a) r133.removeFirst();
        if (Intrinsics.areEqual(r134.f540880a, r100.f540880a) == true) goto L13;
        int r135 = r134.f540888i.size();
        int r136 = 0;
    L15:
        if (r136 >= r135) goto L10;
        r133.add(ListProtector.get(r134.f540888i, r136));
        r136 = r136 + 1;
        goto L15
    L13:
        s6c.a r137 = r134.b();
        Intrinsics.checkNotNullParameter(r100, "node");
        r134.f540884e = r100.f540884e;
        r134.j(r100.f540893n);
        r134.f540883d = r100.f540883d;
        r134.k(r100.f540894o);
        r134.f540886g = r100.f540886g;
        r134.f540882c = r100.f540882c;
        r134.f540891l = r100.f540891l;
        r134.f540889j = r100.f540889j;
        r134.f540890k = r100.f540890k;
        r134.f540888i = r100.f540888i;
        r100.h();
        r103 = r137;
        goto L18
    L17:
        r103 = null;
        goto L18
    }

    public static void d(s6c.a r100, s6c.a r101) {
        ArrayList<s6c.a> r102 = r100.f540888i;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(((s6c.a) r104.next()).f540880a);
        goto L4
    L6:
        int r105 = r101.f540888i.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L16;
        s6c.a r107 = (s6c.a) ListProtector.get(r101.f540888i, r106);
        if (r103.contains(r107.f540880a) == false) goto L14;
        int r108 = r103.indexOf(r107.f540880a);
        s6c.a r109 = (s6c.a) ListProtector.get(r100.f540888i, r108);
        if (r107.g(r109) == true) goto L13;
        r107.j(r109.f540893n);
        s6c.b.a r110 = r109.f540889j;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r107.f540889j = r110;
        s6c.b.a r111 = r109.f540890k;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r107.f540890k = r111;
        r107.i();
    L13:
        d(r109, r107);
    L15:
        r106 = r106 + 1;
        goto L7
    L14:
        e(r107);
        goto L15
    }

    public static void h(long r100, s6c.a r110) {
        long[] r101 = TangramNative.getNodeChildren(r100);
        int r111 = r101.length;
        int r102 = 0;
    L3:
        if (r102 >= r111) goto L5;
        float[] r103 = TangramNative.getNodeFrame(r101[r102]);
        ((s6c.a) ListProtector.get(r110.f540888i, r102)).j(new RectF(r103[0], r103[1], r103[2], r103[3]));
        h(r101[r102], (s6c.a) ListProtector.get(r110.f540888i, r102));
        TangramNative.hashMap.remove(((s6c.a) ListProtector.get(r110.f540888i, r102)).f540880a);
        r102 = r102 + 1;
        goto L3
    }

    public final void i(s6c.a r100, long r101) {
        int r102 = r100.f540888i.size();
        long[] r103 = new long[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = ((s6c.a) ListProtector.get(r100.f540888i, r104)).c(this.f544845c);
        i((s6c.a) ListProtector.get(r100.f540888i, r104), r103[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        TangramNative.setNodeChildren(r101, r103, r102);
    }

    public d(q6c.c r100, b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "rootComponent");
        this.f544843a = r100;
        this.f544844b = r101;
        this.f544845c = r102;
        this.f544846d = Integer.MAX_VALUE;
        this.f544847e = r100.getUniqueId();
        this.f544848f = r100.c();
        this.f544850h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        r100.getStyle();
        j();
        s6c.a r103 = this.f544848f.b();
        g();
        int r104 = c.f544842a;
        f<s6c.a> r105 = c.a.b(r103);
        this.f544849g = r105;
        this.f544850h = r105.f544853a.a();
    }
}
