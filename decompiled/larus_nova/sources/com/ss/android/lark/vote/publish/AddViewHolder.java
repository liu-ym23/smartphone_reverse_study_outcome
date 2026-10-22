package com.ss.android.lark.vote.publish;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/vote/publish/AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", CommonCmd.AIDL_PLATFORM_TYPE_TV, "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "setTv", "(Landroid/widget/TextView;)V", "ivAdd", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvAdd", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIvAdd", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f445257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f445258b;

    public AddViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f445257a = (TextView) r100.findViewById(R.id.add_view_text);
        this.f445258b = (AppCompatImageView) r100.findViewById(R.id.add_view);
        r100.setEnabled(false);
    }
}
