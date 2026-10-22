package com.larus.avlink.record.page;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f294231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f294232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f294233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f294234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PopupWindow f294235e;

    public g(Context r100, ConstraintLayout r101, k r102, l r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "anchor");
        Intrinsics.checkNotNullParameter(r102, "onDeleteClick");
        this.f294231a = r100;
        this.f294232b = r101;
        this.f294233c = r102;
        this.f294234d = r103;
    }
}
