package k62;

import ak6.g;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelChatViewHolder f501950a;

    public b(ChatChannelChatViewHolder r100) {
        this.f501950a = r100;
    }

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f501950a.f134331c;
        if (r101 == null) goto L6;
        r101.setText(r100.f4074a);
        return;
    }
}
