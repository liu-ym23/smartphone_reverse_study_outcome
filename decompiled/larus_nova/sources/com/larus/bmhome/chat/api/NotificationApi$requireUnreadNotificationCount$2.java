package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.resp.UnreadNotificationCount;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/resp/UnreadNotificationCount;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$requireUnreadNotificationCount$2", f = "NotificationApi.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationApi$requireUnreadNotificationCount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UnreadNotificationCount>, Object> {
    final /* synthetic */ List<Integer> $notificationGroups;
    final /* synthetic */ String $source;
    int label;

    public NotificationApi$requireUnreadNotificationCount$2(List<Integer> r100, String r101, Continuation<? super NotificationApi$requireUnreadNotificationCount$2> r102) {
        this.$notificationGroups = r100;
        this.$source = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new NotificationApi$requireUnreadNotificationCount$2(this.$notificationGroups, this.$source, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super UnreadNotificationCount> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super UnreadNotificationCount> r101) {
        return ((NotificationApi$requireUnreadNotificationCount$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r100 = this.label;
        if (r100 == 0) goto L8;
        if (r100 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
        Object r101 = r110;
    L16:
        return ((com.larus.network.http.a) r101).f360135b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        FLogger.f375446a.i("NotificationApi", "requireUnreadNotificationCount: " + this.$notificationGroups);
        JSONArray r102 = new JSONArray();
        Iterator<T> r103 = this.$notificationGroups.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        r102.put(((Number) r103.next()).intValue());
        goto L10
    L12:
        FlowDowngradeServiceDelegate r104 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("groups", r102);
        Unit r106 = Unit.INSTANCE;
        Map r112 = MapsKt.mapOf(TuplesKt.to("source", this.$source));
        this.label = 1;
        r101 = IFlowDowngradeService.a.b(r104, ServiceType.BASIC_SERVICE, UnreadNotificationCount.class, "/alice/notice/get_unread_count", r105, null, false, null, r112, this, 1008);
        if (r101 != r111) goto L16;
        return r111;
    }
}
