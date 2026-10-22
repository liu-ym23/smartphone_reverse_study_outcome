package ouc;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.json.internal.j0;
import kotlinx.serialization.json.internal.m0;
import kotlinx.serialization.json.internal.n0;
import kotlinx.serialization.json.internal.r0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements juc.y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C7114a f526798d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f526799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.modules.d f526800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.serialization.json.internal.p f526801c;

    /* JADX INFO: renamed from: ouc.a$a, reason: collision with other inner class name */
    public static final class C7114a extends a {
        public C7114a() {
            super(new f(false, false, false, false, false, true, LineContent.FOUR_SPACE, false, false, "type", false, true, false, false, false, ClassDiscriminatorMode.POLYMORPHIC), kotlinx.serialization.modules.i.f505488a);
        }
    }

    static {
        f526798d = new C7114a();
    }

    @Override // juc.m
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.f526800b;
    }

    public final i e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return (i) c(r.f526859a, r100);
    }

    public a(f r100, kotlinx.serialization.modules.d r101) {
        this.f526799a = r100;
        this.f526800b = r101;
        this.f526801c = new kotlinx.serialization.json.internal.p();
    }

    @Override // juc.y
    public final <T> String a(juc.n<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "serializer");
        kotlinx.serialization.json.internal.z r102 = new kotlinx.serialization.json.internal.z();
        kotlinx.serialization.json.internal.y.a(this, r102, r100, r101);     // Catch: Throwable -> L6
        String r103 = r102.toString();     // Catch: Throwable -> L6
        r102.e();
        return r103;
    L6:
        th = move-exception;
        r102.e();
        throw th;
    }

    public final <T> T b(juc.c<? extends T> r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        Intrinsics.checkNotNullParameter(r101, "element");
        Intrinsics.checkNotNullParameter(this, "json");
        Intrinsics.checkNotNullParameter(r101, "element");
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        String r102 = null;
        if ((r101 instanceof d0) == false) goto L6;
        muc.e r103 = new kotlinx.serialization.json.internal.a0(this, (d0) r101, r102, 12);
    L17:
        return (T) r103.decodeSerializableValue(r100);
    L6:
        if ((r101 instanceof b) == false) goto L9;
        r103 = new kotlinx.serialization.json.internal.c0(this, (b) r101);
        goto L17
    L9:
        if ((r101 instanceof x) == false) goto L11;
    L15:
        r103 = new kotlinx.serialization.json.internal.w(this, (g0) r101, null);
        goto L17
    L11:
        if (Intrinsics.areEqual(r101, a0.INSTANCE) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T c(juc.c<? extends T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        Intrinsics.checkNotNullParameter(r101, "string");
        Intrinsics.checkNotNullParameter(this, "json");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (this.f526799a.f526846o == true) goto L5;
        m0 r102 = new m0(r101);
    L6:
        T r103 = (T) new j0(this, WriteMode.OBJ, r102, r100.getDescriptor(), null).decodeSerializableValue(r100);
        if (r102.e() != 10) goto L9;
        return r103;
    L9:
        kotlinx.serialization.json.internal.a.m(r102, "Expected EOF after parsing, but had " + r102.f505447e.charAt(r102.f505376a - 1) + " instead", 0, null, 6);
        throw null;
    L5:
        r102 = new n0(r101);
        goto L6
    }

    public final <T> i d(juc.n<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "serializer");
        return r0.a(this, r101, r100);
    }
}
