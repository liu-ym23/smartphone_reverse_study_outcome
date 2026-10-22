package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.bottom.core.inputtext.PanelStickyHeaderDecoration;
import com.larus.bmhome.chat.component.bottom.core.inputtext.m1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.o1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class InputPanelListView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f299040h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f299041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f299042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f299043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f299044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f299045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends o> f299046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f299047g;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends o> f299048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f299049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputPanelListView f299050c;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f299048a.size();
        }

        public c(InputPanelListView r100) {
            this.f299050c = r100;
            this.f299048a = CollectionsKt.emptyList();
            this.f299049b = "";
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            o r101 = (o) ListProtector.get(this.f299048a, r100);
            if ((r101 instanceof o.b) == false) goto L6;
            return 0;
        L6:
            if ((r101 instanceof o.d) == false) goto L9;
            return 1;
        L9:
            if (Intrinsics.areEqual(r101, o.c.f299087a) == false) goto L13;
            return 2;
        L13:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            ExposeXTrackerExtKt.e(r100.itemView);
            super.onViewRecycled(r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            o r102 = (o) ListProtector.get(this.f299048a, r101);
            if ((r102 instanceof o.b) == false) goto L6;
            View r103 = r100.itemView;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r103).setText(((o.b) r102).f299086a);
            return;
        L6:
            if ((r102 instanceof o.d) == false) goto L9;
            String r104 = this.f299049b;
            int r105 = InputPanelListView.f299040h;
            this.f299050c.a(((d) r100).f299051a, (o.d) r102, r104);
            return;
        L9:
            if (Intrinsics.areEqual(r102, o.c.f299087a) == false) goto L12;
            return;
        L12:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != 0) goto L5;
            InputPanelListView r102 = this.f299050c;
            int r103 = InputPanelListView.f299040h;
            return new f(r102.c(r100));
        L5:
            if (r101 == 2) goto L7;
            InputPanelListView r104 = this.f299050c;
            int r105 = InputPanelListView.f299040h;
            return new d(r104.d(r100));
        L7:
            InputPanelListView r106 = this.f299050c;
            int r107 = InputPanelListView.f299040h;
            return new b(m1.a(r106.f299042b, r100));
        }
    }

    public static final class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f299051a;

        public d(e r100) {
            Intrinsics.checkNotNullParameter(r100, "views");
            super(r100.f299052a);
            this.f299051a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f299052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f299053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f299054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f299055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f299056e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f299052a, r101.f299052a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299053b, r101.f299053b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f299054c, r101.f299054c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f299055d, r101.f299055d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f299056e, r101.f299056e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f299052a.hashCode() * 31) + this.f299053b.hashCode()) * 31) + this.f299054c.hashCode()) * 31) + this.f299055d.hashCode()) * 31) + this.f299056e.hashCode();
        }

        public final String toString() {
            return "RowViews(root=" + this.f299052a + ", icon=" + this.f299053b + ", title=" + this.f299054c + ", description=" + this.f299055d + ", trailingIcon=" + this.f299056e + ')';
        }

        public e(View r100, ImageView r101, TextView r102, TextView r103, ImageView r104) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "icon");
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r103, "description");
            Intrinsics.checkNotNullParameter(r104, "trailingIcon");
            this.f299052a = r100;
            this.f299053b = r101;
            this.f299054c = r102;
            this.f299055d = r103;
            this.f299056e = r104;
        }
    }

    public static final class f extends RecyclerView.ViewHolder {
        public f(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    static {
    }

    public InputPanelListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f299041a = r100;
        this.f299042b = LayoutInflater.from(r100);
        c r101 = new c(this);
        this.f299043c = r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f299044d = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_40, r100, R.dimen.larus_dp_40));
        this.f299045e = c7.b(360);
        this.f299046f = CollectionsKt.emptyList();
        RecyclerView r102 = new RecyclerView(r100);
        r102.setLayoutManager(new LinearLayoutManager(r102.getContext()));
        r102.setAdapter(r101);
        r102.setItemAnimator(null);
        ExposeXTrackerExtKt.c(r102);
        r102.addItemDecoration(new PanelStickyHeaderDecoration(new InputPanelListView$view$1$1(r101), new InputPanelListView$view$1$2(this)));
        this.f299047g = r102;
    }

    public static int b(List r100) {
        boolean r101 = true;
        if ((!r100.isEmpty()) == false) goto L17;
        List r102 = r100;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        if (Intrinsics.areEqual((o) r103.next(), o.c.f299087a) == true) goto L11;
        r101 = false;
    L15:
        if (r101 == false) goto L17;
        return 6;
    L7:
        if (r102.isEmpty() == false) goto L9;
    L17:
        return 4;
    }

    public final TextView c(ViewGroup r100) {
        View r101 = this.f299042b.inflate(R.layout.larus_item_panel_header, r100, false);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.TextView");
        TextView r102 = (TextView) r101;
        nda.d.a().wa(r102);
        return r102;
    }

    public final e d(ViewGroup r110) {
        View r100 = this.f299042b.inflate(R.layout.larus_item_panel_row, r110, false);
        Intrinsics.checkNotNull(r100);
        return new e(r100, (ImageView) r100.findViewById(R.id.panel_row_icon), (TextView) r100.findViewById(R.id.panel_row_title), (TextView) r100.findViewById(R.id.panel_row_description), (ImageView) r100.findViewById(R.id.panel_row_trailing_icon));
    }

    public final void a(e r100, final o.d r110, String r111) {
        ExposeXTrackerExtKt.e(r100.f299052a);
        final String r101 = r110.f299099l;
        final Function0<Unit> r102 = r110.f299100m;
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        ExposeXTrackerExtKt.b(r100.f299052a, new p(r102, r101));
    L6:
        r100.f299052a.setEnabled(r110.f299098k);
        r100.f299052a.setClickable(r110.f299098k);
        r100.f299052a.setFocusable(r110.f299098k);
        View r103 = r100.f299052a;
        if (r110.f299098k == false) goto L9;
        float r104 = 1.0f;
    L10:
        r103.setAlpha(r104);
        ColorStateList r105 = null;
        if (r110.f299098k == false) goto L13;
        r100.f299052a.setOnClickListener(new q(r110));
    L14:
        final Function1<View, Unit> r106 = r110.f299101n;
        int r107 = 0;
        if (r110.f299098k == false) goto L18;
        if (r106 == null) goto L18;
        r100.f299052a.setOnLongClickListener(new r(r106));
    L19:
        t1 r108 = r110.f299092e;
        TextView r109 = r100.f299054c;
        if (r110.f299089b == false) goto L22;
        TextUtils.TruncateAt r112 = null;
    L23:
        r109.setEllipsize(r112);
        r100.f299054c.setHorizontalFadingEdgeEnabled(r110.f299089b);
        TextView r113 = r100.f299054c;
        if (r110.f299089b == false) goto L26;
        int r114 = c7.b(24);
    L27:
        r113.setFadingEdgeLength(r114);
        r100.f299054c.scrollTo(0, 0);
        if (r108 == null) goto L30;
        o1.a(r100.f299054c, r110.f299088a, r108.f299233b);
        o1.a(r100.f299055d, r110.f299090c, r108.f299234c);
    L31:
        r100.f299055d.setAlpha(r110.f299091d);
        TextView r115 = r100.f299055d;
        boolean r116 = true;
        if ((!StringsKt.isBlank(r110.f299090c)) == false) goto L34;
        int r117 = 0;
    L35:
        r115.setVisibility(r117);
        ImageView r118 = r100.f299056e;
        if (r110.f299096i != null) goto L39;
        r116 = false;
    L39:
        if (r116 == true) goto L42;
        r107 = 8;
    L42:
        r118.setVisibility(r107);
        Integer r119 = r110.f299096i;
        if (r119 == null) goto L45;
        r100.f299056e.setImageResource(r119.intValue());
    L45:
        ImageView r120 = r100.f299056e;
        Integer r121 = r110.f299097j;
        if (r121 == null) goto L48;
        ColorStateList r122 = ColorStateList.valueOf(r121.intValue());
    L49:
        r120.setImageTintList(r122);
        Drawable r123 = r110.f299094g;
        if (r123 == null) goto L52;
        r100.f299053b.setImageDrawable(r123);
    L55:
        ImageView r124 = r100.f299053b;
        Integer r125 = r110.f299095h;
        if (r125 == null) goto L58;
        r105 = ColorStateList.valueOf(r125.intValue());
    L64:
        r124.setImageTintList(r105);
        return;
    L58:
        Integer r126 = r110.f299093f;
        if (r126 == null) goto L64;
        if (r126.intValue() != R.drawable.larus_ic_mention_reference) goto L64;
        r105 = ContextCompat.getColorStateList(this.f299041a, android.R.color.holo_blue_light);
        goto L64
    L52:
        Integer r127 = r110.f299093f;
        if (r127 == null) goto L55;
        r100.f299053b.setImageResource(r127.intValue());
        goto L55
    L48:
        r122 = null;
        goto L49
    L34:
        r117 = 8;
        goto L35
    L30:
        TextView r128 = r100.f299054c;
        String r129 = r110.f299088a;
        Intrinsics.checkNotNullParameter(r128, "<this>");
        Intrinsics.checkNotNullParameter(r129, "value");
        Intrinsics.checkNotNullParameter(r111, "keyword");
        o1.b(r128, r129, CollectionsKt.listOf(r111));
        TextView r130 = r100.f299055d;
        String r131 = r110.f299090c;
        Intrinsics.checkNotNullParameter(r130, "<this>");
        Intrinsics.checkNotNullParameter(r131, "value");
        Intrinsics.checkNotNullParameter(r111, "keyword");
        o1.b(r130, r131, CollectionsKt.listOf(r111));
        goto L31
    L26:
        r114 = 0;
        goto L27
    L22:
        r112 = TextUtils.TruncateAt.END;
    L18:
        r100.f299052a.setOnLongClickListener(null);
        r100.f299052a.setLongClickable(false);
        goto L19
    L13:
        r100.f299052a.setOnClickListener(null);
        goto L14
    L9:
        r104 = 0.4f;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.ViewGroup, android.widget.LinearLayout, java.lang.Object] */
    public final void e(LinearLayout r100, List<? extends o> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "highlightKeyword");
        r100.removeAllViews();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        o r104 = (o) r103.next();
        if ((r104 instanceof o.b) == false) goto L9;
        ?? r105 = c(r100);
        r105.setText(((o.b) r104).f299086a);
    L14:
        r100.addView(r105);
        goto L4
    L9:
        if ((r104 instanceof o.d) == false) goto L12;
        e r106 = d(r100);
        a(r106, (o.d) r104, r102);
        r105 = r106.f299052a;
        goto L14
    L12:
        if (Intrinsics.areEqual(r104, o.c.f299087a) == false) goto L16;
        r105 = m1.a(this.f299042b, r100);
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
