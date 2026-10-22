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
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiSpaceMemberAdapter extends RecyclerView.Adapter<b> {
    public List<SpaceBean.MembersBean> a;
    public final Context b;
    public boolean c;
    public a d;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {
        public final UDAvatar a;
        public final TextView b;
        public final TextView c;
        public final TextView d;

        public b(View r2) {
            super(r2);
            this.a = r2.findViewById(2131376398);
            this.b = (TextView) r2.findViewById(2131390932);
            this.c = (TextView) r2.findViewById(2131390930);
            this.d = (TextView) r2.findViewById(2131390933);
        }
    }

    public final int getItemCount() {
        List<SpaceBean.MembersBean> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public WikiSpaceMemberAdapter(Context r1) {
        this.b = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        b r7 = (b) r5;
        if (this.a != null) goto L6;
        tt5.a.d("WikiSpaceMemberAdapter", "mMembersBeanList is null");
        return;
    L6:
        if (this.c == false) goto L8;
        tt5.a.h("WikiSpaceMemberAdapter", "mIsPlaceHolderMode is true");
        int r8 = this.b.getResources().getColor(2131100549);
        r7.a.setImageDrawable(new ColorDrawable(r8));
        r7.b.setBackgroundColor(r8);
        r7.c.setBackgroundColor(r8);
        r7.d.setBackgroundColor(r8);
        return;
    L8:
        int r0 = this.b.getResources().getColor(2131100548);
        r7.a.setImageDrawable(new ColorDrawable(r0));
        r7.b.setBackgroundColor(r0);
        r7.c.setBackgroundColor(r0);
        r7.d.setBackgroundColor(r0);
        SpaceBean.MembersBean r9 = (SpaceBean.MembersBean) ListProtector.get(this.a, r6);
        r7.b.setText(r9.getMember_name());
        if (r9.getDescription() != null) goto L11;
    L14:
        r7.c.setVisibility(8);
    L16:
        if (r9.getMember_role() != SpaceBean.MembersBean.MEMBER_ADMIN) goto L18;
        r7.d.setText(this.b.getResources().getString(2131888348));
    L20:
        if (TextUtils.isEmpty(r9.getIcon_url()) == true) goto L23;
        Glide.with(this.b).load(new BearGlideUrl(r9.getIcon_url())).placeholder(2131235295).error(2131235295).listener(new l()).into(r7.a);
    L33:
        if (r9.getMember_type() != 1) goto L35;
    L38:
        UDAvatar r10 = r7.a;
        final String r11 = r9.getMember_id();
        r10.setOnClickListener(new k(this, r11));
        return;
    L35:
        if (r9.getMember_type() == 0) goto L38;
        r7.a.setOnClickListener(null);
        return;
    L23:
        if (r9.getMember_type() != 18) goto L26;
        r7.a.setImageResource(2131237750);
        goto L33
    L26:
        if (r9.getMember_type() != 22) goto L28;
    L31:
        r7.a.setImageResource(2131237751);
        goto L33
    L28:
        if (r9.getMember_type() == 30) goto L31;
        tt5.a.d("WikiSpaceMemberAdapter", "membersBean getIcon_url is null");
        r7.a.setImageResource(2131235295);
        goto L33
    L18:
        r7.d.setText(this.b.getResources().getString(2131888349));
        goto L20
    L11:
        if (r9.getDescription().trim().isEmpty() == true) goto L14;
        r7.c.setVisibility(0);
        r7.c.setText(r9.getDescription());
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new b(LayoutInflater.from(r3.getContext()).inflate(2131568257, r3, false));
    }
}
