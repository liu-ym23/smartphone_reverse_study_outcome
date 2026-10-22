package com.bytedance.jedi.ext.adapter.multitype;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.jedi.ext.adapter.decorator.internal.e;
import com.bytedance.jedi.ext.adapter.internal.JediViewHolderTrashStation;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class ViewHolderFactoryManager<VH extends MultiTypeViewHolder<?>> implements c<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Function1<ViewGroup, VH>> f251040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f251041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a<VH>> f251042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.jedi.ext.adapter.internal.a f251043d;

    public static final class a<VH> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<ViewGroup, VH> f251044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Integer, Boolean> f251045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f251046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function2<Integer, RecyclerView, Unit> f251047d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f251044a, r101.f251044a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f251045b, r101.f251045b) == true) goto L10;
            return false;
        L10:
            if (this.f251046c == r101.f251046c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f251047d, r101.f251047d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            Function1<ViewGroup, VH> r100 = this.f251044a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Function1<Integer, Boolean> r104 = this.f251045b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (((r103 + r105) * 31) + this.f251046c) * 31;
            Function2<Integer, RecyclerView, Unit> r107 = this.f251047d;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "HolderCreator(factory=" + this.f251044a + ", typeMatcher=" + this.f251045b + ", viewType=" + this.f251046c + ", onAttachedToRecyclerView=" + this.f251047d + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super ViewGroup, ? extends VH> r100, Function1<? super Integer, Boolean> r101, int r102, Function2<? super Integer, ? super RecyclerView, Unit> r103) {
            this.f251044a = r100;
            this.f251045b = r101;
            this.f251046c = r102;
            this.f251047d = r103;
        }
    }

    public void c(MultiTypeViewHolder r100) {
    }

    public VH h(int r100) {
        return null;
    }

    public ViewHolderFactoryManager() {
        this.f251040a = new SparseArray();
        this.f251041b = 11513600;
        Function1<ViewGroup, VH> r100 = new ViewHolderFactoryManager$holderCreators$1(this);
        ViewHolderFactoryManager$holderCreators$2 r101 = ViewHolderFactoryManager$holderCreators$2.INSTANCE;
        int r102 = this.f251041b;
        this.f251041b = r102 + 1;
        this.f251042c = CollectionsKt.mutableListOf(new a[]{new a(r100, r101, r102, null)});
        this.f251043d = new com.bytedance.jedi.ext.adapter.internal.a();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final int b(int r100) {
        Iterator<T> r101 = this.f251042c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (((a) r102).f251045b.invoke(Integer.valueOf(r100)).booleanValue() == false) goto L4;
    L9:
        a r103 = (a) r102;
        if (r103 == null) goto L16;
        Function1<ViewGroup, VH> r104 = r103.f251044a;
        int r105 = r103.f251046c;
        if (this.f251040a.get(r105) != null) goto L14;
        this.f251040a.put(r105, (Function1<ViewGroup, VH>) r104);
    L14:
        return r105;
    L16:
        throw new IllegalArgumentException("no factory is registered for this item type".toString());
    L8:
        r102 = null;
        goto L9
    }

    public VH d(ViewGroup r100) {
        return new com.bytedance.jedi.ext.adapter.multitype.a(r100);
    }

    public final void e(RecyclerView r100) {
        com.bytedance.jedi.ext.adapter.internal.a r101 = this.f251043d;
        e r102 = r101.f251028b;
        r102.f250986a = r100;
        r100.addOnAttachStateChangeListener(r102);
        r101.f251029c = new JediViewHolderTrashStation();
        Iterator<T> r103 = this.f251042c.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        a r104 = (a) r103.next();
        int r105 = r104.f251046c;
        Function2<Integer, RecyclerView, Unit> r106 = r104.f251047d;
        if (r106 == null) goto L4;
        Unit r107 = r106.invoke(Integer.valueOf(r105), r100);
        goto L4
    }

    public final VH a(ViewGroup r100, int r101) {
        VH r102 = (VH) h(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (this.f251040a.indexOfKey(r101) < 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        VH r104 = this.f251040a.get(r101).invoke(r100);
        c(r104);
        return r104;
    L13:
        throw new IllegalArgumentException(("no factory for viewType " + r101 + " is registered").toString());
    L8:
        r103 = false;
        goto L9
    }

    public final ViewHolderFactoryManager g(Function2 r100, Function1 r101) {
        Function1<ViewGroup, VH> r102 = this.f251040a.get(0);
        if (r102 != null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        ListProtector.add(this.f251042c, this.f251042c.size() - 1, new a(r101, ViewHolderFactoryManager$register$2.INSTANCE, 0, r100));
        this.f251040a.put(0, r101);
        return this;
    L10:
        throw new IllegalArgumentException(("factory's viewType 0 " + r102.getClass().getSimpleName() + " is already registered").toString());
    L5:
        r103 = false;
        goto L6
    }

    public final ViewHolderFactoryManager f(Function1 r100, Function2 r101, Function1 r102) {
        int r103 = this.f251042c.size();
        int r104 = this.f251041b;
        this.f251041b = r104 + 1;
        ListProtector.add(this.f251042c, r103 - 1, new a(r102, r100, r104, r101));
        return this;
    }
}
