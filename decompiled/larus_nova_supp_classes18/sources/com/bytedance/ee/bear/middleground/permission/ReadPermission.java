package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.PermissionDataV2;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ReadPermission {
    public static final Map<String, PermissionDataV2> e = null;
    public static final Map<String, List<ReadPermission>> f = null;
    public static final List<ReadPermission> g = null;
    public static final List<Pair<String, Integer>> h = null;
    public static long i;
    public static final Lazy<wh5.d> j = null;
    public static final Function0<Unit> k = null;
    public final String a;
    public final WeakReference<Function1<List<PermissionDataV2>, Unit>> b;
    public final Map<String, sbb.e> c;
    public final boolean d;

    public static final class a {
        public static final void a() {
            Map<String, PermissionDataV2> r0 = ReadPermission.e;
            if ((System.currentTimeMillis() - ReadPermission.i) <= 1000) goto L12;
            ReadPermission.i = System.currentTimeMillis();
            List<Pair<String, Integer>> r1 = ReadPermission.h;
            List r2 = CollectionsKt.take(r1, 10);
            if (r2.isEmpty() == true) goto L16;
            ArrayList r3 = (ArrayList) r1;
            r3.removeAll(r2);
            wh5.d r4 = (wh5.d) ReadPermission.j.getValue();
            Map r5 = MapsKt.toMap(r2);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "objs");
            int r6 = wh5.b.a;
            Intrinsics.checkNotNullParameter(r5, "objs");
            NetService.f r7 = new NetService.f("/space/api/suite/permission/objects/");
            ((NetService.e) r7).c = 1;
            JSONObject r8 = new JSONObject();
            JSONArray r9 = new JSONArray();
            Iterator r10 = MapsKt.toList(r5).iterator();
        L9:
            if (r10.hasNext() == false) goto L11;
            Pair r11 = (Pair) r10.next();
            JSONObject r12 = new JSONObject();
            r12.put(ResourceData.KEY_TOKEN, r11.getFirst());
            r12.put(ResourceData.KEY_TYPE, ((Number) r11.getSecond()).intValue());
            r9.put(r12);
            goto L9
        L11:
            r8.put("objs", r9);
            ((NetService.e) r7).j = r8.toString();
            ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new wh5.a()).a(r7).observeOn(fo5.d.d()).subscribe(d.a, new e(r2));
            return;
        L16:
            return;
        L12:
            Function0<Unit> r13 = ReadPermission.k;
            j.e(new c(r13));
            j.d(new c(r13), 1000);
        }

        public a() {
        }
    }

    public static final class b {
        public final sbb.e a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "FileInfo(documentType=" + this.a + ", objToken=" + this.b + ')';
        }

        public b(sbb.e r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "documentType");
            Intrinsics.checkNotNullParameter(r3, "objToken");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0 a;

        public c(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
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
        new a();
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new ArrayList();
        h = new ArrayList();
        j = LazyKt.lazy(ReadPermission$Companion$mPermissionExecutor$2.INSTANCE);
        k = ReadPermission$Companion$fetchDelayRunnable$1.INSTANCE;
    }

    public final void c() {
        tt5.a.h("ReadPermission", "clearAll: " + this.a);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r0.next();
        List r2 = (List) ((LinkedHashMap) f).get(r1.getKey());
        if (r2 == null) goto L8;
        r2.remove(this);
    L8:
        List r3 = r2;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L4;
        e.remove(r1.getKey());
        goto L4
    L11:
        if (r3.isEmpty() == true) goto L14;
        r4 = false;
        goto L15
    L17:
        ((LinkedHashMap) this.c).clear();
        ((ArrayList) g).remove(this);
    }

    private final void call(BatchDocUserPermission r9) {
        ArrayList r0 = new ArrayList();
        Map<String, Integer> r1 = r9.getPerms();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Integer>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, Integer> r4 = r3.next();
        if (this.c.containsKey(r4.getKey()) == false) goto L4;
        r2.put(r4.getKey(), r4.getValue());
        goto L4
    L8:
        Iterator r5 = r2.entrySet().iterator();
    L9:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L21;
        Map.Entry r7 = (Map.Entry) r5.next();
        PermissionDataV2 r8 = new PermissionDataV2();
        r8.setToken((String) r7.getKey());
        r8.setPermission(((Number) r7.getValue()).intValue());
        Integer r10 = r9.getPermissionV2().get(r7.getKey());
        if (r10 == null) goto L14;
        int r11 = r10.intValue();
    L15:
        r8.setPermission_v2(r11);
        DocUserPermission.a r12 = DocUserPermission.Companion;
        int r13 = r8.getPermission_v2();
        r12.getClass();
        if ((r13 & 1) != 0) goto L19;
        r6 = false;
    L19:
        r8.setReadAble(r6);
        e.put((String) r7.getKey(), r8);
        r0.add(r8);
        goto L9
    L14:
        r11 = 0;
        goto L15
    L21:
        if ((!r0.isEmpty()) == false) goto L34;
        Function1<List<PermissionDataV2>, Unit> r14 = this.b.get();
        if (r14 == null) goto L35;
        r14.invoke(r0);
        return;
    L35:
        return;
    }

    public final void b(List<b> r7) {
        Intrinsics.checkNotNullParameter(r7, "files");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L3:
        boolean r2 = true;
        if (r8.hasNext() == false) goto L30;
        b r1 = (b) r8.next();
        tt5.a.h("ReadPermission", "add: " + du5.d.a(r1.b));
        this.c.put(r1.b, r1.a);
        Map<String, List<ReadPermission>> r3 = f;
        Object r4 = ((LinkedHashMap) r3).get(r1.b);
        Collection r5 = (Collection) r4;
        if (r5 != null) goto L8;
    L11:
        if (r2 == false) goto L13;
        r4 = new ArrayList();
        r3.put(r1.b, (List<ReadPermission>) r4);
    L13:
        Iterator r6 = ((Iterable) r4).iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r9 = r6.next();
        if (Intrinsics.areEqual((ReadPermission) r9, this) == false) goto L15;
    L21:
        if (((ReadPermission) r9) != null) goto L24;
        ((List) r4).add(this);
    L24:
        if (this.d == false) goto L3;
        PermissionDataV2 r10 = (PermissionDataV2) ((LinkedHashMap) e).get(r1.b);
        if (r10 != null) goto L27;
        ((ArrayList) h).add(TuplesKt.to(r1.b, Integer.valueOf(r1.a.b)));
        Function0<Unit> r11 = k;
        j.e(new c(r11));
        j.d(new c(r11), 1000);
        goto L3
    L27:
        r0.add(r10);
        goto L3
    L19:
        r9 = null;
        goto L21
    L8:
        if (r5.isEmpty() == true) goto L11;
        r2 = false;
        goto L11
    L30:
        if ((!r0.isEmpty()) == false) goto L46;
        Function1<List<PermissionDataV2>, Unit> r12 = this.b.get();
        if (r12 == null) goto L47;
        r12.invoke(r0);
        return;
    L47:
        return;
    }

    public ReadPermission(String r2, WeakReference<Function1<List<PermissionDataV2>, Unit>> r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
        ((ArrayList) g).add(this);
        this.c = new LinkedHashMap();
        this.d = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.use_permission_manager", false);
    }

    public static final /* synthetic */ void a(ReadPermission r0, BatchDocUserPermission r1) {
        r0.call(r1);
    }

    public final void d(sbb.e r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        Intrinsics.checkNotNullParameter(r3, "objToken");
        this.c.remove(r3);
        if (this.c.isEmpty() == false) goto L17;
        List r4 = (List) ((LinkedHashMap) f).get(r3);
        if (r4 == null) goto L7;
        r4.remove(this);
    L7:
        List r5 = r4;
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L18;
        e.remove(r3);
        return;
    L18:
        return;
    L10:
        if (r5.isEmpty() == true) goto L13;
        r6 = false;
        goto L14
    }
}
