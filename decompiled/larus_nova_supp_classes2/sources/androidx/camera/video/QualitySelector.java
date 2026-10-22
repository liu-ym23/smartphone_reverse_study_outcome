package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class QualitySelector {
    private static final String TAG = "QualitySelector";
    private final FallbackStrategy mFallbackStrategy;
    private final List<Quality> mPreferredQualityList;

    public String toString() {
        return "QualitySelector{preferredQualities=" + this.mPreferredQualityList + ", fallbackStrategy=" + this.mFallbackStrategy + "}";
    }

    private static void checkQualityConstantsOrThrow(List<Quality> r4) {
        Iterator<Quality> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Quality r0 = r5.next();
        Preconditions.checkArgument(Quality.containsQuality(r0), "qualities contain invalid quality: " + r0);
        goto L4
    }

    public static QualitySelector from(Quality r1) {
        return from(r1, FallbackStrategy.NONE);
    }

    public static QualitySelector fromOrderedList(List<Quality> r1) {
        return fromOrderedList(r1, FallbackStrategy.NONE);
    }

    private static Size getProfileVideoSize(VideoValidatedEncoderProfilesProxy r2) {
        EncoderProfilesProxy.VideoProfileProxy r3 = r2.getDefaultVideoProfile();
        return new Size(r3.getWidth(), r3.getHeight());
    }

    public static List<Quality> getSupportedQualities(CameraInfo r1) {
        return Recorder.getVideoCapabilities(r1).getSupportedQualities(DynamicRange.SDR);
    }

    public List<Quality> getPrioritizedQualities(List<Quality> r7) {
        if (r7.isEmpty() == false) goto L6;
        Logger.w(TAG, "No supported quality on the device.");
        return new ArrayList();
    L6:
        Logger.d(TAG, "supportedQualities = " + r7);
        Set<Quality> r0 = new LinkedHashSet();
        Iterator<Quality> r2 = this.mPreferredQualityList.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        Quality r3 = r2.next();
        if (r3 == Quality.HIGHEST) goto L11;
        if (r3 == Quality.LOWEST) goto L14;
        if (r7.contains(r3) == true) goto L17;
        Logger.w(TAG, "quality is not supported and will be ignored: " + r3);
        goto L8
    L17:
        r0.add(r3);
        goto L8
    L14:
        ArrayList r1 = new ArrayList(r7);
        Collections.reverse(r1);
        r0.addAll(r1);
        goto L19
    L11:
        r0.addAll(r7);
    L19:
        addByFallbackStrategy(r7, r0);
        return new ArrayList(r0);
    }

    private static void checkQualityConstantsOrThrow(Quality r3) {
        Preconditions.checkArgument(Quality.containsQuality(r3), "Invalid quality: " + r3);
    }

    public QualitySelector(List<Quality> r3, FallbackStrategy r4) {
        if (r3.isEmpty() == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0, "No preferred quality and fallback strategy.");
        this.mPreferredQualityList = Collections.unmodifiableList(new ArrayList(r3));
        this.mFallbackStrategy = r4;
        return;
    L5:
        if (r4 != FallbackStrategy.NONE) goto L8;
        r0 = false;
        goto L9
    }

    private void addByFallbackStrategy(List<Quality> r11, Set<Quality> r12) {
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12.containsAll(r11) == false) goto L8;
        return;
    L8:
        Logger.d(TAG, "Select quality by fallbackStrategy = " + this.mFallbackStrategy);
        FallbackStrategy r0 = this.mFallbackStrategy;
        if (r0 != FallbackStrategy.NONE) goto L11;
        return;
    L11:
        Preconditions.checkState(r0 instanceof FallbackStrategy.RuleStrategy, "Currently only support type RuleStrategy");
        FallbackStrategy.RuleStrategy r1 = (FallbackStrategy.RuleStrategy) this.mFallbackStrategy;
        List<Quality> r2 = Quality.getSortedQualities();
        boolean r5 = false;
        if (r1.getFallbackQuality() != Quality.HIGHEST) goto L15;
        Quality r3 = (Quality) ListProtector.get(r2, 0);
    L18:
        int r4 = r2.indexOf(r3);
        if (r4 == (-1)) goto L21;
        r5 = true;
    L21:
        Preconditions.checkState(r5);
        ArrayList r6 = new ArrayList();
        int r7 = r4 - 1;
    L22:
        if (r7 < 0) goto L27;
        Quality r8 = (Quality) ListProtector.get(r2, r7);
        if (r11.contains(r8) == false) goto L26;
        r6.add(r8);
    L26:
        r7 = r7 - 1;
        goto L22
    L27:
        ArrayList r9 = new ArrayList();
        int r10 = r4 + 1;
    L29:
        if (r10 >= r2.size()) goto L34;
        Quality r13 = (Quality) ListProtector.get(r2, r10);
        if (r11.contains(r13) == false) goto L33;
        r9.add(r13);
    L33:
        r10 = r10 + 1;
        goto L29
    L34:
        Logger.d(TAG, "sizeSortedQualities = " + r2 + ", fallback quality = " + r3 + ", largerQualities = " + r6 + ", smallerQualities = " + r9);
        int r14 = r1.getFallbackRule();
        if (r14 == 0) goto L56;
        if (r14 != 1) goto L38;
        r12.addAll(r6);
        r12.addAll(r9);
        return;
    L38:
        if (r14 != 2) goto L40;
        r12.addAll(r6);
        return;
    L40:
        if (r14 != 3) goto L42;
        r12.addAll(r9);
        r12.addAll(r6);
        return;
    L42:
        if (r14 != 4) goto L45;
        r12.addAll(r9);
        return;
    L45:
        throw new AssertionError("Unhandled fallback strategy: " + this.mFallbackStrategy);
    L56:
        return;
    L15:
        if (r1.getFallbackQuality() != Quality.LOWEST) goto L17;
        r3 = (Quality) ListProtector.get(r2, r2.size() - 1);
        goto L18
    L17:
        r3 = r1.getFallbackQuality();
        goto L18
    }

    public static QualitySelector from(Quality r1, FallbackStrategy r2) {
        Preconditions.checkNotNull(r1, "quality cannot be null");
        Preconditions.checkNotNull(r2, "fallbackStrategy cannot be null");
        checkQualityConstantsOrThrow(r1);
        return new QualitySelector(Collections.singletonList(r1), r2);
    }

    public static QualitySelector fromOrderedList(List<Quality> r2, FallbackStrategy r3) {
        Preconditions.checkNotNull(r2, "qualities cannot be null");
        Preconditions.checkNotNull(r3, "fallbackStrategy cannot be null");
        Preconditions.checkArgument(!r2.isEmpty(), "qualities cannot be empty");
        checkQualityConstantsOrThrow(r2);
        return new QualitySelector(r2, r3);
    }

    public static Map<Quality, Size> getQualityToResolutionMap(VideoCapabilities r5, DynamicRange r6) {
        HashMap r0 = new HashMap();
        Iterator<Quality> r1 = r5.getSupportedQualities(r6).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Quality r2 = r1.next();
        VideoValidatedEncoderProfilesProxy r3 = r5.getProfiles(r2, r6);
        Objects.requireNonNull(r3);
        r0.put(r2, getProfileVideoSize(r3));
        goto L4
    L6:
        return r0;
    }

    public static Size getResolution(CameraInfo r1, Quality r2) {
        checkQualityConstantsOrThrow(r2);
        VideoValidatedEncoderProfilesProxy r3 = Recorder.getVideoCapabilities(r1).getProfiles(r2, DynamicRange.SDR);
        if (r3 != null) goto L7;
        return null;
    L7:
        return getProfileVideoSize(r3);
    }

    public static boolean isQualitySupported(CameraInfo r1, Quality r2) {
        return Recorder.getVideoCapabilities(r1).isQualitySupported(r2, DynamicRange.SDR);
    }
}
