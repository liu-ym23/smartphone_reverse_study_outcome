package com.larus.bmhome;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\bH\u0016J&\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J \u0010 \u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016J&\u0010#\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\bH\u0016J(\u0010&\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016J$\u0010+\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010,2\u0006\u0010\u0010\u001a\u00020\bH\u0016¨\u0006-"}, d2 = {"Lcom/larus/bmhome/AIChatRenderTraceServiceImpl;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "setSpringTraceDataMap", "", "traceDataMap", "", "", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "clear", "getTemplatePromptString", "cvsId", "setTemplatePromptString", "string", "getAutoFillPromptString", "setAutoFillPromptString", "getCreationInfo", "Lkotlin/Pair;", "setCreationInfo", "creationId", "creationType", "setTemplateInfo", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "getTemplateInfo", "setSendMessageTrackExtMap", "sendMessageTrackMap", "getSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "updateSendMessageTrackExtMap", "onReceiveAudioData", DBDefinition.TASK_ID, "setActionbarRecommendInfo", "actionBarItemId", "", "recommendRequestID", "actionbarRecommendFrom", "getActionbarRecommendInfo", "Lkotlin/Triple;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatRenderTraceServiceImpl implements IAIChatRenderTraceService {
    public AIChatRenderTraceServiceImpl() {
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> i() {
        ChatRenderTrace.f310039b.getClass();
        return ChatRenderTrace.f310057t;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void l() {
        ChatRenderTrace.f310039b.l();
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return ChatRenderTrace.f310039b.d(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return ChatRenderTrace.f310039b.f(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceDataMap");
        ChatRenderTrace.f310039b.h(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        ChatRenderTrace.f310039b.j(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return ChatRenderTrace.f310039b.k(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        ChatRenderTrace.f310039b.c(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void e(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        ChatRenderTrace.f310039b.e(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        ChatRenderTrace.f310039b.g(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        ChatRenderTrace.f310039b.m(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "key");
        ChatRenderTrace.f310039b.n(r100, r101);
    }
}
