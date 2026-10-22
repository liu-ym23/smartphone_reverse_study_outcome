package ll9;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class h {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f509735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f509737c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509738a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f509739b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(w0.f520792a), kuc.a.d(v2.f520790a), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f509739b;
        }

        static {
            a r100 = new a();
            f509738a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.quick_access.ListPinnedRequest", r100, 3);
            r101.j("count", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            r101.j("with_detail", true);
            f509739b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f509739b;
            muc.c r111 = r110.beginStructure(r100);
            Integer r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            Integer r102 = (Integer) r111.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            Boolean r104 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new h(r105, r102, r103, r104);
        L5:
            String r106 = null;
            Boolean r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r112 = r111.decodeElementIndex(r100);
            if (r112 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r112 != 0) goto L10;
            r101 = (Integer) r111.decodeNullableSerializableElement(r100, 0, w0.f520792a, r101);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r107 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r105 = r108;
            r102 = r101;
            r103 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            h r102 = (h) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f509739b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = h.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f509735a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 10) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, w0.f520792a, r102.f509735a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f509736b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            r106 = true;
        L29:
            if (r106 == false) goto L31;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f509737c);
        L31:
            r104.endStructure(r103);
            return;
        L27:
            if (Intrinsics.areEqual(r102.f509737c, Boolean.TRUE) == true) goto L29;
        L18:
            if (r102.f509736b != null) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.f509738a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f509735a, r101.f509735a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509736b, r101.f509736b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509737c, r101.f509737c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f509735a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509736b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f509737c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ListPinnedRequest(count=" + this.f509735a + ", cursor=" + this.f509736b + ", withDetail=" + this.f509737c + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ h(Integer r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = 10;
    L5:
        Boolean r103 = null;
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = Boolean.TRUE;
    L11:
        this(r100, r101, r103);
    }

    public h(Integer r100, String r101, Boolean r102) {
        this.f509735a = r100;
        this.f509736b = r101;
        this.f509737c = r102;
    }

    public h(int r100, Integer r101, String r102, Boolean r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f509739b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 10;
    L7:
        this.f509735a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f509736b = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f509737c = Boolean.TRUE;
        return;
    L14:
        this.f509737c = r103;
        return;
    L10:
        this.f509736b = r102;
        goto L12
    }
}
