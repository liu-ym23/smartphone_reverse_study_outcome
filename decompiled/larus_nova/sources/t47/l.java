package t47;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.plugins.ManifestPlugin;
import com.bytedance.pia.core.plugins.RenderingPlugin;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import s47.n;
import s47.t;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements k47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, n> f544597a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f544598a = null;

        static {
            f544598a = new l();
        }
    }

    public l() {
    }

    static {
        f544597a = new HashMap();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [t47.j] */
    /* JADX WARN: Type inference failed for: r2v6, types: [t47.i] */
    /* JADX WARN: Type inference failed for: r7v1, types: [t47.k] */
    @Override // k47.d
    public final i a(String r100, String r101, Map r102, final l47.a r103, final l47.a r104) {
        Lazy<Settings> r105 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        r104.accept(new PiaMethod.SettingDisableError());
        return null;
    L6:
        if (r100 != null) goto L9;
        r104.accept(new PiaMethod.SettingDisableError());
        return null;
    L9:
        Config r106 = Config.c(UriProtector.parse(r100));
        if (r106 != null) goto L12;
    L20:
        r104.accept(new PiaMethod.SettingDisableError());
        return null;
    L12:
        if (r106.i() == false) goto L20;
        ConcurrentHashMap<String, FutureTask<n>> r107 = t.f540673a;
        t.a.f540674a.getClass();
        n r108 = t.a(r100, r101, null, r106, false);
        if (r108 != null) goto L18;
        r104.accept(new PiaMethod.Error("Create runtime error!"));
        return null;
    L18:
        final AtomicBoolean r109 = new AtomicBoolean(false);
        final String r110 = r108.toString();
        ((HashMap) f544597a).put(r110, r108);
        final ?? r111 = new i(r109, r110);
        ?? r112 = new j(r109, r111, r103);
        ?? r113 = new k(r109, r111, r104);
        r108.i(HtmlPlugin.class, null);
        r108.i(ManifestPlugin.class, null);
        r108.i(RenderingPlugin.class, new RenderingPlugin.c(r102, r112, r113));
        r108.h();
        return r111;
    }

    @Override // k47.d
    public final i b(String r100, String r101, Map r102, cf7.c r103, cf7.d r104) {
        return a(r100, r101, r102, r103, r104);
    }
}
