package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes41.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f495046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f495047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f495048c;

    /* JADX INFO: renamed from: io.reactivex.internal.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC6334a<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T r100);
    }

    public a() {
        Object[] r100 = new Object[5];
        this.f495046a = r100;
        this.f495047b = r100;
    }

    public final <U> boolean a(wwc.b<? super U> r100) {
        Object[] r101 = this.f495046a;
    L3:
        int r102 = 0;
        if (r101 == null) goto L16;
    L6:
        if (r102 >= 4) goto L15;
        Object[] r103 = r101[r102];
        if (r103 == null) goto L15;
        if (NotificationLite.acceptFull(r103, r100) == true) goto L12;
        r102 = r102 + 1;
        goto L6
    L12:
        return true;
    L15:
        r101 = r101[4];
        goto L3
    L16:
        return false;
    }

    public final void b(T r100) {
        int r101 = this.f495048c;
        if (r101 != 4) goto L5;
        Object[] r102 = new Object[5];
        this.f495047b[4] = r102;
        this.f495047b = r102;
        r101 = 0;
    L5:
        this.f495047b[r101] = r100;
        this.f495048c = r101 + 1;
    }

    public final void c(InterfaceC6334a<? super T> r100) {
        Object[] r101 = this.f495046a;
    L3:
        if (r101 == null) goto L15;
        int r102 = 0;
    L6:
        if (r102 >= 4) goto L14;
        Object r103 = r101[r102];
        if (r103 == null) goto L14;
        if (r100.test(r103) == true) goto L12;
        r102 = r102 + 1;
        goto L6
    L12:
        return;
    L14:
        r101 = (Object[]) r101[4];
        goto L3
    }
}
