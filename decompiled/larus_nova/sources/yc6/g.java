package yc6;

import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oc6.p;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements p, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer.e f567178a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // oc6.p
    public final void sendLog(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    public g(com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer.e r100) {
        Intrinsics.checkNotNullParameter(r100, "groupCardDataStore");
        this.f567178a = r100;
    }

    @Override // oc6.p
    public final void selectGroupCard(int r100, String r101, long r102) {
        com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer.e r103 = this.f567178a;
        oc6.g r104 = new oc6.g();
        r104.c(r100);
        r104.d(r101);
        r104.e(r102);
        Unit r105 = Unit.INSTANCE;
        r103.getClass();
    }
}
