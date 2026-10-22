package ldb;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.j0;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregatingv2impl.entity.ErrorType;
import com.ss.android.lark.featuregatingv2impl.statistics.metrics.FeatureGatingMetricsTracker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.rust.lark_fg.Lark_fgKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class c extends c0c.b implements jdb.e, jdb.d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<String, Boolean> f508853r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<String, Boolean> f508854s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f508855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Object f508856u = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f508857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f508858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f508859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f508860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, HashSet<String>> f508861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, ConcurrentHashMap<String, CopyOnWriteArrayList<jdb.c>>> f508862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f508863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f508864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, HashSet<String>> f508865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<String> f508866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f508867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f508868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f508869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, ConcurrentHashMap<String, Boolean>> f508870o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Inject
    public j f508871p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Inject
    public Application f508872q;

    public class a implements jdb.b<Set<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f508873a;

        public a(c r100) {
            this.f508873a = r100;
        }

        @Override // jdb.b
        public final void onSuccess(Set<String> r100, String r101) {
            final Set<String> r102 = r100;
            if (r102 != null) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r101) == true) goto L8;
            final String r103 = r101 + "_normal_fg";
        L9:
            c r104 = this.f508873a;
            Object r105 = r104.f508859d;
            monitor-enter(r105);
            ((HashMap) r104.f508861f).put(r103, new HashSet(r102));     // Catch: Throwable -> L15
            monitor-exit(r105);     // Catch: Throwable -> L15
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new ldb.b(this, r102, r103));
            return;
        L15:
            th = move-exception;
            throw th;
        L8:
            r103 = "";
            goto L9
        }
    }

    public class b implements jdb.b<Set<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f508874a;

        public b(c r100) {
            this.f508874a = r100;
        }

        @Override // jdb.b
        public final void onSuccess(Set<String> r100, String r101) {
            final Set<String> r102 = r100;
            if (r102 != null) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r101) == false) goto L9;
            Log.w("GlobalFeatureGatingService", "syncSettingFeatureGatingData failed, settingsFGData: " + r102 + ", uid:" + j0.a(r101));
            return;
        L9:
            if (TextUtils.isEmpty(r101) == true) goto L11;
            final String r103 = r101 + "_no_user_fg";
        L12:
            c r104 = this.f508874a;
            Object r105 = r104.f508859d;
            monitor-enter(r105);
            ((HashMap) r104.f508861f).put(r103, new HashSet(r102));     // Catch: Throwable -> L30
            monitor-exit(r105);     // Catch: Throwable -> L30
            final boolean r106 = false;
            if (TextUtils.isEmpty(r101) == false) goto L19;
        L21:
            boolean r107 = false;
        L22:
            if (r107 == false) goto L24;
            Log.i("GlobalFeatureGatingService", "isSettingsFGWithUserUpdated: true");
            this.f508874a.f508869n = true;
        L24:
            if (r107 == false) goto L26;
        L27:
            r106 = true;
        L28:
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(this, r106, r102, r103));
            return;
        L26:
            if (this.f508874a.f508869n == true) goto L28;
        L19:
            if (TextUtils.equals(r101, "absent_user") == true) goto L21;
            r107 = true;
        L30:
            th = move-exception;
            throw th;
        L11:
            r103 = "";
            goto L12
        }
    }

    /* JADX INFO: renamed from: ldb.c$c, reason: collision with other inner class name */
    public class C6679c implements jdb.b<Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f508875a;

        public C6679c(c r100) {
            this.f508875a = r100;
        }

        @Override // jdb.b
        public final void onSuccess(Map<String, Boolean> r100, final String r101) {
            final Map<String, Boolean> r102 = r100;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new e(this, r102, r101));
        }
    }

    static {
        f508853r = new HashMap();
        f508854s = new HashMap();
        f508856u = new Object();
    }

    @Override // jdb.e
    public final void U1() {
        Object r100 = this.f508859d;
        monitor-enter(r100);
        ((HashMap) this.f508861f).clear();     // Catch: Throwable -> L7
        ((CopyOnWriteArraySet) this.f508863h).clear();     // Catch: Throwable -> L7
        ((ConcurrentHashMap) this.f508865j).clear();     // Catch: Throwable -> L7
        ((HashMap) this.f508870o).clear();     // Catch: Throwable -> L7
        Log.i("GlobalFeatureGatingService", "clear global fg mem cache data.");     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // jdb.e
    public final void Y9() {
        Log.i("GlobalFeatureGatingService", "spiInject called");
    }

    @Override // jdb.e
    public final Set<String> getSettingsFGKeys() {
        if (CollectionUtils.isNotEmpty(this.f508867l) == false) goto L7;
        return this.f508867l;
    L7:
        return pdb.a.a().getStringSet("key_feature_gating_no_user_keys", new CopyOnWriteArraySet());
    }

    @Override // jdb.e
    public final void init() {
        Object r100 = this.f508859d;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f508860e == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        this.f508860e = true;     // Catch: Throwable -> L11
        a r101 = new a(this);     // Catch: Throwable -> L11
        b r102 = new b(this);     // Catch: Throwable -> L11
        C6679c r103 = new C6679c(this);     // Catch: Throwable -> L11
        gdb.b r104 = gdb.b.C6013b.f480991a;     // Catch: Throwable -> L11
        r104.f480988i = r101;     // Catch: Throwable -> L11
        r104.f480989j = r102;     // Catch: Throwable -> L11
        r104.f480990k = r103;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public final Set<String> wf() {
        boolean r100 = true;
        if (this.f508864i == false) goto L6;
    L9:
        if (r100 == true) goto L11;
        Set<String> r101 = null;
    L17:
        if (r101 == null) goto L19;
        return r101;
    L19:
        return new HashSet();
    L11:
        if (CollectionUtils.isEmpty(this.f508866k) == false) goto L15;
        String r102 = pdb.a.a().getString("key_feature_gating_no_user_config", "");
        if (r102 == null) goto L15;
        this.f508866k.addAll(new HashSet(Arrays.asList(r102.split(","))));
    L15:
        r101 = this.f508866k;
        goto L17
    L6:
        if (pdb.a.a().contains("key_feature_gating_no_user_config") == false) goto L8;
        this.f508864i = true;
        goto L9
    L8:
        r100 = false;
        goto L9
    }

    @Override // jdb.e
    public final Set<String> allFg(String r100) {
        Object r101 = this.f508859d;
        monitor-enter(r101);
        LinkedHashSet r102 = new LinkedHashSet();     // Catch: Throwable -> L27
        String r103 = r100 + "_normal_fg";     // Catch: Throwable -> L27
        if (this.f508858c == false) goto L11;
        HashSet r104 = (HashSet) ((HashMap) this.f508861f).get(r103);     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r104) == false) goto L11;
        r102.addAll(r104);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from memory: " + r104.size());     // Catch: Throwable -> L27
        Set<String> r105 = Collections.unmodifiableSet(r102);     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        return r105;
    L11:
        Set<String> r106 = xf(r103);     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r106) == false) goto L16;
        r102.addAll(r106);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from disk cache: " + r106.size());     // Catch: Throwable -> L27
        Set<String> r107 = Collections.unmodifiableSet(r102);     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        return r107;
    L16:
        Set<String> r108 = wf();     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r108) == false) goto L21;
        r102.addAll(r108);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from absent user cache: " + r108.size());     // Catch: Throwable -> L27
        Set<String> r109 = Collections.unmodifiableSet(r102);     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        return r109;
    L21:
        List<String> r110 = idb.d.a();     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r110) == false) goto L24;
        r102.addAll(r110);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from package defaults: " + ((ArrayList) r110).size());     // Catch: Throwable -> L27
    L24:
        Set<String> r111 = Collections.unmodifiableSet(r102);     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        return r111;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // jdb.e
    public final boolean isNoUserFGEnable(String r100) {
        Log.i("GlobalFeatureGatingService", "calling isNoUserFGEnable, FG key: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
        return false;
    L7:
        if (CollectionUtils.isEmpty(this.f508857b) == true) goto L13;
        if (this.f508857b.containsKey(r100) == false) goto L13;
        Boolean r101 = this.f508857b.get(r100);
        Log.i("GlobalFeatureGatingService", "from mock, value: " + r101);
        return Boolean.TRUE.equals(r101);
    L13:
        if (this.f508858c == false) goto L22;
        HashSet r102 = (HashSet) ((HashMap) this.f508861f).get("absent_user_no_user_fg");
        if (CollectionUtils.isNotEmpty(r102) == false) goto L19;
        boolean r103 = r102.contains(r100);
        Log.i("GlobalFeatureGatingService", "from mRuntimeFeaturesMap, value: " + r103);
        return r103;
    L19:
        if (CollectionUtils.isNotEmpty(this.f508868m) == false) goto L22;
        boolean r104 = ((CopyOnWriteArraySet) this.f508868m).contains(r100);
        Log.i("GlobalFeatureGatingService", "from mSettingsFGNoUserSet, value: " + r104);
        return r104;
    L22:
        Set<String> r105 = xf("absent_user_no_user_fg");
        if (CollectionUtils.isNotEmpty(r105) == false) goto L26;
        boolean r106 = r105.contains(r100);
        Log.i("GlobalFeatureGatingService", "from RuntimeFGSPCache cache, value: " + r106);
        return r106;
    L26:
        Set<String> r107 = wf();
        if (CollectionUtils.isNotEmpty(r107) == false) goto L30;
        boolean r108 = r107.contains(r100);
        Log.i("GlobalFeatureGatingService", "from FGNoUserSPCache, value: " + r108);
        return r108;
    L30:
        boolean r109 = FeatureGatingModule.getDependency().e9(r100);
        Log.i("GlobalFeatureGatingService", "form SettingsDefaultValue, value: " + r109);
        return r109;
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Log.i("GlobalFeatureGatingService", "destroy called");
        String r101 = r100.f475033a.userId;
        Object r102 = this.f508859d;
        monitor-enter(r102);
        Iterator r103 = Arrays.asList(new String[]{"_normal_fg", "_no_user_fg"}).iterator();     // Catch: Throwable -> L14
    L6:
        if (r103.hasNext() == false) goto L11;
        String r104 = (String) r103.next();     // Catch: Throwable -> L14
        String r105 = r101 + r104;     // Catch: Throwable -> L14
        HashSet r106 = (HashSet) ((HashMap) this.f508861f).get(r105);     // Catch: Throwable -> L14
        if (r106 == null) goto L10;
        r106.clear();     // Catch: Throwable -> L14
    L10:
        ((CopyOnWriteArraySet) this.f508863h).remove(r105);     // Catch: Throwable -> L14
        ((ConcurrentHashMap) this.f508865j).remove(r105);     // Catch: Throwable -> L14
        ((HashMap) this.f508870o).remove("absent_user" + r104);     // Catch: Throwable -> L14
        ((HashMap) this.f508870o).remove(r105);     // Catch: Throwable -> L14
        ((ConcurrentHashMap) this.f508862g).remove(r105);     // Catch: Throwable -> L14
        goto L6
    L11:
        this.f508869n = false;     // Catch: Throwable -> L14
        Log.i("GlobalFeatureGatingService", "clear user fg mem cache data and update listeners.");     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Log.i("GlobalFeatureGatingService", "onPrepared called");
    }

    public final Set<String> xf(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L15;
        Set<String> r102 = null;
    L22:
        if (r102 == null) goto L24;
        return r102;
    L24:
        return new HashSet();
    L15:
        if (((ConcurrentHashMap) this.f508865j).containsKey(r100) == true) goto L20;
        String r103 = pdb.a.b(r100).getString("key_feature_gating_config", "");
        if (r103 == null) goto L19;
        ((ConcurrentHashMap) this.f508865j).put(r100, new HashSet(Arrays.asList(r103.split(","))));
        goto L20
    L19:
        ((ConcurrentHashMap) this.f508865j).put(r100, new HashSet());
    L20:
        r102 = (Set) ((ConcurrentHashMap) this.f508865j).get(r100);
        goto L22
    L6:
        if (((CopyOnWriteArraySet) this.f508863h).contains(r100) == false) goto L9;
    L11:
        r101 = true;
        goto L13
    L9:
        if (pdb.a.b(r100).contains("key_feature_gating_config") == false) goto L12;
        ((CopyOnWriteArraySet) this.f508863h).add(r100);
        Log.i("GlobalFeatureGatingService", "hasRuntimeFGSPCache add " + j0.a(r100));
        goto L11
    }

    @Inject
    public c(j r100, jdb.f r101) {
        super(r100);
        this.f508859d = new Object();
        this.f508860e = false;
        this.f508861f = new HashMap();
        this.f508862g = new ConcurrentHashMap();
        this.f508863h = new CopyOnWriteArraySet();
        this.f508865j = new ConcurrentHashMap();
        this.f508866k = new CopyOnWriteArraySet();
        this.f508867l = new CopyOnWriteArraySet();
        this.f508868m = new CopyOnWriteArraySet();
        this.f508870o = new HashMap();
        boolean r102 = z.e(this.f508872q);
        this.f508858c = r102;
        this.f508857b = r101.a();
        Log.i("GlobalFeatureGatingService", "GlobalFeatureGatingService called, main process:" + r102);
        h.a(this);
    }

    public static void tf(c r100, Set r101) {
        r100.getClass();
        Log.i("GlobalFeatureGatingService", "updateSettingsNoUserKeys called");
        Object r102 = r100.f508859d;
        monitor-enter(r102);
        r100.f508864i = true;     // Catch: Throwable -> L21
        Set<String> r103 = r100.wf();     // Catch: Throwable -> L21
        r100.f508866k = new HashSet(r101);     // Catch: Throwable -> L21
        if (zf(r101, r103) == false) goto L13;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L21
        Iterator r105 = ((HashSet) r101).iterator();     // Catch: Throwable -> L21
    L9:
        if (r105.hasNext() == false) goto L11;
        r104.append((String) r105.next());     // Catch: Throwable -> L21
        r104.append(",");     // Catch: Throwable -> L21
        goto L9
    L11:
        pdb.a.a().putString("key_feature_gating_no_user_config", r104.toString());     // Catch: Throwable -> L21
    L13:
        if (pdb.a.a().getBoolean("removed_legacy_no_user_keys", false) == true) goto L19;
        Log.i("GlobalFeatureGatingService", "removing no user legacy keys.");     // Catch: Throwable -> L21
        Iterator<String> r106 = r103.iterator();     // Catch: Throwable -> L21
    L16:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();     // Catch: Throwable -> L21
        pdb.a.a().remove(r107);     // Catch: Throwable -> L21
        goto L16
    L18:
        pdb.a.a().putBoolean("removed_legacy_no_user_keys", true);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public static void uf(c r100, Set r101) {
        Object r102 = r100.f508859d;
        monitor-enter(r102);
        if (r101 != null) goto L11;
    L6:
        monitor-exit(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        ((CopyOnWriteArraySet) r100.f508867l).addAll(r101);     // Catch: Throwable -> L8
        pdb.a.a().putStringSet("key_feature_gating_no_user_keys", r101);     // Catch: Throwable -> L8
        goto L6
    }

    public static List vf(Set r100, Set r101) {
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        Iterator r103 = r101.iterator();     // Catch: Exception -> L13
    L8:
        if (r103.hasNext() == false) goto L15;
        String r104 = (String) r103.next();     // Catch: Exception -> L13
        if (r100.contains(r104) == true) goto L8;
        r102.add(r104);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.i("GlobalFeatureGatingService", "compareDiffKey fail, e: " + e.getMessage());
    L15:
        return r102;
    }

    public static boolean zf(Set r100, Set r101) {
        if (CollectionUtils.isEmpty(r101) == false) goto L5;
        return true;
    L5:
        List r102 = vf(r100, r101);
        List r103 = vf(r101, r100);
        if (((ArrayList) r102).isEmpty() == true) goto L8;
        return true;
    L8:
        if (((ArrayList) r103).isEmpty() == false) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // jdb.e
    public final boolean B0(String r110, String r111) {
        Log.d("GlobalFeatureGatingService", "calling isEnable, FG key: " + r111);
        long r100 = System.nanoTime();
        boolean r101 = false;
        if (TextUtils.isEmpty(r111) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is illegal.");
        return false;
    L7:
        if (TextUtils.isEmpty(r110) == false) goto L10;
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        r110 = "absent_user";
    L12:
        String r112 = r110 + "_normal_fg";
        if (CollectionUtils.isEmpty(this.f508857b) == false) goto L15;
    L18:
        kdb.a r102 = new kdb.a();
        odb.a r103 = r102.f502992b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r103.f522906a = r111;
        Map r104 = (Map) ((HashMap) this.f508870o).get("absent_user");
        if (CollectionUtils.isEmpty(r104) == false) goto L21;
    L23:
        Map r105 = (Map) ((HashMap) this.f508870o).get(r112);
        if (CollectionUtils.isEmpty(r105) == false) goto L26;
    L28:
        String r106 = r112.replace("_normal_fg", "");
        if (com.ss.android.lark.featuregating.b.f420726d.a().a("improve.safe.score.rust") == false) goto L46;
        if (FeatureGatingModule.getFeatureGatingService().isNoUserFGEnable("lazy_load_fg_barrier_before_login") == true) goto L36;
        Boolean r107 = (Boolean) ((HashMap) f508854s).get(r106);
        if (r107 == null) goto L40;
        r101 = r107.booleanValue();
    L40:
        if (r101 == true) goto L90;
    L51:
        Set<String> r108 = xf(r112);
        if (CollectionUtils.isNotEmpty(r108) == false) goto L54;
        boolean r109 = r108.contains(r111);
        r102.setResult(r109);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_DISK.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r109);
    L58:
        boolean r113 = r102.f502991a;
        ConcurrentHashMap r114 = (ConcurrentHashMap) ((HashMap) this.f508870o).get(r112);
        if (r114 != null) goto L71;
        Object r115 = this.f508859d;
        monitor-enter(r115);
        ConcurrentHashMap r116 = (ConcurrentHashMap) ((HashMap) this.f508870o).get(r112);     // Catch: Throwable -> L68
        if (r116 != null) goto L65;
        ConcurrentHashMap r117 = new ConcurrentHashMap();     // Catch: Throwable -> L68
        r117.put(r111, Boolean.valueOf(r113));     // Catch: Throwable -> L68
        ((HashMap) this.f508870o).put(r112, r117);     // Catch: Throwable -> L68
    L66:
        monitor-exit(r115);     // Catch: Throwable -> L68
    L72:
        ndb.c r118 = ndb.c.b.f518840a;
        boolean r119 = r102.f502991a;
        boolean r120 = yf(r111, r112).f502991a;
        r118.getClass();
        if (Boolean.TRUE.equals(FeatureGatingModule.getDependency().Y()) == true) goto L84;
        ndb.d r121 = new ndb.d();
        String r122 = "1";
        if (r119 == false) goto L78;
        String r123 = "1";
    L79:
        r121.fgValueClient = r123;
        if (r120 == true) goto L83;
        r122 = "0";
    L83:
        r121.fgValueServer = r122;
        r121.fgKey = r111;
        r121.fgInterfaceType = "0";
        r121.f518841pv = 1;
        r118.d(r112, r121);
        goto L84
    L78:
        r123 = "0";
    L84:
        odb.a r124 = r102.f502992b;
        r124.f522907b = r100;
        r124.f522908c = System.nanoTime();
        FeatureGatingMetricsTracker r125 = FeatureGatingMetricsTracker.f420741a;
        FeatureGatingMetricsTracker.b(r102.f502992b);
        return r102.f502991a;
    L65:
        Log.i("GlobalFeatureGatingService", "should missed used fg.");     // Catch: Throwable -> L68
        r116.put(r111, Boolean.valueOf(r113));     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    L71:
        r114.put(r111, Boolean.valueOf(r113));
        goto L72
    L54:
        Set r126 = (Set) ((HashMap) this.f508861f).get("absent_user_normal_fg");
        if (CollectionUtils.isEmpty(r126) == true) goto L57;
        boolean r127 = r126.contains(r111);
        Log.d("GlobalFeatureGatingService", "from no-user-state cache, value: " + r127);
        r102.setResult(r127);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        goto L58
    L57:
        boolean r128 = idb.d.b(r111).booleanValue();
        Log.d("GlobalFeatureGatingService", "from package, value: " + r128);
        r102.setResult(r128);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        goto L58
    L90:
        boolean r129 = Lark_fgKt.getImmutableFeatureGating(r106, r111);     // Catch: Exception -> L43
        Log.d("GlobalFeatureGatingService", "from molten, value: " + r129 + ", uidWithType: " + r112 + ", uid: " + r106);     // Catch: Exception -> L43
        r102.setResult(r129);     // Catch: Exception -> L43
        r102.f502992b.a(ErrorType.NORMAL);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        r102.f502992b.a(ErrorType.SINGLE_ERROR_MOLTEN_FAIL);
        Log.e("GlobalFeatureGatingService", "Lark_biz_fgKt err: " + e.getMessage() + ", uidWithType: " + r112 + ", uid: " + r106 + ", fg=" + r111);
        goto L51
    L36:
        Boolean r130 = (Boolean) ((HashMap) f508853r).get(r106);
        if (r130 == null) goto L40;
        r101 = r130.booleanValue();
        goto L40
    L46:
        if (FeatureGatingModule.getDependency().e6(r106) == false) goto L51;
        boolean r131 = Lark_fgKt.getImmutableFeatureGating(r106, r111);     // Catch: Exception -> L49
        Log.d("GlobalFeatureGatingService", "from molten, value: " + r131 + ", uidWithType: " + r112 + ", uid: " + r106);     // Catch: Exception -> L49
        r102.setResult(r131);     // Catch: Exception -> L49
        r102.f502992b.a(ErrorType.NORMAL);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        r102.f502992b.a(ErrorType.SINGLE_ERROR_MOLTEN_FAIL);
        Log.e("GlobalFeatureGatingService", "Lark_biz_fgKt err: " + e.getMessage() + ", uidWithType: " + r112 + ", uid: " + r106 + ", fg=" + r111);
        goto L51
    L26:
        if (r105.containsKey(r111) == false) goto L28;
        Boolean r132 = (Boolean) r105.get(r111);
        Log.d("GlobalFeatureGatingService", "from usedMap, value: " + r132);
        r102.setResult(Boolean.TRUE.equals(r132));
        r102.f502992b.a(ErrorType.NORMAL);
        goto L58
    L21:
        if (r104.containsKey(r111) == false) goto L23;
        Boolean r133 = (Boolean) r104.get(r111);
        Log.i("GlobalFeatureGatingService", "from absentUserUsedFG, value: " + r133);
        r102.setResult(Boolean.TRUE.equals(r133));
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        goto L58
    L15:
        if (this.f508857b.containsKey(r111) == false) goto L18;
        Boolean r134 = this.f508857b.get(r111);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r134);
        return Boolean.TRUE.equals(r134);
    L10:
        if (TextUtils.isDigitsOnly(r110) == true) goto L12;
        Log.w("GlobalFeatureGatingService", "uid is illegal, uid: " + r110);
        goto L12
    }

    @Override // jdb.e
    public final void Tc(String r100, boolean r101) {
        if (TextUtils.equals(r100, "absent_user") == false) goto L5;
    L6:
        r100 = "absent_user";
    L7:
        Map<String, Boolean> r102 = f508854s;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Boolean.valueOf(r101));
        if (f508855t == false) goto L10;
        return;
    L10:
        Object r104 = f508856u;
        monitor-enter(r104);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (f508855t == false) goto L16;
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L16:
        com.ss.android.lark.sdk.g.e.f439875a.b(Command.PUSH_LAZY_LOAD_FEATURE_GATING_STARTED, new ldb.a(this));     // Catch: Throwable -> L19
        f508855t = true;     // Catch: Throwable -> L19
        Log.i("GlobalFeatureGatingService", "RegisterMoltenPushInit");     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        goto L6
    }

    @Override // jdb.e
    public final Map<String, String> getChangedKeysBySyncUpdate(String r100, Map<String, String> r101) {
        String r102 = r101.get("lark_features");
        gdb.b.C6013b.f480991a.getClass();
        Set r103 = gdb.b.k(r102);
        Set<String> r104 = xf(r100 + "_normal_fg");
        List r105 = vf(r103, r104);
        List r106 = vf(r104, r103);
        HashMap r107 = new HashMap();
        StringBuilder r108 = new StringBuilder();
        Iterator r109 = ((ArrayList) r105).iterator();
    L4:
        if (r109.hasNext() == false) goto L9;
        String r110 = (String) r109.next();
        if (r108.length() <= 0) goto L8;
        r108.append(",");
    L8:
        r108.append(r110);
        goto L4
    L9:
        StringBuilder r111 = new StringBuilder();
        Iterator r112 = ((ArrayList) r106).iterator();
    L11:
        if (r112.hasNext() == false) goto L16;
        String r113 = (String) r112.next();
        if (r111.length() <= 0) goto L15;
        r111.append(",");
    L15:
        r111.append(r113);
        goto L11
    L16:
        r107.put("added_keys", r106.toString());
        r107.put("removed_keys", r105.toString());
        return r107;
    }

    @Override // jdb.e
    public final Set<String> getRuntimeFGSPCache(String r100, String r101) {
        return xf(r100 + r101);
    }

    @Override // jdb.e
    public final Map<String, Boolean> getUsedFGMap(String r100, String r101) {
        Log.d("GlobalFeatureGatingService", "getUsedFGMap, uid: " + r100);
        Map r102 = (Map) ((HashMap) this.f508870o).get("absent_user" + r101);
        Map r103 = (Map) ((HashMap) this.f508870o).get(r100 + r101);
        HashMap r104 = new HashMap();
        if (CollectionUtils.isNotEmpty(r102) == false) goto L6;
        r104.putAll(r102);
    L6:
        if (CollectionUtils.isNotEmpty(r103) == false) goto L9;
        r104.putAll(r103);
    L9:
        if (CollectionUtils.isEmpty(r104) == false) goto L13;
        Log.i("GlobalFeatureGatingService", "no used fg.");
        return new HashMap();
    L13:
        return new HashMap(r104);
    }

    @Override // jdb.e
    public final void notifySettingsFGChanged(Map<String, Boolean> r100, String r101) {
        gdb.b r102 = gdb.b.C6013b.f480991a;
        r102.getClass();
        gdb.b.j();
        Log.i("FeatureGatingHandler", "getSettingsFGData called");
        HashSet r103 = new HashSet();
        Iterator<Map.Entry<String, Boolean>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, Boolean> r105 = r104.next();
        if (r105.getValue().booleanValue() == false) goto L4;
        r103.add(r105.getKey());
        goto L4
    L8:
        Log.i("FeatureGatingHandler", "settingsFGData: " + r103.toString());
        if (CollectionUtils.isEmpty(r103) == true) goto L19;
        jdb.b<Set<String>> r106 = r102.f480989j;
        if (r106 == null) goto L20;
        r106.onSuccess(r103, r101);
        return;
    L20:
        return;
    }

    @Override // jdb.e
    public final void notifySettingsFGNoUserChanged(Map<String, Boolean> r100, String r101) {
        gdb.b r102 = gdb.b.C6013b.f480991a;
        r102.getClass();
        gdb.b.j();
        if (CollectionUtils.isEmpty(r100) == true) goto L8;
        jdb.b<Map<String, Boolean>> r103 = r102.f480990k;
        if (r103 == null) goto L9;
        r103.onSuccess(r100, r101);
        return;
    L9:
        return;
    }

    @Override // jdb.e
    public final boolean tb(String r100, String r101) {
        Log.d("GlobalFeatureGatingService", "calling isCrossUserEnable, FG key: " + r101);
        Log.d("GlobalFeatureGatingService", "calling isUserEnable, FG key: " + r101);
        if (CollectionUtils.isEmpty(this.f508857b) == true) goto L8;
        if (this.f508857b.containsKey(r101) == false) goto L8;
        Boolean r102 = this.f508857b.get(r101);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r102);
        return Boolean.TRUE.equals(r102);
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
    L25:
        return false;
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L13;
    L24:
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        goto L25
    L13:
        if (TextUtils.equals(r100, "absent_user") == true) goto L24;
        String r103 = r100 + "_no_user_fg";
        if (this.f508858c == false) goto L20;
        HashSet r104 = (HashSet) ((HashMap) this.f508861f).get(r103);
        if (CollectionUtils.isEmpty(r104) == true) goto L20;
        boolean r105 = r104.contains(r101);
        Log.d("GlobalFeatureGatingService", "from mem cache, value: " + r105);
        return r105;
    L20:
        Set<String> r106 = xf(r103);
        if (CollectionUtils.isNotEmpty(r106) == false) goto L23;
        boolean r107 = r106.contains(r101);
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r107);
        return r107;
    L23:
        boolean r108 = FeatureGatingModule.getDependency().e9(r101);
        Log.i("GlobalFeatureGatingService", "form SettingsDefaultValue, value: " + r108);
        return r108;
    }

    @Override // jdb.e
    public final boolean x(String r100, String r110) {
        Log.d("GlobalFeatureGatingService", "calling isCurrentEnable, FG key: " + r110);
        long r101 = System.nanoTime();
        if (TextUtils.isEmpty(r110) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
        return false;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        r100 = "absent_user";
    L10:
        if (CollectionUtils.isEmpty(this.f508857b) == false) goto L12;
    L15:
        String r102 = r100 + "_normal_fg";
        kdb.a r103 = yf(r110, r102);
        ndb.c r104 = ndb.c.b.f518840a;
        boolean r105 = r103.f502991a;
        r104.getClass();
        if (Boolean.TRUE.equals(FeatureGatingModule.getDependency().Y()) == true) goto L23;
        ndb.d r106 = new ndb.d();
        Log.d("FeatureGatingTracker", "for isEnable report, end.");
        if (r105 == false) goto L21;
        String r107 = "1";
    L22:
        r106.fgValueServer = r107;
        r106.fgKey = r110;
        r106.fgInterfaceType = "1";
        r106.f518841pv = 1;
        r104.d(r102, r106);
        goto L23
    L21:
        r107 = "0";
    L23:
        odb.a r108 = r103.f502992b;
        r108.f522907b = r101;
        r108.f522908c = System.nanoTime();
        FeatureGatingMetricsTracker r109 = FeatureGatingMetricsTracker.f420741a;
        FeatureGatingMetricsTracker.b(r103.f502992b);
        return r103.f502991a;
    L12:
        if (this.f508857b.containsKey(r110) == false) goto L15;
        Boolean r111 = this.f508857b.get(r110);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r111);
        return Boolean.TRUE.equals(r111);
    }

    public final kdb.a yf(String r100, String r101) {
        kdb.a r102 = new kdb.a();
        odb.a r103 = r102.f502992b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r103.f522906a = r100;
        if (this.f508858c == false) goto L8;
        HashSet r104 = (HashSet) ((HashMap) this.f508861f).get(r101);
        if (CollectionUtils.isEmpty(r104) == true) goto L8;
        boolean r105 = r104.contains(r100);
        r102.setResult(r105);
        r102.f502992b.a(ErrorType.NORMAL);
        Log.d("GlobalFeatureGatingService", "from mem cache, value: " + r105);
        return r102;
    L8:
        Set<String> r106 = xf(r101);
        if (CollectionUtils.isNotEmpty(r106) == false) goto L12;
        boolean r107 = r106.contains(r100);
        r102.setResult(r107);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_DISK);
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r107);
        return r102;
    L12:
        String r108 = "_normal_fg";
        if (r101.endsWith("_normal_fg") == true) goto L16;
        r108 = "_no_user_fg";
    L16:
        Set r109 = (Set) ((HashMap) this.f508861f).get("absent_user".concat(r108));
        if (CollectionUtils.isEmpty(r109) == true) goto L20;
        boolean r110 = r109.contains(r100);
        Log.d("GlobalFeatureGatingService", "from no-user-state cache, value: " + r110);
        r102.setResult(r110);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        return r102;
    L20:
        boolean r111 = idb.d.b(r100).booleanValue();
        Log.d("GlobalFeatureGatingService", "from package, value:" + r111);
        r102.setResult(r111);
        r102.f502992b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        return r102;
    }

    public static void rf(c r110, Set r111, String r112) {
        r110.getClass();
        Log.i("GlobalFeatureGatingService", "onFeatureGatingUpdate:" + r112);
        if (r111 != null) goto L5;
        return;
    L5:
        if (((ConcurrentHashMap) r110.f508862g).containsKey(r112) == false) goto L58;
        ConcurrentHashMap r100 = (ConcurrentHashMap) ((ConcurrentHashMap) r110.f508862g).get(r112);
        if (CollectionUtils.isNotEmpty(r100) == false) goto L57;
        ArrayList r101 = new ArrayList(Arrays.asList(new Set[]{r110.xf(r112)}));
        if (TextUtils.equals("absent_user_no_user_fg", r112) == false) goto L12;
        r101.add(r110.wf());
    L12:
        Iterator r113 = r101.iterator();
    L14:
        if (r113.hasNext() == false) goto L59;
        Set r102 = (Set) r113.next();
        List r103 = vf(r111, r102);
        List r104 = vf(r102, r111);
        Iterator r105 = ((ArrayList) r103).iterator();
    L17:
        if (r105.hasNext() == false) goto L27;
        String r106 = (String) r105.next();
        if (TextUtils.isEmpty(r106) == true) goto L20;
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) r100.get(r106);
        if (r107 == null) goto L17;
        Iterator r108 = r107.iterator();
    L25:
        if (r108.hasNext() == false) goto L17;
        ((jdb.c) r108.next()).a(false);
        Log.i("GlobalFeatureGatingService", "notify " + r106 + " close, , uidWithType=" + r112);
        goto L25
    L20:
        Log.w("GlobalFeatureGatingService", "removedKey is empty, uidWithType=" + r112);
        goto L17
    L27:
        Iterator r109 = ((ArrayList) r104).iterator();
    L29:
        if (r109.hasNext() == false) goto L14;
        String r114 = (String) r109.next();
        if (TextUtils.isEmpty(r114) == true) goto L32;
        CopyOnWriteArrayList r115 = (CopyOnWriteArrayList) r100.get(r114);
        if (r115 == null) goto L29;
        Iterator r116 = r115.iterator();
    L37:
        if (r116.hasNext() == false) goto L29;
        ((jdb.c) r116.next()).a(true);
        Log.i("GlobalFeatureGatingService", "notify " + r114 + " open, , uidWithType=" + r112);
        goto L37
    L32:
        Log.w("GlobalFeatureGatingService", "addedKey is empty, uidWithType=" + r112);
        goto L29
    L59:
        return;
    L57:
        return;
    }

    public static void sf(c r100, Set r101, String r102) {
        Object r103 = r100.f508859d;
        monitor-enter(r103);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L21;
        if (r101 == null) goto L21;
        ((CopyOnWriteArraySet) r100.f508863h).add(r102);     // Catch: Throwable -> L23
        Set<String> r104 = r100.xf(r102);     // Catch: Throwable -> L23
        Map<String, HashSet<String>> r105 = r100.f508865j;     // Catch: Throwable -> L23
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;     // Catch: Throwable -> L23
        r106.put(r102, new HashSet(r101));     // Catch: Throwable -> L23
        if (zf(r101, r104) == false) goto L15;
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L23
        Iterator r108 = r101.iterator();     // Catch: Throwable -> L23
    L11:
        if (r108.hasNext() == false) goto L13;
        r107.append((String) r108.next());     // Catch: Throwable -> L23
        r107.append(",");     // Catch: Throwable -> L23
        goto L11
    L13:
        pdb.a.b(r102).putString("key_feature_gating_config", r107.toString());     // Catch: Throwable -> L23
    L15:
        if (pdb.a.b(r102).getBoolean("removed_legacy_keys", false) == true) goto L21;
        Log.i("GlobalFeatureGatingService", "removing legacy keys.");     // Catch: Throwable -> L23
        Iterator<String> r109 = r104.iterator();     // Catch: Throwable -> L23
    L18:
        if (r109.hasNext() == false) goto L20;
        String r110 = r109.next();     // Catch: Throwable -> L23
        pdb.a.b(r102).remove(r110);     // Catch: Throwable -> L23
        goto L18
    L20:
        pdb.a.b(r102).putBoolean("removed_legacy_keys", true);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r103);     // Catch: Throwable -> L23
    }

    @Override // jdb.e
    public final void Kb(String r100, jdb.c r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r103 = "absent_user";
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
        String r104 = "absent_user" + r102;
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
    L12:
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((ConcurrentHashMap) this.f508862g).get(r103);
        if (r105 == null) goto L22;
        Iterator r106 = r105.values().iterator();
    L16:
        if (r106.hasNext() == false) goto L21;
        if (((CopyOnWriteArrayList) r106.next()).remove(r101) == false) goto L16;
        Log.i("GlobalFeatureGatingService", "remove fg update listener " + r101 + " success.");
        return;
    L21:
        Log.i("GlobalFeatureGatingService", "remove fg update listener " + r101 + " failed, not found.");
        return;
    L22:
        Log.i("GlobalFeatureGatingService", "remove fg update listener failed, not contains uid.");
        return;
    L11:
        r103 = r104;
        goto L12
    L7:
        r104 = r100 + r102;
        goto L9
    }

    @Override // jdb.e
    public final void T(String r100, String r101, jdb.c r102, String r110) {
        if (TextUtils.isEmpty(r101) == true) goto L45;
        if (r102 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
        String r103 = "absent_user" + r110;
    L10:
        ConcurrentHashMap r111 = (ConcurrentHashMap) ((ConcurrentHashMap) this.f508862g).get(r103);
        if (r111 != null) goto L26;
        Object r104 = this.f508859d;
        monitor-enter(r104);
        ConcurrentHashMap r112 = (ConcurrentHashMap) ((ConcurrentHashMap) this.f508862g).get(r103);     // Catch: Throwable -> L23
        if (r112 != null) goto L17;
        ConcurrentHashMap r113 = new ConcurrentHashMap();     // Catch: Throwable -> L23
        r113.put(r101, new CopyOnWriteArrayList(Collections.singletonList(r102)));     // Catch: Throwable -> L23
        ((ConcurrentHashMap) this.f508862g).put(r103, r113);     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + ", key: " + r101 + ". new uid.");     // Catch: Throwable -> L23
    L21:
        monitor-exit(r104);     // Catch: Throwable -> L23
        return;
    L17:
        Log.i("GlobalFeatureGatingService", "should missed fg update listener, new uid.");     // Catch: Throwable -> L23
        CopyOnWriteArrayList r105 = (CopyOnWriteArrayList) r112.get(r101);     // Catch: Throwable -> L23
        if (r105 != null) goto L20;
        r112.put(r101, new CopyOnWriteArrayList(Collections.singletonList(r102)));     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + ", key: " + r101 + ". new key.");     // Catch: Throwable -> L23
        goto L21
    L20:
        r105.add(r102);     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + ", key: " + r101 + ".");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        CopyOnWriteArrayList r106 = (CopyOnWriteArrayList) r111.get(r101);
        if (r106 != null) goto L39;
        Object r107 = this.f508859d;
        monitor-enter(r107);
        CopyOnWriteArrayList r108 = (CopyOnWriteArrayList) r111.get(r101);     // Catch: Throwable -> L36
        if (r108 != null) goto L33;
        CopyOnWriteArrayList r109 = new CopyOnWriteArrayList();     // Catch: Throwable -> L36
        r109.add(r102);     // Catch: Throwable -> L36
        r111.put(r101, r109);     // Catch: Throwable -> L36
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + ", key: " + r101 + ". new key.");     // Catch: Throwable -> L36
    L34:
        monitor-exit(r107);     // Catch: Throwable -> L36
        return;
    L33:
        Log.i("GlobalFeatureGatingService", "should missed fg update listener, new key.");     // Catch: Throwable -> L36
        r108.add(r102);     // Catch: Throwable -> L36
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + r101 + ".");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L39:
        r106.add(r102);
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r102.getClass().getName() + " success. uidWithType: " + r103 + ", key: " + r101 + ".");
        return;
    L9:
        r103 = r100 + r110;
        goto L10
    }
}
