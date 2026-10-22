package com.bytedance.lynx.webview.adblock;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import l17.g;
import l17.k;
import l17.n;

/* JADX INFO: loaded from: classes21.dex */
public final class TTAdblockClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f265035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f265036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f265037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f265038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.bytedance.lynx.webview.adblock.c f265039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<c> f265040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<ValueCallback<Boolean>> f265041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile LoadLibraryStatus f265042h;

    public static final enum DownloadLibraryStatus extends Enum<DownloadLibraryStatus> {
        public static final DownloadLibraryStatus DOWNLOAD_FAIL = null;
        public static final DownloadLibraryStatus DOWNLOAD_START = null;
        public static final DownloadLibraryStatus DOWNLOAD_SUCCESS = null;
        public static final DownloadLibraryStatus NOT_DOWNLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadLibraryStatus[] f265043a = null;

        static {
            DownloadLibraryStatus r100 = new DownloadLibraryStatus("NOT_DOWNLOAD", 0);
            NOT_DOWNLOAD = r100;
            DownloadLibraryStatus r101 = new DownloadLibraryStatus("DOWNLOAD_START", 1);
            DOWNLOAD_START = r101;
            DownloadLibraryStatus r102 = new DownloadLibraryStatus("DOWNLOAD_SUCCESS", 2);
            DOWNLOAD_SUCCESS = r102;
            DownloadLibraryStatus r103 = new DownloadLibraryStatus("DOWNLOAD_FAIL", 3);
            DOWNLOAD_FAIL = r103;
            f265043a = new DownloadLibraryStatus[]{r100, r101, r102, r103};
        }

        public static DownloadLibraryStatus[] values() {
            return (DownloadLibraryStatus[]) f265043a.clone();
        }

        public static DownloadLibraryStatus valueOf(String r100) {
            return (DownloadLibraryStatus) r27.a.a(DownloadLibraryStatus.class, r100);
        }

        public DownloadLibraryStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LoadLibraryStatus extends Enum<LoadLibraryStatus> {
        public static final LoadLibraryStatus HAVE_TRY_LOAD = null;
        public static final LoadLibraryStatus LOAD_FAIL = null;
        public static final LoadLibraryStatus LOAD_SUCCESS = null;
        public static final LoadLibraryStatus NOT_LOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadLibraryStatus[] f265044a = null;

        static {
            LoadLibraryStatus r100 = new LoadLibraryStatus("NOT_LOAD", 0);
            NOT_LOAD = r100;
            LoadLibraryStatus r101 = new LoadLibraryStatus("HAVE_TRY_LOAD", 1);
            HAVE_TRY_LOAD = r101;
            LoadLibraryStatus r102 = new LoadLibraryStatus("LOAD_SUCCESS", 2);
            LOAD_SUCCESS = r102;
            LoadLibraryStatus r103 = new LoadLibraryStatus("LOAD_FAIL", 3);
            LOAD_FAIL = r103;
            f265044a = new LoadLibraryStatus[]{r100, r101, r102, r103};
        }

        public static LoadLibraryStatus[] values() {
            return (LoadLibraryStatus[]) f265044a.clone();
        }

        public static LoadLibraryStatus valueOf(String r100) {
            return (LoadLibraryStatus) r27.a.a(LoadLibraryStatus.class, r100);
        }

        public LoadLibraryStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ParseRulesStatus extends Enum<ParseRulesStatus> {
        public static final ParseRulesStatus NOT_PARSE = null;
        public static final ParseRulesStatus PARSE_FAIL = null;
        public static final ParseRulesStatus PARSE_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ParseRulesStatus[] f265045a = null;

        static {
            ParseRulesStatus r100 = new ParseRulesStatus("NOT_PARSE", 0);
            NOT_PARSE = r100;
            ParseRulesStatus r101 = new ParseRulesStatus("PARSE_SUCCESS", 1);
            PARSE_SUCCESS = r101;
            ParseRulesStatus r102 = new ParseRulesStatus("PARSE_FAIL", 2);
            PARSE_FAIL = r102;
            f265045a = new ParseRulesStatus[]{r100, r101, r102};
        }

        public static ParseRulesStatus[] values() {
            return (ParseRulesStatus[]) f265045a.clone();
        }

        public static ParseRulesStatus valueOf(String r100) {
            return (ParseRulesStatus) r27.a.a(ParseRulesStatus.class, r100);
        }

        public ParseRulesStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WebResourceResponse f265046a = null;

        static {
            f265046a = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TTAdblockClient f265047a = null;

        static {
            f265047a = new TTAdblockClient();
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f265048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f265049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ValueCallback<Boolean> f265050c;

        public c(String[] r100, String[] r101, ValueCallback r102) {
            this.f265048a = r100;
            this.f265049b = r101;
            this.f265050c = r102;
        }
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("adblock_component", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> adblock_component");
        com.bytedance.librarian.a.c("adblock_component");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> adblock_component");
    }

    public final void d() {
        Object r100 = this.f265037c;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (b(true) == true) goto L11;
        k.d(new String[]{"adblock engine switch is false. Not init"});     // Catch: Throwable -> L20
        EventStatistics.a("scc_load_sys_adblock_engine_result", "disable");     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L11:
        if (n.d(TTWebContext.h().getContext()) == true) goto L16;
        k.d(new String[]{"adblock engine only init in main process."});     // Catch: Throwable -> L20
        EventStatistics.a("scc_load_sys_adblock_engine_result", "notMainProcess");     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L16:
        if (j() == false) goto L18;
        k.d(new String[]{"ensureCreateLoadEngine create adblock engine"});     // Catch: Throwable -> L20
        this.f265039e = com.bytedance.lynx.webview.adblock.c.a.f265063a;     // Catch: Throwable -> L20
        k();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L20
    }

    public final boolean e() {
        if (this.f265035a.get() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f265036b.get() == false) goto L9;
        if (this.f265039e == null) goto L9;
        return true;
    }

    public final void k() {
        c r100 = this.f265040f.getAndSet(null);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f265048a != null) goto L7;
        return;
    L7:
        if (r100.f265049b != null) goto L9;
        return;
    L9:
        if (this.f265039e == null) goto L17;
        boolean r101 = c(r100.f265048a, r100.f265049b);
        ValueCallback<Boolean> r102 = r100.f265050c;
        if (r102 == null) goto L18;
        r102.onReceiveValue(Boolean.valueOf(r101));
        return;
    L18:
        return;
    }

    public TTAdblockClient() {
        AtomicBoolean r100 = new AtomicBoolean(false);
        this.f265035a = r100;
        AtomicBoolean r101 = new AtomicBoolean(false);
        this.f265036b = r101;
        this.f265037c = new Object();
        AtomicBoolean r102 = new AtomicBoolean(false);
        this.f265038d = new AtomicBoolean(false);
        this.f265040f = new AtomicReference(null);
        this.f265041g = new AtomicReference(null);
        DownloadLibraryStatus r103 = DownloadLibraryStatus.NOT_DOWNLOAD;
        this.f265042h = LoadLibraryStatus.NOT_LOAD;
        ParseRulesStatus r104 = ParseRulesStatus.NOT_PARSE;
        EventStatistics.a("scc_adblock_status", "init");
        boolean r105 = b(true);
        if (Setting.c().b("sdk_enable_prev_adblock_enable", false) == false) goto L5;
        TTWebContext.h().f265221g.getClass();
        r100.set(TTWebContext.h().p().f265273b.getBoolean("host_adblock_enable", true));
    L5:
        r101.set(r105);
        EventStatistics.a("scc_adblock_switch", Boolean.valueOf(r105));
        if (r102.compareAndSet(false, true) == false) goto L9;
        k.d(new String[]{"initWhenConstruct"});
        d();
        return;
    }

    public final boolean j() {
        k.d(new String[]{"tryLoadAdblockLibrary"});
        boolean r100 = false;
        if (this.f265042h != LoadLibraryStatus.LOAD_SUCCESS) goto L5;
        return false;
    L5:
        EventStatistics.a("scc_load_sys_adblock_engine_result", "notLoad");
        this.f265042h = LoadLibraryStatus.HAVE_TRY_LOAD;
        h17.a.C6090a r101 = h17.a.d().c();
        String r102 = r101.f483531a;
        String r103 = r101.f483533c;
        String r104 = r101.f483534d;
        if (r102.isEmpty() == false) goto L9;
        k.d(new String[]{"adblock engine library library not exist."});
        return false;
    L9:
        String r105 = r102 + File.separator + "libadblock_component.so";
        this.f265042h = LoadLibraryStatus.LOAD_FAIL;
        if (new PolarisFileWrapper(r105).exists() == true) goto L29;
    L24:
        if (r100 == false) goto L26;
        EventStatistics.a("scc_load_sys_adblock_engine_result", "loadSuccess");
        k.d(new String[]{"adblock engine library load success."});
    L27:
        EventStatistics.a("scc_load_sys_adblock_engine_version", r103);
        EventStatistics.e(EventType.ADBLOCK_ENGINE_LOAD_RESULT, Boolean.valueOf(r100));
        g(r100);
        return r100;
    L26:
        EventStatistics.a("scc_load_sys_adblock_engine_result", "loadFail");
        k.d(new String[]{"adblock engine library load fail."});
        goto L27
    L29:
        int r106 = CastIntegerProtector.parseInt(Setting.c().h("adblock_engine_version", "0"));     // Catch: Throwable -> L13
        int r107 = TTWebContext.h().k();     // Catch: Throwable -> L13
    L15:
        if (r106 < 6) goto L24;
        if (r107 < 30) goto L24;
        String r108 = g.g(r105);
        if (Setting.c().b("adblock_engine_enable_check", false) == true) goto L21;
    L23:
        r100 = f(r105);
        goto L24
    L21:
        if (r108.equals(r104) == true) goto L23;
        k.b(new String[]{"adblock engine library md5 verify failed. fielMd5: " + r108 + " md5: " + r104});
    L13:
        r106 = 0;
        r107 = 0;
        goto L15
    }

    public static void i() {
        DownloadLibraryStatus r100 = DownloadLibraryStatus.NOT_DOWNLOAD;
    }

    public static boolean b(boolean r100) {
        if (Setting.c().b("sdk_enable_scc_system_adblock", r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (TTWebContext.h().p().f265273b.getBoolean("sys_adblock_enabled", true) == false) goto L7;
        return true;
    }

    public final boolean f(String r100) {
        boolean r101 = true;
        if (this.f265042h != LoadLibraryStatus.LOAD_SUCCESS) goto L5;
        return true;
    L5:
        this.f265042h = LoadLibraryStatus.HAVE_TRY_LOAD;
    L11:
        th = move-exception;
        r101 = false;
        k.b(new String[]{"Load system adblock engine error: " + th});
    L13:
        if (r101 == false) goto L15;
        LoadLibraryStatus r102 = LoadLibraryStatus.LOAD_SUCCESS;
    L16:
        this.f265042h = r102;
        return r101;
    L15:
        r102 = LoadLibraryStatus.LOAD_FAIL;
        goto L16
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        a();     // Catch: Throwable -> L11
    L18:
        goto L13
    L9:
        System.load(r100);     // Catch: Throwable -> L11
        goto L18
    }

    public final void g(boolean r100) {
        k.d(new String[]{"runSetAdblockEnableCallBack call"});
        ValueCallback<Boolean> r101 = this.f265041g.getAndSet(null);
        if (r101 == null) goto L6;
        r101.onReceiveValue(Boolean.valueOf(r100));
        return;
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L4;
        DownloadLibraryStatus r101 = DownloadLibraryStatus.NOT_DOWNLOAD;
        return;
    L4:
        DownloadLibraryStatus r102 = DownloadLibraryStatus.NOT_DOWNLOAD;
        g(false);
    }

    public final boolean c(String[] r110, String[] r111) {
        if (this.f265039e == null) goto L52;
        EventStatistics.a("scc_adblock_status", "parsing_rule");
        com.bytedance.lynx.webview.adblock.c r100 = this.f265039e;
        r100.getClass();
        if (r110 == null) goto L47;
        if (r111 == null) goto L47;
        if (r110.length <= 0) goto L47;
        if (r111.length <= 0) goto L47;
        long r101 = System.currentTimeMillis();
        String r102 = r110[0];
        String r103 = r111[0];
        Context r112 = TTWebContext.h().getContext();
        com.bytedance.lynx.webview.adblock.b r104 = new com.bytedance.lynx.webview.adblock.b(r112, "sys_adblock_");
        Object r113 = r104.f265057b;
        monitor-enter(r113);
        TTWebViewAdblockWrapper r114 = r104.f265056a;     // Catch: Throwable -> L19
        if (r114 == null) goto L23;
        e r115 = r114.f265053b;     // Catch: Throwable -> L19
        if (r115 == null) goto L22;
        r114.f265052a = 0;     // Catch: Throwable -> L19
        r115.a(2);     // Catch: Throwable -> L19
        r114.f265053b = null;     // Catch: Throwable -> L19
    L22:
        r104.f265056a = null;     // Catch: Throwable -> L19
    L24:
        TTWebViewAdblockWrapper r105 = new TTWebViewAdblockWrapper(r112.getCacheDir().getAbsolutePath(), "sys_adblock_");     // Catch: Throwable -> L19
        boolean r106 = true;
        if (r105.b(r102, r103) == false) goto L29;
        r104.f265056a = r105;     // Catch: Throwable -> L19
        monitor-exit(r113);     // Catch: Throwable -> L19
        boolean r107 = true;
    L31:
        if (r107 == false) goto L33;
        k.d(new String[]{"TTAdblockEngine sys_adblock_ parse success"});
    L34:
        if (r107 == true) goto L37;
        r104 = null;
    L37:
        r100.f265058a = r104;
        EventStatistics.e(EventType.ADBLOCK_PARSE_RUST_RULES_FILES, Long.valueOf(System.currentTimeMillis() - r101));
        if (r100.f265058a != null) goto L41;
        r106 = false;
    L41:
        if (r106 == false) goto L43;
        EventStatistics.a("scc_rust_rule_md5", r111[0]);
    L44:
        EventStatistics.e(EventType.ADBLOCK_PARSE_RUST_RULES, Boolean.valueOf(r106));
        boolean r108 = r106;
    L48:
        if (r108 == false) goto L50;
        ParseRulesStatus r109 = ParseRulesStatus.NOT_PARSE;
        EventStatistics.a("scc_adblock_status", "parse_success");
        return r108;
    L50:
        ParseRulesStatus r116 = ParseRulesStatus.NOT_PARSE;
        EventStatistics.a("scc_adblock_status", "parse_fail");
        return r108;
    L43:
        EventStatistics.a("scc_rust_rule_md5", "");
        goto L44
    L33:
        k.d(new String[]{"TTAdblockEngine sys_adblock_ parse fail"});
        goto L34
    L29:
        monitor-exit(r113);     // Catch: Throwable -> L19
        r107 = false;
        goto L31
    L23:
        r101 = r101;
    L19:
        th = move-exception;
        throw th;
    L47:
        r108 = false;
        goto L48
    L52:
        return false;
    }
}
