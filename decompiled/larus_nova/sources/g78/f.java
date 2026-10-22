package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowAsrClientImpl f480285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f480286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f480287c;

    public /* synthetic */ f(FlowAsrClientImpl r100, String r101, String r102) {
        this.f480285a = r100;
        this.f480286b = r101;
        this.f480287c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        FlowAsrClientImpl r100 = this.f480285a;
        String r101 = this.f480286b;
        String r102 = this.f480287c;
        n58.b r103 = r100.f289674h;
        if (r103 == null) goto L6;
        r103.b(r101, r102);
    L6:
        return Unit.INSTANCE;
    }
}
