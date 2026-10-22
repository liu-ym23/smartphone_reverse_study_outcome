package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p0 extends SelectEditPanel {
    public static final /* synthetic */ int K = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public a f208158J;

    public class a extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SelectEditAdapter f208159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f208160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p0 f208161c;

        public int z2() {
            return R.layout.select_item_preview_layout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f208160b).size();
        }

        public c y2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            return new c(this.f208161c, r100, this.f208159a);
        }

        public a(p0 r100, SelectEditAdapter r101) {
            Intrinsics.checkNotNullParameter(r101, "adapter");
            this.f208161c = r100;
            this.f208159a = r101;
            this.f208160b = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            String r103 = (String) ListProtector.get(this.f208160b, r101);
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r104 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) ((HashMap) this.f208159a.f208063c).get(r103);
            r102.f208166d = r104;
            if (r104 == null) goto L6;
            r102.f208164b.setData(r104);
            r102.U3(r104);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(z2(), r100, false);
            Intrinsics.checkNotNull(r102);
            return y2(r102);
        }
    }

    public final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p0 f208162d;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.p0.a
        public final int z2() {
            return R.layout.select_item_preview_layout_v2;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.p0.a
        public final c y2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            return new d(this.f208162d, r100, this.f208159a);
        }

        public b(p0 r100, SelectEditAdapter r101) {
            Intrinsics.checkNotNullParameter(r101, "adapter");
            this.f208162d = r100;
            super(r100, r101);
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SelectEditAdapter f208163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SelectTextView f208164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f208165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a f208166d;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f208167a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p0 f208168b;

            public a(c r100, p0 r101) {
                this.f208167a = r100;
                this.f208168b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                c r101 = this.f208167a;
                com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r102 = r101.f208166d;
                if (r102 == null) goto L14;
                SelectEditAdapter r103 = r101.f208163a;
                String r104 = r102.f207141a;
                int r105 = 0;
                r103.A2(r104, false);
            L6:
                if (r105 >= ((ArrayList) r103.getCurrentList()).size()) goto L11;
                if (TextUtils.equals(((SelectEditAdapter.b) ListProtector.get(r103.getCurrentList(), r105)).f207141a, r104) == true) goto L12;
                r105 = r105 + 1;
            L12:
                if (r105 == (-1)) goto L14;
                r103.notifyItemChanged(r105);
                goto L14
            L11:
                r105 = -1;
            L14:
                p0 r106 = this.f208168b;
                int r107 = p0.K;
                r106.v("delete");
            }
        }

        public void T3() {
            this.f208164b.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(24), com.bytedance.ee.util.ui.n.d(2));
        }

        public void U3(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            String r101 = r100.f207145e;
            if (r101 == null) goto L6;
            this.f208165c.setImageTintList(ColorStateList.valueOf(ColorUtils.h(r101)));
            return;
        }

        public c(p0 r100, View r101, SelectEditAdapter r102) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            Intrinsics.checkNotNullParameter(r102, "selectEditAdapter");
            super(r101);
            this.f208163a = r102;
            SelectTextView r103 = (SelectTextView) r101.findViewById(R.id.option_item);
            this.f208164b = r103;
            this.f208165c = (AppCompatImageView) r101.findViewById(R.id.closeIcon);
            T3();
            r103.V1 = false;
            r101.setOnClickListener(new a(this, r100));
        }
    }

    public final class d extends c {
        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.p0.c
        public final void T3() {
            SelectTextView r100 = this.f208164b;
            if ((r100 instanceof SelectTagView) == false) goto L5;
            SelectTagView r101 = (SelectTagView) r100;
        L6:
            if (r101 == null) goto L8;
            r101.U(BaseTagSize.LARGE);
        L8:
            this.f208165c.setImageResource(R.drawable.ud_icon_close_bold_outlined);
            this.f208165c.setAlpha(1.0f);
            ViewGroup.LayoutParams r102 = this.f208165c.getLayoutParams();
            BaseTagSize r103 = BaseTagSize.LARGE;
            r102.width = com.bytedance.ee.util.ui.n.d(r103.getRightIconSizeDp());
            r102.height = com.bytedance.ee.util.ui.n.d(r103.getRightIconSizeDp());
            if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            int r104 = com.bytedance.ee.util.ui.n.d(r103.getRightIconPaddingDp());
            ((ViewGroup.MarginLayoutParams) r102).rightMargin = r104;
        L11:
            this.f208165c.setLayoutParams(r102);
            int r105 = (r103.getRightIconSizeDp() + r103.getRightIconGapDp()) + r103.getRightIconPaddingDp();
            this.f208164b.setPadding(com.bytedance.ee.util.ui.n.d(r103.getTextPaddingHorizontalDp()), 0, com.bytedance.ee.util.ui.n.d(r105), 0);
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.p0.c
        public final void U3(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            SelectTextView r101 = this.f208164b;
            String r102 = null;
            if ((r101 instanceof SelectTagView) == false) goto L5;
            SelectTagView r103 = (SelectTagView) r101;
        L6:
            if (r103 == null) goto L8;
            r103.S(r100.f207146f);
        L8:
            String r104 = r100.f207147g;
            if (r104 != null) goto L11;
        L17:
            r102 = r100.f207145e;
        L18:
            if (r102 == null) goto L21;
            this.f208165c.setImageTintList(ColorStateList.valueOf(BaseTagSize.LARGE.closeIconTint(ColorUtils.h(r102))));
            return;
        L21:
            return;
        L11:
            if (r104.length() <= 0) goto L13;
            boolean r105 = true;
        L14:
            if (r105 == false) goto L16;
            r102 = r104;
        L16:
            if (r102 != null) goto L18;
        L13:
            r105 = false;
            goto L14
        L5:
            r103 = null;
            goto L6
        }

        public d(p0 r100, View r101, SelectEditAdapter r102) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            Intrinsics.checkNotNullParameter(r102, "selectEditAdapter");
            super(r100, r101, r102);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditPanel
    public final void E(int r100) {
    }

    public final void K() {
        a r100 = this.f208158J;
        if (r100 == null) goto L7;
        List<String> r101 = r100.f208160b;
        if (r101 == null) goto L7;
        ((ArrayList) r101).clear();
    L7:
        Iterator r102 = ((ArrayList) z().f208064d).iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        String r103 = (String) r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (((HashMap) z().f208063c).containsKey(r103) == false) goto L9;
        a r104 = this.f208158J;
        if (r104 == null) goto L9;
        List<String> r105 = r104.f208160b;
        if (r105 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        ((ArrayList) r105).add(r103);
        goto L9
    L19:
        a r106 = this.f208158J;
        if (r106 == null) goto L26;
        List<String> r107 = r106.f208160b;
        if (r107 == null) goto L26;
        boolean r108 = true;
        if ((!((ArrayList) r107).isEmpty()) != true) goto L26;
    L28:
        if (r108 == true) goto L30;
        this.G.f210685o.setVisibility(8);
        this.G.f210678h.setVisibility(8);
    L34:
        a r109 = this.f208158J;
        if (r109 == null) goto L49;
        r109.notifyDataSetChanged();
        return;
    L49:
        return;
    L30:
        this.G.f210685o.setVisibility(0);
        if (this.G.f210676f.getVisibility() != 0) goto L33;
        this.G.f210678h.setVisibility(8);
        goto L34
    L33:
        this.G.f210678h.setVisibility(0);
    L26:
        r108 = false;
        goto L28
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditPanel
    public final void C() {
        super.C();
        this.G.f210679i.setDividerVisible(false);
        com.bytedance.ee.bear.bitable.m.s(this.G.f210677g, com.bytedance.ee.util.ui.n.c(16.0f), false);
        com.bytedance.ee.bear.bitable.m.s(this.G.f210678h, com.bytedance.ee.util.ui.n.c(16.0f), false);
        RecyclerView r100 = this.G.f210685o;
        r100.setLayoutManager(new LinearLayoutManager(r100.getContext(), 0, false));
        if (this.I == false) goto L5;
        a r101 = new b(this, z());
    L6:
        this.f208158J = r101;
        r100.setAdapter(r101);
        return;
    L5:
        r101 = new a(this, z());
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditPanel
    public final void G(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r100, List<String> r101) {
        super.G(r100, r101);
        K();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditPanel
    public final void H(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r100, String r101) {
        super.H(r100, r101);
        K();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditPanel, com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
    public final void l(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "optionId");
        super.l(r100, r101);
        K();
    }

    public p0(Context r100, boolean r101, ColorBean[] r102, boolean r103, gp4.h r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103, r104);
    }
}
