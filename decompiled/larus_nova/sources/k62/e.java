package k62;

import ak6.g;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelSystemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelSystemViewHolder f501954a;

    public e(ChatChannelSystemViewHolder r100) {
        this.f501954a = r100;
    }

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f501954a.f134339a;
        if (r101 == null) goto L6;
        r101.setText(r100.f4074a);
        return;
    }
}
