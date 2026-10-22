package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f244772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f244773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f244774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f244775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile List<String> f244776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile List<String> f244777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f244778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile List<Pattern> f244779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile List<String> f244780i;

    static {
        f244776e = new ArrayList();
        f244777f = new ArrayList();
        f244778g = false;
        f244779h = new ArrayList();
        f244780i = new CopyOnWriteArrayList();
    }

    public static String a(Context r100) {
        InputStream r101 = r100.getAssets().open("ttnet_config.json");     // Catch: Throwable -> L10
        byte[] r102 = new byte[r101.available()];     // Catch: Throwable -> L9
        r101.read(r102);     // Catch: Throwable -> L9
        String r103 = new String(r102, "UTF-8");     // Catch: Throwable -> L9
        r101.close();     // Catch: IOException -> L7
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r103;
    L11:
        if (r101 != null) goto L24;
    L16:
        return "";
    L24:
        r101.close();     // Catch: IOException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        r101 = null;
        goto L11
    }

    public static boolean b(Context r100) {
        String r101 = r100.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (new PolarisFileWrapper(r101 + "/ttnet_boe.flag").exists() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L14:
        return false;
    }

    public static String c(Context r100, String r101, List<Header> r102) {
        boolean r103 = true;
        if (f244778g == true) goto L22;
        if (f244774c == true) goto L22;
        String r104 = a(r100);
        if (TextUtils.isEmpty(r104) == false) goto L148;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
    L19:
        boolean r106 = true;
    L20:
        f244774c = r106;
        f244778g = true;
        goto L22
    L16:
        if (b(r100) == true) goto L19;
        r106 = false;
        goto L20
    L148:
        if (new JSONObject(r104).optBoolean("boe_proxy_enabled", false) == false) goto L13;
        r105 = true;
    L11:
        th = move-exception;
        th.printStackTrace();
    L22:
        if (f244774c == true) goto L24;
        return r101;
    L24:
        if (TextUtils.isEmpty(f244772a) == true) goto L26;
    L28:
        Uri r107 = UriProtector.parse(r101);
        if (StringUtils.isEmpty(r107.getScheme()) == false) goto L31;
        return r101;
    L31:
        if (StringUtils.isEmpty(r107.getHost()) == false) goto L33;
        return r101;
    L33:
        if (StringUtils.isEmpty(r107.getPath()) == true) goto L186;
        String r108 = r107.getHost();
        String r109 = r107.getPath();
        if (((ArrayList) f244776e).isEmpty() == true) goto L38;
    L44:
        Iterator r110 = ((ArrayList) f244776e).iterator();
    L46:
        if (r110.hasNext() == false) goto L50;
        if (UrlUtils.matchPattern(r108, (String) r110.next()) == false) goto L46;
    L68:
        boolean r111 = true;
    L71:
        if (r111 == false) goto L73;
        return r101;
    L73:
        Iterator<Header> r112 = r102.iterator();
    L75:
        if (r112.hasNext() == false) goto L86;
        Header r113 = r112.next();
        if (StringUtils.isEmpty(r113.getName()) == true) goto L75;
        if (StringUtils.isEmpty(r113.getValue()) == true) goto L75;
        if (r113.getName().equals("bypass-boe") == false) goto L75;
        if (r113.getValue().equals("1") == false) goto L75;
        return r101;
    L86:
        String r114 = r107.getScheme();
        if (f244775d == false) goto L144;
        if (r114.equals("https") == false) goto L93;
        String r115 = "http";
    L97:
        if (StringUtils.isEmpty(r115) == true) goto L144;
        r101 = r101.replaceFirst(r114, r115);
        goto L144
    L93:
        if (r114.equals("wss") == false) goto L95;
        r115 = "ws";
        goto L97
    L95:
        r115 = null;
    L144:
        boolean r116 = f.f244783a.matcher(r107.getHost()).matches();     // Catch: IllegalArgumentException -> L102
    L103:
        if (r116 == false) goto L150;
    L116:
        if (r103 == false) goto L119;
        return r101;
    L119:
        if (f244775d == false) goto L124;
        String r117 = r107.getHost();
        if (r117.contains(f244772a) == false) goto L123;
        return r101;
    L123:
        return r101.replaceFirst(r117, r117 + f244772a);
    L124:
        String r118 = r107.getHost();
        if (TextUtils.isEmpty(f244773b) == true) goto L187;
        String[] r119 = r118.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r120 = r119.length;
        if (r120 < 2) goto L188;
        int r121 = r120 - 2;
        String r122 = r119[r121];
        if (r122.contains(f244773b) == true) goto L189;
        int r123 = 0;
        int r124 = 0;
    L134:
        if (r123 >= r121) goto L142;
        if (r123 != 0) goto L137;
        int r125 = 0;
    L138:
        r124 = r101.indexOf(".", r125);
        if (r124 == (-1)) goto L140;
        r123 = r123 + 1;
        goto L134
    L140:
        r124 = 0;
        goto L142
    L137:
        r125 = r124 + 1;
    L142:
        String r126 = r122 + f244773b;
        return r101.substring(0, r124) + r101.substring(r124).replaceFirst(r122, r126);
    L189:
        return r101;
    L188:
        return r101;
    L187:
        return r101;
    L150:
        boolean r127 = f.f244784b.matcher(r107.getHost()).matches();     // Catch: IllegalArgumentException -> L107
    L108:
        if (r127 == true) goto L116;
        boolean r128 = f.f244785c.matcher(r107.getHost()).matches();     // Catch: IllegalArgumentException -> L112
    L113:
        if (r128 == true) goto L116;
        r103 = false;
    L112:
        r128 = false;
    L107:
        r127 = false;
    L102:
        r116 = false;
        goto L103
    L50:
        Iterator r129 = ((CopyOnWriteArrayList) f244780i).iterator();
    L52:
        if (r129.hasNext() == false) goto L56;
        if (UrlUtils.matchPattern(r108, (String) r129.next()) == false) goto L52;
    L56:
        Iterator r130 = ((ArrayList) f244777f).iterator();
    L58:
        if (r130.hasNext() == false) goto L62;
        if (UrlUtils.matchPattern(r109, (String) r130.next()) == false) goto L58;
    L62:
        String r131 = r108 + r109;
        Iterator r132 = ((ArrayList) f244779h).iterator();
    L64:
        if (r132.hasNext() == false) goto L70;
        if (((Pattern) r132.next()).matcher(r131).matches() == false) goto L64;
    L70:
        r111 = false;
        goto L71
    L38:
        if (((ArrayList) f244777f).isEmpty() == false) goto L44;
        if (((ArrayList) f244779h).isEmpty() == false) goto L44;
        if (((CopyOnWriteArrayList) f244780i).isEmpty() == false) goto L44;
    L186:
        return r101;
    L26:
        if (TextUtils.isEmpty(f244773b) == false) goto L28;
        return r101;
    }
}
