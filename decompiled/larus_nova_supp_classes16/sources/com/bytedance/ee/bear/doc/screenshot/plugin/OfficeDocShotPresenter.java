package com.bytedance.ee.bear.doc.screenshot.plugin;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.doc.screenshot.DocShotModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.vfs.VFSPath;
import fz4.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jdb.g;
import jz4.l;
import kz4.b;
import sa5.r;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeDocShotPresenter implements r {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final FragmentActivity d;
    public WebView e;
    public int f;
    public boolean g;
    public c h;
    public final MutableLiveData<Boolean> i;
    public long j;
    public long k;
    public b l;
    public VFSPath m;
    public jz4.a n;
    public final AtomicInteger o;
    public a p;
    public wz4.c q;
    public wz4.a r;
    public final boolean s;
    public VFSPath t;

    public @interface SCREEN_SHOT_STATE {
    }

    public interface a {
    }

    public final void c() {
        if (this.b == false) goto L33;
        boolean r1 = true;
        if (this.o.get() >= 1) goto L34;
        FragmentActivity r0 = this.d;
        if (r0 != null) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L35;
        this.o.incrementAndGet();
        zo5.b r2 = (zo5.b) org.koin.java.a.a(zo5.b.class);
        zo5.a r3 = r2.m();
        tt5.a.h("OfficeDocShotPresenter", "attachWatermarkActivity info=" + r3);
        c r4 = this.h;
        if (r4 == null) goto L18;
        BearUrl r5 = r4.c;
        if (r5 == null) goto L18;
        String r6 = r5.b;
    L20:
        if (TextUtils.equals(r6, r3.a) == true) goto L23;
        tt5.a.k("OfficeDocShotPresenter", "attachWatermarkActivity token is different!! force add watermark");
        r2.n(this.d);
        return;
    L23:
        if (r3.c == true) goto L28;
        if (r3.d == false) goto L37;
        r2.n(this.d);
        return;
    L37:
        return;
    L28:
        if (r3.e == false) goto L30;
    L31:
        r2.q(this.d);
        return;
    L30:
        if (r3.f == true) goto L31;
        return;
    L18:
        r6 = "";
        goto L20
    L35:
        return;
    L9:
        if (r0.isFinishing() == true) goto L11;
    L34:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Runnable, jz4.a] */
    public final boolean f() {
        this.i.setValue(Boolean.FALSE);
        tt5.a.b("OfficeDocShotPresenter", "onBackPressed()...");
        this.g = true;
        e(1, this.e);
        b r1 = this.l;
        if (r1 == null) goto L5;
        r1.stop();
    L5:
        a r2 = this.p;
        if (r2 == null) goto L8;
        l r3 = (l) r2;
        OfficeSnapshotPlugin.c(r3.a, r3.b);
    L8:
        wz4.a r4 = this.r;
        if (r4 == null) goto L11;
        r4.setSnapState(false);
    L11:
        c r5 = this.h;
        if (r5 != null) goto L14;
        return false;
    L14:
        if ("doc".equals(r5.c.a) == false) goto L19;
        jz4.a r6 = this.n;
        if (r6 == null) goto L18;
        j.e(r6);
    L18:
        ?? r7 = new jz4.a(this);
        this.n = r7;
        j.d(r7, 500);
    L22:
        return true;
    L19:
        wz4.a r8 = this.r;
        if (r8 == null) goto L22;
        r8.onHideShotView();
        goto L22
    }

    public static void a(OfficeDocShotPresenter r1, boolean r2) {
        WebView r0 = r1.e;
        if (r0 == null) goto L10;
        boolean r3 = r0.isVerticalScrollBarEnabled();
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        r1.e.setVerticalScrollBarEnabled(true);
        return;
    L8:
        r1.e.setVerticalScrollBarEnabled(false);
        return;
    }

    public final void d(String r4, DocShotModel r5) {
        this.i.setValue(Boolean.FALSE);
        WebView r0 = this.e;
        if (r0 == null) goto L5;
        r0.scrollTo(0, this.f);
    L5:
        tt5.a.h("OfficeDocShotPresenter", "docShotFail()..");
        wz4.a r1 = this.r;
        if (r1 == null) goto L8;
        r1.setSnapState(false);
    L8:
        wz4.c r2 = this.q;
        if (r2 == null) goto L11;
        r2.onSnapshotFailed(r4);
        this.q = null;
    L11:
        a r3 = this.p;
        if (r3 == null) goto L14;
        l r6 = (l) r3;
        OfficeSnapshotPlugin.c(r6.a, r6.b);
    L14:
        this.m = null;
        e(1, this.e);
        g(1, r4, r5);
    }

    public final void e(int r3, WebView r4) {
        if (r4 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put("state", Integer.valueOf(r3));
        ap5.a.a(r4, "javascript:window.native.screenshot", r0, null);
        this.e = r4;
        return;
    }

    public OfficeDocShotPresenter(FragmentActivity r3, boolean r4, vo5.a r5) {
        this.i = new MutableLiveData();
        this.j = 0;
        this.k = 0;
        boolean r1 = true;
        this.o = new AtomicInteger(1);
        this.d = r3;
        boolean r6 = !r4;
        this.a = r6;
        g r7 = ((dn4.a) r5.a(dn4.a.class)).a();
        boolean r8 = r7.isEnable("admin.security.watermark.file.switch");
        boolean r0 = r7.isEnable("admin.security.watermark.file.switch.docx");
        this.s = r8;
        if (r8 == false) goto L6;
        if (r0 == false) goto L6;
    L7:
        this.b = r1;
        boolean r9 = r7.isEnable("admin.watermark.filewatermark.remaining");
        this.c = r9;
        tt5.a.h("OfficeDocShotPresenter", "mCppEncodeEnabled=" + r6 + ", mPartBitmapShotOptimization=" + r1 + ", mIsWatermarkRemainingEnable=" + r9);
        return;
    L6:
        r1 = false;
        goto L7
    }

    public final void g(int r4, String r5, DocShotModel r6) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L12
        r0.put("file_id", du5.b.g(this.h.c.b));     // Catch: Exception -> L12
        String r2 = this.h.c.a;     // Catch: Exception -> L12
        if (r2 != null) goto L5;
        r2 = e.g.getType();     // Catch: Exception -> L12
    L5:
        r0.put("file_type", r2);     // Catch: Exception -> L12
        r0.put("status_code", Integer.valueOf(r4));     // Catch: Exception -> L12
        r0.put("status_name", r5);     // Catch: Exception -> L12
        if (r6 != null) goto L8;
    L10:
        ((d) org.koin.java.a.a(d.class)).v("client_generate_long_image", r0);     // Catch: Exception -> L12
        return;
    L8:
        if (r6.success == true) goto L10;
        r0.put("image_count", Integer.valueOf(r6.image_count));     // Catch: Exception -> L12
        r0.put("image_load_count", Integer.valueOf(r6.image_load_count));     // Catch: Exception -> L12
        r0.put("image_load_timeout", Boolean.valueOf(r6.image_load_timeout));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f("OfficeDocShotPresenter", e, false);
    }

    public static void b(OfficeDocShotPresenter r10, int r11, int r12, int r13, int r14, int r16) {
        r10.getClass();
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r10.j != 0) goto L7;
        r10.j = r2;     // Catch: Exception -> L19
    L7:
        if (r10.k != 0) goto L9;
        r10.k = r2;     // Catch: Exception -> L19
    L9:
        if (r13 == 0) goto L13;
        int r4 = r12 / r13;     // Catch: Exception -> L19
        if ((r12 % r13) <= 0) goto L14;
        r4 = r4 + 1;     // Catch: Exception -> L19
    L14:
        HashMap r17 = new HashMap();     // Catch: Exception -> L19
        r17.put("file_id", du5.b.g(r10.h.c.b));     // Catch: Exception -> L19
        String r6 = r10.h.c.a;     // Catch: Exception -> L19
        if (r6 != null) goto L17;
        r6 = e.g.getType();     // Catch: Exception -> L19
    L17:
        r17.put("file_type", r6);     // Catch: Exception -> L19
        r17.put("time_cost_ms", String.valueOf(r2 - r10.j));     // Catch: Exception -> L19
        r17.put("js_cost_ms", String.valueOf(r10.k - r10.j));     // Catch: Exception -> L19
        r17.put("native_cost_ms", String.valueOf(r2 - r10.k));     // Catch: Exception -> L19
        r17.put("width", String.valueOf(r11));     // Catch: Exception -> L19
        r17.put("height", String.valueOf(r12));     // Catch: Exception -> L19
        r17.put("page_count", String.valueOf(r4));     // Catch: Exception -> L19
        r17.put("retry_count", String.valueOf(r16));     // Catch: Exception -> L19
        r17.put("file_size", String.valueOf((((r11 * r12) * 2) / 1024) / 1024));     // Catch: Exception -> L19
        r17.put("status_code", String.valueOf(r14));     // Catch: Exception -> L19
        tt5.a.h("OfficeDocShotPresenter", r17.toString());     // Catch: Exception -> L19
        ((d) org.koin.java.a.a(d.class)).v("client_long_image_info", r17);     // Catch: Exception -> L19
        return;
    L13:
        r4 = 0;
    L19:
        e = move-exception;
        tt5.a.f("OfficeDocShotPresenter", e, false);
    }
}
