package com.bytedance.ee.bear.document.alert;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f218940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f218941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f218942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDDialog f218943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gp5.a f218944e;

    public static final class a {
    }

    static {
    }

    public static int d(int r100) {
        if (r100 != 1) goto L5;
        return R.color.function_danger_fill_default;
    L5:
        if (r100 == 2) goto L7;
        return R.color.text_title;
    L7:
        return R.color.primary_fill_default;
    }

    public r(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f218940a = r100;
    }

    public static void a(UDDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void c(r r100, String r101, String r102, tb5.m r103, boolean r104, Boolean r105, String r106, int r107) {
        if ((r107 & 8) == 0) goto L6;
        r104 = true;
    L6:
        if ((r107 & 16) == 0) goto L9;
        r105 = null;
    L9:
        if ((r107 & 32) == 0) goto L11;
        r106 = null;
    L11:
        r100.getClass();
        JSONObject r108 = new JSONObject();
        r108.put2("id", r101);
        r108.put2("input", r102);
        if (r105 == null) goto L14;
        r105.booleanValue();
        r108.put2("isChecked", r105);
    L14:
        if (r106 == null) goto L16;
        r108.put2("selectedRadioId", r106);
    L16:
        r103.b(r108);
        if (r104 == false) goto L22;
        UDDialog r109 = r100.f218943d;
        if (r109 == null) goto L23;
        a(r109);
        return;
    L23:
        return;
    }
}
