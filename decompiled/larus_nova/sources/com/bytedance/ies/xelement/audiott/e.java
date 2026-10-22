package com.bytedance.ies.xelement.audiott;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f249765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioFocusRequest f249766b;

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("audio");
        if (r101 == null) goto L7;
        this.f249765a = (AudioManager) r101;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
