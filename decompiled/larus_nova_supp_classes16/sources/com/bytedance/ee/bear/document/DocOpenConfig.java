package com.bytedance.ee.bear.document;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.document.quota.ShowQuotaBannerPlugin;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocOpenConfig {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static SsrWebviewConfig e;
    public static List<String> f;
    public static OpenDocTimeOutConfigs g;
    public static long h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static int l;
    public static boolean m;

    @AppConfig(key = "ccm_web_template_setting_config")
    public static class CcmTempWebviewConfig implements NonProguard {
        public CcmTempWebviewConfig() {
        }
    }

    @AppConfig(key = "docs_webview_config")
    public static class DocsWebviewConfig implements NonProguard {
        public int resetWKProcessPoolContinuousFailCount;

        public DocsWebviewConfig() {
        }
    }

    @AppConfig(key = "open_doc_timeout")
    public static class OpenDocTimeOutConfigs implements NonProguard {
        private static final int DEFAULT_TIMEOUT_4G = 60000;
        private static final int DEFAULT_TIMEOUT_WIFI = 60000;
        private static final int MIN_TIMEOUT_4G = 1000;
        private static final int MIN_TIMEOUT_WIFI = 1000;

        @JSONField(name = "4G")
        public int carrierTimeout;
        public int clientvar_length;
        public long fetchClientvarTimeout;
        public int fetch_core_pool_size;
        public int fetch_keep_alive_time;
        public int fetch_max_pool_size;
        public int get_pending_ssr_max_length;
        public boolean preload_view_cache;
        public int reload_max_num;
        public boolean service_worker_enable;

        @JSONField(name = "WI-FI")
        public int wifiTimeout;

        public int getCarrierTimeout() {
            int r0 = this.carrierTimeout;
            if (r0 >= 1000) goto L6;
            return UploadResult.UPLOAD_CACELL;
        L6:
            return r0;
        }

        public int getWifiTimeout() {
            int r0 = this.wifiTimeout;
            if (r0 >= 1000) goto L6;
            return UploadResult.UPLOAD_CACELL;
        L6:
            return r0;
        }

        public String toString() {
            return "OpenDocTimeOutConfigs{wifiTimeout=" + this.wifiTimeout + ", carrierTimeout=" + this.carrierTimeout + ", clientvar_length=" + this.clientvar_length + ", reload_max_num=" + this.reload_max_num + ", service_worker_enable=" + this.service_worker_enable + ", preload_view_cache=" + this.preload_view_cache + '}';
        }

        public OpenDocTimeOutConfigs() {
            this.wifiTimeout = ShowQuotaBannerPlugin.NEED_SHOW_CREATE_TIME_INTERVAL;
            this.carrierTimeout = ShowQuotaBannerPlugin.NEED_SHOW_CREATE_TIME_INTERVAL;
            this.clientvar_length = 0;
            this.reload_max_num = 10;
            this.service_worker_enable = true;
            this.preload_view_cache = true;
            this.get_pending_ssr_max_length = 100000;
            this.fetch_core_pool_size = 7;
            this.fetch_max_pool_size = 64;
            this.fetch_keep_alive_time = 10;
            this.fetchClientvarTimeout = 20;
        }
    }

    @AppConfig(key = "preload_jsmodule_config")
    public static class PreloadJSModuleConfigs implements NonProguard {
        public boolean bitable;
        public boolean doc;
        public boolean docx;
        public boolean mindnote;
        public boolean sheet;
        public boolean slide;
        public boolean wiki;

        public String toString() {
            return "PreloadJSModuleConfigs{doc=" + this.doc + ", sheet=" + this.sheet + ", bitable=" + this.bitable + ", docx=" + this.docx + ", wiki=" + this.wiki + ", mindnote=" + this.mindnote + ", slide=" + this.slide + '}';
        }

        public PreloadJSModuleConfigs() {
            this.doc = true;
            this.sheet = true;
            this.bitable = true;
            this.docx = true;
            this.wiki = true;
        }
    }

    @AppConfig(key = "preload_jsmodule_sequencing_config")
    public static class PreloadJsModuleSequencingConfig implements NonProguard {
        public PreloadJsModuleSequencingConfig() {
        }
    }

    @AppConfig(key = "sheet_chart_cdp_protocol")
    public static class SheetChartCdpProtocolConfig implements NonProguard {
        public SheetChartCdpProtocolConfig() {
        }
    }

    @AppConfig(key = "ssr_webview_config")
    public static class SsrWebviewConfig implements NonProguard {
        public boolean enable_after_render;
        public boolean enable_low_device;
        public long preload_ssr_template_timeout;
        public long promt_timeout;
        public long ssr_webview_get_pos_gap_time;

        public SsrWebviewConfig() {
            this.promt_timeout = 100;
            this.ssr_webview_get_pos_gap_time = 50;
            this.preload_ssr_template_timeout = 20000;
            this.enable_after_render = false;
            this.enable_low_device = true;
        }
    }

    static {
        a = Arrays.asList(new String[]{"docx", "sheet", "bitable", "doc", FileInfoPuller.CALLER_WIKI});
        b = Arrays.asList(new String[]{sbb.e.g.getType(), sbb.e.h.getType(), sbb.e.i.getType(), sbb.e.o.getType()});
        c = new AtomicBoolean(true);
        d = new AtomicBoolean();
        g = new OpenDocTimeOutConfigs();
        l = -1;
    }

    public static void a() {
        if (g != null) goto L6;
        g = (OpenDocTimeOutConfigs) com.bytedance.ee.bear.appsetting.c.a.a.c("open_doc_timeout", OpenDocTimeOutConfigs.class, new OpenDocTimeOutConfigs());
        return;
    }

    public static String b() {
        return ((s45.c) org.koin.java.a.a(s45.c.class)).getString("domain_characteristic_config", "{}");
    }

    public static String c() {
        return ((s45.c) org.koin.java.a.a(s45.c.class)).O6();
    }

    public static List<String> e() {
        if (f != null) goto L6;
        f = com.bytedance.ee.bear.appsetting.c.a.a.e("preload_jsmodule_sequencing_config", String.class, a);
    L6:
        return f;
    }

    public static SsrWebviewConfig f() {
        if (e != null) goto L6;
        e = (SsrWebviewConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("ssr_webview_config", SsrWebviewConfig.class, new SsrWebviewConfig());
    L6:
        return e;
    }

    public static void h() {
        if (c.compareAndSet(true, false) == false) goto L6;
        tt5.a.h("DocOpenConfig", "preload DocOpenConfig");
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        g = (OpenDocTimeOutConfigs) r0.c("open_doc_timeout", OpenDocTimeOutConfigs.class, new OpenDocTimeOutConfigs());
        PreloadJSModuleConfigs r3 = (PreloadJSModuleConfigs) r0.c("preload_jsmodule_config", PreloadJSModuleConfigs.class, new PreloadJSModuleConfigs());
        f = r0.e("preload_jsmodule_sequencing_config", String.class, a);
        e = (SsrWebviewConfig) r0.c("ssr_webview_config", SsrWebviewConfig.class, new SsrWebviewConfig());
        k = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).isUsPackage();
        j = r0.i("spacekit.mobile.feed.init.immediate", false);
        h = ((Integer) r0.d("loading_delay_time", 0)).intValue();
        i = r0.i("spacekit.mobile.doc_new_cover", false);
        m = r0.h("ccm.webview.load_ssr_after_wating_html_ready");
    L6:
        if (eu5.c.c() == false) goto L9;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r1 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r1, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("documentOpenTimeout", "key");
        l = r1.getInt("documentOpenTimeout", -1);
    L9:
        if (d.compareAndSet(false, true) == false) goto L12;
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Pe(new r1());
        return;
    }

    public static int d() {
        a();
        if (l < 0) goto L7;
        tt5.a.h("DocOpenConfig", "getOpenTimeout: debugOpenTimeout = " + l);
        return l;
    L7:
        if (fw4.d.a() == null) goto L13;
        if (fw4.d.a() != NetworkType.NETWORK_WIFI) goto L13;
        return g.getWifiTimeout();
    L13:
        return g.getCarrierTimeout();
    }

    public static boolean g() {
        a();
        return g.service_worker_enable;
    }
}
