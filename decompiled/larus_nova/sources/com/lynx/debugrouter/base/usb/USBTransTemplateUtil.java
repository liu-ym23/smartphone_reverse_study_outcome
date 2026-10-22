package com.lynx.debugrouter.base.usb;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.MessageTransceiverStateListener;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.base.service.DebugRouterServiceCenter;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import y5a.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\"\u0010\u001d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\tJ\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a0 J\u0006\u0010!\u001a\u00020\rJ\u0016\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0016J\u0016\u0010$\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0018J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/lynx/debugrouter/base/usb/USBTransTemplateUtil;", "", "()V", "TAG", "", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "globalRequestId", "", "ipPortRegex", "Lkotlin/text/Regex;", "mIsDebugPlatformSupport", "", "mTransceiver", "Lcom/lynx/debugrouter/base/MessageTransceiver;", "mUSBIsEnabled", "requestTimeOutTask", "", "Ljava/util/concurrent/ScheduledFuture;", "responseMap", "Ljava/util/TreeSet;", "Lcom/lynx/debugrouter/base/usb/TemplateData;", "responseSize", "Lcom/lynx/debugrouter/base/usb/TemplateFileSize;", "urlMap", "Lkotlin/Pair;", "addInterceptor", "", "getTemplateData", "reqId", "getUrlSet", "", "isUSBTransTemplateAvailable", "receiveData", "data", "receiveResponseSize", "size", "reportOpenCardUrl", "url", "requestData", "setDebugPlatformSupport", "support", "setUSBTransceiver", "transceiver", "updateUrlSet", "USBTransTemplateTransceiverListener", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class USBTransTemplateUtil {
    public static final USBTransTemplateUtil INSTANCE = null;
    private static final String TAG = "USBTransTemplateUtil";
    private static final ScheduledExecutorService executor = null;
    private static volatile long globalRequestId;
    private static final Regex ipPortRegex = null;
    private static boolean mIsDebugPlatformSupport;
    private static volatile MessageTransceiver mTransceiver;
    private static volatile boolean mUSBIsEnabled;
    private static Map<Long, ScheduledFuture<?>> requestTimeOutTask;
    private static Map<Long, TreeSet<TemplateData>> responseMap;
    private static Map<Long, TemplateFileSize> responseSize;
    private static final Map<Pair<String, String>, Boolean> urlMap = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/lynx/debugrouter/base/usb/USBTransTemplateUtil$USBTransTemplateTransceiverListener;", "Lcom/lynx/debugrouter/base/MessageTransceiverStateListener;", "()V", "onClose", "", "transceiver", "Lcom/lynx/debugrouter/base/MessageTransceiver;", "code", "", "reason", "", LynxVideoManagerLite.EVENT_ON_ERROR, "t", "", "onMessage", "text", "onOpen", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class USBTransTemplateTransceiverListener implements MessageTransceiverStateListener {
        public static final USBTransTemplateTransceiverListener INSTANCE = null;

        static {
            INSTANCE = new USBTransTemplateTransceiverListener();
        }

        private USBTransTemplateTransceiverListener() {
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onOpen(MessageTransceiver r100) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(true);
            USBTransTemplateUtil.access$getUrlMap$p().clear();
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onError(MessageTransceiver r100, Throwable r101) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(false);
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onMessage(MessageTransceiver r100, String r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (StringsKt.indexOf$default(r101, "OpenCard", 0, false, 6, null) == (-1)) goto L26;
            Object r102 = new JSONObject(r101).opt("data");
            String r103 = null;
            if ((r102 instanceof JSONObject) == false) goto L8;
            JSONObject r104 = (JSONObject) r102;
        L9:
            if (r104 == null) goto L11;
            Object r105 = r104.opt("data");
        L13:
            if ((r105 instanceof JSONObject) == false) goto L15;
            JSONObject r106 = (JSONObject) r105;
        L16:
            if (r106 == null) goto L18;
            Object r107 = r106.opt("url");
        L20:
            if ((r107 instanceof String) == false) goto L22;
            r103 = (String) r107;
        L22:
            if (r103 == null) goto L27;
            USBTransTemplateUtil r108 = USBTransTemplateUtil.INSTANCE;
            r108.updateUrlSet(r103);
            USBTransTemplateUtil.access$reportOpenCardUrl(r108, r103);
            return;
        L27:
            return;
        L18:
            r107 = null;
            goto L20
        L15:
            r106 = null;
            goto L16
        L11:
            r105 = null;
            goto L13
        L8:
            r104 = null;
            goto L9
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onClose(MessageTransceiver r100, int r101, String r102) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(false);
        }
    }

    private USBTransTemplateUtil() {
    }

    public static /* synthetic */ void a(long r100, String r101) {
        m8573requestData$lambda1(r100, r101);
    }

    static {
        INSTANCE = new USBTransTemplateUtil();
        ipPortRegex = new Regex("(?:http:\\/\\/|http%3A%2F%2F)((?:[0-9]{1,3}(?:\\.|%2E)){3}[0-9]{1,3})(?::|%3A)([0-9]{1,5})(?:\\/|%2F)");
        executor = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory(TAG));
        responseMap = new ConcurrentHashMap();
        responseSize = new ConcurrentHashMap();
        requestTimeOutTask = new ConcurrentHashMap();
        urlMap = new ConcurrentHashMap();
    }

    public final Set<Pair<String, String>> getUrlSet() {
        return urlMap.keySet();
    }

    public final boolean isUSBTransTemplateAvailable() {
        if (mUSBIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (mIsDebugPlatformSupport == false) goto L7;
        return true;
    }

    public final void addInterceptor() {
        IUSBHijackService r100 = (IUSBHijackService) DebugRouterServiceCenter.instance().getService(IUSBHijackService.class);     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        return;
    L5:
        r100.addInterceptor();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.getMessage();
    }

    public static final /* synthetic */ Map access$getUrlMap$p() {
        return urlMap;
    }

    public static final /* synthetic */ void access$setMUSBIsEnabled$p(boolean r100) {
        mUSBIsEnabled = r100;
    }

    private final void reportOpenCardUrl(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("url", r100);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBOpenCardUrl", r101, null, null);
        return;
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }

    public final Pair<TreeSet<TemplateData>, TemplateFileSize> getTemplateData(long r100) {
        TemplateFileSize r101 = responseSize.get(Long.valueOf(r100));
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.isError() == true) goto L8;
        TreeSet<TemplateData> r102 = responseMap.get(Long.valueOf(r100));
        if (r102 != null) goto L12;
    L15:
        return null;
    L12:
        if (r102.size() != r101.getSeqCount()) goto L15;
        return new Pair(r102, r101);
    L8:
        return new Pair(new TreeSet(), r101);
    }

    public final long requestData(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        final long r101 = globalRequestId;
        globalRequestId = 1 + r101;
        responseMap.put(Long.valueOf(r101), new TreeSet());
        ScheduledFuture<?> r102 = executor.schedule(new a(r101, r100), 8, TimeUnit.SECONDS);
        requestTimeOutTask.put(Long.valueOf(r101), r102);
        MessageTransceiver r103 = mTransceiver;
        if (r103 == null) goto L5;
        r103.send("{\"data\":{\"data\":{\"client_id\":-1,\"message\": \"{\\\"method\\\":\\\"DownloadTemplateByUsb\\\",\\\"params\\\":{\\\"requestId\\\":" + r101 + ", \\\"url\\\":\\\"" + r100 + "\\\"}}\",\"session_id\": -1},\"sender\": -1,\"type\": \"CDP\"},\"event\": \"Customized\"}");
    L5:
        return r101;
    }

    public final void setDebugPlatformSupport(boolean r100) {
        mIsDebugPlatformSupport = r100;
    }

    public final void setUSBTransceiver(MessageTransceiver r100) {
        Intrinsics.checkNotNullParameter(r100, "transceiver");
        mTransceiver = r100;
        MessageTransceiver r101 = mTransceiver;
        if (r101 == null) goto L6;
        r101.setStateListener(USBTransTemplateTransceiverListener.INSTANCE);
        return;
    }

    public final void updateUrlSet(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        MatchResult r101 = Regex.find$default(ipPortRegex, r100, 0, 2, null);
        if (r101 == null) goto L10;
        List<String> r102 = r101.getGroupValues();
        if (r102.size() != 3) goto L7;
        Boolean r103 = urlMap.put(new Pair(ListProtector.get(r102, 1), ListProtector.get(r102, 2)), Boolean.TRUE);
        return;
    L7:
        return;
    }

    public static final /* synthetic */ void access$reportOpenCardUrl(USBTransTemplateUtil r100, String r101) {
        r100.reportOpenCardUrl(r101);
    }

    /* JADX INFO: renamed from: requestData$lambda-1, reason: not valid java name */
    private static final void m8573requestData$lambda1(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "$url");
        requestTimeOutTask.remove(Long.valueOf(r100));
        Long r102 = Long.valueOf(r100);
        responseSize.put(r102, new TemplateFileSize(-3, -3));
        Long r103 = Long.valueOf(r100);
        responseMap.put(r103, new TreeSet());
    }

    public final void receiveData(long r100, TemplateData r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (requestTimeOutTask.get(Long.valueOf(r100)) == null) goto L8;
        TreeSet<TemplateData> r102 = responseMap.get(Long.valueOf(r100));
        if (r102 == null) goto L9;
        r102.add(r101);
        return;
    L9:
        return;
    }

    public final void receiveResponseSize(long r100, TemplateFileSize r101) {
        Intrinsics.checkNotNullParameter(r101, "size");
        ScheduledFuture<?> r102 = requestTimeOutTask.get(Long.valueOf(r100));
        if (r102 == null) goto L6;
        r102.cancel(true);
        requestTimeOutTask.remove(Long.valueOf(r100));
        Long r103 = Long.valueOf(r100);
        responseSize.put(r103, r101);
        return;
    }
}
