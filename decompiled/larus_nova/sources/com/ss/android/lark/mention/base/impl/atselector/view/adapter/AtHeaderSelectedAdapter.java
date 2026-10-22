package com.ss.android.lark.mention.base.impl.atselector.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.joooonho.SelectableRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class AtHeaderSelectedAdapter extends LarkRecyclerViewBaseAdapter<SelectedChatterViewHolder, BaseAtBean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f431830c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f431831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f431832b;

    public static class SelectedChatterViewHolder extends RecyclerView.ViewHolder {

        @BindView(9088)
        SelectableRoundedImageView mAvatar;

        public SelectedChatterViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class SelectedChatterViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SelectedChatterViewHolder f431833a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            SelectedChatterViewHolder r100 = this.f431833a;
            if (r100 == null) goto L7;
            this.f431833a = null;
            r100.mAvatar = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public SelectedChatterViewHolder_ViewBinding(SelectedChatterViewHolder r100, View r101) {
            this.f431833a = r100;
            r100.mAvatar = (SelectableRoundedImageView) Utils.findRequiredViewAsType(r101, R.id.at_select_preview_avatar, "field 'mAvatar'", SelectableRoundedImageView.class);
        }
    }

    public interface a {
    }

    static {
        f431830c = UIHelper.getDimens(R.dimen.avatar_width_chatter);
    }

    public AtHeaderSelectedAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SelectedChatterViewHolder r102 = (SelectedChatterViewHolder) r100;
        BaseAtBean r103 = getItem(r101);
        Context r104 = this.f431831a;
        SelectableRoundedImageView r105 = r102.mAvatar;
        int r106 = f431830c;
        r103.showAvatar(r104, r105, r106, r106);
        r102.itemView.setOnClickListener(new com.ss.android.lark.mention.base.impl.atselector.view.adapter.a(this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f431831a = r100.getContext();
        return new SelectedChatterViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.at_select_preview_item, r100, false));
    }
}
