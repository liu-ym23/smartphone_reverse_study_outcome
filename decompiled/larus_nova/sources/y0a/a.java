package y0a;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565592a;

    /* JADX INFO: renamed from: y0a.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C8293a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8293a f565593a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f565594b = null;

        public C8293a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f565594b;
        }

        static {
            C8293a r100 = new C8293a();
            f565593a = r100;
            g2 r101 = new g2("com.larus.ugc.feed.impl.repo.CreationTabListRequestKmp", r100, 1);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, true);
            f565594b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f565594b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            int r104 = r102.decodeIntElement(r101, 0);
        L15:
            r102.endStructure(r101);
            return new a(r103, r104);
        L5:
            r104 = 0;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = r102.decodeIntElement(r101, 0);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f565594b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = a.Companion;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeIntElement(r103, 0, r102.f565592a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (r102.f565592a != 0) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C8293a.f565593a;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f565592a == ((a) r100).f565592a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f565592a;
    }

    public final String toString() {
        return "CreationTabListRequestKmp(recommendType=" + this.f565592a + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r100) {
        this.f565592a = r100;
    }

    public a(int r100, int r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C8293a.f565594b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f565592a = 0;
        return;
    L7:
        this.f565592a = r101;
    }
}
