package yi3;

import android.view.View;
import com.bytedance.android.shopping.store.home.view.MoveDelegateFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ MoveDelegateFrameLayout b;
    public final /* synthetic */ View c;

    public a(b r1, MoveDelegateFrameLayout r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoveDelegateFrameLayout r0 = this.b;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.setDelegateView(this.c);     // Catch: Throwable -> L9
    L5:
        MoveDelegateFrameLayout r1 = this.b;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setOffsetLocation(new Pair(Float.valueOf(0.0f), Float.valueOf(b.q0(this.a).r)));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
