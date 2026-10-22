package com.bytedance.bmmt.video;

import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public interface VideoEncoder {

    public static final enum BitrateMode extends Enum<BitrateMode> {
        private static final /* synthetic */ BitrateMode[] $VALUES = null;
        public static final BitrateMode AUTO = null;
        public static final BitrateMode CBR = null;
        public static final BitrateMode VBR = null;
        private int value;

        private static /* synthetic */ BitrateMode[] $values() {
            return new BitrateMode[]{AUTO, VBR, CBR};
        }

        static {
            AUTO = new BitrateMode("AUTO", 0, 0);
            VBR = new BitrateMode("VBR", 1, 1);
            CBR = new BitrateMode("CBR", 2, 2);
            $VALUES = $values();
        }

        public static BitrateMode[] values() {
            return (BitrateMode[]) $VALUES.clone();
        }

        public static BitrateMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return AUTO;
        L10:
            return CBR;
        L12:
            return VBR;
        L14:
            return AUTO;
        }

        public static BitrateMode valueOf(String r100) {
            return (BitrateMode) r27.a.a(BitrateMode.class, r100);
        }

        private BitrateMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface Callback {
        void onEncodedEvent(EncodeEvent r100);

        void onEncodedFrame(EncodedImage r100, CodecSpecificInfo r101, ByteBuffer r102);
    }

    public static class CodecSpecificInfo {
        public BmmtVideoCodecStandard codec_standard;

        public CodecSpecificInfo(BmmtVideoCodecStandard r100) {
            this.codec_standard = r100;
        }
    }

    public static final enum EncodeEvent extends Enum<EncodeEvent> {
        private static final /* synthetic */ EncodeEvent[] $VALUES = null;
        public static final EncodeEvent RESET = null;
        public static final EncodeEvent UNKNOWN = null;
        private int value;

        private static /* synthetic */ EncodeEvent[] $values() {
            return new EncodeEvent[]{UNKNOWN, RESET};
        }

        static {
            UNKNOWN = new EncodeEvent("UNKNOWN", 0, 0);
            RESET = new EncodeEvent("RESET", 1, 1);
            $VALUES = $values();
        }

        public static EncodeEvent[] values() {
            return (EncodeEvent[]) $VALUES.clone();
        }

        public int getEventValue() {
            return this.value;
        }

        public static EncodeEvent fromValue(int r100) {
            if (r100 == 1) goto L7;
            return UNKNOWN;
        L7:
            return RESET;
        }

        public static EncodeEvent valueOf(String r100) {
            return (EncodeEvent) r27.a.a(EncodeEvent.class, r100);
        }

        private EncodeEvent(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum EncodeMode extends Enum<EncodeMode> {
        private static final /* synthetic */ EncodeMode[] $VALUES = null;
        public static final EncodeMode CLOUD_GAME = null;
        public static final EncodeMode COMMON = null;
        public static final EncodeMode CONFERENCE = null;
        public static final EncodeMode LIVE = null;
        private int value;

        private static /* synthetic */ EncodeMode[] $values() {
            return new EncodeMode[]{COMMON, CLOUD_GAME, CONFERENCE, LIVE};
        }

        static {
            COMMON = new EncodeMode("COMMON", 0, 0);
            CLOUD_GAME = new EncodeMode("CLOUD_GAME", 1, 1);
            CONFERENCE = new EncodeMode("CONFERENCE", 2, 2);
            LIVE = new EncodeMode("LIVE", 3, 3);
            $VALUES = $values();
        }

        public static EncodeMode[] values() {
            return (EncodeMode[]) $VALUES.clone();
        }

        public static EncodeMode fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return COMMON;
        L11:
            return LIVE;
        L13:
            return CONFERENCE;
        L15:
            return CLOUD_GAME;
        }

        public static EncodeMode valueOf(String r100) {
            return (EncodeMode) r27.a.a(EncodeMode.class, r100);
        }

        private EncodeMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ScaleMode extends Enum<ScaleMode> {
        private static final /* synthetic */ ScaleMode[] $VALUES = null;
        public static final ScaleMode AUTO = null;
        public static final ScaleMode FIT_WITH_CROPPING = null;
        public static final ScaleMode FIT_WITH_FILLING = null;
        public static final ScaleMode STRETCH = null;
        private int value;

        private static /* synthetic */ ScaleMode[] $values() {
            return new ScaleMode[]{AUTO, STRETCH, FIT_WITH_CROPPING, FIT_WITH_FILLING};
        }

        static {
            AUTO = new ScaleMode("AUTO", 0, 0);
            STRETCH = new ScaleMode("STRETCH", 1, 1);
            FIT_WITH_CROPPING = new ScaleMode("FIT_WITH_CROPPING", 2, 2);
            FIT_WITH_FILLING = new ScaleMode("FIT_WITH_FILLING", 3, 3);
            $VALUES = $values();
        }

        public static ScaleMode[] values() {
            return (ScaleMode[]) $VALUES.clone();
        }

        public static ScaleMode fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return AUTO;
        L12:
            return FIT_WITH_FILLING;
        L14:
            return FIT_WITH_CROPPING;
        L16:
            return STRETCH;
        L18:
            return AUTO;
        }

        public static ScaleMode valueOf(String r100) {
            return (ScaleMode) r27.a.a(ScaleMode.class, r100);
        }

        private ScaleMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class ScalingSettings {
        public static final ScalingSettings OFF = null;
        public final Integer high;
        public final Integer low;

        /* JADX INFO: renamed from: on, reason: collision with root package name */
        public final boolean f202128on;

        static {
            OFF = new ScalingSettings();
        }

        public String toString() {
            if (this.f202128on == true) goto L7;
            return "OFF";
        L7:
            return "[ " + this.low + ", " + this.high + " ]";
        }

        private ScalingSettings() {
            this.f202128on = false;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(boolean r100) {
            this.f202128on = r100;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(int r100, int r101) {
            this.f202128on = true;
            this.low = Integer.valueOf(r100);
            this.high = Integer.valueOf(r101);
        }

        public ScalingSettings(boolean r100, int r101, int r102) {
            this.f202128on = r100;
            this.low = Integer.valueOf(r101);
            this.high = Integer.valueOf(r102);
        }
    }

    public static class Settings {
        public final int bFrameNum;
        public final BitrateMode bitrateMode;
        public final boolean closeSetProfile;
        public final boolean enableAlignment;
        public final boolean enableAsyncMode;
        public final boolean enableColorSpaceSetting;
        public final boolean enableQpSetting;
        public final EncodeMode encodeMode;
        public final int height;
        public final boolean isStatisticsEnabled;
        public final int matrixId;
        public final int maxIQp;
        public final int maxQp;
        public final int minIQp;
        public final int minQp;
        public final int primaryId;
        public final int rangeId;
        public final ScaleMode scaleMode;
        public final EglBase14.Context sharedContext;
        public int targetBps;
        public final int targetFps;
        public final int targetKeyFrameIntervalMs;
        public final int temporalLayerNum;
        public final int transferId;
        public final boolean useSurfaceMode;
        public final int width;

        public Settings(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, boolean r117, int r118, int r119, int r210, boolean r211, boolean r212, boolean r213, int r214, int r215, EglBase.Context r216, boolean r217, boolean r218, boolean r219) {
            this.width = r100;
            this.height = r101;
            this.scaleMode = ScaleMode.fromValue(r102);
            this.targetBps = r103;
            this.targetFps = r104;
            this.primaryId = r105;
            this.transferId = r110;
            this.matrixId = r111;
            this.rangeId = r112;
            this.maxQp = r113;
            this.minQp = r114;
            this.temporalLayerNum = r118;
            this.bitrateMode = BitrateMode.fromValue(r119);
            this.targetKeyFrameIntervalMs = r210;
            this.closeSetProfile = r211;
            this.useSurfaceMode = r212;
            this.enableAlignment = r213;
            this.maxIQp = r115;
            this.minIQp = r116;
            this.bFrameNum = r215;
            this.enableQpSetting = r117;
            this.encodeMode = EncodeMode.fromValue(r214);
            if ((r216 instanceof EglBase14.Context) == false) goto L5;
            this.sharedContext = (EglBase14.Context) r216;
        L6:
            this.enableAsyncMode = r217;
            this.isStatisticsEnabled = r218;
            this.enableColorSpaceSetting = r219;
            return;
        L5:
            this.sharedContext = null;
            goto L6
        }
    }

    VideoCodecStatus encode(BmmtVideoFrameInterface r100, boolean r101);

    VideoCodecStatus initEncode(Settings r100, Callback r101);

    VideoCodecStatus release();

    VideoCodecStatus requestKeyFrame();

    VideoCodecStatus setPrivateParam(String r100, String r101);

    VideoCodecStatus setRateAllocation(int r100, int r101);
}
