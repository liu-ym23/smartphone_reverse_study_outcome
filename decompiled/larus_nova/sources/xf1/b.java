package xf1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    public b() {
    }

    @Override // xf1.a
    public final boolean a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L7;
        Bundle r103 = m0.a(r101);
        if (r103 == null) goto L7;
        boolean r104 = r103.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_VIP_BACK_PRE_ROOM_ENABLE, true);
    L9:
        return true ^ r104;
    L7:
        r104 = true;
        goto L9
    }
}
