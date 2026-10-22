package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.foundation.dialog.FlowAlertDialog;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmDoubaoDialogProvider implements qub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, FlowAlertDialog> f436900a;

    public static final class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rub.b f436901a;

        public a(rub.b r100) {
            this.f436901a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            Function0<Unit> r101 = this.f436901a.f539311n;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmDoubaoDialogProvider f436902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rub.b f436903b;

        public b(MmDoubaoDialogProvider r100, rub.b r101) {
            this.f436902a = r100;
            this.f436903b = r101;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            this.f436902a.f436900a.remove(this.f436903b.f539298a);
            Function0<Unit> r101 = this.f436903b.f539310m;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public MmDoubaoDialogProvider() {
        this.f436900a = new LinkedHashMap();
    }

    public static void X0(FlowAlertDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // qub.c
    public final void B(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r102 = CollectionsKt.toList(((LinkedHashMap) this.f436900a).values()).iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        X0((FlowAlertDialog) r102.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        ((LinkedHashMap) this.f436900a).clear();     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        int r105 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.OVERLAY, "dismissAllDialogs", "dismissAllDialogs failed e=" + r104, null);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void Z1(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "id");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        FlowAlertDialog r103 = this.f436900a.remove(r101);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        X0(r103);     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        int r107 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.OVERLAY, "dismissDialog", "dismissDialog failed id=" + r101 + " e=" + r106, null);
        return;
    L17:
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // qub.c
    public final void u0(Context r100, final rub.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L39
        Z1(r100, r101.f539298a);     // Catch: Throwable -> L39
        boolean r103 = false;
        FlowAlertDialog r104 = new FlowAlertDialog(r100, 0);     // Catch: Throwable -> L39
        String r105 = r101.f539299b;     // Catch: Throwable -> L39
        if (r105 == null) goto L7;
        Intrinsics.checkNotNullParameter(r105, "text");     // Catch: Throwable -> L39
        r104.f425600a = r105;     // Catch: Throwable -> L39
    L7:
        String r106 = r101.f539300c;     // Catch: Throwable -> L39
        if (r106 == null) goto L10;
        Intrinsics.checkNotNullParameter(r106, "text");     // Catch: Throwable -> L39
        r104.f425601b = r106;     // Catch: Throwable -> L39
    L10:
        r104.setCancelable(r101.f539306i);     // Catch: Throwable -> L39
        r104.setCanceledOnTouchOutside(r101.f539307j);     // Catch: Throwable -> L39
        String r107 = r101.f539301d;     // Catch: Throwable -> L39
        String r108 = r101.f539302e;     // Catch: Throwable -> L39
        if (r107 != null) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L19;
        Function1<FlowAlertDialog, Unit> r110 = new MmDoubaoDialogProvider$showDialog$1$1$3(r101);     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r107, "text");     // Catch: Throwable -> L39
        r104.f425602c = r107;     // Catch: Throwable -> L39
        r104.f425606g = r110;     // Catch: Throwable -> L39
    L19:
        if (r108 != null) goto L21;
    L22:
        r103 = true;
    L23:
        if (r103 == true) goto L25;
        Function1<FlowAlertDialog, Unit> r111 = new MmDoubaoDialogProvider$showDialog$1$1$4(r101);     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r108, "text");     // Catch: Throwable -> L39
        r104.f425603d = r108;     // Catch: Throwable -> L39
        r104.f425607h = r111;     // Catch: Throwable -> L39
    L25:
        Integer r112 = r101.f539303f;     // Catch: Throwable -> L39
        if (r112 == null) goto L28;
        r104.f425604e = Integer.valueOf(r112.intValue());     // Catch: Throwable -> L39
    L28:
        Integer r113 = r101.f539304g;     // Catch: Throwable -> L39
        if (r113 == null) goto L31;
        r104.f425605f = Integer.valueOf(r113.intValue());     // Catch: Throwable -> L39
    L31:
        r104.setOnShowListener(new a(r101));     // Catch: Throwable -> L39
        r104.setOnDismissListener(new b(this, r101));     // Catch: Throwable -> L39
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r104);     // Catch: Throwable -> L39
    L37:
        this.f436900a.put(r101.f539298a, r104);     // Catch: Throwable -> L39
        Object r114 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L39
    L41:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L50;
        int r116 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.OVERLAY, "showDialog", "showDialog failed e=" + r115, null);
        return;
    L50:
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45 Throwable -> L39
    L36:
        DialogLancet.beforeDialogShow(r104);     // Catch: Throwable -> L39
        r104.show();     // Catch: Throwable -> L39
        DialogLancet.afterDialogShow(r104);     // Catch: Throwable -> L39
        goto L37
    L21:
        if (r108.length() != 0) goto L23;
    L13:
        if (r107.length() == 0) goto L16;
        r109 = false;
    L39:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    }
}
