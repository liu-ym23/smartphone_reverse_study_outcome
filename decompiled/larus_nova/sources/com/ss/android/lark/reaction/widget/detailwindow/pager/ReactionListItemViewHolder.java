package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.reaction.widget.detailwindow.userstatus.ReactionUserStatusLinearLayout;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionListItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f439250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIRoundedImageView f439251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f439252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReactionUserStatusLinearLayout f439253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f439254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f439255f;

    public ReactionListItemViewHolder(View r100) {
        super(r100);
        this.f439250a = (ViewGroup) r100.findViewById(R.id.people_item_layout);
        this.f439251b = (LKUIRoundedImageView) r100.findViewById(R.id.single_avator);
        ImageView r101 = (ImageView) r100.findViewById(R.id.image_unregister);
        this.f439252c = (TextView) r100.findViewById(R.id.text_name);
        this.f439253d = (ReactionUserStatusLinearLayout) r100.findViewById(R.id.user_status);
        this.f439254e = (TextView) r100.findViewById(R.id.workday_leave);
        this.f439255f = r100.findViewById(R.id.divider_next_people);
        DesktopUtil.a(r100.getContext());
    }
}
