package com.larus.asr;

import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h68.d f287271a;

    public f2(d.a r100) {
        this.f287271a = r100;
    }

    public final void a(String r110, String r111, long r112, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "messageContent");
        Intrinsics.checkNotNullParameter("", "vid");
        h68.d r113 = this.f287271a;
        if (r113 == null) goto L6;
        r113.a(new y58.b(r110, null, null, r111, "", r112, AsrResultState.SUCCESS, AsrEventEnum.ASR_SUCCESS, new y58.c(r210, r211, r212), 6));
        return;
    }
}
