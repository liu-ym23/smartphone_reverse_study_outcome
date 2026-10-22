package d3c;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KVRepo f466769a;

    public b(com.ss.android.lark.storage.kv.repo.a r100) {
        this.f466769a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(a.C5624a.class, true);     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L4
        boolean r101 = ((Boolean) r100).booleanValue();     // Catch: Throwable -> L4
        this.f466769a.putBoolean("enableFeedOptimize", r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
