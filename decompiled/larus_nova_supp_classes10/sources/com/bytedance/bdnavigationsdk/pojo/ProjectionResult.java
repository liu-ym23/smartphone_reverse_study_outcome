package com.bytedance.bdnavigationsdk.pojo;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class ProjectionResult {
    public static final b Companion = null;
    public static final juc.d<Object>[] m = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public com.bytedance.bdnavigationsdk.pojo.a b;
    public com.bytedance.bdnavigationsdk.pojo.a c;
    public final com.bytedance.bdnavigationsdk.pojo.a d;
    public int e;
    public int f;
    public float g;
    public float h;
    public Position i;
    public boolean j;
    public boolean k;
    public long l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/bdnavigationsdk/pojo/ProjectionResult$Position;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "BEFORE", "ON", "AFTER", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Position[] $VALUES = null;
        private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
        public static final Position AFTER = null;
        public static final Position BEFORE = null;
        public static final a Companion = null;
        public static final Position DEFAULT = null;
        public static final Position ON = null;

        public static final class a {
            public a() {
            }

            public final juc.d<Position> serializer() {
                return (juc.d) Position.access$get$cachedSerializer$delegate$cp().getValue();
            }
        }

        public static EnumEntries<Position> getEntries() {
            return $ENTRIES;
        }

        static {
            Position r0 = new Position("DEFAULT", 0);
            DEFAULT = r0;
            Position r1 = new Position("BEFORE", 1);
            BEFORE = r1;
            Position r3 = new Position("ON", 2);
            ON = r3;
            Position r5 = new Position("AFTER", 3);
            AFTER = r5;
            Position[] r7 = {r0, r1, r3, r5};
            $VALUES = r7;
            $ENTRIES = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t84.a());
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public static Position valueOf(String r1) {
            return (Position) r27.a.a(Position.class, r1);
        }

        public Position(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ProjectionResult> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.ProjectionResult", r0, 12);
            r1.j("point", true);
            r1.j("source", true);
            r1.j("target", true);
            r1.j("projection", true);
            r1.j("sourceIdx", true);
            r1.j("stepIdx", true);
            r1.j("dist", true);
            r1.j("distToStart", true);
            r1.j("position", true);
            r1.j("suspectedYaw", true);
            r1.j("suspectedAtStart", true);
            r1.j(LocationMonitorConst.TIMESTAMP, true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r0 = ProjectionResult.m;
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r2 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            w0 r3 = w0.a;
            l0 r4 = l0.a;
            i r1 = i.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), r3, r3, r4, r4, kuc.a.d(r0[8]), r1, r1, g1.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r30) {
            Intrinsics.checkNotNullParameter(r30, "decoder");
            g2 r1 = b;
            muc.c r0 = r30.beginStructure(r1);
            juc.c[] r2 = ProjectionResult.m;
            int r5 = 8;
            int r7 = 5;
            com.bytedance.bdnavigationsdk.pojo.a r4 = null;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r3 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            com.bytedance.bdnavigationsdk.pojo.a r12 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            com.bytedance.bdnavigationsdk.pojo.a r11 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            com.bytedance.bdnavigationsdk.pojo.a r9 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 2, r3, null);
            com.bytedance.bdnavigationsdk.pojo.a r6 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            int r8 = r0.decodeIntElement(r1, 4);
            int r10 = r0.decodeIntElement(r1, 5);
            float r13 = r0.decodeFloatElement(r1, 6);
            float r14 = r0.decodeFloatElement(r1, 7);
            Position r15 = (Position) r0.decodeNullableSerializableElement(r1, 8, r2[8], null);
            boolean r16 = r0.decodeBooleanElement(r1, 9);
            Position r21 = r15;
            boolean r22 = r16;
            boolean r23 = r0.decodeBooleanElement(r1, 10);
            int r17 = r8;
            int r18 = r10;
            float r19 = r13;
            com.bytedance.bdnavigationsdk.pojo.a r110 = r12;
            float r20 = r14;
            long r24 = r0.decodeLongElement(r1, 11);
            int r111 = 4095;
            com.bytedance.bdnavigationsdk.pojo.a r112 = r6;
            com.bytedance.bdnavigationsdk.pojo.a r113 = r9;
            com.bytedance.bdnavigationsdk.pojo.a r114 = r11;
        L29:
            r0.endStructure(r1);
            return new ProjectionResult(r111, r110, r114, r113, r112, r17, r18, r19, r20, r21, r22, r23, r24);
        L5:
            int r25 = 11;
            com.bytedance.bdnavigationsdk.pojo.a r26 = null;
            Position r115 = null;
            com.bytedance.bdnavigationsdk.pojo.a r116 = null;
            com.bytedance.bdnavigationsdk.pojo.a r117 = null;
            long r27 = 0;
            int r28 = 0;
            boolean r118 = false;
            boolean r29 = false;
            int r210 = 0;
            int r211 = 0;
            float r212 = 0.0f;
            float r213 = 0.0f;
            boolean r214 = true;
        L6:
            if (r214 == false) goto L28;
            int r119 = r0.decodeElementIndex(r1);
            switch(r119) {
                case -1: goto L27;
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r119);
        L19:
            r210 = r0.decodeIntElement(r1, 4);
            r28 = r28 | 16;
            goto L6
        L20:
            r26 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r26);
            int r31 = r28 | 8;
        L24:
            r28 = r31;
            com.bytedance.bdnavigationsdk.pojo.a r32 = r117;
        L26:
            r117 = r32;
            r25 = 11;
            r5 = 8;
            r7 = 5;
            goto L6
        L22:
            r116 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 2, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r116);
            r31 = r28 | 4;
            goto L24
        L23:
            r117 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r117);
            r31 = r28 | 2;
            goto L24
        L25:
            r32 = r117;
            r28 = r28 | 1;
            r4 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r4);
            goto L26
        L27:
            r5 = 8;
            r7 = 5;
            r214 = false;
            goto L6
        L11:
            r27 = r0.decodeLongElement(r1, r25);
            r28 = r28 | 2048;
            goto L6
        L12:
            r29 = r0.decodeBooleanElement(r1, 10);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
            goto L6
        L13:
            r118 = r0.decodeBooleanElement(r1, 9);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            goto L6
        L14:
            Position r120 = (Position) r0.decodeNullableSerializableElement(r1, r5, r2[r5], r115);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
            r115 = r120;
            goto L6
        L15:
            r213 = r0.decodeFloatElement(r1, 7);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            goto L6
        L16:
            r212 = r0.decodeFloatElement(r1, 6);
            r28 = r28 | 64;
            goto L6
        L17:
            r211 = r0.decodeIntElement(r1, r7);
            r28 = r28 | 32;
            goto L6
        L28:
            r110 = r4;
            r114 = r117;
            r112 = r26;
            r113 = r116;
            r23 = r29;
            r18 = r211;
            r19 = r212;
            r20 = r213;
            r24 = r27;
            r111 = r28;
            r22 = r118;
            r17 = r210;
            r21 = r115;
            goto L29
        }

        public final void serialize(muc.f r10, Object r11) {
            ProjectionResult r12 = (ProjectionResult) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            n[] r1 = ProjectionResult.m;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeNullableSerializableElement(r0, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeNullableSerializableElement(r0, 2, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeNullableSerializableElement(r0, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r13.encodeIntElement(r0, 4, r12.e);
        L48:
            if (r13.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r13.encodeIntElement(r0, 5, r12.f);
        L57:
            if (r13.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r9 = true;
        L63:
            if (r9 == false) goto L66;
            r13.encodeFloatElement(r0, 6, r12.g);
        L66:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r13.encodeFloatElement(r0, 7, r12.h);
        L75:
            if (r13.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r13.encodeNullableSerializableElement(r0, 8, r1[8], r12.i);
        L84:
            if (r13.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r13.encodeBooleanElement(r0, 9, r12.j);
        L93:
            if (r13.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r13.encodeBooleanElement(r0, 10, r12.k);
        L102:
            if (r13.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            r2 = true;
        L107:
            if (r2 == false) goto L109;
            r13.encodeLongElement(r0, 11, r12.l);
        L109:
            r13.endStructure(r0);
            return;
        L105:
            if (r12.l == 0) goto L107;
        L96:
            if (r12.k == true) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r12.j == true) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r12.i != Position.DEFAULT) goto L79;
            r15 = false;
            goto L81
        L69:
            if (Float.compare(r12.h, 0.0f) != 0) goto L70;
            r14 = false;
            goto L72
        L60:
            if (Float.compare(r12.g, 0.0f) != 0) goto L61;
            r9 = false;
            goto L63
        L51:
            if (r12.f != 0) goto L52;
            r8 = false;
            goto L54
        L42:
            if (r12.e != 0) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r12.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r12.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r12.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<ProjectionResult> serializer() {
            return a.a;
        }
    }

    public ProjectionResult() {
        this(null, null, null, null, 0, 0, 0.0f, 0.0f, null, false, 0, 4095);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ProjectionResult) == true) goto L8;
        return false;
    L8:
        ProjectionResult r9 = (ProjectionResult) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r9.h) == 0) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        com.bytedance.bdnavigationsdk.pojo.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.bytedance.bdnavigationsdk.pojo.a r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((((((r9 + r11) * 31) + this.e) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31;
        Position r13 = this.i;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        int r15 = 1231;
        if (this.j == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r14 + r16) * 31;
        if (this.k == true) goto L30;
        r15 = 1237;
    L30:
        long r18 = this.l;
        return ((r17 + r15) * 31) + ((int) (r18 ^ (r18 >>> 32)));
    L25:
        r16 = 1237;
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        m = new juc.d[]{null, null, null, null, null, null, null, null, Position.Companion.serializer(), null, null, null};
    }

    public final String toString() {
        return "ProjectionResult{point=" + this.a + ", source=" + this.b + ", target=" + this.c + ", projection=" + this.d + ", sourceIdx=" + this.e + ", stepIdx=" + this.f + ", dist=" + this.g + ", distToStart=" + this.h + ", position=" + this.i + ", suspectedYaw=" + this.j + ", suspectedAtStart=" + this.k + ", timestamp=" + this.l + "}";
    }

    public static ProjectionResult a(ProjectionResult r17, com.bytedance.bdnavigationsdk.pojo.a r18, com.bytedance.bdnavigationsdk.pojo.a r19, com.bytedance.bdnavigationsdk.pojo.a r20, int r21, int r22, float r23, float r24, Position r25, long r26, int r28) {
        if ((r28 & 1) == 0) goto L5;
        com.bytedance.bdnavigationsdk.pojo.a r2 = r17.a;
    L6:
        com.bytedance.bdnavigationsdk.pojo.a r4 = r2;
        if ((r28 & 2) == 0) goto L9;
        com.bytedance.bdnavigationsdk.pojo.a r5 = r17.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        com.bytedance.bdnavigationsdk.pojo.a r6 = r17.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        com.bytedance.bdnavigationsdk.pojo.a r7 = r17.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        int r8 = r17.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r9 = r17.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        float r10 = r17.g;
    L31:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        float r11 = r17.h;
    L35:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Position r12 = r17.i;
    L39:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        boolean r13 = r17.j;
    L43:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        boolean r14 = r17.k;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        long r15 = r17.l;
    L51:
        return new ProjectionResult(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L49:
        r15 = r26;
        goto L51
    L45:
        r14 = false;
        goto L47
    L41:
        r13 = false;
        goto L43
    L37:
        r12 = r25;
        goto L39
    L33:
        r11 = r24;
        goto L35
    L29:
        r10 = r23;
        goto L31
    L25:
        r9 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public /* synthetic */ ProjectionResult(com.bytedance.bdnavigationsdk.pojo.a r18, com.bytedance.bdnavigationsdk.pojo.a r19, com.bytedance.bdnavigationsdk.pojo.a r20, com.bytedance.bdnavigationsdk.pojo.a r21, int r22, int r23, float r24, float r25, Position r26, boolean r27, long r28, int r30) {
        if ((r30 & 1) == 0) goto L5;
        com.bytedance.bdnavigationsdk.pojo.a r4 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        com.bytedance.bdnavigationsdk.pojo.a r5 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        com.bytedance.bdnavigationsdk.pojo.a r6 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        com.bytedance.bdnavigationsdk.pojo.a r7 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r30 & 32) == 0) goto L25;
        int r9 = 0;
    L27:
        if ((r30 & 64) == 0) goto L29;
        float r10 = 0.0f;
    L31:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        float r11 = 0.0f;
    L35:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Position r12 = Position.DEFAULT;
    L39:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r30 & 2048) == 0) goto L45;
        long r15 = 0;
    L46:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, false, r15);
        return;
    L45:
        r15 = r28;
        goto L46
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public ProjectionResult(com.bytedance.bdnavigationsdk.pojo.a r1, com.bytedance.bdnavigationsdk.pojo.a r2, com.bytedance.bdnavigationsdk.pojo.a r3, com.bytedance.bdnavigationsdk.pojo.a r4, int r5, int r6, float r7, float r8, Position r9, boolean r10, boolean r11, long r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.g = com.bytedance.bdnavigationsdk.utils.b.b(r7, 2);
        this.h = com.bytedance.bdnavigationsdk.utils.b.b(this.h, 2);
    }

    public ProjectionResult(int r6, com.bytedance.bdnavigationsdk.pojo.a r7, com.bytedance.bdnavigationsdk.pojo.a r8, com.bytedance.bdnavigationsdk.pojo.a r9, com.bytedance.bdnavigationsdk.pojo.a r10, int r11, int r12, float r13, float r14, Position r15, boolean r16, boolean r17, long r18) {
        if ((r6 & 0) == 0) goto L5;
        b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r6 & 16) != 0) goto L23;
        this.e = 0;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = 0;
    L29:
        if ((r6 & 64) != 0) goto L31;
        this.g = 0.0f;
    L33:
        if ((r6 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
        this.h = 0.0f;
    L37:
        if ((r6 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L39;
        Position r2 = Position.DEFAULT;
    L40:
        this.i = r2;
        if ((r6 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L43;
        this.j = false;
    L45:
        if ((r6 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L47;
        this.k = false;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        long r1 = 0;
    L52:
        this.l = r1;
        this.g = com.bytedance.bdnavigationsdk.utils.b.b(this.g, 2);
        this.h = com.bytedance.bdnavigationsdk.utils.b.b(this.h, 2);
        return;
    L51:
        r1 = r18;
        goto L52
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        r2 = r15;
        goto L40
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r9;
        goto L17
    L11:
        this.b = r8;
        goto L13
    L7:
        this.a = r7;
        goto L9
    }
}
