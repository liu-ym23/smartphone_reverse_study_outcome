package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f231472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0.e f231473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ef5.m f231474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f231475d;

    public g0(RecyclerView r100, e0.e r101, ef5.m r102, int r103) {
        this.f231472a = r100;
        this.f231473b = r101;
        this.f231474c = r102;
        this.f231475d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f231472a.isAttachedToWindow() == false) goto L10;
        this.f231473b.c(this.f231474c, this.f231475d);     // Catch: Throwable -> L7
        return;
    }
}
