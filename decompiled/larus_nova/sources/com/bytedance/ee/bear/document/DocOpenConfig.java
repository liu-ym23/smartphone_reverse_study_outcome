package com.bytedance.ee.bear.document;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DocOpenConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f218547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f218548b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f218549c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f218550d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SsrWebviewConfig f218551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<String> f218552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static OpenDocTimeOutConfigs f218553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f218554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f218555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f218556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f218557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f218558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f218559m;

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
            int r100 = this.carrierTimeout;
            if (r100 >= 1000) goto L6;
            return 1000;
        L6:
            return r100;
        }

        public int getWifiTimeout() {
            int r100 = this.wifiTimeout;
            if (r100 >= 1000) goto L6;
            return 1000;
        L6:
            return r100;
        }

        public String toString() {
            return "OpenDocTimeOutConfigs{wifiTimeout=" + this.wifiTimeout + ", carrierTimeout=" + this.carrierTimeout + ", clientvar_length=" + this.clientvar_length + ", reload_max_num=" + this.reload_max_num + ", service_worker_enable=" + this.service_worker_enable + ", preload_view_cache=" + this.preload_view_cache + '}';
        }

        public OpenDocTimeOutConfigs() {
            this.wifiTimeout = 60000;
            this.carrierTimeout = 60000;
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

        /* JADX INFO: renamed from: doc, reason: collision with root package name */
        public boolean f218560doc;
        public boolean docx;
        public boolean mindnote;
        public boolean sheet;
        public boolean slide;
        public boolean wiki;

        public String toString() {
            return "PreloadJSModuleConfigs{doc=" + this.f218560doc + ", sheet=" + this.sheet + ", bitable=" + this.bitable + ", docx=" + this.docx + ", wiki=" + this.wiki + ", mindnote=" + this.mindnote + ", slide=" + this.slide + '}';
        }

        public PreloadJSModuleConfigs() {
            this.f218560doc = true;
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
        f218547a = Arrays.asList(new String[]{DocumentType.DOCX_NAME, DocumentType.SHEET_NAME, DocumentType.BITABLE_NAME, "doc", "wiki"});
        f218548b = Arrays.asList(new String[]{sbb.e.f541296g.getType(), sbb.e.f541297h.getType(), sbb.e.f541298i.getType(), sbb.e.f541304o.getType()});
        f218549c = new AtomicBoolean(true);
        f218550d = new AtomicBoolean();
        f218553g = new OpenDocTimeOutConfigs();
        f218558l = -1;
    }

    public static void a() {
        if (f218553g != null) goto L6;
        f218553g = (OpenDocTimeOutConfigs) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("open_doc_timeout", OpenDocTimeOutConfigs.class, new OpenDocTimeOutConfigs());
        return;
    }

    public static String b() {
        return ((s45.c) org.koin.java.a.a(s45.c.class)).getString("domain_characteristic_config", SliceInitService.DEFAULT_SWITCH);
    }

    public static String c() {
        return ((s45.c) org.koin.java.a.a(s45.c.class)).O6();
    }

    public static List<String> e() {
        if (f218552f != null) goto L6;
        f218552f = com.bytedance.ee.bear.appsetting.c.a.f206237a.e("preload_jsmodule_sequencing_config", String.class, f218547a);
    L6:
        return f218552f;
    }

    public static SsrWebviewConfig f() {
        if (f218551e != null) goto L6;
        f218551e = (SsrWebviewConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("ssr_webview_config", SsrWebviewConfig.class, new SsrWebviewConfig());
    L6:
        return f218551e;
    }

    public static void h() {
        if (f218549c.compareAndSet(true, false) == false) goto L6;
        tt5.a.h("DocOpenConfig", "preload DocOpenConfig");
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        f218553g = (OpenDocTimeOutConfigs) r100.c("open_doc_timeout", OpenDocTimeOutConfigs.class, new OpenDocTimeOutConfigs());
        PreloadJSModuleConfigs r101 = (PreloadJSModuleConfigs) r100.c("preload_jsmodule_config", PreloadJSModuleConfigs.class, new PreloadJSModuleConfigs());
        f218552f = r100.e("preload_jsmodule_sequencing_config", String.class, f218547a);
        f218551e = (SsrWebviewConfig) r100.c("ssr_webview_config", SsrWebviewConfig.class, new SsrWebviewConfig());
        f218557k = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).isUsPackage();
        f218556j = r100.i("spacekit.mobile.feed.init.immediate", false);
        f218554h = ((Integer) r100.d("loading_delay_time", 0)).intValue();
        f218555i = r100.i("spacekit.mobile.doc_new_cover", false);
        f218559m = r100.h("ccm.webview.load_ssr_after_wating_html_ready");
    L6:
        if (eu5.c.c() == false) goto L9;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r102 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r102, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("documentOpenTimeout", "key");
        f218558l = r102.getInt("documentOpenTimeout", -1);
    L9:
        if (f218550d.compareAndSet(false, true) == false) goto L12;
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Pe(new r1());
        return;
    }

    public static int d() {
        a();
        if (f218558l < 0) goto L7;
        tt5.a.h("DocOpenConfig", "getOpenTimeout: debugOpenTimeout = " + f218558l);
        return f218558l;
    L7:
        if (fw4.d.a() == null) goto L13;
        if (fw4.d.a() != NetworkType.NETWORK_WIFI) goto L13;
        return f218553g.getWifiTimeout();
    L13:
        return f218553g.getCarrierTimeout();
    }

    public static boolean g() {
        a();
        return f218553g.service_worker_enable;
    }
}
