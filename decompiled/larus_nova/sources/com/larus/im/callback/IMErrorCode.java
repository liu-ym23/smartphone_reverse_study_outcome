package com.larus.im.callback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/callback/IMErrorCode;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface IMErrorCode {
    public static final a Companion = null;
    public static final int ERROR_CODE_CONVERSATION_DISSOLVED = 712013003;
    public static final int ERROR_CODE_DEFAULT = -1;
    public static final int ERROR_CODE_DELETE_MESSAGE_FAIL = -13;
    public static final int ERROR_CODE_DOWNGRADED = -555;
    public static final int ERROR_CODE_DUPLICATE_REQUEST = -104;
    public static final int ERROR_CODE_INVALID_CMD_CONTENT = -18;
    public static final int ERROR_CODE_INVALID_CONVERSATION_ID = -17;
    public static final int ERROR_CODE_INVALID_LOCAL_MESSAGE_ID = -12;
    public static final int ERROR_CODE_INVALID_LOCAL_MESSAGE_INDEX = -11;
    public static final int ERROR_CODE_INVALID_MESSAGE_ID = -16;
    public static final int ERROR_CODE_INVALID_PARTICIPANT_ID = -19;
    public static final int ERROR_CODE_INVALID_REQUEST = -2;
    public static final int ERROR_CODE_IN_BLACK_LIST = 712013109;
    public static final int ERROR_CODE_NOT_INIT = -101;
    public static final int ERROR_CODE_REGEN_TIMES_LIMIT = -15;
    public static final int ERROR_CODE_REVIEW_SETUP_FAILED = 712014004;
    public static final int ERROR_CODE_USER_CHANGE = -100;
    public static final int ERROR_CODE_USER_NOT_IN_CONV = 712013104;
    public static final int ERROR_INVALID_MESSAGE_LOCAL_STATUS = -14;
    public static final int ERROR_JSON_PARSE_ERROR = -103;
    public static final int ERROR_PROCESSOR_EXCEPTION = -3;
    public static final int ERROR_TTNET_ERROR = -110;
    public static final int ERROR_UNKNOWN_ERROR = -1001;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f347129a = null;

        static {
            f347129a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f347129a;
    }
}
