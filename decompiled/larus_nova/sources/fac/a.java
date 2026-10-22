package fac;

import android.content.Context;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static void a(AppCompatDialog r100) {
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

    public static float b(Context r100) {
        TypedValue r101 = new TypedValue();
        r100.getResources().getValue(R.dimen.ud_dialog_background_dim_amount, r101, true);
        return r101.getFloat();
    }
}
