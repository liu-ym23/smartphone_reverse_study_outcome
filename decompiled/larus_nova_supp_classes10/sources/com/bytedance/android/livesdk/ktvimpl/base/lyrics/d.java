package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.graphics.Paint;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends KtvBaseLyricPresenter {
    public long b;
    public final int c;
    public final int d;
    public KtvComponentCountDownView e;

    public d(KtvSingAndListenerLyricViewV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "lyricView");
        super(r2);
        this.c = ((Number) KtvSettingHelper.r.getValue()).intValue();
        this.d = s1.f(5.0f);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvBaseLyricPresenter
    public final void a(ub0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "lyricsChangeEvent");
        String r0 = "singer-onLyricsChange:" + r6.a;
        ALogger.i(bb0.b.b().concat("-lyric"), r0 + ", invoke class :" + d.class.getSimpleName());
        super.a(r6);
        if ((r6 instanceof ub0.a.b) == false) goto L34;
        List r1 = r6.a();
        if (r1 == null) goto L33;
        ViewGroup.LayoutParams r2 = null;
        if ((!r1.isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L33;
        com.bytedance.component.lyric.model.b r3 = (com.bytedance.component.lyric.model.b) ListProtector.get(r1, 0);
        if (r3 == null) goto L33;
        KtvComponentCountDownView r4 = this.e;
        if (r4 == null) goto L16;
        r4.setStartTime(r3.b);
    L16:
        KtvComponentCountDownView r5 = this.e;
        if (r5 == null) goto L19;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
    L21:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r2 = r7;
    L24:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r2;
        if (r8 == null) goto L33;
        Paint r9 = this.a.getDisplayConfig().k;
        String r10 = r3.d;
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r8.rightMargin = (int) r9.measureText(r10);
        KtvComponentCountDownView r11 = this.e;
        if (r11 == null) goto L32;
        r11.setLayoutParams(r8);
    L32:
        r8.topMargin = this.d;
        goto L33
    L19:
        r7 = null;
    L33:
        int r12 = mb0.f.a;
        long r13 = r6.a;
        ub0.a.b r14 = (ub0.a.b) r6;
        mb0.f.f(r13, r14.c, r14.b.size());
        return;
    L34:
        KtvComponentCountDownView r15 = this.e;
        if (r15 == null) goto L39;
        r15.setVisibility(8);
        return;
    }
}
