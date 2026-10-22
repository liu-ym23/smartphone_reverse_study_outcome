package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.ECReplayScrollProductCardDataSourceFactory;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public ECScrollProductCardDataSourceFactory a;
    public ECReplayScrollProductCardDataSourceFactory b;
    public final c c;
    public final b d;
    public final com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a e;

    public a(AbsECScrollProductCardBaseVideModel r2, AbsECScrollProductCardBaseVideModel r3, AbsECScrollProductCardBaseVideModel r4) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "replayCallback");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
