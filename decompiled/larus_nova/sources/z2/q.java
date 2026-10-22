package z2;

import com.bytedance.ai.bridge.ContainerType;
import d3.a0;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<a0> f569756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContainerType f569757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f569758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f569759d;

    @Override // d3.a0
    public final String getAppId() {
        a0 r100 = this.f569756a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppId();
    }

    @Override // d3.a0
    public final String getAppletId() {
        a0 r100 = this.f569756a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppletId();
    }

    @Override // d3.a0
    public final String getContainerId() {
        return this.f569758c;
    }

    @Override // d3.a0
    public final ContainerType getContainerType() {
        return this.f569757b;
    }

    @Override // d3.a0
    public final String getUrl() {
        return this.f569759d;
    }

    public q(k r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContextProvider");
        this.f569756a = r100;
        this.f569757b = ContainerType.EMBED_WEB_VIEW;
        this.f569758c = UUID.randomUUID().toString();
    }
}
