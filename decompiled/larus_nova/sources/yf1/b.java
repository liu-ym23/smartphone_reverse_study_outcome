package yf1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements c {
    public b() {
    }

    @Override // yf1.c
    public final void a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_DOU_PLUS_SEC_BUYER_ID);
        if (r101 == null) goto L6;
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_DOU_PLUS_SEC_BUYER_ID);
        return;
    }
}
