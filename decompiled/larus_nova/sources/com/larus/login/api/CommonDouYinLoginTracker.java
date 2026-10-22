package com.larus.login.api;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class CommonDouYinLoginTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f356940a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/login/api/CommonDouYinLoginTracker$AuthResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "CANCEL", "GO_MARKET", "GO_ACCOUNT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AuthResult extends Enum<AuthResult> {
        public static final AuthResult CANCEL = null;
        public static final AuthResult FAIL = null;
        public static final AuthResult GO_ACCOUNT = null;
        public static final AuthResult GO_MARKET = null;
        public static final AuthResult SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AuthResult[] f356941a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f356942b = null;
        private final String value;

        public static EnumEntries<AuthResult> getEntries() {
            return f356942b;
        }

        static {
            AuthResult r100 = new AuthResult("SUCCESS", 0, "success");
            SUCCESS = r100;
            AuthResult r101 = new AuthResult("FAIL", 1, "fail");
            FAIL = r101;
            AuthResult r102 = new AuthResult("CANCEL", 2, "cancel");
            CANCEL = r102;
            AuthResult r103 = new AuthResult("GO_MARKET", 3, "go_market");
            GO_MARKET = r103;
            AuthResult r104 = new AuthResult("GO_ACCOUNT", 4, "go_account");
            GO_ACCOUNT = r104;
            AuthResult[] r105 = {r100, r101, r102, r103, r104};
            f356941a = r105;
            f356942b = EnumEntriesKt.enumEntries(r105);
        }

        public static AuthResult[] values() {
            return (AuthResult[]) f356941a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AuthResult valueOf(String r100) {
            return (AuthResult) r27.a.a(AuthResult.class, r100);
        }

        public AuthResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/login/api/CommonDouYinLoginTracker$ResultStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "USER_NOT_LOGIN", "LOCAL_TOKEN", "SERVER_TOKEN", "AUTH_GUIDE", "GO_MARKET", "INNER_WEB", "DOUYIN_AUTH", "BIND_TOKEN", "REFRESH_AFTER_BIND", "SWITCH_BIND", "CHANGE_BIND", "GO_ACCOUNT", "REFRESH_AFTER_SWITCH", "REFRESH_AFTER_CHANGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResultStage extends Enum<ResultStage> {
        public static final ResultStage AUTH_GUIDE = null;
        public static final ResultStage BIND_TOKEN = null;
        public static final ResultStage CHANGE_BIND = null;
        public static final ResultStage DOUYIN_AUTH = null;
        public static final ResultStage GO_ACCOUNT = null;
        public static final ResultStage GO_MARKET = null;
        public static final ResultStage INNER_WEB = null;
        public static final ResultStage LOCAL_TOKEN = null;
        public static final ResultStage REFRESH_AFTER_BIND = null;
        public static final ResultStage REFRESH_AFTER_CHANGE = null;
        public static final ResultStage REFRESH_AFTER_SWITCH = null;
        public static final ResultStage SERVER_TOKEN = null;
        public static final ResultStage SWITCH_BIND = null;
        public static final ResultStage UNKNOWN = null;
        public static final ResultStage USER_NOT_LOGIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultStage[] f356943a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f356944b = null;
        private final String value;

        public static EnumEntries<ResultStage> getEntries() {
            return f356944b;
        }

        static {
            ResultStage r100 = new ResultStage("UNKNOWN", 0, "unknown_stage");
            UNKNOWN = r100;
            ResultStage r101 = new ResultStage("USER_NOT_LOGIN", 1, "user_not_login");
            USER_NOT_LOGIN = r101;
            ResultStage r102 = new ResultStage("LOCAL_TOKEN", 2, "local_token");
            LOCAL_TOKEN = r102;
            ResultStage r103 = new ResultStage("SERVER_TOKEN", 3, "server_token");
            SERVER_TOKEN = r103;
            ResultStage r104 = new ResultStage("AUTH_GUIDE", 4, "auth_guide");
            AUTH_GUIDE = r104;
            ResultStage r105 = new ResultStage("GO_MARKET", 5, "go_market");
            GO_MARKET = r105;
            ResultStage r110 = new ResultStage("INNER_WEB", 6, "inner_web");
            INNER_WEB = r110;
            ResultStage r111 = new ResultStage("DOUYIN_AUTH", 7, "douyin_auth");
            DOUYIN_AUTH = r111;
            ResultStage r112 = new ResultStage("BIND_TOKEN", 8, "bind_token");
            BIND_TOKEN = r112;
            ResultStage r113 = new ResultStage("REFRESH_AFTER_BIND", 9, "refresh_after_bind");
            REFRESH_AFTER_BIND = r113;
            ResultStage r114 = new ResultStage("SWITCH_BIND", 10, "switch_bind");
            SWITCH_BIND = r114;
            ResultStage r106 = new ResultStage("CHANGE_BIND", 11, "change_bind");
            CHANGE_BIND = r106;
            ResultStage r107 = new ResultStage("GO_ACCOUNT", 12, "go_account");
            GO_ACCOUNT = r107;
            ResultStage r108 = new ResultStage("REFRESH_AFTER_SWITCH", 13, "refresh_after_switch");
            REFRESH_AFTER_SWITCH = r108;
            ResultStage r109 = new ResultStage("REFRESH_AFTER_CHANGE", 14, "refresh_after_change");
            REFRESH_AFTER_CHANGE = r109;
            ResultStage[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109};
            f356943a = r115;
            f356944b = EnumEntriesKt.enumEntries(r115);
        }

        public static ResultStage[] values() {
            return (ResultStage[]) f356943a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ResultStage valueOf(String r100) {
            return (ResultStage) r27.a.a(ResultStage.class, r100);
        }

        public ResultStage(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }

    public static void a(JSONObject r100, Map r101) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L7;
        if (r100.has(r104) == true) goto L7;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        Result.m9449constructorimpl(r100.put(r104, r105));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "popUpType");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "extraParams");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        r106.put("current_page", r100);
        r106.put("source", r101);
        r106.put("type", r103);
        r106.put("pop_up_type", r102);
        a(r106, r104);
        Unit r107 = Unit.INSTANCE;
        r105.reportEvent("bind_douyin_popup_show", r106);
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "popUpType");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "clickFrom");
        Intrinsics.checkNotNullParameter(r110, "extraParams");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        r106.put("current_page", r100);
        r106.put("source", r101);
        r106.put("type", r103);
        r106.put("click_from", r104);
        r106.put("pop_up_type", r102);
        a(r106, r110);
        Unit r107 = Unit.INSTANCE;
        r105.reportEvent("bind_douyin_popup_click", r106);
    }
}
