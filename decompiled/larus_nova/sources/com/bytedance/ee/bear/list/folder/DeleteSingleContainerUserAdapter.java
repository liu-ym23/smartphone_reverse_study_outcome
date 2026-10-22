package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import uc5.j;

/* JADX INFO: loaded from: classes18.dex */
public class DeleteSingleContainerUserAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f227932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Document> f227933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f227934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AccountService$Account f227935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f227936e;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f227937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f227938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f227939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f227940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppCompatImageView f227941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f227942f;

        public b(View r100) {
            super(r100);
            this.f227937a = (AppCompatImageView) r100.findViewById(R.id.item_file_icon);
            this.f227938b = (TextView) r100.findViewById(R.id.item_file_name);
            this.f227939c = (TextView) r100.findViewById(R.id.item_user_name);
            this.f227940d = (TextView) r100.findViewById(R.id.item_user_name_title);
            this.f227941e = (AppCompatImageView) r100.findViewById(R.id.item_file_no_permission_icon);
            this.f227942f = (TextView) r100.findViewById(R.id.item_no_permission_file_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f227933b.size();
    }

    public DeleteSingleContainerUserAdapter() {
        this.f227933b = new ArrayList();
        this.f227936e = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r111) {
        b r112 = (b) r110;
        final Document r100 = (Document) ListProtector.get(this.f227933b, r111);
        r112.itemView.setOnClickListener(new j(this, r111, r100));
        if (r100.f227893p1 == false) goto L13;
        String r113 = t0.g(this.f227932a, r100);
        if (TextUtils.isEmpty(r100.f227896r) == false) goto L7;
        String r101 = "";
    L8:
        AppCompatImageView r102 = r112.f227937a;
        AccountService$Account r103 = this.f227935d;
        if (r103 == null) goto L11;
        String r104 = r103.token;
    L12:
        new fd5.e(new g0(this.f227932a, r100, r104, false, r102), this.f227936e).a(null);
        r112.f227938b.setText(r113);
        r112.f227939c.setText(r101);
        r112.f227937a.setVisibility(0);
        r112.f227938b.setVisibility(0);
        r112.f227939c.setVisibility(0);
        r112.f227940d.setVisibility(0);
        r112.f227941e.setVisibility(8);
        r112.f227942f.setVisibility(8);
        return;
    L11:
        r104 = "";
        goto L12
    L7:
        r101 = r100.f227896r;
        goto L8
    L13:
        r112.f227937a.setVisibility(8);
        r112.f227938b.setVisibility(8);
        r112.f227939c.setVisibility(8);
        r112.f227940d.setVisibility(8);
        r112.f227941e.setVisibility(0);
        r112.f227942f.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f227932a = r100.getContext();
        return new b(LayoutInflater.from(this.f227932a).inflate(R.layout.list_users_authority_item, r100, false));
    }
}
