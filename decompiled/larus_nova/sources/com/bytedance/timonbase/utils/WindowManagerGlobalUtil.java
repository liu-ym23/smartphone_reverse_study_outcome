package com.bytedance.timonbase.utils;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes22.dex */
public final class WindowManagerGlobalUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<a> f270908b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0015\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timonbase/utils/WindowManagerGlobalUtil$ViewList;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "collection", "", "(Ljava/util/Collection;)V", "add", "", "element", "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    public static final class ViewList extends ArrayList<View> {
        /* JADX WARN: Multi-variable type inference failed */
        public ViewList() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        public ViewList(Collection<? extends View> r100) {
            super(r100);
        }

        public boolean add(View r100) {
            Lazy r101 = WindowManagerGlobalUtil.f270907a;
            Iterator<T> r102 = WindowManagerGlobalUtil.f270908b.iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            ((a) r102.next()).b(r100);
            goto L4
        L7:
            return super.add(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object r100) {
            if ((r100 instanceof View) == true) goto L5;
            return false;
        L5:
            return contains((View) r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r100) {
            if ((r100 instanceof View) == true) goto L5;
            return -1;
        L5:
            return indexOf((View) r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r100) {
            if ((r100 instanceof View) == true) goto L5;
            return -1;
        L5:
            return lastIndexOf((View) r100);
        }

        public boolean remove(View r100) {
            Iterator<a> r101 = WindowManagerGlobalUtil.f270908b.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            r101.next().a();
            goto L4
        L7:
            return super.remove(r100);
        }

        public /* bridge */ View removeAt(int r100) {
            return remove(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((View) r100);
        }

        public /* bridge */ boolean contains(View r100) {
            return super.contains(r100);
        }

        public /* bridge */ int indexOf(View r100) {
            return super.indexOf(r100);
        }

        public /* bridge */ int lastIndexOf(View r100) {
            return super.lastIndexOf(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object r100) {
            if ((r100 instanceof View) == true) goto L5;
            return false;
        L5:
            return remove((View) r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ View remove(int r100) {
            return removeAt(r100);
        }

        public /* synthetic */ ViewList(Collection r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new ArrayList();
        L5:
            this(r100);
        }
    }

    public interface a {
        void a();

        void b(View r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        new ViewList(null, 1, 0 == true ? 1 : 0);
        f270907a = LazyKt.lazy(WindowManagerGlobalUtil$isHookSuccess$2.INSTANCE);
        f270908b = new ArrayList();
    }
}
