package org.apache.commons.lang3.text;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes42.dex */
public class StrBuilder implements CharSequence, Appendable, Serializable {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    public class StrBuilderReader extends Reader {
        private int mark;
        private int pos;
        final /* synthetic */ StrBuilder this$0;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public boolean ready() {
            if (this.pos >= this.this$0.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public int read() {
            if (ready() == true) goto L6;
            return -1;
        L6:
            StrBuilder r100 = this.this$0;
            int r101 = this.pos;
            this.pos = r101 + 1;
            return r100.charAt(r101);
        }

        public StrBuilderReader(StrBuilder r100) {
            this.this$0 = r100;
        }

        @Override // java.io.Reader
        public void mark(int r100) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public long skip(long r100) {
            if ((((long) this.pos) + r100) <= this.this$0.size()) goto L6;
            r100 = this.this$0.size() - this.pos;
        L6:
            if (r100 >= 0) goto L8;
            return 0;
        L8:
            this.pos = (int) (((long) this.pos) + r100);
            return r100;
        }

        @Override // java.io.Reader
        public int read(char[] r100, int r101, int r102) {
            if (r101 < 0) goto L22;
            if (r102 < 0) goto L22;
            if (r101 > r100.length) goto L22;
            int r103 = r101 + r102;
            if (r103 > r100.length) goto L22;
            if (r103 < 0) goto L22;
            if (r102 != 0) goto L13;
            return 0;
        L13:
            if (this.pos < this.this$0.size()) goto L17;
            return -1;
        L17:
            if ((this.pos + r102) <= this.this$0.size()) goto L19;
            r102 = this.this$0.size() - this.pos;
        L19:
            StrBuilder r104 = this.this$0;
            int r105 = this.pos;
            r104.getChars(r105, r105 + r102, r100, r101);
            this.pos += r102;
            return r102;
        L22:
            throw new IndexOutOfBoundsException();
        }
    }

    public class StrBuilderTokenizer extends StrTokenizer {
        final /* synthetic */ StrBuilder this$0;

        public StrBuilderTokenizer(StrBuilder r100) {
            this.this$0 = r100;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public List<String> tokenize(char[] r100, int r101, int r102) {
            if (r100 != null) goto L6;
            StrBuilder r103 = this.this$0;
            return super.tokenize(r103.buffer, 0, r103.size());
        L6:
            return super.tokenize(r100, r101, r102);
        }
    }

    public class StrBuilderWriter extends Writer {
        final /* synthetic */ StrBuilder this$0;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public StrBuilderWriter(StrBuilder r100) {
            this.this$0 = r100;
        }

        @Override // java.io.Writer
        public void write(int r100) {
            this.this$0.append((char) r100);
        }

        @Override // java.io.Writer
        public void write(String r100) {
            this.this$0.append(r100);
        }

        @Override // java.io.Writer
        public void write(char[] r100) {
            this.this$0.append(r100);
        }

        @Override // java.io.Writer
        public void write(String r100, int r101, int r102) {
            this.this$0.append(r100, r101, r102);
        }

        @Override // java.io.Writer
        public void write(char[] r100, int r101, int r102) {
            this.this$0.append(r100, r101, r102);
        }
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public StrBuilder() {
        this(32);
    }

    public StrBuilder appendNewLine() {
        String r100 = this.newLine;
        if (r100 != null) goto L7;
        append(System.lineSeparator());
        return this;
    L7:
        return append(r100);
    }

    public StrBuilder appendNull() {
        String r100 = this.nullText;
        if (r100 != null) goto L6;
        return this;
    L6:
        return append(r100);
    }

    public Reader asReader() {
        return new StrBuilderReader(this);
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer(this);
    }

    public Writer asWriter() {
        return new StrBuilderWriter(this);
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int hashCode() {
        char[] r100 = this.buffer;
        int r101 = this.size - 1;
        int r102 = 0;
    L3:
        if (r101 < 0) goto L5;
        r102 = (r102 * 31) + r100[r101];
        r101 = r101 - 1;
        goto L3
    L5:
        return r102;
    }

    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length <= length()) goto L5;
        char[] r100 = this.buffer;
        char[] r101 = new char[length()];
        this.buffer = r101;
        System.arraycopy(r100, 0, r101, 0, this.size);
    L5:
        return this;
    }

    public StrBuilder reverse() {
        int r100 = this.size;
        if (r100 != 0) goto L5;
        return this;
    L5:
        int r101 = r100 / 2;
        char[] r102 = this.buffer;
        int r103 = r100 - 1;
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L8;
        char r105 = r102[r104];
        r102[r104] = r102[r103];
        r102[r103] = r105;
        r104 = r104 + 1;
        r103 = r103 - 1;
        goto L6
    L8:
        return this;
    }

    public char[] toCharArray() {
        int r100 = this.size;
        if (r100 == 0) goto L5;
        char[] r101 = new char[r100];
        System.arraycopy(this.buffer, 0, r101, 0, r100);
        return r101;
    L5:
        return ArrayUtils.EMPTY_CHAR_ARRAY;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer r100 = new StringBuffer(this.size);
        r100.append(this.buffer, 0, this.size);
        return r100;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder r100 = new StringBuilder(this.size);
        r100.append(this.buffer, 0, this.size);
        return r100;
    }

    public StrBuilder trim() {
        int r100 = this.size;
        if (r100 != 0) goto L5;
        return this;
    L5:
        char[] r101 = this.buffer;
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L11;
        if (r101[r102] > ' ') goto L11;
        r102 = r102 + 1;
    L11:
        if (r102 >= r100) goto L15;
        if (r101[r100 - 1] > ' ') goto L15;
        r100 = r100 - 1;
    L15:
        int r103 = this.size;
        if (r100 >= r103) goto L18;
        delete(r100, r103);
    L18:
        if (r102 <= 0) goto L20;
        delete(0, r102);
    L20:
        return this;
    }

    public /* bridge */ /* synthetic */ Object build() {
        return m10986build();
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public int size() {
        return this.size;
    }

    /* JADX INFO: renamed from: build, reason: collision with other method in class */
    public String m10986build() {
        return toString();
    }

    public StrBuilder(String r100) {
        if (r100 != null) goto L5;
        this.buffer = new char[32];
        return;
    L5:
        this.buffer = new char[r100.length() + 32];
        append(r100);
    }

    public StrBuilder append(boolean r100) {
        if (r100 == false) goto L5;
        ensureCapacity(this.size + 4);
        char[] r101 = this.buffer;
        int r102 = this.size;
        int r103 = r102 + 1;
        r101[r102] = OthersPermission.STICKY_E;
        int r104 = r103 + 1;
        r101[r103] = Permission.READ;
        int r105 = r104 + 1;
        r101[r104] = 'u';
        this.size = r105 + 1;
        r101[r105] = 'e';
    L6:
        return this;
    L5:
        ensureCapacity(this.size + 5);
        char[] r106 = this.buffer;
        int r107 = this.size;
        int r108 = r107 + 1;
        r106[r107] = 'f';
        int r109 = r108 + 1;
        r106[r108] = 'a';
        int r110 = r109 + 1;
        r106[r109] = Symlink.UNIX_ID;
        int r111 = r110 + 1;
        r106[r110] = 's';
        this.size = r111 + 1;
        r106[r111] = 'e';
        goto L6
    }

    public StrBuilder appendAll(Iterable<?> r100) {
        if (r100 == null) goto L7;
        Iterator<?> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L7;
        append(r101.next());
    L7:
        return this;
    }

    public StrBuilder appendSeparator(char r100) {
        if (size() <= 0) goto L5;
        append(r100);
    L5:
        return this;
    }

    public void appendTo(Appendable r100) throws IOException {
        if ((r100 instanceof Writer) == false) goto L6;
        ((Writer) r100).write(this.buffer, 0, this.size);
        return;
    L6:
        if ((r100 instanceof StringBuilder) == false) goto L9;
        ((StringBuilder) r100).append(this.buffer, 0, this.size);
        return;
    L9:
        if ((r100 instanceof StringBuffer) == false) goto L12;
        ((StringBuffer) r100).append(this.buffer, 0, this.size);
        return;
    L12:
        if ((r100 instanceof CharBuffer) == false) goto L14;
        ((CharBuffer) r100).put(this.buffer, 0, this.size);
        return;
    L14:
        r100.append(this);
    }

    public StrBuilder appendln(char r100) {
        return append(r100).appendNewLine();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= length()) goto L8;
        return this.buffer[r100];
    L8:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public boolean contains(char r100) {
        char[] r101 = this.buffer;
        int r102 = 0;
    L4:
        if (r102 >= this.size) goto L10;
        if (r101[r102] == r100) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public StrBuilder deleteAll(char r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L14;
        if (this.buffer[r101] != r100) goto L13;
        int r102 = r101;
    L8:
        r102 = r102 + 1;
        if (r102 >= this.size) goto L12;
        if (this.buffer[r102] == r100) goto L8;
    L12:
        int r103 = r102 - r101;
        deleteImpl(r101, r102, r103);
        r101 = r102 - r103;
    L13:
        r101 = r101 + 1;
        goto L4
    L14:
        return this;
    }

    public StrBuilder deleteCharAt(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= this.size) goto L8;
        deleteImpl(r100, r100 + 1, 1);
        return this;
    L8:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public StrBuilder deleteFirst(String r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        if (r101 <= 0) goto L10;
        int r102 = indexOf(r100, 0);
        if (r102 < 0) goto L10;
        deleteImpl(r102, r102 + r101, r101);
    L10:
        return this;
    L5:
        r101 = r100.length();
        goto L6
    }

    public boolean endsWith(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length();
        if (r101 != 0) goto L8;
        return true;
    L8:
        int r102 = this.size;
        if (r101 <= r102) goto L11;
        return false;
    L11:
        int r103 = r102 - r101;
        int r104 = 0;
    L12:
        if (r104 >= r101) goto L17;
        if (this.buffer[r103] != r100.charAt(r104)) goto L15;
        r104 = r104 + 1;
        r103 = r103 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public StrBuilder ensureCapacity(int r100) {
        char[] r101 = this.buffer;
        if (r100 <= r101.length) goto L5;
        char[] r102 = new char[r100 * 2];
        this.buffer = r102;
        System.arraycopy(r101, 0, r102, 0, this.size);
    L5:
        return this;
    }

    public boolean equals(StrBuilder r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        int r101 = this.size;
        if (r101 == r100.size) goto L11;
        return false;
    L11:
        char[] r102 = this.buffer;
        char[] r103 = r100.buffer;
        int r104 = r101 - 1;
    L12:
        if (r104 < 0) goto L17;
        if (r102[r104] != r103[r104]) goto L15;
        r104 = r104 - 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        int r101 = this.size;
        if (r101 == r100.size) goto L8;
        return false;
    L8:
        char[] r102 = this.buffer;
        char[] r103 = r100.buffer;
        int r104 = r101 - 1;
    L9:
        if (r104 < 0) goto L16;
        char r105 = r102[r104];
        char r106 = r103[r104];
        if (r105 == r106) goto L15;
        if (Character.toUpperCase(r105) == Character.toUpperCase(r106)) goto L15;
        return false;
    L15:
        r104 = r104 - 1;
        goto L9
    L16:
        return true;
    }

    public char[] getChars(char[] r100) {
        int r101 = length();
        if (r100 != null) goto L5;
    L6:
        r100 = new char[r101];
    L7:
        System.arraycopy(this.buffer, 0, r100, 0, r101);
        return r100;
    L5:
        if (r100.length >= r101) goto L7;
        goto L6
    }

    public int indexOf(char r100) {
        return indexOf(r100, 0);
    }

    public int lastIndexOf(char r100) {
        return lastIndexOf(r100, this.size - 1);
    }

    public String leftString(int r100) {
        if (r100 > 0) goto L5;
        return "";
    L5:
        int r101 = this.size;
        if (r100 < r101) goto L10;
        return new String(this.buffer, 0, r101);
    L10:
        return new String(this.buffer, 0, r100);
    }

    public int readFrom(Readable r100) throws IOException {
        int r101 = this.size;
        if ((r100 instanceof Reader) == false) goto L9;
        Reader r102 = (Reader) r100;
        ensureCapacity(r101 + 1);
    L5:
        char[] r103 = this.buffer;
        int r104 = this.size;
        int r105 = r102.read(r103, r104, r103.length - r104);
        if (r105 == (-1)) goto L14;
        int r106 = this.size + r105;
        this.size = r106;
        ensureCapacity(r106 + 1);
    L14:
        return this.size - r101;
    L9:
        if ((r100 instanceof CharBuffer) == false) goto L11;
        CharBuffer r107 = (CharBuffer) r100;
        int r108 = r107.remaining();
        ensureCapacity(this.size + r108);
        r107.get(this.buffer, this.size, r108);
        this.size += r108;
    L11:
        ensureCapacity(this.size + 1);
        char[] r109 = this.buffer;
        int r110 = this.size;
        int r111 = r100.read(CharBuffer.wrap(r109, r110, r109.length - r110));
        if (r111 == (-1)) goto L14;
        this.size += r111;
        goto L11
    }

    public String rightString(int r100) {
        if (r100 > 0) goto L5;
        return "";
    L5:
        int r101 = this.size;
        if (r100 < r101) goto L10;
        return new String(this.buffer, 0, r101);
    L10:
        return new String(this.buffer, r101 - r100, r100);
    }

    public StrBuilder setLength(int r100) {
        if (r100 < 0) goto L12;
        int r101 = this.size;
        if (r100 >= r101) goto L6;
        this.size = r100;
    L10:
        return this;
    L6:
        if (r100 <= r101) goto L10;
        ensureCapacity(r100);
        int r102 = this.size;
        this.size = r100;
    L8:
        if (r102 >= r100) goto L10;
        this.buffer[r102] = 0;
        r102 = r102 + 1;
        goto L8
    L12:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public StrBuilder setNewLineText(String r100) {
        this.newLine = r100;
        return this;
    }

    public StrBuilder setNullText(String r100) {
        if (r100 != null) goto L4;
    L6:
        this.nullText = r100;
        return this;
    L4:
        if (r100.isEmpty() == false) goto L6;
        r100 = null;
        goto L6
    }

    public boolean startsWith(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length();
        if (r101 != 0) goto L9;
        return true;
    L9:
        if (r101 <= this.size) goto L11;
        return false;
    L11:
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L17;
        if (this.buffer[r102] != r100.charAt(r102)) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public String substring(int r100) {
        return substring(r100, this.size);
    }

    public void validateIndex(int r100) {
        if (r100 < 0) goto L7;
        if (r100 > this.size) goto L7;
        return;
    L7:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public StrBuilder(int r100) {
        if (r100 > 0) goto L5;
        r100 = 32;
    L5:
        this.buffer = new char[r100];
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence r100) {
        if (r100 != null) goto L6;
        return appendNull();
    L6:
        if ((r100 instanceof StrBuilder) == false) goto L10;
        return append((StrBuilder) r100);
    L10:
        if ((r100 instanceof StringBuilder) == false) goto L14;
        return append((StringBuilder) r100);
    L14:
        if ((r100 instanceof StringBuffer) == false) goto L18;
        return append((StringBuffer) r100);
    L18:
        if ((r100 instanceof CharBuffer) == false) goto L22;
        return append((CharBuffer) r100);
    L22:
        return append(r100.toString());
    }

    public <T> StrBuilder appendAll(T... r100) {
        if (r100 != null) goto L4;
    L8:
        return this;
    L4:
        if (r100.length <= 0) goto L8;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        append(r100[r102]);
        r102 = r102 + 1;
        goto L6
    }

    public StrBuilder appendSeparator(String r100) {
        return appendSeparator(r100, null);
    }

    public StrBuilder appendln(double r100) {
        return append(r100).appendNewLine();
    }

    public boolean contains(String r100) {
        if (indexOf(r100, 0) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public StrBuilder deleteAll(String r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        if (r101 <= 0) goto L10;
        int r102 = indexOf(r100, 0);
    L8:
        if (r102 < 0) goto L10;
        deleteImpl(r102, r102 + r101, r101);
        r102 = indexOf(r100, r102);
    L10:
        return this;
    L5:
        r101 = r100.length();
        goto L6
    }

    public StrBuilder deleteFirst(char r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L9;
        if (this.buffer[r101] == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        deleteImpl(r101, r101 + 1, 1);
    L9:
        return this;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof StrBuilder) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals((StrBuilder) r100) == false) goto L7;
        return true;
    }

    public int indexOf(String r100) {
        return indexOf(r100, 0);
    }

    public int lastIndexOf(String r100) {
        return lastIndexOf(r100, this.size - 1);
    }

    public StrBuilder append(CharBuffer r100) {
        if (r100 != null) goto L6;
        return appendNull();
    L6:
        if (r100.hasArray() == false) goto L8;
        int r101 = r100.remaining();
        int r102 = length();
        ensureCapacity(r102 + r101);
        System.arraycopy(r100.array(), r100.arrayOffset() + r100.position(), this.buffer, r102, r101);
        this.size += r101;
    L9:
        return this;
    L8:
        append(r100.toString());
        goto L9
    }

    public StrBuilder appendAll(Iterator<?> r100) {
        if (r100 != null) goto L4;
    L6:
        return this;
    L4:
        if (r100.hasNext() == false) goto L6;
        append(r100.next());
        goto L4
    }

    public StrBuilder appendln(float r100) {
        return append(r100).appendNewLine();
    }

    public boolean contains(StrMatcher r100) {
        if (indexOf(r100, 0) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public StrBuilder deleteAll(StrMatcher r100) {
        return replace(r100, null, 0, this.size, -1);
    }

    public StrBuilder deleteFirst(StrMatcher r100) {
        return replace(r100, null, 0, this.size, 1);
    }

    public int indexOf(StrMatcher r100) {
        return indexOf(r100, 0);
    }

    public int lastIndexOf(StrMatcher r100) {
        return lastIndexOf(r100, this.size);
    }

    public StrBuilder append(StrBuilder r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length();
        if (r101 <= 0) goto L8;
        int r102 = length();
        ensureCapacity(r102 + r101);
        System.arraycopy(r100.buffer, 0, this.buffer, r102, r101);
        this.size += r101;
    L8:
        return this;
    L4:
        return appendNull();
    }

    public StrBuilder appendln(int r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(String r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length();
        if (r101 <= 0) goto L8;
        int r102 = length();
        ensureCapacity(r102 + r101);
        r100.getChars(0, r101, this.buffer, r102);
        this.size += r101;
    L8:
        return this;
    L4:
        return appendNull();
    }

    public StrBuilder appendln(long r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(StringBuffer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length();
        if (r101 <= 0) goto L8;
        int r102 = length();
        ensureCapacity(r102 + r101);
        r100.getChars(0, r101, this.buffer, r102);
        this.size += r101;
    L8:
        return this;
    L4:
        return appendNull();
    }

    public StrBuilder appendln(Object r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(StringBuilder r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length();
        if (r101 <= 0) goto L8;
        int r102 = length();
        ensureCapacity(r102 + r101);
        r100.getChars(0, r101, this.buffer, r102);
        this.size += r101;
    L8:
        return this;
    L4:
        return appendNull();
    }

    public StrBuilder appendln(String r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(char[] r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length;
        if (r101 <= 0) goto L8;
        int r102 = length();
        ensureCapacity(r102 + r101);
        System.arraycopy(r100, 0, this.buffer, r102, r101);
        this.size += r101;
    L8:
        return this;
    L4:
        return appendNull();
    }

    public StrBuilder appendln(StringBuffer r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(Object r100) {
        if (r100 != null) goto L6;
        return appendNull();
    L6:
        if ((r100 instanceof CharSequence) == false) goto L10;
        return append((CharSequence) r100);
    L10:
        return append(r100.toString());
    }

    public StrBuilder appendln(StringBuilder r100) {
        return append(r100).appendNewLine();
    }

    @Override // java.lang.Appendable
    public StrBuilder append(char r100) {
        ensureCapacity(length() + 1);
        char[] r101 = this.buffer;
        int r102 = this.size;
        this.size = r102 + 1;
        r101[r102] = r100;
        return this;
    }

    public StrBuilder appendln(StrBuilder r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(double r100) {
        return append(String.valueOf(r100));
    }

    public StrBuilder appendln(boolean r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(float r100) {
        return append(String.valueOf(r100));
    }

    public StrBuilder appendln(char[] r100) {
        return append(r100).appendNewLine();
    }

    public StrBuilder append(int r100) {
        return append(String.valueOf(r100));
    }

    public StrBuilder append(long r100) {
        return append(String.valueOf(r100));
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r100) throws IOException {
        return append(r100);
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        return append(r100);
    }

    public StrBuilder append(String r100, Object... r101) {
        return append(String.format(r100, r101));
    }

    public StrBuilder appendPadding(int r100, char r101) {
        if (r100 < 0) goto L6;
        ensureCapacity(this.size + r100);
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L6;
        char[] r103 = this.buffer;
        int r104 = this.size;
        this.size = r104 + 1;
        r103[r104] = r101;
        r102 = r102 + 1;
    L6:
        return this;
    }

    public StrBuilder appendSeparator(char r100, char r101) {
        if (size() <= 0) goto L5;
        append(r100);
    L6:
        return this;
    L5:
        append(r101);
        goto L6
    }

    public StrBuilder appendWithSeparators(Iterable<?> r100, String r101) {
        if (r100 == null) goto L9;
        String r102 = Objects.toString(r101, "");
        Iterator<?> r103 = r100.iterator();
    L5:
        if (r103.hasNext() == false) goto L9;
        append(r103.next());
        if (r103.hasNext() == false) goto L5;
        append(r102);
    L9:
        return this;
    }

    public StrBuilder appendln(String r100, Object... r101) {
        return append(r100, r101).appendNewLine();
    }

    public StrBuilder delete(int r100, int r101) {
        int r102 = validateRange(r100, r101);
        int r103 = r102 - r100;
        if (r103 <= 0) goto L5;
        deleteImpl(r100, r102, r103);
    L5:
        return this;
    }

    public int indexOf(String r100, int r110) {
        if (r110 >= 0) goto L6;
        r110 = 0;
    L6:
        if (r100 != null) goto L8;
    L28:
        return -1;
    L8:
        if (r110 >= this.size) goto L28;
        int r101 = r100.length();
        if (r101 == 1) goto L13;
        if (r101 != 0) goto L16;
        return r110;
    L16:
        int r102 = this.size;
        if (r101 <= r102) goto L19;
        return -1;
    L19:
        char[] r103 = this.buffer;
        int r104 = (r102 - r101) + 1;
    L20:
        if (r110 >= r104) goto L28;
        int r105 = 0;
    L22:
        if (r105 >= r101) goto L27;
        if (r100.charAt(r105) != r103[r110 + r105]) goto L25;
        r105 = r105 + 1;
        goto L22
    L25:
        r110 = r110 + 1;
        goto L20
    L27:
        return r110;
    L13:
        return indexOf(r100.charAt(0), r110);
    }

    public StrBuilder insert(int r100, boolean r101) {
        validateIndex(r100);
        if (r101 == false) goto L5;
        ensureCapacity(this.size + 4);
        char[] r102 = this.buffer;
        System.arraycopy(r102, r100, r102, r100 + 4, this.size - r100);
        char[] r103 = this.buffer;
        int r104 = r100 + 1;
        r103[r100] = OthersPermission.STICKY_E;
        int r105 = r104 + 1;
        r103[r104] = Permission.READ;
        r103[r105] = 'u';
        r103[r105 + 1] = 'e';
        this.size += 4;
    L6:
        return this;
    L5:
        ensureCapacity(this.size + 5);
        char[] r106 = this.buffer;
        System.arraycopy(r106, r100, r106, r100 + 5, this.size - r100);
        char[] r107 = this.buffer;
        int r108 = r100 + 1;
        r107[r100] = 'f';
        int r109 = r108 + 1;
        r107[r108] = 'a';
        int r110 = r109 + 1;
        r107[r109] = Symlink.UNIX_ID;
        r107[r110] = 's';
        r107[r110 + 1] = 'e';
        this.size += 5;
        goto L6
    }

    public int lastIndexOf(String r100, int r101) {
        int r102 = this.size;
        if (r101 < r102) goto L6;
        r101 = r102 - 1;
    L6:
        if (r100 == null) goto L28;
        if (r101 < 0) goto L28;
        int r103 = r100.length();
        if (r103 > 0) goto L12;
    L26:
        if (r103 != 0) goto L28;
        return r101;
    L12:
        if (r103 > this.size) goto L26;
        if (r103 == 1) goto L16;
        int r104 = (r101 - r103) + 1;
    L18:
        if (r104 < 0) goto L28;
        int r105 = 0;
    L20:
        if (r105 >= r103) goto L25;
        if (r100.charAt(r105) != this.buffer[r104 + r105]) goto L23;
        r105 = r105 + 1;
        goto L20
    L23:
        r104 = r104 - 1;
        goto L18
    L25:
        return r104;
    L16:
        return lastIndexOf(r100.charAt(0), r101);
    L28:
        return -1;
    }

    public String midString(int r100, int r101) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        if (r101 <= 0) goto L14;
        int r102 = this.size;
        if (r100 < r102) goto L9;
        return "";
    L9:
        if (r102 > (r100 + r101)) goto L13;
        return new String(this.buffer, r100, r102 - r100);
    L13:
        return new String(this.buffer, r100, r101);
    L14:
        return "";
    }

    public StrBuilder replaceAll(String r110, String r111) {
        if (r110 != null) goto L5;
        int r100 = 0;
    L6:
        if (r100 <= 0) goto L13;
        if (r111 != null) goto L9;
        int r101 = 0;
    L10:
        int r102 = indexOf(r110, 0);
    L11:
        if (r102 < 0) goto L13;
        int r103 = r102;
        replaceImpl(r103, r102 + r100, r100, r111, r101);
        r102 = indexOf(r110, r102 + r101);
        goto L11
    L9:
        r101 = r111.length();
    L13:
        return this;
    L5:
        r100 = r110.length();
        goto L6
    }

    public StrBuilder replaceFirst(String r100, String r110) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        if (r101 <= 0) goto L13;
        int r102 = indexOf(r100, 0);
        if (r102 < 0) goto L13;
        if (r110 != null) goto L11;
        int r103 = 0;
    L12:
        replaceImpl(r102, r102 + r101, r101, r110, r103);
        goto L13
    L11:
        r103 = r110.length();
    L13:
        return this;
    L5:
        r101 = r100.length();
        goto L6
    }

    public StrBuilder setCharAt(int r100, char r101) {
        if (r100 < 0) goto L8;
        if (r100 >= length()) goto L8;
        this.buffer[r100] = r101;
        return this;
    L8:
        throw new StringIndexOutOfBoundsException(r100);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        if (r100 < 0) goto L13;
        if (r101 > this.size) goto L11;
        if (r100 > r101) goto L9;
        return substring(r100, r101);
    L9:
        throw new StringIndexOutOfBoundsException(r101 - r100);
    L11:
        throw new StringIndexOutOfBoundsException(r101);
    L13:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public String substring(int r100, int r101) {
        int r102 = validateRange(r100, r101);
        return new String(this.buffer, r100, r102 - r100);
    }

    public char[] toCharArray(int r100, int r101) {
        int r102 = validateRange(r100, r101) - r100;
        if (r102 == 0) goto L5;
        char[] r103 = new char[r102];
        System.arraycopy(this.buffer, r100, r103, 0, r102);
        return r103;
    L5:
        return ArrayUtils.EMPTY_CHAR_ARRAY;
    }

    public int validateRange(int r100, int r101) {
        if (r100 < 0) goto L11;
        int r102 = this.size;
        if (r101 <= r102) goto L6;
        r101 = r102;
    L6:
        if (r100 > r101) goto L9;
        return r101;
    L9:
        throw new StringIndexOutOfBoundsException("end < start");
    L11:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public StrBuilder appendSeparator(String r100, String r101) {
        if (isEmpty() == false) goto L5;
        r100 = r101;
    L5:
        if (r100 == null) goto L7;
        append(r100);
    L7:
        return this;
    }

    public StrBuilder appendWithSeparators(Object[] r100, String r101) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.length <= 0) goto L9;
        String r102 = Objects.toString(r101, "");
        append(r100[0]);
        int r103 = 1;
    L7:
        if (r103 >= r100.length) goto L9;
        append(r102);
        append(r100[r103]);
        r103 = r103 + 1;
        goto L7
    }

    public int indexOf(StrMatcher r100, int r101) {
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        if (r100 == null) goto L15;
        int r102 = this.size;
        if (r101 >= r102) goto L15;
        char[] r103 = this.buffer;
        int r104 = r101;
    L10:
        if (r104 >= r102) goto L15;
        if (r100.isMatch(r103, r104, r101, r102) > 0) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return r104;
    L15:
        return -1;
    }

    public StrBuilder insert(int r100, char[] r101) {
        validateIndex(r100);
        if (r101 == null) goto L5;
        int r102 = r101.length;
        if (r102 <= 0) goto L9;
        ensureCapacity(this.size + r102);
        char[] r103 = this.buffer;
        System.arraycopy(r103, r100, r103, r100 + r102, this.size - r100);
        System.arraycopy(r101, 0, this.buffer, r100, r102);
        this.size += r102;
    L9:
        return this;
    L5:
        return insert(r100, this.nullText);
    }

    public int lastIndexOf(StrMatcher r100, int r101) {
        int r102 = this.size;
        if (r101 < r102) goto L6;
        r101 = r102 - 1;
    L6:
        if (r100 == null) goto L15;
        if (r101 < 0) goto L15;
        char[] r103 = this.buffer;
        int r104 = r101 + 1;
    L10:
        if (r101 < 0) goto L15;
        if (r100.isMatch(r103, r101, 0, r104) > 0) goto L13;
        r101 = r101 - 1;
        goto L10
    L13:
        return r101;
    L15:
        return -1;
    }

    public StrBuilder replaceAll(char r100, char r101) {
        if (r100 == r101) goto L10;
        int r102 = 0;
    L5:
        if (r102 >= this.size) goto L10;
        char[] r103 = this.buffer;
        if (r103[r102] != r100) goto L9;
        r103[r102] = r101;
    L9:
        r102 = r102 + 1;
    L10:
        return this;
    }

    public StrBuilder replaceFirst(char r100, char r101) {
        if (r100 == r101) goto L10;
        int r102 = 0;
    L5:
        if (r102 >= this.size) goto L10;
        char[] r103 = this.buffer;
        if (r103[r102] == r100) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        r103[r102] = r101;
    L10:
        return this;
    }

    public StrBuilder appendSeparator(String r100, int r101) {
        if (r100 == null) goto L5;
        if (r101 <= 0) goto L5;
        append(r100);
    L5:
        return this;
    }

    public StrBuilder appendWithSeparators(Iterator<?> r100, String r101) {
        if (r100 == null) goto L9;
        String r102 = Objects.toString(r101, "");
    L5:
        if (r100.hasNext() == false) goto L9;
        append(r100.next());
        if (r100.hasNext() == false) goto L5;
        append(r102);
    L9:
        return this;
    }

    public int indexOf(char r100, int r101) {
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        if (r101 < this.size) goto L7;
        return -1;
    L7:
        char[] r102 = this.buffer;
    L9:
        if (r101 >= this.size) goto L14;
        if (r102[r101] == r100) goto L12;
        r101 = r101 + 1;
        goto L9
    L12:
        return r101;
    L14:
        return -1;
    }

    public StrBuilder insert(int r100, String r101) {
        validateIndex(r100);
        if (r101 != null) goto L5;
        r101 = this.nullText;
    L5:
        if (r101 == null) goto L9;
        int r102 = r101.length();
        if (r102 <= 0) goto L9;
        int r103 = this.size + r102;
        ensureCapacity(r103);
        char[] r104 = this.buffer;
        System.arraycopy(r104, r100, r104, r100 + r102, this.size - r100);
        this.size = r103;
        r101.getChars(0, r102, this.buffer, r100);
    L9:
        return this;
    }

    public int lastIndexOf(char r100, int r101) {
        int r102 = this.size;
        if (r101 < r102) goto L6;
        r101 = r102 - 1;
    L6:
        if (r101 >= 0) goto L8;
        return -1;
    L8:
        if (r101 < 0) goto L13;
        if (this.buffer[r101] == r100) goto L11;
        r101 = r101 - 1;
        goto L8
    L11:
        return r101;
    L13:
        return -1;
    }

    public StrBuilder replaceAll(StrMatcher r100, String r101) {
        return replace(r100, r101, 0, this.size, -1);
    }

    public StrBuilder replaceFirst(StrMatcher r100, String r101) {
        return replace(r100, r101, 0, this.size, 1);
    }

    public StrBuilder appendSeparator(char r100, int r101) {
        if (r101 <= 0) goto L4;
        append(r100);
    L4:
        return this;
    }

    public StrBuilder insert(int r100, char r101) {
        validateIndex(r100);
        ensureCapacity(this.size + 1);
        char[] r102 = this.buffer;
        System.arraycopy(r102, r100, r102, r100 + 1, this.size - r100);
        this.buffer[r100] = r101;
        this.size++;
        return this;
    }

    public StrBuilder insert(int r100, Object r101) {
        if (r101 != null) goto L6;
        return insert(r100, this.nullText);
    L6:
        return insert(r100, r101.toString());
    }

    public StrBuilder insert(int r100, double r101) {
        return insert(r100, String.valueOf(r101));
    }

    public StrBuilder insert(int r100, float r101) {
        return insert(r100, String.valueOf(r101));
    }

    public StrBuilder insert(int r100, int r101) {
        return insert(r100, String.valueOf(r101));
    }

    public StrBuilder insert(int r100, long r101) {
        return insert(r100, String.valueOf(r101));
    }

    private void deleteImpl(int r100, int r101, int r102) {
        char[] r103 = this.buffer;
        System.arraycopy(r103, r101, r103, r100, this.size - r101);
        this.size -= r102;
    }

    public StrBuilder append(CharBuffer r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return appendNull();
    L6:
        if (r100.hasArray() == false) goto L18;
        int r103 = r100.remaining();
        if (r101 < 0) goto L17;
        if (r101 > r103) goto L17;
        if (r102 < 0) goto L15;
        if ((r101 + r102) > r103) goto L15;
        int r104 = length();
        ensureCapacity(r104 + r102);
        System.arraycopy(r100.array(), (r100.arrayOffset() + r100.position()) + r101, this.buffer, r104, r102);
        this.size += r102;
    L19:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("length must be valid");
    L17:
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    L18:
        append(r100.toString(), r101, r102);
        goto L19
    }

    public StrBuilder appendFixedWidthPadLeft(Object r100, int r101, char r102) {
        if (r101 <= 0) goto L17;
        ensureCapacity(this.size + r101);
        if (r100 != null) goto L6;
        String r103 = getNullText();
    L7:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        int r104 = r103.length();
        if (r104 < r101) goto L12;
        r103.getChars(r104 - r101, r104, this.buffer, this.size);
    L16:
        this.size += r101;
        goto L17
    L12:
        int r105 = r101 - r104;
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L15;
        this.buffer[this.size + r106] = r102;
        r106 = r106 + 1;
        goto L13
    L15:
        r103.getChars(0, r104, this.buffer, this.size + r105);
        goto L16
    L6:
        r103 = r100.toString();
    L17:
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object r100, int r101, char r102) {
        if (r101 <= 0) goto L16;
        ensureCapacity(this.size + r101);
        if (r100 != null) goto L6;
        String r103 = getNullText();
    L7:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        int r104 = r103.length();
        int r105 = 0;
        if (r104 < r101) goto L12;
        r103.getChars(0, r101, this.buffer, this.size);
    L15:
        this.size += r101;
        goto L16
    L12:
        int r106 = r101 - r104;
        r103.getChars(0, r104, this.buffer, this.size);
    L13:
        if (r105 >= r106) goto L15;
        this.buffer[(this.size + r104) + r105] = r102;
        r105 = r105 + 1;
        goto L13
    L6:
        r103 = r100.toString();
    L16:
        return this;
    }

    public StrBuilder appendln(String r100, int r101, int r102) {
        return append(r100, r101, r102).appendNewLine();
    }

    public StrBuilder replace(int r100, int r101, String r102) {
        int r103 = validateRange(r100, r101);
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        replaceImpl(r100, r103, r103 - r100, r102, r104);
        return this;
    L5:
        r104 = r102.length();
        goto L6
    }

    public StrBuilder append(char[] r100, int r101, int r102) {
        if (r100 == null) goto L4;
        if (r101 < 0) goto L17;
        if (r101 > r100.length) goto L17;
        if (r102 < 0) goto L15;
        if ((r101 + r102) > r100.length) goto L15;
        if (r102 <= 0) goto L13;
        int r103 = length();
        ensureCapacity(r103 + r102);
        System.arraycopy(r100, r101, this.buffer, r103, r102);
        this.size += r102;
    L13:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("Invalid length: " + r102);
    L17:
        throw new StringIndexOutOfBoundsException("Invalid startIndex: " + r102);
    L4:
        return appendNull();
    }

    public StrBuilder appendFixedWidthPadLeft(int r100, int r101, char r102) {
        return appendFixedWidthPadLeft(String.valueOf(r100), r101, r102);
    }

    public StrBuilder appendFixedWidthPadRight(int r100, int r101, char r102) {
        return appendFixedWidthPadRight(String.valueOf(r100), r101, r102);
    }

    public StrBuilder appendln(StringBuffer r100, int r101, int r102) {
        return append(r100, r101, r102).appendNewLine();
    }

    public StrBuilder append(String r100, int r101, int r102) {
        if (r100 == null) goto L4;
        if (r101 < 0) goto L17;
        if (r101 > r100.length()) goto L17;
        if (r102 < 0) goto L15;
        int r103 = r101 + r102;
        if (r103 > r100.length()) goto L15;
        if (r102 <= 0) goto L13;
        int r104 = length();
        ensureCapacity(r104 + r102);
        r100.getChars(r101, r103, this.buffer, r104);
        this.size += r102;
    L13:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("length must be valid");
    L17:
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    L4:
        return appendNull();
    }

    public StrBuilder appendln(StringBuilder r100, int r101, int r102) {
        return append(r100, r101, r102).appendNewLine();
    }

    public StrBuilder append(StringBuffer r100, int r101, int r102) {
        if (r100 == null) goto L4;
        if (r101 < 0) goto L17;
        if (r101 > r100.length()) goto L17;
        if (r102 < 0) goto L15;
        int r103 = r101 + r102;
        if (r103 > r100.length()) goto L15;
        if (r102 <= 0) goto L13;
        int r104 = length();
        ensureCapacity(r104 + r102);
        r100.getChars(r101, r103, this.buffer, r104);
        this.size += r102;
    L13:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("length must be valid");
    L17:
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    L4:
        return appendNull();
    }

    public StrBuilder appendln(StrBuilder r100, int r101, int r102) {
        return append(r100, r101, r102).appendNewLine();
    }

    public StrBuilder append(StringBuilder r100, int r101, int r102) {
        if (r100 == null) goto L4;
        if (r101 < 0) goto L17;
        if (r101 > r100.length()) goto L17;
        if (r102 < 0) goto L15;
        int r103 = r101 + r102;
        if (r103 > r100.length()) goto L15;
        if (r102 <= 0) goto L13;
        int r104 = length();
        ensureCapacity(r104 + r102);
        r100.getChars(r101, r103, this.buffer, r104);
        this.size += r102;
    L13:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("length must be valid");
    L17:
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    L4:
        return appendNull();
    }

    public StrBuilder appendln(char[] r100, int r101, int r102) {
        return append(r100, r101, r102).appendNewLine();
    }

    public StrBuilder append(StrBuilder r100, int r101, int r102) {
        if (r100 == null) goto L4;
        if (r101 < 0) goto L17;
        if (r101 > r100.length()) goto L17;
        if (r102 < 0) goto L15;
        int r103 = r101 + r102;
        if (r103 > r100.length()) goto L15;
        if (r102 <= 0) goto L13;
        int r104 = length();
        ensureCapacity(r104 + r102);
        r100.getChars(r101, r103, this.buffer, r104);
        this.size += r102;
    L13:
        return this;
    L15:
        throw new StringIndexOutOfBoundsException("length must be valid");
    L17:
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    L4:
        return appendNull();
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return appendNull();
    L6:
        return append(r100.toString(), r101, r102);
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
        return append(r100, r101, r102);
    }

    public void getChars(int r100, int r101, char[] r102, int r103) {
        if (r100 < 0) goto L14;
        if (r101 < 0) goto L12;
        if (r101 > length()) goto L12;
        if (r100 > r101) goto L10;
        System.arraycopy(this.buffer, r100, r102, r103, r101 - r100);
        return;
    L10:
        throw new StringIndexOutOfBoundsException("end < start");
    L12:
        throw new StringIndexOutOfBoundsException(r101);
    L14:
        throw new StringIndexOutOfBoundsException(r100);
    }

    public StrBuilder insert(int r100, char[] r101, int r102, int r103) {
        validateIndex(r100);
        if (r101 == null) goto L5;
        if (r102 < 0) goto L18;
        if (r102 > r101.length) goto L18;
        if (r103 < 0) goto L16;
        if ((r102 + r103) > r101.length) goto L16;
        if (r103 <= 0) goto L14;
        ensureCapacity(this.size + r103);
        char[] r104 = this.buffer;
        System.arraycopy(r104, r100, r104, r100 + r103, this.size - r100);
        System.arraycopy(r101, r102, this.buffer, r100, r103);
        this.size += r103;
    L14:
        return this;
    L16:
        throw new StringIndexOutOfBoundsException("Invalid length: " + r103);
    L18:
        throw new StringIndexOutOfBoundsException("Invalid offset: " + r102);
    L5:
        return insert(r100, this.nullText);
    }

    private StrBuilder replaceImpl(StrMatcher r110, String r111, int r112, int r113, int r114) {
        if (r110 != null) goto L4;
    L18:
        return this;
    L4:
        if (this.size == 0) goto L18;
        if (r111 != null) goto L8;
        int r100 = 0;
    L9:
        int r101 = r112;
    L10:
        if (r101 >= r113) goto L18;
        if (r114 == 0) goto L18;
        int r102 = r110.isMatch(this.buffer, r101, r112, r113);
        if (r102 <= 0) goto L17;
        replaceImpl(r101, r101 + r102, r102, r111, r100);
        r113 = (r113 - r102) + r100;
        r101 = (r101 + r100) - 1;
        if (r114 <= 0) goto L17;
        r114 = r114 - 1;
    L17:
        r101 = r101 + 1;
        goto L10
    L8:
        r100 = r111.length();
        goto L9
    }

    public StrBuilder replace(StrMatcher r100, String r101, int r102, int r110, int r111) {
        return replaceImpl(r100, r101, r102, validateRange(r102, r110), r111);
    }

    private void replaceImpl(int r100, int r101, int r102, String r103, int r104) {
        int r105 = (this.size - r102) + r104;
        if (r104 == r102) goto L5;
        ensureCapacity(r105);
        char[] r106 = this.buffer;
        System.arraycopy(r106, r101, r106, r100 + r104, this.size - r101);
        this.size = r105;
    L5:
        if (r104 <= 0) goto L8;
        r103.getChars(0, r104, this.buffer, r100);
        return;
    }
}
