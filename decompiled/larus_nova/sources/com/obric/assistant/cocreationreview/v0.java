package com.obric.assistant.cocreationreview;

import android.os.Looper;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class v0 implements f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CocreationReviewActivity f387750a;

    public /* synthetic */ v0(CocreationReviewActivity r100) {
        this.f387750a = r100;
    }

    @Override // com.obric.assistant.cocreationreview.f5
    public final void a(final i5 r100) {
        final CocreationReviewActivity r101 = this.f387750a;
        Set<String> r102 = CocreationReviewActivity.P1;
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        r101.runOnUiThread(new l2(r101, r100));
        return;
    L5:
        r101.d2(r100);
    }
}
