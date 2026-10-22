package com.bytedance.applet.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.bytedance.ai.bridge.service.ActionSheetBuilder;
import com.bytedance.ai.bridge.service.ActionSheetBuilderAction;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.PageTitleBar;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.applet.impl.dialog.AppletInputDialog;
import com.bytedance.applet.impl.dialog.AppletInputDialogCallbackStore;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonActionSheetDialog;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0 implements IHostStyleUIDepend {
    public final com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend a;

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ DialogBuilder a;

        public final void confirm() {
            DialogInterface.OnClickListener r0 = this.a.getPositiveClickListener();
            if (r0 == null) goto L6;
            r0.onClick(null, 0);
            return;
        }

        public b(DialogBuilder r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ DialogBuilder a;

        public final void cancel() {
            DialogInterface.OnClickListener r0 = this.a.getNegativeClickListener();
            if (r0 == null) goto L6;
            r0.onClick(null, 1);
            return;
        }

        public c(DialogBuilder r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.l1 {
        public final /* synthetic */ DialogBuilder a;

        public final void a() {
            DialogInterface.OnCancelListener r0 = this.a.getCancelOnTouchOutsideListener();
            if (r0 == null) goto L6;
            r0.onCancel(null);
            return;
        }

        public d(DialogBuilder r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void setPageNaviStyle(e3.a r1, Activity r2, PageTitleBar r3) {
    }

    public r0() {
        XBaseRuntime.a.getClass();
        this.a = XBaseRuntime.g;
    }

    public static boolean a(FragmentActivity r1) {
        if (r1.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isDestroyed() == true) goto L7;
        return true;
    }

    public final Boolean hideLoading(e3.a r4) {
        FragmentActivity r0 = null;
        if (r4 == null) goto L5;
        XBridge3ToAIBridgeAdapter.a r1 = new XBridge3ToAIBridgeAdapter.a(r4);
    L6:
        if (r1 == null) goto L8;
        Activity r2 = r1.getOwnerActivity();
    L10:
        if ((r2 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r3 = (FragmentActivity) r2;
    L13:
        if (r3 != null) goto L30;
        if (r4 == null) goto L16;
        Activity r5 = r4.getOwnerActivity();
    L18:
        if ((r5 instanceof FragmentActivity) == false) goto L20;
        r3 = (FragmentActivity) r5;
    L21:
        if (r3 != null) goto L30;
        Activity r6 = AppHost.a.a().getCurrentActivity();
        if ((r6 instanceof FragmentActivity) == false) goto L25;
        r0 = (FragmentActivity) r6;
    L25:
        if (r0 == null) goto L27;
        r3 = r0;
        goto L30
    L27:
        return Boolean.FALSE;
    L20:
        r3 = null;
        goto L21
    L16:
        r5 = null;
    L30:
        if (a(r3) == false) goto L44;
        if (r3.getSupportFragmentManager().isStateSaved() == true) goto L44;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L39
        Fragment r8 = r3.getSupportFragmentManager().findFragmentByTag("AppletHostLoadingDialog");     // Catch: Throwable -> L39
        if (r8 == null) goto L37;
        r3.getSupportFragmentManager().beginTransaction().remove(r8).commitAllowingStateLoss();     // Catch: Throwable -> L39
    L37:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L42:
        return Boolean.valueOf(Result.isSuccess-impl(r9));
    L39:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        return Boolean.FALSE;
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final Boolean hideToast(e3.a r2) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L4
        t19.s.a.a();     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L7:
        return Boolean.valueOf(Result.isSuccess-impl(r4));
    L4:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applet.impl.n0, java.lang.Object] */
    public final Boolean showDialog(DialogBuilder r19) {
        Intrinsics.checkNotNullParameter(r19, "dialogBuilder");
        Context r1 = r19.getContext();
    L3:
        if (r1 == null) goto L10;
        if ((r1 instanceof FragmentActivity) == true) goto L6;
        if ((r1 instanceof ContextWrapper) == false) goto L10;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L6:
        FragmentActivity r2 = (FragmentActivity) r1;
    L11:
        if (r2 != null) goto L20;
        Activity r3 = AppHost.a.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L15;
        r2 = (FragmentActivity) r3;
    L16:
        if (r2 != null) goto L20;
        return Boolean.FALSE;
    L15:
        r2 = null;
    L20:
        if (a(r2) == false) goto L80;
        if (r2.getSupportFragmentManager().isStateSaved() == true) goto L80;
        boolean r4 = false;
        if (r19.getEditable() == false) goto L47;
        final Function1 r5 = r19.getPositiveClickListenerWithInput();
        final DialogInterface.OnClickListener r8 = r19.getPositiveClickListener();
        final DialogInterface.OnClickListener r9 = r19.getNegativeClickListener();
        if (com.larus.utils.o0.d(r19.getNegativeBtnText()) == false) goto L30;
        if (r9 == null) goto L30;
        r4 = true;
    L30:
        int r7 = AppletInputDialog.e;
        String r10 = r19.getTitle();
        String r11 = r19.getMessage();
        String r12 = r19.getPlaceholderText();
        String r13 = r19.getPositiveBtnText();
        Integer r14 = r19.getPositiveBtnTextColor();
        String r15 = r19.getNegativeBtnText();
        Integer r16 = r19.getNegativeBtnTextColor();
        boolean r6 = r19.getCancelOnTouchOutside();
        ?? r0 = new n0(r5, r8);
        if (r4 == false) goto L33;
        o0 r17 = new o0(r9);
    L34:
        DialogInterface.OnCancelListener r18 = r19.getCancelOnTouchOutsideListener();
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r0, "onConfirm");
        String r20 = UUID.randomUUID().toString();
        FragmentActivity r110 = r2;
        ((AppletInputDialogCallbackStore) new ViewModelProvider(r2).get(AppletInputDialogCallbackStore.class)).register(r20, new AppletInputDialogCallbackStore.a(r0, r17, r18));
        AppletInputDialog r21 = new AppletInputDialog();
        Bundle r22 = new Bundle();
        r22.putString("request_id", r20);
        r22.putCharSequence("title", r10);
        r22.putCharSequence("message", r11);
        r22.putCharSequence("placeholder", r12);
        r22.putString("confirm_text", r13);
        if (r14 == null) goto L37;
        r22.putInt("confirm_text_color", r14.intValue());
    L37:
        r22.putString("cancel_text", r15);
        if (r16 == null) goto L40;
        r22.putInt("cancel_text_color", r16.intValue());
    L40:
        r22.putBoolean("show_cancel", r4);
        r22.putBoolean("canceled_on_touch_outside", r6);
        r21.setArguments(r22);
        FragmentManager r23 = r110.getSupportFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r21, "AppletHostInputDialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r21, r24) == true) goto L46;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L81
    L44:
        r21.show(r23, "AppletHostInputDialog");
    L46:
        return Boolean.TRUE;
    L33:
        r17 = 0;
        goto L34
    L47:
        FragmentActivity r111 = r2;
        CommonDialog.a r25 = new CommonDialog.a();
        String r26 = r19.getTitle();
        String r27 = "";
        if (r26 != null) goto L50;
        r26 = "";
    L50:
        Intrinsics.checkNotNullParameter(r26, "title");
        r25.a = r26;
        String r28 = r19.getMessage();
        if (r28 == null) goto L54;
        r27 = r28;
    L54:
        Intrinsics.checkNotNullParameter(r27, "message");
        r25.i = r27;
        CommonDialog.a.f(r25, new b(r19), r19.getPositiveBtnText(), false, 12);
        Integer r29 = r19.getPositiveBtnTextColor();
        if (r29 == null) goto L58;
        r25.q = r29.intValue();
    L58:
        if (com.larus.utils.o0.d(r19.getNegativeBtnText()) == true) goto L60;
    L64:
        r25.z = r19.getCancelOnTouchOutside();
        d r30 = new d(r19);
        Intrinsics.checkNotNullParameter(r30, "listener");
        r25.v = r30;
        String r31 = r19.getMessage();
        if (r31 != null) goto L67;
    L68:
        r4 = true;
    L69:
        if (r4 == false) goto L71;
        CommonDialog r32 = r25.c();
    L72:
        FragmentManager r33 = r111.getSupportFragmentManager();
        LandscapeRestrictionOperation r34 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r32, null, r34);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r33, r32, r34) == true) goto L78;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L76:
        r32.show(r33, null);
    L78:
        return Boolean.TRUE;
    L71:
        r32 = r25.a();
        goto L72
    L67:
        if (r31.length() != 0) goto L69;
    L60:
        if (r19.getNegativeClickListener() == null) goto L64;
        CommonDialog.a.e(r25, new c(r19), r19.getNegativeBtnText(), 4);
        Integer r35 = r19.getNegativeBtnTextColor();
        if (r35 == null) goto L64;
        r25.r = r35.intValue();
    L80:
        return Boolean.FALSE;
    L10:
        r2 = null;
        goto L11
    }

    public final Boolean showLoading(e3.a r5) {
        FragmentActivity r1 = null;
        if (r5 == null) goto L5;
        XBridge3ToAIBridgeAdapter.a r2 = new XBridge3ToAIBridgeAdapter.a(r5);
    L6:
        if (r2 == null) goto L8;
        Activity r3 = r2.getOwnerActivity();
    L10:
        if ((r3 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r4 = (FragmentActivity) r3;
    L13:
        if (r4 != null) goto L30;
        if (r5 == null) goto L16;
        Activity r6 = r5.getOwnerActivity();
    L18:
        if ((r6 instanceof FragmentActivity) == false) goto L20;
        r4 = (FragmentActivity) r6;
    L21:
        if (r4 != null) goto L30;
        Activity r7 = AppHost.a.a().getCurrentActivity();
        if ((r7 instanceof FragmentActivity) == false) goto L25;
        r1 = (FragmentActivity) r7;
    L25:
        if (r1 == null) goto L27;
        r4 = r1;
        goto L30
    L27:
        return Boolean.FALSE;
    L20:
        r4 = null;
        goto L21
    L16:
        r6 = null;
    L30:
        if (a(r4) == false) goto L49;
        if (r4.getSupportFragmentManager().isStateSaved() == true) goto L49;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L44
        Fragment r9 = r4.getSupportFragmentManager().findFragmentByTag("AppletHostLoadingDialog");     // Catch: Throwable -> L44
        if (r9 == null) goto L37;
        r4.getSupportFragmentManager().beginTransaction().remove(r9).commitAllowingStateLoss();     // Catch: Throwable -> L44
    L37:
        int r10 = CommonLoadDialogFragment.e;     // Catch: Throwable -> L44
        Bundle r11 = new Bundle();     // Catch: Throwable -> L44
        r11.putFloat("key_dim", 0.2f);     // Catch: Throwable -> L44
        CommonLoadDialogFragment r12 = new CommonLoadDialogFragment();     // Catch: Throwable -> L44
        r12.setArguments(r11);     // Catch: Throwable -> L44
        FragmentManager r13 = r4.getSupportFragmentManager();     // Catch: Throwable -> L44
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L44
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "AppletHostLoadingDialog", r14);     // Catch: Throwable -> L44
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r12, r14) == false) goto L53;
    L42:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L47:
        return Boolean.valueOf(Result.isSuccess-impl(r15));
    L53:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50 Throwable -> L44
    L41:
        r12.show(r13, "AppletHostLoadingDialog");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        return Boolean.FALSE;
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final Boolean showToast(ToastBuilder r12) {
        Intrinsics.checkNotNullParameter(r12, "toastBuilder");
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.showToast(new com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder(r12.getContext(), r12.getMessage(), r12.getType(), r12.getDuration(), r12.getIcon(), null, 32, null));
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.applet.impl.p0] */
    public final Boolean showActionSheet(ActionSheetBuilder r10, final ShowActionSheetListener r11) {
        Intrinsics.checkNotNullParameter(r10, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r11, "showActionSheetListener");
        Context r0 = r10.getContext();
    L3:
        FragmentActivity r1 = null;
        if (r0 == null) goto L11;
        if ((r0 instanceof FragmentActivity) == true) goto L7;
        if ((r0 instanceof ContextWrapper) == false) goto L11;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L3
    L7:
        FragmentActivity r2 = (FragmentActivity) r0;
    L12:
        if (r2 != null) goto L21;
        Activity r3 = AppHost.a.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L16;
        r1 = (FragmentActivity) r3;
    L16:
        if (r1 == null) goto L18;
        r2 = r1;
        goto L21
    L18:
        return Boolean.FALSE;
    L21:
        if (a(r2) == false) goto L45;
        if (r2.getSupportFragmentManager().isStateSaved() == true) goto L45;
        if (r10.getActions().isEmpty() == true) goto L45;
        List r4 = r10.getActions();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
        final int r7 = 0;
    L29:
        if (r6.hasNext() == false) goto L37;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r12 = ((ActionSheetBuilderAction) r8).getTitle();
        if (r12 != null) goto L36;
        r12 = "";
    L36:
        r5.add(new CommonActionSheetDialog.b(r12, r10.getItemColor(), new p0(r11, r7)));
        r7 = r9;
        goto L29
    L37:
        int r13 = CommonActionSheetDialog.j;
        FragmentManager r14 = r2.getSupportFragmentManager();
        String r15 = r10.getTitle();
        String r16 = r2.getString(R.string.cancel);
        Function0 r17 = new q0(r11);
        Intrinsics.checkNotNullParameter(r14, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "items");
        CommonActionSheetDialog r18 = new CommonActionSheetDialog();
        r18.d = r15;
        r18.e = r5;
        r18.f = r16;
        r18.g = r17;
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "CommonActionSheetDialog", r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r18, r19) == true) goto L43;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L41:
        r18.show(r14, "CommonActionSheetDialog");
    L43:
        return Boolean.TRUE;
    L45:
        return Boolean.FALSE;
    L11:
        r2 = null;
        goto L12
    }
}
