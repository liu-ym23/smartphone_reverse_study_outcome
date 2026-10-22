package k62;

import ak6.g;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelChatViewHolder f501949a;

    public a(ChatChannelChatViewHolder r100) {
        this.f501949a = r100;
    }

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f501949a.f134331c;
        if (r101 == null) goto L6;
        r101.setText(r100.f4074a);
        return;
    }
}
