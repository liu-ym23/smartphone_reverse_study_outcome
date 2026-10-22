package ov6;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.locallife.common.utils.k;
import com.bytedance.locallife.live.msgcenter.interfaces.ReleaseScene;
import com.bytedance.locallife.live.util.m;
import com.bytedance.locallife.live.util.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements pv6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, pv6.a> f526911a;

    public static final class a {
    }

    /* JADX INFO: renamed from: ov6.b$b, reason: collision with other inner class name */
    public static final class C7117b implements pv6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, a> f526912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, Observer<Object>> f526913b;

        /* JADX INFO: renamed from: ov6.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MutableLiveData<Object> f526914a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f526915b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f526914a, r101.f526914a) == true) goto L12;
                return false;
            L12:
                if (this.f526915b == r101.f526915b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f526914a.hashCode() * 31;
                if (this.f526915b == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "LifeLiveData(data=" + this.f526914a + ", isAppLifeCycle=" + this.f526915b + ')';
            }

            public a(MutableLiveData<Object> r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f526914a = r100;
                this.f526915b = r101;
            }
        }

        /* JADX INFO: renamed from: ov6.b$b$b, reason: collision with other inner class name */
        public static final class RunnableC7118b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<MutableLiveData<Object>> f526916a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Observer<Object> f526917b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ C7117b f526918c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.locallife.live.msgcenter.b f526919d;

            public RunnableC7118b(Ref.ObjectRef r100, c r101, C7117b r102, com.bytedance.locallife.live.msgcenter.b r103) {
                this.f526916a = r100;
                this.f526917b = r101;
                this.f526918c = r102;
                this.f526919d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MutableLiveData<Object> r100 = this.f526916a.element;     // Catch: Throwable -> L7
                if (r100 == null) goto L5;
                r100.observeForever(this.f526917b);     // Catch: Throwable -> L7
            L5:
                this.f526918c.f526913b.put(Integer.valueOf(this.f526919d.hashCode()), this.f526917b);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        /* JADX INFO: renamed from: ov6.b$b$c */
        public static final class c<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.locallife.live.msgcenter.b f526920a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f526921b;

            public c(com.bytedance.locallife.live.msgcenter.b r100, String r101) {
                this.f526920a = r100;
                this.f526921b = r101;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                if ((r100 instanceof Unit) == true) goto L6;
                com.bytedance.locallife.live.msgcenter.b.a(this.f526920a, "live_life_listen_data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", r100), TuplesKt.to("extra", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_name", this.f526921b)}))}));
                return;
            }
        }

        /* JADX INFO: renamed from: ov6.b$b$d */
        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f526922a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f526923b;

            public d(a r100, Object r101) {
                this.f526922a = r100;
                this.f526923b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f526922a.f526914a.setValue(this.f526923b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public C7117b() {
            this.f526912a = new LinkedHashMap();
            this.f526913b = new LinkedHashMap();
        }

        @Override // pv6.a
        public final void a(ReleaseScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            if (r100 != ReleaseScene.EXIT_ROOM) goto L10;
            Iterator r101 = ((LinkedHashMap) this.f526912a).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L17;
            if (((a) ((Map.Entry) r101.next()).getValue()).f526915b == true) goto L6;
            r101.remove();
            goto L6
        L17:
            return;
        L10:
            ((LinkedHashMap) this.f526912a).clear();
        }

        @Override // pv6.a
        public final Object l8(String r100) {
            a r101 = (a) ((LinkedHashMap) this.f526912a).get(r100);
            if (r101 == null) goto L7;
            MutableLiveData<Object> r102 = r101.f526914a;
            if (r102 == null) goto L7;
            return r102.getValue();
        L7:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // pv6.a
        public final void b(String r100, com.bytedance.locallife.live.msgcenter.b r101) {
            Intrinsics.checkNotNullParameter(r101, "subscriber");
            if (r100 != null) goto L24;
            return;
        L24:
            Ref.ObjectRef r102 = new Ref.ObjectRef();     // Catch: Exception -> L23
            a r103 = (a) ((LinkedHashMap) this.f526912a).get(r100);     // Catch: Exception -> L23
            T r104 = 0;
            if (r103 == null) goto L8;
            T r105 = r103.f526914a;     // Catch: Exception -> L23
        L9:
            r102.element = r105;     // Catch: Exception -> L23
            if (r105 != 0) goto L16;
            c(r100, Unit.INSTANCE, Boolean.FALSE);     // Catch: Exception -> L23
            a r106 = (a) ((LinkedHashMap) this.f526912a).get(r100);     // Catch: Exception -> L23
            if (r106 == null) goto L14;
            r104 = r106.f526914a;     // Catch: Exception -> L23
        L14:
            r102.element = r104;     // Catch: Exception -> L23
        L16:
            if (this.f526913b.containsKey(Integer.valueOf(r101.hashCode())) == false) goto L18;
            return;
        L18:
            RunnableC7118b r107 = new RunnableC7118b(r102, new c(r101, r100), this, r101);     // Catch: Exception -> L23
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L21;
            r107.run();     // Catch: Exception -> L23
            return;
        L21:
            k.b().post(r107);     // Catch: Exception -> L23
            return;
        L8:
            r105 = 0;
            goto L9
        }

        @Override // pv6.a
        public final void d(String r100, com.bytedance.locallife.live.msgcenter.b r101) {
            Intrinsics.checkNotNullParameter(r101, "subscriber");
            Map<Integer, Observer<Object>> r102 = this.f526913b;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            Observer r104 = (Observer) r103.get(Integer.valueOf(r101.hashCode()));
            if (r104 == null) goto L11;
            a r105 = (a) ((LinkedHashMap) this.f526912a).get(r100);
            if (r105 == null) goto L9;
            MutableLiveData<Object> r106 = r105.f526914a;
            if (r106 == null) goto L9;
            r106.removeObserver(r104);
        L9:
            Observer<Object> r107 = this.f526913b.remove(Integer.valueOf(r101.hashCode()));
            return;
        }

        @Override // pv6.a
        public final void c(String r100, Object r101, Boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "dataName");
            Intrinsics.checkNotNullParameter(r101, "updateData");
            if (this.f526912a.containsKey(r100) == false) goto L8;
            Object r103 = ((LinkedHashMap) this.f526912a).get(r100);
            Intrinsics.checkNotNull(r103);
            d r104 = new d((a) r103, r101);
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
            r104.run();
            return;
        L7:
            k.b().post(r104);
            return;
        L8:
            Map<String, a> r105 = this.f526912a;
            MutableLiveData r106 = new MutableLiveData(r101);
            if (r102 == null) goto L11;
            boolean r107 = r102.booleanValue();
        L12:
            r105.put(r100, new a(r106, r107));
            return;
        L11:
            r107 = false;
            goto L12
        }
    }

    static {
    }

    public b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("common_data_source", new C7117b());
        this.f526911a = r100;
    }

    @Override // pv6.b
    public final boolean b(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        if (Intrinsics.areEqual(r100.f260628a, "live_life_listen_data") == false) goto L24;
        Map<String, Object> r101 = r100.f260629b;
        String r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.get("data_name");
    L9:
        if ((r103 instanceof String) == false) goto L11;
        String r104 = (String) r103;
    L12:
        Map<String, Object> r105 = r100.f260629b;
        if (r105 == null) goto L15;
        Object r106 = r105.get("data_source_name");
    L17:
        if ((r106 instanceof String) == false) goto L19;
        r102 = (String) r106;
    L19:
        if (r102 != null) goto L21;
        r102 = "common_data_source";
    L21:
        pv6.a r107 = (pv6.a) ((LinkedHashMap) this.f526911a).get(r102);
        if (r107 == null) goto L24;
        r107.b(r104, r100);
        goto L24
    L15:
        r106 = null;
        goto L17
    L11:
        r104 = null;
        goto L12
    L7:
        r103 = null;
    L24:
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        return true;
    }

    @Override // pv6.b
    public final void c(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        if (Intrinsics.areEqual(r100.f260628a, "live_life_listen_data") == false) goto L26;
        Map<String, Object> r101 = r100.f260629b;
        String r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.get("data_name");
    L9:
        if ((r103 instanceof String) == false) goto L11;
        String r104 = (String) r103;
    L12:
        Map<String, Object> r105 = r100.f260629b;
        if (r105 == null) goto L15;
        Object r106 = r105.get("data_source_name");
    L17:
        if ((r106 instanceof String) == false) goto L19;
        r102 = (String) r106;
    L19:
        if (r102 != null) goto L21;
        r102 = "common_data_source";
    L21:
        if (r104 == null) goto L26;
        pv6.a r107 = (pv6.a) ((LinkedHashMap) this.f526911a).get(r102);
        if (r107 == null) goto L26;
        r107.d(r104, r100);
        goto L26
    L15:
        r106 = null;
        goto L17
    L11:
        r104 = null;
        goto L12
    L7:
        r103 = null;
    L26:
        Intrinsics.checkNotNullParameter(r100, "subscriber");
    }

    @Override // pv6.b
    public final boolean a(com.bytedance.locallife.live.msgcenter.a r100, com.bytedance.locallife.live.msgcenter.b r110) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r111 = r100.f260624a;
        String r101 = "common_data_source";
        Object r102 = null;
        Boolean r103 = null;
        if (Intrinsics.areEqual(r111, "live_life_set_data") == false) goto L43;
        Map<String, Object> r112 = r100.f260625b;
        if (r112 == null) goto L7;
        Object r113 = r112.get("data_name");
    L9:
        if ((r113 instanceof String) == false) goto L11;
        String r114 = (String) r113;
    L12:
        Map<String, Object> r104 = r100.f260625b;
        if (r104 == null) goto L15;
        Object r105 = r104.get("data_source_name");
    L17:
        if ((r105 instanceof String) == false) goto L19;
        String r106 = (String) r105;
    L20:
        if (r106 == null) goto L23;
        r101 = r106;
    L23:
        Map<String, Object> r107 = r100.f260625b;
        if (r107 == null) goto L26;
        Object r108 = r107.get("data");
    L27:
        Map<String, Object> r109 = r100.f260626c;
        if (r109 == null) goto L30;
        Object r115 = r109.get("is_app_life_cycle");
    L32:
        if ((r115 instanceof Boolean) == false) goto L34;
        r103 = (Boolean) r115;
    L34:
        if (r114 == null) goto L40;
        if (r108 == null) goto L40;
        pv6.a r116 = (pv6.a) ((LinkedHashMap) this.f526911a).get(r101);
        if (r116 == null) goto L74;
        r116.c(r114, r108, r103);
    L74:
        return true;
    L40:
        m r117 = n.f260724a;
        n.a("data_center_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reason", "data name or data is null")}));
        return true;
    L30:
        r115 = null;
        goto L32
    L26:
        r108 = null;
        goto L27
    L19:
        r106 = null;
        goto L20
    L15:
        r105 = null;
        goto L17
    L11:
        r114 = null;
        goto L12
    L7:
        r113 = null;
        goto L9
    L43:
        if (Intrinsics.areEqual(r111, "live_life_get_data") == false) goto L76;
        Map<String, Object> r118 = r100.f260625b;
        if (r118 == null) goto L47;
        Object r119 = r118.get("data_name");
    L49:
        if ((r119 instanceof String) == false) goto L51;
        String r120 = (String) r119;
    L52:
        Map<String, Object> r121 = r100.f260625b;
        if (r121 == null) goto L55;
        Object r122 = r121.get("data_source_name");
    L57:
        if ((r122 instanceof String) == false) goto L59;
        String r123 = (String) r122;
    L60:
        if (r123 == null) goto L63;
        r101 = r123;
    L63:
        pv6.a r124 = (pv6.a) ((LinkedHashMap) this.f526911a).get(r101);
        if (r124 == null) goto L67;
        r102 = r124.l8(r120);
    L67:
        if (r100.f260627d != null) goto L69;
        r100.f260627d = new HashMap();
    L69:
        HashMap<String, Object> r125 = r100.f260627d;
        if (r125 == null) goto L74;
        if (r102 != null) goto L73;
        r102 = "";
    L73:
        r125.put("data", r102);
        goto L74
    L59:
        r123 = null;
        goto L60
    L55:
        r122 = null;
        goto L57
    L51:
        r120 = null;
        goto L52
    L47:
        r119 = null;
        goto L49
    L76:
        return false;
    }

    @Override // pv6.b
    public final void d(ReleaseScene r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Iterator r102 = ((LinkedHashMap) this.f526911a).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((pv6.a) ((Map.Entry) r102.next()).getValue()).a(r100);
        goto L4
    }
}
