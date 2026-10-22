package com.bytedance.locallife.adapter.live.impl.host.live;

import android.content.Context;
import com.bytedance.locallife.live.dsl.GXFastPreviewSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import it6.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements g {
    public c() {
    }

    @Override // it6.g
    public final void a() {
    }

    @Override // it6.g
    public final void b() {
    }

    @Override // it6.g
    public final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "name");
    }

    @Override // it6.g
    public final void d(GXFastPreviewSource r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // it6.g
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // it6.g
    public final void isPPEEnable() {
    }
}
