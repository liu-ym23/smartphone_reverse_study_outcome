package com.bytedance.ee.bear.document.loading;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingLayout.a f220220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f220221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f220222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoadingLayout f220223d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f220220a.f220205c == false) goto L5;
        LoadingLayout.b r101 = this.f220223d.f220202b;
        if (r101 == null) goto L13;
        LoadingFailedPlugin.c(((e) r101).f220216a);
        return;
    L13:
        return;
    L5:
        if (this.f220223d.f220201a == null) goto L11;
        this.f220221b.setVisibility(8);
        this.f220223d.f220201a.onFailedRetry(this.f220222c);
        return;
    }

    public h(LoadingLayout r100, LoadingLayout.a r101, TextView r102, int r103) {
        this.f220223d = r100;
        this.f220220a = r101;
        this.f220221b = r102;
        this.f220222c = r103;
    }
}
