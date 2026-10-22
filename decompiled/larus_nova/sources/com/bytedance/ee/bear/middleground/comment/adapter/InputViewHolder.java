package com.bytedance.ee.bear.middleground.comment.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/InputViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inputTv", "kotlin.jvm.PlatformType", "getInputTv", "()Landroid/view/View;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f230263a;

    public InputViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f230263a = r100.findViewById(R.id.whole_input_tv);
    }
}
