package com.larus.bmhome.metadata;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes26.dex */
public final class ExifInterface2 {
    public static final byte[] A = null;
    public static final byte[] B = null;
    public static final byte[] C = null;
    public static final byte[] D = null;
    public static final byte[] E = null;
    public static final byte[] F = null;
    public static final byte[] G = null;
    public static final byte[] H = null;
    public static final byte[] I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte[] f312480J = null;
    public static final byte[] K = null;
    public static final byte[] L = null;
    public static final byte[] M = null;
    public static final byte[] N = null;
    public static final byte[] O = null;
    public static final String[] P = null;
    public static final int[] Q = null;
    public static final byte[] R = null;
    public static final e S = null;
    public static final e[][] T = null;
    public static final e[] U = null;
    public static final e V = null;
    public static final e W = null;
    public static final HashMap<Integer, e>[] X = null;
    public static final HashMap<String, e>[] Y = null;
    public static final HashSet<String> Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f312481a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Charset f312482b0 = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final byte[] f312483c0 = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final Pattern f312484d0 = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final Pattern f312485e0 = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final Pattern f312486f0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f312487r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final List<Integer> f312488s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final List<Integer> f312489t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f312490u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f312491v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f312492w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f312493x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final byte[] f312494y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte[] f312495z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f312496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f312497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f312498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f312499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, d>[] f312500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Integer> f312501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteOrder f312502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f312503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f312504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f312505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f312506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f312507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f312508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f312509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f312510o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f312511p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f312512q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public class a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f312513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f312514b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public final long getSize() throws IOException {
            return -1;
        }

        public a(b r100) {
            this.f312514b = r100;
        }

        @Override // android.media.MediaDataSource
        public final int readAt(long r100, byte[] r101, int r110, int r111) throws IOException {
            if (r111 != 0) goto L6;
            return 0;
        L6:
            if (r100 >= 0) goto L26;
            return -1;
        L26:
            long r102 = this.f312513a;     // Catch: IOException -> L25
            if (r102 == r100) goto L17;
            if (r102 >= 0) goto L13;
        L15:
            this.f312514b.a(r100);     // Catch: IOException -> L25
            this.f312513a = r100;     // Catch: IOException -> L25
            goto L17
        L13:
            if (r100 < (r102 + ((long) this.f312514b.available()))) goto L15;
            return -1;
        L17:
            if (r111 <= this.f312514b.available()) goto L19;
            r111 = this.f312514b.available();     // Catch: IOException -> L25
        L19:
            int r103 = this.f312514b.read(r101, r110, r111);     // Catch: IOException -> L25
            if (r103 < 0) goto L23;
            this.f312513a += (long) r103;     // Catch: IOException -> L25
            return r103;
        L23:
            this.f312513a = -1;
            return -1;
        }
    }

    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ByteOrder f312515e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ByteOrder f312516f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f312517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f312518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f312519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f312520d;

        static {
            f312515e = ByteOrder.LITTLE_ENDIAN;
            f312516f = ByteOrder.BIG_ENDIAN;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            return this.f312517a.available();
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            this.f312520d++;
            return this.f312517a.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() throws IOException {
            this.f312520d++;
            return this.f312517a.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            int r100 = this.f312520d + 1;
            this.f312520d = r100;
            if (r100 > this.f312519c) goto L11;
            int r101 = this.f312517a.read();
            if (r101 < 0) goto L9;
            return (byte) r101;
        L9:
            throw new EOFException();
        L11:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() throws IOException {
            this.f312520d += 2;
            return this.f312517a.readChar();
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            int r100 = this.f312520d + 4;
            this.f312520d = r100;
            if (r100 > this.f312519c) goto L19;
            int r101 = this.f312517a.read();
            int r102 = this.f312517a.read();
            int r103 = this.f312517a.read();
            int r104 = this.f312517a.read();
            if ((((r101 | r102) | r103) | r104) < 0) goto L17;
            ByteOrder r105 = this.f312518b;
            if (r105 != f312515e) goto L11;
            return (((r104 << 24) + (r103 << 16)) + (r102 << 8)) + r101;
        L11:
            if (r105 != f312516f) goto L15;
            return (((r101 << 24) + (r102 << 16)) + (r103 << 8)) + r104;
        L15:
            throw new IOException("Invalid byte order: " + this.f312518b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readLine() throws IOException {
            FLogger.f375446a.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            int r100 = this.f312520d + 8;
            this.f312520d = r100;
            if (r100 > this.f312519c) goto L19;
            int r101 = this.f312517a.read();
            int r102 = this.f312517a.read();
            int r103 = this.f312517a.read();
            int r104 = this.f312517a.read();
            int r105 = this.f312517a.read();
            int r106 = this.f312517a.read();
            int r107 = this.f312517a.read();
            int r108 = this.f312517a.read();
            if ((((((((r101 | r102) | r103) | r104) | r105) | r106) | r107) | r108) < 0) goto L17;
            ByteOrder r110 = this.f312518b;
            if (r110 != f312515e) goto L11;
            return (((((((((long) r108) << 56) + (((long) r107) << 48)) + (((long) r106) << 40)) + (((long) r105) << 32)) + (((long) r104) << 24)) + (((long) r103) << 16)) + (((long) r102) << 8)) + ((long) r101);
        L11:
            if (r110 != f312516f) goto L15;
            return (((((((((long) r101) << 56) + (((long) r102) << 48)) + (((long) r103) << 40)) + (((long) r104) << 32)) + (((long) r105) << 24)) + (((long) r106) << 16)) + (((long) r107) << 8)) + ((long) r108);
        L15:
            throw new IOException("Invalid byte order: " + this.f312518b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            int r100 = this.f312520d + 2;
            this.f312520d = r100;
            if (r100 > this.f312519c) goto L19;
            int r101 = this.f312517a.read();
            int r102 = this.f312517a.read();
            if ((r101 | r102) < 0) goto L17;
            ByteOrder r103 = this.f312518b;
            if (r103 != f312515e) goto L11;
            return (short) ((r102 << 8) + r101);
        L11:
            if (r103 != f312516f) goto L15;
            return (short) ((r101 << 8) + r102);
        L15:
            throw new IOException("Invalid byte order: " + this.f312518b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readUTF() throws IOException {
            this.f312520d += 2;
            return this.f312517a.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() throws IOException {
            this.f312520d++;
            return this.f312517a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            int r100 = this.f312520d + 2;
            this.f312520d = r100;
            if (r100 > this.f312519c) goto L19;
            int r101 = this.f312517a.read();
            int r102 = this.f312517a.read();
            if ((r101 | r102) < 0) goto L17;
            ByteOrder r103 = this.f312518b;
            if (r103 != f312515e) goto L11;
            return (r102 << 8) + r101;
        L11:
            if (r103 != f312516f) goto L15;
            return (r101 << 8) + r102;
        L15:
            throw new IOException("Invalid byte order: " + this.f312518b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public b(byte[] r100) throws IOException {
            this(new ByteArrayInputStream(r100));
        }

        public final void a(long r100) throws IOException {
            int r101 = this.f312520d;
            if (r101 <= r100) goto L5;
            this.f312520d = 0;
            this.f312517a.reset();
            this.f312517a.mark(this.f312519c);
        L6:
            int r102 = (int) r100;
            if (skipBytes(r102) != r102) goto L10;
            return;
        L10:
            throw new IOException("Couldn't seek up to the byteCount");
        L5:
            r100 = r100 - ((long) r101);
            goto L6
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int r100) {
            monitor-enter(this);
            this.f312517a.mark(r100);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] r100) throws IOException {
            int r101 = this.f312520d + r100.length;
            this.f312520d = r101;
            if (r101 > this.f312519c) goto L10;
            if (this.f312517a.read(r100, 0, r100.length) != r100.length) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final int skipBytes(int r100) throws IOException {
            int r101 = Math.min(r100, this.f312519c - this.f312520d);
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r102 = r102 + this.f312517a.skipBytes(r101 - r102);
            goto L3
        L5:
            this.f312520d += r102;
            return r102;
        }

        public b(InputStream r100) throws IOException {
            this(r100, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream r100, ByteOrder r101) throws IOException {
            this.f312518b = ByteOrder.BIG_ENDIAN;
            DataInputStream r102 = new DataInputStream(r100);
            this.f312517a = r102;
            int r103 = r102.available();
            this.f312519c = r103;
            this.f312520d = 0;
            r102.mark(r103);
            this.f312518b = r101;
        }

        @Override // java.io.InputStream
        public final int read(byte[] r100, int r101, int r102) throws IOException {
            int r103 = this.f312517a.read(r100, r101, r102);
            this.f312520d += r103;
            return r103;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] r100, int r101, int r102) throws IOException {
            int r103 = this.f312520d + r102;
            this.f312520d = r103;
            if (r103 > this.f312519c) goto L10;
            if (this.f312517a.read(r100, r101, r102) != r102) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }
    }

    public static class c extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f312521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f312522b;

        public final void a(int r100) throws IOException {
            this.f312521a.write(r100);
        }

        public final void b(int r100) throws IOException {
            ByteOrder r101 = this.f312522b;
            if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.f312521a.write((r100 >>> 0) & 255);
            this.f312521a.write((r100 >>> 8) & 255);
            this.f312521a.write((r100 >>> 16) & 255);
            this.f312521a.write((r100 >>> 24) & 255);
            return;
        L6:
            if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
            this.f312521a.write((r100 >>> 24) & 255);
            this.f312521a.write((r100 >>> 16) & 255);
            this.f312521a.write((r100 >>> 8) & 255);
            this.f312521a.write((r100 >>> 0) & 255);
            return;
        }

        public final void c(short r100) throws IOException {
            ByteOrder r101 = this.f312522b;
            if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.f312521a.write((r100 >>> 0) & 255);
            this.f312521a.write((r100 >>> 8) & 255);
            return;
        L6:
            if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
            this.f312521a.write((r100 >>> 8) & 255);
            this.f312521a.write((r100 >>> 0) & 255);
            return;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r100) throws IOException {
            this.f312521a.write(r100);
        }

        public c(OutputStream r100, ByteOrder r101) {
            super(r100);
            this.f312521a = r100;
            this.f312522b = r101;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r100, int r101, int r102) throws IOException {
            this.f312521a.write(r100, r101, r102);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f312523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f312524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f312525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f312526d;

        public final String toString() {
            return "(" + ExifInterface2.P[this.f312523a] + ", data length:" + this.f312526d.length + ")";
        }

        public static d a(String r100) {
            byte[] r101 = r100.concat("\u0000").getBytes(ExifInterface2.f312482b0);
            return new d(2, r101.length, r101);
        }

        public final double g(ByteOrder r100) {
            Object r101 = j(r100);
            if (r101 == null) goto L43;
            if ((r101 instanceof String) == false) goto L9;
            return CastDoubleProtector.parseDouble((String) r101);
        L9:
            if ((r101 instanceof long[]) == false) goto L17;
            long[] r102 = (long[]) r101;
            if (r102.length != 1) goto L15;
            return r102[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r101 instanceof int[]) == false) goto L25;
            int[] r103 = (int[]) r101;
            if (r103.length != 1) goto L23;
            return r103[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r101 instanceof double[]) == false) goto L33;
            double[] r104 = (double[]) r101;
            if (r104.length != 1) goto L31;
            return r104[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r101 instanceof f[]) == false) goto L41;
            f[] r105 = (f[]) r101;
            if (r105.length != 1) goto L39;
            f r106 = r105[0];
            return r106.f312531a / r106.f312532b;
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public final int h(ByteOrder r100) {
            Object r101 = j(r100);
            if (r101 == null) goto L27;
            if ((r101 instanceof String) == false) goto L9;
            return CastIntegerProtector.parseInt((String) r101);
        L9:
            if ((r101 instanceof long[]) == false) goto L17;
            long[] r102 = (long[]) r101;
            if (r102.length != 1) goto L15;
            return (int) r102[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r101 instanceof int[]) == false) goto L25;
            int[] r103 = (int[]) r101;
            if (r103.length != 1) goto L23;
            return r103[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public final String i(ByteOrder r100) {
            Object r101 = j(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            if ((r101 instanceof String) == true) goto L8;
            StringBuilder r102 = new StringBuilder();
            int r103 = 0;
            if ((r101 instanceof long[]) == false) goto L20;
            long[] r104 = (long[]) r101;
        L13:
            if (r103 >= r104.length) goto L18;
            r102.append(r104[r103]);
            r103 = r103 + 1;
            if (r103 == r104.length) goto L13;
            r102.append(",");
            goto L13
        L18:
            return r102.toString();
        L20:
            if ((r101 instanceof int[]) == false) goto L30;
            int[] r105 = (int[]) r101;
        L23:
            if (r103 >= r105.length) goto L28;
            r102.append(r105[r103]);
            r103 = r103 + 1;
            if (r103 == r105.length) goto L23;
            r102.append(",");
            goto L23
        L28:
            return r102.toString();
        L30:
            if ((r101 instanceof double[]) == false) goto L40;
            double[] r106 = (double[]) r101;
        L33:
            if (r103 >= r106.length) goto L38;
            r102.append(r106[r103]);
            r103 = r103 + 1;
            if (r103 == r106.length) goto L33;
            r102.append(",");
            goto L33
        L38:
            return r102.toString();
        L40:
            if ((r101 instanceof f[]) == false) goto L49;
            f[] r107 = (f[]) r101;
        L43:
            if (r103 >= r107.length) goto L48;
            r102.append(r107[r103].f312531a);
            r102.append('/');
            r102.append(r107[r103].f312532b);
            r103 = r103 + 1;
            if (r103 == r107.length) goto L43;
            r102.append(",");
            goto L43
        L48:
            return r102.toString();
        L49:
            return null;
        L8:
            return (String) r101;
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01bf: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777663), block:B:151:0x01bf */
        public final Object j(ByteOrder r110) {
            InputStream r100 = null;
            b r101 = new b(this.f312526d);     // Catch: Throwable -> L139 IOException -> L141
            r101.f312518b = r110;     // Catch: IOException -> L62 Throwable -> L150
            int r102 = 0;
            boolean r103 = true;
            switch(this.f312523a) {
                case 1: goto L117;
                case 2: goto L90;
                case 3: goto L79;
                case 4: goto L69;
                case 5: goto L57;
                case 6: goto L117;
                case 7: goto L90;
                case 8: goto L47;
                case 9: goto L37;
                case 10: goto L27;
                case 11: goto L17;
                case 12: goto L7;
                default: goto L183;
            };     // Catch: IOException -> L62 Throwable -> L150
        L7:
            double[] r111 = new double[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L9:
            if (r102 >= this.f312524b) goto L172;
            r111[r102] = r101.readDouble();     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L9
        L172:
            r101.close();     // Catch: IOException -> L14
        L16:
            return r111;
        L14:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L16
        L17:
            double[] r112 = new double[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L19:
            if (r102 >= this.f312524b) goto L177;
            r112[r102] = r101.readFloat();     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L19
        L177:
            r101.close();     // Catch: IOException -> L24
        L26:
            return r112;
        L24:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L26
        L27:
            f[] r113 = new f[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L29:
            if (r102 >= this.f312524b) goto L164;
            r113[r102] = new f(r101.readInt(), r101.readInt());     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L29
        L164:
            r101.close();     // Catch: IOException -> L34
        L36:
            return r113;
        L34:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L36
        L37:
            int[] r114 = new int[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L39:
            if (r102 >= this.f312524b) goto L170;
            r114[r102] = r101.readInt();     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L39
        L170:
            r101.close();     // Catch: IOException -> L44
        L46:
            return r114;
        L44:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L46
        L47:
            int[] r115 = new int[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L49:
            if (r102 >= this.f312524b) goto L175;
            r115[r102] = r101.readShort();     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L49
        L175:
            r101.close();     // Catch: IOException -> L54
        L56:
            return r115;
        L54:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L56
        L57:
            f[] r116 = new f[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L59:
            if (r102 >= this.f312524b) goto L158;
            r116[r102] = new f(((long) r101.readInt()) & BodyPartID.bodyIdMax, ((long) r101.readInt()) & BodyPartID.bodyIdMax);     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L59
        L158:
            r101.close();     // Catch: IOException -> L66
        L68:
            return r116;
        L66:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L68
        L69:
            long[] r117 = new long[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L71:
            if (r102 >= this.f312524b) goto L162;
            r117[r102] = ((long) r101.readInt()) & BodyPartID.bodyIdMax;     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L71
        L162:
            r101.close();     // Catch: IOException -> L76
        L78:
            return r117;
        L76:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L78
        L79:
            int[] r118 = new int[this.f312524b];     // Catch: IOException -> L62 Throwable -> L150
        L81:
            if (r102 >= this.f312524b) goto L166;
            r118[r102] = r101.readUnsignedShort();     // Catch: IOException -> L62 Throwable -> L150
            r102 = r102 + 1;
            goto L81
        L166:
            r101.close();     // Catch: IOException -> L86
        L88:
            return r118;
        L86:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L88
        L117:
            byte[] r119 = this.f312526d;     // Catch: IOException -> L62 Throwable -> L150
            if (r119.length != 1) goto L128;
            byte r104 = r119[0];     // Catch: IOException -> L62 Throwable -> L150
            if (r104 < 0) goto L128;
            if (r104 > 1) goto L128;
            String r120 = new String(new char[]{(char) (r104 + 48)});     // Catch: IOException -> L62 Throwable -> L150
            r101.close();     // Catch: IOException -> L125
        L127:
            return r120;
        L125:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L128:
            String r105 = new String(r119, ExifInterface2.f312482b0);     // Catch: IOException -> L62 Throwable -> L150
            r101.close();     // Catch: IOException -> L131
        L133:
            return r105;
        L131:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L133
        L183:
            r101.close();     // Catch: IOException -> L136
        L138:
            return null;
        L136:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L138
        L90:
            if (this.f312524b < ExifInterface2.R.length) goto L100;
            int r121 = 0;
        L92:
            byte[] r106 = ExifInterface2.R;     // Catch: IOException -> L62 Throwable -> L150
            if (r121 >= r106.length) goto L98;
            if (this.f312526d[r121] != r106[r121]) goto L96;
            r121 = r121 + 1;     // Catch: IOException -> L62 Throwable -> L150
            goto L92
        L96:
            r103 = false;
        L98:
            if (r103 == false) goto L100;
            r102 = r106.length;     // Catch: IOException -> L62 Throwable -> L150
        L100:
            StringBuilder r122 = new StringBuilder();     // Catch: IOException -> L62 Throwable -> L150
        L102:
            if (r102 >= this.f312524b) goto L111;
            byte r107 = this.f312526d[r102];     // Catch: IOException -> L62 Throwable -> L150
            if (r107 == 0) goto L111;
            if (r107 < 32) goto L109;
            r122.append((char) r107);     // Catch: IOException -> L62 Throwable -> L150
        L110:
            r102 = r102 + 1;     // Catch: IOException -> L62 Throwable -> L150
            goto L102
        L109:
            r122.append('?');     // Catch: IOException -> L62 Throwable -> L150
        L111:
            String r123 = r122.toString();     // Catch: IOException -> L62 Throwable -> L150
            r101.close();     // Catch: IOException -> L114
        L116:
            return r123;
        L114:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L62:
            e = e;
        L143:
            FLogger.f375446a.w("ExifInterface", "IOException occurred during reading a value", e);     // Catch: Throwable -> L150
            if (r101 != null) goto L160;
        L149:
            return null;
        L160:
            r101.close();     // Catch: IOException -> L147
        L147:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L149
        L150:
            th = th;
            r100 = r3;
        L152:
            if (r100 != null) goto L179;
        L157:
            throw th;
        L179:
            r100.close();     // Catch: IOException -> L155
        L155:
            e = move-exception;
            FLogger.f375446a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L141:
            e = e;
            r101 = null;
        L139:
            th = th;
            goto L152
        }

        public static d b(long r100, ByteOrder r101) {
            return c(new long[]{r100}, r101);
        }

        public static d c(long[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface2.Q[4] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putInt((int) r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new d(4, r100.length, r102.array());
        }

        public static d d(f[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface2.Q[5] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            f r105 = r100[r104];
            r102.putInt((int) r105.f312531a);
            r102.putInt((int) r105.f312532b);
            r104 = r104 + 1;
            goto L3
        L6:
            return new d(5, r100.length, r102.array());
        }

        public static d e(int r100, ByteOrder r101) {
            return f(new int[]{r100}, r101);
        }

        public static d f(int[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface2.Q[3] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putShort((short) r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new d(3, r100.length, r102.array());
        }

        public d(int r100, int r101, byte[] r102) {
            this(r100, r101, -1, r102);
        }

        public d(int r100, int r101, long r102, byte[] r103) {
            this.f312523a = r100;
            this.f312524b = r101;
            this.f312525c = r102;
            this.f312526d = r103;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f312527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f312528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f312529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f312530d;

        public e(String r100, int r101, int r102) {
            this.f312528b = r100;
            this.f312527a = r101;
            this.f312529c = r102;
            this.f312530d = -1;
        }

        public e(String r100, int r101, int r102, int r103) {
            this.f312528b = r100;
            this.f312527a = r101;
            this.f312529c = r102;
            this.f312530d = r103;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f312531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f312532b;

        public final String toString() {
            return this.f312531a + HTTP.URL_DEFAULT + this.f312532b;
        }

        public f(long r100, long r101) {
            if (r101 != 0) goto L6;
            this.f312531a = 0;
            this.f312532b = 1;
            return;
        L6:
            this.f312531a = r100;
            this.f312532b = r101;
        }
    }

    public final void B() {
        int r100 = 0;
    L4:
        if (r100 >= this.f312500e.length) goto L10;
        FLogger.f375446a.d("ExifInterface", "The size of tag group[" + r100 + "]: " + this.f312500e[r100].size());
        Iterator<Map.Entry<String, d>> r101 = this.f312500e[r100].entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, d> r102 = r101.next();
        d r103 = r102.getValue();
        FLogger.f375446a.d("ExifInterface", "tagName: " + r102.getKey() + ", tagType: " + r103.toString() + ", tagValue: '" + r103.i(this.f312502g) + "'");
        goto L7
    L9:
        r100 = r100 + 1;
        goto L4
    }

    public final void O() throws IOException {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        d r100 = this.f312500e[1].get(ExifInterface.TAG_PIXEL_X_DIMENSION);
        d r101 = this.f312500e[1].get(ExifInterface.TAG_PIXEL_Y_DIMENSION);
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_WIDTH, r100);
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_LENGTH, r101);
    L7:
        if (this.f312500e[4].isEmpty() == false) goto L12;
        if (y(this.f312500e[5]) == false) goto L12;
        HashMap<String, d>[] r102 = this.f312500e;
        r102[4] = r102[5];
        r102[5] = new HashMap();
    L12:
        if (y(this.f312500e[4]) == true) goto L15;
        FLogger.f375446a.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        return;
    }

    static {
        f312487r = AppHost.f326268a.isDebug();
        f312488s = Arrays.asList(new Integer[]{1, 6, 3, 8});
        f312489t = Arrays.asList(new Integer[]{2, 7, 4, 5});
        f312490u = new int[]{8, 8, 8};
        f312491v = new int[]{8};
        f312492w = new byte[]{-1, -40, -1};
        f312493x = new byte[]{102, 116, 121, 112};
        f312494y = new byte[]{109, 105, 102, 49};
        f312495z = new byte[]{104, 101, 105, 99};
        A = new byte[]{79, 76, 89, 77, 80, 0};
        B = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        C = new byte[]{-119, 80, 78, 71, HTTP.CR, 10, 26, 10};
        D = new byte[]{101, 88, 73, 102};
        E = new byte[]{73, 72, 68, 82};
        F = new byte[]{73, 69, 78, 68};
        G = new byte[]{82, 73, 70, 70};
        H = new byte[]{87, 69, 66, 80};
        I = new byte[]{69, 88, 73, 70};
        f312480J = new byte[]{-99, 1, 42};
        K = "VP8X".getBytes(Charset.defaultCharset());
        L = "VP8L".getBytes(Charset.defaultCharset());
        M = "VP8 ".getBytes(Charset.defaultCharset());
        N = "ANIM".getBytes(Charset.defaultCharset());
        O = "ANMF".getBytes(Charset.defaultCharset());
        P = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        Q = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        R = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        e[] r110 = {new e(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new e(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new e(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new e(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new e(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new e(ExifInterface.TAG_COMPRESSION, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new e(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new e(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new e(ExifInterface.TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new e(ExifInterface.TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new e(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new e(ExifInterface.TAG_ORIENTATION, 274, 3), new e(ExifInterface.TAG_SAMPLES_PER_PIXEL, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new e(ExifInterface.TAG_ROWS_PER_STRIP, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new e(ExifInterface.TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new e(ExifInterface.TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new e(ExifInterface.TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new e(ExifInterface.TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new e(ExifInterface.TAG_RESOLUTION_UNIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new e(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new e(ExifInterface.TAG_SOFTWARE, 305, 2), new e(ExifInterface.TAG_DATETIME, 306, 2), new e(ExifInterface.TAG_ARTIST, 315, 2), new e(ExifInterface.TAG_WHITE_POINT, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new e(ExifInterface.TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new e("SubIFDPointer", 330, 4), new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new e(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER, 5), new e(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new e(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new e(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new e(ExifInterface.TAG_COPYRIGHT, 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new e(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new e(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new e(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new e(ExifInterface.TAG_RW2_ISO, 23, 3), new e(ExifInterface.TAG_RW2_JPG_FROM_RAW, 46, 7), new e(ExifInterface.TAG_XMP, 700, 1)};
        e[] r100 = {new e(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new e(ExifInterface.TAG_F_NUMBER, 33437, 5), new e(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new e(ExifInterface.TAG_SPECTRAL_SENSITIVITY, 34852, 2), new e(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new e(ExifInterface.TAG_OECF, 34856, 7), new e(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new e(ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new e(ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new e(ExifInterface.TAG_ISO_SPEED, 34867, 4), new e(ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new e(ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new e(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new e(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new e(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new e(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new e(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new e(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new e(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new e(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new e(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new e(ExifInterface.TAG_SUBJECT_DISTANCE, 37382, 5), new e(ExifInterface.TAG_METERING_MODE, 37383, 3), new e(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new e(ExifInterface.TAG_FLASH, 37385, 3), new e(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new e(ExifInterface.TAG_SUBJECT_AREA, 37396, 3), new e(ExifInterface.TAG_MAKER_NOTE, 37500, 7), new e(ExifInterface.TAG_USER_COMMENT, 37510, 7), new e(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new e(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new e(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new e(ExifInterface.TAG_FLASHPIX_VERSION, UnixStat.LINK_FLAG, 7), new e(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new e(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new e(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new e(ExifInterface.TAG_RELATED_SOUND_FILE, 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e(ExifInterface.TAG_FLASH_ENERGY, 41483, 5), new e(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new e(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new e(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new e(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new e(ExifInterface.TAG_SUBJECT_LOCATION, 41492, 3), new e(ExifInterface.TAG_EXPOSURE_INDEX, 41493, 5), new e(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new e(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new e(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new e(ExifInterface.TAG_CFA_PATTERN, 41730, 7), new e(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new e(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new e(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new e(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new e(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new e(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new e(ExifInterface.TAG_GAIN_CONTROL, 41991, 3), new e(ExifInterface.TAG_CONTRAST, 41992, 3), new e(ExifInterface.TAG_SATURATION, 41993, 3), new e(ExifInterface.TAG_SHARPNESS, 41994, 3), new e(ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new e(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new e(ExifInterface.TAG_IMAGE_UNIQUE_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ANRENDER_REFRESH_SURFACE, 2), new e("CameraOwnerName", 42032, 2), new e(ExifInterface.TAG_BODY_SERIAL_NUMBER, 42033, 2), new e(ExifInterface.TAG_LENS_SPECIFICATION, 42034, 5), new e(ExifInterface.TAG_LENS_MAKE, 42035, 2), new e(ExifInterface.TAG_LENS_MODEL, 42036, 2), new e(ExifInterface.TAG_GAMMA, 42240, 5), new e(ExifInterface.TAG_DNG_VERSION, 50706, 1), new e(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        e[] r101 = {new e(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new e(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new e(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10), new e(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new e(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10), new e(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new e(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new e(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new e(ExifInterface.TAG_GPS_SATELLITES, 8, 2), new e(ExifInterface.TAG_GPS_STATUS, 9, 2), new e(ExifInterface.TAG_GPS_MEASURE_MODE, 10, 2), new e(ExifInterface.TAG_GPS_DOP, 11, 5), new e(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new e(ExifInterface.TAG_GPS_SPEED, 13, 5), new e(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new e(ExifInterface.TAG_GPS_TRACK, 15, 5), new e(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new e(ExifInterface.TAG_GPS_IMG_DIRECTION, 17, 5), new e(ExifInterface.TAG_GPS_MAP_DATUM, 18, 2), new e(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new e(ExifInterface.TAG_GPS_DEST_LATITUDE, 20, 5), new e(ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new e(ExifInterface.TAG_GPS_DEST_LONGITUDE, 22, 5), new e(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new e(ExifInterface.TAG_GPS_DEST_BEARING, 24, 5), new e(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new e(ExifInterface.TAG_GPS_DEST_DISTANCE, 26, 5), new e(ExifInterface.TAG_GPS_PROCESSING_METHOD, 27, 7), new e(ExifInterface.TAG_GPS_AREA_INFORMATION, 28, 7), new e(ExifInterface.TAG_GPS_DATESTAMP, 29, 2), new e(ExifInterface.TAG_GPS_DIFFERENTIAL, 30, 3), new e(ExifInterface.TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        e[] r102 = {new e(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        e[] r103 = {new e(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new e(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new e(ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new e(ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new e(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new e(ExifInterface.TAG_COMPRESSION, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new e(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new e(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new e(ExifInterface.TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new e(ExifInterface.TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new e(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e(ExifInterface.TAG_SAMPLES_PER_PIXEL, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new e(ExifInterface.TAG_ROWS_PER_STRIP, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new e(ExifInterface.TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new e(ExifInterface.TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new e(ExifInterface.TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new e(ExifInterface.TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new e(ExifInterface.TAG_RESOLUTION_UNIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new e(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new e(ExifInterface.TAG_SOFTWARE, 305, 2), new e(ExifInterface.TAG_DATETIME, 306, 2), new e(ExifInterface.TAG_ARTIST, 315, 2), new e(ExifInterface.TAG_WHITE_POINT, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new e(ExifInterface.TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new e("SubIFDPointer", 330, 4), new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new e(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER, 5), new e(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new e(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new e(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new e(ExifInterface.TAG_COPYRIGHT, 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e(ExifInterface.TAG_DNG_VERSION, 50706, 1), new e(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        S = new e(ExifInterface.TAG_STRIP_OFFSETS, 273, 3);
        T = new e[][]{r110, r100, r101, r102, r103, r110, new e[]{new e(ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new e("CameraSettingsIFDPointer", AVMDLDataLoader.KeyIsEnableSpeedEngine, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new e(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new e[]{new e(ExifInterface.TAG_ORF_ASPECT_FRAME, 4371, 3)}, new e[]{new e(ExifInterface.TAG_COLOR_SPACE, 55, 3)}};
        U = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", AVMDLDataLoader.KeyIsEnableSpeedEngine, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        V = new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        W = new e(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        X = new HashMap[10];
        Y = new HashMap[10];
        Z = new HashSet(Arrays.asList(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_GPS_TIMESTAMP}));
        f312481a0 = new HashMap();
        Charset r104 = Charset.forName("US-ASCII");
        f312482b0 = r104;
        f312483c0 = "Exif\u0000\u0000".getBytes(r104);
        Locale r105 = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", r105).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r105).setTimeZone(TimeZone.getTimeZone("UTC"));
        int r106 = 0;
    L3:
        e[][] r107 = T;
        if (r106 >= r107.length) goto L9;
        X[r106] = new HashMap();
        Y[r106] = new HashMap();
        e[] r108 = r107[r106];
        int r109 = r108.length;
        int r111 = 0;
    L6:
        if (r111 >= r109) goto L8;
        e r112 = r108[r111];
        X[r106].put(Integer.valueOf(r112.f312527a), r112);
        Y[r106].put(r112.f312528b, r112);
        r111 = r111 + 1;
        goto L6
    L8:
        r106 = r106 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r113 = f312481a0;
        e[] r114 = U;
        r113.put(Integer.valueOf(r114[0].f312527a), 5);
        r113.put(Integer.valueOf(r114[1].f312527a), 1);
        r113.put(Integer.valueOf(r114[2].f312527a), 2);
        r113.put(Integer.valueOf(r114[3].f312527a), 3);
        r113.put(Integer.valueOf(r114[4].f312527a), 7);
        r113.put(Integer.valueOf(r114[5].f312527a), 8);
        PatternProtector.compile(".*[1-9].*");
        f312484d0 = PatternProtector.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        f312485e0 = PatternProtector.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        f312486f0 = PatternProtector.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public final void G() throws IOException {
        int r100 = this.f312499d;
        boolean r101 = true;
        boolean r102 = false;
        if (r100 == 4) goto L8;
        if (r100 == 13) goto L8;
        if (r100 == 14) goto L8;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L111;
        if (this.f312497b == null) goto L13;
    L17:
        int r104 = this.f312508m;
        Closeable r105 = null;
        if (r104 != 6) goto L20;
    L23:
        byte[] r106 = t();
    L24:
        this.f312507l = r106;
        File r107 = File.createTempFile("temp", "tmp");     // Catch: Throwable -> L101 Exception -> L103
        if (this.f312496a == null) goto L28;
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(this.f312496a);     // Catch: Throwable -> L101 Exception -> L103
    L124:
        PolarisFileOutputStreamWrapper r110 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L97 Exception -> L99
    L131:
        g(r108, r110);     // Catch: Throwable -> L93 Exception -> L95
        d(r108);
        d(r110);
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper(r107);     // Catch: Throwable -> L60 Exception -> L62
    L56:
        e = e;
        PolarisFileOutputStreamWrapper r111 = null;
    L58:
        BufferedInputStream r112 = null;
        BufferedOutputStream r113 = null;
    L59:
        PolarisFileOutputStreamWrapper r114 = r111;
        r105 = r109;
    L126:
        PolarisFileInputStreamWrapper r115 = new PolarisFileInputStreamWrapper(r107);     // Catch: Throwable -> L78 Exception -> L80
    L128:
    L76:
        e = e;
        r105 = r115;
    L114:
    L83:
        th = th;
    L118:
        d(r105);     // Catch: Throwable -> L86
        d(r114);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = th;
        r102 = r101;
    L88:
        r105 = r112;
    L89:
        d(r105);
        d(r113);
        if (r102 == true) goto L92;
        r107.delete();
    L92:
        throw th;
    L82:
        throw new IOException("Failed to save new file. Original file is stored in " + r107.getAbsolutePath(), e);     // Catch: Throwable -> L83
    L74:
        th = th;
        r105 = r115;
    L79:
        r101 = false;
        goto L118
    L66:
        if (this.f312496a != null) goto L68;
        Os.lseek(this.f312497b, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L74 Exception -> L76
        PolarisFileOutputStreamWrapper r116 = new PolarisFileOutputStreamWrapper(this.f312497b);     // Catch: Throwable -> L74 Exception -> L76
    L69:
        r114 = r116;
        g(r115, r114);     // Catch: Throwable -> L74 Exception -> L76
        d(r115);     // Catch: Throwable -> L72
        d(r114);     // Catch: Throwable -> L72
        throw new IOException("Failed to save new file", e);     // Catch: Throwable -> L72
    L68:
        r116 = new PolarisFileOutputStreamWrapper(this.f312496a);     // Catch: Throwable -> L74 Exception -> L76
    L80:
        e = e;
    L78:
        th = th;
        goto L79
    L34:
        if (this.f312496a == null) goto L36;
        r111 = new PolarisFileOutputStreamWrapper(this.f312496a);     // Catch: Exception -> L56 Throwable -> L60
    L120:
        r112 = new BufferedInputStream(r109);     // Catch: Exception -> L54 Throwable -> L60
    L133:
        r113 = new BufferedOutputStream(r111);     // Catch: Throwable -> L50 Exception -> L52
        int r117 = this.f312499d;     // Catch: Exception -> L48 Throwable -> L72
        if (r117 != 4) goto L42;
        H(r112, r113);     // Catch: Exception -> L48 Throwable -> L72
    L46:
        d(r112);
        d(r113);
        r107.delete();
        this.f312507l = null;
        return;
    L42:
        if (r117 != 13) goto L44;
        I(r112, r113);     // Catch: Exception -> L48 Throwable -> L72
        goto L46
    L44:
        if (r117 != 14) goto L46;
        J(r112, r113);     // Catch: Exception -> L48 Throwable -> L72
    L48:
        e = e;
        goto L59
    L52:
        e = e;
        r113 = null;
    L50:
        th = th;
        r113 = null;
    L54:
        e = e;
        goto L58
    L36:
        Os.lseek(this.f312497b, 0, OsConstants.SEEK_SET);     // Catch: Exception -> L56 Throwable -> L60
        r111 = new PolarisFileOutputStreamWrapper(this.f312497b);     // Catch: Exception -> L56 Throwable -> L60
    L72:
        th = th;
    L62:
        e = e;
        r114 = null;
        r112 = null;
        r113 = null;
    L60:
        th = th;
        r113 = null;
        goto L89
    L95:
        e = e;
        r105 = r110;
    L100:
        Closeable r118 = r105;
        r105 = r108;
    L121:
    L107:
        th = th;
    L108:
        d(r105);
        d(r118);
        throw th;
    L106:
        throw new IOException("Failed to copy original file to temp file", e);     // Catch: Throwable -> L107
    L93:
        th = th;
        r105 = r110;
    L98:
        r118 = r105;
        r105 = r108;
    L99:
        e = e;
    L97:
        th = th;
        goto L98
    L28:
        Os.lseek(this.f312497b, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L101 Exception -> L103
        r108 = new PolarisFileInputStreamWrapper(this.f312497b);     // Catch: Throwable -> L101 Exception -> L103
    L103:
        e = e;
        r118 = null;
    L101:
        th = th;
        r118 = null;
        goto L108
    L20:
        if (r104 == 7) goto L23;
        r106 = null;
        goto L24
    L13:
        if (this.f312496a != null) goto L17;
        throw new IOException("ExifInterface does not support saving attributes for the current input.");
    L111:
        throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
    L8:
        r103 = true;
        goto L9
    }

    public final void a() {
        String r100 = j(ExifInterface.TAG_DATETIME_ORIGINAL);
        if (r100 == null) goto L8;
        if (j(ExifInterface.TAG_DATETIME) != null) goto L8;
        this.f312500e[0].put(ExifInterface.TAG_DATETIME, d.a(r100));
    L8:
        if (j(ExifInterface.TAG_IMAGE_WIDTH) != null) goto L11;
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_WIDTH, d.b(0, this.f312502g));
    L11:
        if (j(ExifInterface.TAG_IMAGE_LENGTH) != null) goto L14;
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_LENGTH, d.b(0, this.f312502g));
    L14:
        if (j(ExifInterface.TAG_ORIENTATION) != null) goto L17;
        this.f312500e[0].put(ExifInterface.TAG_ORIENTATION, d.b(0, this.f312502g));
    L17:
        if (j(ExifInterface.TAG_LIGHT_SOURCE) != null) goto L20;
        this.f312500e[1].put(ExifInterface.TAG_LIGHT_SOURCE, d.b(0, this.f312502g));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final byte[] t() {
        ?? r100 = 0;
        r100 = 0;
        if (this.f312503h == true) goto L5;
        return null;
    L5:
        ?? r101 = this.f312507l;
        if (r101 == 0) goto L65;
        return r101;
    L65:
        r101 = this.f312498c;     // Catch: Throwable -> L47 Exception -> L49
        if (r101 == 0) goto L22;
    L19:
        e = move-exception;
        Exception e100 = e;
        FileDescriptor r102 = null;
    L51:
        FLogger.f375446a.d("ExifInterface", "Encountered exception while getting thumbnail. Exception message: " + e100.getMessage());     // Catch: Throwable -> L56
        d(r101);
        if (r102 == null) goto L55;
        c(r102);
    L55:
        return null;
    L17:
        th = th;
        FileDescriptor r103 = null;
    L57:
        r100 = r101;
    L58:
        d(r100);
        if (r103 == null) goto L61;
        c(r103);
    L61:
        throw th;
    L11:
        if (r101.markSupported() == false) goto L14;
        r101.reset();     // Catch: Throwable -> L17 Exception -> L19
        ?? r104 = r101;
    L13:
        r102 = null;
        r101 = r104;
    L62:
    L41:
        e100 = e;
        goto L51
    L29:
        if (r101.skip(this.f312505j + this.f312509n) != (this.f312505j + this.f312509n)) goto L40;
        byte[] r105 = new byte[this.f312506k];     // Catch: Exception -> L41 Throwable -> L56
        if (r101.read(r105) != this.f312506k) goto L38;
        this.f312507l = r105;     // Catch: Exception -> L41 Throwable -> L56
        d(r101);
        if (r102 == null) goto L36;
        c(r102);
    L36:
        return r105;
    L38:
        throw new IOException("Corrupted image");     // Catch: Exception -> L41 Throwable -> L56
    L40:
        throw new IOException("Corrupted image");     // Catch: Exception -> L41 Throwable -> L56
    L14:
        FLogger.f375446a.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");     // Catch: Throwable -> L17 Exception -> L19
        d(r101);
        return null;
    L22:
        if (this.f312496a == null) goto L24;
        r104 = new PolarisFileInputStreamWrapper(this.f312496a);     // Catch: Throwable -> L47 Exception -> L49
        goto L13
    L24:
        FileDescriptor r106 = Os.dup(this.f312497b);     // Catch: Throwable -> L47 Exception -> L49
        Os.lseek(r106, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L43 Exception -> L45
        r102 = r106;
        r101 = new PolarisFileInputStreamWrapper(r106);     // Catch: Throwable -> L43 Exception -> L45
        goto L62
    L45:
        e = move-exception;
        e100 = e;
        r102 = r106;
        r101 = 0;
    L43:
        th = th;
        r103 = r106;
    L49:
        e = move-exception;
        r101 = 0;
        e100 = e;
        r102 = null;
    L47:
        th = th;
        r103 = null;
    L56:
        th = th;
        goto L57
    }

    public ExifInterface2(FileDescriptor r100) throws IOException {
        e[][] r101 = T;
        this.f312500e = new HashMap[r101.length];
        this.f312501f = new HashSet(r101.length);
        this.f312502g = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L28;
        this.f312498c = null;
        this.f312496a = null;
        if (x(r100) == false) goto L12;
        this.f312497b = r100;
        r100 = Os.dup(r100);     // Catch: Exception -> L9
        boolean r102 = true;
    L33:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L21
        z(r103);     // Catch: Throwable -> L19
        d(r103);
        if (r102 == false) goto L35;
        c(r100);
        return;
    L35:
        return;
    L19:
        Throwable th10 = th;
    L23:
        d(r103);
        if (r102 == false) goto L26;
        c(r100);
    L26:
        throw th10;
    L21:
        th = move-exception;
        r103 = null;
        th10 = th;
    L9:
        e = move-exception;
        throw new IOException("Failed to duplicate file descriptor", e);
    L12:
        this.f312497b = null;
        r102 = false;
        goto L33
    L28:
        throw new NullPointerException("fileDescriptor cannot be null");
    }

    public static ByteOrder C(b r100) throws IOException {
        short r101 = r100.readShort();
        if (r101 == 18761) goto L14;
        if (r101 != 19789) goto L12;
        if (f312487r == false) goto L10;
        FLogger.f375446a.d("ExifInterface", "readExifSegment: Byte Align MM");
    L10:
        return ByteOrder.BIG_ENDIAN;
    L12:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r101));
    L14:
        if (f312487r == false) goto L17;
        FLogger.f375446a.d("ExifInterface", "readExifSegment: Byte Align II");
    L17:
        return ByteOrder.LITTLE_ENDIAN;
    }

    public static String b(byte[] r100) {
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r102])}));
        r102 = r102 + 1;
        goto L4
    L7:
        return r101.toString();
    }

    public static void c(FileDescriptor r100) {
        Os.close(r100);     // Catch: Exception -> L4
        return;
    L4:
        FLogger.f375446a.e("ExifInterface", "Error closing fd.");
    }

    public static void d(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static long[] f(Object r100) {
        if ((r100 instanceof int[]) == false) goto L10;
        int[] r101 = (int[]) r100;
        long[] r102 = new long[r101.length];
        int r103 = 0;
    L6:
        if (r103 >= r101.length) goto L8;
        r102[r103] = r101[r103];
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    L10:
        if ((r100 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) r100;
    }

    public static Pair<Integer, Integer> v(String r110) {
        int r100 = 1;
        if (r110.contains(",") == false) goto L35;
        String[] r111 = r110.split(",", -1);
        Pair<Integer, Integer> r101 = v(r111[0]);
        if (((Integer) r101.first).intValue() != 2) goto L8;
        return r101;
    L8:
        if (r100 >= r111.length) goto L33;
        Pair<Integer, Integer> r102 = v(r111[r100]);
        if (((Integer) r102.first).equals(r101.first) == false) goto L12;
    L15:
        int r103 = ((Integer) r101.first).intValue();
    L17:
        if (((Integer) r101.second).intValue() != (-1)) goto L19;
    L23:
        int r104 = -1;
    L24:
        if (r103 != (-1)) goto L28;
        if (r104 != (-1)) goto L28;
        return new Pair(2, -1);
    L28:
        if (r103 != (-1)) goto L30;
        r101 = new Pair(Integer.valueOf(r104), -1);
    L32:
        r100 = r100 + 1;
        goto L8
    L30:
        if (r104 != (-1)) goto L32;
        r101 = new Pair(Integer.valueOf(r103), -1);
        goto L32
    L19:
        if (((Integer) r102.first).equals(r101.second) == false) goto L21;
    L22:
        r104 = ((Integer) r101.second).intValue();
        goto L24
    L21:
        if (((Integer) r102.second).equals(r101.second) == false) goto L23;
    L12:
        if (((Integer) r102.second).equals(r101.first) == true) goto L15;
        r103 = -1;
        goto L17
    L33:
        return r101;
    L35:
        if (r110.contains(HTTP.URL_DEFAULT) == false) goto L73;
        String[] r112 = r110.split(HTTP.URL_DEFAULT, -1);
        if (r112.length != 2) goto L55;
        long r105 = (long) CastDoubleProtector.parseDouble(r112[0]);     // Catch: NumberFormatException -> L72
        long r106 = (long) CastDoubleProtector.parseDouble(r112[1]);     // Catch: NumberFormatException -> L72
        if (r105 < 0) goto L53;
        if (r106 < 0) goto L53;
        if (r105 > SieveCacheKt.NodeLinkMask) goto L51;
        if (r106 > SieveCacheKt.NodeLinkMask) goto L51;
        return new Pair(10, 5);
    L51:
        return new Pair(5, -1);
    L53:
        return new Pair(10, -1);
    L55:
        return new Pair(2, -1);
    L73:
        Long r107 = Long.valueOf(CastLongProtector.parseLong(r110));     // Catch: NumberFormatException -> L68
        if (r107.longValue() < 0) goto L63;
        if (r107.longValue() > 65535) goto L63;
        return new Pair(3, 4);
    L63:
        if (r107.longValue() >= 0) goto L67;
        return new Pair(9, -1);
    L67:
        return new Pair(4, -1);
    L68:
        CastDoubleProtector.parseDouble(r110);     // Catch: NumberFormatException -> L70
        return new Pair(12, -1);
    L71:
        return new Pair(2, -1);
    }

    public static boolean x(FileDescriptor r100) {
        Os.lseek(r100, 0, OsConstants.SEEK_CUR);     // Catch: Exception -> L5
        return true;
    L6:
        if (f312487r == false) goto L12;
        FLogger.f375446a.d("ExifInterface", "The file descriptor for the given input is not seekable");
        return false;
    L12:
        return false;
    }

    public final void F(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= T.length) goto L6;
        this.f312500e[r101].remove(r100);
        r101 = r101 + 1;
        goto L4
    }

    public final void L(b r210) throws IOException {
        HashMap<String, d> r100 = this.f312500e[4];
        d r101 = r100.get(ExifInterface.TAG_COMPRESSION);
        if (r101 == null) goto L74;
        int r102 = r101.h(this.f312502g);
        this.f312508m = r102;
        int r103 = 1;
        if (r102 == 1) goto L11;
        if (r102 != 6) goto L8;
        w(r210, r100);
        return;
    L8:
        if (r102 == 7) goto L11;
        return;
    L11:
        d r104 = r100.get(ExifInterface.TAG_BITS_PER_SAMPLE);
        if (r104 == null) goto L29;
        int[] r105 = (int[]) r104.j(this.f312502g);
        int[] r106 = f312490u;
        if (Arrays.equals(r106, r105) == false) goto L17;
    L27:
        boolean r107 = true;
    L32:
        if (r107 == false) goto L82;
        d r108 = r100.get(ExifInterface.TAG_STRIP_OFFSETS);
        d r109 = r100.get(ExifInterface.TAG_STRIP_BYTE_COUNTS);
        if (r108 == null) goto L83;
        if (r109 == null) goto L84;
        long[] r110 = f(r108.j(this.f312502g));
        long[] r111 = f(r109.j(this.f312502g));
        if (r110 != null) goto L39;
    L73:
        FLogger.f375446a.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        return;
    L39:
        if (r110.length == 0) goto L73;
        if (r111 != null) goto L43;
    L72:
        FLogger.f375446a.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
        return;
    L43:
        if (r111.length == 0) goto L72;
        if (r110.length == r111.length) goto L48;
        FLogger.f375446a.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
        return;
    L48:
        int r112 = r111.length;
        long r113 = 0;
        int r114 = 0;
    L49:
        if (r114 >= r112) goto L51;
        r113 = r113 + r111[r114];
        r114 = r114 + 1;
        goto L49
    L51:
        int r115 = (int) r113;
        byte[] r116 = new byte[r115];
        this.f312504i = true;
        this.f312503h = true;
        int r117 = 0;
        int r118 = 0;
        int r119 = 0;
    L53:
        if (r117 >= r110.length) goto L69;
        int r120 = (int) r110[r117];
        int r121 = (int) r111[r117];
        if (r117 < (r110.length - r103)) goto L57;
    L59:
        int r122 = r120 - r118;
        if (r122 < 0) goto L61;
        long r123 = r122;
        if (r210.skip(r123) != r123) goto L64;
        int r124 = r118 + r122;
        byte[] r125 = new byte[r121];
        if (r210.read(r125) != r121) goto L67;
        r118 = r124 + r121;
        System.arraycopy(r125, 0, r116, r119, r121);
        r119 = r119 + r121;
        r117 = r117 + 1;
        r103 = 1;
        goto L53
    L67:
        FLogger.f375446a.d("ExifInterface", "Failed to read " + r121 + " bytes.");
        return;
    L64:
        FLogger.f375446a.d("ExifInterface", "Failed to skip " + r122 + " bytes.");
        return;
    L61:
        FLogger.f375446a.d("ExifInterface", "Invalid strip offset value");
        return;
    L57:
        if ((r120 + r121) == r110[r117 + 1]) goto L59;
        this.f312504i = false;
        goto L59
    L69:
        this.f312507l = r116;
        if (this.f312504i == false) goto L89;
        this.f312505j = (int) r110[0];
        this.f312506k = r115;
        return;
    L89:
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L17:
        if (this.f312499d != 3) goto L29;
        d r126 = r100.get(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION);
        if (r126 == null) goto L29;
        int r127 = r126.h(this.f312502g);
        if (r127 == 1) goto L23;
    L24:
        if (r127 != 6) goto L29;
        if (Arrays.equals(r105, r106) == false) goto L29;
    L23:
        if (Arrays.equals(r105, f312491v) == true) goto L27;
    L29:
        if (f312487r == false) goto L31;
        FLogger.f375446a.d("ExifInterface", "Unsupported data type value");
    L31:
        r107 = false;
        goto L32
    L74:
        this.f312508m = 6;
        w(r210, r100);
    }

    public final void P(c r110) throws IOException {
        e[][] r100 = T;
        int[] r101 = new int[r100.length];
        int[] r102 = new int[r100.length];
        e[] r103 = U;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        F(r103[r105].f312528b);
        r105 = r105 + 1;
        goto L3
    L5:
        F(V.f312528b);
        F(W.f312528b);
        int r106 = 0;
    L7:
        if (r106 >= T.length) goto L16;
        Object[] r107 = this.f312500e[r106].entrySet().toArray();
        int r108 = r107.length;
        int r109 = 0;
    L9:
        if (r109 >= r108) goto L14;
        Map.Entry r111 = (Map.Entry) r107[r109];
        if (r111.getValue() != null) goto L13;
        this.f312500e[r106].remove(r111.getKey());
    L13:
        r109 = r109 + 1;
        goto L9
    L14:
        r106 = r106 + 1;
        goto L7
    L16:
        if (this.f312500e[1].isEmpty() == true) goto L19;
        this.f312500e[0].put(U[1].f312528b, d.b(0, this.f312502g));
    L19:
        if (this.f312500e[2].isEmpty() == true) goto L22;
        this.f312500e[0].put(U[2].f312528b, d.b(0, this.f312502g));
    L22:
        if (this.f312500e[3].isEmpty() == true) goto L25;
        this.f312500e[1].put(U[3].f312528b, d.b(0, this.f312502g));
    L25:
        if (this.f312503h == false) goto L27;
        this.f312500e[4].put(V.f312528b, d.b(0, this.f312502g));
        this.f312500e[4].put(W.f312528b, d.b(this.f312506k, this.f312502g));
    L27:
        int r112 = 0;
    L29:
        if (r112 >= T.length) goto L38;
        Iterator<Map.Entry<String, d>> r113 = this.f312500e[r112].entrySet().iterator();
        int r114 = 0;
    L32:
        if (r113.hasNext() == false) goto L37;
        d r115 = r113.next().getValue();
        r115.getClass();
        int r116 = Q[r115.f312523a] * r115.f312524b;
        if (r116 <= 4) goto L32;
        r114 = r114 + r116;
        goto L32
    L37:
        r102[r112] = r102[r112] + r114;
        r112 = r112 + 1;
        goto L29
    L38:
        int r117 = 8;
        int r118 = 0;
    L40:
        if (r118 >= T.length) goto L46;
        if (this.f312500e[r118].isEmpty() == true) goto L44;
        r101[r118] = r117;
        r117 = r117 + ((((this.f312500e[r118].size() * 12) + 2) + 4) + r102[r118]);
    L44:
        r118 = r118 + 1;
        goto L40
    L46:
        if (this.f312503h == false) goto L49;
        this.f312500e[4].put(V.f312528b, d.b(r117, this.f312502g));
        this.f312505j = r117;
        r117 = r117 + this.f312506k;
    L49:
        if (this.f312499d != 4) goto L52;
        r117 = r117 + 8;
    L52:
        if (f312487r == false) goto L58;
        int r119 = 0;
    L55:
        if (r119 >= T.length) goto L58;
        FLogger.f375446a.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(r119), Integer.valueOf(r101[r119]), Integer.valueOf(this.f312500e[r119].size()), Integer.valueOf(r102[r119]), Integer.valueOf(r117)}));
        r119 = r119 + 1;
    L58:
        if (this.f312500e[1].isEmpty() == true) goto L61;
        this.f312500e[0].put(U[1].f312528b, d.b(r101[1], this.f312502g));
    L61:
        if (this.f312500e[2].isEmpty() == true) goto L64;
        this.f312500e[0].put(U[2].f312528b, d.b(r101[2], this.f312502g));
    L64:
        if (this.f312500e[3].isEmpty() == true) goto L66;
        this.f312500e[1].put(U[3].f312528b, d.b(r101[3], this.f312502g));
    L66:
        int r120 = this.f312499d;
        if (r120 != 4) goto L69;
        r110.c((short) r117);
        r110.write(f312483c0);
    L76:
        if (this.f312502g != ByteOrder.BIG_ENDIAN) goto L78;
        short r121 = 19789;
    L79:
        r110.c(r121);
        r110.f312522b = this.f312502g;
        r110.c((short) 42);
        r110.b((int) 8);
        int r122 = 0;
    L81:
        if (r122 >= T.length) goto L108;
        if (this.f312500e[r122].isEmpty() == true) goto L106;
        r110.c((short) this.f312500e[r122].size());
        int r123 = ((r101[r122] + 2) + (this.f312500e[r122].size() * 12)) + 4;
        Iterator<Map.Entry<String, d>> r124 = this.f312500e[r122].entrySet().iterator();
    L86:
        if (r124.hasNext() == false) goto L94;
        Map.Entry<String, d> r125 = r124.next();
        int r126 = Y[r122].get(r125.getKey()).f312527a;
        d r127 = r125.getValue();
        r127.getClass();
        int r128 = Q[r127.f312523a] * r127.f312524b;
        r110.c((short) r126);
        r110.c((short) r127.f312523a);
        r110.b(r127.f312524b);
        if (r128 > 4) goto L89;
        r110.write(r127.f312526d);
        if (r128 >= 4) goto L86;
    L92:
        if (r128 >= 4) goto L86;
        r110.a(0);
        r128 = r128 + 1;
        goto L92
    L89:
        r110.b(r123);
        r123 = r123 + r128;
        goto L86
    L94:
        if (r122 == 0) goto L96;
    L98:
        r110.b((int) 0);
    L99:
        Iterator<Map.Entry<String, d>> r129 = this.f312500e[r122].entrySet().iterator();
    L101:
        if (r129.hasNext() == false) goto L106;
        byte[] r130 = r129.next().getValue().f312526d;
        if (r130.length <= 4) goto L101;
        r110.write(r130, 0, r130.length);
        goto L101
    L96:
        if (this.f312500e[4].isEmpty() == true) goto L98;
        r110.b(r101[4]);
    L106:
        r122 = r122 + 1;
        goto L81
    L108:
        if (this.f312503h == false) goto L111;
        r110.write(t());
    L111:
        if (this.f312499d == 14) goto L113;
    L115:
        r110.f312522b = ByteOrder.BIG_ENDIAN;
        return;
    L113:
        if ((r117 % 2) != 1) goto L115;
        r110.a(0);
        goto L115
    L78:
        r121 = 18761;
        goto L79
    L69:
        if (r120 == 13) goto L73;
        if (r120 != 14) goto L76;
        r110.write(I);
        r110.b(r117);
        goto L76
    L73:
        r110.b(r117);
        r110.write(D);
        goto L76
    }

    public final String j(String r100) {
        d r101 = k(r100);
        if (r101 != null) goto L5;
    L27:
        return null;
    L5:
        if (Z.contains(r100) == true) goto L9;
        return r101.i(this.f312502g);
    L9:
        if (r100.equals(ExifInterface.TAG_GPS_TIMESTAMP) == false) goto L29;
        int r102 = r101.f312523a;
        if (r102 != 5) goto L13;
    L16:
        f[] r103 = (f[]) r101.j(this.f312502g);
        if (r103 != null) goto L19;
    L23:
        FLogger.f375446a.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(r103));
        return null;
    L19:
        if (r103.length != 3) goto L23;
        f r104 = r103[0];
        f r105 = r103[1];
        f r106 = r103[2];
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r104.f312531a / r104.f312532b)), Integer.valueOf((int) (r105.f312531a / r105.f312532b)), Integer.valueOf((int) (r106.f312531a / r106.f312532b))});
    L13:
        if (r102 == 10) goto L16;
        FLogger.f375446a.w("ExifInterface", "GPS Timestamp format is not rational. format=" + r101.f312523a);
        return null;
    L29:
        return Double.toString(r101.g(this.f312502g));
    }

    public final d k(String r100) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(r100) == true) goto L5;
    L8:
        int r101 = 0;
    L10:
        if (r101 >= T.length) goto L15;
        d r102 = this.f312500e[r101].get(r100);
        if (r102 != null) goto L13;
        r101 = r101 + 1;
        goto L10
    L13:
        return r102;
    L15:
        return null;
    L5:
        if (f312487r == false) goto L7;
        FLogger.f375446a.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L7:
        r100 = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        goto L8
    }

    public final void l(b r110) throws IOException {
        MediaMetadataRetriever r100 = new MediaMetadataRetriever();
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L74
        if (r101 < 23) goto L6;
        r100.setDataSource(new a(r110));     // Catch: Throwable -> L74
    L12:
        String r102 = null;
        if (r101 < 29) goto L15;
        String r103 = e(r100, 33);     // Catch: Throwable -> L74
    L16:
        if (r101 < 29) goto L18;
        String r104 = e(r100, 34);     // Catch: Throwable -> L74
    L20:
        if (r101 < 28) goto L22;
        String r105 = e(r100, 26);     // Catch: Throwable -> L74
    L23:
        String r106 = e(r100, 17);     // Catch: Throwable -> L74
        if (BdpAppEventConstant.YES.equals(r105) == false) goto L27;
        r102 = e(r100, 29);     // Catch: Throwable -> L74
        String r107 = e(r100, 30);     // Catch: Throwable -> L74
        String r108 = e(r100, 31);     // Catch: Throwable -> L74
    L31:
        if (r102 == null) goto L33;
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_WIDTH, d.e(Integer.parseInt(r102), this.f312502g));     // Catch: Throwable -> L74
    L33:
        if (r107 == null) goto L36;
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_LENGTH, d.e(Integer.parseInt(r107), this.f312502g));     // Catch: Throwable -> L74
    L36:
        if (r108 == null) goto L48;
        int r109 = Integer.parseInt(r108);     // Catch: Throwable -> L74
        if (r109 != 90) goto L40;
        int r111 = 6;
    L47:
        this.f312500e[0].put(ExifInterface.TAG_ORIENTATION, d.e(r111, this.f312502g));     // Catch: Throwable -> L74
        goto L48
    L40:
        if (r109 != 180) goto L42;
        r111 = 3;
        goto L47
    L42:
        if (r109 == 270) goto L44;
        r111 = 1;
        goto L47
    L44:
        r111 = 8;
    L48:
        if (r103 == null) goto L68;
        if (r104 == null) goto L68;
        int r112 = Integer.parseInt(r103);     // Catch: Throwable -> L74
        int r113 = Integer.parseInt(r104);     // Catch: Throwable -> L74
        if (r113 <= 6) goto L66;
        r110.a(r112);     // Catch: Throwable -> L74
        byte[] r114 = new byte[6];     // Catch: Throwable -> L74
        if (r110.read(r114) != 6) goto L64;
        int r115 = r112 + 6;     // Catch: Throwable -> L74
        int r116 = r113 - 6;     // Catch: Throwable -> L74
        if (Arrays.equals(r114, f312483c0) == false) goto L62;
        byte[] r117 = new byte[r116];     // Catch: Throwable -> L74
        if (r110.read(r117) != r116) goto L60;
        this.f312509n = r115;     // Catch: Throwable -> L74
        D(r117, 0);     // Catch: Throwable -> L74
        goto L68
    L60:
        throw new IOException("Can't read exif");     // Catch: Throwable -> L74
    L62:
        throw new IOException("Invalid identifier");     // Catch: Throwable -> L74
    L64:
        throw new IOException("Can't read identifier");     // Catch: Throwable -> L74
    L66:
        throw new IOException("Invalid exif length");     // Catch: Throwable -> L74
    L68:
        if (f312487r == false) goto L70;
        FLogger.f375446a.d("ExifInterface", "Heif meta: " + r102 + "x" + r107 + ", rotation " + r108);     // Catch: Throwable -> L74
    L70:
        r100.release();
        return;
    L27:
        if (BdpAppEventConstant.YES.equals(r106) == false) goto L29;
        r102 = e(r100, 18);     // Catch: Throwable -> L74
        r107 = e(r100, 19);     // Catch: Throwable -> L74
        r108 = e(r100, 24);     // Catch: Throwable -> L74
        goto L31
    L29:
        r107 = null;
        r108 = null;
        goto L31
    L22:
        r105 = null;
        goto L23
    L18:
        r104 = null;
        goto L20
    L15:
        r103 = null;
        goto L16
    L6:
        FileDescriptor r118 = this.f312497b;     // Catch: Throwable -> L74
        if (r118 == null) goto L9;
        r100.setDataSource(r118);     // Catch: Throwable -> L74
        goto L12
    L9:
        String r119 = this.f312496a;     // Catch: Throwable -> L74
        if (r119 == null) goto L72;
        r100.setDataSource(r119);     // Catch: Throwable -> L74
        goto L12
    L72:
        r100.release();
        return;
    L74:
        th = move-exception;
        r100.release();
        throw th;
    }

    public final int n(BufferedInputStream r110) throws IOException {
        r110.mark(5000);
        byte[] r100 = new byte[5000];
        r110.read(r100);
        r110.reset();
        int r101 = 0;
    L3:
        byte[] r102 = f312492w;
        if (r101 >= r102.length) goto L9;
        if (r100[r101] != r102[r101]) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        return 4;
    L13:
        byte[] r104 = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int r105 = 0;
    L15:
        if (r105 >= r104.length) goto L20;
        if (r100[r105] != r104[r105]) goto L18;
        r105 = r105 + 1;
        goto L15
    L18:
        boolean r106 = false;
    L21:
        if (r106 == false) goto L171;
        return 9;
    L171:
        b r107 = new b(r100);     // Catch: Throwable -> L63 Exception -> L65
        long r108 = r107.readInt();     // Catch: Throwable -> L59 Exception -> L61
        byte[] r109 = new byte[4];     // Catch: Throwable -> L59 Exception -> L61
        r107.read(r109);     // Catch: Throwable -> L59 Exception -> L61
        if (Arrays.equals(r109, f312493x) == true) goto L29;
    L71:
        r107.close();
    L72:
        boolean r111 = false;
    L73:
        if (r111 == false) goto L167;
        return 12;
    L167:
        b r112 = new b(r100);     // Catch: Throwable -> L89 Exception -> L94
        ByteOrder r113 = C(r112);     // Catch: Throwable -> L86 Exception -> L88
        this.f312502g = r113;     // Catch: Throwable -> L86 Exception -> L88
        r112.f312518b = r113;     // Catch: Throwable -> L86 Exception -> L88
        short r114 = r112.readShort();     // Catch: Throwable -> L86 Exception -> L88
        goto L95
    L79:
        if (r114 != 20306) goto L81;
    L84:
        boolean r115 = true;
    L85:
        r112.close();
    L98:
        if (r115 == false) goto L163;
        return 7;
    L163:
        b r116 = new b(r100);     // Catch: Throwable -> L111 Exception -> L116
        ByteOrder r117 = C(r116);     // Catch: Throwable -> L108 Exception -> L110
        this.f312502g = r117;     // Catch: Throwable -> L108 Exception -> L110
        r116.f312518b = r117;     // Catch: Throwable -> L108 Exception -> L110
    L104:
        if (r116.readShort() != 85) goto L106;
        boolean r118 = true;
    L107:
        r116.close();
    L120:
        if (r118 == false) goto L123;
        return 10;
    L123:
        int r119 = 0;
    L124:
        byte[] r120 = C;
        if (r119 >= r120.length) goto L130;
        if (r100[r119] != r120[r119]) goto L128;
        r119 = r119 + 1;
        goto L124
    L128:
        boolean r121 = false;
    L131:
        if (r121 == false) goto L134;
        return 13;
    L134:
        int r122 = 0;
    L135:
        byte[] r123 = G;
        if (r122 >= r123.length) goto L141;
        if (r100[r122] != r123[r122]) goto L146;
        r122 = r122 + 1;
    L146:
        boolean r124 = false;
    L149:
        if (r124 == false) goto L152;
        return 14;
    L152:
        return 0;
    L141:
        int r125 = 0;
    L142:
        byte[] r126 = H;
        if (r125 >= r126.length) goto L148;
        if (r100[(G.length + r125) + 4] != r126[r125]) goto L146;
        r125 = r125 + 1;
        goto L142
    L148:
        r124 = true;
        goto L149
    L130:
        r121 = true;
        goto L131
    L106:
        r118 = false;
    L110:
        b r127 = r116;
    L117:
        if (r127 == null) goto L119;
        r127.close();
    L119:
        r118 = false;
    L108:
        th = th;
        b r128 = r116;
    L113:
        if (r128 == null) goto L115;
        r128.close();
    L115:
        throw th;
    L116:
        r127 = null;
    L111:
        th = th;
        r128 = null;
        goto L113
    L81:
        if (r114 == 21330) goto L84;
        r115 = false;
    L86:
        th = th;
        b r129 = r112;
    L91:
        if (r129 == null) goto L93;
        r129.close();
    L93:
        throw th;
    L95:
        if (r112 == null) goto L97;
        r112.close();
    L97:
        r115 = false;
        goto L98
    L94:
        r112 = null;
    L89:
        th = th;
        r129 = null;
        goto L91
    L29:
        if (r108 != 1) goto L33;
        r108 = r107.readLong();     // Catch: Throwable -> L59 Exception -> L61
        long r130 = 16;
        if (r108 < 16) goto L71;
    L34:
        long r131 = 5000;
        if (r108 <= r131) goto L37;
        r108 = r131;
    L37:
        long r132 = r108 - r130;     // Catch: Throwable -> L59 Exception -> L61
        if (r132 < 8) goto L71;
        byte[] r133 = new byte[4];     // Catch: Throwable -> L59 Exception -> L61
        long r134 = 0;
        boolean r135 = false;
        boolean r136 = false;
    L41:
        if (r134 >= (r132 / 4)) goto L71;
        if (r107.read(r133) != 4) goto L71;
        if (r134 != 1) goto L50;
    L58:
        r134 = r134 + 1;
        goto L41
    L50:
        if (Arrays.equals(r133, f312494y) == false) goto L53;
        r135 = true;
    L55:
        if (r135 == false) goto L58;
        if (r136 == false) goto L58;
        r107.close();
        r111 = true;
        goto L73
    L53:
        if (Arrays.equals(r133, f312495z) == false) goto L55;
        r136 = true;
        goto L55
    L33:
        r130 = 8;
    L61:
        e = e;
    L159:
    L153:
        th = th;
        b r137 = r107;
    L155:
        r107 = r137;
    L156:
        if (r107 == null) goto L158;
        r107.close();
    L158:
        throw th;
    L68:
        if (f312487r == false) goto L70;
        FLogger.f375446a.d("ExifInterface", "Exception parsing HEIF file type box. Exception message: " + e.getMessage());     // Catch: Throwable -> L153
    L70:
        if (r107 == null) goto L72;
    L59:
        th = th;
        goto L156
    L65:
        e = e;
        r107 = null;
    L63:
        th = th;
        r137 = null;
        goto L155
    L20:
        r106 = true;
        goto L21
    L9:
        r103 = true;
        goto L11
    }

    public final void o(b r100) throws IOException {
        r(r100);
        d r101 = this.f312500e[1].get(ExifInterface.TAG_MAKER_NOTE);
        if (r101 == null) goto L31;
        b r102 = new b(r101.f312526d);
        r102.f312518b = this.f312502g;
        byte[] r103 = A;
        byte[] r104 = new byte[r103.length];
        r102.readFully(r104);
        r102.a(0);
        byte[] r105 = B;
        byte[] r106 = new byte[r105.length];
        r102.readFully(r106);
        if (Arrays.equals(r104, r103) == false) goto L8;
        r102.a(8);
    L10:
        E(r102, 6);
        d r107 = this.f312500e[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START);
        d r108 = this.f312500e[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH);
        if (r107 == null) goto L14;
        if (r108 == null) goto L14;
        this.f312500e[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, r107);
        this.f312500e[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r108);
    L14:
        d r109 = this.f312500e[8].get(ExifInterface.TAG_ORF_ASPECT_FRAME);
        if (r109 == null) goto L32;
        int[] r110 = (int[]) r109.j(this.f312502g);
        if (r110 != null) goto L19;
    L29:
        FLogger.f375446a.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(r110));
        return;
    L19:
        if (r110.length != 4) goto L29;
        int r111 = r110[2];
        int r112 = r110[0];
        if (r111 <= r112) goto L33;
        int r113 = r110[3];
        int r114 = r110[1];
        if (r113 <= r114) goto L34;
        int r115 = (r111 - r112) + 1;
        int r116 = (r113 - r114) + 1;
        if (r115 >= r116) goto L28;
        int r117 = r115 + r116;
        r116 = r117 - r116;
        r115 = r117 - r116;
    L28:
        d r118 = d.e(r115, this.f312502g);
        d r119 = d.e(r116, this.f312502g);
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_WIDTH, r118);
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_LENGTH, r119);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r106, r105) == false) goto L10;
        r102.a(12);
        goto L10
    }

    public final void p(b r100) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "getPngAttributes starting with: " + r100);
    L5:
        r100.mark(0);
        r100.f312518b = ByteOrder.BIG_ENDIAN;
        byte[] r101 = C;
        r100.skipBytes(r101.length);
        int r102 = r101.length + 0;
    L35:
        int r103 = r100.readInt();     // Catch: EOFException -> L33
        int r104 = r102 + 4;     // Catch: EOFException -> L33
        byte[] r105 = new byte[4];     // Catch: EOFException -> L33
        if (r100.read(r105) != 4) goto L32;
        int r106 = r104 + 4;     // Catch: EOFException -> L33
        if (r106 != 16) goto L16;
        if (Arrays.equals(r105, E) == true) goto L16;
        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");     // Catch: EOFException -> L33
    L16:
        if (Arrays.equals(r105, F) == true) goto L40;
        if (Arrays.equals(r105, D) == true) goto L20;
        int r107 = r103 + 4;     // Catch: EOFException -> L33
        r100.skipBytes(r107);     // Catch: EOFException -> L33
        r102 = r106 + r107;     // Catch: EOFException -> L33
        goto L35
    L20:
        byte[] r108 = new byte[r103];     // Catch: EOFException -> L33
        if (r100.read(r108) != r103) goto L29;
        int r109 = r100.readInt();     // Catch: EOFException -> L33
        CRC32 r110 = new CRC32();     // Catch: EOFException -> L33
        r110.update(r105);     // Catch: EOFException -> L33
        r110.update(r108);     // Catch: EOFException -> L33
        if (((int) r110.getValue()) != r109) goto L27;
        this.f312509n = r106;     // Catch: EOFException -> L33
        D(r108, 0);     // Catch: EOFException -> L33
        O();     // Catch: EOFException -> L33
        L(new b(r108));     // Catch: EOFException -> L33
        return;
    L27:
        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + r109 + ", calculated CRC value: " + r110.getValue());     // Catch: EOFException -> L33
    L29:
        throw new IOException("Failed to read given length for given PNG chunk type: " + b(r105));     // Catch: EOFException -> L33
    L40:
        return;
    L32:
        throw new IOException("Encountered invalid length while parsing PNG chunktype");     // Catch: EOFException -> L33
    L34:
        throw new IOException("Encountered corrupt PNG file.");
    }

    public final void q(b r100) throws IOException {
        boolean r101 = f312487r;
        if (r101 == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "getRafAttributes starting with: " + r100);
    L5:
        r100.mark(0);
        r100.skipBytes(84);
        byte[] r102 = new byte[4];
        byte[] r103 = new byte[4];
        byte[] r104 = new byte[4];
        r100.read(r102);
        r100.read(r103);
        r100.read(r104);
        int r105 = ByteBuffer.wrap(r102).getInt();
        int r106 = ByteBuffer.wrap(r103).getInt();
        int r107 = ByteBuffer.wrap(r104).getInt();
        byte[] r108 = new byte[r106];
        r100.a(r105);
        r100.read(r108);
        m(new b(r108), r105, 5);
        r100.a(r107);
        r100.f312518b = ByteOrder.BIG_ENDIAN;
        int r109 = r100.readInt();
        if (r101 == false) goto L8;
        FLogger.f375446a.d("ExifInterface", "numberOfDirectoryEntry: " + r109);
    L8:
        int r110 = 0;
    L9:
        if (r110 >= r109) goto L17;
        int r111 = r100.readUnsignedShort();
        int r112 = r100.readUnsignedShort();
        if (r111 == S.f312527a) goto L12;
        r100.skipBytes(r112);
        r110 = r110 + 1;
        goto L9
    L12:
        short r113 = r100.readShort();
        short r114 = r100.readShort();
        d r115 = d.e(r113, this.f312502g);
        d r116 = d.e(r114, this.f312502g);
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_LENGTH, r115);
        this.f312500e[0].put(ExifInterface.TAG_IMAGE_WIDTH, r116);
        if (f312487r == false) goto L20;
        FLogger.f375446a.d("ExifInterface", "Updated to length: " + r113 + ", width: " + r114);
        return;
    L20:
        return;
    }

    public final void r(b r100) throws IOException {
        A(r100, r100.available());
        E(r100, 0);
        N(r100, 0);
        N(r100, 5);
        N(r100, 4);
        O();
        if (this.f312499d != 8) goto L10;
        d r101 = this.f312500e[1].get(ExifInterface.TAG_MAKER_NOTE);
        if (r101 == null) goto L11;
        b r102 = new b(r101.f312526d);
        r102.f312518b = this.f312502g;
        r102.a(6);
        E(r102, 9);
        d r103 = this.f312500e[9].get(ExifInterface.TAG_COLOR_SPACE);
        if (r103 == null) goto L12;
        this.f312500e[1].put(ExifInterface.TAG_COLOR_SPACE, r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void s(b r100) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "getRw2Attributes starting with: " + r100);
    L5:
        r(r100);
        d r101 = this.f312500e[0].get(ExifInterface.TAG_RW2_JPG_FROM_RAW);
        if (r101 == null) goto L8;
        m(new b(r101.f312526d), (int) r101.f312525c, 5);
    L8:
        d r102 = this.f312500e[0].get(ExifInterface.TAG_RW2_ISO);
        d r103 = this.f312500e[1].get(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (r102 == null) goto L13;
        if (r103 != null) goto L14;
        this.f312500e[1].put(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, r102);
        return;
    L14:
        return;
    }

    public final void u(b r100) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "getWebpAttributes starting with: " + r100);
    L5:
        r100.mark(0);
        r100.f312518b = ByteOrder.LITTLE_ENDIAN;
        r100.skipBytes(G.length);
        int r101 = r100.readInt() + 8;
        int r102 = r100.skipBytes(H.length) + 8;
    L36:
        byte[] r103 = new byte[4];     // Catch: EOFException -> L34
        if (r100.read(r103) != 4) goto L33;
        int r104 = r100.readInt();     // Catch: EOFException -> L34
        int r105 = (r102 + 4) + 4;     // Catch: EOFException -> L34
        if (Arrays.equals(I, r103) == true) goto L11;
        if ((r104 % 2) != 1) goto L20;
        r104 = r104 + 1;
    L20:
        int r106 = r105 + r104;
        if (r106 == r101) goto L42;
        if (r106 > r101) goto L31;
        int r107 = r100.skipBytes(r104);     // Catch: EOFException -> L34
        if (r107 != r104) goto L29;
        r102 = r105 + r107;     // Catch: EOFException -> L34
        goto L36
    L29:
        throw new IOException("Encountered WebP file with invalid chunk size");     // Catch: EOFException -> L34
    L31:
        throw new IOException("Encountered WebP file with invalid chunk size");     // Catch: EOFException -> L34
    L42:
        return;
    L11:
        byte[] r108 = new byte[r104];     // Catch: EOFException -> L34
        if (r100.read(r108) != r104) goto L15;
        this.f312509n = r105;     // Catch: EOFException -> L34
        D(r108, 0);     // Catch: EOFException -> L34
        L(new b(r108));     // Catch: EOFException -> L34
        return;
    L15:
        throw new IOException("Failed to read given length for given PNG chunk type: " + b(r103));     // Catch: EOFException -> L34
    L33:
        throw new IOException("Encountered invalid length while parsing WebP chunktype");     // Catch: EOFException -> L34
    L35:
        throw new IOException("Encountered corrupt WebP file.");
    }

    public final boolean y(HashMap r100) throws IOException {
        d r101 = (d) r100.get(ExifInterface.TAG_IMAGE_LENGTH);
        d r102 = (d) r100.get(ExifInterface.TAG_IMAGE_WIDTH);
        if (r101 == null) goto L10;
        if (r102 == null) goto L12;
        int r103 = r101.h(this.f312502g);
        int r104 = r102.h(this.f312502g);
        if (r103 > 512) goto L13;
        if (r104 > 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public final void z(InputStream r100) {
        int r101 = 0;
    L57:
    L43:
        th = move-exception;
        a();
        if (f312487r == false) goto L56;
        B();
    L56:
        throw th;
    L45:
        e = move-exception;
        boolean r102 = f312487r;     // Catch: Throwable -> L43
        if (r102 == false) goto L49;
        FLogger.f375446a.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);     // Catch: Throwable -> L43
    L49:
        a();
        if (r102 == false) goto L65;
    L51:
        B();
        return;
    L65:
        return;
    L4:
        if (r101 >= T.length) goto L6;
        this.f312500e[r101] = new HashMap();     // Catch: Throwable -> L43 IOException -> L45
        r101 = r101 + 1;     // Catch: Throwable -> L43 IOException -> L45
        goto L57
    L6:
        BufferedInputStream r103 = new BufferedInputStream(r100, 5000);     // Catch: Throwable -> L43 IOException -> L45
        this.f312499d = n(r103);     // Catch: Throwable -> L43 IOException -> L45
        b r104 = new b(r103);     // Catch: Throwable -> L43 IOException -> L45
        switch(this.f312499d) {
            case 0: goto L38;
            case 1: goto L38;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L33;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L32;
            case 8: goto L38;
            case 9: goto L27;
            case 10: goto L22;
            case 11: goto L38;
            case 12: goto L20;
            case 13: goto L14;
            case 14: goto L9;
            default: goto L39;
        };     // Catch: Throwable -> L43 IOException -> L45
    L9:
        u(r104);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == false) goto L59;
        B();
        return;
    L59:
        return;
    L14:
        p(r104);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == false) goto L60;
        B();
        return;
    L60:
        return;
    L22:
        s(r104);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == false) goto L61;
        B();
        return;
    L61:
        return;
    L27:
        q(r104);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == false) goto L62;
        B();
        return;
    L62:
        return;
    L32:
        o(r104);     // Catch: Throwable -> L43 IOException -> L45
        goto L39
    L33:
        m(r104, 0, 0);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == false) goto L63;
        B();
        return;
    L63:
        return;
    L38:
        r(r104);     // Catch: Throwable -> L43 IOException -> L45
    L39:
        r104.a(this.f312509n);     // Catch: Throwable -> L43 IOException -> L45
        L(r104);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (f312487r == true) goto L51;
        return;
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L39;
        l(r104);     // Catch: Throwable -> L43 IOException -> L45
        goto L39
    }

    public ExifInterface2(String r100) throws IOException {
        e[][] r101 = T;
        this.f312500e = new HashMap[r101.length];
        this.f312501f = new HashSet(r101.length);
        this.f312502g = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L26;
        PolarisFileInputStreamWrapper r102 = null;
        this.f312498c = null;
        this.f312496a = r100;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L16 Exception -> L18
    L14:
        e = e;
        r102 = r103;
    L19:
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L16
        d(r102);
    L27:
        return;
    L12:
        th = th;
    L23:
        d(r103);
        throw th;
    L7:
        if (x(r103.getFD()) == false) goto L9;
        this.f312497b = r103.getFD();     // Catch: Throwable -> L12 Exception -> L14
    L10:
        z(r103);     // Catch: Throwable -> L12 Exception -> L14
        d(r103);
        goto L27
    L9:
        this.f312497b = null;     // Catch: Throwable -> L12 Exception -> L14
    L16:
        th = th;
        r103 = r102;
    L18:
        e = e;
        goto L19
    L26:
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface2(InputStream r100) throws IOException {
        e[][] r101 = T;
        this.f312500e = new HashMap[r101.length];
        this.f312501f = new HashSet(r101.length);
        this.f312502g = ByteOrder.BIG_ENDIAN;
        this.f312496a = null;
        if ((r100 instanceof AssetManager.AssetInputStream) == false) goto L6;
        this.f312498c = (AssetManager.AssetInputStream) r100;
        this.f312497b = null;
    L11:
        z(r100);
        return;
    L6:
        if ((r100 instanceof FileInputStream) == false) goto L10;
        FileInputStream r102 = (FileInputStream) r100;
        if (x(r102.getFD()) == false) goto L10;
        this.f312498c = null;
        this.f312497b = r102.getFD();
    L10:
        this.f312498c = null;
        this.f312497b = null;
        goto L11
    }

    public static String e(MediaMetadataRetriever r110, int r111) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void g(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    }

    public final void A(b r100, int r101) throws IOException {
        ByteOrder r102 = C(r100);
        this.f312502g = r102;
        r100.f312518b = r102;
        int r103 = r100.readUnsignedShort();
        int r104 = this.f312499d;
        if (r104 != 7) goto L5;
    L11:
        int r105 = r100.readInt();
        if (r105 < 8) goto L23;
        if (r105 >= r101) goto L23;
        int r106 = r105 - 8;
        if (r106 > 0) goto L17;
        return;
    L17:
        if (r100.skipBytes(r106) != r106) goto L20;
        return;
    L20:
        throw new IOException("Couldn't jump to first Ifd: " + r106);
    L23:
        throw new IOException("Invalid first Ifd offset: " + r105);
    L5:
        if (r104 == 10) goto L11;
        if (r103 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r103));
    }

    public final void D(byte[] r100, int r101) throws IOException {
        b r102 = new b(r100);
        A(r102, r100.length);
        E(r102, r101);
    }

    public final void E(b r310, int r311) throws IOException {
        ((HashSet) this.f312501f).add(Integer.valueOf(r310.f312520d));
        if ((r310.f312520d + 2) <= r310.f312519c) goto L5;
        return;
    L5:
        short r100 = r310.readShort();
        if (f312487r == false) goto L9;
        FLogger.f375446a.d("ExifInterface", "numberOfDirectoryEntry: " + r100);
    L9:
        if ((r310.f312520d + (r100 * 12)) > r310.f312519c) goto L188;
        if (r100 <= 0) goto L196;
        char r101 = 0;
        short r102 = 0;
    L14:
        if (r102 >= r100) goto L162;
        int r110 = r310.readUnsignedShort();
        int r111 = r310.readUnsignedShort();
        int r112 = r310.readInt();
        long r103 = ((long) r310.f312520d) + 4;
        e r104 = X[r311].get(Integer.valueOf(r110));
        boolean r113 = f312487r;
        if (r113 == false) goto L22;
        FLogger r114 = FLogger.f375446a;
        Object[] r115 = new Object[5];
        r115[r101] = Integer.valueOf(r311);
        r115[1] = Integer.valueOf(r110);
        if (r104 == null) goto L20;
        String r105 = r104.f312528b;
    L21:
        r115[2] = r105;
        r115[3] = Integer.valueOf(r111);
        r115[4] = Integer.valueOf(r112);
        r114.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", r115));
        goto L22
    L20:
        r105 = null;
    L22:
        if (r104 != null) goto L26;
        if (r113 == false) goto L25;
        FLogger.f375446a.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + r110);
    L25:
        short r210 = r100;
    L62:
        int r116 = r110;
    L77:
        long r106 = 0;
    L78:
        boolean r107 = false;
    L79:
        if (r107 == true) goto L82;
        r310.a(r103);
        r102 = r102;
    L160:
        r102 = (short) (r102 + 1);
        r100 = r210;
        r101 = 0;
        goto L14
    L82:
        if (r106 <= 4) goto L105;
        int r117 = r310.readInt();
        if (r113 == false) goto L88;
        FLogger.f375446a.d("ExifInterface", "seek to data offset: " + r117);
    L88:
        if (this.f312499d != 7) goto L98;
        if (ExifInterface.TAG_MAKER_NOTE.equals(r104.f312528b) == false) goto L93;
        this.f312510o = r117;
        goto L98
    L93:
        if (r311 != 6) goto L98;
        if (ExifInterface.TAG_ORF_THUMBNAIL_IMAGE.equals(r104.f312528b) == false) goto L98;
        this.f312511p = r117;
        this.f312512q = r112;
        d r108 = d.e(6, this.f312502g);
        d r118 = d.b(this.f312511p, this.f312502g);
        d r109 = d.b(this.f312512q, this.f312502g);
        this.f312500e[4].put(ExifInterface.TAG_COMPRESSION, r108);
        this.f312500e[4].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, r118);
        this.f312500e[4].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r109);
    L98:
        long r119 = r117;
        if ((r119 + r106) > r310.f312519c) goto L101;
        r310.a(r119);
    L106:
        Integer r120 = f312481a0.get(Integer.valueOf(r116));
        if (r113 == false) goto L109;
        FLogger.f375446a.d("ExifInterface", "nextIfdType: " + r120 + " byteCount: " + r106);
    L109:
        if (r120 == null) goto L141;
        int r121 = r111;
        if (r121 != 3) goto L113;
        int r122 = r310.readUnsignedShort();
    L125:
        long r123 = r122;
    L126:
        if (r113 == false) goto L130;
        FLogger.f375446a.d("ExifInterface", String.format("Offset: %d, tagName: %s", new Object[]{Long.valueOf(r123), r104.f312528b}));
    L130:
        if (r123 > 0) goto L132;
    L138:
        if (r113 == false) goto L140;
        FLogger.f375446a.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + r123);
    L140:
        r310.a(r103);
        goto L160
    L132:
        if (r123 >= r310.f312519c) goto L138;
        if (((HashSet) this.f312501f).contains(Integer.valueOf((int) r123)) == true) goto L136;
        r310.a(r123);
        E(r310, r120.intValue());
        goto L140
    L136:
        if (r113 == false) goto L140;
        FLogger.f375446a.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + r120 + " (at " + r123 + ")");
        goto L140
    L113:
        if (r121 != 4) goto L115;
        r123 = ((long) r310.readInt()) & BodyPartID.bodyIdMax;
        goto L126
    L115:
        if (r121 != 8) goto L117;
        r122 = r310.readShort();
        goto L125
    L117:
        if (r121 != 9) goto L119;
    L121:
        r122 = r310.readInt();
        goto L125
    L119:
        if (r121 == 13) goto L121;
        r123 = -1;
        goto L126
    L141:
        e r124 = r104;
        int r125 = r310.f312520d + this.f312509n;
        byte[] r126 = new byte[(int) r106];
        r310.readFully(r126);
        d r127 = new d(r111, r112, r125, r126);
        this.f312500e[r311].put(r124.f312528b, r127);
        if (ExifInterface.TAG_DNG_VERSION.equals(r124.f312528b) == false) goto L145;
        this.f312499d = 3;
    L145:
        if (ExifInterface.TAG_MAKE.equals(r124.f312528b) == true) goto L149;
        if (ExifInterface.TAG_MODEL.equals(r124.f312528b) == true) goto L149;
    L153:
        if (ExifInterface.TAG_COMPRESSION.equals(r124.f312528b) == false) goto L158;
        if (r127.h(this.f312502g) != 65535) goto L158;
    L156:
        this.f312499d = 8;
    L158:
        if (r310.f312520d == r103) goto L160;
        r310.a(r103);
    L149:
        if (r127.i(this.f312502g) == null) goto L153;
        if (r127.i(this.f312502g).contains("PENTAX") == true) goto L156;
    L101:
        if (r113 == false) goto L103;
        FLogger.f375446a.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + r117);
    L103:
        r310.a(r103);
        goto L160
    L105:
        r104 = r104;
        r102 = r102;
        r111 = r111;
        r112 = r112;
        goto L106
    L26:
        if (r111 <= 0) goto L74;
        int[] r128 = Q;
        if (r111 >= r128.length) goto L74;
        int r129 = r104.f312529c;
        if (r129 == 7) goto L57;
        if (r111 == 7) goto L57;
        if (r129 == r111) goto L57;
        int r130 = r104.f312530d;
        if (r130 == r111) goto L57;
        r210 = r100;
        if (r129 == 4) goto L42;
        if (r130 == 4) goto L42;
    L45:
        if (r129 == 9) goto L48;
        if (r130 == 9) goto L48;
    L51:
        if (r129 == 12) goto L54;
        if (r130 == 12) goto L54;
    L56:
        boolean r131 = false;
    L59:
        if (r131 == true) goto L64;
        if (r113 == false) goto L62;
        FLogger.f375446a.d("ExifInterface", "Skip the tag entry since data format (" + P[r111] + ") is unexpected for tag: " + r104.f312528b);
        goto L62
    L64:
        if (r111 != 7) goto L66;
        r111 = r129;
    L66:
        r116 = r110;
        r106 = ((long) r128[r111]) * ((long) r112);
        if (r106 >= 0) goto L69;
    L72:
        if (r113 == false) goto L78;
        FLogger.f375446a.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + r112);
        goto L78
    L69:
        if (r106 > SieveCacheKt.NodeLinkMask) goto L72;
        r107 = true;
    L54:
        if (r111 != 11) goto L56;
    L58:
        r131 = true;
    L48:
        if (r111 != 8) goto L51;
    L42:
        if (r111 != 3) goto L45;
    L57:
        r210 = r100;
    L74:
        r210 = r100;
        r116 = r110;
        if (r113 == false) goto L77;
        FLogger.f375446a.d("ExifInterface", "Skip the tag entry since data format is invalid: " + r111);
        goto L77
    L162:
        if ((r310.f312520d + 4) > r310.f312519c) goto L189;
        int r132 = r310.readInt();
        boolean r133 = f312487r;
        if (r133 == false) goto L166;
        FLogger.f375446a.d("ExifInterface", String.format("nextIfdOffset: %d", new Object[]{Integer.valueOf(r132)}));
    L166:
        long r134 = r132;
        if (r134 > 0) goto L169;
    L180:
        if (r133 == false) goto L195;
        FLogger.f375446a.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + r132);
        return;
    L195:
        return;
    L169:
        if (r132 >= r310.f312519c) goto L180;
        if (((HashSet) this.f312501f).contains(Integer.valueOf(r132)) == true) goto L178;
        r310.a(r134);
        if (this.f312500e[4].isEmpty() == false) goto L176;
        E(r310, 4);
        return;
    L176:
        if (this.f312500e[5].isEmpty() == false) goto L191;
        E(r310, 5);
        return;
    L191:
        return;
    L178:
        if (r133 == false) goto L193;
        FLogger.f375446a.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + r132);
        return;
    L193:
        return;
    L189:
        return;
    L196:
        return;
    }

    public final void H(InputStream r110, OutputStream r111) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + r110 + ", outputStream: " + r111 + ")");
    L5:
        DataInputStream r100 = new DataInputStream(r110);
        c r112 = new c(r111, ByteOrder.BIG_ENDIAN);
        if (r100.readByte() != (-1)) goto L57;
        r112.a(-1);
        if (r100.readByte() != (-40)) goto L55;
        r112.a(-40);
        j(ExifInterface.TAG_XMP);
        r112.a(-1);
        r112.a(-31);
        P(r112);
        byte[] r101 = new byte[4096];
    L11:
        if (r100.readByte() != (-1)) goto L53;
        byte r102 = r100.readByte();
        if (r102 == (-39)) goto L50;
        if (r102 == (-38)) goto L50;
        if (r102 != (-31)) goto L18;
        int r103 = r100.readUnsignedShort() - 2;
        if (r103 < 0) goto L49;
        byte[] r113 = new byte[6];
        if (r103 < 6) goto L41;
        if (r100.read(r113) != 6) goto L40;
        if (Arrays.equals(r113, f312483c0) == false) goto L41;
        int r104 = r103 - 6;
        if (r100.skipBytes(r104) == r104) goto L11;
        throw new IOException("Invalid length");
    L40:
        throw new IOException("Invalid exif");
    L41:
        r112.a(-1);
        r112.a(r102);
        r112.c((short) (r103 + 2));
        if (r103 < 6) goto L44;
        r103 = r103 - 6;
        r112.write(r113);
    L44:
        if (r103 <= 0) goto L11;
        int r105 = r100.read(r101, 0, Math.min(r103, 4096));
        if (r105 < 0) goto L11;
        r112.write(r101, 0, r105);
        r103 = r103 - r105;
        goto L44
    L49:
        throw new IOException("Invalid length");
    L18:
        r112.a(-1);
        r112.a(r102);
        int r106 = r100.readUnsignedShort();
        r112.c((short) r106);
        int r107 = r106 - 2;
        if (r107 < 0) goto L25;
    L20:
        if (r107 <= 0) goto L11;
        int r108 = r100.read(r101, 0, Math.min(r107, 4096));
        if (r108 < 0) goto L11;
        r112.write(r101, 0, r108);
        r107 = r107 - r108;
        goto L20
    L25:
        throw new IOException("Invalid length");
    L50:
        r112.a(-1);
        r112.a(r102);
        g(r100, r112);
        return;
    L53:
        throw new IOException("Invalid marker");
    L55:
        throw new IOException("Invalid marker");
    L57:
        throw new IOException("Invalid marker");
    }

    public final void I(InputStream r100, OutputStream r101) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "savePngAttributes starting with (inputStream: " + r100 + ", outputStream: " + r101 + ")");
    L5:
        DataInputStream r102 = new DataInputStream(r100);
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
        c r104 = new c(r101, r103);
        byte[] r105 = C;
        h(r102, r104, r105.length);
        int r106 = this.f312509n;
        if (r106 != 0) goto L8;
        int r107 = r102.readInt();
        r104.b(r107);
        h(r102, r104, (r107 + 4) + 4);
    L21:
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        c r109 = new c(r108, r103);     // Catch: Throwable -> L13
        P(r109);     // Catch: Throwable -> L13
        byte[] r110 = ((ByteArrayOutputStream) r109.f312521a).toByteArray();     // Catch: Throwable -> L13
        r104.write(r110);     // Catch: Throwable -> L13
        CRC32 r111 = new CRC32();     // Catch: Throwable -> L13
        r111.update(r110, 4, r110.length - 4);     // Catch: Throwable -> L13
        r104.b((int) r111.getValue());     // Catch: Throwable -> L13
        d(r108);
        g(r102, r104);
        return;
    L13:
        th = th;
    L17:
        d(r108);
        throw th;
    L15:
        th = th;
        r108 = null;
        goto L17
    L8:
        h(r102, r104, ((r106 - r105.length) - 4) - 4);
        r102.skipBytes((r102.readInt() + 4) + 4);
        goto L21
    }

    public final void J(InputStream r210, OutputStream r211) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + r210 + ", outputStream: " + r211 + ")");
    L5:
        ByteOrder r100 = ByteOrder.LITTLE_ENDIAN;
        b r101 = new b(r210, r100);
        c r102 = new c(r211, r100);
        byte[] r103 = G;
        h(r101, r102, r103.length);
        byte[] r104 = H;
        r101.skipBytes(r104.length + 4);
        ByteArrayOutputStream r105 = null;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();     // Catch: Throwable -> L74 Exception -> L76
        c r110 = new c(r106, r100);     // Catch: Throwable -> L31 Exception -> L72
        int r107 = this.f312509n;     // Catch: Throwable -> L31 Exception -> L72
        if (r107 == 0) goto L10;
        h(r101, r110, ((r107 - ((r103.length + 4) + r104.length)) - 4) - 4);     // Catch: Throwable -> L31 Exception -> L72
        r101.skipBytes(4);     // Catch: Throwable -> L31 Exception -> L72
        r101.skipBytes(r101.readInt());     // Catch: Throwable -> L31 Exception -> L72
        P(r110);     // Catch: Throwable -> L31 Exception -> L72
    L67:
        g(r101, r110);     // Catch: Throwable -> L31 Exception -> L72
        int r108 = r106.size();     // Catch: Throwable -> L31 Exception -> L72
        byte[] r109 = H;     // Catch: Throwable -> L31 Exception -> L72
        r102.b(r108 + r109.length);     // Catch: Throwable -> L31 Exception -> L72
        r102.write(r109);     // Catch: Throwable -> L31 Exception -> L72
        r106.writeTo(r102);     // Catch: Throwable -> L31 Exception -> L72
        d(r106);
        return;
    L10:
        byte[] r111 = new byte[4];     // Catch: Throwable -> L31 Exception -> L72
        if (r101.read(r111) != 4) goto L71;
        byte[] r112 = K;     // Catch: Throwable -> L31 Exception -> L72
        boolean r113 = false;
        if (Arrays.equals(r111, r112) == false) goto L34;
        int r114 = r101.readInt();     // Catch: Throwable -> L31 Exception -> L72
        if ((r114 % 2) != 1) goto L17;
        int r115 = r114 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L18:
        byte[] r116 = new byte[r115];     // Catch: Throwable -> L31 Exception -> L72
        r101.read(r116);     // Catch: Throwable -> L31 Exception -> L72
        byte r117 = (byte) (8 | r116[0]);     // Catch: Throwable -> L31 Exception -> L72
        r116[0] = r117;     // Catch: Throwable -> L31 Exception -> L72
        if (((r117 >> 1) & 1) != 1) goto L21;
        r113 = true;
    L21:
        r110.write(r112);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(r114);     // Catch: Throwable -> L31 Exception -> L72
        r110.write(r116);     // Catch: Throwable -> L31 Exception -> L72
        if (r113 == false) goto L33;
        i(r101, r110, N, null);     // Catch: Throwable -> L31 Exception -> L72
    L24:
        byte[] r118 = new byte[4];     // Catch: Throwable -> L31 Exception -> L72
        r210.read(r118);     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r118, O) == false) goto L26;
        int r119 = r101.readInt();     // Catch: Throwable -> L31 Exception -> L72
        r110.write(r118);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(r119);     // Catch: Throwable -> L31 Exception -> L72
        if ((r119 % 2) != 1) goto L30;
        r119 = r119 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L30:
        h(r101, r110, r119);     // Catch: Throwable -> L31 Exception -> L72
        goto L24
    L26:
        P(r110);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L33:
        i(r101, r110, M, L);     // Catch: Throwable -> L31 Exception -> L72
        P(r110);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L17:
        r115 = r114;
        goto L18
    L34:
        byte[] r120 = M;     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r111, r120) == false) goto L37;
    L38:
        int r121 = r101.readInt();     // Catch: Throwable -> L31 Exception -> L72
        if ((r121 % 2) != 1) goto L41;
        int r122 = r121 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L42:
        byte[] r123 = new byte[3];     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r111, r120) == false) goto L52;
        r101.read(r123);     // Catch: Throwable -> L31 Exception -> L72
        byte[] r124 = new byte[3];     // Catch: Throwable -> L31 Exception -> L72
        if (r101.read(r124) != 3) goto L50;
        if (Arrays.equals(f312480J, r124) == false) goto L50;
        int r125 = r101.readInt();     // Catch: Throwable -> L31 Exception -> L72
        int r126 = (r125 << 18) >> 18;     // Catch: Throwable -> L31 Exception -> L72
        int r127 = (r125 << 2) >> 18;     // Catch: Throwable -> L31 Exception -> L72
        r122 = r122 - 10;     // Catch: Throwable -> L31 Exception -> L72
    L59:
        int r128 = r127;
        int r129 = r126;
        int r130 = 0;
    L60:
        r110.write(r112);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(10);     // Catch: Throwable -> L31 Exception -> L72
        byte[] r131 = new byte[10];     // Catch: Throwable -> L31 Exception -> L72
        byte r132 = (byte) (r131[0] | 8);     // Catch: Throwable -> L31 Exception -> L72
        r131[0] = r132;     // Catch: Throwable -> L31 Exception -> L72
        r131[0] = (byte) (r132 | (r130 << 4));     // Catch: Throwable -> L31 Exception -> L72
        int r133 = r129 - 1;     // Catch: Throwable -> L31 Exception -> L72
        int r134 = r128 - 1;     // Catch: Throwable -> L31 Exception -> L72
        r131[4] = (byte) r133;     // Catch: Throwable -> L31 Exception -> L72
        r131[5] = (byte) (r133 >> 8);     // Catch: Throwable -> L31 Exception -> L72
        r131[6] = (byte) (r133 >> 16);     // Catch: Throwable -> L31 Exception -> L72
        r131[7] = (byte) r134;     // Catch: Throwable -> L31 Exception -> L72
        r131[8] = (byte) (r134 >> 8);     // Catch: Throwable -> L31 Exception -> L72
        r131[9] = (byte) (r134 >> 16);     // Catch: Throwable -> L31 Exception -> L72
        r110.write(r131);     // Catch: Throwable -> L31 Exception -> L72
        r110.write(r111);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(r121);     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r111, r120) == false) goto L64;
        r110.write(r123);     // Catch: Throwable -> L31 Exception -> L72
        r110.write(f312480J);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(r125);     // Catch: Throwable -> L31 Exception -> L72
    L66:
        h(r101, r110, r122);     // Catch: Throwable -> L31 Exception -> L72
        P(r110);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L64:
        if (Arrays.equals(r111, L) == false) goto L66;
        r110.write(47);     // Catch: Throwable -> L31 Exception -> L72
        r110.b(r125);     // Catch: Throwable -> L31 Exception -> L72
    L50:
        throw new IOException("Encountered error while checking VP8 signature");     // Catch: Throwable -> L31 Exception -> L72
    L52:
        if (Arrays.equals(r111, L) == true) goto L54;
        r125 = 0;
        r126 = 0;
        r127 = 0;
        goto L59
    L54:
        if (r101.readByte() != 47) goto L57;
        r125 = r101.readInt();     // Catch: Throwable -> L31 Exception -> L72
        r129 = ((r125 << 18) >> 18) + 1;     // Catch: Throwable -> L31 Exception -> L72
        r128 = ((r125 << 4) >> 18) + 1;     // Catch: Throwable -> L31 Exception -> L72
        r130 = r125 & 8;     // Catch: Throwable -> L31 Exception -> L72
        r122 = r122 - 5;     // Catch: Throwable -> L31 Exception -> L72
        goto L60
    L57:
        throw new IOException("Encountered error while checking VP8L signature");     // Catch: Throwable -> L31 Exception -> L72
    L41:
        r122 = r121;
        goto L42
    L37:
        if (Arrays.equals(r111, L) == false) goto L67;
    L71:
        throw new IOException("Encountered invalid length while parsing WebP chunk type");     // Catch: Throwable -> L31 Exception -> L72
    L72:
        e = e;
        r105 = r106;
    L78:
        throw new IOException("Failed to save WebP file", e);     // Catch: Throwable -> L74
    L31:
        th = th;
    L80:
        d(r106);
        throw th;
    L76:
        e = e;
    L74:
        th = th;
        r106 = r105;
        goto L80
    }

    public final void K(String r110, String r210) {
        String r100 = r110;
        String r101 = r210;
        if (r100 == null) goto L147;
        if (ExifInterface.TAG_DATETIME.equals(r100) == false) goto L7;
    L10:
        if (r101 == null) goto L21;
        boolean r102 = f312485e0.matcher(r101).find();
        boolean r103 = f312486f0.matcher(r101).find();
        if (r210.length() != 19) goto L18;
        if (r102 == true) goto L16;
        if (r103 == false) goto L18;
    L16:
        if (r103 == false) goto L21;
        r101 = r101.replaceAll("-", ":");
    L18:
        FLogger.f375446a.w("ExifInterface", "Invalid value for " + r100 + " : " + r101);
        return;
    L21:
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(r100) == true) goto L23;
    L26:
        int r104 = 2;
        int r105 = 1;
        if (r101 != null) goto L29;
    L44:
        int r106 = 0;
    L46:
        if (r106 >= T.length) goto L145;
        if (r106 == 4) goto L50;
    L52:
        e r107 = Y[r106].get(r100);
        if (r107 == null) goto L144;
        if (r101 != null) goto L56;
        this.f312500e[r106].remove(r100);
        goto L144
    L56:
        Pair<Integer, Integer> r111 = v(r101);
        int r112 = -1;
        if (r107.f312529c != ((Integer) r111.first).intValue()) goto L59;
    L85:
        int r108 = r107.f312529c;
    L87:
        switch(r108) {
            case 1: goto L134;
            case 2: goto L131;
            case 3: goto L125;
            case 4: goto L120;
            case 5: goto L115;
            case 6: goto L89;
            case 7: goto L131;
            case 8: goto L89;
            case 9: goto L107;
            case 10: goto L99;
            case 11: goto L89;
            case 12: goto L91;
            default: goto L89;
        };
    L91:
        String[] r109 = r101.split(",", -1);
        int r113 = r109.length;
        double[] r114 = new double[r113];
        int r115 = 0;
    L93:
        if (r115 >= r109.length) goto L95;
        r114[r115] = CastDoubleProtector.parseDouble(r109[r115]);
        r115 = r115 + 1;
        goto L93
    L95:
        HashMap<String, d> r116 = this.f312500e[r106];
        ByteOrder r117 = this.f312502g;
        ByteBuffer r118 = ByteBuffer.wrap(new byte[Q[12] * r113]);
        r118.order(r117);
        int r119 = 0;
    L96:
        if (r119 >= r113) goto L98;
        r118.putDouble(r114[r119]);
        r119 = r119 + 1;
        goto L96
    L98:
        r116.put(r100, new d(12, r113, r118.array()));
        goto L144
    L99:
        String[] r120 = r101.split(",", -1);
        int r121 = r120.length;
        f[] r122 = new f[r121];
        int r123 = 0;
    L101:
        if (r123 >= r120.length) goto L103;
        String[] r124 = r120[r123].split(HTTP.URL_DEFAULT, r112);
        r122[r123] = new f((long) CastDoubleProtector.parseDouble(r124[0]), (long) CastDoubleProtector.parseDouble(r124[r105]));
        r123 = r123 + 1;
        r121 = r121;
        r105 = 1;
        r112 = -1;
        goto L101
    L103:
        int r125 = r121;
        HashMap<String, d> r126 = this.f312500e[r106];
        ByteOrder r127 = this.f312502g;
        ByteBuffer r128 = ByteBuffer.wrap(new byte[Q[10] * r125]);
        r128.order(r127);
        int r129 = 0;
    L104:
        if (r129 >= r125) goto L106;
        f r130 = r122[r129];
        r128.putInt((int) r130.f312531a);
        r128.putInt((int) r130.f312532b);
        r129 = r129 + 1;
        goto L104
    L106:
        r126.put(r100, new d(10, r125, r128.array()));
        goto L144
    L107:
        String[] r131 = r101.split(",", -1);
        int r132 = r131.length;
        int[] r133 = new int[r132];
        int r134 = 0;
    L109:
        if (r134 >= r131.length) goto L111;
        r133[r134] = CastIntegerProtector.parseInt(r131[r134]);
        r134 = r134 + 1;
        goto L109
    L111:
        HashMap<String, d> r135 = this.f312500e[r106];
        ByteOrder r136 = this.f312502g;
        ByteBuffer r137 = ByteBuffer.wrap(new byte[Q[9] * r132]);
        r137.order(r136);
        int r138 = 0;
    L112:
        if (r138 >= r132) goto L114;
        r137.putInt(r133[r138]);
        r138 = r138 + 1;
        goto L112
    L114:
        r135.put(r100, new d(9, r132, r137.array()));
        goto L144
    L115:
        int r139 = -1;
        String[] r140 = r101.split(",", -1);
        f[] r141 = new f[r140.length];
        int r142 = 0;
    L117:
        if (r142 >= r140.length) goto L119;
        String[] r143 = r140[r142].split(HTTP.URL_DEFAULT, r139);
        r141[r142] = new f((long) CastDoubleProtector.parseDouble(r143[0]), (long) CastDoubleProtector.parseDouble(r143[1]));
        r142 = r142 + 1;
        r139 = -1;
        goto L117
    L119:
        this.f312500e[r106].put(r100, d.d(r141, this.f312502g));
        goto L144
    L120:
        String[] r144 = r101.split(",", -1);
        long[] r145 = new long[r144.length];
        int r146 = 0;
    L122:
        if (r146 >= r144.length) goto L124;
        r145[r146] = CastLongProtector.parseLong(r144[r146]);
        r146 = r146 + 1;
        goto L122
    L124:
        this.f312500e[r106].put(r100, d.c(r145, this.f312502g));
        goto L144
    L125:
        String[] r147 = r101.split(",", -1);
        int[] r148 = new int[r147.length];
        int r149 = 0;
    L127:
        if (r149 >= r147.length) goto L129;
        r148[r149] = CastIntegerProtector.parseInt(r147[r149]);
        r149 = r149 + 1;
        goto L127
    L129:
        this.f312500e[r106].put(r100, d.f(r148, this.f312502g));
        goto L144
    L134:
        HashMap<String, d> r150 = this.f312500e[r106];
        if (r101.length() == 1) goto L137;
    L141:
        byte[] r151 = r101.getBytes(f312482b0);
        d r152 = new d(1, r151.length, r151);
    L142:
        r150.put(r100, r152);
        goto L144
    L137:
        if (r101.charAt(0) < '0') goto L141;
        if (r101.charAt(0) > '1') goto L141;
        r152 = new d(1, 1, new byte[]{(byte) (r101.charAt(0) - '0')});
        goto L142
    L89:
        if (f312487r == false) goto L144;
        FLogger.f375446a.d("ExifInterface", "Data format isn't one of expected formats: " + r108);
        goto L144
    L131:
        if (r100.equals(ExifInterface.TAG_USER_COMMENT) == false) goto L133;
        HashMap<String, d> r153 = this.f312500e[r106];
        byte[] r154 = r101.concat("\u0000").getBytes(f312482b0);
        byte[] r155 = R;
        int r156 = r155.length + r154.length;
        byte[] r157 = new byte[r156];
        System.arraycopy(r155, 0, r157, 0, r155.length);
        System.arraycopy(r154, 0, r157, r155.length, r154.length);
        r153.put(r100, new d(7, r156, r157));
        goto L144
    L133:
        this.f312500e[r106].put(r100, d.a(r101));
        goto L144
    L59:
        if (r107.f312529c == ((Integer) r111.second).intValue()) goto L85;
        int r158 = r107.f312530d;
        if (r158 != (-1)) goto L64;
    L68:
        int r159 = r107.f312529c;
        if (r159 == r105) goto L84;
        if (r159 == 7) goto L84;
        if (r159 == r104) goto L84;
        if (f312487r == false) goto L144;
        FLogger r160 = FLogger.f375446a;
        StringBuilder r161 = new StringBuilder("Given tag (");
        r161.append(r100);
        r161.append(") value didn't match with one of expected formats: ");
        String[] r162 = P;
        r161.append(r162[r107.f312529c]);
        String r163 = "";
        if (r107.f312530d != (-1)) goto L78;
        String r164 = "";
    L79:
        r161.append(r164);
        r161.append(" (guess: ");
        r161.append(r162[((Integer) r111.first).intValue()]);
        if (((Integer) r111.second).intValue() == (-1)) goto L83;
        r163 = ", " + r162[((Integer) r111.second).intValue()];
    L83:
        r161.append(r163);
        r161.append(")");
        r160.d("ExifInterface", r161.toString());
        goto L144
    L78:
        r164 = ", " + r162[r107.f312530d];
    L84:
        r108 = r159;
        goto L87
    L64:
        if (r158 != ((Integer) r111.first).intValue()) goto L66;
    L67:
        r108 = r107.f312530d;
        goto L87
    L66:
        if (r107.f312530d != ((Integer) r111.second).intValue()) goto L68;
    L144:
        r106 = r106 + 1;
        r104 = 2;
        r105 = 1;
        goto L46
    L50:
        if (this.f312503h == true) goto L52;
    L145:
        return;
    L29:
        if (Z.contains(r100) == false) goto L44;
        if (r100.equals(ExifInterface.TAG_GPS_TIMESTAMP) == false) goto L148;
        Matcher r165 = f312484d0.matcher(r101);
        if (r165.find() == true) goto L36;
        FLogger.f375446a.w("ExifInterface", "Invalid value for " + r100 + " : " + r101);
        return;
    L36:
        r101 = CastIntegerProtector.parseInt(r165.group(1)) + "/1," + CastIntegerProtector.parseInt(r165.group(2)) + "/1," + CastIntegerProtector.parseInt(r165.group(3)) + "/1";
        goto L44
    L148:
        long r166 = (long) (CastDoubleProtector.parseDouble(r101) * 10000.0d);     // Catch: NumberFormatException -> L42
        long r167 = 10000;
        if (10000 != 0) goto L40;
        r167 = 1;
        r166 = 0;
    L40:
        r101 = r166 + HTTP.URL_DEFAULT + r167;     // Catch: NumberFormatException -> L42
    L42:
        FLogger.f375446a.w("ExifInterface", "Invalid value for " + r100 + " : " + r101);
        return;
    L23:
        if (f312487r == false) goto L25;
        FLogger.f375446a.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L25:
        r100 = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        goto L26
    L7:
        if (ExifInterface.TAG_DATETIME_ORIGINAL.equals(r100) == true) goto L10;
        if (ExifInterface.TAG_DATETIME_DIGITIZED.equals(r100) == false) goto L21;
    L147:
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void M(int r100, int r101) throws IOException {
        if (this.f312500e[r100].isEmpty() == true) goto L26;
        if (this.f312500e[r101].isEmpty() == true) goto L26;
        d r102 = this.f312500e[r100].get(ExifInterface.TAG_IMAGE_LENGTH);
        d r103 = this.f312500e[r100].get(ExifInterface.TAG_IMAGE_WIDTH);
        d r104 = this.f312500e[r101].get(ExifInterface.TAG_IMAGE_LENGTH);
        d r105 = this.f312500e[r101].get(ExifInterface.TAG_IMAGE_WIDTH);
        if (r102 == null) goto L22;
        if (r103 == null) goto L22;
        if (r104 == null) goto L19;
        if (r105 == null) goto L19;
        int r106 = r102.h(this.f312502g);
        int r107 = r103.h(this.f312502g);
        int r108 = r104.h(this.f312502g);
        int r109 = r105.h(this.f312502g);
        if (r106 >= r108) goto L29;
        if (r107 >= r109) goto L30;
        HashMap<String, d>[] r110 = this.f312500e;
        HashMap<String, d> r111 = r110[r100];
        r110[r100] = r110[r101];
        r110[r101] = r111;
        return;
    L30:
        return;
    L29:
        return;
    L19:
        if (f312487r == false) goto L32;
        FLogger.f375446a.d("ExifInterface", "Second image does not contain valid size information");
        return;
    L32:
        return;
    L22:
        if (f312487r == false) goto L34;
        FLogger.f375446a.d("ExifInterface", "First image does not contain valid size information");
        return;
    L34:
        return;
    L26:
        if (f312487r == false) goto L35;
        FLogger.f375446a.d("ExifInterface", "Cannot perform swap since only one image data exists");
        return;
    }

    public final void N(b r110, int r111) throws IOException {
        d r100 = this.f312500e[r111].get(ExifInterface.TAG_DEFAULT_CROP_SIZE);
        d r101 = this.f312500e[r111].get(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER);
        d r102 = this.f312500e[r111].get(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER);
        d r103 = this.f312500e[r111].get(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER);
        d r104 = this.f312500e[r111].get(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (r100 != null) goto L5;
        if (r101 == null) goto L31;
        if (r102 == null) goto L31;
        if (r103 == null) goto L31;
        if (r104 == null) goto L31;
        int r112 = r101.h(this.f312502g);
        int r105 = r103.h(this.f312502g);
        int r106 = r104.h(this.f312502g);
        int r107 = r102.h(this.f312502g);
        if (r105 <= r112) goto L40;
        if (r106 <= r107) goto L41;
        d r113 = d.e(r105 - r112, this.f312502g);
        d r108 = d.e(r106 - r107, this.f312502g);
        this.f312500e[r111].put(ExifInterface.TAG_IMAGE_LENGTH, r113);
        this.f312500e[r111].put(ExifInterface.TAG_IMAGE_WIDTH, r108);
        return;
    L41:
        return;
    L40:
        return;
    L31:
        d r109 = this.f312500e[r111].get(ExifInterface.TAG_IMAGE_LENGTH);
        d r114 = this.f312500e[r111].get(ExifInterface.TAG_IMAGE_WIDTH);
        if (r109 == null) goto L34;
        if (r114 == null) goto L34;
        return;
    L34:
        d r115 = this.f312500e[r111].get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        d r116 = this.f312500e[r111].get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r115 == null) goto L44;
        if (r116 == null) goto L45;
        int r117 = r115.h(this.f312502g);
        int r118 = r115.h(this.f312502g);
        r110.a(r117);
        byte[] r119 = new byte[r118];
        r110.read(r119);
        m(new b(r119), r117, r111);
        return;
    L45:
        return;
    L44:
        return;
    L5:
        if (r100.f312523a != 5) goto L14;
        f[] r120 = (f[]) r100.j(this.f312502g);
        if (r120 != null) goto L9;
    L12:
        FLogger.f375446a.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(r120));
        return;
    L9:
        if (r120.length != 2) goto L12;
        d r121 = d.d(new f[]{r120[0]}, this.f312502g);
        d r122 = d.d(new f[]{r120[1]}, this.f312502g);
    L20:
        this.f312500e[r111].put(ExifInterface.TAG_IMAGE_WIDTH, r121);
        this.f312500e[r111].put(ExifInterface.TAG_IMAGE_LENGTH, r122);
        return;
    L14:
        int[] r123 = (int[]) r100.j(this.f312502g);
        if (r123 != null) goto L17;
    L21:
        FLogger.f375446a.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(r123));
        return;
    L17:
        if (r123.length != 2) goto L21;
        r121 = d.e(r123[0], this.f312502g);
        r122 = d.e(r123[1], this.f312502g);
        goto L20
    }

    public final void w(b r100, HashMap r101) throws IOException {
        d r102 = (d) r101.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        d r103 = (d) r101.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r102 == null) goto L23;
        if (r103 == null) goto L24;
        int r104 = r102.h(this.f312502g);
        int r105 = r103.h(this.f312502g);
        if (this.f312499d != 7) goto L8;
        r104 = r104 + this.f312510o;
    L8:
        int r106 = Math.min(r105, r100.f312519c - r104);
        if (r104 <= 0) goto L20;
        if (r106 <= 0) goto L20;
        this.f312503h = true;
        if (this.f312496a == null) goto L14;
    L18:
        this.f312505j = r104;
        this.f312506k = r106;
        goto L20
    L14:
        if (this.f312498c != null) goto L18;
        if (this.f312497b != null) goto L18;
        byte[] r107 = new byte[r106];
        r100.skip(r104);
        r100.read(r107);
        this.f312507l = r107;
    L20:
        if (f312487r == false) goto L25;
        FLogger.f375446a.d("ExifInterface", "Setting thumbnail attributes with offset: " + r104 + ", length: " + r106);
        return;
    L25:
        return;
    L24:
        return;
    }

    public static void h(InputStream r100, OutputStream r101, int r102) throws IOException {
        byte[] r103 = new byte[8192];
    L3:
        if (r102 <= 0) goto L9;
        int r104 = Math.min(r102, 8192);
        int r105 = r100.read(r103, 0, r104);
        if (r105 != r104) goto L8;
        r102 = r102 - r105;
        r101.write(r103, 0, r105);
        goto L3
    L8:
        throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
    }

    public final void m(b r110, int r111, int r112) throws IOException {
        if (f312487r == false) goto L5;
        FLogger.f375446a.d("ExifInterface", "getJpegAttributes starting with: " + r110);
    L5:
        r110.mark(0);
        r110.f312518b = ByteOrder.BIG_ENDIAN;
        byte r100 = r110.readByte();
        if (r100 != (-1)) goto L80;
        if (r110.readByte() != (-40)) goto L78;
        int r101 = 2;
    L10:
        byte r102 = r110.readByte();
        if (r102 != (-1)) goto L76;
        boolean r103 = true;
        int r104 = r101 + 1;
        byte r105 = r110.readByte();
        boolean r113 = f312487r;
        if (r113 == false) goto L15;
        FLogger.f375446a.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(r105 & UByte.MAX_VALUE));
    L15:
        int r106 = r104 + 1;
        if (r105 == (-39)) goto L73;
        if (r105 == (-38)) goto L73;
        int r114 = r110.readUnsignedShort() - 2;
        int r107 = r106 + 2;
        if (r113 == false) goto L24;
        FLogger.f375446a.d("ExifInterface", "JPEG segment: " + Integer.toHexString(r105 & UByte.MAX_VALUE) + " (length: " + (r114 + 2) + ")");
    L24:
        if (r114 < 0) goto L72;
        if (r105 != (-31)) goto L28;
        byte[] r108 = new byte[r114];
        r110.readFully(r108);
        int r115 = r107 + r114;
        byte[] r116 = f312483c0;
        if (r116 != null) goto L50;
    L57:
        r103 = false;
    L59:
        if (r103 == false) goto L61;
        byte[] r109 = f312483c0;
        byte[] r117 = Arrays.copyOfRange(r108, r109.length, r114);
        this.f312509n = (r111 + r107) + r109.length;
        D(r117, r112);
        L(new b(r117));
    L61:
        r107 = r115;
    L62:
        r114 = 0;
    L63:
        if (r114 < 0) goto L70;
        if (r110.skipBytes(r114) != r114) goto L68;
        r101 = r107 + r114;
        goto L10
    L68:
        throw new IOException("Invalid JPEG segment");
    L70:
        throw new IOException("Invalid length");
    L50:
        if (r114 < r116.length) goto L57;
        int r118 = 0;
    L54:
        if (r118 >= r116.length) goto L59;
        if (r108[r118] != r116[r118]) goto L57;
        r118 = r118 + 1;
        goto L54
    L28:
        if (r105 == (-2)) goto L39;
        switch(r105) {
            case -64: goto L35;
            case -63: goto L35;
            case -62: goto L35;
            case -61: goto L35;
            default: goto L30;
        };
    L30:
        switch(r105) {
            case -59: goto L35;
            case -58: goto L35;
            case -57: goto L35;
            default: goto L31;
        };
    L31:
        switch(r105) {
            case -55: goto L35;
            case -54: goto L35;
            case -53: goto L35;
            default: goto L32;
        };
    L32:
        switch(r105) {
            case -51: goto L35;
            case -50: goto L35;
            case -49: goto L35;
            default: goto L63;
        };
    L35:
        if (r110.skipBytes(1) != 1) goto L38;
        this.f312500e[r112].put(ExifInterface.TAG_IMAGE_LENGTH, d.b(r110.readUnsignedShort(), this.f312502g));
        this.f312500e[r112].put(ExifInterface.TAG_IMAGE_WIDTH, d.b(r110.readUnsignedShort(), this.f312502g));
        r114 = r114 - 5;
        goto L63
    L38:
        throw new IOException("Invalid SOFx");
    L39:
        byte[] r119 = new byte[r114];
        if (r110.read(r119) != r114) goto L45;
        if (j(ExifInterface.TAG_USER_COMMENT) != null) goto L62;
        this.f312500e[1].put(ExifInterface.TAG_USER_COMMENT, d.a(new String(r119, f312482b0)));
        goto L62
    L45:
        throw new IOException("Invalid exif");
    L72:
        throw new IOException("Invalid length");
    L73:
        r110.f312518b = this.f312502g;
        return;
    L76:
        throw new IOException("Invalid marker:" + Integer.toHexString(r102 & UByte.MAX_VALUE));
    L78:
        throw new IOException("Invalid marker: " + Integer.toHexString(r100 & UByte.MAX_VALUE));
    L80:
        throw new IOException("Invalid marker: " + Integer.toHexString(r100 & UByte.MAX_VALUE));
    }

    public static void i(b r100, c r101, byte[] r102, byte[] r103) throws IOException {
    L2:
        byte[] r104 = new byte[4];
        if (r100.read(r104) != 4) goto L4;
        int r105 = r100.readInt();
        r101.write(r104);
        r101.b(r105);
        if ((r105 % 2) != 1) goto L13;
        r105 = r105 + 1;
    L13:
        h(r100, r101, r105);
        if (Arrays.equals(r104, r102) == true) goto L18;
        if (r103 == null) goto L2;
        if (Arrays.equals(r104, r103) == false) goto L2;
        return;
    L18:
        return;
    L4:
        StringBuilder r106 = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
        Charset r107 = f312482b0;
        r106.append(new String(r102, r107));
        if (r103 != null) goto L7;
        String r108 = "";
    L8:
        r106.append(r108);
        throw new IOException(r106.toString());
    L7:
        r108 = " or ".concat(new String(r103, r107));
        goto L8
    }
}
