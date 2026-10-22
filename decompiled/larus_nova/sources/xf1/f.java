package xf1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements a {
    public f() {
    }

    @Override // xf1.a
    public final boolean a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_ID) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
