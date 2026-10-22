package com.bytedance.ee.bear.bitable.common.widgets.rating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sr4.c;
import sr4.d;
import sr4.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002PQB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\rJ\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0007J\b\u0010C\u001a\u00020@H\u0002J\u0010\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\fH\u0016J\u0015\u0010F\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010GJ0\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\fH\u0014J\b\u0010N\u001a\u00020@H\u0002J\b\u0010O\u001a\u00020\fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u000e\u0010%\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00107\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u000106@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/OnRatingStarClickListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "mRating", "Ljava/lang/Integer;", "EMPTY_DEFAULT_RATING", "MAX_CHILDREN_NUM", "mIsIndicator", "", "mIsNps", "mSelectedIconResId", "mUnSelectedIconResId", "mUnSelectedColorResId", "mMaxRating", "getMMaxRating", "()I", "setMMaxRating", "(I)V", "mMinRating", "getMMinRating", "setMMinRating", "mInitRating", "getMInitRating", "setMInitRating", "mShowTip", "mRatingStarNum", "mAutoScale", "mScaleFactor", "", "mRatingStarSizeInfo", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/RatingStarSizeInfo;", "mNpsIconsInfo", "", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/RatingSymbolResConf$NpsIconResInfo;", "ratingStarSizeUpdateListener", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar$OnStarSizeUpdateListener;", "getRatingStarSizeUpdateListener", "()Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar$OnStarSizeUpdateListener;", "setRatingStarSizeUpdateListener", "(Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar$OnStarSizeUpdateListener;)V", "value", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/OnRatingChangeListener;", "ratingChangeListener", "getRatingChangeListener", "()Lcom/bytedance/ee/bear/bitable/common/widgets/rating/OnRatingChangeListener;", "setRatingChangeListener", "(Lcom/bytedance/ee/bear/bitable/common/widgets/rating/OnRatingChangeListener;)V", "Rating", "getRating", "()Ljava/lang/Integer;", "setRatingBarInfo", "", "builder", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar$Builder;", "buildRatingContent", "onRatingStarClick", "rating", "updateRating", "(Ljava/lang/Integer;)V", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "resizeIfNeeded", "getChildrenWidth", "Builder", "OnStarSizeUpdateListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BTRatingBar extends LinearLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f210027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f210028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f210029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f210030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f210031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f210032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f210033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f210034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f210035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f210036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f210037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f210038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f210039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f210040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<com.bytedance.ee.bear.bitable.common.widgets.rating.a.c> f210041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f210042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f210043q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f210044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f210045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f210046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f210047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f210048e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f210049f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f210050g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f210051h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f210052i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<com.bytedance.ee.bear.bitable.common.widgets.rating.a.c> f210053j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Boolean f210054k;

        public a() {
            this.f210046c = 0;
            this.f210047d = 0;
            this.f210048e = 0;
            this.f210054k = Boolean.FALSE;
        }
    }

    public interface b {
        void O0(int r100, int r101);
    }

    private final int getChildrenWidth() {
        e r100 = this.f210040n;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.f543227a;
    L6:
        int r103 = n.d(r102);
        e r104 = this.f210040n;
        if (r104 == null) goto L10;
        r101 = r104.f543228b;
    L10:
        return (r103 + n.d(r101)) * this.f210030d;
    L5:
        r102 = 0;
        goto L6
    }

    public final void b() {
        tt5.a.b(this.f210027a, "buildRatingContent");
        e r100 = this.f210040n;
        if (r100 == null) goto L26;
        int r101 = this.f210036j;
        int r102 = this.f210035i;
        if (r101 > r102) goto L28;
    L6:
        boolean r103 = true;
        if (this.f210032f == true) goto L9;
        sr4.b r104 = new sr4.b(getContext());
        Integer r105 = Integer.valueOf(r101);
        Integer r106 = this.f210033g;
        Integer r107 = this.f210034h;
        boolean r108 = this.f210031e;
        boolean r110 = this.f210038l;
        r104.f543209b = false;
        r104.f543208a = r105;
        r104.f543212e = r106;
        r104.f543213f = r107;
        r104.f543217j = r100;
        r104.f543211d = r108;
        r104.f543223p = r110;
        r104.a();
    L20:
        if (r101 <= this.f210037k) goto L23;
        r103 = false;
    L23:
        r104.b(r103);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r104.setRatingStarClickListener(this);
        addView(r104);
        if (r101 == r102) goto L29;
        r101 = r101 + 1;
        goto L6
    L29:
        return;
    L9:
        r104 = new sr4.b(getContext());
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r109 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r111 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r101));
        Integer r112 = Integer.valueOf(r101);
        Integer r113 = null;
        if (r111 == null) goto L12;
        Integer r114 = Integer.valueOf(r111.f210059a);
    L13:
        if (r111 == null) goto L15;
        Integer r115 = Integer.valueOf(r111.f210060b);
    L16:
        if (r111 == null) goto L18;
        r113 = Integer.valueOf(r111.f210061c);
    L18:
        boolean r116 = this.f210031e;
        boolean r117 = this.f210038l;
        r104.f543209b = true;
        r104.f543208a = r112;
        r104.f543214g = r114;
        r104.f543215h = r115;
        r104.f543216i = r113;
        r104.f543217j = r100;
        r104.f543211d = r116;
        r104.f543223p = r117;
        r104.a();
        goto L20
    L15:
        r115 = null;
        goto L16
    L12:
        r114 = null;
        goto L13
    L28:
        return;
    }

    public final int getMInitRating() {
        return this.f210037k;
    }

    public final int getMMaxRating() {
        return this.f210035i;
    }

    public final int getMMinRating() {
        return this.f210036j;
    }

    public final Integer getRating() {
        return this.f210028b;
    }

    public final c getRatingChangeListener() {
        return this.f210043q;
    }

    public final b getRatingStarSizeUpdateListener() {
        return this.f210042p;
    }

    public BTRatingBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // sr4.d
    public final void a(int r100) {
        Integer r101 = this.f210028b;
        if (r101 != null) goto L6;
    L8:
        Integer r102 = Integer.valueOf(r100);
    L10:
        if (Intrinsics.areEqual(r102, this.f210028b) == true) goto L14;
        this.f210028b = r102;
        c r103 = this.f210043q;
        if (r103 == null) goto L14;
        r103.b(r102);
    L14:
        int r104 = getChildCount();
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L32;
        View r106 = getChildAt(r105);
        if ((r106 instanceof sr4.b) == false) goto L19;
        sr4.b r107 = (sr4.b) r106;
    L20:
        if (r107 == null) goto L31;
        Integer r108 = r107.getRating();
        if (r108 == null) goto L31;
        int r109 = r108.intValue();
        Integer r110 = this.f210028b;
        if (r110 == null) goto L26;
        int r111 = r110.intValue();
    L27:
        if (r109 > r111) goto L29;
        boolean r112 = true;
    L30:
        r107.b(r112);
        goto L31
    L29:
        r112 = false;
        goto L30
    L26:
        r111 = this.f210029c;
    L31:
        r105 = r105 + 1;
        goto L15
    L19:
        r107 = null;
        goto L20
    L32:
        return;
    L6:
        if (r100 != r101.intValue()) goto L8;
        r102 = null;
        goto L10
    }

    public final void c(Integer r100) {
        this.f210028b = r100;
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L20;
        View r103 = getChildAt(r102);
        if ((r103 instanceof sr4.b) == false) goto L7;
        sr4.b r104 = (sr4.b) r103;
    L8:
        if (r104 == null) goto L19;
        Integer r105 = r104.getRating();
        if (r105 == null) goto L19;
        int r106 = r105.intValue();
        Integer r107 = this.f210028b;
        if (r107 == null) goto L14;
        int r108 = r107.intValue();
    L15:
        if (r106 > r108) goto L17;
        boolean r109 = true;
    L18:
        r104.b(r109);
        goto L19
    L17:
        r109 = false;
        goto L18
    L14:
        r108 = this.f210029c;
    L19:
        r102 = r102 + 1;
        goto L3
    L7:
        r104 = null;
        goto L8
    }

    public final void setMInitRating(int r100) {
        this.f210037k = r100;
    }

    public final void setMMaxRating(int r100) {
        this.f210035i = r100;
    }

    public final void setMMinRating(int r100) {
        this.f210036j = r100;
    }

    public final void setRatingBarInfo(a r100) {
        if (r100 == null) goto L39;
        removeAllViews();
        Integer r101 = r100.f210047d;
        if (r101 == null) goto L6;
        this.f210036j = r101.intValue();
    L6:
        Integer r102 = r100.f210046c;
        if (r102 == null) goto L9;
        this.f210035i = r102.intValue();
    L9:
        Integer r103 = r100.f210048e;
        if (r103 == null) goto L12;
        this.f210037k = r103.intValue();
    L14:
        if (this.f210036j >= 0) goto L17;
        this.f210036j = 0;
    L17:
        if (this.f210035i >= 0) goto L19;
        this.f210035i = 10;
    L19:
        Integer r104 = r100.f210044a;
        if (r104 == null) goto L22;
        this.f210033g = Integer.valueOf(r104.intValue());
    L22:
        Integer r105 = r100.f210045b;
        if (r105 == null) goto L25;
        this.f210034h = Integer.valueOf(r105.intValue());
    L25:
        Boolean r106 = r100.f210049f;
        if (r106 == null) goto L28;
        this.f210038l = r106.booleanValue();
    L28:
        this.f210031e = r100.f210050g;
        this.f210032f = r100.f210052i;
        e r107 = r100.f210051h;
        if (r107 == null) goto L31;
        this.f210040n = r107;
    L31:
        List<com.bytedance.ee.bear.bitable.common.widgets.rating.a.c> r108 = r100.f210053j;
        if (r108 == null) goto L34;
        this.f210041o = r108;
    L34:
        Boolean r109 = r100.f210054k;
        if (r109 == null) goto L37;
        this.f210039m = r109.booleanValue();
    L37:
        b();
        return;
    L12:
        this.f210037k = this.f210029c;
        goto L14
    }

    public final void setRatingChangeListener(c r100) {
        this.f210043q = r100;
    }

    public final void setRatingStarSizeUpdateListener(b r100) {
        this.f210042p = r100;
    }

    public BTRatingBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public BTRatingBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f210027a = "BTRatingBar";
        this.f210029c = Integer.MIN_VALUE;
        this.f210030d = 11;
        this.f210035i = 10;
        this.f210038l = true;
        setOrientation(0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        tt5.a.b(this.f210027a, "onLayout");
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f210039m == false) goto L21;
        int r105 = getChildrenWidth();
        int r106 = getWidth();
        if (r106 >= r105) goto L22;
        tt5.a.b(this.f210027a, "resizeIfNeeded -" + r106 + " - " + r105);
        float r107 = ((float) r106) / ((float) r105);
        e r108 = this.f210040n;
        int r109 = 0;
        if (r108 == null) goto L9;
        int r110 = r108.f543227a;
    L10:
        int r111 = (int) (r110 * r107);
        if (r108 == null) goto L13;
        r109 = r108.f543228b;
    L13:
        int r112 = (int) (r109 * r107);
        b r113 = this.f210042p;
        if (r113 == null) goto L16;
        r113.O0(r111, r112);
    L16:
        e r114 = this.f210040n;
        if (r114 == null) goto L19;
        r114.f543227a = r111;
        r114.f543228b = r112;
    L19:
        removeAllViews();
        b();
        post(new sr4.a(this));
        return;
    L9:
        r110 = 0;
        goto L10
    L22:
        return;
    }
}
