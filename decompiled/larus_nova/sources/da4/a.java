package da4;

import android.widget.ImageView;
import com.bytedance.bdp.bdpplatform.service.image.BdpImageServiceImpl;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.bytedance.bdp.serviceapi.defaults.ui.model.d;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f467677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdpThreadService f467678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f467679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BdpImageServiceImpl f467680d;

    @Override // java.lang.Runnable
    public final void run() {
        BdpImageServiceImpl.E2(this.f467680d, this.f467677a);     // Catch: Throwable -> L4
        BdpImageServiceImpl r100 = this.f467680d;     // Catch: Throwable -> L4
        BdpThreadService r101 = this.f467678b;     // Catch: Throwable -> L4
        ImageView r102 = this.f467679c;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        r101.c(new c(null, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BdpImageServiceImpl r100, d r101, BdpThreadService r102, ImageView r103) {
        this.f467680d = r100;
        this.f467677a = r101;
        this.f467678b = r102;
        this.f467679c = r103;
    }
}
