package yx5;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.utils.TTReflectException;
import com.bytedance.frameworks.baselib.network.utils.TTReflectIOException;
import com.bytedance.retrofit2.NetworkLibLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f569415a;

    /* JADX INFO: renamed from: yx5.a$a, reason: collision with other inner class name */
    public static class C8397a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Reflect f569416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RetrofitMetrics f569417b;

        @Override // yx5.a.b
        public final <T> T get() {
            return (T) this.f569416a.get();
        }

        @Override // yx5.a.b
        public b call(String r110) throws TTReflectIOException {
            long r100 = System.nanoTime();
            this.f569416a = this.f569416a.call(r110);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r111 = this.f569417b;
            if (r111 == null) goto L10;
            NetworkLibLayerMetrics.ImportantInnerSpan r112 = r111.networklib.innerSpan;
            if (r112.reflection != (-1)) goto L9;
            r112.reflection = 0;
        L9:
            r112.reflection += System.nanoTime() - r100;
        L10:
            return this;
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r101 = this.f569417b;
            if (r101 == null) goto L22;
            NetworkLibLayerMetrics.ImportantInnerSpan r102 = r101.networklib.innerSpan;
            if (r102.reflection != (-1)) goto L21;
            r102.reflection = 0;
        L21:
            r102.reflection += System.nanoTime() - r100;
        L22:
            throw th;
        }

        public C8397a(Reflect r100, RetrofitMetrics r101) {
            this.f569416a = r100;
            this.f569417b = r101;
        }

        @Override // yx5.a.b
        public b call(String r100, Class<?>[] r110, Object... r111) throws TTReflectIOException {
            long r101 = System.nanoTime();
            this.f569416a = this.f569416a.call(r100, r110, r111);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r102 = this.f569417b;
            if (r102 == null) goto L10;
            NetworkLibLayerMetrics.ImportantInnerSpan r103 = r102.networklib.innerSpan;
            if (r103.reflection != (-1)) goto L9;
            r103.reflection = 0;
        L9:
            r103.reflection += System.nanoTime() - r101;
        L10:
            return this;
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r112 = this.f569417b;
            if (r112 == null) goto L22;
            NetworkLibLayerMetrics.ImportantInnerSpan r113 = r112.networklib.innerSpan;
            if (r113.reflection != (-1)) goto L21;
            r113.reflection = 0;
        L21:
            r113.reflection += System.nanoTime() - r101;
        L22:
            throw th;
        }
    }

    public interface b {
        b call(String r100) throws TTReflectIOException;

        b call(String r100, Class<?>[] r101, Object... r102) throws TTReflectIOException;

        <T> T get();
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public yx5.b f569418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RetrofitMetrics f569419b;

        @Override // yx5.a.b
        public final <T> T get() {
            return (T) this.f569418a.f569421a;
        }

        @Override // yx5.a.b
        public b call(String r110) throws TTReflectIOException {
            long r100 = System.nanoTime();
            this.f569418a = this.f569418a.call(r110);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r111 = this.f569419b;
            if (r111 == null) goto L10;
            NetworkLibLayerMetrics.ImportantInnerSpan r112 = r111.networklib.innerSpan;
            if (r112.reflection != (-1)) goto L9;
            r112.reflection = 0;
        L9:
            r112.reflection += System.nanoTime() - r100;
        L10:
            return this;
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r101 = this.f569419b;
            if (r101 == null) goto L22;
            NetworkLibLayerMetrics.ImportantInnerSpan r102 = r101.networklib.innerSpan;
            if (r102.reflection != (-1)) goto L21;
            r102.reflection = 0;
        L21:
            r102.reflection += System.nanoTime() - r100;
        L22:
            throw th;
        }

        public c(yx5.b r100, RetrofitMetrics r101) {
            this.f569418a = r100;
            this.f569419b = r101;
        }

        @Override // yx5.a.b
        public b call(String r100, Class<?>[] r110, Object... r111) throws TTReflectIOException {
            long r101 = System.nanoTime();
            this.f569418a = this.f569418a.call(r100, r110, r111);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r102 = this.f569419b;
            if (r102 == null) goto L10;
            NetworkLibLayerMetrics.ImportantInnerSpan r103 = r102.networklib.innerSpan;
            if (r103.reflection != (-1)) goto L9;
            r103.reflection = 0;
        L9:
            r103.reflection += System.nanoTime() - r101;
        L10:
            return this;
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r112 = this.f569419b;
            if (r112 == null) goto L22;
            NetworkLibLayerMetrics.ImportantInnerSpan r113 = r112.networklib.innerSpan;
            if (r113.reflection != (-1)) goto L21;
            r113.reflection = 0;
        L21:
            r113.reflection += System.nanoTime() - r101;
        L22:
            throw th;
        }
    }

    public static b a(Class<?> r100) throws TTReflectIOException {
    L5:
        e = move-exception;
    L11:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L10:
        throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Exception -> L11
    L3:
        if (f569415a == false) goto L8;
        return new c(new yx5.b(r100), null);
    L8:
        return new C8397a(Reflect.on(r100), null);
    }

    public static b b(Object r100) throws TTReflectIOException {
        return c(r100, null);
    L5:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    }

    public static b d(String r100) throws TTReflectIOException {
    L8:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L3:
        if (f569415a == false) goto L7;
        return new c(yx5.b.g(r100), null);
    L7:
        return new C8397a(Reflect.on(r100), null);
    }

    public static b c(Object r100, RetrofitMetrics r101) throws TTReflectIOException {
    L12:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L3:
        if (f569415a == false) goto L11;
        if (r100 != null) goto L7;
        Map<String, Method> r102 = yx5.b.f569420c;     // Catch: Exception -> L12
        throw new TTReflectException("Instance object cannot be null");     // Catch: Exception -> L12
    L7:
        return new c(new yx5.b(r100), r101);
    L11:
        return new C8397a(Reflect.on(r100), r101);
    }
}
