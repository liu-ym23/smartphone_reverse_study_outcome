package com.facebook.imagepipeline.common;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BytesRange {
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;

    @Nullable
    private static Pattern sHeaderParsingRegEx;
    public final int from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    public final int f274104to;

    public String toHttpRangeHeaderValue() {
        return String.format(null, "bytes=%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.f274104to)});
    }

    public String toString() {
        return String.format(null, "%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.f274104to)});
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.from, this.f274104to);
    }

    public static BytesRange from(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        Preconditions.checkArgument(r101);
        return new BytesRange(r100, Integer.MAX_VALUE);
    L4:
        r101 = false;
        goto L5
    }

    @Nullable
    public static BytesRange fromContentRangeHeader(@Nullable String r100) throws IllegalArgumentException {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (sHeaderParsingRegEx != null) goto L30;
        sHeaderParsingRegEx = Pattern.compile("[-/ ]");
    L30:
        String[] r101 = sHeaderParsingRegEx.split(r100);     // Catch: IllegalArgumentException -> L27
        if (r101.length != 4) goto L12;
        boolean r102 = true;
    L13:
        Preconditions.checkArgument(r102);     // Catch: IllegalArgumentException -> L27
        Preconditions.checkArgument(r101[0].equals(HTTP.CONTENT_RANGE_BYTES));     // Catch: IllegalArgumentException -> L27
        int r103 = Integer.parseInt(r101[1]);     // Catch: IllegalArgumentException -> L27
        int r104 = Integer.parseInt(r101[2]);     // Catch: IllegalArgumentException -> L27
        int r105 = Integer.parseInt(r101[3]);     // Catch: IllegalArgumentException -> L27
        if (r104 <= r103) goto L16;
        boolean r106 = true;
    L17:
        Preconditions.checkArgument(r106);     // Catch: IllegalArgumentException -> L27
        if (r105 <= r104) goto L20;
        boolean r107 = true;
    L21:
        Preconditions.checkArgument(r107);     // Catch: IllegalArgumentException -> L27
        if (r104 >= (r105 - 1)) goto L26;
        return new BytesRange(r103, r104);
    L26:
        return new BytesRange(r103, Integer.MAX_VALUE);
    L20:
        r107 = false;
        goto L21
    L16:
        r106 = false;
        goto L17
    L12:
        r102 = false;
    L27:
        e = move-exception;
        throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", new Object[]{r100}), e);
    }

    public static BytesRange toMax(int r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        return new BytesRange(0, r100);
    L5:
        r101 = false;
        goto L6
    }

    private static String valueOrEmpty(int r100) {
        if (r100 != Integer.MAX_VALUE) goto L7;
        return "";
    L7:
        return Integer.toString(r100);
    }

    public boolean contains(@Nullable BytesRange r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.from <= r100.from) goto L8;
        return false;
    L8:
        if (this.f274104to < r100.f274104to) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BytesRange) == true) goto L8;
        return false;
    L8:
        BytesRange r101 = (BytesRange) r100;
        if (this.from == r101.from) goto L11;
    L13:
        return false;
    L11:
        if (this.f274104to != r101.f274104to) goto L13;
        return true;
    }

    public BytesRange(int r100, int r101) {
        this.from = r100;
        this.f274104to = r101;
    }
}
