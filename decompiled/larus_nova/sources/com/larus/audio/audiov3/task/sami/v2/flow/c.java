package com.larus.audio.audiov3.task.sami.v2.flow;

import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import g58.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements SAMICoreCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r78.b f288581a;

    public c(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f288581a = r100;
    }

    @Override // com.mammon.audiosdk.SAMICoreCallBackListener
    public final void onMessageReceived(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f288581a.a(r100.getValue(), new r78.a(r101.dataType.getValue(), r101.numberAudioData, r101.audioData, r101.userContext));
    }
}
