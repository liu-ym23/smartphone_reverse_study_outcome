package com.bytedance.bdnavigationsdk.pojo;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class YawResult {
    public static final b Companion = null;
    public static final juc.d<Object>[] c = null;
    public final ErrCode a;
    public final c b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/bdnavigationsdk/pojo/YawResult$ErrCode;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "SYSTEM_ERROR", "INSUFFICIENT_LOCATION", "INSUFFICIENT_USABLE_LOCATION", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final enum ErrCode extends Enum<ErrCode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ErrCode[] $VALUES = null;
        private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
        public static final a Companion = null;

        @SerialName("INSUFFICIENT_LOCATION")
        public static final ErrCode INSUFFICIENT_LOCATION = null;

        @SerialName("INSUFFICIENT_USABLE_LOCATION")
        public static final ErrCode INSUFFICIENT_USABLE_LOCATION = null;

        @SerialName("SUCCESS")
        public static final ErrCode SUCCESS = null;

        @SerialName("SYSTEM_ERROR")
        public static final ErrCode SYSTEM_ERROR = null;

        public static final class a {
            public a() {
            }

            public final juc.d<ErrCode> serializer() {
                return (juc.d) ErrCode.access$get$cachedSerializer$delegate$cp().getValue();
            }
        }

        public static EnumEntries<ErrCode> getEntries() {
            return $ENTRIES;
        }

        static {
            ErrCode r0 = new ErrCode("SUCCESS", 0);
            SUCCESS = r0;
            ErrCode r1 = new ErrCode("SYSTEM_ERROR", 1);
            SYSTEM_ERROR = r1;
            ErrCode r3 = new ErrCode("INSUFFICIENT_LOCATION", 2);
            INSUFFICIENT_LOCATION = r3;
            ErrCode r5 = new ErrCode("INSUFFICIENT_USABLE_LOCATION", 3);
            INSUFFICIENT_USABLE_LOCATION = r5;
            ErrCode[] r7 = {r0, r1, r3, r5};
            $VALUES = r7;
            $ENTRIES = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t84.d());
        }

        public static ErrCode[] values() {
            return (ErrCode[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public static ErrCode valueOf(String r1) {
            return (ErrCode) r27.a.a(ErrCode.class, r1);
        }

        public ErrCode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<YawResult> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.YawResult", r0, 2);
            r1.j("code", true);
            r1.j("data", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(YawResult.c[0]), kuc.a.d(c.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            juc.c[] r1 = YawResult.c;
            ErrCode r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            ErrCode r2 = (ErrCode) r12.decodeNullableSerializableElement(r0, 0, r1[0], null);
            c r3 = (c) r12.decodeNullableSerializableElement(r0, 1, c.a.a, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new YawResult(r4, r2, r3);
        L5:
            c r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r5 = (ErrCode) r12.decodeNullableSerializableElement(r0, 0, r1[0], r5);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r6 = (c) r12.decodeNullableSerializableElement(r0, 1, c.a.a, r6);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            YawResult r8 = (YawResult) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            n[] r1 = YawResult.c;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, r1[0], r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, c.a.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (r8.b == null) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<YawResult> serializer() {
            return a.a;
        }
    }

    @Serializable
    public static final class c {
        public static final b Companion = null;
        public static final juc.d<Object>[] f = null;
        public final boolean a;
        public final com.bytedance.bdnavigationsdk.pojo.a b;
        public final ProjectionResult c;
        public final com.bytedance.bdnavigationsdk.pojo.b d;
        public final List<ProjectionResult> e;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<c> {
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
                g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.YawResult.YawData", r0, 5);
                r1.j("isYaw", true);
                r1.j("yawCoord", true);
                r1.j("nearest", true);
                r1.j(LocationMonitorConst.LOCATION, true);
                r1.j("nearestWindow", true);
                b = r1;
            }

            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{i.a, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C0133a.a), kuc.a.d(ProjectionResult.a.a), kuc.a.d(com.bytedance.bdnavigationsdk.pojo.b.a.a), kuc.a.d(c.f[4])};
            }

            public final juc.d<?>[] typeParametersSerializers() {
                return i2.a;
            }

            public final Object deserialize(e r23) {
                Intrinsics.checkNotNullParameter(r23, "decoder");
                g2 r1 = b;
                muc.c r0 = r23.beginStructure(r1);
                juc.c[] r2 = c.f;
                if (r0.decodeSequentially() == false) goto L5;
                boolean r3 = r0.decodeBooleanElement(r1, 0);
                com.bytedance.bdnavigationsdk.pojo.a r6 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
                ProjectionResult r5 = (ProjectionResult) r0.decodeNullableSerializableElement(r1, 2, ProjectionResult.a.a, null);
                com.bytedance.bdnavigationsdk.pojo.b r7 = (com.bytedance.bdnavigationsdk.pojo.b) r0.decodeNullableSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.b.a.a, null);
                List r21 = (List) r0.decodeNullableSerializableElement(r1, 4, r2[4], null);
                boolean r17 = r3;
                ProjectionResult r19 = r5;
                com.bytedance.bdnavigationsdk.pojo.a r18 = r6;
                com.bytedance.bdnavigationsdk.pojo.b r20 = r7;
                int r16 = 31;
            L24:
                r0.endStructure(r1);
                return new c(r16, r17, r18, r19, r20, r21);
            L5:
                com.bytedance.bdnavigationsdk.pojo.a r10 = null;
                ProjectionResult r11 = null;
                com.bytedance.bdnavigationsdk.pojo.b r12 = null;
                List r13 = null;
                boolean r4 = false;
                int r9 = 0;
                boolean r14 = true;
            L6:
                if (r14 == false) goto L23;
                int r15 = r0.decodeElementIndex(r1);
                if (r15 != (-1)) goto L9;
                r14 = false;
                goto L6
            L9:
                if (r15 != 0) goto L10;
                r4 = r0.decodeBooleanElement(r1, 0);
                r9 = r9 | 1;
                goto L6
            L10:
                if (r15 == 1) goto L19;
                if (r15 == 2) goto L18;
                if (r15 == 3) goto L17;
                if (r15 != 4) goto L16;
                r9 = r9 | 16;
                r13 = (List) r0.decodeNullableSerializableElement(r1, 4, r2[4], r13);
                goto L6
            L16:
                throw new UnknownFieldException(r15);
            L17:
                r9 = r9 | 8;
                r12 = (com.bytedance.bdnavigationsdk.pojo.b) r0.decodeNullableSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.b.a.a, r12);
                goto L6
            L18:
                r9 = r9 | 4;
                r11 = (ProjectionResult) r0.decodeNullableSerializableElement(r1, 2, ProjectionResult.a.a, r11);
                goto L6
            L19:
                r9 = r9 | 2;
                r10 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r10);
                goto L6
            L23:
                r17 = r4;
                r16 = r9;
                r18 = r10;
                r19 = r11;
                r20 = r12;
                r21 = r13;
                goto L24
            }

            public final void serialize(muc.f r8, Object r9) {
                c r10 = (c) r9;
                Intrinsics.checkNotNullParameter(r8, "encoder");
                Intrinsics.checkNotNullParameter(r10, "value");
                g2 r0 = b;
                muc.d r11 = r8.beginStructure(r0);
                n[] r1 = c.f;
                boolean r2 = false;
                if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
            L7:
                boolean r3 = true;
            L9:
                if (r3 == false) goto L12;
                r11.encodeBooleanElement(r0, 0, r10.a);
            L12:
                if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
            L16:
                boolean r4 = true;
            L18:
                if (r4 == false) goto L21;
                r11.encodeNullableSerializableElement(r0, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r10.b);
            L21:
                if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
            L25:
                boolean r5 = true;
            L27:
                if (r5 == false) goto L30;
                r11.encodeNullableSerializableElement(r0, 2, ProjectionResult.a.a, r10.c);
            L30:
                if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
            L34:
                boolean r6 = true;
            L36:
                if (r6 == false) goto L39;
                r11.encodeNullableSerializableElement(r0, 3, com.bytedance.bdnavigationsdk.pojo.b.a.a, r10.d);
            L39:
                if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
            L43:
                r2 = true;
            L44:
                if (r2 == false) goto L46;
                r11.encodeNullableSerializableElement(r0, 4, r1[4], r10.e);
            L46:
                r11.endStructure(r0);
                return;
            L42:
                if (r10.e == null) goto L44;
            L33:
                if (r10.d != null) goto L34;
                r6 = false;
                goto L36
            L24:
                if (r10.c != null) goto L25;
                r5 = false;
                goto L27
            L15:
                if (r10.b != null) goto L16;
                r4 = false;
                goto L18
            L6:
                if (r10.a == true) goto L7;
                r3 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<c> serializer() {
                return a.a;
            }
        }

        public c() {
            this(false, null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            com.bytedance.bdnavigationsdk.pojo.a r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            ProjectionResult r6 = this.c;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r5 + r7) * 31;
            com.bytedance.bdnavigationsdk.pojo.b r9 = this.d;
            if (r9 != null) goto L17;
            int r10 = 0;
        L18:
            int r11 = (r8 + r10) * 31;
            List<ProjectionResult> r12 = this.e;
            if (r12 == null) goto L23;
            r3 = r12.hashCode();
        L23:
            return r11 + r3;
        L17:
            r10 = r9.hashCode();
            goto L18
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        static {
            Companion = new b();
            f = new juc.d[]{null, null, null, null, new nuc.f(ProjectionResult.a.a)};
        }

        public final String toString() {
            return "YawData{isYaw=" + this.a + ", yawCoord=" + this.b + ", nearest=" + this.c + ", location=" + this.d + "}";
        }

        public c(boolean r1, com.bytedance.bdnavigationsdk.pojo.a r2, ProjectionResult r3, com.bytedance.bdnavigationsdk.pojo.b r4, List<ProjectionResult> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public c(int r4, boolean r5, com.bytedance.bdnavigationsdk.pojo.a r6, ProjectionResult r7, com.bytedance.bdnavigationsdk.pojo.b r8, List r9) {
            if ((r4 & 0) == 0) goto L5;
            b2.b(r4, 0, a.b);
            throw null;
        L5:
            if ((r4 & 1) != 0) goto L7;
            this.a = false;
        L9:
            if ((r4 & 2) != 0) goto L11;
            this.b = null;
        L13:
            if ((r4 & 4) != 0) goto L15;
            this.c = null;
        L17:
            if ((r4 & 8) != 0) goto L19;
            this.d = null;
        L21:
            if ((r4 & 16) != 0) goto L23;
            this.e = null;
            return;
        L23:
            this.e = r9;
            return;
        L19:
            this.d = r8;
            goto L21
        L15:
            this.c = r7;
            goto L17
        L11:
            this.b = r6;
            goto L13
        L7:
            this.a = r5;
            goto L9
        }
    }

    public YawResult() {
        this(null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof YawResult) == true) goto L8;
        return false;
    L8:
        YawResult r6 = (YawResult) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ErrCode r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        c r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        c = new juc.d[]{ErrCode.Companion.serializer(), null};
    }

    public final String toString() {
        return "YawResult{code=" + this.a + ", data=" + this.b + "}";
    }

    public YawResult(ErrCode r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public YawResult(int r3, ErrCode r4, c r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
