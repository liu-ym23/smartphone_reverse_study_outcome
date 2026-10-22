package com.ss.android.lark.vote.message.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BottomTipBinder implements a<Object, BottomTipViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f445214a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/vote/message/detail/BottomTipBinder$BottomTipViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomTipViewHolder extends RecyclerView.ViewHolder {
        public BottomTipViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public BottomTipBinder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f445214a = r100;
    }

    @Override // com.ss.android.lark.vote.message.detail.a
    public final RecyclerView.ViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new BottomTipViewHolder(LayoutInflater.from(this.f445214a).inflate(R.layout.lark_vote_detail_pople_limited, r100, false));
    }
}
