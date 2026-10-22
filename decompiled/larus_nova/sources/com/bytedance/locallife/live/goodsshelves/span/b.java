package com.bytedance.locallife.live.goodsshelves.span;

import android.view.View;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f259881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f259882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f259883d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f259883d = 3;
        d r101 = this.f259882c;
        if (r101 == null) goto L6;
        r101.onCancel(this.f259880a);
        return;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        this.f259880a = r100;
        this.f259881b = r101;
    }
}
