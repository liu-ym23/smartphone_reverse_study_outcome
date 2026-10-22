package com.bytedance.creativex.mediaimport.view.internal.pager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import ki4.z;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ti4.s;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B_\u0012*\u0010\u0004\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00060\u0005\u0012*\u0010\f\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R2\u0010\u0004\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/pager/LocalMediaPagerAdapter;", "DATA", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/bytedance/creativex/mediaimport/view/internal/pager/ConcatenateAdapter;", "localMediaList", "", "Lkotlin/Pair;", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectPagerView$Page;", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategory;", "Lkotlin/Function1;", "", "", "pageViewProvider", "Lkotlin/Function2;", "Lcom/bytedance/creativex/mediaimport/view/api/IMediaSelectListView;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getCount", "", "isViewFromObject", "view", "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "", "canHandle", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "destroyItem", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalMediaPagerAdapter<DATA> extends PagerAdapter implements ConcatenateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<s<z>, Function1<Boolean, Unit>>> f204003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<z, Function1<? super Boolean, Unit>, si4.c<DATA>> f204004b;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f204003a.size();
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.pager.ConcatenateAdapter
    public final boolean a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return r100 instanceof si4.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalMediaPagerAdapter(List<? extends Pair<s<z>, ? extends Function1<? super Boolean, Unit>>> r100, Function2<? super z, ? super Function1<? super Boolean, Unit>, ? extends si4.c<DATA>> r101) {
        Intrinsics.checkNotNullParameter(r100, "localMediaList");
        Intrinsics.checkNotNullParameter(r101, "pageViewProvider");
        this.f204003a = r100;
        this.f204004b = r101;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Pair r102 = (Pair) ListProtector.get(this.f204003a, r101);
        s r103 = (s) r102.component1();
        Function1<? super Boolean, Unit> r104 = (Function1) r102.component2();
        si4.c<DATA> r105 = this.f204004b.invoke((z) r103.f546102a, r104);
        r100.addView(r105.a());
        return r105;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        View r102 = null;
        if ((r101 instanceof si4.c) == false) goto L5;
        si4.c r103 = (si4.c) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.a();
    L8:
        if (r102 != r100) goto L10;
        return true;
    L10:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        if ((r102 instanceof si4.c) == false) goto L5;
        si4.c r103 = (si4.c) r102;
    L6:
        if (r103 == null) goto L9;
        r100.removeView(r103.a());
        r103.destroy();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
