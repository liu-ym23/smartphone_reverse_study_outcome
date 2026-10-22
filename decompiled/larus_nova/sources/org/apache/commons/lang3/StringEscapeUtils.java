package org.apache.commons.lang3;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.Writer;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.apache.commons.lang3.text.translate.OctalUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;

/* JADX INFO: loaded from: classes42.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_CSV = null;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT = null;
    public static final CharSequenceTranslator ESCAPE_HTML3 = null;
    public static final CharSequenceTranslator ESCAPE_HTML4 = null;
    public static final CharSequenceTranslator ESCAPE_JAVA = null;
    public static final CharSequenceTranslator ESCAPE_JSON = null;
    public static final CharSequenceTranslator ESCAPE_XML = null;
    public static final CharSequenceTranslator ESCAPE_XML10 = null;
    public static final CharSequenceTranslator ESCAPE_XML11 = null;
    public static final CharSequenceTranslator UNESCAPE_CSV = null;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT = null;
    public static final CharSequenceTranslator UNESCAPE_HTML3 = null;
    public static final CharSequenceTranslator UNESCAPE_HTML4 = null;
    public static final CharSequenceTranslator UNESCAPE_JAVA = null;
    public static final CharSequenceTranslator UNESCAPE_JSON = null;
    public static final CharSequenceTranslator UNESCAPE_XML = null;

    public static class CsvEscaper extends CharSequenceTranslator {
        private static final String CSV_QUOTE_STR = null;
        private static final char[] CSV_SEARCH_CHARS = null;

        static {
            CSV_QUOTE_STR = String.valueOf(Typography.quote);
            CSV_SEARCH_CHARS = new char[]{',', Typography.quote, '\r', '\n'};
        }

        public CsvEscaper() {
        }

        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
            if (r101 != 0) goto L10;
            if (StringUtils.containsNone(r100.toString(), CSV_SEARCH_CHARS) == false) goto L6;
            r102.write(r100.toString());
        L8:
            return Character.codePointCount(r100, 0, r100.length());
        L6:
            r102.write(34);
            String r103 = r100.toString();
            String r104 = CSV_QUOTE_STR;
            r102.write(StringUtils.replace(r103, r104, r104 + r104));
            r102.write(34);
            goto L8
        L10:
            throw new IllegalStateException("CsvEscaper should never reach the [1] index");
        }
    }

    public static class CsvUnescaper extends CharSequenceTranslator {
        private static final String CSV_QUOTE_STR = null;
        private static final char[] CSV_SEARCH_CHARS = null;

        static {
            CSV_QUOTE_STR = String.valueOf(Typography.quote);
            CSV_SEARCH_CHARS = new char[]{',', Typography.quote, '\r', '\n'};
        }

        public CsvUnescaper() {
        }

        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
            if (r101 != 0) goto L17;
            if (r100.charAt(0) == '\"') goto L6;
        L14:
            r102.write(r100.toString());
            return Character.codePointCount(r100, 0, r100.length());
        L6:
            if (r100.charAt(r100.length() - 1) != '\"') goto L14;
            String r103 = r100.subSequence(1, r100.length() - 1).toString();
            if (StringUtils.containsAny(r103, CSV_SEARCH_CHARS) == false) goto L11;
            StringBuilder r104 = new StringBuilder();
            String r105 = CSV_QUOTE_STR;
            r104.append(r105);
            r104.append(r105);
            r102.write(StringUtils.replace(r103, r104.toString(), r105));
        L13:
            return Character.codePointCount(r100, 0, r100.length());
        L11:
            r102.write(r100.toString());
            goto L13
        L17:
            throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
        }
    }

    static {
        ESCAPE_JAVA = new LookupTranslator(new String[][]{new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}}).with(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())}).with(new CharSequenceTranslator[]{JavaUnicodeEscaper.outsideOf(32, 127)});
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(new String[][]{new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{HTTP.URL_DEFAULT, "\\/"}}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127)});
        ESCAPE_JSON = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(new String[][]{new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{HTTP.URL_DEFAULT, "\\/"}}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127)});
        ESCAPE_XML = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE())});
        ESCAPE_XML10 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[][]{new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}}), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover()});
        ESCAPE_XML11 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[][]{new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}}), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover()});
        ESCAPE_HTML3 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE())});
        ESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE())});
        ESCAPE_CSV = new CsvEscaper();
        AggregateTranslator r100 = new AggregateTranslator(new CharSequenceTranslator[]{new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()), new LookupTranslator(new String[][]{new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}})});
        UNESCAPE_JAVA = r100;
        UNESCAPE_ECMASCRIPT = r100;
        UNESCAPE_JSON = r100;
        UNESCAPE_HTML3 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_XML = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.APOS_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
        UNESCAPE_CSV = new CsvUnescaper();
    }

    public static final String escapeJson(String r100) {
        return ESCAPE_JSON.translate(r100);
    }
}
