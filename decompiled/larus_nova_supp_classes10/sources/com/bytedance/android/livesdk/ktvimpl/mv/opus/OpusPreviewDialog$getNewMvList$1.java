package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.view.OpusPreviewErrorView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;", "it", "", "fromRequest", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;Z)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class OpusPreviewDialog$getNewMvList$1 extends Lambda implements Function2<com.bytedance.android.livesdk.ktvapi.model.mv.a, Boolean, Unit> {
    final /* synthetic */ OpusPreviewDialog this$0;

    public OpusPreviewDialog$getNewMvList$1(OpusPreviewDialog r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(com.bytedance.android.livesdk.ktvapi.model.mv.a r5, boolean r6) {
        int r7 = 0;
        if (r5 != null) goto L34;
        OpusPreviewViewModel r8 = this.this$0.r;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L7:
        ArrayList r9 = (ArrayList) r8.getOpusMvList().getValue();
        OpusPreviewViewModel r1 = this.this$0.r;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L10:
        List r0 = (List) r1.getOfficialMvList().getValue();
        if (r9 != null) goto L13;
    L14:
        if (r0 != null) goto L16;
    L23:
        final OpusPreviewDialog r10 = this.this$0;
        Context r2 = r10.getContext();
        if (r2 == null) goto L46;
        OpusPreviewErrorView r3 = r10.h;
        if (r3 != null) goto L31;
        r3 = new OpusPreviewErrorView(r2, null);
        FrameLayout r4 = r10.v;
        if (r4 == null) goto L31;
        r4.addView(r3, new ViewGroup.LayoutParams(-1, -1));
    L31:
        r10.h = r3;
        r3.setVisibility(0);
        OpusPreviewErrorView r11 = r10.h;
        if (r11 == null) goto L43;
        r11.setRetryCallback(new OpusPreviewDialog$showErrorView$$inlined$run$lambda$1(r10));
        return;
    L43:
        return;
    L46:
        return;
    L16:
        if (r0.isEmpty() == true) goto L23;
    L18:
        Function2<? super Integer, ? super Boolean, Unit> r12 = this.this$0.i;
        if (r12 == null) goto L41;
        if (r9 == null) goto L22;
        r7 = r9.size();
    L22:
        Unit r13 = (Unit) r12.invoke(Integer.valueOf(r7), Boolean.FALSE);
        return;
    L41:
        return;
    L13:
        if (r9.isEmpty() == false) goto L18;
    L34:
        Function2<? super Integer, ? super Boolean, Unit> r14 = this.this$0.i;
        if (r14 == null) goto L45;
        List r15 = r5.e();
        if (r15 == null) goto L39;
        r7 = r15.size();
    L39:
        Unit r16 = (Unit) r14.invoke(Integer.valueOf(r7), Boolean.FALSE);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.android.livesdk.ktvapi.model.mv.a) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
