package com.bytedance.ee.bear.more.pageview2;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f234775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PageViewFragment.b f234776b;

    @Override // java.lang.Runnable
    public final void run() {
        PageViewFragment r100 = this.f234776b.E;     // Catch: Throwable -> L4
        r100.f234730y = x08.a.a(this.f234775a, R.string.Doc_Facade_Loading);     // Catch: Throwable -> L4
        this.f234776b.E.f234730y.show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(PageViewFragment.b r100, FragmentActivity r101) {
        this.f234776b = r100;
        this.f234775a = r101;
    }
}
