package com.bytedance.ee.bear.office.list;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeListPageMenuCapabilityRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeListPageMenuCapabilityRegistry f235547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<a, List<i>> f235548b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<a, WeakReference<Fragment>> f235549c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OfficeSpaceTab f235551b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f235550a, r101.f235550a) == true) goto L12;
            return false;
        L12:
            if (this.f235551b == r101.f235551b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f235550a.hashCode() * 31) + this.f235551b.hashCode();
        }

        public final String toString() {
            return "Key(runtimeId=" + this.f235550a + ", tab=" + this.f235551b + ')';
        }

        public a(String r100, OfficeSpaceTab r101) {
            Intrinsics.checkNotNullParameter(r100, "runtimeId");
            Intrinsics.checkNotNullParameter(r101, "tab");
            this.f235550a = r100;
            this.f235551b = r101;
        }
    }

    public OfficeListPageMenuCapabilityRegistry() {
    }

    static {
        f235547a = new OfficeListPageMenuCapabilityRegistry();
        f235548b = new ConcurrentHashMap();
        f235549c = new ConcurrentHashMap();
    }

    public static boolean c(i r100) {
        Fragment r101 = r100.a();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAdded() == true) goto L8;
        return false;
    L8:
        if (r101.getView() != null) goto L10;
        return false;
    L10:
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean d(i r100) {
        Fragment r101 = r100.a();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAdded() == true) goto L8;
        return false;
    L8:
        if (r101.getView() != null) goto L10;
        return false;
    L10:
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static String e(String r100) {
        if (r100 != null) goto L4;
    L8:
        return "__office_default_runtime__";
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L8;
        return r100;
    }

    public static String f(Fragment r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getClass().getSimpleName());
        r101.append('@');
        r101.append(System.identityHashCode(r100));
        r101.append(",added=");
        r101.append(r100.isAdded());
        r101.append(",hasView=");
        if (r100.getView() == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(",state=");
        r101.append(r100.getLifecycle().getCurrentState());
        return r101.toString();
    L5:
        r102 = false;
        goto L6
    }

    public static String g(String r100) {
        if (Intrinsics.areEqual(r100, "__office_default_runtime__") == false) goto L6;
        return "default";
    L6:
        return "hash=" + r100.hashCode();
    }

    public static i a(String r110, OfficeSpaceTab r111) {
        Intrinsics.checkNotNullParameter(r111, "tab");
        a r100 = new a(e(r110), r111);
        List<i> r101 = f235548b.get(r100);
        i r102 = null;
        String r103 = null;
        r103 = null;
        if (r101 != null) goto L6;
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "find page menu capability miss, reason=no_entries, runtime=" + g(r100.f235550a) + ", tab=" + r111);
        return null;
    L6:
        CollectionsKt.removeAll(r101, OfficeListPageMenuCapabilityRegistry$find$1.INSTANCE);
        WeakReference<Fragment> r104 = f235549c.get(r100);
        if (r104 == null) goto L9;
        Fragment r105 = r104.get();
    L10:
        if (r105 == null) goto L24;
        Iterator<T> r106 = r101.iterator();
    L13:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        i r108 = (i) r107;
        if (r108.a() != r105) goto L19;
        f235547a.getClass();
        if (c(r108) == false) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L13;
    L23:
        i r112 = (i) r107;
    L26:
        if (r112 != null) goto L49;
        if (r105 == null) goto L41;
        f235549c.remove(r100);
        ListIterator<i> r113 = r101.listIterator(r101.size());
    L30:
        if (r113.hasPrevious() == false) goto L34;
        i r114 = r113.previous();
        f235547a.getClass();
        if (c(r114) == false) goto L30;
    L35:
        r112 = r114;
        StringBuilder r115 = new StringBuilder("active owner mismatch, runtime=");
        r115.append(g(r100.f235550a));
        r115.append(", tab=");
        r115.append(r111);
        r115.append(", active=");
        r115.append(f(r105));
        r115.append(", fallback=");
        if (r112 == null) goto L40;
        Fragment r116 = r112.a();
        if (r116 == null) goto L40;
        r103 = f(r116);
    L40:
        r115.append(r103);
        r115.append(", size=");
        r115.append(r101.size());
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r115.toString());
        goto L49
    L34:
        r114 = null;
        goto L35
    L41:
        ListIterator<i> r117 = r101.listIterator(r101.size());
    L43:
        if (r117.hasPrevious() == false) goto L47;
        i r118 = r117.previous();
        f235547a.getClass();
        if (c(r118) == false) goto L43;
        r102 = r118;
    L47:
        r112 = r102;
    L49:
        if (r101.isEmpty() == false) goto L51;
        f235548b.remove(r100, r101);
        f235549c.remove(r100);
    L51:
        if (r112 != null) goto L58;
        StringBuilder r119 = new StringBuilder("find page menu capability miss, reason=no_active_owner, runtime=");
        r119.append(g(r100.f235550a));
        r119.append(", tab=");
        r119.append(r111);
        r119.append(", active=");
        if (r105 == null) goto L56;
        String r120 = f(r105);
        if (r120 == null) goto L56;
    L57:
        r119.append(r120);
        r119.append(", entries=");
        r119.append(CollectionsKt.joinToString$default(r101, null, null, null, 0, null, OfficeListPageMenuCapabilityRegistry$find$2.INSTANCE, 31, null));
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r119.toString());
    L56:
        r120 = "null";
    L58:
        return r112;
    L19:
        r109 = false;
        goto L20
    L22:
        r107 = null;
        goto L23
    L24:
        r112 = null;
        goto L26
    L9:
        r105 = null;
        goto L10
    }

    public static i b(String r100, OfficeSpaceTab r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r101, "tab");
        if (r102 == null) goto L5;
        a r103 = new a(e(r100), r101);
        ConcurrentHashMap<a, List<i>> r104 = f235548b;
        List<i> r105 = r104.get(r103);
        if (r105 != null) goto L9;
        return null;
    L9:
        CollectionsKt.removeAll(r105, OfficeListPageMenuCapabilityRegistry$find$3.INSTANCE);
        if (r105.isEmpty() == false) goto L13;
        r104.remove(r103, r105);
        f235549c.remove(r103);
        return null;
    L13:
        List<i> r106 = r105;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (((i) r108).a() != r102) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L15;
    L23:
        i r110 = (i) r108;
        if (r110 == null) goto L29;
        f235547a.getClass();
        if (d(r110) == true) goto L28;
        return null;
    L28:
        return r110;
    L29:
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r106.iterator();
    L31:
        if (r112.hasNext() == false) goto L36;
        Object r113 = r112.next();
        f235547a.getClass();
        if (d((i) r113) == false) goto L31;
        r111.add(r113);
        goto L31
    L36:
        return (i) CollectionsKt.singleOrNull(r111);
    L19:
        r109 = false;
        goto L20
    L22:
        r108 = null;
        goto L23
    L5:
        return a(r100, r101);
    }

    public static void h(String r100, OfficeSpaceTab r110, final Fragment r111) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "ownerFragment");
        a r101 = new a(e(r100), r110);
        ConcurrentHashMap<a, List<i>> r102 = f235548b;
        List<i> r103 = r102.get(r101);
        if (r103 != null) goto L5;
        return;
    L5:
        CollectionsKt.removeAll(r103, new OfficeListPageMenuCapabilityRegistry$unregister$1(r111));
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "unregister page menu owner, runtime=" + g(r101.f235550a) + ", tab=" + r110 + ", owner=" + f(r111) + ", remaining=" + r103.size());
        if (r103.isEmpty() == false) goto L8;
        r102.remove(r101, r103);
    L8:
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "ownerFragment");
        a r104 = new a(e(r100), r110);
        ConcurrentHashMap<a, WeakReference<Fragment>> r105 = f235549c;
        WeakReference<Fragment> r106 = r105.get(r104);
        if (r106 == null) goto L11;
        Fragment r107 = r106.get();
    L12:
        if (r107 != r111) goto L15;
        r105.remove(r104);
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "deactivate page menu owner, runtime=" + g(r104.f235550a) + ", tab=" + r110 + ", owner=" + f(r111));
        return;
    L15:
        return;
    L11:
        r107 = null;
        goto L12
    }
}
