package com.larus.bmhome.view.actionbar.edit.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.bmhome.view.actionbar.edit.component.m1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/fragment/FeatureSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "initInputText", "", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;Ljava/lang/String;)V", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "subTitle", "Landroid/widget/TextView;", "tagContainer", "Lcom/larus/bmhome/chat/view/FlowLayout;", "getFlowLayout", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionFeatureOptionPanel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f316524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f316525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f316526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowLayout f316527d;

    public FeatureSelectorHolder(ConstraintLayout r100, m1 r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f316524a = r101;
        this.f316525b = r102;
        this.f316526c = (TextView) r100.findViewById(R.id.tv_feature_selector_sub_title);
        this.f316527d = (FlowLayout) r100.findViewById(R.id.tag_container);
    }
}
