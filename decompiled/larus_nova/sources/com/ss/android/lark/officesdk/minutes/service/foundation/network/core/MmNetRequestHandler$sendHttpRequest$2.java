package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import hvb.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2", f = "MmNetRequestHandler.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"path"}, s = {"L$0"})
public final class MmNetRequestHandler$sendHttpRequest$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends R>>, Object> {
    final /* synthetic */ gvb.a $request;
    final /* synthetic */ Class<R> $respType;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmNetRequestHandler this$0;

    public MmNetRequestHandler$sendHttpRequest$2(gvb.a r100, MmNetRequestHandler r101, Class<R> r102, Continuation<? super MmNetRequestHandler$sendHttpRequest$2> r103) {
        this.$request = r100;
        this.this$0 = r101;
        this.$respType = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmNetRequestHandler$sendHttpRequest$2(this.$request, this.this$0, this.$respType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super Result<? extends R>> r101) {
        return ((MmNetRequestHandler$sendHttpRequest$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2$2$callBack$1, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        MmNetRequestHandler r102 = (MmNetRequestHandler) this.L$3;
        Class r103 = (Class) this.L$2;
        gvb.a r104 = (gvb.a) this.L$1;
        String r105 = (String) this.L$0;
        ResultKt.throwOnFailure(r210);
        return r210;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r210);
        final String r106 = this.$request.getPath();
        MmNetRequestHandler r107 = this.this$0;
        int r108 = MmNetRequestHandler.f433892c;
        Result<R> r109 = r107.e(r106);
        if (r109 != null) goto L11;
        final gvb.a r110 = this.$request;
        final Class<R> r111 = this.$respType;
        final MmNetRequestHandler r112 = this.this$0;
        this.L$0 = r106;
        this.L$1 = r110;
        this.L$2 = r111;
        this.L$3 = r112;
        this.label = 1;
        final SafeContinuation r113 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        MmHttpMethod r114 = r110.getMethod();
        MmHttpContentType r115 = r110.getContentType();
        Map<String, String> r116 = r110.a();
        Map<String, String> r117 = r110.e();
        Map<String, String> r118 = r110.f();
        String r119 = r110.c();
        ByteString r120 = r110.b();
        if (r118.isEmpty() == false) goto L23;
        if (r119 != null) goto L16;
    L19:
        boolean r121 = true;
    L20:
        if (r121 == false) goto L23;
        if (r120 != null) goto L23;
        boolean r122 = true;
    L24:
        lvb.a.e("MmNetRequestHandler", "sendHttpRequest: path=" + r106 + ", method=" + r114 + ", contentType=" + r115 + ", respType=" + r111 + ", request=" + r110);
        String r123 = r112.f433894b.J().b();
        if (r116.isEmpty() == false) goto L27;
        String r124 = r123 + r106;
    L55:
        MmRecordingSource r125 = r110.getClientSource();
        int r126 = hvb.a.f487360a;
        int r127 = hvb.c.f487362a;
        ArrayList r128 = new ArrayList();
        HttpHeader.Builder r129 = new HttpHeader.Builder().name("app-id");
        LarkAppContext.Companion.getClass();
        r128.add(r129.value(String.valueOf(LarkAppContext.access$getInstance$cp().appIdInfo().f18218a)).build());
        r128.add(new HttpHeader.Builder().name("m-version").value("").build());
        r128.add(new HttpHeader.Builder().name("m-locale").value(com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a()).build());
        HttpHeader.Builder r130 = new HttpHeader.Builder().name("device-id");
        IDeviceInfoProvider r131 = OfficeSDKManager.getDeviceInfoProvider();
        if (r131 == null) goto L59;
        String r132 = r131.getDeviceId();
        if (r132 == null) goto L59;
    L60:
        r128.add(r130.value(r132).build());
        r128.add(new HttpHeader.Builder().name("request-id").value("mm#" + SystemClock.elapsedRealtimeNanos()).build());
        r128.add(new HttpHeader.Builder().name("platform").value("android").build());
        r128.add(new HttpHeader.Builder().name(AppConstants.HTTP_H_REFERER).value(r112.f433894b.J().b()).build());
        if (r125 != null) goto L63;
    L70:
        if (r122 == true) goto L75;
        if (r115 == MmHttpContentType.CUSTOM) goto L75;
        r128.add(new HttpHeader.Builder().name("Content-Type").value(r115.getValue()).build());
    L75:
        if ((!r117.isEmpty()) == false) goto L80;
        Iterator<T> r133 = r117.keySet().iterator();
    L78:
        if (r133.hasNext() == false) goto L80;
        String r134 = (String) r133.next();
        r128.add(new HttpHeader.Builder().name(r134).value(r117.get(r134)).build());
    L80:
        HttpHeaderMap r135 = new HttpHeaderMap.Builder().headers(r128).build();
        if (r120 != null) goto L108;
        if (r119 == null) goto L86;
        ByteString.Companion.getClass();
        r120 = ByteString.a.b(r119);
        goto L108
    L86:
        if (r118.isEmpty() == false) goto L88;
        ByteString.Companion.getClass();
        r120 = ByteString.a.b("");
        goto L108
    L88:
        int r136 = MmNetRequestHandler.b.f433896b[r115.ordinal()];
        if (r136 != 1) goto L91;
        String r137 = GsonProtectorUtils.toJson(new Gson(), r118);
        if (r137 != null) goto L106;
    L105:
        String r138 = "";
    L107:
        ByteString.Companion.getClass();
        r120 = ByteString.a.b(r138);
        goto L108
    L106:
        r138 = r137;
        goto L107
    L91:
        if (r136 != 2) goto L105;
        if ((!r118.isEmpty()) == false) goto L105;
        Iterator<Map.Entry<String, String>> r139 = r118.entrySet().iterator();
        r138 = "";
    L97:
        if (r139.hasNext() == false) goto L107;
        Map.Entry<String, String> r140 = r139.next();
        StringBuilder r141 = new StringBuilder();
        r141.append(r138);
        if (TextUtils.isEmpty(r138) == true) goto L101;
        String r142 = "&" + r140.getKey() + com.alipay.sdk.m.n.a.f25612h + r140.getValue();
    L102:
        r141.append(r142);
        r138 = r141.toString();
        goto L97
    L101:
        r142 = r140.getKey() + com.alipay.sdk.m.n.a.f25612h + r140.getValue();
    L108:
        UserSendHttpRequest.Builder r143 = new UserSendHttpRequest.Builder().url(r124);
        int r144 = MmNetRequestHandler.b.f433897c[r114.ordinal()];
        if (r144 != 1) goto L111;
        HttpMethod r145 = HttpMethod.GET;
    L125:
        UserSendHttpRequest r146 = r143.method(r145).headers(r135).body(r120).disable_cookie(Boxing.boxBoolean(false)).build();
        Intrinsics.checkNotNull(r146, "null cannot be cast to non-null type com.squareup.wire.Message<*, *>");
        ProtoAdapter r147 = ProtoAdapter.get(UserSendHttpResponse.class);
        Intrinsics.checkNotNull(r147, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r148 = new MmNetRequestHandler$sendHttpRequest$2$2$callBack$1(r112, r106, r113, r111, r110);
        int r149 = g.f487369a;
        l r150 = r112.f433893a;
        Intrinsics.checkNotNullParameter(r150, "rustClient");
        Intrinsics.checkNotNullParameter(r146, "request");
        Intrinsics.checkNotNullParameter(r148, "callBack");
        Intrinsics.checkNotNullParameter(r147, "responseProtoAdapter");
        lvb.a.e("RustSdkBridge", "[sendHttp] request=" + r146);
        Ref.ObjectRef r151 = new Ref.ObjectRef();
        r151.element = r150.h(new com.bytedance.lark.rustclient.api.d(r146.newBuilder(), r147, Command.USER_SEND_HTTP, null, null, null, null, 248)).a().subscribe(new hvb.d(r148, r151));
        Object r152 = r113.getOrThrow();
        if (r152 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L129;
        DebugProbesKt.probeCoroutineSuspended(this);
    L129:
        if (r152 != r100) goto L145;
        return r100;
    L145:
        return r152;
    L111:
        if (r144 != 2) goto L113;
        r145 = HttpMethod.POST;
        goto L125
    L113:
        if (r144 != 3) goto L115;
        r145 = HttpMethod.PUT;
        goto L125
    L115:
        if (r144 != 4) goto L117;
        r145 = HttpMethod.DELETE;
        goto L125
    L117:
        if (r144 != 5) goto L120;
        r145 = HttpMethod.PATCH;
        goto L125
    L120:
        throw new NoWhenBranchMatchedException();
    L63:
        switch(MmNetRequestHandler.b.f433895a[r125.ordinal()]) {
            case 1: goto L68;
            case 2: goto L68;
            case 3: goto L68;
            case 4: goto L68;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L67;
            case 8: goto L67;
            case 9: goto L67;
            case 10: goto L67;
            case 11: goto L67;
            case 12: goto L66;
            default: goto L65;
        };
    L66:
        String r153 = "2";
    L69:
        r128.add(new HttpHeader.Builder().name("x-mm-client-source").value(r153).build());
        goto L70
    L67:
        r153 = "1";
        goto L69
    L68:
        r153 = "0";
        goto L69
    L65:
        throw new NoWhenBranchMatchedException();
    L59:
        r132 = "";
        goto L60
    L27:
        StringBuilder r154 = new StringBuilder();
        r154.append(r123);
        int r155 = hvb.a.f487360a;
        Intrinsics.checkNotNullParameter(r106, "baseUrl");
        Intrinsics.checkNotNullParameter(r116, "params");
        StringBuilder r156 = new StringBuilder();
        r156.append(r106);
        if (StringsKt.endsWith$default(r106, "?", false, 2, null) == true) goto L30;
        r156.append("?");
    L30:
        Iterator<Map.Entry<String, String>> r157 = r116.entrySet().iterator();
        boolean r158 = true;
    L32:
        if (r157.hasNext() == false) goto L54;
        Map.Entry<String, String> r159 = r157.next();
        String r160 = r159.getKey();
        String r161 = r159.getValue();
        int r162 = hvb.b.f487361a;
        r161 = URLEncoder.encode(r161, "UTF-8");     // Catch: Exception -> L36
    L39:
        if (r160.length() <= 0) goto L41;
        boolean r163 = true;
    L42:
        if (r163 == false) goto L32;
        if (r161 != null) goto L45;
    L48:
        boolean r164 = true;
    L49:
        if (r164 == true) goto L32;
        if (r158 == true) goto L52;
        r156.append("&");
    L53:
        r156.append(r160);
        r156.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r156.append(r161);
        goto L32
    L52:
        r158 = false;
        goto L53
    L45:
        if (r161.length() == 0) goto L48;
        r164 = false;
        goto L49
    L41:
        r163 = false;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L54:
        r154.append(r156.toString());
        r124 = r154.toString();
        goto L55
    L16:
        if (r119.length() == 0) goto L19;
        r121 = false;
    L23:
        r122 = false;
        goto L24
    L11:
        return Result.m9448boximpl(r109.m9458unboximpl());
    }
}
