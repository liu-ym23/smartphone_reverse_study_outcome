package dc2;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final <T extends RoomDataSyncModel> T a(ylc.e r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$createRoomDataSyncModel");
        Intrinsics.checkNotNullParameter(r101, "factory");
        T r102 = r101.invoke();
        r102.bindManager(r100);
        return r102;
    }
}
