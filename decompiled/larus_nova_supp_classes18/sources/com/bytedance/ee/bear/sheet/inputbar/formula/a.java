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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final Context a;
    public final PopupWindow b;
    public final RecyclerView c;
    public final c d;
    public String e;
    public b f;
    public Runnable g;
    public View h;
    public int i;
    public int j;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.formula.a$a, reason: collision with other inner class name */
    public static class C0176a extends RecyclerView.ItemDecoration {
        public final Paint a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final RectF f;

        public C0176a(Context r3) {
            Paint r0 = new Paint(1);
            this.a = r0;
            this.f = new RectF();
            this.b = h(r3, 3.0f);
            this.c = h(r3, 4.0f);
            this.d = h(r3, 8.0f);
            this.e = h(r3, 32.0f);
            r0.setColor(ContextCompat.getColor(r3, 2131106620));
        }

        public static int h(Context r1, float r2) {
            Resources r3 = r1.getResources();
            return (int) TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        }

        public final void onDrawOver(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
            int r11 = r9.computeVerticalScrollRange();
            int r0 = r9.computeVerticalScrollExtent();
            if (r11 <= r0) goto L11;
            if (r11 <= 0) goto L12;
            int r1 = r9.computeVerticalScrollOffset();
            int r2 = Math.max(0, r9.getHeight() - (this.d * 2));
            if (r2 > 0) goto L9;
            return;
        L9:
            float r4 = r2;
            float r3 = Math.max(this.e, (r0 / r11) * r4);
            int r5 = this.d;
            float r12 = Math.max(r5, Math.min(r5 + ((r4 - r3) * (r1 / (r11 - r0))), (r2 + r5) - r3));
            float r13 = r9.getWidth() - this.c;
            this.f.set(r13 - this.b, r12, r13, r3 + r12);
            RectF r14 = this.f;
            int r15 = this.b;
            r8.drawRoundRect(r14, r15 / 2.0f, r15 / 2.0f, this.a);
            return;
        L12:
            return;
        }
    }

    public interface b {
        void a(String r1, int r2);
    }

    public static class c extends RecyclerView.Adapter<b> {
        public List<FormulaSuggestionsData.Item> a;
        public String b;
        public final InterfaceC0177a c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.formula.a$c$a, reason: collision with other inner class name */
        public interface InterfaceC0177a {
        }

        public static class b extends RecyclerView.ViewHolder {
            public final TextView a;
            public final TextView b;

            public b(View r1, TextView r2, TextView r3) {
                super(r1);
                this.a = r2;
                this.b = r3;
            }
        }

        public final int getItemCount() {
            List<FormulaSuggestionsData.Item> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        public c(List r2, bn5.a r3) {
            this.b = "";
            this.a = r2;
            this.c = r3;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
            final b r11 = (b) r9;
            FormulaSuggestionsData.Item r12 = (FormulaSuggestionsData.Item) ListProtector.get(this.a, r10);
            TextView r0 = r11.a;
            Context r1 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
            String r3 = "";
            if (r12.getLabel() != null) goto L5;
            String r2 = "";
        L6:
            String r4 = this.b;
            CharSequence r5 = r2;
            if (TextUtils.isEmpty(r4) == true) goto L15;
            boolean r6 = TextUtils.isEmpty(r2);
            r5 = r2;
            if (r6 == true) goto L15;
            Locale r7 = Locale.ROOT;
            int r8 = r2.toLowerCase(r7).indexOf(r4.toLowerCase(r7));
            r5 = r2;
            if (r8 < 0) goto L15;
            SpannableString r13 = new SpannableString(r2);
            r13.setSpan(new BackgroundColorSpan(ContextCompat.getColor(r1, 2131105553)), r8, r4.length() + r8, 33);
            r5 = r13;
        L15:
            r0.setText(r5);
            TextView r14 = r11.b;
            if (r12.getDetail() == null) goto L19;
            r3 = r12.getDetail();
        L19:
            r14.setText(r3);
            ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new bn5.c(this, r11));
            return;
        L5:
            r2 = r12.getLabel();
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564563, r3, false);
            return new b(r5, (TextView) r5.findViewById(2131373215), (TextView) r5.findViewById(2131373214));
        }
    }

    public final void a() {
        if (this.b.isShowing() == false) goto L5;
        PopupWindow r0 = this.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.e = "";
        this.h = null;
        this.i = 0;
        this.j = 0;
    }

    public final boolean c() {
        return this.b.isShowing();
    }

    public final void d() {
        if (this.b.isShowing() == false) goto L25;
        View r0 = this.h;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isAttachedToWindow() == true) goto L10;
        return;
    L10:
        int r1 = this.h.getHeight();
        int r7 = this.i;
        int r2 = -(r1 + r7);
        PopupWindow r8 = this.b;     // Catch: IllegalStateException -> L21
        View r9 = this.h;     // Catch: IllegalStateException -> L21
        int r10 = this.j;     // Catch: IllegalStateException -> L21
        if ((r8 instanceof PopupWindow) == false) goto L17;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r8) == false) goto L17;
        r8.update(r9, 0, r2, r10, r7);     // Catch: IllegalStateException -> L21
    L22:
        return;
    L17:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r8, r9, 0, r2, r10, r7) == true) goto L22;
        r8.update(r9, 0, r2, r10, r7);     // Catch: IllegalStateException -> L21
    L27:
        return;
    }

    public a(Context r6) {
        this.e = "";
        this.a = r6;
        View r0 = LayoutInflater.from(r6).inflate(2131564564, null, false);
        RecyclerView r1 = r0.findViewById(2131373216);
        this.c = r1;
        r1.setLayoutManager(new LinearLayoutManager(r6));
        r1.setVerticalScrollBarEnabled(false);
        r1.addItemDecoration(new C0176a(r6));
        c r7 = new c(new ArrayList(), new bn5.a(this));
        this.d = r7;
        r1.setAdapter(r7);
        PopupWindow r8 = new PopupWindow(r0, -1, -2);
        this.b = r8;
        r8.setBackgroundDrawable(new ColorDrawable(0));
        r8.setOutsideTouchable(false);
        r8.setFocusable(false);
        r8.setOnDismissListener(new bn5.b(this));
    }

    public final int b(float r3) {
        Resources r0 = this.a.getResources();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void e(View r9, FormulaSuggestionsData r10, String r11) {
        this.h = r9;
        if (r10.getItems() != null) goto L5;
        List<FormulaSuggestionsData.Item> r0 = Collections.emptyList();
    L7:
        if (CollectionUtils.isEmpty(r0) == false) goto L10;
        a();
        return;
    L10:
        String r2 = "";
        if (r10.getRequestId() != null) goto L13;
        String r12 = "";
    L14:
        this.e = r12;
        c r13 = this.d;
        r13.a = r0;
        if (r11 == null) goto L18;
        r2 = r11.trim();
    L18:
        r13.b = r2;
        r13.notifyDataSetChanged();
        Resources r14 = this.a.getResources();
        int r15 = Math.min((r0.size() * b(56.0f)) + b(8.0f), Math.max(b(168.0f), (int) (WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).heightPixels * 0.25f)));
        int r16 = b(30.0f) + r15;
        int r1 = r9.getWidth();
        Resources r3 = this.a.getResources();
        int r6 = Math.max(r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, r15));
        this.b.setHeight(r16);
        this.b.setWidth(r6);
        this.i = r16;
        this.j = r6;
        int r17 = -((r9.getHeight() + r16) - b(1.0f));
        if (this.b.isShowing() == false) goto L29;
        PopupWindow r7 = this.b;
        if ((r7 instanceof PopupWindow) == false) goto L26;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r7) == false) goto L26;
        r7.update(r9, 0, r17, r6, r16);
        return;
    L26:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r7, r9, 0, r17, r6, r16) == true) goto L36;
        r7.update(r9, 0, r17, r6, r16);
        return;
    L36:
        return;
    L29:
        PopupWindow r18 = this.b;
        OverlaySource r4 = PopupWindowLancet.resolveSource(r9);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r18, r9, r4) == true) goto L37;
        r18.showAsDropDown(r9, 0, r17);
        PopupWindowLancet.trackAfterShow(r18, r4, r9);
        return;
    L37:
        return;
    L13:
        r12 = r10.getRequestId();
        goto L14
    L5:
        r0 = r10.getItems();
        goto L7
    }
}
