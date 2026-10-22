package fn8;

import com.larus.list.exposex.ExposeXTrackerExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f477981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f477982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f477983c;

    public /* synthetic */ o(w r100, x r101, c0 r102) {
        this.f477981a = r100;
        this.f477982b = r101;
        this.f477983c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        w r100 = this.f477981a;
        final x r101 = this.f477982b;
        final c0 r102 = this.f477983c;
        ExposeXTrackerExtKt.b(r100, new g(r101, r102));
        return Unit.INSTANCE;
    }
}
