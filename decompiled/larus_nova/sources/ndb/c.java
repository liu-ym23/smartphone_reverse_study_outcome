package ndb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.util.share_preference.UserSP;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f518831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<d> f518832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f518833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f518834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f518835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f518836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, CopyOnWriteArraySet<d>> f518837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f518838h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f518839a;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = b.f518840a;     // Catch: Throwable -> L4
            Set r101 = this.f518839a;     // Catch: Throwable -> L4
            r100.f518831a.execute(new ndb.b(r100, r101));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Set r100) {
            this.f518839a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f518840a = null;

        static {
            f518840a = new c();
        }
    }

    public static Set a() {
        Log.i("FeatureGatingTracker", "getAndUpdateSpBeanSet called");
        Gson r100 = new Gson();
        Set r101 = (Set) GsonProtectorUtils.fromJson(r100, UserSP.getInstance().getString("user_sp_fg_params", ""), Set.class);
        HashSet r102 = new HashSet();
        if (r101 != null) goto L13;
        r101 = new HashSet();
    L13:
        Iterator r103 = r101.iterator();     // Catch: Exception -> L10
    L7:
        if (r103.hasNext() == false) goto L12;
        r102.add((d) r100.fromJson(r103.next().toString(), d.class));     // Catch: Exception -> L10
    L12:
        return r102;
    L10:
        e = move-exception;
        Log.e("FeatureGatingTracker", "getSpBeanSet error", e);
        goto L12
    }

    public final void c() {
        Object r100 = this.f518836f;
        monitor-enter(r100);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtils.isEmpty(this.f518837g) == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L34
    L20:
        Set r101 = a();
        Gson r102 = new Gson();
        Iterator r103 = ((CopyOnWriteArraySet) this.f518832b).iterator();
    L22:
        if (r103.hasNext() == false) goto L32;
        d r104 = (d) r103.next();
        HashSet r105 = (HashSet) r101;
        Iterator r106 = r105.iterator();
    L25:
        if (r106.hasNext() == false) goto L29;
        d r107 = (d) r106.next();
        if (TextUtils.equals(r107.a(), r104.a()) == false) goto L25;
        r107.f518841pv += r104.f518841pv;
        boolean r108 = true;
    L30:
        if (r108 == true) goto L22;
        r105.add(r104);
        goto L22
    L29:
        r108 = false;
        goto L30
    L32:
        UserSP.getInstance().putString("user_sp_fg_params", GsonProtectorUtils.toJson(r102, r101));
        ((CopyOnWriteArraySet) this.f518832b).clear();
        return;
    L8:
        HashMap r109 = new HashMap(this.f518837g);     // Catch: Throwable -> L34
        ((HashMap) this.f518837g).clear();     // Catch: Throwable -> L34
        monitor-exit(r100);     // Catch: Throwable -> L34
        if (CollectionUtils.isEmpty(r109) == true) goto L20;
        Iterator r110 = r109.values().iterator();
    L15:
        if (r110.hasNext() == false) goto L20;
        Iterator r111 = ((Set) r110.next()).iterator();
    L18:
        if (r111.hasNext() == false) goto L15;
        b((d) r111.next());
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [ndb.a] */
    public c() {
        this.f518831a = CoreThreadPool.getDefault().newSerialIODensityThreadPool("fg_use_client_collect");
        this.f518832b = new CopyOnWriteArraySet();
        this.f518835e = new Object();
        this.f518836f = new Object();
        this.f518837g = new HashMap();
        this.f518838h = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("fg_use_client_collect_global_feature_gating_service");
        FeatureGatingModule.getDependency().ve(new ndb.a(this));
    }

    public final void b(d r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f518832b).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        d r102 = (d) r101.next();
        if (TextUtils.equals(r102.fgKey, r100.fgKey) == false) goto L4;
        if (TextUtils.equals(r102.fgValueClient, r100.fgValueClient) == false) goto L4;
        if (TextUtils.equals(r102.fgValueServer, r100.fgValueServer) == false) goto L4;
        if (TextUtils.equals(r102.fgInterfaceType, r100.fgInterfaceType) == false) goto L4;
        boolean r103 = true;
        r102.f518841pv++;
    L15:
        if (r103 == true) goto L28;
        ((CopyOnWriteArraySet) this.f518832b).add(r100);
        return;
    L28:
        return;
    L14:
        r103 = false;
        goto L15
    }

    public final void d(String r100, d r101) {
        Object r102 = this.f518836f;
        monitor-enter(r102);
        CopyOnWriteArraySet r103 = (CopyOnWriteArraySet) ((HashMap) this.f518837g).get(r100);     // Catch: Throwable -> L15
        if (r103 != null) goto L7;
        r103 = new CopyOnWriteArraySet();     // Catch: Throwable -> L15
        ((HashMap) this.f518837g).put(r100, r103);     // Catch: Throwable -> L15
    L7:
        r103.add(r101);     // Catch: Throwable -> L15
        if (r103.size() < 100) goto L10;
        HashSet r104 = new HashSet(r103);     // Catch: Throwable -> L15
        ((HashMap) this.f518837g).remove(r100);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L15
        if (r104 == null) goto L20;
        this.f518838h.execute(new a(r104));
        return;
    L20:
        return;
    L10:
        r104 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
