package pd2;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    static {
    }

    public static void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        if (m.i() == null) goto L20;
        KtvContext.Companion.getClass();
        KtvContext r101 = KtvContext.a.g();
        String r102 = null;
        if (r101 == null) goto L11;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r103 = r101.getKtvCoreViewModel();
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r104 = r103.getValue();
        if (r104 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r105 = r104.getCurState();
    L12:
        if (r105 == null) goto L14;
        r102 = r105.f145406a;
    L14:
        BaseMonitor.add(r100, "state", r102);
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L17;
        String r106 = "1";
    L18:
        BaseMonitor.add(r100, "is_singer", r106);
        return;
    L17:
        r106 = "0";
    L11:
        r105 = null;
        goto L12
    }
}
