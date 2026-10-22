package com.bytedance.ee.bear.document.analytic;

import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import rcb.f;
import sbb.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AnalyticPlugin extends DocumentPlugin {
    public static final String BIZ_COMMON_PARAMS = "bizCommonParams";
    private static final String JS_HANDLER_SET_COMMON_PARAMS = "biz.analytic.setCommonParams";
    private static final String NATIVE_PERMISSION_COMMON_PARAMS = "nativePermissionCommonParams";
    private boolean hardKeyboardHidden;
    private d mAnalyticService;
    private b05.a mKeyboardAnalytic;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DocsOpenSource.values().length];
            a = r0;
            r0[DocsOpenSource.vc.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[DocsOpenSource.docs_feed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b {
        public b() {
        }
    }

    public class c implements i<b> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AnalyticPlugin r1) {
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            b r3 = (b) r1;
        }
    }

    public static /* synthetic */ void c(AnalyticPlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void d(AnalyticPlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToUIContainer$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private String getSysInfo() {
        int r0 = Build.VERSION.SDK_INT;
        if (com.ss.android.lark.base.embedded.b.e() == false) goto L6;
        String r1 = "OppoFold";
    L13:
        return "Android " + r0 + " ; " + r1;
    L6:
        if (com.ss.android.lark.base.embedded.b.i() == false) goto L9;
        r1 = "XiaomiFold";
        goto L13
    L9:
        if (com.ss.android.lark.base.embedded.b.f() == false) goto L11;
        r1 = "SamsungFold";
        goto L13
    L11:
        r1 = "";
        goto L13
    }

    private void reportKeyboardInfo() {
        b05.a r0 = this.mKeyboardAnalytic;
        boolean r1 = f.b();
        boolean r2 = f.a(getActivity());
        boolean r3 = rcb.b.a(getActivity());
        String r4 = getSysInfo();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "info");
        HashMap r5 = new HashMap();
        r5.putAll(r0.b);
        r5.put("is_freeForm", Integer.valueOf(r1 ? 1 : 0));
        r5.put("is_MultiWindowMode", Integer.valueOf(r2 ? 1 : 0));
        r5.put("is_ex_keyboard", Integer.valueOf(r3 ? 1 : 0));
        r5.put("sys_type", r4);
        tt5.a.h("KeyboardAnalytic", "reportKeyboardInfo : " + du5.b.k(r5.toString()));
        r0.a.n("ex_keyboard_dev", r5);
    }

    public AnalyticPlugin() {
        this.hardKeyboardHidden = true;
    }

    public static /* synthetic */ d access$100(AnalyticPlugin r0) {
        return r0.mAnalyticService;
    }

    private String getAppForm(DocViewModel r2) {
        int r3 = a.a[r2.getOpenSource().ordinal()];
        if (r3 != 1) goto L5;
        return "vc";
    L5:
        if (r3 == 2) goto L8;
        return "none";
    L8:
        return "docs_feed";
    }

    private String getFilePermission(DocumentInfo r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.getDocPermission().b.getReportJson();
    }

    private String getIsOwner(DocumentInfo r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return String.valueOf(r1.getDocPermission().b.isOwner());
    }

    private String getUserPermission(DocumentInfo r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.getDocPermission().a.getReportJson();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(DocumentInfo r5) {
        this.mAnalyticService.j("docCommonParams", "user_permission", getUserPermission(r5));
        this.mAnalyticService.j("docCommonParams", "is_owner", getIsOwner(r5));
        this.mAnalyticService.j("docCommonParams", "file_permission", getFilePermission(r5));
    }

    private void lambda$onAttachToUIContainer$1(DocumentInfo r5) {
        String r0 = r5.getDocPermission().a.getReportJson();
        String r6 = r5.getDocPermission().b.getReportJson();
        this.mAnalyticService.h(NATIVE_PERMISSION_COMMON_PARAMS);
        this.mAnalyticService.j(NATIVE_PERMISSION_COMMON_PARAMS, "user_permission", r0);
        this.mAnalyticService.j(NATIVE_PERMISSION_COMMON_PARAMS, "file_permission", r6);
    }

    private void updateOrientation(Configuration r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.orientation != 2) goto L6;
        String r5 = "horizontal";
    L7:
        this.mAnalyticService.j("docCommonParams", "mobile_screen_mode", r5);
        return;
    L6:
        r5 = "vertical";
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(JS_HANDLER_SET_COMMON_PARAMS, new c(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        d r4 = (d) org.koin.java.a.a(d.class);
        this.mAnalyticService = r4;
        r4.h("docCommonParams");
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new a05.b(this));
        this.mKeyboardAnalytic = new b05.a(this.mAnalyticService);
        this.hardKeyboardHidden = rcb.b.a(getActivity());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        updateOrientation(r2);
        if (rcb.b.a(getActivity()) == this.hardKeyboardHidden) goto L6;
        reportKeyboardInfo();
        this.hardKeyboardHidden = rcb.b.a(getActivity());
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r9, t r10) {
        super.onAttachToUIContainer(r9, r10);
        DocViewModel r11 = getDocViewModel();
        BearUrl r0 = r11.getBearUrl();
        updateOrientation(getResources().getConfiguration());
        this.mAnalyticService.j("docCommonParams", "file_id", du5.b.g(r0.b));
        this.mAnalyticService.j("docCommonParams", "file_type", r0.a);
        e r1 = e.n;
        if (r11.isType(r1) == false) goto L5;
        this.mAnalyticService.j("docCommonParams", "module", r1.getType());
        this.mAnalyticService.j("docCommonParams", "page_token", du5.b.g(r11.getOriginBearUrl().b));
        this.mAnalyticService.j("docCommonParams", "container_type", FileInfoPuller.CALLER_WIKI);
        String r12 = ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).v(r9, r9.c().getArguments());
        this.mAnalyticService.j("docCommonParams", "container_id", du5.b.g(r12));
    L6:
        this.mAnalyticService.j("docCommonParams", "sub_module", "none");
        this.mAnalyticService.j("docCommonParams", "app_form", getAppForm(r11));
        r11.liveDocumentInfoData().observe(getLifecycleOwner(), new a05.a(this));
        reportKeyboardInfo();
        return;
    L5:
        this.mAnalyticService.j("docCommonParams", "module", r0.a);
        this.mAnalyticService.j("docCommonParams", "page_token", du5.b.g(r0.b));
        this.mAnalyticService.j("docCommonParams", "container_type", "folder");
        this.mAnalyticService.j("docCommonParams", "container_id", du5.b.g(r0.b));
        goto L6
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.mAnalyticService.c(BIZ_COMMON_PARAMS);
        this.mAnalyticService.c("docCommonParams");
        this.mAnalyticService.c(NATIVE_PERMISSION_COMMON_PARAMS);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
