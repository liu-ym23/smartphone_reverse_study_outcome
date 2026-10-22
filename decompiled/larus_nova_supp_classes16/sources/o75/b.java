package o75;

import b95.l;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class b implements a {
    public final com.bytedance.ee.bear.drive.report.c a;
    public final com.bytedance.ee.bear.drive.report.a b;
    public final Map<Class<? extends com.bytedance.ee.bear.drive.config.strategy.d>, com.bytedance.ee.bear.drive.config.strategy.d> c;
    public final l d;
    public final q75.a e;
    public final g85.b f;

    @Inject
    public b() {
        HashMap r0 = new HashMap();
        this.c = r0;
        q75.a r1 = new q75.a();
        this.e = r1;
        t85.c r2 = new t85.c();
        this.a = new com.bytedance.ee.bear.drive.report.c(r2);
        com.bytedance.ee.bear.drive.report.a r3 = new com.bytedance.ee.bear.drive.report.a(r2);
        this.b = r3;
        g85.b r4 = new g85.b(eu5.b.a, r3);
        this.f = r4;
        j r5 = j.a.a;
        r0.put(i.class, new i(r4, r5, r1));
        r0.put(n.class, new n(r4, r5, r1));
        r0.put(m.class, new m(r4, r5, r1));
        r0.put(com.bytedance.ee.bear.drive.config.strategy.c.class, new com.bytedance.ee.bear.drive.config.strategy.c(r4, r5, r1));
        r0.put(com.bytedance.ee.bear.drive.config.strategy.b.class, new com.bytedance.ee.bear.drive.config.strategy.b(r5));
        r0.put(h.class, new h(r4, r1));
        r0.put(k.class, new k(r4, r1));
        r0.put(com.bytedance.ee.bear.drive.config.strategy.a.class, new com.bytedance.ee.bear.drive.config.strategy.a(r4, r5, r1));
        r0.put(e.class, new e(r4, r5, r1));
        r0.put(g.class, new g(r5));
        r0.put(com.bytedance.ee.bear.drive.config.strategy.l.class, new com.bytedance.ee.bear.drive.config.strategy.l(r4, r5, r1));
        this.d = new l();
        tt5.a.h("DriveConfigServiceImpl", "start fetch drive config");
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        r1.g = ((Integer) r6.d("drive_convert_file_size_limit", 20)).intValue();
        JSONObject r7 = new JSONObject((String) r6.d("drive_preload_config", ""));     // Catch: Exception -> L5
        r1.a = r7.optInt("recent");     // Catch: Exception -> L5
        r1.b = r7.optInt("favorite");     // Catch: Exception -> L5
        r1.c = r7.optInt("pin");     // Catch: Exception -> L5
        r1.e = r7.optLong("file_max_size");     // Catch: Exception -> L5
        r1.f = r7.optLong("cache_video_size");     // Catch: Exception -> L5
        r1.d = r7.optInt(BottomPopupData.Default);     // Catch: Exception -> L5
        r1.l = (DriveOfficeConfig) r6.c("drive_ttoffice_config", DriveOfficeConfig.class, new DriveOfficeConfig());     // Catch: Exception -> L5
    L7:
        this.e.i = true;
        com.bytedance.ee.bear.appsetting.c r8 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.e.h = (DrivePreviewConfig) r8.c("drive_preview_config", DrivePreviewConfig.class, new DrivePreviewConfig());
        this.e.j = (DriveCacheConfig) r8.c("drive_cache_config", DriveCacheConfig.class, new DriveCacheConfig());
        this.e.k = (DriveImageThumbConfig) r8.c("drive_image_thumb_config", DriveImageThumbConfig.class, new DriveImageThumbConfig());
        tt5.a.h("DriveConfigServiceImpl", "fetch drive config finish, config=" + this.e);
        return;
    L5:
        e = move-exception;
        tt5.a.f("DriveConfigServiceImpl", e, false);
        goto L7
    }

    public static a a() {
        a r0 = (a) e0c.k.a(LarkContext.getApplication(), a.class);
        if (r0 != null) goto L5;
        tt5.a.d("DriveConfigServiceImpl", "dwarf DriveConfigService is null");
    L5:
        return r0;
    }

    @Override // o75.a
    public final t getCacheManager() {
        return t.l();
    }

    @Override // o75.a
    public final l H7() {
        return this.d;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.c Ke() {
        return this.a;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.a Tb() {
        return this.b;
    }

    @Override // o75.a
    public final q75.a getDriveConfig() {
        return this.e;
    }

    @Override // o75.a
    public final f getMimeTypeManager() {
        return this.f;
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.config.strategy.d Ic(Class<? extends com.bytedance.ee.bear.drive.config.strategy.d> r2) {
        return (com.bytedance.ee.bear.drive.config.strategy.d) ((HashMap) this.c).get(r2);
    }
}
