package com.bytedance.creativex.mediaimport.view.internal.pager;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.creativex.mediaimport.widget.viewpager.LazyPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u00022\u00020\u0004:\u0001\"B_\u0012*\u0010\u0005\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u00070\u0006\u0012*\u0010\r\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002R2\u0010\u0005\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/pager/LazyLocalMediaPagerAdapter;", "DATA", "Lcom/bytedance/creativex/mediaimport/widget/viewpager/LazyPagerAdapter;", "Lcom/bytedance/creativex/mediaimport/view/api/IMediaSelectListView;", "Lcom/bytedance/creativex/mediaimport/view/internal/pager/ConcatenateAdapter;", "localMediaList", "", "Lkotlin/Pair;", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectPagerView$Page;", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategory;", "Lkotlin/Function1;", "", "", "pageViewProvider", "Lkotlin/Function2;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getCount", "", "isViewFromObject", "view", "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "", "canHandle", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "destroyItem", "addLazyItem", "getItem", "makeTag", "", "Companion", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyLocalMediaPagerAdapter<DATA> extends LazyPagerAdapter<si4.c<DATA>> implements ConcatenateAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f204000e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<s<z>, Function1<Boolean, Unit>>> f204001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<z, Function1<? super Boolean, Unit>, si4.c<DATA>> f204002d;

    public static final class a {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
    }

    static {
        f204000e = new Object();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f204001c.size();
    }

    public static String g(int r100) {
        return "Lazy Attached " + r100 + " to ViewPager";
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.pager.ConcatenateAdapter
    public final boolean a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return r100 instanceof si4.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLocalMediaPagerAdapter(List<? extends Pair<s<z>, ? extends Function1<? super Boolean, Unit>>> r100, Function2<? super z, ? super Function1<? super Boolean, Unit>, ? extends si4.c<DATA>> r101) {
        Intrinsics.checkNotNullParameter(r100, "localMediaList");
        Intrinsics.checkNotNullParameter(r101, "pageViewProvider");
        this.f204001c = r100;
        this.f204002d = r101;
    }

    @Override // com.bytedance.creativex.mediaimport.widget.viewpager.LazyPagerAdapter
    public final Object f(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r102 = r100.findViewWithTag(g(r101));
        si4.c r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.getTag(R.id.media_select_list_view_tag);
    L7:
        if ((r104 instanceof si4.c) == false) goto L9;
        r103 = (si4.c) r104;
    L9:
        if (r103 != null) goto L12;
        si4.c r105 = (si4.c) this.f204222a.get(r101);
        View r106 = r105.a();
        r106.setTag(g(r101));
        r106.setTag(R.id.media_select_list_view_tag, r105);
        r100.addView(r106);
        this.f204222a.remove(r101);
        return r105;
    L12:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (r100.findViewWithTag(g(r101)) != null) goto L6;
        Pair r102 = (Pair) ListProtector.get(this.f204001c, r101);
        s r103 = (s) r102.component1();
        Function1<? super Boolean, Unit> r104 = (Function1) r102.component2();
        si4.c<DATA> r105 = this.f204002d.invoke((z) r103.f546102a, r104);
        this.f204222a.put(r101, (T) r105);
        return r105;
    L6:
        return f204000e;
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
}
