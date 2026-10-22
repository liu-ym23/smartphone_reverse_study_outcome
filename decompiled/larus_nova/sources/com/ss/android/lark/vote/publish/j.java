package com.ss.android.lark.vote.publish;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteRecycleAdapter f445300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AddViewHolder f445301b;

    public j(VoteRecycleAdapter r100, AddViewHolder r101) {
        this.f445300a = r100;
        this.f445301b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f445300a.getItemCount() >= 52) goto L5;
        VoteRecycleAdapter r101 = this.f445300a;
        r101.f445287d = true;
        int r102 = r101.f445284a.size() - 1;
        g r103 = new g(VoteItemType.OPTION.ordinal());
        ListProtector.add(r101.f445284a, r102, r103);
        r101.notifyItemInserted(r102);
        AppCompatImageView r104 = this.f445301b.f445258b;
        r104.setImageTintList(AppCompatResources.getColorStateList(r104.getContext(), R.color.icon_disable));
        TextView r105 = this.f445301b.f445257a;
        r105.setTextColor(AppCompatResources.getColorStateList(r105.getContext(), R.color.text_disable));
        this.f445301b.itemView.setEnabled(false);
        VoteRecycleAdapter.y2(this.f445300a);
        this.f445300a.f445285b.b();
        this.f445300a.f445285b.a();
        return;
    L5:
        this.f445300a.f445285b.showToast(UIHelper.mustacheFormat(R.string.Lark_IM_Poll_CreatePoll_TooManyOptions_Toast, "num", "50"));
    }
}
