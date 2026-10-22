package com.larus.common_ui.dbx.component;

import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f327027a;

    @Override // android.view.View
    public final boolean performClick() {
        Function0<Unit> r100 = this.f327027a;
        if (r100 == null) goto L6;
        r100.invoke();
    L6:
        if (super.performClick() == true) goto L10;
        if (r100 != null) goto L10;
        return false;
    L10:
        return true;
    }

    public d(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
