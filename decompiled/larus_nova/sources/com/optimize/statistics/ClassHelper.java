package com.optimize.statistics;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.service.annotation.constants.Constants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class ClassHelper {
    private static final String TAG = "ClassHelper";
    private static Class sCRVClass;
    private static Method sCRVGetChildAdapterPositionMethod;
    private static boolean sHasAndroidXAlertDialog;
    private static boolean sHasAndroidXFragment;
    private static boolean sHasAndroidXFragmentActivity;
    private static boolean sHasAndroidXListMenuItemView;
    private static boolean sHasAndroidXRecyclerView;
    private static boolean sHasAndroidXSwipeRefreshLayoutView;
    private static boolean sHasAndroidXViewPager;
    static boolean sHasCustomRecyclerView;
    private static boolean sHasSupportAlertDialog;
    private static boolean sHasSupportFragment;
    private static boolean sHasSupportFragmentActivity;
    private static boolean sHasSupportListMenuItemView;
    private static boolean sHasSupportRecyclerView;
    private static boolean sHasSupportSwipeRefreshLayoutView;
    private static boolean sHasSupportViewPager;
    private static final boolean sHasTransform = false;

    public ClassHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sHasSupportRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
        sHasSupportViewPager = hasClass("androidx.viewpager.widget.ViewPager");
        sHasSupportSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        sHasSupportFragment = hasClass(Constants.CJPAY_FRAGMENT);
        sHasSupportFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
        sHasSupportAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
        sHasSupportListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");
        sHasAndroidXRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
        sHasAndroidXViewPager = hasClass("androidx.viewpager.widget.ViewPager");
        sHasAndroidXSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        sHasAndroidXFragment = hasClass(Constants.CJPAY_FRAGMENT);
        sHasAndroidXFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
        sHasAndroidXAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
        sHasAndroidXListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");
    }

    public static void dumpClassInfo() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_optimize_statistics_ClassHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    private static Class<?> findRecyclerInSuper(Class<?> r100) {
    L2:
        if (r100 == null) goto L18;
        if (r100.equals(ViewGroup.class) == true) goto L27;
        sCRVGetChildAdapterPositionMethod = r100.getDeclaredMethod("getChildAdapterPosition", new Class[]{View.class});     // Catch: NoSuchMethodException -> L8
    L10:
        if (sCRVGetChildAdapterPositionMethod != null) goto L15;
        sCRVGetChildAdapterPositionMethod = r100.getDeclaredMethod("getChildPosition", new Class[]{View.class});     // Catch: NoSuchMethodException -> L13
    L15:
        if (sCRVGetChildAdapterPositionMethod != null) goto L16;
        r100 = r100.getSuperclass();
        goto L2
    L16:
        return r100;
    L27:
        return null;
    L18:
        return null;
    }

    private static boolean hasClass(String r100) {
        INVOKESTATIC_com_optimize_statistics_ClassHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean instanceOfAndroidXAlertDialog(Object r100) {
        if (sHasAndroidXAlertDialog == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof AlertDialog) == false) goto L7;
        return true;
    }

    public static boolean instanceOfAndroidXFragment(Object r100) {
        if (sHasAndroidXFragment == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof Fragment) == false) goto L7;
        return true;
    }

    public static boolean instanceOfAndroidXFragmentActivity(Object r100) {
        if (sHasAndroidXFragmentActivity == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof FragmentActivity) == false) goto L7;
        return true;
    }

    public static boolean instanceOfAndroidXListMenuItemView(Object r100) {
        if (sHasAndroidXListMenuItemView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof ListMenuItemView) == false) goto L7;
        return true;
    }

    public static boolean instanceOfAndroidXRecyclerView(Object r100) {
        if (sHasAndroidXRecyclerView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof RecyclerView) == false) goto L7;
        return true;
    }

    public static boolean instanceOfAndroidXViewPager(Object r100) {
        if (sHasAndroidXViewPager == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof ViewPager) == false) goto L7;
        return true;
    }

    public static boolean instanceOfRecyclerView(Object r100) {
        if (instanceOfAndroidXRecyclerView(r100) == false) goto L5;
    L13:
        return true;
    L5:
        if (instanceOfSupportRecyclerView(r100) == true) goto L13;
        if (sHasCustomRecyclerView == false) goto L12;
        if (r100 == null) goto L12;
        if (sCRVClass.isAssignableFrom(r100.getClass()) == true) goto L13;
    L12:
        return false;
    }

    public static boolean instanceOfSupportAlertDialog(Object r100) {
        if (sHasSupportAlertDialog == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof AlertDialog) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportFragment(Object r100) {
        if (sHasSupportFragment == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof Fragment) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportFragmentActivity(Object r100) {
        if (sHasSupportFragmentActivity == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof FragmentActivity) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportListMenuItemView(Object r100) {
        if (sHasSupportListMenuItemView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof ListMenuItemView) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportRecyclerView(Object r100) {
        if (sHasSupportRecyclerView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof RecyclerView) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportSwipeRefreshLayout(Object r100) {
        if (sHasSupportSwipeRefreshLayoutView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof SwipeRefreshLayout) == false) goto L7;
        return true;
    }

    public static boolean instanceOfSupportViewPager(Object r100) {
        if (sHasSupportViewPager == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof ViewPager) == false) goto L7;
        return true;
    }

    public static boolean instanceofAndroidXSwipeRefreshLayout(Object r100) {
        if (sHasAndroidXSwipeRefreshLayoutView == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof SwipeRefreshLayout) == false) goto L7;
        return true;
    }

    public static void checkCustomRecyclerView(Class<?> r100, String r101) {
        if (sHasAndroidXRecyclerView == false) goto L5;
        return;
    L5:
        if (sHasSupportRecyclerView == false) goto L7;
        return;
    L7:
        if (sHasCustomRecyclerView == true) goto L22;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.contains("RecyclerView") == false) goto L24;
        if (findRecyclerInSuper(r100) != null) goto L14;
        return;
    L14:
        if (sCRVGetChildAdapterPositionMethod == null) goto L26;
        sCRVClass = r100;     // Catch: Exception -> L17
        sHasCustomRecyclerView = true;     // Catch: Exception -> L17
        return;
    L26:
        return;
    L27:
        return;
    L24:
        return;
    }

    public static int invokeCRVGetChildAdapterPositionMethod(View r100, View r101) {
        if (r100.getClass() != sCRVClass) goto L6;
        return ((Integer) sCRVGetChildAdapterPositionMethod.invoke(r100, new Object[]{r101})).intValue();
    L6:
        return -1;
    L11:
        return -1;
    }
}
