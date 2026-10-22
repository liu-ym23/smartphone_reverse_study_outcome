package zk8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f572672a;

    public /* synthetic */ h(Function0 r100) {
        this.f572672a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function0 r101 = this.f572672a;
        ((Float) r100).floatValue();
        n.f572682f = true;
        r101.invoke();
        return Unit.INSTANCE;
    }
}
