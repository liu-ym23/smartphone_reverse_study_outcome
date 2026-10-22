package qw7;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.dtf.face.config.IConstValues;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import exc.e;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static ArrayList a(XmlPullParser r100, Context r101) {
        e.c("SDKAccountXmlImpl", "sdkaccount xml parseAccountsFromXml Start");
        int r102 = r100.getEventType();
        ArrayList r103 = new ArrayList();
        HonorAccount r104 = new HonorAccount();
    L4:
        if (1 == r102) goto L86;
        String r105 = r100.getName();
        if (r102 != 2) goto L8;
        String r106 = "";
        if ("account".equals(r105) == false) goto L20;
        String r107 = r100.getAttributeValue("", "appId");
        if (TextUtils.isEmpty(r107) == false) goto L18;
        e.d("sdk authTokenType is null");
        r107 = r101.getPackageName();
    L18:
        r104.f276540b = r107;
    L85:
        r102 = r100.next();
        goto L4
    L20:
        if ("accountName".equals(r105) == false) goto L23;
        r104.f276542d = nw7.a.a(r101, r100.nextText());
        goto L85
    L23:
        if ("userId".equals(r105) == false) goto L26;
        r104.f276543e = nw7.a.a(r101, r100.nextText());
        goto L85
    L26:
        if ("deviceId".equals(r105) == false) goto L29;
        r104.f276546h = nw7.a.a(r101, r100.nextText());
        goto L85
    L29:
        if ("subDeviceId".equals(r105) == false) goto L32;
        r104.f276547i = nw7.a.a(r101, r100.nextText());
        goto L85
    L32:
        if (IConstValues.DEVICE_TYPE.equals(r105) == false) goto L35;
        r104.f276548j = r100.nextText();
        goto L85
    L35:
        if ("serviceToken".equals(r105) == false) goto L38;
        r104.f276541c = nw7.a.a(r101, r100.nextText());
        goto L85
    L38:
        if ("siteId".equals(r105) == false) goto L44;
        r104.f276544f = CastIntegerProtector.parseInt(r100.nextText());     // Catch: Exception -> L41 NumberFormatException -> L42
    L42:
        e.e("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error");
    L41:
        e.e("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error");
        goto L85
    L44:
        if ("accountType".equals(r105) == false) goto L47;
        r104.f276549k = r100.nextText();
        goto L85
    L47:
        if (UserInfo.LOGIN_USER_NAME.equals(r105) == false) goto L50;
        r104.f276550l = nw7.a.a(r101, r100.nextText());
        goto L85
    L50:
        if ("countryIsoCode".equals(r105) == false) goto L53;
        r104.f276551m = nw7.a.a(r101, r100.nextText());
        goto L85
    L53:
        if (CommonConstant.KEY_SERVICE_COUNTRY_CODE.equals(r105) == false) goto L56;
        r104.f276553o = nw7.a.a(r101, r100.nextText());
        goto L85
    L56:
        if (ST.UUID_DEVICE.equals(r105) == false) goto L59;
        r104.f276554p = nw7.a.a(r101, r100.nextText());
        goto L85
    L59:
        if ("as_server_domain".equals(r105) == false) goto L66;
        String r108 = nw7.a.a(r101, r100.nextText());
        if (ow7.a.e(r108) == false) goto L64;
        r106 = r108;
    L64:
        r104.f276555q = r106;
        goto L85
    L66:
        if ("cas_server_domain".equals(r105) == false) goto L73;
        String r109 = nw7.a.a(r101, r100.nextText());
        if (ow7.a.e(r109) == false) goto L71;
        r106 = r109;
    L71:
        r104.f276556r = r106;
        goto L85
    L73:
        if ("siteDomain".equals(r105) == false) goto L80;
        String r110 = nw7.a.a(r101, r100.nextText());
        if (ow7.a.e(r110) == false) goto L78;
        r106 = r110;
    L78:
        r104.f276561w = r106;
        goto L85
    L80:
        if (CommonConstant.KEY_HOME_ZONE.equals(r105) == false) goto L85;
        r104.f276562x = CastIntegerProtector.parseInt(nw7.a.a(r101, r100.nextText()));     // Catch: Exception -> L83 NumberFormatException -> L84
    L84:
        e.e("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error");
    L83:
        e.e("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error");
        goto L85
    L8:
        if (r102 != 3) goto L85;
        if ("account".equals(r105) == false) goto L85;
        e.c("SDKAccountXmlImpl", "parseAccountsFromXml add account:");
        r103.add(r104);
        r104 = new HonorAccount();
        goto L85
    L86:
        return r103;
    }

    public static void b(Context r100, List r110) {
        if (r110 != null) goto L5;
    L21:
        List r101 = null;
    L22:
        if (r101 != null) goto L24;
    L66:
        e.c("SDKAccountXmlImpl", "write accounts into file error");
        return;
    L24:
        if (r101.isEmpty() == true) goto L66;
        if (r110 == null) goto L66;
        if (r110.isEmpty() == true) goto L66;
        XmlSerializer r102 = Xml.newSerializer();
        StringWriter r103 = new StringWriter();
        r102.setOutput(r103);     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        r102.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        r102.startTag("", "accounts");     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        r102.attribute("", "size", r110.size() + "");     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        Iterator r111 = r110.iterator();     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
    L36:
        if (r111.hasNext() == false) goto L38;
        c(r100, (HonorAccount) r111.next(), r102);     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        goto L36
    L38:
        r102.endTag("", "accounts");     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        r102.endDocument();     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        boolean r112 = cxc.a.e(r100.getFilesDir().getCanonicalPath() + HTTP.URL_DEFAULT, ow7.a.c(r103.toString()));     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        e.c("SDKAccountXmlImpl", "write accounts into file :" + r112);     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
        if (r112 == false) goto L41;
        cxc.a.f(r100, String.valueOf(3));     // Catch: Throwable -> L43 Exception -> L45 RuntimeException -> L48 IOException -> L51 IllegalStateException -> L54 IllegalArgumentException -> L57
    L41:
        r103.close();     // Catch: IOException -> L60
        return;
    L60:
        e.b("SDKAccountXmlImpl", "IOException ");
        return;
    L57:
        e.b("SDKAccountXmlImpl", "IllegalArgumentException write accounts failed!");     // Catch: Throwable -> L43
        r103.close();     // Catch: IOException -> L60
        return;
    L45:
        e.b("SDKAccountXmlImpl", "Exception write accounts failed!");     // Catch: Throwable -> L43
        r103.close();     // Catch: IOException -> L60
        return;
    L48:
        e.b("SDKAccountXmlImpl", "RuntimeException write accounts failed!");     // Catch: Throwable -> L43
        r103.close();     // Catch: IOException -> L60
        return;
    L54:
        e.b("SDKAccountXmlImpl", "IllegalStateException write accounts failed!");     // Catch: Throwable -> L43
        r103.close();     // Catch: IOException -> L60
        return;
    L51:
        e.b("SDKAccountXmlImpl", "IOException write accounts failed!");     // Catch: Throwable -> L43
        r103.close();     // Catch: IOException -> L60
        return;
    L43:
        th = move-exception;
        r103.close();     // Catch: IOException -> L64
    L65:
        throw th;
    L64:
        e.b("SDKAccountXmlImpl", "IOException ");
        goto L65
    L5:
        if (r110.isEmpty() == true) goto L21;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r110.iterator();
    L9:
        if (r105.hasNext() == false) goto L68;
        HonorAccount r106 = (HonorAccount) r105.next();
        if (ow7.a.b(r106) == true) goto L9;
        r104.add(r106);
        goto L9
    L68:
    L19:
        e.b("SDKAccountXmlImpl", "Exception");
    L20:
        r101 = r110;
        goto L22
    L14:
        if (r104.isEmpty() == true) goto L20;
        if (r110.containsAll(r104) == false) goto L20;
        r110.removeAll(r104);     // Catch: Exception -> L19
        goto L20
    }

    public static void c(Context r100, HonorAccount r101, XmlSerializer r102) {
        e.c("SDKAccountXmlImpl", "SDKAccountXmlImpl start.");
        if (r101 != null) goto L6;
        e.b("SDKAccountXmlImpl", "account is null.");
        return;
    L6:
        r102.startTag("", "account");
        r102.attribute("", "appId", r101.f276540b);
        cxc.a.c(r102, "accountName", nw7.a.b(r100, r101.f276542d));
        cxc.a.c(r102, "userId", nw7.a.b(r100, r101.f276543e));
        String r103 = nw7.a.b(r100, r101.f276546h);
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        cxc.a.c(r102, "deviceId", r103);
        String r104 = nw7.a.b(r100, r101.f276547i);
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        cxc.a.c(r102, "subDeviceId", r104);
        String r105 = r101.f276548j;
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        cxc.a.c(r102, IConstValues.DEVICE_TYPE, r105);
        cxc.a.c(r102, "serviceToken", nw7.a.b(r100, r101.f276541c));
        cxc.a.c(r102, UserInfo.LOGIN_USER_NAME, nw7.a.b(r100, r101.f276550l));
        cxc.a.c(r102, "countryIsoCode", nw7.a.b(r100, r101.f276551m));
        cxc.a.c(r102, "siteId", r101.f276544f + "");
        String r106 = r101.f276549k;
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        cxc.a.c(r102, "accountType", r106);
        if (TextUtils.isEmpty(r101.f276553o) == false) goto L21;
        String r107 = "";
    L22:
        String r108 = nw7.a.b(r100, r107);
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        cxc.a.c(r102, CommonConstant.KEY_SERVICE_COUNTRY_CODE, r108);
        String r109 = nw7.a.b(r100, r101.f276554p);
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        cxc.a.c(r102, ST.UUID_DEVICE, r109);
        String r110 = r101.f276555q;
        if (TextUtils.isEmpty(r110) == true) goto L32;
        r110 = nw7.a.b(r100, r110);
    L32:
        if (TextUtils.isEmpty(r110) == false) goto L34;
        r110 = "";
    L34:
        cxc.a.c(r102, "as_server_domain", r110);
        String r111 = r101.f276556r;
        if (TextUtils.isEmpty(r111) == true) goto L38;
        r111 = nw7.a.b(r100, r111);
    L38:
        if (TextUtils.isEmpty(r111) == false) goto L40;
        r111 = "";
    L40:
        cxc.a.c(r102, "cas_server_domain", r111);
        String r112 = r101.f276561w;
        if (TextUtils.isEmpty(r112) == true) goto L44;
        r112 = nw7.a.b(r100, r112);
    L44:
        if (TextUtils.isEmpty(r112) == false) goto L46;
        r112 = "";
    L46:
        cxc.a.c(r102, "siteDomain", r112);
        cxc.a.c(r102, CommonConstant.KEY_HOME_ZONE, nw7.a.b(r100, r101.f276562x + "") + "");
        String r113 = r101.f276557s;
        if (r113 != null) goto L50;
        r113 = "0";
    L50:
        if (TextUtils.isEmpty(r113) == false) goto L52;
        r113 = "";
    L52:
        cxc.a.c(r102, "lastUpdateTime", r113);
        r102.endTag("", "account");
        return;
    L21:
        r107 = r101.f276553o;
        goto L22
    }
}
