package org.apache.commons.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.CsvTranslators;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.JavaUnicodeEscaper;
import org.apache.commons.text.translate.LookupTranslator;
import org.apache.commons.text.translate.NumericEntityEscaper;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.apache.commons.text.translate.OctalUnescaper;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.apache.commons.text.translate.UnicodeUnpairedSurrogateRemover;

/* JADX INFO: loaded from: classes42.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_CSV = null;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT = null;
    public static final CharSequenceTranslator ESCAPE_HTML3 = null;
    public static final CharSequenceTranslator ESCAPE_HTML4 = null;
    public static final CharSequenceTranslator ESCAPE_JAVA = null;
    public static final CharSequenceTranslator ESCAPE_JSON = null;
    public static final CharSequenceTranslator ESCAPE_XML10 = null;
    public static final CharSequenceTranslator ESCAPE_XML11 = null;
    public static final CharSequenceTranslator ESCAPE_XSI = null;
    public static final CharSequenceTranslator UNESCAPE_CSV = null;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT = null;
    public static final CharSequenceTranslator UNESCAPE_HTML3 = null;
    public static final CharSequenceTranslator UNESCAPE_HTML4 = null;
    public static final CharSequenceTranslator UNESCAPE_JAVA = null;
    public static final CharSequenceTranslator UNESCAPE_JSON = null;
    public static final CharSequenceTranslator UNESCAPE_XML = null;
    public static final CharSequenceTranslator UNESCAPE_XSI = null;

    public static class XsiUnescaper extends CharSequenceTranslator {
        public XsiUnescaper() {
        }

        @Override // org.apache.commons.text.translate.CharSequenceTranslator
        public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
            if (r101 != 0) goto L15;
            String r103 = r100.toString();
            int r104 = 0;
            int r105 = 0;
        L4:
            int r106 = r103.indexOf(92, r104);
            if (r106 == (-1)) goto L7;
            if (r106 <= r105) goto L13;
            r102.write(r103.substring(r105, r106));
        L13:
            r105 = r106 + 1;
            r104 = r106 + 2;
            goto L4
        L7:
            if (r105 >= r103.length()) goto L10;
            r102.write(r103.substring(r105));
        L10:
            return Character.codePointCount(r100, 0, r100.length());
        L15:
            throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
        }
    }

    static {
        HashMap r100 = new HashMap();
        r100.put("\"", "\\\"");
        r100.put("\\", "\\\\");
        Map<CharSequence, CharSequence> r101 = EntityArrays.JAVA_CTRL_CHARS_ESCAPE;
        ESCAPE_JAVA = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(Collections.unmodifiableMap(r100)), new LookupTranslator(r101), JavaUnicodeEscaper.outsideOf(32, 127)});
        HashMap r102 = new HashMap();
        r102.put("'", "\\'");
        r102.put("\"", "\\\"");
        r102.put("\\", "\\\\");
        r102.put(HTTP.URL_DEFAULT, "\\/");
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(Collections.unmodifiableMap(r102)), new LookupTranslator(r101), JavaUnicodeEscaper.outsideOf(32, 127)});
        HashMap r103 = new HashMap();
        r103.put("\"", "\\\"");
        r103.put("\\", "\\\\");
        r103.put(HTTP.URL_DEFAULT, "\\/");
        ESCAPE_JSON = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(Collections.unmodifiableMap(r103)), new LookupTranslator(r101), JavaUnicodeEscaper.outsideOf(32, 127)});
        HashMap r104 = new HashMap();
        r104.put("\u0000", "");
        r104.put("\u0001", "");
        r104.put("\u0002", "");
        r104.put("\u0003", "");
        r104.put("\u0004", "");
        r104.put("\u0005", "");
        r104.put("\u0006", "");
        r104.put("\u0007", "");
        r104.put("\b", "");
        r104.put("\u000b", "");
        r104.put("\f", "");
        r104.put("\u000e", "");
        r104.put("\u000f", "");
        r104.put("\u0010", "");
        r104.put("\u0011", "");
        r104.put("\u0012", "");
        r104.put("\u0013", "");
        r104.put("\u0014", "");
        r104.put("\u0015", "");
        r104.put("\u0016", "");
        r104.put("\u0017", "");
        r104.put("\u0018", "");
        r104.put("\u0019", "");
        r104.put("\u001a", "");
        r104.put("\u001b", "");
        r104.put("\u001c", "");
        r104.put("\u001d", "");
        r104.put("\u001e", "");
        r104.put("\u001f", "");
        r104.put("\ufffe", "");
        r104.put("\uffff", "");
        Map<CharSequence, CharSequence> r105 = EntityArrays.BASIC_ESCAPE;
        Map<CharSequence, CharSequence> r110 = EntityArrays.APOS_ESCAPE;
        ESCAPE_XML10 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r105), new LookupTranslator(r110), new LookupTranslator(Collections.unmodifiableMap(r104)), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover()});
        HashMap r106 = new HashMap();
        r106.put("\u0000", "");
        r106.put("\u000b", "&#11;");
        r106.put("\f", "&#12;");
        r106.put("\ufffe", "");
        r106.put("\uffff", "");
        ESCAPE_XML11 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r105), new LookupTranslator(r110), new LookupTranslator(Collections.unmodifiableMap(r106)), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover()});
        Map<CharSequence, CharSequence> r111 = EntityArrays.ISO8859_1_ESCAPE;
        ESCAPE_HTML3 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r105), new LookupTranslator(r111)});
        ESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r105), new LookupTranslator(r111), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE)});
        ESCAPE_CSV = new CsvTranslators.CsvEscaper();
        HashMap r107 = new HashMap();
        r107.put(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "\\|");
        r107.put("&", "\\&");
        r107.put(i.f25853b, "\\;");
        r107.put("<", "\\<");
        r107.put(">", "\\>");
        r107.put("(", "\\(");
        r107.put(")", "\\)");
        r107.put("$", "\\$");
        r107.put(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "\\`");
        r107.put("\\", "\\\\");
        r107.put("\"", "\\\"");
        r107.put("'", "\\'");
        r107.put(" ", "\\ ");
        r107.put("\t", "\\\t");
        r107.put("\r\n", "");
        r107.put("\n", "");
        r107.put("*", "\\*");
        r107.put("?", "\\?");
        r107.put("[", "\\[");
        r107.put("#", "\\#");
        r107.put(Constants.WAVE_SEPARATOR, "\\~");
        r107.put(ContainerUtils.KEY_VALUE_DELIMITER, "\\=");
        r107.put(GXTemplateKey.GAIAX_PE, "\\%");
        ESCAPE_XSI = new LookupTranslator(Collections.unmodifiableMap(r107));
        HashMap r108 = new HashMap();
        r108.put("\\\\", "\\");
        r108.put("\\\"", "\"");
        r108.put("\\'", "'");
        r108.put("\\", "");
        AggregateTranslator r109 = new AggregateTranslator(new CharSequenceTranslator[]{new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE), new LookupTranslator(Collections.unmodifiableMap(r108))});
        UNESCAPE_JAVA = r109;
        UNESCAPE_ECMASCRIPT = r109;
        UNESCAPE_JSON = r109;
        Map<CharSequence, CharSequence> r112 = EntityArrays.BASIC_UNESCAPE;
        Map<CharSequence, CharSequence> r113 = EntityArrays.ISO8859_1_UNESCAPE;
        UNESCAPE_HTML3 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r112), new LookupTranslator(r113), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r112), new LookupTranslator(r113), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_XML = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(r112), new LookupTranslator(EntityArrays.APOS_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_CSV = new CsvTranslators.CsvUnescaper();
        UNESCAPE_XSI = new XsiUnescaper();
    }

    public static final String unescapeHtml4(String r100) {
        return UNESCAPE_HTML4.translate(r100);
    }

    public static final String unescapeXml(String r100) {
        return UNESCAPE_XML.translate(r100);
    }
}
