package com.larus.basic.experience.downgrade.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.network.http.a;
import com.larus.network.http.v;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import juc.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jz\u0010\u0004\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010\u0012J¨\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0014\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010\u001aJ¨\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0014\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010\u001aJª\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0014\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010 JÐ\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0014\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010!*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u0002H!2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00060$2\u0006\u0010\u001d\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010&Jª\u0001\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0014\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010 ¨\u0006("}, d2 = {"Lcom/larus/basic/experience/downgrade/api/FlowDowngradeServiceDelegate;", "Lcom/larus/basic/experience/downgrade/api/IFlowDowngradeService;", "<init>", "()V", "getIsAuto", "", ExifInterface.GPS_DIRECTION_TRUE, "", "path", "", "outClazz", "Ljava/lang/Class;", "bodyJson", "Lorg/json/JSONObject;", "queryMap", "", "headerMap", "extra", "(Ljava/lang/String;Ljava/lang/Class;Lorg/json/JSONObject;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/Boolean;", "requestGet", "Lcom/larus/network/http/Async;", "tag", "needTrace", "metric", "requestContext", "Lcom/bytedance/ttnet/http/RequestContext;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGetMock", "requestPost", "contentType", "requestChangeListener", "Lcom/larus/network/http/INetRequestListener;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Req", "requestBody", "bodySerializer", "Lkotlinx/serialization/KSerializer;", "responseSerializer", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPostMock", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDowngradeServiceDelegate implements IFlowDowngradeService {
    public static final FlowDowngradeServiceDelegate INSTANCE = null;
    private final /* synthetic */ IFlowDowngradeService $$delegate_0;

    static {
        INSTANCE = new FlowDowngradeServiceDelegate();
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T> Boolean getIsAuto(String r100, Class<T> r110, JSONObject r111, Map<String, String> r112, Map<String, String> r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r110, "outClazz");
        Intrinsics.checkNotNullParameter(r111, "bodyJson");
        return this.$$delegate_0.getIsAuto(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T> Object requestGet(String r110, Class<T> r111, String r112, Map<String, String> r113, Map<String, String> r114, boolean r115, Map<String, ? extends Object> r116, RequestContext r210, Map<String, String> r211, Continuation<? super a<? extends T>> r212) {
        return this.$$delegate_0.requestGet(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T> Object requestGetMock(String r110, Class<T> r111, String r112, Map<String, String> r113, Map<String, String> r114, boolean r115, Map<String, ? extends Object> r116, RequestContext r210, Map<String, String> r211, Continuation<? super a<? extends T>> r212) {
        return this.$$delegate_0.requestGetMock(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T, Req> Object requestPost(String r110, Class<T> r111, String r112, Req r210, d<Req> r211, d<T> r212, String r213, Map<String, String> r214, boolean r215, Map<String, ? extends Object> r216, RequestContext r217, v r218, Map<String, String> r219, Continuation<? super a<? extends T>> r310) {
        return this.$$delegate_0.requestPost(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T> Object requestPost(String r110, Class<T> r111, String r112, JSONObject r113, String r114, Map<String, String> r210, boolean r211, Map<String, ? extends Object> r212, RequestContext r213, v r214, Map<String, String> r215, Continuation<? super a<? extends T>> r216) {
        return this.$$delegate_0.requestPost(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // com.larus.basic.experience.downgrade.api.IFlowDowngradeService
    public <T> Object requestPostMock(String r110, Class<T> r111, String r112, JSONObject r113, String r114, Map<String, String> r210, boolean r211, Map<String, ? extends Object> r212, RequestContext r213, v r214, Map<String, String> r215, Continuation<? super a<? extends T>> r216) {
        return this.$$delegate_0.requestPostMock(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    private FlowDowngradeServiceDelegate() {
        IFlowDowngradeService r100 = (IFlowDowngradeService) ServiceManager.get().getService(IFlowDowngradeService.class);
        if (r100 != null) goto L5;
        r100 = new FlowDowngradeServiceNoop();
    L5:
        this.$$delegate_0 = r100;
    }
}
