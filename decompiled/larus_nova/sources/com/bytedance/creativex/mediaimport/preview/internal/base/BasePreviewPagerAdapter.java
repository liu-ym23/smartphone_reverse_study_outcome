package com.bytedance.creativex.mediaimport.preview.internal.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fi4.a;
import fi4.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ti4.s;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u00022\u00020\u0004BE\u0012<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0004J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016RD\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0012j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/creativex/mediaimport/preview/internal/base/BasePreviewPagerAdapter;", "DATA", "Lcom/bytedance/creativex/mediaimport/preview/internal/IPreviewPagerAdapter;", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectPagerView$Page;", "Landroidx/viewpager/widget/PagerAdapter;", "pageViewProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "data", "Lcom/bytedance/creativex/mediaimport/preview/internal/IPreviewPageView;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "pageList", "", "pageViewList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updatePages", "", "list", "", "getCount", "asPagerAdapter", "getPageData", "isViewFromObject", "", "view", "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "destroyItem", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePreviewPagerAdapter<DATA> extends PagerAdapter implements b<s<DATA>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Integer, DATA, a<DATA>> f203452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<s<DATA>> f203453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a<DATA>> f203454c;

    @Override // fi4.b
    public final PagerAdapter b() {
        return this;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return ((ArrayList) this.f203453b).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasePreviewPagerAdapter(Function2<? super Integer, ? super DATA, ? extends a<DATA>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageViewProvider");
        this.f203452a = r100;
        this.f203453b = new ArrayList();
        this.f203454c = new HashMap();
    }

    @Override // fi4.b
    public final void e(List<s<DATA>> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) this.f203453b).clear();
        ((ArrayList) this.f203453b).addAll(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        s r102 = (s) ListProtector.get(this.f203453b, r101);
        a<DATA> r103 = this.f203452a.invoke(Integer.valueOf(r101), r102.f546102a);
        r100.addView(r103.getContentView());
        return r103;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        View r102 = null;
        if ((r101 instanceof a) == false) goto L5;
        a r103 = (a) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.getContentView();
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
        if ((r102 instanceof a) == false) goto L5;
        a r103 = (a) r102;
    L6:
        if (r103 == null) goto L9;
        this.f203454c.remove(Integer.valueOf(r101));
        r100.removeView(r103.getContentView());
        r103.destroy();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
