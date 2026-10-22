package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.ec.model.response.anchorv3.VideoModelStruct;
import com.bytedance.android.shopping.anchorv3.videowindow.VideoWindowSession;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowMeta;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.WindowConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightControl;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vg3.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ b.a a;

    public a(b.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r14) {
        boolean r15 = ((Boolean) r14).booleanValue();
        int r0 = com.bytedance.android.shopping.anchorv4.video.float.e.a;
        boolean r2 = true;
        if (r0 != 1) goto L5;
    L8:
        Boolean r1 = null;
        if (r2 == false) goto L33;
        final b r3 = this.a.a;
        final SmallVideoWindowVO r4 = r3.m;
        if (r4 == null) goto L74;
        if (r15 == true) goto L15;
        v r16 = r3.n;
        if (r16 == null) goto L69;
        r16.close(false);
        return;
    L69:
        return;
    L15:
        if (r3.n != null) goto L75;
        b0 r17 = (b0) r3.N1(b0.class);
        if (r17 == null) goto L67;
        fj.d r5 = r3.h2(r4);
        VideoModelStruct r6 = r4.getVideoModel();
        if (r6 == null) goto L22;
        ECPDPBaseVideo r7 = r6.getVideoV2();
    L23:
        WindowConfig r8 = r3.g2().getNativeParams().getWindowConfig();
        if (r8 == null) goto L26;
        r1 = Boolean.valueOf(r8.getForceMute());
    L26:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.l r9 = r17.W(r5, r7, r1, null, new LiveVideoComponent$toggleFloatVideo$$inlined$let$lambda$1(r3, r4), r4.getVideoTrackMeta(), null, true);
        if (r9 == null) goto L76;
        r3.n = r17.g1(r9);
        return;
    L76:
        return;
    L22:
        r7 = null;
        goto L23
    L67:
        return;
    L75:
        return;
    L74:
        return;
    L33:
        final b r10 = this.a.a;
        SmallVideoWindowVO r11 = r10.m;
        if (r11 == null) goto L77;
        View r12 = r10.e2();
        if (r12 == null) goto L66;
        final FrameLayout r13 = (FrameLayout) r12;
        if (r15 == false) goto L61;
        fj.d r18 = r10.h2(r11);
        if (r10.o != null) goto L71;
        vg3.a r19 = (vg3.a) r10.N1(vg3.a.class);
        int r20 = VideoWindowSession.t;
        Lifecycle r21 = com.bytedance.android.shopping.prepurchase.arch.container.state.f.a(r10).getLifecycleCompat();
        if (r21 == null) goto L60;
        SmallVideoWindowMeta r22 = r11.getSmallVideoWindowMeta();
        if (r22 == null) goto L47;
        String r23 = r22.getVideoLinkUrl();
    L48:
        if (r19 == null) goto L50;
        vg3.c r24 = r19.v();
    L51:
        Intrinsics.checkNotNull(r24);
        com.bytedance.android.shopping.anchorv3.videowindow.a r25 = new LiveVideoComponent$toggleVideoWindow$1(r10, r13);
        CommonMeta r26 = r10.O1().d().getData().a().a();
        if (r26 == null) goto L54;
        BottomRightControl r110 = r26.getBottomRightControl();
    L55:
        VideoWindowSession r27 = VideoWindowSession.a.a(r13, r18, r21, r23, r24, r25, r110);
        WindowConfig r28 = r10.g2().getNativeParams().getWindowConfig();
        if (r28 == null) goto L58;
        r1 = Boolean.valueOf(r28.getForceMute());
    L58:
        r27.k(r19.e(), r1);
        Unit r111 = Unit.INSTANCE;
        r10.o = r27;
        return;
    L54:
        r110 = null;
        goto L55
    L50:
        r24 = null;
        goto L51
    L47:
        r23 = null;
        goto L48
    L60:
        throw new IllegalStateException("Required value was null.".toString());
    L71:
        return;
    L61:
        VideoWindowSession r112 = r10.o;
        if (r112 == null) goto L73;
        r112.f();
        r10.o = null;
        return;
    L73:
        return;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L77:
        return;
    L5:
        if (r0 == 6) goto L8;
        r2 = false;
        goto L8
    }
}
