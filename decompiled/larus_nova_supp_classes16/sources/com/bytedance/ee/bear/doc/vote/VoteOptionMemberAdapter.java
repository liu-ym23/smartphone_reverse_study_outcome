package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.CustomTitleView;
import com.bytedance.ee.bear.facade.common.widget.RoundImageView;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VoteOptionMemberAdapter extends RecyclerView.Adapter<b> {
    public e a;
    public final LayoutInflater b;
    public final Context c;
    public a d;

    public interface a {
        void a(String r1);
    }

    public static class b extends RecyclerView.ViewHolder {
        public final RoundImageView a;
        public final CustomTitleView b;
        public final TextView c;

        public b(View r2) {
            super(r2);
            this.a = (RoundImageView) r2.findViewById(2131392800);
            this.b = (CustomTitleView) r2.findViewById(2131392801);
            this.c = (TextView) r2.findViewById(2131392814);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a.a).size();
    }

    public VoteOptionMemberAdapter(Context r2) {
        this.a = new e();
        this.c = r2;
        this.b = LayoutInflater.from(r2);
        ((i0) org.koin.java.a.a(i0.class)).a();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        b r8 = (b) r6;
        final VoteOptionMembersFetcher.a r9 = (VoteOptionMembersFetcher.a) ListProtector.get(this.a.a, r7);
        if (com.bytedance.ee.util.ui.b.b(this.c) == false) goto L5;
        Glide.with(this.c).load(new BearGlideUrl(r9.b)).placeholder(2131235295).into(r8.a);
    L5:
        r8.a.setOnClickListener(new d(this, r9));
        r8.b.setTitle(r9.c);
        r8.c.setText(zu5.a.b(this.c, r9.d * 1000));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new b(this.b.inflate(2131561716, r3, false));
    }
}
