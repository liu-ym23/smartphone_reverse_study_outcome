package com.obric.sva.sdk.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/sva/sdk/base/Constant;", "", "<init>", "()V", "MAX_ENROLL_SENTENCE_SIZE", "", "NUM_CHANNELS", "BITS_PER_SAMPLE", "SAMPLE_RATE", "SAMPLE_SIZE_IN_ONE_SECOND", "DATA_READ_INTERVAL", "TIMEOUT_OF_PAGE_ENROLL", "", "TIMEOUT_OF_SENTENCE_ENROLL", "DEFAULT_TONE_VOLUME", "", "MIN_TIME_THRESHOLD_BEFORE_RESULT", "COUNT_DOWN_WHEN_FINISH_ENROLL", "COUNT_DOWN_WHEN_FINISH_ENROLL_TIME", "CHECK_RETRY", "ENROLL_RETRY", "MAX_BLUR_RADIUS", "MED_BLUR_RADIUS", "MIN_BLUR_RADIUS", "ENROLL_OK", "ENROLL_NOT_MATCH_NETWORK_CODE", "WAKEUP_LOG_OUTPUT_TERMINAL", "", "BREATH_WAKEUP_STATUS", "BREATH_DATA_UPLOAD_STATUS", "DOZE_ALWAYS_ON", "ASR_RESULT_ERROR_CODE_ASR_TASK", "ASR_RESULT_ERROR_CODE_ASR_SESSION", "ASR_RESULT_ERROR_CODE_ASR_NETWORK", "SUCCESS_AND_RESTART_RECOG", "SUCCESS_BUT_NOT_RESTART_RECOG", "FAILURE_AND_RESTART_RECOG", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Constant {
    public static final int ASR_RESULT_ERROR_CODE_ASR_NETWORK = 505;
    public static final int ASR_RESULT_ERROR_CODE_ASR_SESSION = 504;
    public static final int ASR_RESULT_ERROR_CODE_ASR_TASK = 500;
    public static final int BITS_PER_SAMPLE = 16;
    public static final String BREATH_DATA_UPLOAD_STATUS = "breath_data_upload_status";
    public static final String BREATH_WAKEUP_STATUS = "breath_wakeup_status";
    public static final int CHECK_RETRY = 1;
    public static final int COUNT_DOWN_WHEN_FINISH_ENROLL = 3;
    public static final long COUNT_DOWN_WHEN_FINISH_ENROLL_TIME = 3000;
    public static final int DATA_READ_INTERVAL = 120;
    public static final float DEFAULT_TONE_VOLUME = 1.0f;
    public static final String DOZE_ALWAYS_ON = "doze_always_on";
    public static final int ENROLL_NOT_MATCH_NETWORK_CODE = 100011;
    public static final int ENROLL_OK = 0;
    public static final int ENROLL_RETRY = 3;
    public static final int FAILURE_AND_RESTART_RECOG = -1;
    public static final Constant INSTANCE = null;
    public static final float MAX_BLUR_RADIUS = 50.0f;
    public static final int MAX_ENROLL_SENTENCE_SIZE = 5;
    public static final float MED_BLUR_RADIUS = 25.0f;
    public static final float MIN_BLUR_RADIUS = 0.001f;
    public static final long MIN_TIME_THRESHOLD_BEFORE_RESULT = 1500;
    public static final int NUM_CHANNELS = 1;
    public static final int SAMPLE_RATE = 16000;
    public static final int SAMPLE_SIZE_IN_ONE_SECOND = 32000;
    public static final int SUCCESS_AND_RESTART_RECOG = 0;
    public static final int SUCCESS_BUT_NOT_RESTART_RECOG = 1;
    public static final long TIMEOUT_OF_PAGE_ENROLL = 15000;
    public static final long TIMEOUT_OF_SENTENCE_ENROLL = 5000;
    public static final String WAKEUP_LOG_OUTPUT_TERMINAL = "wakeup_log_output_terminal";

    static {
        INSTANCE = new Constant();
    }

    private Constant() {
    }
}
