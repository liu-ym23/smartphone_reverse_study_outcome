package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import jg4.i;
import jg4.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KaraokeLyricPresenter$2 implements i {
    public final /* synthetic */ b a;

    public KaraokeLyricPresenter$2(b r1) {
        this.a = r1;
    }

    public final j a(String r8, String r9, String r10, LyricsDisplayConfig r11) {
        Intrinsics.checkNotNullParameter(r8, "url");
        Intrinsics.checkNotNullParameter(r9, "savePath");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        Intrinsics.checkNotNullParameter(r11, "config");
        return new KaraokeLyricPresenter$2$initRequest$1(this, r8, r9, r10, r11);
    }
}
