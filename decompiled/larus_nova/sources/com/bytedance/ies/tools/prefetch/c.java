package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f248793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, u> f248794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f248795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f248796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f248797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f248798f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f248799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f248800b;

        public a(c r100, Function0 r101) {
            this.f248799a = r100;
            this.f248800b = r101;
        }

        public final void a() {
            this.f248799a.f248794b.clear();
            c r100 = this.f248799a;
            List<String> r101 = r100.f248798f.a();
            r100.f248797e.execute(new d(r100, r101));
            this.f248799a.f248793a = true;
            p.b("ConfigManager initialized successfully.");
            this.f248800b.invoke();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.f
    public final Pair<Collection<a0>, SortedMap<String, String>> a(UriWrapper r210) {
        Iterator<Map.Entry<String, u>> r100 = this.f248794b.entrySet().iterator();
    L3:
        Pair<Collection<a0>, SortedMap<String, String>> r101 = null;
        if (r100.hasNext() == false) goto L97;
        u r102 = r100.next().getValue();
        if (r102.f248833d.isEmpty() == false) goto L8;
        Iterator<Map.Entry<String, u>> r110 = r100;
    L91:
        if (r101 == null) goto L95;
        if ((!r101.getFirst().isEmpty()) == false) goto L95;
        return r101;
    L95:
        r100 = r110;
        goto L3
    L8:
        ArrayList r103 = new ArrayList();
        r r104 = r102.f248831b;
        int r105 = 0;
        if (r104 == null) goto L45;
        String r111 = r210.f248774e;
        if (r104.f248827a.containsKey(r111) == false) goto L13;
        List<c0> r106 = r104.f248827a.get(r111);
    L27:
        if (r106 == null) goto L34;
        Iterator<T> r107 = r106.iterator();
    L30:
        if (r107.hasNext() == false) goto L34;
        List r112 = ((c0) r107.next()).a(r210);
        if (r112 == null) goto L30;
        Pair r108 = new Pair(r112, null);
    L35:
        if (r108 == null) goto L45;
        List r109 = (List) r108.getFirst();
        if (r109 == null) goto L45;
        Iterator r113 = r109.iterator();
    L40:
        if (r113.hasNext() == false) goto L45;
        a0 r114 = r102.f248833d.get((String) r113.next());
        if (r114 == null) goto L40;
        r103.add(r114);
    L34:
        r108 = null;
        goto L35
    L13:
        Uri r115 = r210.a();
        String r116 = r115.getPath();
        if (r116 == null) goto L18;
        List<c0> r117 = r104.f248827a.get(r116);
        if (r117 == null) goto L18;
        r106 = r117;
    L18:
        String r118 = r115.getPath();
        if (r118 != null) goto L23;
        r118 = "";
    L23:
        if (StringsKt.endsWith$default(r118, '/', false, 2, null) == false) goto L25;
        String r119 = StringsKt.substringBeforeLast$default(r118, '/', null, 2, null);
    L26:
        r106 = r104.f248827a.get(r119);
        goto L27
    L25:
        r119 = r118.concat(HTTP.URL_DEFAULT);
    L45:
        if (r103.isEmpty() == false) goto L89;
        b0 r120 = r102.f248832c;
        if (r120 == null) goto L89;
        Uri r121 = r210.a();
        String r122 = r210.f248774e;
        String r123 = r121.getPath();
        if (r123 == null) goto L74;
        Iterator<Map.Entry<String, c0>> r124 = r120.f248792a.entrySet().iterator();
    L52:
        if (r124.hasNext() == false) goto L74;
        Map.Entry<String, c0> r125 = r124.next();
        String r126 = r125.getKey();
        List<String> r127 = new Regex(HTTP.URL_DEFAULT).split(r123, r105);
        List<String> r128 = new Regex(HTTP.URL_DEFAULT).split(r126, r105);
        if (r127.size() != r128.size()) goto L67;
        TreeMap r129 = new TreeMap();
        int r130 = r127.size();
    L56:
        if (r105 >= r130) goto L66;
        String r131 = (String) ListProtector.get(r128, r105);
        r110 = r100;
        List<String> r132 = r128;
        Iterator<Map.Entry<String, c0>> r133 = r124;
        if (StringsKt.startsWith$default(r131, ":", false, 2, null) == false) goto L64;
        if (r131 == null) goto L62;
        r129.put(r131.substring(1), ListProtector.get(r127, r105));
    L65:
        r105 = r105 + 1;
        r124 = r133;
        r100 = r110;
        r128 = r132;
        goto L56
    L62:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L64:
        if (Intrinsics.areEqual((String) ListProtector.get(r127, r105), r131) == true) goto L65;
    L68:
        r129 = null;
    L69:
        if (r129 == null) goto L73;
        k r134 = p.f248826a;
        p.a("[scheme:" + r122 + "] match_result_rule:" + r125.getKey());
        List r135 = r125.getValue().a(r210);
        if (r135 == null) goto L73;
        Pair r136 = new Pair(r135, r129);
    L75:
        if (r136 == null) goto L85;
        List r137 = (List) r136.getFirst();
        if (r137 == null) goto L85;
        Iterator r138 = r137.iterator();
    L80:
        if (r138.hasNext() == false) goto L85;
        a0 r139 = r102.f248833d.get((String) r138.next());
        if (r139 == null) goto L80;
        r103.add(r139);
    L85:
        if (r136 == null) goto L87;
        SortedMap r140 = (SortedMap) r136.getSecond();
    L88:
        Pair<Collection<a0>, SortedMap<String, String>> r141 = new Pair(r103, r140);
    L90:
        r101 = r141;
        goto L91
    L87:
        r140 = null;
    L73:
        r124 = r133;
        r100 = r110;
        r105 = 0;
        goto L52
    L66:
        r110 = r100;
        r133 = r124;
        goto L69
    L67:
        r110 = r100;
        r133 = r124;
    L74:
        r110 = r100;
        r136 = null;
    L89:
        r110 = r100;
        r141 = new Pair(r103, null);
        goto L90
    L97:
        return null;
    }

    public final void b(Function0<Unit> r100) {
        if (this.f248793a == false) goto L6;
        r100.invoke();
        return;
    L6:
        this.f248797e.execute(new a(this, r100));
    }

    public c(Executor r100, g r101) {
        this.f248797e = r100;
        this.f248798f = r101;
        this.f248794b = new ConcurrentHashMap();
        this.f248796d = "";
    }
}
