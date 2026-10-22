package ql4;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.dux.dialog.alert.d;
import com.bytedance.dux.dialog.base.AbstractDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b<D extends AbstractDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f533768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f533769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f533770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f533771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractDialog.CloseIconStyle f533772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pair<Integer, Integer> f533773f;

    public abstract d b();

    public final D a() {
        d r100 = b();
        r100.b(this.f533771d, this.f533768a);
        r100.setCancelable(this.f533770c);
        r100.a(this.f533772e, this.f533773f.getFirst(), this.f533773f.getSecond());
        r100.f204972k = null;
        return r100;
    }

    public final void c() {
        AbstractDialog r100 = a();
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f533770c = true;
        this.f533772e = AbstractDialog.CloseIconStyle.DARK;
        this.f533773f = TuplesKt.to(null, null);
    }
}
