package ll9;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
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
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f509718e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f509719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f509721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<NodeType> f509722d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509723a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f509724b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f509724b;
        }

        static {
            a r100 = new a();
            f509723a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.quick_access.DiscoverRequest", r100, 4);
            r101.j("count", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            r101.j("with_detail", true);
            r101.j("types_in", true);
            f509724b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(w0.f520792a), kuc.a.d(v2.f520790a), kuc.a.d(nuc.i.f520705a), kuc.a.d(c.f509718e[3].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f509724b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = c.f509718e;
            Integer r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, null);
            List r110 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
            Integer r111 = r104;
            Boolean r112 = r106;
            String r113 = r105;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new c(r114, r111, r113, r112, r110);
        L5:
            String r107 = null;
            Boolean r115 = null;
            List r116 = null;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r103);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, r115);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r114 = r108;
            r111 = r103;
            r113 = r107;
            r112 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f509724b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = c.f509718e;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f509719a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 10) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, w0.f520792a, r102.f509719a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f509720b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f509721c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            r106 = true;
        L38:
            if (r106 == false) goto L40;
            r104.encodeNullableSerializableElement(r103, 3, r105[3].getValue(), r102.f509722d);
        L40:
            r104.endStructure(r103);
            return;
        L36:
            if (r102.f509722d == null) goto L38;
        L27:
            if (Intrinsics.areEqual(r102.f509721c, Boolean.TRUE) == false) goto L28;
            r110 = false;
            goto L30
        L18:
            if (r102.f509720b != null) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f509723a;
        }
    }

    public c() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f509719a, r101.f509719a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509720b, r101.f509720b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509721c, r101.f509721c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509722d, r101.f509722d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f509719a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509720b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f509721c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<NodeType> r110 = this.f509722d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiscoverRequest(count=" + this.f509719a + ", cursor=" + this.f509720b + ", withDetail=" + this.f509721c + ", typesIn=" + this.f509722d + ')';
    }

    static {
        Companion = new b();
        f509718e = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ll9.b())};
    }

    public c(Integer r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 10;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        Boolean r103 = Boolean.TRUE;
    L12:
        this.f509719a = r100;
        this.f509720b = r101;
        this.f509721c = r103;
        this.f509722d = null;
        return;
    L11:
        r103 = null;
        goto L12
    }

    public c(int r100, Integer r101, String r102, Boolean r103, List r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f509724b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 10;
    L7:
        this.f509719a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f509720b = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f509721c = Boolean.TRUE;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f509722d = null;
        return;
    L18:
        this.f509722d = r104;
        return;
    L14:
        this.f509721c = r103;
        goto L16
    L10:
        this.f509720b = r102;
        goto L12
    }
}
