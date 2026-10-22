package com.larus.basic.experience.downgrade.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.network.http.v;
import java.util.Map;
import juc.d;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J¸\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u0017JÞ\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\b\b\u0001\u0010\u0018*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u0002H\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00040\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00062\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u001dJ´\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010 J¸\u0001\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u0017J´\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010 J\u007f\u0010#\u001a\u0004\u0018\u00010\u0010\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH&¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"Lcom/larus/basic/experience/downgrade/api/IFlowDowngradeService;", "", "requestPost", "Lcom/larus/network/http/Async;", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", "outClazz", "Ljava/lang/Class;", "path", "bodyJson", "Lorg/json/JSONObject;", "contentType", "headerMap", "", "needTrace", "", "metric", "requestContext", "Lcom/bytedance/ttnet/http/RequestContext;", "requestChangeListener", "Lcom/larus/network/http/INetRequestListener;", "extra", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Req", "requestBody", "bodySerializer", "Lkotlinx/serialization/KSerializer;", "responseSerializer", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGet", "queryMap", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPostMock", "requestGetMock", "getIsAuto", "(Ljava/lang/String;Ljava/lang/Class;Lorg/json/JSONObject;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/Boolean;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowDowngradeService {

    public static final class a {
        public static /* synthetic */ Boolean a(FlowDowngradeServiceDelegate r100, Class r101, JSONObject r102, Map r110) {
            return r100.getIsAuto("/profile/collection/list/collection/", r101, r102, null, null, r110);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object b(FlowDowngradeServiceDelegate r110, String r111, Class r112, String r113, JSONObject r210, Map r211, boolean r212, Map r213, Map r214, Continuation r215, int r216) {
            if ((r216 & 16) == 0) goto L5;
            String r100 = "application/json";
        L7:
            if ((r216 & 32) == 0) goto L9;
            Map r101 = MapsKt.emptyMap();
        L11:
            if ((r216 & 64) == 0) goto L13;
            boolean r114 = false;
        L15:
            if ((r216 & 128) == 0) goto L17;
            Map r115 = null;
        L19:
            if ((r216 & 1024) == 0) goto L21;
            Map r116 = null;
        L23:
            return r110.requestPost(r111, r112, r113, r210, r100, r101, r114, r115, null, null, r116, r215);
        L21:
            r116 = r214;
            goto L23
        L17:
            r115 = r213;
            goto L19
        L13:
            r114 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = null;
            goto L7
        }
    }

    <T> Boolean getIsAuto(String r100, Class<T> r101, JSONObject r102, Map<String, String> r103, Map<String, String> r104, Map<String, String> r105);

    <T> Object requestGet(String r100, Class<T> r101, String r102, Map<String, String> r103, Map<String, String> r104, boolean r105, Map<String, ? extends Object> r106, RequestContext r107, Map<String, String> r108, Continuation<? super com.larus.network.http.a<? extends T>> r110);

    <T> Object requestGetMock(String r100, Class<T> r101, String r102, Map<String, String> r103, Map<String, String> r104, boolean r105, Map<String, ? extends Object> r106, RequestContext r107, Map<String, String> r108, Continuation<? super com.larus.network.http.a<? extends T>> r110);

    <T, Req> Object requestPost(String r100, Class<T> r101, String r102, Req r103, d<Req> r104, d<T> r105, String r106, Map<String, String> r107, boolean r108, Map<String, ? extends Object> r110, RequestContext r111, v r112, Map<String, String> r113, Continuation<? super com.larus.network.http.a<? extends T>> r114);

    <T> Object requestPost(String r100, Class<T> r101, String r102, JSONObject r103, String r104, Map<String, String> r105, boolean r106, Map<String, ? extends Object> r107, RequestContext r108, v r110, Map<String, String> r111, Continuation<? super com.larus.network.http.a<? extends T>> r112);

    <T> Object requestPostMock(String r100, Class<T> r101, String r102, JSONObject r103, String r104, Map<String, String> r105, boolean r106, Map<String, ? extends Object> r107, RequestContext r108, v r110, Map<String, String> r111, Continuation<? super com.larus.network.http.a<? extends T>> r112);
}
