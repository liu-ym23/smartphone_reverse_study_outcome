package com.bytedance.debugrouter.usb;

import android.net.Uri;
import android.util.Base64;
import com.bytedance.debugrouter.ToastUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.base.usb.TemplateData;
import com.lynx.debugrouter.base.usb.TemplateFileSize;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/debugrouter/usb/USBInsteadNetInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "assembleResponse", "", "rawResponse", "Lcom/bytedance/retrofit2/client/Response;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "reportInterceptError", "", "errorType", "", "errorMsg", "reportInterceptSuccess", "url", "reqId", "", "reportStartIntercept", "DebugRouterServiceImpl_release"}, k = 1, mv = {1, 4, 2})
public final class USBInsteadNetInterceptor implements Interceptor {
    public USBInsteadNetInterceptor() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r100 = r110.request();
        USBTransTemplateUtil r101 = USBTransTemplateUtil.INSTANCE;
        if (r101.isUSBTransTemplateAvailable() == true) goto L7;
        return r110.proceed(r100);
    L7:
        if (r100.getUrl() == null) goto L9;
        Uri r102 = UriProtector.parse(r100.getUrl());
        Iterator<Pair<String, String>> r103 = r101.getUrlSet().iterator();
    L12:
        if (r103.hasNext() == false) goto L18;
        Pair<String, String> r104 = r103.next();
        Objects.toString(r104);
        if (Intrinsics.areEqual(r102.getHost(), r104.getFirst()) == false) goto L12;
        if (Intrinsics.areEqual(String.valueOf(r102.getPort()), r104.getSecond()) == false) goto L12;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r100.getUrl();
        ToastUtil.toast("Transferring the template via USB: " + r100.getUrl(), 0);
        long r106 = USBTransTemplateUtil.INSTANCE.requestData(r100.getUrl());
        reportStartIntercept(r100.getUrl(), r106);
    L23:
        Pair<TreeSet<TemplateData>, TemplateFileSize> r107 = USBTransTemplateUtil.INSTANCE.getTemplateData(r106);
        if (r107 == null) goto L23;
        if (r107.getSecond().isError() == false) goto L29;
        r107.getSecond().getSeqCount();
        ToastUtil.toast("Encountering issues with transferring template via USB, falling back to the original network request.", 0);
        reportInterceptError("dataError", String.valueOf(r107.getSecond().getSeqCount()));
        return r110.proceed(r100);
    L29:
        r100.getUrl();
        r107.getSecond().getFileLen();
        ByteBuffer r108 = ByteBuffer.allocate(r107.getSecond().getFileLen());
        Iterator<TemplateData> r109 = r107.getFirst().iterator();
    L31:
        if (r109.hasNext() == false) goto L33;
        byte[] r111 = Base64.decode(r109.next().getData(), 0);
        int r112 = r111.length;
        r108.put(r111);
        goto L31
    L33:
        Object r113 = null;
        Object r114 = assembleResponse(new Response(r100.getUrl(), 200, "", CollectionsKt.arrayListOf(new Header[]{new Header("Cache-Control", "no-store")}), new TypedByteArray(null, r108.array(), new String[0])), r110);
        if ((r114 instanceof SsResponse) == false) goto L37;
        r113 = r114;
    L37:
        SsResponse<?> r115 = (SsResponse) r113;
        if (r115 != null) goto L41;
        ToastUtil.toast("Assembly of USB data failed, falling back to the original network request.", 0);
        return r110.proceed(r100);
    L41:
        r100.getUrl();
        reportInterceptSuccess(r100.getUrl(), r106);
        return r115;
    L21:
        return r110.proceed(r100);
    L18:
        r105 = false;
        goto L19
    L9:
        return r110.proceed(r100);
    }

    private final Object assembleResponse(Response r110, Interceptor.Chain r111) {
        Field r100 = r111.getClass().getDeclaredField("interceptors");     // Catch: Exception -> L27
        r100.setAccessible(true);     // Catch: Exception -> L27
        Object r112 = r100.get(r111);     // Catch: Exception -> L27
        if ((r112 instanceof List) == true) goto L6;
        r112 = null;
    L6:
        List r113 = (List) r112;     // Catch: Exception -> L27
        if (r113 != null) goto L10;
        reportInterceptError("assembleResponse", "interceptors == null");     // Catch: Exception -> L27
        return null;
    L10:
        Iterator r114 = CollectionsKt.reversed(r113).iterator();     // Catch: Exception -> L27
    L12:
        if (r114.hasNext() == false) goto L16;
        Object r101 = r114.next();     // Catch: Exception -> L27
        if (StringsKt.contains$default(((Interceptor) r101).getClass().getName(), "CallServerInterceptor", false, 2, null) == false) goto L12;
    L17:
        Interceptor r102 = (Interceptor) r101;     // Catch: Exception -> L27
        if (r102 != null) goto L21;
        reportInterceptError("assembleResponse", "callServerInterceptor == null");     // Catch: Exception -> L27
        return null;
    L21:
        Method r115 = r102.getClass().getDeclaredMethod("parseResponse", new Class[]{Response.class, RetrofitMetrics.class});     // Catch: Exception -> L27
        if (r115 != null) goto L25;
        reportInterceptError("assembleResponse", "parseResponseMethod == null");     // Catch: Exception -> L27
        return null;
    L25:
        r115.setAccessible(true);     // Catch: Exception -> L27
        return r115.invoke(r102, new Object[]{r110, null});
    L16:
        r101 = null;
    L27:
        e = move-exception;
        e.getMessage();
        String r116 = e.getMessage();
        if (r116 != null) goto L32;
        r116 = "";
    L32:
        reportInterceptError("assembleResponse", r116);
        return null;
    }

    private final void reportInterceptError(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("type", r100);     // Catch: JSONException -> L5
        r102.put("msg", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBTransTemplateError", r102, null, null);
        return;
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }

    private final void reportInterceptSuccess(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put("url", r100);     // Catch: JSONException -> L5
        r102.put("reqId", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBTransTemplateSuccess", r102, null, null);
        return;
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }

    private final void reportStartIntercept(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put("url", r100);     // Catch: JSONException -> L5
        r102.put("reqId", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBTransTemplateStart", r102, null, null);
        return;
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }
}
