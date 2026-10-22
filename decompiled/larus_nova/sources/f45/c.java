package f45;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f475515a;

    public c(Function0<Unit> r100) {
        this.f475515a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function0<Unit> r101 = this.f475515a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
