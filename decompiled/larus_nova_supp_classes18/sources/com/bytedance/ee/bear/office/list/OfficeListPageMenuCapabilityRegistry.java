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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeListPageMenuCapabilityRegistry {
    public static final OfficeListPageMenuCapabilityRegistry a = null;
    public static final ConcurrentHashMap<a, List<i>> b = null;
    public static final ConcurrentHashMap<a, WeakReference<Fragment>> c = null;

    public static final class a {
        public final String a;
        public final OfficeSpaceTab b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Key(runtimeId=" + this.a + ", tab=" + this.b + ')';
        }

        public a(String r2, OfficeSpaceTab r3) {
            Intrinsics.checkNotNullParameter(r2, "runtimeId");
            Intrinsics.checkNotNullParameter(r3, "tab");
            this.a = r2;
            this.b = r3;
        }
    }

    public OfficeListPageMenuCapabilityRegistry() {
    }

    static {
        a = new OfficeListPageMenuCapabilityRegistry();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static boolean c(i r2) {
        Fragment r3 = r2.a();
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAdded() == true) goto L8;
        return false;
    L8:
        if (r3.getView() != null) goto L10;
        return false;
    L10:
        if (r3.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean d(i r2) {
        Fragment r3 = r2.a();
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAdded() == true) goto L8;
        return false;
    L8:
        if (r3.getView() != null) goto L10;
        return false;
    L10:
        if (r3.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static String e(String r1) {
        if (r1 != null) goto L4;
    L8:
        return "__office_default_runtime__";
    L4:
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L8;
        return r1;
    }

    public static String f(Fragment r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getClass().getSimpleName());
        r0.append('@');
        r0.append(System.identityHashCode(r2));
        r0.append(",added=");
        r0.append(r2.isAdded());
        r0.append(",hasView=");
        if (r2.getView() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(",state=");
        r0.append(r2.getLifecycle().getCurrentState());
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public static String g(String r2) {
        if (Intrinsics.areEqual(r2, "__office_default_runtime__") == false) goto L6;
        return "default";
    L6:
        return "hash=" + r2.hashCode();
    }

    public static i a(String r18, OfficeSpaceTab r19) {
        Intrinsics.checkNotNullParameter(r19, "tab");
        a r1 = new a(e(r18), r19);
        List<i> r2 = b.get(r1);
        i r5 = null;
        String r6 = null;
        r6 = null;
        if (r2 != null) goto L6;
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "find page menu capability miss, reason=no_entries, runtime=" + g(r1.a) + ", tab=" + r19);
        return null;
    L6:
        CollectionsKt.removeAll(r2, OfficeListPageMenuCapabilityRegistry$find$1.INSTANCE);
        WeakReference<Fragment> r7 = c.get(r1);
        if (r7 == null) goto L9;
        Fragment r8 = r7.get();
    L10:
        if (r8 == null) goto L24;
        Iterator<T> r9 = r2.iterator();
    L13:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        i r11 = (i) r10;
        if (r11.a() != r8) goto L19;
        a.getClass();
        if (c(r11) == false) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L13;
    L23:
        i r13 = (i) r10;
    L26:
        if (r13 != null) goto L49;
        if (r8 == null) goto L41;
        c.remove(r1);
        ListIterator<i> r14 = r2.listIterator(r2.size());
    L30:
        if (r14.hasPrevious() == false) goto L34;
        i r15 = r14.previous();
        a.getClass();
        if (c(r15) == false) goto L30;
    L35:
        r13 = r15;
        StringBuilder r16 = new StringBuilder("active owner mismatch, runtime=");
        r16.append(g(r1.a));
        r16.append(", tab=");
        r16.append(r19);
        r16.append(", active=");
        r16.append(f(r8));
        r16.append(", fallback=");
        if (r13 == null) goto L40;
        Fragment r17 = r13.a();
        if (r17 == null) goto L40;
        r6 = f(r17);
    L40:
        r16.append(r6);
        r16.append(", size=");
        r16.append(r2.size());
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r16.toString());
        goto L49
    L34:
        r15 = null;
        goto L35
    L41:
        ListIterator<i> r20 = r2.listIterator(r2.size());
    L43:
        if (r20.hasPrevious() == false) goto L47;
        i r21 = r20.previous();
        a.getClass();
        if (c(r21) == false) goto L43;
        r5 = r21;
    L47:
        r13 = r5;
    L49:
        if (r2.isEmpty() == false) goto L51;
        b.remove(r1, r2);
        c.remove(r1);
    L51:
        if (r13 != null) goto L58;
        StringBuilder r22 = new StringBuilder("find page menu capability miss, reason=no_active_owner, runtime=");
        r22.append(g(r1.a));
        r22.append(", tab=");
        r22.append(r19);
        r22.append(", active=");
        if (r8 == null) goto L56;
        String r0 = f(r8);
        if (r0 == null) goto L56;
    L57:
        r22.append(r0);
        r22.append(", entries=");
        r22.append(CollectionsKt.joinToString$default(r2, null, null, null, 0, null, OfficeListPageMenuCapabilityRegistry$find$2.INSTANCE, 31, null));
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r22.toString());
    L56:
        r0 = "null";
    L58:
        return r13;
    L19:
        r12 = false;
        goto L20
    L22:
        r10 = null;
        goto L23
    L24:
        r13 = null;
        goto L26
    L9:
        r8 = null;
        goto L10
    }

    public static i b(String r3, OfficeSpaceTab r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        if (r5 == null) goto L5;
        a r0 = new a(e(r3), r4);
        ConcurrentHashMap<a, List<i>> r6 = b;
        List<i> r7 = r6.get(r0);
        if (r7 != null) goto L9;
        return null;
    L9:
        CollectionsKt.removeAll(r7, OfficeListPageMenuCapabilityRegistry$find$3.INSTANCE);
        if (r7.isEmpty() == false) goto L13;
        r6.remove(r0, r7);
        c.remove(r0);
        return null;
    L13:
        List<i> r8 = r7;
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L22;
        Object r1 = r9.next();
        if (((i) r1).a() != r5) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L15;
    L23:
        i r10 = (i) r1;
        if (r10 == null) goto L29;
        a.getClass();
        if (d(r10) == true) goto L28;
        return null;
    L28:
        return r10;
    L29:
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r8.iterator();
    L31:
        if (r12.hasNext() == false) goto L36;
        Object r13 = r12.next();
        a.getClass();
        if (d((i) r13) == false) goto L31;
        r11.add(r13);
        goto L31
    L36:
        return (i) CollectionsKt.singleOrNull(r11);
    L19:
        r2 = false;
        goto L20
    L22:
        r1 = null;
        goto L23
    L5:
        return a(r3, r4);
    }

    public static void h(String r9, OfficeSpaceTab r10, final Fragment r11) {
        Intrinsics.checkNotNullParameter(r10, "tab");
        Intrinsics.checkNotNullParameter(r11, "ownerFragment");
        a r2 = new a(e(r9), r10);
        ConcurrentHashMap<a, List<i>> r3 = b;
        List<i> r4 = r3.get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        CollectionsKt.removeAll(r4, new OfficeListPageMenuCapabilityRegistry$unregister$1(r11));
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "unregister page menu owner, runtime=" + g(r2.a) + ", tab=" + r10 + ", owner=" + f(r11) + ", remaining=" + r4.size());
        if (r4.isEmpty() == false) goto L8;
        r3.remove(r2, r4);
    L8:
        Intrinsics.checkNotNullParameter(r10, "tab");
        Intrinsics.checkNotNullParameter(r11, "ownerFragment");
        a r0 = new a(e(r9), r10);
        ConcurrentHashMap<a, WeakReference<Fragment>> r12 = c;
        WeakReference<Fragment> r1 = r12.get(r0);
        if (r1 == null) goto L11;
        Fragment r5 = r1.get();
    L12:
        if (r5 != r11) goto L15;
        r12.remove(r0);
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "deactivate page menu owner, runtime=" + g(r0.a) + ", tab=" + r10 + ", owner=" + f(r11));
        return;
    L15:
        return;
    L11:
        r5 = null;
        goto L12
    }
}
