package vr2;

import com.bytedance.android.annie.bridge.method.a0;
import com.bytedance.android.annie.bridge.method.z;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ag1;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.ef1;
import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements f, o {
    public m() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr2.f
    public final void Vc() {
        ag1 r100 = bg1.f119867a;
        bg1.f119867a = ef1.f120122a.getValue();
        ALogger.i("RevenueJankOptUtils", "refresh " + bg1.f119867a);
    }

    @Override // vr2.f
    public final void Oe(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "m");
        int r101 = a0.f38503a;
        Intrinsics.checkNotNullParameter(r100, "m");
        r100.put("getCurrentTimeSaas", z.f38870a);
    }
}
