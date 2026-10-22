package org.apache.commons.imaging.palette;

import java.io.Serializable;
import java.util.Comparator;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes42.dex */
class ColorSpaceSubset {
    private static final Logger LOGGER = null;
    public static final RgbComparator RGB_COMPARATOR = null;

    /* JADX INFO: renamed from: rgb, reason: collision with root package name */
    int f525012rgb;

    public static class RgbComparator implements Comparator<ColorSpaceSubset>, Serializable {
        private static final long serialVersionUID = 509214838111679029L;

        public RgbComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ColorSpaceSubset r100, ColorSpaceSubset r101) {
            return compare2(r100, r101);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ColorSpaceSubset r100, ColorSpaceSubset r101) {
            return r100.f525012rgb - r101.f525012rgb;
        }
    }

    static {
        LOGGER = Logger.getLogger(ColorSpaceSubset.class.getName());
        RGB_COMPARATOR = new RgbComparator();
    }
}
