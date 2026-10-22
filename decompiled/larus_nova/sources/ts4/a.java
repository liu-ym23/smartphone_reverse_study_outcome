package ts4;

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

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f547375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f547376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f547377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f547378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f547379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.ViewHolder f547380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f547381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RecyclerView f547382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC7766a f547383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f547384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f547385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f547386l;

    /* JADX INFO: renamed from: ts4.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC7766a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f547387a;

        public ViewTreeObserverOnGlobalLayoutListenerC7766a(a r100) {
            this.f547387a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = this.f547387a.f547382h.getVisibility();
            View r101 = this.f547387a.f547379e;
            if (r101 == null) goto L6;
            r101.setVisibility(r100);
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f547388a;

        public c(a r100) {
            this.f547388a = r100;
        }

        public final void a() {
            a r100 = this.f547388a;
            if (r100.f547384j == (-1)) goto L45;
            View r101 = r100.f547379e;
            if (r101 == null) goto L46;
            Object r102 = null;
            if (r100.f547376b != 1) goto L11;
            if (Intrinsics.areEqual(Float.valueOf(r101.getTranslationY()), Float.valueOf(0.0f)) == false) goto L11;
        L18:
            View r103 = r100.f547379e;
            if (r103 == null) goto L21;
            r102 = r103.getTag();
        L21:
            if (r102 != null) goto L53;
            View r104 = r100.f547379e;
            if (r104 == null) goto L26;
            r104.setTag(Boolean.TRUE);
        L26:
            View r105 = r100.f547379e;
            if (r105 == null) goto L47;
            ViewPropertyAnimator r106 = r105.animate();
            if (r106 == null) goto L48;
            r106.z(r100.f547384j);
            return;
        L48:
            return;
        L47:
            return;
        L53:
            return;
        L11:
            if (r100.f547376b != 0) goto L31;
            View r107 = r100.f547379e;
            if (r107 == null) goto L15;
            Object r108 = Float.valueOf(r107.getTranslationX());
        L17:
            if (Intrinsics.areEqual(r108, Float.valueOf(0.0f)) == false) goto L31;
        L15:
            r108 = 0;
        L31:
            View r109 = r100.f547379e;
            if (r109 == null) goto L34;
            Object r110 = r109.getTag();
        L35:
            if (r110 == null) goto L50;
            View r111 = r100.f547379e;
            if (r111 == null) goto L39;
            r111.setTag(null);
        L39:
            View r112 = r100.f547379e;
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

    public final void b() {
        if (this.f547379e == null) goto L6;
        ViewParent r100 = this.f547382h.getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r100).removeView(this.f547379e);
        this.f547382h.getViewTreeObserver().removeOnGlobalLayoutListener(this.f547383i);
        this.f547379e = null;
        this.f547380f = null;
        return;
    }

    public a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        boolean r101 = true;
        this.f547376b = 1;
        this.f547377c = -1;
        this.f547384j = -1;
        this.f547385k = -1;
        this.f547386l = y9c.d.a(20);
        this.f547382h = r100;
        if (r100.getPaddingLeft() < 0) goto L5;
    L10:
        this.f547381g = r101;
        this.f547383i = new ViewTreeObserverOnGlobalLayoutListenerC7766a(this);
        return;
    L5:
        if (r100.getPaddingRight() >= 0) goto L10;
        if (r100.getPaddingTop() > 0) goto L10;
        r101 = false;
        goto L10
    }

    public final void a(Map<Integer, ? extends View> r100) {
        View r101 = this.f547379e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L16;
        View r103 = this.f547379e;
        if (r103 == null) goto L16;
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new d(r103, this, r100));
    L16:
        Iterator<Map.Entry<Integer, ? extends View>> r104 = r100.entrySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L78;
        Map.Entry<Integer, ? extends View> r105 = r104.next();
        if (r105.getKey().intValue() <= this.f547377c) goto L18;
        View r106 = r105.getValue();
        if (this.f547376b != 1) goto L31;
        float r107 = r106.getY();
        View r108 = this.f547379e;
        if (r108 == null) goto L26;
        int r109 = r108.getHeight();
    L28:
        if (r107 >= r109) goto L30;
    L29:
        boolean r110 = true;
    L39:
        if (this.f547376b != 1) goto L48;
        float r111 = r106.getY();
        View r112 = this.f547379e;
        if (r112 == null) goto L43;
        int r113 = r112.getHeight();
    L45:
        if (r111 < (r113 + this.f547386l)) goto L56;
    L56:
        if (r110 == true) goto L58;
        float r114 = -1.0f;
    L75:
        if (r114 == (-1.0f)) goto L78;
        boolean r115 = false;
    L79:
        if (r115 == true) goto L81;
    L88:
        View r116 = this.f547379e;
        if (r116 == null) goto L95;
        r116.setVisibility(0);
        return;
    L95:
        return;
    L81:
        if (this.f547376b != 1) goto L85;
        View r117 = this.f547379e;
        if (r117 == null) goto L88;
        r117.setTranslationY(0.0f);
        goto L88
    L85:
        View r118 = this.f547379e;
        if (r118 == null) goto L88;
        r118.setTranslationX(0.0f);
        goto L88
    L58:
        if (this.f547376b != 1) goto L66;
        View r119 = this.f547379e;
        if (r119 == null) goto L62;
        int r120 = r119.getHeight();
    L63:
        r114 = -(r120 - r106.getY());
        View r121 = this.f547379e;
        if (r121 == null) goto L75;
        r121.setTranslationY(r114);
        goto L75
    L62:
        r120 = 0;
        goto L63
    L66:
        View r122 = this.f547379e;
        if (r122 == null) goto L69;
        int r123 = r122.getWidth();
    L70:
        r114 = -(r123 - r106.getX());
        View r124 = this.f547379e;
        if (r124 == null) goto L75;
        r124.setTranslationX(r114);
        goto L75
    L69:
        r123 = 0;
        goto L70
    L43:
        r113 = 0;
        goto L45
    L48:
        float r125 = r106.getX();
        View r126 = this.f547379e;
        if (r126 == null) goto L51;
        int r127 = r126.getWidth();
    L53:
        if (r125 >= (r127 + this.f547386l)) goto L56;
        goto L56
    L51:
        r127 = 0;
    L30:
        r110 = false;
        goto L39
    L26:
        r109 = 0;
        goto L28
    L31:
        float r128 = r106.getX();
        View r129 = this.f547379e;
        if (r129 == null) goto L34;
        int r130 = r129.getWidth();
    L36:
        if (r128 >= r130) goto L30;
    L34:
        r130 = 0;
    L78:
        r115 = true;
        goto L79
    L8:
        if (r101.getHeight() != 0) goto L10;
        r102 = true;
        goto L11
    }

    public final boolean c(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f547376b != 1) goto L10;
        if (r100.getY() <= 0.0f) goto L14;
    L11:
        return true;
    L14:
        return false;
    L10:
        if (r100.getX() > 0.0f) goto L11;
        return false;
    }

    public final void d(int r100, Map<Integer, ? extends View> r101, com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.b r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "visibleHeaders");
        if (r103 == false) goto L5;
        int r104 = -1;
    L29:
        View r105 = (View) ((LinkedHashMap) r101).get(Integer.valueOf(r104));
        if (r104 == this.f547377c) goto L101;
        if (r104 != (-1)) goto L33;
    L99:
        this.f547378d = true;
        int r106 = this.f547377c;
        ViewParent r107 = this.f547382h.getParent();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r107).post(new ts4.c(this, r106));
        this.f547377c = -1;
    L105:
        a(r101);
        this.f547382h.post(new c(this));
        return;
    L33:
        if (this.f547381g == true) goto L35;
    L37:
        this.f547377c = r104;
        ViewGroup r108 = null;
        if (r102 == null) goto L40;
        RecyclerView.ViewHolder r109 = r102.a(r104);
    L41:
        if (r109 == null) goto L105;
        if (Intrinsics.areEqual(this.f547380f, r109) == false) goto L59;
        RecyclerView.ViewHolder r110 = this.f547380f;
        if (r110 == null) goto L49;
        RecyclerView.Adapter r111 = this.f547382h.getAdapter();
        if (r111 == null) goto L49;
        r111.onBindViewHolder(r110, r104);
    L49:
        RecyclerView.ViewHolder r112 = this.f547380f;
        if (r112 == null) goto L54;
        View r113 = r112.itemView;
        if (r113 == null) goto L54;
        r113.requestLayout();
    L54:
        View r114 = this.f547379e;
        if (r114 == null) goto L58;
        r114.getViewTreeObserver().addOnGlobalLayoutListener(new ts4.b(this, r114));
    L58:
        this.f547378d = false;
        goto L105
    L59:
        b();
        this.f547380f = r109;
        RecyclerView.Adapter r115 = this.f547382h.getAdapter();
        if (r115 == null) goto L62;
        r115.onBindViewHolder(r109, r104);
    L62:
        RecyclerView.ViewHolder r116 = this.f547380f;
        if (r116 == null) goto L65;
        View r117 = r116.itemView;
    L66:
        this.f547379e = r117;
        if (r117 == null) goto L73;
        Context r118 = r117.getContext();
        int r119 = this.f547385k;
        if (r119 == (-1)) goto L73;
        if (this.f547384j != (-1)) goto L73;
        this.f547384j = y9c.d.b(r118, r119);
    L73:
        View r120 = this.f547379e;
        if (r120 == null) goto L76;
        r120.setVisibility(4);
    L76:
        this.f547382h.getViewTreeObserver().addOnGlobalLayoutListener(this.f547383i);
        ViewParent r121 = this.f547382h.getParent();
        if ((r121 instanceof ViewGroup) == false) goto L79;
        r108 = (ViewGroup) r121;
    L79:
        if (r108 == null) goto L82;
        r108.addView(this.f547379e);
    L82:
        if (this.f547381g == false) goto L98;
        View r122 = this.f547379e;
        if (r122 == null) goto L98;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (this.f547376b != 1) goto L88;
        int r125 = this.f547382h.getPaddingLeft();
    L90:
        if (this.f547376b != 1) goto L92;
        int r126 = 0;
    L94:
        if (this.f547376b != 1) goto L96;
        int r127 = this.f547382h.getPaddingRight();
    L97:
        r124.setMargins(r125, r126, r127, 0);
        goto L98
    L96:
        r127 = 0;
        goto L97
    L92:
        r126 = this.f547382h.getPaddingTop();
        goto L94
    L88:
        r125 = 0;
    L98:
        this.f547378d = false;
        goto L105
    L65:
        r117 = null;
        goto L66
    L40:
        r109 = null;
        goto L41
    L35:
        if (c(r105) == false) goto L37;
    L101:
        if (this.f547381g == false) goto L105;
        if (c(r105) == false) goto L105;
        b();
        this.f547377c = -1;
        goto L105
    L5:
        if (c((View) ((LinkedHashMap) r101).get(Integer.valueOf(r100))) == false) goto L18;
        List<Integer> r128 = this.f547375a;
        if (r128 == null) goto L18;
        int r129 = r128.indexOf(Integer.valueOf(r100)) - 1;
        if (r129 >= 0) goto L11;
    L13:
        boolean r130 = false;
    L14:
        if (r130 == false) goto L16;
        Object r131 = ListProtector.get(r128, r129);
    L17:
        r104 = ((Number) r131).intValue();
    L19:
        if (r104 != (-1)) goto L29;
        List<Integer> r132 = this.f547375a;
        if (r132 == null) goto L29;
        Iterator<Integer> r133 = r132.iterator();
    L24:
        if (r133.hasNext() == false) goto L29;
        int r134 = r133.next().intValue();
        if (r134 > r100) goto L29;
        r104 = r134;
        goto L24
    L16:
        r131 = -1;
        goto L17
    L11:
        if (r129 >= r128.size()) goto L13;
        r130 = true;
    L18:
        r104 = -1;
        goto L19
    }
}
