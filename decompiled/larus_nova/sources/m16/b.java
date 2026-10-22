package m16;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "only for transmit data,not recommend for control bullet load")
public final class b implements c36.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, c<?>> f511604a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<T> f511605a;

        @Override // com.bytedance.ies.bullet.service.base.i0
        public final void release() {
        }

        @Override // m16.c
        public final T provideInstance() {
            return this.f511605a.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends T> r100) {
            this.f511605a = r100;
        }
    }

    public final void h() {
        ((ConcurrentHashMap) this.f511604a).clear();
    }

    public b() {
        this.f511604a = new ConcurrentHashMap();
    }

    public final <T> c<T> a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        c<T> r101 = (c) ((ConcurrentHashMap) this.f511604a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101;
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        Map<Class<?>, c<?>> r101 = this.f511604a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.putAll(r100.f511604a);
    }

    public final <T> T c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        c r101 = (c) ((ConcurrentHashMap) this.f511604a).get(r100);
        if (r101 == null) goto L13;
        Object r102 = r101.provideInstance();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return (T) r102;
    L13:
        return null;
    }

    public final <T> void i(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        c r101 = (c) ((ConcurrentHashMap) this.f511604a).get(r100);
        if (r101 == null) goto L5;
        r101.release();
    L5:
        ((ConcurrentHashMap) this.f511604a).remove(r100);
    }

    public final <T> void d(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        f(r100, new m16.a(r101));
    }

    public final <T> void e(Class<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        c r102 = (c) ((ConcurrentHashMap) this.f511604a).get(r100);
        if (r102 == null) goto L5;
        r102.release();
    L5:
        Map<Class<?>, c<?>> r103 = this.f511604a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r100, new a(r101));
    }

    public final <T> void f(Class<T> r100, c<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        c<? extends T> r102 = (c) ((ConcurrentHashMap) this.f511604a).get(r100);
        if (r102 == null) goto L12;
        if (r102 != r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        r102.release();
        goto L12
    L6:
        r103 = false;
    L12:
        ((ConcurrentHashMap) this.f511604a).put(r100, r101);
    }

    public final <T> void g(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        f(r100, new d(r101));
    }
}
