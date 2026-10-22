package ey1;

import android.content.Context;
import com.bytedance.android.livesdk.gift.blindbox.BlindBoxGiftPlugin;
import com.bytedance.android.livesdk.gift.blindbox.c;
import com.bytedance.android.livesdk.gift.platform.business.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements h.a {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h.a
    public final h a(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IRoom r102 = (IRoom) r100.get("data_room", null);
        if (r102 == null) goto L5;
        boolean r103 = r102.isMediaRoom();
    L6:
        if (r102 == null) goto L8;
        long r104 = r102.getId();
    L9:
        JSONObject r105 = new JSONObject();
        c.f(r105, "is_enabled", Boolean.TRUE);
        c.f(r105, "room_id", Long.valueOf(r104));
        c.f(r105, "is_media_room", Boolean.valueOf(r103));
        c.e("ttlive_blind_box_plugin_status", 0, r105);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_plugin_status " + r105);
        return new BlindBoxGiftPlugin(r100, r101);
    L8:
        r104 = 0;
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
