package com.bytedance.android.shopping.slice.elements.liveplayer;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.prepurchase.arch.container.state.f;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.ecom.arch.slice.render.elements.b<SlcPdpLivePlayerView> {
    public SlcPdpLivePlayerView H3;
    public final SlcTemplateContext I3;

    public e(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
        this.I3 = r2;
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
    public final void m1(View r2) {
        SlcPdpLivePlayerView r3 = (SlcPdpLivePlayerView) r2;
        Intrinsics.checkNotNullParameter(r3, "contentView");
        this.H3 = r3;
    }

    public final View n1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r0 = this.I3.w.g(u.class);
        Context r2 = null;
        if ((r0 instanceof u) == true) goto L5;
        r0 = null;
    L5:
        u r1 = (u) r0;
        if (r1 == null) goto L11;
        PdpRootComponent r3 = r1.k();
        if (r3 == null) goto L11;
        LifecycleOwner r5 = f.a(r3);
    L16:
        return new SlcPdpLivePlayerView(r4, r5);
    L11:
        if ((r4 instanceof LifecycleOwner) == false) goto L14;
        r2 = r4;
    L14:
        r5 = (LifecycleOwner) r2;
        goto L16
    }
}
