package f45;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Function0<Unit> a;

    public b(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        Function0<Unit> r2 = this.a;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
