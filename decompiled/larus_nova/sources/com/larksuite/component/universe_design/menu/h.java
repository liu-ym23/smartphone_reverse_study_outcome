package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.menu.databinding.UdItemMenuBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285139a = 0;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f285140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<g> f285141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f285142c;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f285141b.size();
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f285140a = r100;
            this.f285141b = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            if (r101 >= getItemCount()) goto L24;
            g r103 = (g) ListProtector.get(this.f285141b, r101);
            int r104 = r103.getIcon();
            if (r104 != 0) goto L8;
            r102.f285143a.f285133c.setImageDrawable(null);
        L9:
            int r105 = r103.c();
            if (r105 == 0) goto L12;
            ColorStateList r106 = UDColorUtils.getColorStateList(this.f285140a, r105);
            r102.f285143a.f285133c.setImageTintList(r106);
        L12:
            int r107 = r103.b();
            if (r107 == 0) goto L16;
            r102.f285143a.f285133c.setImageTintList(ColorStateList.valueOf(r107));
        L16:
            if (this.f285142c == false) goto L18;
            r102.f285143a.f285134d.setMaxLines(1);
            r102.f285143a.f285132b.setMaxLines(2);
        L19:
            r102.f285143a.f285134d.setText(r103.getName());
            int r108 = r103.getTextColor();
            if (r108 == 0) goto L22;
            r102.f285143a.f285134d.setTextColor(r108);
        L22:
            r103.getDescription();
            r102.f285143a.f285132b.setVisibility(8);
            r102.itemView.setOnClickListener(new i(r103, r101));
            r102.itemView.setEnabled(r103.isEnabled());
            return;
        L18:
            r102.f285143a.f285134d.setMaxLines(Integer.MAX_VALUE);
            r102.f285143a.f285132b.setMaxLines(Integer.MAX_VALUE);
            goto L19
        L8:
            r102.f285143a.f285133c.setImageResource(r104);
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(this.f285140a).inflate(R.layout.ud_item_menu, r100, false);
            int r103 = R.id.menu_description;
            TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.menu_description);
            if (r104 == null) goto L11;
            r103 = R.id.menu_icon;
            ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.menu_icon);
            if (r105 == null) goto L11;
            r103 = R.id.menu_name;
            TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.menu_name);
            if (r106 == null) goto L11;
            return new c(new UdItemMenuBinding((ConstraintLayout) r102, r104, r105, r106));
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UdItemMenuBinding f285143a;

        public c(UdItemMenuBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "viewBinding");
            super(r100.f285131a);
            this.f285143a = r100;
        }
    }

    static {
    }
}
