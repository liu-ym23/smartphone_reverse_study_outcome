package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableFrameInfo {
    public final BlendOperation blendOperation;
    public final DisposalMethod disposalMethod;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    public static final enum BlendOperation extends Enum<BlendOperation> {
        private static final /* synthetic */ BlendOperation[] $VALUES = null;
        public static final BlendOperation BLEND_WITH_PREVIOUS = null;
        public static final BlendOperation NO_BLEND = null;

        static {
            BlendOperation r100 = new BlendOperation("BLEND_WITH_PREVIOUS", 0);
            BLEND_WITH_PREVIOUS = r100;
            BlendOperation r101 = new BlendOperation("NO_BLEND", 1);
            NO_BLEND = r101;
            $VALUES = new BlendOperation[]{r100, r101};
        }

        public static BlendOperation[] values() {
            return (BlendOperation[]) $VALUES.clone();
        }

        public static BlendOperation valueOf(String r100) {
            return (BlendOperation) Enum.valueOf(BlendOperation.class, r100);
        }

        private BlendOperation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DisposalMethod extends Enum<DisposalMethod> {
        private static final /* synthetic */ DisposalMethod[] $VALUES = null;
        public static final DisposalMethod DISPOSE_DO_NOT = null;
        public static final DisposalMethod DISPOSE_TO_BACKGROUND = null;
        public static final DisposalMethod DISPOSE_TO_PREVIOUS = null;

        static {
            DisposalMethod r100 = new DisposalMethod("DISPOSE_DO_NOT", 0);
            DISPOSE_DO_NOT = r100;
            DisposalMethod r101 = new DisposalMethod("DISPOSE_TO_BACKGROUND", 1);
            DISPOSE_TO_BACKGROUND = r101;
            DisposalMethod r102 = new DisposalMethod("DISPOSE_TO_PREVIOUS", 2);
            DISPOSE_TO_PREVIOUS = r102;
            $VALUES = new DisposalMethod[]{r100, r101, r102};
        }

        public static DisposalMethod[] values() {
            return (DisposalMethod[]) $VALUES.clone();
        }

        public static DisposalMethod valueOf(String r100) {
            return (DisposalMethod) Enum.valueOf(DisposalMethod.class, r100);
        }

        private DisposalMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnimatedDrawableFrameInfo(int r100, int r101, int r102, int r103, int r104, BlendOperation r105, DisposalMethod r106) {
        this.frameNumber = r100;
        this.xOffset = r101;
        this.yOffset = r102;
        this.width = r103;
        this.height = r104;
        this.blendOperation = r105;
        this.disposalMethod = r106;
    }
}
