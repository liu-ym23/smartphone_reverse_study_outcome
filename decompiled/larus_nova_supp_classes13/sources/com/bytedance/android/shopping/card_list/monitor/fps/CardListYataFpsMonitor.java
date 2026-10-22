package com.bytedance.android.shopping.card_list.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataFpsMonitor {
    public final Lazy a;
    public final Lazy b;
    public final String c;
    public final JSONObject d;

    public final void a(final RecyclerView r3) {
        CardListRunCatchExtKt.a(this.c, "CardListYataFpsMonitor-start", new CardListYataFpsMonitor$start$1(this, r3));
    }

    public CardListYataFpsMonitor(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "monitorId");
        Intrinsics.checkNotNullParameter(r3, "baseCategory");
        this.c = r2;
        this.d = r3;
        this.a = LazyKt.lazy(CardListYataFpsMonitor$monitorScene$2.INSTANCE);
        this.b = LazyKt.lazy(new CardListYataFpsMonitor$fpsTracker$2(this));
    }
}
