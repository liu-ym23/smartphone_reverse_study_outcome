package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import jg4.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KaraokeLyricPresenter$2$initRequest$1 extends j {
    public final /* synthetic */ KaraokeLyricPresenter$2 n;

    public final void b(j r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        c.a("KaraokeLyricPresenter", "onParseSuccess, request = " + r8);
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenter$2$initRequest$1$onParseSuccess$1(this), 7);
    }

    public final void d(final j r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        super.d(r8);
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenter$2$initRequest$1$onLyricTransform$1(this, r8), 7);
    }

    public final void i(j r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        c.a("KaraokeLyricPresenter", "onParseFail, errorMsg = " + r4 + ", request = " + r3);
    }

    public KaraokeLyricPresenter$2$initRequest$1(KaraokeLyricPresenter$2 r1, String r2, String r3, String r4, LyricsDisplayConfig r5) {
        this.n = r1;
        super(r2, r3, r4, r5);
    }
}
