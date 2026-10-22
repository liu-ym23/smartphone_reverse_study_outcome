package ss3;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements ff7.c, IConfigListener, bt3.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f543332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f543333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f543334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f543335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f543336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f543337f;

    public a() {
    }

    public abstract void a(JSONObject r100);

    public abstract boolean c();

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public abstract long h();

    @Override // ff7.c
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // ff7.c
    public final void onActivityPause(Activity r100) {
    }

    @Override // ff7.c
    public void onActivityResume(Activity r100) {
    }

    @Override // ff7.c
    public final void onActivityStarted(Activity r100) {
    }

    @Override // ff7.c
    public final void onChange(Activity r100, Fragment r101) {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f543332a = true;
        if (this.f543335d == true) goto L7;
        this.f543335d = true;
        if (c() == false) goto L7;
        bt3.b.d.f20539a.a(this);
    L7:
        e();
        this.f543337f = System.currentTimeMillis();
    }

    public final void b() {
        if (this.f543334c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f543336e) == true) goto L12;
        this.f543334c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f543333b = !ActivityLifeObserver.getInstance().isForeground();
        d();
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
        if (com.bytedance.apm.d.j() == false) goto L13;
        ps3.b.a(new String[]{"perf init: " + this.f543336e});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    public static void g(js3.e r100) {
        String r101 = k.a(f.a().f543348a.toArray());
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L5:
        JSONObject r102 = r100.f500221e;
        if (r102 != null) goto L18;
        r102 = new JSONObject();
    L18:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L17
    L11:
        r102.put("scene", r101);     // Catch: JSONException -> L17
        r102.put("process_name", com.bytedance.apm.d.c());     // Catch: JSONException -> L17
        r102.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: JSONException -> L17
        if (r102.isNull("is_front") == false) goto L14;
        r102.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L17
    L14:
        r100.f500221e = r102;     // Catch: JSONException -> L17
    L15:
        boolean r103 = TextUtils.equals(r100.f500217a, "memory");
        r100.f500222f = f.a().b(r103);
        is3.a.h().b(r100);
    }

    @Override // ff7.c
    public void onBackground(Activity r100) {
        this.f543333b = true;
        if (com.bytedance.apm.d.f190526n == true) goto L5;
        return;
    L5:
        if (this.f543335d == false) goto L9;
        this.f543335d = false;
        if (c() == false) goto L9;
        bt3.b.d.f20539a.i(this);
    L9:
        f();
    }

    @Override // ff7.c
    public void onFront(Activity r100) {
        this.f543333b = false;
        if (com.bytedance.apm.d.f190526n == true) goto L5;
        return;
    L5:
        if (this.f543332a == true) goto L7;
        return;
    L7:
        if (this.f543335d == true) goto L11;
        this.f543335d = true;
        if (c() == false) goto L11;
        bt3.b.d.f20539a.a(this);
    L11:
        e();
        this.f543337f = System.currentTimeMillis();
    }

    @Override // bt3.b.e
    public final void onTimeEvent(long r100) {
        long r101 = h();
        if (r101 > 0) goto L5;
        return;
    L5:
        if ((r100 - this.f543337f) > r101) goto L7;
        return;
    L7:
        if (this.f543332a == false) goto L12;
        e();
        this.f543337f = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onRefresh(JSONObject r100, boolean r101) {
        JSONObject r102 = r100.optJSONObject("performance_modules");
        if (r102 != null) goto L5;
        return;
    L5:
        JSONObject r103 = r102.optJSONObject(this.f543336e);
        if (r103 != null) goto L8;
        return;
    L8:
        a(r103);
    }
}
