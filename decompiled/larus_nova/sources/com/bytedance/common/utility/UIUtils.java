package com.bytedance.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes3.dex */
public final class UIUtils {
    public static final boolean API_ET_20 = false;
    private static final int BURY_WIDTH_DP = 20;
    public static final char ELLIPSIS_CHAR = 8230;
    private static final float FLOAT_BIAS = 0.5f;
    private static final float FLOAT_DOT999 = 0.999f;
    public static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    private static final int MASK_1000 = 16777216;
    private static final int MASK_FF = 255;
    private static final int MASK_FFFF = 16777215;
    private static final int MAX_COUNT = 10000;
    private static final int MAX_WIDTH = 1375;
    private static int mDpi;
    private static String sScreenResolution;
    public static EllipsisMeasureResult sTempEllipsisResult;
    private static ToastHook sToastHook;

    public static class EllipsisMeasureResult {
        public String ellipsisStr;
        public int length;

        public EllipsisMeasureResult() {
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public interface ToastHook {
    }

    static {
        API_ET_20 = true;
        sScreenResolution = "";
        mDpi = -1;
        sTempEllipsisResult = new EllipsisMeasureResult();
    }

    public static int floatToIntBig(float r100) {
        return (int) (r100 + FLOAT_DOT999);
    }

    public static int setColorAlpha(int r100, int r101) {
        if (r101 <= 255) goto L5;
        r101 = 255;
    L8:
        return (r100 & 16777215) | (r101 * 16777216);
    L5:
        if (r101 >= 0) goto L8;
        r101 = 0;
        goto L8
    }

    public static void setToastHook(ToastHook r100) {
    }

    private static boolean visibilityValid(int r100) {
        if (r100 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r100 == 8) goto L9;
        if (r100 == 4) goto L9;
        return false;
    }

    public static void assertInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        Logger.alertErrorInfo("not in UI thread");
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static boolean isInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private UIUtils() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static boolean clearAnimation(View r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getAnimation() == null) goto L10;
        r100.clearAnimation();
        return true;
    L10:
        return false;
    }

    public static void detachFromParent(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L17;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L14;
        return;
    L14:
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logger.throwException(e);
        return;
    }

    public static int getDiggBuryWidth(Context r100) {
        return ((INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).widthPixels * MAX_WIDTH) / 10000) + ((int) dip2Px(r100, 20.0f));
    }

    public static int getDpi(Context r100) {
        if (mDpi != (-1)) goto L7;
        if (r100 == null) goto L7;
        mDpi = INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getApplicationContext().getResources()).densityDpi;
    L7:
        return mDpi;
    }

    public static int getIndexInParent(View r100) {
        if (r100 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r100.getParent() == null) goto L11;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L11;
        return ((ViewGroup) r101).indexOfChild(r100);
    }

    public static int getScreenHeight(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r101 = INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r101 != null) goto L9;
        return 0;
    L9:
        return r101.heightPixels;
    }

    public static String getScreenResolution(Context r100) {
        if (StringUtils.isEmpty(sScreenResolution) == false) goto L10;
        if (r100 == null) goto L10;
        int r101 = getScreenWidth(r100);
        int r102 = getScreenHeight(r100);
        if (r101 <= 0) goto L10;
        if (r102 <= 0) goto L10;
        sScreenResolution = r101 + "*" + r102;
    L10:
        return sScreenResolution;
    }

    public static int getScreenWidth(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r101 = INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r101 != null) goto L9;
        return 0;
    L9:
        return r101.widthPixels;
    }

    public static int getStatusBarHeight(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public static boolean isViewVisible(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static float dip2Px(Context r100, float r101) {
        if (r100 != null) goto L4;
        return 0.0f;
    L4:
        return (r101 * INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f;
    }

    public static void displayToast(Context r100, int r101) {
        displayToast(r100, r100.getString(r101));
    }

    public static int[] getLocationInAncestor(View r100, View r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        int[] r102 = new int[2];
        float[] r103 = {0.0f, 0.0f};
        r103[0] = r103[0] + r100.getLeft();
        r103[1] = r103[1] + r100.getTop();
        ViewParent r104 = r100.getParent();
    L8:
        if ((r104 instanceof View) == false) goto L13;
        View r105 = (View) r104;
        if (r104 == r101) goto L11;
        r103[0] = r103[0] - r105.getScrollX();
        r103[1] = r103[1] - r105.getScrollY();
        r103[0] = r103[0] + r105.getLeft();
        r103[1] = r103[1] + r105.getTop();
        r104 = r105.getParent();
        goto L8
    L11:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L17;
        Logger.alertErrorInfo("ancestorView:" + r101 + " is not the ancestor of child : " + r100);
        return null;
    L17:
        r102[0] = (int) (r103[0] + 0.5f);
        r102[1] = (int) (r103[1] + 0.5f);
        return r102;
    L13:
        r106 = false;
    L19:
        Logger.alertErrorInfo("invalid params: child:" + r100 + ",ancestor:" + r101);
        return null;
    }

    public static int getRatioOfScreen(Context r100, float r101) {
        DisplayMetrics r102 = INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r102 != null) goto L7;
        return 0;
    L7:
        return (int) (r102.widthPixels * r101);
    }

    public static int px2dip(Context r100, float r101) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        return (int) ((r101 / INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static void requestOrienation(Activity r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isFinishing() == true) goto L13;
        r100.setRequestedOrientation(!r101 ? 1 : 0);
        if (r101 == false) goto L9;
        r100.getWindow().setFlags(1024, 1024);
        return;
    L9:
        r100.getWindow().clearFlags(1024);
        return;
    }

    public static void setText(TextView r100, CharSequence r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r100.setText(r101);
        return;
    }

    public static void setTextViewMaxLines(TextView r100, int r101) {
        if (r100 == null) goto L14;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (r100.getMaxLines() != r101) goto L8;
        return;
    L8:
        boolean r102 = true;
        if (r101 == 1) goto L12;
        r102 = false;
    L12:
        r100.setSingleLine(r102);
        r100.setMaxLines(r101);
        return;
    }

    public static void setTopMargin(View r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        updateLayoutMargin(r100, -3, (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getContext().getResources())), -3, -3);
    }

    public static void setTxtAndAdjustVisible(TextView r100, CharSequence r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        setViewVisibility(r100, 8);
        return;
    L7:
        setViewVisibility(r100, 0);
        r100.setText(r101);
    }

    public static void setViewBackgroundWithPadding(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.getPaddingLeft();
        int r103 = r100.getPaddingRight();
        int r104 = r100.getPaddingTop();
        int r105 = r100.getPaddingBottom();
        r100.setBackgroundResource(r101);
        r100.setPadding(r102, r104, r103, r105);
    }

    public static void setViewMinHeight(View r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getMinimumHeight() != r101) goto L7;
        return;
    L7:
        r100.setMinimumHeight(r101);
    }

    public static void setViewVisibility(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() != r101) goto L6;
        return;
    L6:
        if (visibilityValid(r101) == false) goto L12;
        r100.setVisibility(r101);
        return;
    }

    public static float sp2px(Context r100, float r101) {
        if (r100 != null) goto L4;
        return 0.0f;
    L4:
        return TypedValue.applyDimension(2, r101, INVOKEVIRTUAL_com_bytedance_common_utility_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static void displayToast(Context r100, String r101) {
        displayToast(r100, 0, r101);
    }

    public static void setViewBackgroundWithPadding(View r100, Drawable r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.getPaddingLeft();
        int r103 = r100.getPaddingRight();
        int r104 = r100.getPaddingTop();
        int r105 = r100.getPaddingBottom();
        r100.setBackgroundDrawable(r101);
        r100.setPadding(r102, r104, r103, r105);
    }

    public static void displayLongTimeToast(Context r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r103 = r100.getString(r102);
        if (StringUtils.isEmpty(r103) == false) goto L7;
        return;
    L7:
        displayToastInternal(r100, r101, r103, 1, 17);
    }

    public static void displayToast(Context r100, int r101, int r102) {
        displayToast(r100, r100.getString(r101), r102);
    }

    public static void displayToastWithIcon(Context r100, int r101, int r102) {
        displayToast(r100, r101, r100.getString(r102));
    }

    public static void setClickListener(boolean r100, View r101, View.OnClickListener r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 == false) goto L6;
        r101.setOnClickListener(r102);
        r101.setClickable(true);
        return;
    L6:
        r101.setOnClickListener(null);
        r101.setClickable(false);
    }

    public static void setLayoutParams(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r101 == Integer.MIN_VALUE) goto L8;
        r103.width = r101;
    L8:
        if (r102 == Integer.MIN_VALUE) goto L11;
        r103.height = r102;
        return;
    }

    public static void setViewBackgroundWithPadding(View r100, Resources r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r103 = r100.getPaddingLeft();
        int r104 = r100.getPaddingRight();
        int r105 = r100.getPaddingTop();
        int r106 = r100.getPaddingBottom();
        r100.setBackgroundColor(r101.getColor(r102));
        r100.setPadding(r103, r105, r104, r106);
    }

    public static void updateLayout(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.width != r101) goto L12;
        if (r103.height != r102) goto L12;
        return;
    L12:
        if (r101 == (-3)) goto L14;
        r103.width = r101;
    L14:
        if (r102 == (-3)) goto L16;
        r103.height = r102;
    L16:
        r100.setLayoutParams(r103);
    }

    public static void displayToast(Context r100, int r101, String r102) {
        displayToastInternal(r100, r101, r102, 0, 17);
    }

    public static void displayToastWithIcon(Context r100, int r101, String r102) {
        displayToast(r100, r101, r102);
    }

    public static void displayToast(Context r100, String r101, int r102) {
        displayToastInternal(r100, 0, r101, 0, r102);
    }

    public static void getLocationInUpView(View r100, View r101, int[] r102, boolean r103) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L14;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.length < 2) goto L16;
        r100.getLocationInWindow(r102);
        int r104 = r102[0];
        int r105 = r102[1];
        r101.getLocationInWindow(r102);
        int r106 = r102[0] - r104;
        int r107 = r102[1] - r105;
        if (r103 == false) goto L11;
        int r108 = r101.getWidth();
        r106 = r106 + (r108 / 2);
        r107 = r107 + (r101.getHeight() / 2);
    L11:
        r102[0] = r106;
        r102[1] = r107;
        return;
    L16:
        return;
    L14:
        return;
    }

    public static /* synthetic */ void access$000(Context r100, int r101, String r102, int r103, int r104) {
        displayToastInternal(r100, r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void displayToastInternal(final Context r100, final int r101, final String r110, final int r111, final int r112) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r110) == false) goto L7;
        return;
    L7:
        if (isInUIThread() == true) goto L10;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r100, r101, r110, r111, r112));
        return;
    L10:
        if ((r100 instanceof ICustomToast) == true) goto L12;
        Toast r102 = Toast.makeText(r100, r110, r111);     // Catch: Exception -> L22
        if (r102 == null) goto L31;
        r102.setGravity(r112, 0, 0);     // Catch: Exception -> L22
        r102.show();     // Catch: Exception -> L22
        return;
    L31:
        return;
    L22:
        e = move-exception;
        Logger.throwException(e);
        return;
    L12:
        if (r111 != 1) goto L14;
        ((ICustomToast) r100).showCustomLongToast(r101, r110);
        return;
    L14:
        ICustomToast r103 = (ICustomToast) r100;
        if (r111 != 0) goto L17;
        r111 = 2000;
    L17:
        r103.showCustomToast(r101, r110, r111, r112);
    }

    public static void ellipseSingleLineStr(String r110, int r111, Paint r112, int r113, EllipsisMeasureResult r114) {
        if (r111 > r113) goto L5;
    L17:
        r114.ellipsisStr = "";
        r114.length = 0;
        return;
    L5:
        if (StringUtils.isEmpty(r110) == true) goto L17;
        int r100 = floatToIntBig(r112.measureText(r110));
        if (r100 > r111) goto L11;
        r114.ellipsisStr = r110;
        r114.length = r100;
        return;
    L11:
        StringBuilder r101 = new StringBuilder();
        int r115 = r112.breakText(r110, 0, r110.length(), true, r111 - r113, null);
        if (r115 >= 1) goto L15;
        r114.ellipsisStr = "";
        r114.length = 0;
        return;
    L15:
        r101.append(r110.substring(0, r115));
        r101.append(8230);
        r114.ellipsisStr = r101.toString();
        r114.length = r111;
    }

    public static void expandClickRegion(final View r100, final int r101, final int r102, final int r110, final int r111) {
        r100.post(new AnonymousClass2(r100, r102, r111, r101, r110));
    }

    public static void updateLayoutMargin(View r100, int r101, int r110, int r111, int r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        updateMargin(r100, (ViewGroup.MarginLayoutParams) r102, r101, r110, r111, r112);
        return;
    }

    private static void updateMargin(View r100, ViewGroup.MarginLayoutParams r101, int r102, int r103, int r104, int r105) {
        if (r100 == null) goto L25;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.leftMargin != r102) goto L15;
        if (r101.topMargin != r103) goto L15;
        if (r101.rightMargin != r104) goto L15;
        if (r101.bottomMargin != r105) goto L15;
        return;
    L15:
        if (r102 == (-3)) goto L17;
        r101.leftMargin = r102;
    L17:
        if (r103 == (-3)) goto L19;
        r101.topMargin = r103;
    L19:
        if (r104 == (-3)) goto L21;
        r101.rightMargin = r104;
    L21:
        if (r105 == (-3)) goto L23;
        r101.bottomMargin = r105;
    L23:
        r100.setLayoutParams(r101);
        return;
    }
}
