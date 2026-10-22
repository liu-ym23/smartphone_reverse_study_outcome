package rdc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.widget.photopicker.s f537379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f537380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t> f537381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f537382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f537383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f537384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Pair<Integer, Integer>> f537385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Integer> f537386h;

    public final List<t> a() {
        ArrayList r100 = new ArrayList(this.f537381c);
        b(r100);
        return r100;
    }

    public s(com.ss.android.lark.widget.photopicker.s r100) {
        Intrinsics.checkNotNullParameter(r100, "pickerParams");
        this.f537379a = r100;
        this.f537380b = new CopyOnWriteArrayList();
        this.f537381c = new CopyOnWriteArrayList();
        this.f537382d = r100.f447569n;
        this.f537384f = new ConcurrentHashMap();
        this.f537385g = new ConcurrentHashMap();
        this.f537386h = new ConcurrentHashMap();
    }

    public final void b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L66;
        t r102 = (t) r101.next();
        boolean r103 = ((CopyOnWriteArrayList) this.f537380b).contains(r102.f447736a);
        boolean r104 = r102.f537388m;
        if (r103 == r104) goto L8;
        r102.f537388m = !r104;
    L8:
        int r105 = ((CopyOnWriteArrayList) this.f537380b).size();
        com.ss.android.lark.widget.photopicker.s r106 = this.f537379a;
        boolean r107 = false;
        if (r105 != r106.f447558c) goto L11;
        boolean r108 = true;
    L13:
        if (r106.f447561f == true) goto L15;
    L19:
        boolean r109 = false;
    L20:
        if (r108 == true) goto L23;
        if (r109 == true) goto L23;
    L25:
        boolean r110 = false;
    L26:
        r102.f537390o = r110;
        r102.f537391p = this.f537383e;
        if (r102.f537388m == false) goto L29;
        String r111 = String.valueOf(((CopyOnWriteArrayList) this.f537380b).indexOf(r102.f447736a) + 1);
    L31:
        if (TextUtils.equals(r102.f537387l, r111) == true) goto L34;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r102.f537387l = r111;
    L34:
        if (((CopyOnWriteArrayList) this.f537380b).isEmpty() == false) goto L39;
        if (this.f537379a.f447560e == true) goto L39;
    L52:
        if (r102.f537389n == r107) goto L54;
        r102.f537389n = r107;
    L54:
        String r112 = String.valueOf(r102.f447736a);
        if (((ConcurrentHashMap) this.f537384f).containsKey(r112) == true) goto L57;
    L60:
        Pair r113 = (Pair) ((ConcurrentHashMap) this.f537385g).get(r112);
        if (r113 == null) goto L63;
        r102.f447740e = ((Number) r113.getFirst()).intValue();
        r102.f447741f = ((Number) r113.getSecond()).intValue();
    L63:
        Integer r114 = (Integer) ((ConcurrentHashMap) this.f537386h).get(r112);
        if (r114 == null) goto L4;
        r102.f447743h = r114.intValue();
        goto L4
    L57:
        if (TextUtils.isEmpty(r102.f537392q) == false) goto L59;
        r102.f537392q = r102.f447737b;
    L59:
        r102.f447737b = (String) ((ConcurrentHashMap) this.f537384f).get(r112);
    L39:
        if (((CopyOnWriteArrayList) this.f537380b).contains(r102.f447736a) == true) goto L52;
        if (this.f537379a.f447557b != 3) goto L52;
        if (this.f537383e == true) goto L47;
        r107 = r102.a();
        goto L52
    L47:
        if (this.f537379a.f447561f == false) goto L49;
    L50:
        r107 = true;
        goto L52
    L49:
        if (r102.a() == true) goto L52;
    L29:
        r111 = "";
    L23:
        if (((CopyOnWriteArrayList) this.f537380b).contains(r102.f447736a) == true) goto L25;
        r110 = true;
        goto L26
    L15:
        if (((CopyOnWriteArrayList) this.f537380b).size() != 1) goto L19;
        if (this.f537383e == false) goto L19;
        r109 = true;
        goto L20
    L11:
        r108 = false;
        goto L13
    }

    public final void c(t r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "photo");
        if (r101 == false) goto L7;
        List<Integer> r102 = this.f537380b;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        if (r103.contains(r100.f447736a) == true) goto L13;
        List<Integer> r104 = this.f537380b;
        CopyOnWriteArrayList r105 = (CopyOnWriteArrayList) r104;
        r105.add(r100.f447736a);
        ((CopyOnWriteArrayList) this.f537381c).add(r100);
        return;
    L13:
        return;
    L7:
        List<Integer> r106 = this.f537380b;
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) r106;
        r107.remove(r100.f447736a);
        int r108 = this.f537381c.size();
        int r109 = 0;
    L8:
        if (r109 >= r108) goto L18;
        if (Intrinsics.areEqual(((t) ListProtector.get(this.f537381c, r109)).f447736a, r100.f447736a) == true) goto L11;
        r109 = r109 + 1;
        goto L8
    L11:
        ListProtector.remove(this.f537381c, r109);
        return;
    }
}
