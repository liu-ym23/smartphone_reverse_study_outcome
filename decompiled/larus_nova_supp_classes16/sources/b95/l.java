package b95;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public final WeakHashMap<Integer, Dialog> a;

    public interface a {
        void cancel();

        void confirm();
    }

    public final void a() {
        Iterator<Dialog> r0 = this.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        Dialog r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.isShowing() == false) goto L4;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 == null) goto L14;
        if (Looper.myLooper() == r2.getLooper()) goto L14;
        r2.post(DialogLancet.createDismissRunnable(r1));
    L14:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r1);
        goto L4
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    }

    public l() {
        this.a = new WeakHashMap();
    }

    public final UDDialog b(FragmentActivity r3, String r4, String r5, String r6, final a r7) {
        tt5.a.h("DriveDialogManager", "getSimpleMessageConfirmDialog" + r4 + r5);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r3);
        r0.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.title(r4);
        Intrinsics.checkNotNullParameter(r5, "value");
        r0.message(r5);
        r0.messageTextSize(16);
        DialogInterface.OnClickListener r8 = new h(r7);
        Intrinsics.checkNotNullParameter(r6, "text");
        r0.addActionButton(2131391777, r6, r8);
        r0.cancelable(false);
        r0.width(303.0f);
        r0.marginInDp(0);
        final UDDialog r9 = r0.build();
        r9.setOnShowListener(new i(this, r9));
        r9.setOnDismissListener(new j(this, r9));
        return r9;
    }
}
