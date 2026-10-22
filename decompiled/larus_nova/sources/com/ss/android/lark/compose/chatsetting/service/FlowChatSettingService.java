package com.ss.android.lark.compose.chatsetting.service;

import b38.b;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.GenLarkReportUrlRequest;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowChatSettingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowChatSettingService f417519a = null;

    static {
        f417519a = new FlowChatSettingService();
    }

    public FlowChatSettingService() {
    }

    public final Object a(String r100, Continuation<? super RucketJob<GenLarkReportUrlResponse>> r101) {
        if ((r101 instanceof FlowChatSettingService$getReportUrl$1) == false) goto L7;
        FlowChatSettingService$getReportUrl$1 r102 = (FlowChatSettingService$getReportUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        RucketJobImpl r107 = (RucketJobImpl) r102.L$0;
        ResultKt.throwOnFailure(r104);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Intrinsics.checkNotNullParameter(r100, "chatId");
        long r108 = CastLongProtector.parseLong(r100);     // Catch: Throwable -> L24
        int r109 = com.ss.android.lark.language.service.impl.a.f431092f;
        Locale r110 = com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting();
        StringBuilder r111 = new StringBuilder();
        String r112 = r110.getLanguage();
        String r113 = "";
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        r111.append(r112);
        r111.append('-');
        String r114 = r110.getCountry();
        if (r114 == null) goto L23;
        r113 = r114;
    L23:
        r111.append(r113);
        String r115 = r111.toString();
        GenLarkReportUrlRequest.Builder r116 = new GenLarkReportUrlRequest.Builder().chat_id(Long.valueOf(r108)).lang_type(r115);
    L26:
        if (r116 != null) goto L28;
        RucketJobImpl r117 = new RucketJobImpl();
        ErrorResult r118 = new ErrorResult("generate request failed");
        r102.L$0 = r117;
        r102.label = 1;
        if (r117.setError(r118, r102) != r105) goto L35;
        return r105;
    L35:
        return r117;
    L28:
        return ((a) b.f17382a.create(a.class)).getReportUrl(r116.build());
    L24:
        th = move-exception;
        Log.e("FlowChatSettingService", th);
        r116 = null;
    L7:
        r102 = new FlowChatSettingService$getReportUrl$1(this, r101);
        goto L8
    }
}
