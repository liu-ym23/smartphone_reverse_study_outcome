package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f382714c = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f382715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f382716b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<RecyclerView> f382717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Callback f382718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f382719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f382720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f382721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f382722f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f382723g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ListViewHolder.b f382724h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f382725i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f382726j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C4566a f382727k;

        /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.list.b$a$a, reason: collision with other inner class name */
        public class C4566a extends RecyclerView.SimpleOnItemTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f382728a;

            public C4566a(a r100) {
                this.f382728a = r100;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
                this.f382728a.f382725i = false;
                return false;
            }
        }

        public final void a() {
            RecyclerView r100 = this.f382717a.get();
            if (r100 != null) goto L5;
        L159:
            b();
            return;
        L5:
            if (r100.getLayoutManager() == null) goto L159;
            if (r100.getChildCount() == 0) goto L159;
            boolean r101 = true;
            if (this.f382725i == true) goto L13;
            this.f382718b.invoke(new Object[]{0});
            b();
            return;
        L13:
            int r102 = Math.min(this.f382719c, r100.getLayoutManager().getItemCount() - 1);
            this.f382719c = r102;
            this.f382719c = Math.max(r102, 0);
            int r103 = r100.getChildCount();
            int r104 = 0;
        L15:
            if (r104 >= r103) goto L22;
            ListViewHolder.b r105 = (ListViewHolder.b) r100.getChildAt(r104);
            if (r105.f382622a == 3) goto L21;
            if (((ListViewHolder) r100.getChildViewHolder(r105)).f382620a.f382623b == null) goto L21;
            boolean r106 = false;
        L23:
            if (r106 == false) goto L155;
            RecyclerView.LayoutManager r107 = r100.getLayoutManager();
            int r108 = r100.getChildCount();
            this.f382722f = r107.getItemCount();
            this.f382723g = 0;
            int r109 = 0;
        L26:
            if (r109 >= r108) goto L32;
            ListViewHolder.b r110 = (ListViewHolder.b) r100.getChildAt(r109);
            int r111 = ((RecyclerView.LayoutParams) r110.getLayoutParams()).getViewLayoutPosition();
            this.f382723g = Math.max(r111, this.f382723g);
            this.f382722f = Math.min(r111, this.f382722f);
            if (r111 == this.f382719c) goto L29;
            r109 = r109 + 1;
            goto L26
        L29:
            this.f382724h = r110;
        L32:
            if (this.f382724h != null) goto L58;
            int r112 = this.f382722f;
            int r113 = this.f382719c;
            if (r112 <= r113) goto L36;
            int r114 = -1;
        L37:
            int r115 = this.f382723g;
            int r116 = (r115 - r112) + 1;
            if (r114 != (-1)) goto L40;
            int r117 = r112 - r113;
        L42:
            if (this.f382726j == false) goto L44;
            int r118 = r100.getHeight();
        L45:
            int r119 = (r117 * r118) / r116;
            if (r117 > 30) goto L48;
        L50:
            boolean r120 = false;
        L51:
            if (r120 == false) goto L57;
            int r121 = this.f382722f;
            int r122 = this.f382719c;
            if (r121 > r122) goto L56;
            r121 = this.f382723g;
        L56:
            r100.scrollToPosition(((r121 - r122) / 2) + r122);
            goto L155
        L57:
            int r123 = Math.min(r118, b.f382714c * r117) * r114;
        L100:
            boolean r124 = this.f382726j;
            if (r123 == 0) goto L147;
            if (r123 <= 0) goto L105;
            byte r125 = 1;
        L106:
            RecyclerView.LayoutManager r126 = r100.getLayoutManager();
            int r127 = r100.getChildCount();
            if (r100.findViewHolderForLayoutPosition(0) == null) goto L109;
            boolean r128 = true;
        L111:
            if (r100.findViewHolderForLayoutPosition(r126.getItemCount() - 1) == null) goto L113;
            boolean r129 = true;
        L114:
            if (r128 == false) goto L116;
            if ((-1) != r125) goto L116;
        L118:
            int r130 = Integer.MAX_VALUE;
            int r131 = Integer.MIN_VALUE;
            int r132 = 0;
        L119:
            if (r132 >= r127) goto L129;
            View r133 = r100.getChildAt(r132);
            if (r124 == false) goto L123;
            int r134 = Math.min(r126.getDecoratedTop(r133), r130);
        L124:
            r130 = r134;
            if (r124 == false) goto L127;
            int r135 = Math.max(r126.getDecoratedBottom(r133), r131);
        L128:
            r131 = r135;
            r132 = r132 + 1;
            goto L119
        L127:
            r135 = Math.max(r126.getDecoratedRight(r133), r131);
            goto L128
        L123:
            r134 = Math.min(r126.getDecoratedLeft(r133), r130);
            goto L124
        L129:
            if (r124 == false) goto L131;
            int r136 = r126.getPaddingTop();
        L132:
            if (r124 == false) goto L134;
            int r137 = r126.getHeight();
            int r138 = r126.getPaddingBottom();
        L135:
            int r139 = r137 - r138;
            if (r128 == false) goto L140;
            if ((-1) != r125) goto L140;
            if (r130 < r136) goto L145;
        L144:
            boolean r140 = false;
        L146:
            if (r140 == false) goto L147;
            if (r124 == false) goto L150;
            char r141 = 0;
            r100.scrollBy(0, r123);
        L151:
            boolean r142 = true;
        L152:
            if (r142 == true) goto L154;
            Callback r143 = this.f382718b;
            Object[] r144 = new Object[2];
            r144[r141] = 4;
            r144[1] = "can not scroll when come to border";
            r143.invoke(r144);
        L154:
            r101 = r142;
            goto L155
        L150:
            r141 = 0;
            r100.scrollBy(r123, 0);
        L145:
            r140 = true;
        L140:
            if (r129 == false) goto L145;
            if (1 != r125) goto L145;
            if (r131 <= r139) goto L144;
        L134:
            r137 = r126.getWidth();
            r138 = r126.getPaddingRight();
            goto L135
        L131:
            r136 = r126.getPaddingLeft();
        L116:
            if (r129 == false) goto L145;
            if (1 != r125) goto L145;
        L113:
            r129 = false;
            goto L114
        L109:
            r128 = false;
            goto L111
        L105:
            r125 = -1;
        L147:
            r141 = 0;
            r142 = false;
            goto L152
        L48:
            if (r119 <= (r118 * 10)) goto L50;
            r120 = true;
            goto L51
        L44:
            r118 = r100.getWidth();
            goto L45
        L40:
            r117 = r113 - r115;
            goto L42
        L36:
            r114 = 1;
            goto L37
        L58:
            RecyclerView.LayoutManager r145 = r100.getLayoutManager();
            if (this.f382726j == false) goto L61;
            int r146 = r145.getDecoratedTop(this.f382724h);
        L63:
            if (this.f382726j == false) goto L65;
            int r147 = r145.getDecoratedMeasuredHeight(this.f382724h);
        L67:
            if (this.f382726j == false) goto L69;
            int r148 = r145.getHeight();
        L71:
            if (this.f382726j == false) goto L73;
            int r149 = r145.getPaddingTop();
        L75:
            if (this.f382726j == false) goto L77;
            int r150 = r145.getPaddingBottom();
        L78:
            int r151 = (r148 - r149) - r150;
            if (TextUtils.equals(this.f382720d, "middle") == false) goto L82;
            int r152 = (this.f382721e + r149) + ((r151 - r147) / 2);
        L85:
            int r153 = r146 - r152;
            if (r153 != 0) goto L88;
            this.f382718b.invoke(new Object[]{0});
        L99:
            r101 = false;
            goto L155
        L88:
            r123 = Math.min(Math.max(Math.abs(r153) / 3, 1), b.f382714c);
            if (r153 > 0) goto L93;
            r123 = -r123;
        L93:
            if (this.f382726j == false) goto L95;
            int r154 = this.f382724h.getHeight();
        L96:
            if (r154 != 0) goto L100;
            if (r123 != 1) goto L100;
            this.f382718b.invoke(new Object[]{0});
            goto L99
        L95:
            r154 = this.f382724h.getWidth();
            goto L96
        L82:
            if (TextUtils.equals(this.f382720d, "bottom") == false) goto L84;
            r152 = ((this.f382721e + r149) + r151) - r147;
            goto L85
        L84:
            r152 = this.f382721e + r149;
            goto L85
        L77:
            r150 = r145.getPaddingRight();
            goto L78
        L73:
            r149 = r145.getPaddingLeft();
            goto L75
        L69:
            r148 = r145.getWidth();
            goto L71
        L65:
            r147 = r145.getDecoratedMeasuredWidth(this.f382724h);
            goto L67
        L61:
            r146 = r145.getDecoratedLeft(this.f382724h);
        L155:
            if (r101 == false) goto L157;
            r100.post(this);
            return;
        L157:
            b();
            return;
        L21:
            r104 = r104 + 1;
            goto L15
        L22:
            r106 = true;
            goto L23
        }

        public final void b() {
            LLog.i("UIList", "ListScroller stop");
            RecyclerView r100 = this.f382717a.get();
            this.f382725i = false;
            if (r100 == null) goto L6;
            r100.removeOnItemTouchListener(this.f382727k);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(RecyclerView r100) {
            this.f382726j = true;
            this.f382727k = new C4566a(this);
            this.f382717a = new WeakReference(r100);
            this.f382718b = null;
            this.f382724h = null;
            this.f382725i = false;
        }
    }

    public b(Context r100, RecyclerView r101) {
        Resources r102 = r100.getResources();
        f382714c = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).densityDpi / 4;
        this.f382715a = r101;
        this.f382716b = new a(this.f382715a);
    }

    public final void a(int r100, int r101, Callback r102) {
        LLog.i("UIList", "ListScroller scrollToPositionNoSmooth: position=" + r100 + ", offset=" + r101);
        a r103 = this.f382716b;
        if (r103 != null) goto L5;
    L10:
        RecyclerView r104 = this.f382715a;
        if (r104 == null) goto L13;
        r104.stopScroll();
        this.f382715a.stopNestedScroll();
    L13:
        RecyclerView.LayoutManager r105 = this.f382715a.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L17;
        ((LinearLayoutManager) r105).scrollToPositionWithOffset(r100, r101);
    L19:
        if (r102 == null) goto L23;
        r102.invoke(new Object[]{0});
        return;
    L23:
        return;
    L17:
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L19;
        ((StaggeredGridLayoutManager) r105).scrollToPositionWithOffset(r100, r101);
        goto L19
    L5:
        if (r103.f382725i == false) goto L10;
        LLog.e("UIList", "ListScroller scrollToPositionSmoothly is scrolling ");
        if (r102 == null) goto L22;
        r102.invoke(new Object[]{1, "dumplicated, scrollToPositionSmoothly is working"});
        return;
    }
}
