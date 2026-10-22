package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomSingEndedFeedbackViewContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "viewModel", "", "setKtvRoomViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomSingEndedFeedbackViewContainer extends FrameLayout implements a {
    public final a a;

    public KtvRoomSingEndedFeedbackViewContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomSingEndedFeedbackViewContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void F5(com.bytedance.android.livesdk.ktvimpl.base.sei.a r2) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.F5(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void p0(boolean r2) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.p0(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public void setKtvRoomViewModel(KtvRoomViewModel r2) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.setKtvRoomViewModel(r2);
        return;
    }

    public KtvRoomSingEndedFeedbackViewContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566533, this);
        KeyEvent.Callback r5 = findViewById(2131377058);
        if (r5 == null) goto L7;
        this.a = (a) r5;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.IKtvRoomSingEndedFeedbackView");
    }

    public /* synthetic */ KtvRoomSingEndedFeedbackViewContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
