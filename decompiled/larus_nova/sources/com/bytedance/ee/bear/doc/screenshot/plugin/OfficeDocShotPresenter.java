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
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.vfs.VFSPath;
import fz4.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jdb.g;
import jz4.l;
import kz4.b;
import sa5.r;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDocShotPresenter implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f218119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f218120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f218121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f218122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebView f218123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f218124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f218125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f218126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Boolean> f218127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f218128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f218129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f218130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VFSPath f218131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public jz4.a f218132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicInteger f218133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f218134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public wz4.c f218135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public wz4.a f218136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f218137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VFSPath f218138t;

    public @interface SCREEN_SHOT_STATE {
    }

    public interface a {
    }

    public final void c() {
        if (this.f218120b == false) goto L33;
        boolean r100 = true;
        if (this.f218133o.get() >= 1) goto L34;
        FragmentActivity r101 = this.f218122d;
        if (r101 != null) goto L9;
    L11:
        r100 = false;
    L12:
        if (r100 == false) goto L35;
        this.f218133o.incrementAndGet();
        zo5.b r102 = (zo5.b) org.koin.java.a.a(zo5.b.class);
        zo5.a r103 = r102.m();
        tt5.a.h("OfficeDocShotPresenter", "attachWatermarkActivity info=" + r103);
        c r104 = this.f218126h;
        if (r104 == null) goto L18;
        BearUrl r105 = r104.f479355c;
        if (r105 == null) goto L18;
        String r106 = r105.f222561b;
    L20:
        if (TextUtils.equals(r106, r103.f573126a) == true) goto L23;
        tt5.a.k("OfficeDocShotPresenter", "attachWatermarkActivity token is different!! force add watermark");
        r102.n(this.f218122d);
        return;
    L23:
        if (r103.f573128c == true) goto L28;
        if (r103.f573129d == false) goto L37;
        r102.n(this.f218122d);
        return;
    L37:
        return;
    L28:
        if (r103.f573130e == false) goto L30;
    L31:
        r102.q(this.f218122d);
        return;
    L30:
        if (r103.f573131f == true) goto L31;
        return;
    L18:
        r106 = "";
        goto L20
    L35:
        return;
    L9:
        if (r101.isFinishing() == true) goto L11;
    L34:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Runnable, jz4.a] */
    public final boolean f() {
        this.f218127i.setValue(Boolean.FALSE);
        tt5.a.b("OfficeDocShotPresenter", "onBackPressed()...");
        this.f218125g = true;
        e(1, this.f218123e);
        b r100 = this.f218130l;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        a r101 = this.f218134p;
        if (r101 == null) goto L8;
        l r102 = (l) r101;
        OfficeSnapshotPlugin.c(r102.f501197a, r102.f501198b);
    L8:
        wz4.a r103 = this.f218136r;
        if (r103 == null) goto L11;
        r103.setSnapState(false);
    L11:
        c r104 = this.f218126h;
        if (r104 != null) goto L14;
        return false;
    L14:
        if ("doc".equals(r104.f479355c.f222560a) == false) goto L19;
        jz4.a r105 = this.f218132n;
        if (r105 == null) goto L18;
        j.e(r105);
    L18:
        ?? r106 = new jz4.a(this);
        this.f218132n = r106;
        j.d(r106, 500);
    L22:
        return true;
    L19:
        wz4.a r107 = this.f218136r;
        if (r107 == null) goto L22;
        r107.onHideShotView();
        goto L22
    }

    public static void a(OfficeDocShotPresenter r100, boolean r101) {
        WebView r102 = r100.f218123e;
        if (r102 == null) goto L10;
        boolean r103 = r102.isVerticalScrollBarEnabled();
        if (r101 == false) goto L8;
        if (r103 == false) goto L8;
        r100.f218123e.setVerticalScrollBarEnabled(true);
        return;
    L8:
        r100.f218123e.setVerticalScrollBarEnabled(false);
        return;
    }

    public final void d(String r100, DocShotModel r101) {
        this.f218127i.setValue(Boolean.FALSE);
        WebView r102 = this.f218123e;
        if (r102 == null) goto L5;
        r102.scrollTo(0, this.f218124f);
    L5:
        tt5.a.h("OfficeDocShotPresenter", "docShotFail()..");
        wz4.a r103 = this.f218136r;
        if (r103 == null) goto L8;
        r103.setSnapState(false);
    L8:
        wz4.c r104 = this.f218135q;
        if (r104 == null) goto L11;
        r104.onSnapshotFailed(r100);
        this.f218135q = null;
    L11:
        a r105 = this.f218134p;
        if (r105 == null) goto L14;
        l r106 = (l) r105;
        OfficeSnapshotPlugin.c(r106.f501197a, r106.f501198b);
    L14:
        this.f218131m = null;
        e(1, this.f218123e);
        g(1, r100, r101);
    }

    public final void e(int r100, WebView r101) {
        if (r101 == null) goto L5;
        JSONObject r102 = new JSONObject();
        r102.put2("state", Integer.valueOf(r100));
        ap5.a.a(r101, "javascript:window.native.screenshot", r102, null);
        this.f218123e = r101;
        return;
    }

    public OfficeDocShotPresenter(FragmentActivity r100, boolean r101, vo5.a r102) {
        this.f218127i = new MutableLiveData();
        this.f218128j = 0;
        this.f218129k = 0;
        boolean r103 = true;
        this.f218133o = new AtomicInteger(1);
        this.f218122d = r100;
        boolean r104 = !r101;
        this.f218119a = r104;
        g r105 = ((dn4.a) r102.a(dn4.a.class)).a();
        boolean r106 = r105.isEnable("admin.security.watermark.file.switch");
        boolean r107 = r105.isEnable("admin.security.watermark.file.switch.docx");
        this.f218137s = r106;
        if (r106 == false) goto L6;
        if (r107 == false) goto L6;
    L7:
        this.f218120b = r103;
        boolean r108 = r105.isEnable("admin.watermark.filewatermark.remaining");
        this.f218121c = r108;
        tt5.a.h("OfficeDocShotPresenter", "mCppEncodeEnabled=" + r104 + ", mPartBitmapShotOptimization=" + r103 + ", mIsWatermarkRemainingEnable=" + r108);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public final void g(int r100, String r101, DocShotModel r102) {
        HashMap r103 = new HashMap();     // Catch: Exception -> L12
        r103.put("file_id", du5.b.g(this.f218126h.f479355c.f222561b));     // Catch: Exception -> L12
        String r104 = this.f218126h.f479355c.f222560a;     // Catch: Exception -> L12
        if (r104 != null) goto L5;
        r104 = e.f541296g.getType();     // Catch: Exception -> L12
    L5:
        r103.put("file_type", r104);     // Catch: Exception -> L12
        r103.put("status_code", Integer.valueOf(r100));     // Catch: Exception -> L12
        r103.put("status_name", r101);     // Catch: Exception -> L12
        if (r102 != null) goto L8;
    L10:
        ((d) org.koin.java.a.a(d.class)).v("client_generate_long_image", r103);     // Catch: Exception -> L12
        return;
    L8:
        if (r102.success == true) goto L10;
        r103.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r102.image_count));     // Catch: Exception -> L12
        r103.put("image_load_count", Integer.valueOf(r102.image_load_count));     // Catch: Exception -> L12
        r103.put("image_load_timeout", Boolean.valueOf(r102.image_load_timeout));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f("OfficeDocShotPresenter", e, false);
    }

    public static void b(OfficeDocShotPresenter r110, int r111, int r112, int r113, int r114, int r115) {
        r110.getClass();
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r110.f218128j != 0) goto L7;
        r110.f218128j = r100;     // Catch: Exception -> L19
    L7:
        if (r110.f218129k != 0) goto L9;
        r110.f218129k = r100;     // Catch: Exception -> L19
    L9:
        if (r113 == 0) goto L13;
        int r101 = r112 / r113;     // Catch: Exception -> L19
        if ((r112 % r113) <= 0) goto L14;
        r101 = r101 + 1;     // Catch: Exception -> L19
    L14:
        HashMap r116 = new HashMap();     // Catch: Exception -> L19
        r116.put("file_id", du5.b.g(r110.f218126h.f479355c.f222561b));     // Catch: Exception -> L19
        String r102 = r110.f218126h.f479355c.f222560a;     // Catch: Exception -> L19
        if (r102 != null) goto L17;
        r102 = e.f541296g.getType();     // Catch: Exception -> L19
    L17:
        r116.put("file_type", r102);     // Catch: Exception -> L19
        r116.put("time_cost_ms", String.valueOf(r100 - r110.f218128j));     // Catch: Exception -> L19
        r116.put("js_cost_ms", String.valueOf(r110.f218129k - r110.f218128j));     // Catch: Exception -> L19
        r116.put("native_cost_ms", String.valueOf(r100 - r110.f218129k));     // Catch: Exception -> L19
        r116.put("width", String.valueOf(r111));     // Catch: Exception -> L19
        r116.put("height", String.valueOf(r112));     // Catch: Exception -> L19
        r116.put("page_count", String.valueOf(r101));     // Catch: Exception -> L19
        r116.put("retry_count", String.valueOf(r115));     // Catch: Exception -> L19
        r116.put("file_size", String.valueOf((((r111 * r112) * 2) / 1024) / 1024));     // Catch: Exception -> L19
        r116.put("status_code", String.valueOf(r114));     // Catch: Exception -> L19
        tt5.a.h("OfficeDocShotPresenter", r116.toString());     // Catch: Exception -> L19
        ((d) org.koin.java.a.a(d.class)).v("client_long_image_info", r116);     // Catch: Exception -> L19
        return;
    L13:
        r101 = 0;
    L19:
        e = move-exception;
        tt5.a.f("OfficeDocShotPresenter", e, false);
    }
}
