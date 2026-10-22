package com.larus.platform.spi;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J \u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J \u0010$\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016J\u001e\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010(\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J \u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010+\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0006H\u0016J(\u00100\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0016J$\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/platform/spi/AIChatRenderTraceServiceNoop;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "springTraceDataMap", "", "", "templatePromptMap", "", "autoFillPromptMap", "creationInfoMap", "Lkotlin/Pair;", "templateInfoMap", "sendMessageTrackExtMap", "actionbarRecommendInfoMap", "Lkotlin/Triple;", "", "setSpringTraceDataMap", "", "traceDataMap", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "clear", "getTemplatePromptString", "cvsId", "setTemplatePromptString", "string", "getAutoFillPromptString", "setAutoFillPromptString", "getCreationInfo", "setCreationInfo", "creationId", "creationType", "setTemplateInfo", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "getTemplateInfo", "setSendMessageTrackExtMap", "sendMessageTrackMap", "getSendMessageTrackExtMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "onReceiveAudioData", DBDefinition.TASK_ID, "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "getActionbarRecommendInfo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatRenderTraceServiceNoop implements IAIChatRenderTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f365881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f365882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f365883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, String>> f365884e;

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void l() {
        this.f365881b = null;
    }

    public AIChatRenderTraceServiceNoop() {
        this.f365882c = new LinkedHashMap();
        this.f365883d = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        this.f365884e = new LinkedHashMap();
        new LinkedHashMap();
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> i() {
        return this.f365881b;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return (Map) ((LinkedHashMap) this.f365884e).get(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        String r101 = (String) ((LinkedHashMap) this.f365882c).get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceDataMap");
        this.f365881b = r100;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        String r101 = (String) ((LinkedHashMap) this.f365883d).get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        this.f365884e.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void e(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        Map<String, Map<String, String>> r102 = this.f365884e;
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L5;
        r103 = MapsKt.emptyMap();
    L5:
        r102.put(r100, MapsKt.plus(r103, r101));
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        this.f365882c.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        this.f365883d.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map<String, Map<String, String>> r102 = this.f365884e;
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L5;
        r103 = MapsKt.emptyMap();
    L5:
        r102.put(r100, MapsKt.minus(r103, r101));
    }
}
