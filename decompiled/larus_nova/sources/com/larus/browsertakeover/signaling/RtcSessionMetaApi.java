package com.larus.browsertakeover.signaling;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.larus.im.internal.jni.bean.RoomMeta;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/signaling/RtcSessionMetaApi;", "", "sessionMeta", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/browsertakeover/signaling/RtcSessionMetaData;", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RtcSessionMetaApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f319590a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f319591a = null;

        static {
            f319591a = new Companion();
        }

        public Companion() {
        }

        public final Object a(String r110, Continuation<? super RoomMeta> r111) {
            if ((r111 instanceof RtcSessionMetaApi$Companion$refresh$1) == false) goto L7;
            RtcSessionMetaApi$Companion$refresh$1 r100 = (RtcSessionMetaApi$Companion$refresh$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = r100.label;
            boolean r114 = true;
            if (r102 == 0) goto L14;
            if (r102 != 1) goto L13;
            r110 = (String) r100.L$0;
            ResultKt.throwOnFailure(r112);
        L20:
            dm9.a r115 = (dm9.a) r112;
            JobKt.ensureActive(r100.getContext());
            if ((r115 instanceof dm9.a.b) == false) goto L41;
            BizResponse<T> r116 = ((dm9.a.b) r115).f469231a;
            if (r116.isSuccess() == true) goto L25;
            return null;
        L25:
            RtcSessionMetaData r117 = (RtcSessionMetaData) r116.getData();
            if (r117 == null) goto L45;
            RtcRoomMetaData r118 = r117.getRoomMeta();
            if (r118 == null) goto L46;
            RoomMeta r119 = r118.toRoomMeta();
            if (r119 != null) goto L32;
            return null;
        L32:
            if (j.b(r119) == true) goto L34;
        L36:
            r114 = false;
        L37:
            if (r114 == true) goto L39;
            return null;
        L39:
            return r119;
        L34:
            if (Intrinsics.areEqual(r119.sessionId, r110) == false) goto L36;
        L46:
            return null;
        L45:
            return null;
        L41:
            if ((r115 instanceof dm9.a.C5690a) == false) goto L44;
            return null;
        L44:
            throw new NoWhenBranchMatchedException();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r112);
            if (StringsKt.isBlank(r110) == false) goto L17;
            return null;
        L17:
            FlowHttpConnection r120 = FlowHttpConnection.f359975a;
            RtcSessionMetaApi$Companion$refresh$result$1 r103 = new RtcSessionMetaApi$Companion$refresh$result$1(r110, null);
            r100.L$0 = r110;
            r100.label = 1;
            r112 = FlowHttpConnection.g(ServiceType.MAIN_BOT, RtcSessionMetaApi.class, r103, false, null, null, null, r100, 240);
            if (r112 != r113) goto L20;
            return r113;
        L7:
            r100 = new RtcSessionMetaApi$Companion$refresh$1(this, r111);
            goto L8
        }
    }

    static {
        f319590a = Companion.f319591a;
    }

    @GET("/alice/dispatch/rtc/session_meta")
    Object sessionMeta(@Query("session_id") String r100, Continuation<? super BizResponse<RtcSessionMetaData>> r101);
}
