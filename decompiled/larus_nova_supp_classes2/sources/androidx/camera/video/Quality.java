package androidx.camera.video;

import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Quality {
    public static final Quality FHD = null;
    public static final Quality HD = null;
    public static final Quality HIGHEST = null;
    public static final Quality LOWEST = null;
    static final Quality NONE = null;
    private static final Set<Quality> QUALITIES = null;
    private static final List<Quality> QUALITIES_ORDER_BY_SIZE = null;
    public static final Quality SD = null;
    public static final Quality UHD = null;

    /* JADX INFO: renamed from: androidx.camera.video.Quality$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class ConstantQuality extends Quality {
        public ConstantQuality() {
            super(null);
        }

        public abstract String getName();

        public abstract List<Size> getTypicalSizes();

        public abstract int getValue();

        public static ConstantQuality of(int r1, String r2, List<Size> r3) {
            return new AutoValue_Quality_ConstantQuality(r1, r2, r3);
        }
    }

    static {
        ConstantQuality r1 = ConstantQuality.of(4, "SD", Collections.unmodifiableList(Arrays.asList(new Size[]{new Size(720, 480), new Size(640, 480)})));
        SD = r1;
        ConstantQuality r3 = ConstantQuality.of(5, "HD", Collections.singletonList(new Size(1280, 720)));
        HD = r3;
        ConstantQuality r7 = ConstantQuality.of(6, "FHD", Collections.singletonList(new Size(1920, 1080)));
        FHD = r7;
        ConstantQuality r9 = ConstantQuality.of(8, "UHD", Collections.singletonList(new Size(3840, 2160)));
        UHD = r9;
        ConstantQuality r10 = ConstantQuality.of(0, "LOWEST", Collections.emptyList());
        LOWEST = r10;
        ConstantQuality r11 = ConstantQuality.of(1, "HIGHEST", Collections.emptyList());
        HIGHEST = r11;
        NONE = ConstantQuality.of(-1, "NONE", Collections.emptyList());
        QUALITIES = new HashSet(Arrays.asList(new Quality[]{r10, r11, r1, r3, r7, r9}));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(new Quality[]{r9, r7, r3, r1});
    }

    public static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }

    private Quality() {
    }

    public /* synthetic */ Quality(AnonymousClass1 r1) {
        this();
    }

    public static boolean containsQuality(Quality r1) {
        return QUALITIES.contains(r1);
    }
}
