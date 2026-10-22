package r74;

import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f536436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f536437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f536438c;

    @Override // java.lang.Runnable
    public final void run() {
        System.currentTimeMillis();     // Catch: Throwable -> L4
        this.f536438c.k(this.f536436a);     // Catch: Throwable -> L4
        this.f536438c.g(this.f536437b);     // Catch: Throwable -> L4
        this.f536438c.h(this.f536437b, DTraitRiskType.HIGH, Integer.MIN_VALUE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(g r100, JSONObject r101) {
        this.f536438c = r100;
        this.f536436a = r101;
        this.f536437b = "[device]";
    }
}
