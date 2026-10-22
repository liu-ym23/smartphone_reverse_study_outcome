package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class i<D extends AbstractDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnDismissListener f400715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f400716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f400717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractDialog.CloseIconStyle f400719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pair<Integer, Integer> f400720f;

    public abstract D b();

    public final D a() {
        D r100 = (D) b();
        r100.f400666t = null;
        r100.i(this.f400718d, this.f400716b);
        r100.setCancelable(this.f400717c);
        r100.c(this.f400719e, this.f400720f.getFirst(), this.f400720f.getSecond());
        return r100;
    }

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f400717c = true;
        this.f400719e = AbstractDialog.CloseIconStyle.DARK;
        this.f400720f = TuplesKt.to(null, null);
    }
}
