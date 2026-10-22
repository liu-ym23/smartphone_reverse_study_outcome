package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class KtvMusicPlayer$bgmProgressListener$1$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KtvMusicPlayer.b this$0;

    public KtvMusicPlayer$bgmProgressListener$1$start$1(KtvMusicPlayer.b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m255invoke() {
        KtvMusicPlayer r0 = this.this$0.a;
        if (r0.i == true) goto L6;
        r0.h = false;
        r0.i = true;
        int r1 = mb0.f.a;
        mb0.f.c(r0.b);
        ee2.a.b("play");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m255invoke();
        return Unit.INSTANCE;
    }
}
