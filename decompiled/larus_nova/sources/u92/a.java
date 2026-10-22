package u92;

import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements j {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "textMessage");
        T r101 = r100.f133141b;
        if ((r101 instanceof n0) == false) goto L13;
        n0 r102 = (n0) r101;
        o0.b r103 = r102.getExtraInfo();
        if (r103 == null) goto L13;
        String r104 = r103.getSource();
        if (r104 == null) goto L13;
        if (r102.getAction() != 1) goto L13;
        if (Intrinsics.areEqual("anchor_pause", r104) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
