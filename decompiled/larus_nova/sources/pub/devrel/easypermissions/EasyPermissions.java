package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import bxc.e;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class EasyPermissions {
    private static final String TAG = "EasyPermissions";

    public interface PermissionCallbacks extends ActivityCompat.OnRequestPermissionsResultCallback {
        void d0();

        void p1();
    }

    public interface a {
        void a();

        void b();
    }

    public EasyPermissions() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_pub_devrel_easypermissions_EasyPermissions_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private static boolean isUsingAndroidAnnotations(Object r100) {
        if (r100.getClass().getSimpleName().endsWith("_") == true) goto L8;
        return false;
    L8:
        return INVOKESTATIC_pub_devrel_easypermissions_EasyPermissions_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("org.androidannotations.api.view.HasViews").isInstance(r100);
    L7:
        return false;
    }

    public static void requestPermissions(axc.a r100) {
        if (hasPermissions(r100.f16649a.getContext(), (String[]) r100.f16650b.clone()) == false) goto L6;
        notifyAlreadyHasPermissions(r100.f16649a.f21384a, r100.f16651c, (String[]) r100.f16650b.clone());
        return;
    L6:
        r100.f16649a.requestPermissions(r100.f16652d, r100.f16653e, r100.f16654f, r100.f16655g, r100.f16651c, (String[]) r100.f16650b.clone());
    }

    public static boolean hasPermissions(Context r100, String... r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        if (r100 == null) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        if (ContextCompat.checkSelfPermission(r100, r101[r103]) != 0) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    L14:
        throw new IllegalArgumentException("Can't check permissions for null context");
    }

    public static boolean permissionPermanentlyDenied(Activity r100, String r101) {
        return !e.b(r100).e(r101);
    }

    private static void runAnnotatedMethods(Object r100, int r101) {
        Class<?> r102 = r100.getClass();
        if (isUsingAndroidAnnotations(r100) == false) goto L5;
        r102 = r102.getSuperclass();
    L5:
        if (r102 == null) goto L23;
        Method[] r103 = r102.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L22;
        Method r106 = r103[r105];
        AfterPermissionGranted r107 = (AfterPermissionGranted) r106.getAnnotation(AfterPermissionGranted.class);
        if (r107 == null) goto L21;
        if (r107.value() != r101) goto L21;
        if (r106.getParameterTypes().length > 0) goto L20;
        if (r106.isAccessible() == true) goto L17;
        r106.setAccessible(true);     // Catch: Throwable -> L24
    L17:
        r106.invoke(r100, new Object[0]);     // Catch: Throwable -> L24
        goto L21
    L20:
        throw new RuntimeException("Cannot execute method " + r106.getName() + " because it is non-void method and/or has input parameters.");
    L21:
        r105 = r105 + 1;
        goto L7
    L22:
        r102 = r102.getSuperclass();
        goto L5
    }

    public static boolean somePermissionDenied(Activity r100, String... r101) {
        return e.b(r100).d(r101);
    }

    public static boolean somePermissionPermanentlyDenied(Activity r100, List<String> r101) {
        e<? extends Activity> r102 = e.b(r100);
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if ((!r102.e(r103.next())) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public static boolean permissionPermanentlyDenied(Fragment r100, String r101) {
        return !e.c(r100).e(r101);
    }

    public static boolean somePermissionDenied(Fragment r100, String... r101) {
        return e.c(r100).d(r101);
    }

    public static boolean somePermissionPermanentlyDenied(Fragment r100, List<String> r101) {
        e<Fragment> r102 = e.c(r100);
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if ((!r102.e(r103.next())) == false) goto L4;
        return true;
    L8:
        return false;
    }

    private static void notifyAlreadyHasPermissions(Object r100, int r101, String[] r102) {
        int[] r103 = new int[r102.length];
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L6;
        r103[r104] = 0;
        r104 = r104 + 1;
        goto L4
    L6:
        onRequestPermissionsResult(r101, r102, r103, new Object[]{r100});
    }

    public static void onRequestPermissionsResult(int r100, String[] r101, int[] r102, Object... r103) {
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r107 >= r101.length) goto L10;
        String r108 = r101[r107];
        if (r102[r107] != 0) goto L8;
        r104.add(r108);
    L9:
        r107 = r107 + 1;
        goto L4
    L8:
        r105.add(r108);
        goto L9
    L10:
        int r109 = r103.length;
    L11:
        if (r106 >= r109) goto L28;
        Object r110 = r103[r106];
        if (r104.isEmpty() == true) goto L18;
        if ((r110 instanceof PermissionCallbacks) == false) goto L18;
        ((PermissionCallbacks) r110).d0();
    L18:
        if (r105.isEmpty() == true) goto L23;
        if ((r110 instanceof PermissionCallbacks) == false) goto L23;
        ((PermissionCallbacks) r110).p1();
    L23:
        if (r104.isEmpty() == true) goto L27;
        if (r105.isEmpty() == false) goto L27;
        runAnnotatedMethods(r110, r100);
    L27:
        r106 = r106 + 1;
        goto L11
    }

    public static void requestPermissions(Activity r100, String r101, int r110, String... r111) {
        e<? extends Activity> r102 = e.b(r100);
        if (r101 != null) goto L5;
        r101 = r102.getContext().getString(R.string.rationale_ask);
    L5:
        requestPermissions(new axc.a(r102, r111, r110, r101, r102.getContext().getString(android.R.string.ok), r102.getContext().getString(android.R.string.cancel), -1));
    }

    public static void requestPermissions(Fragment r100, String r101, int r110, String... r111) {
        e<Fragment> r102 = e.c(r100);
        if (r101 != null) goto L5;
        r101 = r102.getContext().getString(R.string.rationale_ask);
    L5:
        requestPermissions(new axc.a(r102, r111, r110, r101, r102.getContext().getString(android.R.string.ok), r102.getContext().getString(android.R.string.cancel), -1));
    }
}
