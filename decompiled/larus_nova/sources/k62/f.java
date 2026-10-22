package k62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.PadAdjustViewHolder;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAdjustViewHolder f501955a;

    public f(PadAdjustViewHolder r100) {
        this.f501955a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        if (((PadOrientation) sh6.c.b(r101)) != PadOrientation.LANDSCAPE) goto L6;
        UIUtils.updateLayout(this.f501955a.itemView, -1, -3);
        return;
    L6:
        if (((PadOrientation) sh6.c.b(r101)) != PadOrientation.PORTRAIT) goto L10;
        UIUtils.updateLayout(this.f501955a.itemView, (int) (s1.y() * 0.6f), -3);
        return;
    }
}
