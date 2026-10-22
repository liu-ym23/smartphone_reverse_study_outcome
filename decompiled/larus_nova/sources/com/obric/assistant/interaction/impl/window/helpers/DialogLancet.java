package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.AssistantWindowContext;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.reflect.Field;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class DialogLancet {
    private static final String TAG = "DialogLancet";
    public static volatile Throwable sLastShowStack;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.window.helpers.DialogLancet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class DialogDismissRunnable implements Runnable {
        private final Dialog mDialog;

        @Override // java.lang.Runnable
        public void run() {
            com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable__run$___twin___() {
            DialogLancet.beforeDialogDismiss(this.mDialog);
            Dialog.class.getMethod("dismiss", new Class[0]).invoke(this.mDialog, new Object[0]);     // Catch: Throwable -> L5 Exception -> L7
        L11:
            DialogLancet.afterDialogDismiss(this.mDialog);
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L5
            Throwable r100 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L5
            if (r100 == null) goto L11;
            com.bytedance.crash.d.d(r100, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            DialogLancet.afterDialogDismiss(this.mDialog);
            throw th;
        }

        private DialogDismissRunnable(Dialog r100) {
            this.mDialog = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DialogDismissRunnable r100) {
            r100.com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ DialogDismissRunnable(Dialog r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public DialogLancet() {
    }

    public void dismiss() {
        Object r100 = This.get();
        Dialog r101 = (Dialog) r100;
        Handler r102 = resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L8:
        beforeDialogDismiss(r100);
        Origin.callVoid();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r103 = sLastShowStack;     // Catch: Throwable -> L11
        if (r103 == null) goto L10;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L8;
        r102.post(createDismissRunnable(r101));
    }

    public void show() {
        Object r100 = This.get();
        if (shouldBlockDialogShow(r100) == false) goto L10;
        handleBlockedDialogShow(r100);
        return;
    L10:
        sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        beforeDialogShow(r100);
        Origin.callVoid();
        afterDialogShow(r100);
    }

    public static void afterDialogDismiss(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r101 = (Dialog) r100;
        LandscapeRestrictionGuard.onDialogDismissed(r101);
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r101);
    }

    public static void afterDialogShow(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r101 = (Dialog) r100;
        LandscapeRestrictionGuard.onDialogShown(r101);
        LandscapeChildDialogBoundsAdapter.onDialogShown(r101);
        trackDialogIfNeeded(r101);
    }

    public static void beforeDialogDismiss(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r101 = (Dialog) r100;
        LandscapeRestrictionGuard.onDialogDismissed(r101);
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r101);
        untrackDialog(r101);
    }

    public static void beforeDialogShow(Object r100) {
        tryBindDialogToWindowHostIfNeeded(r100);
        if ((r100 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r101 = (Dialog) r100;
        LandscapeChildDialogBoundsAdapter.beginPreAddViewBoundsSession(r101);
        if (isPlainFrameworkDialog(r101) == false) goto L9;
        handleDialogPreAddViewOnStart(r101, "dialog:beforeShow");
        return;
    }

    public static Runnable createDismissRunnable(Dialog r100) {
        return new DialogDismissRunnable(r100, null);
    }

    public static void handleBlockedDialogShow(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L6;
        FLogger.f375446a.w(TAG, "handleBlockedDialogShow ignored, target is not Dialog");
        return;
    L6:
        Dialog r101 = (Dialog) r100;
        FLogger.f375446a.i(TAG, "handleBlockedDialogShow dialogClass=" + r101.getClass().getName() + ", dialogIdentity=" + System.identityHashCode(r101));
        PopupOrDialogVisibilityTracker.onDialogShowBlocked(r101);
    }

    public static boolean isDialogFromWindowContext(Dialog r100) {
        Context r101 = r100.getContext();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L13;
        if ((r101 instanceof ChatWindowActivity) == true) goto L7;
        if ((r101 instanceof AssistantWindowContext) == true) goto L10;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L10:
        return true;
    L7:
        return true;
    L13:
        if ((r101 instanceof ChatWindowActivity) == false) goto L15;
        return true;
    L15:
        if ((r101 instanceof AssistantWindowContext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public static boolean isPlainFrameworkDialog(Dialog r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Class<?> r101 = r100.getClass();
        if (isClassOrSuperclassNamed(r101, "androidx.activity.ComponentDialog") == false) goto L8;
        return false;
    L8:
        if (isClassOrSuperclassNamed(r101, "com.google.android.material.bottomsheet.BottomSheetDialog") == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isWindowChildDialog(Dialog r100) {
        Window r101 = r100.getWindow();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L13:
        return r102;
    L5:
        if (r101.getAttributes() == null) goto L13;
        IBinder r103 = r101.getAttributes().token;
        IBinder r104 = WindowHost.INSTANCE.getWindowToken();
        if (r103 == null) goto L11;
        if (r103 != r104) goto L11;
        r102 = true;
    L11:
        if (r102 == false) goto L13;
        FLogger.f375446a.i(TAG, "isWindowChildDialog matched, dialog = " + r100 + ", dialogToken = " + r103 + ", windowToken = " + r104);
        goto L13
    }

    public static Handler resolveDialogHandler(Dialog r100) {
        Field r101 = Dialog.class.getDeclaredField("mHandler");     // Catch: Throwable -> L8
        r101.setAccessible(true);     // Catch: Throwable -> L8
        Object r102 = r101.get(r100);     // Catch: Throwable -> L8
        if ((r102 instanceof Handler) == false) goto L11;
        return (Handler) r102;
    L11:
        return null;
    L12:
        return null;
    }

    public static OverlaySource resolveDialogSource(Dialog r100) {
        if (isWindowChildDialog(r100) == false) goto L7;
        return OverlaySource.WINDOW;
    L7:
        if (WindowUtils.INSTANCE.isChatActivityDialog(r100) == false) goto L10;
        FLogger.f375446a.i(TAG, "resolveDialogSource activity dialog = " + r100);
        return OverlaySource.ACTIVITY;
    L10:
        return null;
    }

    public static boolean shouldBlockDialogShow(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L5;
    L7:
        return false;
    L5:
        if (LandscapeRestrictionGuard.shouldBlockDialogShow((Dialog) r100) == false) goto L7;
        return true;
    }

    public static void trackDialogIfNeeded(Dialog r100) {
        if ((r100 instanceof AssistantChatDialog) == false) goto L5;
        return;
    L5:
        OverlaySource r101 = resolveDialogSource(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101 != OverlaySource.ACTIVITY) goto L11;
        FragmentActivity r102 = WindowUtils.INSTANCE.resolveChatActivityDialog(r100);
    L12:
        PopupOrDialogVisibilityTracker.onDialogShow(r100, r101, r102);
        FLogger.f375446a.i(TAG, "trackDialogIfNeeded track dialog = " + r100 + ", source = " + r101 + ", activity = " + r102);
        return;
    L11:
        r102 = null;
        goto L12
    }

    public static void tryBindDialogToWindowHostIfNeeded(Object r100) {
        if ((r100 instanceof Dialog) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof AssistantChatDialog) == false) goto L8;
        return;
    L8:
        Dialog r101 = (Dialog) r100;
        WindowHost r102 = WindowHost.INSTANCE;
        if (r102.isShowing() == true) goto L14;
        if (r102.isStashed() == true) goto L14;
        return;
    L14:
        if (isDialogFromWindowContext(r101) == true) goto L16;
        return;
    L16:
        Window r103 = r101.getWindow();
        if (r103 != null) goto L36;
        return;
    L36:
        if (r103 != r102.provideWindow()) goto L23;
        return;
    L23:
        WindowManager.LayoutParams r104 = r103.getAttributes();
        if (r104 != null) goto L26;
        return;
    L26:
        IBinder r105 = WindowHost.INSTANCE.getWindowToken();
        if (r105 != null) goto L30;
        return;
    L30:
        if (r104.token == r105) goto L32;
    L34:
        r104.token = r105;
        r104.type = 1000;
        r103.setAttributes(r104);
        return;
    L32:
        if (r104.type != 1000) goto L34;
    }

    public static void untrackDialog(Dialog r100) {
        PopupOrDialogVisibilityTracker.onDialogDismiss(r100);
        FLogger.f375446a.i(TAG, "untrackDialog dialog = " + r100);
    }

    public static void handleDialogPreAddViewOnStart(Object r100, String r101) {
        if ((r100 instanceof Dialog) == true) goto L5;
        return;
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogPreAddView((Dialog) r100, r101);
    }

    public static boolean isClassOrSuperclassNamed(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L8;
        if (r101.equals(r100.getName()) == true) goto L5;
        r100 = r100.getSuperclass();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }
}
