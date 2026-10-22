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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ BubbleMenuVM a;
        public final /* synthetic */ List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> b;

        public static final class a<T> implements Comparator {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r1).c), Integer.valueOf(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r2).c));
            }
        }

        public b(BubbleMenuVM r1, List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LinkedHashMap r0 = new LinkedHashMap();
            LinkedHashSet r1 = new LinkedHashSet();
            List r2 = (List) BubbleMenuVM.access$getMenuItemsLiveData$p(this.a).getValue();
            if (r2 != null) goto L5;
            r2 = CollectionsKt.emptyList();
        L5:
            Iterator r3 = CollectionsKt.plus(r2, this.b).iterator();
        L7:
            if (r3.hasNext() == false) goto L12;
            com.bytedance.ee.bear.drive.biz.bubblemenu.c r4 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r3.next();
            if (r0.put(r4.a, r4) == null) goto L7;
            r1.add(r4.a);
            goto L7
        L12:
            if ((!r1.isEmpty()) == false) goto L14;
            tt5.a.h(BubbleMenuVM.TAG, "addMenus replace items by id, ids=" + r1);
        L14:
            BubbleMenuVM.access$getMenuItemsLiveData$p(this.a).setValue(CollectionsKt.sortedWith(r0.values(), new a()));
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
        public final /* synthetic */ BubbleMenuVM a;
        public final /* synthetic */ HashSet<String> b;

        public c(BubbleMenuVM r1, HashSet<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            List r0 = (List) BubbleMenuVM.access$getMenuItemsLiveData$p(this.a).getValue();
            if (r0 != null) goto L5;
            r0 = CollectionsKt.emptyList();
        L5:
            HashSet<String> r2 = this.b;
            ArrayList r3 = new ArrayList();
            Iterator r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L12;
            Object r4 = r1.next();
            if (r2.contains(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r4).a) == true) goto L7;
            r3.add(r4);
            goto L7
        L12:
            if (r3.size() == r0.size()) goto L14;
            tt5.a.h(BubbleMenuVM.TAG, "removeMenus remove items by id, ids=" + this.b);
        L14:
            BubbleMenuVM.access$getMenuItemsLiveData$p(this.a).setValue(r3);
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
        MutableLiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r0 = this.menuItemsLiveData;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuItem>?>");
        return r0;
    }

    public final LiveData<d> getSelectionDataLiveData() {
        MutableLiveData<d> r0 = this.selectionDataLiveData;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.bytedance.ee.bear.drive.biz.bubblemenu.SelectionData?>");
        return r0;
    }

    public BubbleMenuVM() {
        MutableLiveData<List<com.bytedance.ee.bear.drive.biz.bubblemenu.c>> r0 = new MutableLiveData(null);
        this.menuItemsLiveData = r0;
        this.enabledLiveData = Transformations.map(r0, BubbleMenuVM$enabledLiveData$1.INSTANCE);
        this.selectionDataLiveData = new MutableLiveData(null);
    }

    public final LiveData<Boolean> getEnabledLiveData() {
        return this.enabledLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getMenuItemsLiveData$p(BubbleMenuVM r0) {
        return r0.menuItemsLiveData;
    }

    public final void addMenus(List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItems");
        j.c(new b(this, r2));
    }

    public final boolean hasMenu(String r5) {
        Intrinsics.checkNotNullParameter(r5, "menuId");
        List r0 = (List) this.menuItemsLiveData.getValue();
        Object r1 = null;
        if (r0 == null) goto L11;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r3).a, r5) == false) goto L6;
        r1 = r3;
    L10:
        r1 = (com.bytedance.ee.bear.drive.biz.bubblemenu.c) r1;
    L11:
        if (r1 == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final void removeMenus(List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        HashSet r0 = new HashSet();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((com.bytedance.ee.bear.drive.biz.bubblemenu.c) r4.next()).a);
        goto L4
    L6:
        j.c(new c(this, r0));
    }

    public final void updateSelectionData(d r2) {
        this.selectionDataLiveData.postValue(r2);
    }
}
