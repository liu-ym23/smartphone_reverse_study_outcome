package com.ss.android.lark.chameleon.container.webcontainer.report;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.api.PreloadPolicy;
import com.ss.android.lark.chameleon.util.UUIDUtil;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker;", "", "()V", "sessionTrackers", "", "", "Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$SessionTracker;", "getSessionTracker", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "newSessionTracker", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "releaseTracker", "", "Event", "EventType", "OpenResult", "OpenResultCode", "ParamKey", "SessionTracker", "Stage", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonOpenTracker {
    public static final ChameleonOpenTracker INSTANCE = null;
    private static final Map<String, SessionTracker> sessionTrackers = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$Event;", "", "()V", "CHAMELEON_COMMON_ERROR_DEV", "", "Chameleon_OPEN_FINISH_DEV", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Event {
        public static final String CHAMELEON_COMMON_ERROR_DEV = "webapp_common_error_dev";
        public static final String Chameleon_OPEN_FINISH_DEV = "webapp_open_finish_dev";
        public static final Event INSTANCE = null;

        static {
            INSTANCE = new Event();
        }

        private Event() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$EventType;", "", "()V", EventType.PULL_DATA_END, "", EventType.PULL_DATA_START, EventType.RENDER_END, EventType.RENDER_START, EventType.RES_READY, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EventType {
        public static final EventType INSTANCE = null;
        public static final String PULL_DATA_END = "PULL_DATA_END";
        public static final String PULL_DATA_START = "PULL_DATA_START";
        public static final String RENDER_END = "RENDER_END";
        public static final String RENDER_START = "RENDER_START";
        public static final String RES_READY = "RES_READY";

        static {
            INSTANCE = new EventType();
        }

        private EventType() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$OpenResult;", "", "()V", "CANCEL", "", "FAILED", "SUCCESS", "TIMEOUT", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OpenResult {
        public static final String CANCEL = "cancel";
        public static final String FAILED = "failed";
        public static final OpenResult INSTANCE = null;
        public static final String SUCCESS = "success";
        public static final String TIMEOUT = "timeout";

        static {
            INSTANCE = new OpenResult();
        }

        private OpenResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$OpenResultCode;", "", "()V", "CANCEL", "", "ERROR_PRELOAD", "ERROR_RENDER_GONE", "FRONT_ERROR", "SUCCESS", "TIMEOUT", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OpenResultCode {
        public static final int CANCEL = -3;
        public static final int ERROR_PRELOAD = 200;
        public static final int ERROR_RENDER_GONE = 100;
        public static final int FRONT_ERROR = 10000;
        public static final OpenResultCode INSTANCE = null;
        public static final int SUCCESS = 0;
        public static final int TIMEOUT = -2;

        static {
            INSTANCE = new OpenResultCode();
        }

        private OpenResultCode() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$ParamKey;", "", "()V", "APP_ID", "", "APP_NAME", "CODE", "COST", "ERRORMSG", "ERROR_TYPE", "FROM", "IS_TT_WEBVIEW", "LOAD_TYPE", "PRELOAD_TYPE", "RESULT", "RES_VERSION", "TT_WEBVIEW_VERSION", "URL", "URL_TYPE", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParamKey {
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String CODE = "code";
        public static final String COST = "cost";
        public static final String ERRORMSG = "errorMsg";
        public static final String ERROR_TYPE = "error_type";
        public static final String FROM = "from";
        public static final ParamKey INSTANCE = null;
        public static final String IS_TT_WEBVIEW = "is_tt_webview";
        public static final String LOAD_TYPE = "load_type";
        public static final String PRELOAD_TYPE = "preload_type";
        public static final String RESULT = "result";
        public static final String RES_VERSION = "res_version";
        public static final String TT_WEBVIEW_VERSION = "tt_webview_version";
        public static final String URL = "url";
        public static final String URL_TYPE = "url_type";

        static {
            INSTANCE = new ParamKey();
        }

        private ParamKey() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0001J\u001e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0007J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$SessionTracker;", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "start", "", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;J)V", "extraParams", "", "getExtraParams", "()Ljava/util/Map;", "isFinish", "", "stageMap", "Lkotlin/Pair;", "openFinish", "", "result", "code", "", "timeMills", "recordParam", "key", "value", "reportCommonError", "msg", "errorType", "stageEnd", "stage", "stageStart", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SessionTracker {
        private final ChameleonConfig chameleonConfig;
        private final Map<String, Object> extraParams;
        private boolean isFinish;
        private final String session;
        private final Map<String, Pair<Long, Long>> stageMap;
        private final long start;

        public final Map<String, Object> getExtraParams() {
            return this.extraParams;
        }

        public final void recordParam(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.extraParams.put(r100, r101);
        }

        public final void stageEnd(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            Pair<Long, Long> r102 = this.stageMap.get(r100);
            if (r102 == null) goto L6;
            this.stageMap.put(r100, new Pair(r102.getFirst(), Long.valueOf(r101)));
            return;
        }

        public final void stageStart(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            this.stageMap.put(r100, new Pair(Long.valueOf(r101), 0L));
        }

        public SessionTracker(String r100, ChameleonConfig r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
            this.session = r100;
            this.chameleonConfig = r101;
            this.start = r102;
            this.stageMap = new LinkedHashMap();
            this.extraParams = new LinkedHashMap();
        }

        public final void openFinish(String r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (this.isFinish == false) goto L5;
            return;
        L5:
            this.isFinish = true;
            JSONObject r103 = new JSONObject();
            r103.put("result", r100);
            r103.put("code", r101);
            r103.put("app_id", this.chameleonConfig.getAppID());
            r103.put("app_name", this.chameleonConfig.getBizName());
            PreloadConfig r104 = this.chameleonConfig.getPreloadConfig();
            if (r104 == null) goto L9;
            PreloadPolicy r105 = r104.getPolicy();
            if (r105 == null) goto L9;
        L10:
            r103.put(ParamKey.PRELOAD_TYPE, r105);
            r103.put(ParamKey.COST, r102 - this.start);
            Iterator<T> r106 = this.stageMap.entrySet().iterator();
        L12:
            if (r106.hasNext() == false) goto L18;
            Map.Entry r107 = (Map.Entry) r106.next();
            if (((Number) ((Pair) r107.getValue()).getFirst()).longValue() <= 0) goto L12;
            if (((Number) ((Pair) r107.getValue()).getSecond()).longValue() <= ((Number) ((Pair) r107.getValue()).getFirst()).longValue()) goto L12;
            r103.put(((String) r107.getKey()) + "_stage_start", ((Number) ((Pair) r107.getValue()).getFirst()).longValue() - this.start);
            r103.put(((String) r107.getKey()) + "_stage_cost", ((Number) ((Pair) r107.getValue()).getSecond()).longValue() - ((Number) ((Pair) r107.getValue()).getFirst()).longValue());
            goto L12
        L18:
            Iterator<Map.Entry<String, Object>> r108 = this.extraParams.entrySet().iterator();
        L20:
            if (r108.hasNext() == false) goto L22;
            Map.Entry<String, Object> r109 = r108.next();
            r103.put(r109.getKey(), r109.getValue());
            goto L20
        L22:
            ChameleonReport.INSTANCE.trackEventExt(Event.Chameleon_OPEN_FINISH_DEV, r103);
            return;
        L9:
            r105 = PreloadPolicy.NO_PRELOAD;
            goto L10
        }

        public final void reportCommonError(int r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            JSONObject r103 = new JSONObject();
            r103.put("code", r100);
            r103.put("app_id", this.chameleonConfig.getAppID());
            r103.put("app_name", this.chameleonConfig.getBizName());
            r103.put("errorMsg", r101);
            r103.put("error_type", r102);
            ChameleonReport.INSTANCE.trackEventExt(Event.CHAMELEON_COMMON_ERROR_DEV, r103);
        }

        public /* synthetic */ SessionTracker(String r100, ChameleonConfig r101, long r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = System.currentTimeMillis();
        L5:
            this(r100, r101, r102);
        }

        public static /* synthetic */ void stageEnd$default(SessionTracker r100, String r101, long r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L5;
            r102 = System.currentTimeMillis();
        L5:
            r100.stageEnd(r101, r102);
        }

        public static /* synthetic */ void stageStart$default(SessionTracker r100, String r101, long r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L5;
            r102 = System.currentTimeMillis();
        L5:
            r100.stageStart(r101, r102);
        }

        public static /* synthetic */ void openFinish$default(SessionTracker r100, String r101, int r102, long r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L5;
            r103 = System.currentTimeMillis();
        L5:
            r100.openFinish(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$Stage;", "", "()V", "PRELOAD", "", "PULLDATA", "RENDER", "UNZIP", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Stage {
        public static final Stage INSTANCE = null;
        public static final String PRELOAD = "preload";
        public static final String PULLDATA = "pulldata";
        public static final String RENDER = "render";
        public static final String UNZIP = "unzip";

        static {
            INSTANCE = new Stage();
        }

        private Stage() {
        }
    }

    private ChameleonOpenTracker() {
    }

    static {
        INSTANCE = new ChameleonOpenTracker();
        sessionTrackers = new LinkedHashMap();
    }

    public final SessionTracker getSessionTracker(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return sessionTrackers.get(r100);
    }

    public final String newSessionTracker(ChameleonConfig r110) {
        Intrinsics.checkNotNullParameter(r110, "chameleonConfig");
        String r100 = UUIDUtil.randomUUID().toString();
        sessionTrackers.put(r100, new SessionTracker(r100, r110, 0, 4, null));
        return r100;
    }

    public final void releaseTracker(String r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        sessionTrackers.remove(r100);
    }
}
