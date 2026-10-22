package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.PermissionDataV2;
import com.bytedance.ee.util.ui.j;
import com.bytedance.keva.KevaImpl;
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

/* JADX INFO: loaded from: classes18.dex */
public final class ReadPermission {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, PermissionDataV2> f232831e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, List<ReadPermission>> f232832f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<ReadPermission> f232833g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<Pair<String, Integer>> f232834h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f232835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<wh5.d> f232836j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Function0<Unit> f232837k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Function1<List<PermissionDataV2>, Unit>> f232839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, sbb.e> f232840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f232841d;

    public static final class a {
        public static final void a() {
            Map<String, PermissionDataV2> r100 = ReadPermission.f232831e;
            if ((System.currentTimeMillis() - ReadPermission.f232835i) <= 1000) goto L12;
            ReadPermission.f232835i = System.currentTimeMillis();
            List<Pair<String, Integer>> r101 = ReadPermission.f232834h;
            List r102 = CollectionsKt.take(r101, 10);
            if (r102.isEmpty() == true) goto L16;
            ArrayList r103 = (ArrayList) r101;
            r103.removeAll(r102);
            wh5.d r104 = ReadPermission.f232836j.getValue();
            Map r105 = MapsKt.toMap(r102);
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "objs");
            int r106 = wh5.b.f559668a;
            Intrinsics.checkNotNullParameter(r105, "objs");
            NetService.f r107 = new NetService.f("/space/api/suite/permission/objects/");
            r107.f216906c = 1;
            JSONObject r108 = new JSONObject();
            JSONArray r109 = new JSONArray();
            Iterator r110 = MapsKt.toList(r105).iterator();
        L9:
            if (r110.hasNext() == false) goto L11;
            Pair r111 = (Pair) r110.next();
            JSONObject r112 = new JSONObject();
            r112.put("token", r111.getFirst());
            r112.put("type", ((Number) r111.getSecond()).intValue());
            r109.put(r112);
            goto L9
        L11:
            r108.put("objs", r109);
            r107.f216913j = r108.toString();
            ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new wh5.a()).a(r107).observeOn(fo5.d.d()).subscribe(d.f233828a, new e(r102));
            return;
        L16:
            return;
        L12:
            Function0<Unit> r113 = ReadPermission.f232837k;
            j.e(new c(r113));
            j.d(new c(r113), 1000);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sbb.e f232842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f232843b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f232842a, r101.f232842a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f232843b, r101.f232843b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f232842a.hashCode() * 31) + this.f232843b.hashCode();
        }

        public final String toString() {
            return "FileInfo(documentType=" + this.f232842a + ", objToken=" + this.f232843b + ')';
        }

        public b(sbb.e r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "documentType");
            Intrinsics.checkNotNullParameter(r101, "objToken");
            this.f232842a = r100;
            this.f232843b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f232844a;

        public c(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f232844a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f232844a.invoke();     // Catch: Throwable -> L4
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
        f232831e = new LinkedHashMap();
        f232832f = new LinkedHashMap();
        f232833g = new ArrayList();
        f232834h = new ArrayList();
        f232836j = LazyKt.lazy(ReadPermission$Companion$mPermissionExecutor$2.INSTANCE);
        f232837k = ReadPermission$Companion$fetchDelayRunnable$1.INSTANCE;
    }

    public final void c() {
        tt5.a.h("ReadPermission", "clearAll: " + this.f232838a);
        Iterator r100 = ((LinkedHashMap) this.f232840c).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        Map.Entry r101 = (Map.Entry) r100.next();
        List r102 = (List) ((LinkedHashMap) f232832f).get(r101.getKey());
        if (r102 == null) goto L8;
        r102.remove(this);
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L4;
        f232831e.remove(r101.getKey());
        goto L4
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    L17:
        ((LinkedHashMap) this.f232840c).clear();
        ((ArrayList) f232833g).remove(this);
    }

    private final void call(BatchDocUserPermission r100) {
        ArrayList r101 = new ArrayList();
        Map<String, Integer> r102 = r100.getPerms();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, Integer>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, Integer> r105 = r104.next();
        if (this.f232840c.containsKey(r105.getKey()) == false) goto L4;
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L8:
        Iterator r106 = r103.entrySet().iterator();
    L9:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L21;
        Map.Entry r108 = (Map.Entry) r106.next();
        PermissionDataV2 r109 = new PermissionDataV2();
        r109.setToken((String) r108.getKey());
        r109.setPermission(((Number) r108.getValue()).intValue());
        Integer r110 = r100.getPermissionV2().get(r108.getKey());
        if (r110 == null) goto L14;
        int r111 = r110.intValue();
    L15:
        r109.setPermission_v2(r111);
        DocUserPermission.a r112 = DocUserPermission.Companion;
        int r113 = r109.getPermission_v2();
        r112.getClass();
        if ((r113 & 1) != 0) goto L19;
        r107 = false;
    L19:
        r109.setReadAble(r107);
        f232831e.put((String) r108.getKey(), r109);
        r101.add(r109);
        goto L9
    L14:
        r111 = 0;
        goto L15
    L21:
        if ((!r101.isEmpty()) == false) goto L34;
        Function1<List<PermissionDataV2>, Unit> r114 = this.f232839b.get();
        if (r114 == null) goto L35;
        r114.invoke(r101);
        return;
    L35:
        return;
    }

    public final void b(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L30;
        b r104 = (b) r102.next();
        tt5.a.h("ReadPermission", "add: " + du5.d.a(r104.f232843b));
        this.f232840c.put(r104.f232843b, r104.f232842a);
        Map<String, List<ReadPermission>> r105 = f232832f;
        Object r106 = ((LinkedHashMap) r105).get(r104.f232843b);
        Collection r107 = (Collection) r106;
        if (r107 != null) goto L8;
    L11:
        if (r103 == false) goto L13;
        r106 = new ArrayList();
        r105.put(r104.f232843b, (List<ReadPermission>) r106);
    L13:
        Iterator r108 = ((Iterable) r106).iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (Intrinsics.areEqual((ReadPermission) r109, this) == false) goto L15;
    L21:
        if (((ReadPermission) r109) != null) goto L24;
        ((List) r106).add(this);
    L24:
        if (this.f232841d == false) goto L3;
        PermissionDataV2 r110 = (PermissionDataV2) ((LinkedHashMap) f232831e).get(r104.f232843b);
        if (r110 != null) goto L27;
        ((ArrayList) f232834h).add(TuplesKt.to(r104.f232843b, Integer.valueOf(r104.f232842a.f541317b)));
        Function0<Unit> r111 = f232837k;
        j.e(new c(r111));
        j.d(new c(r111), 1000);
        goto L3
    L27:
        r101.add(r110);
        goto L3
    L19:
        r109 = null;
        goto L21
    L8:
        if (r107.isEmpty() == true) goto L11;
        r103 = false;
        goto L11
    L30:
        if ((!r101.isEmpty()) == false) goto L46;
        Function1<List<PermissionDataV2>, Unit> r112 = this.f232839b.get();
        if (r112 == null) goto L47;
        r112.invoke(r101);
        return;
    L47:
        return;
    }

    public ReadPermission(String r100, WeakReference<Function1<List<PermissionDataV2>, Unit>> r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f232838a = r100;
        this.f232839b = r101;
        ((ArrayList) f232833g).add(this);
        this.f232840c = new LinkedHashMap();
        this.f232841d = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.use_permission_manager", false);
    }

    public static final /* synthetic */ void a(ReadPermission r100, BatchDocUserPermission r101) {
        r100.call(r101);
    }

    public final void d(sbb.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "documentType");
        Intrinsics.checkNotNullParameter(r101, "objToken");
        this.f232840c.remove(r101);
        if (this.f232840c.isEmpty() == false) goto L17;
        List r102 = (List) ((LinkedHashMap) f232832f).get(r101);
        if (r102 == null) goto L7;
        r102.remove(this);
    L7:
        List r103 = r102;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L18;
        f232831e.remove(r101);
        return;
    L18:
        return;
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
        goto L14
    }
}
