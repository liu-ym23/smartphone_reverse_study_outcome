package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static eta.b f408079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f408080b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f408081c = null;

    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408082a = null;

        static {
            int[] r100 = new int[Level.values().length];
            f408082a = r100;
            r100[Level.L0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f408082a[Level.L1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface b {
        HashMap<String, String> getExtrparams(Level r100);
    }

    static {
        f408080b = new ConcurrentHashMap();
        f408081c = new ConcurrentHashMap();
    }

    public static boolean f(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        if (r100.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r100.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r101 = 0;
    L13:
        if (r101 >= r100.length()) goto L21;
        if (r100.charAt(r101) != '0') goto L16;
        r101 = r101 + 1;
        goto L13
    L16:
        return false;
    L21:
        return true;
    }

    public static void a(StringBuilder r100, Map<String, String> r101) {
        Uri r102 = UriProtector.parse(r100.toString());
        Set<String> r103 = UriProtector.getQueryParameterNames(r102);
        Uri.Builder r104 = r102.buildUpon();
        Iterator r105 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r107 = (String) r106.getKey();
        String r108 = (String) r106.getValue();
        if (r103.contains(r107) == true) goto L4;
        if (TextUtils.isEmpty(r108) == true) goto L4;
        r104.appendQueryParameter(r107, (String) r106.getValue());
        goto L4
    L10:
        r100.delete(0, r100.length());
        r100.append(r104.build().toString());
    }

    public static String b(String r100, boolean r101) {
        Level r102 = Level.L0;
        eta.b r103 = f408079a;
        if (StringUtils.isEmpty(r100) == true) goto L8;
        if (r103 == null) goto L9;
        StringBuilder r104 = new StringBuilder(r100);
        d(r104, r101, r102);
        return r104.toString();
    L9:
        return r100;
    L8:
        return r100;
    }

    public static void c(String r100, Level r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty("language") == false) goto L7;
        return;
    L7:
        if (StringUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        if (jta.g.f() == false) goto L12;
        com.bytedance.bdinstall.i.a(r100, r101);
        return;
    L12:
        int r102 = a.f408082a[r101.ordinal()];
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L18;
        f408080b.put("language", r100);
    L18:
        String[] r103 = d0.f408092a;
        if (StringUtils.isEmpty("language") == false) goto L21;
        return;
    L21:
        if (StringUtils.isEmpty(r100) == false) goto L24;
        return;
    L24:
        if (jta.g.f() == false) goto L26;
        com.bytedance.bdinstall.i.a(r100, r101);
        return;
    L26:
        int r104 = d0.a.f408104a[r101.ordinal()];
        if (r104 == 1) goto L31;
        if (r104 != 2) goto L40;
        d0.f408101j.put("language", r100);
        return;
    L40:
        return;
    L31:
        d0.f408102k.put("language", r100);
        return;
    L17:
        f408081c.put("language", r100);
        goto L18
    }

    public static void d(StringBuilder r100, boolean r101, Level r102) {
        if (f408079a == null) goto L24;
        String r103 = r100.toString();
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return;
    L7:
        Uri r104 = UriProtector.parse(r103);
        Set<String> r105 = UriProtector.getQueryParameterNames(r104);
        Uri.Builder r106 = r104.buildUpon();
        LinkedHashMap r107 = new LinkedHashMap();
        g(r107, r101, r102);
        Iterator r108 = r107.entrySet().iterator();
    L9:
        if (r108.hasNext() == false) goto L15;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r110 = (String) r109.getKey();
        String r111 = (String) r109.getValue();
        if (r105.contains(r110) == true) goto L9;
        if (TextUtils.isEmpty(r111) == true) goto L9;
        r106.appendQueryParameter(r110, (String) r109.getValue());
        goto L9
    L15:
        r100.delete(0, r100.length());
        r100.append(r106.build().toString());
        return;
    }

    public static void g(Map<String, String> r110, boolean r111, Level r112) {
        eta.b r100 = f408079a;
        if (r100 != null) goto L5;
        return;
    L5:
        Context r101 = r100.getContext();
        if (jta.g.f() == false) goto L10;
        com.bytedance.bdinstall.k r102 = com.bytedance.bdinstall.i.f199652b;
        if (r102.e() == false) goto L189;
        r102.f199682i.b(r101, r111, r110, r112);
        return;
    L189:
        return;
    L10:
        eta.b r103 = d0.f408095d;
        if (r110 == null) goto L191;
        if (r103 == null) goto L192;
        if (r112 != null) goto L16;
        return;
    L16:
        if (jta.g.f() == false) goto L20;
        Context r104 = r103.getContext();
        com.bytedance.bdinstall.k r105 = com.bytedance.bdinstall.i.f199652b;
        if (r105.e() == false) goto L193;
        r105.f199682i.b(r104, r111, r110, r112);
        return;
    L193:
        return;
    L20:
        HashMap r106 = new HashMap();
        boolean r107 = true;
        String r108 = ita.k.c(r103.getContext());     // Catch: Exception -> L33
        if (r108 != null) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == true) goto L29;
        jta.g.f500376j.x(r106, jta.g.f500369c);     // Catch: Exception -> L33
    L34:
        String r113 = (String) r106.get("klink_egdi");
        if (StringUtils.isEmpty(r113) == true) goto L37;
        r110.put("klink_egdi", r113);
    L37:
        String r114 = (String) r106.get("install_id");
        if (StringUtils.isEmpty(r114) == true) goto L40;
        r110.put(WsConstants.KEY_INSTALL_ID, r114);
    L40:
        String r115 = (String) r106.get("device_id");
        if (StringUtils.isEmpty(r115) == true) goto L43;
        r110.put("device_id", r115);
    L43:
        Context r116 = r103.getContext();
        if (r116 == null) goto L50;
        String[] r117 = d0.f408092a;
        String r118 = NetworkUtils.getNetworkAccessType(r116);
        if (StringUtils.isEmpty(r118) == true) goto L50;
        r110.put(TTVideoEngineInterface.PLAY_API_KEY_AC, r118);
        if (Logger.debug() == false) goto L50;
        ita.j.b("NetUtil get access from access " + r118, null);
    L50:
        if (r116 != null) goto L53;
        boolean r119 = lta.c.f510716a;
        r107 = false;
    L56:
        String r120 = r103.getTweakedChannel();
        if (r120 == null) goto L59;
        r110.put("channel", r120);
    L59:
        r110.put("aid", String.valueOf(r103.getAid()));
        String r121 = r103.getAppName();
        if (r121 == null) goto L62;
        r110.put("app_name", r121);
    L62:
        r110.put("version_code", String.valueOf(r103.getVersionCode()));
        r110.put("version_name", r103.getVersion());
        String r122 = "android";
        r110.put("device_platform", "android");
        if (pta.d.h() == false) goto L65;
        r122 = RomUtils.OS_HARMONY;
    L65:
        r110.put("os", r122);
    L70:
        th = move-exception;
        th.printStackTrace();
    L72:
        String r123 = r103.getAbVersion();
        if (StringUtils.isEmpty(r123) == true) goto L75;
        r110.put(TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, r123);
    L75:
        String r124 = r103.getAbClient();
        if (StringUtils.isEmpty(r124) == true) goto L78;
        r110.put("ab_client", r124);
    L78:
        String r125 = r103.getAbGroup();
        if (StringUtils.isEmpty(r125) == true) goto L81;
        r110.put("ab_group", r125);
    L81:
        String r126 = r103.getAbFeature();
        if (StringUtils.isEmpty(r126) == true) goto L84;
        r110.put("ab_feature", r126);
    L84:
        long r127 = r103.getAbFlag();
        if (r127 <= 0) goto L87;
        r110.put("abflag", String.valueOf(r127));
    L87:
        if (r111 == false) goto L89;
        r110.put("ssmix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
    L89:
        r110.put("device_type", Build.MODEL);
        r110.put("device_brand", Build.BRAND);
        r110.put("language", Locale.getDefault().getLanguage());
        r110.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r128 = Build.VERSION.RELEASE;     // Catch: Exception -> L97
        if (r128 != null) goto L93;
    L95:
        r110.put("os_version", r128);     // Catch: Exception -> L97
        goto L98
    L93:
        if (r128.length() <= 10) goto L95;
        r128 = r128.substring(0, 10);     // Catch: Exception -> L97
    L98:
        Level r129 = Level.L0;
        if (r112 == r129) goto L101;
    L105:
        r110.put("manifest_version_code", String.valueOf(r103.getManifestVersionCode()));
        String r130 = UIUtils.getScreenResolution(r103.getContext());
        if (StringUtils.isEmpty(r130) == true) goto L108;
        r110.put("resolution", r130);
    L108:
        int r131 = UIUtils.getDpi(r103.getContext());
        if (r131 <= 0) goto L111;
        r110.put("dpi", String.valueOf(r131));
    L111:
        r110.put("update_version_code", String.valueOf(r103.getUpdateVersionCode()));
        r110.put("_rticket", String.valueOf(System.currentTimeMillis()));
        d0.c(d0.f408101j, r110);
        if (r112 != r129) goto L169;
        d0.c(d0.f408102k, r110);
    L169:
    L135:
        th = move-exception;
        th.printStackTrace();
    L137:
        String r132 = pta.a.a(r116);
        if (StringUtils.isEmpty(r132) == true) goto L141;
        r110.put("cdid", r132);
    L141:
        if (r112 != Level.L0) goto L162;
        if (r107 == true) goto L150;
        if (jta.g.f500373g != null) goto L147;
        jta.g.f500373g = new jta.j();
    L147:
        if (jta.g.f500373g.f500382a.b() == false) goto L162;
        kta.s.b(r116).a();
        goto L162
    L150:
        if (jta.g.f500372f == true) goto L154;
        String r133 = r103.getDeviceId();
        if (f(r133) == true) goto L154;
        r110.put(ST.UUID_DEVICE, r133);
    L154:
        if (r107 == false) goto L162;
        String r134 = kta.f.c(kta.n.c(r116));     // Catch: Throwable -> L159
        if (r134 == null) goto L162;
        r110.put("oaid", r134);     // Catch: Throwable -> L159
    L159:
        th = move-exception;
        th.printStackTrace();
    L162:
        if (jta.g.g(r116) == false) goto L195;
        jta.k r135 = (jta.k) ota.b.a(jta.k.class);
        if (r135 == null) goto L196;
        r135.a();
        return;
    L196:
        return;
    L195:
        return;
    L115:
        if (d0.f408103l == null) goto L137;
        HashMap<String, String> r136 = d0.f408103l.getExtrparams(r112);     // Catch: Throwable -> L135
        if (r136 == null) goto L137;
        if (r136.isEmpty() == true) goto L137;
        Iterator<Map.Entry<String, String>> r137 = r136.entrySet().iterator();     // Catch: Throwable -> L135
    L122:
        if (r137.hasNext() == false) goto L137;
        Map.Entry<String, String> r138 = r137.next();     // Catch: Throwable -> L135
        if (r138 == null) goto L122;
        String r139 = r138.getKey();     // Catch: Throwable -> L135
        String r140 = r138.getValue();     // Catch: Throwable -> L135
        if (StringUtils.isEmpty(r139) == true) goto L122;
        if (StringUtils.isEmpty(r140) == true) goto L122;
        if (r110.containsKey(r139) == true) goto L122;
        r110.put(r139, r140);     // Catch: Throwable -> L135
        goto L122
    L101:
        if (jta.g.f500376j.t() == true) goto L105;
        String r141 = (String) r106.get("openudid");
        if (StringUtils.isEmpty(r141) == true) goto L105;
        r110.put("openudid", r141);
        goto L105
    L67:
        if (pta.d.h() == false) goto L72;
        r110.put("sub_os_api", String.valueOf(i84.u.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L70
        goto L72
    L53:
        if (lta.c.f510716a == true) goto L56;
        r107 = lta.c.f510717b.b(new Object[]{r116}).getBoolean("_install_started_v2", false);
        goto L56
    L29:
        if (Logger.debug() == false) goto L34;
        ita.j.b("PushService idmap = " + StringUtils.mapToString(r106), null);     // Catch: Exception -> L33
        goto L34
    L24:
        if (r108.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L26;
        r109 = true;
    L33:
        jta.g.f500376j.x(r106, jta.g.f500369c);
        goto L34
    L192:
        return;
    }

    public static String e(com.bytedance.applog.m r100, String r101, byte[] r102, boolean r103, String r104, Map r105, boolean r106, boolean r107) throws CommonHttpException {
        HashMap r108 = new HashMap();
        if (StringUtils.isEmpty(r104) == true) goto L6;
        r108.put("Content-Type", r104);
    L6:
        if (r103 == false) goto L27;
        if (r100 != null) goto L9;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == true) goto L27;
        r102 = NetworkClient.compressWithgzip(r102);     // Catch: Exception -> L24
        r108.put("Content-Encoding", DownloadHelper.GZIP);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L9:
        if (r101.contains("/service/2/app_log/") == false) goto L20;
        com.bytedance.applog.e r110 = r100.a(r102);
        if (r110 == null) goto L20;
        byte[] r111 = r110.f192451a;
        if (r111 == null) goto L20;
        Map<String, String> r112 = r110.f192453c;
        if (r112 != null) goto L17;
    L19:
        r109 = true;
        r102 = r111;
        goto L21
    L17:
        if (r112.isEmpty() == true) goto L19;
        r108.putAll(r110.f192453c);
    L27:
        if (r105 == null) goto L29;
        r108.putAll(r105);
    L29:
        if (r107 == true) goto L31;
        ita.g.a(r108, r106);
    L31:
        NetworkClient.ReqContext r113 = new NetworkClient.ReqContext();
        r113.addCommonParams = false;
        return NetworkClient.getDefault().post(r101, r102, r108, r113);
    }

    public static String h(com.bytedance.applog.m r100, String r101, byte[] r102, Context r103, boolean r104, String[] r105, Map r110, boolean r111, boolean r112) throws Exception {
        String[] r106 = d0.f408092a;
        byte[] r107 = null;
        GZIPInputStream r108 = null;
        GZIPInputStream r109 = null;
        r108 = null;
        r109 = null;
        if (StringUtils.isEmpty(r101) == true) goto L145;
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.length <= 0) goto L146;
        HashMap r113 = new HashMap();
        r113.put("log-encode-type", DownloadHelper.GZIP);
        if (r101.contains("/service/2/app_log/") == false) goto L41;
        if (r100 != null) goto L125;
    L28:
        if (r103 == null) goto L35;
        d0.a(r103);     // Catch: Throwable -> L26
        if (d0.f408098g >= 3) goto L34;
        byte[] r114 = EncryptorUtil.b(r102, r102.length);     // Catch: Throwable -> L26
        d0.f(r103);     // Catch: Throwable -> L26
        if (r114 != null) goto L42;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);     // Catch: Throwable -> L26
    L42:
        if (r114 == null) goto L110;
        String r115 = r101.concat("&tt_data=a");
        if (r104 == false) goto L46;
        r115 = r115 + "&config_retry=b";
    L46:
        r113.remove("Content-Encoding");
        r113.put("Content-Type", DownloadNetworkFactory.ContentType.TT_DATA);
        if (r110 == null) goto L49;
        r113.putAll(r110);
    L49:
        if (r112 == true) goto L52;
        ita.g.a(r113, r111);
    L52:
        if (nta.d.d(r105) == false) goto L144;
        byte[] r116 = NetworkClient.getDefault().postDataStream(r115, r114, r113, null);
        if (r116 == null) goto L107;
        String r117 = r105[0];
        String r118 = r105[1];
        Cipher r119 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L64
        int r120 = r117.length();     // Catch: Throwable -> L64
        byte[] r121 = new byte[r120];     // Catch: Throwable -> L64
        int r122 = 0;
    L57:
        if (r122 >= r120) goto L59;
        r121[r122] = (byte) r117.charAt(r122);     // Catch: Throwable -> L64
        r122 = r122 + 1;     // Catch: Throwable -> L64
        goto L57
    L59:
        SecretKeySpec r123 = new SecretKeySpec(r121, CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L64
        int r124 = r118.length();     // Catch: Throwable -> L64
        byte[] r125 = new byte[r124];     // Catch: Throwable -> L64
        int r126 = 0;
    L60:
        if (r126 >= r124) goto L62;
        r125[r126] = (byte) r118.charAt(r126);     // Catch: Throwable -> L64
        r126 = r126 + 1;     // Catch: Throwable -> L64
        goto L60
    L62:
        r119.init(2, r123, new IvParameterSpec(r125));     // Catch: Throwable -> L64
        byte[] r127 = r119.doFinal(r116);     // Catch: Throwable -> L64
    L66:
        if (r127 != null) goto L69;
        return new String(r116);
    L69:
        if (r127.length <= 0) goto L143;
        ByteArrayOutputStream r128 = new ByteArrayOutputStream();
        ByteArrayInputStream r129 = new ByteArrayInputStream(r127);     // Catch: Throwable -> L88 IOException -> L97
        GZIPInputStream r130 = new GZIPInputStream(r129);     // Catch: Throwable -> L85 IOException -> L87
        goto L98
    L132:
        byte[] r131 = new byte[1024];     // Catch: Throwable -> L82 IOException -> L84
    L76:
        int r132 = r130.read(r131);     // Catch: Throwable -> L82 IOException -> L84
        if (r132 < 0) goto L119;
        r128.write(r131, 0, r132);     // Catch: Throwable -> L82 IOException -> L84
    L119:
        r130.close();     // Catch: IOException -> L112
    L115:
        r129.close();     // Catch: IOException -> L113
    L104:
        r107 = r128.toByteArray();
    L84:
        r108 = r130;
    L82:
        th = th;
        r109 = r130;
    L90:
        if (r109 != null) goto L126;
    L94:
        if (r129 == null) goto L139;
        r129.close();     // Catch: IOException -> L114
        throw th;
    L140:
        throw th;
    L139:
        throw th;
    L126:
        r109.close();     // Catch: IOException -> L93
    L85:
        th = th;
    L98:
        if (r108 != null) goto L121;
    L102:
        if (r129 == null) goto L104;
    L121:
        r108.close();     // Catch: IOException -> L101
        goto L102
    L97:
        r129 = null;
    L88:
        th = th;
        r129 = null;
    L143:
        return new String(r107);
    L64:
        th = move-exception;
        th.printStackTrace();
        r127 = null;
        goto L66
    L107:
        throw new RuntimeException("get encrypted resp failed");
    L144:
        return NetworkClient.getDefault().post(r115, r114, r113, null);
    L110:
        throw new RuntimeException("encrypt failed");
    L34:
        r114 = null;
        goto L42
    L35:
        r114 = EncryptorUtil.b(r102, r102.length);     // Catch: Throwable -> L26
        if (r114 != null) goto L42;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);     // Catch: Throwable -> L26
        goto L42
    L125:
        com.bytedance.applog.e r133 = r100.a(r102);     // Catch: Throwable -> L26
        if (r133 == null) goto L25;
        byte[] r134 = r133.f192451a;     // Catch: Throwable -> L26
        if (r134 == null) goto L25;
        Map<String, String> r135 = r133.f192453c;     // Catch: Throwable -> L23
        if (r135 != null) goto L20;
    L22:
        r102 = r134;
        goto L28
    L20:
        if (r135.isEmpty() == true) goto L22;
        r113.putAll(r133.f192453c);     // Catch: Throwable -> L23
    L23:
        th = th;
    L40:
        ita.j.c("compress log data failed", th);
        r114 = r134;
    L25:
        e.a().b(StatsCountKeys.COMPRESS_ERROR_COUNT, 1);     // Catch: Throwable -> L26
        return null;
    L26:
        th = th;
        r134 = r102;
        goto L40
    L41:
        r114 = d0.b(r103, r102);
        goto L42
    L146:
        return null;
    L145:
        return null;
    }
}
