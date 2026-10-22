package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MagicWindowUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/utils/WindowModeUtils;", "", "()V", "FREE_FORM_MODE", "", "HW_FREE_FORM_MODE", "OPPO_FREE_FORM_MODE", "OPPO_SPLIT_SCREEN_MODE", "TAG", "configuration", "Landroid/content/res/Configuration;", "navHeight", "", "getNavHeight", "()I", "setNavHeight", "(I)V", "isActivityInMultiWindowMode", "", "activity", "Landroid/app/Activity;", "isDeviceInMultiWindowMode", "isInFreeFromMode", "isSupportedFoldDisplay", "isXiaomiInMultiWindowMode", "setConfiguration", "", "newConfiguration", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WindowModeUtils {
    private static final String FREE_FORM_MODE = "mWindowingMode=freeform";
    private static final String HW_FREE_FORM_MODE = "mWindowingMode=hwMultiwindow-freeform";
    public static final WindowModeUtils INSTANCE = null;
    private static final String OPPO_FREE_FORM_MODE = "mWindowingMode=100";
    private static final String OPPO_SPLIT_SCREEN_MODE = "mScenario= 2";
    private static final String TAG = "WindowModeUtils";
    private static Configuration configuration;
    private static int navHeight;

    static {
        INSTANCE = new WindowModeUtils();
    }

    private WindowModeUtils() {
    }

    @JvmStatic
    public static final boolean isSupportedFoldDisplay() {
        return false;
    }

    public final boolean isInFreeFromMode() {
        Configuration r0 = configuration;
        if (r0 == null) goto L14;
        String r1 = r0.toString();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r1, FREE_FORM_MODE, false, 2, null) == false) goto L9;
    L12:
        return true;
    L9:
        if (StringsKt.contains$default(r1, HW_FREE_FORM_MODE, false, 2, null) == true) goto L12;
        if (StringsKt.contains$default(r1, OPPO_FREE_FORM_MODE, false, 2, null) == true) goto L12;
        return false;
    L14:
        return false;
    }

    public final int getNavHeight() {
        return navHeight;
    }

    public final boolean isActivityInMultiWindowMode(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L7:
        return false;
    L5:
        if (isDeviceInMultiWindowMode(r3) == false) goto L7;
        return true;
    }

    public final boolean isDeviceInMultiWindowMode(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (r2.isInMultiWindowMode() == false) goto L7;
        if (MagicWindowUtil.isXiaomi() == true) goto L7;
    L8:
        return true;
    L7:
        if (isXiaomiInMultiWindowMode(r2) == true) goto L8;
        return false;
    }

    public final boolean isXiaomiInMultiWindowMode(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (MagicWindowUtil.isXiaomi() == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.isInMultiWindowMode() == false) goto L9;
        if (MagicWindowUtil.isMagicWindow(r2) == true) goto L9;
        return true;
    }

    public final void setConfiguration(Configuration r3) {
        Log.i(TAG, "newConfiguration: " + r3);
        configuration = r3;
    }

    public final void setNavHeight(int r1) {
        navHeight = r1;
    }
}
