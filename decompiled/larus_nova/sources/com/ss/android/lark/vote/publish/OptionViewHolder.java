package com.ss.android.lark.vote.publish;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/vote/publish/OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "et", "Landroid/widget/EditText;", "getEt", "()Landroid/widget/EditText;", "setEt", "(Landroid/widget/EditText;)V", "ivDelete", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvDelete", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIvDelete", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f445259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f445260b;

    public OptionViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f445259a = (EditText) r100.findViewById(R.id.et_vote_option);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.vote_decrease);
        this.f445260b = r101;
        r101.setEnabled(false);
    }
}
