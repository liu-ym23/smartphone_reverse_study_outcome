package com.bytedance.ee.bear.sheet.inputbar.formula;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bn5.i;
import bn5.j;
import bn5.k;
import bn5.m;
import bn5.n;
import bn5.o;
import bn5.p;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FormulaPickerFragment extends BaseFragment {
    public static final /* synthetic */ int t = 0;
    public FormulaCatalogData.Catalog e;
    public d f;
    public c g;
    public pcb.a h;
    public k i;
    public j j;
    public boolean k;
    public int l;
    public FormulaCatalogData.Category m;
    public String n;
    public TextView o;
    public EditText p;
    public RecyclerView q;
    public g r;
    public Parcelable s;

    public static class a extends RecyclerView.ViewHolder {
        public final TextView a;

        public a(LinearLayout r1, TextView r2) {
            super(r1);
            this.a = r2;
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        public final TextView a;

        public b(LinearLayout r1, TextView r2) {
            super(r1);
            this.a = r2;
        }
    }

    public interface c {
        void onDismiss();
    }

    public interface d {
        void Bo(String r1, boolean r2);
    }

    public interface e {
    }

    public interface f {
    }

    public final class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<h> a;
        public final f b;
        public final /* synthetic */ FormulaPickerFragment c;

        public final int getItemCount() {
            return this.a.size();
        }

        public final int getItemViewType(int r2) {
            return ((h) ListProtector.get(this.a, r2)).a;
        }

        public final LinearLayout y2(Context r12) {
            LinearLayout r0 = new LinearLayout(r12);
            r0.setOrientation(0);
            r0.setGravity(16);
            FormulaPickerFragment r3 = this.c;
            int r4 = FormulaPickerFragment.t;
            r0.setLayoutParams(new RecyclerView.LayoutParams(-1, r3.W90(56)));
            LayerDrawable r5 = new LayerDrawable(new Drawable[]{new ColorDrawable(ContextCompat.getColor(this.c.requireContext(), 2131103353)), new ColorDrawable(ContextCompat.getColor(this.c.requireContext(), 2131100548))});
            r5.setLayerInset(1, 0, 0, 0, 1);
            r0.setBackground(r5);
            r0.setPadding(this.c.W90(16), 0, this.c.W90(16), 0);
            return r0;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            final h r5 = (h) ListProtector.get(this.a, r4);
            if ((r3 instanceof a) == false) goto L12;
            FormulaCatalogData.Category r0 = r5.b;
            if (r0 == null) goto L12;
            a r6 = (a) r3;
            if (r0.getLabel() == null) goto L9;
            String r1 = r5.b.getLabel();
        L10:
            r6.a.setText(r1);
            ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new o(this, r5));
            return;
        L9:
            r1 = r5.b.getId();
        L12:
            if ((r3 instanceof b) == false) goto L18;
            FormulaCatalogData.Item r2 = r5.c;
            if (r2 == null) goto L19;
            b r7 = (b) r3;
            r7.a.setText(r2.getName());
            ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new p(this, r5));
            return;
        L19:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
            Context r8 = r6.getContext();
            if (r7 == 1) goto L6;
            LinearLayout r9 = y2(r8);
            TextView r0 = new TextView(r8);
            r0.setTextSize(2, 17.0f);
            r0.setTextColor(ContextCompat.getColor(this.c.requireContext(), 2131106622));
            r9.addView(r0);
            return new b(r9, r0);
        L6:
            LinearLayout r10 = y2(r8);
            TextView r1 = new TextView(r8);
            r1.setTextSize(2, 17.0f);
            r1.setTextColor(ContextCompat.getColor(this.c.requireContext(), 2131106622));
            r1.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            ImageView r2 = new ImageView(r8);
            r2.setImageResource(2131255566);
            r2.setColorFilter(ContextCompat.getColor(this.c.requireContext(), 2131106620));
            r2.setLayoutParams(new LinearLayout.LayoutParams(this.c.W90(20), this.c.W90(20)));
            r10.addView(r1);
            r10.addView(r2);
            return new a(r10, r1);
        }

        public g(FormulaPickerFragment r1, List r2, com.bytedance.ee.bear.sheet.inputbar.formula.b r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class h {
        public final int a;
        public final FormulaCatalogData.Category b;
        public final FormulaCatalogData.Item c;

        public h(int r1, FormulaCatalogData.Category r2, FormulaCatalogData.Item r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void ba0() {
        this.l = 1;
        String r0 = null;
        this.m = null;
        this.n = "";
        EditText r2 = this.p;
        if (r2 == null) goto L5;
        r2.setText("");
    L5:
        TextView r1 = this.o;
        if (r1 == null) goto L11;
        FormulaCatalogData.Catalog r3 = this.e;
        if (r3 == null) goto L10;
        r0 = r3.getTitle();
    L10:
        r1.setText(r0);
    L11:
        aa0();
    }

    public final void onDestroyView() {
        this.k = false;
        ca0();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final boolean S90() {
        if (this.l != 2) goto L6;
        Z90();
        return true;
    L6:
        return false;
    }

    public final void X90() {
        EditText r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        rcb.c.d(r0);
        this.p.clearFocus();
    }

    public final void aa0() {
        if (this.r != null) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        int r2 = this.l;
        if (r2 != 1) goto L35;
        if (TextUtils.isEmpty(this.n) == true) goto L24;
        ArrayList r3 = new ArrayList();
        if (this.e.getPopular() == null) goto L13;
        r3.addAll(this.e.getPopular());
    L13:
        if (this.e.getCategories() == null) goto L20;
        Iterator<FormulaCatalogData.Category> r4 = this.e.getCategories().iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        FormulaCatalogData.Category r5 = r4.next();
        if (r5.getFunctions() == null) goto L16;
        r3.addAll(r5.getFunctions());
    L20:
        Iterator<FormulaCatalogData.Item> r6 = Y90(r3).iterator();
    L22:
        if (r6.hasNext() == false) goto L42;
        U90(r0, r1, r6.next());
    L42:
        g r7 = this.r;
        r7.a = r0;
        r7.notifyDataSetChanged();
        return;
    L24:
        Iterator<FormulaCatalogData.Item> r8 = Y90(this.e.getPopular()).iterator();
    L26:
        if (r8.hasNext() == false) goto L29;
        U90(r0, r1, r8.next());
        goto L26
    L29:
        if (this.e.getCategories() == null) goto L42;
        Iterator<FormulaCatalogData.Category> r9 = this.e.getCategories().iterator();
    L32:
        if (r9.hasNext() == false) goto L42;
        r0.add(new h(1, r9.next(), null));
        goto L32
    L35:
        if (r2 != 2) goto L42;
        FormulaCatalogData.Category r10 = this.m;
        if (r10 == null) goto L42;
        Iterator<FormulaCatalogData.Item> r11 = Y90(r10.getFunctions()).iterator();
    L40:
        if (r11.hasNext() == false) goto L42;
        U90(r0, r1, r11.next());
        goto L40
    }

    public final void ca0() {
        pcb.a r0 = this.h;
        if (r0 == null) goto L7;
        k r1 = this.i;
        if (r1 == null) goto L7;
        r0.a(r1);
    L7:
        EditText r2 = this.p;
        if (r2 == null) goto L12;
        j r3 = this.j;
        if (r3 == null) goto L12;
        r2.removeCallbacks(r3);
    L12:
        this.i = null;
        this.h = null;
        this.j = null;
    }

    public FormulaPickerFragment() {
        this.l = 1;
        this.n = "";
    }

    public final void Z90() {
        X90();
        ba0();
        RecyclerView r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.s == null) goto L13;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L12;
        r1.onRestoreInstanceState(this.s);
        this.s = null;
        return;
    L12:
        return;
    }

    public final int W90(int r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final List<FormulaCatalogData.Item> Y90(List<FormulaCatalogData.Item> r6) {
        if (CollectionUtils.isEmpty(r6) == false) goto L7;
        return Collections.emptyList();
    L7:
        if (TextUtils.isEmpty(this.n) == false) goto L9;
        return r6;
    L9:
        final String r0 = this.n.toUpperCase(Locale.ROOT);
        ArrayList r1 = new ArrayList();
        Iterator<FormulaCatalogData.Item> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        FormulaCatalogData.Item r2 = r7.next();
        String r3 = r2.getName();
        if (r3 == null) goto L11;
        if (r3.toUpperCase(Locale.ROOT).contains(r0) == false) goto L11;
        r1.add(r2);
        goto L11
    L18:
        Collections.sort(r1, new bn5.f(r0));
        return r1;
    }

    public final void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        d r3 = getParentFragment();
        if ((r3 instanceof d) == false) goto L6;
        this.f = r3;
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        this.e = (FormulaCatalogData.Catalog) r3.getSerializable("arg_catalog");
        return;
    }

    public final void V90(pcb.a r2, e r3) {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.h != r2) goto L10;
        ca0();
        ((i) r3).a(true);
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        if (this.e != null) goto L6;
        tt5.a.k("FormulaPickerFragment", "onViewCreated catalog == null, dismiss");
        T90(0);
        return;
    L6:
        SheetDragView r8 = (SheetDragView) r6.findViewById(2131373218);
        String r1 = null;
        if (r8 != null) goto L10;
    L15:
        View r9 = r6.findViewById(2131388817);
        if (r9 == null) goto L21;
        this.o = (TextView) r9.findViewById(2131388772);
        ImageView r10 = (ImageView) r9.findViewById(2131363779);
        if (r10 == null) goto L21;
        r10.setOnClickListener(new bn5.d(this));
    L21:
        EditText r11 = (EditText) r6.findViewById(2131373222);
        this.p = r11;
        if (r11 == null) goto L28;
        FormulaCatalogData.Catalog r0 = this.e;
        if (r0 == null) goto L27;
        r1 = r0.getSearchPlaceholder();
    L27:
        r11.setHint(r1);
        this.p.setImeOptions(3);
        this.p.setOnEditorActionListener(new bn5.g(this));
        this.p.setOnFocusChangeListener(new bn5.h(this));
        this.p.addTextChangedListener(new m(this));
    L28:
        RecyclerView r12 = r6.findViewById(2131373219);
        this.q = r12;
        if (r12 == null) goto L35;
        r12.setLayoutManager(new LinearLayoutManager(getContext()));
        g r13 = new g(this, new ArrayList(), new com.bytedance.ee.bear.sheet.inputbar.formula.b(this));
        this.r = r13;
        this.q.setAdapter(r13);
        RecyclerView r14 = this.q;
        if (r14 == null) goto L35;
        r14.addOnScrollListener(new n(this));
    L35:
        ba0();
        return;
    L10:
        if ((getParentFragment() instanceof d) == false) goto L14;
        r8.setDragHandlerVisible(false);
        r8.setDragUpEnable(false);
        r8.setOnCloseListener(null);
        r8.getShadowLayout().setVisibility(8);
        ViewGroup.LayoutParams r2 = r8.getLayoutParams();
        if (r2 == null) goto L15;
        r2.height = -1;
        r8.setLayoutParams(r2);
        goto L15
    L14:
        r8.setSlideView(r6.findViewById(2131388817));
        r8.setDragUpEnable(true);
        r8.setOnCloseListener(new bn5.e(this));
        Resources r3 = r8.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).heightPixels;
        float r5 = Math.min(0.5f * r4, W90(320));
        float r15 = r4 * 0.75f;
        r8.y = 0.0f;
        r8.z = r5;
        r8.A = r15;
        r8.x.m(0.0f, r5, r15);
        goto L15
    }

    public static void U90(List r2, Set r3, FormulaCatalogData.Item r4) {
        String r0 = r4.getName();
        if (r0 != null) goto L5;
        String r1 = "";
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L13;
        HashSet r5 = (HashSet) r3;
        if (r5.contains(r1) == true) goto L14;
        r5.add(r1);
        ArrayList r6 = (ArrayList) r2;
        r6.add(new h(2, null, r4));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = r0.toUpperCase(Locale.ROOT);
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564565, r3, false);
    }
}
