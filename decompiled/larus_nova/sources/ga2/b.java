package ga2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f480544a = null;

    public b() {
    }

    static {
        f480544a = new b();
    }

    @Override // ga2.a
    public final void a(f<?> r100, k r101) {
        if (((HashMap) r100.f133152m).containsKey("show_tag_for_public_screen_track_stat") == false) goto L5;
        return;
    L5:
        Map<String, String> r102 = r100.f133152m;
        if (r102 == null) goto L8;
        ((HashMap) r102).put("show_tag_for_public_screen_track_stat", "has_show");
    L8:
        LinkedHashMap r103 = new LinkedHashMap();
        IPublicAreaCommon r104 = r100.v();
        String r105 = "";
        if (r104 == null) goto L14;
        Map<String, String> r106 = r104.getTrackingParams();
        if (r106 == null) goto L14;
        String r107 = r106.get(SeiMessageConst.MSG_TYPE);
        if (r107 == null) goto L14;
    L15:
        r103.put(SeiMessageConst.MSG_TYPE, r107);
        if (r101 == null) goto L21;
        String r108 = r101.c();
        if (r108 == null) goto L21;
        r105 = r108;
    L21:
        r103.put("selected_mode_type", r105);
        int r109 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.f133631a;
        if (r101 == null) goto L26;
        WeakReference<DataCenter> r110 = r101.getDataCenter();
        if (r110 == null) goto L26;
        DataCenter r111 = r110.get();
    L27:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r103, r111);
        j0.l().sendLog("livesdk_selected_msg_layer_msg_show", r103, new Object[]{Room.class});
        return;
    L26:
        r111 = null;
    L14:
        r107 = "";
        goto L15
    }
}
