package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes41.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;
    private final int errorIndex;
    private final String parsedString;

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public String getParsedString() {
        return this.parsedString;
    }

    public DateTimeParseException(String r100, CharSequence r101, int r102) {
        super(r100);
        this.parsedString = r101.toString();
        this.errorIndex = r102;
    }

    public DateTimeParseException(String r100, CharSequence r101, int r102, Throwable r103) {
        super(r100, r103);
        this.parsedString = r101.toString();
        this.errorIndex = r102;
    }
}
