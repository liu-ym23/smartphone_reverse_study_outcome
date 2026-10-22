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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f218898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f218899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f218900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDDialog f218901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gp5.a f218902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ew4.w f218903f;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<DialogInterface, Integer, Unit> f218904a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super DialogInterface, ? super Integer, Unit> r100) {
            this.f218904a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Function2<DialogInterface, Integer, Unit> r102 = this.f218904a;
            Intrinsics.checkNotNull(r100);
            r102.invoke(r100, Integer.valueOf(r101));
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<DialogInterface, Integer, Unit> f218905a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super DialogInterface, ? super Integer, Unit> r100) {
            this.f218905a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Function2<DialogInterface, Integer, Unit> r102 = this.f218905a;
            Intrinsics.checkNotNull(r100);
            r102.invoke(r100, Integer.valueOf(r101));
        }
    }

    static {
    }

    public static int f(int r100) {
        if (r100 != 1) goto L5;
        return R.color.function_danger_fill_default;
    L5:
        if (r100 == 2) goto L7;
        return R.color.text_title;
    L7:
        return R.color.primary_fill_default;
    }

    public e(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f218898a = r100;
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

    public final void c(BearUDDialogBuilder r100, int r101, CharSequence r102, int r103, Function2<? super DialogInterface, ? super Integer, Unit> r104) {
        BearUDDialogBuilder.a r105 = new BearUDDialogBuilder.a();
        r105.f240195a = r101;
        r105.f240197c = r102;
        r105.f240198d = r103;
        r105.f240200f = new b(r104);
        ew4.w r106 = this.f218903f;
        if (r106 == null) goto L7;
        Integer r107 = r106.p1();
        if (r107 == null) goto L7;
        r105.f240199e = r107.intValue();
    L7:
        r100.d(r105);
    }

    public final void d(fp5.a r100, int r101, CharSequence r102, int r103, Function2<? super DialogInterface, ? super Integer, Unit> r104) {
        UDBaseDialogBuilder.ActionBuilder r105 = new UDBaseDialogBuilder.ActionBuilder().actionResId(r101).text(r102).textColorRes(r103).onClickListener(new c(r104));
        ew4.w r106 = this.f218903f;
        if (r106 == null) goto L7;
        Integer r107 = r106.p1();
        if (r107 == null) goto L7;
        r105.bgDrawableRes(r107.intValue());
    L7:
        r100.addActionButton(r105);
    }

    public static void e(e r100, String r101, String r102, tb5.m r103, boolean r104, Boolean r105, String r106, int r107) {
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
        UDDialog r109 = r100.f218901d;
        if (r109 == null) goto L23;
        a(r109);
        return;
    L23:
        return;
    }
}
