package com.bytedance.ee.bear.clip;

import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.clip.handlers.ClipFetchHandler;
import com.bytedance.ee.bear.clip.handlers.ClipLogHandler;
import com.bytedance.ee.bear.clip.handlers.ClipOpenUrlHandler;
import com.bytedance.ee.bear.clip.handlers.ClipReportHandler;
import com.bytedance.ee.bear.clip.handlers.ClipSaveFileHandler;
import com.bytedance.ee.bear.clip.handlers.ClipToastHandler;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipExecutor implements at5.f<String, LarkWebView> {
    public static final Map<String, WeakReference<ClipExecutor>> h = null;
    public final LarkWebView a;
    public String b;
    public final g c;
    public volatile boolean d;
    public volatile boolean e;
    public ClipToastHandler f;
    public ClipFetchHandler g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/clip/ClipExecutor$InjectException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "failReason", "", "<init>", "(Ljava/lang/String;)V", "getFailReason", "()Ljava/lang/String;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InjectException extends RuntimeException {
        private final String failReason;

        public final String getFailReason() {
            return this.failReason;
        }

        public InjectException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "failReason");
            this.failReason = r2;
        }
    }

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r10) {
            Intrinsics.checkNotNullParameter((String) r10, "it");
            if (com.bytedance.ee.bear.clip.a.c().exists() == false) goto L9;
            if (com.bytedance.ee.bear.clip.a.c().isFile() == false) goto L9;
            if (com.bytedance.ee.bear.clip.a.c().length() <= 0) goto L9;
        L25:
            com.bytedance.ee.bear.clip.a.C0034a r11 = new com.bytedance.ee.bear.clip.a.C0034a(true, VFSFile.readText$default(com.bytedance.ee.bear.clip.a.c(), null, 1, null), null, 4);
        L28:
            if (r11.a == false) goto L32;
            return r11.b;
        L32:
            throw new InjectException(r11.c);
        L9:
            if (ay4.d.a().v(com.bytedance.ee.bear.clip.a.a(null).getRealPath(), "jsfile").exists() == false) goto L12;
            FileUtils.c(ay4.d.a().v(com.bytedance.ee.bear.clip.a.a(null).getRealPath(), "jsfile").getVfsPath());
        L12:
            if (com.bytedance.ee.bear.clip.a.d().exists() == true) goto L14;
            com.bytedance.ee.bear.clip.a.d().mkdirs();
        L14:
            tt5.a.h("DocsClip#ClipJsFileManager", com.bytedance.ee.bear.clip.a.c().getAbsolutePath() + " not exist, start copy and unzip");
            long r3 = System.currentTimeMillis();
            FileUtils.f(LarkContext.getApplication(), "clip.7z", com.bytedance.ee.bear.clip.a.b().getAbsolutePath());
            cw4.a.a("copy_assets", System.currentTimeMillis() - r3, null);
            if (com.bytedance.ee.bear.clip.a.b().exists() == true) goto L17;
            r11 = new com.bytedance.ee.bear.clip.a.C0034a(false, null, "copy_fail", 2);
            goto L28
        L17:
            long r5 = System.currentTimeMillis();
            com.bytedance.ee.util.io.d.a(com.bytedance.ee.bear.clip.a.b().getAbsolutePath(), com.bytedance.ee.bear.clip.a.d().getAbsolutePath());
            cw4.a.a("extract_js", System.currentTimeMillis() - r5, null);
            if (com.bytedance.ee.bear.clip.a.c().exists() == true) goto L20;
        L26:
            r11 = new com.bytedance.ee.bear.clip.a.C0034a(false, null, "unzip_fail", 2);
            goto L28
        L20:
            if (com.bytedance.ee.bear.clip.a.c().isFile() == false) goto L26;
            if (com.bytedance.ee.bear.clip.a.c().length() <= 0) goto L26;
            com.bytedance.ee.bear.clip.a.b().delete();
            goto L25
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ ClipExecutor a;
        public final /* synthetic */ String b;

        public c(ClipExecutor r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r16) {
            String r0 = (String) r16;
            Intrinsics.checkNotNullParameter(r0, "it");
            ClipExecutor r17 = this.a;
            String r2 = this.b;
            r17.getClass();
            long r6 = System.currentTimeMillis();
            String r8 = StringsKt.replaceFirst$default(r0, "{{ secret_key }}", r2, false, 4, null);
            if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.docs.clip_specify_enable") == false) goto L5;
            String r18 = "True";
        L6:
            String r19 = StringsKt.replaceFirst$default(r8, "{{ specify_enable }}", r18, false, 4, null);
            cw4.a.a("replace", System.currentTimeMillis() - r6, null);
            return r19;
        L5:
            r18 = "False";
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ClipExecutor a;

        public d(ClipExecutor r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            j.d(this.a.c, ToastModel.DEFAULT_DURATION);
            LarkWebView r0 = this.a.a;
            r0.evaluateJavascript((String) r4, null);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ClipExecutor a;

        public e(ClipExecutor r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("DocsClip#ClipExecutor", "doInject error", r5, false);
            this.a.e = false;
            ClipExecutor r0 = this.a;
            if ((r5 instanceof InjectException) == false) goto L5;
            String r6 = ((InjectException) r5).getFailReason();
        L6:
            r0.c(r6);
            return;
        L5:
            r6 = "inject_js_fail";
            goto L6
        }
    }

    public static final class f implements at5.j {
        public f() {
        }

        public final void a(Status r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "status");
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ ClipExecutor a;

        public g(ClipExecutor r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClipExecutor r0 = this.a;     // Catch: Throwable -> L4
            r0.d = true;     // Catch: Throwable -> L4
            r0.e = false;     // Catch: Throwable -> L4
            r0.c("inject_js_timeout");     // Catch: Throwable -> L4
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

    public final boolean shouldRunInUIThread() {
        return true;
    }

    static {
        h = new LinkedHashMap();
    }

    public final void b() {
        tt5.a.h("DocsClip#ClipExecutor", "doInject");
        at5.a r0 = this.a.getBridge();
        String r2 = UUID.randomUUID().toString();
        tt5.a.h("DocsClip#ClipExecutor", "generateSecretKey: " + r2);
        this.f = new ClipToastHandler();
        this.g = new ClipFetchHandler(r2);
        r0.c("saveFile", new ClipSaveFileHandler());
        ClipToastHandler r1 = this.f;
        Intrinsics.checkNotNull(r1);
        r0.c("showToast", r1);
        ClipFetchHandler r3 = this.g;
        Intrinsics.checkNotNull(r3);
        r0.c("nativeFetch", r3);
        r0.c("openUrl", new ClipOpenUrlHandler());
        r0.c("reportEvent", new ClipReportHandler());
        r0.c("getLang", new com.bytedance.ee.bear.clip.handlers.d());
        r0.c("printLog", new ClipLogHandler());
        r0.c("notifyJsReady", this);
        Flowable.just("").map(b.a).map(new c(this, r2)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
    }

    public final void c(String r6) {
        ClipToastHandler r0 = this.f;
        if (r0 == null) goto L5;
        ClipToastHandler.ToastData r1 = new ClipToastHandler.ToastData();
        r1.setStatus(2);
        r1.setProgress(0);
        r1.setFailReason(0);
        r1.setShowRetry(false);
        r0.b(r1, new f(), this.a);
    L5:
        int r2 = cw4.a.a;
        String r3 = this.b;
        Intrinsics.checkNotNullParameter(r3, "website");
        Intrinsics.checkNotNullParameter(r6, "failReason");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("click", "fail");
        r4.put("target", "ccm_clip_prompt_view");
        r4.put("click_source", "im_card");
        r4.put("website", r3);
        r4.put("login_state", "true");
        r4.put("version", "2.0.3");
        r4.put("is_latest_flag", "true");
        r4.put("is_real_fail_flag", "false");
        r4.put("fail_reason", r6);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_clip_result_click", r4);
        tt5.a.h("DocsClip#ClipReport", "event: ccm_clip_result_click, params: " + r4);
    }

    public ClipExecutor(LarkWebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.a = r2;
        this.b = r3;
        this.c = new g(this);
    }

    public final void a(Object r2, at5.d r3, String r4, LarkWebView r5) {
        String r6 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        tt5.a.h("DocsClip#ClipExecutor", "notifyJsReady, timeout = " + this.d);
        j.e(this.c);
        this.e = false;
        if (this.d == true) goto L7;
        r3.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operation", "start_clip"), TuplesKt.to("networkStatus", Integer.valueOf(!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() ? 1 : 0))}));
        return;
    }
}
