package com.huawei.hms.hatool;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.miui.easygo.constant.EasyGoConstant;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f277426a = null;

    static {
        f277426a = new String[]{"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d", "f8d927750a0952ffb5bd87dfb83d781ae65f7bed043a7886d1d3cdcfc94bb77a", "e9702f1e92e97fce49cdf81a5fa730a4e913554d09b3fe41e1d8a7fba00a8459", "24fbae40bcd50b759b26e3ba0f46aa25e932fa7da05f226d75ec507bcf53bce5"};
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L19;
        v.c("hmsSdk", "url is null");
        return r100;
    L19:
    L16:
        e = move-exception;
        v.b("hmsSdk", "getHostByURI error : " + e.getMessage());
        return null;
    L8:
        if (URLUtil.isNetworkUrl(r100) == true) goto L10;
    L14:
        v.b("hmsSdk", "url don't starts with https");     // Catch: URISyntaxException -> L16
        return null;
    L10:
        if (r100.toLowerCase(Locale.US).startsWith(GXImageView.NET_HTTP_PREFIX) == true) goto L14;
        return new URI(r100).getHost();
    }

    private static String a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r101 <= 0) goto L15;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length >= r101) goto L10;
        return "";
    L10:
        StringBuffer r103 = new StringBuffer();
        r103.append(r102[r102.length - r101]);
        int r104 = 1;
    L11:
        if (r104 >= r101) goto L14;
        r103.append(".");
        r103.append(r102[(r102.length - r101) + r104]);
        r104 = r104 + 1;
        goto L11
    L14:
        return r103.toString();
    L15:
        v.c("hmsSdk", "url is null");
        return r100;
    }

    public static boolean a(String r100, String r101, int r102) {
        String r103 = a(r100);
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L29:
        String r104 = "url or whitelistHash is null";
    L10:
        v.b("hmsSdk", r104);
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        String r105 = a(r103, r102);
        if (TextUtils.isEmpty(r105) == false) goto L13;
        r104 = "get urlLastNStr is null";
        goto L10
    L13:
        if (r101.equals(SHA.sha256Encrypt(r103)) == false) goto L17;
        return true;
    L17:
        if (r101.equals(SHA.sha256Encrypt(r105)) == true) goto L30;
        return false;
    L30:
        String r106 = r103.substring(0, r103.length() - r105.length());     // Catch: Exception -> L23 IndexOutOfBoundsException -> L26
        if (r106.endsWith(".") == true) goto L21;
        return false;
    L21:
        return r106.matches("^[A-Za-z0-9.-]+$");
    L26:
        e = move-exception;
        StringBuilder r107 = new StringBuilder("IndexOutOfBoundsException");
        String r108 = e.getMessage();
    L25:
        r107.append(r108);
        r104 = r107.toString();
    L23:
        e = move-exception;
        r107 = new StringBuilder("Exception : ");
        r108 = e.getMessage();
        goto L25
    }

    public static boolean b(String r100) {
        if (p.f277418a.booleanValue() == false) goto L5;
        return true;
    L5:
        String[] r101 = f277426a;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (a(r100, r101[r103], 2) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }
}
