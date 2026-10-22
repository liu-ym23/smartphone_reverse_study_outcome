package i08;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.crash.d;
import com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<LKUILoadingToastImpl> f487893a;

    static {
        f487893a = new WeakReference(null);
    }

    @JvmStatic
    public static final void a() {
        if (f487893a.get() != null) goto L5;
        return;
    L5:
        LKUILoadingToastImpl r100 = f487893a.get();
        if (r100 == null) goto L24;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r100);
        goto L24
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r101.getLooper()) goto L12;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L24:
        f487893a.clear();
    }

    @JvmStatic
    public static final void b(Context r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        if (f487893a.get() != null) goto L6;
        f487893a = new WeakReference(new LKUILoadingToastImpl(r100));
    L6:
        LKUILoadingToastImpl r102 = f487893a.get();
        Intrinsics.checkNotNull(r102);
        LKUILoadingToastImpl r103 = r102;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r103.isShowing() == false) goto L9;
        r103.f284480e.removeMessages(61441);
    L10:
        r103.f284480e.post(new b(r103, r101));
        r103.f284480e.post(new com.larksuite.component.ui.toast.loading.a(r103));
        return;
    L9:
        Message.obtain(r103.f284480e, 61442).sendToTarget();
        goto L10
    }
}
