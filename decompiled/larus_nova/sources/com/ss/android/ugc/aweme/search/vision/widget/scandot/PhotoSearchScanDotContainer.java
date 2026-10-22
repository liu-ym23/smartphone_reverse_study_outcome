package com.ss.android.ugc.aweme.search.vision.widget.scandot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.android.ugc.aweme.search.utils.extensions.ViewExtensionsKt;
import com.ss.android.ugc.aweme.search.vision.crop.CirclePoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u0019\u0010 J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/widget/scandot/PhotoSearchScanDotContainer;", "Landroid/widget/FrameLayout;", "", "Lcom/ss/android/ugc/aweme/search/vision/crop/CirclePoint;", "list", "", "setPoints", "Lkotlin/Function1;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function1;", "getPointClickCallback", "()Lkotlin/jvm/functions/Function1;", "setPointClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "pointClickCallback", "Landroid/view/View;", "value", "c", "Landroid/view/View;", "setLastSelectedDotView", "(Landroid/view/View;)V", "lastSelectedDotView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchScanDotContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super CirclePoint, Boolean> f454111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, PhotoSearchScanDot> f454112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f454113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CirclePoint f454114d;

    public final void c() {
        CirclePoint r100 = this.f454114d;
        if (r100 != null) goto L5;
        return;
    L5:
        PhotoSearchScanDot r101 = this.f454112b.get(Integer.valueOf(r100.f453480a));
        if (r101 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r100, "point");
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L11;
        r102 = null;
    L11:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 == null) goto L15;
        float r104 = r100.f453482c.x - DimenExtensionsKt.b(16);
        float r105 = r100.f453482c.y - DimenExtensionsKt.b(16);
        r103.setMarginStart((int) r104);
        r103.topMargin = (int) r105;
        r101.setLayoutParams(r103);
    L15:
        setLastSelectedDotView(r101);
    }

    public final Function1<CirclePoint, Boolean> getPointClickCallback() {
        return this.f454111a;
    }

    public PhotoSearchScanDotContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f454112b = new HashMap();
    }

    private final void setLastSelectedDotView(View r100) {
        View r101 = this.f454113c;
        if (r101 == null) goto L5;
        ViewExtKt.q(r101);
    L5:
        this.f454113c = r100;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(4);
        return;
    }

    public final void b(CirclePoint r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        PhotoSearchScanDot r101 = this.f454112b.get(Integer.valueOf(r100.f453480a));
        if (r101 != null) goto L5;
        return;
    L5:
        setLastSelectedDotView(r101);
    }

    public final void setPointClickCallback(Function1<? super CirclePoint, Boolean> r100) {
        this.f454111a = r100;
    }

    public final void setPoints(List<CirclePoint> r100) {
        removeAllViews();
        if (r100 == null) goto L17;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L21;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        final CirclePoint r105 = (CirclePoint) r103;
        final PhotoSearchScanDot r106 = new PhotoSearchScanDot(getContext());
        Intrinsics.checkNotNullParameter(this, "parent");
        Intrinsics.checkNotNullParameter(r105, "point");
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        float r108 = r105.f453482c.x - DimenExtensionsKt.b(16);
        float r109 = r105.f453482c.y - DimenExtensionsKt.b(16);
        r107.setMarginStart((int) r108);
        r107.topMargin = (int) r109;
        addView(r106, r107);
        ViewExtensionsKt.a(r106, 1000, new PhotoSearchScanDotContainer$setPoints$$inlined$forEachIndexed$lambda$1(r105, r106, this));
        if (r102 != 0) goto L14;
        setLastSelectedDotView(r106);
    L14:
        if (r105.f453486g == false) goto L16;
        this.f454114d = r105;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        r106.setVisibility(4);
    L16:
        this.f454112b.put(Integer.valueOf(r105.f453480a), r106);
        r102 = r104;
        goto L6
    L21:
        return;
    }

    public PhotoSearchScanDotContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f454112b = new HashMap();
    }

    public static final /* synthetic */ void a(PhotoSearchScanDotContainer r100, PhotoSearchScanDot r101) {
        r100.setLastSelectedDotView(r101);
    }

    public PhotoSearchScanDotContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f454112b = new HashMap();
    }
}
