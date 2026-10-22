package v74;

import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f553481a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bdinstall.nativeManager.NativeLogManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nativeManager.NativeLogManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdinstall.nativeManager.NativeLogManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bdinstall.nativeManager.NativeLogManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nativeManager.NativeLogManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdinstall.nativeManager.NativeLogManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdinstall.nativeManager.NativeLogManager");
    }

    public d() {
        this.f553481a = null;
        this.f553481a = a();     // Catch: Exception -> L5
        m74.a.a("[dt] ~~~reflect success~~~");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        y74.a.c(DTraitLogLevel.ERROR, "[device]", "DTraitNativeManager", "native反射失败" + e.getMessage(), e);
    }

    public final String b(String[] r100) {
        Class<?> r101 = this.f553481a;
        if (r101 != null) goto L17;
        return "";
    L17:
        int r102 = 0;
        int[] r103 = (int[]) r101.getDeclaredMethod("getDI0Result", new Class[]{String[].class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L16
        if (r103 == null) goto L15;
        if (r103.length <= 0) goto L15;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L16
    L11:
        if (r102 >= r103.length) goto L13;
        r104.put(r100[r102], r103[r102]);     // Catch: Exception -> L16
        r102 = r102 + 1;     // Catch: Exception -> L16
        goto L11
    L13:
        return r104.toString();
    L15:
        return "";
    }

    public final byte[] c(Map r110, int r111, String r112) {
        Class<?> r100 = this.f553481a;
        if (r100 == null) goto L5;
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L11
        byte[] r113 = (byte[]) r100.getDeclaredMethod("getMMMapResult", new Class[]{Map.class, r101, r101, String.class}).invoke(null, new Object[]{r110, Integer.valueOf(r111), 0, r112});     // Catch: Exception -> L11
        if (r113 == null) goto L9;
        return r113;
    L9:
        y74.a.c(DTraitLogLevel.ERROR, "[device]", "DTraitNativeManager", " getMMMapResult map result is null", null);     // Catch: Exception -> L11
        return new byte[0];
    L11:
        e = move-exception;
        y74.a.c(DTraitLogLevel.ERROR, "[device]", "DTraitNativeManager", " getMMMapResult error" + e.getMessage(), e);
        return new byte[0];
    L5:
        return new byte[0];
    }
}
