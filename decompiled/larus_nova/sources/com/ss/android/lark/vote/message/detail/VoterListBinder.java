package com.ss.android.lark.vote.message.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.content.VoteUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VoterListBinder implements a<VoteUser, VoterListItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f445235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f445236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f445237c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/vote/message/detail/VoterListBinder$VoterListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mVotePeopleAvator", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getMVotePeopleAvator", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "setMVotePeopleAvator", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;)V", "mVotePeopleName", "Landroid/widget/TextView;", "getMVotePeopleName", "()Landroid/widget/TextView;", "setMVotePeopleName", "(Landroid/widget/TextView;)V", "mVoteMaster", "getMVoteMaster", "setMVoteMaster", "mExternalTag", "getMExternalTag", "setMExternalTag", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VoterListItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(9209)
        public TextView mExternalTag;

        @BindView(10125)
        public TextView mVoteMaster;

        @BindView(10128)
        public LKUIRoundedImageView mVotePeopleAvator;

        @BindView(10130)
        public TextView mVotePeopleName;

        public VoterListItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public final class VoterListItemViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VoterListItemViewHolder f445238a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            VoterListItemViewHolder r100 = this.f445238a;
            if (r100 == null) goto L7;
            this.f445238a = null;
            r100.mVotePeopleAvator = null;
            r100.mVotePeopleName = null;
            r100.mVoteMaster = null;
            r100.mExternalTag = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public VoterListItemViewHolder_ViewBinding(VoterListItemViewHolder r100, View r101) {
            this.f445238a = r100;
            r100.mVotePeopleAvator = (LKUIRoundedImageView) Utils.findRequiredViewAsType(r101, R.id.vote_people_avator, "field 'mVotePeopleAvator'", LKUIRoundedImageView.class);
            r100.mVotePeopleName = (TextView) Utils.findRequiredViewAsType(r101, R.id.vote_people_name, "field 'mVotePeopleName'", TextView.class);
            r100.mVoteMaster = (TextView) Utils.findRequiredViewAsType(r101, R.id.vote_master, "field 'mVoteMaster'", TextView.class);
            r100.mExternalTag = (TextView) Utils.findRequiredViewAsType(r101, R.id.external_votter_tag, "field 'mExternalTag'", TextView.class);
        }
    }

    @Override // com.ss.android.lark.vote.message.detail.a
    public final RecyclerView.ViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new VoterListItemViewHolder(LayoutInflater.from(this.f445235a).inflate(R.layout.lark_vote_detail_people_list_item, r100, false));
    }

    public VoterListBinder(Context r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatId");
        this.f445235a = r100;
        this.f445236b = r101;
        this.f445237c = r102;
    }
}
