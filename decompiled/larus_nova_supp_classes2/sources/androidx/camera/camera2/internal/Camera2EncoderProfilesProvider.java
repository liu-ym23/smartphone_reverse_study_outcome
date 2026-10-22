package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.compat.EncoderProfilesProxyCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Camera2EncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "Camera2EncoderProfilesProvider";
    private final String mCameraId;
    private final Quirks mCameraQuirks;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final boolean mHasValidCameraId;
    private final int mIntCameraId;

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EncoderProfiles getAll(String r0, int r1) {
            return CamcorderProfile.getAll(r0, r1);
        }
    }

    private EncoderProfilesProxy findHighestQualityProfiles() {
        Iterator<Integer> r0 = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        EncoderProfilesProxy r1 = getAll(r0.next().intValue());
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    private EncoderProfilesProxy findLowestQualityProfiles() {
        int r0 = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        EncoderProfilesProxy r1 = getAll(r0);
        if (r1 != null) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private EncoderProfilesProxy createProfilesFromCamcorderProfile(int r5) {
        CamcorderProfile r6 = CamcorderProfile.get(this.mIntCameraId, r5);     // Catch: RuntimeException -> L5
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        return EncoderProfilesProxyCompat.from(r6);
    L5:
        e = move-exception;
        Logger.w(TAG, "Unable to get CamcorderProfile by quality: " + r5, e);
        r6 = null;
        goto L7
    }

    private EncoderProfilesProxy getProfilesInternal(int r4) {
        if (Build.VERSION.SDK_INT < 31) goto L20;
        EncoderProfiles r0 = Api31Impl.getAll(this.mCameraId, r4);
        if (r0 != null) goto L9;
        return null;
    L9:
        if (DeviceQuirks.get(InvalidVideoProfilesQuirk.class) == null) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L21;
        Logger.d(TAG, "EncoderProfiles contains invalid video profiles, use CamcorderProfile to create EncoderProfilesProxy.");
        goto L20
    L21:
        return EncoderProfilesProxyCompat.from(r0);
    L17:
        e = move-exception;
        Logger.w(TAG, "Failed to create EncoderProfilesProxy, EncoderProfiles might  contain invalid video profiles. Use CamcorderProfile instead.", e);
        goto L20
    L11:
        r1 = false;
    L20:
        return createProfilesFromCamcorderProfile(r4);
    }

    private boolean isEncoderProfilesResolutionValidInQuirk(EncoderProfilesProxy r4) {
        CamcorderProfileResolutionQuirk r0 = (CamcorderProfileResolutionQuirk) this.mCameraQuirks.get(CamcorderProfileResolutionQuirk.class);
        if (r0 != null) goto L5;
        return true;
    L5:
        List<EncoderProfilesProxy.VideoProfileProxy> r5 = r4.getVideoProfiles();
        if (r5.isEmpty() == false) goto L8;
        return true;
    L8:
        EncoderProfilesProxy.VideoProfileProxy r6 = (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r5, 0);
        return r0.getSupportedResolutions().contains(new Size(r6.getWidth(), r6.getHeight()));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r4) {
        EncoderProfilesProxy r1 = null;
        if (this.mHasValidCameraId == true) goto L6;
        return null;
    L6:
        if (CamcorderProfile.hasProfile(this.mIntCameraId, r4) == true) goto L9;
        return null;
    L9:
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r4)) == true) goto L11;
        EncoderProfilesProxy r0 = getProfilesInternal(r4);
        if (r0 != null) goto L15;
    L21:
        r1 = r0;
    L22:
        this.mEncoderProfilesCache.put(Integer.valueOf(r4), r1);
        return r1;
    L15:
        if (isEncoderProfilesResolutionValidInQuirk(r0) == true) goto L21;
        if (r4 != 1) goto L19;
        r1 = findHighestQualityProfiles();
        goto L22
    L19:
        if (r4 != 0) goto L22;
        r1 = findLowestQualityProfiles();
        goto L22
    L11:
        return this.mEncoderProfilesCache.get(Integer.valueOf(r4));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r3) {
        if (this.mHasValidCameraId == true) goto L6;
        return false;
    L6:
        if (getAll(r3) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public Camera2EncoderProfilesProvider(String r3, Quirks r4) {
        this.mEncoderProfilesCache = new HashMap();
        this.mCameraId = r3;
        int r5 = CastIntegerProtector.parseInt(r3);     // Catch: NumberFormatException -> L5
        boolean r0 = true;
    L6:
        this.mHasValidCameraId = r0;
        this.mIntCameraId = r5;
        this.mCameraQuirks = r4;
        return;
    L5:
        Logger.w(TAG, "Camera id is not an integer: " + r3 + ", unable to create Camera2EncoderProfilesProvider");
        r0 = false;
        r5 = -1;
        goto L6
    }
}
