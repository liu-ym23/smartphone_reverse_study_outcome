package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    public boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    public TooltipPopup(Context r5) {
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.mLayoutParams = r0;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = r5;
        View r1 = LayoutInflater.from(r5).inflate(2131558433, null);
        this.mContentView = r1;
        this.mMessageView = (TextView) r1.findViewById(2131379959);
        r0.setTitle(getClass().getSimpleName());
        r0.packageName = r5.getPackageName();
        r0.type = 1002;
        r0.width = -2;
        r0.height = -2;
        r0.format = -3;
        r0.windowAnimations = 2131951686;
        r0.flags = 24;
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private static View getAppRootView(View r3) {
        View r0 = r3.getRootView();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof WindowManager.LayoutParams) == true) goto L5;
    L7:
        Context r4 = r3.getContext();
    L9:
        if ((r4 instanceof ContextWrapper) == false) goto L15;
        if ((r4 instanceof Activity) == true) goto L13;
        r4 = ((ContextWrapper) r4).getBaseContext();
        goto L9
    L13:
        return INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r4).getWindow());
    L15:
        return r0;
    L5:
        if (((WindowManager.LayoutParams) r1).type != 2) goto L7;
        return r0;
    }

    public static void INVOKEINTERFACE_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
        r0.addView(r1, r2);
    }

    private void computePosition(View r9, int r10, int r11, boolean r12, WindowManager.LayoutParams r13) {
        r13.token = r9.getApplicationWindowToken();
        int r0 = this.mContext.getResources().getDimensionPixelOffset(2131168481);
        if (r9.getWidth() >= r0) goto L7;
        r10 = r9.getWidth() / 2;
    L7:
        if (r9.getHeight() < r0) goto L9;
        int r1 = this.mContext.getResources().getDimensionPixelOffset(2131168480);
        int r2 = r11 + r1;
        int r14 = r11 - r1;
    L10:
        r13.gravity = 49;
        Resources r3 = this.mContext.getResources();
        if (r12 == false) goto L13;
        int r4 = 2131168484;
    L14:
        int r5 = r3.getDimensionPixelOffset(r4);
        View r6 = getAppRootView(r9);
        if (r6 != null) goto L17;
        return;
    L17:
        r6.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect r7 = this.mTmpDisplayFrame;
        if (r7.left < 0) goto L20;
    L26:
        r6.getLocationOnScreen(this.mTmpAppPos);
        r9.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r15 = this.mTmpAnchorPos;
        int r8 = r15[0];
        int[] r16 = this.mTmpAppPos;
        int r17 = r8 - r16[0];
        r15[0] = r17;
        r15[1] = r15[1] - r16[1];
        r13.x = (r17 + r10) - (r6.getWidth() / 2);
        int r18 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r18, r18);
        int r19 = this.mContentView.getMeasuredHeight();
        int r110 = this.mTmpAnchorPos[1];
        int r111 = ((r14 + r110) - r5) - r19;
        int r112 = (r110 + r2) + r5;
        if (r12 == false) goto L32;
        if (r111 < 0) goto L30;
        r13.y = r111;
        return;
    L30:
        r13.y = r112;
        return;
    L32:
        if ((r19 + r112) > this.mTmpDisplayFrame.height()) goto L34;
        r13.y = r112;
        return;
    L34:
        r13.y = r111;
        return;
    L20:
        if (r7.top >= 0) goto L26;
        Resources r20 = this.mContext.getResources();
        int r21 = r20.getIdentifier("status_bar_height", "dimen", "android");
        if (r21 == 0) goto L24;
        int r22 = r20.getDimensionPixelSize(r21);
    L25:
        DisplayMetrics r23 = INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r20);
        this.mTmpDisplayFrame.set(0, r22, r23.widthPixels, r23.heightPixels);
        goto L26
    L24:
        r22 = 0;
        goto L25
    L13:
        r4 = 2131168483;
        goto L14
    L9:
        r2 = r9.getHeight();
        r14 = 0;
        goto L10
    }

    public void show(View r8, int r9, int r10, boolean r11, CharSequence r12) {
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r12);
        computePosition(r8, r9, r10, r11, this.mLayoutParams);
        INVOKEINTERFACE_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView((WindowManager) this.mContext.getSystemService("window"), this.mContentView, this.mLayoutParams);
    }
}
