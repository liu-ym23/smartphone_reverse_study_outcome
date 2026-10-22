package com.larus.bmhome.chat.bean;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/bean/ProcessFileResultCode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "PREPARE_FILE_NOT_FOUND", "PREPARE_OVER_STORAGE_FREE_SPACE", "PREPARE_COMPRESSED_SUCCESS", "PREPARE_ORIGINAL_RES_CLONE_SUCCESS", "PREPARE_GIF_PROCESS_SUCCESS", "PREPARE_CLONE_SUCCESS", "PREPARE_CLONE_FAILED", "PREPARE_OPEN_FILE_ERROR", "PREPARE_RES_NOT_FOUND", "PREPARE_TYPE_NO_MATCH", "PREPARE_GIF_PROCESS_FAILED", "PREPARE_OVER_SIZE", "PREPARE_OVER_DURATION", "PREPARE_OVER_META_LIMIT", "PROCESS_TRANSCODE_ERROR", "UPLOAD_GET_AUTH_TOKEN_ERROR", "UPLOAD_IMAGEX_ERROR", "UPLOAD_CANCELED_BY_USER", "UPLOAD_CANCELED_BY_LEAVE_CHAT", "UPLOAD_RESOURCE_REGISTER_ERROR", "UPLOAD_NO_NETWORK", "isSuccess", "", "getErrorType", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProcessFileResultCode extends Enum<ProcessFileResultCode> {
    public static final a Companion = null;
    public static final ProcessFileResultCode PREPARE_CLONE_FAILED = null;
    public static final ProcessFileResultCode PREPARE_CLONE_SUCCESS = null;
    public static final ProcessFileResultCode PREPARE_COMPRESSED_SUCCESS = null;
    public static final ProcessFileResultCode PREPARE_FILE_NOT_FOUND = null;
    public static final ProcessFileResultCode PREPARE_GIF_PROCESS_FAILED = null;
    public static final ProcessFileResultCode PREPARE_GIF_PROCESS_SUCCESS = null;
    public static final ProcessFileResultCode PREPARE_OPEN_FILE_ERROR = null;
    public static final ProcessFileResultCode PREPARE_ORIGINAL_RES_CLONE_SUCCESS = null;
    public static final ProcessFileResultCode PREPARE_OVER_DURATION = null;
    public static final ProcessFileResultCode PREPARE_OVER_META_LIMIT = null;
    public static final ProcessFileResultCode PREPARE_OVER_SIZE = null;
    public static final ProcessFileResultCode PREPARE_OVER_STORAGE_FREE_SPACE = null;
    public static final ProcessFileResultCode PREPARE_RES_NOT_FOUND = null;
    public static final ProcessFileResultCode PREPARE_TYPE_NO_MATCH = null;
    public static final ProcessFileResultCode PROCESS_TRANSCODE_ERROR = null;
    public static final ProcessFileResultCode SUCCESS = null;
    public static final ProcessFileResultCode UPLOAD_CANCELED_BY_LEAVE_CHAT = null;
    public static final ProcessFileResultCode UPLOAD_CANCELED_BY_USER = null;
    public static final ProcessFileResultCode UPLOAD_GET_AUTH_TOKEN_ERROR = null;
    public static final ProcessFileResultCode UPLOAD_IMAGEX_ERROR = null;
    public static final ProcessFileResultCode UPLOAD_NO_NETWORK = null;
    public static final ProcessFileResultCode UPLOAD_RESOURCE_REGISTER_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProcessFileResultCode[] f297421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297422b = null;
    private final String value;

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297423a = null;

        static {
            int[] r100 = new int[ProcessFileResultCode.values().length];
            r100[ProcessFileResultCode.PREPARE_CLONE_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r100[ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r100[ProcessFileResultCode.PREPARE_RES_NOT_FOUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r100[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[ProcessFileResultCode.PREPARE_GIF_PROCESS_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r100[ProcessFileResultCode.PREPARE_OVER_DURATION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r100[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[ProcessFileResultCode.PROCESS_TRANSCODE_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[ProcessFileResultCode.UPLOAD_GET_AUTH_TOKEN_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[ProcessFileResultCode.UPLOAD_NO_NETWORK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[ProcessFileResultCode.UPLOAD_IMAGEX_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r100[ProcessFileResultCode.UPLOAD_RESOURCE_REGISTER_ERROR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r100[ProcessFileResultCode.UPLOAD_CANCELED_BY_USER.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r100[ProcessFileResultCode.UPLOAD_CANCELED_BY_LEAVE_CHAT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            f297423a = r100;
        }
    }

    public static EnumEntries<ProcessFileResultCode> getEntries() {
        return f297422b;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.bmhome.chat.bean.ProcessFileResultCode$a] */
    static {
        ProcessFileResultCode r100 = new ProcessFileResultCode("SUCCESS", 0, "success");
        SUCCESS = r100;
        ProcessFileResultCode r101 = new ProcessFileResultCode("PREPARE_FILE_NOT_FOUND", 1, "prepare_file_not_found");
        PREPARE_FILE_NOT_FOUND = r101;
        ProcessFileResultCode r102 = new ProcessFileResultCode("PREPARE_OVER_STORAGE_FREE_SPACE", 2, "over_storage_free_space");
        PREPARE_OVER_STORAGE_FREE_SPACE = r102;
        ProcessFileResultCode r103 = new ProcessFileResultCode("PREPARE_COMPRESSED_SUCCESS", 3, "prepare_compressed_success");
        PREPARE_COMPRESSED_SUCCESS = r103;
        ProcessFileResultCode r104 = new ProcessFileResultCode("PREPARE_ORIGINAL_RES_CLONE_SUCCESS", 4, "prepare_original_res_clone_success");
        PREPARE_ORIGINAL_RES_CLONE_SUCCESS = r104;
        ProcessFileResultCode r105 = new ProcessFileResultCode("PREPARE_GIF_PROCESS_SUCCESS", 5, "prepare_gif_process_success");
        PREPARE_GIF_PROCESS_SUCCESS = r105;
        ProcessFileResultCode r110 = new ProcessFileResultCode("PREPARE_CLONE_SUCCESS", 6, "prepare_clone_success");
        PREPARE_CLONE_SUCCESS = r110;
        ProcessFileResultCode r111 = new ProcessFileResultCode("PREPARE_CLONE_FAILED", 7, "prepare_clone_error");
        PREPARE_CLONE_FAILED = r111;
        ProcessFileResultCode r112 = new ProcessFileResultCode("PREPARE_OPEN_FILE_ERROR", 8, "prepare_open_file_error");
        PREPARE_OPEN_FILE_ERROR = r112;
        ProcessFileResultCode r113 = new ProcessFileResultCode("PREPARE_RES_NOT_FOUND", 9, "prepare_res_not_found_error");
        PREPARE_RES_NOT_FOUND = r113;
        ProcessFileResultCode r106 = new ProcessFileResultCode("PREPARE_TYPE_NO_MATCH", 10, "prepare_type_no_match_error");
        PREPARE_TYPE_NO_MATCH = r106;
        ProcessFileResultCode r107 = new ProcessFileResultCode("PREPARE_GIF_PROCESS_FAILED", 11, "prepare_gif_process_error");
        PREPARE_GIF_PROCESS_FAILED = r107;
        ProcessFileResultCode r108 = new ProcessFileResultCode("PREPARE_OVER_SIZE", 12, "prepare_oversize_error");
        PREPARE_OVER_SIZE = r108;
        ProcessFileResultCode r109 = new ProcessFileResultCode("PREPARE_OVER_DURATION", 13, "prepare_overduration_error");
        PREPARE_OVER_DURATION = r109;
        ProcessFileResultCode r114 = new ProcessFileResultCode("PREPARE_OVER_META_LIMIT", 14, "prepare_over_meta_limit_error");
        PREPARE_OVER_META_LIMIT = r114;
        ProcessFileResultCode r115 = new ProcessFileResultCode("PROCESS_TRANSCODE_ERROR", 15, ResourceUploadError.VIDEO_TRANSCODE_ERROR);
        PROCESS_TRANSCODE_ERROR = r115;
        ProcessFileResultCode r116 = new ProcessFileResultCode("UPLOAD_GET_AUTH_TOKEN_ERROR", 16, ResourceUploadError.AUTH_TOKEN);
        UPLOAD_GET_AUTH_TOKEN_ERROR = r116;
        ProcessFileResultCode r117 = new ProcessFileResultCode("UPLOAD_IMAGEX_ERROR", 17, ResourceUploadError.UPLOAD_ERROR);
        UPLOAD_IMAGEX_ERROR = r117;
        ProcessFileResultCode r118 = new ProcessFileResultCode("UPLOAD_CANCELED_BY_USER", 18, "upload_canceled_by_user");
        UPLOAD_CANCELED_BY_USER = r118;
        ProcessFileResultCode r119 = new ProcessFileResultCode("UPLOAD_CANCELED_BY_LEAVE_CHAT", 19, "upload_canceled_by_leave_chat");
        UPLOAD_CANCELED_BY_LEAVE_CHAT = r119;
        ProcessFileResultCode r120 = new ProcessFileResultCode("UPLOAD_RESOURCE_REGISTER_ERROR", 20, ResourceUploadError.REGISTER_ERROR);
        UPLOAD_RESOURCE_REGISTER_ERROR = r120;
        ProcessFileResultCode r121 = new ProcessFileResultCode("UPLOAD_NO_NETWORK", 21, "no_network");
        UPLOAD_NO_NETWORK = r121;
        ProcessFileResultCode[] r122 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121};
        f297421a = r122;
        f297422b = EnumEntriesKt.enumEntries(r122);
        Companion = new a();
    }

    public static ProcessFileResultCode[] values() {
        return (ProcessFileResultCode[]) f297421a.clone();
    }

    public final String getErrorType() {
        switch(b.f297423a[ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L5;
            case 14: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "send_file_upload_cancel";
    L6:
        return "send_file_upload_fail";
    L7:
        return "send_file_process_fail";
    L8:
        return "send_file_preprocess_fail";
    }

    public final boolean isSuccess() {
        if (this != SUCCESS) goto L5;
    L14:
        return true;
    L5:
        if (this == PREPARE_COMPRESSED_SUCCESS) goto L14;
        if (this == PREPARE_ORIGINAL_RES_CLONE_SUCCESS) goto L14;
        if (this == PREPARE_GIF_PROCESS_SUCCESS) goto L14;
        if (this == PREPARE_CLONE_SUCCESS) goto L14;
        return false;
    }

    public final String getValue() {
        return this.value;
    }

    public static ProcessFileResultCode valueOf(String r100) {
        return (ProcessFileResultCode) r27.a.a(ProcessFileResultCode.class, r100);
    }

    public ProcessFileResultCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
