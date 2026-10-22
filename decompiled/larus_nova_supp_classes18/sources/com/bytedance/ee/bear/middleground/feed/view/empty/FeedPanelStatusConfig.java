package com.bytedance.ee.bear.middleground.feed.view.empty;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.empty.Config;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FeedPanelStatusConfig {
    public final Context a;
    public final String b;
    public final Function0<Config> c;

    public FeedPanelStatusConfig(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lang");
        this.a = r2;
        this.b = r3;
        this.c = new FeedPanelStatusConfig$value$1(this);
    }
}
