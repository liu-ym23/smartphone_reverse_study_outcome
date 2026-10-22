package ep5;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends Dialog {
    @Override // android.app.Dialog
    public void show() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r2 == false) goto L15;
        tt5.a.d("BaseDialog", "activity already finish");
        return;
    L15:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        return;
    L9:
        if (r1.isFinishing() != true) goto L11;
        r2 = true;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public final void setOnCancelListener(DialogInterface.OnCancelListener r2) {
        super.setOnCancelListener(new b(r2));
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r2) {
        super.setOnDismissListener(new c(r2));
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener r2) {
        super.setOnShowListener(new d(r2));
    }

    public a(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
