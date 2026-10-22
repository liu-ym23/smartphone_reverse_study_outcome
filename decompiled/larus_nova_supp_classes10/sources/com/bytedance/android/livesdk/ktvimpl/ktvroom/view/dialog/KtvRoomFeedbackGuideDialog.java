package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvMusicFeedbackDialog;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/KtvRoomFeedbackGuideDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomFeedbackGuideDialog extends BaseKtvDialogFragment {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> g;
    public KtvMusicFeedbackDialog.FeedbackType h;
    public DialogInterface.OnDismissListener i;
    public com.bytedance.android.live.ktv.common.ordersong.feedback.a j;

    public static final class a {
        public static KtvRoomFeedbackGuideDialog a(com.bytedance.android.live.ktv.common.ordersong.feedback.a r1, KtvMusicFeedbackDialog.FeedbackType r2) {
            Intrinsics.checkNotNullParameter(r1, "predicateContent");
            Intrinsics.checkNotNullParameter(r2, "feedbackType");
            KtvRoomFeedbackGuideDialog r0 = new KtvRoomFeedbackGuideDialog();
            r0.j = r1;
            r0.h = r2;
            r0.i = null;
            return r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ KtvRoomFeedbackGuideDialog a;

        public b(KtvRoomFeedbackGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            KtvRoomFeedbackGuideDialog r3 = this.a;
            ((BaseKtvDialogFragment) r3).d = null;
            r3.dismiss();     // Catch: Exception -> L5
        L9:
            KtvRoomFeedbackGuideDialog r4 = this.a;
            DialogInterface.OnDismissListener r0 = r4.i;
            if (r0 == null) goto L15;
            r0.onDismiss(r4.getDialog());
            return;
        L15:
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L9;
            d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    public final String S90() {
        return "KtvRoomFeedbackHintDialog";
    }

    public final int getLayoutId() {
        return 2131565577;
    }

    public final void V90() {
        KtvContext.Companion.getClass();
        List<MusicPanel> r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        if (r0 == null) goto L7;
        if ((!r0.isEmpty()) != true) goto L7;
    L8:
        super.V90();
        return;
    L7:
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L8;
    }

    public KtvRoomFeedbackGuideDialog() {
        this.g = new LinkedHashMap();
        this.h = KtvMusicFeedbackDialog.FeedbackType.KSONG_SONG_INFO;
        this.j = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
    }

    public final void onDestroyView() {
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onDestroyView();
        this.g.clear();
    }

    public final View X90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r2, r3);
        ((TextView) X90(2131376985)).setOnClickListener(new b(this));
        ((TextView) X90(2131376986)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        ConstraintLayout r4 = X90(2131367728);
        if (r4 == null) goto L5;
        KtvOrderSongThemeManager.b(r4, 1);
    L5:
        TextView r5 = (TextView) X90(2131376941);
        if (r5 == null) goto L8;
        KtvOrderSongThemeManager.d(r5, 10);
    L8:
        TextView r6 = (TextView) X90(2131376985);
        if (r6 == null) goto L12;
        KtvOrderSongThemeManager.c(r6, KtvOrderSongThemeManager.b);
        return;
    }
}
