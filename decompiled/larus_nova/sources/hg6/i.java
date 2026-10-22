package hg6;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static boolean a() {
        yz0.g r100 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        String r101 = null;
        if (r100 == null) goto L5;
        IRoomBase r102 = r100.getRoom();
    L6:
        if (r102 == null) goto L11;
        Map<String, String> r103 = IRoomKt_androidKt.getAnchorABMap(r102);
        if (r103 == null) goto L11;
        r101 = r103.get("bigevent_disable_lynx_panel");
    L11:
        if (Intrinsics.areEqual(r101, "2") == false) goto L14;
    L18:
        return false;
    L14:
        if (vm2.i.a().getLinkServiceEnable() == false) goto L18;
        if (vm2.i.b().getEmojiPanelOpen() == false) goto L18;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean c() {
        yz0.g r100 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r100 == null) goto L5;
        IRoomBase r101 = r100.getRoom();
    L7:
        return b(r101);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean d() {
        yz0.g r100 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        String r101 = null;
        if (r100 == null) goto L5;
        IRoomBase r102 = r100.getRoom();
    L6:
        if (r102 == null) goto L11;
        Map<String, String> r103 = IRoomKt_androidKt.getAnchorABMap(r102);
        if (r103 == null) goto L11;
        r101 = r103.get("bigevent_disable_lynx_panel");
    L11:
        if (Intrinsics.areEqual(r101, "2") == false) goto L14;
    L18:
        return false;
    L14:
        if (vm2.i.a().getLinkServiceEnable() == false) goto L18;
        if (vm2.i.b().getSettingPanelOpen() == false) goto L18;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean b(IRoomBase r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = IRoomKt_androidKt.getAnchorABMap(r100);
        if (r101 == null) goto L6;
        String r102 = r101.get("bigevent_disable_lynx_panel");
    L8:
        if (Intrinsics.areEqual(r102, "2") == false) goto L11;
        return false;
    L11:
        if (vm2.i.a().getLinkServiceEnable() == true) goto L13;
        return false;
    L13:
        if (vm2.i.b().getEmojiPanelOpen() == false) goto L15;
    L16:
        return true;
    L15:
        if (vm2.i.b().getSettingPanelOpen() == true) goto L16;
        return false;
    L6:
        r102 = null;
        goto L8
    }
}
