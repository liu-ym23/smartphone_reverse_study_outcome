package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class KtvBaseLyricPresenter {
    public com.bytedance.android.livesdk.ktvimpl.base.lyrics.a a;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ KtvBaseLyricPresenter(KtvSingAndListenerLyricViewV2 r2) {
        KtvContext.Companion.getClass();
        KtvContext.a.g();
        this(r2);
    }

    public void a(final ub0.a r9) {
        Intrinsics.checkNotNullParameter(r9, "lyricsChangeEvent");
        if ((r9 instanceof ub0.a.b) == false) goto L6;
        LyricsDisplayConfig r0 = this.a.getDisplayConfig();
        r0.n = ((ub0.a.b) r9).c;
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvBaseLyricPresenter$onLyricsChange$1(this, r9), 3);
        return;
    L6:
        if ((r9 instanceof ub0.a.a) == false) goto L15;
        Object r10 = this.a;
        if ((r10 instanceof View) == true) goto L10;
        r10 = null;
    L10:
        View r11 = (View) r10;
        if (r11 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r11);
        return;
    L16:
        return;
    }

    public KtvBaseLyricPresenter(com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lyricView");
        this.a = r2;
    }
}
