package com.ss.android.ttve.vealgorithm.params;

import com.ss.android.vesdk.VERect;
import com.ss.android.vesdk.VERectF;

/* JADX INFO: loaded from: classes38.dex */
public class VEBachCommonImageResult extends VEAlgorithmResult {
    public MattingContent mattingContent;
    public ReframeContent[] reframeContents;
    public float[] vectorResult;

    public static class MattingContent {
        public VERect box;
        public boolean isValid;
        public String outputPath;

        public MattingContent() {
        }
    }

    public static class ReframeContent {
        public VERectF box;
        public boolean isValid;

        public ReframeContent() {
        }
    }

    public VEBachCommonImageResult() {
        this.type = VEAlgorithmType.VEAlgorithmTypeBachCommonImage;
    }
}
