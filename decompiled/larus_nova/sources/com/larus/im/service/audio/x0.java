package com.larus.im.service.audio;

import com.obric.sva.sdk.utils.InteractConst;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class x0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f350805r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioSessionType f350807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f350809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f350810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f350811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f350812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f350813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f350814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f350815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f350816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f350817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f350818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.larus.im.service.d f350819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c1 f350820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f350821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e f350822q;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<x0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f350823a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f350824b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f350824b;
        }

        static {
            a r100 = new a();
            f350823a = r100;
            g2 r101 = new g2("com.larus.im.service.audio.MediaSessionConfig", r100, 17);
            r101.j("bizId", false);
            r101.j(InteractConst.WAKEUP_SESSION_TYPE, false);
            r101.j("userID", false);
            r101.j("deviceId", false);
            r101.j("appVersion", false);
            r101.j("updateVersionCode", false);
            r101.j("packageType", false);
            r101.j("localCallId", false);
            r101.j("conversationId", false);
            r101.j("botId", false);
            r101.j("audioKitConfig", false);
            r101.j("enablePseudo", false);
            r101.j("extra", false);
            r101.j("mmtConfig", true);
            r101.j("rtcConfig", true);
            r101.j("engineBusinessId", true);
            r101.j("videoKitConfig", true);
            f350824b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = x0.f350805r;
            v2 r101 = v2.f520790a;
            return new juc.d[]{r101, r100[1].getValue(), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(nuc.g1.f520681a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), c.a.f350700a, nuc.i.f520705a, r100[12].getValue(), kuc.a.d(com.larus.im.service.d.a.f350832a), kuc.a.d(c1.a.f350717a), kuc.a.d(r101), kuc.a.d(e.a.f350736a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f350824b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = x0.f350805r;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = r101.decodeStringElement(r100, 0);
            AudioSessionType r104 = (AudioSessionType) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            Long r108 = (Long) r101.decodeNullableSerializableElement(r100, 5, nuc.g1.f520681a, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 6, r105, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 7, r105, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 8, r105, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            c r114 = (c) r101.decodeSerializableElement(r100, 10, c.a.f350700a, null);
            boolean r115 = r101.decodeBooleanElement(r100, 11);
            Map r116 = (Map) r101.decodeSerializableElement(r100, 12, r102[12].getValue(), null);
            com.larus.im.service.d r117 = (com.larus.im.service.d) r101.decodeNullableSerializableElement(r100, 13, com.larus.im.service.d.a.f350832a, null);
            c1 r118 = (c1) r101.decodeNullableSerializableElement(r100, 14, c1.a.f350717a, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 15, r105, null);
            c1 r210 = r118;
            c r211 = r114;
            e r212 = (e) r101.decodeNullableSerializableElement(r100, 16, e.a.f350736a, null);
            String r120 = r111;
            String r213 = r119;
            com.larus.im.service.d r214 = r117;
            Map r215 = r116;
            String r121 = r103;
            String r122 = r106;
            Long r123 = r108;
            String r216 = r113;
            String r124 = r112;
            boolean r217 = r115;
            int r125 = 131071;
            String r126 = r107;
            String r127 = r110;
            AudioSessionType r128 = r104;
            String r129 = r109;
        L45:
            r101.endStructure(r100);
            return new x0(r125, r121, r128, r122, r127, r126, r123, r120, r124, r129, r216, r211, r217, r215, r214, r210, r213, r212);
        L5:
            String r130 = null;
            String r131 = null;
            Long r132 = null;
            String r133 = null;
            com.larus.im.service.d r134 = null;
            e r135 = null;
            Map r136 = null;
            String r137 = null;
            c r138 = null;
            String r139 = null;
            String r140 = null;
            String r218 = null;
            String r219 = null;
            c1 r220 = null;
            String r221 = null;
            AudioSessionType r311 = null;
            int r141 = 0;
            boolean r312 = false;
            boolean r313 = true;
        L6:
            if (r313 == false) goto L44;
            int r142 = r101.decodeElementIndex(r100);
            switch(r142) {
                case -1: goto L41;
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L36;
                case 3: goto L34;
                case 4: goto L32;
                case 5: goto L30;
                case 6: goto L28;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                default: goto L10;
            };
        L11:
            r135 = (e) r101.decodeNullableSerializableElement(r100, 16, e.a.f350736a, r135);
            r141 = r141 | 65536;
        L14:
            c1 r143 = r220;
        L18:
            r131 = r131;
            c1 r144 = r143;
            String r145 = r133;
            r137 = r137;
        L38:
            r133 = r145;
            String r314 = r218;
            r102 = r102;
            String r146 = r314;
        L43:
            r220 = r144;
            r133 = r133;
            r131 = r131;
            Lazy<juc.d<Object>>[] r315 = r102;
            r218 = r146;
            r102 = r315;
            goto L6
        L12:
            r137 = r137;
            r145 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r133);
            r141 = r141 | 32768;
            r134 = r134;
            r220 = r220;
        L31:
            String r147 = r137;
        L33:
            String r222 = r130;
        L35:
            r131 = r131;
            r130 = r222;
        L37:
            r219 = r219;
            r134 = r134;
            c1 r316 = r220;
            r137 = r147;
            r144 = r316;
            goto L38
        L13:
            r220 = (c1) r101.decodeNullableSerializableElement(r100, 14, c1.a.f350717a, r220);
            r141 = r141 | 16384;
            goto L14
        L15:
            r133 = r133;
            r137 = r137;
            r143 = r220;
            r134 = (com.larus.im.service.d) r101.decodeNullableSerializableElement(r100, 13, com.larus.im.service.d.a.f350832a, r134);
            r141 = r141 | 8192;
            goto L18
        L17:
            r133 = r133;
            r137 = r137;
            r143 = r220;
            r136 = (Map) r101.decodeSerializableElement(r100, 12, r102[12].getValue(), r136);
            r141 = r141 | 4096;
            goto L18
        L19:
            r312 = r101.decodeBooleanElement(r100, 11);
            r141 = r141 | 2048;
        L20:
            r145 = r133;
            goto L31
        L22:
            r138 = (c) r101.decodeSerializableElement(r100, 10, c.a.f350700a, r138);
            r141 = r141 | 1024;
            goto L20
        L23:
            r140 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r140);
            r141 = r141 | 512;
            goto L20
        L24:
            r139 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r139);
            r141 = r141 | 256;
        L26:
            r145 = r133;
            goto L31
        L25:
            r130 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r130);
            r141 = r141 | 128;
            goto L26
        L28:
            r134 = r134;
            r137 = r137;
            r220 = r220;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r131);
            r141 = r141 | 64;
            r145 = r133;
            goto L31
        L30:
            r134 = r134;
            r137 = r137;
            r220 = r220;
            r132 = (Long) r101.decodeNullableSerializableElement(r100, 5, nuc.g1.f520681a, r132);
            r141 = r141 | 32;
            r145 = r133;
            goto L31
        L32:
            r134 = r134;
            String r317 = r137;
            r220 = r220;
            r141 = r141 | 16;
            r147 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r317);
            r145 = r133;
            goto L33
        L34:
            r134 = r134;
            r147 = r137;
            r220 = r220;
            String r148 = r219;
            r222 = r130;
            r141 = r141 | 8;
            r219 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r148);
            r145 = r133;
            goto L35
        L36:
            r134 = r134;
            r147 = r137;
            r219 = r219;
            r220 = r220;
            r131 = r131;
            r218 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r218);
            r141 = r141 | 4;
            r145 = r133;
            r130 = r130;
            goto L37
        L39:
            r311 = (AudioSessionType) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), r311);
            r141 = r141 | 2;
        L42:
            r146 = r218;
            r130 = r130;
            r219 = r219;
            r134 = r134;
            r137 = r137;
            r144 = r220;
            goto L43
        L40:
            r221 = r101.decodeStringElement(r100, 0);
            r141 = r141 | 1;
            goto L42
        L41:
            r313 = false;
            goto L42
        L10:
            throw new UnknownFieldException(r142);
        L44:
            com.larus.im.service.d r149 = r134;
            String r150 = r219;
            String r223 = r130;
            String r151 = r218;
            r123 = r132;
            r212 = r135;
            r211 = r138;
            r129 = r139;
            r216 = r140;
            r213 = r133;
            r214 = r149;
            r120 = r131;
            r124 = r223;
            r217 = r312;
            r122 = r151;
            r125 = r141;
            r126 = r137;
            r127 = r150;
            r215 = r136;
            r210 = r220;
            r121 = r221;
            r128 = r311;
            goto L45
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            x0 r111 = (x0) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f350824b;
            muc.d r102 = r100.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = x0.f350805r;
            boolean r104 = false;
            r102.encodeStringElement(r101, 0, r111.f350806a);
            r102.encodeSerializableElement(r101, 1, r103[1].getValue(), r111.f350807b);
            v2 r105 = v2.f520790a;
            r102.encodeNullableSerializableElement(r101, 2, r105, r111.f350808c);
            r102.encodeNullableSerializableElement(r101, 3, r105, r111.f350809d);
            r102.encodeNullableSerializableElement(r101, 4, r105, r111.f350810e);
            r102.encodeNullableSerializableElement(r101, 5, nuc.g1.f520681a, r111.f350811f);
            r102.encodeNullableSerializableElement(r101, 6, r105, r111.f350812g);
            r102.encodeNullableSerializableElement(r101, 7, r105, r111.f350813h);
            r102.encodeNullableSerializableElement(r101, 8, r105, r111.f350814i);
            r102.encodeNullableSerializableElement(r101, 9, r105, r111.f350815j);
            r102.encodeSerializableElement(r101, 10, c.a.f350700a, r111.f350816k);
            r102.encodeBooleanElement(r101, 11, r111.f350817l);
            r102.encodeSerializableElement(r101, 12, r103[12].getValue(), r111.f350818m);
            if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L12;
            r102.encodeNullableSerializableElement(r101, 13, com.larus.im.service.d.a.f350832a, r111.f350819n);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 14) == false) goto L15;
        L16:
            boolean r107 = true;
        L18:
            if (r107 == false) goto L21;
            r102.encodeNullableSerializableElement(r101, 14, c1.a.f350717a, r111.f350820o);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 15) == false) goto L24;
        L25:
            boolean r108 = true;
        L27:
            if (r108 == false) goto L30;
            r102.encodeNullableSerializableElement(r101, 15, r105, r111.f350821p);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 16) == false) goto L33;
        L34:
            r104 = true;
        L35:
            if (r104 == false) goto L37;
            r102.encodeNullableSerializableElement(r101, 16, e.a.f350736a, r111.f350822q);
        L37:
            r102.endStructure(r101);
            return;
        L33:
            if (r111.f350822q == null) goto L35;
        L24:
            if (r111.f350821p != null) goto L25;
            r108 = false;
            goto L27
        L15:
            if (r111.f350820o != null) goto L16;
            r107 = false;
            goto L18
        L6:
            if (r111.f350819n != null) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x0> serializer() {
            return a.f350823a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f350806a, r101.f350806a) == true) goto L12;
        return false;
    L12:
        if (this.f350807b == r101.f350807b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350808c, r101.f350808c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350809d, r101.f350809d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350810e, r101.f350810e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f350811f, r101.f350811f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f350812g, r101.f350812g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f350813h, r101.f350813h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f350814i, r101.f350814i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f350815j, r101.f350815j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f350816k, r101.f350816k) == true) goto L42;
        return false;
    L42:
        if (this.f350817l == r101.f350817l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f350818m, r101.f350818m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f350819n, r101.f350819n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f350820o, r101.f350820o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f350821p, r101.f350821p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f350822q, r101.f350822q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f350806a.hashCode() * 31) + this.f350807b.hashCode()) * 31;
        String r101 = this.f350808c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f350809d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f350810e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f350811f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f350812g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f350813h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f350814i;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f350815j;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (((r122 + r124) * 31) + this.f350816k.hashCode()) * 31;
        if (this.f350817l == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (((r125 + r126) * 31) + this.f350818m.hashCode()) * 31;
        com.larus.im.service.d r128 = this.f350819n;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        c1 r131 = this.f350820o;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f350821p;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        e r137 = this.f350822q;
        if (r137 == null) goto L55;
        r102 = r137.hashCode();
    L55:
        return r136 + r102;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaSessionConfig(bizId=" + this.f350806a + ", sessionType=" + this.f350807b + ", userID=" + this.f350808c + ", deviceId=" + this.f350809d + ", appVersion=" + this.f350810e + ", updateVersionCode=" + this.f350811f + ", packageType=" + this.f350812g + ", localCallId=" + this.f350813h + ", conversationId=" + this.f350814i + ", botId=" + this.f350815j + ", audioKitConfig=" + this.f350816k + ", enablePseudo=" + this.f350817l + ", extra=" + this.f350818m + ", mmtConfig=" + this.f350819n + ", rtcConfig=" + this.f350820o + ", engineBusinessId=" + this.f350821p + ", videoKitConfig=" + this.f350822q + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f350805r = new Lazy[]{null, LazyKt.lazy(r100, new v0()), null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new w0()), null, null, null, null};
    }

    public static x0 a(x0 r210, Map r211, String r212, int r213) {
        e r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = r210.f350806a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        AudioSessionType r102 = r210.f350807b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = r210.f350808c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = r210.f350809d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r210.f350810e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Long r110 = r210.f350811f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r111 = r210.f350812g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r112 = r210.f350813h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r113 = r210.f350814i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        String r114 = r210.f350815j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        c r115 = r210.f350816k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        boolean r116 = r210.f350817l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        Map r106 = r210.f350818m;
    L55:
        if ((r213 & 8192) == 0) goto L57;
        com.larus.im.service.d r117 = r210.f350819n;
    L59:
        if ((r213 & 16384) == 0) goto L61;
        c1 r118 = r210.f350820o;
    L63:
        if ((32768 & r213) == 0) goto L65;
        String r214 = r210.f350821p;
    L67:
        if ((r213 & 65536) == 0) goto L69;
        r100 = r210.f350822q;
    L69:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r101, "bizId");
        Intrinsics.checkNotNullParameter(r102, InteractConst.WAKEUP_SESSION_TYPE);
        Intrinsics.checkNotNullParameter(r115, "audioKitConfig");
        Intrinsics.checkNotNullParameter(r106, "extra");
        return new x0(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r106, r117, r118, r214, r100);
    L65:
        r214 = r212;
        goto L67
    L61:
        r118 = null;
        goto L63
    L57:
        r117 = null;
        goto L59
    L53:
        r106 = r211;
        goto L55
    L49:
        r116 = false;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public x0(String r100, AudioSessionType r101, String r102, String r110, String r111, Long r112, String r113, String r114, String r115, String r116, c r117, boolean r118, Map<String, String> r119, com.larus.im.service.d r210, c1 r211, String r212, e r213) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_SESSION_TYPE);
        Intrinsics.checkNotNullParameter(r117, "audioKitConfig");
        Intrinsics.checkNotNullParameter(r119, "extra");
        this.f350806a = r100;
        this.f350807b = r101;
        this.f350808c = r102;
        this.f350809d = r110;
        this.f350810e = r111;
        this.f350811f = r112;
        this.f350812g = r113;
        this.f350813h = r114;
        this.f350814i = r115;
        this.f350815j = r116;
        this.f350816k = r117;
        this.f350817l = r118;
        this.f350818m = r119;
        this.f350819n = r210;
        this.f350820o = r211;
        this.f350821p = r212;
        this.f350822q = r213;
    }

    public /* synthetic */ x0(String r210, AudioSessionType r211, String r212, String r213, String r214, Long r215, String r216, String r217, String r310, String r311, c r312, boolean r313, Map r314, com.larus.im.service.d r315, c1 r316, e r317, int r318) {
        if ((r318 & 8192) == 0) goto L5;
        com.larus.im.service.d r110 = null;
    L7:
        if ((r318 & 16384) == 0) goto L9;
        c1 r111 = null;
    L11:
        if ((r318 & 65536) == 0) goto L13;
        e r218 = null;
    L14:
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r110, r111, null, r218);
        return;
    L13:
        r218 = r317;
        goto L14
    L9:
        r111 = r316;
        goto L11
    L5:
        r110 = r315;
        goto L7
    }

    public x0(int r100, String r101, AudioSessionType r102, String r103, String r110, String r111, Long r112, String r113, String r114, String r115, String r116, c r117, boolean r118, Map r119, com.larus.im.service.d r210, c1 r211, String r212, e r213) {
        if (8191 != (r100 & 8191)) goto L21;
        this.f350806a = r101;
        this.f350807b = r102;
        this.f350808c = r103;
        this.f350809d = r110;
        this.f350810e = r111;
        this.f350811f = r112;
        this.f350812g = r113;
        this.f350813h = r114;
        this.f350814i = r115;
        this.f350815j = r116;
        this.f350816k = r117;
        this.f350817l = r118;
        this.f350818m = r119;
        if ((r100 & 8192) != 0) goto L7;
        this.f350819n = null;
    L9:
        if ((r100 & 16384) != 0) goto L11;
        this.f350820o = null;
    L13:
        if ((32768 & r100) != 0) goto L15;
        this.f350821p = null;
    L17:
        if ((r100 & 65536) != 0) goto L19;
        this.f350822q = null;
        return;
    L19:
        this.f350822q = r213;
        return;
    L15:
        this.f350821p = r212;
        goto L17
    L11:
        this.f350820o = r211;
        goto L13
    L7:
        this.f350819n = r210;
        goto L9
    L21:
        b2.b(r100, 8191, a.f350824b);
        throw null;
    }
}
