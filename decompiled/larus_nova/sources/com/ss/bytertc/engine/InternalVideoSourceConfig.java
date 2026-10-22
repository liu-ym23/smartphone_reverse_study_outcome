package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class InternalVideoSourceConfig {
    private int source_category;
    private int source_type;

    public static final enum VideoContentCategory extends Enum<VideoContentCategory> {
        private static final /* synthetic */ VideoContentCategory[] $VALUES = null;
        public static final VideoContentCategory VIDEO_CONTENT_CATEGORY_CAMERA = null;
        public static final VideoContentCategory VIDEO_CONTENT_CATEGRORY_SCREEN = null;
        private int value;

        static {
            VideoContentCategory r100 = new VideoContentCategory("VIDEO_CONTENT_CATEGORY_CAMERA", 0, 0);
            VIDEO_CONTENT_CATEGORY_CAMERA = r100;
            VideoContentCategory r101 = new VideoContentCategory("VIDEO_CONTENT_CATEGRORY_SCREEN", 1, 1);
            VIDEO_CONTENT_CATEGRORY_SCREEN = r101;
            $VALUES = new VideoContentCategory[]{r100, r101};
        }

        public static VideoContentCategory[] values() {
            return (VideoContentCategory[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static VideoContentCategory valueOf(String r100) {
            return (VideoContentCategory) a.a(VideoContentCategory.class, r100);
        }

        private VideoContentCategory(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoSourceType extends Enum<VideoSourceType> {
        private static final /* synthetic */ VideoSourceType[] $VALUES = null;
        public static final VideoSourceType VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST = null;
        public static final VideoSourceType VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST = null;
        public static final VideoSourceType VIDEO_SOURCE_TYPE_EXTERNAL = null;
        public static final VideoSourceType VIDEO_SOURCE_TYPE_INTERNAL = null;
        private int value;

        static {
            VideoSourceType r100 = new VideoSourceType("VIDEO_SOURCE_TYPE_EXTERNAL", 0, 0);
            VIDEO_SOURCE_TYPE_EXTERNAL = r100;
            VideoSourceType r101 = new VideoSourceType("VIDEO_SOURCE_TYPE_INTERNAL", 1, 1);
            VIDEO_SOURCE_TYPE_INTERNAL = r101;
            VideoSourceType r102 = new VideoSourceType("VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST", 2, 2);
            VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST = r102;
            VideoSourceType r103 = new VideoSourceType("VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST", 3, 3);
            VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST = r103;
            $VALUES = new VideoSourceType[]{r100, r101, r102, r103};
        }

        public static VideoSourceType[] values() {
            return (VideoSourceType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static VideoSourceType valueOf(String r100) {
            return (VideoSourceType) a.a(VideoSourceType.class, r100);
        }

        private VideoSourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int getVideoSourceCategory() {
        return this.source_category;
    }

    public int getVideoSourceType() {
        return this.source_type;
    }

    public InternalVideoSourceConfig(VideoSourceType r100, VideoContentCategory r101) {
        this.source_type = r100.getValue();
        this.source_category = r101.getValue();
    }
}
