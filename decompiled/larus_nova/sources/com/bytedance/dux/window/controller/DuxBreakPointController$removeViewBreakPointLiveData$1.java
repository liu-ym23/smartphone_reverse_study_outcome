package com.bytedance.dux.window.controller;

import android.view.View;
import com.bytedance.dux.common.live_data.NextLiveData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import hm4.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DuxBreakPointController$removeViewBreakPointLiveData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NextLiveData<d> $liveData;
    final /* synthetic */ View $view;
    final /* synthetic */ DuxBreakPointController this$0;

    public DuxBreakPointController$removeViewBreakPointLiveData$1(NextLiveData<d> r100, DuxBreakPointController r101, View r102) {
        this.$liveData = r100;
        this.this$0 = r101;
        this.$view = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$liveData.removeObserver(this.this$0);
        ConcurrentHashMap<Integer, d> r100 = b.f205936a;
        b.d(this.$view, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
