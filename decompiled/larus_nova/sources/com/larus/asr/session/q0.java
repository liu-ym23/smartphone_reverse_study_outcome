package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.InputTextAsrPostComponent;
import com.larus.asr.session.component.ObricAsrPreComponent;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class q0 extends ComponentAsrSession {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f287954j = 0;

    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.asr.session.p0] */
    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.f287439a, new n0()), new com.larus.asr.session.component.z(this.f287439a, new o0(), null, 26), new ObricAsrPreComponent(this.f287444f, false), new com.larus.asr.session.component.h(this.f287439a, this.f287440b, this.f287444f, new com.larus.asr.session.component.e(false, false, null, new p0(), 21))}), CollectionsKt.listOf(new com.larus.asr.session.component.o0[]{new InputTextAsrPostComponent(this.f287439a, this.f287440b, this.f287444f), new com.larus.asr.session.component.l0(this.f287439a, this.f287444f), new com.larus.asr.session.component.z0(this.f287439a, this.f287444f, false)}));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean g(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 != this.f287444f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void h(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f287439a.V9(AppHost.f326268a.getApplication().getString(R.string.larus_doing_asr_placeholder));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        BotModel r101 = this.f287439a.i();
        if (r101 == null) goto L5;
        String r102 = r101.getBotId();
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        String r103 = "actionbar_instruction_" + System.currentTimeMillis();
        AsrEngineRoute r104 = r100.f287713o;
        Intrinsics.checkNotNullParameter(r103, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, CloudControlInf.ROUTE);
        r100.f287711m = r103;
        r100.f287712n = 0;
        r100.f287713o = r104;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public q0(p r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "isCurrentSession");
        super(r100, r101, VoiceInputType.TouchSpeaker, r102);
    }
}
