package com.unicom.online.account.kernel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    y f462100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f462101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f462102c;

    public x() {
        this.f462102c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ount/kernel/x"));
        this.f462101b = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("ount/kernel/x"));
    }

    public static String a(Context r110, int r111) {
        String r100 = ak.c();     // Catch: Exception -> L26
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L26
        r101.append(System.currentTimeMillis());     // Catch: Exception -> L26
        String r102 = r101.toString();     // Catch: Exception -> L26
        String r103 = ac.d();     // Catch: Exception -> L26
        String r104 = r110.getPackageName();     // Catch: Exception -> L26
        String r105 = ad.a(r110, al.g());     // Catch: Exception -> L26
        String r112 = al.a();     // Catch: Exception -> L26
        String r113 = r112.substring(0, 16);     // Catch: Exception -> L26
        String r114 = r112.substring(16, 32);     // Catch: Exception -> L26
        e.a().f462029c = System.currentTimeMillis();     // Catch: Exception -> L26
        if (ac.f461949a == false) goto L6;
        String r115 = "3.1";
        String r106 = o.a(r.a(r105.getBytes("Utf-8"), r113.getBytes(), r114.getBytes()));     // Catch: Exception -> L26
        String r116 = o.a(r.a(r112.getBytes(), p.a("045C5DD4890819CEB16B0A66ED62B2FFA29B08F3CBF344A52A3A100ECB271BBEF3A9BC3743E753CA16EF238A1E55B72E95659A70425064D506B48F8EE3442786F7")));     // Catch: Exception -> L26
    L8:
        if (ac.f461953e.equalsIgnoreCase("sm3") == false) goto L10;
        String r107 = al.a(r110, r110.getPackageName());     // Catch: Exception -> L26
    L12:
        if (ac.a(r111) == false) goto L16;
        String r117 = ak.b();     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r117) == true) goto L17;
        r117 = "0";
    L17:
        String r108 = (r107 + "\n" + r100 + "\n" + r115 + "\njson\n" + r117 + "\n" + r104 + "\n" + r106 + "\n" + r103 + "\n" + r116 + "\n" + r102).replaceAll("\n", "");     // Catch: Exception -> L26
        if (ac.f461949a == false) goto L20;
        String r109 = al.c(r108);     // Catch: Exception -> L26
    L21:
        String r118 = o.a(r106);     // Catch: Exception -> L26
        String r119 = o.a(r116);     // Catch: Exception -> L26
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L26
        r120.put("androidMd5", r107);     // Catch: Exception -> L26
        r120.put("apiKey", r100);     // Catch: Exception -> L26
        r120.put(com.alipay.sdk.m.l.c.f25508m, r115);     // Catch: Exception -> L26
        r120.put(SubInfo.KEY_FORMAT, "json");     // Catch: Exception -> L26
        if (ac.a(r111) == false) goto L24;
        r120.put(OnekeyLoginConstants.CU_KEY_OPERATOR, r117);     // Catch: Exception -> L26
    L24:
        r120.put("packName", r104);     // Catch: Exception -> L26
        r120.put("privateIp", r118);     // Catch: Exception -> L26
        r120.put(com.heytap.mcssdk.constant.b.C, r103);     // Catch: Exception -> L26
        r120.put("secretKey", r119);     // Catch: Exception -> L26
        r120.put(VideoSurfaceTexture.KEY_TIME, r102);     // Catch: Exception -> L26
        r120.put("sign", r109);     // Catch: Exception -> L26
        return r120.toString();
    L20:
        r109 = al.a(r108);     // Catch: Exception -> L26
        goto L21
    L16:
        r117 = "";
        goto L17
    L10:
        r107 = al.a(r110, r110.getPackageName(), ac.f461953e);     // Catch: Exception -> L26
        goto L12
    L6:
        r115 = "2.1";
        r106 = al.a(r105, r113, r114);     // Catch: Exception -> L26
        r116 = s.a(r112, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVc1ecjpc5k7TkabF935iQONDZ0/E5XWPVv9FEsI59XTRW0+BCMK1MODRSWMvHFrPMh9ZilnRr7qXuAKCBEynQEghmpIVvMYhFu48FAI9bKfkI5lKuQK+tc4X0+zTbNrpedNoKXK4C7dDjTETBH6prwWE9j5WsAf0gbjUbIs3FxwIDAQAB");     // Catch: Exception -> L26
    L26:
        e = move-exception;
        aj.a(e);
        return "";
    }

    private void a(final Context r110, final int r111, final z r112) {
        int r100 = al.b(r110.getApplicationContext());     // Catch: Exception -> L11
        ak.d(r100);     // Catch: Exception -> L11
        if (r100 != 1) goto L6;
        final long r101 = System.currentTimeMillis();     // Catch: Exception -> L11
        af.a().a(r110, new AnonymousClass3(this, r101, r110, r111, r112));     // Catch: Exception -> L11
        return;
    L6:
        if (r100 != 0) goto L9;
        e.a().f462028b = 0;     // Catch: Exception -> L11
        a(r110, r111, null, r112);     // Catch: Exception -> L11
        return;
    L9:
        r112.a(r111, 410004, "数据网络未开启");     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        aj.a(e);
        r112.a(r111, 410005, "网络判断异常" + e.getMessage());
    }

    public static /* synthetic */ void a(x r100) {
        ScheduledExecutorService r101 = r100.f462101b;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.shutdownNow();     // Catch: Exception -> L6
        r100.f462101b = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        aj.a(e);
    }

    private void b(Context r100, int r101) {
        a(r100, r101, new AnonymousClass2(this));
    }

    public final void a(Context r100, int r101, final int r102, h r103) {
        y r104 = new y();
        this.f462100a = r104;
        r104.f462116a = r103;
        this.f462101b.schedule(new AnonymousClass1(this, r102), r101, TimeUnit.MILLISECONDS);     // Catch: Exception -> L5
        b(r100, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        aj.a(e);
    }

    public final void a(final Context r100, final int r110, final Object r111, final z r112) {
        monitor-enter(this);
        this.f462102c.submit(new AnonymousClass4(this, r110, r100, r112, r111));     // Catch: Throwable -> L5 Exception -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        r112.a(r110, 410009, "410009" + e.getMessage());     // Catch: Throwable -> L5
        goto L9
    }
}
