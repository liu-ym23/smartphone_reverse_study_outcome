package pd2;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    static {
    }

    public static void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        if (m.i() == null) goto L20;
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        String r1 = null;
        if (r0 == null) goto L11;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r3 = r0.getKtvCoreViewModel();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r3.getValue();
        if (r4 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
    L12:
        if (r5 == null) goto L14;
        r1 = r5.a;
    L14:
        BaseMonitor.add(r2, BaseCoreViewModel.CORE_TAG_STATE, r1);
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L17;
        String r6 = "1";
    L18:
        BaseMonitor.add(r2, "is_singer", r6);
        return;
    L17:
        r6 = BDLocationException.ERROR_TIMEOUT;
    L11:
        r5 = null;
        goto L12
    }
}
