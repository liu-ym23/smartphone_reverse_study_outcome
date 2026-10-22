package dxc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.IConstValues;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.data.UserInfo;
import exc.e;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements a {
    public d() {
    }

    public static ArrayList b(XmlPullParser r100, Context r101) {
        e.d("parseAccountsFromXml Start");
        int r102 = r100.getEventType();
        ArrayList r103 = new ArrayList();
        HonorAccount r104 = new HonorAccount();
    L4:
        if (1 == r102) goto L62;
        String r105 = r100.getName();
        if (r102 == 0) goto L61;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L13;
        e.d("default");
        goto L61
    L13:
        if ("account".equals(r105) == false) goto L61;
        e.d("parseAccountsFromXml account add ");
        if (TextUtils.isEmpty(r104.f276542d) == true) goto L17;
        r103.add(r104);
    L18:
        r104 = new HonorAccount();
        goto L61
    L17:
        e.c("XmlFileGrade", "Invalid account , not need add.");
        goto L18
    L20:
        if ("account".equals(r105) == false) goto L29;
        String r106 = "";
        String r107 = r100.getAttributeValue("", "appId");
        if (TextUtils.isEmpty(r107) == false) goto L27;
        e.d("authTokenType is null");
        if (r101 == null) goto L26;
        r106 = r101.getPackageName();
    L26:
        r107 = r106;
    L27:
        r104.f276540b = r107;
        goto L61
    L29:
        if ("accountName".equals(r105) == false) goto L32;
        r104.f276542d = nw7.a.a(r101, r100.nextText());
        goto L61
    L32:
        if ("userId".equals(r105) == false) goto L35;
        r104.f276543e = nw7.a.a(r101, r100.nextText());
        goto L61
    L35:
        if ("deviceId".equals(r105) == false) goto L38;
        r104.f276546h = nw7.a.a(r101, r100.nextText());
        goto L61
    L38:
        if ("subDeviceId".equals(r105) == false) goto L41;
        r104.f276547i = nw7.a.a(r101, r100.nextText());
        goto L61
    L41:
        if (IConstValues.DEVICE_TYPE.equals(r105) == false) goto L44;
        r104.f276548j = r100.nextText();
        goto L61
    L44:
        if ("serviceToken".equals(r105) == false) goto L47;
        r104.f276541c = nw7.a.a(r101, r100.nextText());
        goto L61
    L47:
        if ("siteId".equals(r105) == false) goto L53;
        r104.f276544f = CastIntegerProtector.parseInt(r100.nextText());     // Catch: Exception -> L50 NumberFormatException -> L51
    L51:
        e.e("XmlFileGrade", "NumberFormatException: read accounts.xml parseInt error");
    L50:
        e.e("XmlFileGrade", "read accounts.xml parseInt error");
        goto L61
    L53:
        if ("accountType".equals(r105) == false) goto L56;
        r104.f276549k = r100.nextText();
        goto L61
    L56:
        if (UserInfo.LOGIN_USER_NAME.equals(r105) == false) goto L59;
        r104.f276550l = nw7.a.a(r101, r100.nextText());
        goto L61
    L59:
        if ("countryIsoCode".equals(r105) == false) goto L61;
        r104.f276551m = nw7.a.a(r101, r100.nextText());
    L61:
        r102 = r100.next();
        goto L4
    L62:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.xmlpull.v1.XmlPullParser] */
    /* JADX WARN: Type inference failed for: r7v20, types: [com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    @Override // dxc.a
    public final void a(Context r100, int r101) {
        ?? r102 = "XmlFileGrade";
        if (r101 < 3) goto L6;
        e.b("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error");
        return;
    L6:
        e.c("XmlFileGrade", "update HnAccounts.xml when version update");
        gxc.a r103 = gxc.a.a(r100);
        r103.c("last_head_picture_url");
        e.c("XmlFileGrade", "delete last_head_picture_url in HonorAccount.xml");
        r103.c("DEVID_1");
        e.c("XmlFileGrade", "delete DEVID in HonorAccount.xml");
        r103.c("SUBDEVID");
        e.c("XmlFileGrade", "delete SUBDEVID in HonorAccount.xml");
        r103.c("hasEncryptHeadPictureUrl");
        e.c("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HonorAccount.xml");
        String r104 = r103.b("accessToken");
        if (TextUtils.isEmpty(r104) == true) goto L12;
        String r105 = nw7.a.a(r100, r104);
        if (TextUtils.isEmpty(r105) == true) goto L11;
        e.c("XmlFileGrade", "update accessToken in HonorAccount.xml");
        r103.d("accessToken", r105);
        goto L12
    L11:
        r103.c("accessToken");
        e.c("XmlFileGrade", "accessToken ecb decrypt error");
    L12:
        String r106 = r103.b("UUID");
        if (TextUtils.isEmpty(r106) == true) goto L15;
        e.c("XmlFileGrade", "update uuid in HonorAccount.xml");
        r103.d("UUID", r106);
    L16:
        String r107 = r100.getPackageName();
        cxc.c.a(r100).getClass();
        if (r107.equals("com.hihonor.id") == true) goto L100;
        String r108 = "IOException";
        ?? r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r100.getFilesDir().getCanonicalPath() + "/accounts.xml");     // Catch: Throwable -> L36 Exception -> L75 RuntimeException -> L76 IOException -> L77 FileNotFoundException -> L78 XmlPullParserException -> L79
        if (r110.exists() == true) goto L23;
        e.c("XmlFileGrade", "xmlfilegradle sdk filepath not exist");     // Catch: Throwable -> L36 Exception -> L75 RuntimeException -> L76 IOException -> L77 FileNotFoundException -> L78 XmlPullParserException -> L79
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L36 Exception -> L75 RuntimeException -> L76 IOException -> L77 FileNotFoundException -> L78 XmlPullParserException -> L79
    L96:
    L63:
        FileOutputStream r112 = cxc.a.f465749a;
        r108 = "accounts.xml";
        r102 = TextUtils.isEmpty("accounts.xml");
        if (r102 != 0) goto L67;
        cxc.a.d(new PolarisFileWrapper(r100.getFilesDir(), "accounts.xml"));
    L67:
        qw7.b.b(r100, r111);
        return;
    L23:
        ?? r113 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L36 Exception -> L75 RuntimeException -> L76 IOException -> L77 FileNotFoundException -> L78 XmlPullParserException -> L79
        ?? r114 = Xml.newPullParser();     // Catch: Throwable -> L29 Exception -> L31 RuntimeException -> L32 IOException -> L33 FileNotFoundException -> L34 XmlPullParserException -> L35
        r114.setInput(r113, null);     // Catch: Throwable -> L29 Exception -> L31 RuntimeException -> L32 IOException -> L33 FileNotFoundException -> L34 XmlPullParserException -> L35
        ArrayList r115 = b(r114, r100);     // Catch: Throwable -> L29 Exception -> L31 RuntimeException -> L32 IOException -> L33 FileNotFoundException -> L34 XmlPullParserException -> L35
        r113.close();     // Catch: IOException -> L27
    L28:
        r111 = r115;
        r109 = r115;
    L27:
        e.b("XmlFileGrade", "IOException");
        goto L28
    L34:
        r109 = r113;
    L33:
        r109 = r113;
    L32:
        r109 = r113;
    L35:
        r109 = r113;
    L31:
        r109 = r113;
    L29:
        th = th;
    L70:
        if (r113 != 0) goto L80;
    L74:
        throw th;
    L80:
        r113.close();     // Catch: IOException -> L73
    L73:
        e.b(r102, r108);
    L36:
        th = th;
        r113 = r109;
    L53:
        e.b("XmlFileGrade", "readAccountsFromXml FileNotFoundException");     // Catch: Throwable -> L36
        r111 = new ArrayList();     // Catch: Throwable -> L36
        if (r109 == 0) goto L63;
        r109.close();     // Catch: IOException -> L57
    L57:
        e.b("XmlFileGrade", "IOException");
    L48:
        e.b("XmlFileGrade", "readAccountsFromXml IOException");     // Catch: Throwable -> L36
        r111 = new ArrayList();     // Catch: Throwable -> L36
        if (r109 == 0) goto L63;
        r109.close();     // Catch: IOException -> L52
    L52:
        e.b("XmlFileGrade", "IOException");
    L43:
        e.b("XmlFileGrade", "readAccountsFromXml RuntimeException");     // Catch: Throwable -> L36
        r111 = new ArrayList();     // Catch: Throwable -> L36
        if (r109 == 0) goto L63;
        r109.close();     // Catch: IOException -> L47
    L47:
        e.b("XmlFileGrade", "IOException");
    L58:
        e.b("XmlFileGrade", "XmlPullParserException readAccountsFromXmlfailed!");     // Catch: Throwable -> L36
        r111 = new ArrayList();     // Catch: Throwable -> L36
        if (r109 == 0) goto L63;
        r109.close();     // Catch: IOException -> L62
    L62:
        e.b("XmlFileGrade", "IOException");
    L38:
        e.b("XmlFileGrade", "readAccountsFromXml Exception");     // Catch: Throwable -> L36
        r111 = new ArrayList();     // Catch: Throwable -> L36
        if (r109 == 0) goto L63;
        r109.close();     // Catch: IOException -> L42
    L42:
        e.b("XmlFileGrade", "IOException");
        goto L63
    L100:
        return;
    L15:
        r103.c("UUID");
        e.c("XmlFileGrade", "uuid ecb decrypt error");
        goto L16
    }
}
