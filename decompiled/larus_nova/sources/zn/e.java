package zn;

import androidx.arch.core.executor.ArchTaskExecutor;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer f572896a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f572897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f572898b;

        public a(e r100, Object r101) {
            this.f572897a = r100;
            this.f572898b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f572897a.f572896a.onChanged(this.f572898b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e(ECWindowLinkageHeaderLivePresenter.c r100) {
        this.f572896a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        ArchTaskExecutor.getInstance().postToMainThread(new a(this, r100));
    }
}
