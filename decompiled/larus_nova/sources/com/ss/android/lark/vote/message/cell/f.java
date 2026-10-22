package com.ss.android.lark.vote.message.cell;

import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.vote.v1.VoteStatus;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vote.message.content.VoteContent;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteContent f445206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteMessageCell.VoteMessageViewHolder f445207b;

    public f(VoteContent r100, VoteMessageCell.VoteMessageViewHolder r101) {
        this.f445206a = r100;
        this.f445207b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L12;
        VoteContent r102 = this.f445206a;
        VoteMessageCell.VoteMessageViewHolder r103 = this.f445207b;
        r101.booleanValue();
        if (r102.getStatus() == VoteStatus.OPEN) goto L7;
        r103.b().setTextColor(UIHelper.getColor(R.color.text_disable));
        r103.b().setStrokeColor(UIHelper.getColor(R.color.text_disable));
        r103.b().setText(UIHelper.getString(R.string.Lark_IM_Poll_Result_PollEnded_Button));
        r103.b().setEnabled(false);
        return;
    L7:
        if (r101.booleanValue() == false) goto L9;
        r103.b().setTextColor(UIHelper.getColor(R.color.primary_content_default));
        r103.b().setStrokeColor(UIHelper.getColor(R.color.primary_content_default));
        r103.b().setText(UIHelper.getString(R.string.Lark_IM_Poll_Detail_VoteNow_Button));
        r103.b().setEnabled(true);
        return;
    L9:
        r103.b().setTextColor(UIHelper.getColor(R.color.text_disable));
        r103.b().setStrokeColor(UIHelper.getColor(R.color.text_disable));
        r103.b().setText(UIHelper.getString(R.string.Lark_IM_Poll_Detail_SelectAndVote_Button));
        r103.b().setEnabled(false);
        return;
    }
}
