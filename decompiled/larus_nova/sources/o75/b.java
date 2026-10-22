package o75;

import b95.l;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.config.fg.DriveCacheConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveImageThumbConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveOfficeConfig;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;
import com.bytedance.ee.bear.drive.config.strategy.e;
import com.bytedance.ee.bear.drive.config.strategy.g;
import com.bytedance.ee.bear.drive.config.strategy.h;
import com.bytedance.ee.bear.drive.config.strategy.i;
import com.bytedance.ee.bear.drive.config.strategy.k;
import com.bytedance.ee.bear.drive.config.strategy.m;
import com.bytedance.ee.bear.drive.config.strategy.n;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import g85.f;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.c f522265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f522266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends com.bytedance.ee.bear.drive.config.strategy.d>, com.bytedance.ee.bear.drive.config.strategy.d> f522267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f522268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q75.a f522269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g85.b f522270f;

    @Inject
    public b() {
        HashMap r100 = new HashMap();
        this.f522267c = r100;
        q75.a r101 = new q75.a();
        this.f522269e = r101;
        t85.c r102 = new t85.c();
        this.f522265a = new com.bytedance.ee.bear.drive.report.c(r102);
        com.bytedance.ee.bear.drive.report.a r103 = new com.bytedance.ee.bear.drive.report.a(r102);
        this.f522266b = r103;
        g85.b r104 = new g85.b(eu5.b.f474075a, r103);
        this.f522270f = r104;
        j r105 = j.a.f217090a;
        r100.put(i.class, new i(r104, r105, r101));
        r100.put(n.class, new n(r104, r105, r101));
        r100.put(m.class, new m(r104, r105, r101));
        r100.put(com.bytedance.ee.bear.drive.config.strategy.c.class, new com.bytedance.ee.bear.drive.config.strategy.c(r104, r105, r101));
        r100.put(com.bytedance.ee.bear.drive.config.strategy.b.class, new com.bytedance.ee.bear.drive.config.strategy.b(r105));
        r100.put(h.class, new h(r104, r101));
        r100.put(k.class, new k(r104, r101));
        r100.put(com.bytedance.ee.bear.drive.config.strategy.a.class, new com.bytedance.ee.bear.drive.config.strategy.a(r104, r105, r101));
        r100.put(e.class, new e(r104, r105, r101));
        r100.put(g.class, new g(r105));
        r100.put(com.bytedance.ee.bear.drive.config.strategy.l.class, new com.bytedance.ee.bear.drive.config.strategy.l(r104, r105, r101));
        this.f522268d = new l();
        tt5.a.h("DriveConfigServiceImpl", "start fetch drive config");
        com.bytedance.ee.bear.appsetting.c r106 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        r101.f531964g = ((Integer) r106.d("drive_convert_file_size_limit", 20)).intValue();
        JSONObject r107 = new JSONObject((String) r106.d("drive_preload_config", ""));     // Catch: Exception -> L5
        r101.f531958a = r107.optInt("recent");     // Catch: Exception -> L5
        r101.f531959b = r107.optInt("favorite");     // Catch: Exception -> L5
        r101.f531960c = r107.optInt("pin");     // Catch: Exception -> L5
        r101.f531962e = r107.optLong("file_max_size");     // Catch: Exception -> L5
        r101.f531963f = r107.optLong("cache_video_size");     // Catch: Exception -> L5
        r101.f531961d = r107.optInt("default");     // Catch: Exception -> L5
        r101.f531969l = (DriveOfficeConfig) r106.c("drive_ttoffice_config", DriveOfficeConfig.class, new DriveOfficeConfig());     // Catch: Exception -> L5
    L7:
        this.f522269e.f531966i = true;
        com.bytedance.ee.bear.appsetting.c r108 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f522269e.f531965h = (DrivePreviewConfig) r108.c("drive_preview_config", DrivePreviewConfig.class, new DrivePreviewConfig());
        this.f522269e.f531967j = (DriveCacheConfig) r108.c("drive_cache_config", DriveCacheConfig.class, new DriveCacheConfig());
        this.f522269e.f531968k = (DriveImageThumbConfig) r108.c("drive_image_thumb_config", DriveImageThumbConfig.class, new DriveImageThumbConfig());
        tt5.a.h("DriveConfigServiceImpl", "fetch drive config finish, config=" + this.f522269e);
        return;
    L5:
        e = move-exception;
        tt5.a.f("DriveConfigServiceImpl", e, false);
        goto L7
    }

    public static a a() {
        a r100 = (a) e0c.k.a(LarkContext.getApplication(), a.class);
        if (r100 != null) goto L5;
        tt5.a.d("DriveConfigServiceImpl", "dwarf DriveConfigService is null");
    L5:
        return r100;
    }

    @Override // o75.a
    public final t getCacheManager() {
        return t.l();
    }

    @Override // o75.a
    public final l H7() {
        return this.f522268d;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.c Ke() {
        return this.f522265a;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.a Tb() {
        return this.f522266b;
    }

    @Override // o75.a
    public final q75.a getDriveConfig() {
        return this.f522269e;
    }

    @Override // o75.a
    public final f getMimeTypeManager() {
        return this.f522270f;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.config.strategy.d Ic(Class<? extends com.bytedance.ee.bear.drive.config.strategy.d> r100) {
        return (com.bytedance.ee.bear.drive.config.strategy.d) ((HashMap) this.f522267c).get(r100);
    }
}
