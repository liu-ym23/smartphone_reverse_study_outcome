package fn8;

import com.larus.list.expose.ExposureTrackerExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f477962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f477963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f477964c;

    public /* synthetic */ e(w r100, x r101, c0 r102) {
        this.f477962a = r100;
        this.f477963b = r101;
        this.f477964c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        w r100 = this.f477962a;
        final x r101 = this.f477963b;
        final c0 r102 = this.f477964c;
        ExposureTrackerExtKt.a(r100, new k(r101, r102));
        return Unit.INSTANCE;
    }
}
