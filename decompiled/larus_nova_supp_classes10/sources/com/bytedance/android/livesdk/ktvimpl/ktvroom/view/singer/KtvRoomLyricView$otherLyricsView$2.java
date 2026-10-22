package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAudienceLyricsDisplayView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class KtvRoomLyricView$otherLyricsView$2 extends Lambda implements Function0<KtvAudienceLyricsDisplayView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ KtvRoomLyricView this$0;

    public KtvRoomLyricView$otherLyricsView$2(KtvRoomLyricView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final KtvAudienceLyricsDisplayView invoke() {
        final KtvAudienceLyricsDisplayView r0 = new KtvAudienceLyricsDisplayView(this.$context, null, 6, 0);
        r0.c(new KtvRoomLyricView$otherLyricsView$2$$special$$inlined$apply$lambda$1(r0, this));
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m406invoke() {
        return invoke();
    }
}
