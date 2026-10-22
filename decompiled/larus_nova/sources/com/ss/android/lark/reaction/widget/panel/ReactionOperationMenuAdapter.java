package com.ss.android.lark.reaction.widget.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionOperationMenuAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f439443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f439444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f439445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f439446d;

    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f439447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f439448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f439449c;

        public a(View r100) {
            super(r100);
            this.f439449c = (ImageView) r100.findViewById(R.id.image_red_dot);
            this.f439448b = (ImageView) r100.findViewById(R.id.image_icon);
            this.f439447a = (TextView) r100.findViewById(R.id.text_icon_name);
        }
    }

    public interface b {
    }

    public interface c {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f439446d.size();
    }

    public ReactionOperationMenuAdapter(Context r100, List<e> r101) {
        this.f439443a = null;
        this.f439444b = null;
        this.f439445c = r100;
        this.f439446d = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        e r103 = (e) ListProtector.get(this.f439446d, r101);
        final boolean r104 = r103.f439499e;
        e.b r105 = r103.f439500f;
        if (r105 != null) goto L5;
    L7:
        r102.f439447a.setText(r103.f439495a);
        if (r104 == false) goto L10;
        int r106 = v2c.a.b(this.f439445c, R.color.icon_n1);
    L11:
        int r107 = r103.f439497c;
        if (r107 == (-1)) goto L14;
        Drawable r108 = UDIconUtils.getIconDrawable(this.f439445c, r107, r106);
    L18:
        r102.f439449c.setVisibility(8);
        r102.f439448b.setImageDrawable(r108);
        r102.itemView.setTag(Integer.valueOf(r101));
        r102.f439447a.setMaxLines(2);
        r102.itemView.setOnClickListener(new s2c.a(this, r104));
        r102.f439447a.setEnabled(r104);
        r102.f439448b.setEnabled(r104);
        r102.f439449c.setEnabled(r104);
        e.b r109 = r103.f439500f;
        if (r109 == null) goto L22;
        r109.onViewCreated();
        r103.f439500f.onShow();
        return;
    L22:
        return;
    L14:
        Drawable r110 = r103.f439498d;
        if (r104 == false) goto L17;
        r110.mutate();
        r110.setTint(r106);
    L17:
        r108 = r110;
        goto L18
    L10:
        r106 = v2c.a.b(this.f439445c, R.color.icon_disable);
        goto L11
    L5:
        if (r105.a() == false) goto L7;
        r104 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new a(LayoutInflater.from(this.f439445c).inflate(R.layout.reaction_menu_item, r100, false));
    }
}
