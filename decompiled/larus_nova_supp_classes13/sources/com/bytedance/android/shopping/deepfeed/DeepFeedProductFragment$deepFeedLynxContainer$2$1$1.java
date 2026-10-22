package com.bytedance.android.shopping.deepfeed;

import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DeepFeedProductFragment$deepFeedLynxContainer$2$1$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public DeepFeedProductFragment$deepFeedLynxContainer$2$1$1(DeepFeedProductFragment r8) {
        super(1, r8, DeepFeedProductFragment.class, "onLynxPopupVisibilityChanged", "onLynxPopupVisibilityChanged(Z)V", 0);
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [android.widget.FrameLayout, com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView] */
    public final void invoke(boolean r6) {
        DeepFeedProductFragment r0 = (DeepFeedProductFragment) ((CallableReference) this).receiver;
        boolean r1 = false;
        AbsDeepFeedProductVH r2 = null;
        if (r6 == false) goto L33;
        AbsDeepFeedProductVH r7 = r0.v;
        if ((r7 instanceof DeepFeedProductSlcVH) == false) goto L8;
        r2 = r7;
    L8:
        DeepFeedProductSlcVH r3 = (DeepFeedProductSlcVH) r2;
        if (r3 == null) goto L69;
        r0.x = r3;
        DeepFeedSlcList r8 = r3.C4();
        if (r8 == null) goto L30;
        DeepFeedSliceVideoView r9 = r8.y();
        if (r9 == null) goto L27;
        ECVideoPlayerView r4 = r9.d;
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L25;
        ECVideoPlayerView r10 = r9.d;
        if (r10 == null) goto L25;
        r10.m();
    L25:
        if (r5 != true) goto L27;
        boolean r11 = true;
    L28:
        if (r11 != true) goto L30;
        r1 = true;
        goto L30
    L18:
        if (r4.h() != true) goto L20;
        r5 = true;
    L27:
        r11 = false;
    L30:
        r0.z = r1;
        DeepFeedSlcList r12 = r3.C4();
        if (r12 == null) goto L67;
        r12.m = true;
        r12.D();
        return;
    L67:
        return;
    L69:
        return;
    L33:
        DeepFeedProductSlcVH r13 = r0.x;
        if (r13 == null) goto L47;
        DeepFeedSlcList r14 = r13.C4();
        if (r14 == null) goto L47;
        r14.m = false;
        com.bytedance.android.shopping.deepfeed.slice.view.list.c r15 = r14.n;
        if (r15.a == false) goto L47;
        if (r15.b == false) goto L47;
        if (r14.l == false) goto L47;
        if (r14.i == true) goto L47;
        r14.C();
    L47:
        if (r0.z == false) goto L65;
        DeepFeedProductSlcVH r16 = r0.x;
        if (r16 == null) goto L65;
        DeepFeedSlcList r17 = r16.C4();
        if (r17 == null) goto L65;
        ?? r18 = r17.y();
        if (r18 == 0) goto L65;
        if (r18.h.i == false) goto L65;
        if (r18.isAttachedToWindow() == false) goto L65;
        ECVideoPlayerView r19 = r18.d;
        if (r19 == null) goto L65;
        if (r19.h() == true) goto L65;
        ECVideoPlayerView r20 = r18.d;
        if (r20 == null) goto L65;
        r20.u();
    L65:
        r0.x = null;
        r0.z = false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
