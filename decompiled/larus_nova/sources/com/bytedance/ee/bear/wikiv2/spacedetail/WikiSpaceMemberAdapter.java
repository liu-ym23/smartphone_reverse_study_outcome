package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class WikiSpaceMemberAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SpaceBean.MembersBean> f241317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f241318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f241319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f241320d;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDAvatar f241321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f241322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f241323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f241324d;

        public b(View r100) {
            super(r100);
            this.f241321a = (UDAvatar) r100.findViewById(R.id.iv_member_avatar);
            this.f241322b = (TextView) r100.findViewById(R.id.tv_member_name);
            this.f241323c = (TextView) r100.findViewById(R.id.tv_member_department);
            this.f241324d = (TextView) r100.findViewById(R.id.tv_member_permission);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<SpaceBean.MembersBean> r100 = this.f241317a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public WikiSpaceMemberAdapter(Context r100) {
        this.f241318b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        if (this.f241317a != null) goto L6;
        tt5.a.d("WikiSpaceMemberAdapter", "mMembersBeanList is null");
        return;
    L6:
        if (this.f241319c == false) goto L8;
        tt5.a.h("WikiSpaceMemberAdapter", "mIsPlaceHolderMode is true");
        int r103 = this.f241318b.getResources().getColor(R.color.bg_body_overlay);
        r102.f241321a.setImageDrawable(new ColorDrawable(r103));
        r102.f241322b.setBackgroundColor(r103);
        r102.f241323c.setBackgroundColor(r103);
        r102.f241324d.setBackgroundColor(r103);
        return;
    L8:
        int r104 = this.f241318b.getResources().getColor(R.color.bg_body);
        r102.f241321a.setImageDrawable(new ColorDrawable(r104));
        r102.f241322b.setBackgroundColor(r104);
        r102.f241323c.setBackgroundColor(r104);
        r102.f241324d.setBackgroundColor(r104);
        SpaceBean.MembersBean r105 = (SpaceBean.MembersBean) ListProtector.get(this.f241317a, r101);
        r102.f241322b.setText(r105.getMember_name());
        if (r105.getDescription() != null) goto L11;
    L14:
        r102.f241323c.setVisibility(8);
    L16:
        if (r105.getMember_role() != SpaceBean.MembersBean.MEMBER_ADMIN) goto L18;
        r102.f241324d.setText(this.f241318b.getResources().getString(R.string.Doc_Wiki_SpaceDetail_RoleAdmin));
    L20:
        if (TextUtils.isEmpty(r105.getIcon_url()) == true) goto L23;
        Glide.with(this.f241318b).load(new BearGlideUrl(r105.getIcon_url())).placeholder(R.drawable.facade_common_avatar_place_holder).error(R.drawable.facade_common_avatar_place_holder).listener(new l()).into(r102.f241321a);
    L33:
        if (r105.getMember_type() != 1) goto L35;
    L38:
        UDAvatar r106 = r102.f241321a;
        final String r107 = r105.getMember_id();
        r106.setOnClickListener(new k(this, r107));
        return;
    L35:
        if (r105.getMember_type() == 0) goto L38;
        r102.f241321a.setOnClickListener(null);
        return;
    L23:
        if (r105.getMember_type() != 18) goto L26;
        r102.f241321a.setImageResource(R.drawable.icon_collaborator_organization);
        goto L33
    L26:
        if (r105.getMember_type() != 22) goto L28;
    L31:
        r102.f241321a.setImageResource(R.drawable.icon_collaborator_usergroup);
        goto L33
    L28:
        if (r105.getMember_type() == 30) goto L31;
        tt5.a.d("WikiSpaceMemberAdapter", "membersBean getIcon_url is null");
        r102.f241321a.setImageResource(R.drawable.facade_common_avatar_place_holder);
        goto L33
    L18:
        r102.f241324d.setText(this.f241318b.getResources().getString(R.string.Doc_Wiki_SpaceDetail_RoleMember));
        goto L20
    L11:
        if (r105.getDescription().trim().isEmpty() == true) goto L14;
        r102.f241323c.setVisibility(0);
        r102.f241323c.setText(r105.getDescription());
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.wiki_space_detail_member_item, r100, false));
    }
}
