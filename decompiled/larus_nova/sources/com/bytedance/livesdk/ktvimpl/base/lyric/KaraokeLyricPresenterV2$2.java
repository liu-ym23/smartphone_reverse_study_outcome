package com.bytedance.livesdk.ktvimpl.base.lyric;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import ng4.l;

/* JADX INFO: loaded from: classes20.dex */
public final class KaraokeLyricPresenterV2$2 extends tg4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f256323a;

    public KaraokeLyricPresenterV2$2(b r100) {
        this.f256323a = r100;
    }

    @Override // tg4.a, ng4.j
    public final void b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super.b(r100);
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenterV2$2$onParseSuccess$1(this), 7);
    }

    @Override // tg4.a, ng4.j
    public final void e(final l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenterV2$2$onLyricTransform$1(this, r100), 7);
    }
}
