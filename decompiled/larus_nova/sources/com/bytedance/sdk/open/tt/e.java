package com.bytedance.sdk.open.tt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f269790d = "_douyin_open_sdk.ab.exposed.vids.sp";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f269791e = "vid_key";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f269792f = "OpenAbManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile e f269793g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f269794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f269795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f269796c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f269797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f269798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f269799c;

        public a(e r100, String r101, long r102) {
            this.f269799c = r100;
            this.f269797a = r101;
            this.f269798b = r102;
        }

        public void com_bytedance_sdk_open_tt_e$a__run$___twin___() {
            if (e.a(this.f269799c) == true) goto L5;
            e.a(this.f269799c, true);
            e.b(this.f269799c);
        L5:
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            LogUtils.e(e.f269792f, new Object[]{"updateVidInfo", e});     // Catch: Throwable -> L18
        L23:
            monitor-exit(this);     // Catch: Throwable -> L18
            e.b(this.f269799c);
            return;
        L8:
            if (e.c(this.f269799c).contains(this.f269797a) == true) goto L13;
            e.c(this.f269799c).edit().putString(this.f269797a, String.valueOf(this.f269798b)).apply();     // Catch: Throwable -> L18 Exception -> L20
            LogUtils.d(e.f269792f, new Object[]{"put vid key=" + this.f269797a});     // Catch: Throwable -> L18 Exception -> L20
        L30:
        L13:
            if (this.f269798b == Long.parseLong(e.c(this.f269799c).getString(this.f269797a, "0"))) goto L30;
            e.c(this.f269799c).edit().putString(this.f269797a, String.valueOf(this.f269798b)).apply();     // Catch: Throwable -> L18 Exception -> L20
            LogUtils.d(e.f269792f, new Object[]{"put vid key=" + this.f269797a});     // Catch: Throwable -> L18 Exception -> L20
            goto L30
        }

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_sdk_open_tt_e$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sdk_open_tt_e$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_bytedance_sdk_open_tt_e$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private e(Context r100) {
        this.f269794a = false;
        SharedPreferences r101 = r100.getSharedPreferences(f269790d, 0);
        this.f269795b = r101;
        this.f269796c = r101.edit();
    }

    public static e a(Context r100) {
        if (f269793g != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269793g != null) goto L9;
        f269793g = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f269793g;
    }

    private void a() {
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L15
        Iterator<?> r101 = this.f269795b.getAll().values().iterator();     // Catch: Exception -> L15
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();     // Catch: Exception -> L15
        if ((r102 instanceof String) == false) goto L4;
        r100.add((String) r102);     // Catch: Exception -> L15
        goto L4
    L8:
        OpenHostSettingService r103 = (OpenHostSettingService) OpenServiceManager.getInst().getService(OpenHostSettingService.class);     // Catch: Exception -> L15
        if (r103 == null) goto L25;
        List<String> r104 = r103.getExposeVids();     // Catch: Exception -> L15
        if (r104 == null) goto L13;
        r100.addAll(r104);     // Catch: Exception -> L15
    L13:
        r103.setExposeVids(r100);     // Catch: Exception -> L15
        return;
    L25:
        return;
    L15:
        e = move-exception;
        LogUtils.e(f269792f, new Object[]{"updateAllAppExposeVids", e});
    }

    public static /* synthetic */ boolean a(e r100) {
        return r100.f269794a;
    }

    public static /* synthetic */ boolean a(e r100, boolean r101) {
        r100.f269794a = r101;
        return r101;
    }

    public static /* synthetic */ void b(e r100) {
        r100.a();
    }

    public static /* synthetic */ SharedPreferences c(e r100) {
        return r100.f269795b;
    }

    public void a(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r101 == null) goto L12;
        long r102 = r101.optLong(r100, -1);
        if (r102 > 0) goto L9;
        return;
    L9:
        ThreadUtils.summit(new a(this, r100, r102));
        return;
    L12:
        return;
    }

    public void a(JSONObject r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.f269794a == true) goto L7;
        this.f269794a = true;
        a();
    L7:
        monitor-enter(this);
        Iterator<String> r100 = this.f269795b.getAll().keySet().iterator();     // Catch: Throwable -> L35
    L10:
        if (r100.hasNext() == false) goto L32;
        String r101 = r100.next();     // Catch: Throwable -> L35
    L14:
        if (r110.has(r101) == true) goto L40;
        this.f269796c.remove(r101);     // Catch: Exception -> L29 Throwable -> L35
        LogUtils.d(f269792f, new Object[]{"remove vid key=" + r101});     // Catch: Exception -> L29 Throwable -> L35
    L27:
        this.f269796c.apply();     // Catch: Exception -> L29 Throwable -> L35
        goto L10
    L40:
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29 Throwable -> L35
        goto L27
    L20:
        if (r110.optLong(r101) == Long.parseLong(this.f269795b.getString(r101, "0"))) goto L27;
        this.f269796c.remove(r101);     // Catch: Exception -> L25 Throwable -> L35
        LogUtils.d(f269792f, new Object[]{"remove vid key=" + r101});     // Catch: Exception -> L25 Throwable -> L35
    L29:
        e = move-exception;
        LogUtils.e(f269792f, new Object[]{e});     // Catch: Throwable -> L35
        goto L10
    L32:
        a();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    }
}
