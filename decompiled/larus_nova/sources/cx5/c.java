package cx5;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f465716c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f465717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f465718b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465719a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f465720b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465720b;
        }

        static {
            a r100 = new a();
            f465719a = r100;
            g2 r101 = new g2("com.bytedance.flow_audio.impl.core.response.FlowAudioASRResponse", r100, 2);
            r101.j("results", true);
            r101.j("extra", true);
            f465720b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{c.f465716c[0].getValue(), kuc.a.d(e.a.f465725a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f465720b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = c.f465716c;
            List r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            List r103 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), null);
            e r104 = (e) r111.decodeNullableSerializableElement(r100, 1, e.a.f465725a, null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new c(r105, r103, r104);
        L5:
            e r106 = null;
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
            r102 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), r102);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r106 = (e) r111.decodeNullableSerializableElement(r100, 1, e.a.f465725a, r106);
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
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f465720b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = c.f465716c;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, r105[0].getValue(), r102.f465717a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, e.a.f465725a, r102.f465718b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f465718b == null) goto L17;
        L6:
            if (Intrinsics.areEqual(r102.f465717a, CollectionsKt.emptyList()) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f465719a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f465717a, r101.f465717a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465718b, r101.f465718b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f465717a.hashCode() * 31;
        e r101 = this.f465718b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowAudioASRResponse(results=" + this.f465717a + ", extra=" + this.f465718b + ')';
    }

    static {
        Companion = new b();
        f465716c = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new cx5.b()), null};
    }

    public c() {
        List<f> r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "results");
        this.f465717a = r100;
        this.f465718b = null;
    }

    public c(int r100, List r101, e r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f465720b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = CollectionsKt.emptyList();
    L7:
        this.f465717a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f465718b = null;
        return;
    L10:
        this.f465718b = r102;
    }
}
