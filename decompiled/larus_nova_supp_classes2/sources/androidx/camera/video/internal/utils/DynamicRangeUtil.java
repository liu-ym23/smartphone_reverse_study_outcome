package androidx.camera.video.internal.utils;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DynamicRangeUtil {
    public static final Map<Integer, Set<Integer>> DR_TO_VP_BIT_DEPTH_MAP = null;
    public static final Map<Integer, Set<Integer>> DR_TO_VP_FORMAT_MAP = null;
    private static final Map<String, Map<DynamicRange, Integer>> MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = null;
    public static final Map<Integer, Integer> VP_TO_DR_BIT_DEPTH = null;
    public static final Map<Integer, Integer> VP_TO_DR_FORMAT_MAP = null;

    static {
        HashMap r0 = new HashMap();
        DR_TO_VP_BIT_DEPTH_MAP = r0;
        HashMap r1 = new HashMap();
        DR_TO_VP_FORMAT_MAP = r1;
        HashMap r2 = new HashMap();
        VP_TO_DR_BIT_DEPTH = r2;
        HashMap r3 = new HashMap();
        VP_TO_DR_FORMAT_MAP = r3;
        HashMap r4 = new HashMap();
        MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = r4;
        r0.put(8, new HashSet(Collections.singletonList(8)));
        r0.put(10, new HashSet(Collections.singletonList(10)));
        r0.put(0, new HashSet(Arrays.asList(new Integer[]{8, 10})));
        r1.put(0, new HashSet(Arrays.asList(new Integer[]{0, 1, 2, 3, 4})));
        r1.put(1, new HashSet(Collections.singletonList(0)));
        r1.put(2, new HashSet(Arrays.asList(new Integer[]{1, 2, 3, 4})));
        r1.put(3, new HashSet(Collections.singletonList(1)));
        r1.put(4, new HashSet(Collections.singletonList(2)));
        r1.put(5, new HashSet(Collections.singletonList(3)));
        r1.put(6, new HashSet(Collections.singletonList(4)));
        r2.put(8, 8);
        r2.put(10, 10);
        r3.put(0, 1);
        r3.put(1, 3);
        r3.put(2, 4);
        r3.put(3, 5);
        r3.put(4, 6);
        HashMap r5 = new HashMap();
        DynamicRange r6 = DynamicRange.SDR;
        r5.put(r6, 1);
        DynamicRange r7 = DynamicRange.HLG_10_BIT;
        r5.put(r7, 2);
        DynamicRange r8 = DynamicRange.HDR10_10_BIT;
        r5.put(r8, 4096);
        DynamicRange r9 = DynamicRange.HDR10_PLUS_10_BIT;
        r5.put(r9, 8192);
        HashMap r10 = new HashMap();
        r10.put(r6, 1);
        r10.put(r7, 2);
        r10.put(r8, 4096);
        r10.put(r9, 8192);
        HashMap r11 = new HashMap();
        r11.put(r6, 1);
        r11.put(r7, 4);
        r11.put(r8, 4096);
        r11.put(r9, 16384);
        HashMap r12 = new HashMap();
        r12.put(DynamicRange.DOLBY_VISION_10_BIT, 256);
        r12.put(DynamicRange.DOLBY_VISION_8_BIT, 512);
        r4.put("video/hevc", r5);
        r4.put("video/av01", r10);
        r4.put("video/x-vnd.on2.vp9", r11);
        r4.put("video/dolby-vision", r12);
    }

    private DynamicRangeUtil() {
    }

    public static Set<Integer> dynamicRangeToVideoProfileBitDepth(DynamicRange r1) {
        Set<Integer> r2 = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(r1.getBitDepth()));
        if (r2 == null) goto L5;
        return r2;
    L5:
        return Collections.emptySet();
    }

    public static Set<Integer> dynamicRangeToVideoProfileHdrFormats(DynamicRange r1) {
        Set<Integer> r2 = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(r1.getEncoding()));
        if (r2 == null) goto L5;
        return r2;
    L5:
        return Collections.emptySet();
    }

    public static int videoProfileBitDepthToDynamicRangeBitDepth(int r2) {
        Map<Integer, Integer> r0 = VP_TO_DR_BIT_DEPTH;
        Preconditions.checkArgument(r0.containsKey(Integer.valueOf(r2)));
        Integer r3 = r0.get(Integer.valueOf(r2));
        Objects.requireNonNull(r3);
        return r3.intValue();
    }

    public static int videoProfileHdrFormatsToDynamicRangeEncoding(int r2) {
        Map<Integer, Integer> r0 = VP_TO_DR_FORMAT_MAP;
        Preconditions.checkArgument(r0.containsKey(Integer.valueOf(r2)));
        Integer r3 = r0.get(Integer.valueOf(r2));
        Objects.requireNonNull(r3);
        return r3.intValue();
    }

    public static int dynamicRangeToCodecProfileLevelForMime(String r1, DynamicRange r2) {
        Map<DynamicRange, Integer> r3 = MIME_TO_DEFAULT_PROFILE_LEVEL_MAP.get(r1);
        if (r3 == null) goto L8;
        Integer r4 = r3.get(r2);
        if (r4 != null) goto L7;
        return -1;
    L7:
        return r4.intValue();
    L8:
        return -1;
    }

    private static boolean isBitDepthMatched(int r1, DynamicRange r2) {
        Set<Integer> r3 = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(r2.getBitDepth()));
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.contains(Integer.valueOf(r1)) == false) goto L7;
        return true;
    }

    private static boolean isHdrEncodingMatched(int r1, DynamicRange r2) {
        Set<Integer> r3 = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(r2.getEncoding()));
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.contains(Integer.valueOf(r1)) == false) goto L7;
        return true;
    }

    public static boolean isHdrSettingsMatched(EncoderProfilesProxy.VideoProfileProxy r1, DynamicRange r2) {
        if (isBitDepthMatched(r1.getBitDepth(), r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (isHdrEncodingMatched(r1.getHdrFormat(), r2) == false) goto L7;
        return true;
    }
}
