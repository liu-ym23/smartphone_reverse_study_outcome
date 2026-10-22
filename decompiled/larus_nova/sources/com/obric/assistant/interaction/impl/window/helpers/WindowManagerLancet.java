package com.obric.assistant.interaction.impl.window.helpers;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import me.ele.lancet.base.Origin;

/* JADX INFO: loaded from: classes33.dex */
public final class WindowManagerLancet {
    private static final String TAG = "WindowManagerLancet";

    public WindowManagerLancet() {
    }

    public static boolean isApplicationWindow(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof WindowManager.LayoutParams) == true) goto L6;
        FLogger.f375446a.w(TAG, "Skip child window binding: params are not WindowManager.LayoutParams");
        return false;
    L6:
        int r101 = ((WindowManager.LayoutParams) r100).type;
        if (r101 >= 1) goto L9;
        return false;
    L9:
        if (r101 > 99) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean bindApplicationWindowToParentIfNeeded(IBinder r100, ViewGroup.LayoutParams r101) {
        if (r100 != null) goto L4;
    L8:
        FLogger.f375446a.w(TAG, "Skip child window binding: parent token is null or not an application window");
        return false;
    L4:
        if (isApplicationWindow(r101) == false) goto L8;
        WindowManager.LayoutParams r102 = (WindowManager.LayoutParams) r101;
        r102.token = r100;
        r102.type = 1000;
        return true;
    }

    public static boolean bindToAssistantWindowIfNeeded(View r100, ViewGroup.LayoutParams r101) {
        if (r100 != null) goto L7;
        FLogger.f375446a.w(TAG, "Skip child window binding: view is null");
        return false;
    L7:
        if (ChatWindowServiceDelegate.f392926b.d(r100.getContext()) == true) goto L10;
        return false;
    L10:
        if ((r101 instanceof WindowManager.LayoutParams) == true) goto L13;
        FLogger.f375446a.w(TAG, "Skip child window binding: params are not WindowManager.LayoutParams, view=".concat(r100.getClass().getName()));
        return false;
    L13:
        WindowManager.LayoutParams r102 = (WindowManager.LayoutParams) r101;
        int r103 = r102.type;
        if (isApplicationWindow(r101) == true) goto L17;
        FLogger.f375446a.i(TAG, "Skip child window binding: not an application window, type=" + r103 + ", view=" + r100.getClass().getName());
        return false;
    L17:
        IBinder r104 = WindowHost.INSTANCE.getChildWindowParentToken();
        if (r104 != null) goto L21;
        FLogger.f375446a.w(TAG, "Skip child window binding: assistant Window token is unavailable, type=" + r103 + ", view=" + r100.getClass().getName());
        return false;
    L21:
        boolean r105 = bindApplicationWindowToParentIfNeeded(r104, r101);
        FLogger.f375446a.i(TAG, "Application window bound as assistant child window, originalType=" + r103 + ", targetType=" + r102.type + ", view=" + r100.getClass().getName());
        return r105;
    }

    public void addView(View r100, ViewGroup.LayoutParams r101) {
        bindToAssistantWindowIfNeeded(r100, r101);
        Origin.callVoid();
    }
}
