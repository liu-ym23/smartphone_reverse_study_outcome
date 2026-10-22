package wa8;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class a0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f558831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558832b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f558833a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f558834b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.i.f520705a), kuc.a.d(v2.f520790a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f558834b;
        }

        static {
            a r100 = new a();
            f558833a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionParseResult", r100, 2);
            r101.j("is_success", true);
            r101.j("fail_reason", true);
            f558834b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f558834b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            Boolean r102 = (Boolean) r111.decodeNullableSerializableElement(r100, 0, nuc.i.f520705a, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new a0(r104, r102, r103);
        L5:
            Boolean r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = (Boolean) r111.decodeNullableSerializableElement(r100, 0, nuc.i.f520705a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r101);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r104 = r106;
            r103 = r101;
            r102 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a0 r102 = (a0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f558834b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = a0.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, nuc.i.f520705a, r102.f558831a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f558832b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f558832b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r102.f558831a, Boolean.FALSE) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a0> serializer() {
            return a.f558833a;
        }
    }

    public a0() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f558831a, r101.f558831a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558832b, r101.f558832b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f558831a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f558832b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarInstructionParseResult(isSuccess=" + this.f558831a + ", failReason=" + this.f558832b + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ a0(Boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r101 & 2) == 0) goto L8;
        String r102 = "";
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public a0(Boolean r100, String r101) {
        this.f558831a = r100;
        this.f558832b = r101;
    }

    public a0(int r100, Boolean r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f558834b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = Boolean.FALSE;
    L7:
        this.f558831a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f558832b = "";
        return;
    L10:
        this.f558832b = r102;
    }
}
