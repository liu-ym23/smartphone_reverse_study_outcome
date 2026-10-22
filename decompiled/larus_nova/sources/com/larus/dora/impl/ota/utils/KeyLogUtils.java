package com.larus.dora.impl.ota.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.dora.api.model.FlowDoraWifiScene;
import g49.d;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class KeyLogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f337794a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$DataFlowDirection;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UPLINK", "DOWNLINK", "INTERNAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DataFlowDirection extends Enum<DataFlowDirection> {
        public static final DataFlowDirection DOWNLINK = null;
        public static final DataFlowDirection INTERNAL = null;
        public static final DataFlowDirection UPLINK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataFlowDirection[] f337795a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f337796b = null;
        private final String value;

        public static EnumEntries<DataFlowDirection> getEntries() {
            return f337796b;
        }

        static {
            DataFlowDirection r100 = new DataFlowDirection("UPLINK", 0, "UPLINK");
            UPLINK = r100;
            DataFlowDirection r101 = new DataFlowDirection("DOWNLINK", 1, "DOWNLINK");
            DOWNLINK = r101;
            DataFlowDirection r102 = new DataFlowDirection("INTERNAL", 2, "INTERNAL");
            INTERNAL = r102;
            DataFlowDirection[] r103 = {r100, r101, r102};
            f337795a = r103;
            f337796b = EnumEntriesKt.enumEntries(r103);
        }

        public static DataFlowDirection[] values() {
            return (DataFlowDirection[]) f337795a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DataFlowDirection valueOf(String r100) {
            return (DataFlowDirection) r27.a.a(DataFlowDirection.class, r100);
        }

        public DataFlowDirection(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$DataLink;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE", "AUDIO", FlowDoraWifiScene.OTA, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DataLink extends Enum<DataLink> {
        public static final DataLink AUDIO = null;
        public static final DataLink IMAGE = null;
        public static final DataLink OTA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataLink[] f337797a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f337798b = null;
        private final String value;

        public static EnumEntries<DataLink> getEntries() {
            return f337798b;
        }

        static {
            DataLink r100 = new DataLink("IMAGE", 0, "IMAGE");
            IMAGE = r100;
            DataLink r101 = new DataLink("AUDIO", 1, "AUDIO");
            AUDIO = r101;
            DataLink r102 = new DataLink(FlowDoraWifiScene.OTA, 2, FlowDoraWifiScene.OTA);
            OTA = r102;
            DataLink[] r103 = {r100, r101, r102};
            f337797a = r103;
            f337798b = EnumEntriesKt.enumEntries(r103);
        }

        public static DataLink[] values() {
            return (DataLink[]) f337797a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DataLink valueOf(String r100) {
            return (DataLink) r27.a.a(DataLink.class, r100);
        }

        public DataLink(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$LogType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "KEY", "INFO", "WARN", "ERROR", SpeechEngineDefines.LOG_LEVEL_FATAL, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LogType extends Enum<LogType> {
        public static final LogType ERROR = null;
        public static final LogType FATAL = null;
        public static final LogType INFO = null;
        public static final LogType KEY = null;
        public static final LogType WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogType[] f337799a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f337800b = null;
        private final String value;

        public static EnumEntries<LogType> getEntries() {
            return f337800b;
        }

        static {
            LogType r100 = new LogType("KEY", 0, "KEY");
            KEY = r100;
            LogType r101 = new LogType("INFO", 1, "INFO");
            INFO = r101;
            LogType r102 = new LogType("WARN", 2, "WARN");
            WARN = r102;
            LogType r103 = new LogType("ERROR", 3, "ERROR");
            ERROR = r103;
            LogType r104 = new LogType(SpeechEngineDefines.LOG_LEVEL_FATAL, 4, SpeechEngineDefines.LOG_LEVEL_FATAL);
            FATAL = r104;
            LogType[] r105 = {r100, r101, r102, r103, r104};
            f337799a = r105;
            f337800b = EnumEntriesKt.enumEntries(r105);
        }

        public static LogType[] values() {
            return (LogType[]) f337799a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LogType valueOf(String r100) {
            return (LogType) r27.a.a(LogType.class, r100);
        }

        public LogType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f337801a;

        public a() {
            this.f337801a = new JSONObject();
        }

        public static void b(String r100, JSONException r101) {
            d.b("KeyLogUtils", "JSONBuilder add field error, key: " + r100 + ", exception: " + r101);
        }

        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            JSONObject r102 = this.f337801a;     // Catch: JSONException -> L8
            if (r101 != null) goto L6;
            r101 = "none";
        L6:
            r102.put(r100, r101);     // Catch: JSONException -> L8
            return;
        L8:
            e = move-exception;
            b(r100, e);
        }
    }

    static {
    }

    public static void a(LogType r100, DataLink r101, DataFlowDirection r102, String r103, a r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, "dataLink");
        Intrinsics.checkNotNullParameter(r102, "dataFlowDirection");
        String r106 = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        if (r104 == null) goto L8;
        JSONObject r107 = r104.f337801a;
        if (r107 == null) goto L8;
        String r108 = r107.toString();
        if (r108 == null) goto L8;
    L9:
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        Object[] r110 = new Object[9];
        r110[0] = r106;
        r110[1] = r100.getValue();
        TextUtils.isEmpty("-");
        r110[2] = "-";
        r110[3] = r101.getValue();
        TextUtils.isEmpty("-");
        r110[4] = "-";
        r110[5] = r102.getValue();
        r110[6] = r103;
        r110[7] = r108;
        if (TextUtils.isEmpty(r105) == false) goto L12;
        r105 = "-";
    L12:
        r110[8] = r105;
        d.d("KeyLogUtils", String.format("[%s]|DS|%s|%s|%s|%s|%s|%s|%s|%s|", Arrays.copyOf(r110, 9)));
        return;
    L8:
        r108 = SliceInitService.DEFAULT_SWITCH;
        goto L9
    }
}
