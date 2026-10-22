package com.f.android.quality.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/f/android/quality/impl/d;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/f/android/quality/impl/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Scene$onEventElaspedTime$1 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ String $customEvent;
    final /* synthetic */ long $duration;

    public Scene$onEventElaspedTime$1(String r100, long r101) {
        this.$customEvent = r100;
        this.$duration = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r100) {
        String r101 = this.$customEvent;
        r100.f274093b.put("custom_event", r101);
        long r102 = this.$duration;
        r100.f274093b.put("duration", Long.valueOf(r102));
        long r103 = this.$duration;
        r100.f274093b.put("valid_duration", Long.valueOf(r103));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
