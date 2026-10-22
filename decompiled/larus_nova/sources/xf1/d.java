package xf1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.backroom.utils.BackSourceConfigs;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {
    public d() {
    }

    @Override // xf1.a
    public final boolean a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Lazy r103 = BackSourceConfigs.f105113a;
        if (r101 == null) goto L5;
        String r104 = com.bytedance.android.livesdk.chatroom.backroom.utils.a.a(r101);
    L6:
        Lazy r105 = BackSourceConfigs.f105113a;
        if (((List) r105.getValue()).contains(IBackRoomStackKt.JUMP_SOURCE_ALL) == false) goto L9;
    L12:
        return true;
    L9:
        if (CollectionsKt.contains((List) r105.getValue(), r104) == true) goto L12;
        return false;
    L5:
        r104 = null;
        goto L6
    }
}
