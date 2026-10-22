package com.larus.bmhome.clarification;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f310529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, LinkedHashSet<String>> f310530b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, LinkedHashSet<String>> f310531c = null;

    public h() {
    }

    static {
        f310529a = new h();
        f310530b = new LinkedHashMap();
        f310531c = new LinkedHashMap();
    }

    public static LinkedHashSet d(String r100) {
        String r101 = AccountService.f365697a.getUserId();
        if (StringsKt.isBlank(r101) == false) goto L6;
        r101 = "anonymous";
    L6:
        if (Intrinsics.areEqual(r100, "consumed_identifiers") == false) goto L9;
        Map<String, LinkedHashSet<String>> r102 = f310530b;
    L11:
        LinkedHashSet<String> r103 = r102.get(r101);
        if (r103 != null) goto L24;
        String[] r104 = Keva.getRepo("auto_route_clarification_".concat(r101), 0).getStringArray(r100, new String[0]);
        if (r104 != null) goto L16;
        r104 = new String[0];
    L16:
        List r105 = ArraysKt.filterNotNull(r104);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if ((!StringsKt.isBlank((String) r108)) == false) goto L18;
        r106.add(r108);
        goto L18
    L22:
        r103 = new LinkedHashSet(CollectionsKt.takeLast(r106, 200));
        r102.put(r101, r103);
    L24:
        return r103;
    L9:
        if (Intrinsics.areEqual(r100, "discarded_answer_identifiers") == false) goto L26;
        r102 = f310531c;
        goto L11
    L26:
        throw new IllegalStateException("Unsupported AutoRoute clarification store key: ".concat(r100).toString());
    }

    public final synchronized boolean c(Collection<String> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "identifiers");     // Catch: Throwable -> L6
        boolean r101 = b("discarded_answer_identifiers", r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(Collection<String> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "identifiers");     // Catch: Throwable -> L6
        a("consumed_identifiers", r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void a(String r100, Collection r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        if ((!StringsKt.isBlank((String) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        if (r102.isEmpty() == false) goto L11;
        return;
    L11:
        LinkedHashSet r105 = d(r100);
        r105.addAll(r102);
    L13:
        if (r105.size() <= 200) goto L18;
        Iterator r106 = r105.iterator();
        if (r106.hasNext() == false) goto L18;
        r106.next();
        r106.remove();
    L18:
        String r107 = AccountService.f365697a.getUserId();
        if (StringsKt.isBlank(r107) == false) goto L21;
        r107 = "anonymous";
    L21:
        Keva.getRepo("auto_route_clarification_".concat(r107), 0).storeStringArray(r100, (String[]) r105.toArray(new String[0]));
    }

    public static boolean b(String r100, Collection r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        if ((true ^ StringsKt.isBlank((String) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        if (r102.isEmpty() == false) goto L12;
        return false;
    L12:
        if (r102.isEmpty() == true) goto L20;
        Iterator r105 = r102.iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        String r106 = (String) r105.next();
        if (d(r100).contains(r106) == false) goto L16;
        return true;
    L20:
        return false;
    }
}
