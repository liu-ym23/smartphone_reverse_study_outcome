package com.larksuite.component.universe_design.datepicker.impl.infinite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPageViews", "", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePageView;", "[Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePageView;", "mInflatedPageCount", "", "value", "", "isAllPagesInflated", "()Z", "initAdapterViews", "", "instantiateItem", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "getPageView", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "(I)Landroid/view/View;", "destroyItem", MapController.ITEM_LAYER_TAG, "onInstantiateItem", "afterInstantiateItem", "getCount", "isViewFromObject", "view", "rotateLeft2Right", "rotateRight2Left", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InfinitePagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f284812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o08.a[] f284813b;

    public static final class a {
    }

    static {
    }

    public abstract void f();

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return 3;
    }

    public InfinitePagerAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f284812a = r100;
    }

    public final <T extends View> T g(int r100) {
        o08.a[] r101 = null;
        if (r100 >= 0) goto L5;
        return null;
    L5:
        if (r100 > 2) goto L14;
        o08.a[] r102 = this.f284813b;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
    L12:
        return (T) r101[r100].f521644b;
    L10:
        r101 = r102;
        goto L12
    L14:
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        o08.a[] r102 = this.f284813b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        r102 = null;
    L5:
        o08.a r103 = r102[r101];
        r100.addView(r103.f521643a);
        f();
        return r103;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (r100 != ((o08.a) r101).f521643a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        if ((r102 instanceof o08.a) == false) goto L5;
        o08.a r103 = (o08.a) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        r100.removeView(r103.f521643a);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
