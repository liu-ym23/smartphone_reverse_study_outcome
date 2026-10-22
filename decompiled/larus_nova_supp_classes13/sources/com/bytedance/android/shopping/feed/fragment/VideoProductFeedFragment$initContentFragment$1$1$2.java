package com.bytedance.android.shopping.feed.fragment;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class VideoProductFeedFragment$initContentFragment$1$1$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public VideoProductFeedFragment$initContentFragment$1$1$2(VideoProductFeedFragment r8) {
        super(1, r8, VideoProductFeedFragment.class, "setInflowState", "setInflowState(I)V", 0);
    }

    public final void invoke(int r3) {
        VideoProductFeedFragment r0 = (VideoProductFeedFragment) ((CallableReference) this).receiver;
        int r1 = VideoProductFeedFragment.O;
        BottomSheetBehavior<View> r2 = r0.f;
        if (r2 == null) goto L6;
        r2.setState(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
