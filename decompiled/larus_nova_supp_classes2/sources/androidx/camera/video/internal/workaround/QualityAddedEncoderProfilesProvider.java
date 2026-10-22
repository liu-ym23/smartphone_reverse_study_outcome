package androidx.camera.video.internal.workaround;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedQualityQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class QualityAddedEncoderProfilesProvider implements EncoderProfilesProvider {
    private Map<Integer, EncoderProfilesProxy> mExtraQualityToEncoderProfiles;
    private final EncoderProfilesProvider mProvider;

    private EncoderProfilesProxy getProfilesInternal(int r3) {
        Map<Integer, EncoderProfilesProxy> r0 = this.mExtraQualityToEncoderProfiles;
        if (r0 == null) goto L9;
        if (r0.containsKey(Integer.valueOf(r3)) == false) goto L9;
        return this.mExtraQualityToEncoderProfiles.get(Integer.valueOf(r3));
    L9:
        return this.mProvider.getAll(r3);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r1) {
        return getProfilesInternal(r1);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r1) {
        if (getProfilesInternal(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public QualityAddedEncoderProfilesProvider(EncoderProfilesProvider r4, Quirks r5, CameraInfoInternal r6, Function<VideoEncoderConfig, VideoEncoderInfo> r7) {
        this.mProvider = r4;
        List r8 = r5.getAll(ExtraSupportedQualityQuirk.class);
        if (r8.isEmpty() == true) goto L12;
        boolean r2 = true;
        if (r8.size() == 1) goto L8;
        r2 = false;
    L8:
        Preconditions.checkState(r2);
        Map<Integer, EncoderProfilesProxy> r9 = ((ExtraSupportedQualityQuirk) ListProtector.get(r8, 0)).getExtraEncoderProfiles(r6, r4, r7);
        if (r9 == null) goto L13;
        this.mExtraQualityToEncoderProfiles = new HashMap(r9);
        return;
    L13:
        return;
    }
}
