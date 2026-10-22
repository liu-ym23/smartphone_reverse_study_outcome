package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.camera.core.DynamicRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DynamicRangeConversions {
    private static final Map<DynamicRange, List<Long>> DR_TO_PROFILE_MAP = null;
    private static final Map<Long, DynamicRange> PROFILE_TO_DR_MAP = null;

    private DynamicRangeConversions() {
    }

    static {
        HashMap r0 = new HashMap();
        PROFILE_TO_DR_MAP = r0;
        HashMap r1 = new HashMap();
        DR_TO_PROFILE_MAP = r1;
        DynamicRange r3 = DynamicRange.SDR;
        r0.put(1L, r3);
        r1.put(r3, Collections.singletonList(1L));
        r0.put(2L, DynamicRange.HLG_10_BIT);
        r1.put((DynamicRange) r0.get(2L), Collections.singletonList(2L));
        DynamicRange r4 = DynamicRange.HDR10_10_BIT;
        r0.put(4L, r4);
        r1.put(r4, Collections.singletonList(4L));
        DynamicRange r5 = DynamicRange.HDR10_PLUS_10_BIT;
        r0.put(8L, r5);
        r1.put(r5, Collections.singletonList(8L));
        List<Long> r2 = Arrays.asList(new Long[]{64L, 128L, 16L, 32L});
        Iterator<Long> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        PROFILE_TO_DR_MAP.put(r6.next(), DynamicRange.DOLBY_VISION_10_BIT);
        goto L4
    L6:
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_10_BIT, r2);
        List<Long> r7 = Arrays.asList(new Long[]{Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH), 256L, 512L});
        Iterator<Long> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        PROFILE_TO_DR_MAP.put(r8.next(), DynamicRange.DOLBY_VISION_8_BIT);
        goto L8
    L10:
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_8_BIT, r7);
    }

    public static DynamicRange profileToDynamicRange(long r1) {
        return PROFILE_TO_DR_MAP.get(Long.valueOf(r1));
    }

    public static Long dynamicRangeToFirstSupportedProfile(DynamicRange r2, DynamicRangeProfiles r3) {
        List<Long> r4 = DR_TO_PROFILE_MAP.get(r2);
        if (r4 == null) goto L10;
        Set<Long> r5 = r3.getSupportedProfiles();
        Iterator<Long> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Long r0 = r6.next();
        if (r5.contains(r0) == false) goto L6;
        return r0;
    L15:
        return null;
    L10:
        return null;
    }
}
