package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionContextParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTransportType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantContextCreateParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionContextParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionContextPama2NativeKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[SpeechAudioTransportType.values().length];
            r100[SpeechAudioTransportType.WEBSOCKET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SpeechAudioTransportType.QUIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SpeechAudioTransportType.HOST_INJECTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final SAMICoreVoiceAssistantContextCreateParameter toNative(SpeechVoiceAssistantSessionContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreVoiceAssistantContextCreateParameter r101 = new SAMICoreVoiceAssistantContextCreateParameter();
        r101.url = r100.getUrl();
        r101.header = r100.getHeader();
        r101.protoVersion = r100.getProtoVersion();
        r101.appKey = r100.getAppKey();
        r101.token = r100.getToken();
        r101.connectTimeout = r100.getConnectTimeout();
        r101.enableTransferRetry = r100.getEnableTransferRetry();
        List<Integer> r102 = r100.getRetryTimeArray();
        if (r102 == null) goto L5;
        int[] r103 = CollectionsKt.toIntArray(r102);
    L6:
        r101.retryTimeArray = r103;
        r101.businessInfo = r100.getBusinessInfo();
        r101.taskId = r100.getTaskId();
        r101.dumpDir = r100.getDumpDir();
        SpeechAudioTokenType r104 = r100.getTokenType();
        if (r104 == null) goto L9;
        r101.tokenType = SAMICoreTokenType.fromInt(r104.getValue());
    L9:
        SpeechAudioTransportType r105 = r100.getTransportType();
        if (r105 == null) goto L18;
        int r106 = WhenMappings.$EnumSwitchMapping$0[r105.ordinal()];
        if (r106 != 2) goto L14;
        r101.enableFrontier = true;
        r101.enableConnectPool = true;
        r101.connectPoolBusiness = r100.getConnectPoolBusiness();
        goto L18
    L14:
        if (r106 != 3) goto L18;
        r101.enableHostTransport = true;
    L18:
        return r101;
    L5:
        r103 = null;
        goto L6
    }
}
