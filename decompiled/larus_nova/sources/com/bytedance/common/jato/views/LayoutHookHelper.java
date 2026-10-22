package com.bytedance.common.jato.views;

import android.os.Trace;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class LayoutHookHelper {
    public static final boolean DEBUG = false;
    private static Field Field_AttachInfo_mViewRequestingLayout;
    private static Field Field_OldHeightSpec;
    private static Field Field_OldWidthSpec;
    private static Field Field_Parents;
    private static Field Field_mAttachInfo;
    private static Field Field_mPrivateFlags;
    private static Field Field_mPrivateFlags3;
    private static final boolean IS_HOOK_INIT = false;
    private static Method Method_View_OnLayout;
    private static Method Method_View_OnMeasure;
    private static int VIEW_PFLAG3_IS_LAID_OUT;
    private static int VIEW_PFLAG_FORCE_LAYOUT;
    private static int VIEW_PFLAG_LAYOUT_REQUIRED;
    private static final GlobalLayoutChangeRunnable sGlobalLayoutChangeRunnable = null;
    private boolean mIsInited;
    private boolean mIsPendingTraversalComsume;
    private boolean mSkipMeasure;
    private final Runnable mStrictModeCheckRunnable;
    private final Runnable mUpdateChildRunnable;
    private View mView;
    private ViewInterface mViewThis;
    public String viewName;
    private StrictCheckViewProp viewPropForNextCheck;

    public static class GlobalLayoutChangeRunnable implements Runnable {
        private ViewTreeObserver mOb;

        private GlobalLayoutChangeRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_common_jato_views_LayoutHookHelper$GlobalLayoutChangeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_common_jato_views_LayoutHookHelper$GlobalLayoutChangeRunnable__run$___twin___() {
            if (this.mOb == null) goto L11;
            boolean r100 = LayoutHookHelper.DEBUG;
            if (r100 == false) goto L7;
            Trace.beginSection("JatoOptFrameLayout dispatchOnGlobalLayout");
        L7:
            this.mOb.dispatchOnGlobalLayout();
            this.mOb = null;
            if (r100 == false) goto L12;
            Trace.endSection();
            return;
        L12:
            return;
        }

        public /* synthetic */ GlobalLayoutChangeRunnable(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_common_jato_views_LayoutHookHelper$GlobalLayoutChangeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(GlobalLayoutChangeRunnable r100) {
            r100.com_bytedance_common_jato_views_LayoutHookHelper$GlobalLayoutChangeRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setCallback(ViewTreeObserver r100) {
            if (r100 == null) goto L5;
            this.mOb = r100;
            return;
        }
    }

    public static class StrictCheckViewProp {
        public int bottom;
        public int left;
        public int oldHeightSpec;
        public int oldWidthSpec;
        public int right;
        public int top;

        private StrictCheckViewProp() {
        }

        public String toString() {
            return toString(this.oldWidthSpec, this.oldHeightSpec, this.left, this.top, this.right, this.bottom);
        }

        public /* synthetic */ StrictCheckViewProp(AnonymousClass1 r100) {
            this();
        }

        public static String toString(int r100, int r101, int r102, int r103, int r104, int r105) {
            return "StrictCheckViewProp{oldWidthSpec=" + r100 + ", oldHeightSpec=" + r101 + ", left=" + r102 + ", top=" + r103 + ", right=" + r104 + ", bottom=" + r105 + '}';
        }
    }

    public interface ViewInterface {
        void requestLayoutDelegate();
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private int getMeasuredSize(int r100) {
        return r100 & 16777215;
    }

    private static boolean initHook() {
        Field r100 = DoubleReflector.getField(View.class, "mParent");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_Parents = r100;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r100.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r101 = DoubleReflector.getField(View.class, "mPrivateFlags");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_mPrivateFlags = r101;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r101.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r102 = DoubleReflector.getField(View.class, "mPrivateFlags3");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_mPrivateFlags3 = r102;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r102.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r103 = DoubleReflector.getField(View.class, "mOldWidthMeasureSpec");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_OldWidthSpec = r103;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r103.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r104 = DoubleReflector.getField(View.class, "mOldHeightMeasureSpec");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_OldHeightSpec = r104;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r104.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r105 = DoubleReflector.getField(View.class, "mAttachInfo");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_mAttachInfo = r105;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r105.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r106 = DoubleReflector.getField(INVOKESTATIC_com_bytedance_common_jato_views_LayoutHookHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.View$AttachInfo"), "mViewRequestingLayout");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field_AttachInfo_mViewRequestingLayout = r106;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r106.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Class r107 = Integer.TYPE;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Method r108 = DoubleReflector.getMethod(View.class, "onMeasure", new Class[]{r107, r107});     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Method_View_OnMeasure = r108;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r108.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Method r109 = DoubleReflector.getMethod(View.class, "onLayout", new Class[]{Boolean.TYPE, r107, r107, r107, r107});     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Method_View_OnLayout = r109;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r109.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r110 = DoubleReflector.getField(View.class, "PFLAG_FORCE_LAYOUT");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r111 = DoubleReflector.getField(View.class, "PFLAG_LAYOUT_REQUIRED");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        Field r112 = DoubleReflector.getField(View.class, "PFLAG3_IS_LAID_OUT");     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r110.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r111.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        r112.setAccessible(true);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        VIEW_PFLAG_FORCE_LAYOUT = r110.getInt(View.class);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        VIEW_PFLAG_LAYOUT_REQUIRED = r111.getInt(View.class);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        int r113 = r112.getInt(View.class);     // Catch: Exception -> L12 NoSuchFieldException -> L14
        VIEW_PFLAG3_IS_LAID_OUT = r113;     // Catch: Exception -> L12 NoSuchFieldException -> L14
        if (VIEW_PFLAG_FORCE_LAYOUT != 4096) goto L11;
    L7:
        if (VIEW_PFLAG_LAYOUT_REQUIRED != 8192) goto L11;
        if (r113 != 4) goto L11;
        return true;
    L11:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void resetFlagsAfterTraversal() {
        int r100 = (Field_mPrivateFlags.getInt(this.mViewThis) & (~VIEW_PFLAG_LAYOUT_REQUIRED)) & (~VIEW_PFLAG_FORCE_LAYOUT);     // Catch: IllegalAccessException -> L4
        Field_mPrivateFlags.setInt(this.mViewThis, r100);     // Catch: IllegalAccessException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    static {
        DEBUG = ViewOpt.isDebug();
        VIEW_PFLAG_FORCE_LAYOUT = -1;
        VIEW_PFLAG_LAYOUT_REQUIRED = -1;
        VIEW_PFLAG3_IS_LAID_OUT = -1;
        IS_HOOK_INIT = initHook();
        sGlobalLayoutChangeRunnable = new GlobalLayoutChangeRunnable(null);
    }

    private void postGlobalLayoutCallback() {
        if (ViewOpt.isDispatchGlobalLayout() == true) goto L5;
        return;
    L5:
        View r100 = this.mView;
        GlobalLayoutChangeRunnable r101 = sGlobalLayoutChangeRunnable;
        r100.removeCallbacks(r101);
        r101.setCallback(this.mView.getViewTreeObserver());
        this.mView.postOnAnimation(r101);
    }

    public static /* synthetic */ Field access$100() {
        return Field_OldWidthSpec;
    }

    public static /* synthetic */ Field access$200() {
        return Field_OldHeightSpec;
    }

    public static /* synthetic */ Method access$300() {
        return Method_View_OnMeasure;
    }

    public static /* synthetic */ Method access$400() {
        return Method_View_OnLayout;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_jato_views_LayoutHookHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ View access$000(LayoutHookHelper r100) {
        return r100.mView;
    }

    public static /* synthetic */ void access$500(LayoutHookHelper r100) {
        r100.resetFlagsAfterTraversal();
    }

    public static /* synthetic */ StrictCheckViewProp access$800(LayoutHookHelper r100) {
        return r100.viewPropForNextCheck;
    }

    public boolean proxyRequestLayout(boolean r100) {
        if (this.mIsInited == true) goto L7;
        this.mViewThis.requestLayoutDelegate();
        return false;
    L7:
        if (this.mSkipMeasure == true) goto L12;
        this.mViewThis.requestLayoutDelegate();
        if (ViewOpt.isIsStrictMode() == false) goto L11;
        this.mStrictModeCheckRunnable.run();
        this.mIsPendingTraversalComsume = true;
    L11:
        return false;
    L12:
        UIUtils.checkRunOnUIThread();
        Object r101 = Field_Parents.get(this.mViewThis);     // Catch: IllegalAccessException -> L33
        if (r101 == null) goto L18;
        int r102 = Field_mPrivateFlags.getInt(r101);     // Catch: IllegalAccessException -> L33
        if (r102 == 0) goto L19;
        Field_mPrivateFlags.setInt(r101, VIEW_PFLAG_FORCE_LAYOUT | r102);     // Catch: IllegalAccessException -> L33
    L19:
        this.mViewThis.requestLayoutDelegate();     // Catch: IllegalAccessException -> L33
        boolean r103 = DEBUG;     // Catch: IllegalAccessException -> L33
        if (r103 == true) goto L22;
    L22:
        if (r101 == null) goto L32;
        if (r102 == 0) goto L32;
        Field_mPrivateFlags.setInt(r101, r102);     // Catch: IllegalAccessException -> L33
        if (r100 == true) goto L27;
    L31:
        return true;
    L27:
        if (this.mIsPendingTraversalComsume == true) goto L31;
        this.mView.postOnAnimation(this.mUpdateChildRunnable);     // Catch: IllegalAccessException -> L33
        postGlobalLayoutCallback();     // Catch: IllegalAccessException -> L33
        this.mIsPendingTraversalComsume = true;     // Catch: IllegalAccessException -> L33
        if (r103 == false) goto L31;
    L32:
        return false;
    L18:
        r102 = 0;
    L33:
        e = move-exception;
        e.printStackTrace();
        this.mViewThis.requestLayoutDelegate();
        return false;
    }

    public void setSkipMeasure(boolean r100) {
        if (ViewOpt.isIsStrictMode() == true) goto L6;
        this.mSkipMeasure = r100;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutHookHelper(String r100, ViewInterface r101) {
        this.viewName = "";
        this.mIsPendingTraversalComsume = false;
        this.mSkipMeasure = false;
        this.mIsInited = false;
        this.mUpdateChildRunnable = new AnonymousClass1(this);
        this.viewPropForNextCheck = null;
        this.mStrictModeCheckRunnable = new AnonymousClass2(this);
        if ((r101 instanceof View) == true) goto L5;
        return;
    L5:
        this.viewName = r100;
        this.mViewThis = r101;
        this.mView = (View) r101;
        this.mIsInited = IS_HOOK_INIT;
        if (DEBUG == true) goto L8;
        return;
    }

    public static /* synthetic */ int access$1000(LayoutHookHelper r100, int r101) {
        return r100.getMeasuredSize(r101);
    }

    public static /* synthetic */ boolean access$602(LayoutHookHelper r100, boolean r101) {
        r100.mIsPendingTraversalComsume = r101;
        return r101;
    }

    public static /* synthetic */ StrictCheckViewProp access$802(LayoutHookHelper r100, StrictCheckViewProp r101) {
        r100.viewPropForNextCheck = r101;
        return r101;
    }

    public boolean checkViewPropAvailable(int r100, int r101, int r102, int r103, int r104, int r105) {
        StrictCheckViewProp r106 = this.viewPropForNextCheck;
        if (r106 != null) goto L6;
        return true;
    L6:
        if (r100 == r106.oldWidthSpec) goto L8;
    L19:
        StrictCheckViewProp.toString(r100, r101, r102, r103, r104, r105);
        this.viewPropForNextCheck.toString();
        return false;
    L8:
        if (r101 != r106.oldHeightSpec) goto L19;
        if (r102 != r106.left) goto L19;
        if (r104 != r106.right) goto L19;
        if (r103 != r106.top) goto L19;
        if (r105 != r106.bottom) goto L19;
        return true;
    }
}
