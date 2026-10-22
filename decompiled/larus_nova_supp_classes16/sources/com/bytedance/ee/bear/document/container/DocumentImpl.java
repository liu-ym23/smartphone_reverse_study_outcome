package com.bytedance.ee.bear.document.container;

import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.bytedance.ee.bear.document.s2;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.webviewpool.PreloadNextWebGapABTest;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.JsbAuthConfig;
import com.ss.android.lark.chameleon.JsbAuthGroup;
import com.ss.android.lark.chameleon.JsbAuthInfo;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PluginProvider;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResInterceptConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocumentImpl {
    public static final /* synthetic */ int a = 0;

    public static final class a implements vo5.a {
        public final /* synthetic */ UserSession a;

        public final UserSession b() {
            UserSession r0 = this.a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return PassportcConvention.a(LarkContext.getApplication());
        }

        public a(UserSession r1) {
            this.a = r1;
        }

        public final <T> T a(Class<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "userScopeApi");
            UserSession r0 = b();
            return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r0), r4);
        }
    }

    public static final class b implements vo5.a {
        public final /* synthetic */ UserSession a;

        public final UserSession b() {
            UserSession r0 = this.a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return PassportcConvention.a(LarkContext.getApplication());
        }

        public b(UserSession r1) {
            this.a = r1;
        }

        public final <T> T a(Class<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "userScopeApi");
            UserSession r0 = b();
            return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r0), r4);
        }
    }

    static {
    }

    public static ChameleonConfig b(UserSession r13) {
        final b r0 = new b(r13);
        final String r14 = UUID.randomUUID().toString();
        ChameleonConfig.Builder r1 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_DOCS.getType()).subBizname("document_ssr");
        u35.a r2 = u35.a.a;
        ChameleonConfig.Builder r3 = r1.loadUrl(u35.a.b(r0));
        s2 r4 = s2.c;
        s2 r5 = s2.a.a();
        if (r5 == null) goto L6;
        ResConfig r6 = r5.a;
        if (r6 == null) goto L6;
    L7:
        ChameleonConfig.Builder r7 = r3.resConfig(r6);
        PreloadConfig r10 = new PreloadConfig(null, null, 0, null, 15, null);
        r10.setTemplateUrl(u35.a.b(r0));
        r10.setPolicy(PreloadPolicy.PRELOAD_BIZ_HTML);
        ChameleonConfig.Builder r8 = r7.preloadConfig(r10);
        ResInterceptConfig r12 = new ResInterceptConfig(null, null, null, null, null, null, false, 127, null);
        r12.setRootHtml("/template/bear/mobile_ssr_standalone.html");
        r12.setPathRewrites("/eesz");
        r12.setGetBizTemplateVars(new DocumentImpl$buildSSRResInterceptConfig$1$1(r0, r14));
        r12.setServiceWorkerEnable(DocOpenConfig.g());
        ChameleonConfig.Builder r16 = r8.resInterceptConfig(r12);
        WebviewConfig r9 = new WebviewConfig(null, null, null, false, null, 31, null);
        r9.setBizUAgent(n45.d.a());
        r9.setLarkApiEnable(false);
        r9.setWebViewPoolConfig(new WebViewPoolConfig(1, 1, 1, SmallLoadingPlugin.DURATION_MAX));
        r9.setWebService(new c());
        return r16.webviewConfig(r9).build();
    L6:
        r6 = new ResConfig(null, null, null, 7, null);
        goto L7
    }

    public static ChameleonConfig a(final v4 r21, UserSession r22, ArrayList r23) {
        Intrinsics.checkNotNullParameter(r21, "documentOpenStrategy");
        final a r1 = new a(r22);
        Lazy r2 = LazyKt.lazy(DocumentImpl$buildChameleonConfig$fetchKey$2.INSTANCE);
        ChameleonConfig.Builder r3 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_DOCS.getType()).loadUrl(com.bytedance.ee.bear.document.render.preload.b.a(r1));
        s2 r4 = s2.c;
        s2 r5 = s2.a.a();
        if (r5 == null) goto L6;
        ResConfig r6 = r5.a;
        if (r6 == null) goto L6;
    L7:
        ChameleonConfig.Builder r7 = r3.resConfig(r6);
        OpenConfig r16 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        TitlebarConfig r8 = new TitlebarConfig(false, null, 3, null);
        r8.setShowTitlebar(true);
        r16.setTitlebarConfig(r8);
        r16.setHideLoadingByJS(true);
        r16.setNestedEnable(true);
        PluginProvider r9 = new PluginProvider(null, null, 3, null);
        if (r23 != null) goto L10;
        ArrayList r10 = new ArrayList();
    L11:
        r9.setPluginHostAbilitys(r10);
        r9.setPluginListProvider(new com.bytedance.ee.bear.document.container.b(r21));
        r16.setPluginProvider(r9);
        r16.setOnCreateLifecycleListener(new DocumentImpl$buildOpenConfig$1$3(r21));
        r16.setOnCreateUIContainer(new DocumentImpl$buildOpenConfig$1$4(r21));
        ChameleonConfig.Builder r0 = r7.openConfig(r16);
        PreloadConfig r11 = new PreloadConfig(null, null, 0, null, 15, null);
        r11.setTemplateUrl(com.bytedance.ee.bear.document.render.preload.b.a(r1));
        r11.setPolicy(PreloadPolicy.PRELOAD_BIZ_HTML);
        ChameleonConfig.Builder r12 = r0.preloadConfig(r11);
        final String r13 = (String) r2.getValue();
        ResInterceptConfig r14 = new ResInterceptConfig(null, null, null, null, null, null, false, 127, null);
        r14.setRootHtml("/template/bear/mobile_index.html");
        r14.setPathRewrites("/eesz");
        r14.setGetBizTemplateVars(new DocumentImpl$buildResInterceptConfig$1$1(r1, r13));
        r14.setServiceWorkerEnable(DocOpenConfig.g());
        ChameleonConfig.Builder r17 = r12.resInterceptConfig(r14);
        String r18 = (String) r2.getValue();
        WebviewConfig r19 = new WebviewConfig(null, null, null, false, null, 31, null);
        r19.setBizUAgent(n45.d.a());
        r19.setLarkApiEnable(false);
        com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig r20 = (com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig.KEY, com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig.class, new com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig(1, 2, 5, 3));
        etb.b r24 = (etb.b) LarkContext.spiByDwarf(etb.b.class);
        if (r24 == null) goto L18;
        PreloadNextWebGapABTest r26 = (PreloadNextWebGapABTest) r24.r("use_new_webView_pool_config", PreloadNextWebGapABTest.class, new PreloadNextWebGapABTest());
        if (r26 == null) goto L18;
        if (r26.getUseNewWebViewPoolConfig() != true) goto L18;
        boolean r27 = true;
    L19:
        if (r27 == false) goto L22;
        Log.i("OfficeDocumentImpl", "getWebViewPoolConfig, useNewWebViewPoolConfig");
        r20 = r20.changeToOfficeWebViewPoolConfig();
    L22:
        if (DevicePerfManager.b.a.e.h == false) goto L24;
        r20.maxUseCount = 1;
        r20.coreSize = 1;
        r20.maxSize -= 2;
    L24:
        r19.setWebViewPoolConfig(new WebViewPoolConfig(r20.initialSize, r20.coreSize, r20.maxSize, r20.maxUseCount));
        r19.setWebService(new d(r18));
        r19.setJsbAuthConfig(new JsbAuthConfig(true, false, CollectionsKt.arrayListOf(new JsbAuthInfo[]{new JsbAuthInfo("^http.*", JsbAuthGroup.Private, null, null, 12, null)})));
        return r17.webviewConfig(r19).build();
    L18:
        r27 = false;
        goto L19
    L10:
        r10 = r23;
    L6:
        r6 = new ResConfig(null, null, null, 7, null);
        goto L7
    }
}
