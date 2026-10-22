package com.ss.android.lark.forwardv3.confirmdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onItemClickListener", "Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "OnItemClickListener", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardConfirmDialogAdapter extends LarkRecyclerViewBaseAdapter<ForwardConfirmDialogViewHolder, SearchBaseInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f425258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f425259b;

    public interface a {
        void a(SearchBaseInfo r100);
    }

    public ForwardConfirmDialogAdapter(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f425258a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ForwardConfirmDialogViewHolder r102 = (ForwardConfirmDialogViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        SearchBaseInfo r103 = getItem(r101);
        LKUIRoundedImageView r104 = r102.f425261a;
        LKUIRoundedImageView r105 = r102.f425262b;
        if (r104 == null) goto L12;
        if (r105 == null) goto L15;
        int r106 = n.f425590a;
        Context r107 = this.f425258a;
        Intrinsics.checkNotNull(r103);
        n.c(r107, r103, r104, r105);
        a r108 = this.f425259b;
        if (r108 == null) goto L13;
        Intrinsics.checkNotNullParameter(r108, "onItemClickListener");
        Intrinsics.checkNotNullParameter(r103, "data");
        FrameLayout r109 = r102.f425263c;
        if (r109 == null) goto L14;
        r109.setOnClickListener(new com.ss.android.lark.forwardv3.confirmdialog.a(r108, r103));
        return;
    L14:
        return;
    L13:
        return;
    L15:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_forward_confirm_dialog, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ForwardConfirmDialogViewHolder(r102);
    }
}
