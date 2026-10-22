package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    private final DynamicValueConfig mDynamicValueConfig;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
        private DefaultDynamicValueConfig() {
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int getGoodEnoughScanNumber() {
            return 0;
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public List<Integer> getScansToDecode() {
            return Collections.EMPTY_LIST;
        }

        public /* synthetic */ DefaultDynamicValueConfig(AnonymousClass1 r100) {
            this();
        }
    }

    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig(null));
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig r100) {
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(r100);
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int getNextScanNumberToDecode(int r100) {
        List<Integer> r101 = this.mDynamicValueConfig.getScansToDecode();
        if (r101 == null) goto L18;
        if (r101.isEmpty() == true) goto L18;
        int r102 = 0;
    L9:
        if (r102 >= r101.size()) goto L15;
        if (r101.get(r102).intValue() > r100) goto L13;
        r102 = r102 + 1;
        goto L9
    L13:
        return r101.get(r102).intValue();
    L15:
        return Integer.MAX_VALUE;
    L18:
        return r100 + 1;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public QualityInfo getQualityInfo(int r100) {
        if (r100 < this.mDynamicValueConfig.getGoodEnoughScanNumber()) goto L5;
        boolean r101 = true;
    L7:
        return ImmutableQualityInfo.of(r100, r101, false);
    L5:
        r101 = false;
        goto L7
    }
}
