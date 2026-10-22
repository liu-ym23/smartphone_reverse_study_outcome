package com.larus.common.account.bdauth.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.account.bdauth.impl.databinding.LarusItemAuthHeaderBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter$HeaderViewHolder;", "<init>", "()V", "title", "", "subTitle", "update", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "HeaderViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BDAuthorizeHeaderAdapter extends RecyclerView.Adapter<HeaderViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f325964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f325965b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/account/bdauth/impl/databinding/LarusItemAuthHeaderBinding;", "<init>", "(Lcom/larus/account/bdauth/impl/databinding/LarusItemAuthHeaderBinding;)V", "bind", "", "title", "", "subTitle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusItemAuthHeaderBinding f325966a;

        public HeaderViewHolder(LarusItemAuthHeaderBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f286225a);
            this.f325966a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    public BDAuthorizeHeaderAdapter() {
        this.f325964a = "";
        this.f325965b = "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        HeaderViewHolder r102 = (HeaderViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = this.f325964a;
        String r104 = this.f325965b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "subTitle");
        r102.f325966a.f286227c.setText(r103);
        r102.f325966a.f286226b.setText(r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_auth_header, r100, false);
        int r103 = R.id.auth_account_logo;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.auth_account_logo)) == null) goto L11;
        r103 = R.id.auth_account_sub_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.auth_account_sub_title);
        if (r104 == null) goto L11;
        r103 = R.id.auth_account_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.auth_account_title);
        if (r105 == null) goto L11;
        return new HeaderViewHolder(new LarusItemAuthHeaderBinding((ConstraintLayout) r102, r104, r105));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public final void update(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        this.f325964a = r100;
        this.f325965b = r101;
        notifyItemChanged(0);
    }
}
