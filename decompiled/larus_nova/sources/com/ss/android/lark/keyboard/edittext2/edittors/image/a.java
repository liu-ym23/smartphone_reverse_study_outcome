package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.viewstub.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.widget.span.b.AbstractC5432b<?> f429063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f429064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f429066d;

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public a(com.ss.android.lark.widget.span.b.AbstractC5432b<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "loadInfo");
        this.f429063a = r100;
        this.f429066d = -1;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UrlImageSpanView r101 = new UrlImageSpanView(r100, this.f429063a);
        int r102 = this.f429064b;
        int r103 = this.f429065c;
        r101.setPadding(r102, r101.getPaddingTop(), r103, r101.getPaddingBottom());
        r101.setFixSize(this.f429066d);
        return r101;
    }
}
