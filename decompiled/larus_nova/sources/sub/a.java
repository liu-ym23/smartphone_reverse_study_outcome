package sub;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public final int hashCode() {
        Arrays.hashCode(null);
        throw null;
    }

    public final String toString() {
        return "ExternalEncodedAudioFrame(payload=" + Arrays.toString(null) + ", codec=null, sampleRate=0, channel=0, timestampUs=0, frameDurationMs=0, sequence=null, flags=null)";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalEncodedAudioFrame");
        a r102 = (a) r100;
        r102.getClass();
        if (Arrays.equals(null, null) == true) goto L15;
        return false;
    L15:
        r102.getClass();
        r102.getClass();
        r102.getClass();
        r102.getClass();
        r102.getClass();
        r102.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        r102.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
