package com.bytedance.awemeopen.apps.framework.feed.widget;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke", "(FF)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LiveSkyLightTouchLayout$scrollPredicate$1 extends Lambda implements Function2<Float, Float, Boolean> {
    public static final LiveSkyLightTouchLayout$scrollPredicate$1 INSTANCE = null;

    static {
        INSTANCE = new LiveSkyLightTouchLayout$scrollPredicate$1();
    }

    public LiveSkyLightTouchLayout$scrollPredicate$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).floatValue(), ((Number) r2).floatValue());
    }

    public final Boolean invoke(float r1, float r2) {
        return Boolean.FALSE;
    }
}
