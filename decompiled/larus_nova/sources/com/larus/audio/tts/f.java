package com.larus.audio.tts;

import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.platform.api.r3;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements n68.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r3.b f289839a;

    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f289840a = null;

        static {
            int[] r100 = new int[PlayStateEnum.values().length];
            r100[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f289840a = r100;
        }
    }

    public f() {
    }

    @Override // n68.a
    public final void d(PlayStateEnum r100) {
    }

    @Override // n68.a
    public final void e(TtsErrorType r100) {
    }

    @Override // n68.a
    public final void c(PlayStateEnum r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
        r3.b r102 = this.f289839a;
        if (r102 == null) goto L19;
        r102.end();
    L19:
        r3.b r103 = r3.f365250a.a("tts");
        this.f289839a = r103;
        if (r103 == null) goto L24;
        r103.start();
        return;
    L24:
        return;
    L8:
        if (r101 != 2) goto L10;
    L12:
        r3.b r104 = this.f289839a;
        if (r104 == null) goto L15;
        r104.end();
    L15:
        this.f289839a = null;
        return;
    L10:
        if (r101 == 3) goto L12;
        return;
    L4:
        r101 = a.f289840a[r100.ordinal()];
        goto L6
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
