package bq3;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b extends QUIModule {
    public final int l;
    public final View m;

    public static final class a {
    }

    /* JADX INFO: renamed from: bq3.b$b, reason: collision with other inner class name */
    public static final class RunnableC0003b implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ int b;

        public RunnableC0003b(b r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.m;     // Catch: Throwable -> L4
            r0.setPadding(r0.getPaddingLeft(), this.a.m.getPaddingTop(), this.a.m.getPaddingRight(), this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final QIPresenter h() {
        return null;
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        super(0);
        this.m = r2;
        this.l = com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final int j(QModel r4) {
        if ((r4 instanceof vp3.d) == true) goto L5;
        r4 = null;
    L5:
        vp3.d r5 = (vp3.d) r4;
        if (r5 != null) goto L9;
        return 0;
    L9:
        if (r5.c() == false) goto L11;
        int r6 = 0;
    L13:
        if (this.m.getPaddingBottom() == r6) goto L18;
        RunnableC0003b r1 = new RunnableC0003b(this, r6);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        r1.run();
        goto L18
    L17:
        this.m.post(r1);
    L18:
        return 0;
    L11:
        r6 = this.l;
        goto L13
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }
}
