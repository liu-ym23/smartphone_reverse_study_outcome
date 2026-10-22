package o8;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.env.api.EnvManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Boolean f522321c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f522322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f522323b;

    public static final class a {
        public static Pair b() {
            if (c.f522321c == null) goto L5;
        L20:
            Boolean r100 = c.f522321c;
            Boolean r101 = Boolean.FALSE;
            if (Intrinsics.areEqual(r100, r101) == true) goto L23;
            EnvManager.Companion.getClass();
            AccessKeyType r102 = EnvManager.a.a().getGeckoConfig().a();
            boolean r103 = false;
            if (r102 != AccessKeyType.INHOUSE) goto L37;
            boolean r104 = true;
        L38:
            Boolean r105 = Boolean.valueOf(r104);
            if (r102 != AccessKeyType.BOE) goto L42;
            r103 = true;
        L42:
            return new Pair(r105, Boolean.valueOf(r103));
        L37:
            r104 = false;
            goto L38
        L23:
            if (com.bytedance.android.annie.ng.g.f39675g == false) goto L28;
            if (com.bytedance.android.annie.ng.g.b().f39657a.f522323b == false) goto L28;
            return new Pair(r101, Boolean.TRUE);
        L28:
            if (com.bytedance.android.annie.ng.g.f39675g == false) goto L33;
            if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L33;
            return new Pair(Boolean.TRUE, r101);
        L33:
            return new Pair(r101, r101);
        L5:
            monitor-enter(c.class);
        L17:
            th = move-exception;
            throw th;
        L7:
            if (c.f522321c != null) goto L14;
            Boolean r106 = c.f522321c;     // Catch: Throwable -> L17
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L11
            a("com.bytedance.env.api.GeckoConfig");     // Catch: Throwable -> L11
            Object r108 = Result.m9449constructorimpl(a("com.bytedance.env.core.impl.EnvManagerApiImpl"));     // Catch: Throwable -> L11
        L13:
            c.f522321c = Boolean.valueOf(Result.m9456isSuccessimpl(r108));     // Catch: Throwable -> L17
            goto L14
        L11:
            th = move-exception;
            Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L17
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        L14:
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(c.class);
            goto L20
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
    }

    static {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f522322a == r101.f522322a) goto L12;
        return false;
    L12:
        if (this.f522323b == r101.f522323b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f522322a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f522323b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "EnvInfo(isDebug=" + this.f522322a + ", isBoe=" + this.f522323b + ')';
    }

    public c(int r100) {
        this.f522322a = true;
        this.f522323b = false;
    }
}
