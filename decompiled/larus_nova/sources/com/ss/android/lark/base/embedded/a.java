package com.ss.android.lark.base.embedded;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.embedding.ActivityStack;
import androidx.window.embedding.SplitInfo;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Consumer<List<SplitInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f409743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f409744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LKSplitController f409745c;

    @Override // androidx.core.util.Consumer
    public final void accept(List<SplitInfo> r100) {
        List<SplitInfo> r101 = r100;
    L8:
        th = move-exception;
        this.f409745c.f(this);
        throw th;
    L4:
        if (r101.isEmpty() == true) goto L6;
        ActivityStack r102 = r101.get(0).getSecondaryActivityStack();     // Catch: Throwable -> L8
        this.f409743a.accept(Boolean.valueOf(r102.contains(this.f409744b)));     // Catch: Throwable -> L8
    L6:
        this.f409745c.f(this);
    }

    public a(com.suite.lark.platform.component.widget.floatingpanel.impl.container.a r100, Activity r101, LKSplitController r102) {
        this.f409743a = r100;
        this.f409744b = r101;
        this.f409745c = r102;
    }
}
