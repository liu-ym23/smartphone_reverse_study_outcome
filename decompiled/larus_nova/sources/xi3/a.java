package xi3;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f563921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Constructor<? extends View>> f563922b;

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "attrs");
        return null;
    }

    public a() {
        this.f563921a = new String[]{"android.widget.", "android.view.", "android.webkit."};
        this.f563922b = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = Class.forName(r100, false, r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r105 = Class.forName(r100, false, r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public final View b(Context r100, AttributeSet r101, String r102, String r103) {
        Constructor<? extends View> r104 = this.f563922b.get(r102);
        if (r104 != null) goto L8;
        if (r103 != null) goto L12;
        String r105 = r102;
    L7:
        r104 = a(r105, r100.getClassLoader()).asSubclass(View.class).getConstructor(new Class[]{Context.class, AttributeSet.class});     // Catch: Exception -> L10
        this.f563922b.put(r102, r104);     // Catch: Exception -> L10
        goto L8
    L12:
        r105 = r103 + r102;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L10
        r104.setAccessible(true);     // Catch: Exception -> L10
        MutableContextWrapper r106 = new MutableContextWrapper(r100);     // Catch: Exception -> L10
        r106.setTheme(r100.getPackageManager().getApplicationInfo(r106.getPackageName(), 0).theme);     // Catch: Exception -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L10
        return r104.newInstance(new Object[]{r106, r101});
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r100, String r101, Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "attrs");
        if (Intrinsics.areEqual(r101, "view") == false) goto L5;
        String r102 = r111.getAttributeValue(null, "class");
    L7:
        if ((-1) != StringsKt.indexOf$default(r101, '.', 0, false, 6, null)) goto L15;
        int r103 = this.f563921a.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L18;
        View r105 = b(r110, r111, r102, this.f563921a[r104]);
        if (r105 != null) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return r105;
    L18:
        return null;
    L15:
        return b(r110, r111, r101, null);
    L5:
        r102 = r101;
        goto L7
    }
}
