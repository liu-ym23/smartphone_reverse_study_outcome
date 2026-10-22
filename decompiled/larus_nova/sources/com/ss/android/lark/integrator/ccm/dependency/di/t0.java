package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.gecko.GeckoSettingConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maincore.TabType;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class t0 implements com.bytedance.ee.bear.lark.dependency.g {
    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void A0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void B0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void D0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void E0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void F0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void G0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void H0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void I0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void K0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void L0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void M0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void P0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void Q0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void R0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void S0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void T0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void V0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void W0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void getLarkHttpClient() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void getNtpTime() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final boolean C0() {
        return AppLifecycle.a.f408803a.h();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final boolean N0() {
        if (((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).s() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final String O0() {
        int r100 = gcb.c.f480889a;
        if (idb.f.a().isEnable("lark.ka.dynamicres") == false) goto L107;
        final String r101 = kcb.a.c().getString("ka_resource_tid", "");
        com.ss.android.lark.gecko.a r102 = com.ss.android.lark.gecko.a.C5032a.f425768a;
        final Application r103 = com.larksuite.framework.utils.b.f285948a;
        r102.getClass();
        if (idb.f.a().isEnable("lark.hobby.lark_resource_bundle_refactor") == false) goto L63;
        com.ss.android.lark.hobby.d r104 = com.ss.android.lark.hobby.d.a.f425860a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L47;
        String r110 = UserSP.getInstance().getString("hobby_res_task_id", "");
        if (r103 != null) goto L12;
    L42:
        String r111 = "HybridDynamicResourceProvider";
    L43:
        String r105 = "";
    L45:
        if (TextUtils.isEmpty(r105) == true) goto L60;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.hobby.a(r103, r101));
    L60:
        if (TextUtils.isEmpty(r105) == false) goto L62;
        UserSP.getInstance().putString("hobby_res_task_id", "");
    L62:
        Log.i("GeckoResManager", "hobbyResPath: " + r105);
    L103:
        String r106 = r105;
    L106:
        if (TextUtils.isEmpty(r106) == true) goto L107;
        String r107 = kcb.a.c().getString("ka_resource_path", "");
        String r108 = kcb.a.c().getString("ka_hybrid_resource", "");
        if (TextUtils.isEmpty(r107) == false) goto L111;
    L160:
        InputStream r109 = new PolarisZipFileWrapper(r106).getInputStream(new ZipEntry("assets/hybrid_material"));     // Catch: Throwable -> L128 Exception -> L130 IOException -> L135 FileNotFoundException -> L140
    L115:
        String r112 = r111;
        Log.i(r112, "load hybrid material from remote");     // Catch: Exception -> L119 IOException -> L121 FileNotFoundException -> L154 Throwable -> L147
        String r113 = new String(com.larksuite.framework.utils.e0.b(r109), StandardCharsets.UTF_8);     // Catch: Exception -> L119 IOException -> L121 FileNotFoundException -> L154 Throwable -> L147
        r109.close();     // Catch: IOException -> L152
    L145:
        kcb.a.c().putString("ka_resource_path", r106);
        kcb.a.c().putString("ka_hybrid_resource", r113);
        Log.d(r112, "HYBRID_MATERIAL " + r113);
        return r113;
    L121:
        e = e;
    L137:
        Log.i(r112, e);     // Catch: Throwable -> L147
        if (r109 != null) goto L156;
    L144:
        r113 = null;
    L156:
        r109.close();     // Catch: IOException -> L153
    L119:
        e = e;
    L132:
        Log.i(r112, e);     // Catch: Throwable -> L147
        if (r109 == null) goto L144;
    L141:
        Log.i(r112, "default package without hybrid material file");     // Catch: Throwable -> L147
        if (r109 == null) goto L144;
    L147:
        th = th;
        ?? r114 = r108;
    L149:
        if (r114 != 0) goto L158;
    L151:
        throw th;
    L158:
        r114.close();     // Catch: IOException -> L155
    L140:
        r112 = r111;
        r109 = null;
    L135:
        e = e;
        r112 = r111;
        r109 = null;
    L130:
        e = e;
        r112 = r111;
        r109 = null;
    L128:
        th = th;
        r114 = 0;
        goto L149
    L111:
        if (TextUtils.equals(r107, r106) == false) goto L160;
        return r108;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L42;
        String r115 = com.ss.android.lark.hobby.d.d(r101);
        if (TextUtils.isEmpty(r110) == true) goto L20;
        r111 = "HybridDynamicResourceProvider";
        PolarisFileWrapper r116 = new PolarisFileWrapper(com.ss.android.lark.hobby.d.b(r103, r115) + File.separator + r110, "resource-bundle");
        if (r116.exists() == false) goto L19;
        Log.i("HobbyResManager", "getKaResPathFast: found res by SP, taskId: " + r110);
        r105 = r116.getAbsolutePath();
        goto L45
    L19:
        Log.w("HobbyResManager", "getKaResPathFast: res by SP not valid, taskId: " + r110 + ", path: " + r116.getAbsolutePath());
    L161:
        Log.i("HobbyResManager", "getKaResPathFast: start fallback scanning");     // Catch: Exception -> L40
        String r117 = com.ss.android.lark.hobby.d.b(r103, r115);     // Catch: Exception -> L40
        PolarisFileWrapper r118 = new PolarisFileWrapper(r117);     // Catch: Exception -> L40
        if (r118.exists() == true) goto L24;
    L38:
        Log.w("HobbyResManager", "getKaResPathFast: kaResDir not valid: " + r117);     // Catch: Exception -> L40
        goto L43
    L24:
        if (r118.isDirectory() == false) goto L38;
        File[] r119 = r118.listFiles();     // Catch: Exception -> L40
        if (r119 != null) goto L29;
    L37:
        Log.w("HobbyResManager", "getKaResPathFast: no task dirs found in " + r117);     // Catch: Exception -> L40
        goto L43
    L29:
        if (r119.length == 0) goto L37;
        Arrays.sort(r119, Collections.reverseOrder());     // Catch: Exception -> L40
        File r120 = r119[0];     // Catch: Exception -> L40
        File[] r121 = r120.listFiles();     // Catch: Exception -> L40
        if (r121 != null) goto L34;
    L36:
        Log.w("HobbyResManager", "getKaResPathFast: no resource bundles in " + r120.getAbsolutePath());     // Catch: Exception -> L40
        goto L43
    L34:
        if (r121.length <= 0) goto L36;
        String r122 = r121[0].getAbsolutePath();     // Catch: Exception -> L40
        Log.i("HobbyResManager", "getKaResPathFast: found res by scanning, taskId: " + r120.getName() + ", path: " + r122);     // Catch: Exception -> L40
        UserSP.getInstance().putString("hobby_res_task_id", r120.getName());     // Catch: Exception -> L40
        r105 = r122;
    L40:
        e = move-exception;
        Log.e("HobbyResManager", "getKaResPathFast error", e);
        goto L43
    L20:
        r111 = "HybridDynamicResourceProvider";
        Log.i("HobbyResManager", "getKaResPathFast: taskId in SP is empty");
        goto L161
    L47:
        r111 = "HybridDynamicResourceProvider";
        r104.a(r103, r101);
        File[] r123 = new PolarisFileWrapper(com.ss.android.lark.hobby.d.b(r103, com.ss.android.lark.hobby.d.d(r101))).listFiles();
        if (r123 != null) goto L50;
    L58:
        r105 = "";
        goto L60
    L50:
        if (r123.length == 0) goto L58;
        Arrays.sort(r123, Collections.reverseOrder());
        File[] r124 = r123[0].listFiles();
        if (r124 == null) goto L58;
        if (r124.length == 0) goto L58;
        r105 = r124[0].getAbsolutePath();
        Log.i("HobbyResManager", "kaResPath: " + r105);
        goto L60
    L63:
        r111 = "HybridDynamicResourceProvider";
        Log.i("GeckoResManager", "getKaRes context:" + r103 + ", tid:" + r101);
        if (r103 != null) goto L66;
    L104:
        r106 = null;
        goto L106
    L66:
        if (TextUtils.isEmpty(r101) == true) goto L104;
        String r125 = "ka_" + r101;
        if (((HashMap) r102.f425767a).containsKey(r125) == false) goto L71;
        r105 = (String) ((HashMap) r102.f425767a).get(r125);
        goto L103
    L71:
        GeckoSettingConfig r126 = (GeckoSettingConfig) SettingManager.getInstance().get(GeckoSettingConfig.class);
        if (r126 != null) goto L75;
        Log.i("GeckoResManager", "geckoSettingConfig is null");
        goto L104
    L75:
        if (r126.mKaDynamicResource != null) goto L77;
        Log.i("GeckoResManager", "mKaDynamicResource is null");
        goto L104
    L77:
        String r127 = ResLoadUtils.getChannelPath(new PolarisFileWrapper(r103.getFilesDir(), GeckoClient.GECKO_ROOT_DIR), r126.mKaDynamicResource.mAccessKey, r125);
        if (TextUtils.isEmpty(r127) == false) goto L80;
    L83:
        boolean r128 = true;
    L84:
        if (r128 == true) goto L104;
        PolarisFileWrapper r129 = new PolarisFileWrapper(r127);
        Long r130 = CastLongProtector.valueOf(r129.getParentFile().getName());
        StringBuilder r131 = new StringBuilder();
        r131.append(r103.getFilesDir().getAbsolutePath());
        String r132 = File.separator;
        r131.append(r132);
        r131.append("gecko_ka_res");
        r131.append(r132);
        r131.append(r125);
        String r133 = r131.toString();
        PolarisFileWrapper r134 = new PolarisFileWrapper(r133);
        if (r134.exists() == false) goto L104;
        List r135 = ez5.f.a(r134);
        if (r135 == null) goto L102;
        ArrayList r136 = (ArrayList) r135;
        if (r136.isEmpty() == true) goto L102;
        if (r136.contains(r130) == false) goto L102;
        PolarisFileWrapper r137 = new PolarisFileWrapper(r133 + r132 + r130.longValue() + r132 + "res");
        if (com.ss.android.lark.gecko.a.a(r137) == true) goto L102;
        if (r129.length() != r137.length()) goto L102;
        String r138 = r137.listFiles()[0].getAbsolutePath();
        ((HashMap) r102.f425767a).put(r125, r138);
        r105 = r138;
    L102:
        r105 = null;
        goto L103
    L80:
        if (com.ss.android.lark.gecko.a.a(new PolarisFileWrapper(r127)) == true) goto L83;
        r128 = false;
    L107:
        return null;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final u0 getSearchLifecycleObserver() {
        return new u0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final Activity getTopActivity() {
        return AppLifecycle.a.f408803a.f();
    }

    @Inject
    public t0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final TabType getTabType() {
        return TabType.Others;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void U0(c2 r100) {
        ((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).h6(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final String decodeQRCode(String r100) {
        dxa.g r101 = ((mlb.a) ApiUtils.getApi(mlb.a.class)).decodeQRCode(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r101.f470449a) == false) goto L8;
        List<dxa.f> r102 = r101.f470450b;
        if (r102 != null) goto L12;
    L15:
        return "";
    L12:
        if (r102.size() <= 0) goto L15;
        return ((dxa.f) ListProtector.get(r101.f470450b, 0)).f470443a;
    L8:
        return r101.f470449a;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final WatermarkInfo z0(Context r100) {
        return ((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).z0(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void openUrl(Context r100, String r101) {
        com.ss.android.lark.router.c.b(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final void J0(Context r100, int[] r101, com.bytedance.ee.bear.lark.dependency.p0 r102) {
        s0 r103 = new s0(r102, new r0(r100));
        ew4.c0 r104 = ew4.v.f474600a;
        UserSession r105 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L5
        r104 = (ew4.c0) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.internal.v.class)).c(r105), ew4.c0.class);     // Catch: Throwable -> L5
    L7:
        r104.I0(r100, r101, r103);
        return;
    L5:
        th = move-exception;
        tt5.a.l("OfficeCoreDependencyImpl", "get session QR code service failed, use default service", th);
        goto L7
    }

    @Override // com.bytedance.ee.bear.lark.dependency.g
    public final Bitmap e(String r100, int r101, int r102) {
        owb.b r103 = (owb.b) OfficeSDKManager.getHostGlobalService(owb.b.class);
        if (r103 != null) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNullParameter(r103, "hostService");
        Intrinsics.checkNotNullParameter(r100, "content");
        return r103.q1(r100, new owb.c(r101, r102));
    }
}
