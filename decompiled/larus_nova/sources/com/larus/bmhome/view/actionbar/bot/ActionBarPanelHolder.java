package com.larus.bmhome.view.actionbar.bot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarPanelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/bot/ActionBarHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/bot/ActionBarHolderCallback;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "actionStar", "Landroid/widget/ImageView;", "getActionStar", "()Landroid/widget/ImageView;", "bindData", "", "templates", "Lcom/larus/im/bean/conversation/Templates;", "useSubscribedColor", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarPanelHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f315684d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f315685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f315686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f315687c;

    public ActionBarPanelHolder(View r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f315685a = r101;
        this.f315686b = (TextView) r100.findViewById(R.id.temp_title);
        this.f315687c = (ImageView) r100.findViewById(R.id.action_star);
    }
}
