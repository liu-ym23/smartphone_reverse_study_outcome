package okio;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0096\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010¢\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006^"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", TTVideoEngineInterface.PLAY_API_KEY_BASE64, "base64Url", "compareTo", "other", "copyInto", "", "offset", PickerReporterConstants.KEY.TARGET, "targetOffset", "byteCount", "digest", faceverify.q.KEY_ALGORITHM_CONFIG, "digest$okio", "endsWith", "", "suffix", "equals", "", MonitorConstants.CONNECT_TYPE_GET, "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", Argument.OUT, "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = null;
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ByteString a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "<this>");
            byte[] r100 = okio.a.f523968a;
            Intrinsics.checkNotNullParameter(r110, "<this>");
            int r101 = r110.length();
        L4:
            if (r101 <= 0) goto L13;
            int r102 = r101 - 1;
            char r103 = r110.charAt(r102);
            if (r103 == '=') goto L12;
            if (r103 == '\n') goto L12;
            if (r103 == '\r') goto L12;
            if (r103 == ' ') goto L12;
            if (r103 != '\t') goto L13;
        L12:
            r101 = r102;
        L13:
            int r104 = (int) ((((long) r101) * 6) / 8);
            byte[] r105 = new byte[r104];
            int r106 = 0;
            int r111 = 0;
            int r112 = 0;
            int r113 = 0;
        L14:
            boolean r114 = true;
            if (r106 >= r101) goto L61;
            char r115 = r110.charAt(r106);
            if ('A' <= r115) goto L19;
        L21:
            boolean r107 = false;
        L22:
            if (r107 == false) goto L25;
            int r116 = r115 - 'A';
        L57:
            r112 = (r112 << 6) | r116;
            r111 = r111 + 1;
            if ((r111 % 4) != 0) goto L60;
            int r108 = r113 + 1;
            r105[r113] = (byte) (r112 >> 16);
            int r117 = r108 + 1;
            r105[r108] = (byte) (r112 >> 8);
            r105[r117] = (byte) r112;
            r113 = r117 + 1;
        L60:
            r106 = r106 + 1;
            goto L14
        L25:
            if ('a' <= r115) goto L27;
        L29:
            boolean r109 = false;
        L30:
            if (r109 == false) goto L33;
            r116 = r115 - 'G';
            goto L57
        L33:
            if ('0' <= r115) goto L35;
        L37:
            r114 = false;
        L38:
            if (r114 == false) goto L41;
            r116 = r115 + 4;
            goto L57
        L41:
            if (r115 != '+') goto L43;
        L56:
            r116 = 62;
            goto L57
        L43:
            if (r115 == '-') goto L56;
            if (r115 != '/') goto L48;
        L55:
            r116 = 63;
            goto L57
        L48:
            if (r115 == '_') goto L55;
            if (r115 == '\n') goto L60;
            if (r115 == '\r') goto L60;
            if (r115 == ' ') goto L60;
            if (r115 == '\t') goto L60;
        L73:
            r105 = null;
        L74:
            if (r105 != null) goto L76;
            return null;
        L76:
            return new ByteString(r105);
        L35:
            if (r115 >= ':') goto L37;
        L27:
            if (r115 >= '{') goto L29;
            r109 = true;
            goto L30
        L19:
            if (r115 >= '[') goto L21;
            r107 = true;
            goto L22
        L61:
            int r118 = r111 % 4;
            if (r118 == 1) goto L73;
            if (r118 != 2) goto L66;
            r105[r113] = (byte) ((r112 << 12) >> 16);
            r113 = r113 + 1;
        L70:
            if (r113 == r104) goto L74;
            r105 = Arrays.copyOf(r105, r113);
            goto L74
        L66:
            if (r118 != 3) goto L70;
            int r119 = r112 << 6;
            int r120 = r113 + 1;
            r105[r113] = (byte) (r119 >> 16);
            r113 = r120 + 1;
            r105[r120] = (byte) (r119 >> 8);
            goto L70
        }

        @JvmStatic
        public static ByteString b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r100, "<this>");
            ByteString r101 = new ByteString(r100.getBytes(Charsets.UTF_8));
            r101.setUtf8$okio(r100);
            return r101;
        }

        @JvmStatic
        public static ByteString c(byte... r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return new ByteString(Arrays.copyOf(r100, r100.length));
        }

        public static /* synthetic */ ByteString e(a r100, byte[] r101) {
            Buffer.a r102 = b.f523972a;
            r100.getClass();
            return d(r101, 0, -1234567890);
        }

        @JvmStatic
        public static ByteString f(InputStream r100, int r101) throws IOException {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            int r102 = 0;
            if (r101 < 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L17;
            byte[] r104 = new byte[r101];
        L8:
            if (r102 >= r101) goto L15;
            int r105 = r100.read(r104, r102, r101 - r102);
            if (r105 == (-1)) goto L13;
            r102 = r102 + r105;
            goto L8
        L13:
            throw new EOFException();
        L15:
            return new ByteString(r104);
        L17:
            throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
        L5:
            r103 = false;
            goto L6
        }

        @JvmStatic
        public static ByteString d(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Buffer.a r103 = b.f523972a;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (r102 != (-1234567890)) goto L5;
            r102 = r100.length;
        L5:
            b.b(r100.length, r101, r102);
            return new ByteString(ArraysKt.copyOfRange(r100, r101, r102 + r101));
        }
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r100) {
        Companion.getClass();
        return a.b(r100);
    }

    @JvmStatic
    public static final ByteString of(byte... r100) {
        Companion.getClass();
        return a.c(r100);
    }

    @JvmStatic
    public static final ByteString of(byte[] r100, int r101, int r102) {
        Companion.getClass();
        return a.d(r100, r101, r102);
    }

    @JvmStatic
    public static final ByteString read(InputStream r100, int r101) throws IOException {
        Companion.getClass();
        return a.f(r100, r101);
    }

    public final int indexOf(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return indexOf$default(this, r100, 0, 2, null);
    }

    public final int indexOf(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return indexOf$default(this, r100, 0, 2, null);
    }

    public final int lastIndexOf(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return lastIndexOf$default(this, r100, 0, 2, null);
    }

    public final int lastIndexOf(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return lastIndexOf$default(this, r100, 0, 2, null);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int r100) {
        return substring$default(this, r100, 0, 2, null);
    }

    public ByteString toAsciiLowercase() {
        int r100 = 0;
    L4:
        if (r100 >= getData$okio().length) goto L22;
        byte r101 = getData$okio()[r100];
        if (r101 < 65) goto L20;
        if (r101 > 90) goto L20;
        byte[] r102 = getData$okio();
        byte[] r103 = Arrays.copyOf(r102, r102.length);
        int r104 = r100 + 1;
        r103[r100] = (byte) (r101 + 32);
    L12:
        if (r104 >= r103.length) goto L31;
        byte r105 = r103[r104];
        if (r105 < 65) goto L18;
        if (r105 > 90) goto L18;
        r103[r104] = (byte) (r105 + 32);
    L18:
        r104 = r104 + 1;
        goto L12
    L31:
        return new ByteString(r103);
    L20:
        r100 = r100 + 1;
        goto L4
    L22:
        return this;
    }

    public ByteString toAsciiUppercase() {
        int r100 = 0;
    L4:
        if (r100 >= getData$okio().length) goto L22;
        byte r101 = getData$okio()[r100];
        if (r101 < 97) goto L20;
        if (r101 > 122) goto L20;
        byte[] r102 = getData$okio();
        byte[] r103 = Arrays.copyOf(r102, r102.length);
        int r104 = r100 + 1;
        r103[r100] = (byte) (r101 - 32);
    L12:
        if (r104 >= r103.length) goto L31;
        byte r105 = r103[r104];
        if (r105 < 97) goto L18;
        if (r105 > 122) goto L18;
        r103[r104] = (byte) (r105 - 32);
    L18:
        r104 = r104 + 1;
        goto L12
    L31:
        return new ByteString(r103);
    L20:
        r100 = r100 + 1;
        goto L4
    L22:
        return this;
    }

    static {
        Companion = new a();
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m10977deprecated_size() {
        return size();
    }

    public String base64() {
        return okio.a.a(getData$okio(), okio.a.f523968a);
    }

    public String base64Url() {
        return okio.a.a(getData$okio(), okio.a.f523969b);
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public int hashCode() {
        int r100 = getHashCode$okio();
        if (r100 != 0) goto L7;
        int r101 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r101);
        return r101;
    L7:
        return r100;
    }

    public String hex() {
        char[] r100 = new char[getData$okio().length * 2];
        byte[] r101 = getData$okio();
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r105 = r101[r103];
        int r106 = r104 + 1;
        char[] r107 = okio.internal.b.f524038a;
        r100[r104] = r107[(r105 >> 4) & 15];
        r104 = r106 + 1;
        r100[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r100);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public final int size() {
        return getSize$okio();
    }

    public byte[] toByteArray() {
        byte[] r100 = getData$okio();
        return Arrays.copyOf(r100, r100.length);
    }

    public String toString() {
        if (getData$okio().length != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        String r101 = "[size=0]";
    L316:
        return r101;
    L9:
        byte[] r102 = getData$okio();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r104 >= r103) goto L248;
        byte r107 = r102[r104];
        if (r107 >= 0) goto L14;
        if ((r107 >> 5) != (-2)) goto L113;
        int r108 = r104 + 1;
        if (r103 <= r108) goto L72;
        byte r109 = r102[r108];
        if ((r109 & 192) != 128) goto L77;
        boolean r110 = true;
    L78:
        if (r110 == false) goto L79;
        int r111 = (r109 ^ ByteCompanionObject.MIN_VALUE) ^ (r107 << 6);
        if (r111 < 128) goto L83;
        int r112 = r105 + 1;
        if (r105 == 64) goto L248;
        if (r111 == 10) goto L104;
        if (r111 == 13) goto L104;
        if (r111 < 0) goto L93;
        if (r111 >= 32) goto L93;
        boolean r113 = true;
    L94:
        if (r113 == true) goto L102;
        if (127 > r111) goto L98;
        if (r111 >= 160) goto L98;
        boolean r114 = true;
    L99:
        if (r114 == true) goto L102;
        boolean r115 = false;
    L103:
        if (r115 == false) goto L104;
    L246:
        r106 = -1;
    L98:
        r114 = false;
    L102:
        r115 = true;
    L93:
        r113 = false;
    L104:
        if (r111 == 65533) goto L246;
        if (r111 >= 65536) goto L109;
        int r116 = 1;
    L110:
        r106 = r106 + r116;
        Unit r117 = Unit.INSTANCE;
        r104 = r104 + 2;
    L111:
        r105 = r112;
        goto L11
    L109:
        r116 = 2;
        goto L110
    L83:
        if (r105 != 64) goto L246;
    L79:
        if (r105 != 64) goto L246;
    L77:
        r110 = false;
        goto L78
    L72:
        if (r105 != 64) goto L246;
    L113:
        if ((r107 >> 4) != (-2)) goto L173;
        int r118 = r104 + 2;
        if (r103 <= r118) goto L116;
        byte r119 = r102[r104 + 1];
        if ((r119 & 192) != 128) goto L121;
        boolean r120 = true;
    L122:
        if (r120 == false) goto L123;
        byte r121 = r102[r118];
        if ((r121 & 192) != 128) goto L128;
        boolean r122 = true;
    L129:
        if (r122 == false) goto L130;
        int r123 = ((r121 ^ ByteCompanionObject.MIN_VALUE) ^ (r119 << 6)) ^ (r107 << 12);
        if (r123 < 2048) goto L134;
        if (55296 > r123) goto L139;
        if (r123 >= 57344) goto L139;
        boolean r124 = true;
    L140:
        if (r124 == true) goto L141;
        r112 = r105 + 1;
        if (r105 == 64) goto L248;
        if (r123 == 10) goto L165;
        if (r123 == 13) goto L165;
        if (r123 < 0) goto L151;
        if (r123 >= 32) goto L151;
        boolean r125 = true;
    L152:
        if (r125 == false) goto L154;
    L162:
        boolean r126 = true;
    L163:
        if (r126 == true) goto L246;
    L154:
        if (127 <= r123) goto L156;
    L158:
        boolean r127 = false;
    L159:
        if (r127 == true) goto L162;
        r126 = false;
        goto L163
    L156:
        if (r123 >= 160) goto L158;
        r127 = true;
    L151:
        r125 = false;
    L165:
        if (r123 == 65533) goto L246;
        if (r123 >= 65536) goto L170;
        int r128 = 1;
    L171:
        r106 = r106 + r128;
        Unit r129 = Unit.INSTANCE;
        r104 = r104 + 3;
        goto L111
    L170:
        r128 = 2;
        goto L171
    L141:
        if (r105 != 64) goto L246;
    L139:
        r124 = false;
        goto L140
    L134:
        if (r105 != 64) goto L246;
    L130:
        if (r105 != 64) goto L246;
    L128:
        r122 = false;
        goto L129
    L123:
        if (r105 != 64) goto L246;
    L121:
        r120 = false;
        goto L122
    L116:
        if (r105 != 64) goto L246;
    L173:
        if ((r107 >> 3) != (-2)) goto L244;
        int r130 = r104 + 3;
        if (r103 <= r130) goto L176;
        byte r131 = r102[r104 + 1];
        if ((r131 & 192) != 128) goto L181;
        boolean r132 = true;
    L182:
        if (r132 == false) goto L183;
        byte r133 = r102[r104 + 2];
        if ((r133 & 192) != 128) goto L188;
        boolean r134 = true;
    L189:
        if (r134 == false) goto L190;
        byte r135 = r102[r130];
        if ((r135 & 192) != 128) goto L195;
        boolean r136 = true;
    L196:
        if (r136 == false) goto L197;
        int r137 = (((r135 ^ ByteCompanionObject.MIN_VALUE) ^ (r133 << 6)) ^ (r131 << 12)) ^ (r107 << 18);
        if (r137 > 1114111) goto L201;
        if (55296 > r137) goto L206;
        if (r137 >= 57344) goto L206;
        boolean r138 = true;
    L207:
        if (r138 == true) goto L208;
        if (r137 < 65536) goto L212;
        r112 = r105 + 1;
        if (r105 == 64) goto L248;
        if (r137 == 10) goto L237;
        if (r137 == 13) goto L237;
        if (r137 >= 0) goto L221;
    L223:
        boolean r139 = false;
    L224:
        if (r139 == false) goto L226;
    L234:
        boolean r140 = true;
    L235:
        if (r140 == true) goto L246;
    L226:
        if (127 <= r137) goto L228;
    L230:
        boolean r141 = false;
    L231:
        if (r141 == true) goto L234;
        r140 = false;
        goto L235
    L228:
        if (r137 >= 160) goto L230;
        r141 = true;
        goto L231
    L221:
        if (r137 >= 32) goto L223;
        r139 = true;
    L237:
        if (r137 == 65533) goto L246;
        if (r137 >= 65536) goto L242;
        int r142 = 1;
    L243:
        r106 = r106 + r142;
        Unit r143 = Unit.INSTANCE;
        r104 = r104 + 4;
        goto L111
    L242:
        r142 = 2;
        goto L243
    L212:
        if (r105 != 64) goto L246;
    L208:
        if (r105 != 64) goto L246;
    L206:
        r138 = false;
        goto L207
    L201:
        if (r105 != 64) goto L246;
    L197:
        if (r105 != 64) goto L246;
    L195:
        r136 = false;
        goto L196
    L190:
        if (r105 != 64) goto L246;
    L188:
        r134 = false;
        goto L189
    L183:
        if (r105 != 64) goto L246;
    L181:
        r132 = false;
        goto L182
    L176:
        if (r105 != 64) goto L246;
    L244:
        if (r105 != 64) goto L246;
    L14:
        int r144 = r105 + 1;
        if (r105 == 64) goto L248;
        if (r107 == 10) goto L33;
        if (r107 == 13) goto L33;
        if (r107 < 0) goto L22;
        if (r107 >= 32) goto L22;
        boolean r145 = true;
    L23:
        if (r145 == true) goto L31;
        if (127 > r107) goto L27;
        if (r107 >= 160) goto L27;
        boolean r146 = true;
    L28:
        if (r146 == true) goto L31;
        boolean r147 = false;
    L32:
        if (r147 == true) goto L246;
    L27:
        r146 = false;
    L31:
        r147 = true;
    L22:
        r145 = false;
    L33:
        if (r107 == 65533) goto L246;
        if (r107 >= 65536) goto L37;
        int r148 = 1;
    L38:
        r106 = r106 + r148;
        r104 = r104 + 1;
    L39:
        r105 = r144;
        if (r104 >= r103) goto L11;
        byte r149 = r102[r104];
        if (r149 < 0) goto L11;
        r104 = r104 + 1;
        r144 = r105 + 1;
        if (r105 == 64) goto L248;
        if (r149 == 10) goto L62;
        if (r149 == 13) goto L62;
        if (r149 < 0) goto L51;
        if (r149 >= 32) goto L51;
        boolean r150 = true;
    L52:
        if (r150 == true) goto L60;
        if (127 > r149) goto L56;
        if (r149 >= 160) goto L56;
        boolean r151 = true;
    L57:
        if (r151 == true) goto L60;
        boolean r152 = false;
    L61:
        if (r152 == true) goto L246;
    L56:
        r151 = false;
    L60:
        r152 = true;
    L51:
        r150 = false;
    L62:
        if (r149 == 65533) goto L246;
        if (r149 >= 65536) goto L66;
        int r153 = 1;
    L67:
        r106 = r106 + r153;
        goto L39
    L66:
        r153 = 2;
        goto L67
    L37:
        r148 = 2;
    L248:
        if (r106 == (-1)) goto L250;
        String r154 = utf8();
        String r155 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r154.substring(0, r106), "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r106 >= r154.length()) goto L275;
        return "[size=" + getData$okio().length + " text=" + r155 + "…]";
    L275:
        return "[text=" + r155 + ']';
    L250:
        if (getData$okio().length > 64) goto L252;
        r101 = "[hex=" + hex() + ']';
        goto L316
    L252:
        StringBuilder r156 = new StringBuilder("[size=");
        r156.append(getData$okio().length);
        r156.append(" hex=");
        int r157 = b.c(this, 64);
        if (r157 > getData$okio().length) goto L255;
        boolean r158 = true;
    L256:
        if (r158 == false) goto L270;
        if ((r157 + 0) < 0) goto L260;
        boolean r159 = true;
    L261:
        if (r159 == false) goto L268;
        if (r157 != getData$okio().length) goto L265;
        ByteString r160 = this;
    L266:
        r156.append(r160.hex());
        r156.append("…]");
        return r156.toString();
    L265:
        r160 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, r157));
        goto L266
    L268:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L260:
        r159 = false;
        goto L261
    L270:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L255:
        r158 = false;
        goto L256
    L5:
        r100 = false;
        goto L6
    }

    public String utf8() {
        String r100 = getUtf8$okio();
        if (r100 != null) goto L6;
        byte[] r101 = internalArray$okio();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = new String(r101, Charsets.UTF_8);
        setUtf8$okio(r102);
        return r102;
    L6:
        return r100;
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public ByteString(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
    }

    @JvmStatic
    public static final ByteString decodeHex(String r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
        if ((r100.length() % 2) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        int r103 = r100.length() / 2;
        byte[] r104 = new byte[r103];
    L8:
        if (r101 >= r103) goto L11;
        int r105 = r101 * 2;
        r104[r101] = (byte) ((okio.internal.b.a(r100.charAt(r105)) << 4) + okio.internal.b.a(r100.charAt(r105 + 1)));
        r101 = r101 + 1;
        goto L8
    L11:
        return new ByteString(r104);
    L13:
        throw new IllegalArgumentException("Unexpected hex string: ".concat(r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte[] r101 = new byte[r100.remaining()];
        r100.get(r101);
        return new ByteString(r101);
    }

    private final void readObject(ObjectInputStream r100) throws IOException {
        int r101 = r100.readInt();
        Companion.getClass();
        ByteString r102 = a.f(r100, r101);
        Field r103 = ByteString.class.getDeclaredField("data");
        r103.setAccessible(true);
        r103.set(this, r102.data);
    }

    private final void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeInt(this.data.length);
        r100.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m10976deprecated_getByte(int r100) {
        return getByte(r100);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r110) {
        Intrinsics.checkNotNullParameter(r110, "other");
        int r100 = size();
        int r101 = r110.size();
        int r102 = Math.min(r100, r101);
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L10;
        int r104 = getByte(r103) & UByte.MAX_VALUE;
        int r105 = r110.getByte(r103) & UByte.MAX_VALUE;
        if (r104 != r105) goto L8;
        r103 = r103 + 1;
        goto L4
    L8:
        if (r104 < r105) goto L13;
    L14:
        return 1;
    L13:
        return -1;
    L10:
        if (r100 == r101) goto L19;
        if (r100 >= r101) goto L14;
    L19:
        return 0;
    }

    public ByteString digest$okio(String r100) {
        Intrinsics.checkNotNullParameter(r100, faceverify.q.KEY_ALGORITHM_CONFIG);
        MessageDigest r101 = MessageDigest.getInstance(r100);
        r101.update(this.data, 0, size());
        byte[] r102 = r101.digest();
        Intrinsics.checkNotNull(r102);
        return new ByteString(r102);
    }

    public final boolean endsWith(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "suffix");
        return rangeEquals(size() - r100.size(), r100, 0, r100.size());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByteString) == false) goto L12;
        ByteString r101 = (ByteString) r100;
        if (r101.size() != getData$okio().length) goto L12;
        if (r101.rangeEquals(0, getData$okio(), 0, getData$okio().length) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final byte getByte(int r100) {
        return internalGet$okio(r100);
    }

    public ByteString hmacSha1(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac$okio("HmacSHA1", r100);
    }

    public ByteString hmacSha256(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac$okio("HmacSHA256", r100);
    }

    public ByteString hmacSha512(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac$okio("HmacSHA512", r100);
    }

    public byte internalGet$okio(int r100) {
        return getData$okio()[r100];
    }

    public final void setHashCode$okio(int r100) {
        this.hashCode = r100;
    }

    public final void setUtf8$okio(String r100) {
        this.utf8 = r100;
    }

    public final boolean startsWith(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        return rangeEquals(0, r100, 0, r100.size());
    }

    public String string(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "charset");
        return new String(this.data, r100);
    }

    public void write(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.write(this.data);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r100) {
        return compareTo2(r100);
    }

    public final boolean endsWith(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "suffix");
        return rangeEquals(size() - r100.length, r100, 0, r100.length);
    }

    public final boolean startsWith(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        return rangeEquals(0, r100, 0, r100.length);
    }

    @JvmStatic
    public static final ByteString encodeString(String r100, Charset r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new ByteString(r100.getBytes(r101));
    }

    public ByteString hmac$okio(String r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, faceverify.q.KEY_ALGORITHM_CONFIG);
        Intrinsics.checkNotNullParameter(r101, "key");
        Mac r102 = Mac.getInstance(r100);     // Catch: InvalidKeyException -> L5
        r102.init(new SecretKeySpec(r101.toByteArray(), r100));     // Catch: InvalidKeyException -> L5
        return new ByteString(r102.doFinal(this.data));
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public int indexOf(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r102 = getData$okio().length - r100.length;
        int r103 = Math.max(r101, 0);
        if (r103 <= r102) goto L5;
    L9:
        return -1;
    L5:
        if (b.a(getData$okio(), r103, r100, 0, r100.length) == true) goto L13;
        if (r103 == r102) goto L9;
        r103 = r103 + 1;
        goto L5
    L13:
        return r103;
    }

    public int lastIndexOf(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r102 = Math.min(b.c(this, r101), getData$okio().length - r100.length);
    L4:
        if ((-1) >= r102) goto L9;
        if (b.a(getData$okio(), r102, r100, 0, r100.length) == true) goto L13;
        r102 = r102 - 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    public ByteString substring(int r100, int r101) {
        int r102 = b.c(this, r101);
        boolean r103 = true;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L28;
        if (r102 > getData$okio().length) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L26;
        if ((r102 - r100) >= 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L24;
        if (r100 != 0) goto L22;
        if (r102 != getData$okio().length) goto L22;
        return this;
    L22:
        return new ByteString(ArraysKt.copyOfRange(getData$okio(), r100, r102));
    L24:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L26:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L10:
        r105 = false;
        goto L11
    L28:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r104 = false;
        goto L6
    }

    public final int indexOf(ByteString r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return indexOf(r100.internalArray$okio(), r101);
    }

    public final int lastIndexOf(ByteString r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return lastIndexOf(r100.internalArray$okio(), r101);
    }

    public void write$okio(Buffer r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "buffer");
        r100.write(getData$okio(), r101, r102);
    }

    public void copyInto(int r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        ArraysKt.copyInto(getData$okio(), r101, r102, r100, r103 + r100);
    }

    public boolean rangeEquals(int r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r100 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r100 > (getData$okio().length - r103)) goto L12;
        if (r102 < 0) goto L12;
        if (r102 > (r101.length - r103)) goto L12;
        if (b.a(getData$okio(), r100, r101, r102, r103) == false) goto L12;
        return true;
    }

    public boolean rangeEquals(int r100, ByteString r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "other");
        return r101.rangeEquals(r102, getData$okio(), r100, r103);
    }

    public static /* synthetic */ int indexOf$default(ByteString r100, ByteString r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        return r100.indexOf(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r100, ByteString r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        Buffer.a r105 = b.f523972a;
        r102 = -1234567890;
    L7:
        return r100.lastIndexOf(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ ByteString substring$default(ByteString r100, int r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = 0;
    L7:
        if ((r103 & 2) == 0) goto L10;
        Buffer.a r105 = b.f523972a;
        r102 = -1234567890;
    L10:
        return r100.substring(r101, r102);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public static /* synthetic */ int indexOf$default(ByteString r100, byte[] r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        return r100.indexOf(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r100, byte[] r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        Buffer.a r105 = b.f523972a;
        r102 = -1234567890;
    L7:
        return r100.lastIndexOf(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ void copyInto$default(ByteString r100, int r101, byte[] r102, int r103, int r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 1) == 0) goto L7;
        r101 = 0;
    L7:
        if ((r105 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        r100.copyInto(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }
}
