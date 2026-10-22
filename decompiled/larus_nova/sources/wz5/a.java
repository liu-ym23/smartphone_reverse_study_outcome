package wz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.detector.l;
import hz5.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {
    public a() {
    }

    @Override // wz5.b
    public final boolean a(PrivacyEvent r100) {
        if (r100.f245372i == false) goto L5;
    L8:
        r100.f245384u.add("background");
        k.d("Helios-Control-Api", "BackgroundCondition id=" + r100.f245366c + " startedTime=" + r100.f245376m);
    L10:
        return r100.f245372i;
    L5:
        if (r100.f245383t != 1) goto L10;
        if ((!Intrinsics.areEqual(r100.f245373j, l.f245530d[0])) == false) goto L10;
        goto L8
    }
}
