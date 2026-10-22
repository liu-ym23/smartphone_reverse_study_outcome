package com.larus.asr;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n58.b f288275a;

    public z2(b2 r100) {
        this.f288275a = r100;
    }

    public final void a(String r110, String r111, String r112, long r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "messageContent");
        Intrinsics.checkNotNullParameter(r112, "audioFilePath");
        Intrinsics.checkNotNullParameter("", "vid");
        n58.b r100 = this.f288275a;
        if (r100 == null) goto L6;
        n58.b.a.a(r100, r110, AsrCallBackType.AS_SUCCESS, r111, r112, r113, "", r114, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        return;
    }
}
