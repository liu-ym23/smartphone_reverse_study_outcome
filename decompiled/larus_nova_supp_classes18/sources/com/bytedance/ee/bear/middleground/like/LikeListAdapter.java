package com.bytedance.ee.bear.middleground.like;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.RoundImageView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.widgets.tagview.TagValue;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikeListAdapter extends RecyclerView.Adapter<a> {
    public b a;
    public final LayoutInflater b;
    public final Context c;
    public final String d;
    public hg5.c e;
    public final Locale f;

    public static class a extends RecyclerView.ViewHolder {
        public final RoundImageView a;
        public final SpaceTagTitleView b;
        public final TextView c;

        public a(View r2) {
            super(r2);
            this.a = r2.findViewById(2131377876);
            this.b = (SpaceTagTitleView) r2.findViewById(2131377877);
            this.c = (TextView) r2.findViewById(2131377878);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a.a).size();
    }

    public LikeListAdapter(Context r2) {
        this.a = new b();
        this.c = r2;
        this.b = LayoutInflater.from(r2);
        int r3 = p.a;
        this.d = ((i0) org.koin.java.a.a(i0.class)).a();
        this.f = ((i0) org.koin.java.a.a(i0.class)).c();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        a r11 = (a) r9;
        final b.a r12 = (b.a) ListProtector.get(this.a.a, r10);
        if (com.bytedance.ee.util.ui.b.b(this.c) == false) goto L5;
        Glide.with(this.c).load(new BearGlideUrl(r12.d)).placeholder(2131235295).into(r11.a);
    L5:
        r11.a.setOnClickListener(new j(this, r12));
        String r0 = ou5.a.a(this.d, r12.g, r12.e, r12.f);
        r11.b.setTitle(r0);
        LikeListPuller.b r1 = r12.h;
        if (r1 == null) goto L10;
        TagValue r2 = r1.a;
        if (r2 == null) goto L10;
        String r3 = r2.getI18TagValue(this.f);
    L11:
        SpaceTagTitleView r4 = r11.b;
        SpaceTagType[] r5 = new SpaceTagType[1];
        int r6 = p.a;
        String r7 = r12.c;
        AccountService.Account r8 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r8 != null) goto L14;
    L18:
        boolean r13 = false;
    L19:
        r5[0] = SpaceTagType.b(r3, r13, true);
        r4.setLabels(r5);
        r11.c.setText(zu5.a.b(this.c, r12.i * 1000));
        return;
    L14:
        if (TextUtils.equals(r7, r8.tenantId) == true) goto L18;
        if (r8.isConsumer() == true) goto L18;
        r13 = true;
    L10:
        r3 = null;
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new a(this.b.inflate(2131563466, r3, false));
    }
}
