package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.userstatus.ReactionUserStatusLinearLayout;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<DetailUserInfo> f439235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f439236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f439237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f439238e;

    public interface a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f439235b.size() + (!TextUtils.isEmpty(this.f439238e) ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 < this.f439235b.size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    public ReactionListAdapter(Context r100, List<DetailUserInfo> r101) {
        this.f439238e = "";
        this.f439234a = r100;
        this.f439235b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        if ((r100 instanceof ReactionListItemViewHolder) == false) goto L23;
        if (this.f439237d != null) goto L7;
        this.f439237d = new c(this.f439234a, this.f439236c);
    L7:
        final c r101 = this.f439237d;
        ReactionListItemViewHolder r102 = (ReactionListItemViewHolder) r100;
        final DetailUserInfo r111 = (DetailUserInfo) ListProtector.get(this.f439235b, r110);
        r101.getClass();
        r102.f439252c.setText(r111.getUserName());
        if (TextUtils.isEmpty(r111.getAvatarUrl()) == true) goto L10;
        IRequestCreator r103 = r101.f439263d.load(r111.getAvatarUrl());
        int r104 = r101.f439262c;
        r103.override(r104, r104).into(r102.f439251b);
    L12:
        if (TextUtils.isEmpty(r111.getDescription()) == true) goto L14;
    L16:
        r102.f439253d.setVisibility(0);
        int r105 = ContextCompat.getColor(r101.f439260a, R.color.line_divider_default);
        Context r106 = r101.f439260a;
        r111.getDescType();
        Drawable r107 = UDIconUtils.getIconDrawable(r106, R.drawable.reaction_icon_status_divider, r105);
        ReactionUserStatusLinearLayout r108 = r102.f439253d;
        String r109 = r111.getDescription();
        r108.f439342a.setImageDrawable(r107);
        r108.f439343b.setText(r109);
    L18:
        if (TextUtils.isEmpty(r111.getWorkStatusDesc()) == false) goto L20;
        r102.f439254e.setVisibility(8);
    L21:
        r102.itemView.setOnClickListener(new b(r101, r111));
        goto L23
    L20:
        r102.f439254e.setVisibility(0);
        r102.f439254e.setText(r111.getWorkStatusDesc());
        goto L21
    L14:
        if (r111.getDescType() != DetailUserInfo.DescriptionType.DEFAULT) goto L16;
        r102.f439253d.setVisibility(8);
        goto L18
    L10:
        String r112 = r111.getAvatarKey();
        String r113 = r111.getUserId();
        int r114 = r101.f439262c;
        AvatarImage r115 = AvatarImage.Builder.obtain(r112, r113, r114, r114).build();
        IRequestCreator r116 = r101.f439263d.load(r115);
        int r117 = r101.f439262c;
        r116.override(r117, r117).into(r102.f439251b);
    L23:
        if ((r100 instanceof ReactionTipListItemViewHolder) == false) goto L26;
        String r118 = this.f439238e;
        ((ReactionTipListItemViewHolder) r100).f439256a.setText(r118);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        LayoutInflater r102 = LayoutInflater.from(this.f439234a);
        if (r101 != 1) goto L6;
        return new ReactionListItemViewHolder(r102.inflate(R.layout.reaction_detail_people_list_item, r100, false));
    L6:
        return new ReactionTipListItemViewHolder(r102.inflate(R.layout.reaction_detail_tip_list_item, r100, false));
    }
}
