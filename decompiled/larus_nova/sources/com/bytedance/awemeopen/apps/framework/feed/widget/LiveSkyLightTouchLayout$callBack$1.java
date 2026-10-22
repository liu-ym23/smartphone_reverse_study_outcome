package com.bytedance.awemeopen.apps.framework.feed.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LiveSkyLightTouchLayout$callBack$1 extends Lambda implements Function2<Float, Float, Unit> {
    public static final LiveSkyLightTouchLayout$callBack$1 INSTANCE = null;

    static {
        INSTANCE = new LiveSkyLightTouchLayout$callBack$1();
    }

    public LiveSkyLightTouchLayout$callBack$1() {
        super(2);
    }

    public final void invoke(float r100, float r101) {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Float r100, Float r101) {
        invoke(r100.floatValue(), r101.floatValue());
        return Unit.INSTANCE;
    }
}
