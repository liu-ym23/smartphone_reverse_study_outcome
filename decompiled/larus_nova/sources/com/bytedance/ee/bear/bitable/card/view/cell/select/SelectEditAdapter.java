package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class SelectEditAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f208061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f208062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f208063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f208064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f208065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f208066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f208067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f208068h;

    public class OptionHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDCheckBox f208069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SelectTextView f208070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SelectTextViewV2 f208071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f208072d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f208073e;

        public void U3() {
            if (com.bytedance.ee.bear.bitable.c.A() == false) goto L5;
            this.f208071c = (SelectTextViewV2) this.itemView.findViewById(R.id.option_item);
            return;
        L5:
            SelectTextView r100 = (SelectTextView) this.itemView.findViewById(R.id.option_item);
            this.f208070b = r100;
            r100.V1 = false;
        }

        public OptionHolder(View r100) {
            super(r100);
            U3();
            this.f208073e = this.itemView.findViewById(R.id.divider);
            UDCheckBox r101 = (UDCheckBox) this.itemView.findViewById(R.id.check_box);
            this.f208069a = r101;
            r101.setClickable(false);
            this.f208072d = (AppCompatImageView) this.itemView.findViewById(R.id.more_operation_icon);
        }

        public void T3(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
            if (com.bytedance.ee.bear.bitable.c.A() == false) goto L8;
            this.f208071c.setData(r100);
            if (this.f208071c.getLineCount() < 2) goto L7;
            this.f208071c.y(com.bytedance.ee.util.ui.n.d(28));
            return;
        L7:
            this.f208071c.y(com.bytedance.ee.util.ui.n.d(12));
            return;
        L8:
            this.f208070b.setData(r100);
        }
    }

    public interface a {
        void e(b r100);

        void j(boolean r100);

        void k();

        void l(String r100, boolean r101);
    }

    public static class b extends com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a {
        public b(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r110) {
            super(r110.f207141a, r110.f207142b, r110.f207143c, r110.f207144d, r110.f207145e, r110.f207146f, r110.f207147g, r110.f207148h);
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public c(View r100) {
            super(r100);
            r100.setLayoutParams(new ViewGroup.LayoutParams(-1, r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_18)));
        }
    }

    public static class d implements a {
        public d() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
        public final void e(b r100) {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
        public void j(boolean r100) {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
        public final void k() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
        public void l(String r100, boolean r101) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public final List<b> getCurrentList() {
        if (TextUtils.isEmpty(this.f208068h) == false) goto L7;
        return this.f208061a;
    L7:
        return this.f208062b;
    }

    public SelectEditAdapter() {
        this.f208061a = new ArrayList();
        this.f208062b = new ArrayList();
        this.f208063c = new HashMap();
        this.f208064d = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) getCurrentList()).size() + 1;
    }

    public int z2() {
        if (com.bytedance.ee.bear.bitable.c.A() == false) goto L6;
        return R.layout.bitable_card_select_edit_option_item_v2;
    L6:
        return R.layout.bitable_card_select_edit_option_item;
    }

    public final void B2(String r100) {
        this.f208068h = r100;
        ((ArrayList) this.f208062b).clear();
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f208061a).size()) goto L17;
        b r102 = (b) ListProtector.get(this.f208061a, r101);
        String r103 = r102.f207142b;
        String r104 = this.f208068h;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        if (r103.toLowerCase().contains(r104.toLowerCase()) == false) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        ((ArrayList) this.f208062b).add(r102);
    L16:
        r101 = r101 + 1;
        goto L4
    L13:
        r105 = ru7.c.d(r103).toLowerCase().contains(r104.toLowerCase());
        goto L14
    L17:
        notifyDataSetChanged();
        a r106 = this.f208067g;
        if (r106 == null) goto L24;
        r106.j(CollectionUtils.isEmpty(this.f208062b));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != (getItemCount() - 1)) goto L6;
        return -1;
    L6:
        return super.getItemViewType(r100);
    }

    public OptionHolder y2(View r100) {
        return new OptionHolder(r100);
    }

    public final void A2(String r100, boolean r101) {
        if (r101 == true) goto L4;
        ((ArrayList) this.f208064d).remove(r100);
    L8:
        a r102 = this.f208067g;
        if (r102 == null) goto L12;
        r102.l(r100, r101);
        return;
    L12:
        return;
    L4:
        if (this.f208066f == false) goto L6;
        ((ArrayList) this.f208064d).add(r100);
        goto L8
    L6:
        ((ArrayList) this.f208064d).clear();
        ((ArrayList) this.f208064d).add(r100);
        notifyDataSetChanged();
        goto L8
    }

    public final void C2(List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r100, List<String> r101) {
        ((ArrayList) this.f208061a).clear();
        ((HashMap) this.f208063c).clear();
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        Iterator<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        b r103 = new b(r102.next());
        ((ArrayList) this.f208061a).add(r103);
        Map<String, b> r104 = this.f208063c;
        HashMap r105 = (HashMap) r104;
        r105.put(r103.f207141a, r103);
        goto L8
    L10:
        r100.size();
    L12:
        if (TextUtils.isEmpty(this.f208068h) == true) goto L14;
        B2(this.f208068h);
    L14:
        ((ArrayList) this.f208064d).clear();
        if (r101 != null) goto L17;
        return;
    L17:
        if (r101.isEmpty() == true) goto L22;
        ((ArrayList) this.f208064d).addAll(r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        if (r101 < getItemCount()) goto L6;
        return;
    L6:
        if ((r100 instanceof OptionHolder) == false) goto L25;
        final b r102 = (b) ListProtector.get(getCurrentList(), r101);
        final OptionHolder r103 = (OptionHolder) r100;
        if (this.f208066f == false) goto L11;
        UDCheckBox.CheckBoxType r104 = UDCheckBox.CheckBoxType.CHECK_BOX;
    L12:
        r103.f208069a.setType(r104);
        r103.itemView.setOnClickListener(new e0(this, r103, r102));
        if (this.f208065e == true) goto L15;
    L17:
        List<String> r105 = this.f208064d;
        ArrayList r106 = (ArrayList) r105;
        boolean r107 = r106.contains(r102.f207141a);
        boolean r108 = this.f208065e;
        AppCompatImageView r109 = r103.f208072d;
        if (r108 == false) goto L20;
        int r110 = 0;
    L21:
        r109.setVisibility(r110);
        ViewGroup.LayoutParams r111 = r103.itemView.getLayoutParams();
        r103.itemView.setVisibility(0);
        r111.height = -2;
        r111.width = -1;
        r103.itemView.setLayoutParams(r111);
        r103.f208069a.setChecked(r107);
        r103.T3(r102);
        final ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r103.f208073e.getLayoutParams();
        r103.f208069a.post(new g0(r103, r112));
        return;
    L20:
        r110 = 8;
        goto L21
    L15:
        if (this.f208067g == null) goto L17;
        r103.f208072d.setOnClickListener(new f0(this, r102));
        goto L17
    L11:
        r104 = UDCheckBox.CheckBoxType.RADIO;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != (-1)) goto L7;
        return new c(new View(r100.getContext()));
    L7:
        return y2(LayoutInflater.from(r100.getContext()).inflate(z2(), r100, false));
    }
}
