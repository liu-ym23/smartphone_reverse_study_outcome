package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements n68.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f319159a;

    public g(h r100) {
        this.f319159a = r100;
    }

    @Override // n68.a
    public final void d(PlayStateEnum r100) {
    }

    @Override // n68.a
    public final void e(TtsErrorType r100) {
    }

    @Override // n68.a
    public final void c(PlayStateEnum r100) {
        this.f319159a.f319162c.dispatchUIAction(new l.d(r100));
    }

    @Override // n68.a
    public final void a(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
    }

    @Override // n68.a
    public final void b(boolean r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
    }
}
