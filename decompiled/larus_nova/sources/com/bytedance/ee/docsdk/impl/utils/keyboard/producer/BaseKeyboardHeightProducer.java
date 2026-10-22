package com.bytedance.ee.docsdk.impl.utils.keyboard.producer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.HardKeyboardUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.WindowModeUtils;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 E2\u00020\u0001:\u0002EFB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\tH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u00020-H$J\u0018\u00104\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u00020-H\u0004J\b\u00105\u001a\u000206H\u0005J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020'H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020-H\u0004J\b\u0010=\u001a\u00020'H\u0004J\u0010\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020%H&J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u000206H&J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020-H\u0004J\b\u0010D\u001a\u00020'H&R\u0014\u0010\u0005\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u0019X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivity", "getMActivity", "()Landroid/app/Activity;", "mAutoShowKeyboard", "", "getMAutoShowKeyboard", "()Z", "setMAutoShowKeyboard", "(Z)V", "mDelayedDuration", "", "getMDelayedDuration", "()Ljava/lang/Long;", "setMDelayedDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mPlaceholderViewVisible", "getMPlaceholderViewVisible", "setMPlaceholderViewVisible", "mPopupView", "Landroid/view/ViewGroup;", "getMPopupView", "()Landroid/view/ViewGroup;", "setMPopupView", "(Landroid/view/ViewGroup;)V", "mPopupWindow", "Landroid/widget/PopupWindow;", "getMPopupWindow", "()Landroid/widget/PopupWindow;", "mPopupWindow$delegate", "Lkotlin/Lazy;", "recentKeyboardData", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "close", "", "configurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "handleChanged", "createContentView", "Landroid/view/View;", "createLinearLayout", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createPopupWindow", "contentView", "defaultPopupWindow", "getKeyboardHeightByInvoke", "", "handleInsertsChanged", "insets", "Landroidx/core/view/WindowInsetsCompat;", "init", "insertsImpl", "insertsView", "invokeImpl", "notifyFromInsert", "data", "notifyFromInvoke", "imeHeight", "showPopupWindow", BaseSwitches.V, "start", "Companion", "KeyboardData", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseKeyboardHeightProducer {
    public static final long CONFIGURATION_CHANGED_INTERVAL = 1000;
    public static final long CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL = 2000;
    public static final Companion Companion = null;
    public static final long DEBOUNCE_DELAY_MILLIS = 200;
    public static final int ERR_HEIGHT = -1;
    public static final int HEIGHT_0 = 0;
    public static final int HEIGHT_1 = 1;
    public static final int MIN_KEYBOARD_HEIGHT = 300;
    private static final String TAG = "BaseBaseKBH#Producer";
    private static final int VALUE_0 = 0;
    private static final int VALUE_1 = 1;
    public static final boolean VISIBLE_FALSE = false;
    public static final boolean VISIBLE_TRUE = true;
    private final Activity mActivity;
    private boolean mAutoShowKeyboard;
    private Long mDelayedDuration;
    private boolean mPlaceholderViewVisible;
    protected ViewGroup mPopupView;
    private final Lazy mPopupWindow$delegate;
    private KeyboardData recentKeyboardData;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$Companion;", "", "()V", "CONFIGURATION_CHANGED_INTERVAL", "", "CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL", "DEBOUNCE_DELAY_MILLIS", "ERR_HEIGHT", "", "HEIGHT_0", "HEIGHT_1", "MIN_KEYBOARD_HEIGHT", "TAG", "", "VALUE_0", "VALUE_1", "VISIBLE_FALSE", "", "VISIBLE_TRUE", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "", "imeHeight", "", "navHeight", "capHeight", "isVisible", "", "(IIIZ)V", "getCapHeight", "()I", "setCapHeight", "(I)V", "getImeHeight", "setImeHeight", "()Z", "setVisible", "(Z)V", "getNavHeight", "setNavHeight", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KeyboardData {
        private int capHeight;
        private int imeHeight;
        private boolean isVisible;
        private int navHeight;

        public static /* synthetic */ KeyboardData copy$default(KeyboardData r100, int r101, int r102, int r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.imeHeight;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.navHeight;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.capHeight;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.isVisible;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.imeHeight;
        }

        public final int component2() {
            return this.navHeight;
        }

        public final int component3() {
            return this.capHeight;
        }

        public final boolean component4() {
            return this.isVisible;
        }

        public final KeyboardData copy(int r100, int r101, int r102, boolean r103) {
            return new KeyboardData(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof KeyboardData) == true) goto L8;
            return false;
        L8:
            KeyboardData r101 = (KeyboardData) r100;
            if (this.imeHeight == r101.imeHeight) goto L12;
            return false;
        L12:
            if (this.navHeight == r101.navHeight) goto L15;
            return false;
        L15:
            if (this.capHeight == r101.capHeight) goto L18;
            return false;
        L18:
            if (this.isVisible == r101.isVisible) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int r100 = ((((this.imeHeight * 31) + this.navHeight) * 31) + this.capHeight) * 31;
            boolean r101 = this.isVisible;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public String toString() {
            return "KeyboardData(imeHeight=" + this.imeHeight + ", navHeight=" + this.navHeight + ", capHeight=" + this.capHeight + ", isVisible=" + this.isVisible + ')';
        }

        public final int getCapHeight() {
            return this.capHeight;
        }

        public final int getImeHeight() {
            return this.imeHeight;
        }

        public final int getNavHeight() {
            return this.navHeight;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public final void setCapHeight(int r100) {
            this.capHeight = r100;
        }

        public final void setImeHeight(int r100) {
            this.imeHeight = r100;
        }

        public final void setNavHeight(int r100) {
            this.navHeight = r100;
        }

        public final void setVisible(boolean r100) {
            this.isVisible = r100;
        }

        public KeyboardData(int r100, int r101, int r102, boolean r103) {
            this.imeHeight = r100;
            this.navHeight = r101;
            this.capHeight = r102;
            this.isVisible = r103;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ WindowInsetsCompat a(BaseKeyboardHeightProducer r100, View r101, WindowInsetsCompat r102) {
        return insertsImpl$lambda$1$lambda$0(r100, r101, r102);
    }

    public void close() {
    }

    public abstract PopupWindow createPopupWindow(Context r100, View r101);

    public abstract void notifyFromInsert(KeyboardData r100);

    public abstract void notifyFromInvoke(int r100);

    public abstract void start();

    public final int getKeyboardHeightByInvoke() {
        Object r100 = this.mActivity.getSystemService("input_method");     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L5
        InputMethodManager r101 = (InputMethodManager) r100;     // Catch: Exception -> L5
        Method r102 = r101.getClass().getDeclaredMethod("getInputMethodWindowVisibleHeight", new Class[0]);     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        Object r103 = r102.invoke(r101, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L5
        int r104 = ((Integer) r103).intValue();     // Catch: Exception -> L5
        Log.i(TAG, "getKeyboardHeightByInvoke height : " + r104);     // Catch: Exception -> L5
        return r104;
    L5:
        e = move-exception;
        Log.e(TAG, "getKeyboardHeightByInvoke height : -1; " + e.getMessage());
        return -1;
    }

    public final ViewGroup getMPopupView() {
        ViewGroup r100 = this.mPopupView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPopupView");
        return null;
    }

    public final PopupWindow getMPopupWindow() {
        return (PopupWindow) this.mPopupWindow$delegate.getValue();
    }

    public void init() {
        setMPopupView(createLinearLayout(this.mActivity));
        WindowModeUtils.INSTANCE.setConfiguration(this.mActivity.getResources().getConfiguration());
    }

    public final void invokeImpl() {
        int r100 = getKeyboardHeightByInvoke();
        Log.i(TAG, "invokeImpl imeHeight=" + r100 + ';');
        if (r100 > 0) goto L5;
    L7:
        if (r100 > 0) goto L9;
        r100 = 0;
    L9:
        notifyFromInvoke(r100);
        return;
    L5:
        if (WindowModeUtils.INSTANCE.isInFreeFromMode() == false) goto L7;
        r100 = 1;
        goto L9
    }

    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final boolean getMAutoShowKeyboard() {
        return this.mAutoShowKeyboard;
    }

    public final Long getMDelayedDuration() {
        return this.mDelayedDuration;
    }

    public final boolean getMPlaceholderViewVisible() {
        return this.mPlaceholderViewVisible;
    }

    public BaseKeyboardHeightProducer(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.mActivity = r100;
        this.mPopupWindow$delegate = LazyKt.lazy(new BaseKeyboardHeightProducer$mPopupWindow$2(this));
        this.mAutoShowKeyboard = true;
    }

    private final void handleInsertsChanged(WindowInsetsCompat r100) {
        if (HardKeyboardUtils.hasHardKeyboard(this.mActivity) == false) goto L5;
    L7:
        Insets r101 = r100.getInsets(WindowInsetsCompat.Type.systemBars());
        Insets r102 = r100.getInsets(WindowInsetsCompat.Type.ime());
        Insets r103 = r100.getInsets(WindowInsetsCompat.Type.captionBar());
        Insets r104 = r100.getInsets(WindowInsetsCompat.Type.navigationBars());
        int r105 = r102.bottom;
        boolean r106 = r100.isVisible(WindowInsetsCompat.Type.ime());
        Log.i(TAG, "handleInsertsChanged  \n imeInset = " + r102 + " ; \n captionInset = " + r103 + " ; \n navInset = " + r104 + " ; \n systemBarInset = " + r101 + " \n imeHeight = " + r105 + " \n isKeyboardVisible = " + r106);
        WindowModeUtils.INSTANCE.setNavHeight(r104.bottom);
        KeyboardData r107 = new KeyboardData(r105, r104.bottom, r103.bottom, r106);
        if (HardKeyboardUtils.hasHardKeyboard(this.mActivity) == false) goto L13;
        if (r106 == false) goto L13;
        if (r107.getImeHeight() != 0) goto L13;
        r107.setImeHeight(1);
    L13:
        this.recentKeyboardData = r107;
        notifyFromInsert(r107);
        return;
    L5:
        if (WindowModeUtils.INSTANCE.isActivityInMultiWindowMode(this.mActivity) == false) goto L7;
        invokeImpl();
    }

    public View createContentView(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        return r100.findViewById(R.id.content);
    }

    public final LinearLayout createLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r101.setOrientation(1);
        r101.setBackgroundColor(r100.getResources().getColor(R.color.transparent));
        return r101;
    }

    public final void insertsImpl(View r100) {
        Intrinsics.checkNotNullParameter(r100, "insertsView");
        ViewCompat.setOnApplyWindowInsetsListener(r100, new a(this));
    }

    public final void setMAutoShowKeyboard(boolean r100) {
        this.mAutoShowKeyboard = r100;
    }

    public final void setMDelayedDuration(Long r100) {
        this.mDelayedDuration = r100;
    }

    public final void setMPlaceholderViewVisible(boolean r100) {
        this.mPlaceholderViewVisible = r100;
    }

    public final void setMPopupView(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mPopupView = r100;
    }

    public final void showPopupWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (getMPopupWindow().isShowing() == true) goto L12;
        getMPopupWindow().setBackgroundDrawable(new ColorDrawable(0));
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_producer_BaseKeyboardHeightProducer_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(getMPopupWindow(), r100, 0, 0, 0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e(TAG, "showPopupWindow err =" + th.getMessage() + ';');
        return;
    }

    public void configurationChanged(Configuration r100, boolean r101) {
        Log.i(TAG, "configurationChanged : ");
        WindowModeUtils.INSTANCE.setConfiguration(r100);
    }

    public final PopupWindow defaultPopupWindow(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        PopupWindow r102 = new PopupWindow(r100);
        r102.setContentView(r101);
        r102.setSoftInputMode(21);
        r102.setInputMethodMode(1);
        r102.setWidth(1);
        r102.setHeight(-1);
        r102.setTouchable(false);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r102.setWindowLayoutType(1003);
    L6:
        return r102;
    L5:
        KeyBoardUtils.setPopupWindowType(r102, 1003);
        goto L6
    }

    private static final WindowInsetsCompat insertsImpl$lambda$1$lambda$0(BaseKeyboardHeightProducer r100, View r101, WindowInsetsCompat r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.handleInsertsChanged(r102);
        return r102.consumeSystemWindowInsets();
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_producer_BaseKeyboardHeightProducer_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }
}
