package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;
    private static final String[] REPLACEMENT_CHARS = null;
    private static final Pattern VALID_JSON_NUMBER_PATTERN = null;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack;
    private int stackSize;

    public JsonWriter endArray() throws IOException {
        return close(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, '}');
    }

    static {
        VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        REPLACEMENT_CHARS = new String[128];
        int r100 = 0;
    L4:
        if (r100 > 31) goto L6;
        REPLACEMENT_CHARS[r100] = String.format("\\u%04x", new Object[]{Integer.valueOf(r100)});
        r100 = r100 + 1;
        goto L4
    L6:
        String[] r101 = REPLACEMENT_CHARS;
        r101[34] = "\\\"";
        r101[92] = "\\\\";
        r101[9] = "\\t";
        r101[8] = "\\b";
        r101[10] = "\\n";
        r101[13] = "\\r";
        r101[12] = "\\f";
        String[] r102 = (String[]) r101.clone();
        HTML_SAFE_REPLACEMENT_CHARS = r102;
        r102[60] = "\\u003c";
        r102[62] = "\\u003e";
        r102[38] = "\\u0026";
        r102[61] = "\\u003d";
        r102[39] = "\\u0027";
    }

    private void newline() throws IOException {
        if (this.indent != null) goto L5;
        return;
    L5:
        this.out.write(10);
        int r100 = this.stackSize;
        int r101 = 1;
    L6:
        if (r101 >= r100) goto L8;
        this.out.write(this.indent);
        r101 = r101 + 1;
        goto L6
    }

    private int peek() {
        int r100 = this.stackSize;
        if (r100 == 0) goto L7;
        return this.stack[r100 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName == null) goto L6;
        beforeName();
        string(this.deferredName);
        this.deferredName = null;
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int r100 = this.stackSize;
        if (r100 > 1) goto L10;
        if (r100 == 1) goto L6;
    L7:
        this.stackSize = 0;
        return;
    L6:
        if (this.stack[r100 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) goto L7;
        this.out.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) goto L5;
    L9:
        beforeValue();
        this.out.write("null");
        return this;
    L5:
        if (this.serializeNulls == false) goto L7;
        writeDeferredName();
        goto L9
    L7:
        this.deferredName = null;
        return this;
    }

    private void beforeName() throws IOException {
        int r100 = peek();
        if (r100 != 5) goto L6;
        this.out.write(44);
    L7:
        newline();
        replaceTop(4);
        return;
    L6:
        if (r100 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void beforeValue() throws IOException {
        int r100 = peek();
        if (r100 == 1) goto L20;
        if (r100 != 2) goto L6;
        this.out.append(',');
        newline();
        return;
    L6:
        if (r100 != 4) goto L8;
        this.out.append(this.separator);
        replaceTop(5);
        return;
    L8:
        if (r100 == 6) goto L17;
        if (r100 != 7) goto L16;
        if (this.lenient == true) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        replaceTop(7);
        return;
    L20:
        replaceTop(2);
        newline();
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, '{');
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter(Writer r100) {
        this.stack = new int[32];
        this.stackSize = 0;
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        Objects.requireNonNull(r100, "out == null");
        this.out = r100;
    }

    private static boolean isTrustedNumberType(Class<? extends Number> r100) {
        if (r100 != Integer.class) goto L5;
    L24:
        return true;
    L5:
        if (r100 == Long.class) goto L24;
        if (r100 == Double.class) goto L24;
        if (r100 == Float.class) goto L24;
        if (r100 == Byte.class) goto L24;
        if (r100 == Short.class) goto L24;
        if (r100 == BigDecimal.class) goto L24;
        if (r100 == BigInteger.class) goto L24;
        if (r100 == AtomicInteger.class) goto L24;
        if (r100 == AtomicLong.class) goto L24;
        return false;
    }

    private void push(int r100) {
        int r101 = this.stackSize;
        int[] r102 = this.stack;
        if (r101 != r102.length) goto L5;
        this.stack = Arrays.copyOf(r102, r101 * 2);
    L5:
        int[] r103 = this.stack;
        int r104 = this.stackSize;
        this.stackSize = r104 + 1;
        r103[r104] = r100;
    }

    private void replaceTop(int r100) {
        this.stack[this.stackSize - 1] = r100;
    }

    private void string(String r100) throws IOException {
        if (this.htmlSafe == false) goto L5;
        String[] r101 = HTML_SAFE_REPLACEMENT_CHARS;
    L6:
        this.out.write(34);
        int r102 = r100.length();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r102) goto L23;
        char r105 = r100.charAt(r103);
        if (r105 >= 128) goto L14;
        String r106 = r101[r105];
        if (r106 == null) goto L22;
    L19:
        if (r104 >= r103) goto L21;
        this.out.write(r100, r104, r103 - r104);
    L21:
        this.out.write(r106);
        r104 = r103 + 1;
    L22:
        r103 = r103 + 1;
        goto L7
    L14:
        if (r105 != 8232) goto L17;
        r106 = "\\u2028";
        goto L19
    L17:
        if (r105 != 8233) goto L22;
        r106 = "\\u2029";
        goto L19
    L23:
        if (r104 >= r102) goto L25;
        this.out.write(r100, r104, r102 - r104);
    L25:
        this.out.write(34);
        return;
    L5:
        r101 = REPLACEMENT_CHARS;
        goto L6
    }

    public JsonWriter jsonValue(String r100) throws IOException {
        if (r100 == null) goto L4;
        writeDeferredName();
        beforeValue();
        this.out.append(r100);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter name(String r100) throws IOException {
        Objects.requireNonNull(r100, "name == null");
        if (this.deferredName != null) goto L11;
        if (this.stackSize == 0) goto L9;
        this.deferredName = r100;
        return this;
    L9:
        throw new IllegalStateException("JsonWriter is closed.");
    L11:
        throw new IllegalStateException();
    }

    public final void setHtmlSafe(boolean r100) {
        this.htmlSafe = r100;
    }

    public final void setIndent(String r100) {
        if (r100.length() != 0) goto L5;
        this.indent = null;
        this.separator = ":";
        return;
    L5:
        this.indent = r100;
        this.separator = ": ";
    }

    public final void setLenient(boolean r100) {
        this.lenient = r100;
    }

    public final void setSerializeNulls(boolean r100) {
        this.serializeNulls = r100;
    }

    public JsonWriter value(Number r100) throws IOException {
        if (r100 == null) goto L4;
        writeDeferredName();
        String r101 = r100.toString();
        if (r101.equals("-Infinity") == true) goto L20;
        if (r101.equals("Infinity") == true) goto L20;
        if (r101.equals("NaN") == true) goto L20;
        Class<?> r102 = r100.getClass();
        if (isTrustedNumberType(r102) == false) goto L15;
    L21:
        beforeValue();
        this.out.append(r101);
        return this;
    L15:
        if (VALID_JSON_NUMBER_PATTERN.matcher(r101).matches() == true) goto L21;
        throw new IllegalArgumentException("String created by " + r102 + " is not a valid JSON number: " + r101);
    L20:
        if (this.lenient == true) goto L21;
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(r101));
    L4:
        return nullValue();
    }

    public JsonWriter value(double r100) throws IOException {
        writeDeferredName();
        if (this.lenient == false) goto L5;
    L11:
        beforeValue();
        this.out.append(Double.toString(r100));
        return this;
    L5:
        if (Double.isNaN(r100) == true) goto L10;
        if (Double.isInfinite(r100) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r100);
    }

    public JsonWriter value(float r100) throws IOException {
        writeDeferredName();
        if (this.lenient == false) goto L5;
    L11:
        beforeValue();
        this.out.append(Float.toString(r100));
        return this;
    L5:
        if (Float.isNaN(r100) == true) goto L10;
        if (Float.isInfinite(r100) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r100);
    }

    public JsonWriter value(Boolean r100) throws IOException {
        if (r100 == null) goto L4;
        writeDeferredName();
        beforeValue();
        Writer r101 = this.out;
        if (r100.booleanValue() == false) goto L8;
        String r102 = "true";
    L9:
        r101.write(r102);
        return this;
    L8:
        r102 = "false";
        goto L9
    L4:
        return nullValue();
    }

    public JsonWriter value(boolean r100) throws IOException {
        writeDeferredName();
        beforeValue();
        Writer r101 = this.out;
        if (r100 == false) goto L5;
        String r102 = "true";
    L6:
        r101.write(r102);
        return this;
    L5:
        r102 = "false";
        goto L6
    }

    public JsonWriter value(String r100) throws IOException {
        if (r100 == null) goto L4;
        writeDeferredName();
        beforeValue();
        string(r100);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter value(long r100) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(r100));
        return this;
    }

    private JsonWriter open(int r100, char r101) throws IOException {
        beforeValue();
        push(r100);
        this.out.write(r101);
        return this;
    }

    private JsonWriter close(int r100, int r101, char r102) throws IOException {
        int r103 = peek();
        if (r103 == r101) goto L9;
        if (r103 == r100) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.deferredName != null) goto L16;
        this.stackSize--;
        if (r103 != r101) goto L13;
        newline();
    L13:
        this.out.write(r102);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }
}
