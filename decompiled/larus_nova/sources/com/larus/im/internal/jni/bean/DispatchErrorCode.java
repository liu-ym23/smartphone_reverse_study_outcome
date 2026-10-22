package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.j;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/im/internal/jni/bean/DispatchErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DISPATCH_ERROR_CODE_SUCCESS", "DISPATCH_ERROR_CODE_UNKNOWN", "DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION", "DISPATCH_ERROR_CODE_SANDBOX_UNREADY", "DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED", "DISPATCH_ERROR_CODE_GET_META_FAILED", "DISPATCH_ERROR_CODE_UNKNOWN_COMMAND", "DISPATCH_ERROR_CODE_NOT_ONLINE", "DISPATCH_ERROR_CODE_DISABLE_CONTROL", "DISPATCH_ERROR_CODE_NOT_AUTHORIZED", "DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE", "DISPATCH_ERROR_CODE_FILE_NOT_FOUND", "DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED", "DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE", "DISPATCH_ERROR_CODE_FILE_TOO_LARGE", "DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum DispatchErrorCode extends Enum<DispatchErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DispatchErrorCode[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("8")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_DISABLE_CONTROL = null;

    @SerialName("11")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_FILE_NOT_FOUND = null;

    @SerialName(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_FILE_TOO_LARGE = null;

    @SerialName("12")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED = null;

    @SerialName("5")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_GET_META_FAILED = null;

    @SerialName("100")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED = null;

    @SerialName("2")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_NOT_AUTHORIZED = null;

    @SerialName("7")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_NOT_ONLINE = null;

    @SerialName("3")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_SANDBOX_UNREADY = null;

    @SerialName("4")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED = null;

    @SerialName("0")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_SUCCESS = null;

    @SerialName("1")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_UNKNOWN = null;

    @SerialName("6")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_UNKNOWN_COMMAND = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE = null;

    @SerialName("13")
    public static final DispatchErrorCode DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/DispatchErrorCode$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/DispatchErrorCode;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) DispatchErrorCode.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<DispatchErrorCode> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final DispatchErrorCode findByValue(int r100) {
            if (r100 == 100) goto L22;
            switch(r100) {
                case 0: goto L38;
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                default: goto L5;
            };
        L5:
            d1.f348206b.b("enum", "DispatchErrorCode unknown value: " + r100);
            return DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS;
        L24:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_FILE_TOO_LARGE;
        L25:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE;
        L26:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED;
        L27:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_FILE_NOT_FOUND;
        L28:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE;
        L29:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_NOT_AUTHORIZED;
        L30:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_DISABLE_CONTROL;
        L31:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_NOT_ONLINE;
        L32:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_UNKNOWN_COMMAND;
        L33:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_GET_META_FAILED;
        L34:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED;
        L35:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_SANDBOX_UNREADY;
        L36:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION;
        L37:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_UNKNOWN;
        L38:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS;
        L22:
            return DispatchErrorCode.DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED;
        }
    }

    private static final /* synthetic */ DispatchErrorCode[] $values() {
        return new DispatchErrorCode[]{DISPATCH_ERROR_CODE_SUCCESS, DISPATCH_ERROR_CODE_UNKNOWN, DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION, DISPATCH_ERROR_CODE_SANDBOX_UNREADY, DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED, DISPATCH_ERROR_CODE_GET_META_FAILED, DISPATCH_ERROR_CODE_UNKNOWN_COMMAND, DISPATCH_ERROR_CODE_NOT_ONLINE, DISPATCH_ERROR_CODE_DISABLE_CONTROL, DISPATCH_ERROR_CODE_NOT_AUTHORIZED, DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE, DISPATCH_ERROR_CODE_FILE_NOT_FOUND, DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED, DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE, DISPATCH_ERROR_CODE_FILE_TOO_LARGE, DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final DispatchErrorCode findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<DispatchErrorCode> getEntries() {
        return $ENTRIES;
    }

    static {
        DISPATCH_ERROR_CODE_SUCCESS = new DispatchErrorCode("DISPATCH_ERROR_CODE_SUCCESS", 0, 0);
        DISPATCH_ERROR_CODE_UNKNOWN = new DispatchErrorCode("DISPATCH_ERROR_CODE_UNKNOWN", 1, 1);
        DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION = new DispatchErrorCode("DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION", 2, 2);
        DISPATCH_ERROR_CODE_SANDBOX_UNREADY = new DispatchErrorCode("DISPATCH_ERROR_CODE_SANDBOX_UNREADY", 3, 3);
        DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED = new DispatchErrorCode("DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED", 4, 4);
        DISPATCH_ERROR_CODE_GET_META_FAILED = new DispatchErrorCode("DISPATCH_ERROR_CODE_GET_META_FAILED", 5, 5);
        DISPATCH_ERROR_CODE_UNKNOWN_COMMAND = new DispatchErrorCode("DISPATCH_ERROR_CODE_UNKNOWN_COMMAND", 6, 6);
        DISPATCH_ERROR_CODE_NOT_ONLINE = new DispatchErrorCode("DISPATCH_ERROR_CODE_NOT_ONLINE", 7, 7);
        DISPATCH_ERROR_CODE_DISABLE_CONTROL = new DispatchErrorCode("DISPATCH_ERROR_CODE_DISABLE_CONTROL", 8, 8);
        DISPATCH_ERROR_CODE_NOT_AUTHORIZED = new DispatchErrorCode("DISPATCH_ERROR_CODE_NOT_AUTHORIZED", 9, 9);
        DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE = new DispatchErrorCode("DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE", 10, 10);
        DISPATCH_ERROR_CODE_FILE_NOT_FOUND = new DispatchErrorCode("DISPATCH_ERROR_CODE_FILE_NOT_FOUND", 11, 11);
        DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED = new DispatchErrorCode("DISPATCH_ERROR_CODE_FILE_UPLOAD_FAILED", 12, 12);
        DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE = new DispatchErrorCode("DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE", 13, 13);
        DISPATCH_ERROR_CODE_FILE_TOO_LARGE = new DispatchErrorCode("DISPATCH_ERROR_CODE_FILE_TOO_LARGE", 14, 14);
        DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED = new DispatchErrorCode("DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED", 15, 100);
        DispatchErrorCode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j());
    }

    public static DispatchErrorCode[] values() {
        return (DispatchErrorCode[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.DispatchErrorCode", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11", "12", "13", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "100"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static DispatchErrorCode valueOf(String r100) {
        return (DispatchErrorCode) a.a(DispatchErrorCode.class, r100);
    }

    private DispatchErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
