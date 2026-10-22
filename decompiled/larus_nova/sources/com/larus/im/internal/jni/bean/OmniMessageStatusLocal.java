package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.g9;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0087\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageStatusLocal;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MESSAGE_STATUS_LOCAL_ADD_LOCAL", "MESSAGE_STATUS_LOCAL_UNKNOWN", "MESSAGE_STATUS_LOCAL_UPLOADING", "MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS", "MESSAGE_STATUS_LOCAL_UPLOAD_FAILED", "MESSAGE_STATUS_LOCAL_SENDING", "MESSAGE_STATUS_LOCAL_SEND_SUCCESS", "MESSAGE_STATUS_LOCAL_SEND_FAILED", "MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED", "MESSAGE_STATUS_LOCAL_SEND_COMPLIANT", "MESSAGE_STATUS_LOCAL_RECEIVING", "MESSAGE_STATUS_LOCAL_RECEIVED", "MESSAGE_STATUS_LOCAL_RECEIVE_FAILED", "MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED", "MESSAGE_STATUS_LOCAL_RECEIVE_LOADING", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMessageStatusLocal extends Enum<OmniMessageStatusLocal> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMessageStatusLocal[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("0")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_ADD_LOCAL = null;

    @SerialName("21")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_RECEIVED = null;

    @SerialName("22")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_RECEIVE_FAILED = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR)
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED = null;

    @SerialName("24")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_RECEIVE_LOADING = null;

    @SerialName("20")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_RECEIVING = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_SENDING = null;

    @SerialName(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_SEND_COMPLIANT = null;

    @SerialName("12")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_SEND_FAILED = null;

    @SerialName("13")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED = null;

    @SerialName("11")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_SEND_SUCCESS = null;

    @SerialName("-1")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_UNKNOWN = null;

    @SerialName("1")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_UPLOADING = null;

    @SerialName("3")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_UPLOAD_FAILED = null;

    @SerialName("2")
    public static final OmniMessageStatusLocal MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageStatusLocal$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMessageStatusLocal;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMessageStatusLocal.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMessageStatusLocal> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMessageStatusLocal findByValue(int r100) {
            if (r100 == (-1)) goto L29;
            if (r100 == 0) goto L44;
            if (r100 == 1) goto L43;
            if (r100 == 2) goto L42;
            if (r100 == 3) goto L41;
            switch(r100) {
                case 10: goto L40;
                case 11: goto L39;
                case 12: goto L38;
                case 13: goto L37;
                case 14: goto L36;
                default: goto L12;
            };
        L12:
            switch(r100) {
                case 20: goto L35;
                case 21: goto L34;
                case 22: goto L33;
                case 23: goto L32;
                case 24: goto L31;
                default: goto L13;
            };
        L13:
            d1.f348206b.b("enum", "OmniMessageStatusLocal unknown value: " + r100);
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_ADD_LOCAL;
        L31:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_RECEIVE_LOADING;
        L32:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED;
        L33:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_RECEIVE_FAILED;
        L34:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_RECEIVED;
        L35:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_RECEIVING;
        L36:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SEND_COMPLIANT;
        L37:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED;
        L38:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SEND_FAILED;
        L39:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SEND_SUCCESS;
        L40:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SENDING;
        L41:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_UPLOAD_FAILED;
        L42:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS;
        L43:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_UPLOADING;
        L44:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_ADD_LOCAL;
        L29:
            return OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniMessageStatusLocal[] $values() {
        return new OmniMessageStatusLocal[]{MESSAGE_STATUS_LOCAL_ADD_LOCAL, MESSAGE_STATUS_LOCAL_UNKNOWN, MESSAGE_STATUS_LOCAL_UPLOADING, MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS, MESSAGE_STATUS_LOCAL_UPLOAD_FAILED, MESSAGE_STATUS_LOCAL_SENDING, MESSAGE_STATUS_LOCAL_SEND_SUCCESS, MESSAGE_STATUS_LOCAL_SEND_FAILED, MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED, MESSAGE_STATUS_LOCAL_SEND_COMPLIANT, MESSAGE_STATUS_LOCAL_RECEIVING, MESSAGE_STATUS_LOCAL_RECEIVED, MESSAGE_STATUS_LOCAL_RECEIVE_FAILED, MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED, MESSAGE_STATUS_LOCAL_RECEIVE_LOADING};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMessageStatusLocal findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMessageStatusLocal> getEntries() {
        return $ENTRIES;
    }

    static {
        MESSAGE_STATUS_LOCAL_ADD_LOCAL = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_ADD_LOCAL", 0, 0);
        MESSAGE_STATUS_LOCAL_UNKNOWN = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_UNKNOWN", 1, -1);
        MESSAGE_STATUS_LOCAL_UPLOADING = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_UPLOADING", 2, 1);
        MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_UPLOAD_SUCCESS", 3, 2);
        MESSAGE_STATUS_LOCAL_UPLOAD_FAILED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_UPLOAD_FAILED", 4, 3);
        MESSAGE_STATUS_LOCAL_SENDING = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_SENDING", 5, 10);
        MESSAGE_STATUS_LOCAL_SEND_SUCCESS = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_SEND_SUCCESS", 6, 11);
        MESSAGE_STATUS_LOCAL_SEND_FAILED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_SEND_FAILED", 7, 12);
        MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_SEND_INTERRUPTED", 8, 13);
        MESSAGE_STATUS_LOCAL_SEND_COMPLIANT = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_SEND_COMPLIANT", 9, 14);
        MESSAGE_STATUS_LOCAL_RECEIVING = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_RECEIVING", 10, 20);
        MESSAGE_STATUS_LOCAL_RECEIVED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_RECEIVED", 11, 21);
        MESSAGE_STATUS_LOCAL_RECEIVE_FAILED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_RECEIVE_FAILED", 12, 22);
        MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_RECEIVE_INTERRUPTED", 13, 23);
        MESSAGE_STATUS_LOCAL_RECEIVE_LOADING = new OmniMessageStatusLocal("MESSAGE_STATUS_LOCAL_RECEIVE_LOADING", 14, 24);
        OmniMessageStatusLocal[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new g9());
    }

    public static OmniMessageStatusLocal[] values() {
        return (OmniMessageStatusLocal[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMessageStatusLocal", values(), new String[]{"0", "-1", "1", "2", "3", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11", "12", "13", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "20", "21", "22", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "24"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMessageStatusLocal valueOf(String r100) {
        return (OmniMessageStatusLocal) a.a(OmniMessageStatusLocal.class, r100);
    }

    private OmniMessageStatusLocal(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
