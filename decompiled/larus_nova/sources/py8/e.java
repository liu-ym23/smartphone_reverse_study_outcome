package py8;

import android.companion.CompanionDeviceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public class e extends d {
    public e(CompanionDeviceManager r100) {
        Intrinsics.checkNotNullParameter(r100, "companionDeviceManager");
        super(r100);
    }

    @Override // py8.d, py8.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
        this.f531043a.stopObservingDevicePresence(r100);
    }

    @Override // py8.d, py8.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
        this.f531043a.startObservingDevicePresence(r100);
    }
}
