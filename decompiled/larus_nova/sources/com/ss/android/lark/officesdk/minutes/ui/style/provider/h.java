package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements qub.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, AlertDialog> f436913a;

    public h() {
        this.f436913a = new LinkedHashMap();
    }

    public static void X0(AlertDialog r100) {
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

    @Override // qub.d
    public final void t0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r102 = CollectionsKt.toList(((LinkedHashMap) this.f436913a).values()).iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        X0((AlertDialog) r102.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        ((LinkedHashMap) this.f436913a).clear();     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        int r105 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.OVERLAY, "hideAllLoadings", "hideAllLoadings failed e=" + r104, null);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
