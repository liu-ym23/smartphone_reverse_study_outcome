package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.ProgressFieldPropertyEditViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import yp4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f211737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f211738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f211739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f211740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorPreviewFlexLayout f211741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f211742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C3035a f211743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f211744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f211745j;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a$a, reason: collision with other inner class name */
    public final class C3035a extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f211746a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a$a$a, reason: collision with other inner class name */
        public final class C3036a extends LinearSmoothScroller {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C3035a f211747a;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final float calculateSpeedPerPixel(DisplayMetrics r100) {
                a r101 = this.f211747a.f211746a;
                if (r101.f211745j == false) goto L5;
                r101.f211745j = false;
                return Float.MIN_VALUE;
            L5:
                if (r100 == null) goto L8;
                return 100.0f / r100.densityDpi;
            L8:
                return super.calculateSpeedPerPixel(r100);
            }

            public C3036a(C3035a r100, Context r101) {
                Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                this.f211747a = r100;
                super(r101);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
                return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
            }
        }

        public C3035a(a r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f211746a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
            if (r100 == null) goto L5;
            C3036a r103 = new C3036a(this, r100.getContext());
            r103.setTargetPosition(r102);
            startSmoothScroll(r103);
            return;
        }
    }

    public final class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f211748a;

        public b(int r100) {
            this.f211748a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            super.getItemOffsets(r100, r101, r102, r103);
            int r104 = this.f211748a;
            r100.left = r104;
            r100.right = r104;
        }
    }

    public final class c extends RecyclerView.Adapter<C3037a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f211749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<FieldConfigMetaModel.CommonColor> f211750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f211751c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a$c$a, reason: collision with other inner class name */
        public final class C3037a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f211752a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final GradientOffsetView f211753b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final View f211754c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final View f211755d;

            public C3037a(View r100) {
                Intrinsics.checkNotNullParameter(r100, "view");
                super(r100);
                this.f211752a = r100;
                this.f211753b = (GradientOffsetView) r100.findViewById(R.id.defaultColorPreview);
                this.f211754c = r100.findViewById(R.id.gradientColorPreview);
                this.f211755d = r100.findViewById(R.id.selectTip);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<FieldConfigMetaModel.CommonColor> r100 = this.f211750b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public final Context getContext() {
            return this.f211749a;
        }

        public c(a r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f211751c = r100;
            this.f211749a = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            C3037a r102 = (C3037a) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            List<FieldConfigMetaModel.CommonColor> r103 = this.f211750b;
            if (r103 == null) goto L5;
            FieldConfigMetaModel.CommonColor r104 = (FieldConfigMetaModel.CommonColor) ListProtector.get(r103, r101);
        L6:
            if (r104 == null) goto L35;
            String r105 = r104.getType();
            Locale r106 = Locale.ROOT;
            int r107 = 0;
            if (Intrinsics.areEqual(r105, "MULTI".toLowerCase(r106)) == false) goto L10;
        L21:
            GradientOffsetView r108 = r102.f211753b;
            if (r108 == null) goto L24;
            r108.setVisibility(0);
        L24:
            View r109 = r102.f211754c;
            if (r109 == null) goto L27;
            r109.setVisibility(8);
        L27:
            j.i(r104.getColor(), r102.f211753b);
        L28:
            View r110 = r102.f211755d;
            if (r110 == null) goto L35;
            if (Intrinsics.areEqual(r104.getId(), this.f211751c.f211742g) == true) goto L34;
            r107 = 8;
        L34:
            r110.setVisibility(r107);
            goto L35
        L10:
            if (Intrinsics.areEqual(r105, "PURE".toLowerCase(r106)) == true) goto L21;
            if (Intrinsics.areEqual(r105, "GRADIENT".toLowerCase(r106)) == false) goto L28;
            GradientOffsetView r111 = r102.f211753b;
            if (r111 == null) goto L17;
            r111.setVisibility(8);
        L17:
            View r112 = r102.f211754c;
            if (r112 == null) goto L20;
            r112.setVisibility(0);
        L20:
            j.j(r104.getColor(), r102.f211754c);
        L35:
            r102.f211752a.setOnClickListener(new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.b(r104, this.f211751c, this, r101));
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(this.f211749a).inflate(R.layout.bitable_card_progress_edit_color_select_item, r100, false);
            Intrinsics.checkNotNull(r102);
            return new C3037a(r102);
        }
    }

    public interface d {
        void a();

        List<FieldConfigMetaModel.CommonColor> b();

        void c(FieldConfigMetaModel.CommonColor r100);

        String getPanelTitle();

        mr4.a o();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f211756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f211757b;

        public e() {
            this.f211757b = -1;
        }
    }

    public final Context getContext() {
        return this.f211736a;
    }

    public final void a(FieldConfigMetaModel.CommonColor r100) {
        if (r100 == null) goto L25;
        ArrayList r101 = new ArrayList();
        if (TextUtils.equals(r100.getType(), "GRADIENT".toLowerCase(Locale.ROOT)) == false) goto L6;
        e r102 = new e();
        r102.f211756a = 38;
        r102.f211757b = j.c(38, r100);
        r101.add(r102);
        e r103 = new e();
        r103.f211756a = 63;
        r103.f211757b = j.c(63, r100);
        r101.add(r103);
        e r104 = new e();
        r104.f211756a = 100;
        r104.f211757b = j.c(100, r100);
        r101.add(r104);
    L18:
        TextView r105 = this.f211740e;
        if (r105 == null) goto L21;
        r105.setText(r100.getName());
    L21:
        ColorPreviewFlexLayout r106 = this.f211741f;
        if (r106 == null) goto L26;
        r106.setPreviewList(r101);
        return;
    L26:
        return;
    L6:
        String[] r107 = r100.getColor();
        if (r107 == null) goto L18;
        int r108 = r107.length;
        if (r108 != 1) goto L11;
        e r109 = new e();
        r109.f211756a = 80;
        r109.f211757b = j.c(80, r100);
        r101.add(r109);
        goto L18
    L11:
        if (r108 != 2) goto L13;
        e r110 = new e();
        r110.f211756a = 40;
        r110.f211757b = j.c(40, r100);
        r101.add(r110);
        e r111 = new e();
        r111.f211756a = 60;
        r111.f211757b = j.c(60, r100);
        r101.add(r111);
        goto L18
    L13:
        if (r108 != 5) goto L18;
        e r112 = new e();
        r112.f211756a = 17;
        r112.f211757b = j.c(17, r100);
        r101.add(r112);
        e r113 = new e();
        r113.f211756a = 33;
        r113.f211757b = j.c(33, r100);
        r101.add(r113);
        e r114 = new e();
        r114.f211756a = 50;
        r114.f211757b = j.c(50, r100);
        r101.add(r114);
        e r115 = new e();
        r115.f211756a = 67;
        r115.f211757b = j.c(67, r100);
        r101.add(r115);
        e r116 = new e();
        r116.f211756a = 83;
        r116.f211757b = j.c(83, r100);
        r101.add(r116);
        goto L18
    }

    public a(Context r100, ProgressFieldPropertyEditViewHolder.c.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f211736a = r100;
        this.f211737b = r101;
        this.f211745j = true;
    }
}
