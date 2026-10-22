package n2a;

import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class a implements Function0 {
    public /* synthetic */ a() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TTVideoEngineLog.turnOn(2, 1);
        TTVideoEngineLog.setLogNotifyLevel(2, 1);
        return Unit.INSTANCE;
    }
}
