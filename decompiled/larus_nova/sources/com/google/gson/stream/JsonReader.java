package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final Reader f275914in;
    private boolean lenient;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int r100 = this.pos - 1;
        this.pos = r100;
        if ((r100 + 5) > this.limit) goto L5;
    L7:
        int r101 = this.pos;
        char[] r102 = this.buffer;
        if (r102[r101] == ')') goto L10;
        return;
    L10:
        if (r102[r101 + 1] == ']') goto L12;
        return;
    L12:
        if (r102[r101 + 2] == '}') goto L14;
        return;
    L14:
        if (r102[r101 + 3] == '\'') goto L16;
        return;
    L16:
        if (r102[r101 + 4] != '\n') goto L24;
        this.pos = r101 + 5;
        return;
    L24:
        return;
    L5:
        if (fillBuffer(5) == true) goto L7;
    }

    private String nextUnquotedValue() throws IOException {
        StringBuilder r100 = null;
        int r101 = 0;
    L3:
        int r102 = 0;
    L4:
        int r103 = this.pos;
        if ((r103 + r102) < this.limit) goto L6;
        if (r102 >= this.buffer.length) goto L41;
        if (fillBuffer(r102 + 1) == true) goto L4;
    L40:
        r101 = r102;
    L45:
        if (r100 != null) goto L47;
        String r104 = new String(this.buffer, this.pos, r101);
    L48:
        this.pos += r101;
        return r104;
    L47:
        r100.append(this.buffer, this.pos, r101);
        r104 = r100.toString();
        goto L48
    L41:
        if (r100 != null) goto L43;
        r100 = new StringBuilder(Math.max(r102, 16));
    L43:
        r100.append(this.buffer, this.pos, r102);
        this.pos += r102;
        if (fillBuffer(1) == true) goto L3;
    L6:
        char r105 = this.buffer[r103 + r102];
        if (r105 == '\t') goto L40;
        if (r105 == '\n') goto L40;
        if (r105 == '\f') goto L40;
        if (r105 == '\r') goto L40;
        if (r105 == ' ') goto L40;
        if (r105 == '#') goto L34;
        if (r105 == ',') goto L40;
        if (r105 == '/') goto L34;
        if (r105 == '=') goto L34;
        if (r105 == '{') goto L40;
        if (r105 == '}') goto L40;
        if (r105 == ':') goto L40;
        if (r105 == ';') goto L34;
        switch(r105) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r102 = r102 + 1;
    L34:
        checkLenient();
        goto L40
    }

    private void skipUnquotedValue() throws IOException {
    L2:
        int r100 = 0;
    L3:
        int r101 = this.pos;
        if ((r101 + r100) >= this.limit) goto L36;
        char r102 = this.buffer[r101 + r100];
        if (r102 == '\t') goto L34;
        if (r102 == '\n') goto L34;
        if (r102 == '\f') goto L34;
        if (r102 == '\r') goto L34;
        if (r102 == ' ') goto L34;
        if (r102 == '#') goto L33;
        if (r102 == ',') goto L34;
        if (r102 == '/') goto L33;
        if (r102 == '=') goto L33;
        if (r102 == '{') goto L34;
        if (r102 == '}') goto L34;
        if (r102 == ':') goto L34;
        if (r102 == ';') goto L33;
        switch(r102) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r100 = r100 + 1;
    L33:
        checkLenient();
    L34:
        this.pos += r100;
        return;
    L36:
        this.pos = r101 + r100;
        if (fillBuffer(1) == true) goto L2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f275914in.close();
    }

    public String getPath() {
        return getPath(false);
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public void skipValue() throws IOException {
        int r100 = 0;
    L3:
        int r101 = this.peeked;
        if (r101 != 0) goto L7;
        r101 = doPeek();
    L7:
        switch(r101) {
            case 1: goto L29;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L31;
            case 12: goto L17;
            case 13: goto L14;
            case 14: goto L11;
            case 15: goto L31;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L31;
        };
    L10:
        this.pos += this.peekedNumberLength;
        goto L31
    L11:
        skipUnquotedValue();
        if (r100 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L14:
        skipQuotedValue(Typography.quote);
        if (r100 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L17:
        skipQuotedValue('\'');
        if (r100 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L20:
        skipUnquotedValue();
        goto L31
    L21:
        skipQuotedValue(Typography.quote);
        goto L31
    L22:
        skipQuotedValue('\'');
        goto L31
    L23:
        this.stackSize--;
    L24:
        r100 = r100 - 1;
        goto L31
    L25:
        push(1);
    L30:
        r100 = r100 + 1;
        goto L31
    L26:
        if (r100 != 0) goto L28;
        this.pathNames[this.stackSize - 1] = null;
    L28:
        this.stackSize--;
        goto L24
    L29:
        push(3);
    L31:
        this.peeked = 0;
        if (r100 > 0) goto L3;
        int[] r102 = this.pathIndices;
        int r103 = this.stackSize - 1;
        r102[r103] = r102[r103] + 1;
        return;
    }

    static {
        JsonReaderInternalAccess.INSTANCE = new AnonymousClass1();
    }

    private void checkLenient() throws IOException {
        if (this.lenient == false) goto L6;
        return;
    L6:
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int peekKeyword() throws IOException {
        char r100 = this.buffer[this.pos];
        if (r100 != 't') goto L5;
    L20:
        String r101 = "true";
        String r102 = "TRUE";
        int r103 = 5;
    L21:
        int r104 = r101.length();
        int r105 = 1;
    L22:
        if (r105 >= r104) goto L35;
        if ((this.pos + r105) >= this.limit) goto L26;
    L28:
        char r106 = this.buffer[this.pos + r105];
        if (r106 == r101.charAt(r105)) goto L33;
        if (r106 == r102.charAt(r105)) goto L33;
        return 0;
    L33:
        r105 = r105 + 1;
        goto L22
    L26:
        if (fillBuffer(r105 + 1) == true) goto L28;
        return 0;
    L35:
        if ((this.pos + r104) < this.limit) goto L39;
        if (fillBuffer(r104 + 1) == true) goto L39;
    L41:
        this.pos += r104;
        this.peeked = r103;
        return r103;
    L39:
        if (isLiteral(this.buffer[this.pos + r104]) == false) goto L41;
        return 0;
    L5:
        if (r100 == 'T') goto L20;
        if (r100 != 'f') goto L10;
    L19:
        r101 = "false";
        r102 = "FALSE";
        r103 = 6;
        goto L21
    L10:
        if (r100 == 'F') goto L19;
        if (r100 != 'n') goto L15;
    L18:
        r101 = "null";
        r102 = "NULL";
        r103 = 7;
        goto L21
    L15:
        if (r100 == 'N') goto L18;
        return 0;
    }

    private int peekNumber() throws IOException {
        char[] r100 = this.buffer;
        int r101 = this.pos;
        int r102 = this.limit;
        int r103 = 0;
        int r104 = 0;
        char r105 = 0;
        boolean r110 = true;
        long r111 = 0;
        boolean r112 = false;
    L4:
        if ((r101 + r104) == r102) goto L6;
    L12:
        char r113 = r100[r101 + r104];
        if (r113 != '+') goto L15;
        r103 = 0;
        if (r105 != 5) goto L102;
    L100:
        r105 = 6;
    L101:
        r104 = r104 + 1;
        goto L4
    L102:
        return 0;
    L15:
        if (r113 != 'E') goto L17;
    L91:
        r103 = 0;
        if (r105 != 2) goto L94;
    L97:
        r105 = 5;
        goto L101
    L94:
        if (r105 == 4) goto L97;
        return 0;
    L17:
        if (r113 == 'e') goto L91;
        if (r113 != '-') goto L21;
        r103 = 0;
        if (r105 != 0) goto L88;
        r105 = 1;
        r112 = true;
        goto L101
    L88:
        if (r105 == 5) goto L100;
        return 0;
    L21:
        if (r113 != '.') goto L23;
        r103 = 0;
        if (r105 != 2) goto L84;
        r105 = 3;
        goto L101
    L84:
        return 0;
    L23:
        if (r113 < '0') goto L55;
        if (r113 > '9') goto L55;
        if (r105 == 1) goto L52;
        if (r105 == 0) goto L52;
        if (r105 == 2) goto L32;
        if (r105 != 3) goto L46;
        r103 = 0;
        r105 = 4;
        goto L101
    L46:
        if (r105 != 5) goto L48;
    L51:
        r103 = 0;
        r105 = 7;
        goto L101
    L48:
        if (r105 == 6) goto L51;
    L50:
        r103 = 0;
        goto L101
    L32:
        if (r111 == 0) goto L33;
        long r106 = (10 * r111) - ((long) (r113 - '0'));
        if (r111 > MIN_INCOMPLETE_INTEGER) goto L42;
        if (r111 == MIN_INCOMPLETE_INTEGER) goto L39;
    L41:
        boolean r107 = false;
    L43:
        r110 = r110 & r107;
        r111 = r106;
        goto L50
    L39:
        if (r106 >= r111) goto L41;
    L42:
        r107 = true;
        goto L43
    L33:
        return 0;
    L52:
        r111 = -(r113 - '0');
        r103 = 0;
        r105 = 2;
    L55:
        if (isLiteral(r113) == true) goto L79;
    L56:
        if (r105 != 2) goto L69;
        if (r110 == false) goto L69;
        if (r111 != Long.MIN_VALUE) goto L62;
        if (r112 == false) goto L69;
    L62:
        if (r111 != 0) goto L64;
        if (r112 == true) goto L69;
    L64:
        if (r112 == true) goto L67;
        r111 = -r111;
    L67:
        this.peekedLong = r111;
        this.pos += r104;
        this.peeked = 15;
        return 15;
    L69:
        if (r105 != 2) goto L71;
    L77:
        this.peekedNumberLength = r104;
        this.peeked = 16;
        return 16;
    L71:
        if (r105 == 4) goto L77;
        if (r105 == 7) goto L77;
        return 0;
    L79:
        return 0;
    L6:
        if (r104 == r100.length) goto L7;
        if (fillBuffer(r104 + 1) == false) goto L56;
        r101 = this.pos;
        r102 = this.limit;
        goto L12
    L7:
        return r103;
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit) goto L5;
    L9:
        char[] r100 = this.buffer;
        int r101 = this.pos;
        int r102 = r101 + 1;
        this.pos = r102;
        char r103 = r100[r101];
        if (r103 != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r102;
    L73:
        return r103;
    L12:
        if (r103 == '\"') goto L73;
        if (r103 == '\'') goto L73;
        if (r103 == '/') goto L73;
        if (r103 == '\\') goto L73;
        if (r103 != 'b') goto L22;
        return '\b';
    L22:
        if (r103 != 'f') goto L24;
        return '\f';
    L24:
        if (r103 != 'n') goto L26;
        return '\n';
    L26:
        if (r103 != 'r') goto L28;
        return '\r';
    L28:
        if (r103 != 't') goto L30;
        return '\t';
    L30:
        if (r103 != 'u') goto L62;
        if ((r102 + 4) > this.limit) goto L34;
    L38:
        int r104 = this.pos;
        int r105 = r104 + 4;
        char r106 = 0;
    L39:
        if (r104 >= r105) goto L59;
        char r107 = this.buffer[r104];
        char r108 = (char) (r106 << 4);
        if (r107 < '0') goto L47;
        if (r107 > '9') goto L47;
        int r109 = r107 - '0';
    L45:
        r106 = (char) (r108 + r109);
        r104 = r104 + 1;
    L47:
        if (r107 < 'a') goto L52;
        if (r107 > 'f') goto L52;
        int r110 = r107 - 'a';
    L50:
        r109 = r110 + 10;
    L52:
        if (r107 < 'A') goto L58;
        if (r107 > 'F') goto L58;
        r110 = r107 - 'A';
    L58:
        throw new NumberFormatException("\\u".concat(new String(this.buffer, this.pos, 4)));
    L59:
        this.pos += 4;
        return r106;
    L34:
        if (fillBuffer(4) == true) goto L38;
        throw syntaxError("Unterminated escape sequence");
    L62:
        throw syntaxError("Invalid escape sequence");
    L5:
        if (fillBuffer(1) == true) goto L9;
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipToEndOfLine() throws IOException {
    L3:
        if (this.pos >= this.limit) goto L5;
    L6:
        char[] r100 = this.buffer;
        int r101 = this.pos;
        int r102 = r101 + 1;
        this.pos = r102;
        char r103 = r100[r101];
        if (r103 == '\n') goto L8;
        if (r103 != '\r') goto L3;
        return;
    L8:
        this.lineNumber++;
        this.lineStart = r102;
        return;
    L5:
        if (fillBuffer(1) == true) goto L6;
    }

    public void beginArray() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 3) goto L10;
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 1) goto L10;
        push(3);
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public int doPeek() throws IOException {
        int[] r100 = this.stack;
        int r101 = this.stackSize;
        int r102 = r100[r101 - 1];
        if (r102 != 1) goto L5;
        r100[r101 - 1] = 2;
    L46:
        int r103 = nextNonWhitespace(true);
        if (r103 == 34) goto L84;
        if (r103 == 39) goto L82;
        if (r103 == 44) goto L75;
        if (r103 == 59) goto L75;
        if (r103 == 91) goto L73;
        if (r103 != 93) goto L55;
        if (r102 != 1) goto L75;
        this.peeked = 4;
        return 4;
    L55:
        if (r103 == 123) goto L68;
        this.pos--;
        int r104 = peekKeyword();
        if (r104 == 0) goto L59;
        return r104;
    L59:
        int r105 = peekNumber();
        if (r105 == 0) goto L63;
        return r105;
    L63:
        if (isLiteral(this.buffer[this.pos]) == false) goto L67;
        checkLenient();
        this.peeked = 10;
        return 10;
    L67:
        throw syntaxError("Expected value");
    L68:
        this.peeked = 1;
        return 1;
    L73:
        this.peeked = 3;
        return 3;
    L75:
        if (r102 == 1) goto L80;
        if (r102 == 2) goto L80;
        throw syntaxError("Unexpected value");
    L80:
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    L82:
        checkLenient();
        this.peeked = 8;
        return 8;
    L84:
        this.peeked = 9;
        return 9;
    L5:
        if (r102 != 2) goto L16;
        int r106 = nextNonWhitespace(true);
        if (r106 == 44) goto L46;
        if (r106 == 59) goto L14;
        if (r106 != 93) goto L13;
        this.peeked = 4;
        return 4;
    L13:
        throw syntaxError("Unterminated array");
    L14:
        checkLenient();
        goto L46
    L16:
        if (r102 == 3) goto L88;
        if (r102 == 5) goto L88;
        if (r102 != 4) goto L34;
        r100[r101 - 1] = 5;
        int r107 = nextNonWhitespace(true);
        if (r107 == 58) goto L46;
        if (r107 != 61) goto L32;
        checkLenient();
        if (this.pos >= this.limit) goto L27;
    L28:
        char[] r108 = this.buffer;
        int r109 = this.pos;
        if (r108[r109] != '>') goto L46;
        this.pos = r109 + 1;
        goto L46
    L27:
        if (fillBuffer(1) == false) goto L46;
    L32:
        throw syntaxError("Expected ':'");
    L34:
        if (r102 == 6) goto L36;
        if (r102 == 7) goto L41;
        if (r102 != 8) goto L46;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (nextNonWhitespace(false) != (-1)) goto L44;
        this.peeked = 17;
        return 17;
    L44:
        checkLenient();
        this.pos--;
        goto L46
    L36:
        if (this.lenient == false) goto L38;
        consumeNonExecutePrefix();
    L38:
        this.stack[this.stackSize - 1] = 7;
    L88:
        r100[r101 - 1] = 4;
        if (r102 != 5) goto L99;
        int r110 = nextNonWhitespace(true);
        if (r110 == 44) goto L99;
        if (r110 == 59) goto L98;
        if (r110 != 125) goto L97;
        this.peeked = 2;
        return 2;
    L97:
        throw syntaxError("Unterminated object");
    L98:
        checkLenient();
    L99:
        int r111 = nextNonWhitespace(true);
        if (r111 == 34) goto L117;
        if (r111 != 39) goto L103;
        checkLenient();
        this.peeked = 12;
        return 12;
    L103:
        if (r111 == 125) goto L110;
        checkLenient();
        this.pos--;
        if (isLiteral((char) r111) == false) goto L109;
        this.peeked = 14;
        return 14;
    L109:
        throw syntaxError("Expected name");
    L110:
        if (r102 == 5) goto L114;
        this.peeked = 2;
        return 2;
    L114:
        throw syntaxError("Expected name");
    L117:
        this.peeked = 13;
        return 13;
    }

    public void endArray() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 4) goto L10;
        int r101 = this.stackSize - 1;
        this.stackSize = r101;
        int[] r102 = this.pathIndices;
        int r103 = r101 - 1;
        r102[r103] = r102[r103] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 2) goto L10;
        int r101 = this.stackSize - 1;
        this.stackSize = r101;
        this.pathNames[r101] = null;
        int[] r102 = this.pathIndices;
        int r103 = r101 - 1;
        r102[r103] = r102[r103] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public boolean hasNext() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r100 == 4) goto L12;
        if (r100 == 17) goto L12;
        return true;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 5) goto L10;
        this.peeked = 0;
        int[] r101 = this.pathIndices;
        int r102 = this.stackSize - 1;
        r101[r102] = r101[r102] + 1;
        return true;
    L10:
        if (r100 != 6) goto L14;
        this.peeked = 0;
        int[] r103 = this.pathIndices;
        int r104 = this.stackSize - 1;
        r103[r104] = r103[r104] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 15) goto L10;
        this.peeked = 0;
        int[] r101 = this.pathIndices;
        int r102 = this.stackSize - 1;
        r101[r102] = r101[r102] + 1;
        return this.peekedLong;
    L10:
        if (r100 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r103 = Double.parseDouble(this.peekedString);
        if (this.lenient == false) goto L31;
    L37:
        this.peekedString = null;
        this.peeked = 0;
        int[] r104 = this.pathIndices;
        int r105 = this.stackSize - 1;
        r104[r105] = r104[r105] + 1;
        return r103;
    L31:
        if (Double.isNaN(r103) == true) goto L36;
        if (Double.isInfinite(r103) == false) goto L37;
    L36:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r103 + locationString());
    L13:
        if (r100 != 8) goto L15;
    L24:
        if (r100 != 8) goto L26;
        char r106 = '\'';
    L27:
        this.peekedString = nextQuotedValue(r106);
        goto L28
    L26:
        r106 = Typography.quote;
        goto L27
    L15:
        if (r100 == 9) goto L24;
        if (r100 != 10) goto L20;
        this.peekedString = nextUnquotedValue();
        goto L28
    L20:
        if (r100 == 11) goto L28;
        throw new IllegalStateException("Expected a double but was " + peek() + locationString());
    }

    public int nextInt() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 15) goto L14;
        long r101 = this.peekedLong;
        int r102 = (int) r101;
        if (r101 != r102) goto L12;
        this.peeked = 0;
        int[] r103 = this.pathIndices;
        int r104 = this.stackSize - 1;
        r103[r104] = r103[r104] + 1;
        return r102;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
    L14:
        if (r100 != 16) goto L17;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L33:
        this.peeked = 11;
        double r105 = Double.parseDouble(this.peekedString);
        int r106 = (int) r105;
        if (r106 != r105) goto L38;
        this.peekedString = null;
        this.peeked = 0;
        int[] r107 = this.pathIndices;
        int r108 = this.stackSize - 1;
        r107[r108] = r107[r108] + 1;
        return r106;
    L38:
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    L17:
        if (r100 != 8) goto L19;
    L24:
        if (r100 != 10) goto L26;
        this.peekedString = nextUnquotedValue();
    L39:
        int r109 = Integer.parseInt(this.peekedString);     // Catch: NumberFormatException -> L32
        this.peeked = 0;     // Catch: NumberFormatException -> L32
        int[] r110 = this.pathIndices;     // Catch: NumberFormatException -> L32
        int r111 = this.stackSize - 1;     // Catch: NumberFormatException -> L32
        r110[r111] = r110[r111] + 1;     // Catch: NumberFormatException -> L32
        return r109;
    L26:
        if (r100 != 8) goto L28;
        char r112 = '\'';
    L29:
        this.peekedString = nextQuotedValue(r112);
        goto L39
    L28:
        r112 = Typography.quote;
        goto L29
    L19:
        if (r100 == 9) goto L24;
        if (r100 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + peek() + locationString());
    }

    public long nextLong() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 15) goto L10;
        this.peeked = 0;
        int[] r101 = this.pathIndices;
        int r102 = this.stackSize - 1;
        r101[r102] = r101[r102] + 1;
        return this.peekedLong;
    L10:
        if (r100 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L29:
        this.peeked = 11;
        double r103 = Double.parseDouble(this.peekedString);
        long r104 = (long) r103;
        if (r104 != r103) goto L34;
        this.peekedString = null;
        this.peeked = 0;
        int[] r105 = this.pathIndices;
        int r106 = this.stackSize - 1;
        r105[r106] = r105[r106] + 1;
        return r104;
    L34:
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    L13:
        if (r100 != 8) goto L15;
    L20:
        if (r100 != 10) goto L22;
        this.peekedString = nextUnquotedValue();
    L35:
        long r107 = Long.parseLong(this.peekedString);     // Catch: NumberFormatException -> L28
        this.peeked = 0;     // Catch: NumberFormatException -> L28
        int[] r108 = this.pathIndices;     // Catch: NumberFormatException -> L28
        int r109 = this.stackSize - 1;     // Catch: NumberFormatException -> L28
        r108[r109] = r108[r109] + 1;     // Catch: NumberFormatException -> L28
        return r107;
    L22:
        if (r100 != 8) goto L24;
        char r110 = '\'';
    L25:
        this.peekedString = nextQuotedValue(r110);
        goto L35
    L24:
        r110 = Typography.quote;
        goto L25
    L15:
        if (r100 == 9) goto L20;
        if (r100 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + peek() + locationString());
    }

    public String nextName() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 14) goto L9;
        String r101 = nextUnquotedValue();
    L14:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r101;
        return r101;
    L9:
        if (r100 != 12) goto L12;
        r101 = nextQuotedValue('\'');
        goto L14
    L12:
        if (r100 != 13) goto L17;
        r101 = nextQuotedValue(Typography.quote);
        goto L14
    L17:
        throw new IllegalStateException("Expected a name but was " + peek() + locationString());
    }

    public void nextNull() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 7) goto L10;
        this.peeked = 0;
        int[] r101 = this.pathIndices;
        int r102 = this.stackSize - 1;
        r101[r102] = r101[r102] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L6;
        r100 = doPeek();
    L6:
        if (r100 != 10) goto L9;
        String r101 = nextUnquotedValue();
    L23:
        this.peeked = 0;
        int[] r102 = this.pathIndices;
        int r103 = this.stackSize - 1;
        r102[r103] = r102[r103] + 1;
        return r101;
    L9:
        if (r100 != 8) goto L12;
        r101 = nextQuotedValue('\'');
        goto L23
    L12:
        if (r100 != 9) goto L15;
        r101 = nextQuotedValue(Typography.quote);
        goto L23
    L15:
        if (r100 != 11) goto L18;
        r101 = this.peekedString;
        this.peekedString = null;
        goto L23
    L18:
        if (r100 != 15) goto L21;
        r101 = Long.toString(this.peekedLong);
        goto L23
    L21:
        if (r100 != 16) goto L26;
        r101 = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        goto L23
    L26:
        throw new IllegalStateException("Expected a string but was " + peek() + locationString());
    }

    public JsonToken peek() throws IOException {
        int r100 = this.peeked;
        if (r100 != 0) goto L5;
        r100 = doPeek();
    L5:
        switch(r100) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public JsonReader(Reader r100) {
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int[] r101 = new int[32];
        this.stack = r101;
        this.stackSize = 0 + 1;
        r101[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(r100, "in == null");
        this.f275914in = r100;
    }

    private boolean fillBuffer(int r100) throws IOException {
        char[] r101 = this.buffer;
        int r102 = this.lineStart;
        int r103 = this.pos;
        this.lineStart = r102 - r103;
        int r104 = this.limit;
        if (r104 == r103) goto L5;
        int r105 = r104 - r103;
        this.limit = r105;
        System.arraycopy(r101, r103, r101, 0, r105);
    L6:
        this.pos = 0;
    L7:
        Reader r106 = this.f275914in;
        int r107 = this.limit;
        int r108 = r106.read(r101, r107, r101.length - r107);
        if (r108 == (-1)) goto L19;
        int r109 = this.limit + r108;
        this.limit = r109;
        if (this.lineNumber != 0) goto L17;
        int r110 = this.lineStart;
        if (r110 != 0) goto L17;
        if (r109 <= 0) goto L17;
        if (r101[0] != 65279) goto L17;
        this.pos++;
        this.lineStart = r110 + 1;
        r100 = r100 + 1;
    L17:
        if (r109 < r100) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.limit = 0;
        goto L6
    }

    private String getPath(boolean r100) {
        StringBuilder r101 = new StringBuilder("$");
        int r102 = 0;
    L3:
        int r103 = this.stackSize;
        if (r102 >= r103) goto L28;
        int r104 = this.stack[r102];
        if (r104 != 1) goto L8;
    L19:
        int r105 = this.pathIndices[r102];
        if (r100 == false) goto L25;
        if (r105 <= 0) goto L25;
        if (r102 != (r103 - 1)) goto L25;
        r105 = r105 - 1;
    L25:
        r101.append('[');
        r101.append(r105);
        r101.append(']');
    L26:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104 == 2) goto L19;
        if (r104 != 3) goto L12;
    L16:
        r101.append('.');
        String r106 = this.pathNames[r102];
        if (r106 == null) goto L26;
        r101.append(r106);
        goto L26
    L12:
        if (r104 == 4) goto L16;
        if (r104 == 5) goto L16;
    L28:
        return r101.toString();
    }

    private boolean isLiteral(char r100) throws IOException {
        if (r100 != '\t') goto L5;
        return false;
    L5:
        if (r100 != '\n') goto L7;
        return false;
    L7:
        if (r100 != '\f') goto L9;
        return false;
    L9:
        if (r100 != '\r') goto L11;
        return false;
    L11:
        if (r100 != ' ') goto L13;
        return false;
    L13:
        if (r100 != '#') goto L15;
    L31:
        checkLenient();
        return false;
    L15:
        if (r100 != ',') goto L17;
        return false;
    L17:
        if (r100 == '/') goto L31;
        if (r100 == '=') goto L31;
        if (r100 != '{') goto L23;
        return false;
    L23:
        if (r100 != '}') goto L25;
        return false;
    L25:
        if (r100 != ':') goto L27;
        return false;
    L27:
        if (r100 == ';') goto L31;
        switch(r100) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    private int nextNonWhitespace(boolean r100) throws IOException {
        char[] r101 = this.buffer;
        int r102 = this.pos;
        int r103 = this.limit;
    L4:
        if (r102 != r103) goto L13;
        this.pos = r102;
        if (fillBuffer(1) == false) goto L7;
        r102 = this.pos;
        r103 = this.limit;
        goto L13
    L7:
        if (r100 == true) goto L11;
        return -1;
    L11:
        throw new EOFException("End of input" + locationString());
    L13:
        int r104 = r102 + 1;
        char r105 = r101[r102];
        if (r105 == '\n') goto L15;
        if (r105 == ' ') goto L45;
        if (r105 == '\r') goto L45;
        if (r105 == '\t') goto L45;
        if (r105 == '/') goto L25;
        if (r105 != '#') goto L43;
        this.pos = r104;
        checkLenient();
        skipToEndOfLine();
        r102 = this.pos;
        r103 = this.limit;
        goto L4
    L43:
        this.pos = r104;
        return r105;
    L25:
        this.pos = r104;
        if (r104 != r103) goto L30;
        this.pos = r104 - 1;
        boolean r106 = fillBuffer(2);
        this.pos++;
        if (r106 == true) goto L30;
        return r105;
    L30:
        checkLenient();
        int r107 = this.pos;
        char r108 = r101[r107];
        if (r108 != '*') goto L32;
        this.pos = r107 + 1;
        if (skipTo("*/") == false) goto L39;
        r102 = this.pos + 2;
        r103 = this.limit;
        goto L4
    L39:
        throw syntaxError("Unterminated comment");
    L32:
        if (r108 != '/') goto L33;
        this.pos = r107 + 1;
        skipToEndOfLine();
        r102 = this.pos;
        r103 = this.limit;
        goto L4
    L33:
        return r105;
    L45:
        r102 = r104;
        goto L4
    L15:
        this.lineNumber++;
        this.lineStart = r104;
        goto L45
    }

    private String nextQuotedValue(char r110) throws IOException {
        char[] r100 = this.buffer;
        StringBuilder r101 = null;
    L3:
        int r102 = this.pos;
        int r103 = this.limit;
    L4:
        int r104 = r103;
        int r105 = r102;
    L6:
        if (r102 >= r104) goto L25;
        int r106 = r102 + 1;
        char r107 = r100[r102];
        if (r107 == r110) goto L9;
        if (r107 == '\\') goto L17;
        if (r107 != '\n') goto L24;
        this.lineNumber++;
        this.lineStart = r106;
    L24:
        r102 = r106;
        goto L6
    L17:
        this.pos = r106;
        int r108 = (r106 - r105) - 1;
        if (r101 != null) goto L20;
        r101 = new StringBuilder(Math.max((r108 + 1) * 2, 16));
    L20:
        r101.append(r100, r105, r108);
        r101.append(readEscapeCharacter());
        r102 = this.pos;
        r103 = this.limit;
        goto L4
    L9:
        this.pos = r106;
        int r109 = (r106 - r105) - 1;
        if (r101 == null) goto L12;
        r101.append(r100, r105, r109);
        return r101.toString();
    L12:
        return new String(r100, r105, r109);
    L25:
        if (r101 != null) goto L27;
        r101 = new StringBuilder(Math.max((r102 - r105) * 2, 16));
    L27:
        r101.append(r100, r105, r102 - r105);
        this.pos = r102;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private void push(int r100) {
        int r101 = this.stackSize;
        int[] r102 = this.stack;
        if (r101 != r102.length) goto L5;
        int r103 = r101 * 2;
        this.stack = Arrays.copyOf(r102, r103);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r103);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r103);
    L5:
        int[] r104 = this.stack;
        int r105 = this.stackSize;
        this.stackSize = r105 + 1;
        r104[r105] = r100;
    }

    private void skipQuotedValue(char r100) throws IOException {
        char[] r101 = this.buffer;
    L3:
        int r102 = this.pos;
        int r103 = this.limit;
    L5:
        if (r102 >= r103) goto L17;
        int r104 = r102 + 1;
        char r105 = r101[r102];
        if (r105 == r100) goto L8;
        if (r105 == '\\') goto L12;
        if (r105 != '\n') goto L16;
        this.lineNumber++;
        this.lineStart = r104;
    L16:
        r102 = r104;
        goto L5
    L12:
        this.pos = r104;
        readEscapeCharacter();
        r102 = this.pos;
        r103 = this.limit;
        goto L5
    L8:
        this.pos = r104;
        return;
    L17:
        this.pos = r102;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String r100) throws IOException {
        int r101 = r100.length();
    L3:
        int r102 = 0;
        if ((this.pos + r101) > this.limit) goto L6;
    L9:
        char[] r103 = this.buffer;
        int r104 = this.pos;
        if (r103[r104] != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r104 + 1;
    L15:
        this.pos++;
    L12:
        if (r102 >= r101) goto L17;
        if (this.buffer[this.pos + r102] != r100.charAt(r102)) goto L15;
        r102 = r102 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (fillBuffer(r101) == true) goto L9;
        return false;
    }

    private IOException syntaxError(String r100) throws IOException {
        throw new MalformedJsonException(r100 + locationString());
    }

    public final void setLenient(boolean r100) {
        this.lenient = r100;
    }
}
