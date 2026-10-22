package com.ss.android.lark.message.vote.chatthread;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class VoteCardViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VoteCardViewHolder f432292a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        VoteCardViewHolder r100 = this.f432292a;
        if (r100 == null) goto L7;
        this.f432292a = null;
        r100.mTitleLayout = null;
        r100.mTitleTv = null;
        r100.mSelectTypeTv = null;
        r100.mOptionsRv = null;
        r100.mNumberOfParticipantsTv = null;
        r100.mActualParticipantNumberTv = null;
        r100.mActionBtn = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public VoteCardViewHolder_ViewBinding(VoteCardViewHolder r100, View r101) {
        this.f432292a = r100;
        r100.mTitleLayout = Utils.findRequiredView(r101, R.id.title_layout, "field 'mTitleLayout'");
        r100.mTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.title_tv, "field 'mTitleTv'", TextView.class);
        r100.mSelectTypeTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.select_type_tv, "field 'mSelectTypeTv'", TextView.class);
        r100.mOptionsRv = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.options_rv, "field 'mOptionsRv'", RecyclerView.class);
        r100.mNumberOfParticipantsTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.number_of_participants_tv, "field 'mNumberOfParticipantsTv'", TextView.class);
        r100.mActualParticipantNumberTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.actual_participant_number_tv, "field 'mActualParticipantNumberTv'", TextView.class);
        r100.mActionBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.action_btn, "field 'mActionBtn'", TextView.class);
    }
}
