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
public final class a0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NodeType f509714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509715b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509716a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f509717b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{n.f509758a, v2.f520790a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f509717b;
        }

        static {
            a r100 = new a();
            f509716a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.quick_access.UnpinRequest", r100, 2);
            r101.j("node_type", true);
            r101.j("reference_id", true);
            f509717b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f509717b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            NodeType r102 = (NodeType) r111.decodeSerializableElement(r100, 0, n.f509758a, null);
            String r103 = r111.decodeStringElement(r100, 1);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new a0(r104, r102, r103);
        L5:
            NodeType r105 = null;
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
            r105 = (NodeType) r111.decodeSerializableElement(r100, 0, n.f509758a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = r111.decodeStringElement(r100, 1);
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
            g2 r103 = f509717b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = a0.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, n.f509758a, r102.f509714a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeStringElement(r103, 1, r102.f509715b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f509715b, "") == true) goto L17;
        L6:
            if (r102.f509714a != NodeType.UNKNOWN) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a0> serializer() {
            return a.f509716a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f509714a == r101.f509714a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509715b, r101.f509715b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f509714a.hashCode() * 31) + this.f509715b.hashCode();
    }

    public final String toString() {
        return "UnpinRequest(nodeType=" + this.f509714a + ", referenceId=" + this.f509715b + ')';
    }

    static {
        Companion = new b();
    }

    public a0() {
        this(NodeType.UNKNOWN, "");
    }

    public a0(NodeType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeType");
        Intrinsics.checkNotNullParameter(r101, "referenceId");
        this.f509714a = r100;
        this.f509715b = r101;
    }

    public a0(int r100, NodeType r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f509717b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = NodeType.UNKNOWN;
    L7:
        this.f509714a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f509715b = "";
        return;
    L10:
        this.f509715b = r102;
    }
}
