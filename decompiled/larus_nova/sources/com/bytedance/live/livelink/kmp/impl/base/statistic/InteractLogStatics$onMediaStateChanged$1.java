package com.bytedance.live.livelink.kmp.impl.base.statistic;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class InteractLogStatics$onMediaStateChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $linkId;
    final /* synthetic */ String $message;
    final /* synthetic */ int $state;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ InteractLogStatics this$0;

    public InteractLogStatics$onMediaStateChanged$1(InteractLogStatics r100, long r101, String r102, int r103, String r104) {
        this.this$0 = r100;
        this.$timestamp = r101;
        this.$message = r102;
        this.$state = r103;
        this.$linkId = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JsonObject r100 = InteractLogStatics.j(this.this$0, "rtc_media_state_changed", Long.valueOf(this.$timestamp));
        if (r100 != null) goto L5;
        return;
    L5:
        r100.addProperty("message", this.$message);
        r100.addProperty("state", Integer.valueOf(this.$state));
        r100.addProperty("remote_rtc_user_id", this.$linkId);
        InteractLogStatics.k(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
