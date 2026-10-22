package com.larus.platform.spi;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 +2\u00020\u0001:\u0001+J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H&J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u0006H&J&\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J \u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0006H&J&\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H&J(\u0010$\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H&J$\u0010)\u001a\u0016\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010*2\u0006\u0010\u000e\u001a\u00020\u0006H&¨\u0006,"}, d2 = {"Lcom/larus/platform/spi/IAIChatRenderTraceService;", "", "setSpringTraceDataMap", "", "traceDataMap", "", "", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "clear", "getTemplatePromptString", "cvsId", "setTemplatePromptString", "string", "getAutoFillPromptString", "setAutoFillPromptString", "getCreationInfo", "Lkotlin/Pair;", "setCreationInfo", "creationId", "creationType", "setTemplateInfo", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "getTemplateInfo", "setSendMessageTrackExtMap", "sendMessageTrackMap", "getSendMessageTrackExtMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "onReceiveAudioData", DBDefinition.TASK_ID, "setActionbarRecommendInfo", "actionBarItemId", "", "recommendRequestID", "actionbarRecommendFrom", "getActionbarRecommendInfo", "Lkotlin/Triple;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIChatRenderTraceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f365896a = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0010H\u0096\u0001J\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0096\u0001J)\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0096\u0001J!\u0010!\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0096\u0001J'\u0010$\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001J\u001f\u0010&\u001a\u00020\u00052\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001J!\u0010(\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0096\u0001J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0096\u0001J'\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010H\u0096\u0001¨\u0006-"}, d2 = {"Lcom/larus/platform/spi/IAIChatRenderTraceService$Companion;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "clear", "", "clearSpringTraceDataMap", "getActionbarRecommendInfo", "Lkotlin/Triple;", "", "", "cvsId", "getAutoFillPromptString", "getCreationInfo", "Lkotlin/Pair;", "getSendMessageTrackExtMap", "", "getSpringTraceDataMap", "getTemplateInfo", "getTemplatePromptString", "onReceiveAudioData", DBDefinition.TASK_ID, "onRender", "msg", "Lcom/larus/im/bean/message/Message;", "removeSendMessageTrackExtMap", "key", "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "setAutoFillPromptString", "string", "setCreationInfo", "creationId", "creationType", "setSendMessageTrackExtMap", "sendMessageTrackMap", "setSpringTraceDataMap", "traceDataMap", "setTemplateInfo", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "setTemplatePromptString", "updateSendMessageTrackExtMap", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAIChatRenderTraceService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f365897c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAIChatRenderTraceService f365898b;

        static {
            f365897c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void c(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
            this.f365898b.c(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final Map<String, String> d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            return this.f365898b.d(r100);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void e(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
            this.f365898b.e(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final String f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            return this.f365898b.f(r100);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void g(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "string");
            this.f365898b.g(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void h(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "traceDataMap");
            this.f365898b.h(r100);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final Map<String, String> i() {
            return this.f365898b.i();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void j(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            this.f365898b.j(r100);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final String k(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            return this.f365898b.k(r100);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void l() {
            this.f365898b.l();
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void m(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "string");
            this.f365898b.m(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatRenderTraceService
        public final void n(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.f365898b.n(r100, r101);
        }

        private Companion() {
            IAIChatRenderTraceService r100 = (IAIChatRenderTraceService) ServiceManager.get().getService(IAIChatRenderTraceService.class);
            if (r100 != null) goto L5;
            r100 = new AIChatRenderTraceServiceNoop();
        L5:
            this.f365898b = r100;
        }
    }

    static {
        f365896a = Companion.f365897c;
    }

    void c(String r100, Map<String, String> r101);

    Map<String, String> d(String r100);

    void e(String r100, Map<String, String> r101);

    String f(String r100);

    void g(String r100, String r101);

    void h(Map<String, String> r100);

    Map<String, String> i();

    void j(String r100);

    String k(String r100);

    void l();

    void m(String r100, String r101);

    void n(String r100, String r101);
}
