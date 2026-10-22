package com.larus.trace.audioattachment;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b;\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bA¨\u0006B"}, d2 = {"Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Result;", "", "stage", "Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;", "code", "", "reason", "", "<init>", "(Ljava/lang/String;ILcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;ILjava/lang/String;)V", "getStage", "()Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;", "getCode", "()I", "getReason", "()Ljava/lang/String;", "SELECTED", "VALIDATED", "WITHOUT_DURATION", "EMPTY_URL", "EMPTY_DATA", "UNSUPPORTED_TYPE", "OVERSIZE", "OVER_DURATION", "COUNT_EXCEEDED", "INSUFFICIENT_STORAGE", "MIXED_TYPE", "VALIDATION_UNKNOWN", "CACHED", "REMOTE_CACHE_SKIPPED", "COPY_FAILED", "SOURCE_UNAVAILABLE", "CACHE_UNKNOWN", "UPLOAD_DISPATCHED", "UPLOADER_UNAVAILABLE", "UPLOAD_MODEL_FAILED", "INVALID_SOURCE", "DISPATCH_UNKNOWN", "FULL_UPLOAD", "FAST_UPLOAD", "ARTIFACT_CACHE", "DRIVE_REUSE", "HISTORY_REUSE", "PRECHECK_MISS", "PRECHECK_FALLBACK", "READY", "AUTH_FAILED", "NETWORK_UNAVAILABLE", "UPLOAD_FAILED", "TOKEN_EXHAUSTED", "REGISTER_FAILED", "UPLOAD_TIMEOUT", "USER_CANCELED", "LEAVE_CANCELED", "ARTIFACT_MISSING", "RESOURCE_UNKNOWN", "SEND_DISPATCHED", "SENT", "ENCODE_FAILED", "LOCAL_MESSAGE_MISSING", "IM_SDK_FAILED", "BUSINESS_REJECTED", "CONNECTION_UNAVAILABLE", "PAIRED_MESSAGE_FAILED", "SEND_TIMEOUT", "SEND_UNKNOWN", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioAttachmentUploadEvent$Result extends Enum<AudioAttachmentUploadEvent$Result> {
    public static final AudioAttachmentUploadEvent$Result ARTIFACT_CACHE = null;
    public static final AudioAttachmentUploadEvent$Result ARTIFACT_MISSING = null;
    public static final AudioAttachmentUploadEvent$Result AUTH_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result BUSINESS_REJECTED = null;
    public static final AudioAttachmentUploadEvent$Result CACHED = null;
    public static final AudioAttachmentUploadEvent$Result CACHE_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result CONNECTION_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result COPY_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result COUNT_EXCEEDED = null;
    public static final AudioAttachmentUploadEvent$Result DISPATCH_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result DRIVE_REUSE = null;
    public static final AudioAttachmentUploadEvent$Result EMPTY_DATA = null;
    public static final AudioAttachmentUploadEvent$Result EMPTY_URL = null;
    public static final AudioAttachmentUploadEvent$Result ENCODE_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result FAST_UPLOAD = null;
    public static final AudioAttachmentUploadEvent$Result FULL_UPLOAD = null;
    public static final AudioAttachmentUploadEvent$Result HISTORY_REUSE = null;
    public static final AudioAttachmentUploadEvent$Result IM_SDK_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result INSUFFICIENT_STORAGE = null;
    public static final AudioAttachmentUploadEvent$Result INVALID_SOURCE = null;
    public static final AudioAttachmentUploadEvent$Result LEAVE_CANCELED = null;
    public static final AudioAttachmentUploadEvent$Result LOCAL_MESSAGE_MISSING = null;
    public static final AudioAttachmentUploadEvent$Result MIXED_TYPE = null;
    public static final AudioAttachmentUploadEvent$Result NETWORK_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result OVERSIZE = null;
    public static final AudioAttachmentUploadEvent$Result OVER_DURATION = null;
    public static final AudioAttachmentUploadEvent$Result PAIRED_MESSAGE_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result PRECHECK_FALLBACK = null;
    public static final AudioAttachmentUploadEvent$Result PRECHECK_MISS = null;
    public static final AudioAttachmentUploadEvent$Result READY = null;
    public static final AudioAttachmentUploadEvent$Result REGISTER_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result REMOTE_CACHE_SKIPPED = null;
    public static final AudioAttachmentUploadEvent$Result RESOURCE_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result SELECTED = null;
    public static final AudioAttachmentUploadEvent$Result SEND_DISPATCHED = null;
    public static final AudioAttachmentUploadEvent$Result SEND_TIMEOUT = null;
    public static final AudioAttachmentUploadEvent$Result SEND_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result SENT = null;
    public static final AudioAttachmentUploadEvent$Result SOURCE_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result TOKEN_EXHAUSTED = null;
    public static final AudioAttachmentUploadEvent$Result UNSUPPORTED_TYPE = null;
    public static final AudioAttachmentUploadEvent$Result UPLOADER_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_DISPATCHED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_MODEL_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_TIMEOUT = null;
    public static final AudioAttachmentUploadEvent$Result USER_CANCELED = null;
    public static final AudioAttachmentUploadEvent$Result VALIDATED = null;
    public static final AudioAttachmentUploadEvent$Result VALIDATION_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result WITHOUT_DURATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioAttachmentUploadEvent$Result[] f370159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370160b = null;
    private final int code;
    private final String reason;
    private final AudioAttachmentUploadEvent$Stage stage;

    public static EnumEntries<AudioAttachmentUploadEvent$Result> getEntries() {
        return f370160b;
    }

    static {
        AudioAttachmentUploadEvent$Result r100 = new AudioAttachmentUploadEvent$Result("SELECTED", 0, AudioAttachmentUploadEvent$Stage.SELECTED, 0, "selected");
        SELECTED = r100;
        AudioAttachmentUploadEvent$Stage r101 = AudioAttachmentUploadEvent$Stage.VALIDATION;
        AudioAttachmentUploadEvent$Result r102 = new AudioAttachmentUploadEvent$Result("VALIDATED", 1, r101, 0, "validated");
        VALIDATED = r102;
        AudioAttachmentUploadEvent$Result r103 = new AudioAttachmentUploadEvent$Result("WITHOUT_DURATION", 2, r101, 0, "validated_without_duration");
        WITHOUT_DURATION = r103;
        AudioAttachmentUploadEvent$Result r104 = new AudioAttachmentUploadEvent$Result("EMPTY_URL", 3, r101, 1001, "empty_url");
        EMPTY_URL = r104;
        AudioAttachmentUploadEvent$Result r105 = new AudioAttachmentUploadEvent$Result("EMPTY_DATA", 4, r101, 1002, "empty_data");
        EMPTY_DATA = r105;
        AudioAttachmentUploadEvent$Result r106 = new AudioAttachmentUploadEvent$Result("UNSUPPORTED_TYPE", 5, r101, 1003, "unsupported_type");
        UNSUPPORTED_TYPE = r106;
        AudioAttachmentUploadEvent$Result r107 = new AudioAttachmentUploadEvent$Result("OVERSIZE", 6, r101, 1004, "oversize");
        OVERSIZE = r107;
        AudioAttachmentUploadEvent$Result r108 = new AudioAttachmentUploadEvent$Result("OVER_DURATION", 7, r101, 1005, "over_duration");
        OVER_DURATION = r108;
        AudioAttachmentUploadEvent$Result r109 = new AudioAttachmentUploadEvent$Result("COUNT_EXCEEDED", 8, r101, 1006, "count_exceeded");
        COUNT_EXCEEDED = r109;
        AudioAttachmentUploadEvent$Result r110 = new AudioAttachmentUploadEvent$Result("INSUFFICIENT_STORAGE", 9, r101, 1007, "insufficient_storage");
        INSUFFICIENT_STORAGE = r110;
        AudioAttachmentUploadEvent$Result r111 = new AudioAttachmentUploadEvent$Result("MIXED_TYPE", 10, r101, 1008, "mixed_type_rejected");
        MIXED_TYPE = r111;
        AudioAttachmentUploadEvent$Result r112 = new AudioAttachmentUploadEvent$Result("VALIDATION_UNKNOWN", 11, r101, 1099, "validation_unknown");
        VALIDATION_UNKNOWN = r112;
        AudioAttachmentUploadEvent$Stage r210 = AudioAttachmentUploadEvent$Stage.CACHE;
        AudioAttachmentUploadEvent$Result r113 = new AudioAttachmentUploadEvent$Result("CACHED", 12, r210, 0, "cached");
        CACHED = r113;
        AudioAttachmentUploadEvent$Result r114 = new AudioAttachmentUploadEvent$Result("REMOTE_CACHE_SKIPPED", 13, r210, 0, "skipped_remote_resource");
        REMOTE_CACHE_SKIPPED = r114;
        AudioAttachmentUploadEvent$Result r211 = new AudioAttachmentUploadEvent$Result("COPY_FAILED", 14, r210, 2001, "copy_file_failed");
        COPY_FAILED = r211;
        AudioAttachmentUploadEvent$Result r212 = new AudioAttachmentUploadEvent$Result("SOURCE_UNAVAILABLE", 15, r210, 2002, "source_unavailable");
        SOURCE_UNAVAILABLE = r212;
        AudioAttachmentUploadEvent$Result r213 = new AudioAttachmentUploadEvent$Result("CACHE_UNKNOWN", 16, r210, 2099, "cache_unknown");
        CACHE_UNKNOWN = r213;
        AudioAttachmentUploadEvent$Stage r115 = AudioAttachmentUploadEvent$Stage.UPLOAD;
        AudioAttachmentUploadEvent$Result r116 = new AudioAttachmentUploadEvent$Result("UPLOAD_DISPATCHED", 17, r115, 0, "dispatched");
        UPLOAD_DISPATCHED = r116;
        AudioAttachmentUploadEvent$Result r117 = new AudioAttachmentUploadEvent$Result("UPLOADER_UNAVAILABLE", 18, r115, 3001, "uploader_unavailable");
        UPLOADER_UNAVAILABLE = r117;
        AudioAttachmentUploadEvent$Result r118 = new AudioAttachmentUploadEvent$Result("UPLOAD_MODEL_FAILED", 19, r115, 3002, "upload_model_failed");
        UPLOAD_MODEL_FAILED = r118;
        AudioAttachmentUploadEvent$Result r119 = new AudioAttachmentUploadEvent$Result("INVALID_SOURCE", 20, r115, 3003, "invalid_upload_source");
        INVALID_SOURCE = r119;
        AudioAttachmentUploadEvent$Result r120 = new AudioAttachmentUploadEvent$Result("DISPATCH_UNKNOWN", 21, r115, SpeechEngineDefines.CODE_TTS_ERROR_UNKNOWN, "dispatch_unknown");
        DISPATCH_UNKNOWN = r120;
        AudioAttachmentUploadEvent$Stage r310 = AudioAttachmentUploadEvent$Stage.PATH;
        AudioAttachmentUploadEvent$Result r121 = new AudioAttachmentUploadEvent$Result("FULL_UPLOAD", 22, r310, 0, "full_upload");
        FULL_UPLOAD = r121;
        AudioAttachmentUploadEvent$Result r214 = new AudioAttachmentUploadEvent$Result("FAST_UPLOAD", 23, r310, 0, "fast_upload_hit");
        FAST_UPLOAD = r214;
        AudioAttachmentUploadEvent$Result r215 = new AudioAttachmentUploadEvent$Result("ARTIFACT_CACHE", 24, r310, 0, "artifact_cache_hit");
        ARTIFACT_CACHE = r215;
        AudioAttachmentUploadEvent$Result r216 = new AudioAttachmentUploadEvent$Result("DRIVE_REUSE", 25, r310, 0, "drive_resource_reused");
        DRIVE_REUSE = r216;
        AudioAttachmentUploadEvent$Result r311 = new AudioAttachmentUploadEvent$Result("HISTORY_REUSE", 26, r310, 0, "history_resource_reused");
        HISTORY_REUSE = r311;
        AudioAttachmentUploadEvent$Result r312 = new AudioAttachmentUploadEvent$Result("PRECHECK_MISS", 27, r310, 0, "precheck_miss");
        PRECHECK_MISS = r312;
        AudioAttachmentUploadEvent$Result r313 = new AudioAttachmentUploadEvent$Result("PRECHECK_FALLBACK", 28, r310, 0, "precheck_failed_fallback");
        PRECHECK_FALLBACK = r313;
        AudioAttachmentUploadEvent$Stage r410 = AudioAttachmentUploadEvent$Stage.READY;
        AudioAttachmentUploadEvent$Result r217 = new AudioAttachmentUploadEvent$Result("READY", 29, r410, 0, "ready");
        READY = r217;
        AudioAttachmentUploadEvent$Result r314 = new AudioAttachmentUploadEvent$Result("AUTH_FAILED", 30, r410, 4001, "auth_failed");
        AUTH_FAILED = r314;
        AudioAttachmentUploadEvent$Result r315 = new AudioAttachmentUploadEvent$Result("NETWORK_UNAVAILABLE", 31, r410, 4002, "network_unavailable");
        NETWORK_UNAVAILABLE = r315;
        AudioAttachmentUploadEvent$Result r316 = new AudioAttachmentUploadEvent$Result("UPLOAD_FAILED", 32, r410, 4003, "upload_failed");
        UPLOAD_FAILED = r316;
        AudioAttachmentUploadEvent$Result r317 = new AudioAttachmentUploadEvent$Result("TOKEN_EXHAUSTED", 33, r410, 4004, "token_expired_retry_exhausted");
        TOKEN_EXHAUSTED = r317;
        AudioAttachmentUploadEvent$Result r411 = new AudioAttachmentUploadEvent$Result("REGISTER_FAILED", 34, r410, 4005, "resource_register_failed");
        REGISTER_FAILED = r411;
        AudioAttachmentUploadEvent$Result r412 = new AudioAttachmentUploadEvent$Result("UPLOAD_TIMEOUT", 35, r410, 4006, "upload_timeout");
        UPLOAD_TIMEOUT = r412;
        AudioAttachmentUploadEvent$Result r413 = new AudioAttachmentUploadEvent$Result("USER_CANCELED", 36, r410, 4007, "canceled_by_user");
        USER_CANCELED = r413;
        AudioAttachmentUploadEvent$Result r414 = new AudioAttachmentUploadEvent$Result("LEAVE_CANCELED", 37, r410, 4008, "canceled_by_leave_chat");
        LEAVE_CANCELED = r414;
        AudioAttachmentUploadEvent$Result r415 = new AudioAttachmentUploadEvent$Result("ARTIFACT_MISSING", 38, r410, 4009, "artifact_missing");
        ARTIFACT_MISSING = r415;
        AudioAttachmentUploadEvent$Result r416 = new AudioAttachmentUploadEvent$Result("RESOURCE_UNKNOWN", 39, r410, 4099, "resource_unknown");
        RESOURCE_UNKNOWN = r416;
        AudioAttachmentUploadEvent$Result r218 = new AudioAttachmentUploadEvent$Result("SEND_DISPATCHED", 40, AudioAttachmentUploadEvent$Stage.SEND, 0, "dispatched");
        SEND_DISPATCHED = r218;
        AudioAttachmentUploadEvent$Stage r219 = AudioAttachmentUploadEvent$Stage.SENT;
        AudioAttachmentUploadEvent$Result r220 = new AudioAttachmentUploadEvent$Result("SENT", 41, r219, 0, "sent");
        SENT = r220;
        AudioAttachmentUploadEvent$Result r318 = new AudioAttachmentUploadEvent$Result("ENCODE_FAILED", 42, r219, 5001, "message_encode_failed");
        ENCODE_FAILED = r318;
        AudioAttachmentUploadEvent$Result r319 = new AudioAttachmentUploadEvent$Result("LOCAL_MESSAGE_MISSING", 43, r219, 5002, "local_message_missing");
        LOCAL_MESSAGE_MISSING = r319;
        AudioAttachmentUploadEvent$Result r320 = new AudioAttachmentUploadEvent$Result("IM_SDK_FAILED", 44, r219, 5003, "im_sdk_failed");
        IM_SDK_FAILED = r320;
        AudioAttachmentUploadEvent$Result r417 = new AudioAttachmentUploadEvent$Result("BUSINESS_REJECTED", 45, r219, ITTVideoEngineInternal.PLAYER_OPTION_EXO_CODEC_ASYNC_INIT_ENABLE, "business_rejected");
        BUSINESS_REJECTED = r417;
        AudioAttachmentUploadEvent$Result r510 = new AudioAttachmentUploadEvent$Result("CONNECTION_UNAVAILABLE", 46, r219, ITTVideoEngineInternal.PLAYER_OPTION_EXO_ALLOW_MEDIACODECHELPER, "connection_unavailable");
        CONNECTION_UNAVAILABLE = r510;
        AudioAttachmentUploadEvent$Result r511 = new AudioAttachmentUploadEvent$Result("PAIRED_MESSAGE_FAILED", 47, r219, 5006, "paired_message_failed");
        PAIRED_MESSAGE_FAILED = r511;
        AudioAttachmentUploadEvent$Result r512 = new AudioAttachmentUploadEvent$Result("SEND_TIMEOUT", 48, r219, 5007, "send_timeout");
        SEND_TIMEOUT = r512;
        AudioAttachmentUploadEvent$Result r513 = new AudioAttachmentUploadEvent$Result("SEND_UNKNOWN", 49, r219, 5099, "im_send_unknown");
        SEND_UNKNOWN = r513;
        AudioAttachmentUploadEvent$Result[] r122 = {r100, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r211, r212, r213, r116, r117, r118, r119, r120, r121, r214, r215, r216, r311, r312, r313, r217, r314, r315, r316, r317, r411, r412, r413, r414, r415, r416, r218, r220, r318, r319, r320, r417, r510, r511, r512, r513};
        f370159a = r122;
        f370160b = EnumEntriesKt.enumEntries(r122);
    }

    public static AudioAttachmentUploadEvent$Result[] values() {
        return (AudioAttachmentUploadEvent$Result[]) f370159a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getReason() {
        return this.reason;
    }

    public final AudioAttachmentUploadEvent$Stage getStage() {
        return this.stage;
    }

    public static AudioAttachmentUploadEvent$Result valueOf(String r100) {
        return (AudioAttachmentUploadEvent$Result) a.a(AudioAttachmentUploadEvent$Result.class, r100);
    }

    public AudioAttachmentUploadEvent$Result(String r100, int r101, AudioAttachmentUploadEvent$Stage r102, int r103, String r104) {
        super(r100, r101);
        this.stage = r102;
        this.code = r103;
        this.reason = r104;
    }
}
