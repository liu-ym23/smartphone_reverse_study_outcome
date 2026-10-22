package com.bytedance.bdnavigationsdk.pojo;

import java.util.List;
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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class YawResult {
    public static final b Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final juc.d<Object>[] f200317c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrCode f200318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f200319b;

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
            ErrCode r100 = new ErrCode("SUCCESS", 0);
            SUCCESS = r100;
            ErrCode r101 = new ErrCode("SYSTEM_ERROR", 1);
            SYSTEM_ERROR = r101;
            ErrCode r102 = new ErrCode("INSUFFICIENT_LOCATION", 2);
            INSUFFICIENT_LOCATION = r102;
            ErrCode r103 = new ErrCode("INSUFFICIENT_USABLE_LOCATION", 3);
            INSUFFICIENT_USABLE_LOCATION = r103;
            ErrCode[] r104 = {r100, r101, r102, r103};
            $VALUES = r104;
            $ENTRIES = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t84.d());
        }

        public static ErrCode[] values() {
            return (ErrCode[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public static ErrCode valueOf(String r100) {
            return (ErrCode) r27.a.a(ErrCode.class, r100);
        }

        public ErrCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<YawResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200320a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200321b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f200321b;
        }

        static {
            a r100 = new a();
            f200320a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.YawResult", r100, 2);
            r101.j("code", true);
            r101.j("data", true);
            f200321b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(YawResult.f200317c[0]), kuc.a.d(c.a.f200328a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200321b;
            muc.c r111 = r110.beginStructure(r100);
            juc.d<Object>[] r101 = YawResult.f200317c;
            ErrCode r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            ErrCode r103 = (ErrCode) r111.decodeNullableSerializableElement(r100, 0, r101[0], null);
            c r104 = (c) r111.decodeNullableSerializableElement(r100, 1, c.a.f200328a, null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new YawResult(r105, r103, r104);
        L5:
            c r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L16;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r102 = (ErrCode) r111.decodeNullableSerializableElement(r100, 0, r101[0], r102);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r106 = (c) r111.decodeNullableSerializableElement(r100, 1, c.a.f200328a, r106);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r103 = r102;
            r104 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            YawResult r102 = (YawResult) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200321b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = YawResult.f200317c;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0], r102.f200318a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, c.a.f200328a, r102.f200319b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f200319b == null) goto L17;
        L6:
            if (r102.f200318a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<YawResult> serializer() {
            return a.f200320a;
        }
    }

    @Serializable
    public static final class c {
        public static final b Companion = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final juc.d<Object>[] f200322f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f200323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.bdnavigationsdk.pojo.a f200324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProjectionResult f200325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.bdnavigationsdk.pojo.b f200326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<ProjectionResult> f200327e;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f200328a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f200329b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final f getDescriptor() {
                return f200329b;
            }

            static {
                a r100 = new a();
                f200328a = r100;
                g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.YawResult.YawData", r100, 5);
                r101.j("isYaw", true);
                r101.j("yawCoord", true);
                r101.j("nearest", true);
                r101.j("location", true);
                r101.j("nearestWindow", true);
                f200329b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{i.f520705a, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a), kuc.a.d(ProjectionResult.a.f200315a), kuc.a.d(com.bytedance.bdnavigationsdk.pojo.b.a.f200342a), kuc.a.d(c.f200322f[4])};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f200329b;
                muc.c r101 = r210.beginStructure(r100);
                juc.d<Object>[] r102 = c.f200322f;
                if (r101.decodeSequentially() == false) goto L5;
                boolean r103 = r101.decodeBooleanElement(r100, 0);
                com.bytedance.bdnavigationsdk.pojo.a r104 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 1, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, null);
                ProjectionResult r105 = (ProjectionResult) r101.decodeNullableSerializableElement(r100, 2, ProjectionResult.a.f200315a, null);
                com.bytedance.bdnavigationsdk.pojo.b r106 = (com.bytedance.bdnavigationsdk.pojo.b) r101.decodeNullableSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.b.a.f200342a, null);
                List r211 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4], null);
                boolean r110 = r103;
                ProjectionResult r111 = r105;
                com.bytedance.bdnavigationsdk.pojo.a r112 = r104;
                com.bytedance.bdnavigationsdk.pojo.b r212 = r106;
                int r113 = 31;
            L24:
                r101.endStructure(r100);
                return new c(r113, r110, r112, r111, r212, r211);
            L5:
                com.bytedance.bdnavigationsdk.pojo.a r114 = null;
                ProjectionResult r115 = null;
                com.bytedance.bdnavigationsdk.pojo.b r116 = null;
                List r117 = null;
                boolean r107 = false;
                int r108 = 0;
                boolean r118 = true;
            L6:
                if (r118 == false) goto L23;
                int r119 = r101.decodeElementIndex(r100);
                if (r119 != (-1)) goto L9;
                r118 = false;
                goto L6
            L9:
                if (r119 != 0) goto L10;
                r107 = r101.decodeBooleanElement(r100, 0);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r119 == 1) goto L19;
                if (r119 == 2) goto L18;
                if (r119 == 3) goto L17;
                if (r119 != 4) goto L16;
                r108 = r108 | 16;
                r117 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4], r117);
                goto L6
            L16:
                throw new UnknownFieldException(r119);
            L17:
                r108 = r108 | 8;
                r116 = (com.bytedance.bdnavigationsdk.pojo.b) r101.decodeNullableSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.b.a.f200342a, r116);
                goto L6
            L18:
                r108 = r108 | 4;
                r115 = (ProjectionResult) r101.decodeNullableSerializableElement(r100, 2, ProjectionResult.a.f200315a, r115);
                goto L6
            L19:
                r108 = r108 | 2;
                r114 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 1, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r114);
                goto L6
            L23:
                r110 = r107;
                r113 = r108;
                r112 = r114;
                r111 = r115;
                r212 = r116;
                r211 = r117;
                goto L24
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                c r102 = (c) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f200329b;
                muc.d r104 = r100.beginStructure(r103);
                juc.d<Object>[] r105 = c.f200322f;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f200323a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeNullableSerializableElement(r103, 1, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r102.f200324b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeNullableSerializableElement(r103, 2, ProjectionResult.a.f200315a, r102.f200325c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeNullableSerializableElement(r103, 3, com.bytedance.bdnavigationsdk.pojo.b.a.f200342a, r102.f200326d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                r106 = true;
            L44:
                if (r106 == false) goto L46;
                r104.encodeNullableSerializableElement(r103, 4, r105[4], r102.f200327e);
            L46:
                r104.endStructure(r103);
                return;
            L42:
                if (r102.f200327e == null) goto L44;
            L33:
                if (r102.f200326d != null) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f200325c != null) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f200324b != null) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f200323a == true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<c> serializer() {
                return a.f200328a;
            }
        }

        public c() {
            this(false, null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f200323a == r101.f200323a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f200324b, r101.f200324b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f200325c, r101.f200325c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f200326d, r101.f200326d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f200327e, r101.f200327e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.f200323a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            com.bytedance.bdnavigationsdk.pojo.a r102 = this.f200324b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            ProjectionResult r106 = this.f200325c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            com.bytedance.bdnavigationsdk.pojo.b r109 = this.f200326d;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            List<ProjectionResult> r112 = this.f200327e;
            if (r112 == null) goto L23;
            r103 = r112.hashCode();
        L23:
            return r111 + r103;
        L17:
            r110 = r109.hashCode();
            goto L18
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        static {
            Companion = new b();
            f200322f = new juc.d[]{null, null, null, null, new nuc.f(ProjectionResult.a.f200315a)};
        }

        public final String toString() {
            return "YawData{isYaw=" + this.f200323a + ", yawCoord=" + this.f200324b + ", nearest=" + this.f200325c + ", location=" + this.f200326d + com.alipay.sdk.m.u.i.f25855d;
        }

        public c(boolean r100, com.bytedance.bdnavigationsdk.pojo.a r101, ProjectionResult r102, com.bytedance.bdnavigationsdk.pojo.b r103, List<ProjectionResult> r104) {
            this.f200323a = r100;
            this.f200324b = r101;
            this.f200325c = r102;
            this.f200326d = r103;
            this.f200327e = r104;
        }

        public c(int r100, boolean r101, com.bytedance.bdnavigationsdk.pojo.a r102, ProjectionResult r103, com.bytedance.bdnavigationsdk.pojo.b r104, List r105) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f200329b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f200323a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f200324b = null;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f200325c = null;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f200326d = null;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f200327e = null;
            return;
        L23:
            this.f200327e = r105;
            return;
        L19:
            this.f200326d = r104;
            goto L21
        L15:
            this.f200325c = r103;
            goto L17
        L11:
            this.f200324b = r102;
            goto L13
        L7:
            this.f200323a = r101;
            goto L9
        }
    }

    public YawResult() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof YawResult) == true) goto L8;
        return false;
    L8:
        YawResult r101 = (YawResult) r100;
        if (this.f200318a == r101.f200318a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200319b, r101.f200319b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ErrCode r100 = this.f200318a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.f200319b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        f200317c = new juc.d[]{ErrCode.Companion.serializer(), null};
    }

    public final String toString() {
        return "YawResult{code=" + this.f200318a + ", data=" + this.f200319b + com.alipay.sdk.m.u.i.f25855d;
    }

    public YawResult(ErrCode r100, c r101) {
        this.f200318a = r100;
        this.f200319b = r101;
    }

    public YawResult(int r100, ErrCode r101, c r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200321b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200318a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200319b = null;
        return;
    L11:
        this.f200319b = r102;
        return;
    L7:
        this.f200318a = r101;
        goto L9
    }
}
