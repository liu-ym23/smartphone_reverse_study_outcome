package okio;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", DBDefinition.SEGMENT_TABLE_NAME, "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", TTVideoEngineInterface.PLAY_API_KEY_BASE64, "", "base64Url", "copyInto", "", "offset", "", PickerReporterConstants.KEY.TARGET, "targetOffset", "byteCount", "digest", faceverify.q.KEY_ALGORITHM_CONFIG, "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", Argument.OUT, "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient byte[][] f523966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int[] f523967b;

    public final ByteString a() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString r100 = a();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.Object");
        return r100;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r100 = getHashCode$okio();
        if (r100 != 0) goto L15;
        int r101 = getSegments$okio().length;
        int r102 = 0;
        int r103 = 1;
        int r104 = 0;
    L6:
        if (r102 >= r101) goto L11;
        int r105 = getDirectory$okio()[r101 + r102];
        int r106 = getDirectory$okio()[r102];
        byte[] r107 = getSegments$okio()[r102];
        int r108 = (r106 - r104) + r105;
    L8:
        if (r105 >= r108) goto L10;
        r103 = (r103 * 31) + r107[r105];
        r105 = r105 + 1;
        goto L8
    L10:
        r102 = r102 + 1;
        r104 = r106;
        goto L6
    L11:
        setHashCode$okio(r103);
        return r103;
    L15:
        return r100;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] r100 = new byte[size()];
        int r101 = getSegments$okio().length;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r105 = getDirectory$okio()[r101 + r102];
        int r106 = getDirectory$okio()[r102];
        int r107 = r106 - r103;
        ArraysKt.copyInto(getSegments$okio()[r102], r100, r104, r105, r105 + r107);
        r104 = r104 + r107;
        r102 = r102 + 1;
        r103 = r106;
        goto L3
    L5:
        return r100;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    public final int[] getDirectory$okio() {
        return this.f523967b;
    }

    public final byte[][] getSegments$okio() {
        return this.f523966a;
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String r100) {
        Intrinsics.checkNotNullParameter(r100, faceverify.q.KEY_ALGORITHM_CONFIG);
        MessageDigest r101 = MessageDigest.getInstance(r100);
        int r102 = getSegments$okio().length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r105 = getDirectory$okio()[r102 + r103];
        int r106 = getDirectory$okio()[r103];
        r101.update(getSegments$okio()[r103], r105, r106 - r104);
        r103 = r103 + 1;
        r104 = r106;
        goto L3
    L5:
        byte[] r107 = r101.digest();
        Intrinsics.checkNotNull(r107);
        return new ByteString(r107);
    }

    @Override // okio.ByteString
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByteString) == false) goto L12;
        ByteString r101 = (ByteString) r100;
        if (r101.size() != size()) goto L12;
        if (rangeEquals(0, r101, 0, size()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int r100) {
        b.b(getDirectory$okio()[getSegments$okio().length - 1], r100, 1);
        int r101 = okio.internal.d.a(this, r100);
        if (r101 != 0) goto L5;
        int r102 = 0;
    L7:
        return getSegments$okio()[r101][(r100 - r102) + getDirectory$okio()[getSegments$okio().length + r101]];
    L5:
        r102 = getDirectory$okio()[r101 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public String string(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "charset");
        return a().string(r100);
    }

    @Override // okio.ByteString
    public void write(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        int r101 = getSegments$okio().length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r104 = getDirectory$okio()[r101 + r102];
        int r105 = getDirectory$okio()[r102];
        r100.write(getSegments$okio()[r102], r104, r105 - r103);
        r102 = r102 + 1;
        r103 = r105;
        goto L3
    }

    public SegmentedByteString(byte[][] r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r101, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.f523966a = r100;
        this.f523967b = r101;
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, faceverify.q.KEY_ALGORITHM_CONFIG);
        Intrinsics.checkNotNullParameter(r101, "key");
        Mac r102 = Mac.getInstance(r100);     // Catch: InvalidKeyException -> L8
        r102.init(new SecretKeySpec(r101.toByteArray(), r100));     // Catch: InvalidKeyException -> L8
        int r103 = getSegments$okio().length;     // Catch: InvalidKeyException -> L8
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r103) goto L6;
        int r106 = getDirectory$okio()[r103 + r104];     // Catch: InvalidKeyException -> L8
        int r107 = getDirectory$okio()[r104];     // Catch: InvalidKeyException -> L8
        r102.update(getSegments$okio()[r104], r106, r107 - r105);     // Catch: InvalidKeyException -> L8
        r104 = r104 + 1;     // Catch: InvalidKeyException -> L8
        r105 = r107;
        goto L4
    L6:
        return new ByteString(r102.doFinal());
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return a().indexOf(r100, r101);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return a().lastIndexOf(r100, r101);
    }

    @Override // okio.ByteString
    public ByteString substring(int r110, int r111) {
        int r112 = b.c(this, r111);
        int r100 = 0;
        if (r110 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L40;
        if (r112 > size()) goto L10;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L38;
        int r103 = r112 - r110;
        if (r103 < 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L36;
        if (r110 == 0) goto L20;
    L22:
        if (r110 == r112) goto L43;
        int r105 = okio.internal.d.a(this, r110);
        int r113 = okio.internal.d.a(this, r112 - 1);
        byte[][] r106 = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), r105, r113 + 1);
        int[] r107 = new int[r106.length * 2];
        if (r105 > r113) goto L30;
        int r108 = r105;
        int r109 = 0;
    L27:
        r107[r109] = Math.min(getDirectory$okio()[r108] - r110, r103);
        int r114 = r109 + 1;
        r107[r109 + r106.length] = getDirectory$okio()[getSegments$okio().length + r108];
        if (r108 == r113) goto L30;
        r108 = r108 + 1;
        r109 = r114;
    L30:
        if (r105 == 0) goto L33;
        r100 = getDirectory$okio()[r105 - 1];
    L33:
        int r115 = r106.length;
        r107[r115] = r107[r115] + (r110 - r100);
        return new SegmentedByteString(r106, r107);
    L43:
        return ByteString.EMPTY;
    L20:
        if (r112 != size()) goto L22;
        return this;
    L36:
        throw new IllegalArgumentException(("endIndex=" + r112 + " < beginIndex=" + r110).toString());
    L16:
        r104 = false;
        goto L17
    L38:
        throw new IllegalArgumentException(("endIndex=" + r112 + " > length(" + size() + ')').toString());
    L10:
        r102 = false;
        goto L12
    L40:
        throw new IllegalArgumentException(("beginIndex=" + r110 + " < 0").toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // okio.ByteString
    public void write$okio(Buffer r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "buffer");
        int r100 = r111 + r112;
        int r101 = okio.internal.d.a(this, r111);
    L3:
        if (r111 >= r100) goto L12;
        if (r101 != 0) goto L6;
        int r102 = 0;
    L7:
        int r103 = getDirectory$okio()[r101] - r102;
        int r104 = getDirectory$okio()[getSegments$okio().length + r101];
        int r105 = Math.min(r100, r103 + r102) - r111;
        int r106 = r104 + (r111 - r102);
        g0 r107 = new g0(getSegments$okio()[r101], r106, r106 + r105, true, false);
        g0 r108 = r110.head;
        if (r108 != null) goto L10;
        r107.f524023g = r107;
        r107.f524022f = r107;
        r110.head = r107;
    L11:
        r111 = r111 + r105;
        r101 = r101 + 1;
        goto L3
    L10:
        Intrinsics.checkNotNull(r108);
        g0 r109 = r108.f524023g;
        Intrinsics.checkNotNull(r109);
        r109.b(r107);
        goto L11
    L6:
        r102 = getDirectory$okio()[r101 - 1];
        goto L7
    L12:
        r110.setSize$okio(r110.size() + ((long) r112));
    }

    @Override // okio.ByteString
    public void copyInto(int r110, byte[] r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        long r100 = r113;
        b.b(size(), r110, r100);
        b.b(r111.length, r112, r100);
        int r114 = r113 + r110;
        int r101 = okio.internal.d.a(this, r110);
    L3:
        if (r110 >= r114) goto L8;
        if (r101 != 0) goto L6;
        int r102 = 0;
    L7:
        int r103 = getDirectory$okio()[r101] - r102;
        int r104 = getDirectory$okio()[getSegments$okio().length + r101];
        int r105 = Math.min(r114, r103 + r102) - r110;
        int r106 = r104 + (r110 - r102);
        ArraysKt.copyInto(getSegments$okio()[r101], r111, r112, r106, r106 + r105);
        r112 = r112 + r105;
        r110 = r110 + r105;
        r101 = r101 + 1;
        goto L3
    L6:
        r102 = getDirectory$okio()[r101 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r100, byte[] r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 > (size() - r110)) goto L24;
        if (r102 >= 0) goto L8;
        return false;
    L8:
        if (r102 > (r101.length - r110)) goto L26;
        int r111 = r110 + r100;
        int r103 = okio.internal.d.a(this, r100);
    L11:
        if (r100 >= r111) goto L19;
        if (r103 != 0) goto L14;
        int r104 = 0;
    L15:
        int r105 = getDirectory$okio()[r103] - r104;
        int r106 = getDirectory$okio()[getSegments$okio().length + r103];
        int r107 = Math.min(r111, r105 + r104) - r100;
        if (b.a(getSegments$okio()[r103], r106 + (r100 - r104), r101, r102, r107) == false) goto L27;
        r102 = r102 + r107;
        r100 = r100 + r107;
        r103 = r103 + 1;
        goto L11
    L27:
        return false;
    L14:
        r104 = getDirectory$okio()[r103 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r100, ByteString r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 > (size() - r110)) goto L21;
        int r111 = r110 + r100;
        int r103 = okio.internal.d.a(this, r100);
    L8:
        if (r100 >= r111) goto L16;
        if (r103 != 0) goto L11;
        int r104 = 0;
    L12:
        int r105 = getDirectory$okio()[r103] - r104;
        int r106 = getDirectory$okio()[getSegments$okio().length + r103];
        int r107 = Math.min(r111, r105 + r104) - r100;
        if (r101.rangeEquals(r102, getSegments$okio()[r103], r106 + (r100 - r104), r107) == false) goto L22;
        r102 = r102 + r107;
        r100 = r100 + r107;
        r103 = r103 + 1;
        goto L8
    L22:
        return false;
    L11:
        r104 = getDirectory$okio()[r103 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
    }
}
