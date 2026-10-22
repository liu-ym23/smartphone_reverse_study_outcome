package com.bytedance.android.livesdk.ktvimpl.ksong.base.view;

import android.graphics.Paint;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAudienceLyricsDisplayView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class KtvComponentFeedView$ktvLyricsView$2 extends Lambda implements Function0<KtvAudienceLyricsDisplayView> {
    final /* synthetic */ KtvComponentFeedView this$0;

    public KtvComponentFeedView$ktvLyricsView$2(KtvComponentFeedView r1) {
        this.this$0 = r1;
        super(0);
    }

    public final KtvAudienceLyricsDisplayView invoke() {
        KtvAudienceLyricsDisplayView r0 = (KtvAudienceLyricsDisplayView) this.this$0.findViewById(2131376976);
        if (r0 == null) goto L5;
        r0.setLyricTextAlign(Paint.Align.RIGHT);
        r0.setOneLineMaxWidth(0.0f);
        r0.c(KtvComponentFeedView$ktvLyricsView$2$1$1.INSTANCE);
        r0.a(new KtvComponentFeedView$ktvLyricsView$2$$special$$inlined$apply$lambda$1(this));
        return r0;
    L5:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m263invoke() {
        return invoke();
    }
}
