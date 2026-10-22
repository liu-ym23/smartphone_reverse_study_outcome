package ep5;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class a extends Dialog {
    @Override // android.app.Dialog
    public void show() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        if (r102 == false) goto L15;
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
        if (r101.isFinishing() != true) goto L11;
        r102 = true;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public final void setOnCancelListener(DialogInterface.OnCancelListener r100) {
        super.setOnCancelListener(new b(r100));
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        super.setOnDismissListener(new c(r100));
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener r100) {
        super.setOnShowListener(new d(r100));
    }

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
