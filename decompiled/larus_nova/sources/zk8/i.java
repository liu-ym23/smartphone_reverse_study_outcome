package zk8;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f572673a;

    public /* synthetic */ i(Function0 r100) {
        this.f572673a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function0 r101 = this.f572673a;
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r102, "reason");
        FLogger.f375446a.e("FileAudioPlayer", "play failed, media focus denied, reason=" + r102);
        r101.invoke();
        return Unit.INSTANCE;
    }
}
