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
import java.util.Locale;
import z05.g;
import z05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends RecyclerView.Adapter<C0071a> {
    public b a;
    public String b;
    public final Activity c;
    public final AsyncListDiffer<g> d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.panel.a$a, reason: collision with other inner class name */
    public static class C0071a extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final AppCompatImageView c;

        public C0071a(View r6) {
            super(r6);
            TextView r0 = (TextView) r6.findViewById(2131390554);
            this.a = r0;
            this.b = (TextView) r6.findViewById(2131390553);
            this.c = r6.findViewById(2131376205);
            ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r0.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) r7).width = (int) (((double) n.w(r0.getContext())) * 0.82d);
            r0.setLayoutParams(r7);
        }
    }

    public interface b {
    }

    public static class c extends DiffUtil.ItemCallback<g> {
        public c() {
        }

        public final boolean areContentsTheSame(Object r3, Object r4) {
            g r5 = (g) r3;
            g r6 = (g) r4;
            if (TextUtils.equals(r5.a, r6.a) == true) goto L5;
        L19:
            return false;
        L5:
            if (TextUtils.equals(r5.f, r6.f) == false) goto L19;
            if (TextUtils.equals(r5.g, r6.g) == false) goto L19;
            if (TextUtils.equals(r5.e, r6.e) == false) goto L19;
            if (TextUtils.equals(r5.b, r6.b) == false) goto L19;
            if (TextUtils.equals(r5.c, r6.c) == false) goto L19;
            if (r5.h.equals(r6.h) == false) goto L19;
            if (r5.i.equals(r6.i) == false) goto L19;
            return true;
        }

        public final boolean areItemsTheSame(Object r3, Object r4) {
            g r5 = (g) r3;
            g r6 = (g) r4;
            if (TextUtils.equals(r5.a, r6.a) == true) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.equals(r5.f, r6.f) == false) goto L7;
            return true;
        }
    }

    public final int getItemCount() {
        return this.d.getCurrentList().size();
    }

    public a(FragmentActivity r3) {
        this.b = "";
        this.d = new AsyncListDiffer(this, new c());
        this.c = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, final int r8) {
        C0071a r9 = (C0071a) r7;
        final g r0 = (g) ListProtector.get(this.d.getCurrentList(), r8);
        r9.a.setText(r0.b);
        Long r1 = r0.h;
        Locale r2 = ((RecyclerView.ViewHolder) r9).itemView.getResources().getConfiguration().locale;
        String r3 = r0.e;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        String r4 = r0.c;
        String r5 = r0.d;
        r3 = ou5.a.b(((i0) org.koin.java.a.a(i0.class)).a(), r4, r5);
    L5:
        String r6 = i.a(this.c, r3, r1, r2);
        r9.b.setText(r6);
        if (this.b.equals(r0.f) == false) goto L8;
        r9.c.setVisibility(0);
        l.c(r9.c, 2131106614);
    L9:
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new d15.a(this, r8, r0));
        return;
    L8:
        r9.c.setVisibility(8);
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new C0071a(LayoutInflater.from(r2.getContext()).inflate(2131560130, null));
    }
}
