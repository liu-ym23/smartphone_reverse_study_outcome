package com.larus.livetutor.impl.view;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e2 implements com.larus.livetutor.impl.tutor.controller.r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorVoiceView f356828a;

    @Override // com.larus.livetutor.impl.tutor.controller.r0
    public final void onClear() {
        kj9.b.a("[LiveTutorVoiceView] clear subtitle");
        LiveTutorVoiceView.Y5(this.f356828a);
    }

    public e2(LiveTutorVoiceView r100) {
        this.f356828a = r100;
    }

    @Override // com.larus.livetutor.impl.tutor.controller.r0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subtitle");
        Intrinsics.checkNotNullParameter("", MonitorConstants.CHUNK);
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorVoiceView] onSubtitleStream: " + r100 + ", chunk = ");
        LiveTutorVoiceView.U5(this.f356828a, r100);
    }
}
