package com.bytedance.ee.bear.document.editionmanager.panel;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.Locale;
import z05.g;
import z05.i;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends RecyclerView.Adapter<C3127a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f219671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f219672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f219673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncListDiffer<g> f219674d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.panel.a$a, reason: collision with other inner class name */
    public static class C3127a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f219675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f219676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f219677c;

        public C3127a(View r100) {
            super(r100);
            TextView r101 = (TextView) r100.findViewById(R.id.tv_edition_name);
            this.f219675a = r101;
            this.f219676b = (TextView) r100.findViewById(R.id.tv_edition_description);
            this.f219677c = (AppCompatImageView) r100.findViewById(R.id.iv_edition_selected);
            ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) r102).width = (int) (((double) n.w(r101.getContext())) * 0.82d);
            r101.setLayoutParams(r102);
        }
    }

    public interface b {
    }

    public static class c extends DiffUtil.ItemCallback<g> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(g r100, g r101) {
            g r102 = r100;
            g r103 = r101;
            if (TextUtils.equals(r102.f569617a, r103.f569617a) == true) goto L5;
        L19:
            return false;
        L5:
            if (TextUtils.equals(r102.f569622f, r103.f569622f) == false) goto L19;
            if (TextUtils.equals(r102.f569623g, r103.f569623g) == false) goto L19;
            if (TextUtils.equals(r102.f569621e, r103.f569621e) == false) goto L19;
            if (TextUtils.equals(r102.f569618b, r103.f569618b) == false) goto L19;
            if (TextUtils.equals(r102.f569619c, r103.f569619c) == false) goto L19;
            if (r102.f569624h.equals(r103.f569624h) == false) goto L19;
            if (r102.f569625i.equals(r103.f569625i) == false) goto L19;
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(g r100, g r101) {
            g r102 = r100;
            g r103 = r101;
            if (TextUtils.equals(r102.f569617a, r103.f569617a) == true) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.equals(r102.f569622f, r103.f569622f) == false) goto L7;
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f219674d.getCurrentList().size();
    }

    public a(FragmentActivity r100) {
        this.f219672b = "";
        this.f219674d = new AsyncListDiffer(this, new c());
        this.f219673c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        C3127a r102 = (C3127a) r100;
        final g r103 = (g) ListProtector.get(this.f219674d.getCurrentList(), r101);
        r102.f219675a.setText(r103.f569618b);
        Long r104 = r103.f569624h;
        Locale r105 = r102.itemView.getResources().getConfiguration().locale;
        String r106 = r103.f569621e;
        if (TextUtils.isEmpty(r106) == false) goto L5;
        String r107 = r103.f569619c;
        String r108 = r103.f569620d;
        r106 = ou5.a.b(((i0) org.koin.java.a.a(i0.class)).a(), r107, r108);
    L5:
        String r109 = i.a(this.f219673c, r106, r104, r105);
        r102.f219676b.setText(r109);
        if (this.f219672b.equals(r103.f569622f) == false) goto L8;
        r102.f219677c.setVisibility(0);
        l.c(r102.f219677c, R.color.text_link_hover);
    L9:
        r102.itemView.setOnClickListener(new d15.a(this, r101, r103));
        return;
    L8:
        r102.f219677c.setVisibility(8);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new C3127a(LayoutInflater.from(r100.getContext()).inflate(R.layout.docx_edition_item, null));
    }
}
