package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public abstract class n implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> f492037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.ktor.utils.io.core.internal.a f492038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f492039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f492040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f492042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f492043g;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public abstract void g(ByteBuffer r100);

    public n() {
        io.ktor.utils.io.core.internal.a r100 = io.ktor.utils.io.core.internal.a.f492030m;
        this(r100, h.c(r100), c.f492026a);
    }

    public final io.ktor.utils.io.core.internal.a d() {
        if (this.f492043g == false) goto L5;
        return null;
    L5:
        io.ktor.utils.io.core.internal.a r100 = f();
        boolean r101 = true;
        if (r100 != null) goto L9;
        this.f492043g = true;
        return null;
    L9:
        io.ktor.utils.io.core.internal.a r102 = h.a(this.f492038b);
        if (r102 != io.ktor.utils.io.core.internal.a.f492030m) goto L22;
        u(r100);
        long r103 = 0;
        if (this.f492042f == 0) goto L15;
        r101 = false;
    L15:
        if (r101 == false) goto L21;
        io.ktor.utils.io.core.internal.a r104 = r100.i();
        if (r104 == null) goto L19;
        r103 = h.c(r104);
    L19:
        t(r103);
    L23:
        return r100;
    L21:
        throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
    L22:
        r102.m(r100);
        t(this.f492042f + h.c(r100));
        goto L23
    }

    public io.ktor.utils.io.core.internal.a f() {
        io.ktor.utils.io.core.internal.a r100 = this.f492037a.Q5();
        r100.e();     // Catch: Throwable -> L12
        g(r100.f492020a);     // Catch: Throwable -> L12
        boolean r101 = true;
        this.f492043g = true;     // Catch: Throwable -> L12
        if (r100.f492022c > r100.f492021b) goto L7;
        r101 = false;
    L7:
        if (r101 == true) goto L10;
        r100.k(this.f492037a);     // Catch: Throwable -> L12
        return null;
    L10:
        r100.a(0);     // Catch: Throwable -> L12
        return r100;
    L12:
        th = move-exception;
        r100.k(this.f492037a);
        throw th;
    }

    public final boolean i() {
        if ((this.f492041e - this.f492040d) == 0) goto L5;
    L11:
        return false;
    L5:
        if (this.f492042f != 0) goto L11;
        if (this.f492043g == false) goto L9;
    L10:
        return true;
    L9:
        if (d() != null) goto L11;
        goto L10
    }

    public final io.ktor.utils.io.core.internal.a j() {
        io.ktor.utils.io.core.internal.a r100 = this.f492038b;
        int r101 = this.f492040d;
        if (r101 >= 0) goto L5;
    L10:
        int r102 = r100.f492021b;
        d.b(r101 - r102, r100.f492022c - r102);
        throw null;
    L5:
        if (r101 > r100.f492022c) goto L10;
        if (r100.f492021b == r101) goto L9;
        r100.f492021b = r101;
    L9:
        return r100;
    }

    public final long k() {
        return ((long) (this.f492041e - this.f492040d)) + this.f492042f;
    }

    public final byte readByte() {
        int r100 = this.f492040d;
        int r101 = r100 + 1;
        int r102 = this.f492041e;
        if (r101 >= r102) goto L7;
        this.f492040d = r101;
        return this.f492039c.get(r100);
    L7:
        if (r100 >= r102) goto L18;
        byte r103 = this.f492039c.get(r100);
        this.f492040d = r100;
        io.ktor.utils.io.core.internal.a r104 = this.f492038b;
        if (r100 >= 0) goto L11;
    L16:
        int r105 = r104.f492021b;
        d.b(r100 - r105, r104.f492022c - r105);
        throw null;
    L11:
        if (r100 > r104.f492022c) goto L16;
        if (r104.f492021b == r100) goto L15;
        r104.f492021b = r100;
    L15:
        e(r104);
        return r103;
    L18:
        io.ktor.utils.io.core.internal.a r106 = l();
        if (r106 == null) goto L26;
        int r107 = r106.f492021b;
        if (r107 == r106.f492022c) goto L25;
        r106.f492021b = r107 + 1;
        byte r108 = r106.f492020a.get(r107);
        io.ktor.utils.io.core.internal.c.a(this, r106);
        return r108;
    L25:
        throw new EOFException("No readable bytes available.");
    L26:
        v.a(1);
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q();
        if (this.f492043g == true) goto L5;
        this.f492043g = true;
    L5:
        a();
    }

    public final io.ktor.utils.io.core.internal.a l() {
        io.ktor.utils.io.core.internal.a r100 = j();
        if ((this.f492041e - this.f492040d) < 1) goto L6;
        return r100;
    L6:
        return n(1, r100);
    }

    public final void q() {
        io.ktor.utils.io.core.internal.a r100 = j();
        AtomicReferenceFieldUpdater r101 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.internal.a r102 = io.ktor.utils.io.core.internal.a.f492030m;
        if (r100 == r102) goto L6;
        u(r102);
        t(0);
        h.b(r100, this.f492037a);
        return;
    }

    public static String p(n r210) {
        if (r210.i() == true) goto L11;
        long r100 = r210.k();
        if (r100 > 0) goto L8;
    L103:
        StringBuilder r101 = new StringBuilder(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(0, 16), Integer.MAX_VALUE));
        if (r210.i() == true) goto L259;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        io.ktor.utils.io.core.internal.a r102 = r210.m(1);
        if (r102 != null) goto L109;
        int r103 = 0;
        boolean r104 = false;
    L137:
        String r105 = " chars but had only ";
        String r106 = "Premature end of stream: expected at least ";
        if (r104 == false) goto L257;
        int r107 = 0 - r103;
        int r108 = Integer.MAX_VALUE - r103;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        io.ktor.utils.io.core.internal.a r110 = r210.m(1);
        if (r110 != null) goto L142;
        String r111 = " chars but had only ";
        String r211 = "Premature end of stream: expected at least ";
        int r109 = 0;
    L244:
        if (r109 >= r107) goto L259;
        throw new MalformedUTF8InputException(r211 + r107 + r111 + r109);
    L142:
        io.ktor.utils.io.core.internal.a r112 = r110;
        int r113 = 1;
        int r114 = 0;
    L270:
        int r115 = r112.f492022c;     // Catch: Throwable -> L250
        int r116 = r112.f492021b;     // Catch: Throwable -> L250
        int r117 = r115 - r116;
        if (r117 >= r113) goto L279;
        r111 = r105;
        r211 = r106;
    L226:
        if (r117 == 0) goto L285;
        if (r117 < r113) goto L236;
        if ((r112.f492025f - r112.f492024e) < 8) goto L236;
        io.ktor.utils.io.core.internal.a r118 = r112;
    L237:
        if (r118 == null) goto L238;
        if (r113 <= 0) goto L240;
        r112 = r118;
        r105 = r111;
        r106 = r211;
        goto L270
    L240:
        r112 = r118;
        boolean r119 = true;
    L241:
        if (r119 == false) goto L243;
        io.ktor.utils.io.core.internal.c.a(r210, r112);
    L243:
        r109 = r114;
        goto L244
    L238:
        r119 = false;
    L236:
        io.ktor.utils.io.core.internal.c.a(r210, r112);     // Catch: Throwable -> L228
        Intrinsics.checkNotNullParameter(r210, "<this>");     // Catch: Throwable -> L228
        r118 = r210.m(r113);     // Catch: Throwable -> L228
        goto L237
    L285:
        r118 = io.ktor.utils.io.core.internal.c.b(r210, r112);     // Catch: Throwable -> L228
    L228:
        th = th;
        boolean r120 = false;
    L253:
        if (r120 == false) goto L255;
        io.ktor.utils.io.core.internal.c.a(r210, r112);
    L255:
        throw th;
    L279:
        ByteBuffer r121 = r112.f492020a;     // Catch: Throwable -> L220
        int r122 = r114;
        int r123 = r116;
        int r124 = 0;
        int r125 = 0;
        int r126 = 0;
    L147:
        if (r123 >= r115) goto L212;
        r111 = r105;
        int r127 = r121.get(r123) & UByte.MAX_VALUE;     // Catch: Throwable -> L220
        ByteBuffer r128 = r121;
        int r129 = -1;
        if ((r127 & 128) != 0) goto L160;
        if (r124 != 0) goto L159;
        char r130 = (char) r127;     // Catch: Throwable -> L220
        if (r122 != r108) goto L154;
        boolean r131 = false;
    L155:
        if (r131 == false) goto L156;
        r211 = r106;
    L171:
        int r132 = r125;
    L283:
        r123 = r123 + 1;     // Catch: Throwable -> L209
        r125 = r132;
        r105 = r111;
        r121 = r128;
        r106 = r211;
    L209:
        th = move-exception;
        throw th;     // Catch: Throwable -> L223
    L156:
        r112.c(r123 - r116);     // Catch: Throwable -> L220
        r211 = r106;
    L214:
        if (r129 != 0) goto L216;
        r129 = 1;
    L281:
        r117 = r112.f492022c - r112.f492021b;     // Catch: Throwable -> L223
        r114 = r122;
        r113 = r129;
    L223:
        th = th;
    L252:
        r120 = true;
        goto L253
    L216:
        if (r129 > 0) goto L281;
        r129 = 0;
        goto L281
    L154:
        r101.append(r130);     // Catch: Throwable -> L220
        r122 = r122 + 1;     // Catch: Throwable -> L220
        r131 = true;
        goto L155
    L159:
        throw new MalformedUTF8InputException("Expected " + r124 + " more character bytes");     // Catch: Throwable -> L220
    L160:
        if (r124 != 0) goto L172;
        r125 = r127;
        r211 = r106;
        int r133 = 1;
        int r134 = 128;
    L163:
        if (r133 >= 7) goto L167;
        if ((r125 & r134) == 0) goto L167;
        r125 = r125 & (~r134);     // Catch: Throwable -> L220
        r134 = r134 >> 1;     // Catch: Throwable -> L220
        r124 = r124 + 1;     // Catch: Throwable -> L220
        r133 = r133 + 1;     // Catch: Throwable -> L220
    L167:
        int r135 = r124 - 1;     // Catch: Throwable -> L220
        if (r124 > (r115 - r123)) goto L169;
        r126 = r124;
        r124 = r135;
        goto L171
    L169:
        r112.c(r123 - r116);     // Catch: Throwable -> L220
        r129 = r124;
        goto L214
    L172:
        r211 = r106;
        r132 = (r125 << 6) | (r127 & 127);     // Catch: Throwable -> L220
        r124 = r124 - 1;     // Catch: Throwable -> L220
        if (r124 != 0) goto L283;
        if ((r132 >>> 16) != 0) goto L177;
        boolean r136 = true;
    L178:
        if (r136 == false) goto L187;
        char r137 = (char) r132;     // Catch: Throwable -> L220
        if (r122 != r108) goto L182;
        boolean r138 = false;
    L183:
        if (r138 == false) goto L184;
    L204:
        r132 = 0;
        goto L283
    L184:
        r112.c(((r123 - r116) - r126) + 1);     // Catch: Throwable -> L220
        goto L214
    L182:
        r101.append(r137);     // Catch: Throwable -> L220
        r122 = r122 + 1;     // Catch: Throwable -> L220
        r138 = true;
        goto L183
    L187:
        if (r132 > 1114111) goto L189;
        boolean r139 = true;
    L190:
        if (r139 == false) goto L207;
        char r140 = (char) ((r132 >>> 10) + 55232);     // Catch: Throwable -> L220
        if (r122 != r108) goto L194;
        int r141 = r122;
        boolean r142 = false;
    L195:
        if (r142 == false) goto L205;
        char r143 = (char) ((r132 & 1023) + 56320);     // Catch: Throwable -> L220
        if (r141 != r108) goto L199;
        boolean r144 = false;
    L201:
        if (r144 == false) goto L205;
        r122 = r141;
        goto L204
    L199:
        r101.append(r143);     // Catch: Throwable -> L220
        r141 = r141 + 1;
        r144 = true;
    L205:
        r122 = r141;
        r112.c(((r123 - r116) - r126) + 1);     // Catch: Throwable -> L209
        goto L214
    L194:
        r101.append(r140);     // Catch: Throwable -> L220
        r141 = r122 + 1;     // Catch: Throwable -> L220
        r142 = true;
        goto L195
    L207:
        UTF8Kt.c(r132);     // Catch: Throwable -> L209
        throw null;     // Catch: Throwable -> L209
    L189:
        r139 = false;
        goto L190
    L177:
        r136 = false;
        goto L178
    L212:
        r111 = r105;
        r211 = r106;
        r112.c(r117);     // Catch: Throwable -> L209
        r129 = 0;
    L220:
        th = move-exception;
        throw th;     // Catch: Throwable -> L223
    L250:
        th = th;
        goto L252
    L257:
        if (r103 >= 0) goto L259;
        throw new MalformedUTF8InputException("Premature end of stream: expected at least 0 chars but had only " + r103);
    L109:
        io.ktor.utils.io.core.internal.a r145 = r102;
        r103 = 0;
        r104 = false;
    L277:
        ByteBuffer r146 = r145.f492020a;     // Catch: Throwable -> L265
        int r147 = r145.f492021b;     // Catch: Throwable -> L265
        int r148 = r145.f492022c;     // Catch: Throwable -> L265
        int r149 = r147;
    L111:
        if (r149 >= r148) goto L122;
        int r150 = r146.get(r149) & UByte.MAX_VALUE;     // Catch: Throwable -> L265
        if ((r150 & 128) == 128) goto L121;
        char r151 = (char) r150;     // Catch: Throwable -> L265
        if (r103 != Integer.MAX_VALUE) goto L117;
        boolean r152 = false;
    L118:
        if (r152 == false) goto L121;
        r149 = r149 + 1;     // Catch: Throwable -> L265
        goto L111
    L117:
        r101.append(r151);     // Catch: Throwable -> L265
        r103 = r103 + 1;     // Catch: Throwable -> L265
        r152 = true;
    L121:
        r145.c(r149 - r147);     // Catch: Throwable -> L265
        boolean r153 = false;
    L124:
        if (r153 == false) goto L126;
        boolean r154 = true;
    L130:
        if (r154 == false) goto L131;
        io.ktor.utils.io.core.internal.a r155 = io.ktor.utils.io.core.internal.c.b(r210, r145);     // Catch: Throwable -> L263
        if (r155 == null) goto L134;
        r145 = r155;
        goto L277
    L134:
        boolean r156 = false;
    L135:
        if (r156 == false) goto L137;
        io.ktor.utils.io.core.internal.c.a(r210, r145);
    L263:
        th = th;
        boolean r157 = false;
    L267:
        if (r157 == false) goto L269;
        io.ktor.utils.io.core.internal.c.a(r210, r145);
    L269:
        throw th;
    L131:
        r156 = true;
        goto L135
    L126:
        if (r103 == Integer.MAX_VALUE) goto L129;
        r104 = true;
    L129:
        r154 = false;
        goto L130
    L122:
        r145.c(r148 - r147);     // Catch: Throwable -> L265
        r153 = true;
    L265:
        th = th;
        r157 = true;
    L259:
        return r101.toString();
    L8:
        if (Integer.MAX_VALUE < r100) goto L103;
        int r158 = (int) r100;
        Charset r159 = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r159, "charset");
        CharsetDecoder r160 = r159.newDecoder();
        CharBuffer r161 = ksc.a.f505998a;
        Intrinsics.checkNotNullParameter(r160, "<this>");
        Intrinsics.checkNotNullParameter(r210, "input");
        if (r158 == 0) goto L11;
        if ((r210.f492041e - r210.f492040d) >= r158) goto L15;
        CharBuffer r162 = CharBuffer.allocate(r158);
        Intrinsics.checkNotNullParameter(r210, "<this>");
        io.ktor.utils.io.core.internal.a r163 = r210.m(1);
        int r164 = r158;
        if (r163 != null) goto L26;
        boolean r165 = false;
    L82:
        if (r162.hasRemaining() == false) goto L89;
        if (r165 == true) goto L89;
        CoderResult r166 = r160.decode(ksc.a.f505999b, r162, true);
        if (r166.isMalformed() == false) goto L87;
    L88:
        ksc.a.d(r166);
        goto L89
    L87:
        if (r166.isUnmappable() == true) goto L88;
    L89:
        if (r164 > 0) goto L95;
        if (r164 < 0) goto L93;
        r162.flip();
        return r162.toString();
    L93:
        throw new AssertionError("remainingInputBytes < 0");
    L95:
        throw new EOFException("Not enough bytes available: had only " + (r158 - r164) + " instead of " + r158);
    L26:
        int r167 = 1;
        boolean r168 = false;
        int r169 = 1;
    L274:
    L98:
        th = th;
        boolean r170 = true;
    L100:
        if (r170 == false) goto L102;
        io.ktor.utils.io.core.internal.c.a(r210, r163);
    L102:
        throw th;
    L28:
        int r171 = r163.f492022c - r163.f492021b;
        if (r171 >= r167) goto L287;
    L63:
        if (r171 == 0) goto L275;
        if (r171 >= r167) goto L69;
    L72:
        io.ktor.utils.io.core.internal.c.a(r210, r163);     // Catch: Throwable -> L65
        Intrinsics.checkNotNullParameter(r210, "<this>");     // Catch: Throwable -> L65
        io.ktor.utils.io.core.internal.a r172 = r210.m(r167);     // Catch: Throwable -> L65
    L73:
        if (r172 == null) goto L74;
        r163 = r172;
        if (r167 > 0) goto L274;
        boolean r173 = true;
    L78:
        if (r173 == false) goto L80;
        io.ktor.utils.io.core.internal.c.a(r210, r163);
    L80:
        r165 = r168;
        goto L82
    L74:
        r173 = false;
        goto L78
    L69:
        if ((r163.f492025f - r163.f492024e) < 8) goto L72;
        r172 = r163;
        goto L73
    L275:
        r172 = io.ktor.utils.io.core.internal.c.b(r210, r163);     // Catch: Throwable -> L65
    L65:
        th = th;
        r170 = false;
        goto L100
    L287:
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L98
    L31:
        if (r162.hasRemaining() == false) goto L59;
        if (r164 == 0) goto L59;
        ByteBuffer r174 = r163.f492020a;     // Catch: Throwable -> L61
        int r175 = r163.f492021b;     // Catch: Throwable -> L61
        int r176 = r163.f492022c - r175;     // Catch: Throwable -> L61
        ByteBuffer r177 = jsc.c.f500279b;     // Catch: Throwable -> L61
        ByteBuffer r178 = jsc.d.c(r174, r175, r176);     // Catch: Throwable -> L61
        Intrinsics.checkNotNullParameter(r178, "buffer");     // Catch: Throwable -> L61
        int r179 = r178.limit();     // Catch: Throwable -> L61
        int r180 = r178.position();     // Catch: Throwable -> L61
        if ((r179 - r180) < r164) goto L37;
        boolean r181 = true;
    L38:
        if (r181 == false) goto L40;
        r178.limit(r180 + r164);     // Catch: Throwable -> L61
    L40:
        CoderResult r182 = r160.decode(r178, r162, r181);     // Catch: Throwable -> L61
        if (r182.isMalformed() == false) goto L43;
    L44:
        ksc.a.d(r182);     // Catch: Throwable -> L61
    L46:
        if (r182.isUnderflow() == true) goto L48;
    L50:
        int r183 = 1;
    L51:
        r178.limit(r179);     // Catch: Throwable -> L61
        r164 = r164 - (r178.position() - r180);     // Catch: Throwable -> L61
        if (r178.limit() != r176) goto L54;
        boolean r184 = true;
    L55:
        if (r184 == false) goto L58;
        r163.c(r178.position());     // Catch: Throwable -> L61
        r168 = r181;
        r167 = r183;
        r169 = r167;
    L60:
        r171 = r163.f492022c - r163.f492021b;     // Catch: Throwable -> L98
        goto L63
    L58:
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());     // Catch: Throwable -> L61
    L54:
        r184 = false;
        goto L55
    L48:
        if (r178.hasRemaining() == false) goto L50;
        r183 = r169 + 1;     // Catch: Throwable -> L61
        goto L51
    L43:
        if (r182.isUnmappable() == false) goto L46;
    L37:
        r181 = false;
    L59:
        r167 = 0;
        goto L60
    L15:
        if (r210.f492039c.hasArray() == false) goto L17;
        ByteBuffer r185 = r210.f492039c;
        String r186 = new String(r185.array(), (r185.arrayOffset() + r185.position()) + r210.j().f492021b, r158, r160.charset());
        r210.c(r158);
        return r186;
    L17:
        CharBuffer r187 = CharBuffer.allocate(r158);
        ByteBuffer r188 = r210.f492039c;
        int r189 = r210.j().f492021b;
        ByteBuffer r190 = jsc.c.f500279b;
        ByteBuffer r191 = jsc.d.c(r188, r189, r158);
        Intrinsics.checkNotNullParameter(r191, "buffer");
        CoderResult r192 = r160.decode(r191, r187, true);
        if (r192.isMalformed() == false) goto L20;
    L21:
        ksc.a.d(r192);
    L22:
        r187.flip();
        r210.c(r191.position());
        return r187.toString();
    L20:
        if (r192.isUnmappable() == false) goto L22;
    L11:
        return "";
    }

    public final long b(long r100) {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        long r101 = 0;
    L7:
        if (r100 == 0) goto L11;
        io.ktor.utils.io.core.internal.a r102 = l();
        if (r102 == null) goto L11;
        int r103 = (int) Math.min(r102.f492022c - r102.f492021b, r100);
        r102.c(r103);
        this.f492040d += r103;
        if ((r102.f492022c - r102.f492021b) != 0) goto L15;
        r(r102);
    L15:
        long r104 = r103;
        r100 = r100 - r104;
        r101 = r101 + r104;
    L11:
        return r101;
    }

    public final void c(int r100) {
        int r101 = 0;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L21;
        int r103 = r100;
    L8:
        if (r103 == 0) goto L12;
        io.ktor.utils.io.core.internal.a r104 = l();
        if (r104 == null) goto L12;
        int r105 = Math.min(r104.f492022c - r104.f492021b, r103);
        r104.c(r105);
        this.f492040d += r105;
        if ((r104.f492022c - r104.f492021b) != 0) goto L19;
        r(r104);
    L19:
        r103 = r103 - r105;
        r101 = r101 + r105;
    L12:
        if (r101 != r100) goto L15;
        return;
    L15:
        throw new EOFException("Unable to discard " + r100 + " bytes due to end of packet");
    L21:
        throw new IllegalArgumentException(("Negative discard is not allowed: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    public final io.ktor.utils.io.core.internal.a e(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "current");
        AtomicReferenceFieldUpdater r101 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.internal.a r102 = io.ktor.utils.io.core.internal.a.f492030m;
    L3:
        if (r100 == r102) goto L23;
        io.ktor.utils.io.core.internal.a r103 = r100.g();
        r100.k(this.f492037a);
        if (r103 == null) goto L7;
        if (r103.f492022c <= r103.f492021b) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L13;
        r100 = r103;
        goto L3
    L13:
        u(r103);
        t(this.f492042f - ((long) (r103.f492022c - r103.f492021b)));
        return r103;
    L11:
        r104 = false;
        goto L12
    L7:
        u(r102);
        t(0);
        r100 = r102;
        goto L3
    L23:
        return d();
    }

    public final void h(io.ktor.utils.io.core.internal.a r100) {
        if (this.f492043g == true) goto L5;
    L8:
        int r101 = r100.f492022c - r100.f492021b;
        int r102 = Math.min(r101, 8 - (r100.f492025f - r100.f492024e));
        if (r101 <= r102) goto L11;
        io.ktor.utils.io.core.internal.a r103 = this.f492037a.Q5();
        io.ktor.utils.io.core.internal.a r104 = this.f492037a.Q5();
        r103.e();
        r104.e();
        r103.m(r104);
        r104.m(r100.g());
        b.a(r103, r100, r101 - r102);
        b.a(r104, r100, r102);
        u(r103);
        t(h.c(r104));
    L12:
        r100.k(this.f492037a);
        return;
    L11:
        io.ktor.utils.io.core.internal.a r105 = this.f492037a.Q5();
        r105.e();
        r105.m(r100.g());
        b.a(r105, r100, r101);
        u(r105);
        goto L12
    L5:
        if (r100.i() != null) goto L8;
        this.f492040d = r100.f492021b;
        this.f492041e = r100.f492022c;
        t(0);
    }

    public final io.ktor.utils.io.core.internal.a m(int r100) {
        return n(r100, j());
    }

    public final void r(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "head");
        io.ktor.utils.io.core.internal.a r101 = r100.g();
        if (r101 != null) goto L5;
        r101 = io.ktor.utils.io.core.internal.a.f492030m;
    L5:
        u(r101);
        t(this.f492042f - ((long) (r101.f492022c - r101.f492021b)));
        r100.k(this.f492037a);
    }

    public final void t(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        this.f492042f = r100;
        return;
    L10:
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + r100).toString());
    L5:
        r101 = false;
        goto L6
    }

    public final void u(io.ktor.utils.io.core.internal.a r100) {
        this.f492038b = r100;
        this.f492039c = r100.f492020a;
        this.f492040d = r100.f492021b;
        this.f492041e = r100.f492022c;
    }

    public final io.ktor.utils.io.core.internal.a n(int r100, io.ktor.utils.io.core.internal.a r110) {
    L2:
        int r101 = this.f492041e - this.f492040d;
        if (r101 >= r100) goto L4;
        io.ktor.utils.io.core.internal.a r102 = r110.i();
        if (r102 != null) goto L10;
        r102 = d();
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r101 == 0) goto L12;
        int r103 = b.a(r110, r102, r100 - r101);
        this.f492041e = r110.f492022c;
        t(this.f492042f - ((long) r103));
        int r104 = r102.f492022c;
        int r105 = r102.f492021b;
        boolean r106 = false;
        if (r104 <= r105) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L21;
        r110.m(null);
        r110.m(r102.g());
        r102.k(this.f492037a);
    L38:
        if ((r110.f492022c - r110.f492021b) >= r100) goto L39;
        if (r100 <= 8) goto L2;
        throw new IllegalStateException("minSize of " + r100 + " is too big (should be less than 8)");
    L39:
        return r110;
    L21:
        if (r103 < 0) goto L23;
        r106 = true;
    L23:
        if (r106 == false) goto L48;
        if (r105 < r103) goto L27;
        r102.f492023d = r103;
        goto L38
    L27:
        if (r105 != r104) goto L45;
        if (r103 > r102.f492024e) goto L30;
        r102.f492022c = r103;
        r102.f492021b = r103;
        r102.f492023d = r103;
        goto L38
    L30:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r103 <= r102.f492025f) goto L35;
        throw new IllegalArgumentException("Start gap " + r103 + " is bigger than the capacity " + r102.f492025f);
    L35:
        throw new IllegalStateException("Unable to reserve " + r103 + " start gap: there are already " + (r102.f492025f - r102.f492024e) + " bytes reserved in the end");
    L45:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        throw new IllegalStateException("Unable to reserve " + r103 + " start gap: there are already " + (r102.f492022c - r102.f492021b) + " content bytes starting at offset " + r102.f492021b);
    L48:
        throw new IllegalArgumentException(("startGap shouldn't be negative: " + r103).toString());
    L18:
        r107 = false;
        goto L19
    L12:
        if (r110 == io.ktor.utils.io.core.internal.a.f492030m) goto L14;
        r(r110);
    L14:
        r110 = r102;
        goto L2
    L4:
        return r110;
    }

    public n(io.ktor.utils.io.core.internal.a r100, long r101, io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "head");
        Intrinsics.checkNotNullParameter(r102, "pool");
        this.f492037a = r102;
        this.f492038b = r100;
        this.f492039c = r100.f492020a;
        int r103 = r100.f492021b;
        this.f492040d = r103;
        int r104 = r100.f492022c;
        this.f492041e = r104;
        this.f492042f = r101 - ((long) (r104 - r103));
    }
}
