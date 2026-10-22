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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeAnchoredMenuImpl implements lk5.a {
    public static final /* synthetic */ int c = 0;
    public final FragmentActivity a;
    public final j b;

    public static final class a {
    }

    static {
    }

    @Override // lk5.a
    public final void dismiss() {
        j.e(this.b, "office_anchored_menu_dismiss", 2);
    }

    @Override // lk5.a
    public final void release() {
        this.b.o();
    }

    public OfficeAnchoredMenuImpl(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        j r0 = new j();
        r0.h(r2);
        this.b = r0;
    }

    @Override // lk5.a
    public final void a(final View r30, List<lk5.c> r31, int r32, Function1<? super String, Unit> r33, Function0<Unit> r34) {
        Intrinsics.checkNotNullParameter(r30, "anchor");
        Intrinsics.checkNotNullParameter(r31, "items");
        Intrinsics.checkNotNullParameter(r33, "onItemClick");
        final h r4 = new h(r33);
        List r2 = CollectionsKt.createListBuilder();
        Iterator<T> r6 = r31.iterator();
        int r7 = 0;
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r8 = r6.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        lk5.c r9 = (lk5.c) r8;
        int r12 = View.generateViewId();
        String r13 = r9.b;
        int r11 = r9.c;
        int r14 = k.a(this.a, 20);
        int r15 = k.a(this.a, 12);
        boolean r16 = r9.d;
        r2.add(new e(r12, r13, null, null, Integer.valueOf(r11), false, false, null, false, r9, r16, !r16, Integer.valueOf(r14), Integer.valueOf(r15), 3052));
        if (r7 != r32) goto L13;
        if (r7 >= CollectionsKt.getLastIndex(r31)) goto L13;
        r2.add(new c(View.generateViewId(), 0, k.a(this.a, 8), k.a(this.a, 200), 78));
    L13:
        r7 = r10;
        goto L4
    L14:
        List r3 = CollectionsKt.build(r2);
        CommonMenu r5 = new CommonMenu(this.a);
        b.a(r5);
        r5.d(k.a(this.a, 200));
        r5.f(r3, new OfficeAnchoredMenuImpl$show$commonMenu$1(r4, this));
        j r17 = this.b;
        r17.g = r34;
        ScreenMenuLayout r18 = r17.a;
        if (r18 == null) goto L17;
        r18.setOnDismissListener(r34);
    L17:
        this.b.n(new OfficeAnchoredMenuImpl$show$1(this, r30));
        this.b.s(r30, r5.j(), u.f);
    }
}
