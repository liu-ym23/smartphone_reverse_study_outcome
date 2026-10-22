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
import androidx.activity.result.ActivityResultCaller;
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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaPickerFragment extends BaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f237987t = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FormulaCatalogData.Catalog f237988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f237989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f237990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pcb.a f237991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f237992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f237993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f237994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f237995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FormulaCatalogData.Category f237996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f237997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f237998o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EditText f237999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecyclerView f238000q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g f238001r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Parcelable f238002s;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f238003a;

        public a(LinearLayout r100, TextView r101) {
            super(r100);
            this.f238003a = r101;
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f238004a;

        public b(LinearLayout r100, TextView r101) {
            super(r100);
            this.f238004a = r101;
        }
    }

    public interface c {
        void onDismiss();
    }

    public interface d {
        void Bo(String r100, boolean r101);
    }

    public interface e {
    }

    public interface f {
    }

    public final class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<h> f238005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f238006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FormulaPickerFragment f238007c;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f238005a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return ((h) ListProtector.get(this.f238005a, r100)).f238008a;
        }

        public final LinearLayout y2(Context r110) {
            LinearLayout r100 = new LinearLayout(r110);
            r100.setOrientation(0);
            r100.setGravity(16);
            FormulaPickerFragment r101 = this.f238007c;
            int r102 = FormulaPickerFragment.f237987t;
            r100.setLayoutParams(new RecyclerView.LayoutParams(-1, r101.W90(56)));
            LayerDrawable r103 = new LayerDrawable(new Drawable[]{new ColorDrawable(ContextCompat.getColor(this.f238007c.requireContext(), R.color.line_divider_default)), new ColorDrawable(ContextCompat.getColor(this.f238007c.requireContext(), R.color.bg_body))});
            r103.setLayerInset(1, 0, 0, 0, 1);
            r100.setBackground(r103);
            r100.setPadding(this.f238007c.W90(16), 0, this.f238007c.W90(16), 0);
            return r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            final h r102 = (h) ListProtector.get(this.f238005a, r101);
            if ((r100 instanceof a) == false) goto L12;
            FormulaCatalogData.Category r103 = r102.f238009b;
            if (r103 == null) goto L12;
            a r104 = (a) r100;
            if (r103.getLabel() == null) goto L9;
            String r105 = r102.f238009b.getLabel();
        L10:
            r104.f238003a.setText(r105);
            r104.itemView.setOnClickListener(new o(this, r102));
            return;
        L9:
            r105 = r102.f238009b.getId();
        L12:
            if ((r100 instanceof b) == false) goto L18;
            FormulaCatalogData.Item r106 = r102.f238010c;
            if (r106 == null) goto L19;
            b r107 = (b) r100;
            r107.f238004a.setText(r106.getName());
            r107.itemView.setOnClickListener(new p(this, r102));
            return;
        L19:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Context r102 = r100.getContext();
            if (r101 == 1) goto L6;
            LinearLayout r103 = y2(r102);
            TextView r104 = new TextView(r102);
            r104.setTextSize(2, 17.0f);
            r104.setTextColor(ContextCompat.getColor(this.f238007c.requireContext(), R.color.text_title));
            r103.addView(r104);
            return new b(r103, r104);
        L6:
            LinearLayout r105 = y2(r102);
            TextView r106 = new TextView(r102);
            r106.setTextSize(2, 17.0f);
            r106.setTextColor(ContextCompat.getColor(this.f238007c.requireContext(), R.color.text_title));
            r106.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            ImageView r107 = new ImageView(r102);
            r107.setImageResource(R.drawable.ud_icon_right_outlined);
            r107.setColorFilter(ContextCompat.getColor(this.f238007c.requireContext(), R.color.text_placeholder));
            r107.setLayoutParams(new LinearLayout.LayoutParams(this.f238007c.W90(20), this.f238007c.W90(20)));
            r105.addView(r106);
            r105.addView(r107);
            return new a(r105, r106);
        }

        public g(FormulaPickerFragment r100, List r101, com.bytedance.ee.bear.sheet.inputbar.formula.b r102) {
            this.f238007c = r100;
            this.f238005a = r101;
            this.f238006b = r102;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f238008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FormulaCatalogData.Category f238009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FormulaCatalogData.Item f238010c;

        public h(int r100, FormulaCatalogData.Category r101, FormulaCatalogData.Item r102) {
            this.f238008a = r100;
            this.f238009b = r101;
            this.f238010c = r102;
        }
    }

    public final void ba0() {
        this.f237995l = 1;
        String r100 = null;
        this.f237996m = null;
        this.f237997n = "";
        EditText r101 = this.f237999p;
        if (r101 == null) goto L5;
        r101.setText("");
    L5:
        TextView r102 = this.f237998o;
        if (r102 == null) goto L11;
        FormulaCatalogData.Catalog r103 = this.f237988e;
        if (r103 == null) goto L10;
        r100 = r103.getTitle();
    L10:
        r102.setText(r100);
    L11:
        aa0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f237994k = false;
        ca0();
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final boolean S90() {
        if (this.f237995l != 2) goto L6;
        Z90();
        return true;
    L6:
        return false;
    }

    public final void X90() {
        EditText r100 = this.f237999p;
        if (r100 != null) goto L5;
        return;
    L5:
        rcb.c.d(r100);
        this.f237999p.clearFocus();
    }

    public final void aa0() {
        if (this.f238001r != null) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        HashSet r101 = new HashSet();
        int r102 = this.f237995l;
        if (r102 != 1) goto L35;
        if (TextUtils.isEmpty(this.f237997n) == true) goto L24;
        ArrayList r103 = new ArrayList();
        if (this.f237988e.getPopular() == null) goto L13;
        r103.addAll(this.f237988e.getPopular());
    L13:
        if (this.f237988e.getCategories() == null) goto L20;
        Iterator<FormulaCatalogData.Category> r104 = this.f237988e.getCategories().iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        FormulaCatalogData.Category r105 = r104.next();
        if (r105.getFunctions() == null) goto L16;
        r103.addAll(r105.getFunctions());
    L20:
        Iterator<FormulaCatalogData.Item> r106 = Y90(r103).iterator();
    L22:
        if (r106.hasNext() == false) goto L42;
        U90(r100, r101, r106.next());
    L42:
        g r107 = this.f238001r;
        r107.f238005a = r100;
        r107.notifyDataSetChanged();
        return;
    L24:
        Iterator<FormulaCatalogData.Item> r108 = Y90(this.f237988e.getPopular()).iterator();
    L26:
        if (r108.hasNext() == false) goto L29;
        U90(r100, r101, r108.next());
        goto L26
    L29:
        if (this.f237988e.getCategories() == null) goto L42;
        Iterator<FormulaCatalogData.Category> r109 = this.f237988e.getCategories().iterator();
    L32:
        if (r109.hasNext() == false) goto L42;
        r100.add(new h(1, r109.next(), null));
        goto L32
    L35:
        if (r102 != 2) goto L42;
        FormulaCatalogData.Category r110 = this.f237996m;
        if (r110 == null) goto L42;
        Iterator<FormulaCatalogData.Item> r111 = Y90(r110.getFunctions()).iterator();
    L40:
        if (r111.hasNext() == false) goto L42;
        U90(r100, r101, r111.next());
        goto L40
    }

    public final void ca0() {
        pcb.a r100 = this.f237991h;
        if (r100 == null) goto L7;
        k r101 = this.f237992i;
        if (r101 == null) goto L7;
        r100.a(r101);
    L7:
        EditText r102 = this.f237999p;
        if (r102 == null) goto L12;
        j r103 = this.f237993j;
        if (r103 == null) goto L12;
        r102.removeCallbacks(r103);
    L12:
        this.f237992i = null;
        this.f237991h = null;
        this.f237993j = null;
    }

    public FormulaPickerFragment() {
        this.f237995l = 1;
        this.f237997n = "";
    }

    public final void Z90() {
        X90();
        ba0();
        RecyclerView r100 = this.f238000q;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f238002s == null) goto L13;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if (r101 == null) goto L12;
        r101.onRestoreInstanceState(this.f238002s);
        this.f238002s = null;
        return;
    L12:
        return;
    }

    public final int W90(int r100) {
        Resources r101 = getResources();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final List<FormulaCatalogData.Item> Y90(List<FormulaCatalogData.Item> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L7;
        return Collections.emptyList();
    L7:
        if (TextUtils.isEmpty(this.f237997n) == false) goto L9;
        return r100;
    L9:
        final String r101 = this.f237997n.toUpperCase(Locale.ROOT);
        ArrayList r102 = new ArrayList();
        Iterator<FormulaCatalogData.Item> r103 = r100.iterator();
    L11:
        if (r103.hasNext() == false) goto L18;
        FormulaCatalogData.Item r104 = r103.next();
        String r105 = r104.getName();
        if (r105 == null) goto L11;
        if (r105.toUpperCase(Locale.ROOT).contains(r101) == false) goto L11;
        r102.add(r104);
        goto L11
    L18:
        Collections.sort(r102, new bn5.f(r101));
        return r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        ActivityResultCaller r101 = getParentFragment();
        if ((r101 instanceof d) == false) goto L6;
        this.f237989f = (d) r101;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f237988e = (FormulaCatalogData.Catalog) r101.getSerializable("arg_catalog");
        return;
    }

    public final void V90(pcb.a r100, e r101) {
        if (this.f237994k == true) goto L5;
        return;
    L5:
        if (this.f237991h != r100) goto L10;
        ca0();
        ((i) r101).a(true);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.f237988e != null) goto L6;
        tt5.a.k("FormulaPickerFragment", "onViewCreated catalog == null, dismiss");
        T90(0);
        return;
    L6:
        SheetDragView r102 = (SheetDragView) r100.findViewById(R.id.formula_picker_dragview);
        String r103 = null;
        if (r102 != null) goto L10;
    L15:
        View r104 = r100.findViewById(R.id.title_bar_layout);
        if (r104 == null) goto L21;
        this.f237998o = (TextView) r104.findViewById(R.id.title);
        ImageView r105 = (ImageView) r104.findViewById(R.id.back_icon);
        if (r105 == null) goto L21;
        r105.setOnClickListener(new bn5.d(this));
    L21:
        EditText r106 = (EditText) r100.findViewById(R.id.formula_search_input);
        this.f237999p = r106;
        if (r106 == null) goto L28;
        FormulaCatalogData.Catalog r107 = this.f237988e;
        if (r107 == null) goto L27;
        r103 = r107.getSearchPlaceholder();
    L27:
        r106.setHint(r103);
        this.f237999p.setImeOptions(3);
        this.f237999p.setOnEditorActionListener(new bn5.g(this));
        this.f237999p.setOnFocusChangeListener(new bn5.h(this));
        this.f237999p.addTextChangedListener(new m(this));
    L28:
        RecyclerView r108 = (RecyclerView) r100.findViewById(R.id.formula_picker_list);
        this.f238000q = r108;
        if (r108 == null) goto L35;
        r108.setLayoutManager(new LinearLayoutManager(getContext()));
        g r109 = new g(this, new ArrayList(), new com.bytedance.ee.bear.sheet.inputbar.formula.b(this));
        this.f238001r = r109;
        this.f238000q.setAdapter(r109);
        RecyclerView r110 = this.f238000q;
        if (r110 == null) goto L35;
        r110.addOnScrollListener(new n(this));
    L35:
        ba0();
        return;
    L10:
        if ((getParentFragment() instanceof d) == false) goto L14;
        r102.setDragHandlerVisible(false);
        r102.setDragUpEnable(false);
        r102.setOnCloseListener(null);
        r102.getShadowLayout().setVisibility(8);
        ViewGroup.LayoutParams r111 = r102.getLayoutParams();
        if (r111 == null) goto L15;
        r111.height = -1;
        r102.setLayoutParams(r111);
        goto L15
    L14:
        r102.setSlideView(r100.findViewById(R.id.title_bar_layout));
        r102.setDragUpEnable(true);
        r102.setOnCloseListener(new bn5.e(this));
        Resources r112 = r102.getResources();
        float r113 = WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).heightPixels;
        float r114 = Math.min(0.5f * r113, W90(320));
        float r115 = r113 * 0.75f;
        r102.f237476y = 0.0f;
        r102.f237477z = r114;
        r102.A = r115;
        r102.f237475x.m(0.0f, r114, r115);
        goto L15
    }

    public static void U90(List r100, Set r101, FormulaCatalogData.Item r102) {
        String r103 = r102.getName();
        if (r103 != null) goto L5;
        String r104 = "";
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        HashSet r105 = (HashSet) r101;
        if (r105.contains(r104) == true) goto L14;
        r105.add(r104);
        ArrayList r106 = (ArrayList) r100;
        r106.add(new h(2, null, r102));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r104 = r103.toUpperCase(Locale.ROOT);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_formula_picker_fragment, r101, false);
    }
}
