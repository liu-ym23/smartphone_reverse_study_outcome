package com.larus.audio.flow.client.kmp_com.service;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.larus.audio.utils.AudioLogLevel;
import com.larus.audio.utils.e;
import com.larus.audio.utils.z;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/service/LoggerInject;", "Lcom/bytedance/flow_audio/api/service/common/IKMPLoggerService;", "<init>", "()V", "logDebug", "", SubInfo.KEY_FORMAT, "", "tag", "logError", "logInfo", "logWarn", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggerInject implements IKMPLoggerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f289759b = null;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    public LoggerInject() {
    }

    static {
        f289759b = new e("FLOW-KMP-AUDIO-TTS");
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPLoggerService
    public final void logDebug(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "tag");
        e r102 = f289759b;
        String r103 = r101 + ' ' + r100;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "what");
        z.a(new z(r102.f290029a, AudioLogLevel.DEBUG, r103));
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPLoggerService
    public final void logError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "tag");
        z.a(f289759b.a(r101 + ' ' + r100));
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPLoggerService
    public final void logWarn(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "tag");
        e r102 = f289759b;
        String r103 = r101 + ' ' + r100;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "what");
        z.a(new z(r102.f290029a, AudioLogLevel.WARN, r103));
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPLoggerService
    public final void m1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "tag");
        z.a(f289759b.b(r101 + ' ' + r100));
    }
}
