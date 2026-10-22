package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f211764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f211765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f211766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f211767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f211768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C3039d f211769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BTRatingBar f211770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f211771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f211772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DialogInterface.OnDismissListener f211773k;

    public final class a extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f211774a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.d$a$a, reason: collision with other inner class name */
        public final class C3038a extends LinearSmoothScroller {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f211775a;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final float calculateSpeedPerPixel(DisplayMetrics r100) {
                d r101 = this.f211775a.f211774a;
                if (r101.f211771i == false) goto L5;
                r101.f211771i = false;
                return Float.MIN_VALUE;
            L5:
                if (r100 == null) goto L8;
                return 100.0f / r100.densityDpi;
            L8:
                return super.calculateSpeedPerPixel(r100);
            }

            public C3038a(a r100, Context r101) {
                Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                this.f211775a = r100;
                super(r101);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
                return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
            }
        }

        public a(d r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f211774a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
            if (r100 == null) goto L5;
            C3038a r103 = new C3038a(this, r100.getContext());
            r103.setTargetPosition(r102);
            startSmoothScroll(r103);
            return;
        }
    }

    public final class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f211776a;

        public b(int r100) {
            this.f211776a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            super.getItemOffsets(r100, r101, r102, r103);
            int r104 = this.f211776a;
            r100.left = r104;
            r100.right = r104;
        }
    }

    public interface c {
        void a();

        List<FieldConfigMetaModel.RatingSymboInfo> b();

        void c(FieldConfigMetaModel.RatingSymboInfo r100);

        String getPanelTitle();

        mr4.a o();
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.d$d, reason: collision with other inner class name */
    public final class C3039d extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f211777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<FieldConfigMetaModel.RatingSymboInfo> f211778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f211779c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.d$d$a */
        public final class a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f211780a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final View f211781b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ImageView f211782c;

            public a(View r100) {
                Intrinsics.checkNotNullParameter(r100, "view");
                super(r100);
                this.f211780a = r100;
                this.f211781b = r100.findViewById(R.id.item_root);
                this.f211782c = (ImageView) r100.findViewById(R.id.selectTip);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<FieldConfigMetaModel.RatingSymboInfo> r100 = this.f211778b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public final Context getContext() {
            return this.f211777a;
        }

        public C3039d(d r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f211779c = r100;
            this.f211777a = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            a r102 = (a) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            List<FieldConfigMetaModel.RatingSymboInfo> r103 = this.f211778b;
            String r104 = null;
            if (r103 == null) goto L5;
            FieldConfigMetaModel.RatingSymboInfo r105 = (FieldConfigMetaModel.RatingSymboInfo) ListProtector.get(r103, r101);
        L6:
            Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r106 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
            if (r105 == null) goto L9;
            String r107 = r105.getSymbol();
        L11:
            if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(r107) == false) goto L17;
            com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r108 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b("preview");
            if (r108 == null) goto L25;
            ImageView r109 = r102.f211782c;
            if (r109 == null) goto L25;
            r109.setImageResource(r108.f210059a);
        L25:
            if (r105 == null) goto L28;
            r104 = r105.getSymbol();
        L28:
            if (TextUtils.equals(r104, this.f211779c.f211772j) == false) goto L32;
            View r110 = r102.f211781b;
            if (r110 == null) goto L35;
            r110.setBackgroundResource(R.drawable.bitable_field_edit_rating_selected_bg);
        L35:
            View r111 = r102.f211781b;
            if (r111 == null) goto L39;
            r111.setOnClickListener(new e(r105, this.f211779c, this, r101));
            return;
        L39:
            return;
        L32:
            View r112 = r102.f211781b;
            if (r112 == null) goto L35;
            r112.setBackgroundResource(R.drawable.bitable_field_edit_rating_unselected_bg);
            goto L35
        L17:
            if (r105 == null) goto L19;
            String r113 = r105.getSymbol();
        L20:
            com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r114 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(r113);
            if (r114 == null) goto L25;
            ImageView r115 = r102.f211782c;
            if (r115 == null) goto L25;
            r115.setImageResource(r114.f210057a);
            goto L25
        L19:
            r113 = null;
            goto L20
        L9:
            r107 = null;
            goto L11
        L5:
            r105 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(this.f211777a).inflate(R.layout.bitable_card_rating_edit_icon_select_item, r100, false);
            Intrinsics.checkNotNull(r102);
            return new a(r102);
        }
    }

    public final void a() {
        Dialog r100 = this.f211765c;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public final void b() {
        Object r100 = null;
        if (this.f211765c != null) goto L30;
        this.f211771i = true;
        CommonActionPanelLayout r101 = new CommonActionPanelLayout(this.f211763a);
        r101.setTitle(this.f211764b.getPanelTitle());
        r101.setPanelBackgroundColor(R.color.bg_float_base);
        r101.setOnActionListener(new f(this));
        View r102 = LayoutInflater.from(this.f211763a).inflate(R.layout.bitable_field_edit_rating_icon_select_view, null);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r103 = (ViewGroup) r102;
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-1, -2);
        int r105 = this.f211763a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        r104.setMargins(r105, r105, r105, 0);
        this.f211766d = (RecyclerView) r103.findViewById(R.id.rateRv);
        this.f211770h = (BTRatingBar) r103.findViewById(R.id.preview_ratebar);
        this.f211767e = (TextView) r103.findViewById(R.id.rateIconTip);
        RecyclerView r106 = this.f211766d;
        if (r106 == null) goto L18;
        a r107 = new a(this, this.f211763a);
        this.f211768f = r107;
        r107.setOrientation(0);
        C3039d r108 = new C3039d(this, this.f211763a);
        this.f211769g = r108;
        List<FieldConfigMetaModel.RatingSymboInfo> r109 = this.f211764b.b();
        Intrinsics.checkNotNullParameter(r109, "rateIconList");
        r108.f211778b = r109;
        r108.notifyDataSetChanged();
        r106.setLayoutManager(this.f211768f);
        r106.addItemDecoration(new b(n.d(3)));
        r106.setAdapter(this.f211769g);
        a r110 = this.f211768f;
        if (r110 == null) goto L18;
        RecyclerView.State r111 = new RecyclerView.State();
        String r112 = this.f211772j;
        if (r112 == null) goto L16;
        Iterator<T> r113 = this.f211764b.b().iterator();
        int r114 = 0;
    L12:
        if (r113.hasNext() == false) goto L17;
        if (TextUtils.equals(r112, ((FieldConfigMetaModel.RatingSymboInfo) r113.next()).getSymbol()) == true) goto L17;
        r114 = r114 + 1;
    L17:
        r110.smoothScrollToPosition(r106, r111, r114);
        goto L18
    L16:
        r114 = 0;
    L18:
        r101.addView(r103, r104);
        if (ku5.c.k(this.f211763a) == false) goto L21;
        int r115 = R.style.CustomPadBottomSheetDialog;
    L22:
        Dialog r116 = new Dialog(this.f211763a, r115);
        r116.setContentView(r101);
        Window r117 = r116.getWindow();
        if (r117 == null) goto L26;
        r101.measure(0, 0);
        WindowManager.LayoutParams r118 = r117.getAttributes();
        r118.width = -1;
        r118.height = r101.getMeasuredHeight();
        r118.gravity = 80;
        r117.setAttributes(r118);
    L26:
        if (g.b() == false) goto L28;
        int r119 = WatermarkUtils.f209802a;
        WatermarkUtils.a(this.f211764b.o(), r116);
    L29:
        r116.setOnDismissListener(this.f211773k);
        this.f211765c = r116;
        goto L30
    L28:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r116);
        goto L29
    L21:
        r115 = R.style.CustomBottomSheetDialog;
    L30:
        Iterator<T> r120 = this.f211764b.b().iterator();
    L32:
        if (r120.hasNext() == false) goto L36;
        Object r121 = r120.next();
        if (TextUtils.equals(this.f211772j, ((FieldConfigMetaModel.RatingSymboInfo) r121).getSymbol()) == false) goto L32;
        r100 = r121;
    L36:
        c((FieldConfigMetaModel.RatingSymboInfo) r100);
        Dialog r122 = this.f211765c;
        if (r122 != null) goto L39;
        return;
    L39:
        if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r122);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L42:
        DialogLancet.beforeDialogShow(r122);
        r122.show();
        DialogLancet.afterDialogShow(r122);
    }

    public final Context getContext() {
        return this.f211763a;
    }

    public final void c(FieldConfigMetaModel.RatingSymboInfo r100) {
        if (r100 == null) goto L33;
        TextView r101 = this.f211767e;
        if (r101 == null) goto L6;
        r101.setText(r100.getName());
    L6:
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r102 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(r100.getSymbol()) == false) goto L18;
        ArrayList r103 = new ArrayList();
        int r104 = 1;
    L10:
        if (r104 >= 6) goto L15;
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r105 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r106 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r104));
        if (r106 == null) goto L14;
        r103.add(r106);
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        BTRatingBar r107 = this.f211770h;
        if (r107 == null) goto L34;
        BTRatingBar.a r108 = new BTRatingBar.a();
        r108.f210048e = 3;
        r108.f210046c = 5;
        r108.f210047d = 1;
        r108.f210052i = true;
        r108.f210053j = r103;
        r108.f210051h = new sr4.e(25, 10, null);
        r108.f210050g = true;
        r107.setRatingBarInfo(r108);
        return;
    L34:
        return;
    L18:
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r109 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(r100.getSymbol());
        BTRatingBar r110 = this.f211770h;
        if (r110 == null) goto L36;
        BTRatingBar.a r111 = new BTRatingBar.a();
        r111.f210048e = 3;
        r111.f210046c = 5;
        r111.f210047d = 1;
        if (r109 == null) goto L23;
        Integer r112 = Integer.valueOf(r109.f210057a);
    L24:
        r111.f210044a = r112;
        if (r109 == null) goto L27;
        Integer r113 = Integer.valueOf(r109.f210058b);
    L28:
        r111.f210045b = r113;
        r111.f210051h = new sr4.e(25, 10, null);
        r111.f210050g = true;
        r110.setRatingBarInfo(r111);
        return;
    L27:
        r113 = null;
        goto L28
    L23:
        r112 = null;
        goto L24
    L36:
        return;
    }

    public d(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f211763a = r100;
        this.f211764b = r101;
        this.f211771i = true;
    }
}
