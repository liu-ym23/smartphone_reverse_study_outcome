package com.ss.android.lark.picker.doubao.selectedmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.doubao.view.DoubaoCustomBinderViewHolder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: classes37.dex */
public class DoubaoSelectedMoreAdapter extends LarkRecyclerViewBaseAdapter<SelectedMemberViewHolder, SearchBaseInfo> {
    private static final String TAG = "LarkSearch.Common.SelectedMoreAdapter";
    private Context mContext;
    private OnItemRemoveListener mItemRemoveListener;

    public interface OnItemRemoveListener {
        void onItemRemove(SearchBaseInfo r100);
    }

    public static class SelectedMemberViewHolder extends RecyclerView.ViewHolder {
        public DoubaoCustomBinderViewHolder innerHolder;
        public View item;
        public View remove;

        public SelectedMemberViewHolder(View r100) {
            super(r100);
            this.item = r100.findViewById(R.id.doubao_item_body);
            this.innerHolder = new DoubaoCustomBinderViewHolder(this.item);
            this.remove = r100.findViewById(R.id.selected_remove);
        }
    }

    public DoubaoSelectedMoreAdapter(Context r100) {
        this.mContext = r100;
    }

    public static /* synthetic */ OnItemRemoveListener access$000(DoubaoSelectedMoreAdapter r100) {
        return r100.mItemRemoveListener;
    }

    public void setOnItemRemoveListener(OnItemRemoveListener r100) {
        this.mItemRemoveListener = r100;
    }

    public void onBindViewHolder(SelectedMemberViewHolder r100, int r101) {
        final SearchBaseInfo r102 = getItem(r101);
        r100.remove.setOnClickListener(new AnonymousClass1(this, r102));
        r100.innerHolder.bindTitle(r102);
        r100.innerHolder.bindAvatar(r102);
        r100.innerHolder.bindSummary(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectedMemberViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new SelectedMemberViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.doubao_selected_more_item, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((SelectedMemberViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }
}
