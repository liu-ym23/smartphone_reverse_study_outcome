package com.ss.android.dypay.utils;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.TTPayAnnieContainerImpl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.text.Charsets;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f408479a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f408480b;

    public static final class a implements uta.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f408481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f408482b;

        public a(boolean r100, Activity r101) {
            this.f408481a = r100;
            this.f408482b = r101;
        }

        @Override // uta.d
        public final void a() {
            b.f408480b = false;
            sta.a r100 = sta.a.f543576b;
            JSONObject r101 = new JSONObject();
            String r102 = "0";
            r101.put("result", "0");
            if (this.f408481a == true) goto L6;
            r102 = "1";
        L6:
            r101.put("is_prefetch", r102);
            sta.a.f(r100, "out_wallet_cashier_fetch_deeplink_result", r101);
        }

        @Override // uta.d
        public final void b(String r100) {
            boolean r101 = false;
            b.f408480b = false;
            JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L27
            if (r102.optInt("code") != 0) goto L28;
            JSONObject r103 = r102.optJSONObject("data");     // Catch: Exception -> L27
            String r104 = null;
            if (r103 == null) goto L8;
            String r105 = r103.optString(ComplianceResult.JsonKey.MARKET_DEEP_LINK);     // Catch: Exception -> L27
        L10:
            if (r105 == null) goto L20;
            if (r105.length() <= 0) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == false) goto L17;
            r104 = r105;
        L17:
            if (r104 == null) goto L20;
            b.f408479a = r104;     // Catch: Exception -> L27
            goto L20
        L14:
            r106 = false;
        L20:
            if (this.f408481a == false) goto L28;
            if (b.f408479a.length() <= 0) goto L24;
            r101 = true;
        L24:
            if (r101 == false) goto L28;
            b.c(this.f408482b, b.f408479a);     // Catch: Exception -> L27
            goto L28
        L8:
            r105 = null;
        L28:
            sta.a r107 = sta.a.f543576b;
            JSONObject r108 = new JSONObject();
            String r109 = "1";
            r108.put("result", "1");
            if (this.f408481a == false) goto L31;
            r109 = "0";
        L31:
            r108.put("is_prefetch", r109);
            r108.put("market_dy_scheme", b.f408479a);
            sta.a.f(r107, "out_wallet_cashier_fetch_deeplink_result", r108);
        }
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static void b(Activity r100, boolean r101) {
        if (k.f408504a == true) goto L12;
        if (a().getName().length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        k.f408505b = r102;     // Catch: Exception -> L18
        goto L10
    L8:
        r102 = false;
    L10:
        k.f408504a = true;
    L12:
        if (k.f408505b == true) goto L14;
        return;
    L14:
        if (f408480b == true) goto L22;
        f408480b = r101;
        JSONObject r103 = new JSONObject();
        r103.put("app_id", "cj");
        r103.put("source", TTPayAnnieContainerImpl.CAIJING_BID);
        r103.put("package_name", "com.ss.android.ugc.aweme");
        Charset r104 = Charsets.UTF_8;
        byte[] r105 = "KLIbZDWlqMIh".getBytes(r104);
        byte[] r106 = "qVXCvZnqQtoi".getBytes(r104);
        byte[] r107 = "UZIBjisSlYxJ".getBytes(r104);
        byte[] r108 = "KATOzxi".getBytes(r104);
        r103.put("token", new String(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(r105, r106), r107), r108), r104));
        r103.put("source_package_name", r100.getPackageName());
        ThreadMethodProxy.start(new PthreadThreadV2(new uta.b("https://praisewindow.ugsdk.cn/zebra/praise/url", r103.toString(), new a(r101, r100)), "dypay/utils/b"));
        return;
    }

    public static boolean c(Activity r100, String r101) {
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse(r101));
        r102.addFlags(268435456);
        if (r102.resolveActivity(r100.getPackageManager()) == null) goto L5;
        r100.startActivity(r102);
    L8:
        return true;
    L5:
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("https://tp-pay.snssdk.com/cashdesk/download"));
        if (r103.resolveActivity(r100.getPackageManager()) == null) goto L9;
        r100.startActivity(Intent.createChooser(r103, r100.getString(R.string.dypay_download_with_browser)));
        goto L8
    L9:
        return false;
    }
}
