package com.larus.bmhome.chat.api;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f297243a = null;

    static {
        f297243a = new p();
    }

    public p() {
    }

    @Override // com.larus.bmhome.chat.api.u
    public final void a(ConversationFeedActionType r100, wh8.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "data");
    }
}
