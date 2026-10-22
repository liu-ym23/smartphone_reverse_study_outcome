package com.obric.sva.sdk.listen;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public class ObricListenTypes {
    public static final int DEREGISTERED_EVENT = 7;
    public static final int DETECT_FAILED_EVENT = 6;
    public static final int DETECT_SUCCESS_EVENT = 5;
    public static final String DISABLE = "disable";
    public static final String ENABLE = "enable";
    public static final int EVENT_DATA_TYPE = 1;
    public static final int EVENT_DATA_TYPE_V2 = 2;
    public static final int KEYWORD_ONLY_DETECTION_MODE = 1;
    public static final int LISTEN_ENGINE_DIED_EVENT = 10;
    public static final String LISTEN_FEATURE = "ListenFeature";
    public static final int LISTEN_FEATURE_DISABLE_EVENT = 1;
    public static final int LISTEN_FEATURE_ENABLE_EVENT = 2;
    public static final int LISTEN_RUNNING_EVENT = 8;
    public static final int LISTEN_STOPPED_EVENT = 9;
    public static final int STATUS_EBAD_PARAM = -2;
    public static final int STATUS_EBUFFERING_DATA_INCOMPLETE = -10;
    public static final int STATUS_EBUFFERING_NOT_ENABLED = -8;
    public static final int STATUS_ECALLBACK_NOT_SET = -7;
    public static final int STATUS_ECANNOT_DELETE_LAST_KEYWORD = -24;
    public static final int STATUS_ECHOPPED_SAMPLE = -29;
    public static final int STATUS_ECLIPPED_SAMPLE = -30;
    public static final int STATUS_EDETECTION_NOT_RUNNING = -18;
    public static final int STATUS_EFAILURE = -1;
    public static final int STATUS_EFEATURE_NOT_ENABLED = -5;
    public static final int STATUS_EFUNCTION_NOT_IMPLEMENTED = -31;
    public static final int STATUS_EKEYWORD_NOT_IN_SOUNDMODEL = -11;
    public static final int STATUS_EKEYWORD_USER_PAIR_NOT_IN_SOUNDMODEL = -13;
    public static final int STATUS_EMAX_KEYWORDS_EXCEEDED = -22;
    public static final int STATUS_EMAX_USERS_EXCEEDED = -23;
    public static final int STATUS_ENOT_BUFFERING = -9;
    public static final int STATUS_ENOT_SUPPORTED_FOR_SOUNDMODEL_VERSION = -14;
    public static final int STATUS_ENO_MEMORY = -17;
    public static final int STATUS_ENO_SPEACH_IN_RECORDING = -25;
    public static final int STATUS_ERECORDING_TOO_LONG = -28;
    public static final int STATUS_ERECORDING_TOO_SHORT = -27;
    public static final int STATUS_ERESOURCE_NOT_AVAILABLE = -6;
    public static final int STATUS_ESOUNDMODELS_WITH_SAME_KEYWORD_CANNOT_BE_MERGED = -20;
    public static final int STATUS_ESOUNDMODELS_WITH_SAME_USER_KEYWORD_PAIR_CANNOT_BE_MERGED = -21;
    public static final int STATUS_ESOUNDMODEL_ALREADY_REGISTERED = -4;
    public static final int STATUS_ESOUNDMODEL_NOT_REGISTERED = -3;
    public static final int STATUS_ETOO_MUCH_NOISE_IN_RECORDING = -26;
    public static final int STATUS_EUNSUPPORTED_SOUNDMODEL = -15;
    public static final int STATUS_EUSER_KEYWORD_PAIRING_ALREADY_PRESENT = -19;
    public static final int STATUS_EUSER_NAME_CANNOT_BE_USED = -16;
    public static final int STATUS_EUSER_NOT_IN_SOUNDMODEL = -12;
    public static final int STATUS_SAMI_WAKEWORD_ERR = -32;
    public static final int STATUS_SUCCESS = 0;
    public static final int SVA_APP_TYPE = 1;
    public static final int USER_KEYWORD_DETECTION_MODE = 2;
    public static final String VOICEWAKEUP_FEATURE = "VoiceWakeupFeature";
    public static final int VOICEWAKEUP_FEATURE_DISABLE_EVENT = 3;
    public static final int VOICEWAKEUP_FEATURE_ENABLE_EVENT = 4;
    public static final String VWU_EVENT_0100 = "VoiceWakeup_DetectionData_v0100";
    public static final String VWU_EVENT_0200 = "VoiceWakeup_DetectionData_v0200";

    public static abstract class DetectionData {
        public int status;
        public String type;

        public DetectionData() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class KeywordInfo {
        public String[] activeUsers;
        public String keywordPhrase;

        public KeywordInfo() {
        }
    }

    public static class KeywordUserCounts {
        public short numKeywords;
        public short numUserKWPairs;
        public short numUsers;

        public KeywordUserCounts() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class SVASoundModelInfo extends SoundModelInfo {
        public KeywordUserCounts counts;
        public KeywordInfo[] keywordInfo;
        public String[] userNames;

        public SVASoundModelInfo() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class SoundModelInfo {
        public int size;
        public int type;
        public int version;

        public SoundModelInfo() {
        }
    }

    public static class SoundModelParams {
        public boolean bFailureNotification;
        public int detectionMode;
        public short minKeywordConfidence;
        public short minUserConfidence;
        public ByteBuffer soundModelData;

        public SoundModelParams() {
        }
    }

    public ObricListenTypes() {
    }
}
