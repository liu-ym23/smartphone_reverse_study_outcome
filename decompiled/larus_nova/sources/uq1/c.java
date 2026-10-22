package uq1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static final IRoom a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        DataCenter r101 = r100.f551201e;
        if (r101 != null) goto L5;
        return null;
    L5:
        return (IRoom) r101.get("data_room", null);
    }
}
