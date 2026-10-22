package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = null;
    private final int column;
    private final int line;

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", new Object[]{Integer.valueOf(this.line), Integer.valueOf(this.column)});
    }

    static {
        EMPTY = new TextFormatParseLocation(-1, -1);
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextFormatParseLocation) == true) goto L8;
        return false;
    L8:
        TextFormatParseLocation r101 = (TextFormatParseLocation) r100;
        if (this.line == r101.getLine()) goto L11;
    L13:
        return false;
    L11:
        if (this.column != r101.getColumn()) goto L13;
        return true;
    }

    private TextFormatParseLocation(int r100, int r101) {
        this.line = r100;
        this.column = r101;
    }

    public static TextFormatParseLocation create(int r100, int r101) {
        if (r100 != (-1)) goto L7;
        if (r101 != (-1)) goto L7;
        return EMPTY;
    L7:
        if (r100 < 0) goto L12;
        if (r101 < 0) goto L12;
        return new TextFormatParseLocation(r100, r101);
    L12:
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));
    }
}
