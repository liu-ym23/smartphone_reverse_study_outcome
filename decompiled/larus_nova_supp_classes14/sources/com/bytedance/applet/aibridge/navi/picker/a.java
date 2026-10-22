package com.bytedance.applet.aibridge.navi.picker;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.larus.navigation.api.c;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static volatile WeakReference<Dialog> a;
    public static volatile Function2<? super String, ? super Integer, Unit> b;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.navi.picker.a$a, reason: collision with other inner class name */
    public static final class C0051a {
        public final CharSequence a;
        public final String b;
        public final String c;
        public final NavigationMapAppLauncher.InstallState d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0051a) == true) goto L8;
            return false;
        L8:
            C0051a r6 = (C0051a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
            NavigationMapAppLauncher.InstallState r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Row(text=" + this.a + ", desc=" + this.b + ", selectionKey=" + this.c + ", installState=" + this.d + ')';
        }

        public C0051a(CharSequence r2, String r3, String r4, NavigationMapAppLauncher.InstallState r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r4, "selectionKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public static void a(Dialog r3) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(Function2 r0, String r1, Integer r2) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.invoke(r1, r2);     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        int r3 = c.a;
        c.c("nav_map_popup_mgr", "pending callback threw [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
    }
}
