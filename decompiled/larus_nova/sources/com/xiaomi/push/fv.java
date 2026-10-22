package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes41.dex */
public class fv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static XmlPullParser f463623a;

    public static fn a(XmlPullParser r110) {
        boolean r111 = false;
        String r112 = null;
        if ("1".equals(r110.getAttributeValue("", "s")) == false) goto L40;
        String r100 = r110.getAttributeValue("", "chid");
        String r113 = r110.getAttributeValue("", "id");
        String r101 = r110.getAttributeValue("", "from");
        String r102 = r110.getAttributeValue("", RemoteMessageConst.TO);
        String r103 = r110.getAttributeValue("", "type");
        com.xiaomi.push.service.am.b r104 = com.xiaomi.push.service.am.a().a(r100, r102);
        if (r104 != null) goto L7;
        r104 = com.xiaomi.push.service.am.a().a(r100, r101);
    L7:
        if (r104 == null) goto L39;
        fn r114 = null;
    L10:
        if (r111 == true) goto L34;
        int r105 = r110.next();
        if (r105 == 2) goto L14;
        if (r105 != 3) goto L10;
        if (r110.getName().equals("message") == false) goto L10;
        r111 = true;
        goto L10
    L14:
        if ("s".equals(r110.getName()) == false) goto L28;
        if (r110.next() != 4) goto L26;
        String r106 = r110.getText();
        if ("5".equals(r100) == true) goto L23;
        if ("6".equals(r100) == true) goto L23;
        a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(r104.f464222h, r113), r106));
        f463623a.next();
        r114 = a(f463623a);
    L23:
        fm r107 = new fm();
        r107.l(r100);
        r107.b(true);
        r107.n(r101);
        r107.m(r102);
        r107.k(r113);
        r107.f(r103);
        fk r108 = new fk("s", null, null, null);
        r108.m9097a(r106);
        r107.a(r108);
        return r107;
    L26:
        throw new fh("error while receiving a encrypted message with wrong format");
    L28:
        throw new fh("error while receiving a encrypted message with wrong format");
    L34:
        if (r114 == null) goto L37;
        return r114;
    L37:
        throw new fh("error while receiving a encrypted message with wrong format");
    L39:
        throw new fh("the channel id is wrong while receiving a encrypted message");
    L40:
        fm r109 = new fm();
        String r115 = r110.getAttributeValue("", "id");
        if (r115 != null) goto L43;
        r115 = "ID_NOT_AVAILABLE";
    L43:
        r109.k(r115);
        r109.m(r110.getAttributeValue("", RemoteMessageConst.TO));
        r109.n(r110.getAttributeValue("", "from"));
        r109.l(r110.getAttributeValue("", "chid"));
        r109.a(r110.getAttributeValue("", "appid"));
        String r116 = r110.getAttributeValue("", "transient");     // Catch: Exception -> L46
    L107:
        String r117 = r110.getAttributeValue("", OnekeyLoginConstants.CU_KEY_SEQ);     // Catch: Exception -> L104
        if (TextUtils.isEmpty(r117) == true) goto L111;
        r109.b(r117);     // Catch: Exception -> L104
    L111:
        String r118 = r110.getAttributeValue("", "mseq");     // Catch: Exception -> L105
        if (TextUtils.isEmpty(r118) == true) goto L115;
        r109.c(r118);     // Catch: Exception -> L105
    L115:
        String r119 = r110.getAttributeValue("", "fseq");     // Catch: Exception -> L106
        if (TextUtils.isEmpty(r119) == true) goto L113;
        r109.d(r119);     // Catch: Exception -> L106
    L113:
        String r120 = r110.getAttributeValue("", "status");     // Catch: Exception -> L60
        if (TextUtils.isEmpty(r120) == true) goto L62;
        r109.e(r120);     // Catch: Exception -> L60
    L62:
        if (TextUtils.isEmpty(r116) == false) goto L64;
    L66:
        boolean r121 = false;
    L67:
        r109.a(r121);
        r109.f(r110.getAttributeValue("", "type"));
        String r122 = b(r110);
        if (r122 != null) goto L70;
    L72:
        fn.q();
    L73:
        if (r111 == true) goto L102;
        int r123 = r110.next();
        if (r123 == 2) goto L76;
        if (r123 != 3) goto L73;
        if (r110.getName().equals("message") == false) goto L73;
        r111 = true;
        goto L73
    L76:
        String r124 = r110.getName();
        String r125 = r110.getNamespace();
        if (TextUtils.isEmpty(r125) == false) goto L80;
        r125 = "xm";
    L80:
        if (r124.equals(com.bytedance.android.ec.core.event.a.KEY_SUBJECT) == false) goto L83;
        b(r110);
        r109.g(m9111a(r110));
        goto L73
    L83:
        if (r124.equals(ContainerPosition.BODY) == false) goto L89;
        String r126 = r110.getAttributeValue("", "encode");
        String r127 = m9111a(r110);
        if (TextUtils.isEmpty(r126) == true) goto L87;
        r109.a(r127, r126);
        goto L73
    L87:
        r109.h(r127);
        goto L73
    L89:
        if (r124.equals("thread") == false) goto L93;
        if (r112 != null) goto L73;
        r112 = r110.nextText();
        goto L73
    L93:
        if (r124.equals("error") == false) goto L95;
        r109.a(m9110a(r110));
        goto L73
    L95:
        r109.a(a(r124, r125, r110));
        goto L73
    L102:
        r109.i(r112);
        return r109;
    L70:
        if ("".equals(r122.trim()) == true) goto L72;
        r109.j(r122);
        goto L73
    L64:
        if (r116.equalsIgnoreCase("true") == false) goto L66;
        r121 = true;
    L46:
        r116 = null;
        goto L107
    }

    private static String b(XmlPullParser r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.getAttributeCount()) goto L15;
        String r102 = r100.getAttributeName(r101);
        if ("xml:lang".equals(r102) == true) goto L14;
        if (CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL.equals(r102) == false) goto L12;
        if ("xml".equals(r100.getAttributePrefix(r101)) == true) goto L14;
    L12:
        r101 = r101 + 1;
    L14:
        return r100.getAttributeValue(r101);
    L15:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fp m9108a(XmlPullParser r100) {
        fp.b r101 = fp.b.f463584a;
        String r102 = r100.getAttributeValue("", "type");
        if (r102 != null) goto L5;
    L9:
        fp r103 = new fp(r101);
        r103.m(r100.getAttributeValue("", RemoteMessageConst.TO));
        r103.n(r100.getAttributeValue("", "from"));
        r103.l(r100.getAttributeValue("", "chid"));
        String r104 = r100.getAttributeValue("", "id");
        if (r104 != null) goto L12;
        r104 = "ID_NOT_AVAILABLE";
    L12:
        r103.k(r104);
        boolean r105 = false;
    L13:
        if (r105 == true) goto L40;
        int r106 = r100.next();
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L13;
        if (r100.getName().equals("presence") == false) goto L13;
        r105 = true;
        goto L13
    L16:
        String r107 = r100.getName();
        String r108 = r100.getNamespace();
        if (r107.equals("status") == true) goto L18;
        if (r107.equals("priority") == false) goto L26;
        r103.a(CastIntegerProtector.parseInt(r100.nextText()));     // Catch: IllegalArgumentException -> L23 NumberFormatException -> L24
    L23:
        r103.a(0);
        goto L13
    L26:
        if (r107.equals("show") == true) goto L27;
        if (r107.equals("error") == true) goto L33;
        r103.a(a(r107, r108, r100));
        goto L13
    L33:
        r103.a(m9110a(r100));
        goto L13
    L27:
        String r109 = r100.nextText();
        r103.a(fp.a.valueOf(r109));     // Catch: IllegalArgumentException -> L30
    L30:
        System.err.println("Found invalid presence mode " + r109);
        goto L13
    L18:
        r103.a(r100.nextText());
        goto L13
    L40:
        return r103;
    L5:
        if (r102.equals("") == true) goto L9;
        r101 = fp.b.valueOf(r102);     // Catch: IllegalArgumentException -> L8
    L8:
        System.err.println("Found invalid presence type ".concat(r102));
        goto L9
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fr m9110a(XmlPullParser r110) {
        ArrayList r100 = new ArrayList();
        String r101 = "-1";
        boolean r102 = false;
        String r103 = null;
        String r104 = null;
        int r105 = 0;
    L4:
        if (r105 >= r110.getAttributeCount()) goto L15;
        if (r110.getAttributeName(r105).equals("code") == false) goto L9;
        r101 = r110.getAttributeValue("", "code");
    L9:
        if (r110.getAttributeName(r105).equals("type") == false) goto L12;
        r104 = r110.getAttributeValue("", "type");
    L12:
        if (r110.getAttributeName(r105).equals("reason") == false) goto L14;
        r103 = r110.getAttributeValue("", "reason");
    L14:
        r105 = r105 + 1;
        goto L4
    L15:
        String r106 = null;
        String r107 = null;
    L16:
        if (r102 == true) goto L34;
        int r108 = r110.next();
        if (r108 == 2) goto L20;
        if (r108 == 3) goto L29;
        if (r108 != 4) goto L16;
        r107 = r110.getText();
        goto L16
    L29:
        if (r110.getName().equals("error") == false) goto L16;
        r102 = true;
        goto L16
    L20:
        if (r110.getName().equals("text") == true) goto L21;
        String r109 = r110.getName();
        String r111 = r110.getNamespace();
        if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(r111) == true) goto L24;
        r100.add(a(r109, r111, r110));
        goto L16
    L24:
        r106 = r109;
        goto L16
    L21:
        r107 = r110.nextText();
        goto L16
    L34:
        if (r104 != null) goto L36;
        String r112 = "cancel";
    L38:
        return new fr(CastIntegerProtector.parseInt(r101), r112, r103, r106, r107, r100);
    L36:
        r112 = r104;
        goto L38
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m9111a(XmlPullParser r100) {
        int r101 = r100.getDepth();
        String r102 = "";
    L4:
        if (r100.next() != 3) goto L9;
        if (r100.getDepth() != r101) goto L9;
        return r102;
    L9:
        r102 = r102 + r100.getText();
        goto L4
    }

    private static void a(byte[] r100) {
        if (f463623a == null) goto L10;
    L8:
        f463623a.setInput(new InputStreamReader(new ByteArrayInputStream(r100)));
        return;
    L10:
        XmlPullParser r101 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: XmlPullParserException -> L6
        f463623a = r101;     // Catch: XmlPullParserException -> L6
        r101.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: XmlPullParserException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fq m9109a(XmlPullParser r100) {
        fq r101 = null;
        boolean r102 = false;
    L3:
        if (r102 == true) goto L12;
        int r103 = r100.next();
        if (r103 == 2) goto L6;
        if (r103 != 3) goto L3;
        if (r100.getName().equals("error") == false) goto L3;
        r102 = true;
        goto L3
    L6:
        r101 = new fq(r100.getName());
        goto L3
    L12:
        return r101;
    }

    public static fl a(XmlPullParser r110, ez r111) {
        String r100 = r110.getAttributeValue("", "id");
        String r101 = r110.getAttributeValue("", RemoteMessageConst.TO);
        String r102 = r110.getAttributeValue("", "from");
        String r103 = r110.getAttributeValue("", "chid");
        fl.a r104 = fl.a.a(r110.getAttributeValue("", "type"));
        HashMap r105 = new HashMap();
        boolean r106 = false;
        int r107 = 0;
    L4:
        if (r107 >= r110.getAttributeCount()) goto L6;
        String r108 = r110.getAttributeName(r107);
        r105.put(r108, r110.getAttributeValue("", r108));
        r107 = r107 + 1;
        goto L4
    L6:
        fl r109 = null;
        fr r112 = null;
    L7:
        if (r106 == true) goto L19;
        int r113 = r110.next();
        if (r113 == 2) goto L10;
        if (r113 != 3) goto L7;
        if (r110.getName().equals("iq") == false) goto L7;
        r106 = true;
        goto L7
    L10:
        String r114 = r110.getName();
        String r115 = r110.getNamespace();
        if (r114.equals("error") == true) goto L12;
        r109 = new fl();
        r109.a(a(r114, r115, r110));
        goto L7
    L12:
        r112 = m9110a(r110);
        goto L7
    L19:
        if (r109 == null) goto L21;
    L28:
        r109.k(r100);
        r109.m(r101);
        r109.l(r103);
        r109.n(r102);
        r109.a(r104);
        r109.a(r112);
        r109.a(r105);
        return r109;
    L21:
        if (fl.a.f463551a != r104) goto L23;
    L26:
        fl r116 = new AnonymousClass1();
        r116.k(r100);
        r116.m(r102);
        r116.n(r101);
        r116.a(fl.a.f463554d);
        r116.l(r103);
        r116.a(new fr(fr.a.f463601e));
        r111.a(r116);
        com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
        return null;
    L23:
        if (fl.a.f463552b == r104) goto L26;
        r109 = new AnonymousClass2();
        goto L28
    }

    public static fk a(String r100, String r101, XmlPullParser r102) {
        Object r103 = fu.a().m9106a("all", "xm:chat");
        if (r103 != null) goto L5;
        return null;
    L5:
        if ((r103 instanceof com.xiaomi.push.service.i) == true) goto L7;
        return null;
    L7:
        return ((com.xiaomi.push.service.i) r103).b(r102);
    }
}
