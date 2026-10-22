package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import uc5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DeleteSingleContainerUserAdapter extends RecyclerView.Adapter<b> {
    public Context a;
    public List<Document> b;
    public a c;
    public AccountService.Account d;
    public final boolean e;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final AppCompatImageView e;
        public final TextView f;

        public b(View r2) {
            super(r2);
            this.a = r2.findViewById(2131375759);
            this.b = (TextView) r2.findViewById(2131375760);
            this.c = (TextView) r2.findViewById(2131375882);
            this.d = (TextView) r2.findViewById(2131375883);
            this.e = r2.findViewById(2131375761);
            this.f = (TextView) r2.findViewById(2131375810);
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public DeleteSingleContainerUserAdapter() {
        this.b = new ArrayList();
        this.e = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, final int r13) {
        b r14 = (b) r12;
        final Document r3 = (Document) ListProtector.get(this.b, r13);
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new j(this, r13, r3));
        if (r3.p1 == false) goto L13;
        String r15 = t0.g(this.a, r3);
        if (TextUtils.isEmpty(r3.r) == false) goto L7;
        String r8 = "";
    L8:
        AppCompatImageView r6 = r14.a;
        AccountService.Account r1 = this.d;
        if (r1 == null) goto L11;
        String r4 = r1.token;
    L12:
        new fd5.e(new g0(this.a, r3, r4, false, r6), this.e).a(null);
        r14.b.setText(r15);
        r14.c.setText(r8);
        r14.a.setVisibility(0);
        r14.b.setVisibility(0);
        r14.c.setVisibility(0);
        r14.d.setVisibility(0);
        r14.e.setVisibility(8);
        r14.f.setVisibility(8);
        return;
    L11:
        r4 = "";
        goto L12
    L7:
        r8 = r3.r;
        goto L8
    L13:
        r14.a.setVisibility(8);
        r14.b.setVisibility(8);
        r14.c.setVisibility(8);
        r14.d.setVisibility(8);
        r14.e.setVisibility(0);
        r14.f.setVisibility(0);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        this.a = r4.getContext();
        return new b(LayoutInflater.from(this.a).inflate(2131563518, r4, false));
    }
}
