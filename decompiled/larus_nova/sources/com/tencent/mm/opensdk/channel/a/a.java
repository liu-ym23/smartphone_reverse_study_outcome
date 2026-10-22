package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.utils.logger.FLogger;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C5539a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f461595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f461596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f461597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f461598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f461599e;

        public C5539a() {
        }
    }

    public static int a(Bundle r100, String r101, int r102) {
        if (r100 != null) goto L9;
        return r102;
    L9:
        return r100.getInt(r101, r102);
    L6:
        e = move-exception;
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
        return r102;
    }

    public static Object a(int r100, String r101) {
        switch(r100) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L18;
        };
    L11:
        return r101;
    L18:
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");     // Catch: Exception -> L16
        return null;
    L6:
        return CastDoubleProtector.valueOf(r101);
    L8:
        return CastFloatProtector.valueOf(r101);
    L10:
        return Boolean.valueOf(r101);
    L13:
        return CastLongProtector.valueOf(r101);
    L15:
        return CastIntegerProtector.valueOf(r101);
    L16:
        e = move-exception;
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
        return null;
    }

    public static String a(Bundle r100, String r101) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.getString(r101);
    L7:
        e = move-exception;
        Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
        return null;
    }

    public static boolean a(Context r100, C5539a r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (b.b(r101.f461596b) == false) goto L12;
        String r102 = "send fail, action is null";
    L9:
        Log.e("MicroMsg.SDK.MMessage", r102);
        return false;
    L12:
        if (b.b(r101.f461595a) == true) goto L14;
        String r103 = r101.f461595a + ".permission.MM_MESSAGE";
    L15:
        Intent r104 = new Intent(r101.f461596b);
        Bundle r105 = r101.f461599e;
        if (r105 == null) goto L18;
        r104.putExtras(r105);
    L18:
        String r106 = r100.getPackageName();
        r104.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        r104.putExtra(ConstantsAPI.APP_PACKAGE, r106);
        r104.putExtra(ConstantsAPI.CONTENT, r101.f461597c);
        r104.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, r101.f461598d);
        r104.putExtra(ConstantsAPI.CHECK_SUM, a(r101.f461597c, Build.SDK_INT, r106));
        r100.sendBroadcast(r104, r103);
        Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + r104 + ", perm=" + r103);
        return true;
    L14:
        r103 = null;
    L20:
        r102 = "send fail, invalid argument";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0278: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:146:0x0278 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v84 */
    /* JADX WARN: Type inference failed for: r8v85 */
    public static byte[] a(String r100, int r101) {
        ByteArrayOutputStream r102 = null;
        r102 = null;
        r102 = null;
        ?? r103 = 0;
        if (r100 == null) goto L163;
        int r104 = r100.length();
        if (r104 == 0) goto L163;
        HttpURLConnection r105 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_mm_opensdk_channel_a_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));     // Catch: Throwable -> L82 Exception -> L85 IOException -> L105 MalformedURLException -> L125
        if (r105 != null) goto L200;
        Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");     // Catch: Throwable -> L16 Exception -> L18 IOException -> L20 MalformedURLException -> L22
        if (r105 != null) goto L169;
    L15:
        return null;
    L169:
        r105.disconnect();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L15
    L200:
        r105.setRequestMethod("GET");     // Catch: Throwable -> L74 Exception -> L76 IOException -> L78 MalformedURLException -> L80
        r105.setConnectTimeout(r101);     // Catch: Throwable -> L74 Exception -> L76 IOException -> L78 MalformedURLException -> L80
        r105.setReadTimeout(r101);     // Catch: Throwable -> L74 Exception -> L76 IOException -> L78 MalformedURLException -> L80
        if (r105.getResponseCode() < 300) goto L37;
        Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");     // Catch: Throwable -> L16 Exception -> L18 IOException -> L20 MalformedURLException -> L22
        r105.disconnect();     // Catch: Throwable -> L30
    L32:
        return null;
    L30:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L32
    L37:
        InputStream r106 = r105.getInputStream();     // Catch: Throwable -> L74 Exception -> L76 IOException -> L78 MalformedURLException -> L80
    L207:
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Throwable -> L66 Exception -> L68 IOException -> L70 MalformedURLException -> L72
    L202:
        byte[] r108 = new byte[1024];     // Catch: Throwable -> L58 Exception -> L60 IOException -> L62 MalformedURLException -> L64
    L41:
        int r109 = r106.read(r108);     // Catch: Throwable -> L58 Exception -> L60 IOException -> L62 MalformedURLException -> L64
        if (r109 == (-1)) goto L44;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L58 Exception -> L60 IOException -> L62 MalformedURLException -> L64
        goto L41
    L44:
        byte[] r110 = r107.toByteArray();     // Catch: Throwable -> L58 Exception -> L60 IOException -> L62 MalformedURLException -> L64
        Log.d("MicroMsg.SDK.NetUtil", "httpGet end");     // Catch: Throwable -> L58 Exception -> L60 IOException -> L62 MalformedURLException -> L64
        r105.disconnect();     // Catch: Throwable -> L47
    L184:
        r106.close();     // Catch: Throwable -> L51
    L196:
        r107.close();     // Catch: Throwable -> L55
    L57:
        return r110;
    L55:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L51:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L47:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L184
    L64:
        e = move-exception;
        InputStream r111 = r106;
        MalformedURLException e100 = e;
        ByteArrayOutputStream r112 = r107;
        HttpURLConnection r113 = r105;
    L128:
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e100.getMessage());     // Catch: Throwable -> L145
        if (r113 != null) goto L173;
    L134:
        if (r111 != null) goto L188;
    L139:
        if (r112 != null) goto L167;
    L144:
        return null;
    L167:
        r112.close();     // Catch: Throwable -> L142
    L142:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L144
    L188:
        r111.close();     // Catch: Throwable -> L137
    L137:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L139
    L173:
        r113.disconnect();     // Catch: Throwable -> L132
    L132:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L62:
        e = move-exception;
        InputStream r114 = r106;
        IOException e101 = e;
        ByteArrayOutputStream r115 = r107;
        HttpURLConnection r116 = r105;
    L108:
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e101.getMessage());     // Catch: Throwable -> L145
        if (r116 != null) goto L186;
    L114:
        if (r114 != null) goto L198;
    L119:
        if (r115 != null) goto L180;
    L124:
        return null;
    L180:
        r115.close();     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L124
    L198:
        r114.close();     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L119
    L186:
        r116.disconnect();     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L60:
        e = move-exception;
        InputStream r117 = r106;
        Exception e102 = e;
        ByteArrayOutputStream r118 = r107;
        HttpURLConnection r119 = r105;
    L88:
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e102.getMessage());     // Catch: Throwable -> L145
        if (r119 != null) goto L192;
    L94:
        if (r117 != null) goto L175;
    L99:
        if (r118 != null) goto L190;
    L104:
        return null;
    L190:
        r118.close();     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L104
    L175:
        r117.close();     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L99
    L192:
        r119.disconnect();     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L58:
        th = move-exception;
        ?? r120 = r106;
        th = th;
        r102 = r107;
        Object r121 = r105;
    L84:
        ?? r122 = r120;
        ByteArrayOutputStream r123 = r102;
        r103 = r122;
        ?? r124 = r121;
    L147:
        if (r124 != 0) goto L182;
    L152:
        if (r103 != 0) goto L194;
    L157:
        if (r123 == null) goto L210;
        r123.close();     // Catch: Throwable -> L160
        throw th;
    L160:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        throw th;
    L210:
        throw th;
    L194:
        r103.close();     // Catch: Throwable -> L155
    L155:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
        goto L157
    L182:
        r124.disconnect();     // Catch: Throwable -> L150
    L150:
        th = move-exception;
        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + th.getMessage());
    L72:
        e = move-exception;
        r111 = r106;
        e100 = e;
        HttpURLConnection r125 = r105;
    L127:
        r112 = null;
        r113 = r125;
    L70:
        e = move-exception;
        r114 = r106;
        e101 = e;
        HttpURLConnection r126 = r105;
    L107:
        r115 = null;
        r116 = r126;
    L68:
        e = move-exception;
        r117 = r106;
        e102 = e;
        HttpURLConnection r127 = r105;
    L87:
        r118 = null;
        r119 = r127;
    L66:
        th = move-exception;
        r120 = r106;
        th = th;
        r121 = r105;
    L80:
        e100 = e;
        r111 = null;
        r125 = r105;
    L78:
        e101 = e;
        r114 = null;
        r126 = r105;
    L76:
        e102 = e;
        r117 = null;
        r127 = r105;
    L74:
        th = th;
        r120 = 0;
        r121 = r105;
    L22:
        e100 = e;
        r111 = null;
        r112 = null;
        r113 = r105;
    L20:
        e101 = e;
        r114 = null;
        r115 = null;
        r116 = r105;
    L18:
        e102 = e;
        r117 = null;
        r118 = null;
        r119 = r105;
    L16:
        th = th;
        r123 = null;
        r124 = r105;
        goto L147
    L125:
        e = move-exception;
        e100 = e;
        r125 = null;
        r111 = null;
    L105:
        e = move-exception;
        e101 = e;
        r126 = null;
        r114 = null;
    L85:
        e = move-exception;
        e102 = e;
        r127 = null;
        r117 = null;
    L82:
        th = move-exception;
        th = th;
        r121 = null;
        r120 = 0;
    L145:
        th = th;
        r102 = r4;
        r120 = r104;
        r121 = r100;
    L163:
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_mm_opensdk_channel_a_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public static byte[] a(String r100, int r101, String r102) {
        StringBuffer r103 = new StringBuffer();
        if (r100 == null) goto L5;
        r103.append(r100);
    L5:
        r103.append(r101);
        r103.append(r102);
        r103.append("mMcShCsTr");
        byte[] r104 = r103.toString().substring(1, 9).getBytes();
        char[] r105 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        MessageDigest r106 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L11
        r106.update(r104);     // Catch: Exception -> L11
        byte[] r107 = r106.digest();     // Catch: Exception -> L11
        int r108 = r107.length;     // Catch: Exception -> L11
        char[] r109 = new char[r108 * 2];     // Catch: Exception -> L11
        int r110 = 0;
        int r111 = 0;
    L7:
        if (r110 >= r108) goto L9;
        byte r112 = r107[r110];     // Catch: Exception -> L11
        int r113 = r111 + 1;     // Catch: Exception -> L11
        r109[r111] = r105[(r112 >>> 4) & 15];     // Catch: Exception -> L11
        r111 = r113 + 1;     // Catch: Exception -> L11
        r109[r113] = r105[r112 & 15];     // Catch: Exception -> L11
        r110 = r110 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        String r114 = new String(r109);     // Catch: Exception -> L11
    L13:
        return r114.getBytes();
    L11:
        r114 = null;
        goto L13
    }
}
