package com.bytedance.ee.bear.sheet.inputbar.formula;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f238012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PopupWindow f238013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f238014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f238015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f238016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f238017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f238018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f238019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f238020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f238021j;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.formula.a$a, reason: collision with other inner class name */
    public static class C3423a extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f238022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f238023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f238024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f238025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f238026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f238027f;

        public C3423a(Context r100) {
            Paint r101 = new Paint(1);
            this.f238022a = r101;
            this.f238027f = new RectF();
            this.f238023b = h(r100, 3.0f);
            this.f238024c = h(r100, 4.0f);
            this.f238025d = h(r100, 8.0f);
            this.f238026e = h(r100, 32.0f);
            r101.setColor(ContextCompat.getColor(r100, R.color.text_placeholder));
        }

        public static int h(Context r100, float r101) {
            Resources r102 = r100.getResources();
            return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
            int r111 = r101.computeVerticalScrollRange();
            int r102 = r101.computeVerticalScrollExtent();
            if (r111 <= r102) goto L11;
            if (r111 <= 0) goto L12;
            int r103 = r101.computeVerticalScrollOffset();
            int r104 = Math.max(0, r101.getHeight() - (this.f238025d * 2));
            if (r104 > 0) goto L9;
            return;
        L9:
            float r105 = r104;
            float r106 = Math.max(this.f238026e, (r102 / r111) * r105);
            int r107 = this.f238025d;
            float r112 = Math.max(r107, Math.min(r107 + ((r105 - r106) * (r103 / (r111 - r102))), (r104 + r107) - r106));
            float r108 = r101.getWidth() - this.f238024c;
            this.f238027f.set(r108 - this.f238023b, r112, r108, r106 + r112);
            RectF r109 = this.f238027f;
            int r113 = this.f238023b;
            r100.drawRoundRect(r109, r113 / 2.0f, r113 / 2.0f, this.f238022a);
            return;
        L12:
            return;
        }
    }

    public interface b {
        void a(String r100, int r101);
    }

    public static class c extends RecyclerView.Adapter<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<FormulaSuggestionsData.Item> f238028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f238029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC3424a f238030c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.formula.a$c$a, reason: collision with other inner class name */
        public interface InterfaceC3424a {
        }

        public static class b extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f238031a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f238032b;

            public b(View r100, TextView r101, TextView r102) {
                super(r100);
                this.f238031a = r101;
                this.f238032b = r102;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<FormulaSuggestionsData.Item> r100 = this.f238028a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.size();
        }

        public c(List r100, bn5.a r101) {
            this.f238029b = "";
            this.f238028a = r100;
            this.f238030c = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
            final b r101 = (b) r100;
            FormulaSuggestionsData.Item r111 = (FormulaSuggestionsData.Item) ListProtector.get(this.f238028a, r110);
            TextView r102 = r101.f238031a;
            Context r103 = r101.itemView.getContext();
            String r104 = "";
            if (r111.getLabel() != null) goto L5;
            String r105 = "";
        L6:
            String r106 = this.f238029b;
            CharSequence r107 = r105;
            if (TextUtils.isEmpty(r106) == true) goto L15;
            boolean r108 = TextUtils.isEmpty(r105);
            r107 = r105;
            if (r108 == true) goto L15;
            Locale r109 = Locale.ROOT;
            int r112 = r105.toLowerCase(r109).indexOf(r106.toLowerCase(r109));
            r107 = r105;
            if (r112 < 0) goto L15;
            SpannableString r113 = new SpannableString(r105);
            r113.setSpan(new BackgroundColorSpan(ContextCompat.getColor(r103, R.color.primary_fill_solid_02)), r112, r106.length() + r112, 33);
            r107 = r113;
        L15:
            r102.setText(r107);
            TextView r114 = r101.f238032b;
            if (r111.getDetail() == null) goto L19;
            r104 = r111.getDetail();
        L19:
            r114.setText(r104);
            r101.itemView.setOnClickListener(new bn5.c(this, r101));
            return;
        L5:
            r105 = r111.getLabel();
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_formula_completion_item, r100, false);
            return new b(r102, (TextView) r102.findViewById(R.id.formula_completion_label), (TextView) r102.findViewById(R.id.formula_completion_detail));
        }
    }

    public final void a() {
        if (this.f238013b.isShowing() == false) goto L5;
        PopupWindow r100 = this.f238013b;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f238016e = "";
        this.f238019h = null;
        this.f238020i = 0;
        this.f238021j = 0;
    }

    public final boolean c() {
        return this.f238013b.isShowing();
    }

    public final void d() {
        if (this.f238013b.isShowing() == false) goto L25;
        View r100 = this.f238019h;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isAttachedToWindow() == true) goto L10;
        return;
    L10:
        int r101 = this.f238019h.getHeight();
        int r102 = this.f238020i;
        int r103 = -(r101 + r102);
        PopupWindow r104 = this.f238013b;     // Catch: IllegalStateException -> L21
        View r105 = this.f238019h;     // Catch: IllegalStateException -> L21
        int r110 = this.f238021j;     // Catch: IllegalStateException -> L21
        if ((r104 instanceof PopupWindow) == false) goto L17;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r104) == false) goto L17;
        r104.update(r105, 0, r103, r110, r102);     // Catch: IllegalStateException -> L21
    L22:
        return;
    L17:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r104, r105, 0, r103, r110, r102) == true) goto L22;
        r104.update(r105, 0, r103, r110, r102);     // Catch: IllegalStateException -> L21
    L27:
        return;
    }

    public a(Context r100) {
        this.f238016e = "";
        this.f238012a = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.sheet_formula_completion_window, null, false);
        RecyclerView r102 = (RecyclerView) r101.findViewById(R.id.formula_completion_list);
        this.f238014c = r102;
        r102.setLayoutManager(new LinearLayoutManager(r100));
        r102.setVerticalScrollBarEnabled(false);
        r102.addItemDecoration(new C3423a(r100));
        c r103 = new c(new ArrayList(), new bn5.a(this));
        this.f238015d = r103;
        r102.setAdapter(r103);
        PopupWindow r104 = new PopupWindow(r101, -1, -2);
        this.f238013b = r104;
        r104.setBackgroundDrawable(new ColorDrawable(0));
        r104.setOutsideTouchable(false);
        r104.setFocusable(false);
        r104.setOnDismissListener(new bn5.b(this));
    }

    public final int b(float r100) {
        Resources r101 = this.f238012a.getResources();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final void e(View r100, FormulaSuggestionsData r110, String r111) {
        this.f238019h = r100;
        if (r110.getItems() != null) goto L5;
        List<FormulaSuggestionsData.Item> r101 = Collections.emptyList();
    L7:
        if (CollectionUtils.isEmpty(r101) == false) goto L10;
        a();
        return;
    L10:
        String r102 = "";
        if (r110.getRequestId() != null) goto L13;
        String r112 = "";
    L14:
        this.f238016e = r112;
        c r113 = this.f238015d;
        r113.f238028a = r101;
        if (r111 == null) goto L18;
        r102 = r111.trim();
    L18:
        r113.f238029b = r102;
        r113.notifyDataSetChanged();
        Resources r114 = this.f238012a.getResources();
        int r115 = Math.min((r101.size() * b(56.0f)) + b(8.0f), Math.max(b(168.0f), (int) (WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).heightPixels * 0.25f)));
        int r116 = b(30.0f) + r115;
        int r103 = r100.getWidth();
        Resources r104 = this.f238012a.getResources();
        int r105 = Math.max(r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels);
        this.f238014c.setLayoutParams(new LinearLayout.LayoutParams(-1, r115));
        this.f238013b.setHeight(r116);
        this.f238013b.setWidth(r105);
        this.f238020i = r116;
        this.f238021j = r105;
        int r117 = -((r100.getHeight() + r116) - b(1.0f));
        if (this.f238013b.isShowing() == false) goto L29;
        PopupWindow r106 = this.f238013b;
        if ((r106 instanceof PopupWindow) == false) goto L26;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r106) == false) goto L26;
        r106.update(r100, 0, r117, r105, r116);
        return;
    L26:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r106, r100, 0, r117, r105, r116) == true) goto L36;
        r106.update(r100, 0, r117, r105, r116);
        return;
    L36:
        return;
    L29:
        PopupWindow r118 = this.f238013b;
        OverlaySource r107 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r118, r100, r107) == true) goto L37;
        r118.showAsDropDown(r100, 0, r117);
        PopupWindowLancet.trackAfterShow(r118, r107, r100);
        return;
    L37:
        return;
    L13:
        r112 = r110.getRequestId();
        goto L14
    L5:
        r101 = r110.getItems();
        goto L7
    }
}
