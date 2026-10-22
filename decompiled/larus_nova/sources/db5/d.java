package db5;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bean.Icon;
import com.bytedance.ee.bear.config.AtRegexConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import org.apache.commons.text.StringEscapeUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Function<String, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<fb5.c> f467815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f467816b;

    public static Pattern d() {
        AtRegexConfig r100 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        if (r100 == null) goto L11;
        String r101 = r100.getLinkRegex();
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return PatternProtector.compile(r101);
    L8:
        th = move-exception;
        tt5.a.f("CommentParser", th, false);
    L11:
        return PatternProtector.compile("((https?|http|ftp):\\/\\/((localhost:[0-9]{2,5})|( (([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}(2[0-4][0-9]|25[0-5]|1[0-9]{2}|[1-9][0-9]|[0-9])(:[0-9]{2,5})?))(\\/[-a-zA-Z0-9@:%_+.~#?&//=]*)?)|(((https?|http|ftp):\\/\\/)?[-a-zA-Z0-9:%._+~#=]{2,256}\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|google|[a-z][a-z])\\b([-a-zA-Z0-9@:%_+.~#?&//=;()$,!]*))|(^(?!data:)(?:mailto:)?[\\w.!#$%&'*+-/=?^_`{|}~]{1,2000}@[A-Za-z0-9.-]+\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|[a-z][a-z]))");
    }

    public d() {
        ArrayList r100 = new ArrayList();
        this.f467815a = r100;
        this.f467816b = false;
        r100.add(new fb5.a());
        r100.add(new fb5.b());
        AtRegexConfig r101 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        if (r101 == null) goto L5;
        this.f467816b = r101.getNewRuleEnable();
    L5:
        tt5.a.h("CommentParser", "newRuleEnable = " + this.f467816b);
    }

    @Override // io.reactivex.functions.Function
    public final /* bridge */ /* synthetic */ a apply(String r100) throws Exception {
        return c(r100);
    }

    public final a c(String r110) throws Exception {
        tt5.a.b("CommentParser", "apply: begin origin=" + r110);
        Matcher r100 = PatternProtector.compile("<at(\n|.)*?>(\n|.)*?</at>").matcher(r110);
        ArrayList r101 = new ArrayList();
    L4:
        if (r100.find() == false) goto L8;
        bo4.a r102 = e(r110, r100.start(), r100.end());
        if (r102 == null) goto L4;
        r101.add(r102);
        goto L4
    L8:
        int r103 = r101.size();
        bo4.a[] r104 = new bo4.a[r103];
        r101.toArray(r104);
        tt5.a.b("CommentParser", "replaceAts: ");
        StringBuilder r105 = new StringBuilder(r110);
        int r111 = 0;
        int r106 = 0;
    L9:
        if (r106 >= r103) goto L13;
        bo4.a r107 = r104[r106];
        int r108 = (r107.f19812b - r107.f19811a) - r107.f19817g.length();
        r105.replace(r107.f19811a, r107.f19812b, r107.f19817g);
        r107.f19812b = r107.f19811a + r107.f19817g.length();
        r106 = r106 + 1;
        int r109 = r106;
    L11:
        if (r109 >= r103) goto L9;
        bo4.a r112 = r104[r109];
        r112.f19811a -= r108;
        r112.f19812b -= r108;
        r109 = r109 + 1;
        goto L11
    L13:
        String r113 = r105.toString();
        if (this.f467816b == true) goto L16;
        Matcher r114 = d().matcher(r113);
        ArrayList r115 = new ArrayList();
    L40:
        if (r114.find() == false) goto L42;
        int r116 = r114.start();
        int r117 = r114.end();
        r115.add(new j(r116, r117, r113.substring(r116, r117)));
        goto L40
    L42:
        j[] r118 = new j[r115.size()];
        r115.toArray(r118);
    L44:
        return new a(r113, r104, r118);
    L16:
        if (TextUtils.isEmpty(r113) == false) goto L18;
        r118 = new j[0];
        goto L44
    L18:
        Pattern r119 = d();
        Matcher r120 = r119.matcher(r113);
        ArrayList r121 = new ArrayList();
        String r122 = r113;
    L20:
        if (r122.length() <= 0) goto L37;
        if (r120.find() == false) goto L37;
        int r123 = r120.start();
        int r124 = r120.end();
        String r125 = r122.substring(r123, r124);
        Iterator r126 = ((ArrayList) this.f467815a).iterator();
    L25:
        if (r126.hasNext() == false) goto L34;
        Pair<String, Boolean> r127 = ((fb5.c) r126.next()).a(r125);
        String r128 = r127.getFirst();
        if (r127.getSecond().booleanValue() == true) goto L32;
        if (r128.isEmpty() == true) goto L32;
        r125 = r128;
    L32:
        r125 = r128;
    L34:
        if (r125.isEmpty() == true) goto L35;
        int r129 = r125.length();
        int r130 = r111 + r123;
        r121.add(new j(r130, r130 + r129, r125));
        int r131 = r123 + r129;
        r111 = r111 + r131;
        r122 = r122.substring(r131);
        r120 = r119.matcher(r122);
        goto L20
    L35:
        tt5.a.e("CommentParser", "extract url error!", new IllegalStateException("extract empty url! origin: " + r122.substring(r123, r124)), true);
    L37:
        r118 = new j[r121.size()];
        r121.toArray(r118);
        goto L44
    }

    public static bo4.a e(String r310, int r311, int r312) throws XmlPullParserException, IOException {
        tt5.a.b("CommentParser", "parseAt: start = " + r311 + ", end = " + r312);
        String r100 = r310.substring(r311, r312).replace("&", "&amp;");
        int r101 = r100.indexOf(">") + 1;
        int r102 = r100.lastIndexOf("<");
        if (r101 < r102) goto L5;
    L7:
        String r103 = "";
    L8:
        XmlPullParser r104 = XmlPullParserFactory.newInstance().newPullParser();
        r104.setInput(new StringReader(r100));
        int r105 = r104.getEventType();
    L9:
        Icon r106 = null;
        if (r105 == 1) goto L74;
        String r107 = r104.getName();
        if (r105 != 2) goto L73;
        if (INotificationHitPoint.NoticeType.AT.equals(r107) == false) goto L73;
        tt5.a.b("CommentParser", "apply: find at tag");
        String r108 = r104.getAttributeValue(null, "type");     // Catch: Exception -> L43
        String r110 = r104.getAttributeValue(null, "sub_type");     // Catch: Exception -> L41
        String r111 = r104.getAttributeValue(null, "token");     // Catch: Exception -> L39
        String r112 = r104.getAttributeValue(null, "href");     // Catch: Exception -> L37
        String r113 = r104.getAttributeValue(null, "name");     // Catch: Exception -> L35
        String r114 = r104.getAttributeValue(null, "en_name");     // Catch: Exception -> L33
        String r115 = r104.getAttributeValue(null, "icon");     // Catch: Exception -> L31
        String r116 = r104.getAttributeValue(null, "origin_title");     // Catch: Exception -> L29
        String r117 = Uri.decode(r104.getAttributeValue(null, "icon_info"));     // Catch: Exception -> L27
    L51:
        String r210 = r116;
        boolean r109 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.docx_comment_copy_atmention_support");
        if (TextUtils.isEmpty(r113) == true) goto L54;
    L83:
        r106 = (Icon) JSON.parseObject(r115, Icon.class);     // Catch: Exception -> L59
    L61:
        if (r106 != null) goto L64;
        r106 = new Icon();
    L64:
        if (TextUtils.isEmpty(r108) == true) goto L66;
        int r118 = CastIntegerProtector.parseInt(r108);
    L68:
        if (TextUtils.isEmpty(r110) == true) goto L70;
        int r119 = CastIntegerProtector.parseInt(r110);
    L71:
        int r120 = r106.getType();
        String r121 = r106.getKey();
        return new bo4.a(r311, r312, r118, r119, r111, r112, r103, r113, r114, null, null, r117, r106.getFs_unit(), r121, r120, false, null, false, false, "", "", null, r210, null, 0);
    L70:
        r119 = -1;
        goto L71
    L66:
        r118 = -1;
    L59:
        e = move-exception;
        tt5.a.e("CommentParser", "parseAt() icon: ", e, false);
        goto L61
    L54:
        if (TextUtils.isEmpty(r103) == true) goto L83;
        if (r109 == false) goto L83;
        r113 = r103.replace("@", "");
    L27:
        e = e;
    L50:
        tt5.a.e("CommentParser", "parse xml exception", e, false);
        r117 = "";
    L29:
        e = e;
        r116 = null;
    L31:
        e = e;
        r116 = null;
        r115 = "";
    L33:
        e = e;
    L49:
        r116 = null;
        r114 = "";
        r115 = r114;
    L35:
        e = e;
    L48:
        r113 = "";
    L37:
        e = e;
    L47:
        r112 = "";
    L39:
        e = e;
    L46:
        r111 = "";
    L41:
        e = e;
    L45:
        r110 = "";
    L43:
        e = e;
        r108 = "";
    L73:
        r105 = r104.next();
        goto L9
    L74:
        return null;
    L5:
        if (r102 >= r100.length()) goto L7;
        r103 = StringEscapeUtils.unescapeHtml4(StringEscapeUtils.unescapeXml(r100.substring(r101, r102)));
        goto L8
    }
}
