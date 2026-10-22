package com.bytedance.ee.bear.clip;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.clip.handlers.ClipFetchHandler;
import com.bytedance.ee.bear.clip.handlers.ClipLogHandler;
import com.bytedance.ee.bear.clip.handlers.ClipOpenUrlHandler;
import com.bytedance.ee.bear.clip.handlers.ClipReportHandler;
import com.bytedance.ee.bear.clip.handlers.ClipSaveFileHandler;
import com.bytedance.ee.bear.clip.handlers.ClipToastHandler;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class ClipExecutor implements at5.f<String, LarkWebView> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, WeakReference<ClipExecutor>> f216654h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkWebView f216655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f216656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f216657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f216658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f216659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ClipToastHandler f216660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClipFetchHandler f216661g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/clip/ClipExecutor$InjectException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "failReason", "", "<init>", "(Ljava/lang/String;)V", "getFailReason", "()Ljava/lang/String;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InjectException extends RuntimeException {
        private final String failReason;

        public final String getFailReason() {
            return this.failReason;
        }

        public InjectException(String r100) {
            Intrinsics.checkNotNullParameter(r100, "failReason");
            this.failReason = r100;
        }
    }

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f216662a = null;

        static {
            f216662a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            Intrinsics.checkNotNullParameter((String) r110, "it");
            if (com.bytedance.ee.bear.clip.a.c().exists() == false) goto L9;
            if (com.bytedance.ee.bear.clip.a.c().isFile() == false) goto L9;
            if (com.bytedance.ee.bear.clip.a.c().length() <= 0) goto L9;
        L25:
            com.bytedance.ee.bear.clip.a.C3090a r111 = new com.bytedance.ee.bear.clip.a.C3090a(true, VFSFile.readText$default(com.bytedance.ee.bear.clip.a.c(), null, 1, null), null, 4);
        L28:
            if (r111.f216671a == false) goto L32;
            return r111.f216672b;
        L32:
            throw new InjectException(r111.f216673c);
        L9:
            if (ay4.d.a().v(com.bytedance.ee.bear.clip.a.a(null).getRealPath(), "jsfile").exists() == false) goto L12;
            FileUtils.c(ay4.d.a().v(com.bytedance.ee.bear.clip.a.a(null).getRealPath(), "jsfile").getVfsPath());
        L12:
            if (com.bytedance.ee.bear.clip.a.d().exists() == true) goto L14;
            com.bytedance.ee.bear.clip.a.d().mkdirs();
        L14:
            tt5.a.h("DocsClip#ClipJsFileManager", com.bytedance.ee.bear.clip.a.c().getAbsolutePath() + " not exist, start copy and unzip");
            long r100 = System.currentTimeMillis();
            FileUtils.f(LarkContext.getApplication(), "clip.7z", com.bytedance.ee.bear.clip.a.b().getAbsolutePath());
            cw4.a.a("copy_assets", System.currentTimeMillis() - r100, null);
            if (com.bytedance.ee.bear.clip.a.b().exists() == true) goto L17;
            r111 = new com.bytedance.ee.bear.clip.a.C3090a(false, null, "copy_fail", 2);
            goto L28
        L17:
            long r101 = System.currentTimeMillis();
            com.bytedance.ee.util.io.d.a(com.bytedance.ee.bear.clip.a.b().getAbsolutePath(), com.bytedance.ee.bear.clip.a.d().getAbsolutePath());
            cw4.a.a("extract_js", System.currentTimeMillis() - r101, null);
            if (com.bytedance.ee.bear.clip.a.c().exists() == true) goto L20;
        L26:
            r111 = new com.bytedance.ee.bear.clip.a.C3090a(false, null, "unzip_fail", 2);
            goto L28
        L20:
            if (com.bytedance.ee.bear.clip.a.c().isFile() == false) goto L26;
            if (com.bytedance.ee.bear.clip.a.c().length() <= 0) goto L26;
            com.bytedance.ee.bear.clip.a.b().delete();
            goto L25
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClipExecutor f216663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f216664b;

        public c(ClipExecutor r100, String r101) {
            this.f216663a = r100;
            this.f216664b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            String r100 = (String) r110;
            Intrinsics.checkNotNullParameter(r100, "it");
            ClipExecutor r111 = this.f216663a;
            String r101 = this.f216664b;
            r111.getClass();
            long r102 = System.currentTimeMillis();
            String r103 = StringsKt.replaceFirst$default(r100, "{{ secret_key }}", r101, false, 4, null);
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.docs.clip_specify_enable") == false) goto L5;
            String r112 = BdpAppEventConstant.TRUE;
        L6:
            String r113 = StringsKt.replaceFirst$default(r103, "{{ specify_enable }}", r112, false, 4, null);
            cw4.a.a("replace", System.currentTimeMillis() - r102, null);
            return r113;
        L5:
            r112 = BdpAppEventConstant.FALSE;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClipExecutor f216665a;

        public d(ClipExecutor r100) {
            this.f216665a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            j.d(this.f216665a.f216657c, 3000);
            LarkWebView r101 = this.f216665a.f216655a;
            r101.evaluateJavascript((String) r100, null);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClipExecutor f216666a;

        public e(ClipExecutor r100) {
            this.f216666a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("DocsClip#ClipExecutor", "doInject error", r101, false);
            this.f216666a.f216659e = false;
            ClipExecutor r102 = this.f216666a;
            if ((r101 instanceof InjectException) == false) goto L5;
            String r103 = ((InjectException) r101).getFailReason();
        L6:
            r102.c(r103);
            return;
        L5:
            r103 = "inject_js_fail";
            goto L6
        }
    }

    public static final class f implements at5.j {
        public f() {
        }

        @Override // at5.j
        public final void a(Status r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClipExecutor f216667a;

        public g(ClipExecutor r100) {
            this.f216667a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClipExecutor r100 = this.f216667a;     // Catch: Throwable -> L4
            r100.f216658d = true;     // Catch: Throwable -> L4
            r100.f216659e = false;     // Catch: Throwable -> L4
            r100.c("inject_js_timeout");     // Catch: Throwable -> L4
            tt5.a.d("DocsClip#ClipExecutor", "inject js timeout!");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // at5.f
    public final boolean shouldRunInUIThread() {
        return true;
    }

    static {
        f216654h = new LinkedHashMap();
    }

    public final void b() {
        tt5.a.h("DocsClip#ClipExecutor", "doInject");
        at5.a r100 = this.f216655a.getBridge();
        String r101 = UUID.randomUUID().toString();
        tt5.a.h("DocsClip#ClipExecutor", "generateSecretKey: " + r101);
        this.f216660f = new ClipToastHandler();
        this.f216661g = new ClipFetchHandler(r101);
        r100.c("saveFile", new ClipSaveFileHandler());
        ClipToastHandler r102 = this.f216660f;
        Intrinsics.checkNotNull(r102);
        r100.c("showToast", r102);
        ClipFetchHandler r103 = this.f216661g;
        Intrinsics.checkNotNull(r103);
        r100.c("nativeFetch", r103);
        r100.c(RuleConditionBean.OPEN_URL_KEY, new ClipOpenUrlHandler());
        r100.c("reportEvent", new ClipReportHandler());
        r100.c("getLang", new com.bytedance.ee.bear.clip.handlers.d());
        r100.c("printLog", new ClipLogHandler());
        r100.c("notifyJsReady", this);
        Flowable.just("").map(b.f216662a).map(new c(this, r101)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
    }

    public final void c(String r100) {
        ClipToastHandler r101 = this.f216660f;
        if (r101 == null) goto L5;
        ClipToastHandler.ToastData r102 = new ClipToastHandler.ToastData();
        r102.setStatus(2);
        r102.setProgress(0);
        r102.setFailReason(0);
        r102.setShowRetry(false);
        r101.b(r102, new f(), this.f216655a);
    L5:
        int r103 = cw4.a.f465575a;
        String r104 = this.f216656b;
        Intrinsics.checkNotNullParameter(r104, "website");
        Intrinsics.checkNotNullParameter(r100, "failReason");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("click", "fail");
        r105.put(PickerReporterConstants.KEY.TARGET, "ccm_clip_prompt_view");
        r105.put("click_source", "im_card");
        r105.put("website", r104);
        r105.put("login_state", "true");
        r105.put("version", "2.0.3");
        r105.put("is_latest_flag", "true");
        r105.put("is_real_fail_flag", "false");
        r105.put("fail_reason", r100);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_clip_result_click", r105);
        tt5.a.h("DocsClip#ClipReport", "event: ccm_clip_result_click, params: " + r105);
    }

    public ClipExecutor(LarkWebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f216655a = r100;
        this.f216656b = r101;
        this.f216657c = new g(this);
    }

    @Override // at5.f
    public final void a(Object r100, at5.d r101, String r102, LarkWebView r103) {
        String r104 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "callback");
        tt5.a.h("DocsClip#ClipExecutor", "notifyJsReady, timeout = " + this.f216658d);
        j.e(this.f216657c);
        this.f216659e = false;
        if (this.f216658d == true) goto L7;
        r101.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.OPT, "start_clip"), TuplesKt.to(Constants.OperatorKey.KEY_NETWORK_STATUS, Integer.valueOf(!com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() ? 1 : 0))}));
        return;
    }
}
