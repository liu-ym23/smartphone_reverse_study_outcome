package com.ss.android.lark.widget.photo.preview.ocr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class SelectionMenu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f447031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f447032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PopupWindow f447033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f447034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f447035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f447036f;

    public static final class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f447037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f447038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<c, Unit> f447039c;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/ocr/SelectionMenu$MenuAdapter$MenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/widget/photo/preview/ocr/SelectionMenu$MenuItem;", "onItemClick", "Lkotlin/Function1;", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class MenuViewHolder extends RecyclerView.ViewHolder {
            public MenuViewHolder(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f447037a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            MenuViewHolder r102 = (MenuViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            c r103 = (c) ListProtector.get(this.f447037a, r101);
            Function1<c, Unit> r104 = this.f447039c;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r104, "onItemClick");
            View r105 = r102.itemView;
            if ((r105 instanceof TextView) == false) goto L5;
            TextView r106 = (TextView) r105;
        L6:
            if (r106 == null) goto L9;
            r106.setText(r103.f447042b);
            r106.setOnClickListener(new com.ss.android.lark.widget.photo.preview.ocr.b(r103, r104));
            return;
        L9:
            return;
        L5:
            r106 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Context r102 = r100.getContext();
            TextView r103 = new TextView(r102);
            r103.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            r103.setMaxWidth(this.f447038b);
            r103.setEllipsize(TextUtils.TruncateAt.END);
            r103.setSingleLine(true);
            int r104 = UIUtils.dp2px(r102, 12.0f);
            int r105 = UIUtils.dp2px(r102, 9.0f);
            r103.setPadding(r104, r105, r104, r105);
            r103.setTextColor(ContextCompat.getColor(r102, R.color.text_title));
            r103.setTextSize(14.0f);
            return new MenuViewHolder(r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MenuAdapter(List<c> r100, int r101, Function1<? super c, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "menuItems");
            Intrinsics.checkNotNullParameter(r102, "onItemClick");
            this.f447037a = r100;
            this.f447038b = r101;
            this.f447039c = r102;
        }
    }

    public static final class a {
    }

    public static final class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f447040a;

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f447040a = ContextCompat.getDrawable(r100, R.drawable.menu_ocr_divider);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "parent");
            Intrinsics.checkNotNullParameter(r102, "state");
            if (this.f447040a != null) goto L5;
            return;
        L5:
            int r103 = r101.getPaddingTop();
            int r104 = r101.getHeight() - r101.getPaddingBottom();
            int r105 = r101.getChildCount() - 1;
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L8;
            View r107 = r101.getChildAt(r106);
            ViewGroup.LayoutParams r108 = r107.getLayoutParams();
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int r109 = r107.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r108)).rightMargin;
            this.f447040a.setBounds(r109, r103, this.f447040a.getIntrinsicWidth() + r109, r104);
            this.f447040a.draw(r100);
            r106 = r106 + 1;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            if (this.f447040a != null) goto L5;
            return;
        L5:
            int r104 = r102.getChildAdapterPosition(r101);
            RecyclerView.Adapter r105 = r102.getAdapter();
            if (r105 == null) goto L8;
            int r106 = r105.getItemCount();
        L10:
            if (r104 == (r106 - 1)) goto L13;
            r100.right = this.f447040a.getIntrinsicWidth();
            return;
        L13:
            return;
        L8:
            r106 = 1;
            goto L10
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f447041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f447042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f447043c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f447041a == r101.f447041a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f447042b, r101.f447042b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f447043c, r101.f447043c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f447041a * 31) + this.f447042b.hashCode()) * 31) + this.f447043c.hashCode();
        }

        public final String toString() {
            return "MenuItem(id=" + this.f447041a + ", title=" + this.f447042b + ", action=" + this.f447043c + ')';
        }

        public c(int r100, String r101, Function0<Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "action");
            this.f447041a = r100;
            this.f447042b = r101;
            this.f447043c = r102;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f447044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f447045b;

        public d(View r100, View r101) {
            this.f447044a = r100;
            this.f447045b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f447044a.requestLayout();     // Catch: Throwable -> L4
            this.f447045b.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f447046a;

        public e(RecyclerView r100) {
            this.f447046a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f447046a.smoothScrollToPosition(0);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f447047a;

        public f(RecyclerView r100) {
            this.f447047a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RecyclerView.Adapter r101 = this.f447047a.getAdapter();
            if (r101 == null) goto L8;
            RecyclerView r102 = this.f447047a;
            if (r101.getItemCount() <= 0) goto L9;
            r102.smoothScrollToPosition(r101.getItemCount() - 1);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void a() {
        PopupWindow r100 = this.f447033c;
        if (r100 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        return;
    }

    public SelectionMenu(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f447031a = r100;
        this.f447032b = new ArrayList();
        this.f447035e = true;
        this.f447036f = UIUtils.dp2px(r100, 6.0f);
    }

    public final void b(int r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "action");
        List<c> r103 = this.f447032b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new c(r100, r101, r102));
        this.f447035e = true;
    }

    public final void c(View r110, Rect r111, Rect r210) {
        Intrinsics.checkNotNullParameter(r110, "anchorView");
        Intrinsics.checkNotNullParameter(r111, "startRect");
        Intrinsics.checkNotNullParameter(r210, "endRect");
        PopupWindow r100 = this.f447033c;
        if (r100 == null) goto L5;
        boolean r101 = r100.isShowing();
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (((ArrayList) this.f447032b).isEmpty() == false) goto L11;
        return;
    L11:
        if (this.f447034d != null) goto L13;
    L14:
        View r102 = LayoutInflater.from(this.f447031a).inflate(R.layout.menu_ocr_selection, null);
        RecyclerView r103 = (RecyclerView) r102.findViewById(R.id.rv_menu_content);
        r103.setLayoutManager(new LinearLayoutManager(this.f447031a, 0, false));
        r103.addItemDecoration(new b(this.f447031a));
        this.f447035e = false;
        Intrinsics.checkNotNull(r102);
        this.f447034d = r102;
    L15:
        View r104 = this.f447034d;
        if (r104 != null) goto L18;
        return;
    L18:
        Object r105 = this.f447031a.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r106 = (WindowManager) r105;
        if (Build.VERSION.SDK_INT < 30) goto L21;
        int r107 = r106.getCurrentWindowMetrics().getBounds().width();
    L22:
        BubbleLayout r108 = (BubbleLayout) r104.findViewById(R.id.bubble_layout);
        RecyclerView r109 = (RecyclerView) r104.findViewById(R.id.rv_menu_content);
        final View r112 = r104.findViewById(R.id.iv_arrow_left_container);
        final View r113 = r104.findViewById(R.id.iv_arrow_right_container);
        TextView r114 = new TextView(this.f447031a);
        int r115 = UIUtils.dp2px(r114.getContext(), 12.0f);
        int r116 = UIUtils.dp2px(r114.getContext(), 9.0f);
        r114.setPadding(r115, r116, r115, r116);
        r114.setTextColor(ContextCompat.getColor(r114.getContext(), R.color.text_title));
        r114.setTextSize(14.0f);
        r114.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        Drawable r117 = ContextCompat.getDrawable(this.f447031a, R.drawable.menu_ocr_divider);
        if (r117 == null) goto L25;
        int r118 = r117.getIntrinsicWidth();
    L26:
        Iterator r119 = ((ArrayList) this.f447032b).iterator();
        int r120 = 0;
    L28:
        if (r119.hasNext() == false) goto L31;
        r114.setText(((c) r119.next()).f447042b);
        r114.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r120 = r120 + r114.getMeasuredWidth();
        r119 = r119;
        goto L28
    L31:
        if (((ArrayList) this.f447032b).size() <= 1) goto L33;
        r120 = r120 + (r118 * (((ArrayList) this.f447032b).size() - 1));
    L33:
        int r121 = r107 - UIUtils.dp2px(this.f447031a, 16.0f);
        int r122 = UIUtils.dp2px(this.f447031a, 32.0f) * 2;
        if (r120 <= r121) goto L36;
        boolean r123 = true;
    L37:
        if (r123 == false) goto L39;
        r109.getLayoutParams().width = r121 - r122;
        r113.setVisibility(0);
        r112.setVisibility(0);
        r109.clearOnScrollListeners();
        r109.addOnScrollListener(new SelectionMenu$show$2(r112, r113));
        r109.post(new d(r112, r113));
    L40:
        r112.setOnClickListener(new e(r109));
        r113.setOnClickListener(new f(r109));
        r109.setAdapter(new MenuAdapter(this.f447032b, r121 - r122, new SelectionMenu$show$6(this)));
        r104.measure(View.MeasureSpec.makeMeasureSpec(r121, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r124 = r104.getMeasuredWidth();
        int r125 = r104.getMeasuredHeight();
        int r126 = UIUtils.dp2px(this.f447031a, 8.0f);
        int r127 = RangesKt.coerceIn(((r111.left + r210.right) / 2) - (r124 / 2), r126, RangesKt.coerceAtLeast((r107 - r124) - r126, r126));
        int r128 = (r111.top - r125) - this.f447036f;
        if (r128 >= 0) goto L43;
        r128 = r210.bottom;
    L43:
        Pair r129 = new Pair(Integer.valueOf(r127), Integer.valueOf(r128));
        int r130 = ((Number) r129.component1()).intValue();
        int r131 = ((Number) r129.component2()).intValue();
        PopupWindow r132 = this.f447033c;
        if (r132 != null) goto L46;
        PopupWindow r133 = new PopupWindow(r104, r124, r125);
        r133.setFocusable(false);
        r133.setOutsideTouchable(false);
        r133.setTouchable(true);
        r133.setBackgroundDrawable(new ColorDrawable(0));
        r133.setAnimationStyle(R.style.photo_pager_selection_menu);
        this.f447033c = r133;
    L49:
        r108.setArrowCenterX(((r111.left + r210.right) / 2) - r130);
        PopupWindow r134 = this.f447033c;
        if (r134 != null) goto L52;
        return;
    L52:
        if (PopupWindowLancet.hasSubWindowToken(r110) == false) goto L55;
        return;
    L55:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r134) == false) goto L57;
        r134.showAtLocation(r110, 0, r130, r131);
        return;
    L57:
        OverlaySource r135 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r134, r110, r135, 0, r130, r131) == true) goto L68;
        r134.showAtLocation(r110, 0, r130, r131);
        PopupWindowLancet.trackAfterShow(r134, r135, r110);
        return;
    L68:
        return;
    L46:
        r132.setWidth(r124);
        PopupWindow r136 = this.f447033c;
        if (r136 == null) goto L49;
        r136.setHeight(r125);
        goto L49
    L39:
        r109.getLayoutParams().width = -2;
        r112.setVisibility(8);
        r113.setVisibility(8);
        goto L40
    L36:
        r123 = false;
        goto L37
    L25:
        r118 = 0;
        goto L26
    L21:
        DisplayMetrics r137 = new DisplayMetrics();
        r106.getDefaultDisplay().getMetrics(r137);
        r107 = r137.widthPixels;
        goto L22
    L13:
        if (this.f447035e == false) goto L15;
    L5:
        r101 = false;
        goto L6
    }
}
