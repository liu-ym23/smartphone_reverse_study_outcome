package xf1;

import android.os.Bundle;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements a {
    public c() {
    }

    @Override // xf1.a
    public final boolean a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L16:
        return r103;
    L10:
        if (oj1.f120911a.getValue().a() == false) goto L16;
        if (r101 != null) goto L13;
        return false;
    L13:
        if (r101.getLong(VSConstants.EXTRA_VS_CAMERA_ID) != r100.getLong(VSConstants.EXTRA_VS_CAMERA_ID)) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r101.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID) != r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID)) goto L7;
        r103 = true;
        goto L8
    }
}
