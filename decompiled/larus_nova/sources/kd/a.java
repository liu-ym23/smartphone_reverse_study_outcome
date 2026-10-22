package kd;

import androidx.camera.video.AudioStats;
import com.bytedance.android.common.sonic.SonicJsonParser;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends JsonReader {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C6539a f502693o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonToken[] f502694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f502695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f502696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double[] f502697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[][] f502698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f502699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f502700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f502701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f502702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f502703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f502704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f502705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f502706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f502707n;

    /* JADX INFO: renamed from: kd.a$a, reason: collision with other inner class name */
    public class C6539a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            throw new AssertionError();
        }

        public C6539a() {
        }

        @Override // java.io.Reader
        public final int read(char[] r100, int r101, int r102) throws IOException {
            throw new AssertionError();
        }
    }

    public class b extends JsonReaderInternalAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonReaderInternalAccess f502708a;

        public b() {
            this.f502708a = JsonReaderInternalAccess.INSTANCE;
        }

        @Override // com.google.gson.internal.JsonReaderInternalAccess
        public final void promoteNameToValue(JsonReader r100) throws IOException {
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            r101.b();
            r101.f502695b[r101.f502700g] = 5;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw new IllegalStateException("json: [" + r101.f502706m + "]", th);
        L10:
            this.f502708a.promoteNameToValue(r100);
        }
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.gson.stream.JsonReader
    public final String getPath() {
        return "";
    }

    static {
        f502693o = new C6539a();
        JsonReaderInternalAccess.INSTANCE = new b();
    }

    public final void b() throws IOException {
        boolean r100 = false;
        if (this.f502707n.compareAndSet(false, true) == false) goto L21;
        int r101 = this.f502705l;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L20;
        return;
    L20:
        throw null;
    L22:
        Object[] r102 = SonicJsonParser.processTokens(this.f502706m, false);     // Catch: Throwable -> L14
        byte[] r103 = (byte[]) r102[0];     // Catch: Throwable -> L14
        this.f502695b = r103;     // Catch: Throwable -> L14
        this.f502696c = (long[]) r102[1];     // Catch: Throwable -> L14
        this.f502697d = (double[]) r102[2];     // Catch: Throwable -> L14
        this.f502698e = (String[][]) r102[3];     // Catch: Throwable -> L14
        this.f502699f = (int[]) r102[4];     // Catch: Throwable -> L14
        this.f502700g = 0;     // Catch: Throwable -> L14
        this.f502701h = 0;     // Catch: Throwable -> L14
        this.f502702i = 0;     // Catch: Throwable -> L14
        this.f502703j = 0;     // Catch: Throwable -> L14
        if (r103.length == 1) goto L10;
    L12:
        this.f502704k = r100;     // Catch: Throwable -> L14
        return;
    L10:
        if (r103[0] != 11) goto L12;
        r100 = true;
    L14:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }

    @Override // com.google.gson.stream.JsonReader
    public final String nextString() throws IOException {
        b();
        byte[] r100 = this.f502695b;     // Catch: Throwable -> L20
        int r101 = this.f502700g;     // Catch: Throwable -> L20
        this.f502700g = r101 + 1;     // Catch: Throwable -> L20
        byte r102 = r100[r101];     // Catch: Throwable -> L20
        if (r102 != 4) goto L6;
    L18:
        int[] r103 = this.f502699f;     // Catch: Throwable -> L20
        int r104 = this.f502703j;     // Catch: Throwable -> L20
        this.f502703j = r104 + 1;     // Catch: Throwable -> L20
        return c(r103[r104]);
    L6:
        if (r102 == 5) goto L18;
        if (r102 != 6) goto L13;
        long[] r105 = this.f502696c;     // Catch: Throwable -> L20
        int r106 = this.f502701h;     // Catch: Throwable -> L20
        this.f502701h = r106 + 1;     // Catch: Throwable -> L20
        return Long.toString(r105[r106]);
    L13:
        if (r102 != 7) goto L17;
        double[] r107 = this.f502697d;     // Catch: Throwable -> L20
        int r108 = this.f502702i;     // Catch: Throwable -> L20
        this.f502702i = r108 + 1;     // Catch: Throwable -> L20
        return Double.toString(r107[r108]);
    L17:
        throw new IllegalStateException("Expected a string but was " + this.f502694a[this.f502695b[this.f502700g]]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }

    @Override // com.google.gson.stream.JsonReader
    public final void beginArray() throws IOException {
        b();
        a(JsonToken.BEGIN_ARRAY);
        this.f502700g++;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void beginObject() throws IOException {
        b();
        a(JsonToken.BEGIN_OBJECT);
        this.f502700g++;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void endArray() throws IOException {
        b();
        a(JsonToken.END_ARRAY);
        this.f502700g++;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void endObject() throws IOException {
        b();
        a(JsonToken.END_OBJECT);
        this.f502700g++;
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean hasNext() throws IOException {
        b();
        byte r100 = this.f502695b[this.f502700g];     // Catch: Throwable -> L11
        if (r100 != 1) goto L7;
    L9:
        return false;
    L7:
        if (r100 == 3) goto L9;
        return true;
    L11:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean nextBoolean() throws IOException {
        b();
        a(JsonToken.BOOLEAN);
        byte[] r100 = this.f502695b;     // Catch: Throwable -> L31
        int r101 = this.f502700g;     // Catch: Throwable -> L31
        this.f502700g = r101 + 1;     // Catch: Throwable -> L31
        byte r102 = r100[r101];     // Catch: Throwable -> L31
        if (r102 != 8) goto L7;
        return true;
    L7:
        if (r102 != 9) goto L10;
        return false;
    L10:
        if (r102 != 6) goto L17;
        long[] r103 = this.f502696c;     // Catch: Throwable -> L31
        int r104 = this.f502701h;     // Catch: Throwable -> L31
        this.f502701h = r104 + 1;     // Catch: Throwable -> L31
        if (r103[r104] != 0) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r102 != 4) goto L19;
    L29:
        int[] r105 = this.f502699f;     // Catch: Throwable -> L31
        int r106 = this.f502703j;     // Catch: Throwable -> L31
        this.f502703j = r106 + 1;     // Catch: Throwable -> L31
        return c(r105[r106]).toLowerCase().equals("true");
    L19:
        if (r102 == 5) goto L29;
        if (r102 != 7) goto L28;
        double[] r107 = this.f502697d;     // Catch: Throwable -> L31
        int r108 = this.f502702i;     // Catch: Throwable -> L31
        this.f502702i = r108 + 1;     // Catch: Throwable -> L31
        if (r107[r108] != AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        return false;
    L36:
        return true;
    L28:
        return false;
    L31:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }

    @Override // com.google.gson.stream.JsonReader
    public final double nextDouble() throws IOException {
        b();
        byte[] r100 = this.f502695b;
        int r101 = this.f502700g;
        this.f502700g = r101 + 1;
        byte r102 = r100[r101];
        if (r102 != 7) goto L7;
        double[] r103 = this.f502697d;
        int r104 = this.f502702i;
        this.f502702i = r104 + 1;
        return r103[r104];
    L7:
        if (r102 != 6) goto L11;
        long[] r105 = this.f502696c;
        int r106 = this.f502701h;
        this.f502701h = r106 + 1;
        return r105[r106];
    L11:
        if (r102 != 5) goto L13;
    L21:
        int[] r107 = this.f502699f;
        int r108 = this.f502703j;
        this.f502703j = r108 + 1;
        return CastDoubleProtector.parseDouble(c(r107[r108]));
    L13:
        if (r102 == 4) goto L21;
        if (r102 != 8) goto L20;
        throw new IllegalStateException("Expected a double but was true");
    L20:
        throw new IllegalStateException("Expected a double but was false");
    }

    @Override // com.google.gson.stream.JsonReader
    public final int nextInt() throws IOException {
        b();
        byte[] r100 = this.f502695b;
        int r101 = this.f502700g;
        this.f502700g = r101 + 1;
        byte r102 = r100[r101];
        if (r102 != 6) goto L10;
        long[] r103 = this.f502696c;
        int r104 = this.f502701h;
        this.f502701h = r104 + 1;
        long r105 = r103[r104];
        int r106 = (int) r105;
        if (r106 != r105) goto L8;
        return r106;
    L8:
        throw new NumberFormatException("Expected an int but was " + r105);
    L10:
        if (r102 != 5) goto L12;
    L27:
        int[] r107 = this.f502699f;
        int r108 = this.f502703j;
        this.f502703j = r108 + 1;
        String r109 = c(r107[r108]);
        return CastIntegerProtector.parseInt(r109);
    L31:
        throw new NumberFormatException("Expected an int but was " + r109);
    L12:
        if (r102 == 4) goto L27;
        if (r102 != 7) goto L22;
        double[] r110 = this.f502697d;
        int r111 = this.f502702i;
        this.f502702i = r111 + 1;
        double r112 = r110[r111];
        int r113 = (int) r112;
        if (r113 != r112) goto L20;
        return r113;
    L20:
        throw new NumberFormatException("Expected an int but was " + r112);
    L22:
        if (r102 != 8) goto L26;
        throw new IllegalStateException("Expected an int but was true");
    L26:
        throw new IllegalStateException("Expected an int but was false");
    }

    @Override // com.google.gson.stream.JsonReader
    public final long nextLong() throws IOException {
        b();
        byte[] r100 = this.f502695b;
        int r101 = this.f502700g;
        this.f502700g = r101 + 1;
        byte r102 = r100[r101];
        if (r102 != 6) goto L7;
        long[] r103 = this.f502696c;
        int r104 = this.f502701h;
        this.f502701h = r104 + 1;
        return r103[r104];
    L7:
        if (r102 != 5) goto L9;
    L24:
        int[] r105 = this.f502699f;
        int r106 = this.f502703j;
        this.f502703j = r106 + 1;
        String r107 = c(r105[r106]);
        return CastLongProtector.parseLong(r107);
    L28:
        throw new NumberFormatException("Expected a long but was " + r107);
    L9:
        if (r102 == 4) goto L24;
        if (r102 != 7) goto L19;
        double[] r108 = this.f502697d;
        int r109 = this.f502702i;
        this.f502702i = r109 + 1;
        double r110 = r108[r109];
        long r111 = (long) r110;
        if (r111 != r110) goto L17;
        return r111;
    L17:
        throw new NumberFormatException("Expected a long but was " + r110);
    L19:
        if (r102 != 8) goto L23;
        throw new IllegalStateException("Expected an long but was true");
    L23:
        throw new IllegalStateException("Expected an long but was false");
    }

    @Override // com.google.gson.stream.JsonReader
    public final String nextName() throws IOException {
        b();
        return nextString();
    }

    @Override // com.google.gson.stream.JsonReader
    public final void nextNull() throws IOException {
        b();
        this.f502700g++;
    }

    @Override // com.google.gson.stream.JsonReader
    public final JsonToken peek() throws IOException {
        b();
    L9:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    L4:
        if (this.f502704k == true) goto L8;
        return this.f502694a[this.f502695b[this.f502700g]];
    L8:
        throw new EOFException();     // Catch: Throwable -> L9
    }

    @Override // com.google.gson.stream.JsonReader
    public final void skipValue() throws IOException {
        b();
        int r100 = 0;
    L33:
        byte[] r101 = this.f502695b;     // Catch: Throwable -> L30
        int r102 = this.f502700g;     // Catch: Throwable -> L30
        this.f502700g = r102 + 1;     // Catch: Throwable -> L30
        byte r103 = r101[r102];     // Catch: Throwable -> L30
        if (r103 != 0) goto L6;
    L27:
        r100 = r100 + 1;
    L28:
        if (r100 > 0) goto L33;
        return;
    L6:
        if (r103 == 2) goto L27;
        if (r103 != 1) goto L11;
    L26:
        r100 = r100 - 1;
        goto L28
    L11:
        if (r103 == 3) goto L26;
        if (r103 != 4) goto L16;
    L24:
        this.f502703j++;     // Catch: Throwable -> L30
        goto L28
    L16:
        if (r103 == 5) goto L24;
        if (r103 != 6) goto L22;
        this.f502701h++;     // Catch: Throwable -> L30
        goto L28
    L22:
        if (r103 != 7) goto L28;
        this.f502702i++;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }

    public a(String r100) {
        super(f502693o);
        JsonToken r101 = JsonToken.NUMBER;
        JsonToken r102 = JsonToken.BOOLEAN;
        this.f502694a = new JsonToken[]{JsonToken.BEGIN_ARRAY, JsonToken.END_ARRAY, JsonToken.BEGIN_OBJECT, JsonToken.END_OBJECT, JsonToken.NAME, JsonToken.STRING, r101, r101, r102, r102, JsonToken.NULL, JsonToken.END_DOCUMENT};
        this.f502706m = null;
        this.f502707n = new AtomicBoolean(false);
        this.f502706m = r100;
        this.f502705l = 1;
    }

    public final void a(JsonToken r100) {
        if (r100 != this.f502694a[this.f502695b[this.f502700g]]) goto L6;
        return;
    L6:
        throw new IllegalStateException("type can not match " + r100);
    }

    public final String c(int r100) {
        return this.f502698e[32 - Integer.numberOfLeadingZeros(r100)][r100 ^ Integer.highestOneBit(r100)];
    L4:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.f502706m + "]", th);
    }
}
