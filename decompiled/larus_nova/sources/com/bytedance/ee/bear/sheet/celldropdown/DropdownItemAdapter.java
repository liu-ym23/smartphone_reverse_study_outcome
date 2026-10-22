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
import com.larus.nova.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class DropdownItemAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DropdownData.a[] f237447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f237448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f237449c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f237450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f237451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f237452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f237453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ DropdownItemAdapter f237454e;

        public class a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f237455c;

            public a(b r100) {
                this.f237455c = r100;
            }

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                Object r101 = r100.getTag();
                if ((r101 instanceof DropdownData.a) == false) goto L11;
                DropdownItemAdapter r102 = this.f237455c.f237454e;
                if (r102.f237448b == null) goto L12;
                DropdownData.a r103 = (DropdownData.a) r101;
                DropdownData.a[] r104 = r102.f237447a;
                if (r104 == null) goto L9;
                r103.f237446c = !r103.f237446c;
                r102.notifyItemChanged(Arrays.asList(r104).indexOf(r101));
            L9:
                a r105 = this.f237455c.f237454e.f237448b;
                ((pm5.a) r105).f529838a.selectOption(r103.f237445b);
                return;
            L12:
                return;
            }
        }

        public b(DropdownItemAdapter r100, View r101) {
            this.f237454e = r100;
            super(r101);
            this.f237450a = r101;
            this.f237451b = (TextView) r101.findViewById(R.id.tv_spinner_item);
            this.f237452c = (ImageView) r101.findViewById(R.id.iv_selected_item);
            this.f237453d = r101.findViewById(R.id.view_divider);
            r101.setOnClickListener(new a(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        DropdownData.a[] r100 = this.f237447a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return 1;
    L12:
        return r100.length;
    L5:
        if (r100.length == 0) goto L8;
        r101 = false;
        goto L9
    }

    public DropdownItemAdapter() {
        this.f237449c = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        DropdownData.a[] r101 = this.f237447a;
        if (r101 != null) goto L5;
    L8:
        int r102 = 1;
    L10:
        return r102 ^ 1;
    L5:
        if (r101.length == 0) goto L8;
        r102 = 0;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        boolean r103 = true;
        if (getItemViewType(r101) != 1) goto L27;
        DropdownData.a r104 = this.f237447a[r101];
        r102.f237451b.setText(r104.f237445b);
        if ((!TextUtils.isEmpty(r104.f237444a)) == false) goto L7;
        r102.f237451b.setBackground(r102.f237450a.getContext().getDrawable(R.drawable.sheet_cell_dropdown_item_text_bg));
        r102.f237451b.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r104.f237444a)));
    L8:
        String r105 = this.f237449c;
        if (r105 != null) goto L11;
        TextView r106 = r102.f237451b;
        r106.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(r106.getContext(), R.color.text_title)));
    L12:
        ImageView r107 = r102.f237452c;
        int r108 = 0;
        if (r104.f237446c == false) goto L15;
        int r109 = 0;
    L16:
        r107.setVisibility(r109);
        r102.f237450a.setTag(r104);
        if (r101 == (this.f237447a.length - 1)) goto L20;
        r103 = false;
    L20:
        ViewGroup.LayoutParams r110 = r102.itemView.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r103 == false) goto L25;
        r108 = n.l(r102.itemView.getContext(), R.dimen.space_kit_len_32);
    L25:
        r111.bottomMargin = r108;
        r102.itemView.setLayoutParams(r110);
        return;
    L28:
        return;
    L15:
        r109 = 8;
        goto L16
    L11:
        r102.f237451b.setTextColor(ColorUtils.h(r105));
        goto L12
    L7:
        r102.f237451b.setBackground(null);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 0) goto L5;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_cell_dropdown_empty, r100, false);
    L7:
        return new b(this, r102);
    L5:
        r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_cell_dropdown_item, r100, false);
        goto L7
    }
}
