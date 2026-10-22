package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class y implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowAsrClientImpl f480329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y58.b f480330b;

    public /* synthetic */ y(FlowAsrClientImpl r100, y58.b r101) {
        this.f480329a = r100;
        this.f480330b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final FlowAsrClientImpl r100 = this.f480329a;
        final y58.b r101 = this.f480330b;
        r100.f289668b.submit(new g(r100, r101));
        return Unit.INSTANCE;
    }
}
