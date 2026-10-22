package com.larus.business.arc.api;

import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes26.dex */
@Serializable
public final class j {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f319892d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArcBizStatus f319893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArcFrameworkFailure f319894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f319895c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319896a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f319897b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f319897b;
        }

        static {
            a r100 = new a();
            f319896a = r100;
            g2 r101 = new g2("com.larus.business.arc.api.ArcCallOutcome", r100, 3);
            r101.j("bizStatus", false);
            r101.j("failureCode", true);
            r101.j("bizCode", true);
            f319897b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = j.f319892d;
            return new juc.d[]{r100[0].getValue(), r100[1].getValue(), v2.f520790a};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f319897b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = j.f319892d;
            ArcBizStatus r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            ArcBizStatus r103 = (ArcBizStatus) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), null);
            ArcFrameworkFailure r104 = (ArcFrameworkFailure) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), null);
            String r105 = r111.decodeStringElement(r100, 2);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new j(r106, r103, r104, r105);
        L5:
            ArcFrameworkFailure r107 = null;
            String r108 = null;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r102 = (ArcBizStatus) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (ArcFrameworkFailure) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = r111.decodeStringElement(r100, 2);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r103 = r102;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            j r102 = (j) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f319897b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = j.f319892d;
            boolean r106 = false;
            r104.encodeSerializableElement(r103, 0, r105[0].getValue(), r102.f319893a);
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 1, r105[1].getValue(), r102.f319894b);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeStringElement(r103, 2, r102.f319895c);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f319895c, "0") == true) goto L17;
        L6:
            if (r102.f319894b != ArcFrameworkFailure.NONE) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.f319896a;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319898a = null;

        static {
            int[] r100 = new int[ArcStage.values().length];
            r100[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f319898a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f319893a == r101.f319893a) goto L12;
        return false;
    L12:
        if (this.f319894b == r101.f319894b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f319895c, r101.f319895c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f319893a.hashCode() * 31) + this.f319894b.hashCode()) * 31) + this.f319895c.hashCode();
    }

    public final String toString() {
        return "ArcCallOutcome(bizStatus=" + this.f319893a + ", failureCode=" + this.f319894b + ", bizCode=" + this.f319895c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f319892d = new Lazy[]{LazyKt.lazy(r100, new h()), LazyKt.lazy(r100, new i()), null};
    }

    public final j b() {
        ArcStage r100 = this.f319894b.getStage();
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        String r102 = "0";
        if (r101 == (-1)) goto L16;
        if (r101 == 1) goto L265;
        if (r101 == 2) goto L264;
        if (r101 == 3) goto L16;
        throw new NoWhenBranchMatchedException();
    L264:
        return a(this, ArcBizStatus.UNKNOWN, "0", 2);
    L265:
        return a(this, ArcBizStatus.NOT_STARTED, "0", 2);
    L16:
        List<String> r103 = p.f319905a;
        String r104 = this.f319895c;
        ArcBizStatus r105 = this.f319893a;
        Intrinsics.checkNotNullParameter(r105, "status");
        if (r105 != ArcBizStatus.FAILED) goto L246;
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        if (r104.length() > 256) goto L243;
        String r106 = StringsKt.trim(r104).toString();
        if (r106.length() != 0) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == true) goto L246;
        if (Intrinsics.areEqual(r106, "0") == true) goto L246;
        if (r106.length() > 64) goto L240;
        int r108 = 0;
    L36:
        if (r108 >= r106.length()) goto L67;
        char r109 = r106.charAt(r108);
        if ('a' > r109) goto L41;
        if (r109 >= '{') goto L41;
        boolean r110 = true;
    L42:
        if (r110 == true) goto L55;
        if ('A' > r109) goto L46;
        if (r109 >= '[') goto L46;
        boolean r111 = true;
    L47:
        if (r111 == true) goto L55;
        if ('0' > r109) goto L51;
        if (r109 >= ':') goto L51;
        boolean r112 = true;
    L52:
        if (r112 == true) goto L55;
        boolean r113 = false;
    L56:
        if (r113 == true) goto L63;
        if (r109 == '_') goto L63;
        if (r109 == '.') goto L63;
        if (r109 == ':') goto L63;
        if (r109 == '-') goto L63;
        boolean r114 = false;
    L64:
        if (r114 == false) goto L65;
        r108 = r108 + 1;
        goto L36
    L65:
        boolean r115 = false;
    L68:
        if (r115 == false) goto L240;
        if (p.f319912h.matches(r106) == false) goto L73;
    L141:
        boolean r116 = true;
    L146:
        if (r116 == false) goto L148;
    L237:
        boolean r117 = true;
    L238:
        if (r117 == true) goto L240;
        boolean r118 = true;
    L241:
        if (r118 == false) goto L243;
    L244:
        r102 = r106;
        goto L246
    L148:
        if (p.f319906b.matches(r106) == true) goto L237;
        if (p.f319907c.matches(r106) == true) goto L237;
        if (p.f319908d.matches(r106) == true) goto L237;
        if (p.f319909e.matches(r106) == true) goto L237;
        if (p.f319913i.containsMatchIn(r106) == true) goto L237;
        if (p.f319914j.containsMatchIn(r106) == true) goto L237;
        if (p.f319915k.contains(r106.toLowerCase(Locale.ROOT)) == true) goto L237;
        if (StringsKt.contains$default(r106, '@', false, 2, null) == true) goto L237;
        if (StringsKt.contains$default(r106, '/', false, 2, null) == true) goto L237;
        if (StringsKt.contains$default(r106, '\\', false, 2, null) == true) goto L237;
        int r119 = 0;
    L169:
        if (r119 >= r106.length()) goto L185;
        char r120 = r106.charAt(r119);
        if (r120 != '{') goto L173;
    L181:
        boolean r121 = true;
    L182:
        if (r121 == true) goto L183;
        r119 = r119 + 1;
        goto L169
    L183:
        boolean r122 = true;
    L186:
        if (r122 == true) goto L237;
        int r123 = 0;
        int r124 = 0;
    L189:
        if (r123 >= r106.length()) goto L198;
        if (r106.charAt(r123) != ':') goto L193;
        boolean r125 = true;
    L194:
        if (r125 == false) goto L196;
        r124 = r124 + 1;
    L196:
        r123 = r123 + 1;
        goto L189
    L193:
        r125 = false;
        goto L194
    L198:
        if (r124 < 2) goto L233;
        int r126 = 0;
    L201:
        if (r126 >= r106.length()) goto L230;
        char r127 = r106.charAt(r126);
        if ('a' <= r127) goto L205;
    L207:
        boolean r128 = false;
    L208:
        if (r128 == true) goto L226;
        if ('A' <= r127) goto L211;
    L213:
        boolean r129 = false;
    L214:
        if (r129 == true) goto L226;
        if ('0' > r127) goto L218;
        if (r127 >= ':') goto L218;
        boolean r130 = true;
    L219:
        if (r130 == true) goto L226;
        if (r127 == ':') goto L226;
        if (r127 == '.') goto L226;
        boolean r131 = false;
    L227:
        if (r131 == false) goto L228;
        r126 = r126 + 1;
        goto L201
    L228:
        boolean r132 = false;
    L231:
        if (r132 == false) goto L233;
        boolean r133 = true;
    L234:
        if (r133 == true) goto L237;
        r117 = false;
    L218:
        r130 = false;
        goto L219
    L211:
        if (r127 >= 'G') goto L213;
        r129 = true;
    L226:
        r131 = true;
        goto L227
    L205:
        if (r127 >= 'g') goto L207;
        r128 = true;
        goto L208
    L230:
        r132 = true;
    L233:
        r133 = false;
        goto L234
    L173:
        if (r120 == '}') goto L181;
        if (r120 == '[') goto L181;
        if (r120 == ']') goto L181;
        if (r120 == '\"') goto L181;
        r121 = false;
        goto L182
    L185:
        r122 = false;
        goto L186
    L73:
        if (r106.length() < 24) goto L78;
        if (p.f319910f.matches(r106) == true) goto L141;
    L78:
        if (r106.length() < 24) goto L143;
        if (p.f319911g.matches(r106) == false) goto L139;
        int r134 = 0;
    L84:
        if (r134 >= r106.length()) goto L93;
        char r135 = r106.charAt(r134);
        if ('a' > r135) goto L89;
        if (r135 >= '{') goto L89;
        boolean r136 = true;
    L90:
        if (r136 == true) goto L91;
        r134 = r134 + 1;
        goto L84
    L91:
        int r137 = 1;
    L94:
        int r138 = 0;
    L96:
        if (r138 >= r106.length()) goto L105;
        char r139 = r106.charAt(r138);
        if ('A' > r139) goto L101;
        if (r139 >= '[') goto L101;
        boolean r140 = true;
    L102:
        if (r140 == true) goto L103;
        r138 = r138 + 1;
        goto L96
    L103:
        boolean r141 = true;
    L106:
        if (r141 == false) goto L108;
        r137 = r137 + 1;
    L108:
        int r142 = 0;
    L110:
        if (r142 >= r106.length()) goto L119;
        char r143 = r106.charAt(r142);
        if ('0' > r143) goto L115;
        if (r143 >= ':') goto L115;
        boolean r144 = true;
    L116:
        if (r144 == true) goto L117;
        r142 = r142 + 1;
        goto L110
    L117:
        boolean r145 = true;
    L120:
        if (r145 == false) goto L122;
        r137 = r137 + 1;
    L122:
        int r146 = 0;
    L124:
        if (r146 >= r106.length()) goto L134;
        char r147 = r106.charAt(r146);
        if (r147 == '_') goto L130;
        if (r147 == '-') goto L130;
        boolean r148 = false;
    L131:
        if (r148 == true) goto L132;
        r146 = r146 + 1;
        goto L124
    L132:
        boolean r149 = true;
    L135:
        if (r149 == false) goto L137;
        r137 = r137 + 1;
    L137:
        if (r137 < 3) goto L139;
        boolean r150 = true;
    L140:
        if (r150 == false) goto L143;
    L130:
        r148 = true;
        goto L131
    L134:
        r149 = false;
    L115:
        r144 = false;
        goto L116
    L119:
        r145 = false;
    L101:
        r140 = false;
        goto L102
    L105:
        r141 = false;
    L89:
        r136 = false;
        goto L90
    L93:
        r137 = 0;
    L139:
        r150 = false;
    L143:
        if (r106.length() >= 32) goto L145;
        r116 = false;
        goto L146
    L145:
        r116 = p.f319911g.matches(r106);
    L63:
        r114 = true;
    L51:
        r112 = false;
    L46:
        r111 = false;
    L55:
        r113 = true;
    L41:
        r110 = false;
        goto L42
    L67:
        r115 = true;
    L240:
        r118 = false;
        goto L241
    L27:
        r107 = false;
    L243:
        r106 = "UNCLASSIFIED";
    L246:
        return a(this, null, r102, 3);
    L5:
        r101 = c.f319898a[r100.ordinal()];
        goto L6
    }

    public j(ArcBizStatus r100, ArcFrameworkFailure r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bizStatus");
        Intrinsics.checkNotNullParameter(r101, "failureCode");
        Intrinsics.checkNotNullParameter(r102, "bizCode");
        this.f319893a = r100;
        this.f319894b = r101;
        this.f319895c = r102;
    }

    public j(int r100, ArcBizStatus r101, ArcFrameworkFailure r102, String r103) {
        if (1 != (r100 & 1)) goto L13;
        this.f319893a = r101;
        if ((r100 & 2) != 0) goto L7;
        this.f319894b = ArcFrameworkFailure.NONE;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.f319895c = "0";
        return;
    L11:
        this.f319895c = r103;
        return;
    L7:
        this.f319894b = r102;
        goto L9
    L13:
        b2.b(r100, 1, a.f319897b);
        throw null;
    }

    public static j a(j r100, ArcBizStatus r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f319893a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        ArcFrameworkFailure r104 = r100.f319894b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f319895c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "bizStatus");
        Intrinsics.checkNotNullParameter(r104, "failureCode");
        Intrinsics.checkNotNullParameter(r102, "bizCode");
        return new j(r101, r104, r102);
    L8:
        r104 = null;
        goto L10
    }
}
