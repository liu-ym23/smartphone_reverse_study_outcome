package g98;

import com.larus.audio.call.o;
import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements u39.b {
    public e() {
    }

    @Override // u39.b
    public final void a(boolean r100, EnvObserveChangeReason r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        FLogger.f375446a.i("DoraEnvObserveManager", "initEnvObserve onEnvObserveChange canEntry = " + r100 + ", reason = " + r101 + ", reasonCode = " + r102);
        o r103 = d.f480522a;
        if (r100 == false) goto L5;
        DoraEnvObserveState r104 = DoraEnvObserveState.START;
    L6:
        DoraEnvObserveState r105 = r104;
        String r106 = r101.toString();
        if (r101 != EnvObserveChangeReason.DEVICE_CHANGE) goto L9;
        int r107 = 0;
    L10:
        d.a(new f(r105, r106, r101, r107, r102));
        return;
    L9:
        r107 = 1;
        goto L10
    L5:
        r104 = DoraEnvObserveState.END;
        goto L6
    }
}
