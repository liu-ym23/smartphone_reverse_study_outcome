package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.graphics.Paint;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "invoke"}, k = 3, mv = {1, 5, 1})
final class KtvBaseLyricPresenter$configDisplay$1 extends Lambda implements Function1<LyricsDisplayConfig, Unit> {
    public static final KtvBaseLyricPresenter$configDisplay$1 INSTANCE = null;

    static {
        INSTANCE = new KtvBaseLyricPresenter$configDisplay$1();
    }

    public KtvBaseLyricPresenter$configDisplay$1() {
        super(1);
    }

    public final void invoke(LyricsDisplayConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        final KtvBaseLyricPresenter$configDisplay$1$shadowConfig$1 r0 = KtvBaseLyricPresenter$configDisplay$1$shadowConfig$1.INSTANCE;
        r3.d(new AnonymousClass1(r0));
        r3.b(AnonymousClass2.INSTANCE);
        r3.c(new AnonymousClass3(r0));
        Function1<Paint, Unit> r1 = new AnonymousClass4(r0);
        Intrinsics.checkNotNullParameter(r1, "func");
        r1.invoke(r3.m);
        r3.g = 2;
        r3.e(Paint.Align.RIGHT, 2);
        r3.f(s1.G(s1.y() - ((int) UtilityKotlinExtentionsKt.h(100.0f))));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LyricsDisplayConfig) r1);
        return Unit.INSTANCE;
    }
}
