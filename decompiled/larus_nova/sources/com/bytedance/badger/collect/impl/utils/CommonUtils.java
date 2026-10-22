package com.bytedance.badger.collect.impl.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.RangersHttpException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class CommonUtils {
    private static final int LENGTH_MAX = 10240;

    public CommonUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_badger_collect_impl_utils_CommonUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_bytedance_badger_collect_impl_utils_CommonUtils_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static String getSecureAndroidId(Context r100) {
        return com_bytedance_badger_collect_impl_utils_CommonUtils_android_provider_Settings$Secure_getString(r100.getContentResolver(), "android_id");
    L4:
        return null;
    }

    public static String map2QueryString(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L20;
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        if (r101.length() <= 0) goto L12;
        r101.append("&");
    L12:
        r101.append(r103.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r103.getValue());
        goto L8
    L14:
        return r101.toString();
    L20:
        return "";
    }

    public static Map<String, String> parseResponseHeaders(Map<String, List<String>> r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L16:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L16;
        Iterator<Map.Entry<String, List<String>>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, List<String>> r103 = r102.next();
        int r104 = 0;
    L11:
        if (r104 >= r103.getValue().size()) goto L8;
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L15;
        r101.put(r103.getKey(), ListProtector.get(r103.getValue(), r104));
    L15:
        r104 = r104 + 1;
        goto L11
    }

    private static int com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_bytedance_badger_collect_impl_utils_CommonUtils_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r110, r111};
        b r112 = new b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private static HttpURLConnection createConnectionCompat(Network r100, URL r101) throws Exception {
        return (HttpURLConnection) INVOKESTATIC_com_bytedance_badger_collect_impl_utils_CommonUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.net.Network").getMethod("openConnection", new Class[]{URL.class}).invoke(r100, new Object[]{r101});
    }

    public static boolean hasPermission(Context r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L13;
        return true;
    L13:
        if (com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission(r100, r101) != 0) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.badger.collect.impl.model.TTResponse] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.badger.collect.impl.model.TTResponse] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static TTResponse http(Network r100, String r101, String r110, Map<String, String> r111, byte[] r112) throws Exception {
        ?? r102 = DownloadHelper.GZIP;
        if (KLog.isDebug() == false) goto L13;
        if (r111 == null) goto L13;
        Iterator<Map.Entry<String, String>> r103 = r111.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r104.getValue()) == true) goto L7;
        KLog.d(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "http headers key:" + r104.getKey() + " value:" + r104.getValue());
    L13:
        HttpURLConnection r105 = null;
        BufferedReader r106 = null;
        r106 = null;
        URL r107 = new URL(r110);     // Catch: Throwable -> L73
        if (r100 == null) goto L19;
        HttpURLConnection r108 = (HttpURLConnection) r100.openConnection(r107);     // Catch: Throwable -> L73
        KLog.d(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "强切# 原生http接口链接创建成功 " + r108);     // Catch: Throwable -> L71
    L21:
        if (Objects.equals(r101, "GET") == false) goto L24;
        r108.setDoOutput(false);     // Catch: Throwable -> L71
    L26:
        r108.setRequestMethod(r101);     // Catch: Throwable -> L71
        r108.setConnectTimeout(30000);     // Catch: Throwable -> L71
        r108.setReadTimeout(30000);     // Catch: Throwable -> L71
        if (r111 != null) goto L29;
    L38:
        r108.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L71
        if (r112 != null) goto L41;
    L44:
        DataOutputStream r109 = null;
    L45:
        int r113 = r108.getResponseCode();     // Catch: Throwable -> L69
        if (r113 == 200) goto L48;
        r102 = new TTResponse(r110, r113, parseResponseHeaders(r108.getHeaderFields()), r108.getResponseMessage());     // Catch: Throwable -> L69
    L60:
        r108.disconnect();
        if (r109 != null) goto L107;
    L65:
        if (r106 == null) goto L86;
        r106.close();     // Catch: IOException -> L68
        r102 = r102;
    L114:
        goto L86
    L107:
        r109.close();     // Catch: IOException -> L64
        goto L65
    L48:
        if (r108.getContentLength() >= 10240) goto L58;
        InputStream r114 = r108.getInputStream();     // Catch: Throwable -> L69
        if (DownloadHelper.GZIP.equalsIgnoreCase(r108.getContentEncoding()) == false) goto L52;
        BufferedReader r115 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r114)));     // Catch: Throwable -> L69
    L53:
        r106 = r115;
        StringBuilder r116 = new StringBuilder(r114.available());     // Catch: Throwable -> L69
    L54:
        String r117 = r106.readLine();     // Catch: Throwable -> L69
        if (r117 == null) goto L57;
        r116.append(r117);     // Catch: Throwable -> L69
        r116.append("\n");     // Catch: Throwable -> L69
        goto L54
    L57:
        JSONObject r118 = new JSONObject(r116.toString());     // Catch: Throwable -> L69
        r118.put("httpCode", 200);     // Catch: Throwable -> L69
        r118.put("Set-Cookie", r108.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L69
        r102 = new TTResponse(r110, r113, parseResponseHeaders(r108.getHeaderFields()), r118.toString());     // Catch: Throwable -> L69
        goto L60
    L52:
        r115 = new BufferedReader(new InputStreamReader(r114));     // Catch: Throwable -> L69
        goto L53
    L58:
        KLog.e(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "强切# http error~~~~");     // Catch: Throwable -> L69
        r102 = 0;
        goto L60
    L41:
        if (r112.length <= 0) goto L44;
        r109 = new DataOutputStream(r108.getOutputStream());     // Catch: Throwable -> L71
        r109.write(r112);     // Catch: Throwable -> L69
        r109.flush();     // Catch: Throwable -> L69
        r109.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r105 = r108;
        DataOutputStream r119 = r109;
        th = th;
        BufferedReader r120 = null;
    L111:
        KLog.e(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, th);     // Catch: Throwable -> L91
        if ((th instanceof RangersHttpException) == true) goto L90;
        r102 = TTResponse.failed(th);     // Catch: Throwable -> L91
        if (r105 == null) goto L80;
        r105.disconnect();
    L80:
        if (r119 != null) goto L105;
    L84:
        if (r120 == null) goto L86;
        r120.close();     // Catch: IOException -> L68
        r102 = r102;
        goto L114
    L105:
        r119.close();     // Catch: IOException -> L83
        goto L84
    L90:
        throw th;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        if (r105 == null) goto L94;
        r105.disconnect();
    L94:
        if (r119 != null) goto L109;
    L98:
        if (r120 == null) goto L133;
        r120.close();     // Catch: IOException -> L101
        throw th;
    L134:
        throw th;
    L133:
        throw th;
    L109:
        r119.close();     // Catch: IOException -> L97
        goto L98
    L29:
        if (r111.isEmpty() == true) goto L38;
        Iterator<Map.Entry<String, String>> r121 = r111.entrySet().iterator();     // Catch: Throwable -> L71
    L32:
        if (r121.hasNext() == false) goto L38;
        Map.Entry<String, String> r122 = r121.next();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r122.getKey()) == true) goto L32;
        if (TextUtils.isEmpty(r122.getValue()) == true) goto L32;
        r108.addRequestProperty(r122.getKey(), r122.getValue());     // Catch: Throwable -> L71
        goto L32
    L24:
        if (Objects.equals(r101, "POST") == false) goto L26;
        r108.setDoOutput(true);     // Catch: Throwable -> L71
    L71:
        th = th;
        r120 = null;
        r105 = r108;
        r119 = null;
        goto L111
    L19:
        r108 = (HttpURLConnection) INVOKEVIRTUAL_com_bytedance_badger_collect_impl_utils_CommonUtils_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r107);     // Catch: Throwable -> L73
    L73:
        th = th;
        r119 = null;
        r120 = null;
    L86:
        if (r102 == 0) goto L88;
        return r102;
    L88:
        return TTResponse.failed();
    }
}
