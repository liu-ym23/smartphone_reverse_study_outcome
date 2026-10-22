package com.ss.android.lark.vote.message.pin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.content.VoteOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/vote/message/pin/VotePinOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/vote/message/pin/VotePinOptionAdapter$VoteOptionViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "optionList", "", "Lcom/ss/android/lark/vote/message/content/VoteOption;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "mContext", "mOptionList", "", "onClickListener", "Landroid/view/View$OnClickListener;", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "ellipsizeOptionList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "VoteOptionViewHolder", "Companion", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VotePinOptionAdapter extends RecyclerView.Adapter<VoteOptionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f445249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f445250b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/vote/message/pin/VotePinOptionAdapter$VoteOptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "optionContentTV", "Landroid/widget/TextView;", "getOptionContentTV", "()Landroid/widget/TextView;", "setOptionContentTV", "(Landroid/widget/TextView;)V", "voteOptionIcon", "Landroid/widget/ImageView;", "getVoteOptionIcon", "()Landroid/widget/ImageView;", "setVoteOptionIcon", "(Landroid/widget/ImageView;)V", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VoteOptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(10127)
        public TextView optionContentTV;

        @BindView(9657)
        public ImageView voteOptionIcon;

        public VoteOptionViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public final class VoteOptionViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VoteOptionViewHolder f445251a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            VoteOptionViewHolder r100 = this.f445251a;
            if (r100 == null) goto L7;
            this.f445251a = null;
            r100.optionContentTV = null;
            r100.voteOptionIcon = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public VoteOptionViewHolder_ViewBinding(VoteOptionViewHolder r100, View r101) {
            this.f445251a = r100;
            r100.optionContentTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.vote_option_tv, "field 'optionContentTV'", TextView.class);
            r100.voteOptionIcon = (ImageView) Utils.findRequiredViewAsType(r101, R.id.pin_vote_option_icon, "field 'voteOptionIcon'", ImageView.class);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f445250b).size();
    }

    public VotePinOptionAdapter(Context r100, List<VoteOption> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "optionList");
        this.f445249a = r100;
        if (r101.size() < 3) goto L5;
        int r102 = 3;
    L6:
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L13;
        String r105 = ((VoteOption) ListProtector.get(r101, r104)).getContent();
        if (r105 == null) goto L11;
        r103.add(r105);
    L11:
        r104 = r104 + 1;
        goto L7
    L13:
        if (r101.size() <= 3) goto L15;
        r103.add("...");
    L15:
        this.f445250b = r103;
        return;
    L5:
        r102 = r101.size();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VoteOptionViewHolder r102 = (VoteOptionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ImageView r103 = r102.voteOptionIcon;
        TextView r104 = null;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("voteOptionIcon");
        r103 = null;
    L6:
        int r105 = 0;
        if (r101 > 2) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L13;
        r105 = 8;
    L13:
        r103.setVisibility(r105);
        TextView r107 = r102.optionContentTV;
        if (r107 == null) goto L16;
        r104 = r107;
    L17:
        r104.setText((CharSequence) ListProtector.get(this.f445250b, r101));
        return;
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("optionContentTV");
        goto L17
    L9:
        r106 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new VoteOptionViewHolder(LayoutInflater.from(this.f445249a).inflate(R.layout.lark_vote_item_ping_option, r100, false));
    }
}
