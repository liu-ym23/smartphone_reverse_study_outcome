package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f277190b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277191c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f277192a;

    static {
        f277190b = new ConcurrentHashMap(16);
        f277191c = new Object();
    }

    public b() {
        this.f277192a = new d(true, true);
    }

    public b(Context r100, boolean r101) {
        a(r100, r101);
        f277190b.put(r100.getPackageName(), this);
    }

    public static b a(String r100) {
        return f277190b.get(r100);
    }

    private void a(Context r110, boolean r111) {
        long r100 = System.currentTimeMillis();
        String r101 = com.huawei.hms.framework.network.grs.h.c.a("grs_route_config_files_list.txt", r110);
        boolean r102 = false;
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - r100), r101});
        if (TextUtils.isEmpty(r101) == false) goto L5;
        long r103 = System.currentTimeMillis();
        String[] r104 = AssetsUtil.list(r110, GrsApp.getInstance().getBrand(""));
        Logger.i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - r103));
    L6:
        if (r104 != null) goto L8;
        List<String> r105 = new ArrayList();
    L9:
        String r106 = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + r106);
        this.f277192a = new d(false, r111);
        if (r105.contains("grs_app_global_route_config.json") == false) goto L12;
    L13:
        this.f277192a = new d(r110, r106, r111);
    L15:
        if (this.f277192a.d() == false) goto L17;
    L19:
        this.f277192a.a(r110, r105);
        StringBuilder r112 = new StringBuilder("on initLocalManager finish, check appGrs: ");
        if (this.f277192a.f277185a != null) goto L22;
        r102 = true;
    L22:
        r112.append(r102);
        Logger.i("LocalManagerProxy", r112.toString());
        return;
    L17:
        if (r105.contains("grs_sdk_global_route_config.json") == false) goto L19;
        this.f277192a = new c(r110, r111);
        goto L19
    L12:
        if (TextUtils.isEmpty(r106) == true) goto L15;
    L8:
        r105 = Arrays.asList(r104);
        goto L9
    L5:
        r104 = r101.split("#");
        goto L6
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f277192a.b();
    }

    public String a(Context r100, com.huawei.hms.framework.network.grs.e.a r110, GrsBaseInfo r111, String r112, String r113, boolean r114) {
        Object r101 = f277191c;
        monitor-enter(r101);
        String r102 = this.f277192a.a(r100, r110, r111, r112, r113, r114);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, String> a(Context r100, com.huawei.hms.framework.network.grs.e.a r101, GrsBaseInfo r110, String r111, boolean r112) {
        Object r102 = f277191c;
        monitor-enter(r102);
        Map<String, String> r103 = this.f277192a.a(r100, r101, r110, r111, r112);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(String r100, com.huawei.hms.framework.network.grs.e.c r101) {
        r101.b(r100 + "#localConfig", this.f277192a.a().toString());     // Catch: Throwable -> L5 JSONException -> L7
    L12:
        return;
    L7:
        String r102 = "save local config encounter JSONException.";
    L8:
        Logger.w("LocalManagerProxy", r102);
        return;
    L5:
        th = move-exception;
        r102 = "save local config encounter Throwable:" + StringUtils.anonymizeMessage(th.getMessage());
        goto L8
    }

    public boolean a(Context r100, String r101) {
        boolean r102 = this.f277192a.d(r101);
        f277190b.put(r100.getPackageName(), this);
        return r102;
    }

    public Set<String> b() {
        return this.f277192a.c();
    }
}
