package com.bytedance.lynx.webview.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.lynx.webview.bean.LoadInfo;
import com.bytedance.lynx.webview.bean.PrepareInfo;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f265273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadInfo f265274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadInfo f265275d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f265276a = null;

        static {
            int[] r100 = new int[EventType.values().length];
            f265276a = r100;
            r100[EventType.LOAD_END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public final synchronized LoadInfo f() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f265274c != null) goto L6;
        this.f265274c = new LoadInfo(g("uptoSoVersioncode", "0620010001"), g("decompressSuccessfulMd5", ""), this.f265273b.getString("supportHostAbi", "Any"));     // Catch: Throwable -> L9
    L6:
        LoadInfo r100 = this.f265274c;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final String c() {
        return g("decompressSuccessfulMd5", "");
    }

    public final int d() {
        return this.f265273b.getInt("download_seg_num", 10);
    }

    public final long e() {
        return this.f265273b.getLong(this.f265272a + "firstCrashTime", System.currentTimeMillis());
    }

    public final void r() {
        TTWebContext.h().getClass();
        boolean r100 = false;
        if (Setting.c() == null) goto L6;
        r100 = Setting.c().b("sdk_enable_save_download_eventlist", false);
    L6:
        if (r100 == false) goto L8;
        this.f265273b.edit().putString("download_eventlist", "").apply();
        return;
    L8:
        l17.k.d(new String[]{"Download event list is disabled to save to sp."});
        this.f265273b.edit().putString("download_eventlist", "").apply();
    }

    public c0(Context r100) {
        this.f265273b = null;
        this.f265274c = null;
        this.f265275d = null;
        SharedPreferences r101 = r100.getSharedPreferences("WebViewBytedancePrefs", 0);
        this.f265273b = r101;
        StringBuilder r102 = new StringBuilder();
        if (l17.n.d(r100) == false) goto L5;
        String r103 = "main_proc";
    L6:
        r102.append(r103);
        r102.append(":");
        this.f265272a = r102.toString();
        this.f265274c = new LoadInfo(g("uptoSoVersioncode", "0620010001"), g("decompressSuccessfulMd5", ""), r101.getString("supportHostAbi", "Any"));
        return;
    L5:
        r103 = l17.n.b(r100).split(":", 2)[1];
        goto L6
    }

    public final boolean a(String r100) {
        String r101 = this.f265273b.getString("isAppFirstInstall", "");
        l17.k.d(new String[]{"appFirstiInstall: " + r101 + ", " + r100});
        if (r101.equals(r100) == true) goto L5;
        this.f265273b.edit().putString("isAppFirstInstall", r100).apply();
        boolean r102 = true;
    L6:
        l17.k.d(new String[]{"IsAppFirstInstall ：" + r102});
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public final synchronized LoadInfo h(boolean r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f265275d != null) goto L15;
        LoadInfo r101 = f();     // Catch: Throwable -> L18
        String r102 = r101.f475074a;     // Catch: Throwable -> L18
        String r103 = g("usedUptoSoVersioncode", "0620010001");     // Catch: Throwable -> L18
        if (r100 == false) goto L9;
    L13:
        this.f265275d = r101;     // Catch: Throwable -> L18
    L14:
        this.f265275d.f265071c = LoadInfo.Type.USING;     // Catch: Throwable -> L18
        goto L15
    L9:
        if (r103.equals(r102) == true) goto L13;
        if (r103.equals("0620010001") == true) goto L13;
        this.f265275d = new LoadInfo(r103, g("usedDecompressSuccessfulMd5", ""), this.f265273b.getString("usedSupportHostAbi", "Any"));     // Catch: Throwable -> L18
        r.d("[Load] main process is using " + r103 + " while this process wants to use " + r102);     // Catch: Throwable -> L18
    L15:
        LoadInfo r104 = this.f265275d;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r104;
    }

    public final void j(int r100) {
        this.f265273b.edit().putInt(this.f265272a + "crashNumber", r100).apply();
    }

    public final void k(boolean r100) {
        this.f265273b.edit().putBoolean(this.f265272a + "crashUptoLimit", r100).apply();
    }

    public final void m(long r100) {
        this.f265273b.edit().putLong(this.f265272a + "firstCrashTime", r100).apply();
    }

    public final synchronized void n(PrepareInfo r100) {
        monitor-enter(this);
        LoadInfo r101 = this.f265274c;     // Catch: Throwable -> L10
        r101.f475075b = r100.f475075b;     // Catch: Throwable -> L10
        r101.f475074a = r100.f475074a;     // Catch: Throwable -> L10
        r101.f265072d = r100.f265077d;     // Catch: Throwable -> L10
        SharedPreferences.Editor r102 = this.f265273b.edit();     // Catch: Throwable -> L10
        if (r100.f265080g != PrepareInfo.Source.BUILTIN) goto L6;
        boolean r103 = true;
    L7:
        r102.putBoolean("isBuiltin", r103).apply();     // Catch: Throwable -> L10
        u("decompressSuccessfulMd5", r100.f475075b);     // Catch: Throwable -> L10
        u("uptoSoVersioncode", r100.f475074a);     // Catch: Throwable -> L10
        u("supportHostAbi", r100.f265077d);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r103 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void p(EventType r100) {
        this.f265273b.edit().putInt("useStatus", r100.getEventCode()).apply();
        if (a.f265276a[r100.ordinal()] == 1) goto L6;
        EventStatistics.e(r100, null);
        return;
    }

    public final void t(String r100) {
        TTWebContext.h().getClass();
        boolean r101 = false;
        if (Setting.c() == null) goto L6;
        r101 = Setting.c().b("sdk_enable_save_load_eventlist", false);
    L6:
        if (r101 == false) goto L8;
        this.f265273b.edit().putString("load_eventlist", r100).apply();
        return;
    L8:
        l17.k.d(new String[]{"Load event list is disabled to save to sp."});
        this.f265273b.edit().putString("load_eventlist", "").apply();
    }

    public final void b(String r100, int r110) {
        HashSet r101 = new HashSet(this.f265273b.getStringSet("downloadUrls", new HashSet()));
        SharedPreferences.Editor r102 = this.f265273b.edit();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        HashSet r105 = new HashSet(this.f265273b.getStringSet("downloadUrls", new HashSet()));
        if (r105.remove(r104) == false) goto L8;
        r102 = r102.putStringSet("downloadUrls", r105);
    L8:
        SharedPreferences.Editor r106 = r102.remove(r104 + "_downloadSize");
        int r107 = 0;
    L9:
        if (r107 >= r110) goto L11;
        r106 = r106.remove(r104 + "_downloadSeg_" + r107);
        r107 = r107 + 1;
        goto L9
    L11:
        r102 = r106.remove(r104 + "_downloadSeg_9999");
        goto L4
    L12:
        r101.add(r100);
        r102.putStringSet("downloadUrls", r101).apply();
    }

    public final String g(String r100, String r101) {
        return this.f265273b.getString(r100, r101);
    }

    public final boolean i(String r100, int r101) {
        return this.f265273b.getBoolean(r100 + "_downloadSeg_" + r101, false);
    }

    public final void l(boolean r100, String r101) {
        String r102 = this.f265272a + "switch_disable_reason";
        if (r100 == true) goto L7;
        r.b("saveEnableStatus stack " + r101 + Log.getStackTraceString(new Throwable("Switch disable")));
        if (r101 == null) goto L8;
        this.f265273b.edit().putString(r102, r101).apply();
    L8:
        this.f265273b.edit().putBoolean(this.f265272a + "enabled", r100).apply();
        return;
    L7:
        this.f265273b.edit().putString(r102, "Switch has been turn on").apply();
        goto L8
    }

    public final void u(String r100, String r101) {
        this.f265273b.edit().putString(r100, r101).apply();
    }

    public final synchronized void o(String r100, String r101, String r102) {
        monitor-enter(this);
        LoadInfo r103 = this.f265274c;     // Catch: Throwable -> L6
        r103.f475075b = r101;     // Catch: Throwable -> L6
        r103.f475074a = r100;     // Catch: Throwable -> L6
        r103.f265072d = r102;     // Catch: Throwable -> L6
        u("decompressSuccessfulMd5", r101);     // Catch: Throwable -> L6
        u("uptoSoVersioncode", r100);     // Catch: Throwable -> L6
        u("supportHostAbi", r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void q(String r100, String r101, String r102) {
        monitor-enter(this);
        u("usedDecompressSuccessfulMd5", r101);     // Catch: Throwable -> L6
        u("usedUptoSoVersioncode", r100);     // Catch: Throwable -> L6
        u("usedSupportHostAbi", r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void s(String r100, int r101, boolean r102) {
        this.f265273b.edit().putBoolean(r100 + "_downloadSeg_" + r101, r102).apply();
    }
}
