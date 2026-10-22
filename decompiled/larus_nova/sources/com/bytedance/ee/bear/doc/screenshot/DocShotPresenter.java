package com.bytedance.ee.bear.doc.screenshot;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.utils.n;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import fz4.a0;
import fz4.b0;
import fz4.e;
import fz4.f;
import fz4.g;
import fz4.h;
import fz4.i;
import fz4.o;
import fz4.s;
import fz4.t;
import fz4.u;
import fz4.v;
import fz4.w;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import sa5.r;

/* JADX INFO: loaded from: classes16.dex */
public final class DocShotPresenter implements a0, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hz4.b f218072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f218073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m.b f218074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fz4.r f218075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f218076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b0 f218077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebView f218078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VFSPath f218079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VFSPath f218080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f218081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f218082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f218083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f218084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f218085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f218086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f218087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f218088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f218089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f218090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f218091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f218092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f218093v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f218094w;

    public @interface SCREEN_SHOT_STATE {
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218095a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            f218095a = r100;
            r100[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f218095a[ShareType.Wechat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f218095a[ShareType.WechatMoments.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f218095a[ShareType.QQ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f218095a[ShareType.Weibo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f218095a[ShareType.More.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f218095a[ShareType.Download.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final Context c() {
        return this.f218076e.getApplication();
    }

    public final void e() {
        if (this.f218091t == false) goto L27;
        boolean r100 = true;
        if (this.f218093v.get() >= 1) goto L28;
        FragmentActivity r101 = this.f218076e;
        if (r101 != null) goto L9;
    L11:
        r100 = false;
    L12:
        if (r100 == false) goto L29;
        this.f218093v.incrementAndGet();
        zo5.b r102 = (zo5.b) org.koin.java.a.a(zo5.b.class);
        zo5.a r103 = r102.m();
        tt5.a.h("DocShotPresenter", "attachWatermarkActivity info=" + r103);
        if (TextUtils.equals(this.f218082k, r103.f573126a) == true) goto L17;
        tt5.a.k("DocShotPresenter", "attachWatermarkActivity token is different!! force add watermark");
        r102.n(this.f218076e);
        return;
    L17:
        if (r103.f573128c == true) goto L22;
        if (r103.f573129d == false) goto L31;
        r102.n(this.f218076e);
        return;
    L31:
        return;
    L22:
        if (r103.f573130e == false) goto L24;
    L25:
        r102.q(this.f218076e);
        return;
    L24:
        if (r103.f573131f == true) goto L25;
        return;
    L29:
        return;
    L9:
        if (r101.isFinishing() == true) goto L11;
    L28:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [fz4.r, java.lang.Runnable] */
    public final boolean k() {
        this.f218073b.setValue(Boolean.FALSE);
        tt5.a.b("DocShotPresenter", "onBackPressed()...");
        this.f218086o = true;
        j(1, this.f218078g);
        hz4.b r100 = this.f218072a;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        c r101 = this.f218089r;
        if (r101 == null) goto L8;
        ((fz4.b) r101).a();
    L8:
        b0 r102 = this.f218077f;
        if (r102 == null) goto L11;
        r102.setSnapState(false);
    L11:
        b0 r103 = this.f218077f;
        if (r103 != null) goto L14;
    L26:
        return false;
    L14:
        if (((DocShotView) r103).getVisibility() != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L26;
        if ("doc".equals(this.f218083l) == false) goto L24;
        fz4.r r105 = this.f218075d;
        if (r105 == null) goto L23;
        j.e(r105);
    L23:
        ?? r106 = new fz4.r(this);
        this.f218075d = r106;
        j.d(r106, 500);
    L25:
        return true;
    L24:
        ((DocShotView) this.f218077f).f();
        goto L25
    L16:
        r104 = false;
        goto L17
    }

    public static void m(ShareType r100) {
        HashMap r101 = new HashMap();     // Catch: Exception -> L21
        r101.put("action", "share_button_click");     // Catch: Exception -> L21
        int r102 = a.f218095a[r100.ordinal()];     // Catch: Exception -> L21
        if (r102 != 2) goto L6;
        r101.put("to_platform", "wechat");     // Catch: Exception -> L21
    L19:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_long_image_share", r101);     // Catch: Exception -> L21
        return;
    L6:
        if (r102 != 3) goto L8;
        r101.put("to_platform", "wechat_article");     // Catch: Exception -> L21
        goto L19
    L8:
        if (r102 != 4) goto L10;
        r101.put("to_platform", "qq");     // Catch: Exception -> L21
        goto L19
    L10:
        if (r102 != 5) goto L12;
        r101.put("to_platform", "weibo");     // Catch: Exception -> L21
        goto L19
    L12:
        if (r102 != 6) goto L19;
        r101.put("to_platform", "more");     // Catch: Exception -> L21
    L21:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }

    public final Single<VFSPath> d(VFSPath r100) {
        if (r100 != null) goto L4;
    L23:
        StringBuilder r101 = new StringBuilder("[watermark remaining] originalPath invalid: ");
        if (r100 != null) goto L26;
        String r102 = "null";
    L27:
        r101.append(r102);
        return Single.error(new IllegalArgumentException(r101.toString()));
    L26:
        r102 = r100.getRealPath();
        goto L27
    L4:
        if (r100.toFile().exists() == false) goto L23;
        if (r100.toFile().isFile() == false) goto L23;
        if (this.f218092u == true) goto L12;
        tt5.a.h("DocShotPresenter", "[watermark remaining] disabled, return originalPath = " + r100.getRealPath());
        return Single.just(Boolean.TRUE).map(new h(r100));
    L12:
        VFSPath r103 = this.f218080i;
        if (r103 == null) goto L21;
        VFSFile r104 = r103.toFile();
        if (r104.exists() == true) goto L17;
    L20:
        tt5.a.k("DocShotPresenter", "[watermark remaining] cached file invalid, regenerate. path=" + r104.getAbsolutePath());
        this.f218080i = null;
        goto L21
    L17:
        if (r104.isFile() == false) goto L20;
        tt5.a.h("DocShotPresenter", "[watermark remaining] reuse cached file = " + r104.getAbsolutePath());
        return Single.just(Boolean.TRUE).map(new i(this));
    L21:
        tt5.a.h("DocShotPresenter", "[watermark remaining] enabled, generating new watermarked image from path = " + r100.getRealPath());
        tt5.a.h("DocShotPresenter", "[watermark remaining] original size = " + lu5.a.b(r100) + " px");
        Toast.showLoading(c(), c().getString(R.string.Doc_Share_ExportImageLoading));
        String r105 = r100.getRealPath();
        Lazy<zo5.b> r106 = CCMWatermarkManager.f220231a;
        Intrinsics.checkNotNullParameter(r105, "filePath");
        return CCMWatermarkManager.f220231a.getValue().e(r105).flatMap(new fz4.j(this));
    }

    public final boolean g(ShareType r100) {
        switch(a.f218095a[r100.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        return f(R.string.CreationMobile_ECM_SecuritySettingKAToast, true);
    L8:
        return f(R.string.CreationMobile_ECM_ShareSecuritySettingKAToast, false);
    }

    public DocShotPresenter(FragmentActivity r100, boolean r101) {
        this.f218073b = new MutableLiveData();
        this.f218087p = 0;
        this.f218088q = 0;
        boolean r102 = true;
        this.f218093v = new AtomicInteger(1);
        this.f218076e = r100;
        boolean r103 = !r101;
        this.f218090s = r103;
        boolean r104 = wo5.c.a("admin.security.watermark.file.switch");
        boolean r105 = wo5.c.a("admin.security.watermark.file.switch.docx");
        if (r104 == false) goto L6;
        if (r105 == false) goto L6;
    L7:
        this.f218091t = r102;
        boolean r106 = wo5.c.a("admin.watermark.filewatermark.remaining");
        this.f218092u = r106;
        tt5.a.h("DocShotPresenter", "mCppEncodeEnabled=" + r103 + ", mPartBitmapShotOptimization=" + r102 + ", mIsWatermarkRemainingEnable=" + r106);
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static void a(DocShotPresenter r100, boolean r101) {
        WebView r102 = r100.f218078g;
        if (r102 == null) goto L10;
        boolean r103 = r102.isVerticalScrollBarEnabled();
        if (r101 == false) goto L8;
        if (r103 == false) goto L8;
        r100.f218078g.setVerticalScrollBarEnabled(true);
        return;
    L8:
        r100.f218078g.setVerticalScrollBarEnabled(false);
        return;
    }

    public final boolean f(int r100, boolean r101) {
        if (CipherManager.d() != 1) goto L9;
        FragmentActivity r102 = this.f218076e;
        if (r102 == null) goto L7;
        Toast.showText(r102, r102.getString(r100), 1, r101);
    L7:
        CipherManager.h();
        return false;
    L9:
        return true;
    }

    public final void h(final ShareType r100, final boolean r101) {
        switch(a.f218095a[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L5;
            default: goto L26;
        };
    L5:
        final com.bytedance.ee.bear.doc.screenshot.a r102 = new com.bytedance.ee.bear.doc.screenshot.a(this);
        tt5.a.h("DocShotPresenter", "onSaveDocBitmap()....");
        if (CipherManager.d() != 1) goto L8;
        Toast.showText(c(), c().getString(R.string.CreationMobile_ECM_SecuritySettingKAToast), 1, true);
        CipherManager.h();
        r102.a(false);
        return;
    L8:
        com.ss.android.lark.utils.h.g(this.f218076e, new fz4.d(this, r102), n.a(), new Token("LARK-PSDA-ccm_docs_export_image"), new String[0]);
        return;
    L9:
        m(r100);
        tt5.a.b("DocShotPresenter", "onShareDoc()...");
        d(this.f218079h).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).doFinally(new o()).subscribe(new s(this), new t());
        return;
    L10:
        m(r100);
        tt5.a.b("DocShotPresenter", "onShareToExternalApp()... channel = " + r100.name());
        final ExternalShareMinaConfig r103 = (ExternalShareMinaConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        d(this.f218079h).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).doFinally(new o()).subscribe(new f(this, r101, r103, r100), new g());
        return;
    L11:
        m(r100);
        VFSPath r104 = this.f218079h;
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.toFile().exists() == true) goto L16;
        return;
    L16:
        if (this.f218079h.toFile().isFile() == false) goto L27;
        Uri r105 = Uri.fromFile(this.f218079h.toFile());
        final ArrayList r106 = new ArrayList();
        r106.add(r105);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new u()).map(new v(r106)).subscribe(new w(), new e());
        return;
    L27:
        return;
    }

    public final void i(String r100, DocShotModel r101) {
        this.f218073b.setValue(Boolean.FALSE);
        WebView r102 = this.f218078g;
        if (r102 == null) goto L5;
        r102.scrollTo(0, this.f218094w);
    L5:
        tt5.a.h("DocShotPresenter", "docShotFail()..");
        b0 r103 = this.f218077f;
        if (r103 == null) goto L8;
        r103.setSnapState(false);
    L8:
        b0 r104 = this.f218077f;
        if (r104 == null) goto L11;
        ((DocShotView) r104).c();
    L11:
        m.b r105 = this.f218074c;
        if (r105 == null) goto L14;
        com.bytedance.ee.bear.document.export.e.b(((com.bytedance.ee.bear.document.export.a.C3128a) r105).f219691a.f219690c, "jpg_long");
        this.f218074c = null;
    L14:
        c r106 = this.f218089r;
        if (r106 == null) goto L17;
        ((fz4.b) r106).a();
    L17:
        this.f218079h = null;
        this.f218080i = null;
        j(1, this.f218078g);
        l(1, r100, r101);
    }

    public final void j(int r100, WebView r101) {
        StringBuilder r102 = new StringBuilder("notifyJScreenShot state=");
        r102.append(r100);
        r102.append(", exportType=");
        r102.append(this.f218084m);
        r102.append(", webViewNull=");
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        tt5.a.h("DocShotPresenter", r102.toString());
        if (r101 != null) goto L10;
        tt5.a.k("DocShotPresenter", "notifyJScreenShot skip: webView is null");
        return;
    L10:
        JSONObject r104 = new JSONObject();
        r104.put2("state", Integer.valueOf(r100));
        if (TextUtils.isEmpty(this.f218084m) == true) goto L13;
        r104.put2("exportType", this.f218084m);
    L13:
        ap5.a.a(r101, "javascript:window.native.screenshot", r104, null);
        this.f218078g = r101;
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void l(int r100, String r101, DocShotModel r102) {
        HashMap r103 = new HashMap();     // Catch: Exception -> L12
        r103.put("file_id", du5.b.g(this.f218082k));     // Catch: Exception -> L12
        String r104 = this.f218083l;     // Catch: Exception -> L12
        if (r104 != null) goto L5;
        r104 = sbb.e.f541296g.getType();     // Catch: Exception -> L12
    L5:
        r103.put("file_type", r104);     // Catch: Exception -> L12
        r103.put("status_code", Integer.valueOf(r100));     // Catch: Exception -> L12
        r103.put("status_name", r101);     // Catch: Exception -> L12
        if (r102 != null) goto L8;
    L10:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_generate_long_image", r103);     // Catch: Exception -> L12
        return;
    L8:
        if (r102.success == true) goto L10;
        r103.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r102.image_count));     // Catch: Exception -> L12
        r103.put("image_load_count", Integer.valueOf(r102.image_load_count));     // Catch: Exception -> L12
        r103.put("image_load_timeout", Boolean.valueOf(r102.image_load_timeout));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }

    public static void b(DocShotPresenter r110, int r111, int r112, int r113, int r114, int r115) {
        r110.getClass();
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r110.f218087p != 0) goto L7;
        r110.f218087p = r100;     // Catch: Exception -> L19
    L7:
        if (r110.f218088q != 0) goto L9;
        r110.f218088q = r100;     // Catch: Exception -> L19
    L9:
        if (r113 == 0) goto L13;
        int r101 = r112 / r113;     // Catch: Exception -> L19
        if ((r112 % r113) <= 0) goto L14;
        r101 = r101 + 1;     // Catch: Exception -> L19
    L14:
        HashMap r116 = new HashMap();     // Catch: Exception -> L19
        r116.put("file_id", du5.b.g(r110.f218082k));     // Catch: Exception -> L19
        String r102 = r110.f218083l;     // Catch: Exception -> L19
        if (r102 != null) goto L17;
        r102 = sbb.e.f541296g.getType();     // Catch: Exception -> L19
    L17:
        r116.put("file_type", r102);     // Catch: Exception -> L19
        r116.put("time_cost_ms", String.valueOf(r100 - r110.f218087p));     // Catch: Exception -> L19
        r116.put("js_cost_ms", String.valueOf(r110.f218088q - r110.f218087p));     // Catch: Exception -> L19
        r116.put("native_cost_ms", String.valueOf(r100 - r110.f218088q));     // Catch: Exception -> L19
        r116.put("width", String.valueOf(r111));     // Catch: Exception -> L19
        r116.put("height", String.valueOf(r112));     // Catch: Exception -> L19
        r116.put("page_count", String.valueOf(r101));     // Catch: Exception -> L19
        r116.put("retry_count", String.valueOf(r115));     // Catch: Exception -> L19
        r116.put("file_size", String.valueOf((((r111 * r112) * 2) / 1024) / 1024));     // Catch: Exception -> L19
        r116.put("status_code", String.valueOf(r114));     // Catch: Exception -> L19
        tt5.a.h("DocShotPresenter", r116.toString());     // Catch: Exception -> L19
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_long_image_info", r116);     // Catch: Exception -> L19
        return;
    L13:
        r101 = 0;
    L19:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }
}
