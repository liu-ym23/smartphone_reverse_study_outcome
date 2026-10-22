package com.bytedance.ee.bear.drive.biz.bubblemenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\tJ\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0014\u001a\u00020\u0012J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\u0017\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "menuItemsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuItem;", "enabledLiveData", "Landroidx/lifecycle/LiveData;", "", "getEnabledLiveData", "()Landroidx/lifecycle/LiveData;", "selectionDataLiveData", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/SelectionData;", "getMenuItemsLiveData", "getSelectionDataLiveData", "updateSelectionData", "", "selectionData", "clearSelectionData", "addMenus", "menuItems", "removeMenus", "hasMenu", "menuId", "", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleMenuVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "BubbleMenuVM";
    private final LiveData<Boolean> enabledLiveData;
    private final MutableLiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> menuItemsLiveData;
    private final MutableLiveData<d> selectionDataLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BubbleMenuVM f222595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> f222596b;

        public static final class a<T> implements Comparator {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r100).f222607c), Integer.valueOf(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r101).f222607c));
            }
        }

        public b(BubbleMenuVM r100, List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r101) {
            this.f222595a = r100;
            this.f222596b = r101;
        }

        public final void a() {
            LinkedHashMap r100 = new LinkedHashMap();
            LinkedHashSet r101 = new LinkedHashSet();
            List r102 = (List) BubbleMenuVM.access$getMenuItemsLiveData$p(this.f222595a).getValue();
            if (r102 != null) goto L5;
            r102 = CollectionsKt.emptyList();
        L5:
            Iterator r103 = CollectionsKt.plus(r102, this.f222596b).iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r104 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r103.next();
            if (r100.put(r104.f222605a, r104) == null) goto L7;
            r101.add(r104.f222605a);
            goto L7
        L12:
            if ((!r101.isEmpty()) == false) goto L14;
            tt5.a.h(BubbleMenuVM.TAG, "addMenus replace items by id, ids=" + r101);
        L14:
            BubbleMenuVM.access$getMenuItemsLiveData$p(this.f222595a).setValue(CollectionsKt.sortedWith(r100.values(), new a()));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BubbleMenuVM f222597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashSet<String> f222598b;

        public c(BubbleMenuVM r100, HashSet<String> r101) {
            this.f222597a = r100;
            this.f222598b = r101;
        }

        public final void a() {
            List r100 = (List) BubbleMenuVM.access$getMenuItemsLiveData$p(this.f222597a).getValue();
            if (r100 != null) goto L5;
            r100 = CollectionsKt.emptyList();
        L5:
            HashSet<String> r101 = this.f222598b;
            ArrayList r102 = new ArrayList();
            Iterator r103 = r100.iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            Object r104 = r103.next();
            if (r101.contains(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r104).f222605a) == true) goto L7;
            r102.add(r104);
            goto L7
        L12:
            if (r102.size() == r100.size()) goto L14;
            tt5.a.h(BubbleMenuVM.TAG, "removeMenus remove items by id, ids=" + this.f222598b);
        L14:
            BubbleMenuVM.access$getMenuItemsLiveData$p(this.f222597a).setValue(r102);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public final void clearSelectionData() {
        this.selectionDataLiveData.postValue(null);
    }

    public final LiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> getMenuItemsLiveData() {
        MutableLiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r100 = this.menuItemsLiveData;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuItem>?>");
        return r100;
    }

    public final LiveData<d> getSelectionDataLiveData() {
        MutableLiveData<d> r100 = this.selectionDataLiveData;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.bytedance.ee.bear.drive.biz.bubblemenu.SelectionData?>");
        return r100;
    }

    public BubbleMenuVM() {
        MutableLiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r100 = new MutableLiveData(null);
        this.menuItemsLiveData = r100;
        this.enabledLiveData = Transformations.map(r100, BubbleMenuVM$enabledLiveData$1.INSTANCE);
        this.selectionDataLiveData = new MutableLiveData(null);
    }

    public final LiveData<Boolean> getEnabledLiveData() {
        return this.enabledLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getMenuItemsLiveData$p(BubbleMenuVM r100) {
        return r100.menuItemsLiveData;
    }

    public final void addMenus(List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItems");
        j.c(new b(this, r100));
    }

    public final boolean hasMenu(String r100) {
        Intrinsics.checkNotNullParameter(r100, "menuId");
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r101 = this.menuItemsLiveData.getValue();
        Object r102 = null;
        if (r101 == null) goto L11;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r104).f222605a, r100) == false) goto L6;
        r102 = r104;
    L10:
        r102 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r102;
    L11:
        if (r102 == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final void removeMenus(List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItems");
        HashSet r101 = new HashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r102.next()).f222605a);
        goto L4
    L6:
        j.c(new c(this, r101));
    }

    public final void updateSelectionData(d r100) {
        this.selectionDataLiveData.postValue(r100);
    }
}
