package yc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<C8324a> f567111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Function0<Unit>> f567112b = null;

    /* JADX INFO: renamed from: yc.a$a, reason: collision with other inner class name */
    public static final class C8324a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f567113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f567114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f567115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f567116d;

        public C8324a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C8324a) == false) goto L14;
            C8324a r101 = (C8324a) r100;
            if (this.f567113a == r101.f567113a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f567114b, r101.f567114b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f567115c, r101.f567115c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f567116d, r101.f567116d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public final int hashCode() {
            boolean r100 = this.f567113a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            Class<?> r103 = this.f567114b;
            int r104 = 0;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            int r106 = (r102 + r105) * 31;
            Class<?> r107 = this.f567115c;
            if (r107 == null) goto L12;
            int r108 = r107.hashCode();
        L13:
            int r109 = (r106 + r108) * 31;
            Object r110 = this.f567116d;
            if (r110 == null) goto L17;
            r104 = r110.hashCode();
        L17:
            return r109 + r104;
        L12:
            r108 = 0;
            goto L13
        L8:
            r105 = 0;
            goto L9
        }

        public final String toString() {
            return "InjectBean(isNoop=" + this.f567113a + ", serviceInterface=" + this.f567114b + ", service=" + this.f567115c + ", instance=" + this.f567116d + ")";
        }

        public C8324a(boolean r100, Class r101, Class r102) {
            this.f567113a = r100;
            this.f567114b = r101;
            this.f567115c = r102;
            this.f567116d = null;
        }
    }

    static {
        f567111a = new CopyOnWriteArrayList();
        f567112b = new LinkedHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void b(Class r100, Class r101) {
        f567111a.add(new C8324a(true, r100, r101));
    }

    public static void c(Class r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Class r103 = a(r101);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Boolean.valueOf(f567111a.add(new C8324a(false, r100, r103))));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
