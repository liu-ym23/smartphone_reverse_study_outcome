package jq9;

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

/* JADX INFO: loaded from: classes31.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f500080b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f500081a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f500082a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f500083b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f500083b;
        }

        static {
            a r100 = new a();
            f500082a = r100;
            g2 r101 = new g2("com.larus.platform.model.actionbar.ActionBarGradientConfig", r100, 1);
            r101.j("gradient_style_list", true);
            f500083b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(c.f500080b[0].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f500083b;
            muc.c r102 = r100.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = c.f500080b;
            int r104 = 1;
            List r105 = null;
            if (r102.decodeSequentially() == false) goto L5;
            List r106 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), null);
        L15:
            r102.endStructure(r101);
            return new c(r104, r106);
        L5:
            int r107 = 0;
        L6:
            if (r104 == 0) goto L14;
            int r108 = r102.decodeElementIndex(r101);
            if (r108 != (-1)) goto L9;
            r104 = 0;
            goto L6
        L9:
            if (r108 != 0) goto L12;
            r105 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), r105);
            r107 = r107 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r108);
        L14:
            r104 = r107;
            r106 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f500083b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = c.f500080b;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f500081a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (Intrinsics.areEqual(r102.f500081a, CollectionsKt.emptyList()) == false) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f500082a;
        }
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f500081a, ((c) r100).f500081a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<j> r100 = this.f500081a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ActionBarGradientConfig(gradientStyleList=" + this.f500081a + ')';
    }

    static {
        Companion = new b();
        f500080b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new jq9.b())};
    }

    public /* synthetic */ c(int r100) {
        this(CollectionsKt.emptyList());
    }

    public c(List<j> r100) {
        this.f500081a = r100;
    }

    public c(int r100, List r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f500083b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f500081a = CollectionsKt.emptyList();
        return;
    L7:
        this.f500081a = r101;
    }
}
