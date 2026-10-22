package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f275860a;

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f275861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275864e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f275865f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f275866g;

        public final int f() throws IOException {
            int r100 = this.f275864e;
            int r101 = this.f275862c;
            if (r101 == r100) goto L34;
            byte[] r102 = this.f275861b;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.f275864e = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L34;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L15;
            int r107 = r106 ^ com.alipay.sdk.m.n.a.f25611g;
        L48:
            this.f275864e = r105;
            return r107;
        L15:
            int r108 = r105 + 1;
            int r109 = r106 ^ (r102[r105] << 14);
            if (r109 < 0) goto L19;
            r107 = r109 ^ 16256;
        L18:
            r105 = r108;
            goto L48
        L19:
            r105 = r108 + 1;
            int r110 = r109 ^ (r102[r108] << 21);
            if (r110 >= 0) goto L22;
            r107 = r110 ^ (-2080896);
            goto L48
        L22:
            r108 = r105 + 1;
            byte r111 = r102[r105];
            r107 = (r110 ^ (r111 << 28)) ^ 266354560;
            if (r111 >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L48;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L48;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L48;
        L34:
            long r112 = 0;
            int r113 = 0;
        L36:
            if (r113 >= 64) goto L47;
            int r114 = this.f275864e;
            if (r114 == this.f275862c) goto L45;
            byte[] r115 = this.f275861b;
            this.f275864e = r114 + 1;
            byte r116 = r115[r114];
            r112 = r112 | (((long) (r116 & ByteCompanionObject.MAX_VALUE)) << r113);
            if ((r116 & ByteCompanionObject.MIN_VALUE) == 0) goto L42;
            r113 = r113 + 7;
            goto L36
        L42:
            return (int) r112;
        L45:
            throw InvalidProtocolBufferException.truncatedMessage();
        L47:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final ByteString b() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            int r101 = this.f275862c;
            int r102 = this.f275864e;
            if (r100 > (r101 - r102)) goto L8;
            ByteString r103 = ByteString.copyFrom(this.f275861b, r102, r100);
            this.f275864e += r100;
            return r103;
        L8:
            if (r100 == 0) goto L10;
            if (r100 <= 0) goto L15;
            int r104 = this.f275862c;
            int r105 = this.f275864e;
            if (r100 > (r104 - r105)) goto L15;
            int r106 = r100 + r105;
            this.f275864e = r106;
            byte[] r107 = Arrays.copyOfRange(this.f275861b, r105, r106);
        L19:
            return ByteString.wrap(r107);
        L15:
            if (r100 > 0) goto L23;
            if (r100 != 0) goto L21;
            r107 = e.f275886b;
            goto L19
        L21:
            throw InvalidProtocolBufferException.negativeSize();
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            return ByteString.EMPTY;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String c() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            int r101 = this.f275862c;
            int r102 = this.f275864e;
            if (r100 > (r101 - r102)) goto L8;
            String r103 = new String(this.f275861b, r102, r100, e.f275885a);
            this.f275864e += r100;
            return r103;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String d() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            int r101 = this.f275862c;
            int r102 = this.f275864e;
            if (r100 > (r101 - r102)) goto L8;
            String r103 = Utf8.f275849a.a(this.f275861b, r102, r100);
            this.f275864e += r100;
            return r103;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void e(int r100) throws InvalidProtocolBufferException {
            if (r100 < 0) goto L17;
            int r101 = this.f275864e;
            int r102 = this.f275865f;
            int r103 = r100 + (r101 - r102);
            if (r103 < 0) goto L15;
            if (r103 > this.f275866g) goto L13;
            this.f275866g = r103;
            int r104 = this.f275862c + this.f275863d;
            this.f275862c = r104;
            int r105 = r104 - r102;
            if (r105 <= r103) goto L10;
            int r106 = r105 - r103;
            this.f275863d = r106;
            this.f275862c = r104 - r106;
            return;
        L10:
            this.f275863d = 0;
            return;
        L13:
            throw InvalidProtocolBufferException.truncatedMessage();
        L15:
            throw InvalidProtocolBufferException.parseFailure();
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        }

        public a(byte[] r100, int r101, int r102, boolean r103) {
            this.f275866g = Integer.MAX_VALUE;
            this.f275861b = r100;
            this.f275862c = r102 + r101;
            this.f275864e = r101;
            this.f275865f = r101;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterable<ByteBuffer> f275867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator<ByteBuffer> f275868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ByteBuffer f275869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f275870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f275871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f275872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f275873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f275874i;

        public final int f() throws IOException {
            long r100 = this.f275872g;
            if (this.f275874i == r100) goto L34;
            long r101 = r100 + 1;
            byte r102 = i.f(r100);
            if (r102 < 0) goto L10;
            this.f275872g++;
            return r102;
        L10:
            if ((this.f275874i - this.f275872g) < 10) goto L34;
            long r103 = r101 + 1;
            int r104 = r102 ^ (i.f(r101) << 7);
            if (r104 >= 0) goto L15;
            int r105 = r104 ^ com.alipay.sdk.m.n.a.f25611g;
        L51:
            this.f275872g = r103;
            return r105;
        L15:
            long r106 = r103 + 1;
            int r107 = r104 ^ (i.f(r103) << 14);
            if (r107 < 0) goto L19;
            r105 = r107 ^ 16256;
        L18:
            r103 = r106;
            goto L51
        L19:
            r103 = r106 + 1;
            int r108 = r107 ^ (i.f(r106) << 21);
            if (r108 >= 0) goto L22;
            r105 = r108 ^ (-2080896);
            goto L51
        L22:
            r106 = r103 + 1;
            byte r109 = i.f(r103);
            r105 = (r108 ^ (r109 << 28)) ^ 266354560;
            if (r109 >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L51;
            r106 = r103 + 1;
            if (i.f(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L51;
            r106 = r103 + 1;
            if (i.f(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L51;
        L34:
            int r110 = 0;
            long r111 = 0;
        L36:
            if (r110 >= 64) goto L50;
            if ((this.f275874i - this.f275872g) == 0) goto L40;
        L44:
            long r112 = this.f275872g;
            this.f275872g = r112 + 1;
            byte r113 = i.f(r112);
            r111 = r111 | (((long) (r113 & ByteCompanionObject.MAX_VALUE)) << r110);
            if ((r113 & ByteCompanionObject.MIN_VALUE) == 0) goto L47;
            r110 = r110 + 7;
            goto L36
        L47:
            return (int) r111;
        L40:
            if (this.f275868c.hasNext() == false) goto L43;
            h();
            goto L44
        L43:
            throw InvalidProtocolBufferException.truncatedMessage();
        L50:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int g() {
            return (int) ((((long) (this.f275870e - this.f275871f)) - this.f275872g) + this.f275873h);
        }

        public final void h() {
            ByteBuffer r100 = this.f275868c.next();
            this.f275869d = r100;
            this.f275871f += (int) (this.f275872g - this.f275873h);
            long r101 = r100.position();
            this.f275872g = r101;
            this.f275873h = r101;
            this.f275874i = this.f275869d.limit();
            long r102 = i.f275898b.h(this.f275869d, i.f275902f);
            this.f275872g += r102;
            this.f275873h += r102;
            this.f275874i += r102;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final ByteString b() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            long r101 = r100;
            long r102 = this.f275874i;
            long r103 = this.f275872g;
            if (r101 > (r102 - r103)) goto L8;
            byte[] r104 = new byte[r100];
            i.f275898b.c(r103, r104, 0, r101);
            this.f275872g += r101;
            return ByteString.wrap(r104);
        L8:
            if (r100 > 0) goto L10;
        L13:
            if (r100 == 0) goto L15;
            if (r100 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L15:
            return ByteString.EMPTY;
        L10:
            if (r100 > g()) goto L13;
            byte[] r105 = new byte[r100];
            e(r105, r100);
            return ByteString.wrap(r105);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String c() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            long r101 = r100;
            long r102 = this.f275874i;
            long r103 = this.f275872g;
            if (r101 > (r102 - r103)) goto L8;
            byte[] r104 = new byte[r100];
            i.f275898b.c(r103, r104, 0, r101);
            String r105 = new String(r104, e.f275885a);
            this.f275872g += r101;
            return r105;
        L8:
            if (r100 > 0) goto L10;
        L13:
            if (r100 != 0) goto L16;
            return "";
        L16:
            if (r100 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r100 > g()) goto L13;
            byte[] r106 = new byte[r100];
            e(r106, r100);
            return new String(r106, e.f275885a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String d() throws IOException {
            int r100 = f();
            if (r100 <= 0) goto L8;
            long r101 = r100;
            long r102 = this.f275874i;
            long r103 = this.f275872g;
            if (r101 > (r102 - r103)) goto L8;
            String r104 = Utf8.c(this.f275869d, (int) (r103 - this.f275873h), r100);
            this.f275872g += r101;
            return r104;
        L8:
            if (r100 >= 0) goto L10;
        L13:
            if (r100 != 0) goto L16;
            return "";
        L16:
            if (r100 > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r100 > g()) goto L13;
            byte[] r105 = new byte[r100];
            e(r105, r100);
            return Utf8.f275849a.a(r105, 0, r100);
        }

        public b(Iterable r100, int r101) {
            this.f275870e = r101;
            this.f275867b = r100;
            this.f275868c = r100.iterator();
            this.f275871f = 0;
            if (r101 != 0) goto L5;
            this.f275869d = e.f275887c;
            this.f275872g = 0;
            this.f275873h = 0;
            this.f275874i = 0;
            return;
        L5:
            h();
        }

        public final void e(byte[] r110, int r111) throws IOException {
            if (r111 >= 0) goto L4;
        L16:
            if (r111 > 0) goto L22;
            if (r111 != 0) goto L20;
            return;
        L20:
            throw InvalidProtocolBufferException.negativeSize();
        L22:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r111 > g()) goto L16;
            int r100 = r111;
        L6:
            if (r100 <= 0) goto L15;
            if ((this.f275874i - this.f275872g) != 0) goto L14;
            if (this.f275868c.hasNext() == false) goto L13;
            h();
            goto L14
        L13:
            throw InvalidProtocolBufferException.truncatedMessage();
        L14:
            int r101 = Math.min(r100, (int) (this.f275874i - this.f275872g));
            long r112 = r101;
            i.f275898b.c(this.f275872g, r110, (r111 - r100) + 0, r112);
            r100 = r100 - r101;
            this.f275872g += r112;
            goto L6
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f275875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f275876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275878e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f275879f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f275880g;

        public final int h() throws IOException {
            int r100 = this.f275879f;
            int r101 = this.f275877d;
            if (r101 == r100) goto L34;
            byte[] r102 = this.f275876c;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.f275879f = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L34;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L15;
            int r107 = r106 ^ com.alipay.sdk.m.n.a.f25611g;
        L47:
            this.f275879f = r105;
            return r107;
        L15:
            int r108 = r105 + 1;
            int r109 = r106 ^ (r102[r105] << 14);
            if (r109 < 0) goto L19;
            r107 = r109 ^ 16256;
        L18:
            r105 = r108;
            goto L47
        L19:
            r105 = r108 + 1;
            int r110 = r109 ^ (r102[r108] << 21);
            if (r110 >= 0) goto L22;
            r107 = r110 ^ (-2080896);
            goto L47
        L22:
            r108 = r105 + 1;
            byte r111 = r102[r105];
            r107 = (r110 ^ (r111 << 28)) ^ 266354560;
            if (r111 >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L47;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L47;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L47;
        L34:
            long r112 = 0;
            int r113 = 0;
        L36:
            if (r113 >= 64) goto L46;
            if (this.f275879f != this.f275877d) goto L40;
            j(1);
        L40:
            byte[] r114 = this.f275876c;
            int r115 = this.f275879f;
            this.f275879f = r115 + 1;
            byte r116 = r114[r115];
            r112 = r112 | (((long) (r116 & ByteCompanionObject.MAX_VALUE)) << r113);
            if ((r116 & ByteCompanionObject.MIN_VALUE) == 0) goto L43;
            r113 = r113 + 7;
            goto L36
        L43:
            return (int) r112;
        L46:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void i() {
            int r100 = this.f275877d + this.f275878e;
            this.f275877d = r100;
            int r101 = this.f275880g + r100;
            if (r101 <= Integer.MAX_VALUE) goto L5;
            int r102 = r101 - Integer.MAX_VALUE;
            this.f275878e = r102;
            this.f275877d = r100 - r102;
            return;
        L5:
            this.f275878e = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final ByteString b() throws IOException {
            int r100 = h();
            int r101 = this.f275877d;
            int r102 = this.f275879f;
            if (r100 > (r101 - r102)) goto L7;
            if (r100 <= 0) goto L7;
            ByteString r103 = ByteString.copyFrom(this.f275876c, r102, r100);
            this.f275879f += r100;
            return r103;
        L7:
            if (r100 == 0) goto L9;
            byte[] r104 = f(r100);
            if (r104 != null) goto L20;
            int r105 = this.f275879f;
            int r106 = this.f275877d;
            int r107 = r106 - r105;
            this.f275880g += r106;
            this.f275879f = 0;
            this.f275877d = 0;
            List<byte[]> r108 = g(r100 - r107);
            byte[] r109 = new byte[r100];
            System.arraycopy(this.f275876c, r105, r109, 0, r107);
            Iterator r110 = ((ArrayList) r108).iterator();
        L15:
            if (r110.hasNext() == false) goto L18;
            byte[] r111 = (byte[]) r110.next();
            System.arraycopy(r111, 0, r109, r107, r111.length);
            r107 = r107 + r111.length;
            goto L15
        L18:
            return ByteString.wrap(r109);
        L20:
            return ByteString.copyFrom(r104);
        L9:
            return ByteString.EMPTY;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String c() throws IOException {
            int r100 = h();
            if (r100 <= 0) goto L8;
            int r101 = this.f275877d;
            int r102 = this.f275879f;
            if (r100 > (r101 - r102)) goto L8;
            String r103 = new String(this.f275876c, r102, r100, e.f275885a);
            this.f275879f += r100;
            return r103;
        L8:
            if (r100 != 0) goto L12;
            return "";
        L12:
            if (r100 > this.f275877d) goto L16;
            j(r100);
            String r104 = new String(this.f275876c, this.f275879f, r100, e.f275885a);
            this.f275879f += r100;
            return r104;
        L16:
            return new String(e(r100), e.f275885a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String d() throws IOException {
            int r100 = h();
            int r101 = this.f275879f;
            int r102 = this.f275877d;
            if (r100 > (r102 - r101)) goto L6;
            if (r100 <= 0) goto L6;
            byte[] r103 = this.f275876c;
            this.f275879f = r101 + r100;
        L14:
            return Utf8.f275849a.a(r103, r101, r100);
        L6:
            if (r100 != 0) goto L9;
            return "";
        L9:
            r101 = 0;
            if (r100 > r102) goto L12;
            j(r100);
            r103 = this.f275876c;
            this.f275879f = r100 + 0;
            goto L14
        L12:
            r103 = e(r100);
            goto L14
        }

        public c(f r100) {
            Charset r101 = e.f275885a;
            this.f275875b = r100;
            this.f275876c = new byte[4096];
            this.f275877d = 0;
            this.f275879f = 0;
            this.f275880g = 0;
        }

        public final byte[] e(int r100) throws IOException {
            byte[] r101 = f(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            int r102 = this.f275879f;
            int r103 = this.f275877d;
            int r104 = r103 - r102;
            this.f275880g += r103;
            this.f275879f = 0;
            this.f275877d = 0;
            List<byte[]> r105 = g(r100 - r104);
            byte[] r106 = new byte[r100];
            System.arraycopy(this.f275876c, r102, r106, 0, r104);
            Iterator r107 = ((ArrayList) r105).iterator();
        L7:
            if (r107.hasNext() == false) goto L9;
            byte[] r108 = (byte[]) r107.next();
            System.arraycopy(r108, 0, r106, r104, r108.length);
            r104 = r104 + r108.length;
            goto L7
        L9:
            return r106;
        }

        public final byte[] f(int r100) throws IOException {
            if (r100 == 0) goto L4;
            if (r100 < 0) goto L39;
            int r101 = this.f275880g;
            int r102 = this.f275879f;
            int r103 = (r101 + r102) + r100;
            if ((r103 - this.f275860a) > 0) goto L37;
            if (r103 > Integer.MAX_VALUE) goto L34;
            int r104 = this.f275877d - r102;
            int r105 = r100 - r104;
            if (r105 >= 4096) goto L40;
        L21:
            byte[] r106 = new byte[r100];
            System.arraycopy(this.f275876c, this.f275879f, r106, 0, r104);
            this.f275880g += this.f275877d;
            this.f275879f = 0;
            this.f275877d = 0;
        L22:
            if (r104 >= r100) goto L33;
            int r107 = this.f275875b.read(r106, r104, r100 - r104);     // Catch: InvalidProtocolBufferException -> L30
            if (r107 == (-1)) goto L29;
            this.f275880g += r107;
            r104 = r104 + r107;
            goto L22
        L29:
            throw InvalidProtocolBufferException.truncatedMessage();
        L30:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        L33:
            return r106;
        L40:
            if (r105 <= this.f275875b.available()) goto L21;
            return null;
        L18:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        L34:
            k((Integer.MAX_VALUE - r101) - r102);
            throw InvalidProtocolBufferException.truncatedMessage();
        L37:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L39:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return e.f275886b;
        }

        public final List<byte[]> g(int r100) throws IOException {
            ArrayList r101 = new ArrayList();
        L3:
            if (r100 <= 0) goto L12;
            int r102 = Math.min(r100, 4096);
            byte[] r103 = new byte[r102];
            int r104 = 0;
        L5:
            if (r104 >= r102) goto L11;
            int r105 = this.f275875b.read(r103, r104, r102 - r104);
            if (r105 == (-1)) goto L10;
            this.f275880g += r105;
            r104 = r104 + r105;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            r100 = r100 - r102;
            r101.add(r103);
            goto L3
        L12:
            return r101;
        }

        public final void j(int r100) throws IOException {
            if (l(r100) == false) goto L5;
            return;
        L5:
            if (r100 <= ((this.f275860a - this.f275880g) - this.f275879f)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void k(int r100) throws IOException {
            int r101 = this.f275877d;
            int r102 = this.f275879f;
            if (r100 > (r101 - r102)) goto L6;
            if (r100 < 0) goto L6;
            this.f275879f = r102 + r100;
            return;
        L6:
            if (r100 < 0) goto L41;
            int r103 = this.f275880g;
            int r104 = r103 + r102;
            if ((r104 + r100) > Integer.MAX_VALUE) goto L38;
            this.f275880g = r104;
            int r105 = r101 - r102;
            this.f275877d = 0;
            this.f275879f = 0;
        L10:
            if (r105 >= r100) goto L30;
        L27:
            th = move-exception;
            this.f275880g += r105;
            i();
            throw th;
        L13:
            long r106 = r100 - r105;
            long r107 = this.f275875b.skip(r106);     // Catch: InvalidProtocolBufferException -> L24 Throwable -> L27
        L16:
            if (r107 < 0) goto L23;
            if (r107 > r106) goto L23;
            if (r107 == 0) goto L30;
            r105 = r105 + ((int) r107);
        L23:
            throw new IllegalStateException(this.f275875b.getClass() + "#skip returned invalid result: " + r107 + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L27
        L24:
            e = move-exception;
            e.setThrownFromInputStream();     // Catch: Throwable -> L27
            throw e;     // Catch: Throwable -> L27
        L30:
            this.f275880g += r105;
            i();
            if (r105 >= r100) goto L51;
            int r108 = this.f275877d;
            int r109 = r108 - this.f275879f;
            this.f275879f = r108;
            j(1);
        L33:
            int r110 = r100 - r109;
            int r111 = this.f275877d;
            if (r110 <= r111) goto L36;
            r109 = r109 + r111;
            this.f275879f = r111;
            j(1);
            goto L33
        L36:
            this.f275879f = r110;
            return;
        L51:
            return;
        L38:
            k((Integer.MAX_VALUE - r103) - r102);
            throw InvalidProtocolBufferException.truncatedMessage();
        L41:
            throw InvalidProtocolBufferException.negativeSize();
        }

        public final boolean l(int r100) throws IOException {
            int r101 = this.f275879f;
            int r102 = r101 + r100;
            int r103 = this.f275877d;
            if (r102 <= r103) goto L34;
            int r104 = this.f275860a;
            int r105 = this.f275880g;
            if (r100 <= ((r104 - r105) - r101)) goto L8;
            return false;
        L8:
            if (((r105 + r101) + r100) <= Integer.MAX_VALUE) goto L10;
            return false;
        L10:
            if (r101 <= 0) goto L14;
            if (r103 <= r101) goto L13;
            byte[] r106 = this.f275876c;
            System.arraycopy(r106, r101, r106, 0, r103 - r101);
        L13:
            this.f275880g += r101;
            this.f275877d -= r101;
            this.f275879f = 0;
        L14:
            InputStream r107 = this.f275875b;
            byte[] r108 = this.f275876c;
            int r109 = this.f275877d;
            int r110 = r107.read(r108, r109, Math.min(r108.length - r109, (this.f275860a - this.f275880g) - r109));     // Catch: InvalidProtocolBufferException -> L30
            if (r110 == 0) goto L29;
            if (r110 < (-1)) goto L29;
            if (r110 > this.f275876c.length) goto L29;
            if (r110 <= 0) goto L27;
            this.f275877d += r110;
            i();
            if (this.f275877d < r100) goto L26;
            return true;
        L26:
            return l(r100);
        L27:
            return false;
        L29:
            throw new IllegalStateException(this.f275875b.getClass() + "#read(byte[]) returned invalid result: " + r110 + "\nThe InputStream implementation is buggy.");
        L30:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        L34:
            throw new IllegalStateException("refillBuffer() called when " + r100 + " bytes were already available in buffer");
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.d$d, reason: collision with other inner class name */
    public static final class C3862d extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f275881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f275882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f275883d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f275884e;

        public final int e() throws IOException {
            long r100 = this.f275884e;
            if (this.f275883d == r100) goto L34;
            long r101 = r100 + 1;
            byte r102 = i.f(r100);
            if (r102 < 0) goto L10;
            this.f275884e = r101;
            return r102;
        L10:
            if ((this.f275883d - r101) < 9) goto L34;
            long r103 = r101 + 1;
            int r104 = r102 ^ (i.f(r101) << 7);
            if (r104 >= 0) goto L15;
            int r105 = r104 ^ com.alipay.sdk.m.n.a.f25611g;
        L48:
            this.f275884e = r103;
            return r105;
        L15:
            long r106 = r103 + 1;
            int r107 = r104 ^ (i.f(r103) << 14);
            if (r107 < 0) goto L19;
            r105 = r107 ^ 16256;
        L18:
            r103 = r106;
            goto L48
        L19:
            r103 = r106 + 1;
            int r108 = r107 ^ (i.f(r106) << 21);
            if (r108 >= 0) goto L22;
            r105 = r108 ^ (-2080896);
            goto L48
        L22:
            r106 = r103 + 1;
            byte r109 = i.f(r103);
            r105 = (r108 ^ (r109 << 28)) ^ 266354560;
            if (r109 >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L48;
            r106 = r103 + 1;
            if (i.f(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L48;
            r106 = r103 + 1;
            if (i.f(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (i.f(r106) >= 0) goto L48;
        L34:
            long r110 = 0;
            int r111 = 0;
        L36:
            if (r111 >= 64) goto L47;
            long r112 = this.f275884e;
            if (r112 == this.f275883d) goto L45;
            this.f275884e = r112 + 1;
            byte r113 = i.f(r112);
            r110 = r110 | (((long) (r113 & ByteCompanionObject.MAX_VALUE)) << r111);
            if ((r113 & ByteCompanionObject.MIN_VALUE) == 0) goto L42;
            r111 = r111 + 7;
            goto L36
        L42:
            return (int) r110;
        L45:
            throw InvalidProtocolBufferException.truncatedMessage();
        L47:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final ByteString b() throws IOException {
            int r100 = e();
            if (r100 <= 0) goto L8;
            long r101 = this.f275883d;
            long r102 = this.f275884e;
            if (r100 > ((int) (r101 - r102))) goto L8;
            byte[] r103 = new byte[r100];
            long r110 = r100;
            i.f275898b.c(r102, r103, 0, r110);
            this.f275884e += r110;
            return ByteString.wrap(r103);
        L8:
            if (r100 == 0) goto L10;
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            return ByteString.EMPTY;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String c() throws IOException {
            int r100 = e();
            if (r100 <= 0) goto L8;
            long r101 = this.f275883d;
            long r102 = this.f275884e;
            if (r100 > ((int) (r101 - r102))) goto L8;
            byte[] r103 = new byte[r100];
            long r110 = r100;
            i.f275898b.c(r102, r103, 0, r110);
            String r104 = new String(r103, e.f275885a);
            this.f275884e += r110;
            return r104;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d
        public final String d() throws IOException {
            int r100 = e();
            if (r100 <= 0) goto L8;
            long r101 = this.f275883d;
            long r102 = this.f275884e;
            if (r100 > ((int) (r101 - r102))) goto L8;
            String r103 = Utf8.c(this.f275881b, (int) (r102 - this.f275882c), r100);
            this.f275884e += (long) r100;
            return r103;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public C3862d(ByteBuffer r100) {
            this.f275881b = r100;
            long r101 = i.f275898b.h(r100, i.f275902f);
            this.f275882c = r101;
            this.f275883d = ((long) r100.limit()) + r101;
            this.f275884e = r101 + ((long) r100.position());
        }
    }

    public abstract ByteString b() throws IOException;

    public abstract String c() throws IOException;

    public abstract String d() throws IOException;

    public d() {
        this.f275860a = Integer.MAX_VALUE;
    }

    public static a a(byte[] r100, int r101, int r102, boolean r103) {
        a r104 = new a(r100, r101, r102, r103);
        r104.e(r102);     // Catch: InvalidProtocolBufferException -> L5
        return r104;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
