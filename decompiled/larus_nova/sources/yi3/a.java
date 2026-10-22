package yi3;

import android.view.View;
import com.bytedance.android.shopping.store.home.view.MoveDelegateFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f567895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MoveDelegateFrameLayout f567896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f567897c;

    public a(b r100, MoveDelegateFrameLayout r101, View r102) {
        this.f567895a = r100;
        this.f567896b = r101;
        this.f567897c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoveDelegateFrameLayout r100 = this.f567896b;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.setDelegateView(this.f567897c);     // Catch: Throwable -> L9
    L5:
        MoveDelegateFrameLayout r101 = this.f567896b;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.setOffsetLocation(new Pair(Float.valueOf(0.0f), Float.valueOf(b.q0(this.f567895a).f186675r)));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
