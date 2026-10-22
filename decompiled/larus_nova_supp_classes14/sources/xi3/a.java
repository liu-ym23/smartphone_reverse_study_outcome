package xi3;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements LayoutInflater.Factory2 {
    public final String[] a;
    public final HashMap<String, Constructor<? extends View>> b;

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String r2, Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        return null;
    }

    public a() {
        this.a = new String[]{"android.widget.", "android.view.", "android.webkit."};
        this.b = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r5 = Class.forName(r3, false, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r6 = Class.forName(r3, false, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final View b(Context r6, AttributeSet r7, String r8, String r9) {
        Constructor<? extends View> r0 = this.b.get(r8);
        if (r0 != null) goto L8;
        if (r9 != null) goto L12;
        String r10 = r8;
    L7:
        r0 = a(r10, r6.getClassLoader()).asSubclass(View.class).getConstructor(new Class[]{Context.class, AttributeSet.class});     // Catch: Exception -> L10
        this.b.put(r8, r0);     // Catch: Exception -> L10
        goto L8
    L12:
        r10 = r9 + r8;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        MutableContextWrapper r11 = new MutableContextWrapper(r6);     // Catch: Exception -> L10
        r11.setTheme(r6.getPackageManager().getApplicationInfo(r11.getPackageName(), 0).theme);     // Catch: Exception -> L10
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L10
        return r0.newInstance(new Object[]{r11, r7});
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r8, String r9, Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        if (Intrinsics.areEqual(r9, "view") == false) goto L5;
        String r12 = r11.getAttributeValue(null, "class");
    L7:
        if ((-1) != StringsKt.indexOf$default(r9, '.', 0, false, 6, null)) goto L15;
        int r13 = this.a.length;
        int r1 = 0;
    L9:
        if (r1 >= r13) goto L18;
        View r2 = b(r10, r11, r12, this.a[r1]);
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r2;
    L18:
        return null;
    L15:
        return b(r10, r11, r9, null);
    L5:
        r12 = r9;
        goto L7
    }
}
