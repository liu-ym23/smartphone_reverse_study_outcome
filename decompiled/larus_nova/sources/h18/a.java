package h18;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f483536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f483537b = null;

    static {
        f483536a = new Rect();
        f483537b = a();     // Catch: ClassNotFoundException -> L5
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.graphics.Insets");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.graphics.Insets");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.graphics.Insets");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.graphics.Insets");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.graphics.Insets");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.graphics.Insets");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.graphics.Insets");
    }

    public static Rect b(Drawable r110) {
        Class<?> r100 = f483537b;
        if (r100 == null) goto L36;
        Drawable r111 = DrawableCompat.unwrap(r110);     // Catch: Exception -> L37
        Object r112 = r111.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(r111, new Object[0]);     // Catch: Exception -> L37
        if (r112 == null) goto L36;
        Rect r101 = new Rect();     // Catch: Exception -> L37
        Field[] r102 = r100.getFields();     // Catch: Exception -> L37
        int r103 = r102.length;     // Catch: Exception -> L37
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L34;
        Field r105 = r102[r104];     // Catch: Exception -> L37
        String r106 = r105.getName();     // Catch: Exception -> L37
        switch(r106.hashCode()) {
            case -1383228885: goto L21;
            case 115029: goto L18;
            case 3317767: goto L15;
            case 108511772: goto L12;
            default: goto L23;
        };     // Catch: Exception -> L37
    L23:
        byte r107 = -1;
    L24:
        if (r107 == 0) goto L32;
        if (r107 == 1) goto L31;
        if (r107 == 2) goto L30;
        if (r107 != 3) goto L33;
        r101.bottom = r105.getInt(r112);     // Catch: Exception -> L37
    L33:
        r104 = r104 + 1;
        goto L7
    L30:
        r101.right = r105.getInt(r112);     // Catch: Exception -> L37
        goto L33
    L31:
        r101.top = r105.getInt(r112);     // Catch: Exception -> L37
        goto L33
    L32:
        r101.left = r105.getInt(r112);     // Catch: Exception -> L37
        goto L33
    L12:
        if (r106.equals("right") == false) goto L23;
        r107 = 2;
        goto L24
    L15:
        if (r106.equals("left") == false) goto L23;
        r107 = 0;
        goto L24
    L18:
        if (r106.equals("top") == false) goto L23;
        r107 = 1;
        goto L24
    L21:
        if (r106.equals("bottom") == false) goto L23;
        r107 = 3;
        goto L24
    L34:
        return r101;
    L36:
        return f483536a;
    }
}
