package com.bytedance.ee.bear.document.alert;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final Activity a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public UDDialog d;
    public gp5.a e;
    public ew4.w f;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function2<DialogInterface, Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super DialogInterface, ? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            Function2<DialogInterface, Integer, Unit> r0 = this.a;
            Intrinsics.checkNotNull(r2);
            r0.invoke(r2, Integer.valueOf(r3));
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function2<DialogInterface, Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super DialogInterface, ? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            Function2<DialogInterface, Integer, Unit> r0 = this.a;
            Intrinsics.checkNotNull(r2);
            r0.invoke(r2, Integer.valueOf(r3));
        }
    }

    static {
    }

    public static int f(int r1) {
        if (r1 != 1) goto L5;
        return 2131102093;
    L5:
        if (r1 == 2) goto L7;
        return 2131106622;
    L7:
        return 2131105548;
    }

    public e(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
    }

    public static void a(UDDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void c(BearUDDialogBuilder r2, int r3, CharSequence r4, int r5, Function2<? super DialogInterface, ? super Integer, Unit> r6) {
        BearUDDialogBuilder.a r0 = new BearUDDialogBuilder.a();
        r0.a = r3;
        r0.c = r4;
        r0.d = r5;
        r0.f = new b(r6);
        ew4.w r7 = this.f;
        if (r7 == null) goto L7;
        Integer r8 = r7.p1();
        if (r8 == null) goto L7;
        r0.e = r8.intValue();
    L7:
        r2.d(r0);
    }

    public final void d(fp5.a r2, int r3, CharSequence r4, int r5, Function2<? super DialogInterface, ? super Integer, Unit> r6) {
        UDBaseDialogBuilder.ActionBuilder r7 = new UDBaseDialogBuilder.ActionBuilder().actionResId(r3).text(r4).textColorRes(r5).onClickListener(new c(r6));
        ew4.w r8 = this.f;
        if (r8 == null) goto L7;
        Integer r9 = r8.p1();
        if (r9 == null) goto L7;
        r7.bgDrawableRes(r9.intValue());
    L7:
        r2.addActionButton(r7);
    }

    public static void e(e r2, String r3, String r4, tb5.m r5, boolean r6, Boolean r7, String r8, int r9) {
        if ((r9 & 8) == 0) goto L6;
        r6 = true;
    L6:
        if ((r9 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 32) == 0) goto L11;
        r8 = null;
    L11:
        r2.getClass();
        JSONObject r10 = new JSONObject();
        r10.put("id", r3);
        r10.put("input", r4);
        if (r7 == null) goto L14;
        r7.booleanValue();
        r10.put("isChecked", r7);
    L14:
        if (r8 == null) goto L16;
        r10.put("selectedRadioId", r8);
    L16:
        r5.b(r10);
        if (r6 == false) goto L22;
        UDDialog r11 = r2.d;
        if (r11 == null) goto L23;
        a(r11);
        return;
    L23:
        return;
    }
}
