package com.ss.android.lark.forwardv3.recentforward;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.forwardv3.recentforward.viewholder.EmptyViewHolder;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xib.c;
import xib.f;
import xib.g;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u001a\u0010\u001e\u001a\u00020\u00162\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010 H\u0016J2\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u001c2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemClickHandler", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemClickListener;", "onItemBusinessConsumeClickListener", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemBusinessConsumeClickListener;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemClickListener;Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemBusinessConsumeClickListener;)V", "binderRepo", "Lcom/ss/android/lark/forwardv3/recentforward/binder/BinderRepo;", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "isValid", "", MapController.ITEM_LAYER_TAG, "diff", "collection", "", "withPayloads", "clearCheckedStatus", "switchMultiple", "isMultiple", "OnItemClickListener", "OnItemBusinessConsumeClickListener", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentForwardAdapterV3 extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, SearchBaseInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f425513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xib.b f425514b;

    public interface a {
        boolean a(SearchBaseInfo r100);
    }

    public interface b {
        void a(SearchBaseInfo r100, int r101, boolean r102);
    }

    public final void y2() {
        Iterator r100 = this.items.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((SearchBaseInfo) r100.next()).selected(false);
        goto L4
    L6:
        notifyDataSetChanged();
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public final void diff(Collection<? extends SearchBaseInfo> r100) {
        boolean r101 = com.ss.android.lark.forwardv3.utils.b.a("lark.forward.disable_recent_forward_thread_filter", false);
        Log.i("FGUtils", "FG key: core.forward.disable_recent_forward_thread_filter: " + r101);
        if (r101 == true) goto L22;
        if (r100 == null) goto L20;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        SearchBaseInfo r105 = (SearchBaseInfo) r104;
        if ((r105 instanceof SearchChatInfo) == false) goto L11;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        if ((r105 instanceof SearchChatterInfo) == true) goto L16;
        if ((r105 instanceof SearchShieldP2PChatInfo) == true) goto L16;
        r106 = false;
        goto L17
    L19:
        List r107 = CollectionsKt.toMutableList(r102);
    L21:
        super.diff(r107);
        return;
    L20:
        r107 = null;
        goto L21
    L22:
        super.diff(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        SearchBaseInfo r101 = getItem(r100);
        if ((r101 instanceof SearchChatInfo) == false) goto L6;
        return 1;
    L6:
        if ((r101 instanceof SearchChatterInfo) == false) goto L9;
        return 2;
    L9:
        if ((r101 instanceof SearchShieldP2PChatInfo) == false) goto L11;
        return 3;
    L11:
        return 0;
    }

    public final void switchMultiple(boolean r100) {
        xib.b r101 = this.f425514b;
        r101.f564007a.f564006a = r100;
        r101.f564008b.f564006a = r100;
        r101.f564009c.f564006a = r100;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        z2(r101, r100, false, new ArrayList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L10;
        return new EmptyViewHolder(new View(this.f425513a));
    L10:
        return new RecentForwardViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.item_recent_forward_for_chat_chatter, r100, false), r101);
    }

    public RecentForwardAdapterV3(Context r100, b r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r102, "onItemBusinessConsumeClickListener");
        this.f425513a = r100;
        this.f425514b = new xib.b(r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        z2(r101, r100, !r102.isEmpty(), r102);
    }

    public final void z2(int r100, RecyclerView.ViewHolder r101, boolean r110, List<Object> r111) {
        SearchBaseInfo r102 = getItem(r100);
        if ((r101 instanceof RecentForwardViewHolder) == false) goto L32;
        RecentForwardViewHolder r103 = (RecentForwardViewHolder) r101;
        int r104 = r103.f425515a;
        int r105 = 0;
        if (r104 == 1) goto L22;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L12;
        return;
    L12:
        if (r110 == false) goto L14;
        g r106 = this.f425514b.f564009c;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        r106.c((SearchShieldP2PChatInfo) r102, r103, r111);
        return;
    L14:
        g r112 = this.f425514b.f564009c;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        SearchShieldP2PChatInfo r107 = (SearchShieldP2PChatInfo) r102;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r107, "data");
        Intrinsics.checkNotNullParameter(r103, "holder");
        r112.a(r100, r107, r103);
        Intrinsics.checkNotNullParameter(r107, "data");
        Intrinsics.checkNotNullParameter(r103, "holder");
        ImageView r108 = r103.f425519e;
        if (r108 == null) goto L34;
        r108.setBackground(d.e(r108.getContext(), R.drawable.ic_shield_chat_recent_forward_new));
        r108.setVisibility(0);
        return;
    L34:
        return;
    L18:
        if (r110 == false) goto L20;
        c r109 = this.f425514b.f564007a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r109.c((SearchChatterInfo) r102, r103, r111);
        return;
    L20:
        c r113 = this.f425514b.f564007a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r113.a(r100, (SearchChatterInfo) r102, r103);
        return;
    L22:
        if (r110 == false) goto L24;
        f r114 = this.f425514b.f564008b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        r114.c((SearchChatInfo) r102, r103, r111);
        return;
    L24:
        f r115 = this.f425514b.f564008b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        SearchChatInfo r116 = (SearchChatInfo) r102;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "data");
        Intrinsics.checkNotNullParameter(r103, "holder");
        r115.a(r100, r116, r103);
        Intrinsics.checkNotNullParameter(r116, "data");
        Intrinsics.checkNotNullParameter(r103, "holder");
        ImageView r117 = r103.f425519e;
        if (r117 == null) goto L39;
        r117.setBackground(d.e(r117.getContext(), R.drawable.ic_shield_chat_recent_forward_new));
        if (r116.isShield() == true) goto L30;
        r105 = 8;
    L30:
        r117.setVisibility(r105);
        return;
    L39:
        return;
    }
}
