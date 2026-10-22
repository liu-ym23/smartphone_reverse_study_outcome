package com.larus.im.internal.jni.bean;

import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.larus.im.internal.delegate.d1;
import de9.f;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/larus/im/internal/jni/bean/DispatchCommand;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DISPATCH_COMMAND_NOT_USED", "UNKNOWN_COMMAND", "DEVICE_ENABLE_CONTROL_REQUEST", "DEVICE_ENABLE_CONTROL_RESPONSE", "GET_META_REQUEST", "GET_META_RESPONSE", "COMPLETION_REQUEST", "COMPLETION_RESPONSE", "DEVICE_STATUS_CHANGE", "INTERACTION_ASK_HANDLE", "INTERACTION_REQUEST_ACTION_HANDLE", "INTERACTION_WARN_HANDLE", "INTERACTION_AUTHORIZE_FOLDER_HANDLE", "INTERACTION_ASK_V2", "INTERACTION_RESPONSE", "RTC_START_ROOM_REQUEST", "RTC_START_ROOM_RESPONSE", "GET_REMOTE_FILES_CONTENT_REQUEST", "GET_REMOTE_FILES_CONTENT_RESPONSE", "GET_WEBPAGE_REQUEST", "GET_WEBPAGE_RESPONSE", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum DispatchCommand extends Enum<DispatchCommand> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DispatchCommand[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("300")
    public static final DispatchCommand COMPLETION_REQUEST = null;

    @SerialName("301")
    public static final DispatchCommand COMPLETION_RESPONSE = null;
    public static final Companion Companion = null;

    @SerialName("100")
    public static final DispatchCommand DEVICE_ENABLE_CONTROL_REQUEST = null;

    @SerialName("101")
    public static final DispatchCommand DEVICE_ENABLE_CONTROL_RESPONSE = null;

    @SerialName("400")
    public static final DispatchCommand DEVICE_STATUS_CHANGE = null;

    @SerialName("0")
    public static final DispatchCommand DISPATCH_COMMAND_NOT_USED = null;

    @SerialName("200")
    public static final DispatchCommand GET_META_REQUEST = null;

    @SerialName("201")
    public static final DispatchCommand GET_META_RESPONSE = null;

    @SerialName("700")
    public static final DispatchCommand GET_REMOTE_FILES_CONTENT_REQUEST = null;

    @SerialName("701")
    public static final DispatchCommand GET_REMOTE_FILES_CONTENT_RESPONSE = null;

    @SerialName("10000")
    public static final DispatchCommand GET_WEBPAGE_REQUEST = null;

    @SerialName("10001")
    public static final DispatchCommand GET_WEBPAGE_RESPONSE = null;

    @SerialName("500")
    public static final DispatchCommand INTERACTION_ASK_HANDLE = null;

    @SerialName("504")
    public static final DispatchCommand INTERACTION_ASK_V2 = null;

    @SerialName("503")
    public static final DispatchCommand INTERACTION_AUTHORIZE_FOLDER_HANDLE = null;

    @SerialName("501")
    public static final DispatchCommand INTERACTION_REQUEST_ACTION_HANDLE = null;

    @SerialName("599")
    public static final DispatchCommand INTERACTION_RESPONSE = null;

    @SerialName("502")
    public static final DispatchCommand INTERACTION_WARN_HANDLE = null;

    @SerialName("600")
    public static final DispatchCommand RTC_START_ROOM_REQUEST = null;

    @SerialName("601")
    public static final DispatchCommand RTC_START_ROOM_RESPONSE = null;

    @SerialName("1")
    public static final DispatchCommand UNKNOWN_COMMAND = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/DispatchCommand$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/DispatchCommand;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) DispatchCommand.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<DispatchCommand> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final DispatchCommand findByValue(int r100) {
            if (r100 == 0) goto L51;
            if (r100 == 1) goto L72;
            if (r100 == 100) goto L71;
            if (r100 == 101) goto L70;
            if (r100 == 200) goto L69;
            if (r100 == 201) goto L68;
            if (r100 == 300) goto L67;
            if (r100 == 301) goto L66;
            if (r100 == 400) goto L65;
            if (r100 == 700) goto L64;
            if (r100 == 701) goto L63;
            if (r100 == 10000) goto L62;
            if (r100 == 10001) goto L61;
            switch(r100) {
                case 500: goto L60;
                case 501: goto L59;
                case 502: goto L58;
                case 503: goto L57;
                case 504: goto L56;
                default: goto L28;
            };
        L28:
            switch(r100) {
                case 599: goto L55;
                case 600: goto L54;
                case 601: goto L53;
                default: goto L29;
            };
        L29:
            d1.f348206b.b("enum", "DispatchCommand unknown value: " + r100);
            return DispatchCommand.DISPATCH_COMMAND_NOT_USED;
        L53:
            return DispatchCommand.RTC_START_ROOM_RESPONSE;
        L54:
            return DispatchCommand.RTC_START_ROOM_REQUEST;
        L55:
            return DispatchCommand.INTERACTION_RESPONSE;
        L56:
            return DispatchCommand.INTERACTION_ASK_V2;
        L57:
            return DispatchCommand.INTERACTION_AUTHORIZE_FOLDER_HANDLE;
        L58:
            return DispatchCommand.INTERACTION_WARN_HANDLE;
        L59:
            return DispatchCommand.INTERACTION_REQUEST_ACTION_HANDLE;
        L60:
            return DispatchCommand.INTERACTION_ASK_HANDLE;
        L61:
            return DispatchCommand.GET_WEBPAGE_RESPONSE;
        L62:
            return DispatchCommand.GET_WEBPAGE_REQUEST;
        L63:
            return DispatchCommand.GET_REMOTE_FILES_CONTENT_RESPONSE;
        L64:
            return DispatchCommand.GET_REMOTE_FILES_CONTENT_REQUEST;
        L65:
            return DispatchCommand.DEVICE_STATUS_CHANGE;
        L66:
            return DispatchCommand.COMPLETION_RESPONSE;
        L67:
            return DispatchCommand.COMPLETION_REQUEST;
        L68:
            return DispatchCommand.GET_META_RESPONSE;
        L69:
            return DispatchCommand.GET_META_REQUEST;
        L70:
            return DispatchCommand.DEVICE_ENABLE_CONTROL_RESPONSE;
        L71:
            return DispatchCommand.DEVICE_ENABLE_CONTROL_REQUEST;
        L72:
            return DispatchCommand.UNKNOWN_COMMAND;
        L51:
            return DispatchCommand.DISPATCH_COMMAND_NOT_USED;
        }
    }

    private static final /* synthetic */ DispatchCommand[] $values() {
        return new DispatchCommand[]{DISPATCH_COMMAND_NOT_USED, UNKNOWN_COMMAND, DEVICE_ENABLE_CONTROL_REQUEST, DEVICE_ENABLE_CONTROL_RESPONSE, GET_META_REQUEST, GET_META_RESPONSE, COMPLETION_REQUEST, COMPLETION_RESPONSE, DEVICE_STATUS_CHANGE, INTERACTION_ASK_HANDLE, INTERACTION_REQUEST_ACTION_HANDLE, INTERACTION_WARN_HANDLE, INTERACTION_AUTHORIZE_FOLDER_HANDLE, INTERACTION_ASK_V2, INTERACTION_RESPONSE, RTC_START_ROOM_REQUEST, RTC_START_ROOM_RESPONSE, GET_REMOTE_FILES_CONTENT_REQUEST, GET_REMOTE_FILES_CONTENT_RESPONSE, GET_WEBPAGE_REQUEST, GET_WEBPAGE_RESPONSE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final DispatchCommand findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<DispatchCommand> getEntries() {
        return $ENTRIES;
    }

    static {
        DISPATCH_COMMAND_NOT_USED = new DispatchCommand("DISPATCH_COMMAND_NOT_USED", 0, 0);
        UNKNOWN_COMMAND = new DispatchCommand("UNKNOWN_COMMAND", 1, 1);
        DEVICE_ENABLE_CONTROL_REQUEST = new DispatchCommand("DEVICE_ENABLE_CONTROL_REQUEST", 2, 100);
        DEVICE_ENABLE_CONTROL_RESPONSE = new DispatchCommand("DEVICE_ENABLE_CONTROL_RESPONSE", 3, 101);
        GET_META_REQUEST = new DispatchCommand("GET_META_REQUEST", 4, 200);
        GET_META_RESPONSE = new DispatchCommand("GET_META_RESPONSE", 5, 201);
        COMPLETION_REQUEST = new DispatchCommand("COMPLETION_REQUEST", 6, 300);
        COMPLETION_RESPONSE = new DispatchCommand("COMPLETION_RESPONSE", 7, 301);
        DEVICE_STATUS_CHANGE = new DispatchCommand("DEVICE_STATUS_CHANGE", 8, 400);
        INTERACTION_ASK_HANDLE = new DispatchCommand("INTERACTION_ASK_HANDLE", 9, 500);
        INTERACTION_REQUEST_ACTION_HANDLE = new DispatchCommand("INTERACTION_REQUEST_ACTION_HANDLE", 10, 501);
        INTERACTION_WARN_HANDLE = new DispatchCommand("INTERACTION_WARN_HANDLE", 11, 502);
        INTERACTION_AUTHORIZE_FOLDER_HANDLE = new DispatchCommand("INTERACTION_AUTHORIZE_FOLDER_HANDLE", 12, 503);
        INTERACTION_ASK_V2 = new DispatchCommand("INTERACTION_ASK_V2", 13, 504);
        INTERACTION_RESPONSE = new DispatchCommand("INTERACTION_RESPONSE", 14, FetchCardPlugin.SERVER_ERROR);
        RTC_START_ROOM_REQUEST = new DispatchCommand("RTC_START_ROOM_REQUEST", 15, 600);
        RTC_START_ROOM_RESPONSE = new DispatchCommand("RTC_START_ROOM_RESPONSE", 16, 601);
        GET_REMOTE_FILES_CONTENT_REQUEST = new DispatchCommand("GET_REMOTE_FILES_CONTENT_REQUEST", 17, 700);
        GET_REMOTE_FILES_CONTENT_RESPONSE = new DispatchCommand("GET_REMOTE_FILES_CONTENT_RESPONSE", 18, 701);
        GET_WEBPAGE_REQUEST = new DispatchCommand("GET_WEBPAGE_REQUEST", 19, 10000);
        GET_WEBPAGE_RESPONSE = new DispatchCommand("GET_WEBPAGE_RESPONSE", 20, 10001);
        DispatchCommand[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f());
    }

    public static DispatchCommand[] values() {
        return (DispatchCommand[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.DispatchCommand", values(), new String[]{"0", "1", "100", "101", "200", "201", "300", "301", "400", "500", "501", "502", "503", "504", "599", "600", "601", "700", "701", "10000", "10001"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static DispatchCommand valueOf(String r100) {
        return (DispatchCommand) a.a(DispatchCommand.class, r100);
    }

    private DispatchCommand(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
