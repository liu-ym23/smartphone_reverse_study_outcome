package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "methodName", "", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class CommonRTCRoomManager_live_link_kmp_implKt$getRoomWrapper$1 extends Lambda implements Function2<String, HashMap<String, Object>, Unit> {
    final /* synthetic */ String $roomId;
    final /* synthetic */ ei6.a $service;

    public CommonRTCRoomManager_live_link_kmp_implKt$getRoomWrapper$1(ei6.a r100, String r101) {
        this.$service = r100;
        this.$roomId = r101;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, HashMap<String, Object> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, HashMap<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "hashMap");
        gi6.e r102 = this.$service.getEventManager();
        if (r102 == null) goto L6;
        EventCategory r103 = EventCategory.RTC_ROOM_EVENT;
        gi6.c r104 = new gi6.c(r100);
        r101.put("eventRoomId", this.$roomId);
        Unit r105 = Unit.INSTANCE;
        r102.d(new gi6.b(r103, r104, r101));
        return;
    }
}
