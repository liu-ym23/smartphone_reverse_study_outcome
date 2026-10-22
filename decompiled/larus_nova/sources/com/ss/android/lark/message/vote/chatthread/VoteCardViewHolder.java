package com.ss.android.lark.message.vote.chatthread;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ss.ttvideoengine.DataLoaderHelper;

/* JADX INFO: loaded from: classes36.dex */
public class VoteCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(DataLoaderHelper.DATALOADER_KEY_ENABLE_NOTIFY_ERROR)
    TextView mActionBtn;

    @BindView(9034)
    TextView mActualParticipantNumberTv;

    @BindView(9896)
    TextView mNumberOfParticipantsTv;

    @BindView(9915)
    RecyclerView mOptionsRv;

    @BindView(10168)
    TextView mSelectTypeTv;

    @BindView(10338)
    View mTitleLayout;

    @BindView(10342)
    TextView mTitleTv;
}
