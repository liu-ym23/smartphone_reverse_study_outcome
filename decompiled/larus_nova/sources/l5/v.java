package l5;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class v implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f507418a;

    public /* synthetic */ v(String r100) {
        this.f507418a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f507418a;
        w.f507420c.remove(r100);
        return Unit.INSTANCE;
    }
}
