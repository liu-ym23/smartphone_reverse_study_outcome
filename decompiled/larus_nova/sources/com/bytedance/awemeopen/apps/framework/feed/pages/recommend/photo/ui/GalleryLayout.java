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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\r\u0017\u0018\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout;", "Landroid/widget/RelativeLayout;", "", "getScrollXDistance", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$b;", "listener", "", "setGalleryLayoutListener", "", "Lr14/y;", "list", "setData", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ThumbnailAdapter", "ThumbnailViewHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GalleryLayout extends RelativeLayout {
    public static int C;
    public View A;
    public b B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f195184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GalleryRecyclerView f195185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayoutManager f195186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AoImageView f195187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f195188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DmtTextView f195189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f195190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DmtTextView f195191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ThumbnailAdapter f195192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f195193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f195194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f195195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f195196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super c, Unit> f195197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f195198o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f195199p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f195200q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f195201r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f195202s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f195203t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f195204u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f195205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f195206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f195207x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f195208y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f195209z;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailViewHolder;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailViewHolder> implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<y> f195210a;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f195210a).size();
        }

        public ThumbnailAdapter() {
            this.f195210a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            ThumbnailViewHolder r102 = (ThumbnailViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            y r103 = (y) ListProtector.get(this.f195210a, r101);
            AoImageView r104 = r102.f195211a;
            if (r103 == null) goto L5;
            List<String> r105 = r103.c();
        L6:
            com.bytedance.awemeopen.infra.base.image.b r106 = new com.bytedance.awemeopen.infra.base.image.b(r105);
            Resources r107 = Resources.getSystem();
            int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
            Resources r109 = Resources.getSystem();
            int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, 42, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
            r106.f198633n = r108;
            r106.f198634o = r110;
            Resources r111 = Resources.getSystem();
            r106.f198638s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
            r106.b(R.drawable.aos_familiar_ic_slides_thumbnail_placeholder);
            r106.f198632m = ImageView.ScaleType.CENTER_CROP;
            r104.j(r106);
            r102.itemView.setTag(Integer.valueOf(r101));
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_familiar_gallery_item_view, r100, false);
            r102.setOnClickListener(this);
            return new ThumbnailViewHolder(r102);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryLayout$ThumbnailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class ThumbnailViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoImageView f195211a;

        public ThumbnailViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f195211a = (AoImageView) r100.findViewById(R.id.gallery_item_view);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f195212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f195213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f195214c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f195212a == r101.f195212a) goto L12;
            return false;
        L12:
            if (this.f195213b == r101.f195213b) goto L15;
            return false;
        L15:
            if (this.f195214c == r101.f195214c) goto L17;
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
            int r100 = this.f195212a * 31;
            boolean r101 = this.f195213b;
            ?? r102 = 1;
            ?? r103 = r101;
            if (r101 == false) goto L5;
            r103 = 1;
        L5:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f195214c;
            if (r105 == true) goto L10;
            r102 = r105;
        L10:
            return r104 + r102;
        }

        public final String toString() {
            return "SelectResult(position=" + this.f195212a + ", outOfBounds=" + this.f195213b + ", isFullScreenSlides=" + this.f195214c + ')';
        }

        public c(int r100, boolean r101, boolean r102) {
            this.f195212a = r100;
            this.f195213b = r101;
            this.f195214c = r102;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryLayout f195215a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            GalleryLayout r100 = this.f195215a;
            r100.A = r100.f195186c.findViewByPosition(r100.f195194k);
            GalleryLayout r101 = this.f195215a;
            View r102 = r101.A;
            View r103 = null;
            if ((r102 instanceof ViewGroup) == false) goto L5;
            ViewGroup r104 = (ViewGroup) r102;
        L6:
            if (r104 == null) goto L8;
            r103 = r104.findViewById(R.id.gallery_item_view);
        L8:
            r101.f195209z = r103;
            GalleryLayout r105 = this.f195215a;
            View r106 = r105.f195209z;
            if (r106 == null) goto L11;
            GalleryLayout.g(r106, (int) n0.a(r105.getContext(), 44.0f));
        L11:
            GalleryLayout r107 = this.f195215a;
            View r108 = r107.A;
            if (r108 == null) goto L14;
            GalleryLayout.g(r108, (int) n0.a(r107.getContext(), 64.0f));
        L14:
            this.f195215a.f195185b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            r104 = null;
            goto L6
        }

        public d(GalleryLayout r100) {
            this.f195215a = r100;
        }
    }

    public GalleryLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, r101, 4, 0);
    }

    public final void b() {
        this.f195195l = 0.0f;
        this.f195196m = 0.0f;
        View r100 = this.f195193j;
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L7:
        if (r101 == null) goto L9;
        View r102 = r101.getChildAt(0);
    L10:
        if (r102 == null) goto L12;
        r102.setBackgroundDrawable(null);
    L12:
        if (r102 == null) goto L16;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L16;
        r103.scaleX(1.0f);
        r103.scaleY(1.0f);
        r103.setDuration(200);
        r103.start();
    L16:
        this.f195193j = null;
        this.f195194k = 0;
        this.f195189f.setText("");
        this.f195197n = null;
        RecyclerView.SmoothScroller.ScrollVectorProvider r104 = this.f195186c;
        if ((r104 instanceof SlidesGalleryLayoutManager) == false) goto L19;
        SlidesGalleryLayoutManager r105 = (SlidesGalleryLayoutManager) r104;
    L20:
        if (r105 == null) goto L22;
        boolean r106 = Intrinsics.areEqual(Boolean.FALSE, Boolean.TRUE);
    L23:
        if (r106 == false) goto L37;
        RecyclerView.SmoothScroller.ScrollVectorProvider r107 = this.f195186c;
        boolean r108 = r107 instanceof SlidesGalleryLayoutManager;
        if (r108 == false) goto L27;
        SlidesGalleryLayoutManager r109 = (SlidesGalleryLayoutManager) r107;
    L28:
        if (r109 == null) goto L30;
        r109.f195268b = 0;
    L30:
        if (r108 == false) goto L32;
        SlidesGalleryLayoutManager r110 = (SlidesGalleryLayoutManager) r107;
    L33:
        if (r110 == null) goto L37;
        r110.t();
        throw null;
    L32:
        r110 = null;
        goto L33
    L27:
        r109 = null;
    L37:
        this.f195185b.removeAllViews();
        this.f195200q = null;
        return;
    L22:
        r106 = false;
        goto L23
    L19:
        r105 = null;
        goto L20
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    static {
        C = -1;
    }

    private final int getScrollXDistance() {
        LinearLayoutManager r100 = this.f195186c;
        if ((r100 instanceof LinearLayoutManager) == true) goto L6;
        r100 = null;
    L6:
        int r101 = 0;
        if (r100 == null) goto L9;
        int r102 = r100.findFirstVisibleItemPosition();
    L10:
        View r103 = this.f195186c.findViewByPosition(r102);
        int r104 = ((int) n0.a(getContext(), 37.0f)) * (r102 + 1);
        if (r103 == null) goto L14;
        r101 = r103.getRight();
    L14:
        return r104 - r101;
    L9:
        r102 = 0;
        goto L10
    }

    public final boolean a() {
        Boolean r100 = this.f195200q;
        if (r100 != null) goto L5;
        boolean r101 = false;
        if (C > 0) goto L9;
        C = (d0.d(getContext()) / ((int) n0.a(getContext(), 37.0f))) + 1;
        if (this.f195192i.getItemCount() <= C) goto L16;
        r101 = true;
    L16:
        Boolean r102 = Boolean.valueOf(r101);
        this.f195200q = r102;
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L9:
        if (this.f195192i.getItemCount() <= C) goto L11;
        r101 = true;
    L11:
        Boolean r103 = Boolean.valueOf(r101);
        this.f195200q = r103;
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L5:
        return r100.booleanValue();
    }

    public final Context getCtx() {
        return this.f195184a;
    }

    public final void c(int r100) {
        this.f195194k = r100;
        if (a() == true) goto L20;
        DmtTextView r101 = this.f195189f;
        if (r100 != (-1)) goto L7;
        String r102 = "";
    L8:
        r101.setText(r102);
        if (this.f195192i.getItemCount() <= 0) goto L11;
        float r103 = (r100 * 1.0f) / this.f195192i.getItemCount();
    L12:
        float r104 = d0.d(getContext()) * r103;
        LinearLayoutManager r105 = this.f195186c;
        if ((r105 instanceof LinearLayoutManager) == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L18;
        r105.scrollToPositionWithOffset(r100, (int) r104);
    L18:
        this.f195185b.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        return;
    L11:
        r103 = 0.0f;
        goto L12
    L7:
        r102 = String.valueOf(r100 + 1);
        goto L8
    }

    public final void h(int r100) {
        if (r100 > (-1)) goto L5;
        return;
    L5:
        if (this.f195187d.getVisibility() != 0) goto L16;
        AoImageView r101 = this.f195187d;
        com.bytedance.awemeopen.infra.base.image.b r102 = new com.bytedance.awemeopen.infra.base.image.b(((y) ListProtector.get(this.f195192i.f195210a, r100)).c());
        r102.b(R.drawable.aos_common_feed_ic_video_loading_background);
        y r103 = (y) ListProtector.get(this.f195192i.f195210a, r100);
        ImageView.ScaleType r104 = ImageView.ScaleType.CENTER_CROP;
        if (r103 != null) goto L9;
    L13:
        r102.f198632m = r104;
        r101.j(r102);
        return;
    L9:
        if (r103.a() <= 0) goto L13;
        if ((r103.d() / r103.a()) <= 0.5625f) goto L13;
        r104 = ImageView.ScaleType.FIT_CENTER;
        goto L13
    }

    public final void setData(List<y> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f195198o = false;
        ThumbnailAdapter r101 = this.f195192i;
        ((ArrayList) r101.f195210a).clear();
        if (r100 == null) goto L5;
        ArrayList r102 = (ArrayList) r101.f195210a;
        r102.addAll(r100);
    L5:
        r101.notifyDataSetChanged();
        this.f195191h.setText(String.valueOf(r100.size()));
    }

    public final void setGalleryLayoutListener(b r100) {
        this.B = r100;
    }

    public static void e(GalleryLayout r100, int r101) {
        View r102 = r100.f195186c.findViewByPosition(r101);
        if (r102 == null) goto L5;
        r100.f(r102, r101, true);
        return;
    L5:
        r100.f195185b.getViewTreeObserver().addOnGlobalLayoutListener(new j(r102, r100, r101));
    }

    public static void g(View r100, int r101) {
        if (r100 == null) goto L4;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L5:
        if (r102 == null) goto L8;
        r102.width = r101;
    L8:
        if (r100 == null) goto L11;
        r100.requestLayout();
        return;
    L11:
        return;
    L4:
        r102 = null;
        goto L5
    }

    public GalleryLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195184a = r100;
        new Handler(Looper.getMainLooper());
        RecyclerView.OnScrollListener r103 = new GalleryLayout$scrollListener$1(this);
        LayoutInflater.from(r100).inflate(R.layout.aos_familiar_gallery_layout, this, true);
        this.f195187d = (AoImageView) findViewById(R.id.preivew_image);
        GalleryRecyclerView r104 = (GalleryRecyclerView) findViewById(R.id.gallery_recycle_view);
        this.f195185b = r104;
        DmtTextView r105 = (DmtTextView) findViewById(R.id.number_tv);
        this.f195189f = r105;
        this.f195190g = findViewById(R.id.top_space);
        this.f195188e = findViewById(R.id.preivew_mask);
        r105.setText("");
        this.f195191h = (DmtTextView) findViewById(R.id.count_tv);
        final Context r106 = r104.getContext();
        new AnonymousClass1(r106);
        ThumbnailAdapter r107 = new ThumbnailAdapter();
        this.f195192i = r107;
        r104.setAdapter(r107);
        r104.addOnScrollListener(r103);
        LinearLayoutManager r108 = new LinearLayoutManager(r100, 0, false);
        this.f195186c = r108;
        r104.setLayoutManager(r108);
    }

    public final void d(float r100, float r101, Function1<? super c, Unit> r110) {
        this.f195197n = r110;
        this.f195195l = r100;
        this.f195196m = r101;
        boolean r102 = true;
        if (a() == false) goto L25;
        int r103 = d0.d(getContext());
        if (this.f195198o == true) goto L10;
        int r104 = (int) (((double) r103) * 0.15d);
        this.f195199p = r104;
        this.f195185b.setPadding(r104, 0, r104, 0);
        this.f195198o = true;
        Function1<? super c, Unit> r105 = this.f195197n;
        if (r105 == null) goto L9;
        r105.invoke(new c(this.f195194k, false, true));
    L9:
        post(new mz3.c(this));
    L10:
        float r106 = this.f195195l;
        int r111 = this.f195199p;
        float r107 = r111;
        if (r106 >= r107) goto L13;
    L15:
        boolean r112 = false;
    L16:
        if (r112 == false) goto L18;
        float r108 = r103 * 0.7f;
        int r109 = RangesKt.coerceAtMost((int) (this.f195192i.getItemCount() * (RangesKt.coerceAtMost(r106 - r107, r108) / r108)), this.f195192i.getItemCount() - 1);
        if (this.f195194k == r109) goto L50;
        this.f195185b.scrollBy(-(getScrollXDistance() - ((int) ((n0.a(getContext(), 37.0f) * r109) - this.f195195l))), 0);
        h(r109);
        e(this, r109);
        return;
    L50:
        return;
    L18:
        if (r106 >= r107) goto L20;
        this.f195185b.smoothScrollToPosition(0);
        e(this, 0);
        return;
    L20:
        this.f195185b.scrollToPosition(this.f195192i.getItemCount() - 1);
        e(this, this.f195192i.getItemCount() - 1);
        return;
    L13:
        if (r106 > (r103 - r111)) goto L15;
        r112 = true;
        goto L16
    L25:
        int[] r113 = new int[2];
        this.f195185b.getLocationOnScreen(r113);
        float r114 = RangesKt.coerceIn(r100 - r113[0], 5.0f, RangesKt.coerceAtLeast(this.f195185b.getWidth(), 5.0f));
        float[] r115 = {r114, r101 - r113[1]};
        View r116 = this.f195185b.findChildViewUnder(r114, n0.a(getContext(), 25.0f));
        if (r116 != null) goto L28;
    L40:
        if (r116 != null) goto L51;
        Objects.toString(r116);
        if (((this.f195185b.getHeight() * 3) + r115[1]) < 0.0f) goto L45;
        r102 = false;
    L45:
        if (r110 == null) goto L52;
        r110.invoke(new c(this.f195194k, r102, false));
        return;
    L52:
        return;
    L51:
        return;
    L28:
        if (Intrinsics.areEqual(r116, this.f195193j) == true) goto L40;
        View r117 = this.f195209z;
        if (r117 == null) goto L35;
        g(r117, (int) n0.a(getContext(), 33.0f));
        View r118 = this.A;
        if (r118 == null) goto L34;
        g(r118, (int) n0.a(getContext(), 37.0f));
    L34:
        this.f195209z = null;
        this.A = null;
    L35:
        int r119 = this.f195185b.getChildAdapterPosition(r116);
        f(r116, r119, false);
        if (r119 <= (-1)) goto L40;
        if (this.f195187d.getVisibility() != 0) goto L40;
        h(r119);
        goto L40
    }

    public final void f(View r100, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "selectItemView");
        if (Intrinsics.areEqual(r100, this.f195193j) == true) goto L47;
        View r101 = this.f195193j;
        View r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.getTag(R.id.gallery_item_holder_view);
    L9:
        if ((r103 instanceof Long) == false) goto L11;
        Long r104 = (Long) r103;
    L12:
        if (r104 == null) goto L14;
        long r105 = r104.longValue();
    L16:
        if (Math.abs(r105 - System.currentTimeMillis()) < 200) goto L47;
        ValueAnimator r106 = this.f195201r;
        if (r106 == null) goto L20;
        r106.cancel();
    L20:
        ValueAnimator r107 = this.f195203t;
        if (r107 == null) goto L23;
        r107.cancel();
    L23:
        ValueAnimator r108 = this.f195205v;
        if (r108 == null) goto L26;
        r108.cancel();
    L26:
        ValueAnimator r109 = this.f195207x;
        if (r109 == null) goto L30;
        r109.cancel();
    L30:
        if ((r100 instanceof ViewGroup) == false) goto L32;
        ViewGroup r112 = (ViewGroup) r100;
    L34:
        if (r112 == null) goto L36;
        View r113 = r112.findViewById(R.id.gallery_item_view);
    L37:
        this.f195202s = r113;
        this.f195204u = r100;
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{33.0f, 44.0f});
        r114.setDuration(200);
        r114.addUpdateListener(new mz3.a(this));
        r114.addListener(new h(this));
        r114.start();
        this.f195201r = r114;
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{37.0f, 64.0f});
        r115.setDuration(200);
        r115.addUpdateListener(new mz3.b(this));
        r115.addListener(new i(this));
        r115.start();
        this.f195203t = r115;
        View r116 = this.f195193j;
        if ((r116 instanceof ViewGroup) == false) goto L40;
        ViewGroup r117 = (ViewGroup) r116;
    L41:
        if (r117 == null) goto L43;
        r102 = r117.findViewById(R.id.gallery_item_view);
    L43:
        this.f195206w = r102;
        this.f195208y = this.f195193j;
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{44.0f, 33.0f});
        r118.setDuration(200);
        r118.addUpdateListener(new mz3.d(this));
        r118.addListener(new f(this));
        r118.start();
        this.f195205v = r118;
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{64.0f, 37.0f});
        r119.setDuration(200);
        r119.addUpdateListener(new e(this));
        r119.addListener(new g(this));
        r119.start();
        this.f195207x = r119;
        this.f195193j = r100;
        if (r100 == null) goto L47;
        r100.setTag(R.id.gallery_item_holder_view, Long.valueOf(System.currentTimeMillis()));
        goto L47
    L40:
        r117 = null;
        goto L41
    L36:
        r113 = null;
        goto L37
    L32:
        r112 = null;
        goto L34
    L14:
        r105 = 0;
        goto L16
    L11:
        r104 = null;
        goto L12
    L7:
        r103 = null;
    L47:
        if (this.f195194k == r110) goto L61;
        this.f195194k = r110;
        if ((this.f195185b.getTop() - this.f195196m) <= n0.a(getContext(), 100.0f)) goto L51;
        boolean r120 = true;
    L52:
        Function1<? super c, Unit> r121 = this.f195197n;
        if (r121 == null) goto L55;
        r121.invoke(new c(this.f195194k, r120, r111));
    L55:
        DmtTextView r122 = this.f195189f;
        if (r110 != (-1)) goto L58;
        String r123 = "";
    L59:
        r122.setText(r123);
        return;
    L58:
        r123 = String.valueOf(r110 + 1);
        goto L59
    L51:
        r120 = false;
        goto L52
    }

    public /* synthetic */ GalleryLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
