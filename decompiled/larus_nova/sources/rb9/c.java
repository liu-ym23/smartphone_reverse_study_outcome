package rb9;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.main.side_bar.feed.arch.FlowFeedAdapter;
import eb9.o;
import fb9.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f536993a = null;

    static {
        f536993a = new c();
    }

    public c() {
    }

    @Override // fb9.f
    public final String c(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof FlowFeedAdapter.FlowFeedViewHolder) == false) goto L5;
        FlowFeedAdapter.FlowFeedViewHolder r101 = (FlowFeedAdapter.FlowFeedViewHolder) r100;
    L6:
        if (r101 == null) goto L14;
        o<?> r102 = r101.f344568d;
        if (r102 == null) goto L10;
        String r103 = r102.f471907a;
    L11:
        if (r103 == null) goto L14;
        return r103;
    L10:
        r103 = null;
    L14:
        if (r100 != null) goto L16;
        return null;
    L16:
        return Long.valueOf(r100.getItemId()).toString();
    L5:
        r101 = null;
        goto L6
    }

    @Override // fb9.f
    public final void m(int r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if ((r101 instanceof FlowFeedAdapter.FlowFeedViewHolder) == false) goto L5;
        FlowFeedAdapter.FlowFeedViewHolder r102 = (FlowFeedAdapter.FlowFeedViewHolder) r101;
    L6:
        if (r102 == null) goto L11;
        o<?> r103 = r102.f344568d;
        if (r103 == null) goto L12;
        r102.f344565a.h(r103, r102.itemView, r102.getBindingAdapterPosition(), r102.f344567c);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
