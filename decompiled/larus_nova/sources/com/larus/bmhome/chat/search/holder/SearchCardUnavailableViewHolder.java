package com.larus.bmhome.chat.search.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.search.view.SearchUnavailableView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardUnavailableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "boxView", "Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;", "<init>", "(Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;)V", "bind", "", "text", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCardUnavailableViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f308663b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchUnavailableView f308664a;

    public static final class a {
        public static SearchCardUnavailableViewHolder a(ViewGroup r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            SearchUnavailableView r103 = new SearchUnavailableView(r100.getContext(), null, 6, 0);
            r103.setLayoutParams(new FrameLayout.LayoutParams(r101, r102));
            return new SearchCardUnavailableViewHolder(r103);
        }
    }

    static {
    }

    public SearchCardUnavailableViewHolder(SearchUnavailableView r100) {
        super(r100);
        this.f308664a = r100;
    }

    public final void bind(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        FLogger.f375446a.e("SearchListBox_Unavailable", r100);
        if (AppHost.f326268a.isDebug() == false) goto L6;
        this.f308664a.setText(r100);
        return;
    }
}
