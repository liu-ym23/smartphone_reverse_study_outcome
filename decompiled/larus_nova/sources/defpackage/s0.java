package defpackage;

import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.context.internal.VStateImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import m1a.c;
import t1a.b;
import t1a.e;
import t1a.f;

/* JADX INFO: loaded from: classes42.dex */
public final class s0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<?>, t1a.a> f539988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<?>, e<?>> f539989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<?>, c<?>> f539990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s0 f539991d;

    public static final class a {
    }

    static {
    }

    public s0() {
        this.f539988a = new LinkedHashMap();
        this.f539989b = new LinkedHashMap();
        this.f539990c = new LinkedHashMap();
    }

    @Override // t1a.b
    public final <T extends t1a.c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) g(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.a> void b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        l(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.a> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) q(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.c> e<T> e(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return p(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.c> T f(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) r(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.c> T g(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        e<T> r101 = p(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.getSource();
    }

    @Override // t1a.b
    public final <T extends t1a.a> T getAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) o(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends f> c<T> j(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        s0 r101 = this.f539991d;     // Catch: Throwable -> L15
        s0 r102 = this;
    L5:
        if (r102.f539990c.containsKey(r100) == true) goto L8;
        if (r101 == null) goto L8;
        r102 = r101;
        r101 = r101.f539991d;     // Catch: Throwable -> L15
    L8:
        Object r103 = ((LinkedHashMap) r102.f539990c).get(r100);     // Catch: Throwable -> L15
        if ((r103 instanceof c) == false) goto L11;
        c<T> r104 = (c) r103;     // Catch: Throwable -> L15
    L12:
        if (r104 != null) goto L14;
        int r105 = y1a.a.f565679a;     // Catch: Throwable -> L15
        y1a.a.b("VContext", "find data " + r100.getQualifiedName() + " null");     // Catch: Throwable -> L15
        y1a.a.c(new NullPointerException(), "find " + r100 + " null");     // Catch: Throwable -> L15
    L14:
        return r104;
    L11:
        r104 = null;
    L16:
        throw new IllegalStateException("stack over flow when get data");
    }

    @Override // t1a.b
    public final <T extends t1a.a> void l(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f539988a.remove(r100);
    }

    @Override // t1a.b
    public final <T extends t1a.c> void m(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        s(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.a> T o(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        s0 r101 = this.f539991d;     // Catch: Throwable -> L22
        s0 r102 = this;
    L5:
        if (r102.f539988a.containsKey(r100) == true) goto L8;
        if (r101 == null) goto L8;
        r102 = r101;
        r101 = r101.f539991d;     // Catch: Throwable -> L22
    L8:
        Object r103 = ((LinkedHashMap) r102.f539988a).get(r100);     // Catch: Throwable -> L22
        if ((r103 instanceof t1a.a) == false) goto L11;
        T r104 = (T) r103;     // Catch: Throwable -> L22
    L12:
        if (r104 != null) goto L17;
        int r105 = y1a.a.f565679a;     // Catch: Throwable -> L22
        String r106 = "find ability " + r100.getQualifiedName() + " null";     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter("VContext", "tag");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r106, "msg");     // Catch: Throwable -> L22
        x1a.b r107 = x1a.a.f562152c;     // Catch: Throwable -> L22
        if (r107 == null) goto L17;
        r107.log(4, "Component_VContext", r106);     // Catch: Throwable -> L22
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L17:
        if ((r104 instanceof AttachReceiver) == false) goto L21;
        if (((AttachReceiver) r104).WI() == false) goto L21;
        return null;
    L21:
        return r104;
    L11:
        r104 = null;
    L23:
        throw new IllegalStateException("stack over flow when get ability");
    }

    @Override // t1a.b
    public final <T extends t1a.c> e<T> p(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        s0 r101 = this.f539991d;     // Catch: Throwable -> L15
        s0 r102 = this;
    L5:
        if (r102.f539989b.containsKey(r100) == true) goto L8;
        if (r101 == null) goto L8;
        r102 = r101;
        r101 = r101.f539991d;     // Catch: Throwable -> L15
    L8:
        Object r103 = ((LinkedHashMap) r102.f539989b).get(r100);     // Catch: Throwable -> L15
        if ((r103 instanceof e) == false) goto L11;
        e<T> r104 = (e) r103;     // Catch: Throwable -> L15
    L12:
        if (r104 != null) goto L14;
        int r105 = y1a.a.f565679a;     // Catch: Throwable -> L15
        y1a.a.b("VContext", "find data " + r100.getQualifiedName() + " null");     // Catch: Throwable -> L15
        y1a.a.c(new NullPointerException(), "find " + r100 + " null");     // Catch: Throwable -> L15
    L14:
        return r104;
    L11:
        r104 = null;
    L16:
        throw new IllegalStateException("stack over flow when get data");
    }

    public final <T extends t1a.a> T q(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) o(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("getAbility null " + r100.getSimpleName());
    }

    public final <T extends t1a.c> T r(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) g(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("getData null " + r100.getSimpleName());
    }

    public final <T extends t1a.c> void s(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        e<?> r101 = this.f539989b.remove(r100);
        if (r101 == null) goto L6;
        r101.destroy();
        return;
    }

    @Override // t1a.b
    public final <T extends t1a.a> void c(T r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        k(r100, JvmClassMappingKt.getKotlinClass(r101));
    }

    @Override // t1a.b
    public final <T extends f> void h(KClass<T> r100, c<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "widget");
        this.f539990c.put(r100, r101);
    }

    @Override // t1a.b
    public final <T extends t1a.c> void i(T r100, KClass<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (this.f539989b.containsKey(r101) == false) goto L5;
        s(r101);
    L5:
        this.f539989b.put(r101, new VStateImpl(r100));
    }

    @Override // t1a.b
    public final <T extends t1a.a> void k(T r100, KClass<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (this.f539988a.containsKey(r101) == false) goto L5;
        this.f539988a.remove(r101);
    L5:
        this.f539988a.put(r101, r100);
    }

    @Override // t1a.b
    public final <T extends t1a.c> void n(T r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        i(r100, JvmClassMappingKt.getKotlinClass(r101));
    }
}
