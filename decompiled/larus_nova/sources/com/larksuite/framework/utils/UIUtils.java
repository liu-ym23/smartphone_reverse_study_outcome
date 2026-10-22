package com.larksuite.framework.utils;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.camera.video.AudioStats;
import androidx.core.graphics.ColorUtils;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class UIUtils {
    private static final String TAG = "UIUtils";
    private static int navigationHeight = -1;
    private static int realScreenHeight;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f285942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f285943b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f285942a.getViewTreeObserver().removeOnPreDrawListener(this);
            float r100 = UIUtils.getScreenHeight(this.f285943b) / 3.0f;
            int[] r101 = new int[2];
            this.f285942a.getLocationOnScreen(r101);
            this.f285942a.setTranslationY(r100 - (r101[1] - this.f285942a.getTranslationY()));
            return false;
        }

        public a(View r100, Context r101) {
            this.f285942a = r100;
            this.f285943b = r101;
        }
    }

    public UIUtils() {
    }

    public static boolean canShowSkeleton() {
        return !RomUtils.f285931n[0].equals(RomUtils.e().f285940a);
    }

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static RectF calcViewScreenLocation(View r100) {
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        return new RectF(r102, r101[1], r102 + r100.getWidth(), r101[1] + r100.getHeight());
    }

    public static boolean canLoadImage(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == true) goto L8;
        return true;
    L8:
        return isActivityRunningInner((Activity) r100);
    }

    public static void disableAllParentClipChild(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L12;
        Object r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L11;
        ViewGroup r102 = (ViewGroup) r101;
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        disableAllParentClipChild((View) r101);
        return;
    L11:
        return;
    }

    public static void disableGrandParentClipChild(View r100) {
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L10;
        ViewParent r102 = r101.getParent();
        if (r102 != null) goto L7;
        return;
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r102).setClipChildren(false);
        return;
    L12:
        return;
    }

    public static Activity getActivityFromContext(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    public static Activity getActivityFromView(View r100) {
        return getActivityFromContext(r100.getContext());
    }

    public static AssetManager getAssets(Context r100) {
        return getResources(r100).getAssets();
    }

    public static DisplayMetrics getDisplayMetrics(Context r100) {
        return INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources(r100));
    }

    public static int getHeight(View r100) {
        if (r100 == null) goto L6;
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredHeight();
    L6:
        return 0;
    }

    public static int getNavigationBarHeight(Context r100) {
        int r101 = navigationHeight;
        if (r101 != (-1)) goto L10;
        Resources r102 = r100.getResources();
        int r103 = r102.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r103 <= 0) goto L8;
        int r104 = r102.getDimensionPixelSize(r103);
        navigationHeight = r104;
        return r104;
    L8:
        return 0;
    L10:
        return r101;
    }

    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static int getScaledTouchSlop(Context r100) {
        return ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public static int getScreenHeight(Context r100) {
        int r101 = realScreenHeight;
        if (r101 != 0) goto L6;
        Display r102 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        int r104 = r103.heightPixels;
        realScreenHeight = r104;
        return r104;
    L6:
        return r101;
    }

    public static int getScreenOrientation(Context r100) {
        return r100.getResources().getConfiguration().orientation;
    }

    public static int getWidth(View r100) {
        if (r100 == null) goto L6;
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredWidth();
    L6:
        return 0;
    }

    public static void hide(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        return;
    }

    public static void invisible(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(4);
        return;
    }

    public static boolean isActivityRunning(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return isActivityRunningInner(r100);
    }

    private static boolean isActivityRunningInner(Activity r100) {
        if (r100.isDestroyed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.isFinishing() == true) goto L7;
        return true;
    }

    public static boolean isVisible(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean performParentLongClick(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ViewParent r101 = r100.getParent();
    L6:
        if (r101 == null) goto L14;
        if ((r101 instanceof ViewGroup) == false) goto L14;
        ViewGroup r102 = (ViewGroup) r101;
        if (r102.isLongClickable() == true) goto L11;
        r101 = r101.getParent();
        goto L6
    L11:
        r102.performLongClick();
        return true;
    L14:
        return false;
    }

    public static void setStatusBarTransparent(Context r100) {
        Activity r101 = (Activity) r100;
        INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).setSystemUiVisibility(1280);
        r101.getWindow().setStatusBarColor(0);
        com.ss.android.lark.insets.h r102 = WindowInsetsUtils.c(r101);
        r102.b(0);
        r102.c(false);
    }

    public static void setViewOnScreenOneThirdPlaceByTranslationY(View r100) {
        Context r101 = r100.getContext();
        r100.getViewTreeObserver().addOnPreDrawListener(new a(r100, r101));
    }

    public static void show(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(0);
        return;
    }

    public static void display(View r100, boolean r101) {
        if (r101 == false) goto L4;
        show(r100);
        return;
    L4:
        hide(r100);
    }

    public static int dp2px(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static <T extends View> T findViewById(View r100, int r101) {
        return (T) r100.findViewById(r101);
    }

    public static int getAlphaColor(int r100, double r101) {
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        if (r101 > 1.0d) goto L9;
        return ColorUtils.setAlphaComponent(r100, (int) (r101 * 255.0d));
    L9:
        throw new IllegalArgumentException();
    }

    public static int getColor(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static ColorStateList getColorStateList(Context r100, int r101) {
        return getResources(r100).getColorStateList(r101);
    }

    public static Drawable getCompatDrawable(Context r100, int r101) {
        return AppCompatResources.getDrawable(r100, r101);
    }

    public static int getDimens(Context r100, int r101) {
        return getResources(r100).getDimensionPixelSize(r101);
    }

    public static Drawable getDrawable(Context r100, int r101) {
        return AppCompatResources.getDrawable(r100, r101);
    }

    public static void getScreenShot(Activity r100, IGetDataCallback<Bitmap> r101) {
        int r102 = d0.f285950a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        d0.a(((ViewGroup) r100.findViewById(R.id.content)).getRootView(), r100.getWindow(), r101);
    }

    public static String getString(Context r100, int r101) {
        return getResources(r100).getString(r101);
    }

    public static String[] getStringArray(Context r100, int r101) {
        return getResources(r100).getStringArray(r101);
    }

    public static View inflate(Context r100, int r101) {
        return LayoutInflater.from(r100).inflate(r101, null);
    }

    public static boolean isActivityAlive(Context r100, String r101) {
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        if (r102 != null) goto L5;
        return false;
    L5:
        List<ActivityManager.RunningTaskInfo> r103 = r102.getRunningTasks(100);
        if (q.a(r103) == false) goto L8;
        return false;
    L8:
        Iterator<ActivityManager.RunningTaskInfo> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L24;
        ActivityManager.RunningTaskInfo r105 = r104.next();
        if (r105 == null) goto L10;
        ComponentName r106 = r105.topActivity;
        if (r106 != null) goto L17;
    L18:
        ComponentName r107 = r105.baseActivity;
        if (r107 == null) goto L10;
        if (r107.toString().contains(r101) == false) goto L10;
    L22:
        Log.i(TAG, r105.topActivity.getPackageName() + " info.baseActivity.getPackageName()=" + r105.baseActivity.getPackageName());
        return true;
    L17:
        if (r106.toString().contains(r101) == true) goto L22;
    L24:
        return false;
    }

    public static AssetFileDescriptor openRawResourceFd(Context r100, int r101) {
        return getResources(r100).openRawResourceFd(r101);
    }

    public static int px2dp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int px2sp(Context r100, int r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity) + 0.5f);
    }

    public static void setForegroundAlpha(Activity r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r102 = r100.getWindow();
        if (r102 != null) goto L7;
        return;
    L7:
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.alpha = r101;
        r102.setAttributes(r103);
    }

    public static void setTextStyle(TextView r100, int r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        r100.setTextAppearance(r100.getContext(), r101);
        return;
    L5:
        r100.setTextAppearance(r101);
    }

    public static boolean setTextViewCursorDrawable(TextView r100, Drawable r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 <= 28) goto L7;
        r100.setTextCursorDrawable(r101);
        r100.invalidate();
        return true;
    L7:
        return setTextViewEditorDrawable(r102, r100, r101);
    }

    public static boolean setTextViewEditorDrawable(TextView r100, Drawable r101) {
        return setTextViewEditorDrawable(Build.VERSION.SDK_INT, r100, r101);
    }

    public static float sp2px(Context r100, float r101) {
        return r101 * INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity;
    }

    public static Bitmap toRoundCorner(Bitmap r100, float r101) {
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        RectF r106 = new RectF(r105);
        r104.setAntiAlias(true);
        r103.drawARGB(0, 0, 0, 0);
        r104.setColor(-12434878);
        r103.drawRoundRect(r106, r101, r101, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, r105, r105, r104);
        return r102;
    }

    public static String getQuantityString(Context r100, int r101, int r102) {
        return getResources(r100).getQuantityString(r101, r102, new Object[]{Integer.valueOf(r102)});
    }

    public static void getScreenViewShot(View r100, Window r101, IGetDataCallback<Bitmap> r102) {
        d0.a(r100, r101, r102);
    }

    public static String getString(Context r100, int r101, Object... r102) throws Resources.NotFoundException {
        return getResources(r100).getString(r101, r102);
    }

    public static View inflate(Context r100, int r101, ViewGroup r102) {
        return LayoutInflater.from(r100).inflate(r101, r102);
    }

    public static void setForegroundDrawable(Activity r100, float r101, Drawable r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r103 = r100.getWindow();
        if (r103 != null) goto L7;
        return;
    L7:
        View r104 = INVOKEVIRTUAL_com_larksuite_framework_utils_UIUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r104.setForeground(r102);
        return;
    L10:
        WindowManager.LayoutParams r105 = r103.getAttributes();
        r105.alpha = r101;
        r103.setAttributes(r105);
    }

    public static boolean setTextViewCursorColor(Context r100, TextView r101, int r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 <= 28) goto L17;
        Drawable r104 = r101.getTextCursorDrawable();
        if (r104 != null) goto L7;
        return false;
    L7:
        r104.setColorFilter(new BlendModeColorFilter(r102, BlendMode.SRC_IN));
        r101.setTextCursorDrawable(r104);
        r101.invalidate();
        return true;
    L17:
        Field r105 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L14
        r105.setAccessible(true);     // Catch: Exception -> L14
        Drawable r106 = AppCompatResources.getDrawable(r100, r105.getInt(r101));     // Catch: Exception -> L14
        if (r106 != null) goto L12;
        return false;
    L12:
        r106.setColorFilter(new PorterDuffColorFilter(r102, PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L14
        return setTextViewEditorDrawable(r103, r101, r106);
    L14:
        e = move-exception;
        Log.d(TAG, "setTextViewCursorColor: " + e.getMessage());
        return false;
    }

    private static boolean setTextViewEditorDrawable(int r100, TextView r101, Drawable r102) {
        if (r100 <= 28) goto L16;
        return setTextViewCursorDrawable(r101, r102);
    L16:
        Field r103 = TextView.class.getDeclaredField("mEditor");     // Catch: Exception -> L13
        r103.setAccessible(true);     // Catch: Exception -> L13
        Object r104 = r103.get(r101);     // Catch: Exception -> L13
        if (r100 != 28) goto L10;
        Field r105 = TextView.class.getDeclaredField("mDrawableForCursor");     // Catch: Exception -> L13
        r105.setAccessible(true);     // Catch: Exception -> L13
        r105.set(r104, r102);     // Catch: Exception -> L13
    L11:
        r101.invalidate();     // Catch: Exception -> L13
        return true;
    L10:
        Field r106 = TextView.class.getDeclaredField("mCursorDrawable");     // Catch: Exception -> L13
        r106.setAccessible(true);     // Catch: Exception -> L13
        r106.set(r104, new Drawable[]{r102, r102});     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "setTextViewEditorDrawable: " + e.getMessage());
        return false;
    }

    public static void setViewLayoutParam(ViewGroup r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = r101;
        r103.height = r102;
        r100.setLayoutParams(r103);
    }

    public static void showByStatus(TextView r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == false) goto L6;
        r100.setText(r101);
        r100.setVisibility(0);
        return;
    L6:
        r100.setVisibility(8);
    }

    public static Bitmap getBitmapFromLayout(Context r100, int r101, int r102, int r103) {
        View r104 = LayoutInflater.from(r100).inflate(r101, null, false);
        r104.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
        r104.layout(0, 0, r102, r103);
        Bitmap r105 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        r104.draw(new Canvas(r105));
        return r105;
    }

    public static Drawable getDrawableFromLayout(Context r100, int r101, int r102, int r103) {
        return new BitmapDrawable(r100.getResources(), getBitmapFromLayout(r100, r101, r102, r103));
    }

    public static void setMargins(View r100, int r101, int r102, int r103, int r104) {
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r100.getLayoutParams()).setMargins(r101, r102, r103, r104);
        r100.requestLayout();
        return;
    }
}
