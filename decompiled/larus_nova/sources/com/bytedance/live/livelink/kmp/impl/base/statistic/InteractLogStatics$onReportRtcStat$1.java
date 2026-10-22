package com.bytedance.live.livelink.kmp.impl.base.statistic;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class InteractLogStatics$onReportRtcStat$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $eventKey;
    final /* synthetic */ long $rtcTimeCost;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ InteractLogStatics this$0;

    public InteractLogStatics$onReportRtcStat$1(InteractLogStatics r100, String r101, long r102, long r103) {
        this.this$0 = r100;
        this.$eventKey = r101;
        this.$timestamp = r102;
        this.$rtcTimeCost = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JsonObject r100 = InteractLogStatics.j(this.this$0, this.$eventKey, Long.valueOf(this.$timestamp));
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.$rtcTimeCost <= 0) goto L8;
        String r101 = "success";
    L9:
        r100.addProperty("result", r101);
        r100.addProperty("stat_elapsed", Long.valueOf(this.$rtcTimeCost));
        InteractLogStatics.k(this.this$0, r100);
        return;
    L8:
        r101 = "failed";
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
