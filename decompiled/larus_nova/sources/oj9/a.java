package oj9;

import androidx.camera.video.AudioStats;
import com.larus.settings.tutor.LiveTutorConfig;
import com.larus.settings.tutor.VoiceConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final double a(LiveTutorConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<VoiceConfig> r101 = r100.getTtsPitchList();
        if (r101 == null) goto L19;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        VoiceConfig r104 = (VoiceConfig) r103;
        if (r104 == null) goto L10;
        boolean r105 = Intrinsics.areEqual(r104.isDefault(), Boolean.TRUE);
    L11:
        if (r105 == false) goto L6;
    L14:
        VoiceConfig r106 = (VoiceConfig) r103;
        if (r106 == null) goto L19;
        Double r107 = r106.getValue();
        if (r107 == null) goto L19;
        return r107.doubleValue();
    L10:
        r105 = false;
        goto L11
    L13:
        r103 = null;
    L19:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static final double b(LiveTutorConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<VoiceConfig> r101 = r100.getTtsSpeedList();
        if (r101 == null) goto L19;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        VoiceConfig r104 = (VoiceConfig) r103;
        if (r104 == null) goto L10;
        boolean r105 = Intrinsics.areEqual(r104.isDefault(), Boolean.TRUE);
    L11:
        if (r105 == false) goto L6;
    L14:
        VoiceConfig r106 = (VoiceConfig) r103;
        if (r106 == null) goto L19;
        Double r107 = r106.getValue();
        if (r107 == null) goto L19;
        return r107.doubleValue();
    L10:
        r105 = false;
        goto L11
    L13:
        r103 = null;
    L19:
        return 1.0d;
    }
}
