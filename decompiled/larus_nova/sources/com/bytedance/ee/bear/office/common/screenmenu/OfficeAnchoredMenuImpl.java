package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeAnchoredMenuImpl implements lk5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f235162c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f235163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f235164b;

    public static final class a {
    }

    static {
    }

    @Override // lk5.a
    public final void dismiss() {
        j.e(this.f235164b, "office_anchored_menu_dismiss", 2);
    }

    @Override // lk5.a
    public final void release() {
        this.f235164b.o();
    }

    public OfficeAnchoredMenuImpl(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f235163a = r100;
        j r101 = new j();
        r101.h(r100);
        this.f235164b = r101;
    }

    @Override // lk5.a
    public final void a(final View r310, List<lk5.c> r311, int r312, Function1<? super String, Unit> r313, Function0<Unit> r314) {
        Intrinsics.checkNotNullParameter(r310, "anchor");
        Intrinsics.checkNotNullParameter(r311, "items");
        Intrinsics.checkNotNullParameter(r313, "onItemClick");
        final h r100 = new h(r313);
        List r101 = CollectionsKt.createListBuilder();
        Iterator<T> r102 = r311.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L14;
        Object r104 = r102.next();
        int r110 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        lk5.c r105 = (lk5.c) r104;
        int r111 = View.generateViewId();
        String r112 = r105.f509572b;
        int r113 = r105.f509573c;
        int r114 = k.a(this.f235163a, 20);
        int r106 = k.a(this.f235163a, 12);
        boolean r115 = r105.f509574d;
        r101.add(new e(r111, r112, null, null, Integer.valueOf(r113), false, false, null, false, r105, r115, !r115, Integer.valueOf(r114), Integer.valueOf(r106), 3052));
        if (r103 != r312) goto L13;
        if (r103 >= CollectionsKt.getLastIndex(r311)) goto L13;
        r101.add(new c(View.generateViewId(), 0, k.a(this.f235163a, 8), k.a(this.f235163a, 200), 78));
    L13:
        r103 = r110;
        goto L4
    L14:
        List r107 = CollectionsKt.build(r101);
        CommonMenu r108 = new CommonMenu(this.f235163a);
        b.a(r108);
        r108.d(k.a(this.f235163a, 200));
        r108.f(r107, new OfficeAnchoredMenuImpl$show$commonMenu$1(r100, this));
        j r109 = this.f235164b;
        r109.f235234g = r314;
        ScreenMenuLayout r116 = r109.f235228a;
        if (r116 == null) goto L17;
        r116.setOnDismissListener(r314);
    L17:
        this.f235164b.n(new OfficeAnchoredMenuImpl$show$1(this, r310));
        this.f235164b.s(r310, r108.j(), u.f235256f);
    }
}
