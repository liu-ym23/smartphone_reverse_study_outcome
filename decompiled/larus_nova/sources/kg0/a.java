package kg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import jg0.c;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends c<e> {
    @Override // jg0.c
    public final int o() {
        return R.layout.ttlive_layer_multilink_dummy_stub;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkDummyLayer.name();
    }

    public a(MicSeatScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        super(r100, null);
    }

    @Override // jg0.f
    public final void d(Object r100, int r101) {
        Intrinsics.checkNotNullParameter((e) r100, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter((e) r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
    }
}
