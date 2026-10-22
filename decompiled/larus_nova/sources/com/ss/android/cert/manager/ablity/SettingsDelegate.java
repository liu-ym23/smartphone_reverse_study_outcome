package com.ss.android.cert.manager.ablity;

/* JADX INFO: loaded from: classes34.dex */
public interface SettingsDelegate {

    public interface SettingsKey {
        public static final String ASR_CONFIG = "byte_user_identity_asr_config";
        public static final String CAMERA_COLLECT_WB_DATA = "camera_collect_wb_data";
        public static final String CAMERA_DETECT_FIRST_FRAME_INTERVAL = "camera_detect_first_frame_interval";
        public static final String CAMERA_DISPLAY_FACTOR = "camera_display_factor";
        public static final String CAMERA_ERROR_DETECT_ENABLED = "camera_error_detect_enabled";
        public static final String CAMERA_WB_GREEN_FULL_MODE = "camera_wb_green_full_mode";
        public static final String CAMERA_WB_REOPEN_CAMERA_ON_WB_CHANGE = "camera_wb_reopen_camera_on_wb_change";
        public static final String CAMERA_WB_RGB_CHANNEL_MAX_VALUE = "camera_wb_rgb_channel_max_value";
        public static final String CAMERA_WB_RGB_CHANNEL_MIN_VALUE = "camera_wb_rgb_channel_min_value";
        public static final String ENABLE_FACE_DETECTION_STEPS = "enable_face_detection_steps";
        public static final String FORCE_CAMERA_V1 = "upgrade_camera_to_v1";
        public static final String FRAME_DETECT_CONFIG = "frame_detect_config";
        public static final String GL_ERROR_DETECT_ENABLED = "gl_error_detect_enabled";
        public static final String USE_MI_SEC_CAMERA = "use_mi_sec_camera";
        public static final String VIDEO_RECORD_OPT_ON_STOP = "video_record_opt_on_stop";
        public static final String VIDEO_RECORD_PARAMS_BITRATE_FACTOR = "video_record_params_bitrate_factor";
        public static final String VIDEO_RECORD_PARAMS_FRAME_INTERVAL = "video_record_params_frame_interval";
        public static final String VIDEO_RECORD_PARAMS_MOOV_PREFIX = "video_record_params_moov_prefix";
    }

    Object getSetting(String r100);
}
