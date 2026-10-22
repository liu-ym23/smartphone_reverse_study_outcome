package com.larus.bmhome;

import com.larus.bmhome.chat.trace.ChatTTSPlayTrace;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0018\u00010\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tH\u0016JB\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J.\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\""}, d2 = {"Lcom/larus/bmhome/AIChatTTSPlayTraceImpl;", "Lcom/larus/platform/spi/IAIChatTtsPlayTraceService;", "<init>", "()V", "bindSocialMessageListSource", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getter", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "setChatTypeFetcher", "chatTypeGetter", "", "setExtraCommonParams", "commonParamsGetter", "Lorg/json/JSONObject;", "startTTS", DBDefinition.TASK_ID, "startTTSReason", com.heytap.mcssdk.constant.b.f276353c, "voiceID", "ttsSpeaker", "traceInfo", "stopTTS", "stopTTSReason", "bindPageMessageListSource", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "onSentenceStart", "sentenceTxt", "sentenceInst", "sentenceRes", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatTTSPlayTraceImpl implements IAIChatTtsPlayTraceService {
    public AIChatTTSPlayTraceImpl() {
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void a(String r100) {
        ChatTTSPlayTrace.f310061b.a(r100);
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void b(com.larus.bmhome.chat.component.list.h0 r100) {
        ChatTTSPlayTrace.f310061b.getClass();
        ChatTTSPlayTrace.f310069j = r100;
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void c(by7.e r100, wq8.b r101) {
        ChatTTSPlayTrace.f310061b.getClass();
        ChatTTSPlayTrace.f310063d = r101;
        ChatTTSPlayTrace.f310062c = r100;
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        ChatTTSPlayTrace.f310061b.d(r100, r101, r102, r103);
    }
}
