package com.ss.android.lark.widget.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class GridMenuAdapter extends RecyclerView.Adapter<a> {

    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f446464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f446465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f446466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ GridMenuAdapter f446467d;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.menu.GridMenuAdapter$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC5402a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f446468a;

            public ViewOnClickListenerC5402a(a r100) {
                this.f446468a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f446468a.f446467d.getClass();
            }
        }

        public a(GridMenuAdapter r100, View r101) {
            this.f446467d = r100;
            super(r101);
            r101.setOnClickListener(new ViewOnClickListenerC5402a(this));
            this.f446465b = (ImageView) r101.findViewById(R.id.image_icon);
            this.f446464a = (TextView) r101.findViewById(R.id.text_icon_name);
            this.f446466c = (ImageView) r101.findViewById(R.id.badge_red_bot);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        b.a r103 = (b.a) ListProtector.get(null, r101);
        r102.f446464a.setText(r103.f446472a);
        r102.f446465b.setImageResource(-1);
        r102.f446466c.setVisibility(4);
        r102.itemView.setTag(Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new a(this, LayoutInflater.from(null).inflate(R.layout.global_dialog_icon_item, r100, false));
    }
}
