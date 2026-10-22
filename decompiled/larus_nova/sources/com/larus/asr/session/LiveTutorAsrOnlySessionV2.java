package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.AsrSessionComponentUtils;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class LiveTutorAsrOnlySessionV2 extends ComponentAsrSession {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f287485j = 0;

    public boolean l(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    public boolean m(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public boolean m0() {
        return false;
    }

    public void n(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.f287439a, true, new w0(), new x0(this)), new com.larus.asr.session.component.z(this.f287439a, this.f287441c, new LiveTutorAsrOnlySessionV2$createComponents$3(this), new LiveTutorAsrOnlySessionV2$createComponents$4(this), new LiveTutorAsrOnlySessionV2$createComponents$5(this))}), CollectionsKt.listOf(new com.larus.asr.session.component.y0(this.f287439a, this.f287444f)));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean g(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == this.f287444f) goto L5;
    L9:
        return false;
    L5:
        if (r100.f287713o != AsrEngineRoute.NORMAL) goto L7;
    L8:
        return true;
    L7:
        if (super.g(r100) == false) goto L9;
        goto L8
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super.qa(r100, r101);
        int r102 = AsrSessionComponentUtils.f287672a;
        AsrSessionComponentUtils.e();
        AsrSessionComponentUtils.b(this.f287439a, r100, VoiceInputType.TouchSpeaker, "onCancel:".concat(r100), 8);
        this.f287444f.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.f299419a);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super.ma(r100, r101, r102);
        int r103 = AsrSessionComponentUtils.f287672a;
        AsrSessionComponentUtils.e();
    }

    public LiveTutorAsrOnlySessionV2(p r100, String r101, VoiceInputType r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "voiceInputType");
        Intrinsics.checkNotNullParameter(r103, "isCurrentSession");
        super(r100, r101, r102, r103);
    }
}
