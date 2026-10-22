package com.bytedance.ee.bear.middleground.comment.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v7b.s;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f232362a;

    public n(m r100) {
        this.f232362a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        v7b.s r100 = (v7b.a) ((v7b.q) r110.f419898d).f553568d;
        int r101 = -1;
        if ((r100 instanceof v7b.u) == false) goto L18;
        this.f232362a.getClass();
        v7b.s r102 = r100;
    L5:
        if (r102 == null) goto L12;
        if ((r102 instanceof v7b.u) == false) goto L9;
    L10:
        r101 = r101 + 1;
    L11:
        r102 = r102.i();
        goto L5
    L9:
        if ((r102 instanceof v7b.c) == false) goto L11;
    L12:
        int r103 = RangesKt.coerceAtLeast(r101, 0);
        m r104 = this.f232362a;
        String[] r105 = com.ss.android.lark.coremd.utils.d.f419966a;
        T r106 = r110.f419898d;
        Integer r107 = ((v7b.q) r106).f553566j;
        if (r107 == null) goto L15;
        int r108 = r107.intValue();
    L36:
        return m.e(r104, com.ss.android.lark.coremd.utils.d.c(r108, r103), (v7b.q) r110.f419898d, r110.getContext(), r110.getTheme(), r103, true);
    L15:
        r108 = com.ss.android.lark.coremd.utils.d.b((v7b.u) r100, r106);
        goto L36
    L18:
        if ((r100 instanceof v7b.c) == false) goto L28;
        this.f232362a.getClass();
    L20:
        if (r100 == null) goto L27;
        if ((r100 instanceof v7b.u) == false) goto L24;
    L25:
        r101 = r101 + 1;
    L26:
        r100 = r100.i();
        goto L20
    L24:
        if ((r100 instanceof v7b.c) == false) goto L26;
    L27:
        int r109 = RangesKt.coerceAtLeast(r101, 0);
        m r111 = this.f232362a;
        r111.getClass();
        List<String> r112 = m.f232350b;
        return m.e(r111, (String) ListProtector.get(r112, r109 % r112.size()), (v7b.q) r110.f419898d, r110.getContext(), r110.getTheme(), r109, false);
    L28:
        return null;
    }
}
