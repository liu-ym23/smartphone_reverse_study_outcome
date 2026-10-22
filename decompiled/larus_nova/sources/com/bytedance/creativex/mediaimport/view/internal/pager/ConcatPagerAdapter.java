package com.bytedance.creativex.mediaimport.view.internal.pager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u0001H\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000fJ \u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016JX\u0010.\u001a\u0004\u0018\u0001H/\"\u0004\b\u0000\u0010/2\u0006\u00100\u001a\u00020\u000f28\u00101\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0006\u0012\u0004\u0018\u0001H/02H\u0082\b¢\u0006\u0002\u00107R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00068"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/pager/ConcatPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/bytedance/creativex/mediaimport/view/internal/pager/IConcatPagerAdapter;", "<init>", "()V", "_adapters", "", "adapters", "getAdapters", "()Ljava/util/List;", "asPagerAdapter", "updateAdapters", "", "list", "getCount", "", "isViewFromObject", "", "view", "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "", "destroyItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "instantiateItem", "setPrimaryItem", "startUpdate", "finishUpdate", "getItemPosition", "saveState", "Landroid/os/Parcelable;", "restoreState", "state", "loader", "Ljava/lang/ClassLoader;", "notifyDataSetChanged", "registerDataSetObserver", "observer", "Landroid/database/DataSetObserver;", "unregisterDataSetObserver", "getPageTitle", "", "getPageWidth", "", "doOnMappedPosition", "R", "rawPosition", "mapped", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "adapter", "mappedPosition", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ConcatPagerAdapter extends PagerAdapter implements a<PagerAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends PagerAdapter> f203997a;

    @Override // com.bytedance.creativex.mediaimport.view.internal.pager.a
    public final PagerAdapter b() {
        return this;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        Iterator<T> r100 = this.f203997a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((PagerAdapter) r100.next()).getCount();
        goto L4
    L6:
        return r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void notifyDataSetChanged() {
        Iterator<T> r100 = this.f203997a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((PagerAdapter) r100.next()).notifyDataSetChanged();
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        List<? extends PagerAdapter> r100 = this.f203997a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L9;
        Parcelable r104 = ((PagerAdapter) r102.next()).saveState();
        if (r104 == null) goto L8;
        r103 = true;
    L8:
        r101.add(r104);
        goto L4
    L9:
        if (r103 == false) goto L12;
        return new ConcatenateAdapter.ConcatenateState(r101);
    L12:
        return super.saveState();
    }

    public ConcatPagerAdapter() {
        this.f203997a = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.pager.a
    public final void d(List<? extends PagerAdapter> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f203997a = r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Iterator<T> r101 = this.f203997a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((PagerAdapter) r101.next()).finishUpdate(r100);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator<T> r101 = this.f203997a.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        Object r103 = (PagerAdapter) r102;
        if ((r103 instanceof ConcatenateAdapter) == true) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        PagerAdapter r105 = (PagerAdapter) r102;
        if (r105 == null) goto L18;
        return r105.getItemPosition(r100);
    L18:
        return super.getItemPosition(r100);
    L8:
        if (((ConcatenateAdapter) r103).a(r100) == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        Iterator<T> r101 = this.f203997a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        PagerAdapter r103 = (PagerAdapter) r101.next();
        int r104 = r103.getCount() + r102;
        if (r102 > r100) goto L9;
        if (r100 >= r104) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L12;
        r102 = r104;
        goto L4
    L12:
        return r103.getPageTitle(r100 - r102);
    L9:
        r105 = false;
        goto L10
    L15:
        throw new IllegalStateException("position" + r100 + " not available while count is " + getCount());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r100) {
        Iterator<T> r101 = this.f203997a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        PagerAdapter r103 = (PagerAdapter) r101.next();
        int r104 = r103.getCount() + r102;
        if (r102 > r100) goto L9;
        if (r100 >= r104) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L12;
        r102 = r104;
        goto L4
    L12:
        return r103.getPageWidth(r100 - r102);
    L9:
        r105 = false;
        goto L10
    L15:
        throw new IllegalStateException("position" + r100 + " not available while count is " + getCount());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void registerDataSetObserver(DataSetObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Iterator<T> r101 = this.f203997a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((PagerAdapter) r101.next()).registerDataSetObserver(r100);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Iterator<T> r101 = this.f203997a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((PagerAdapter) r101.next()).startUpdate(r100);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void unregisterDataSetObserver(DataSetObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Iterator<T> r101 = this.f203997a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((PagerAdapter) r101.next()).unregisterDataSetObserver(r100);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super.finishUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Iterator<T> r102 = this.f203997a.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L17;
        PagerAdapter r104 = (PagerAdapter) r102.next();
        int r105 = r104.getCount() + r103;
        if (r103 > r101) goto L9;
        if (r101 >= r105) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L11;
        r103 = r105;
        goto L4
    L11:
        Object r107 = r104.instantiateItem(r100, r101 - r103);
        if (r107 == null) goto L14;
        return r107;
    L14:
        return super.instantiateItem(r100, r101);
    L9:
        r106 = false;
        goto L10
    L17:
        throw new IllegalStateException("position" + r101 + " not available while count is " + getCount());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        List<? extends PagerAdapter> r102 = this.f203997a;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L27;
        PagerAdapter r104 = (PagerAdapter) r103.next();
        if ((r104 instanceof ConcatenateAdapter) == true) goto L13;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L9;
        return true;
    L13:
        if (((ConcatenateAdapter) r104).a(r101) == false) goto L17;
        if (r104.isViewFromObject(r100, r101) == false) goto L17;
        r105 = true;
        goto L18
    L27:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable r100, ClassLoader r101) {
        if ((r100 instanceof ConcatenateAdapter.ConcatenateState) == false) goto L5;
        ConcatenateAdapter.ConcatenateState r102 = (ConcatenateAdapter.ConcatenateState) r100;
    L6:
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.f203998a.iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L18;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        PagerAdapter r107 = (PagerAdapter) ListProtector.get(this.f203997a, r104);
        r107.restoreState((Parcelable) r105, r101);
        r104 = r106;
        goto L9
    L18:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return super.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Iterator<T> r103 = this.f203997a.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L15;
        PagerAdapter r105 = (PagerAdapter) r103.next();
        int r106 = r105.getCount() + r104;
        if (r104 > r101) goto L9;
        if (r101 >= r106) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == true) goto L11;
        r104 = r106;
        goto L4
    L11:
        r105.destroyItem(r100, r101 - r104, r102);
        return;
    L9:
        r107 = false;
        goto L10
    L15:
        throw new IllegalStateException("position" + r101 + " not available while count is " + getCount());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Iterator<T> r103 = this.f203997a.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L15;
        PagerAdapter r105 = (PagerAdapter) r103.next();
        int r106 = r105.getCount() + r104;
        if (r104 > r101) goto L9;
        if (r101 >= r106) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == true) goto L11;
        r104 = r106;
        goto L4
    L11:
        r105.setPrimaryItem(r100, r101 - r104, r102);
        return;
    L9:
        r107 = false;
        goto L10
    L15:
        throw new IllegalStateException("position" + r101 + " not available while count is " + getCount());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(View r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        super.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(View r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        super.setPrimaryItem(r100, r101, r102);
    }
}
