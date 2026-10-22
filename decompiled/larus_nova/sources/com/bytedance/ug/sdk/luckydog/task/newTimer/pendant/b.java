package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements dl7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyDogPendantViewWrapper f272119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f272120b;

    @Override // dl7.c
    public final void onAttach() {
    }

    @Override // dl7.c
    public final void a(dl7.b r100) {
        if (Intrinsics.areEqual(this.f272119a.f272114f.get(this.f272120b), r100) == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "showPendant() onDetach view = " + r100);
        this.f272119a.f272114f.remove(this.f272120b);
        return;
    }

    public b(LuckyDogPendantViewWrapper r100, FrameLayout r101) {
        this.f272119a = r100;
        this.f272120b = r101;
    }
}
