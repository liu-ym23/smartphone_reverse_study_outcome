package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.common.Constants;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0093\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J'\u0010h\u001a\u0004\u0018\u0001Hk\"\b\b\u0000\u0010k*\u00020%2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hk0lH\u0016¢\u0006\u0002\u0010mJ\u0006\u0010n\u001a\u00020\u001dJ\u0006\u0010o\u001a\u00020\u001dJ\u0006\u0010p\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010s\u001a\u00020\u001dJ\u000e\u0010s\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u001fH\u0016J\u0015\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020/H\u0000¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020FH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020GH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00122\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001dH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020}2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010~\u001a\u00020\f2\u0006\u0010{\u001a\u00020}H\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020/H\u0016J\u001a\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0094\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", Argument.OUT, "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", faceverify.q.KEY_ALGORITHM_CONFIG, "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", MonitorConstants.CONNECT_TYPE_GET, "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", HTTP.CONTENT_RANGE_BYTES, "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", Constants.ROLE_SINK, "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "request", "require", "select", "options", "Lokio/Options;", ExifInterface.GPS_DIRECTION_TRUE, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", BaseSwitches.V, "writeHexadecimalUnsignedLong", "writeInt", RXScreenCaptureService.KEY_INDEX, "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public g0 head;
    private long size;

    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Buffer f523957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f523958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g0 f523959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f523960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f523961e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f523962f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f523963g;

        public final int a() {
            long r100 = this.f523960d;
            Buffer r101 = this.f523957a;
            Intrinsics.checkNotNull(r101);
            if (r100 == r101.size()) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L14;
            long r103 = this.f523960d;
            if (r103 != (-1)) goto L10;
            long r104 = 0;
        L12:
            return b(r104);
        L10:
            r104 = r103 + ((long) (this.f523963g - this.f523962f));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes".toString());
        L5:
            r102 = false;
            goto L6
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f523957a == null) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L10;
            this.f523957a = null;
            this.f523959c = null;
            this.f523960d = -1;
            this.f523961e = null;
            this.f523962f = -1;
            this.f523963g = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r100 = false;
            goto L6
        }

        public a() {
            this.f523960d = -1;
            this.f523962f = -1;
            this.f523963g = -1;
        }

        public final int b(long r110) {
            Buffer r100 = this.f523957a;
            if (r100 == null) goto L42;
            if (r110 < (-1)) goto L40;
            if (r110 > r100.size()) goto L40;
            if (r110 != (-1)) goto L10;
        L37:
            this.f523959c = null;
            this.f523960d = r110;
            this.f523961e = null;
            this.f523962f = -1;
            this.f523963g = -1;
            return -1;
        L10:
            if (r110 == r100.size()) goto L37;
            long r101 = r100.size();
            g0 r102 = r100.head;
            g0 r103 = this.f523959c;
            long r104 = 0;
            if (r103 == null) goto L18;
            long r111 = this.f523960d;
            int r112 = this.f523962f;
            Intrinsics.checkNotNull(r103);
            long r113 = r111 - ((long) (r112 - r103.f524018b));
            if (r113 <= r110) goto L17;
            g0 r105 = this.f523959c;
            r101 = r113;
        L20:
            if ((r101 - r110) <= (r110 - r104)) goto L25;
        L21:
            Intrinsics.checkNotNull(r102);
            long r106 = ((long) (r102.f524019c - r102.f524018b)) + r104;
            if (r110 < r106) goto L29;
            r102 = r102.f524022f;
            r104 = r106;
        L29:
            if (this.f523958b == false) goto L36;
            Intrinsics.checkNotNull(r102);
            if (r102.f524020d == false) goto L36;
            byte[] r107 = r102.f524017a;
            g0 r108 = new g0(Arrays.copyOf(r107, r107.length), r102.f524018b, r102.f524019c, false, true);
            if (r100.head != r102) goto L35;
            r100.head = r108;
        L35:
            r102.b(r108);
            g0 r109 = r108.f524023g;
            Intrinsics.checkNotNull(r109);
            r109.a();
            r102 = r108;
        L36:
            this.f523959c = r102;
            this.f523960d = r110;
            Intrinsics.checkNotNull(r102);
            this.f523961e = r102.f524017a;
            int r114 = r102.f524018b + ((int) (r110 - r104));
            this.f523962f = r114;
            int r115 = r102.f524019c;
            this.f523963g = r115;
            return r115 - r114;
        L25:
            if (r101 <= r110) goto L27;
            Intrinsics.checkNotNull(r105);
            r105 = r105.f524023g;
            Intrinsics.checkNotNull(r105);
            r101 = r101 - ((long) (r105.f524019c - r105.f524018b));
            goto L25
        L27:
            r104 = r101;
            r102 = r105;
            goto L29
        L17:
            r104 = r113;
            r105 = r102;
            r102 = this.f523959c;
            goto L20
        L18:
            r105 = r102;
        L40:
            throw new ArrayIndexOutOfBoundsException("offset=" + r110 + " > size=" + r100.size());
        L42:
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class b extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Buffer f523964a;

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.InputStream
        public final int available() {
            return (int) Math.min(this.f523964a.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public final int read() {
            if (this.f523964a.size() > 0) goto L7;
            return -1;
        L7:
            return this.f523964a.readByte() & UByte.MAX_VALUE;
        }

        public final String toString() {
            return this.f523964a + ".inputStream()";
        }

        public b(Buffer r100) {
            this.f523964a = r100;
        }

        @Override // java.io.InputStream
        public final int read(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
            return this.f523964a.read(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Buffer f523965a;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
        }

        public final String toString() {
            return this.f523965a + ".outputStream()";
        }

        public c(Buffer r100) {
            this.f523965a = r100;
        }

        @Override // java.io.OutputStream
        public final void write(int r100) {
            this.f523965a.writeByte(r100);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f523965a.write(r100, r101, r102);
        }
    }

    public Buffer() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final Buffer copyTo(OutputStream r110) throws IOException {
        Intrinsics.checkNotNullParameter(r110, Argument.OUT);
        return copyTo$default(this, r110, 0, 0, 6, null);
    }

    public final Buffer copyTo(OutputStream r110, long r111) throws IOException {
        Intrinsics.checkNotNullParameter(r110, Argument.OUT);
        return copyTo$default(this, r110, r111, 0, 4, null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final a readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final a readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        return writeTo$default(this, r100, 0, 2, null);
    }

    public final Buffer copy() {
        Buffer r100 = new Buffer();
        if (size() == 0) goto L9;
        g0 r101 = this.head;
        Intrinsics.checkNotNull(r101);
        g0 r102 = r101.c();
        r100.head = r102;
        r102.f524023g = r102;
        r102.f524022f = r102;
        g0 r103 = r101.f524022f;
    L6:
        if (r103 == r101) goto L8;
        g0 r104 = r102.f524023g;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r103);
        r104.b(r103.c());
        r103 = r103.f524022f;
        goto L6
    L8:
        r100.setSize$okio(size());
    L9:
        return r100;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        g0 r100 = this.head;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = 1;
    L6:
        int r102 = r100.f524018b;
        int r103 = r100.f524019c;
    L7:
        if (r102 >= r103) goto L9;
        r101 = (r101 * 31) + r100.f524017a[r102];
        r102 = r102 + 1;
        goto L7
    L9:
        r100 = r100.f524022f;
        Intrinsics.checkNotNull(r100);
        if (r100 != this.head) goto L6;
        return r101;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new b(this);
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new c(this);
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new c0(this));
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (size() == 0) goto L56;
        int r100 = 0;
        long r101 = 0;
        long r102 = -7;
        boolean r103 = false;
        boolean r104 = false;
    L5:
        g0 r110 = this.head;
        Intrinsics.checkNotNull(r110);
        byte[] r111 = r110.f524017a;
        int r112 = r110.f524018b;
        int r113 = r110.f524019c;
    L6:
        if (r112 >= r113) goto L29;
        byte r114 = r111[r112];
        if (r114 < 48) goto L24;
        if (r114 > 57) goto L24;
        int r115 = 48 - r114;
        if (r101 < (-922337203685477580L)) goto L18;
        if (r101 == (-922337203685477580L)) goto L15;
    L17:
        r101 = (r101 * 10) + ((long) r115);
    L27:
        r112 = r112 + 1;
        r100 = r100 + 1;
        goto L6
    L15:
        if (r115 >= r102) goto L17;
    L18:
        Buffer r105 = new Buffer().writeDecimalLong(r101).writeByte(r114);
        if (r103 == true) goto L22;
        r105.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r105.readUtf8());
    L24:
        if (r114 != 45) goto L28;
        if (r100 != 0) goto L28;
        r102 = r102 - 1;
        r103 = true;
    L28:
        r104 = true;
    L29:
        if (r112 != r113) goto L31;
        this.head = r110.a();
        h0.a(r110);
    L32:
        if (r104 == true) goto L37;
        if (this.head != null) goto L5;
    L37:
        setSize$okio(size() - ((long) r100));
        if (r103 == false) goto L40;
        int r116 = 2;
    L41:
        if (r100 < r116) goto L43;
        if (r103 == false) goto L54;
        return r101;
    L54:
        return -r101;
    L43:
        if (size() == 0) goto L50;
        if (r103 == false) goto L46;
        String r106 = "Expected a digit";
    L48:
        throw new NumberFormatException(r106 + " but was 0x" + okio.b.e(getByte(0)));
    L46:
        r106 = "Expected a digit or '-'";
        goto L48
    L50:
        throw new EOFException();
    L40:
        r116 = 1;
        goto L41
    L31:
        r110.f524018b = r112;
        goto L32
    L56:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long r100 = indexOf((byte) 10);
        if (r100 == (-1)) goto L6;
        return okio.internal.a.b(this, r100);
    L6:
        if (size() != 0) goto L11;
        return null;
    L11:
        return readUtf8(size());
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final void clear() {
        skip(size());
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m10975clone();
    }

    public final long completeSegmentByteCount() {
        long r100 = size();
        if (r100 == 0) goto L12;
        g0 r101 = this.head;
        Intrinsics.checkNotNull(r101);
        g0 r102 = r101.f524023g;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.f524019c;
        if (r103 >= 8192) goto L11;
        if (r102.f524021e == false) goto L11;
        r100 = r100 - ((long) (r103 - r102.f524018b));
    L11:
        return r100;
    L12:
        return 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emit() {
        return emit();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() {
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) goto L10;
        g0 r100 = this.head;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.f524018b;
        int r102 = r100.f524019c;
        int r103 = r101 + 1;
        byte r104 = r100.f524017a[r101];
        setSize$okio(size() - 1);
        if (r103 != r102) goto L7;
        this.head = r100.a();
        h0.a(r100);
    L8:
        return r104;
    L7:
        r100.f524018b = r103;
        goto L8
    L10:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        if (size() == 0) goto L41;
        int r100 = 0;
        long r101 = 0;
        boolean r102 = false;
    L5:
        g0 r103 = this.head;
        Intrinsics.checkNotNull(r103);
        byte[] r104 = r103.f524017a;
        int r105 = r103.f524018b;
        int r106 = r103.f524019c;
    L6:
        if (r105 >= r106) goto L32;
        byte r110 = r104[r105];
        if (r110 < 48) goto L13;
        if (r110 > 57) goto L13;
        int r111 = r110 - 48;
    L24:
        if (((-1152921504606846976L) & r101) != 0) goto L27;
        r101 = (r101 << 4) | ((long) r111);
        r105 = r105 + 1;
        r100 = r100 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r101).writeByte(r110).readUtf8());
    L13:
        if (r110 < 97) goto L19;
        if (r110 > 102) goto L19;
        int r112 = r110 - 97;
    L17:
        r111 = r112 + 10;
    L19:
        if (r110 < 65) goto L28;
        if (r110 > 70) goto L28;
        r112 = r110 - 65;
    L28:
        if (r100 == 0) goto L31;
        r102 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + okio.b.e(r110));
    L32:
        if (r105 != r106) goto L34;
        this.head = r103.a();
        h0.a(r103);
    L35:
        if (r102 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        setSize$okio(size() - ((long) r100));
        return r101;
    L34:
        r103.f524018b = r105;
        goto L35
    L41:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) goto L14;
        g0 r100 = this.head;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.f524018b;
        int r102 = r100.f524019c;
        if ((r102 - r101) < 4) goto L15;
        byte[] r103 = r100.f524017a;
        int r104 = r101 + 1;
        int r105 = r104 + 1;
        int r106 = ((r103[r101] & UByte.MAX_VALUE) << 24) | ((r103[r104] & UByte.MAX_VALUE) << 16);
        int r107 = r105 + 1;
        int r108 = r106 | ((r103[r105] & UByte.MAX_VALUE) << 8);
        int r109 = r107 + 1;
        int r110 = r108 | (r103[r107] & UByte.MAX_VALUE);
        setSize$okio(size() - 4);
        if (r109 != r102) goto L10;
        this.head = r100.a();
        h0.a(r100);
    L12:
        return r110;
    L10:
        r100.f524018b = r109;
        goto L12
    L15:
        return ((((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16)) | ((readByte() & UByte.MAX_VALUE) << 8)) | (readByte() & UByte.MAX_VALUE);
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        int r100 = readInt();
        a r101 = okio.b.f523972a;
        int r102 = ((((-16777216) & r100) >>> 24) | ((16711680 & r100) >>> 8)) | ((65280 & r100) << 8);
        return ((r100 & 255) << 24) | r102;
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) goto L14;
        g0 r100 = this.head;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.f524018b;
        int r102 = r100.f524019c;
        if ((r102 - r101) < 8) goto L15;
        byte[] r103 = r100.f524017a;
        int r104 = r101 + 1;
        long r105 = (((long) r103[r101]) & 255) << 56;
        int r106 = r104 + 1;
        long r107 = r105 | ((((long) r103[r104]) & 255) << 48);
        int r108 = r106 + 1;
        long r109 = r107 | ((((long) r103[r106]) & 255) << 40);
        int r110 = r108 + 1;
        long r111 = ((((long) r103[r108]) & 255) << 32) | r109;
        int r112 = r110 + 1;
        long r113 = r111 | ((((long) r103[r110]) & 255) << 24);
        int r114 = r112 + 1;
        long r115 = r113 | ((((long) r103[r112]) & 255) << 16);
        int r116 = r114 + 1;
        long r117 = r115 | ((((long) r103[r114]) & 255) << 8);
        int r118 = r116 + 1;
        long r119 = r117 | (((long) r103[r116]) & 255);
        setSize$okio(size() - 8);
        if (r118 != r102) goto L10;
        this.head = r100.a();
        h0.a(r100);
    L12:
        return r119;
    L10:
        r100.f524018b = r118;
        goto L12
    L15:
        return ((((long) readInt()) & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return okio.b.d(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) goto L14;
        g0 r100 = this.head;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.f524018b;
        int r102 = r100.f524019c;
        if ((r102 - r101) < 2) goto L15;
        byte[] r103 = r100.f524017a;
        int r104 = r101 + 1;
        int r105 = r104 + 1;
        int r106 = ((r103[r101] & UByte.MAX_VALUE) << 8) | (r103[r104] & UByte.MAX_VALUE);
        setSize$okio(size() - 2);
        if (r105 != r102) goto L10;
        this.head = r100.a();
        h0.a(r100);
    L12:
        return (short) r106;
    L10:
        r100.f524018b = r105;
        goto L12
    L15:
        return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        short r100 = readShort();
        a r101 = okio.b.f523972a;
        int r102 = r100 & 65535;
        int r103 = (65280 & r102) >>> 8;
        return (short) (((r102 & 255) << 8) | r103);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        if (size() == 0) goto L42;
        byte r100 = getByte(0);
        boolean r101 = false;
        if ((r100 & ByteCompanionObject.MIN_VALUE) != 0) goto L8;
        int r102 = r100 & ByteCompanionObject.MAX_VALUE;
        int r103 = 1;
        int r104 = 0;
    L16:
        long r110 = r103;
        if (size() < r110) goto L38;
        int r105 = 1;
    L19:
        if (r105 >= r103) goto L24;
        long r106 = r105;
        byte r111 = getByte(r106);
        if ((r111 & 192) != 128) goto L23;
        r102 = (r102 << 6) | (r111 & 63);
        r105 = r105 + 1;
        goto L19
    L23:
        skip(r106);
        return 65533;
    L24:
        skip(r110);
        if (r102 <= 1114111) goto L28;
        return 65533;
    L28:
        if (55296 <= r102) goto L30;
    L32:
        if (r101 == true) goto L48;
        if (r102 >= r104) goto L46;
        return 65533;
    L46:
        return r102;
    L48:
        return 65533;
    L30:
        if (r102 >= 57344) goto L32;
        r101 = true;
        goto L32
    L38:
        throw new EOFException("size < " + r103 + ": " + size() + " (to read code point prefixed 0x" + okio.b.e(r100) + ')');
    L8:
        if ((r100 & 224) != 192) goto L11;
        r102 = r100 & 31;
        r103 = 2;
        r104 = 128;
        goto L16
    L11:
        if ((r100 & 240) != 224) goto L14;
        r102 = r100 & 15;
        r103 = 3;
        r104 = 2048;
        goto L16
    L14:
        if ((r100 & 248) != 240) goto L39;
        r102 = r100 & 7;
        r103 = 4;
        r104 = 65536;
        goto L16
    L39:
        skip(1);
        return 65533;
    L42:
        throw new EOFException();
    }

    public final ByteString snapshot() {
        if (size() > SieveCacheKt.NodeLinkMask) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return snapshot((int) size());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    L5:
        r100 = false;
        goto L6
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m10974deprecated_size() {
        return this.size;
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.Source
    public j0 timeout() {
        return j0.f524073d;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m10975clone() {
        return copy();
    }

    private final ByteString digest(String r100) {
        MessageDigest r101 = MessageDigest.getInstance(r100);
        g0 r102 = this.head;
        if (r102 == null) goto L8;
        byte[] r103 = r102.f524017a;
        int r104 = r102.f524018b;
        r101.update(r103, r104, r102.f524019c - r104);
        g0 r105 = r102.f524022f;
        Intrinsics.checkNotNull(r105);
    L5:
        if (r105 == r102) goto L8;
        byte[] r106 = r105.f524017a;
        int r107 = r105.f524018b;
        r101.update(r106, r107, r105.f524019c - r107);
        r105 = r105.f524022f;
        Intrinsics.checkNotNull(r105);
    L8:
        return new ByteString(r101.digest());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m10973deprecated_getByte(long r100) {
        return getByte(r100);
    }

    public boolean equals(Object r110) {
        if (this != r110) goto L6;
        return true;
    L6:
        if ((r110 instanceof Buffer) == true) goto L8;
    L7:
        return false;
    L8:
        Buffer r100 = (Buffer) r110;
        if (size() != r100.size()) goto L7;
        if (size() == 0) goto L38;
        g0 r101 = this.head;
        Intrinsics.checkNotNull(r101);
        g0 r102 = r100.head;
        Intrinsics.checkNotNull(r102);
        int r103 = r101.f524018b;
        int r104 = r102.f524018b;
        long r105 = 0;
    L16:
        if (r105 >= size()) goto L39;
        long r111 = Math.min(r101.f524019c - r103, r102.f524019c - r104);
        long r112 = 0;
    L19:
        if (r112 >= r111) goto L25;
        int r113 = r103 + 1;
        int r114 = r104 + 1;
        if (r101.f524017a[r103] != r102.f524017a[r104]) goto L7;
        r112 = r112 + 1;
        r103 = r113;
        r104 = r114;
        goto L19
    L25:
        if (r103 != r101.f524019c) goto L28;
        r101 = r101.f524022f;
        Intrinsics.checkNotNull(r101);
        r103 = r101.f524018b;
    L28:
        if (r104 != r102.f524019c) goto L30;
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r104 = r102.f524018b;
    L30:
        r105 = r105 + r111;
        goto L16
    L39:
        return true;
    L38:
        return true;
    }

    public final byte getByte(long r100) {
        okio.b.b(size(), r100, 1);
        g0 r101 = this.head;
        if (r101 != null) goto L5;
        Intrinsics.checkNotNull(null);
        throw null;
    L5:
        if ((size() - r100) >= r100) goto L11;
        long r102 = size();
    L8:
        if (r102 <= r100) goto L10;
        r101 = r101.f524023g;
        Intrinsics.checkNotNull(r101);
        r102 = r102 - ((long) (r101.f524019c - r101.f524018b));
        goto L8
    L10:
        Intrinsics.checkNotNull(r101);
        return r101.f524017a[(int) ((((long) r101.f524018b) + r100) - r102)];
    L11:
        long r103 = 0;
    L12:
        long r104 = ((long) (r101.f524019c - r101.f524018b)) + r103;
        if (r104 > r100) goto L15;
        r101 = r101.f524022f;
        Intrinsics.checkNotNull(r101);
        r103 = r104;
        goto L12
    L15:
        Intrinsics.checkNotNull(r101);
        return r101.f524017a[(int) ((((long) r101.f524018b) + r100) - r103)];
    }

    public final ByteString hmacSha1(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac("HmacSHA1", r100);
    }

    public final ByteString hmacSha256(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac("HmacSHA256", r100);
    }

    public final ByteString hmacSha512(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return hmac("HmacSHA512", r100);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r100) {
        return indexOf(r100, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "targetBytes");
        return indexOfElement(r100, 0);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        g0 r101 = this.head;
        if (r101 != null) goto L6;
        return -1;
    L6:
        int r102 = Math.min(r100.remaining(), r101.f524019c - r101.f524018b);
        r100.put(r101.f524017a, r101.f524018b, r102);
        int r103 = r101.f524018b + r102;
        r101.f524018b = r103;
        this.size -= (long) r102;
        if (r103 != r101.f524019c) goto L9;
        this.head = r101.a();
        h0.a(r101);
    L9:
        return r102;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        long r101 = size();
        if (r101 <= 0) goto L5;
        r100.write(this, r101);
    L5:
        return r101;
    }

    public final a readAndWriteUnsafe(a r100) {
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        byte[] r101 = okio.internal.a.f524037a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        a r102 = okio.b.f523972a;
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        if (r100 != okio.b.f523972a) goto L6;
        r100 = new a();
    L6:
        if (r100.f523957a != null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        r100.f523957a = this;
        r100.f523958b = true;
        return r100;
    L13:
        throw new IllegalStateException("already attached to a buffer".toString());
    L8:
        r103 = false;
        goto L9
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r100) throws EOFException {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L16;
        if (size() < r100) goto L14;
        byte[] r102 = new byte[(int) r100];
        readFully(r102);
        return r102;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r100).toString());
    L5:
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        r101 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r100) throws EOFException {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L19;
        if (size() < r100) goto L17;
        if (r100 < 4096) goto L15;
        ByteString r102 = snapshot((int) r100);
        skip(r100);
        return r102;
    L15:
        return new ByteString(readByteArray(r100));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r100).toString());
    L5:
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        r101 = true;
        goto L8
    }

    public final Buffer readFrom(InputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "input");
        readFrom(r100, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r100) throws EOFException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L10;
        int r102 = read(r100, r101, r100.length - r101);
        if (r102 == (-1)) goto L9;
        r101 = r101 + r102;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readString(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "charset");
        return readString(this.size, r100);
    }

    public final a readUnsafe(a r100) {
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        byte[] r101 = okio.internal.a.f524037a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        a r102 = okio.b.f523972a;
        Intrinsics.checkNotNullParameter(r100, "unsafeCursor");
        if (r100 != okio.b.f523972a) goto L6;
        r100 = new a();
    L6:
        if (r100.f523957a != null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        r100.f523957a = this;
        r100.f523958b = false;
        return r100;
    L13:
        throw new IllegalStateException("already attached to a buffer".toString());
    L8:
        r103 = false;
        goto L9
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r100) throws EOFException {
        return readString(r100, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r110) throws EOFException {
        if (r110 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L25;
        long r101 = Long.MAX_VALUE;
        if (r110 == Long.MAX_VALUE) goto L11;
        r101 = r110 + 1;
    L11:
        long r102 = indexOf((byte) 10, 0, r101);
        if (r102 == (-1)) goto L15;
        return okio.internal.a.b(this, r102);
    L15:
        if (r101 < size()) goto L17;
    L22:
        Buffer r103 = new Buffer();
        copyTo(r103, 0, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), r110) + " content=" + r103.readByteString().hex() + 8230);
    L17:
        if (getByte(r101 - 1) != 13) goto L22;
        if (getByte(r101) != 10) goto L22;
        return okio.internal.a.b(this, r101);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r110).toString());
    L5:
        r100 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean request(long r100) {
        if (this.size < r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r100) throws EOFException {
        if (this.size < r100) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(z r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        byte[] r101 = okio.internal.a.f524037a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(null, "options");
        if (this.head != null) goto L6;
        return -1;
    L6:
        throw null;
    }

    public final void setSize$okio(long r100) {
        this.size = r100;
    }

    @Override // okio.BufferedSource
    public void skip(long r100) throws EOFException {
    L3:
        if (r100 <= 0) goto L11;
        g0 r101 = this.head;
        if (r101 == null) goto L10;
        int r102 = (int) Math.min(r100, r101.f524019c - r101.f524018b);
        long r103 = r102;
        setSize$okio(size() - r103);
        r100 = r100 - r103;
        int r104 = r101.f524018b + r102;
        r101.f524018b = r104;
        if (r104 != r101.f524019c) goto L3;
        this.head = r101.a();
        h0.a(r101);
        goto L3
    L10:
        throw new EOFException();
    }

    public final ByteString snapshot(int r100) {
        if (r100 == 0) goto L19;
        okio.b.b(size(), 0, r100);
        g0 r101 = this.head;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r100) goto L11;
        Intrinsics.checkNotNull(r101);
        int r105 = r101.f524019c;
        int r106 = r101.f524018b;
        if (r105 == r106) goto L10;
        r103 = r103 + (r105 - r106);
        r104 = r104 + 1;
        r101 = r101.f524022f;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r107 = new byte[r104][];
        int[] r108 = new int[r104 * 2];
        g0 r109 = this.head;
        int r110 = 0;
    L12:
        if (r102 >= r100) goto L15;
        Intrinsics.checkNotNull(r109);
        r107[r110] = r109.f524017a;
        r102 = r102 + (r109.f524019c - r109.f524018b);
        r108[r110] = Math.min(r102, r100);
        r108[r110 + r104] = r109.f524018b;
        r109.f524020d = true;
        r110 = r110 + 1;
        r109 = r109.f524022f;
        goto L12
    L15:
        return new SegmentedByteString(r107, r108);
    L19:
        return ByteString.EMPTY;
    }

    public final g0 writableSegment$okio(int r100) {
        boolean r101 = true;
        if (r100 < 1) goto L6;
        if (r100 > 8192) goto L6;
    L7:
        if (r101 == false) goto L20;
        g0 r102 = this.head;
        if (r102 != null) goto L11;
        g0 r103 = h0.b();
        this.head = r103;
        r103.f524023g = r103;
        r103.f524022f = r103;
        return r103;
    L11:
        Intrinsics.checkNotNull(r102);
        g0 r104 = r102.f524023g;
        Intrinsics.checkNotNull(r104);
        if ((r104.f524019c + r100) <= 8192) goto L14;
    L17:
        g0 r105 = h0.b();
        r104.b(r105);
        return r105;
    L14:
        if (r104.f524021e == false) goto L17;
        return r104;
    L20:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r101 = false;
        goto L7
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        int r101 = r100.remaining();
        int r102 = r101;
    L3:
        if (r102 <= 0) goto L5;
        g0 r103 = writableSegment$okio(1);
        int r104 = Math.min(r102, 8192 - r103.f524019c);
        r100.get(r103.f524017a, r103.f524019c, r104);
        r102 = r102 - r104;
        r103.f524019c += r104;
        goto L3
    L5:
        this.size += (long) r101;
        return r101;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        long r101 = 0;
    L3:
        long r102 = r100.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r102 == (-1)) goto L6;
        r101 = r101 + r102;
        goto L3
    L6:
        return r101;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int r100) {
        g0 r101 = writableSegment$okio(1);
        byte[] r102 = r101.f524017a;
        int r103 = r101.f524019c;
        r101.f524019c = r103 + 1;
        r102[r103] = (byte) r100;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long r110) {
        if (r110 == 0) goto L78;
        int r100 = 1;
        if (r110 >= 0) goto L11;
        r110 = -r110;
        if (r110 < 0) goto L79;
        boolean r101 = true;
    L13:
        if (r110 >= 100000000) goto L37;
        if (r110 >= 10000) goto L27;
        if (r110 >= 100) goto L23;
        if (r110 < 10) goto L67;
        r100 = 2;
    L67:
        if (r101 == false) goto L69;
        r100 = r100 + 1;
    L69:
        g0 r102 = writableSegment$okio(r100);
        byte[] r103 = r102.f524017a;
        int r104 = r102.f524019c + r100;
    L71:
        if (r110 == 0) goto L73;
        long r105 = 10;
        r104 = r104 - 1;
        r103[r104] = okio.internal.a.f524037a[(int) (r110 % r105)];
        r110 = r110 / r105;
        goto L71
    L73:
        if (r101 == false) goto L75;
        r103[r104 - 1] = 45;
    L75:
        r102.f524019c += r100;
        setSize$okio(size() + ((long) r100));
        return this;
    L23:
        if (r110 >= 1000) goto L25;
        r100 = 3;
        goto L67
    L25:
        r100 = 4;
        goto L67
    L27:
        if (r110 >= 1000000) goto L33;
        if (r110 >= 100000) goto L31;
        r100 = 5;
        goto L67
    L31:
        r100 = 6;
        goto L67
    L33:
        if (r110 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L35;
        r100 = 7;
        goto L67
    L35:
        r100 = 8;
        goto L67
    L37:
        if (r110 >= 1000000000000L) goto L49;
        if (r110 >= 10000000000L) goto L45;
        if (r110 >= C.NANOS_PER_SECOND) goto L43;
        r100 = 9;
        goto L67
    L43:
        r100 = 10;
        goto L67
    L45:
        if (r110 >= 100000000000L) goto L47;
        r100 = 11;
        goto L67
    L47:
        r100 = 12;
        goto L67
    L49:
        if (r110 >= 1000000000000000L) goto L58;
        if (r110 >= 10000000000000L) goto L54;
        r100 = 13;
        goto L67
    L54:
        if (r110 >= 100000000000000L) goto L56;
        r100 = 14;
        goto L67
    L56:
        r100 = 15;
        goto L67
    L58:
        if (r110 >= 100000000000000000L) goto L64;
        if (r110 >= 10000000000000000L) goto L62;
        r100 = 16;
        goto L67
    L62:
        r100 = 17;
        goto L67
    L64:
        if (r110 >= 1000000000000000000L) goto L66;
        r100 = 18;
        goto L67
    L66:
        r100 = 19;
        goto L67
    L79:
        return writeUtf8("-9223372036854775808");
    L11:
        r101 = false;
        goto L13
    L78:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long r110) {
        if (r110 == 0) goto L11;
        long r100 = (r110 >>> 1) | r110;
        long r101 = r100 | (r100 >>> 2);
        long r102 = r101 | (r101 >>> 4);
        long r103 = r102 | (r102 >>> 8);
        long r104 = r103 | (r103 >>> 16);
        long r105 = r104 | (r104 >>> 32);
        long r106 = r105 - ((r105 >>> 1) & 6148914691236517205L);
        long r107 = ((r106 >>> 2) & 3689348814741910323L) + (r106 & 3689348814741910323L);
        long r108 = ((r107 >>> 4) + r107) & 1085102592571150095L;
        long r109 = r108 + (r108 >>> 8);
        long r111 = r109 + (r109 >>> 16);
        int r112 = (int) ((((r111 & 63) + ((r111 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        g0 r113 = writableSegment$okio(r112);
        byte[] r114 = r113.f524017a;
        int r115 = r113.f524019c;
        int r116 = (r115 + r112) - 1;
    L6:
        if (r116 < r115) goto L8;
        r114[r116] = okio.internal.a.f524037a[(int) (15 & r110)];
        r110 = r110 >>> 4;
        r116 = r116 - 1;
        goto L6
    L8:
        r113.f524019c += r112;
        setSize$okio(size() + ((long) r112));
        return this;
    L11:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int r100) {
        g0 r101 = writableSegment$okio(4);
        byte[] r102 = r101.f524017a;
        int r103 = r101.f524019c;
        int r104 = r103 + 1;
        r102[r103] = (byte) ((r100 >>> 24) & 255);
        int r105 = r104 + 1;
        r102[r104] = (byte) ((r100 >>> 16) & 255);
        int r106 = r105 + 1;
        r102[r105] = (byte) ((r100 >>> 8) & 255);
        r102[r106] = (byte) (r100 & 255);
        r101.f524019c = r106 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int r100) {
        a r101 = okio.b.f523972a;
        int r102 = ((((-16777216) & r100) >>> 24) | ((16711680 & r100) >>> 8)) | ((65280 & r100) << 8);
        return writeInt(((r100 & 255) << 24) | r102);
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long r110) {
        g0 r100 = writableSegment$okio(8);
        byte[] r101 = r100.f524017a;
        int r102 = r100.f524019c;
        int r103 = r102 + 1;
        r101[r102] = (byte) ((r110 >>> 56) & 255);
        int r104 = r103 + 1;
        r101[r103] = (byte) ((r110 >>> 48) & 255);
        int r105 = r104 + 1;
        r101[r104] = (byte) ((r110 >>> 40) & 255);
        int r106 = r105 + 1;
        r101[r105] = (byte) ((r110 >>> 32) & 255);
        int r107 = r106 + 1;
        r101[r106] = (byte) ((r110 >>> 24) & 255);
        int r108 = r107 + 1;
        r101[r107] = (byte) ((r110 >>> 16) & 255);
        int r109 = r108 + 1;
        r101[r108] = (byte) ((r110 >>> 8) & 255);
        r101[r109] = (byte) (r110 & 255);
        r100.f524019c = r109 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long r100) {
        return writeLong(okio.b.d(r100));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int r100) {
        g0 r101 = writableSegment$okio(2);
        byte[] r102 = r101.f524017a;
        int r103 = r101.f524019c;
        int r104 = r103 + 1;
        r102[r103] = (byte) ((r100 >>> 8) & 255);
        r102[r104] = (byte) (r100 & 255);
        r101.f524019c = r104 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int r100) {
        a r101 = okio.b.f523972a;
        int r102 = ((short) r100) & 65535;
        int r103 = (65280 & r102) >>> 8;
        return writeShort((short) (((r102 & 255) << 8) | r103));
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return writeUtf8(r100, 0, r100.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int r100) {
        if (r100 >= 128) goto L6;
        writeByte(r100);
    L21:
        return this;
    L6:
        if (r100 >= 2048) goto L8;
        g0 r101 = writableSegment$okio(2);
        byte[] r102 = r101.f524017a;
        int r103 = r101.f524019c;
        r102[r103] = (byte) ((r100 >> 6) | 192);
        r102[r103 + 1] = (byte) ((r100 & 63) | 128);
        r101.f524019c = r103 + 2;
        setSize$okio(size() + 2);
        goto L21
    L8:
        boolean r104 = false;
        if (55296 <= r100) goto L11;
    L13:
        if (r104 == false) goto L16;
        writeByte(63);
        goto L21
    L16:
        if (r100 >= 65536) goto L19;
        g0 r105 = writableSegment$okio(3);
        byte[] r106 = r105.f524017a;
        int r107 = r105.f524019c;
        r106[r107] = (byte) ((r100 >> 12) | 224);
        r106[r107 + 1] = (byte) (((r100 >> 6) & 63) | 128);
        r106[r107 + 2] = (byte) ((r100 & 63) | 128);
        r105.f524019c = r107 + 3;
        setSize$okio(size() + 3);
        goto L21
    L19:
        if (r100 > 1114111) goto L23;
        g0 r108 = writableSegment$okio(4);
        byte[] r109 = r108.f524017a;
        int r110 = r108.f524019c;
        r109[r110] = (byte) ((r100 >> 18) | 240);
        r109[r110 + 1] = (byte) (((r100 >> 12) & 63) | 128);
        r109[r110 + 2] = (byte) (((r100 >> 6) & 63) | 128);
        r109[r110 + 3] = (byte) ((r100 & 63) | 128);
        r108.f524019c = r110 + 4;
        setSize$okio(size() + 4);
        goto L21
    L23:
        throw new IllegalArgumentException("Unexpected code point: 0x" + okio.b.f(r100));
    L11:
        if (r100 >= 57344) goto L13;
        r104 = true;
        goto L13
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        return indexOf(r100, 0);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        return read(r100, 0, r100.length);
    }

    @Override // okio.BufferedSource
    public <T> T select(k0<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        throw null;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "byteString");
        r100.write$okio(this, 0, r100.size());
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r100) {
        return writeByte(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r100) {
        return writeDecimalLong(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r100) {
        return writeHexadecimalUnsignedLong(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r100) {
        return writeInt(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r100) {
        return writeIntLe(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r100) {
        return writeLong(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r100) {
        return writeLongLe(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r100) {
        return writeShort(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r100) {
        return writeShortLe(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r100) {
        return writeUtf8(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r100) {
        return writeUtf8CodePoint(r100);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return write(r100, 0, r100.length);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r100) {
        return write(r100);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r100) {
        return write(r100);
    }

    private final ByteString hmac(String r100, ByteString r101) {
        Mac r102 = Mac.getInstance(r100);     // Catch: InvalidKeyException -> L9
        r102.init(new SecretKeySpec(r101.internalArray$okio(), r100));     // Catch: InvalidKeyException -> L9
        g0 r103 = this.head;     // Catch: InvalidKeyException -> L9
        if (r103 == null) goto L7;
        byte[] r104 = r103.f524017a;     // Catch: InvalidKeyException -> L9
        int r105 = r103.f524018b;     // Catch: InvalidKeyException -> L9
        r102.update(r104, r105, r103.f524019c - r105);     // Catch: InvalidKeyException -> L9
        g0 r106 = r103.f524022f;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r106);     // Catch: InvalidKeyException -> L9
    L5:
        if (r106 == r103) goto L7;
        byte[] r107 = r106.f524017a;     // Catch: InvalidKeyException -> L9
        int r108 = r106.f524018b;     // Catch: InvalidKeyException -> L9
        r102.update(r107, r108, r106.f524019c - r108);     // Catch: InvalidKeyException -> L9
        r106 = r106.f524022f;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r106);     // Catch: InvalidKeyException -> L9
    L7:
        return new ByteString(r102.doFinal());
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public final Buffer copyTo(Buffer r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        return copyTo(r100, r110, this.size - r110);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r110, long r111) throws IOException {
        long r100 = r111;
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        boolean r101 = true;
        if (r110.size() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L53;
        long r103 = 0;
        if (r100 >= 0) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L51;
        g0 r104 = this.head;
        if (r104 != null) goto L16;
    L48:
        return -1;
    L16:
        if ((size() - r100) >= r100) goto L33;
        r103 = size();
    L19:
        if (r103 <= r100) goto L21;
        r104 = r104.f524023g;
        Intrinsics.checkNotNull(r104);
        r103 = r103 - ((long) (r104.f524019c - r104.f524018b));
        goto L19
    L21:
        byte[] r105 = r110.internalArray$okio();
        byte r106 = r105[0];
        int r107 = r110.size();
        long r112 = (size() - ((long) r107)) + 1;
    L23:
        if (r103 >= r112) goto L48;
        byte[] r108 = r104.f524017a;
        int r113 = (int) Math.min(r104.f524019c, (((long) r104.f524018b) + r112) - r103);
        int r109 = (int) ((((long) r104.f524018b) + r100) - r103);
    L25:
        if (r109 >= r113) goto L32;
        if (r108[r109] != r106) goto L31;
        if (okio.internal.a.a(r104, r109 + 1, r105, r107) == false) goto L31;
    L66:
        return ((long) (r109 - r104.f524018b)) + r103;
    L31:
        r109 = r109 + 1;
        goto L25
    L32:
        r103 = r103 + ((long) (r104.f524019c - r104.f524018b));
        r104 = r104.f524022f;
        Intrinsics.checkNotNull(r104);
        r100 = r103;
    L33:
        long r114 = ((long) (r104.f524019c - r104.f524018b)) + r103;
        if (r114 > r100) goto L36;
        r104 = r104.f524022f;
        Intrinsics.checkNotNull(r104);
        r103 = r114;
        goto L33
    L36:
        byte[] r115 = r110.internalArray$okio();
        byte r116 = r115[0];
        int r117 = r110.size();
        long r118 = (size() - ((long) r117)) + 1;
    L38:
        if (r103 >= r118) goto L48;
        byte[] r119 = r104.f524017a;
        int r120 = (int) Math.min(r104.f524019c, (((long) r104.f524018b) + r118) - r103);
        r109 = (int) ((((long) r104.f524018b) + r100) - r103);
    L40:
        if (r109 >= r120) goto L47;
        if (r119[r109] != r116) goto L46;
        if (okio.internal.a.a(r104, r109 + 1, r115, r117) == true) goto L66;
    L46:
        r109 = r109 + 1;
        goto L40
    L47:
        r103 = r103 + ((long) (r104.f524019c - r104.f524018b));
        r104 = r104.f524022f;
        Intrinsics.checkNotNull(r104);
        r100 = r103;
        goto L38
    L51:
        throw new IllegalArgumentException(("fromIndex < 0: " + r100).toString());
    L53:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "targetBytes");
        long r100 = 0;
        if (r111 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L75;
        g0 r102 = this.head;
        if (r102 != null) goto L11;
        return -1;
    L11:
        if ((size() - r111) >= r111) goto L42;
        r100 = size();
    L14:
        if (r100 <= r111) goto L17;
        r102 = r102.f524023g;
        Intrinsics.checkNotNull(r102);
        r100 = r100 - ((long) (r102.f524019c - r102.f524018b));
        goto L14
    L17:
        if (r110.size() != 2) goto L29;
        byte r103 = r110.getByte(0);
        byte r112 = r110.getByte(1);
    L20:
        if (r100 >= size()) goto L95;
        byte[] r104 = r102.f524017a;
        int r113 = (int) ((((long) r102.f524018b) + r111) - r100);
        int r114 = r102.f524019c;
    L22:
        if (r113 >= r114) goto L28;
        byte r105 = r104[r113];
        if (r105 == r103) goto L57;
        if (r105 == r112) goto L57;
        r113 = r113 + 1;
    L57:
        int r115 = r102.f524018b;
    L73:
        return ((long) (r113 - r115)) + r100;
    L28:
        r100 = r100 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r100;
        goto L20
    L95:
        return -1;
    L29:
        byte[] r116 = r110.internalArray$okio();
    L31:
        if (r100 >= size()) goto L96;
        byte[] r106 = r102.f524017a;
        r113 = (int) ((((long) r102.f524018b) + r111) - r100);
        int r117 = r102.f524019c;
    L33:
        if (r113 >= r117) goto L41;
        byte r107 = r106[r113];
        int r108 = r116.length;
        int r109 = 0;
    L35:
        if (r109 >= r108) goto L40;
        if (r107 == r116[r109]) goto L69;
        r109 = r109 + 1;
    L69:
        r115 = r102.f524018b;
        goto L73
    L40:
        r113 = r113 + 1;
        goto L33
    L41:
        r100 = r100 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r100;
        goto L31
    L96:
        return -1;
    L42:
        long r118 = ((long) (r102.f524019c - r102.f524018b)) + r100;
        if (r118 > r111) goto L46;
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r100 = r118;
        goto L42
    L46:
        if (r110.size() != 2) goto L60;
        byte r119 = r110.getByte(0);
        byte r120 = r110.getByte(1);
    L49:
        if (r100 >= size()) goto L97;
        byte[] r121 = r102.f524017a;
        r113 = (int) ((((long) r102.f524018b) + r111) - r100);
        int r122 = r102.f524019c;
    L51:
        if (r113 >= r122) goto L59;
        byte r123 = r121[r113];
        if (r123 == r119) goto L57;
        if (r123 == r120) goto L57;
        r113 = r113 + 1;
        goto L51
    L59:
        r100 = r100 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r100;
        goto L49
    L97:
        return -1;
    L60:
        byte[] r124 = r110.internalArray$okio();
    L62:
        if (r100 >= size()) goto L98;
        byte[] r125 = r102.f524017a;
        r113 = (int) ((((long) r102.f524018b) + r111) - r100);
        int r126 = r102.f524019c;
    L64:
        if (r113 >= r126) goto L72;
        byte r127 = r125[r113];
        int r128 = r124.length;
        int r129 = 0;
    L66:
        if (r129 >= r128) goto L71;
        if (r127 == r124[r129]) goto L69;
        r129 = r129 + 1;
        goto L66
    L71:
        r113 = r113 + 1;
        goto L64
    L72:
        r100 = r100 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r100;
        goto L62
    L98:
        return -1;
    L75:
        throw new IllegalArgumentException(("fromIndex < 0: " + r111).toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r100, ByteString r110) {
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        return rangeEquals(r100, r110, 0, r110.size());
    }

    @Override // okio.Source
    public long read(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L16;
        if (size() != 0) goto L11;
        return -1;
    L11:
        if (r101 <= size()) goto L13;
        r101 = size();
    L13:
        r100.write(this, r101);
        return r101;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
    L5:
        r102 = false;
        goto L6
    }

    public final Buffer readFrom(InputStream r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        readFrom(r100, r101, false);
        return this;
    L10:
        throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r100, long r101) throws EOFException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (size() < r101) goto L6;
        r100.write(this, r101);
        return;
    L6:
        r100.write(this, size());
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readString(long r100, Charset r110) throws EOFException {
        Intrinsics.checkNotNullParameter(r110, "charset");
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L25;
        if (this.size < r100) goto L23;
        if (r100 != 0) goto L14;
        return "";
    L14:
        g0 r102 = this.head;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.f524018b;
        if ((((long) r103) + r100) > r102.f524019c) goto L17;
        int r104 = (int) r100;
        String r105 = new String(r102.f524017a, r103, r104, r110);
        int r111 = r102.f524018b + r104;
        r102.f524018b = r111;
        this.size -= r100;
        if (r111 != r102.f524019c) goto L21;
        this.head = r102.a();
        h0.a(r102);
    L21:
        return r105;
    L17:
        return new String(readByteArray(r100), r110);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r100).toString());
    L5:
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        r101 = true;
        goto L8
    }

    @Override // okio.Sink
    public void write(Buffer r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r110 == this) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L64;
        okio.b.b(r110.size(), 0, r111);
    L9:
        if (r111 <= 0) goto L73;
        g0 r101 = r110.head;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.f524019c;
        g0 r103 = r110.head;
        Intrinsics.checkNotNull(r103);
        if (r111 >= (r102 - r103.f524018b)) goto L40;
        g0 r104 = this.head;
        if (r104 == null) goto L15;
        Intrinsics.checkNotNull(r104);
        g0 r105 = r104.f524023g;
    L16:
        if (r105 != null) goto L18;
    L26:
        g0 r106 = r110.head;
        Intrinsics.checkNotNull(r106);
        int r107 = (int) r111;
        r106.getClass();
        if (r107 > 0) goto L29;
    L31:
        boolean r108 = false;
    L32:
        if (r108 == false) goto L39;
        if (r107 < 1024) goto L36;
        g0 r109 = r106.c();
    L37:
        r109.f524019c = r109.f524018b + r107;
        r106.f524018b += r107;
        g0 r112 = r106.f524023g;
        Intrinsics.checkNotNull(r112);
        r112.b(r109);
        r110.head = r109;
        goto L40
    L36:
        r109 = h0.b();
        byte[] r113 = r106.f524017a;
        byte[] r114 = r109.f524017a;
        int r115 = r106.f524018b;
        ArraysKt.copyInto$default(r113, r114, 0, r115, r115 + r107, 2, null);
        goto L37
    L39:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L29:
        if (r107 > (r106.f524019c - r106.f524018b)) goto L31;
        r108 = true;
        goto L32
    L18:
        if (r105.f524021e == false) goto L26;
        long r116 = ((long) r105.f524019c) + r111;
        if (r105.f524020d == false) goto L22;
        int r117 = 0;
    L24:
        if ((r116 - ((long) r117)) > PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L26;
        g0 r118 = r110.head;
        Intrinsics.checkNotNull(r118);
        r118.d(r105, (int) r111);
        r110.setSize$okio(r110.size() - r111);
        setSize$okio(size() + r111);
        return;
    L22:
        r117 = r105.f524018b;
        goto L24
    L15:
        r105 = null;
    L40:
        g0 r119 = r110.head;
        Intrinsics.checkNotNull(r119);
        long r120 = r119.f524019c - r119.f524018b;
        r110.head = r119.a();
        g0 r121 = this.head;
        if (r121 != null) goto L43;
        this.head = r119;
        r119.f524023g = r119;
        r119.f524022f = r119;
    L59:
        r110.setSize$okio(r110.size() - r120);
        setSize$okio(size() + r120);
        r111 = r111 - r120;
        goto L9
    L43:
        Intrinsics.checkNotNull(r121);
        g0 r122 = r121.f524023g;
        Intrinsics.checkNotNull(r122);
        r122.b(r119);
        g0 r123 = r119.f524023g;
        if (r123 == r119) goto L46;
        boolean r124 = true;
    L47:
        if (r124 == false) goto L61;
        Intrinsics.checkNotNull(r123);
        if (r123.f524021e == false) goto L59;
        int r125 = r119.f524019c - r119.f524018b;
        g0 r126 = r119.f524023g;
        Intrinsics.checkNotNull(r126);
        int r127 = 8192 - r126.f524019c;
        g0 r128 = r119.f524023g;
        Intrinsics.checkNotNull(r128);
        if (r128.f524020d == false) goto L54;
        int r129 = 0;
    L56:
        if (r125 > (r127 + r129)) goto L59;
        g0 r130 = r119.f524023g;
        Intrinsics.checkNotNull(r130);
        r119.d(r130, r125);
        r119.a();
        h0.a(r119);
        goto L59
    L54:
        g0 r131 = r119.f524023g;
        Intrinsics.checkNotNull(r131);
        r129 = r131.f524018b;
        goto L56
    L61:
        throw new IllegalStateException("cannot compact".toString());
    L46:
        r124 = false;
        goto L47
    L73:
        return;
    L64:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r100 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return writeString(r100, 0, r100.length(), r101);
    }

    public final Buffer writeTo(OutputStream r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        okio.b.b(this.size, 0, r101);
        g0 r102 = this.head;
    L4:
        if (r101 <= 0) goto L8;
        Intrinsics.checkNotNull(r102);
        int r103 = (int) Math.min(r101, r102.f524019c - r102.f524018b);
        r100.write(r102.f524017a, r102.f524018b, r103);
        int r104 = r102.f524018b + r103;
        r102.f524018b = r104;
        long r105 = r103;
        this.size -= r105;
        r101 = r101 - r105;
        if (r104 != r102.f524019c) goto L4;
        g0 r106 = r102.a();
        this.head = r106;
        h0.a(r102);
        r102 = r106;
        goto L4
    L8:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r100, long r101) {
        return indexOf(r100, r101, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSink
    public Buffer write(Source r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
    L4:
        if (r101 <= 0) goto L10;
        long r102 = r100.read(this, r101);
        if (r102 == (-1)) goto L9;
        r101 = r101 - r102;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r100, Charset r101) {
        return writeString(r100, r101);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(Source r100, long r101) {
        return write(r100, r101);
    }

    private final void readFrom(InputStream r100, long r101, boolean r102) throws IOException {
    L3:
        if (r101 > 0) goto L7;
        if (r102 == true) goto L7;
        return;
    L7:
        g0 r103 = writableSegment$okio(1);
        int r104 = r100.read(r103.f524017a, r103.f524019c, (int) Math.min(r101, 8192 - r103.f524019c));
        if (r104 == (-1)) goto L10;
        r103.f524019c += r104;
        long r105 = r104;
        this.size += r105;
        r101 = r101 - r105;
        goto L3
    L10:
        if (r103.f524018b != r103.f524019c) goto L12;
        this.head = r103.a();
        h0.a(r103);
    L12:
        if (r102 == false) goto L15;
        return;
    L15:
        throw new EOFException();
    }

    public final Buffer copyTo(Buffer r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        okio.b.b(size(), r101, r110);
        if (r110 == 0) goto L16;
        r100.setSize$okio(r100.size() + r110);
        g0 r102 = this.head;
    L6:
        Intrinsics.checkNotNull(r102);
        long r103 = r102.f524019c - r102.f524018b;
        if (r101 < r103) goto L10;
        r101 = r101 - r103;
        r102 = r102.f524022f;
    L10:
        if (r110 <= 0) goto L16;
        Intrinsics.checkNotNull(r102);
        g0 r104 = r102.c();
        int r105 = r104.f524018b + ((int) r101);
        r104.f524018b = r105;
        r104.f524019c = Math.min(r105 + ((int) r110), r104.f524019c);
        g0 r106 = r100.head;
        if (r106 != null) goto L14;
        r104.f524023g = r104;
        r104.f524022f = r104;
        r100.head = r104;
    L15:
        r110 = r110 - ((long) (r104.f524019c - r104.f524018b));
        r102 = r102.f524022f;
        r101 = 0;
        goto L10
    L14:
        Intrinsics.checkNotNull(r106);
        g0 r107 = r106.f524023g;
        Intrinsics.checkNotNull(r107);
        r107.b(r104);
    L16:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r110, long r111, long r112) {
        boolean r100 = false;
        long r101 = 0;
        if (0 <= r111) goto L5;
    L7:
        if (r100 == false) goto L46;
        if (r112 <= size()) goto L12;
        r112 = size();
    L12:
        if (r111 == r112) goto L55;
        g0 r102 = this.head;
        if (r102 != null) goto L18;
        return -1;
    L18:
        if ((size() - r111) >= r111) goto L32;
        r101 = size();
    L21:
        if (r101 <= r111) goto L24;
        r102 = r102.f524023g;
        Intrinsics.checkNotNull(r102);
        r101 = r101 - ((long) (r102.f524019c - r102.f524018b));
    L24:
        if (r101 >= r112) goto L57;
        byte[] r103 = r102.f524017a;
        int r104 = (int) Math.min(r102.f524019c, (((long) r102.f524018b) + r112) - r101);
        int r113 = (int) ((((long) r102.f524018b) + r111) - r101);
    L26:
        if (r113 >= r104) goto L31;
        if (r103[r113] == r110) goto L44;
        r113 = r113 + 1;
    L44:
        return ((long) (r113 - r102.f524018b)) + r101;
    L31:
        r101 = r101 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r101;
        goto L24
    L57:
        return -1;
    L32:
        long r105 = ((long) (r102.f524019c - r102.f524018b)) + r101;
        if (r105 > r111) goto L36;
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r101 = r105;
    L36:
        if (r101 >= r112) goto L58;
        byte[] r106 = r102.f524017a;
        int r107 = (int) Math.min(r102.f524019c, (((long) r102.f524018b) + r112) - r101);
        r113 = (int) ((((long) r102.f524018b) + r111) - r101);
    L38:
        if (r113 >= r107) goto L43;
        if (r106[r113] == r110) goto L44;
        r113 = r113 + 1;
        goto L38
    L43:
        r101 = r101 + ((long) (r102.f524019c - r102.f524018b));
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        r111 = r101;
        goto L36
    L58:
        return -1;
    L55:
        return -1;
    L46:
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + r111 + " toIndex=" + r112).toString());
    L5:
        if (r111 > r112) goto L7;
        r100 = true;
        goto L7
    }

    @Override // okio.BufferedSource
    public int read(byte[] r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        okio.b.b(r100.length, r101, r110);
        g0 r102 = this.head;
        if (r102 != null) goto L5;
        return -1;
    L5:
        int r111 = Math.min(r110, r102.f524019c - r102.f524018b);
        byte[] r103 = r102.f524017a;
        int r104 = r102.f524018b;
        ArraysKt.copyInto(r103, r100, r101, r104, r104 + r111);
        r102.f524018b += r111;
        setSize$okio(size() - ((long) r111));
        if (r102.f524018b != r102.f524019c) goto L9;
        this.head = r102.a();
        h0.a(r102);
    L9:
        return r111;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "source");
        long r100 = r112;
        okio.b.b(r110.length, r111, r100);
        int r113 = r112 + r111;
    L3:
        if (r111 >= r113) goto L5;
        g0 r101 = writableSegment$okio(1);
        int r102 = Math.min(r113 - r111, 8192 - r101.f524019c);
        int r103 = r111 + r102;
        ArraysKt.copyInto(r110, r101.f524017a, r101.f524019c, r111, r103);
        r101.f524019c += r102;
        r111 = r103;
        goto L3
    L5:
        setSize$okio(size() + r100);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "string");
        if (r111 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L58;
        if (r112 < r111) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L56;
        if (r112 > r110.length()) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L54;
    L16:
        if (r111 >= r112) goto L52;
        char r103 = r110.charAt(r111);
        if (r103 < 128) goto L19;
        if (r103 < 2048) goto L28;
        if (r103 < 55296) goto L51;
        if (r103 > 57343) goto L51;
        int r104 = r111 + 1;
        if (r104 >= r112) goto L38;
        char r105 = r110.charAt(r104);
    L40:
        if (r103 > 56319) goto L50;
        if (56320 <= r105) goto L44;
    L46:
        boolean r106 = false;
    L47:
        if (r106 == false) goto L50;
        int r107 = (((r103 & 1023) << 10) | (r105 & 1023)) + 65536;
        g0 r108 = writableSegment$okio(4);
        byte[] r109 = r108.f524017a;
        int r113 = r108.f524019c;
        r109[r113] = (byte) ((r107 >> 18) | 240);
        r109[r113 + 1] = (byte) (((r107 >> 12) & 63) | 128);
        r109[r113 + 2] = (byte) (((r107 >> 6) & 63) | 128);
        r109[r113 + 3] = (byte) ((r107 & 63) | 128);
        r108.f524019c = r113 + 4;
        setSize$okio(size() + 4);
        r111 = r111 + 2;
        goto L16
    L44:
        if (r105 >= 57344) goto L46;
        r106 = true;
    L50:
        writeByte(63);
        r111 = r104;
        goto L16
    L38:
        r105 = 0;
    L51:
        g0 r114 = writableSegment$okio(3);
        byte[] r115 = r114.f524017a;
        int r116 = r114.f524019c;
        r115[r116] = (byte) ((r103 >> '\f') | 224);
        r115[r116 + 1] = (byte) ((63 & (r103 >> 6)) | 128);
        r115[r116 + 2] = (byte) ((r103 & '?') | 128);
        r114.f524019c = r116 + 3;
        setSize$okio(size() + 3);
    L29:
        r111 = r111 + 1;
        goto L16
    L28:
        g0 r117 = writableSegment$okio(2);
        byte[] r118 = r117.f524017a;
        int r119 = r117.f524019c;
        r118[r119] = (byte) ((r103 >> 6) | 192);
        r118[r119 + 1] = (byte) ((r103 & '?') | 128);
        r117.f524019c = r119 + 2;
        setSize$okio(size() + 2);
        goto L29
    L19:
        g0 r120 = writableSegment$okio(1);
        byte[] r121 = r120.f524017a;
        int r122 = r120.f524019c - r111;
        int r123 = Math.min(r112, 8192 - r122);
        int r124 = r111 + 1;
        r121[r111 + r122] = (byte) r103;
    L20:
        r111 = r124;
        if (r111 >= r123) goto L25;
        char r125 = r110.charAt(r111);
        if (r125 >= 128) goto L25;
        r124 = r111 + 1;
        r121[r111 + r122] = (byte) r125;
    L25:
        int r126 = r120.f524019c;
        int r127 = (r122 + r111) - r126;
        r120.f524019c = r126 + r127;
        setSize$okio(size() + ((long) r127));
        goto L16
    L52:
        return this;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r112 + " > " + r110.length()).toString());
    L14:
        r102 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r112 + " < " + r111).toString());
    L9:
        r101 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r111).toString());
    L5:
        r100 = false;
        goto L6
    }

    public final Buffer copyTo(OutputStream r100, long r110, long r111) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        okio.b.b(this.size, r110, r111);
        if (r111 != 0) goto L5;
        return this;
    L5:
        g0 r101 = this.head;
    L6:
        Intrinsics.checkNotNull(r101);
        int r102 = r101.f524019c;
        int r103 = r101.f524018b;
        if (r110 < (r102 - r103)) goto L10;
        r110 = r110 - ((long) (r102 - r103));
        r101 = r101.f524022f;
    L10:
        if (r111 <= 0) goto L12;
        Intrinsics.checkNotNull(r101);
        int r112 = (int) (((long) r101.f524018b) + r110);
        int r113 = (int) Math.min(r101.f524019c - r112, r111);
        r100.write(r101.f524017a, r112, r113);
        r111 = r111 - ((long) r113);
        r101 = r101.f524022f;
        r110 = 0;
        goto L10
    L12:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "byteString");
        r100.write$okio(this, r101, r102);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r100, int r101, int r102) {
        return writeUtf8(r100, r101, r102);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r100, int r101, int r102) {
        return write(r100, r101, r102);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r100, int r101, int r102) {
        return write(r100, r101, r102);
    }

    public static /* synthetic */ a readAndWriteUnsafe$default(Buffer r100, a r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = okio.b.f523972a;
    L6:
        return r100.readAndWriteUnsafe(r101);
    }

    public static /* synthetic */ a readUnsafe$default(Buffer r100, a r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = okio.b.f523972a;
    L6:
        return r100.readUnsafe(r101);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r100, ByteString r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
        if (r100 < 0) goto L21;
        if (r110 < 0) goto L22;
        if (r111 >= 0) goto L7;
        return false;
    L7:
        if ((size() - r100) >= r111) goto L9;
        return false;
    L9:
        if ((r101.size() - r110) < r111) goto L25;
        int r102 = 0;
    L12:
        if (r102 >= r111) goto L17;
        if (getByte(((long) r102) + r100) != r101.getByte(r110 + r102)) goto L26;
        r102 = r102 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r100, int r101, int r102, Charset r103) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Intrinsics.checkNotNullParameter(r103, "charset");
        boolean r104 = true;
        if (r101 < 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L27;
        if (r102 < r101) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L25;
        if (r102 <= r100.length()) goto L15;
        r104 = false;
    L15:
        if (r104 == false) goto L23;
        if (Intrinsics.areEqual(r103, Charsets.UTF_8) == true) goto L19;
        byte[] r107 = r100.substring(r101, r102).getBytes(r103);
        return write(r107, 0, r107.length);
    L19:
        return writeUtf8(r100, r101, r102);
    L23:
        throw new IllegalArgumentException(("endIndex > string.length: " + r102 + " > " + r100.length()).toString());
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r102 + " < " + r101).toString());
    L9:
        r106 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(("beginIndex < 0: " + r101).toString());
    L5:
        r105 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r100, int r101, int r102, Charset r103) {
        return writeString(r100, r101, r102, r103);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r100, Buffer r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.copyTo(r101, r102);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer r100, OutputStream r101, long r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100.size;
    L6:
        return r100.writeTo(r101, r102);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r100, OutputStream r101, long r102, long r110, int r111, Object r112) throws IOException {
        if ((r111 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        long r103 = r102;
        if ((r111 & 4) == 0) goto L9;
        r110 = r100.size - r103;
    L9:
        return r100.copyTo(r101, r103, r110);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r100, Buffer r101, long r102, long r110, int r111, Object r112) {
        if ((r111 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.copyTo(r101, r102, r110);
    }
}
