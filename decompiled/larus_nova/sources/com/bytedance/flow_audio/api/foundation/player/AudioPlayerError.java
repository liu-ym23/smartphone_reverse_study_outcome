package com.bytedance.flow_audio.api.foundation.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPlayerError extends Exception {
    private final String message;

    public static /* synthetic */ AudioPlayerError copy$default(AudioPlayerError r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.message;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.message;
    }

    public final AudioPlayerError copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return new AudioPlayerError(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioPlayerError) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.message, ((AudioPlayerError) r100).message) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AudioPlayerError(message=" + this.message + ')';
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public AudioPlayerError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.message = r100;
    }
}
