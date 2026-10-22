package com.ss.android.ttve.vealgorithm.params;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class VECommonParam extends VEAlgorithmParam {
    public String applicationName;
    public String cacheDir;
    public String configPath;
    public int executeMode;
    public int extractFrameFPS;
    public int frameType;
    public ArrayList<String> imagePaths;
    public String modelDir;
    public a timeRange;
    public ArrayList<Long> timeVectorUS;
    public String videoPath;

    public static final enum VEComAlgoExeMode extends Enum<VEComAlgoExeMode> {
        public static final VEComAlgoExeMode DECODE_AND_NO_GRAPH_LOOP = null;
        public static final VEComAlgoExeMode GRAPH_DECODE = null;
        public static final VEComAlgoExeMode GRAPH_NO_DECODE_ONCE = null;
        public static final VEComAlgoExeMode NONE = null;
        public static final VEComAlgoExeMode NO_GRAPH_LOOP = null;
        public static final VEComAlgoExeMode NO_GRAPH_ONCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEComAlgoExeMode[] f449981a = null;

        static {
            VEComAlgoExeMode r100 = new VEComAlgoExeMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            VEComAlgoExeMode r101 = new VEComAlgoExeMode("GRAPH_DECODE", 1);
            GRAPH_DECODE = r101;
            VEComAlgoExeMode r102 = new VEComAlgoExeMode("GRAPH_NO_DECODE_ONCE", 2);
            GRAPH_NO_DECODE_ONCE = r102;
            VEComAlgoExeMode r103 = new VEComAlgoExeMode("NO_GRAPH_LOOP", 3);
            NO_GRAPH_LOOP = r103;
            VEComAlgoExeMode r104 = new VEComAlgoExeMode("NO_GRAPH_ONCE", 4);
            NO_GRAPH_ONCE = r104;
            VEComAlgoExeMode r105 = new VEComAlgoExeMode("DECODE_AND_NO_GRAPH_LOOP", 5);
            DECODE_AND_NO_GRAPH_LOOP = r105;
            f449981a = new VEComAlgoExeMode[]{r100, r101, r102, r103, r104, r105};
        }

        public static VEComAlgoExeMode[] values() {
            return (VEComAlgoExeMode[]) f449981a.clone();
        }

        public static VEComAlgoExeMode valueOf(String r100) {
            return (VEComAlgoExeMode) r27.a.a(VEComAlgoExeMode.class, r100);
        }

        public VEComAlgoExeMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VECommAlgoExtractFrameType extends Enum<VECommAlgoExtractFrameType> {
        public static final VECommAlgoExtractFrameType IMAGE_MULTIPLE = null;
        public static final VECommAlgoExtractFrameType IMAGE_SINGLE = null;
        public static final VECommAlgoExtractFrameType VIDEO_FPS = null;
        public static final VECommAlgoExtractFrameType VIDEO_TIME_RANGE = null;
        public static final VECommAlgoExtractFrameType VIDEO_TIME_VECTOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VECommAlgoExtractFrameType[] f449982a = null;

        static {
            VECommAlgoExtractFrameType r100 = new VECommAlgoExtractFrameType("VIDEO_TIME_RANGE", 0);
            VIDEO_TIME_RANGE = r100;
            VECommAlgoExtractFrameType r101 = new VECommAlgoExtractFrameType("VIDEO_FPS", 1);
            VIDEO_FPS = r101;
            VECommAlgoExtractFrameType r102 = new VECommAlgoExtractFrameType("VIDEO_TIME_VECTOR", 2);
            VIDEO_TIME_VECTOR = r102;
            VECommAlgoExtractFrameType r103 = new VECommAlgoExtractFrameType("IMAGE_SINGLE", 3);
            IMAGE_SINGLE = r103;
            VECommAlgoExtractFrameType r104 = new VECommAlgoExtractFrameType("IMAGE_MULTIPLE", 4);
            IMAGE_MULTIPLE = r104;
            f449982a = new VECommAlgoExtractFrameType[]{r100, r101, r102, r103, r104};
        }

        public static VECommAlgoExtractFrameType[] values() {
            return (VECommAlgoExtractFrameType[]) f449982a.clone();
        }

        public static VECommAlgoExtractFrameType valueOf(String r100) {
            return (VECommAlgoExtractFrameType) r27.a.a(VECommAlgoExtractFrameType.class, r100);
        }

        public VECommAlgoExtractFrameType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {
    }

    public VECommonParam() {
        this.frameType = VECommAlgoExtractFrameType.VIDEO_TIME_RANGE.ordinal();
        this.executeMode = VEComAlgoExeMode.NONE.ordinal();
        this.extractFrameFPS = 0;
        this.applicationName = "common_algorithm-ve";
        this.type = VEAlgorithmType.VEAlgorithmTypeCommonAlgorithm;
    }
}
