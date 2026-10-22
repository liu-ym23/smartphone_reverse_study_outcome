package com.bytedance.locallife.biz.mob.interceptor;

import android.content.Context;
import com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements IEventTrackInterceptor {
    public a() {
    }

    @Override // com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor
    public final void a(Context r100, TrackModel r101) {
        Intrinsics.checkNotNullParameter(r101, "trackModel");
        r101.f450808b.a("life_biz_code", "local_life");
    }
}
