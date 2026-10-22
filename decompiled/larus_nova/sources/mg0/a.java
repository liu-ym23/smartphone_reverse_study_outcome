package mg0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends jg0.a<MultiLinkPCLandscapeViewBinder.a> {
    @Override // jg0.c
    public final int o() {
        return R.layout.ttlive_layer_multilink_common_pc_landscape_stub;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkPCLandscapeMicSeatBasicLayer.name();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        HSImageView r101 = (HSImageView) q().findViewById(R.id.ttlive_empty_bg);
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public a(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        super(r100, r101);
    }

    @Override // jg0.f
    public final void d(Object r100, int r101) {
        Intrinsics.checkNotNullParameter((MultiLinkPCLandscapeViewBinder.a) r100, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter((MultiLinkPCLandscapeViewBinder.a) r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
    }
}
