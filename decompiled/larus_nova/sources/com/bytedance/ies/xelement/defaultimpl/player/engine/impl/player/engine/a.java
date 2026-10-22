package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine;

import android.content.Context;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.MusicPlayerImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements o76.h {
    public a() {
    }

    @Override // o76.h
    public final o76.g a(Context r100, MusicPlayerImpl.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        return new g(r100, r101);
    }
}
