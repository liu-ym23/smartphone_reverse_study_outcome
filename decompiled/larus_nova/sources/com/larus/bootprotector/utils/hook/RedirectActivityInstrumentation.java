package com.larus.bootprotector.utils.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.vivo.push.PushClientConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0003\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bootprotector/utils/hook/RedirectActivityInstrumentation;", "Landroid/app/Instrumentation;", "mInstrumentation", "redirect", "Lcom/larus/bootprotector/utils/hook/RedirectActivityInstrumentation$IActivityRedirect;", "<init>", "(Landroid/app/Instrumentation;Lcom/larus/bootprotector/utils/hook/RedirectActivityInstrumentation$IActivityRedirect;)V", "mActivityRedirect", "newActivity", "Landroid/app/Activity;", "cl", "Ljava/lang/ClassLoader;", PushClientConstants.TAG_CLASS_NAME, "", "intent", "Landroid/content/Intent;", "IActivityRedirect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedirectActivityInstrumentation extends Instrumentation {
    public static final a Companion = null;
    private static final String TAG = "RedirectActivityInstru";
    private final b mActivityRedirect;
    private final Instrumentation mInstrumentation;

    public static final class a {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.app.ActivityThread");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.app.ActivityThread");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.app.ActivityThread");
        }

        public a() {
        }
    }

    public interface b {
        String a(String r100, Intent r101);
    }

    static {
        Companion = new a();
    }

    public /* synthetic */ RedirectActivityInstrumentation(Instrumentation r100, b r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    private RedirectActivityInstrumentation(Instrumentation r100, b r101) {
        this.mInstrumentation = r100;
        this.mActivityRedirect = r101;
    }

    private final String redirect(String r100, Intent r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L10;
        b r102 = this.mActivityRedirect;
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102.a(r100, r101);
    L10:
        return r100;
    L9:
        return r100;
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader r100, String r101, Intent r102) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Intrinsics.checkNotNullParameter(r100, "cl");
        Intrinsics.checkNotNullParameter(r101, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r102, "intent");
        String r103 = redirect(r101, r102);
        return this.mInstrumentation.newActivity(r100, r103, r102);
    }
}
