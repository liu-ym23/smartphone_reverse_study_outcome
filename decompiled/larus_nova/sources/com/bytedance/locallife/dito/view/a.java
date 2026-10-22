package com.bytedance.locallife.dito.view;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoStickyDragItemType f258775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f258776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f258777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f258778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f258779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f258780f;

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final View b() {
        WeakReference<View> r100 = this.f258776b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final DitoStickyDragItemType getType() {
        return this.f258775a;
    }

    public final boolean a(int r100) {
        Boolean r101 = null;
        if (r100 <= 0) goto L9;
        f r102 = this.f258777c;
        if (r102 == null) goto L14;
        View r103 = r102.getNestedScrollTarget();
        if (r103 == null) goto L14;
        r101 = Boolean.valueOf(r103.canScrollVertically(1));
    L14:
        if (r101 != null) goto L16;
        return true;
    L16:
        return r101.booleanValue();
    L9:
        f r104 = this.f258777c;
        if (r104 == null) goto L14;
        View r105 = r104.getNestedScrollTarget();
        if (r105 == null) goto L14;
        r101 = Boolean.valueOf(r105.canScrollVertically(-1));
        goto L14
    }

    public a(DitoStickyDragItemType r100, WeakReference r101, Boolean r102, Boolean r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = DitoStickyDragItemType.DitoStickyDragItemTypeIllegal;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r104 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f258775a = r100;
        this.f258776b = r101;
        this.f258777c = null;
        this.f258778d = r102;
        this.f258779e = r103;
        this.f258780f = r104;
    }
}
