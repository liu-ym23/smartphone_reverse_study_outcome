package i83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadAdapter f488609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f488610b;

    public d(HeadAdapter r100, Runnable r101) {
        this.f488609a = r100;
        this.f488610b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f488609a.f169148e.isComputingLayout() == true) goto L9;
        this.f488610b.run();     // Catch: Throwable -> L6
        return;
    }
}
