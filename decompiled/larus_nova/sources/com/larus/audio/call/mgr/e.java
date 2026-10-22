package com.larus.audio.call.mgr;

import com.byted.cast.common.TeaEventTrack;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289250a = 0;

    static {
    }

    public static h a(AVKitDuplexState.DownState r100) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        int r101 = h.f289261c;
        return h.a.a(r100);
    }

    public static h b(AVKitDuplexState.DownState r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        Intrinsics.checkNotNullParameter(r101, "configurePending");
        int r102 = h.f289261c;
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        Intrinsics.checkNotNullParameter(r101, "configurePending");
        return new h(r100, r101);
    }
}
