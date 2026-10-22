package jz7;

import android.content.Context;
import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.ss.android.lark.log.Log;
import i18.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import l18.g;
import l18.h;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a extends l18.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public lz7.a f501207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LKOpenApiAccessConfig f501208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f501209h;

    public final void b() {
        h r100 = this.f507012a;
        LKOpenApiAccessConfig r101 = this.f501208g;
        iz7.b r102 = null;
        if (r101 != null) goto L6;
        Log.e("AbsPluginManagerContainer", "open api access config is null");
        r101 = null;
    L6:
        lz7.a r103 = this.f501207f;
        r103.getClass();
        if (r100 != null) goto L10;
        Log.e("OPPluginProviderImpl", "plugin manager is null");
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L21;
        Log.i("OPPluginProviderImpl", "scope:null");
        ArrayList r105 = new ArrayList();
        Iterator<LKPluginConfig> r106 = r103.f511435a.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        LKPluginConfig r107 = r106.next();
        Log.d("OPPluginProviderImpl", "load config:" + r107.toString());
        r105.add(r107);
        goto L18
    L20:
        r102 = new iz7.b(r105, r100, r101);
    L21:
        if (r102 == null) goto L25;
        this.f507012a.b(r102);
        return;
    L25:
        return;
    L10:
        if (r103.f511435a.isEmpty() == false) goto L13;
        Log.i("OPPluginProviderImpl", "no add plugin config, pluginConfigs is empty!");
        goto L12
    L13:
        r104 = false;
        goto L14
    }

    public final void e() {
        this.f507016e.i("LKCoreTarget", new Object[]{"onRelease"});
        h r100 = this.f507012a;
        if (r100 == null) goto L16;
        r100.f507024d.i("LKPluginManagerImpl", new Object[]{"onRelease"});
        Object r101 = r100.f507025e;
        monitor-enter(r101);
        Iterator r102 = ((ArrayList) r100.f507021a).iterator();     // Catch: Throwable -> L13
    L8:
        if (r102.hasNext() == false) goto L10;
        ((d) r102.next()).onRelease();     // Catch: Throwable -> L13
        goto L8
    L10:
        ((ArrayList) r100.f507021a).clear();     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        ((HashMap) r100.f507022b).clear();
        ((ArrayList) ((g) r100.f507023c).f507020a).clear();
        this.f507012a = null;
    L13:
        th = move-exception;
        throw th;
    L16:
        p18.a r103 = this.f507015d;
        if (r103 == null) goto L19;
        r103.b();
        this.f507015d = null;
    L19:
        this.f501209h = null;
    }

    @Override // l18.a, j18.b
    public Context getContext() {
        return this.f501209h;
    }

    public a(Context r100) {
        this.f501209h = r100;
        this.f501208g = null;
        this.f501207f = new lz7.a();
        if (iz7.a.f496705b == null) goto L5;
    L14:
        Iterator<LKPluginConfig> r101 = iz7.a.f496705b.f496706a.iterator();
    L16:
        if (r101.hasNext() == false) goto L24;
        LKPluginConfig r102 = r101.next();
        lz7.a r103 = this.f501207f;
        r103.getClass();
        if (r102 == null) goto L23;
        if (r102.configInvalid() == true) goto L23;
        r103.f511435a.add(r102);
    L23:
        Log.e("OPPluginProviderImpl", "invalid params!");
        goto L16
    L24:
        Log.i("AbsPluginManagerContainer", "plugin env is null ,so inject all plugins");
        b();
        return;
    L5:
        monitor-enter(iz7.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iz7.a.f496705b != null) goto L9;
        iz7.a.f496705b = new iz7.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(iz7.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
