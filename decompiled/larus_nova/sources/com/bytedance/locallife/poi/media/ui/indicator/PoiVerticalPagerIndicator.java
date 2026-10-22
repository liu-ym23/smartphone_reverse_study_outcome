package com.bytedance.locallife.poi.media.ui.indicator;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.bytedance.dux.font.DuxFontHelper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/PoiVerticalPagerIndicator;", "Landroid/widget/LinearLayout;", "com/bytedance/locallife/poi/media/ui/indicator/PoiVerticalPagerIndicator$mPageChangeCallback$2$1", ce.f26395j, "Lkotlin/Lazy;", "getMPageChangeCallback", "()Lcom/bytedance/locallife/poi/media/ui/indicator/PoiVerticalPagerIndicator$mPageChangeCallback$2$1;", "mPageChangeCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiVerticalPagerIndicator extends LinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f262856l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f262857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiRecyclerPagerIndicator f262858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VerticalScrollTextView f262859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f262860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f262861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager2 f262862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f262863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f262864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f262865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f262866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PoiVerticalPagerIndicator$mPagerDataObserver$1 f262867k;

    public static final class a {
        public a() {
        }

        public static Typeface a(Context r100) {
            int r101 = PoiVerticalPagerIndicator.f262856l;
            Intrinsics.checkNotNullParameter(CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT, "fontName");
            if (r100 == null) goto L9;
            Typeface r102 = DuxFontHelper.c(r100, CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT);
            if (r102 == null) goto L8;
            return r102;
        L8:
            return Typeface.DEFAULT;
        L9:
            return Typeface.DEFAULT;
        }
    }

    static {
        new a();
    }

    public PoiVerticalPagerIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiVerticalPagerIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final PoiVerticalPagerIndicator$mPageChangeCallback$2.AnonymousClass1 getMPageChangeCallback() {
        return (PoiVerticalPagerIndicator$mPageChangeCallback$2.AnonymousClass1) this.f262866j.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r100 = this.f262864h;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L18;
        Job r103 = this.f262864h;
        if (r103 != null) goto L12;
    L14:
        if (r101 == false) goto L18;
        Job r104 = this.f262864h;
        if (r104 == null) goto L18;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
        goto L18
    L12:
        if (r103.isCancelled() == true) goto L14;
        r101 = true;
    L18:
        ViewPager2 r105 = this.f262862f;
        if (r105 == null) goto L21;
        r105.unregisterOnPageChangeCallback(getMPageChangeCallback());
    L21:
        ViewPager2 r106 = this.f262862f;
        if (r106 == null) goto L33;
        RecyclerView.Adapter r107 = r106.getAdapter();
        if (r107 == null) goto L34;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L27
        r107.unregisterAdapterDataObserver(this.f262867k);     // Catch: Throwable -> L27
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Result.m9448boximpl(r109);
        return;
    L27:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L34:
        return;
    L33:
        return;
    L5:
        if (r100.isCompleted() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void a(ViewPager2 r100) {
        Intrinsics.checkNotNullParameter(r100, "pager");
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L5;
        int r102 = r101.getItemCount();
    L6:
        if (r102 != 0) goto L8;
        return;
    L8:
        this.f262865i = r102;
        r100.registerOnPageChangeCallback(getMPageChangeCallback());
        RecyclerView.Adapter r103 = r100.getAdapter();
        if (r103 == null) goto L11;
        r103.registerAdapterDataObserver(this.f262867k);
    L11:
        getMPageChangeCallback().onPageScrollStateChanged(0);
        this.f262858b.a(r100);
        this.f262862f = r100;
        this.f262859c.c(String.valueOf(r100.getCurrentItem() + 1), "", 0.0f);
        this.f262861e.setText(String.valueOf(r102));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.locallife.poi.media.ui.indicator.PoiVerticalPagerIndicator$mPagerDataObserver$1] */
    public PoiVerticalPagerIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.life_poi_media_vertical_num_pager_indicator, this);
        this.f262857a = r103;
        this.f262858b = (PoiRecyclerPagerIndicator) r103.findViewById(R.id.poi_pager_indicator);
        this.f262859c = (VerticalScrollTextView) r103.findViewById(R.id.poi_pager_indicator_scroll_number);
        TextView r104 = (TextView) r103.findViewById(R.id.poi_pager_indicator_divider);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        r104.setTypeface(a.a(r100));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        this.f262860d = r104;
        TextView r106 = (TextView) this.f262857a.findViewById(R.id.poi_pager_indicator_total);
        r106.setTypeface(a.a(r100));     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        this.f262861e = r106;
        this.f262863g = CoroutineScopeKt.MainScope();
        this.f262866j = LazyKt.lazy(new PoiVerticalPagerIndicator$mPageChangeCallback$2(this));
        this.f262867k = new PoiVerticalPagerIndicator$mPagerDataObserver$1(this);
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public /* synthetic */ PoiVerticalPagerIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
