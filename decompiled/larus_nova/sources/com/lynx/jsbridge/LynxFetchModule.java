package com.lynx.jsbridge;

import android.content.Context;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.service.ILynxHttpService;
import i8a.i;
import i8a.n;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes32.dex */
public class LynxFetchModule extends LynxModule {
    public static final String NAME = "LynxFetchModule";
    private static final String deprecatedStreamingFlag = "useStreaming";
    private static final String standardStreamingFlag = "enableFetchAPIStandardStreaming";
    private static final AtomicLong streamingCounter = null;
    private static final String streamingEventNamePrefix = "LynxFetchModuleStreamingEvent";
    private final z5a.b mSender;

    public class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callback f381275b;

        @Override // i8a.i
        public final void a(HttpResponse r100) {
            JavaOnlyMap r101 = new JavaOnlyMap();
            r101.put("url", this.f381274a);
            if (r100.getHttpBody() == null) goto L5;
            byte[] r102 = r100.getHttpBody();
        L6:
            r101.put(ContainerPosition.BODY, r102);
            String r103 = "";
            if (r100.getHttpHeaders() == null) goto L9;
            Object r104 = r100.getHttpHeaders();
        L10:
            r101.put("headers", r104);
            r101.put("status", Integer.valueOf(r100.getStatusCode()));
            if (r100.getStatusText() == null) goto L13;
            r103 = r100.getStatusText();
        L13:
            r101.put("statusText", r103);
            if (r100.getCustomInfo() == null) goto L16;
            JavaOnlyMap r105 = r100.getCustomInfo();
        L17:
            r101.put("lynxExtension", r105);
            this.f381275b.invoke(new Object[]{r101});
            return;
        L16:
            r105 = new JavaOnlyMap();
            goto L17
        L9:
            r104 = "";
            goto L10
        L5:
            r102 = new byte[0];
            goto L6
        }

        public a(String r100, Callback r101) {
            this.f381274a = r100;
            this.f381275b = r101;
        }
    }

    public class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f381277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Callback f381278c;

        @Override // i8a.i
        public final void a(HttpResponse r100) {
            JavaOnlyMap r101 = new JavaOnlyMap();
            r101.put("url", this.f381276a);
            r101.put(ContainerPosition.BODY, new byte[0]);
            String r102 = "";
            if (r100.getHttpHeaders() == null) goto L5;
            Object r103 = r100.getHttpHeaders();
        L6:
            r101.put("headers", r103);
            r101.put("status", Integer.valueOf(r100.getStatusCode()));
            if (r100.getStatusText() == null) goto L9;
            r102 = r100.getStatusText();
        L9:
            r101.put("statusText", r102);
            if (r100.getCustomInfo() == null) goto L12;
            JavaOnlyMap r104 = r100.getCustomInfo();
        L13:
            r104.putString("streamingId", this.f381277b);
            r101.put("lynxExtension", r104);
            this.f381278c.invoke(new Object[]{r101});
            return;
        L12:
            r104 = new JavaOnlyMap();
            goto L13
        L5:
            r103 = "";
            goto L6
        }

        public b(String r100, String r101, Callback r102) {
            this.f381276a = r100;
            this.f381277b = r101;
            this.f381278c = r102;
        }
    }

    static {
        streamingCounter = new AtomicLong();
    }

    public LynxFetchModule(Context r100, Object r101) {
        super(r100);
        this.mSender = (z5a.b) r101;
    }

    @LynxMethod
    public void fetch(ReadableMap r100, Callback r101, Callback r102) {
        String r103 = r100.getString("url", "");
        HttpRequest r104 = new HttpRequest();
        r104.f381368a = r100.getString(com.alipay.sdk.m.p.e.f25671s, "");
        r104.f381369b = r103;
        r100.getString(PlayerResolution.SDKKEY.ORIGIN, "");
        r104.f381371d = (JavaOnlyMap) r100.getMap("headers", new JavaOnlyMap());
        r104.f381370c = r100.getByteArray(ContainerPosition.BODY, new byte[0]);
        JavaOnlyMap r105 = (JavaOnlyMap) r100.getMap("lynxExtension", new JavaOnlyMap());
        r104.f381372e = r105;
        boolean r106 = r105.getBoolean(deprecatedStreamingFlag, false);
        boolean r107 = r105.getBoolean(standardStreamingFlag, false);
        ILynxHttpService r108 = (ILynxHttpService) n.c().a(ILynxHttpService.class);
        if (r108 != null) goto L6;
        JavaOnlyMap r109 = new JavaOnlyMap();
        r109.put("message", "Lynx Http Service not registered");
        r102.invoke(new Object[]{r109});
        return;
    L6:
        if (r106 == true) goto L9;
        if (r107 == true) goto L9;
        request(r108, r104, r103, r101);
        return;
    L9:
        requestStreaming(r108, r104, r103, r101);
    }

    private void request(ILynxHttpService r100, HttpRequest r101, String r102, Callback r103) {
        r100.request(r101, new a(r102, r103));
    }

    private void requestStreaming(ILynxHttpService r100, HttpRequest r101, String r102, Callback r103) {
        String r104 = streamingEventNamePrefix + streamingCounter.getAndIncrement();
        r100.requestStreaming(r101, new b(r102, r104, r103), new z5a.a(r104, this.mSender));
    }
}
