package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import mz3.e;
import mz3.f;
import mz3.g;
import mz3.h;
import mz3.i;
import mz3.j;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\r\u0017\u0018\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout;", "Landroid/widget/RelativeLayout;", "", "getScrollXDistance", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$b;", "listener", "", "setGalleryLayoutListener", "", "Lr14/y;", "list", "setData", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ThumbnailAdapter", "ThumbnailViewHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GalleryLayout extends RelativeLayout {
    public static int C;
    public View A;
    public b B;
    public final Context a;
    public final GalleryRecyclerView b;
    public final LinearLayoutManager c;
    public final AoImageView d;
    public final View e;
    public final DmtTextView f;
    public final View g;
    public final DmtTextView h;
    public final ThumbnailAdapter i;
    public View j;
    public int k;
    public float l;
    public float m;
    public Function1<? super c, Unit> n;
    public boolean o;
    public int p;
    public Boolean q;
    public ValueAnimator r;
    public View s;
    public ValueAnimator t;
    public View u;
    public ValueAnimator v;
    public View w;
    public ValueAnimator x;
    public View y;
    public View z;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailViewHolder;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailViewHolder> implements View.OnClickListener {
        public final List<y> a;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public ThumbnailAdapter() {
            this.a = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            ThumbnailViewHolder r10 = (ThumbnailViewHolder) r8;
            Intrinsics.checkNotNullParameter(r10, "holder");
            y r0 = (y) ListProtector.get(this.a, r9);
            AoImageView r1 = r10.a;
            if (r0 == null) goto L5;
            List r2 = r0.c();
        L6:
            com.bytedance.awemeopen.infra.base.image.b r3 = new com.bytedance.awemeopen.infra.base.image.b(r2);
            Resources r4 = Resources.getSystem();
            int r5 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
            Resources r6 = Resources.getSystem();
            int r7 = MathKt.roundToInt(TypedValue.applyDimension(1, 42, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
            r3.n = r5;
            r3.o = r7;
            Resources r11 = Resources.getSystem();
            r3.s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
            r3.b(2131231443);
            r3.m = ImageView.ScaleType.CENTER_CROP;
            r1.j(r3);
            ((RecyclerView.ViewHolder) r10).itemView.setTag(Integer.valueOf(r9));
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131558629, r3, false);
            r5.setOnClickListener(this);
            return new ThumbnailViewHolder(r5);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ThumbnailViewHolder extends RecyclerView.ViewHolder {
        public final AoImageView a;

        public ThumbnailViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131373411);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c {
        public final int a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r0 = this.a * 31;
            boolean r1 = this.b;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.c;
            if (r5 == true) goto L10;
            r2 = r5;
        L10:
            return r4 + r2;
        }

        public final String toString() {
            return "SelectResult(position=" + this.a + ", outOfBounds=" + this.b + ", isFullScreenSlides=" + this.c + ')';
        }

        public c(int r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ GalleryLayout a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            GalleryLayout r0 = this.a;
            r0.A = r0.c.findViewByPosition(r0.k);
            GalleryLayout r1 = this.a;
            View r2 = r1.A;
            View r3 = null;
            if ((r2 instanceof ViewGroup) == false) goto L5;
            ViewGroup r4 = (ViewGroup) r2;
        L6:
            if (r4 == null) goto L8;
            r3 = r4.findViewById(2131373411);
        L8:
            r1.z = r3;
            GalleryLayout r5 = this.a;
            View r6 = r5.z;
            if (r6 == null) goto L11;
            GalleryLayout.g(r6, (int) n0.a(r5.getContext(), 44.0f));
        L11:
            GalleryLayout r7 = this.a;
            View r8 = r7.A;
            if (r8 == null) goto L14;
            GalleryLayout.g(r8, (int) n0.a(r7.getContext(), 64.0f));
        L14:
            this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            r4 = null;
            goto L6
        }

        public d(GalleryLayout r1) {
            this.a = r1;
        }
    }

    public GalleryLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GalleryLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        this.l = 0.0f;
        this.m = 0.0f;
        View r0 = this.j;
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L7:
        if (r1 == null) goto L9;
        View r2 = r1.getChildAt(0);
    L10:
        if (r2 == null) goto L12;
        r2.setBackgroundDrawable(null);
    L12:
        if (r2 == null) goto L16;
        ViewPropertyAnimator r3 = r2.animate();
        if (r3 == null) goto L16;
        r3.scaleX(1.0f);
        r3.scaleY(1.0f);
        r3.setDuration(200);
        r3.start();
    L16:
        this.j = null;
        this.k = 0;
        this.f.setText("");
        this.n = null;
        SlidesGalleryLayoutManager r4 = this.c;
        if ((r4 instanceof SlidesGalleryLayoutManager) == false) goto L19;
        SlidesGalleryLayoutManager r5 = r4;
    L20:
        if (r5 == null) goto L22;
        boolean r6 = Intrinsics.areEqual(Boolean.FALSE, Boolean.TRUE);
    L23:
        if (r6 == false) goto L37;
        SlidesGalleryLayoutManager r7 = this.c;
        boolean r8 = r7 instanceof SlidesGalleryLayoutManager;
        if (r8 == false) goto L27;
        SlidesGalleryLayoutManager r9 = r7;
    L28:
        if (r9 == null) goto L30;
        r9.b = 0;
    L30:
        if (r8 == false) goto L32;
        SlidesGalleryLayoutManager r10 = r7;
    L33:
        if (r10 == null) goto L37;
        r10.t();
        throw null;
    L32:
        r10 = null;
        goto L33
    L27:
        r9 = null;
    L37:
        this.b.removeAllViews();
        this.q = null;
        return;
    L22:
        r6 = false;
        goto L23
    L19:
        r5 = null;
        goto L20
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    static {
        C = -1;
    }

    private final int getScrollXDistance() {
        LinearLayoutManager r0 = this.c;
        if ((r0 instanceof LinearLayoutManager) == true) goto L6;
        r0 = null;
    L6:
        int r1 = 0;
        if (r0 == null) goto L9;
        int r2 = r0.findFirstVisibleItemPosition();
    L10:
        View r3 = this.c.findViewByPosition(r2);
        int r4 = ((int) n0.a(getContext(), 37.0f)) * (r2 + 1);
        if (r3 == null) goto L14;
        r1 = r3.getRight();
    L14:
        return r4 - r1;
    L9:
        r2 = 0;
        goto L10
    }

    public final boolean a() {
        Boolean r0 = this.q;
        if (r0 != null) goto L5;
        boolean r1 = false;
        if (C > 0) goto L9;
        C = (d0.d(getContext()) / ((int) n0.a(getContext(), 37.0f))) + 1;
        if (this.i.getItemCount() <= C) goto L16;
        r1 = true;
    L16:
        Boolean r2 = Boolean.valueOf(r1);
        this.q = r2;
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L9:
        if (this.i.getItemCount() <= C) goto L11;
        r1 = true;
    L11:
        Boolean r3 = Boolean.valueOf(r1);
        this.q = r3;
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L5:
        return r0.booleanValue();
    }

    public final Context getCtx() {
        return this.a;
    }

    public final void c(int r4) {
        this.k = r4;
        if (a() == true) goto L20;
        AppCompatTextView r0 = this.f;
        if (r4 != (-1)) goto L7;
        CharSequence r1 = "";
    L8:
        r0.setText(r1);
        if (this.i.getItemCount() <= 0) goto L11;
        float r2 = (r4 * 1.0f) / this.i.getItemCount();
    L12:
        float r3 = d0.d(getContext()) * r2;
        LinearLayoutManager r5 = this.c;
        if ((r5 instanceof LinearLayoutManager) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r5.scrollToPositionWithOffset(r4, (int) r3);
    L18:
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        return;
    L11:
        r2 = 0.0f;
        goto L12
    L7:
        r1 = String.valueOf(r4 + 1);
        goto L8
    }

    public final void h(int r5) {
        if (r5 > (-1)) goto L5;
        return;
    L5:
        if (this.d.getVisibility() != 0) goto L16;
        AoImageView r0 = this.d;
        com.bytedance.awemeopen.infra.base.image.b r1 = new com.bytedance.awemeopen.infra.base.image.b(((y) ListProtector.get(this.i.a, r5)).c());
        r1.b(2131231413);
        y r6 = (y) ListProtector.get(this.i.a, r5);
        ImageView.ScaleType r2 = ImageView.ScaleType.CENTER_CROP;
        if (r6 != null) goto L9;
    L13:
        r1.m = r2;
        r0.j(r1);
        return;
    L9:
        if (r6.a() <= 0) goto L13;
        if ((r6.d() / r6.a()) <= 0.5625f) goto L13;
        r2 = ImageView.ScaleType.FIT_CENTER;
        goto L13
    }

    public final void setData(List<y> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        this.o = false;
        ThumbnailAdapter r0 = this.i;
        ((ArrayList) r0.a).clear();
        if (r4 == null) goto L5;
        ArrayList r1 = (ArrayList) r0.a;
        r1.addAll(r4);
    L5:
        r0.notifyDataSetChanged();
        this.h.setText(String.valueOf(r4.size()));
    }

    public final void setGalleryLayoutListener(b r1) {
        this.B = r1;
    }

    public static void e(GalleryLayout r3, int r4) {
        View r0 = r3.c.findViewByPosition(r4);
        if (r0 == null) goto L5;
        r3.f(r0, r4, true);
        return;
    L5:
        r3.b.getViewTreeObserver().addOnGlobalLayoutListener(new j(r0, r3, r4));
    }

    public static void g(View r1, int r2) {
        if (r1 == null) goto L4;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
    L5:
        if (r0 == null) goto L8;
        r0.width = r2;
    L8:
        if (r1 == null) goto L11;
        r1.requestLayout();
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L5
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryRecyclerView] */
    public GalleryLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        new LinkedHashMap();
        super(r3, r4, r5);
        this.a = r3;
        new Handler(Looper.getMainLooper());
        RecyclerView.OnScrollListener r6 = new GalleryLayout$scrollListener$1(this);
        LayoutInflater.from(r3).inflate(2131558630, this, true);
        this.d = findViewById(2131382873);
        ?? r7 = (GalleryRecyclerView) findViewById(2131373419);
        this.b = r7;
        ?? r0 = (DmtTextView) findViewById(2131381107);
        this.f = r0;
        this.g = findViewById(2131389225);
        this.e = findViewById(2131382874);
        r0.setText("");
        this.h = (DmtTextView) findViewById(2131368025);
        final Context r1 = r7.getContext();
        new AnonymousClass1(r1);
        ThumbnailAdapter r2 = new ThumbnailAdapter();
        this.i = r2;
        r7.setAdapter(r2);
        r7.addOnScrollListener(r6);
        LinearLayoutManager r8 = new LinearLayoutManager(r3, 0, false);
        this.c = r8;
        r7.setLayoutManager(r8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d(float r8, float r9, Function1<? super c, Unit> r10) {
        this.n = r10;
        this.l = r8;
        this.m = r9;
        boolean r2 = true;
        if (a() == false) goto L25;
        int r11 = d0.d(getContext());
        if (this.o == true) goto L10;
        int r12 = (int) (((double) r11) * 0.15d);
        this.p = r12;
        this.b.setPadding(r12, 0, r12, 0);
        this.o = true;
        Function1<? super c, Unit> r13 = this.n;
        if (r13 == null) goto L9;
        r13.invoke(new c(this.k, false, true));
    L9:
        post(new mz3.c(this));
    L10:
        float r14 = this.l;
        int r15 = this.p;
        float r0 = r15;
        if (r14 >= r0) goto L13;
    L15:
        boolean r16 = false;
    L16:
        if (r16 == false) goto L18;
        float r17 = r11 * 0.7f;
        int r18 = RangesKt.coerceAtMost((int) (this.i.getItemCount() * (RangesKt.coerceAtMost(r14 - r0, r17) / r17)), this.i.getItemCount() - 1);
        if (this.k == r18) goto L50;
        this.b.scrollBy(-(getScrollXDistance() - ((int) ((n0.a(getContext(), 37.0f) * r18) - this.l))), 0);
        h(r18);
        e(this, r18);
        return;
    L50:
        return;
    L18:
        if (r14 >= r0) goto L20;
        this.b.smoothScrollToPosition(0);
        e(this, 0);
        return;
    L20:
        this.b.scrollToPosition(this.i.getItemCount() - 1);
        e(this, this.i.getItemCount() - 1);
        return;
    L13:
        if (r14 > (r11 - r15)) goto L15;
        r16 = true;
        goto L16
    L25:
        int[] r1 = new int[2];
        this.b.getLocationOnScreen(r1);
        float r19 = RangesKt.coerceIn(r8 - r1[0], 5.0f, RangesKt.coerceAtLeast(this.b.getWidth(), 5.0f));
        float[] r4 = {r19, r9 - r1[1]};
        View r20 = this.b.findChildViewUnder(r19, n0.a(getContext(), 25.0f));
        if (r20 != null) goto L28;
    L40:
        if (r20 != null) goto L51;
        Objects.toString(r20);
        if (((this.b.getHeight() * 3) + r4[1]) < 0.0f) goto L45;
        r2 = false;
    L45:
        if (r10 == null) goto L52;
        r10.invoke(new c(this.k, r2, false));
        return;
    L52:
        return;
    L51:
        return;
    L28:
        if (Intrinsics.areEqual(r20, this.j) == true) goto L40;
        View r21 = this.z;
        if (r21 == null) goto L35;
        g(r21, (int) n0.a(getContext(), 33.0f));
        View r22 = this.A;
        if (r22 == null) goto L34;
        g(r22, (int) n0.a(getContext(), 37.0f));
    L34:
        this.z = null;
        this.A = null;
    L35:
        int r23 = this.b.getChildAdapterPosition(r20);
        f(r20, r23, false);
        if (r23 <= (-1)) goto L40;
        if (this.d.getVisibility() != 0) goto L40;
        h(r23);
        goto L40
    }

    public final void f(View r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "selectItemView");
        if (Intrinsics.areEqual(r9, this.j) == true) goto L47;
        View r0 = this.j;
        View r2 = null;
        if (r0 == null) goto L7;
        Object r1 = r0.getTag(2131373410);
    L9:
        if ((r1 instanceof Long) == false) goto L11;
        Long r3 = (Long) r1;
    L12:
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
    L16:
        if (Math.abs(r4 - System.currentTimeMillis()) < 200) goto L47;
        ValueAnimator r5 = this.r;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        ValueAnimator r6 = this.t;
        if (r6 == null) goto L23;
        r6.cancel();
    L23:
        ValueAnimator r7 = this.v;
        if (r7 == null) goto L26;
        r7.cancel();
    L26:
        ValueAnimator r8 = this.x;
        if (r8 == null) goto L30;
        r8.cancel();
    L30:
        if ((r9 instanceof ViewGroup) == false) goto L32;
        ViewGroup r12 = (ViewGroup) r9;
    L34:
        if (r12 == null) goto L36;
        View r13 = r12.findViewById(2131373411);
    L37:
        this.s = r13;
        this.u = r9;
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{33.0f, 44.0f});
        r14.setDuration(200);
        r14.addUpdateListener(new mz3.a(this));
        r14.addListener(new h(this));
        r14.start();
        this.r = r14;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{37.0f, 64.0f});
        r15.setDuration(200);
        r15.addUpdateListener(new mz3.b(this));
        r15.addListener(new i(this));
        r15.start();
        this.t = r15;
        View r16 = this.j;
        if ((r16 instanceof ViewGroup) == false) goto L40;
        ViewGroup r17 = (ViewGroup) r16;
    L41:
        if (r17 == null) goto L43;
        r2 = r17.findViewById(2131373411);
    L43:
        this.w = r2;
        this.y = this.j;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{44.0f, 33.0f});
        r18.setDuration(200);
        r18.addUpdateListener(new mz3.d(this));
        r18.addListener(new f(this));
        r18.start();
        this.v = r18;
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{64.0f, 37.0f});
        r19.setDuration(200);
        r19.addUpdateListener(new e(this));
        r19.addListener(new g(this));
        r19.start();
        this.x = r19;
        this.j = r9;
        if (r9 == null) goto L47;
        r9.setTag(2131373410, Long.valueOf(System.currentTimeMillis()));
        goto L47
    L40:
        r17 = null;
        goto L41
    L36:
        r13 = null;
        goto L37
    L32:
        r12 = null;
        goto L34
    L14:
        r4 = 0;
        goto L16
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = null;
    L47:
        if (this.k == r10) goto L61;
        this.k = r10;
        if ((this.b.getTop() - this.m) <= n0.a(getContext(), 100.0f)) goto L51;
        boolean r20 = true;
    L52:
        Function1<? super c, Unit> r21 = this.n;
        if (r21 == null) goto L55;
        r21.invoke(new c(this.k, r20, r11));
    L55:
        AppCompatTextView r22 = this.f;
        if (r10 != (-1)) goto L58;
        CharSequence r110 = "";
    L59:
        r22.setText(r110);
        return;
    L58:
        r110 = String.valueOf(r10 + 1);
        goto L59
    L51:
        r20 = false;
        goto L52
    }

    public /* synthetic */ GalleryLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
