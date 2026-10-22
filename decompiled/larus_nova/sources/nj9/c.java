package nj9;

import com.larus.livetutor.impl.repository.viewmodel.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519468c;

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final int a() {
        return this.f519468c;
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final String b() {
        return this.f519467b;
    }

    public c(int r100) {
        Intrinsics.checkNotNullParameter("webview_fail", "reason");
        this.f519467b = "webview_fail";
        this.f519468c = r100;
    }
}
