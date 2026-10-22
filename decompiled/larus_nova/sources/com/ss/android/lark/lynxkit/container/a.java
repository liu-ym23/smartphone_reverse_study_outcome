package com.ss.android.lark.lynxkit.container;

import android.view.View;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sqb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f431472c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxView f431473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f431474b;

    /* JADX INFO: renamed from: com.ss.android.lark.lynxkit.container.a$a, reason: collision with other inner class name */
    public static final class C5123a {
    }

    static {
    }

    public final void a() {
        int r100 = this.f431473a.getWidth();
        int r101 = this.f431473a.getHeight();
        if (r100 <= 0) goto L12;
        if (r101 <= 0) goto L12;
        int r102 = RangesKt.coerceAtLeast(r100 - this.f431474b.getIntrinsicWidth(), 0);
        if (this.f431473a.getLayoutDirection() != 1) goto L9;
        b r103 = this.f431474b;
        int r104 = RangesKt.coerceIn((r100 - r103.f543151d) - r103.getIntrinsicWidth(), 0, r102);
    L10:
        b r105 = this.f431474b;
        int r106 = RangesKt.coerceAtLeast((r101 - r105.f543151d) - r105.getIntrinsicHeight(), 0);
        b r107 = this.f431474b;
        r107.setBounds(r104, r106, r107.getIntrinsicWidth() + r104, this.f431474b.getIntrinsicHeight() + r106);
        return;
    L9:
        r104 = RangesKt.coerceAtMost(this.f431474b.f543151d, r102);
    L12:
        this.f431474b.setBounds(0, 0, 0, 0);
    }

    public a(LynxView r100, b r101) {
        this.f431473a = r100;
        this.f431474b = r101;
        r100.getOverlay().add(r101);
        r100.addOnLayoutChangeListener(this);
        a();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        Intrinsics.checkNotNullParameter(r100, "view");
        a();
    }
}
