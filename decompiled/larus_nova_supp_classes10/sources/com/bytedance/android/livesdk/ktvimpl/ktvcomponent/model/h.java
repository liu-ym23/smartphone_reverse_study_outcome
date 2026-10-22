package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class h extends jg4.j {
    public final long n;

    public final String toString() {
        return this.n + ": " + super.toString();
    }

    public h(long r2, String r4, String r5, String r6, LyricsDisplayConfig r7) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "savePath");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        Intrinsics.checkNotNullParameter(r7, "config");
        super(r4, r5, r6, r7);
        this.n = r2;
    }
}
