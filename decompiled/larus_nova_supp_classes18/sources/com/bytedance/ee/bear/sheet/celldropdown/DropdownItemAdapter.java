package com.bytedance.ee.bear.sheet.celldropdown;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DropdownItemAdapter extends RecyclerView.Adapter<b> {
    public DropdownData.a[] a;
    public a b;
    public String c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final ImageView c;
        public final View d;
        public final /* synthetic */ DropdownItemAdapter e;

        public class a extends t {
            public final /* synthetic */ b c;

            public a(b r1) {
                this.c = r1;
            }

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r5) {
                Object r6 = r5.getTag();
                if ((r6 instanceof DropdownData.a) == false) goto L11;
                DropdownItemAdapter r0 = this.c.e;
                if (r0.b == null) goto L12;
                DropdownData.a r1 = (DropdownData.a) r6;
                DropdownData.a[] r2 = r0.a;
                if (r2 == null) goto L9;
                r1.c = !r1.c;
                r0.notifyItemChanged(Arrays.asList(r2).indexOf(r6));
            L9:
                a r7 = this.c.e.b;
                ((pm5.a) r7).a.selectOption(r1.b);
                return;
            L12:
                return;
            }
        }

        public b(DropdownItemAdapter r1, View r2) {
            this.e = r1;
            super(r2);
            this.a = r2;
            this.b = (TextView) r2.findViewById(2131391497);
            this.c = (ImageView) r2.findViewById(2131376596);
            this.d = r2.findViewById(2131392500);
            r2.setOnClickListener(new a(this));
        }
    }

    public final int getItemCount() {
        DropdownData.a[] r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return 1;
    L12:
        return r0.length;
    L5:
        if (r0.length == 0) goto L8;
        r2 = false;
        goto L9
    }

    public DropdownItemAdapter() {
        this.c = null;
    }

    public final int getItemViewType(int r2) {
        DropdownData.a[] r3 = this.a;
        if (r3 != null) goto L5;
    L8:
        int r4 = 1;
    L10:
        return r4 ^ 1;
    L5:
        if (r3.length == 0) goto L8;
        r4 = 0;
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        b r8 = (b) r6;
        boolean r1 = true;
        if (getItemViewType(r7) != 1) goto L27;
        DropdownData.a r0 = this.a[r7];
        r8.b.setText(r0.b);
        if ((!TextUtils.isEmpty(r0.a)) == false) goto L7;
        r8.b.setBackground(r8.a.getContext().getDrawable(2131247773));
        r8.b.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r0.a)));
    L8:
        String r2 = this.c;
        if (r2 != null) goto L11;
        TextView r3 = r8.b;
        r3.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(r3.getContext(), 2131106622)));
    L12:
        ImageView r4 = r8.c;
        int r5 = 0;
        if (r0.c == false) goto L15;
        int r9 = 0;
    L16:
        r4.setVisibility(r9);
        r8.a.setTag(r0);
        if (r7 == (this.a.length - 1)) goto L20;
        r1 = false;
    L20:
        ViewGroup.LayoutParams r10 = ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r1 == false) goto L25;
        r5 = n.l(((RecyclerView.ViewHolder) r8).itemView.getContext(), 2131168335);
    L25:
        r11.bottomMargin = r5;
        ((RecyclerView.ViewHolder) r8).itemView.setLayoutParams(r10);
        return;
    L28:
        return;
    L15:
        r9 = 8;
        goto L16
    L11:
        r8.b.setTextColor(ColorUtils.h(r2));
        goto L12
    L7:
        r8.b.setBackground(null);
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 0) goto L5;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564531, r3, false);
    L7:
        return new b(this, r5);
    L5:
        r5 = LayoutInflater.from(r3.getContext()).inflate(2131564533, r3, false);
        goto L7
    }
}
