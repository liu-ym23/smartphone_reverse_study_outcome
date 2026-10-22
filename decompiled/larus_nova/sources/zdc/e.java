package zdc;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f571496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f571497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f571498c;

    public e(f r100, int r101, int r102) {
        this.f571496a = r100;
        this.f571497b = r101;
        this.f571498c = r102;
    }

    public final void a() {
        RecyclerView.Adapter r100 = this.f571496a.f571499a.getAdapter();
        if (r100 != null) goto L5;
        return;
    L5:
        Log.i("RecyclerViewExtension", this.f571496a.f571500b + " width changed:[" + this.f571497b + "->" + this.f571498c + "], notify");
        r100.notifyDataSetChanged();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
