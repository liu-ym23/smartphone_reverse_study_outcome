package vy1;

import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ty1.c f557554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupComponentState.Style f557555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f557556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f557557d;

    public b(ty1.c r100, GroupComponentState.Style r101, int r102, a r103) {
        this.f557554a = r100;
        this.f557555b = r101;
        this.f557556c = r102;
        this.f557557d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f557557d.p(this.f557554a, this.f557555b, this.f557556c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
