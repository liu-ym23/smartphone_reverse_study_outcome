package com.bytedance.locallife.poi.dito.poi.component;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiDetailTagAdapter f262516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f262517b;

    public h(PoiDetailTagAdapter r100, int r101) {
        this.f262516a = r100;
        this.f262517b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView r100 = this.f262516a.f262439c;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.smoothScrollToPosition(this.f262517b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
