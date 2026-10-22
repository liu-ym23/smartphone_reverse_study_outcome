package com.bytedance.pitaya.api.bean;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b7\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006;"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYErrorCode;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", ErrorCode.INIT, "PACKAGE_NOT_FOUND", "PACKAGE_NOT_READY", "PACKAGE_BREAK", "UNKNOWN", "UNSUPPORT_TASK_TYPE", "INVALID_INPUT", "INVALID_OUTPUT", "APP_VERSON", "OS_VERSON", "ENGINE_UNSUPPORT", "ENGINE_VERSION", "PY_VERSON", "PY_FOUNDATION_VERSION", "PY_BRIDGE_VERSION", "PY_BYTEAI_VERSION", "PY_LIBRARY_VERSION", "RESOURCE_VERSION", "MINPY_VERSION", "CEP_VERSION", "NO_MODEL", "NO_HANDLER", "NO_FOUNDATION", "NO_BRIDGE", "NO_BYTEAI", "NO_LIBRARY", "NO_ENGINE", "INVALID_DATA", "NETWORK_ERROR", "SERVER_ERROR", "FILE_ERROR", "MD5_ERROR", "UNZIP_ERROR", "PRIORITY_ERROR", "OFFLINE", "WIFI_ONLY", "TASK_INIT_ERROR", "TASK_LOAD_ERROR", "TASK_RUN_ERROR", "TASK_EXIT_ERROR", "TASK_WATCHDOG", "FEATURE_OPEN_ERROR", "FEATURE_UPGRADE_ERROR", "PITAYA_IMPL_NOT_READY", "SUB_MODULE_SO_ERROR", "SUB_MODULE_OTHER_ERROR", "ARTSOTER_IMPL_NOT_READY", "STORAGE_CLEAN", "ANDROID_CTX_NULL", "CEP_EXECUTE_ERROR", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PTYErrorCode extends Enum<PTYErrorCode> implements ReflectionCall {
    private static final /* synthetic */ PTYErrorCode[] $VALUES = null;
    public static final PTYErrorCode ANDROID_CTX_NULL = null;
    public static final PTYErrorCode APP_VERSON = null;
    public static final PTYErrorCode ARTSOTER_IMPL_NOT_READY = null;
    public static final PTYErrorCode CEP_EXECUTE_ERROR = null;
    public static final PTYErrorCode CEP_VERSION = null;
    public static final PTYErrorCode ENGINE_UNSUPPORT = null;
    public static final PTYErrorCode ENGINE_VERSION = null;
    public static final PTYErrorCode FEATURE_OPEN_ERROR = null;
    public static final PTYErrorCode FEATURE_UPGRADE_ERROR = null;
    public static final PTYErrorCode FILE_ERROR = null;
    public static final PTYErrorCode INIT = null;
    public static final PTYErrorCode INVALID_DATA = null;
    public static final PTYErrorCode INVALID_INPUT = null;
    public static final PTYErrorCode INVALID_OUTPUT = null;
    public static final PTYErrorCode MD5_ERROR = null;
    public static final PTYErrorCode MINPY_VERSION = null;
    public static final PTYErrorCode NETWORK_ERROR = null;
    public static final PTYErrorCode NO_BRIDGE = null;
    public static final PTYErrorCode NO_BYTEAI = null;
    public static final PTYErrorCode NO_ENGINE = null;
    public static final PTYErrorCode NO_FOUNDATION = null;
    public static final PTYErrorCode NO_HANDLER = null;
    public static final PTYErrorCode NO_LIBRARY = null;
    public static final PTYErrorCode NO_MODEL = null;
    public static final PTYErrorCode OFFLINE = null;
    public static final PTYErrorCode OS_VERSON = null;
    public static final PTYErrorCode PACKAGE_BREAK = null;
    public static final PTYErrorCode PACKAGE_NOT_FOUND = null;
    public static final PTYErrorCode PACKAGE_NOT_READY = null;
    public static final PTYErrorCode PITAYA_IMPL_NOT_READY = null;
    public static final PTYErrorCode PRIORITY_ERROR = null;
    public static final PTYErrorCode PY_BRIDGE_VERSION = null;
    public static final PTYErrorCode PY_BYTEAI_VERSION = null;
    public static final PTYErrorCode PY_FOUNDATION_VERSION = null;
    public static final PTYErrorCode PY_LIBRARY_VERSION = null;
    public static final PTYErrorCode PY_VERSON = null;
    public static final PTYErrorCode RESOURCE_VERSION = null;
    public static final PTYErrorCode SERVER_ERROR = null;
    public static final PTYErrorCode STORAGE_CLEAN = null;
    public static final PTYErrorCode SUB_MODULE_OTHER_ERROR = null;
    public static final PTYErrorCode SUB_MODULE_SO_ERROR = null;
    public static final PTYErrorCode SUCCESS = null;
    public static final PTYErrorCode TASK_EXIT_ERROR = null;
    public static final PTYErrorCode TASK_INIT_ERROR = null;
    public static final PTYErrorCode TASK_LOAD_ERROR = null;
    public static final PTYErrorCode TASK_RUN_ERROR = null;
    public static final PTYErrorCode TASK_WATCHDOG = null;
    public static final PTYErrorCode UNKNOWN = null;
    public static final PTYErrorCode UNSUPPORT_TASK_TYPE = null;
    public static final PTYErrorCode UNZIP_ERROR = null;
    public static final PTYErrorCode WIFI_ONLY = null;
    private final int code;

    private static final /* synthetic */ PTYErrorCode[] $values() {
        return new PTYErrorCode[]{SUCCESS, INIT, PACKAGE_NOT_FOUND, PACKAGE_NOT_READY, PACKAGE_BREAK, UNKNOWN, UNSUPPORT_TASK_TYPE, INVALID_INPUT, INVALID_OUTPUT, APP_VERSON, OS_VERSON, ENGINE_UNSUPPORT, ENGINE_VERSION, PY_VERSON, PY_FOUNDATION_VERSION, PY_BRIDGE_VERSION, PY_BYTEAI_VERSION, PY_LIBRARY_VERSION, RESOURCE_VERSION, MINPY_VERSION, CEP_VERSION, NO_MODEL, NO_HANDLER, NO_FOUNDATION, NO_BRIDGE, NO_BYTEAI, NO_LIBRARY, NO_ENGINE, INVALID_DATA, NETWORK_ERROR, SERVER_ERROR, FILE_ERROR, MD5_ERROR, UNZIP_ERROR, PRIORITY_ERROR, OFFLINE, WIFI_ONLY, TASK_INIT_ERROR, TASK_LOAD_ERROR, TASK_RUN_ERROR, TASK_EXIT_ERROR, TASK_WATCHDOG, FEATURE_OPEN_ERROR, FEATURE_UPGRADE_ERROR, PITAYA_IMPL_NOT_READY, SUB_MODULE_SO_ERROR, SUB_MODULE_OTHER_ERROR, ARTSOTER_IMPL_NOT_READY, STORAGE_CLEAN, ANDROID_CTX_NULL, CEP_EXECUTE_ERROR};
    }

    public static PTYErrorCode valueOf(String r100) {
        return (PTYErrorCode) r27.a.a(PTYErrorCode.class, r100);
    }

    public static PTYErrorCode[] values() {
        return (PTYErrorCode[]) $VALUES.clone();
    }

    static {
        SUCCESS = new PTYErrorCode("SUCCESS", 0, 0);
        INIT = new PTYErrorCode(ErrorCode.INIT, 1, 1);
        PACKAGE_NOT_FOUND = new PTYErrorCode("PACKAGE_NOT_FOUND", 2, 2);
        PACKAGE_NOT_READY = new PTYErrorCode("PACKAGE_NOT_READY", 3, 3);
        PACKAGE_BREAK = new PTYErrorCode("PACKAGE_BREAK", 4, 4);
        UNKNOWN = new PTYErrorCode("UNKNOWN", 5, 50);
        UNSUPPORT_TASK_TYPE = new PTYErrorCode("UNSUPPORT_TASK_TYPE", 6, 100);
        INVALID_INPUT = new PTYErrorCode("INVALID_INPUT", 7, 101);
        INVALID_OUTPUT = new PTYErrorCode("INVALID_OUTPUT", 8, 102);
        APP_VERSON = new PTYErrorCode("APP_VERSON", 9, 200);
        OS_VERSON = new PTYErrorCode("OS_VERSON", 10, 201);
        ENGINE_UNSUPPORT = new PTYErrorCode("ENGINE_UNSUPPORT", 11, 210);
        ENGINE_VERSION = new PTYErrorCode("ENGINE_VERSION", 12, 211);
        PY_VERSON = new PTYErrorCode("PY_VERSON", 13, 220);
        PY_FOUNDATION_VERSION = new PTYErrorCode("PY_FOUNDATION_VERSION", 14, 221);
        PY_BRIDGE_VERSION = new PTYErrorCode("PY_BRIDGE_VERSION", 15, 222);
        PY_BYTEAI_VERSION = new PTYErrorCode("PY_BYTEAI_VERSION", 16, 223);
        PY_LIBRARY_VERSION = new PTYErrorCode("PY_LIBRARY_VERSION", 17, 224);
        RESOURCE_VERSION = new PTYErrorCode("RESOURCE_VERSION", 18, 230);
        MINPY_VERSION = new PTYErrorCode("MINPY_VERSION", 19, 240);
        CEP_VERSION = new PTYErrorCode("CEP_VERSION", 20, 260);
        NO_MODEL = new PTYErrorCode("NO_MODEL", 21, 300);
        NO_HANDLER = new PTYErrorCode("NO_HANDLER", 22, 301);
        NO_FOUNDATION = new PTYErrorCode("NO_FOUNDATION", 23, 302);
        NO_BRIDGE = new PTYErrorCode("NO_BRIDGE", 24, 303);
        NO_BYTEAI = new PTYErrorCode("NO_BYTEAI", 25, 304);
        NO_LIBRARY = new PTYErrorCode("NO_LIBRARY", 26, 305);
        NO_ENGINE = new PTYErrorCode("NO_ENGINE", 27, 306);
        INVALID_DATA = new PTYErrorCode("INVALID_DATA", 28, 310);
        NETWORK_ERROR = new PTYErrorCode("NETWORK_ERROR", 29, 400);
        SERVER_ERROR = new PTYErrorCode("SERVER_ERROR", 30, 401);
        FILE_ERROR = new PTYErrorCode("FILE_ERROR", 31, 402);
        MD5_ERROR = new PTYErrorCode("MD5_ERROR", 32, 403);
        UNZIP_ERROR = new PTYErrorCode("UNZIP_ERROR", 33, 404);
        PRIORITY_ERROR = new PTYErrorCode("PRIORITY_ERROR", 34, 405);
        OFFLINE = new PTYErrorCode("OFFLINE", 35, 406);
        WIFI_ONLY = new PTYErrorCode("WIFI_ONLY", 36, 407);
        TASK_INIT_ERROR = new PTYErrorCode("TASK_INIT_ERROR", 37, 500);
        TASK_LOAD_ERROR = new PTYErrorCode("TASK_LOAD_ERROR", 38, 501);
        TASK_RUN_ERROR = new PTYErrorCode("TASK_RUN_ERROR", 39, 502);
        TASK_EXIT_ERROR = new PTYErrorCode("TASK_EXIT_ERROR", 40, 503);
        TASK_WATCHDOG = new PTYErrorCode("TASK_WATCHDOG", 41, 504);
        FEATURE_OPEN_ERROR = new PTYErrorCode("FEATURE_OPEN_ERROR", 42, 600);
        FEATURE_UPGRADE_ERROR = new PTYErrorCode("FEATURE_UPGRADE_ERROR", 43, 601);
        PITAYA_IMPL_NOT_READY = new PTYErrorCode("PITAYA_IMPL_NOT_READY", 44, 700);
        SUB_MODULE_SO_ERROR = new PTYErrorCode("SUB_MODULE_SO_ERROR", 45, 701);
        SUB_MODULE_OTHER_ERROR = new PTYErrorCode("SUB_MODULE_OTHER_ERROR", 46, 702);
        ARTSOTER_IMPL_NOT_READY = new PTYErrorCode("ARTSOTER_IMPL_NOT_READY", 47, 703);
        STORAGE_CLEAN = new PTYErrorCode("STORAGE_CLEAN", 48, 704);
        ANDROID_CTX_NULL = new PTYErrorCode("ANDROID_CTX_NULL", 49, 705);
        CEP_EXECUTE_ERROR = new PTYErrorCode("CEP_EXECUTE_ERROR", 50, 900);
        $VALUES = $values();
    }

    public final int getCode() {
        return this.code;
    }

    private PTYErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
