package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes42.dex */
public final class CsvTranslators {
    private static final String CSV_ESCAPED_QUOTE_STR = null;
    private static final String CSV_QUOTE_STR = null;
    private static final char[] CSV_SEARCH_CHARS = null;

    public static class CsvEscaper extends SinglePassTranslator {
        public CsvEscaper() {
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        public void translateWhole(CharSequence r100, Writer r101) throws IOException {
            String r102 = r100.toString();
            if (StringUtils.containsNone(r102, CsvTranslators.access$000()) == false) goto L5;
            r101.write(r102);
            return;
        L5:
            r101.write(34);
            r101.write(StringUtils.replace(r102, CsvTranslators.access$100(), CsvTranslators.access$200()));
            r101.write(34);
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence r100, int r101, Writer r102) throws IOException {
            return super.translate(r100, r101, r102);
        }
    }

    public static class CsvUnescaper extends SinglePassTranslator {
        public CsvUnescaper() {
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        public void translateWhole(CharSequence r100, Writer r101) throws IOException {
            if (r100.charAt(0) == '\"') goto L5;
        L12:
            r101.write(r100.toString());
            return;
        L5:
            if (r100.charAt(r100.length() - 1) != '\"') goto L12;
            String r102 = r100.subSequence(1, r100.length() - 1).toString();
            if (StringUtils.containsAny(r102, CsvTranslators.access$000()) == false) goto L10;
            r101.write(StringUtils.replace(r102, CsvTranslators.access$200(), CsvTranslators.access$100()));
            return;
        L10:
            r101.write(r100.toString());
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence r100, int r101, Writer r102) throws IOException {
            return super.translate(r100, r101, r102);
        }
    }

    static {
        String r100 = String.valueOf(Typography.quote);
        CSV_QUOTE_STR = r100;
        CSV_ESCAPED_QUOTE_STR = r100 + r100;
        CSV_SEARCH_CHARS = new char[]{',', Typography.quote, '\r', '\n'};
    }

    public static /* synthetic */ char[] access$000() {
        return CSV_SEARCH_CHARS;
    }

    public static /* synthetic */ String access$100() {
        return CSV_QUOTE_STR;
    }

    public static /* synthetic */ String access$200() {
        return CSV_ESCAPED_QUOTE_STR;
    }
}
