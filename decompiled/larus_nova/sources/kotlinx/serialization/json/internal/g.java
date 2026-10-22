package kotlinx.serialization.json.internal;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import nuc.n1;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public abstract class g extends n1 implements ouc.u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ouc.a f505405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ouc.i, Unit> f505406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ouc.f f505407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f505408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f505409f;

    @Override // muc.f
    public final void encodeNotNullMark() {
    }

    public abstract ouc.i q();

    public abstract void r(String r100, ouc.i r101);

    @Override // muc.f
    public final void encodeNull() {
        String r100 = (String) CollectionsKt.lastOrNull(this.f520801a);
        if (r100 != null) goto L6;
        this.f505406c.invoke(ouc.a0.INSTANCE);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "tag");
        r(r100, ouc.a0.INSTANCE);
    }

    @Override // muc.f
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.f505405b.f526800b;
    }

    @Override // ouc.u
    public final ouc.a getJson() {
        return this.f505405b;
    }

    @Override // ouc.u
    public final void a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (this.f505408e != null) goto L5;
    L9:
        encodeSerializableValue(ouc.r.f526859a, r100);
        return;
    L5:
        if ((r100 instanceof ouc.d0) == true) goto L9;
        h0.d(this.f505409f, r100);
        throw null;
    }

    @Override // muc.f
    public final muc.d beginStructure(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (CollectionsKt.lastOrNull(this.f520801a) != null) goto L5;
        Function1<ouc.i, Unit> r101 = this.f505406c;
    L6:
        luc.o r102 = r100.getKind();
        if (Intrinsics.areEqual(r102, luc.p.b.f510878a) == false) goto L9;
    L25:
        g r103 = new d0(this.f505405b, r101);
    L26:
        String r104 = this.f505408e;
        if (r104 != null) goto L29;
    L39:
        return r103;
    L29:
        if ((r103 instanceof f0) == false) goto L34;
        f0 r105 = (f0) r103;
        r105.r("key", ouc.k.c(r104));
        String r106 = this.f505409f;
        if (r106 != null) goto L33;
        r106 = r100.f();
    L33:
        r105.r("value", ouc.k.c(r106));
    L38:
        this.f505408e = null;
        this.f505409f = null;
        goto L39
    L34:
        String r107 = this.f505409f;
        if (r107 != null) goto L37;
        r107 = r100.f();
    L37:
        r103.r(r104, ouc.k.c(r107));
        goto L38
    L9:
        if ((r102 instanceof luc.d) == true) goto L25;
        if (Intrinsics.areEqual(r102, luc.p.c.f510879a) == false) goto L24;
        ouc.a r108 = this.f505405b;
        luc.f r109 = s0.a(r100.h(0), r108.f526800b);
        luc.o r110 = r109.getKind();
        if ((r110 instanceof luc.e) == false) goto L16;
    L23:
        r103 = new f0(this.f505405b, r101);
        goto L26
    L16:
        if (Intrinsics.areEqual(r110, luc.o.b.f510876a) == true) goto L23;
        if (r108.f526799a.f526835d == false) goto L22;
        r103 = new d0(this.f505405b, r101);
        goto L26
    L22:
        throw s.b(r109);
    L24:
        r103 = new b0(this.f505405b, r101);
        goto L26
    L5:
        r101 = new d(this);
        goto L6
    }

    @Override // nuc.x2, muc.f
    public final muc.f encodeInline(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (CollectionsKt.lastOrNull(this.f520801a) == null) goto L9;
        if (this.f505408e == null) goto L10;
        this.f505409f = r100.f();
    L10:
        return super.encodeInline(r100);
    L9:
        return new x(this.f505405b, this.f505406c).encodeInline(r100);
    }

    @Override // nuc.x2
    public final void m(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        this.f505406c.invoke(q());
    }

    public g(ouc.a r100, Function1 r101) {
        this.f505405b = r100;
        this.f505406c = r101;
        this.f505407d = r100.f526799a;
    }

    @Override // nuc.x2
    public final void b(String r100, boolean r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.a(Boolean.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void c(String r100, byte r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Byte.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void d(String r100, char r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.c(String.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void e(String r100, double r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Double.valueOf(r101)));
        if (this.f505407d.f526842k == false) goto L5;
        return;
    L5:
        if (Double.isInfinite(r101) == false) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L15;
        Double r104 = Double.valueOf(r101);
        String r105 = q().toString();
        Intrinsics.checkNotNullParameter(r104, "value");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_OUTPUT);
        throw new JsonEncodingException(s.h(r104, r102, r105));
    L15:
        return;
    L7:
        if (Double.isNaN(r101) == true) goto L9;
        r103 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.x2, muc.f
    public final <T> void encodeSerializableValue(juc.n<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "serializer");
        boolean r102 = false;
        if (CollectionsKt.lastOrNull(this.f520801a) != null) goto L14;
        luc.f r103 = s0.a(r100.getDescriptor(), this.f505405b.f526800b);
        if ((r103.getKind() instanceof luc.e) == false) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        new x(this.f505405b, this.f505406c).encodeSerializableValue(r100, r101);
        return;
    L7:
        if (r103.getKind() == luc.o.b.f510876a) goto L10;
        r104 = false;
    L14:
        ouc.f r105 = this.f505405b.f526799a;
        if (r105.f526840i == false) goto L17;
        r100.serialize(this, r101);
        return;
    L17:
        boolean r106 = r100 instanceof nuc.b;
        if (r106 == true) goto L20;
        int r107 = h0.a.f505415a[r105.f526847p.ordinal()];
        if (r107 != 1) goto L25;
    L35:
        if (r102 == false) goto L37;
        String r108 = h0.c(r100.getDescriptor(), this.f505405b);
    L38:
        if (r106 == false) goto L47;
        nuc.b r109 = (nuc.b) r100;
        if (r101 == 0) goto L46;
        juc.n<? super T> r110 = juc.h.b(r109, this, r101);
        if (r108 == null) goto L44;
        h0.a(r100, r110, r108);
    L44:
        h0.b(r110.getDescriptor().getKind());
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
        r100 = r110;
        goto L47
    L46:
        throw new IllegalArgumentException(("Value for serializer " + r109.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
    L47:
        if (r108 == null) goto L49;
        String r111 = r100.getDescriptor().f();
        this.f505408e = r108;
        this.f505409f = r111;
    L49:
        r100.serialize(this, r101);
        return;
    L37:
        r108 = null;
        goto L38
    L25:
        if (r107 == 2) goto L35;
        if (r107 != 3) goto L34;
        luc.o r112 = r100.getDescriptor().getKind();
        if (Intrinsics.areEqual(r112, luc.p.a.f510877a) == false) goto L31;
    L32:
        r102 = true;
        goto L35
    L31:
        if (Intrinsics.areEqual(r112, luc.p.d.f510880a) == false) goto L35;
    L34:
        throw new NoWhenBranchMatchedException();
    L20:
        if (r105.f526847p == ClassDiscriminatorMode.NONE) goto L35;
        goto L35
    }

    @Override // nuc.x2
    public final void g(String r100, float r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Float.valueOf(r101)));
        if (this.f505407d.f526842k == false) goto L5;
        return;
    L5:
        if (Float.isInfinite(r101) == false) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L15;
        Float r104 = Float.valueOf(r101);
        String r105 = q().toString();
        Intrinsics.checkNotNullParameter(r104, "value");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_OUTPUT);
        throw new JsonEncodingException(s.h(r104, r102, r105));
    L15:
        return;
    L7:
        if (Float.isNaN(r101) == true) goto L9;
        r103 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // nuc.x2
    public final muc.f h(String r100, luc.f r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r101, "inlineDescriptor");
        if (l0.a(r101) == true) goto L15;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.isInline() == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L16;
        Intrinsics.checkNotNullParameter(r101, "inlineDescriptor");
        this.f520801a.add((Tag) r102);
        return this;
    L16:
        return new e(this, r102, r101);
    L8:
        if (Intrinsics.areEqual(r101, ouc.k.f526858a) == false) goto L10;
        r103 = true;
        goto L11
    L15:
        return new f(this, r102);
    }

    @Override // nuc.x2
    public final void i(String r100, int r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Integer.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void j(String r100, long r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Long.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void k(String r100, short r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        r(r102, ouc.k.b(Short.valueOf(r101)));
    }

    @Override // nuc.x2
    public final void l(String r100, String r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r101, "value");
        r(r102, ouc.k.c(r101));
    }

    @Override // nuc.n1
    public String p(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        ouc.a r102 = this.f505405b;
        p.a<Map<String, Integer>> r103 = u.f505459a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "json");
        u.e(r100, r102);
        return r100.b(r101);
    }

    @Override // muc.d
    public final boolean shouldEncodeElementDefault(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return this.f505407d.f526832a;
    }

    @Override // nuc.x2
    public final void f(String r100, luc.f r101, int r102) {
        String r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "tag");
        Intrinsics.checkNotNullParameter(r101, "enumDescriptor");
        r(r103, ouc.k.c(r101.b(r102)));
    }
}
