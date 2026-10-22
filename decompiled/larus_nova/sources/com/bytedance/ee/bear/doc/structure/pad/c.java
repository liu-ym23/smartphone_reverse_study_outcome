package com.bytedance.ee.bear.doc.structure.pad;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CenterLayoutManager f218225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f218226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f218227c;

    public c(CenterLayoutManager r100, int r101, RecyclerView r102) {
        this.f218225a = r100;
        this.f218226b = r101;
        this.f218227c = r102;
    }

    public final void a() {
        View r100 = this.f218225a.findViewByPosition(this.f218226b);
        if (r100 == null) goto L33;
        CenterLayoutManager r101 = this.f218225a;
        RecyclerView r102 = this.f218227c;
        if (r101.getOrientation() != 1) goto L7;
        int r103 = r102.getHeight() / 2;
    L9:
        if (r101.getOrientation() != 1) goto L11;
        int r104 = r100.getTop();
        int r105 = r100.getHeight() / 2;
    L12:
        int r106 = (r104 + r105) - r103;
        View r107 = r101.getChildAt(0);
        if (r107 != null) goto L16;
        int r108 = 0;
    L23:
        int r109 = -r108;
        if (r106 >= r109) goto L26;
        r106 = r109;
    L29:
        if (r101.getOrientation() != 1) goto L31;
        r102.scrollBy(0, r106);
        return;
    L31:
        r102.scrollBy(r106, 0);
        return;
    L26:
        if (r106 <= r108) goto L29;
        r106 = r108;
        goto L29
    L16:
        if (r101.getOrientation() != 1) goto L18;
        int r110 = r107.getHeight();
    L19:
        int r111 = r101.getItemCount() * r110;
        if (r101.getOrientation() != 1) goto L22;
        r108 = RangesKt.coerceAtLeast(r111 - r102.getHeight(), 0);
        goto L23
    L22:
        r108 = RangesKt.coerceAtLeast(r111 - r102.getWidth(), 0);
        goto L23
    L18:
        r110 = r107.getWidth();
        goto L19
    L11:
        r104 = r100.getLeft();
        r105 = r100.getWidth() / 2;
        goto L12
    L7:
        r103 = r102.getWidth() / 2;
        goto L9
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
