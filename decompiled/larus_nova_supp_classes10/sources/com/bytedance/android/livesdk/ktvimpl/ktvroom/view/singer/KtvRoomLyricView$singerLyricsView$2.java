package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ub0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class KtvRoomLyricView$singerLyricsView$2 extends Lambda implements Function0<KtvAnchorLyricsDisplayView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ KtvRoomLyricView this$0;

    public KtvRoomLyricView$singerLyricsView$2(KtvRoomLyricView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final KtvAnchorLyricsDisplayView invoke() {
        final KtvAnchorLyricsDisplayView r0 = new KtvAnchorLyricsDisplayView(this.$context, null, 6, 0);
        if (this.this$0.getCustomSingerConfig() != null) goto L5;
        r0.c(new KtvRoomLyricView$singerLyricsView$2$$special$$inlined$apply$lambda$1(this));
    L8:
        return r0;
    L5:
        final b r1 = this.this$0.getCustomSingerConfig();
        if (r1 == null) goto L8;
        r0.c(new KtvRoomLyricView$singerLyricsView$2$$special$$inlined$apply$lambda$2(r1, r0, this));
        goto L8
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m407invoke() {
        return invoke();
    }
}
