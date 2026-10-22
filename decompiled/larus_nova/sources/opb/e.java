package opb;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.InternalLocalDefaultConfigStorage;
import com.ss.android.lark.appsetting.api.SettingKeysCollector;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import idb.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AbstractBaseSettingHandler> f524816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f524817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map<String, jpb.a> f524818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f524819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ppb.a.InterfaceC7225a f524820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f524821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f524822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f524823h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f524824a = null;

        static {
            f524824a = new e();
        }
    }

    public final void a() {
        Iterator<AbstractBaseSettingHandler> r100 = this.f524816a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        AbstractBaseSettingHandler r101 = r100.next();
        ((HashSet) this.f524817b).add(r101.a());
        goto L4
    L6:
        Set<String> r102 = SettingKeysCollector.getKeySet();
        if (CollectionUtils.isNotEmpty(r102) == false) goto L9;
        this.f524817b.addAll(r102);
    L9:
        Set<String> r103 = b().keySet();
        if (CollectionUtils.isNotEmpty(r103) == false) goto L12;
        this.f524817b.addAll(r103);
    L12:
        ((LarkSettingModuleDependency.a) this.f524820e).getClass();
        Set<String> r104 = f.a().getSettingsFGKeys();
        if (CollectionUtils.isNotEmpty(r104) == false) goto L15;
        this.f524817b.addAll(r104);
    L15:
        Log.i("AppSettingService", "mSettingKeySet size: " + ((HashSet) this.f524817b).size());
    }

    public final Map<String, jpb.a> b() {
        if (this.f524818c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f524818c != null) goto L8;
        ConcurrentHashMap r100 = new ConcurrentHashMap();     // Catch: Throwable -> L10
        ((ppb.a) ApiUtils.getApi(ppb.a.class)).fillDefaultKey2LoadConfigMap(r100);     // Catch: Throwable -> L10
        this.f524818c = r100;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f524818c;
    }

    public final void c() {
        Log.i("AppSettingService", "init called");
        if (this.f524821f == false) goto L6;
        Log.i("AppSettingService", "mIsInit finish, return");
        return;
    L6:
        Object r100 = this.f524822g;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f524821f == false) goto L13;
        Log.i("AppSettingService", "init done, return");     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L13:
        Log.i("AppSettingService", "init start");     // Catch: Throwable -> L16
        int r101 = com.ss.android.lark.appsetting.api.b.f408944a;     // Catch: Throwable -> L16
        InternalLocalDefaultConfigStorage.f408932g.getValue().c();     // Catch: Throwable -> L16
        d();     // Catch: Throwable -> L16
        final List<AbstractBaseSettingHandler> r102 = this.f524816a;     // Catch: Throwable -> L16
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r102));     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
        this.f524821f = true;     // Catch: Throwable -> L16
        Log.i("AppSettingService", "init finish");     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
    }

    public final void d() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = PluginServiceLoader.loadAll(npb.a.class);
    L4:
        if (r101.hasNext() == false) goto L6;
        npb.a r102 = (npb.a) r101.next();
        r102.a();
        r100.addAll(r102.b());
        Log.i("AppSettingService", "not ignored handler is: " + r102.getTag());
        goto L4
    L6:
        r100.add(qpb.a.C7379a.f534445a);
        this.f524816a = r100;
    }

    public final void e() {
        Log.i("AppSettingService", "pullAppSettingsInternal");
        c();
        com.ss.android.lark.appsetting.api.service.d.a.f408956a.a(new ArrayList(this.f524817b), new d(this));
    }

    public e() {
        this.f524817b = new HashSet();
        this.f524819d = new b();
        this.f524822g = new Object();
        this.f524823h = true;
        this.f524816a = Collections.emptyList();
        this.f524820e = ((ppb.a) ApiUtils.getApi(ppb.a.class)).getFeatureGatingDependency();
    }

    public static void f(int r100, boolean r101, long r102, Map r110) {
        int r103 = rpb.a.f538898a;
        Long r104 = Long.valueOf(r102);
        Log.i("AppSettingTracker", "reportSyncUpdate start, scene: " + r100 + ", updateSuccess: " + r101 + ", syncCost: " + r104 + ", changedKeyMap: " + r110);
        JSONObject r111 = new JSONObject();
        if (r101 == true) goto L5;
        r111.put("update_success", r101);
        r111.put("scene", r100);
    L13:
        ((ppb.a) ApiUtils.getApi(ppb.a.class)).sendEvent("fg_sync_update", r111);
        Log.i("AppSettingTracker", "reportSyncUpdate finish, scene: " + r100 + ", updateSuccess: " + r101 + ", syncCost: " + r104 + ", changedKeyMap: " + r110);
        return;
    L5:
        r111.put("update_success", r101);
        r111.put("scene", r100);
        r111.put("sync_cost", r104);
        String r105 = null;
        if (r110 == null) goto L8;
        String r106 = (String) r110.get("added_keys");
    L9:
        r111.put("added_keys", r106);
        if (r110 == null) goto L12;
        r105 = (String) r110.get("removed_keys");
    L12:
        r111.put("removed_keys", r105);
        goto L13
    L8:
        r106 = null;
        goto L9
    }

    public final void g(Map r100, String r110, boolean r111, boolean r112) {
        c();
        Iterator<AbstractBaseSettingHandler> r101 = this.f524816a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().i(r100, true, r111, r112, r110);
        goto L4
    L6:
        com.ss.android.lark.appsetting.api.e.a.f408951a.e(r100, true, r110);
        com.ss.android.lark.appsetting.api.service.d.a.f408956a.b(r100, r110);
        b r102 = this.f524819d;
        Map<String, jpb.a> r103 = b();
        ((LarkSettingModuleDependency.a) this.f524820e).getClass();
        r102.a(r100, r103, r111, true, f.a().isEnable("common_settings_opt_close"));
    }
}
