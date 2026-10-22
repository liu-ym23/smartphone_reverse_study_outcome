package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<DynamicRange> OPTION_INPUT_DYNAMIC_RANGE = null;
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.ImageInputConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static DynamicRange $default$getDynamicRange(ImageInputConfig r2) {
            return (DynamicRange) Preconditions.checkNotNull((DynamicRange) r2.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED));
        }

        public static int $default$getInputFormat(ImageInputConfig r1) {
            return ((Integer) r1.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
        }

        public static boolean $default$hasDynamicRange(ImageInputConfig r1) {
            return r1.containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
        }
    }

    public interface Builder<B> {
        B setDynamicRange(DynamicRange r1);
    }

    DynamicRange getDynamicRange();

    int getInputFormat();

    boolean hasDynamicRange();

    static {
        OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);
        OPTION_INPUT_DYNAMIC_RANGE = Config.Option.create("camerax.core.imageInput.inputDynamicRange", DynamicRange.class);
    }
}
