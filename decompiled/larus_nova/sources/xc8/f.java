package xc8;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListAdapter;
import com.larus.list.arch.IFlowListCell;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vd9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f563237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f563238b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<g> f563239c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f563240d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends IFlowListCell<?>> f563241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f563242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final hi9.a<? extends ei9.f> f563243c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f563241a, r101.f563241a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f563242b, r101.f563242b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f563243c, r101.f563243c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f563241a.hashCode() * 31) + this.f563242b.hashCode()) * 31;
            hi9.a<? extends ei9.f> r101 = this.f563243c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CellInfo(cellClazz=" + this.f563241a + ", stateTransformer=" + this.f563242b + ", matcher=" + this.f563243c + ')';
        }

        public a(Class<? extends IFlowListCell<?>> r100, g r101, hi9.a<? extends ei9.f> r102) {
            Intrinsics.checkNotNullParameter(r100, "cellClazz");
            Intrinsics.checkNotNullParameter(r101, "stateTransformer");
            this.f563241a = r100;
            this.f563242b = r101;
            this.f563243c = r102;
        }
    }

    public f() {
    }

    static {
        z2.f365865a.m0();
        f563237a = new CopyOnWriteArraySet();
        f563238b = new CopyOnWriteArrayList();
        f563239c = new CopyOnWriteArrayList();
        f563240d = LazyKt.lazy(new d());
    }

    @Deprecated(message = "Don't use this directly")
    public static List b() {
        CopyOnWriteArraySet<a> r100 = f563237a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<a> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(r102.next().f563242b);
        goto L4
    L7:
        return new ArrayList(CollectionsKt.plus(r101, f563239c));
    }

    public static void a(m1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Iterator<a> r101 = f563238b.iterator();
    L3:
        g r102 = null;
        if (r101.hasNext() == false) goto L8;
        a r103 = r101.next();
        if (Intrinsics.areEqual(r103.f563241a, r100.l1()) == false) goto L3;
    L9:
        if (r103 != null) goto L18;
        ei9.g<? extends Object, ? extends ei9.f> r104 = r100.N();
        if ((r104 instanceof i) == false) goto L13;
        i r105 = (i) r104;
    L14:
        if (r105 == null) goto L18;
        g r106 = r105.f563244a;
        if (r106 == null) goto L18;
        f563238b.add(new a(r100.l1(), r106, r100.getMatcher()));
        goto L18
    L13:
        r105 = null;
    L18:
        ei9.g<? extends Object, ? extends ei9.f> r107 = r100.N();
        if ((r107 instanceof i) == false) goto L21;
        i r108 = (i) r107;
    L22:
        if (r108 == null) goto L40;
        g r109 = r108.f563244a;
        if (r109 == null) goto L41;
        Iterator<g> r110 = f563239c.iterator();
    L27:
        if (r110.hasNext() == false) goto L31;
        g r111 = r110.next();
        if (r111.getClass().isInstance(r109) == false) goto L27;
        r102 = r111;
    L31:
        if (r102 != null) goto L42;
        f563239c.add(r109);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L21:
        r108 = null;
        goto L22
    L8:
        r103 = null;
        goto L9
    }

    public static g c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        List r101 = b();
        if (AppHost.f326268a.isDebug() == false) goto L25;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = ((ArrayList) r101).iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        Integer r105 = Integer.valueOf(((g) r104).c());
        Object r106 = r102.get(r105);
        if (r106 != null) goto L10;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L10:
        ((List) r106).add(r104);
        goto L6
    L11:
        Iterator r107 = r102.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L25;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (((List) r108.getValue()).size() <= 1) goto L13;
        HashSet r109 = new HashSet();
        Iterable r110 = (Iterable) r108.getValue();
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L18:
        if (r112.hasNext() == false) goto L20;
        r111.add(((g) r112.next()).getClass().getSimpleName());
        goto L18
    L20:
        r109.addAll(r111);
        if (r109.size() <= 1) goto L13;
        throw new RuntimeException("dangerous, transformerType" + ((Number) r108.getKey()).intValue() + ",contain " + ((List) r108.getValue()).size() + " times, dangerous!" + HttpExtKt.p(r109));
    L25:
        Iterator r113 = ((ArrayList) r101).iterator();
    L27:
        if (r113.hasNext() == false) goto L36;
        Object r114 = r113.next();
        g r115 = (g) r114;
        if (r115.a(r100) == true) goto L31;
    L33:
        boolean r116 = false;
    L34:
        if (r116 == false) goto L27;
    L38:
        return (g) r114;
    L31:
        if ((r115 instanceof zc8.b) == true) goto L33;
        r116 = true;
        goto L34
    L36:
        r114 = null;
        goto L38
    }

    public static void d(FlowListAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Iterator<a> r101 = f563237a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = r101.next();
        ei9.e.a(r100, r102.f563241a, r102.f563242b, r102.f563243c);
        goto L4
    L6:
        Iterator<a> r103 = f563238b.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        a r104 = r103.next();
        ei9.e.a(r100, r104.f563241a, r104.f563242b, r104.f563243c);
        goto L8
    }

    public static /* synthetic */ b f(Message r100) {
        return e(r100, new e());
    }

    public static b e(Message r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "extraAction");
        ei9.g r102 = c(r100);
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L5;
    L9:
        if (r102 == null) goto L14;
        b r103 = (b) r102.b(r100);
        if (r103 == null) goto L14;
        r101.invoke(r103);
        return r103;
    L14:
        return new zc8.a(r100);
    L5:
        if (com.larus.im.bean.message.a.b0(r100) == false) goto L9;
        z2 r104 = z2.f365865a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r104.a4(r.a(r100)) == true) goto L9;
        r102 = new zc8.b();
        goto L9
    }
}
