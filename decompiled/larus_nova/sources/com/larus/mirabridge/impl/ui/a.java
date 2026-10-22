package com.larus.mirabridge.impl.ui;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import gl9.i;
import gl9.l;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f359356c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile l f359357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<i> f359358b;

    /* JADX INFO: renamed from: com.larus.mirabridge.impl.ui.a$a, reason: collision with other inner class name */
    public static final class C4421a {
        public static a a() {
            if (a.f359356c == null) goto L5;
        L15:
            a r100 = a.f359356c;
            Intrinsics.checkNotNull(r100);
            return r100;
        L5:
            monitor-enter(a.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (a.f359356c != null) goto L9;
            a.f359356c = new a();     // Catch: Throwable -> L12
        L9:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(a.class);
            goto L15
        }
    }

    static {
    }

    public a() {
        this.f359358b = new CopyOnWriteArrayList();
    }

    public static void a(l r100) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }
}
