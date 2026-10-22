package com.bytedance.locallife.poi.newdetail.component;

import android.view.View;
import androidx.lifecycle.Observer;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiQuickPageNavigationBar f263141a;

    public b0(PoiQuickPageNavigationBar r100) {
        this.f263141a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        PoiQuickPageNavigationBar r102 = this.f263141a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        int r104 = r101.optInt("corner_dp", 0);     // Catch: Throwable -> L11
        Object r105 = r102.getParent();     // Catch: Throwable -> L11
        View r106 = null;
        if ((r105 instanceof View) == false) goto L6;
        View r107 = (View) r105;     // Catch: Throwable -> L11
    L7:
        if (r107 == null) goto L9;
        r107.setOutlineProvider(new cz6.a(em4.g.c(r104)));     // Catch: Throwable -> L11
        r107.setClipToOutline(true);     // Catch: Throwable -> L11
        r107.invalidate();     // Catch: Throwable -> L11
        r106 = r107;
    L9:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
        return;
    L6:
        r107 = null;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
