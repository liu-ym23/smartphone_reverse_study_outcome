package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = 2131375182;
    private static final int IMMERSION_STATUS_BAR_VIEW = 2131375183;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private static Map<String, ImmersionBar> mImmersionBarMap;
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;

    /* JADX INFO: renamed from: com.gyf.barlibrary.ImmersionBar$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$barlibrary$BarHide = null;

        static {
            int[] r100 = new int[BarHide.values().length];
            $SwitchMap$com$gyf$barlibrary$BarHide = r100;
            r100[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mImmersionBarMap = new HashMap();
    }

    private void adjustDarkModeParams() {
        BarParams r100 = this.mBarParams;
        boolean r101 = true;
        if (r100.autoStatusBarDarkModeEnable == false) goto L10;
        int r102 = r100.statusBarColor;
        if (r102 == 0) goto L8;
        if (r102 <= BOUNDARY_COLOR) goto L8;
        boolean r103 = true;
    L9:
        statusBarDarkFont(r103, r100.autoStatusBarDarkModeAlpha);
    L8:
        r103 = false;
    L10:
        BarParams r104 = this.mBarParams;
        if (r104.autoNavigationBarDarkModeEnable == false) goto L19;
        int r105 = r104.navigationBarColor;
        if (r105 == 0) goto L16;
        if (r105 <= BOUNDARY_COLOR) goto L16;
    L17:
        navigationBarDarkIcon(r101, r104.autoNavigationBarDarkModeAlpha);
        return;
    L16:
        r101 = false;
        goto L17
    }

    private void checkNavigationBarFlag() {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        BarParams r100 = this.mBarParams;
        if (r100.useDefaultNavigationBarColor == true) goto L7;
        return;
    L7:
        if ((INVOKEVIRTUAL_com_gyf_barlibrary_ImmersionBar_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).getSystemUiVisibility() & 16) == 0) goto L9;
        boolean r101 = true;
    L10:
        r100.navigationBarDarkIcon = r101;
        return;
    L9:
        r101 = false;
        goto L10
    }

    private void checkNavigationBarInitialized() {
        if (this.mBarParams.useDefaultNavigationBarColor == false) goto L6;
        this.mBarParams.navigationBarColor = this.mWindow.getNavigationBarColor();
        return;
    }

    private void fitsKeyboard() {
        if (this.mIsFragment == false) goto L5;
        ImmersionBar r100 = mImmersionBarMap.get(this.mActivity.toString());
        if (r100 != null) goto L16;
        return;
    L16:
        if (r100.mBarParams.keyboardEnable == true) goto L18;
        FitsKeyboard r101 = r100.mFitsKeyboard;
        if (r101 == null) goto L30;
        r101.disable();
        return;
    L30:
        return;
    L18:
        if (r100.mFitsKeyboard != null) goto L20;
        r100.mFitsKeyboard = new FitsKeyboard(r100, r100.mActivity, r100.mWindow);
    L20:
        r100.mFitsKeyboard.enable(r100.mBarParams.keyboardMode);
        return;
    L5:
        if (this.mBarParams.keyboardEnable == true) goto L7;
        FitsKeyboard r102 = this.mFitsKeyboard;
        if (r102 == null) goto L26;
        r102.disable();
        return;
    L26:
        return;
    L7:
        if (this.mFitsKeyboard != null) goto L9;
        this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
    L9:
        this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
    }

    private void fitsLayoutOverlap() {
        if (this.mIsFitsLayoutOverlap == true) goto L15;
        int r100 = this.mFitsStatusBarType;
        if (r100 != 1) goto L7;
        setTitleBar(this.mActivity, this.mBarParams.titleBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L7:
        if (r100 != 2) goto L9;
        setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L9:
        if (r100 != 3) goto L18;
        setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L18:
        return;
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (this.mIsFitsNotch == true) goto L9;
        WindowManager.LayoutParams r100 = this.mWindow.getAttributes();
        r100.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(r100);
        this.mIsFitsNotch = true;
        return;
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(R.id.content)) == false) goto L9;
        if (this.mBarParams.isSupportActionBar == false) goto L19;
        setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
        return;
    L19:
        return;
    L9:
        if (this.mBarParams.fits == true) goto L11;
    L13:
        int r100 = 0;
    L15:
        if (this.mBarParams.isSupportActionBar == false) goto L17;
        r100 = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
    L17:
        setPadding(0, r100, 0, 0);
        return;
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r100 = this.mBarConfig.getStatusBarHeight();
        goto L15
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(R.id.content)) == false) goto L9;
        if (this.mBarParams.isSupportActionBar == false) goto L44;
        setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
        return;
    L44:
        return;
    L9:
        if (this.mBarParams.fits == true) goto L11;
    L13:
        int r100 = 0;
    L15:
        if (this.mBarParams.isSupportActionBar == false) goto L18;
        r100 = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
    L18:
        if (this.mBarConfig.hasNavigationBar() == false) goto L40;
        BarParams r101 = this.mBarParams;
        if (r101.navigationBarEnable == false) goto L40;
        if (r101.navigationBarWithKitkatEnable == false) goto L40;
        if (r101.fullScreen == false) goto L26;
        int r102 = 0;
    L30:
        int r103 = 0;
    L32:
        if (this.mBarParams.hideNavigationBar == false) goto L38;
        if (this.mBarConfig.isNavigationAtBottom() == true) goto L41;
        r102 = 0;
    L42:
        setPadding(0, r100, r102, r103);
        return;
    L41:
        r103 = 0;
        goto L42
    L38:
        if (this.mBarConfig.isNavigationAtBottom() == true) goto L42;
        r102 = this.mBarConfig.getNavigationBarWidth();
        goto L42
    L26:
        if (this.mBarConfig.isNavigationAtBottom() == false) goto L28;
        r103 = this.mBarConfig.getNavigationBarHeight();
        r102 = 0;
        goto L32
    L28:
        r102 = this.mBarConfig.getNavigationBarWidth();
    L40:
        r102 = 0;
        goto L41
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r100 = this.mBarConfig.getStatusBarHeight();
        goto L15
    }

    private void fitsWindowsEMUI() {
        final View r100 = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        BarParams r101 = this.mBarParams;
        if (r101.navigationBarEnable == true) goto L5;
    L16:
        r100.setVisibility(8);
        return;
    L5:
        if (r101.navigationBarWithKitkatEnable == false) goto L16;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.mNavigationObserver != null) goto L19;
        final Handler r102 = new Handler();
        this.mNavigationObserver = new AnonymousClass1(this, r102, r100);
        Activity r103 = this.mActivity;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getContentResolver() != null) goto L14;
        return;
    L14:
        if (this.mNavigationObserver == null) goto L22;
        this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver);
        return;
    L22:
        return;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() == false) goto L5;
    L6:
        BarParams r100 = this.mBarParams;
        if (r100.navigationBarEnable == true) goto L9;
    L11:
        this.mWindow.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L13:
        if (this.mNavigationBarHeight != 0) goto L16;
        this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
    L16:
        if (this.mNavigationBarWidth != 0) goto L18;
        this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
    L18:
        setupNavBarView();
        return;
    L9:
        if (r100.navigationBarWithKitkatEnable == false) goto L11;
        this.mWindow.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        goto L13
    L5:
        if (OSUtils.isEMUI3_x() == true) goto L6;
    }

    private void initParams() {
        this.mBarParams = new BarParams();
        ViewGroup r100 = (ViewGroup) INVOKEVIRTUAL_com_gyf_barlibrary_ImmersionBar_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
        this.mDecorView = r100;
        this.mContentView = (ViewGroup) r100.findViewById(R.id.content);
    }

    private void setupNavBarView() {
        ViewGroup r100 = this.mDecorView;
        int r101 = IMMERSION_NAVIGATION_BAR_VIEW;
        View r102 = r100.findViewById(r101);
        if (r102 != null) goto L6;
        r102 = new View(this.mActivity);
        r102.setId(r101);
        this.mDecorView.addView(r102);
    L6:
        if (this.mBarConfig.isNavigationAtBottom() == false) goto L8;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
        r103.gravity = 80;
    L9:
        r102.setLayoutParams(r103);
        BarParams r104 = this.mBarParams;
        r102.setBackgroundColor(ColorUtils.blendARGB(r104.navigationBarColor, r104.navigationBarColorTransform, r104.navigationBarAlpha));
        BarParams r105 = this.mBarParams;
        if (r105.navigationBarEnable == true) goto L12;
    L16:
        r102.setVisibility(8);
        return;
    L12:
        if (r105.navigationBarWithKitkatEnable == false) goto L16;
        if (r105.hideNavigationBar == true) goto L16;
        r102.setVisibility(0);
        return;
    L8:
        r103 = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
        r103.gravity = GravityCompat.END;
        goto L9
    }

    private void setupStatusBarView() {
        ViewGroup r100 = this.mDecorView;
        int r101 = IMMERSION_STATUS_BAR_VIEW;
        View r102 = r100.findViewById(r101);
        if (r102 != null) goto L5;
        r102 = new View(this.mActivity);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
        r103.gravity = 48;
        r102.setLayoutParams(r103);
        r102.setVisibility(0);
        r102.setId(r101);
        this.mDecorView.addView(r102);
    L5:
        BarParams r104 = this.mBarParams;
        if (r104.statusBarColorEnabled == false) goto L8;
        r102.setBackgroundColor(ColorUtils.blendARGB(r104.statusBarColor, r104.statusBarColorTransform, r104.statusBarAlpha));
        return;
    L8:
        r102.setBackgroundColor(ColorUtils.blendARGB(r104.statusBarColor, 0, r104.statusBarAlpha));
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() == 0) goto L16;
        Iterator<Map.Entry<View, Map<Integer, Integer>>> r100 = this.mBarParams.viewMap.entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L26;
        Map.Entry<View, Map<Integer, Integer>> r101 = r100.next();
        View r102 = r101.getKey();
        Map<Integer, Integer> r103 = r101.getValue();
        Integer r104 = Integer.valueOf(this.mBarParams.statusBarColor);
        Integer r105 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
        Iterator<Map.Entry<Integer, Integer>> r106 = r103.entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r107 = r106.next();
        Integer r108 = r107.getKey();
        r105 = r107.getValue();
        r104 = r108;
        goto L9
    L11:
        if (r102 == null) goto L6;
        if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) goto L14;
        r102.setBackgroundColor(ColorUtils.blendARGB(r104.intValue(), r105.intValue(), this.mBarParams.viewAlpha));
        goto L6
    L14:
        r102.setBackgroundColor(ColorUtils.blendARGB(r104.intValue(), r105.intValue(), this.mBarParams.statusBarAlpha));
        goto L6
    L26:
        return;
    }

    public void cancelListener() {
        Activity r100 = this.mActivity;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mNavigationObserver == null) goto L7;
        r100.getContentResolver().unregisterContentObserver(this.mNavigationObserver);
        this.mNavigationObserver = null;
    L7:
        FitsKeyboard r101 = this.mFitsKeyboard;
        if (r101 == null) goto L12;
        r101.cancel();
        this.mFitsKeyboard = null;
        return;
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() == 0) goto L5;
        this.mBarParams.viewMap.clear();
    L5:
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar transparentBar() {
        BarParams r100 = this.mBarParams;
        r100.statusBarColor = 0;
        r100.navigationBarColor = 0;
        r100.useDefaultNavigationBarColor = false;
        r100.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        BarParams r100 = this.mBarParams;
        r100.navigationBarColor = 0;
        r100.useDefaultNavigationBarColor = false;
        r100.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    private void fitsWindows() {
        if (OSUtils.isEMUI3_x() == true) goto L5;
        fitsWindowsAboveLOLLIPOP();
        return;
    L5:
        fitsWindowsBelowLOLLIPOP();
        if (this.mIsFragment == false) goto L8;
        return;
    L8:
        if (OSUtils.isEMUI3_x() == false) goto L13;
        fitsWindowsEMUI();
        return;
    }

    public static boolean isSupportNavigationIconDark() {
        if (OSUtils.isMIUI6Later() == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        return false;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (OSUtils.isMIUI6Later() == false) goto L5;
    L10:
        return true;
    L5:
        if (OSUtils.isFlymeOS4Later() == true) goto L10;
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        return false;
    }

    private void setBar() {
        checkNavigationBarInitialized();
        int r100 = 256;
        if (OSUtils.isEMUI3_x() == true) goto L5;
        fitsNotchScreen();
        int r101 = setStatusBarDarkFont(initBarAboveLOLLIPOP(256));
        checkNavigationBarFlag();
        r100 = setNavigationIconDark(r101);
    L6:
        int r102 = hideBar(r100);
        fitsWindows();
        this.mDecorView.setSystemUiVisibility(r102);
        if (OSUtils.isMIUI6Later() == false) goto L12;
        setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
        BarParams r103 = this.mBarParams;
        if (r103.navigationBarEnable == false) goto L12;
        setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, r103.navigationBarDarkIcon);
    L12:
        if (OSUtils.isFlymeOS4Later() == false) goto L18;
        BarParams r104 = this.mBarParams;
        int r105 = r104.flymeOSStatusBarFontColor;
        if (r105 == 0) goto L16;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, r105);
        return;
    L16:
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, r104.statusBarDarkFont);
        return;
    L18:
        return;
    L5:
        initBarBelowLOLLIPOP();
        goto L6
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        if (OSUtils.isEMUI3_x() == false) goto L7;
        BarParams r100 = this.mBarParams;
        if (r100.navigationBarWithKitkatEnable == false) goto L7;
        r100.navigationBarWithKitkatEnable = r100.navigationBarWithEMUI3Enable;
    L7:
        this.mBarConfig = new BarConfig(this.mActivity);
        if (this.mIsFragment == false) goto L13;
        ImmersionBar r101 = mImmersionBarMap.get(this.mActivity.toString());
        if (r101 == null) goto L14;
        r101.mBarParams = this.mBarParams;
        return;
    L14:
        return;
    }

    public void destroy() {
        cancelListener();
        Iterator<Map.Entry<String, ImmersionBar>> r100 = mImmersionBarMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Map.Entry<String, ImmersionBar> r101 = r100.next();
        if (r101.getKey().contains(this.mImmersionBarName) == true) goto L9;
        if (r101.getKey().equals(this.mImmersionBarName) == false) goto L4;
    L9:
        r100.remove();
        goto L4
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    private ImmersionBar(Activity r100) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r100;
        this.mWindow = r100.getWindow();
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new BarParams();
        ViewGroup r101 = (ViewGroup) INVOKEVIRTUAL_com_gyf_barlibrary_ImmersionBar_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
        this.mDecorView = r101;
        this.mContentView = (ViewGroup) r101.findViewById(R.id.content);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_gyf_barlibrary_ImmersionBar_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static View INVOKEVIRTUAL_com_gyf_barlibrary_ImmersionBar_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ BarConfig access$000(ImmersionBar r100) {
        return r100.mBarConfig;
    }

    public static /* synthetic */ Activity access$100(ImmersionBar r100) {
        return r100.mActivity;
    }

    public static /* synthetic */ ViewGroup access$200(ImmersionBar r100) {
        return r100.mContentView;
    }

    public static /* synthetic */ ViewGroup access$300(ImmersionBar r100) {
        return r100.mDecorView;
    }

    public static /* synthetic */ int access$400(ImmersionBar r100) {
        return r100.mNavigationBarHeight;
    }

    public static /* synthetic */ int access$500(ImmersionBar r100) {
        return r100.mNavigationBarWidth;
    }

    public static /* synthetic */ BarParams access$600(ImmersionBar r100) {
        return r100.mBarParams;
    }

    public static boolean checkFitsSystemWindows(View r100) {
        if (r100.getFitsSystemWindows() == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof DrawerLayout) == false) goto L15;
        if (checkFitsSystemWindows(r104) == false) goto L15;
        return true;
    L15:
        if (r104.getFitsSystemWindows() == true) goto L16;
        r103 = r103 + 1;
        goto L8
    L16:
        return true;
    L18:
        return false;
    }

    public static int destroyAll(String r100) {
        int r101 = 0;
        Iterator<Map.Entry<String, ImmersionBar>> r102 = mImmersionBarMap.entrySet().iterator();     // Catch: Exception -> L10
    L5:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, ImmersionBar> r103 = r102.next();     // Catch: Exception -> L10
        if (r103.getKey().startsWith(r100) == false) goto L5;
        r101 = r101 + 1;     // Catch: Exception -> L10
        r103.getValue().cancelListener();     // Catch: Exception -> L10
        r102.remove();     // Catch: Exception -> L10
    L12:
        return r101;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static int getActionBarHeight(Activity r100) {
        return new BarConfig(r100).getActionBarHeight();
    }

    public static int getNavigationBarHeight(Activity r100) {
        return new BarConfig(r100).getNavigationBarHeight();
    }

    public static int getNavigationBarWidth(Activity r100) {
        return new BarConfig(r100).getNavigationBarWidth();
    }

    public static int getStatusBarHeight(Activity r100) {
        return new BarConfig(r100).getStatusBarHeight();
    }

    public static boolean hasNavigationBar(Activity r100) {
        return new BarConfig(r100).hasNavigationBar();
    }

    public static boolean hasNotchScreen(Activity r100) {
        return new BarConfig(r100).hasNotchScreen();
    }

    private int hideBar(int r100) {
        int r101 = AnonymousClass3.$SwitchMap$com$gyf$barlibrary$BarHide[this.mBarParams.barHide.ordinal()];
        if (r101 != 1) goto L5;
        r100 = r100 | 518;
    L16:
        return r100 | 4096;
    L5:
        if (r101 != 2) goto L7;
        r100 = r100 | 1028;
        goto L16
    L7:
        if (r101 != 3) goto L9;
        r100 = r100 | 514;
        goto L16
    L9:
        if (r101 != 4) goto L16;
        r100 = r100 | 0;
        goto L16
    }

    public static void hideStatusBar(Window r100) {
        r100.setFlags(1024, 1024);
    }

    private int initBarAboveLOLLIPOP(int r100) {
        if (this.mHasNavigationBarColor == true) goto L5;
        BarParams r101 = this.mBarParams;
        r101.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
        this.mHasNavigationBarColor = true;
    L5:
        int r102 = r100 | 1024;
        BarParams r103 = this.mBarParams;
        if (r103.fullScreen == true) goto L8;
    L10:
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar() == false) goto L13;
        this.mWindow.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L13:
        this.mWindow.addFlags(Integer.MIN_VALUE);
        BarParams r104 = this.mBarParams;
        if (r104.statusBarColorEnabled == false) goto L16;
        this.mWindow.setStatusBarColor(ColorUtils.blendARGB(r104.statusBarColor, r104.statusBarColorTransform, r104.statusBarAlpha));
    L17:
        BarParams r105 = this.mBarParams;
        if (r105.navigationBarEnable == false) goto L20;
        this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(r105.navigationBarColor, r105.navigationBarColorTransform, r105.navigationBarAlpha));
    L21:
        return r102;
    L20:
        this.mWindow.setNavigationBarColor(r105.defaultNavigationBarColor);
        goto L21
    L16:
        this.mWindow.setStatusBarColor(ColorUtils.blendARGB(r104.statusBarColor, 0, r104.statusBarAlpha));
        goto L17
    L8:
        if (r103.navigationBarEnable == false) goto L10;
        r102 = r102 | 512;
        goto L10
    }

    private static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.trim().length() == 0) goto L7;
        return false;
    }

    public static boolean isNavigationAtBottom(Activity r100) {
        return new BarConfig(r100).isNavigationAtBottom();
    }

    public static void setFitsSystemWindows(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.content);
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof ViewGroup) == false) goto L12;
        if ((r104 instanceof DrawerLayout) == true) goto L12;
        r104.setFitsSystemWindows(true);
        ((ViewGroup) r104).setClipToPadding(true);
    L12:
        r103 = r103 + 1;
        goto L5
    }

    private int setNavigationIconDark(int r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return r100;
    L5:
        if (this.mBarParams.navigationBarDarkIcon == true) goto L7;
        return r100;
    L7:
        return r100 | 16;
    }

    private int setStatusBarDarkFont(int r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return r100;
    L5:
        if (this.mBarParams.statusBarDarkFont == true) goto L7;
        return r100;
    L7:
        return r100 | 8192;
    }

    public static ImmersionBar with(DialogFragment r100) {
        if (r100.getActivity() == null) goto L9;
        ImmersionBar r101 = mImmersionBarMap.get(r100.getActivity().toString() + r100.toString());
        if (r101 != null) goto L10;
        ImmersionBar r102 = new ImmersionBar(r100);
        mImmersionBarMap.put(r100.getActivity().toString() + r100.toString(), r102);
        return r102;
    L10:
        return r101;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public ImmersionBar addTag(String r100) {
        if (isEmpty(r100) == true) goto L7;
        BarParams r101 = this.mBarParams.clone();
        this.mTagMap.put(r100, r101);
        return this;
    L7:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar addViewSupportTransformColor(View r100) {
        return addViewSupportTransformColorInt(r100, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar autoDarkModeEnable(boolean r100) {
        return autoDarkModeEnable(r100, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r100) {
        return autoNavigationBarDarkModeEnable(r100, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r100) {
        return autoStatusBarDarkModeEnable(r100, 0.2f);
    }

    public ImmersionBar barAlpha(float r100) {
        BarParams r101 = this.mBarParams;
        r101.statusBarAlpha = r100;
        r101.navigationBarAlpha = r100;
        return this;
    }

    public ImmersionBar barColor(int r100) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar barColorInt(int r100) {
        BarParams r101 = this.mBarParams;
        r101.statusBarColor = r100;
        r101.navigationBarColor = r100;
        r101.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar barColorTransform(int r100) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar barColorTransformInt(int r100) {
        BarParams r101 = this.mBarParams;
        r101.statusBarColorTransform = r100;
        r101.navigationBarColorTransform = r100;
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean r100) {
        this.mBarParams.fits = r100;
        if (r100 == true) goto L5;
        this.mFitsStatusBarType = 0;
    L8:
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L8;
        this.mFitsStatusBarType = 4;
        goto L8
    }

    public ImmersionBar fixMarginAtBottom(boolean r100) {
        this.mBarParams.fixMarginAtBottom = r100;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int r100) {
        BarParams r101 = this.mBarParams;
        r101.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, r100);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int r100) {
        this.mBarParams.flymeOSStatusBarFontColor = r100;
        return this;
    }

    public ImmersionBar fullScreen(boolean r100) {
        this.mBarParams.fullScreen = r100;
        return this;
    }

    public ImmersionBar getTag(String r100) {
        if (isEmpty(r100) == true) goto L9;
        BarParams r101 = this.mTagMap.get(r100);
        if (r101 == null) goto L7;
        this.mBarParams = r101.clone();
    L7:
        return this;
    L9:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar keyboardEnable(boolean r100) {
        return keyboardEnable(r100, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardMode(int r100) {
        this.mBarParams.keyboardMode = r100;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float r100) {
        this.mBarParams.navigationBarAlpha = r100;
        return this;
    }

    public ImmersionBar navigationBarColor(int r100) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar navigationBarColorInt(int r100) {
        BarParams r101 = this.mBarParams;
        r101.navigationBarColor = r100;
        r101.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int r100) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar navigationBarColorTransformInt(int r100) {
        this.mBarParams.navigationBarColorTransform = r100;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean r100) {
        return navigationBarDarkIcon(r100, 0.2f);
    }

    public ImmersionBar navigationBarEnable(boolean r100) {
        this.mBarParams.navigationBarEnable = r100;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean r100) {
        this.mBarParams.navigationBarWithEMUI3Enable = r100;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean r100) {
        this.mBarParams.navigationBarWithKitkatEnable = r100;
        return this;
    }

    public ImmersionBar removeSupportView(View r100) {
        if (r100 == null) goto L10;
        Map<Integer, Integer> r101 = this.mBarParams.viewMap.get(r100);
        if (r101 != null) goto L6;
    L8:
        return this;
    L6:
        if (r101.size() == 0) goto L8;
        this.mBarParams.viewMap.remove(r100);
        goto L8
    L10:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener r100) {
        BarParams r101 = this.mBarParams;
        if (r101.onKeyboardListener != null) goto L5;
        r101.onKeyboardListener = r100;
    L5:
        return this;
    }

    public ImmersionBar statusBarAlpha(float r100) {
        this.mBarParams.statusBarAlpha = r100;
        return this;
    }

    public ImmersionBar statusBarColor(int r100) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar statusBarColorInt(int r100) {
        this.mBarParams.statusBarColor = r100;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int r100) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, r100));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean r100) {
        this.mBarParams.statusBarColorEnabled = r100;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(int r100) {
        this.mBarParams.statusBarColorTransform = r100;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean r100) {
        return statusBarDarkFont(r100, 0.2f);
    }

    public ImmersionBar statusBarView(View r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.mBarParams.statusBarView = r100;
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 3;
    L7:
        return this;
    }

    public ImmersionBar supportActionBar(boolean r100) {
        this.mBarParams.isSupportActionBar = r100;
        return this;
    }

    public ImmersionBar titleBar(View r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        return titleBar(r100, true);
    }

    public ImmersionBar titleBarMarginTop(int r100) {
        Fragment r101 = this.mFragment;
        if (r101 == null) goto L9;
        if (r101.getView() == null) goto L9;
        return titleBarMarginTop(this.mFragment.getView().findViewById(r100));
    L9:
        return titleBarMarginTop(this.mActivity.findViewById(r100));
    }

    public ImmersionBar viewAlpha(float r100) {
        this.mBarParams.viewAlpha = r100;
        return this;
    }

    private ImmersionBar(DialogFragment r100) {
        this(r100, r100.getDialog());
    }

    public static boolean hasNotchScreen(View r100) {
        return NotchUtils.hasNotchScreen(r100);
    }

    public static ImmersionBar with(Fragment r100) {
        if (r100.getActivity() == null) goto L9;
        ImmersionBar r101 = mImmersionBarMap.get(r100.getActivity().toString() + r100.toString());
        if (r101 != null) goto L10;
        ImmersionBar r102 = new ImmersionBar(r100);
        mImmersionBarMap.put(r100.getActivity().toString() + r100.toString(), r102);
        return r102;
    L10:
        return r101;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public ImmersionBar barColor(String r100) {
        return barColorInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar barColorTransform(String r100) {
        return barColorTransformInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar flymeOSStatusBarFontColor(String r100) {
        BarParams r101 = this.mBarParams;
        r101.flymeOSStatusBarFontColor = ColorProtector.parseColor(r100);
        return this;
    }

    public ImmersionBar hideBar(BarHide r100) {
        this.mBarParams.barHide = r100;
        if (OSUtils.isEMUI3_x() == false) goto L11;
        BarParams r101 = this.mBarParams;
        r101.useDefaultNavigationBarColor = false;
        BarHide r102 = r101.barHide;
        if (r102 != BarHide.FLAG_HIDE_NAVIGATION_BAR) goto L7;
    L10:
        r101.hideNavigationBar = true;
        goto L11
    L7:
        if (r102 == BarHide.FLAG_HIDE_BAR) goto L10;
        r101.hideNavigationBar = false;
    L11:
        return this;
    }

    public ImmersionBar navigationBarColor(String r100) {
        return navigationBarColorInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar navigationBarColorTransform(String r100) {
        return navigationBarColorTransformInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar statusBarColor(String r100) {
        return statusBarColorInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar statusBarColorTransform(String r100) {
        return statusBarColorTransformInt(ColorProtector.parseColor(r100));
    }

    public ImmersionBar statusBarView(int r100) {
        return statusBarView(this.mActivity.findViewById(r100));
    }

    public ImmersionBar titleBar(int r100) {
        return titleBar(r100, true);
    }

    public ImmersionBar titleBarMarginTop(View r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 2;
    L7:
        this.mBarParams.titleBarView = r100;
        return this;
    }

    private ImmersionBar(Fragment r100) {
        this(r100.getActivity(), r100);
    }

    public static ImmersionBar with(Activity r100) {
        ImmersionBar r101 = mImmersionBarMap.get(r100.toString());
        if (r101 != null) goto L6;
        ImmersionBar r102 = new ImmersionBar(r100);
        mImmersionBarMap.put(r100.toString(), r102);
        return r102;
    L6:
        return r101;
    }

    private ImmersionBar(DialogFragment r100, Dialog r101) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        FragmentActivity r102 = r100.getActivity();
        this.mActivity = r102;
        this.mFragment = r100;
        this.mDialog = r101;
        if (r102 == null) goto L14;
        if (r101 == null) goto L12;
        if (mImmersionBarMap.get(r102.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = this.mActivity.toString() + r100.toString();
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog in DialogFragment cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public static /* synthetic */ BarConfig access$002(ImmersionBar r100, BarConfig r101) {
        r100.mBarConfig = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(ImmersionBar r100, int r101) {
        r100.mNavigationBarHeight = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(ImmersionBar r100, int r101) {
        r100.mNavigationBarWidth = r101;
        return r101;
    }

    public static void setStatusBarView(Activity r100, View r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = getStatusBarHeight(r100);
        r101.setLayoutParams(r102);
    }

    public static void setTitleBar(final Activity r100, final View r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        final ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        int r103 = r102.height;
        if (r103 != (-2)) goto L9;
    L12:
        r101.post(new AnonymousClass2(r102, r101, r100));
        return;
    L9:
        if (r103 == (-1)) goto L12;
        r102.height = r103 + getStatusBarHeight(r100);
        r101.setPadding(r101.getPaddingLeft(), r101.getPaddingTop() + getStatusBarHeight(r100), r101.getPaddingRight(), r101.getPaddingBottom());
    }

    public static void setTitleBarMarginTop(Activity r100, View r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
        r102.setMargins(r102.leftMargin, r102.topMargin + getStatusBarHeight(r100), r102.rightMargin, r102.bottomMargin);
    }

    public static ImmersionBar with(DialogFragment r100, Dialog r101) {
        if (r100.getActivity() == null) goto L9;
        ImmersionBar r102 = mImmersionBarMap.get(r100.getActivity().toString() + r100.toString());
        if (r102 != null) goto L10;
        ImmersionBar r103 = new ImmersionBar(r100, r101);
        mImmersionBarMap.put(r100.getActivity().toString() + r100.toString(), r103);
        return r103;
    L10:
        return r102;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public ImmersionBar addViewSupportTransformColor(View r100, int r101) {
        return addViewSupportTransformColorInt(r100, ContextCompat.getColor(this.mActivity, r101));
    }

    public ImmersionBar addViewSupportTransformColorInt(View r100, int r101) {
        if (r100 == null) goto L6;
        HashMap r102 = new HashMap();
        r102.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(r101));
        this.mBarParams.viewMap.put(r100, r102);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar autoDarkModeEnable(boolean r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.autoStatusBarDarkModeEnable = r100;
        r102.autoStatusBarDarkModeAlpha = r101;
        r102.autoNavigationBarDarkModeEnable = r100;
        r102.autoNavigationBarDarkModeAlpha = r101;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.autoNavigationBarDarkModeEnable = r100;
        r102.autoNavigationBarDarkModeAlpha = r101;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.autoStatusBarDarkModeEnable = r100;
        r102.autoStatusBarDarkModeAlpha = r101;
        return this;
    }

    public ImmersionBar barColor(int r100, float r101) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r100), r100);
    }

    public ImmersionBar barColorInt(int r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.statusBarColor = r100;
        r102.navigationBarColor = r100;
        r102.useDefaultNavigationBarColor = false;
        r102.statusBarAlpha = r101;
        r102.navigationBarAlpha = r101;
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean r100, int r101) {
        return fitsSystemWindowsInt(r100, ContextCompat.getColor(this.mActivity, r101));
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r100, int r101) {
        return fitsSystemWindowsInt(r100, r101, -16777216, 0.0f);
    }

    public ImmersionBar keyboardEnable(boolean r100, int r101) {
        BarParams r102 = this.mBarParams;
        r102.keyboardEnable = r100;
        r102.keyboardMode = r101;
        return this;
    }

    public ImmersionBar navigationBarColor(int r100, float r101) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r100), r101);
    }

    public ImmersionBar navigationBarColorInt(int r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.navigationBarColor = r100;
        r102.useDefaultNavigationBarColor = false;
        r102.navigationBarAlpha = r101;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean r100, float r101) {
        this.mBarParams.navigationBarDarkIcon = r100;
        if (r100 == true) goto L5;
    L7:
        this.mBarParams.navigationBarAlpha = 0.0f;
    L8:
        return this;
    L5:
        if (isSupportNavigationIconDark() == true) goto L7;
        this.mBarParams.navigationBarAlpha = r101;
        goto L8
    }

    public ImmersionBar statusBarColor(int r100, float r101) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r100), r101);
    }

    public ImmersionBar statusBarColorInt(int r100, float r101) {
        BarParams r102 = this.mBarParams;
        r102.statusBarColor = r100;
        r102.statusBarAlpha = r101;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean r100, float r101) {
        this.mBarParams.statusBarDarkFont = r100;
        if (r100 == true) goto L5;
    L7:
        BarParams r102 = this.mBarParams;
        r102.flymeOSStatusBarFontColor = 0;
        r102.statusBarAlpha = 0.0f;
    L8:
        return this;
    L5:
        if (isSupportStatusBarDarkFont() == true) goto L7;
        this.mBarParams.statusBarAlpha = r101;
        goto L8
    }

    public ImmersionBar statusBarView(int r100, View r101) {
        return statusBarView(r101.findViewById(r100));
    }

    public ImmersionBar titleBar(int r100, boolean r101) {
        Fragment r102 = this.mFragment;
        if (r102 == null) goto L9;
        if (r102.getView() == null) goto L9;
        return titleBar(this.mFragment.getView().findViewById(r100), r101);
    L9:
        return titleBar(this.mActivity.findViewById(r100), r101);
    }

    public ImmersionBar titleBarMarginTop(int r100, View r101) {
        return titleBarMarginTop(r101.findViewById(r100));
    }

    private ImmersionBar(Activity r100, Fragment r101) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r100;
        this.mFragment = r101;
        if (r100 == null) goto L11;
        if (mImmersionBarMap.get(r100.toString()) == null) goto L9;
        this.mIsFragment = true;
        this.mWindow = this.mActivity.getWindow();
        this.mImmersionBarName = r100.toString() + r101.toString();
        initParams();
        return;
    L9:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L11:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public static ImmersionBar with(Activity r100, Dialog r101) {
        ImmersionBar r102 = mImmersionBarMap.get(r100.toString() + r101.toString());
        if (r102 != null) goto L6;
        ImmersionBar r103 = new ImmersionBar(r100, r101);
        mImmersionBarMap.put(r100.toString() + r101.toString(), r103);
        return r103;
    L6:
        return r102;
    }

    public ImmersionBar addViewSupportTransformColor(View r100, String r101) {
        return addViewSupportTransformColorInt(r100, ColorProtector.parseColor(r101));
    }

    public ImmersionBar barColor(String r100, float r101) {
        return barColorInt(ColorProtector.parseColor(r100), r101);
    }

    public ImmersionBar navigationBarColor(String r100, float r101) {
        return navigationBarColorInt(ColorProtector.parseColor(r100), r101);
    }

    public ImmersionBar statusBarColor(String r100, float r101) {
        return statusBarColorInt(ColorProtector.parseColor(r100), r101);
    }

    public ImmersionBar titleBar(View r100, boolean r101) {
        if (r100 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 1;
    L7:
        BarParams r102 = this.mBarParams;
        r102.titleBarView = r100;
        r102.statusBarColorEnabled = r101;
        return this;
    }

    private ImmersionBar(Activity r100, Dialog r101) {
        this(r100, r101, "");
    }

    public static ImmersionBar with(Activity r100, Fragment r101) {
        ImmersionBar r102 = mImmersionBarMap.get(r100.toString() + r101.toString());
        if (r102 != null) goto L6;
        ImmersionBar r103 = new ImmersionBar(r100, r101);
        mImmersionBarMap.put(r100.toString() + r101.toString(), r103);
        return r103;
    L6:
        return r102;
    }

    public ImmersionBar titleBar(int r100, View r101) {
        return titleBar(r101.findViewById(r100), true);
    }

    private ImmersionBar(Activity r100, Dialog r101, String r102) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r100;
        this.mDialog = r101;
        if (r100 == null) goto L14;
        if (r101 == null) goto L12;
        if (mImmersionBarMap.get(r100.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = r100.toString() + r101.toString() + r102;
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private void setMIUIBarDark(Window r100, String r101, boolean r110) {
        if (r100 == null) goto L13;
        Class<?> r102 = r100.getClass();
        Class r103 = INVOKESTATIC_com_gyf_barlibrary_ImmersionBar_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L9
        int r104 = r103.getField(r101).getInt(r103);     // Catch: Exception -> L9
        Class<?> r105 = Integer.TYPE;     // Catch: Exception -> L9
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Exception -> L9
        if (r110 == false) goto L7;
        r106.invoke(r100, new Object[]{Integer.valueOf(r104), Integer.valueOf(r104)});     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r106.invoke(r100, new Object[]{0, Integer.valueOf(r104)});     // Catch: Exception -> L9
    L14:
        return;
    }

    public static ImmersionBar with(Activity r100, Dialog r101, String r102) {
        ImmersionBar r103 = mImmersionBarMap.get(r100.toString() + r101.toString() + r102);
        if (r103 != null) goto L6;
        ImmersionBar r104 = new ImmersionBar(r100, r101, r102);
        mImmersionBarMap.put(r100.toString() + r101.toString() + r102, r104);
        return r104;
    L6:
        return r103;
    }

    public ImmersionBar addViewSupportTransformColor(View r100, int r101, int r102) {
        return addViewSupportTransformColorInt(r100, ContextCompat.getColor(this.mActivity, r101), ContextCompat.getColor(this.mActivity, r102));
    }

    public ImmersionBar addViewSupportTransformColorInt(View r100, int r101, int r102) {
        if (r100 == null) goto L6;
        HashMap r103 = new HashMap();
        r103.put(Integer.valueOf(r101), Integer.valueOf(r102));
        this.mBarParams.viewMap.put(r100, r103);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar barColor(int r100, int r101, float r102) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r100), ContextCompat.getColor(this.mActivity, r101), r102);
    }

    public ImmersionBar barColorInt(int r100, int r101, float r102) {
        BarParams r103 = this.mBarParams;
        r103.statusBarColor = r100;
        r103.navigationBarColor = r100;
        r103.useDefaultNavigationBarColor = false;
        r103.statusBarColorTransform = r101;
        r103.navigationBarColorTransform = r101;
        r103.statusBarAlpha = r102;
        r103.navigationBarAlpha = r102;
        return this;
    }

    public ImmersionBar navigationBarColor(int r100, int r101, float r102) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r100), ContextCompat.getColor(this.mActivity, r101), r102);
    }

    public ImmersionBar navigationBarColorInt(int r100, int r101, float r102) {
        BarParams r103 = this.mBarParams;
        r103.navigationBarColor = r100;
        r103.useDefaultNavigationBarColor = false;
        r103.navigationBarColorTransform = r101;
        r103.navigationBarAlpha = r102;
        return this;
    }

    public ImmersionBar statusBarColor(int r100, int r101, float r102) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r100), ContextCompat.getColor(this.mActivity, r101), r102);
    }

    public ImmersionBar statusBarColorInt(int r100, int r101, float r102) {
        BarParams r103 = this.mBarParams;
        r103.statusBarColor = r100;
        r103.statusBarColorTransform = r101;
        r103.statusBarAlpha = r102;
        return this;
    }

    public ImmersionBar titleBar(int r100, View r101, boolean r102) {
        return titleBar(r101.findViewById(r100), r102);
    }

    public ImmersionBar addViewSupportTransformColor(View r100, String r101, String r102) {
        return addViewSupportTransformColorInt(r100, ColorProtector.parseColor(r101), ColorProtector.parseColor(r102));
    }

    public ImmersionBar barColor(String r100, String r101, float r102) {
        return barColorInt(ColorProtector.parseColor(r100), ColorProtector.parseColor(r101), r102);
    }

    public ImmersionBar navigationBarColor(String r100, String r101, float r102) {
        return navigationBarColorInt(ColorProtector.parseColor(r100), ColorProtector.parseColor(r101), r102);
    }

    public ImmersionBar statusBarColor(String r100, String r101, float r102) {
        return statusBarColorInt(ColorProtector.parseColor(r100), ColorProtector.parseColor(r101), r102);
    }

    private void setPadding(int r100, int r101, int r102, int r103) {
        ViewGroup r104 = this.mContentView;
        if (r104 == null) goto L5;
        r104.setPadding(r100, r101, r102, r103);
    L5:
        this.mPaddingLeft = r100;
        this.mPaddingTop = r101;
        this.mPaddingRight = r102;
        this.mPaddingBottom = r103;
    }

    public ImmersionBar fitsSystemWindows(boolean r100, int r101, int r102, float r103) {
        return fitsSystemWindowsInt(r100, ContextCompat.getColor(this.mActivity, r101), ContextCompat.getColor(this.mActivity, r102), r103);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r100, int r101, int r102, float r103) {
        BarParams r104 = this.mBarParams;
        r104.fits = r100;
        r104.contentColor = r101;
        r104.contentColorTransform = r102;
        r104.contentAlpha = r103;
        if (r100 == true) goto L5;
        this.mFitsStatusBarType = 0;
    L8:
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(r101, r102, r103));
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L8;
        this.mFitsStatusBarType = 4;
        goto L8
    }

    public static /* synthetic */ void access$700(ImmersionBar r100, int r101, int r102, int r103, int r104) {
        r100.setPadding(r101, r102, r103, r104);
    }
}
