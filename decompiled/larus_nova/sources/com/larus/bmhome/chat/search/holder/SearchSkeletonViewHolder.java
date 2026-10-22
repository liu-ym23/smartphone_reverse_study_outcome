package com.larus.bmhome.chat.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.search.SkeletonInfo;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchSkeletonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "position", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/SkeletonInfo;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSkeletonViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308683a = 0;

    public static final class a {
        public static SearchSkeletonViewHolder a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_search_card_skeleton_holder, r100, false);
            Intrinsics.checkNotNull(r101);
            return new SearchSkeletonViewHolder(r101);
        }
    }

    static {
    }

    public SearchSkeletonViewHolder() {
        throw null;
    }

    public SearchSkeletonViewHolder(View r100) {
        super(r100);
    }

    public static void T3(SkeletonInfo r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        FLogger.f375446a.d("SearchListBox_Skeleton", "search skeleton holder bind, item_id: " + r100.getId());
    }
}
