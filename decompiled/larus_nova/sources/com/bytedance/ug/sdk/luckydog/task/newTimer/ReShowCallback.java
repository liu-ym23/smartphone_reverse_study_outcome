package com.bytedance.ug.sdk.luckydog.task.newTimer;

import android.widget.FrameLayout;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantStyle;
import java.lang.ref.WeakReference;
import ym7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class ReShowCallback implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<FrameLayout> f271954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout.LayoutParams f271955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f271956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PendantStyle f271957d;

    public static final class a {
    }

    static {
    }

    @Override // ym7.k
    public final void a() {
        final FrameLayout r100 = this.f271954a.get();
        if (r100 == null) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ReShowCallback", "checkPendantShowerIfNeeded service is null, and reShowPendant self");
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new ReShowCallback$reShowPendant$1(this, r100));
        return;
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ReShowCallback", "ReShowCallback root is null");
    }

    public ReShowCallback(WeakReference<FrameLayout> r100, FrameLayout.LayoutParams r101, int r102, PendantStyle r103) {
        this.f271954a = r100;
        this.f271955b = r101;
        this.f271956c = r102;
        this.f271957d = r103;
    }
}
