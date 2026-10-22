package com.bytedance.android.shopping.slice.elements.liveplayer;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewManager<SlcPdpLivePlayerView> {
    public SlcPdpLivePlayerView H3;
    public final SlcTemplateContext I3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
        this.I3 = r2;
    }

    public final View A0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r0 = this.I3.w.g(AnchorV4VM.class);
        Context r2 = null;
        if ((r0 instanceof AnchorV4VM) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4VM r1 = (AnchorV4VM) r0;
        if (r1 == null) goto L10;
        LifecycleOwner r3 = r1.getLifecycleOwner();
        if (r3 == null) goto L10;
    L15:
        return new SlcPdpLivePlayerView(r4, r3);
    L10:
        if ((r4 instanceof LifecycleOwner) == false) goto L13;
        r2 = r4;
    L13:
        r3 = (LifecycleOwner) r2;
        goto L15
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((SlcPdpLivePlayerView) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "props");
        Object r8 = r7.get("live_info");
        Object r1 = null;
        if ((r8 instanceof Map) == true) goto L5;
        r8 = null;
    L5:
        Map r9 = (Map) r8;
        if (r9 == null) goto L28;
        SlcPdpLivePlayerView r0 = this.H3;
        if (r0 == null) goto L29;
        Object r3 = r9.get("room_id");
        if ((r3 instanceof String) == true) goto L12;
        r3 = null;
    L12:
        String r4 = (String) r3;
        Object r5 = r9.get("stream_data");
        if ((r5 instanceof String) == true) goto L15;
        r5 = null;
    L15:
        String r6 = (String) r5;
        Object r10 = r9.get("cover");
        if ((r10 instanceof Map) == true) goto L18;
        r10 = null;
    L18:
        Map r11 = (Map) r10;
        if (r11 == null) goto L21;
        Object r12 = r11.get("src");
    L23:
        if ((r12 instanceof String) == false) goto L26;
        r1 = r12;
    L26:
        r0.d(new a(r6, r4, (String) r1));
        return;
    L21:
        r12 = null;
        goto L23
    L29:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(View r2) {
        SlcPdpLivePlayerView r3 = (SlcPdpLivePlayerView) r2;
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        this.H3 = r3;
    }
}
