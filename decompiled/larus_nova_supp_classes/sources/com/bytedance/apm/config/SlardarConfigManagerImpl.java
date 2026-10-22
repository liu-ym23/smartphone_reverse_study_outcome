package com.bytedance.apm.config;

import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import gs3.e;
import it3.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private j mSlardarConfigFetcher;

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        j r0 = this.mSlardarConfigFetcher;
        boolean r1 = r0.k();
        if (d.k() == true) goto L5;
        return;
    L5:
        if (r0.l <= System.currentTimeMillis()) goto L7;
        r1 = true;
    L7:
        r0.h(r1);
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.j;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.a;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        j r0 = this.mSlardarConfigFetcher;
        if (r0.h != null) goto L14;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r0.h != null) goto L8;
        r0.h = e.b(d.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
    L14:
        return r0.h.getString("monitor_net_config", XmlPullParser.NO_NAMESPACE);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.i();
    }

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new j();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject getConfigJSON(String r3) {
        j r0 = this.mSlardarConfigFetcher;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L9;
        JSONObject r1 = r0.j;
        if (r1 == null) goto L9;
        return r1.optJSONObject(r3);
    L9:
        return new JSONObject();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r4) {
        j r0 = this.mSlardarConfigFetcher;
        r0.getClass();
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r4, "block_monitor") == false) goto L9;
        r4 = "caton_monitor";
    L9:
        if (TextUtils.equals(r4, "core_exception_monitor") == false) goto L12;
        return r0.b;
    L12:
        if (r0.c != null) goto L15;
        return false;
    L15:
        if (r0.c.optInt(r4) != 1) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r3) {
        j r0 = this.mSlardarConfigFetcher;
        if (r0.d != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r0.d.optInt(r3) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r3) {
        j r0 = this.mSlardarConfigFetcher;
        if (r0.e != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r0.e.optInt(r3) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r3) {
        j r0 = this.mSlardarConfigFetcher;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L8;
        JSONObject r1 = r0.j;
        if (r1 == null) goto L8;
        return r1.optBoolean(r3);
    L8:
        return false;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(IConfigListener r5) {
        j r0 = this.mSlardarConfigFetcher;
        if (r5 != null) goto L6;
        r0.getClass();
        return;
    L6:
        if (r0.t != null) goto L9;
        r0.t = new CopyOnWriteArrayList();
    L9:
        if (((CopyOnWriteArrayList) r0.t).contains(r5) == true) goto L12;
        ((CopyOnWriteArrayList) r0.t).add(r5);
    L12:
        if (d.j() == false) goto L15;
        ps3.b.a(new String[]{"addConfigListener, mReady=" + r0.a});
    L15:
        if (r0.a == false) goto L19;
        r5.onRefresh(r0.j, r0.k);
        r5.onReady();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(IResponseConfigListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (c.a != null) goto L8;
        c.a = new CopyOnWriteArrayList();
    L8:
        if (((CopyOnWriteArrayList) c.a).contains(r2) == true) goto L11;
        ((CopyOnWriteArrayList) c.a).add(r2);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(IConfigListener r2) {
        j r0 = this.mSlardarConfigFetcher;
        if (r2 != null) goto L5;
        r0.getClass();
        return;
    L5:
        List r1 = r0.t;
        if (r1 == null) goto L10;
        ((CopyOnWriteArrayList) r1).remove(r2);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(IResponseConfigListener r2) {
        if (r2 == null) goto L9;
        List r0 = c.a;
        if (r0 == null) goto L8;
        ((CopyOnWriteArrayList) r0).remove(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r2) {
        return this.mSlardarConfigFetcher.l(r2);
    }

    public void forceUpdateFromRemote(gs3.d r2, List<String> r3) {
        j r0 = this.mSlardarConfigFetcher;
        r0.k();
        if (r2 == null) goto L6;
        r0.i = r2;
    L6:
        if (k.b(r3) == true) goto L8;
        r0.f = new ArrayList(r3);
    L8:
        r0.h(true);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r3, int r4) {
        j r0 = this.mSlardarConfigFetcher;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L9;
        JSONObject r1 = r0.j;
        if (r1 != null) goto L8;
        return r4;
    L8:
        return r1.optInt(r3, r4);
    L9:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.ArrayList] */
    public void initParams(boolean r7, gs3.d r8, List<String> r9) {
        j r0 = this.mSlardarConfigFetcher;
        r0.p = r7;
        r0.q = d.k();
        if (r0.h != null) goto L13;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r0.h != null) goto L8;
        r0.h = e.b(d.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
    L13:
        r0.i = r8;
        boolean r10 = false;
        if (k.b(r9) == true) goto L28;
        if (k.b(r9) == true) goto L25;
        ?? r11 = new ArrayList(2);     // Catch: MalformedURLException -> L46
        int r1 = r9.size();     // Catch: MalformedURLException -> L46
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L26;
        String r3 = new URL((String) ListProtector.get(r9, r2)).getHost();     // Catch: MalformedURLException -> L46
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (r3.indexOf(46) <= 0) goto L24;
        r11.add("https://" + r3 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L46
    L24:
        r2 = r2 + 1;
    L26:
        r0.f = r11;
    L25:
        r11 = Collections.emptyList();
    L28:
        if (r0.o == true) goto L59;
        r0.o = true;
        if (r0.q == false) goto L32;
    L33:
        r10 = true;
    L34:
        if (r10 == false) goto L36;
        bt3.b.d.a.a(r0);
    L36:
        IntentFilter r12 = new IntentFilter();
        r12.addAction("com.apm.setting.update.action");
        g r13 = new g(r0);
        if (d.getContext() == null) goto L60;
    L43:
        th = move-exception;
        av3.b.c("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L39:
        if (Build.VERSION.SDK_INT <= 33) goto L41;
        j.a(d.getContext(), r13, r12);     // Catch: Throwable -> L43
    L47:
        return;
    L41:
        j.b(d.getContext(), r13, r12);     // Catch: Throwable -> L43
        goto L47
    L60:
        return;
    L32:
        if (r0.p == false) goto L34;
    }
}
