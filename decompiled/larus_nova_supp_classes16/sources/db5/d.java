package db5;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bean.Icon;
import com.bytedance.ee.bear.config.AtRegexConfig;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Function<String, a> {
    public final List<fb5.c> a;
    public final boolean b;

    public static Pattern d() {
        AtRegexConfig r0 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        if (r0 == null) goto L11;
        String r1 = r0.getLinkRegex();
        if (TextUtils.isEmpty(r1) == true) goto L11;
        return PatternProtector.compile(r1);
    L8:
        th = move-exception;
        tt5.a.f("CommentParser", th, false);
    L11:
        return PatternProtector.compile("((https?|http|ftp):\\/\\/((localhost:[0-9]{2,5})|( (([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}(2[0-4][0-9]|25[0-5]|1[0-9]{2}|[1-9][0-9]|[0-9])(:[0-9]{2,5})?))(\\/[-a-zA-Z0-9@:%_+.~#?&//=]*)?)|(((https?|http|ftp):\\/\\/)?[-a-zA-Z0-9:%._+~#=]{2,256}\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|google|[a-z][a-z])\\b([-a-zA-Z0-9@:%_+.~#?&//=;()$,!]*))|(^(?!data:)(?:mailto:)?[\\w.!#$%&'*+-/=?^_`{|}~]{1,2000}@[A-Za-z0-9.-]+\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|[a-z][a-z]))");
    }

    public d() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        this.b = false;
        r0.add(new fb5.a());
        r0.add(new fb5.b());
        AtRegexConfig r1 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        if (r1 == null) goto L5;
        this.b = r1.getNewRuleEnable();
    L5:
        tt5.a.h("CommentParser", "newRuleEnable = " + this.b);
    }

    public final /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return c((String) r1);
    }

    public final a c(String r13) throws Exception {
        tt5.a.b("CommentParser", "apply: begin origin=" + r13);
        Matcher r0 = PatternProtector.compile("<at(\n|.)*?>(\n|.)*?</at>").matcher(r13);
        ArrayList r2 = new ArrayList();
    L4:
        if (r0.find() == false) goto L8;
        bo4.a r3 = e(r13, r0.start(), r0.end());
        if (r3 == null) goto L4;
        r2.add(r3);
        goto L4
    L8:
        int r1 = r2.size();
        bo4.a[] r4 = new bo4.a[r1];
        r2.toArray(r4);
        tt5.a.b("CommentParser", "replaceAts: ");
        StringBuilder r5 = new StringBuilder(r13);
        int r14 = 0;
        int r6 = 0;
    L9:
        if (r6 >= r1) goto L13;
        bo4.a r7 = r4[r6];
        int r8 = (r7.b - r7.a) - r7.g.length();
        r5.replace(r7.a, r7.b, r7.g);
        r7.b = r7.a + r7.g.length();
        r6 = r6 + 1;
        int r9 = r6;
    L11:
        if (r9 >= r1) goto L9;
        bo4.a r10 = r4[r9];
        r10.a -= r8;
        r10.b -= r8;
        r9 = r9 + 1;
        goto L11
    L13:
        String r11 = r5.toString();
        if (this.b == true) goto L16;
        Matcher r16 = d().matcher(r11);
        ArrayList r12 = new ArrayList();
    L40:
        if (r16.find() == false) goto L42;
        int r17 = r16.start();
        int r18 = r16.end();
        r12.add(new j(r17, r18, r11.substring(r17, r18)));
        goto L40
    L42:
        j[] r19 = new j[r12.size()];
        r12.toArray(r19);
    L44:
        return new a(r11, r4, r19);
    L16:
        if (TextUtils.isEmpty(r11) == false) goto L18;
        r19 = new j[0];
        goto L44
    L18:
        Pattern r20 = d();
        Matcher r21 = r20.matcher(r11);
        ArrayList r22 = new ArrayList();
        String r23 = r11;
    L20:
        if (r23.length() <= 0) goto L37;
        if (r21.find() == false) goto L37;
        int r24 = r21.start();
        int r26 = r21.end();
        String r27 = r23.substring(r24, r26);
        Iterator r28 = ((ArrayList) this.a).iterator();
    L25:
        if (r28.hasNext() == false) goto L34;
        Pair<String, Boolean> r29 = ((fb5.c) r28.next()).a(r27);
        String r110 = (String) r29.getFirst();
        if (((Boolean) r29.getSecond()).booleanValue() == true) goto L32;
        if (r110.isEmpty() == true) goto L32;
        r27 = r110;
    L32:
        r27 = r110;
    L34:
        if (r27.isEmpty() == true) goto L35;
        int r30 = r27.length();
        int r111 = r14 + r24;
        r22.add(new j(r111, r111 + r30, r27));
        int r31 = r24 + r30;
        r14 = r14 + r31;
        r23 = r23.substring(r31);
        r21 = r20.matcher(r23);
        goto L20
    L35:
        tt5.a.e("CommentParser", "extract url error!", new IllegalStateException("extract empty url! origin: " + r23.substring(r24, r26)), true);
    L37:
        r19 = new j[r22.size()];
        r22.toArray(r19);
        goto L44
    }

    public static bo4.a e(String r30, int r31, int r32) throws XmlPullParserException, IOException {
        tt5.a.b("CommentParser", "parseAt: start = " + r31 + ", end = " + r32);
        String r0 = r30.substring(r31, r32).replace("&", "&amp;");
        int r3 = r0.indexOf(">") + 1;
        int r6 = r0.lastIndexOf("<");
        if (r3 < r6) goto L5;
    L7:
        String r9 = "";
    L8:
        XmlPullParser r4 = XmlPullParserFactory.newInstance().newPullParser();
        r4.setInput(new StringReader(r0));
        int r1 = r4.getEventType();
    L9:
        Icon r7 = null;
        if (r1 == 1) goto L74;
        String r8 = r4.getName();
        if (r1 != 2) goto L73;
        if ("at".equals(r8) == false) goto L73;
        tt5.a.b("CommentParser", "apply: find at tag");
        String r10 = r4.getAttributeValue(null, "type");     // Catch: Exception -> L43
        String r11 = r4.getAttributeValue(null, "sub_type");     // Catch: Exception -> L41
        String r12 = r4.getAttributeValue(null, "token");     // Catch: Exception -> L39
        String r13 = r4.getAttributeValue(null, "href");     // Catch: Exception -> L37
        String r14 = r4.getAttributeValue(null, "name");     // Catch: Exception -> L35
        String r16 = r4.getAttributeValue(null, "en_name");     // Catch: Exception -> L33
        String r17 = r4.getAttributeValue(null, CustomHeaderConfig.Menu.Style.ICON_STYLE);     // Catch: Exception -> L31
        String r18 = r4.getAttributeValue(null, "origin_title");     // Catch: Exception -> L29
        String r19 = Uri.decode(r4.getAttributeValue(null, "icon_info"));     // Catch: Exception -> L27
    L51:
        String r26 = r18;
        boolean r2 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.docx_comment_copy_atmention_support");
        if (TextUtils.isEmpty(r14) == true) goto L54;
    L83:
        r7 = (Icon) JSON.parseObject(r17, Icon.class);     // Catch: Exception -> L59
    L61:
        if (r7 != null) goto L64;
        r7 = new Icon();
    L64:
        if (TextUtils.isEmpty(r10) == true) goto L66;
        int r5 = CastIntegerProtector.parseInt(r10);
    L68:
        if (TextUtils.isEmpty(r11) == true) goto L70;
        int r20 = CastIntegerProtector.parseInt(r11);
    L71:
        int r110 = r7.getType();
        String r111 = r7.getKey();
        return new bo4.a(r31, r32, r5, r20, r12, r13, r9, r14, r16, null, null, r19, r7.getFs_unit(), r111, r110, false, null, false, false, "", "", null, r26, null, 0);
    L70:
        r20 = -1;
        goto L71
    L66:
        r5 = -1;
    L59:
        e = move-exception;
        tt5.a.e("CommentParser", "parseAt() icon: ", e, false);
        goto L61
    L54:
        if (TextUtils.isEmpty(r9) == true) goto L83;
        if (r2 == false) goto L83;
        r14 = r9.replace("@", "");
    L27:
        e = e;
    L50:
        tt5.a.e("CommentParser", "parse xml exception", e, false);
        r19 = "";
    L29:
        e = e;
        r18 = null;
    L31:
        e = e;
        r18 = null;
        r17 = "";
    L33:
        e = e;
    L49:
        r18 = null;
        r16 = "";
        r17 = r16;
    L35:
        e = e;
    L48:
        r14 = "";
    L37:
        e = e;
    L47:
        r13 = "";
    L39:
        e = e;
    L46:
        r12 = "";
    L41:
        e = e;
    L45:
        r11 = "";
    L43:
        e = e;
        r10 = "";
    L73:
        r1 = r4.next();
        goto L9
    L74:
        return null;
    L5:
        if (r6 >= r0.length()) goto L7;
        r9 = StringEscapeUtils.unescapeHtml4(StringEscapeUtils.unescapeXml(r0.substring(r3, r6)));
        goto L8
    }
}
