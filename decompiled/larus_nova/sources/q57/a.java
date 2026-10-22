package q57;

import android.app.Application;
import android.database.CursorWindow;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.PluginState;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends t57.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f531744a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f531745b;

    @Override // t57.a
    public final String b() {
        return "CursorWindowPlugin";
    }

    @Override // t57.a
    public final void d() {
        PluginState r100 = PluginState.INITIALIZED;
        Field r101 = u57.a.a(CursorWindow.class, "sCursorWindowSize");
        f531745b = r101;
        if (r101 == null) goto L31;
        r101.setAccessible(true);
        Field r102 = f531745b;     // Catch: IllegalAccessException -> L32
        if (r102 == null) goto L30;
        if (r102.isAccessible() == true) goto L11;
        r102.setAccessible(true);     // Catch: IllegalAccessException -> L32
    L11:
        int r103 = ((Integer) r102.get(null)).intValue();     // Catch: IllegalAccessException -> L32
        f531744a = r103;     // Catch: IllegalAccessException -> L32
        if (r103 == 1048576) goto L21;
        Field r104 = f531745b;     // Catch: IllegalAccessException -> L32
        if (r104 == null) goto L20;
        if (r104.isAccessible() == true) goto L18;
        r104.setAccessible(true);     // Catch: IllegalAccessException -> L32
    L18:
        r104.set(null, 1048576);     // Catch: IllegalAccessException -> L32
        goto L21
    L20:
        throw new IllegalArgumentException("The field must not be null");     // Catch: IllegalAccessException -> L32
    L21:
        Field r105 = f531745b;     // Catch: IllegalAccessException -> L32
        if (r105 == null) goto L28;
        if (r105.isAccessible() == true) goto L26;
        r105.setAccessible(true);     // Catch: IllegalAccessException -> L32
    L26:
        Logger.a("CursorWindowPlugin", "Resize cursor window size successful! Resize form :" + f531744a + "to " + ((Integer) r105.get(null)).intValue());     // Catch: IllegalAccessException -> L32
        return;
    L28:
        throw new IllegalArgumentException("The field must not be null");     // Catch: IllegalAccessException -> L32
    L30:
        throw new IllegalArgumentException("The field must not be null");     // Catch: IllegalAccessException -> L32
    L35:
        return;
    }

    public a() {
    }

    @Override // t57.a
    public final void c(Application r100) {
        PluginState r101 = PluginState.INITIALIZED;
    }
}
