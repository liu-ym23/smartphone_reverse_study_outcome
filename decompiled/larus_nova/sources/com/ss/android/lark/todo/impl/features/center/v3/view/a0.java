package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f441989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f441990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f441991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f441992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f441993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.ViewHolder f441994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StickyLinearLayoutManager.a f441995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f441996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RecyclerView f441997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f441998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f441999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f442000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f442001m;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f442002a;

        public a(a0 r100) {
            this.f442002a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = this.f442002a.f441997i.getVisibility();
            View r101 = this.f442002a.f441993e;
            if (r101 == null) goto L6;
            r101.setVisibility(r100);
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f442003a;

        public c(a0 r100) {
            this.f442003a = r100;
        }

        public final void a() {
            a0 r100 = this.f442003a;
            if (r100.f441999k == (-1)) goto L45;
            View r101 = r100.f441993e;
            if (r101 == null) goto L46;
            Object r102 = null;
            if (r100.f441990b != 1) goto L11;
            if (Intrinsics.areEqual(Float.valueOf(r101.getTranslationY()), Float.valueOf(0.0f)) == false) goto L11;
        L18:
            View r103 = r100.f441993e;
            if (r103 == null) goto L21;
            r102 = r103.getTag();
        L21:
            if (r102 != null) goto L53;
            View r104 = r100.f441993e;
            if (r104 == null) goto L26;
            r104.setTag(Boolean.TRUE);
        L26:
            View r105 = r100.f441993e;
            if (r105 == null) goto L47;
            ViewPropertyAnimator r106 = r105.animate();
            if (r106 == null) goto L48;
            r106.z(r100.f441999k);
            return;
        L48:
            return;
        L47:
            return;
        L53:
            return;
        L11:
            if (r100.f441990b != 0) goto L31;
            View r107 = r100.f441993e;
            if (r107 == null) goto L15;
            Object r108 = Float.valueOf(r107.getTranslationX());
        L17:
            if (Intrinsics.areEqual(r108, Float.valueOf(0.0f)) == false) goto L31;
        L15:
            r108 = 0;
        L31:
            View r109 = r100.f441993e;
            if (r109 == null) goto L34;
            Object r110 = r109.getTag();
        L35:
            if (r110 == null) goto L50;
            View r111 = r100.f441993e;
            if (r111 == null) goto L39;
            r111.setTag(null);
        L39:
            View r112 = r100.f441993e;
            if (r112 == null) goto L51;
            ViewPropertyAnimator r113 = r112.animate();
            if (r113 == null) goto L52;
            r113.z(0.0f);
            return;
        L52:
            return;
        L51:
            return;
        L50:
            return;
        L34:
            r110 = null;
            goto L35
        L46:
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
    }

    static {
    }

    public a0(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        boolean r101 = true;
        this.f441990b = 1;
        this.f441991c = -1;
        this.f441999k = -1;
        this.f442000l = -1;
        this.f442001m = y9c.d.a(20);
        this.f441997i = r100;
        if (r100.getPaddingLeft() < 0) goto L5;
    L10:
        this.f441996h = r101;
        this.f441998j = new a(this);
        return;
    L5:
        if (r100.getPaddingRight() >= 0) goto L10;
        if (r100.getPaddingTop() > 0) goto L10;
        r101 = false;
        goto L10
    }

    public final void a(Map<Integer, ? extends View> r100) {
        View r101 = this.f441993e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L16;
        View r103 = this.f441993e;
        if (r103 == null) goto L16;
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new d0(r103, this, r100));
    L16:
        Iterator<Map.Entry<Integer, ? extends View>> r104 = r100.entrySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L82;
        Map.Entry<Integer, ? extends View> r105 = r104.next();
        if (r105.getKey().intValue() <= this.f441991c) goto L18;
        View r106 = r105.getValue();
        if (this.f441990b != 1) goto L31;
        float r107 = r106.getY();
        View r108 = this.f441993e;
        if (r108 == null) goto L26;
        int r109 = r108.getHeight();
    L28:
        if (r107 >= r109) goto L30;
    L29:
        boolean r110 = true;
    L39:
        if (this.f441990b != 1) goto L48;
        float r111 = r106.getY();
        View r112 = this.f441993e;
        if (r112 == null) goto L43;
        int r113 = r112.getHeight();
    L45:
        if (r111 >= (r113 + this.f442001m)) goto L47;
    L46:
        boolean r114 = true;
    L55:
        if (r114 == false) goto L60;
        StickyLinearLayoutManager.a r115 = this.f441995g;
        if (r115 == null) goto L60;
        r115.a(this.f441994f);
    L60:
        if (r110 == true) goto L62;
        float r116 = -1.0f;
    L79:
        if (r116 == (-1.0f)) goto L82;
        boolean r117 = false;
    L83:
        if (r117 == true) goto L85;
    L92:
        View r118 = this.f441993e;
        if (r118 == null) goto L99;
        r118.setVisibility(0);
        return;
    L99:
        return;
    L85:
        if (this.f441990b != 1) goto L89;
        View r119 = this.f441993e;
        if (r119 == null) goto L92;
        r119.setTranslationY(0.0f);
        goto L92
    L89:
        View r120 = this.f441993e;
        if (r120 == null) goto L92;
        r120.setTranslationX(0.0f);
        goto L92
    L62:
        if (this.f441990b != 1) goto L70;
        View r121 = this.f441993e;
        if (r121 == null) goto L66;
        int r122 = r121.getHeight();
    L67:
        r116 = -(r122 - r106.getY());
        View r123 = this.f441993e;
        if (r123 == null) goto L79;
        r123.setTranslationY(r116);
        goto L79
    L66:
        r122 = 0;
        goto L67
    L70:
        View r124 = this.f441993e;
        if (r124 == null) goto L73;
        int r125 = r124.getWidth();
    L74:
        r116 = -(r125 - r106.getX());
        View r126 = this.f441993e;
        if (r126 == null) goto L79;
        r126.setTranslationX(r116);
        goto L79
    L73:
        r125 = 0;
    L47:
        r114 = false;
        goto L55
    L43:
        r113 = 0;
        goto L45
    L48:
        float r127 = r106.getX();
        View r128 = this.f441993e;
        if (r128 == null) goto L51;
        int r129 = r128.getWidth();
    L53:
        if (r127 >= (r129 + this.f442001m)) goto L47;
    L51:
        r129 = 0;
    L30:
        r110 = false;
        goto L39
    L26:
        r109 = 0;
        goto L28
    L31:
        float r130 = r106.getX();
        View r131 = this.f441993e;
        if (r131 == null) goto L34;
        int r132 = r131.getWidth();
    L36:
        if (r130 >= r132) goto L30;
    L34:
        r132 = 0;
    L82:
        r117 = true;
        goto L83
    L8:
        if (r101.getHeight() != 0) goto L10;
        r102 = true;
        goto L11
    }

    public final void b(int r100) {
        if (this.f441993e == null) goto L9;
        ViewParent r101 = this.f441997i.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r101).removeView(this.f441993e);
        StickyLinearLayoutManager.a r102 = this.f441995g;
        if (r102 == null) goto L7;
        r102.b();
    L7:
        this.f441997i.getViewTreeObserver().removeOnGlobalLayoutListener(this.f441998j);
        this.f441993e = null;
        this.f441994f = null;
        return;
    }

    public final boolean c(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f441990b != 1) goto L10;
        if (r100.getY() <= 0.0f) goto L14;
    L11:
        return true;
    L14:
        return false;
    L10:
        if (r100.getX() > 0.0f) goto L11;
        return false;
    }

    public final void d(int r100, Map<Integer, ? extends View> r101, e1 r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "visibleHeaders");
        if (r110 == false) goto L5;
        int r111 = -1;
    L29:
        View r103 = (View) ((LinkedHashMap) r101).get(Integer.valueOf(r111));
        if (r111 == this.f441991c) goto L122;
        if (r111 != (-1)) goto L34;
    L120:
        this.f441992d = true;
        int r104 = this.f441991c;
        ViewParent r105 = this.f441997i.getParent();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r105).post(new c0(this, r104));
        this.f441991c = -1;
    L126:
        a(r101);
        this.f441997i.post(new c(this));
        return;
    L34:
        if (this.f441996h == true) goto L36;
    L38:
        this.f441991c = r111;
        ViewGroup r106 = null;
        if (r102 == null) goto L52;
        RecyclerView.Adapter r107 = r102.f442022a.getAdapter();
        if (r107 == null) goto L43;
        int r108 = r107.getItemViewType(r111);
    L45:
        if (r102.f442023b == r108) goto L51;
        r102.f442023b = r108;
        RecyclerView.Adapter r109 = r102.f442022a.getAdapter();
        if (r109 == null) goto L49;
        ViewParent r112 = r102.f442022a.getParent();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.view.ViewGroup");
        RecyclerView.ViewHolder r113 = r109.createViewHolder((ViewGroup) r112, r102.f442023b);
    L50:
        r102.f442024c = r113;
        goto L51
    L49:
        r113 = null;
    L51:
        RecyclerView.ViewHolder r114 = r102.f442024c;
    L53:
        if (r114 == null) goto L126;
        if (Intrinsics.areEqual(this.f441994f, r114) == false) goto L77;
        StickyLinearLayoutManager.a r115 = this.f441995g;
        if (r115 == null) goto L59;
        r115.b();
    L59:
        RecyclerView.ViewHolder r116 = this.f441994f;
        if (r116 == null) goto L64;
        RecyclerView.Adapter r117 = this.f441997i.getAdapter();
        if (r117 == null) goto L64;
        r117.onBindViewHolder(r116, r111);
    L64:
        RecyclerView.ViewHolder r118 = this.f441994f;
        if (r118 == null) goto L69;
        View r119 = r118.itemView;
        if (r119 == null) goto L69;
        r119.requestLayout();
    L69:
        View r120 = this.f441993e;
        if (r120 == null) goto L73;
        r120.getViewTreeObserver().addOnGlobalLayoutListener(new b0(this, r120));
    L73:
        StickyLinearLayoutManager.a r121 = this.f441995g;
        if (r121 == null) goto L76;
        r121.c();
    L76:
        this.f441992d = false;
        goto L126
    L77:
        b(this.f441991c);
        this.f441994f = r114;
        RecyclerView.Adapter r122 = this.f441997i.getAdapter();
        if (r122 == null) goto L80;
        r122.onBindViewHolder(r114, r111);
    L80:
        RecyclerView.ViewHolder r123 = this.f441994f;
        if (r123 == null) goto L83;
        View r124 = r123.itemView;
    L84:
        this.f441993e = r124;
        StickyLinearLayoutManager.a r125 = this.f441995g;
        if (r125 == null) goto L87;
        r125.c();
    L87:
        View r126 = this.f441993e;
        if (r126 == null) goto L94;
        Context r127 = r126.getContext();
        int r128 = this.f442000l;
        if (r128 == (-1)) goto L94;
        if (this.f441999k != (-1)) goto L94;
        this.f441999k = y9c.d.b(r127, r128);
    L94:
        View r129 = this.f441993e;
        if (r129 == null) goto L97;
        r129.setVisibility(4);
    L97:
        this.f441997i.getViewTreeObserver().addOnGlobalLayoutListener(this.f441998j);
        ViewParent r130 = this.f441997i.getParent();
        if ((r130 instanceof ViewGroup) == false) goto L100;
        r106 = (ViewGroup) r130;
    L100:
        if (r106 == null) goto L103;
        r106.addView(this.f441993e);
    L103:
        if (this.f441996h == false) goto L119;
        View r131 = this.f441993e;
        if (r131 == null) goto L119;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
        if (this.f441990b != 1) goto L109;
        int r134 = this.f441997i.getPaddingLeft();
    L111:
        if (this.f441990b != 1) goto L113;
        int r135 = 0;
    L115:
        if (this.f441990b != 1) goto L117;
        int r136 = this.f441997i.getPaddingRight();
    L118:
        r133.setMargins(r134, r135, r136, 0);
        goto L119
    L117:
        r136 = 0;
        goto L118
    L113:
        r135 = this.f441997i.getPaddingTop();
        goto L115
    L109:
        r134 = 0;
    L119:
        this.f441992d = false;
        goto L126
    L83:
        r124 = null;
        goto L84
    L43:
        r108 = -1;
        goto L45
    L52:
        r114 = null;
        goto L53
    L36:
        if (c(r103) == false) goto L38;
    L122:
        if (this.f441996h == false) goto L126;
        if (c(r103) == false) goto L126;
        b(this.f441991c);
        this.f441991c = -1;
        goto L126
    L5:
        if (c((View) ((LinkedHashMap) r101).get(Integer.valueOf(r100))) == false) goto L18;
        List<Integer> r137 = this.f441989a;
        if (r137 == null) goto L18;
        int r138 = r137.indexOf(Integer.valueOf(r100)) - 1;
        if (r138 >= 0) goto L11;
    L13:
        boolean r139 = false;
    L14:
        if (r139 == false) goto L16;
        Object r140 = ListProtector.get(r137, r138);
    L17:
        r111 = ((Number) r140).intValue();
    L19:
        if (r111 != (-1)) goto L29;
        List<Integer> r141 = this.f441989a;
        if (r141 == null) goto L29;
        Iterator<Integer> r142 = r141.iterator();
    L24:
        if (r142.hasNext() == false) goto L29;
        int r143 = r142.next().intValue();
        if (r143 > r100) goto L29;
        r111 = r143;
        goto L24
    L16:
        r140 = -1;
        goto L17
    L11:
        if (r138 >= r137.size()) goto L13;
        r139 = true;
    L18:
        r111 = -1;
        goto L19
    }
}
