package i78;

import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;
import com.bytedance.flow_audio.api.player.KmpAudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements uw5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f488480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q58.b f488481b;

    @Override // uw5.b
    public final void a() {
    }

    @Override // uw5.b
    public final int c() {
        return this.f488480a;
    }

    public e(q58.b r100) {
        this.f488481b = r100;
        this.f488480a = r100.hashCode();
    }

    @Override // uw5.b
    public final void b(AudioPlayerStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        q58.b r101 = this.f488481b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = d.a.f488477a[r100.ordinal()];
        if (r102 != 1) goto L5;
    L14:
        AudioPlayerState r103 = AudioPlayerState.STARTED;
    L15:
        r101.b(r103);
        return;
    L5:
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L9;
        r103 = AudioPlayerState.PAUSED;
        goto L15
    L9:
        if (r102 != 4) goto L12;
        r103 = AudioPlayerState.STOPPED;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // uw5.b
    public final void d(KmpAudioPlayerErrorEnum r100, uw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        q58.b r102 = this.f488481b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(d.a.f488479c[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        AudioPlayerErrorEnum r103 = AudioPlayerErrorEnum.UNKNOWN_ERROR;
    L12:
        r102.a(r103);
        return;
    L7:
        r103 = AudioPlayerErrorEnum.INIT_ERROR;
        goto L12
    L8:
        r103 = AudioPlayerErrorEnum.WRITE_ERROR;
        goto L12
    L9:
        r103 = AudioPlayerErrorEnum.CONFIG_ERROR;
        goto L12
    L10:
        r103 = AudioPlayerErrorEnum.RELEASE_ERROR;
        goto L12
    L11:
        r103 = AudioPlayerErrorEnum.START_ERROR;
        goto L12
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
