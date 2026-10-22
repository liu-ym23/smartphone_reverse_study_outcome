package ee;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements a, ce.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce.a f472270a;

    @Override // ce.a
    public final String A() {
        return this.f472270a.A();
    }

    @Override // ce.a
    public final TraceTimeMetric d() {
        return this.f472270a.d();
    }

    @Override // ce.a
    public final String getEcomNotice() {
        return this.f472270a.getEcomNotice();
    }

    @Override // ce.a
    public final long getMessageId2() {
        return this.f472270a.getMessageId2();
    }

    @Override // ce.a
    public final int getMsgType() {
        return this.f472270a.getMsgType();
    }

    @Override // ce.a
    public final List<String> getSecTargetUid() {
        return this.f472270a.getSecTargetUid();
    }

    @Override // ce.a
    public final List<String> getTargetUid() {
        return this.f472270a.getTargetUid();
    }

    @Override // ce.a
    public final UpdatedCartInfo w() {
        return this.f472270a.w();
    }

    public b(ce.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f472270a = r100;
    }
}
