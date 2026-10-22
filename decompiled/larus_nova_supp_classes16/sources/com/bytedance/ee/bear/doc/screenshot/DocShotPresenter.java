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
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.bytedance.supervisor.token.Token;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocShotPresenter implements a0, r {
    public hz4.b a;
    public final MutableLiveData<Boolean> b;
    public m.b c;
    public fz4.r d;
    public final FragmentActivity e;
    public b0 f;
    public WebView g;
    public VFSPath h;
    public VFSPath i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public long p;
    public long q;
    public c r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final AtomicInteger v;
    public int w;

    public @interface SCREEN_SHOT_STATE {
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            a = r0;
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[ShareType.Wechat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[ShareType.WechatMoments.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[ShareType.QQ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[ShareType.Weibo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[ShareType.More.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ShareType.Download.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final Context c() {
        return this.e.getApplication();
    }

    public final void e() {
        if (this.t == false) goto L27;
        boolean r1 = true;
        if (this.v.get() >= 1) goto L28;
        FragmentActivity r0 = this.e;
        if (r0 != null) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L29;
        this.v.incrementAndGet();
        zo5.b r2 = (zo5.b) org.koin.java.a.a(zo5.b.class);
        zo5.a r3 = r2.m();
        tt5.a.h("DocShotPresenter", "attachWatermarkActivity info=" + r3);
        if (TextUtils.equals(this.k, r3.a) == true) goto L17;
        tt5.a.k("DocShotPresenter", "attachWatermarkActivity token is different!! force add watermark");
        r2.n(this.e);
        return;
    L17:
        if (r3.c == true) goto L22;
        if (r3.d == false) goto L31;
        r2.n(this.e);
        return;
    L31:
        return;
    L22:
        if (r3.e == false) goto L24;
    L25:
        r2.q(this.e);
        return;
    L24:
        if (r3.f == true) goto L25;
        return;
    L29:
        return;
    L9:
        if (r0.isFinishing() == true) goto L11;
    L28:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [fz4.r, java.lang.Runnable] */
    public final boolean k() {
        this.b.setValue(Boolean.FALSE);
        tt5.a.b("DocShotPresenter", "onBackPressed()...");
        this.o = true;
        j(1, this.g);
        hz4.b r1 = this.a;
        if (r1 == null) goto L5;
        r1.stop();
    L5:
        c r2 = this.r;
        if (r2 == null) goto L8;
        ((fz4.b) r2).a();
    L8:
        b0 r3 = this.f;
        if (r3 == null) goto L11;
        r3.setSnapState(false);
    L11:
        b0 r4 = this.f;
        if (r4 != null) goto L14;
    L26:
        return false;
    L14:
        if (((DocShotView) r4).getVisibility() != 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L26;
        if ("doc".equals(this.l) == false) goto L24;
        fz4.r r6 = this.d;
        if (r6 == null) goto L23;
        j.e(r6);
    L23:
        ?? r7 = new fz4.r(this);
        this.d = r7;
        j.d(r7, 500);
    L25:
        return true;
    L24:
        ((DocShotView) this.f).f();
        goto L25
    L16:
        r5 = false;
        goto L17
    }

    public static void m(ShareType r3) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L21
        r0.put(JSEventListener.ACTION, "share_button_click");     // Catch: Exception -> L21
        int r4 = a.a[r3.ordinal()];     // Catch: Exception -> L21
        if (r4 != 2) goto L6;
        r0.put("to_platform", "wechat");     // Catch: Exception -> L21
    L19:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_long_image_share", r0);     // Catch: Exception -> L21
        return;
    L6:
        if (r4 != 3) goto L8;
        r0.put("to_platform", "wechat_article");     // Catch: Exception -> L21
        goto L19
    L8:
        if (r4 != 4) goto L10;
        r0.put("to_platform", "qq");     // Catch: Exception -> L21
        goto L19
    L10:
        if (r4 != 5) goto L12;
        r0.put("to_platform", "weibo");     // Catch: Exception -> L21
        goto L19
    L12:
        if (r4 != 6) goto L19;
        r0.put("to_platform", "more");     // Catch: Exception -> L21
    L21:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }

    public final Single<VFSPath> d(VFSPath r6) {
        if (r6 != null) goto L4;
    L23:
        StringBuilder r1 = new StringBuilder("[watermark remaining] originalPath invalid: ");
        if (r6 != null) goto L26;
        String r7 = "null";
    L27:
        r1.append(r7);
        return Single.error(new IllegalArgumentException(r1.toString()));
    L26:
        r7 = r6.getRealPath();
        goto L27
    L4:
        if (r6.toFile().exists() == false) goto L23;
        if (r6.toFile().isFile() == false) goto L23;
        if (this.u == true) goto L12;
        tt5.a.h("DocShotPresenter", "[watermark remaining] disabled, return originalPath = " + r6.getRealPath());
        return Single.just(Boolean.TRUE).map(new h(r6));
    L12:
        VFSPath r0 = this.i;
        if (r0 == null) goto L21;
        VFSFile r2 = r0.toFile();
        if (r2.exists() == true) goto L17;
    L20:
        tt5.a.k("DocShotPresenter", "[watermark remaining] cached file invalid, regenerate. path=" + r2.getAbsolutePath());
        this.i = null;
        goto L21
    L17:
        if (r2.isFile() == false) goto L20;
        tt5.a.h("DocShotPresenter", "[watermark remaining] reuse cached file = " + r2.getAbsolutePath());
        return Single.just(Boolean.TRUE).map(new i(this));
    L21:
        tt5.a.h("DocShotPresenter", "[watermark remaining] enabled, generating new watermarked image from path = " + r6.getRealPath());
        tt5.a.h("DocShotPresenter", "[watermark remaining] original size = " + lu5.a.b(r6) + " px");
        Toast.showLoading(c(), c().getString(2131888211));
        String r8 = r6.getRealPath();
        Lazy<zo5.b> r3 = CCMWatermarkManager.a;
        Intrinsics.checkNotNullParameter(r8, "filePath");
        return ((zo5.b) CCMWatermarkManager.a.getValue()).e(r8).flatMap(new fz4.j(this));
    }

    public final boolean g(ShareType r2) {
        switch(a.a[r2.ordinal()]) {
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
        return f(2131887290, true);
    L8:
        return f(2131887299, false);
    }

    public DocShotPresenter(FragmentActivity r4, boolean r5) {
        this.b = new MutableLiveData();
        this.p = 0;
        this.q = 0;
        boolean r1 = true;
        this.v = new AtomicInteger(1);
        this.e = r4;
        boolean r6 = !r5;
        this.s = r6;
        boolean r7 = wo5.c.a("admin.security.watermark.file.switch");
        boolean r0 = wo5.c.a("admin.security.watermark.file.switch.docx");
        if (r7 == false) goto L6;
        if (r0 == false) goto L6;
    L7:
        this.t = r1;
        boolean r8 = wo5.c.a("admin.watermark.filewatermark.remaining");
        this.u = r8;
        tt5.a.h("DocShotPresenter", "mCppEncodeEnabled=" + r6 + ", mPartBitmapShotOptimization=" + r1 + ", mIsWatermarkRemainingEnable=" + r8);
        return;
    L6:
        r1 = false;
        goto L7
    }

    public static void a(DocShotPresenter r1, boolean r2) {
        WebView r0 = r1.g;
        if (r0 == null) goto L10;
        boolean r3 = r0.isVerticalScrollBarEnabled();
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        r1.g.setVerticalScrollBarEnabled(true);
        return;
    L8:
        r1.g.setVerticalScrollBarEnabled(false);
        return;
    }

    public final boolean f(int r3, boolean r4) {
        if (CipherManager.d() != 1) goto L9;
        FragmentActivity r0 = this.e;
        if (r0 == null) goto L7;
        Toast.showText(r0, r0.getString(r3), 1, r4);
    L7:
        CipherManager.h();
        return false;
    L9:
        return true;
    }

    public final void h(final ShareType r5, final boolean r6) {
        switch(a.a[r5.ordinal()]) {
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
        final com.bytedance.ee.bear.doc.screenshot.a r7 = new com.bytedance.ee.bear.doc.screenshot.a(this);
        tt5.a.h("DocShotPresenter", "onSaveDocBitmap()....");
        if (CipherManager.d() != 1) goto L8;
        Toast.showText(c(), c().getString(2131887290), 1, true);
        CipherManager.h();
        r7.a(false);
        return;
    L8:
        com.ss.android.lark.utils.h.g(this.e, new fz4.d(this, r7), n.a(), new Token("LARK-PSDA-ccm_docs_export_image"), new String[0]);
        return;
    L9:
        m(r5);
        tt5.a.b("DocShotPresenter", "onShareDoc()...");
        d(this.h).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).doFinally(new o()).subscribe(new s(this), new t());
        return;
    L10:
        m(r5);
        tt5.a.b("DocShotPresenter", "onShareToExternalApp()... channel = " + r5.name());
        final ExternalShareMinaConfig r0 = (ExternalShareMinaConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        d(this.h).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).doFinally(new o()).subscribe(new f(this, r6, r0, r5), new g());
        return;
    L11:
        m(r5);
        VFSPath r8 = this.h;
        if (r8 != null) goto L14;
        return;
    L14:
        if (r8.toFile().exists() == true) goto L16;
        return;
    L16:
        if (this.h.toFile().isFile() == false) goto L27;
        Uri r9 = Uri.fromFile(this.h.toFile());
        final ArrayList r10 = new ArrayList();
        r10.add(r9);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new u()).map(new v(r10)).subscribe(new w(), new e());
        return;
    L27:
        return;
    }

    public final void i(String r4, DocShotModel r5) {
        this.b.setValue(Boolean.FALSE);
        WebView r0 = this.g;
        if (r0 == null) goto L5;
        r0.scrollTo(0, this.w);
    L5:
        tt5.a.h("DocShotPresenter", "docShotFail()..");
        b0 r1 = this.f;
        if (r1 == null) goto L8;
        r1.setSnapState(false);
    L8:
        b0 r2 = this.f;
        if (r2 == null) goto L11;
        ((DocShotView) r2).c();
    L11:
        m.b r3 = this.c;
        if (r3 == null) goto L14;
        com.bytedance.ee.bear.document.export.e.b(((com.bytedance.ee.bear.document.export.a.C0072a) r3).a.c, "jpg_long");
        this.c = null;
    L14:
        c r6 = this.r;
        if (r6 == null) goto L17;
        ((fz4.b) r6).a();
    L17:
        this.h = null;
        this.i = null;
        j(1, this.g);
        l(1, r4, r5);
    }

    public final void j(int r3, WebView r4) {
        StringBuilder r0 = new StringBuilder("notifyJScreenShot state=");
        r0.append(r3);
        r0.append(", exportType=");
        r0.append(this.m);
        r0.append(", webViewNull=");
        if (r4 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("DocShotPresenter", r0.toString());
        if (r4 != null) goto L10;
        tt5.a.k("DocShotPresenter", "notifyJScreenShot skip: webView is null");
        return;
    L10:
        JSONObject r2 = new JSONObject();
        r2.put("state", Integer.valueOf(r3));
        if (TextUtils.isEmpty(this.m) == true) goto L13;
        r2.put("exportType", this.m);
    L13:
        ap5.a.a(r4, "javascript:window.native.screenshot", r2, null);
        this.g = r4;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void l(int r4, String r5, DocShotModel r6) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L12
        r0.put("file_id", du5.b.g(this.k));     // Catch: Exception -> L12
        String r2 = this.l;     // Catch: Exception -> L12
        if (r2 != null) goto L5;
        r2 = sbb.e.g.getType();     // Catch: Exception -> L12
    L5:
        r0.put("file_type", r2);     // Catch: Exception -> L12
        r0.put("status_code", Integer.valueOf(r4));     // Catch: Exception -> L12
        r0.put("status_name", r5);     // Catch: Exception -> L12
        if (r6 != null) goto L8;
    L10:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_generate_long_image", r0);     // Catch: Exception -> L12
        return;
    L8:
        if (r6.success == true) goto L10;
        r0.put("image_count", Integer.valueOf(r6.image_count));     // Catch: Exception -> L12
        r0.put("image_load_count", Integer.valueOf(r6.image_load_count));     // Catch: Exception -> L12
        r0.put("image_load_timeout", Boolean.valueOf(r6.image_load_timeout));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }

    public static void b(DocShotPresenter r10, int r11, int r12, int r13, int r14, int r16) {
        r10.getClass();
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r10.p != 0) goto L7;
        r10.p = r2;     // Catch: Exception -> L19
    L7:
        if (r10.q != 0) goto L9;
        r10.q = r2;     // Catch: Exception -> L19
    L9:
        if (r13 == 0) goto L13;
        int r4 = r12 / r13;     // Catch: Exception -> L19
        if ((r12 % r13) <= 0) goto L14;
        r4 = r4 + 1;     // Catch: Exception -> L19
    L14:
        HashMap r17 = new HashMap();     // Catch: Exception -> L19
        r17.put("file_id", du5.b.g(r10.k));     // Catch: Exception -> L19
        String r6 = r10.l;     // Catch: Exception -> L19
        if (r6 != null) goto L17;
        r6 = sbb.e.g.getType();     // Catch: Exception -> L19
    L17:
        r17.put("file_type", r6);     // Catch: Exception -> L19
        r17.put("time_cost_ms", String.valueOf(r2 - r10.p));     // Catch: Exception -> L19
        r17.put("js_cost_ms", String.valueOf(r10.q - r10.p));     // Catch: Exception -> L19
        r17.put("native_cost_ms", String.valueOf(r2 - r10.q));     // Catch: Exception -> L19
        r17.put("width", String.valueOf(r11));     // Catch: Exception -> L19
        r17.put("height", String.valueOf(r12));     // Catch: Exception -> L19
        r17.put("page_count", String.valueOf(r4));     // Catch: Exception -> L19
        r17.put("retry_count", String.valueOf(r16));     // Catch: Exception -> L19
        r17.put("file_size", String.valueOf((((r11 * r12) * 2) / 1024) / 1024));     // Catch: Exception -> L19
        r17.put("status_code", String.valueOf(r14));     // Catch: Exception -> L19
        tt5.a.h("DocShotPresenter", r17.toString());     // Catch: Exception -> L19
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_long_image_info", r17);     // Catch: Exception -> L19
        return;
    L13:
        r4 = 0;
    L19:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
    }
}
