package com.bytedance.bdp.appbase.network;

import android.content.Context;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.bdp.appbase.network.download.BdpDownloadCallback;
import com.bytedance.bdp.appbase.network.download.BdpDownloadModule;
import com.bytedance.bdp.appbase.network.download.BdpDownloadRequest;
import com.bytedance.bdp.appbase.network.download.BdpDownloadResponse;
import com.bytedance.bdp.appbase.network.request.BdpRequestCallback;
import com.bytedance.bdp.appbase.network.request.BdpRequestModule;
import com.bytedance.bdp.appbase.network.upload.BdpUploadCallback;
import com.bytedance.bdp.appbase.network.upload.BdpUploadModule;
import com.bytedance.bdp.appbase.network.upload.BdpUploadRequest;
import com.bytedance.bdp.appbase.network.wrapper.BdpHostCallWrapper;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import g94.b;
import gb4.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019H\u0007J\"\u0010\u001a\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J*\u0010\u001a\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J6\u0010\u001a\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"H\u0007J>\u0010\u001a\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0006\u0010\u001f\u001a\u00020 H\u0007J>\u0010\u001a\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0006\u0010#\u001a\u00020$H\u0007JH\u0010%\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u000f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0007J@\u0010*\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\u0006\u0010+\u001a\u00020$H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020.H\u0007J*\u0010/\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0012H\u0007J2\u0010/\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0007J>\u0010/\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"H\u0007JF\u0010/\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0006\u0010\u001f\u001a\u00020 H\u0007JF\u0010/\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0006\u0010+\u001a\u00020$H\u0007JL\u00101\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"H\u0007JT\u00101\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\"2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001a\u00103\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u000104H\u0007J\u001a\u00105\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020.2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001a\u00106\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u000107H\u0007R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpNetworkManager;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "baseContext", "kotlin.jvm.PlatformType", "cancelDownload", "", "id", "", "cancelRequest", "cancelUpload", Global.RECORDING_TYPE_CLEAN, "cacheId", "", "config", "json", "Lorg/json/JSONObject;", "executeDownload", "Lcom/bytedance/bdp/appbase/network/download/BdpDownloadResponse;", "request", "Lcom/bytedance/bdp/appbase/network/download/BdpDownloadRequest;", "executeUpload", "Lcom/bytedance/bdp/appbase/network/BdpNetResponse;", "Lcom/bytedance/bdp/appbase/network/upload/BdpUploadRequest;", MonitorConstants.CONNECT_TYPE_GET, "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "url", "fromSource", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "callback", "Lcom/bytedance/bdp/appbase/network/request/BdpRequestCallback;", "headers", "", "timeOut", "", "getWithCache", "requestLibType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "useWebViewOkhttpClient", "", "head", "timeout", "newCall", "Lcom/bytedance/bdp/appbase/network/IBdpNetCall;", "Lcom/bytedance/bdp/appbase/network/BdpNetRequest;", "postJson", "data", "postUrlEncode", "params", "queueDownload", "Lcom/bytedance/bdp/appbase/network/download/BdpDownloadCallback;", "queueRequest", "queueUpload", "Lcom/bytedance/bdp/appbase/network/upload/BdpUploadCallback;", "Companion", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class BdpNetworkManager {
    public static final Companion Companion = null;
    private static volatile BdpNetworkManager INSTANCE;
    private static Double deviceScore;
    private final Context baseContext;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpNetworkManager$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/bdp/appbase/network/BdpNetworkManager;", "deviceScore", "", "Ljava/lang/Double;", "getDeviceScore", "()Ljava/lang/Double;", "setDeviceScore", "", "json", "Lorg/json/JSONObject;", "with", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final Double getDeviceScore() {
            return BdpNetworkManager.access$getDeviceScore$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void setDeviceScore(JSONObject r100) {
            if (r100 == null) goto L4;
            Double r101 = Double.valueOf(r100.optDouble("overall"));
        L5:
            BdpNetworkManager.access$setDeviceScore$cp(r101);
            return;
        L4:
            r101 = null;
            goto L5
        }

        @JvmStatic
        public final BdpNetworkManager with(Context r100) {
            BdpNetworkManager r101 = BdpNetworkManager.access$getINSTANCE$cp();
            if (r101 != null) goto L13;
            monitor-enter(this);
            r101 = BdpNetworkManager.access$getINSTANCE$cp();     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r101 = new BdpNetworkManager(r100, null);     // Catch: Throwable -> L10
            BdpNetworkManager.access$setINSTANCE$cp(r101);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Double getDeviceScore() {
        return Companion.getDeviceScore();
    }

    @JvmStatic
    public static final void setDeviceScore(JSONObject r100) {
        Companion.setDeviceScore(r100);
    }

    @JvmStatic
    public static final BdpNetworkManager with(Context r100) {
        return Companion.with(r100);
    }

    public static final /* synthetic */ Double access$getDeviceScore$cp() {
        return deviceScore;
    }

    public static final /* synthetic */ BdpNetworkManager access$getINSTANCE$cp() {
        return INSTANCE;
    }

    private BdpNetworkManager(Context r100) {
        this.baseContext = r100.getApplicationContext();
    }

    public static final /* synthetic */ void access$setDeviceScore$cp(Double r100) {
        deviceScore = r100;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(BdpNetworkManager r100) {
        INSTANCE = r100;
    }

    public final void cancelDownload(int r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.download.a> r101 = BdpDownloadModule.f200883a;
        com.bytedance.bdp.appbase.network.download.a r102 = BdpDownloadModule.f200883a.get(Integer.valueOf(r100));
        if (r102 == null) goto L12;
        b.d("BdpDownloadTask", new Object[]{"cancel"});
        if (r102.f200885a.compareAndSet(1, 4) == false) goto L7;
    L8:
        IBdpNetCall r103 = r102.f200886b;
        if (r103 == null) goto L14;
        r103.cancel();
        return;
    L14:
        return;
    L7:
        if (r102.f200885a.compareAndSet(2, 4) == true) goto L8;
        return;
    }

    public final void cancelRequest(int r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.request.a> r101 = BdpRequestModule.f200906a;
        com.bytedance.bdp.appbase.network.request.a r102 = BdpRequestModule.f200906a.get(Integer.valueOf(r100));
        if (r102 == null) goto L12;
        b.d("BdpRequestTask", new Object[]{"cancel"});
        if (r102.f200907a.compareAndSet(1, 4) == false) goto L7;
    L8:
        IBdpNetCall r103 = r102.f200908b;
        if (r103 == null) goto L14;
        r103.cancel();
        return;
    L14:
        return;
    L7:
        if (r102.f200907a.compareAndSet(2, 4) == true) goto L8;
        return;
    }

    public final void cancelUpload(int r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.upload.a> r101 = BdpUploadModule.f200913a;
        com.bytedance.bdp.appbase.network.upload.a r102 = BdpUploadModule.f200913a.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f200915b.compareAndSet(1, 4) == false) goto L7;
    L8:
        IBdpNetCall r103 = r102.f200916c;
        if (r103 == null) goto L14;
        r103.cancel();
        return;
    L14:
        return;
    L7:
        if (r102.f200915b.compareAndSet(2, 4) == true) goto L8;
    }

    public final void clean(String r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.request.a> r101 = BdpRequestModule.f200906a;
        BdpRequestModule.a(this.baseContext, r100);
    }

    public final void config(JSONObject r100) {
        BdpOkClient.config(r100);
    }

    public final BdpDownloadResponse executeDownload(BdpDownloadRequest r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.download.a> r101 = BdpDownloadModule.f200883a;
        Context r102 = this.baseContext;
        int r103 = BdpRequestHelper.INSTANCE.generateRequestId();
        com.bytedance.bdp.appbase.network.download.a r104 = new com.bytedance.bdp.appbase.network.download.a(r103, r102, r100, null);
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.download.a> r105 = BdpDownloadModule.f200883a;
        r105.put(Integer.valueOf(r103), r104);
        BdpDownloadResponse r106 = r104.b();     // Catch: Throwable -> L6
        r105.remove(Integer.valueOf(r103));
        return r106;
    L6:
        th = move-exception;
        BdpDownloadModule.f200883a.remove(Integer.valueOf(r103));
        throw th;
    }

    public final BdpNetResponse executeUpload(BdpUploadRequest r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.upload.a> r101 = BdpUploadModule.f200913a;
        Context r102 = this.baseContext;
        int r103 = BdpRequestHelper.INSTANCE.generateRequestId();
        com.bytedance.bdp.appbase.network.upload.a r104 = new com.bytedance.bdp.appbase.network.upload.a(r103, r102, r100, null);
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.upload.a> r105 = BdpUploadModule.f200913a;
        r105.put(Integer.valueOf(r103), r104);
        BdpNetResponse r106 = r104.a();     // Catch: Throwable -> L6
        r105.remove(Integer.valueOf(r103));
        return r106;
    L6:
        th = move-exception;
        BdpUploadModule.f200913a.remove(Integer.valueOf(r103));
        throw th;
    }

    public final IBdpNetCall newCall(BdpNetRequest r100) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.request.a> r101 = BdpRequestModule.f200906a;
        Context r102 = this.baseContext;
        if (r100.getRequestLibType() != BdpRequestType.OK) goto L6;
        return new com.bytedance.bdp.appbase.network.wrapper.a(r102, r100);
    L6:
        return new BdpHostCallWrapper(r100);
    }

    public /* synthetic */ BdpNetworkManager(Context r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final int queueDownload(BdpDownloadRequest r100, BdpDownloadCallback r101) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.download.a> r102 = BdpDownloadModule.f200883a;
        return BdpDownloadModule.a(this.baseContext, r100, r101);
    }

    public final int queueRequest(BdpNetRequest r100, BdpRequestCallback r101) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.request.a> r102 = BdpRequestModule.f200906a;
        return BdpRequestModule.b(this.baseContext, r100, r101);
    }

    public final int queueUpload(BdpUploadRequest r100, BdpUploadCallback r101) {
        ConcurrentHashMap<Integer, com.bytedance.bdp.appbase.network.upload.a> r102 = BdpUploadModule.f200913a;
        return BdpUploadModule.a(this.baseContext, r100, r101);
    }

    public final BdpNetResponse get(BdpAppContext r310, String r311, BdpFromSource r312) {
        com.bytedance.bdp.appbase.core.a r100 = null;
        if (r310 == null) goto L5;
        String r110 = r310.f200762b;
    L6:
        if (r310 == null) goto L8;
        r100 = r310.b();
    L8:
        com.bytedance.bdp.appbase.core.a r111 = r100;
        if (r111 == null) goto L11;
        r111.getAppId();
    L11:
        ArrayList r101 = new ArrayList();
        return newCall(new BdpNetRequest(r311, "GET", r312, false, true, false, false, false, false, new c(r101), r110, r111, null, true, BdpRequestType.HOST, null, 60000, 60000, 60000, true, null, false, null, Boolean.FALSE, new HashMap())).execute();
    L5:
        r110 = null;
        goto L6
    }

    public final int get(BdpAppContext r310, String r311, BdpFromSource r312, BdpRequestCallback r313) {
        com.bytedance.bdp.appbase.core.a r100 = null;
        if (r310 == null) goto L5;
        String r110 = r310.f200762b;
    L6:
        if (r310 == null) goto L8;
        r100 = r310.b();
    L8:
        com.bytedance.bdp.appbase.core.a r111 = r100;
        if (r111 == null) goto L11;
        r111.getAppId();
    L11:
        ArrayList r101 = new ArrayList();
        return queueRequest(new BdpNetRequest(r311, "GET", r312, false, true, false, false, false, false, new c(r101), r110, r111, null, true, BdpRequestType.HOST, null, 60000, 60000, 60000, true, null, false, null, Boolean.FALSE, new HashMap()), r313);
    L5:
        r110 = null;
        goto L6
    }

    public final BdpNetResponse postJson(BdpAppContext r310, String r311, BdpFromSource r312, JSONObject r313) {
        com.bytedance.bdp.appbase.network.mime.c r110 = new com.bytedance.bdp.appbase.network.mime.c(r313);
        if (r310 == null) goto L5;
        String r111 = r310.f200762b;
    L6:
        if (r310 == null) goto L8;
        com.bytedance.bdp.appbase.core.a r112 = r310.b();
    L10:
        if (r112 == null) goto L12;
        r112.getAppId();
    L12:
        ArrayList r100 = new ArrayList();
        return newCall(new BdpNetRequest(r311, "POST", r312, false, true, false, false, false, false, new c(r100), r111, r112, null, true, BdpRequestType.HOST, r110, 60000, 60000, 60000, true, null, false, null, Boolean.FALSE, new HashMap())).execute();
    L8:
        r112 = null;
        goto L10
    L5:
        r111 = null;
        goto L6
    }

    public final BdpNetResponse get(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103) {
        BdpNetRequest.a r104 = new BdpNetRequest.a(r100, r101, r102);
        r104.b(r103);
        r104.f200859e = "GET";
        r104.f200872r = null;
        return newCall(r104.a()).execute();
    }

    public final BdpNetResponse get(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103, long r104) {
        BdpNetRequest.a r105 = new BdpNetRequest.a(r100, r101, r102);
        r105.f200866l = r104;
        r105.f200868n = r104;
        r105.f200867m = r104;
        r105.b(r103);
        r105.f200859e = "GET";
        r105.f200872r = null;
        return newCall(r105.a()).execute();
    }

    public final BdpNetResponse head(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103, long r104) {
        BdpNetRequest.a r105 = new BdpNetRequest.a(r100, r101, r102);
        r105.f200859e = "HEAD";
        r105.f200872r = null;
        if (r103 == null) goto L5;
        r105.b(r103);
    L5:
        r105.f200866l = r104;
        r105.f200868n = r104;
        r105.f200867m = r104;
        return newCall(r105.a()).execute();
    }

    public final int postJson(BdpAppContext r310, String r311, BdpFromSource r312, JSONObject r313, BdpRequestCallback r314) {
        com.bytedance.bdp.appbase.network.mime.c r110 = new com.bytedance.bdp.appbase.network.mime.c(r313);
        if (r310 == null) goto L5;
        String r111 = r310.f200762b;
    L6:
        if (r310 == null) goto L8;
        com.bytedance.bdp.appbase.core.a r112 = r310.b();
    L10:
        if (r112 == null) goto L12;
        r112.getAppId();
    L12:
        ArrayList r100 = new ArrayList();
        return queueRequest(new BdpNetRequest(r311, "POST", r312, false, true, false, false, false, false, new c(r100), r111, r112, null, true, BdpRequestType.HOST, r110, 60000, 60000, 60000, true, null, false, null, Boolean.FALSE, new HashMap()), r314);
    L8:
        r112 = null;
        goto L10
    L5:
        r111 = null;
        goto L6
    }

    public final BdpNetResponse postUrlEncode(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103, Map<String, String> r104) {
        com.bytedance.bdp.appbase.network.mime.b r105 = new com.bytedance.bdp.appbase.network.mime.b();
        if (r104 == null) goto L5;
        r105.d(r104);
    L5:
        BdpNetRequest.a r106 = new BdpNetRequest.a(r100, r101, r102);
        r106.f200859e = "POST";
        r106.f200872r = r105;
        r106.b(r103);
        return newCall(r106.a()).execute();
    }

    public final int get(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103, BdpRequestCallback r104) {
        BdpNetRequest.a r105 = new BdpNetRequest.a(r100, r101, r102);
        r105.b(r103);
        r105.f200859e = "GET";
        r105.f200872r = null;
        return queueRequest(r105.a(), r104);
    }

    public final BdpNetResponse postJson(BdpAppContext r100, String r101, BdpFromSource r102, JSONObject r103, Map<String, String> r104) {
        com.bytedance.bdp.appbase.network.mime.c r105 = new com.bytedance.bdp.appbase.network.mime.c(r103);
        BdpNetRequest.a r106 = new BdpNetRequest.a(r100, r101, r102);
        r106.f200859e = "POST";
        r106.f200872r = r105;
        r106.b(r104);
        return newCall(r106.a()).execute();
    }

    public final BdpNetResponse getWithCache(BdpAppContext r100, BdpRequestType r101, String r102, Map<String, String> r103, BdpFromSource r104, boolean r105) {
        BdpNetRequest.a r106 = new BdpNetRequest.a(r100, r102, r104);
        r106.f200859e = "GET";
        r106.f200872r = null;
        r106.f200871q = r101;
        r106.f200876v = Boolean.valueOf(r105);
        if (r100 == null) goto L7;
        com.bytedance.bdp.appbase.core.a r107 = r100.b();
        if (r107 == null) goto L7;
        r107.getAppId();
    L7:
        if (r103 == null) goto L10;
        r106.b(r103);
    L10:
        return newCall(r106.a()).execute();
    }

    public final BdpNetResponse postJson(BdpAppContext r100, String r101, BdpFromSource r102, JSONObject r103, Map<String, String> r104, long r105) {
        com.bytedance.bdp.appbase.network.mime.c r106 = new com.bytedance.bdp.appbase.network.mime.c(r103);
        BdpNetRequest.a r107 = new BdpNetRequest.a(r100, r101, r102);
        r107.f200866l = r105;
        r107.f200868n = r105;
        r107.f200867m = r105;
        r107.f200859e = "POST";
        r107.f200872r = r106;
        r107.b(r104);
        return newCall(r107.a()).execute();
    }

    public final int postUrlEncode(BdpAppContext r100, String r101, BdpFromSource r102, Map<String, String> r103, Map<String, String> r104, BdpRequestCallback r105) {
        com.bytedance.bdp.appbase.network.mime.b r106 = new com.bytedance.bdp.appbase.network.mime.b();
        if (r104 == null) goto L5;
        r106.d(r104);
    L5:
        BdpNetRequest.a r107 = new BdpNetRequest.a(r100, r101, r102);
        r107.f200859e = "POST";
        r107.f200872r = r106;
        r107.b(r103);
        return queueRequest(r107.a(), r105);
    }

    public final int postJson(BdpAppContext r100, String r101, BdpFromSource r102, JSONObject r103, Map<String, String> r104, BdpRequestCallback r105) {
        com.bytedance.bdp.appbase.network.mime.c r106 = new com.bytedance.bdp.appbase.network.mime.c(r103);
        BdpNetRequest.a r107 = new BdpNetRequest.a(r100, r101, r102);
        r107.f200859e = "POST";
        r107.f200872r = r106;
        r107.b(r104);
        return queueRequest(r107.a(), r105);
    }
}
