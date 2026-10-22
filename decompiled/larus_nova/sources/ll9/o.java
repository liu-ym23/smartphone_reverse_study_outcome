package ll9;

import com.larus.multitask_management.api.data.quick_access.NodeType;
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

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class o {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NodeType f509760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f509762c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509763a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f509764b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{n.f509758a, v2.f520790a, kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f509764b;
        }

        static {
            a r100 = new a();
            f509763a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.quick_access.PinRequest", r100, 3);
            r101.j("node_type", true);
            r101.j("reference_id", true);
            r101.j("force_pin", true);
            f509764b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f509764b;
            muc.c r111 = r110.beginStructure(r100);
            NodeType r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            NodeType r102 = (NodeType) r111.decodeSerializableElement(r100, 0, n.f509758a, null);
            String r103 = r111.decodeStringElement(r100, 1);
            Boolean r104 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new o(r105, r102, r103, r104);
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
            r101 = (NodeType) r111.decodeSerializableElement(r100, 0, n.f509758a, r101);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = r111.decodeStringElement(r100, 1);
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
            o r102 = (o) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f509764b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = o.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, n.f509758a, r102.f509760a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeStringElement(r103, 1, r102.f509761b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f509762c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (Intrinsics.areEqual(r102.f509762c, Boolean.FALSE) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r102.f509761b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f509760a != NodeType.UNKNOWN) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<o> serializer() {
            return a.f509763a;
        }
    }

    public o() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f509760a == r101.f509760a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509761b, r101.f509761b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509762c, r101.f509762c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f509760a.hashCode() * 31) + this.f509761b.hashCode()) * 31;
        Boolean r101 = this.f509762c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PinRequest(nodeType=" + this.f509760a + ", referenceId=" + this.f509761b + ", forcePin=" + this.f509762c + ')';
    }

    static {
        Companion = new b();
    }

    public o(NodeType r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = NodeType.UNKNOWN;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) == 0) goto L11;
        Boolean r103 = Boolean.FALSE;
    L12:
        Intrinsics.checkNotNullParameter(r100, "nodeType");
        Intrinsics.checkNotNullParameter(r101, "referenceId");
        this.f509760a = r100;
        this.f509761b = r101;
        this.f509762c = r103;
        return;
    L11:
        r103 = null;
        goto L12
    }

    public o(int r100, NodeType r101, String r102, Boolean r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f509764b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = NodeType.UNKNOWN;
    L7:
        this.f509760a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f509761b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f509762c = Boolean.FALSE;
        return;
    L14:
        this.f509762c = r103;
        return;
    L10:
        this.f509761b = r102;
        goto L12
    }
}
