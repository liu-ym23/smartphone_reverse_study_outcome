package com.bytedance.dora.logEngine;

import android.text.TextUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.dora.api.model.FlowDoraWifiScene;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class KeyLogUtils {

    public static final enum DataFlowDirection extends Enum<DataFlowDirection> {
        public static final DataFlowDirection DOWNLINK = null;
        public static final DataFlowDirection INTERNAL = null;
        public static final DataFlowDirection UPLINK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataFlowDirection[] f204492a = null;
        private final String value;

        static {
            DataFlowDirection r100 = new DataFlowDirection("UPLINK", 0, "UPLINK");
            UPLINK = r100;
            DataFlowDirection r101 = new DataFlowDirection("DOWNLINK", 1, "DOWNLINK");
            DOWNLINK = r101;
            DataFlowDirection r102 = new DataFlowDirection("INTERNAL", 2, "INTERNAL");
            INTERNAL = r102;
            f204492a = new DataFlowDirection[]{r100, r101, r102};
        }

        public static DataFlowDirection[] values() {
            return (DataFlowDirection[]) f204492a.clone();
        }

        public String getValue() {
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

    public static final enum DataLink extends Enum<DataLink> {
        public static final DataLink AUDIO = null;
        public static final DataLink IMAGE = null;
        public static final DataLink OTA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataLink[] f204493a = null;
        private final String value;

        static {
            DataLink r100 = new DataLink("IMAGE", 0, "IMAGE");
            IMAGE = r100;
            DataLink r101 = new DataLink("AUDIO", 1, "AUDIO");
            AUDIO = r101;
            DataLink r102 = new DataLink(FlowDoraWifiScene.OTA, 2, FlowDoraWifiScene.OTA);
            OTA = r102;
            f204493a = new DataLink[]{r100, r101, r102};
        }

        public static DataLink[] values() {
            return (DataLink[]) f204493a.clone();
        }

        public String getValue() {
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

    public static final enum LogType extends Enum<LogType> {
        public static final LogType ERROR = null;
        public static final LogType FATAL = null;
        public static final LogType INFO = null;
        public static final LogType KEY = null;
        public static final LogType WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogType[] f204494a = null;
        private final String value;

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
            f204494a = new LogType[]{r100, r101, r102, r103, r104};
        }

        public static LogType[] values() {
            return (LogType[]) f204494a.clone();
        }

        public String getValue() {
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

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f204495a;

        public a() {
            this.f204495a = new JSONObject();
        }

        public final void a(String r100, int r101) {
            this.f204495a.put(r100, r101);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            j.b("KeyLogUtils", "JSONBuilder add field error, key: " + r100 + ", exception: " + e);
        }
    }

    public static void a(LogType r100, String r101, DataLink r102, String r103, DataFlowDirection r104, String r105, a r106, String r110) {
        String r107 = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        String r108 = r106.f204495a.toString();
        Object[] r109 = new Object[9];
        r109[0] = r107;
        r109[1] = r100.getValue();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "-";
    L5:
        r109[2] = r101;
        r109[3] = r102.getValue();
        if (TextUtils.isEmpty(r103) == false) goto L8;
        r103 = "-";
    L8:
        r109[4] = r103;
        r109[5] = r104.getValue();
        r109[6] = r105;
        r109[7] = r108;
        if (TextUtils.isEmpty(r110) == false) goto L11;
        r110 = "-";
    L11:
        r109[8] = r110;
        j.d("KeyLogUtils", String.format("[%s]|DS|%s|%s|%s|%s|%s|%s|%s|%s|", r109));
    }
}
