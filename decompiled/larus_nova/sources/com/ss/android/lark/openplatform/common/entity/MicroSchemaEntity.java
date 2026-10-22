package com.ss.android.lark.openplatform.common.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/* JADX INFO: loaded from: classes37.dex */
public class MicroSchemaEntity {
    private static final String SCHEMA_VERSION = "v2";
    private static final String TAG = "MicroSchemaEntity";
    private String appId;
    private Map<String, Object> bdpLog;
    private Map<String, Object> customFields;
    private Host host;
    private Map<String, Object> inspect;
    private LaunchMode launchMode;
    private Map<String, Object> meta;
    private String path;
    private String protocol;
    private Map<String, Object> query;
    private Map<String, Object> refererInfo;
    private String scene;
    private String token;
    private VersionType versionType;

    public static final enum BdpsumCheckResult extends Enum<BdpsumCheckResult> {
        public static final BdpsumCheckResult ERROR = null;
        public static final BdpsumCheckResult NONE = null;
        public static final BdpsumCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpsumCheckResult[] f437586a = null;
        private String name;

        static {
            BdpsumCheckResult r100 = new BdpsumCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            BdpsumCheckResult r101 = new BdpsumCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            BdpsumCheckResult r102 = new BdpsumCheckResult("ERROR", 2, "error");
            ERROR = r102;
            f437586a = new BdpsumCheckResult[]{r100, r101, r102};
        }

        public static BdpsumCheckResult[] values() {
            return (BdpsumCheckResult[]) f437586a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static BdpsumCheckResult valueOf(String r100) {
            return (BdpsumCheckResult) r27.a.a(BdpsumCheckResult.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public BdpsumCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final class Builder {
        private String appId;
        private Map<String, Object> bdpLog;
        private Map<String, Object> customFields;
        private Host host;
        private Map<String, Object> inspect;
        private LaunchMode launchMode;
        private Map<String, Object> meta;
        private String path;
        private String protocol;
        private Map<String, Object> query;
        private Map<String, Object> refererInfo;
        private String scene;
        private String token;
        private VersionType versionType;

        public MicroSchemaEntity build() {
            return new MicroSchemaEntity(this, null);
        }

        public Builder() {
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.protocol;
        }

        public static /* synthetic */ Host access$100(Builder r100) {
            return r100.host;
        }

        public static /* synthetic */ Map access$1000(Builder r100) {
            return r100.customFields;
        }

        public static /* synthetic */ LaunchMode access$1100(Builder r100) {
            return r100.launchMode;
        }

        public static /* synthetic */ Map access$1200(Builder r100) {
            return r100.refererInfo;
        }

        public static /* synthetic */ Map access$1300(Builder r100) {
            return r100.inspect;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.appId;
        }

        public static /* synthetic */ VersionType access$300(Builder r100) {
            return r100.versionType;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.token;
        }

        public static /* synthetic */ Map access$500(Builder r100) {
            return r100.meta;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.scene;
        }

        public static /* synthetic */ String access$700(Builder r100) {
            return r100.path;
        }

        public static /* synthetic */ Map access$800(Builder r100) {
            return r100.query;
        }

        public static /* synthetic */ Map access$900(Builder r100) {
            return r100.bdpLog;
        }

        public Builder appId(String r100) {
            this.appId = r100;
            return this;
        }

        public Builder bdpLog(Map<String, Object> r100) {
            this.bdpLog = r100;
            return this;
        }

        public Builder customFields(Map<String, Object> r100) {
            this.customFields = r100;
            return this;
        }

        public Builder host(Host r100) {
            this.host = r100;
            return this;
        }

        public Builder inspect(Map<String, Object> r100) {
            this.inspect = r100;
            return this;
        }

        public Builder launchMode(LaunchMode r100) {
            this.launchMode = r100;
            return this;
        }

        public Builder meta(Map<String, Object> r100) {
            this.meta = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder protocol(String r100) {
            this.protocol = r100;
            return this;
        }

        public Builder query(Map<String, Object> r100) {
            this.query = r100;
            return this;
        }

        public Builder refererInfo(Map<String, Object> r100) {
            this.refererInfo = r100;
            return this;
        }

        public Builder scene(String r100) {
            this.scene = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder versionType(VersionType r100) {
            this.versionType = r100;
            return this;
        }
    }

    public static final enum Host extends Enum<Host> {
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Host[] f437587a = null;
        private String name;

        static {
            Host r100 = new Host("MICROAPP", 0, AppbrandHostConstants.Micro_Host.HOST_APPBRAND);
            MICROAPP = r100;
            Host r101 = new Host("MICROGAME", 1, AppbrandHostConstants.Micro_Host.HOST_GAME);
            MICROGAME = r101;
            f437587a = new Host[]{r100, r101};
        }

        public static Host[] values() {
            return (Host[]) f437587a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static /* synthetic */ String access$1400(Host r100) {
            return r100.name;
        }

        public static Host fromString(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            Host[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L11;
            Host r104 = r101[r103];
            if (r104.name.equalsIgnoreCase(r100) == true) goto L9;
            r103 = r103 + 1;
            goto L6
        L9:
            return r104;
        L11:
            return null;
        }

        public static Host valueOf(String r100) {
            return (Host) r27.a.a(Host.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public Host(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum LaunchFromCheckResult extends Enum<LaunchFromCheckResult> {
        public static final LaunchFromCheckResult BOTH = null;
        public static final LaunchFromCheckResult INNER = null;
        public static final LaunchFromCheckResult NEITHER = null;
        public static final LaunchFromCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchFromCheckResult[] f437588a = null;
        private String name;

        static {
            LaunchFromCheckResult r100 = new LaunchFromCheckResult("INNER", 0, RNParamRegisterEventHandler.SRC_INNER);
            INNER = r100;
            LaunchFromCheckResult r101 = new LaunchFromCheckResult("OUTER", 1, RNParamRegisterEventHandler.SRC_OUTER);
            OUTER = r101;
            LaunchFromCheckResult r102 = new LaunchFromCheckResult("BOTH", 2, "both");
            BOTH = r102;
            LaunchFromCheckResult r103 = new LaunchFromCheckResult("NEITHER", 3, "neither");
            NEITHER = r103;
            f437588a = new LaunchFromCheckResult[]{r100, r101, r102, r103};
        }

        public static LaunchFromCheckResult[] values() {
            return (LaunchFromCheckResult[]) f437588a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static LaunchFromCheckResult valueOf(String r100) {
            return (LaunchFromCheckResult) r27.a.a(LaunchFromCheckResult.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public LaunchFromCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final LaunchMode HOST_STACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchMode[] f437589a = null;
        private String mode;

        static {
            LaunchMode r100 = new LaunchMode();
            HOST_STACK = r100;
            f437589a = new LaunchMode[]{r100};
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) f437589a.clone();
        }

        public String getMode() {
            return this.mode;
        }

        public static /* synthetic */ String access$1500(LaunchMode r100) {
            return r100.mode;
        }

        public static LaunchMode fromString(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            LaunchMode[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L11;
            LaunchMode r104 = r101[r103];
            if (r104.mode.equalsIgnoreCase(r100) == true) goto L9;
            r103 = r103 + 1;
            goto L6
        L9:
            return r104;
        L11:
            return null;
        }

        public static LaunchMode valueOf(String r100) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r100);
        }

        public void setMode(String r100) {
            this.mode = r100;
        }
    }

    public static final enum SceneCheckResult extends Enum<SceneCheckResult> {
        public static final SceneCheckResult DEFAULT = null;
        public static final SceneCheckResult NONE = null;
        public static final SceneCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneCheckResult[] f437590a = null;
        private String name;

        static {
            SceneCheckResult r100 = new SceneCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            SceneCheckResult r101 = new SceneCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            SceneCheckResult r102 = new SceneCheckResult("DEFAULT", 2, "0");
            DEFAULT = r102;
            f437590a = new SceneCheckResult[]{r100, r101, r102};
        }

        public static SceneCheckResult[] values() {
            return (SceneCheckResult[]) f437590a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static SceneCheckResult valueOf(String r100) {
            return (SceneCheckResult) r27.a.a(SceneCheckResult.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public SceneCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum TTidCheckResult extends Enum<TTidCheckResult> {
        public static final TTidCheckResult BOTH = null;
        public static final TTidCheckResult INNER = null;
        public static final TTidCheckResult NEITHER = null;
        public static final TTidCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TTidCheckResult[] f437591a = null;
        private String name;

        static {
            TTidCheckResult r100 = new TTidCheckResult("INNER", 0, RNParamRegisterEventHandler.SRC_INNER);
            INNER = r100;
            TTidCheckResult r101 = new TTidCheckResult("OUTER", 1, RNParamRegisterEventHandler.SRC_OUTER);
            OUTER = r101;
            TTidCheckResult r102 = new TTidCheckResult("BOTH", 2, "both");
            BOTH = r102;
            TTidCheckResult r103 = new TTidCheckResult("NEITHER", 3, "neither");
            NEITHER = r103;
            f437591a = new TTidCheckResult[]{r100, r101, r102, r103};
        }

        public static TTidCheckResult[] values() {
            return (TTidCheckResult[]) f437591a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static TTidCheckResult valueOf(String r100) {
            return (TTidCheckResult) r27.a.a(TTidCheckResult.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public TTidCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum VersionType extends Enum<VersionType> {
        public static final VersionType AUDIT = null;
        public static final VersionType CURRENT = null;
        public static final VersionType LATEST = null;
        public static final VersionType LOCAL_DEV = null;
        public static final VersionType PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionType[] f437592a = null;
        private String name;

        static {
            VersionType r100 = new VersionType("CURRENT", 0, "current");
            CURRENT = r100;
            VersionType r101 = new VersionType("LATEST", 1, "latest");
            LATEST = r101;
            VersionType r102 = new VersionType("AUDIT", 2, "audit");
            AUDIT = r102;
            VersionType r103 = new VersionType("PREVIEW", 3, "preview");
            PREVIEW = r103;
            VersionType r104 = new VersionType("LOCAL_DEV", 4, AppConstants.CHANNEL_LOCAL_DEV);
            LOCAL_DEV = r104;
            f437592a = new VersionType[]{r100, r101, r102, r103, r104};
        }

        public static VersionType[] values() {
            return (VersionType[]) f437592a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static /* synthetic */ String access$1600(VersionType r100) {
            return r100.name;
        }

        public static VersionType fromString(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            VersionType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L11;
            VersionType r104 = r101[r103];
            if (r104.name.equalsIgnoreCase(r100) == true) goto L9;
            r103 = r103 + 1;
            goto L6
        L9:
            return r104;
        L11:
            return null;
        }

        public static VersionType valueOf(String r100) {
            return (VersionType) r27.a.a(VersionType.class, r100);
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public VersionType(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static /* synthetic */ class a {
    }

    public String toSchema() {
        if (TextUtils.isEmpty(this.appId) == false) goto L5;
        return null;
    L5:
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(this.protocol) == false) goto L9;
        this.protocol = AppConstants.SCHEME_SS_LOCAL;
    L9:
        if (this.host != null) goto L106;
        this.host = Host.MICROAPP;
    L106:
        r100.append(this.protocol);     // Catch: Exception -> L102
        r100.append("://");     // Catch: Exception -> L102
        r100.append(Host.access$1400(this.host));     // Catch: Exception -> L102
        r100.append("?");     // Catch: Exception -> L102
        r100.append("version");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append("v2");     // Catch: Exception -> L102
        r100.append("&");     // Catch: Exception -> L102
        r100.append("app_id");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(this.appId);     // Catch: Exception -> L102
        if (TextUtils.isEmpty(this.scene) == true) goto L16;
        r100.append("&");     // Catch: Exception -> L102
        r100.append("scene");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(this.scene));     // Catch: Exception -> L102
    L18:
        if (this.launchMode == null) goto L20;
        r100.append("&");     // Catch: Exception -> L102
        r100.append(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(LaunchMode.access$1500(this.launchMode));     // Catch: Exception -> L102
    L20:
        r100.append("&");     // Catch: Exception -> L102
        r100.append("version_type");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        VersionType r101 = this.versionType;     // Catch: Exception -> L102
        if (r101 == null) goto L23;
        r100.append(VersionType.access$1600(r101));     // Catch: Exception -> L102
    L25:
        if (TextUtils.isEmpty(this.token) == true) goto L28;
        r100.append("&");     // Catch: Exception -> L102
        r100.append("token");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(this.token);     // Catch: Exception -> L102
    L28:
        if (this.host != Host.MICROGAME) goto L37;
        Map<String, Object> r102 = this.query;     // Catch: Exception -> L102
        if (r102 != null) goto L32;
    L59:
        Map<String, Object> r103 = this.bdpLog;     // Catch: Exception -> L102
        if (r103 != null) goto L62;
    L67:
        Map<String, Object> r104 = this.meta;     // Catch: Exception -> L102
        if (r104 != null) goto L70;
    L72:
        Map<String, Object> r105 = this.inspect;     // Catch: Exception -> L102
        if (r105 != null) goto L75;
    L77:
        Map<String, Object> r106 = this.refererInfo;     // Catch: Exception -> L102
        if (r106 != null) goto L80;
    L82:
        Map<String, Object> r107 = this.customFields;     // Catch: Exception -> L102
        if (r107 != null) goto L85;
    L98:
        String r108 = genBdpSum(r100.toString());     // Catch: Exception -> L102
        if (TextUtils.isEmpty(r108) == true) goto L105;
        r100.append("&");     // Catch: Exception -> L102
        r100.append(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(r108);     // Catch: Exception -> L102
    L105:
        return r100.toString();
    L85:
        if (r107.size() <= 0) goto L98;
        Iterator<String> r109 = this.customFields.keySet().iterator();     // Catch: Exception -> L102
    L88:
        if (r109.hasNext() == false) goto L98;
        String r110 = r109.next();     // Catch: Exception -> L102
        if (isReservedField(r110) == true) goto L88;
        Object r111 = this.customFields.get(r110);     // Catch: Exception -> L102
        if ((r111 instanceof Map) == true) goto L93;
        if (r111 == null) goto L88;
        if (TextUtils.isEmpty(r111.toString()) == true) goto L88;
        r100.append("&");     // Catch: Exception -> L102
        r100.append(r110);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(r111.toString()));     // Catch: Exception -> L102
        goto L88
    L93:
        r100.append("&");     // Catch: Exception -> L102
        r100.append(r110);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(getJsonFromMap((Map) r111).toJSONString()));     // Catch: Exception -> L102
        goto L88
    L80:
        if (r106.size() <= 0) goto L82;
        r100.append("&");     // Catch: Exception -> L102
        r100.append(AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(getJsonFromMap(this.refererInfo).toJSONString()));     // Catch: Exception -> L102
        goto L82
    L75:
        if (r105.size() <= 0) goto L77;
        r100.append("&");     // Catch: Exception -> L102
        r100.append(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(getJsonFromMap(this.inspect).toJSONString()));     // Catch: Exception -> L102
        goto L77
    L70:
        if (r104.size() <= 0) goto L72;
        r100.append("&");     // Catch: Exception -> L102
        r100.append("meta");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(getJsonFromMap(this.meta).toJSONString()));     // Catch: Exception -> L102
        goto L72
    L62:
        if (r103.size() <= 0) goto L67;
        r100.append("&");     // Catch: Exception -> L65
        r100.append("bdp_log");     // Catch: Exception -> L65
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L65
        r100.append(Uri.encode(getJsonFromMap(this.bdpLog).toJSONString()));     // Catch: Exception -> L65
    L65:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());     // Catch: Exception -> L102
        goto L67
    L32:
        if (r102.size() <= 0) goto L59;
        JSONObject r112 = getJsonFromMap(this.query);     // Catch: Exception -> L102
        if (r112 == null) goto L59;
        r100.append("&");     // Catch: Exception -> L102
        r100.append("query");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(r112.toJSONString()));     // Catch: Exception -> L102
        goto L59
    L37:
        if (TextUtils.isEmpty(this.path) == true) goto L57;
        String r113 = this.path;     // Catch: Exception -> L102
        if (this.query == null) goto L55;
        String r114 = r113 + "?";     // Catch: Exception -> L102
        JSONObject r115 = getJsonFromMap(this.query);     // Catch: Exception -> L52
        Iterator r116 = r115.keySet().iterator();     // Catch: Exception -> L52
    L42:
        if (r116.hasNext() == false) goto L54;
        String r117 = (String) r116.next();     // Catch: Exception -> L52
        Object r118 = r115.get(r117);     // Catch: Exception -> L52
        if ((r118 instanceof JSONObject) == true) goto L50;
        if ((r118 instanceof JSONArray) == true) goto L50;
        r114 = r114 + r117 + ContainerUtils.KEY_VALUE_DELIMITER + Uri.encode(r118.toString()) + "&";     // Catch: Exception -> L52
    L50:
        r114 = r114 + r117 + ContainerUtils.KEY_VALUE_DELIMITER + Uri.encode(((JSONAware) r118).toJSONString()) + "&";     // Catch: Exception -> L52
    L54:
        r113 = r114.substring(0, r114.length() - 1);     // Catch: Exception -> L102
        goto L55
    L52:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());     // Catch: Exception -> L102
    L55:
        r100.append("&");     // Catch: Exception -> L102
        r100.append("start_page");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append(Uri.encode(r113));     // Catch: Exception -> L102
        goto L59
    L57:
        if (this.query == null) goto L59;
        return null;
    L23:
        r100.append(VersionType.access$1600(VersionType.CURRENT));     // Catch: Exception -> L102
        goto L25
    L16:
        r100.append("&");     // Catch: Exception -> L102
        r100.append("scene");     // Catch: Exception -> L102
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L102
        r100.append("0");     // Catch: Exception -> L102
    L102:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L105
    }

    public String getAppId() {
        return this.appId;
    }

    public Map<String, Object> getBdpLog() {
        return this.bdpLog;
    }

    public Map<String, Object> getCustomFields() {
        return this.customFields;
    }

    public Host getHost() {
        return this.host;
    }

    public Map<String, Object> getInspect() {
        return this.inspect;
    }

    public LaunchMode getLaunchMode() {
        return this.launchMode;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public String getPath() {
        return this.path;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Map<String, Object> getQuery() {
        return this.query;
    }

    public Map<String, Object> getRefererInfo() {
        return this.refererInfo;
    }

    public String getScene() {
        return this.scene;
    }

    public String getToken() {
        return this.token;
    }

    public VersionType getVersionType() {
        return this.versionType;
    }

    private MicroSchemaEntity(Builder r100) {
        if (TextUtils.isEmpty(Builder.access$000(r100)) == false) goto L5;
        this.protocol = AppConstants.SCHEME_SS_LOCAL;
    L7:
        if (Builder.access$100(r100) != null) goto L9;
        this.host = Host.MICROAPP;
    L10:
        this.appId = Builder.access$200(r100);
        if (Builder.access$300(r100) != null) goto L13;
        this.versionType = VersionType.CURRENT;
    L14:
        this.token = Builder.access$400(r100);
        this.meta = Builder.access$500(r100);
        if (TextUtils.isEmpty(Builder.access$600(r100)) == false) goto L17;
        this.scene = "0";
    L18:
        this.path = Builder.access$700(r100);
        this.query = Builder.access$800(r100);
        this.bdpLog = Builder.access$900(r100);
        if (Builder.access$1000(r100) != null) goto L21;
        this.customFields = new HashMap();
    L22:
        this.launchMode = Builder.access$1100(r100);
        this.refererInfo = Builder.access$1200(r100);
        this.inspect = Builder.access$1300(r100);
        return;
    L21:
        this.customFields = Builder.access$1000(r100);
        goto L22
    L17:
        this.scene = Builder.access$600(r100);
        goto L18
    L13:
        this.versionType = Builder.access$300(r100);
        goto L14
    L9:
        this.host = Builder.access$100(r100);
        goto L10
    L5:
        this.protocol = Builder.access$000(r100);
        goto L7
    }

    public static BdpsumCheckResult checkBdpsum(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String[] r101 = r100.split("&bdpsum=");
        if (r101.length < 2) goto L9;
        String r102 = r101[1];
        String r103 = genBdpSum(r101[0]);
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return BdpsumCheckResult.NONE;
    L15:
        if (TextUtils.isEmpty(r103) == false) goto L19;
        return BdpsumCheckResult.ERROR;
    L19:
        if (r102.equals(r103) == false) goto L23;
        return BdpsumCheckResult.NORMAL;
    L23:
        return BdpsumCheckResult.ERROR;
    L9:
        return BdpsumCheckResult.NONE;
    L5:
        return BdpsumCheckResult.NONE;
    }

    public static LaunchFromCheckResult checkLaunchFrom(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        MicroSchemaEntity r101 = parseFromSchema(r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        Map<String, Object> r102 = r101.customFields;
        boolean r103 = false;
        if (r102 == null) goto L13;
        boolean r104 = r102.containsKey("launch_from");
    L14:
        Map<String, Object> r105 = r101.bdpLog;
        if (r105 == null) goto L17;
        r103 = r105.containsKey("launch_from");
    L17:
        if (r103 == false) goto L21;
        if (r104 == false) goto L21;
        return LaunchFromCheckResult.BOTH;
    L21:
        if (r103 == false) goto L25;
        if (r104 == true) goto L25;
        return LaunchFromCheckResult.INNER;
    L25:
        if (r103 == true) goto L29;
        if (r104 == false) goto L29;
        return LaunchFromCheckResult.OUTER;
    L29:
        if (r103 == true) goto L34;
        if (r104 == true) goto L34;
        return LaunchFromCheckResult.NEITHER;
    L34:
        return LaunchFromCheckResult.NEITHER;
    L13:
        r104 = false;
        goto L14
    L5:
        return LaunchFromCheckResult.NEITHER;
    }

    public static SceneCheckResult checkScene(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        MicroSchemaEntity r101 = parseFromSchema(r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        String r102 = r101.getScene();
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return SceneCheckResult.NONE;
    L15:
        if (r102.equals("0") == false) goto L19;
        return SceneCheckResult.DEFAULT;
    L19:
        return SceneCheckResult.NORMAL;
    L5:
        return SceneCheckResult.NONE;
    }

    public static boolean checkSchemaV2valid(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String[] r101 = r100.split("&bdpsum=");
        if (r101.length >= 2) goto L8;
        return false;
    L8:
        String r102 = r101[1];
        String r103 = genBdpSum(r101[0]);
        if (TextUtils.isEmpty(r102) == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        return false;
    L13:
        if (r102.equals(r103) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static TTidCheckResult checkTTid(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        MicroSchemaEntity r101 = parseFromSchema(r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        Map<String, Object> r102 = r101.customFields;
        boolean r103 = false;
        if (r102 == null) goto L13;
        boolean r104 = r102.containsKey(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID);
    L14:
        Map<String, Object> r105 = r101.bdpLog;
        if (r105 == null) goto L17;
        r103 = r105.containsKey(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID);
    L17:
        if (r103 == false) goto L21;
        if (r104 == false) goto L21;
        return TTidCheckResult.BOTH;
    L21:
        if (r103 == false) goto L25;
        if (r104 == true) goto L25;
        return TTidCheckResult.INNER;
    L25:
        if (r103 == true) goto L29;
        if (r104 == false) goto L29;
        return TTidCheckResult.OUTER;
    L29:
        if (r103 == true) goto L34;
        if (r104 == true) goto L34;
        return TTidCheckResult.NEITHER;
    L34:
        return TTidCheckResult.NEITHER;
    L13:
        r104 = false;
        goto L14
    L5:
        return TTidCheckResult.NEITHER;
    }

    private static String genBdpSum(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        if (r100.contains("://") == false) goto L14;
        String[] r101 = r100.split("://");
        if (r101 != null) goto L10;
    L13:
        return "";
    L10:
        if (r101.length < 2) goto L13;
        r100 = r101[1];
    L14:
        String r102 = md5Hex(r100.substring(0, 10) + AppbrandHostConstants.Schema_BDP_SUM.MD5_SALT + r100.substring(10));
        if (TextUtils.isEmpty(r102) == false) goto L18;
        return "";
    L18:
        return r102.substring(2, 6) + r102.substring(20, 23);
    }

    private static List<Object> getArrayFromJsonArray(JSONArray r100) throws Exception {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L12;
        Object r103 = r100.get(r102);
        if ((r103 instanceof JSONArray) == false) goto L9;
        r103 = getArrayFromJsonArray((JSONArray) r103);
    L11:
        r101.add(r103);
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof JSONObject) == false) goto L11;
        r103 = getMapFromJson((JSONObject) r103);
        goto L11
    L12:
        return r101;
    }

    private static JSONObject getJsonFromMap(Map r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (JSONObject) new JSONParser().parse(JSONValue.toJSONString(r100));
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e.toString()});
        return null;
    }

    private static Map<String, Object> getMapFromJson(JSONObject r100) throws Exception {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L12;
        r104 = getArrayFromJsonArray((JSONArray) r104);
    L14:
        r101.put(r103, r104);
        goto L7
    L12:
        if ((r104 instanceof JSONObject) == false) goto L14;
        r104 = getMapFromJson((JSONObject) r104);
        goto L14
    L15:
        return r101;
    }

    private static boolean isNormalUri(String r100) {
        UriProtector.getQueryParameterNames(UriProtector.parse(r100));     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    private static boolean isReservedField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        if (r100.equals("version") == false) goto L8;
        return true;
    L8:
        if (r100.equals("app_id") == false) goto L10;
        return true;
    L10:
        if (r100.equals("meta") == false) goto L12;
        return true;
    L12:
        if (r100.equals("scene") == false) goto L14;
        return true;
    L14:
        if (r100.equals("version_type") == false) goto L16;
        return true;
    L16:
        if (r100.equals("token") == false) goto L18;
        return true;
    L18:
        if (r100.equals("start_page") == false) goto L20;
        return true;
    L20:
        if (r100.equals("query") == false) goto L22;
        return true;
    L22:
        if (r100.equals("bdp_log") == false) goto L24;
        return true;
    L24:
        if (r100.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD) == false) goto L26;
        return true;
    L26:
        if (r100.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT) == false) goto L28;
        return true;
    L28:
        if (r100.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO) == false) goto L30;
        return true;
    L30:
        if (r100.equals("path") == false) goto L32;
        return true;
    L32:
        if (r100.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM) == true) goto L49;
        return false;
    L49:
        return true;
    }

    private static boolean isjson(String r100) {
        Object r101 = new JSONParser().parse(r100);     // Catch: Exception -> L11
        if ((r101 instanceof JSONObject) == true) goto L9;
        if ((r101 instanceof JSONArray) == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        return true;
    L11:
        return false;
    }

    private static String md5Hex(String r100) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L11
    L5:
        if (r100.length() == 0) goto L11;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L9
        return toHexString(r101.digest());
    }

    public static MicroSchemaEntity parseFromSchema(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (isNormalUri(r100) == true) goto L8;
        return null;
    L8:
        Uri r101 = UriProtector.parse(r100);
        JSONParser r102 = new JSONParser();
        Builder r103 = new Builder().protocol(r101.getScheme()).host(Host.fromString(r101.getHost())).appId(UriProtector.getQueryParameter(r101, "app_id")).versionType(VersionType.fromString(UriProtector.getQueryParameter(r101, "version_type"))).token(UriProtector.getQueryParameter(r101, "token")).scene(UriProtector.getQueryParameter(r101, "scene"));     // Catch: Exception -> L72
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT)) == true) goto L13;
        r103.inspect(getMapFromJson((JSONObject) r102.parse(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT))));     // Catch: Exception -> L72
    L13:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO)) == true) goto L16;
        r103.refererInfo(getMapFromJson((JSONObject) r102.parse(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.REFERER_INFO))));     // Catch: Exception -> L72
    L16:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r101, "meta")) == true) goto L19;
        r103.meta(getMapFromJson((JSONObject) r102.parse(UriProtector.getQueryParameter(r101, "meta"))));     // Catch: Exception -> L72
    L19:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD)) == true) goto L21;
        r103.launchMode(LaunchMode.fromString(UriProtector.getQueryParameter(r101, AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD)));     // Catch: Exception -> L72
    L21:
        String r104 = UriProtector.getQueryParameter(r101, "bdp_log");     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r104) == true) goto L24;
        r103.bdpLog(getMapFromJson((JSONObject) r102.parse(r104)));     // Catch: Exception -> L72
    L24:
        Set<String> r105 = UriProtector.getQueryParameterNames(r101);     // Catch: Exception -> L72
        HashMap r106 = new HashMap();     // Catch: Exception -> L72
        Iterator<String> r107 = r105.iterator();     // Catch: Exception -> L72
    L26:
        if (r107.hasNext() == false) goto L39;
        String r108 = r107.next();     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r108) == true) goto L26;
        if (isReservedField(r108) == true) goto L26;
        String r109 = UriProtector.getQueryParameter(r101, r108);     // Catch: Exception -> L72
        if (isjson(r109) == true) goto L33;
        r106.put(r108, r109);     // Catch: Exception -> L72
        goto L26
    L33:
        Object r110 = r102.parse(r109);     // Catch: Exception -> L72
        if ((r110 instanceof JSONObject) == true) goto L35;
        if (r110 == null) goto L26;
        r106.put(r108, ((JSONArray) r110).toArray());     // Catch: Exception -> L72
        goto L26
    L35:
        r106.put(r108, getMapFromJson((JSONObject) r110));     // Catch: Exception -> L72
        goto L26
    L39:
        r103.customFields(r106);     // Catch: Exception -> L72
        if (Host.fromString(r101.getHost()) != Host.MICROAPP) goto L60;
        String r111 = UriProtector.getQueryParameter(r101, "start_page");     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r111) == true) goto L70;
        String[] r112 = r111.split("\\?");     // Catch: Exception -> L72
        if (r112.length <= 1) goto L59;
        HashMap r113 = new HashMap();     // Catch: Exception -> L72
        r103.path(r112[0]);     // Catch: Exception -> L72
        if (isNormalUri(r111) == false) goto L70;
        Uri r114 = UriProtector.parse(r111);     // Catch: Exception -> L72
        Iterator<String> r115 = UriProtector.getQueryParameterNames(r114).iterator();     // Catch: Exception -> L72
    L49:
        if (r115.hasNext() == false) goto L58;
        String r116 = r115.next();     // Catch: Exception -> L72
        String r117 = UriProtector.getQueryParameter(r114, r116);     // Catch: Exception -> L72
        if (isjson(r117) == true) goto L52;
        r113.put(r116, r117);     // Catch: Exception -> L72
        goto L49
    L52:
        Object r118 = r102.parse(r117);     // Catch: Exception -> L72
        if ((r118 instanceof JSONObject) == true) goto L54;
        if (r118 == null) goto L49;
        r113.put(r116, getArrayFromJsonArray((JSONArray) r118));     // Catch: Exception -> L72
        goto L49
    L54:
        r113.put(r116, getMapFromJson((JSONObject) r118));     // Catch: Exception -> L72
        goto L49
    L58:
        r103.query(r113);     // Catch: Exception -> L72
        goto L70
    L59:
        r103.path(r112[0]);     // Catch: Exception -> L72
    L70:
        return new MicroSchemaEntity(r103);
    L60:
        String r119 = UriProtector.getQueryParameter(r101, "query");     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r119) == true) goto L70;
        if (isjson(r119) == true) goto L66;
        r119 = Uri.decode(r119);     // Catch: Exception -> L72
    L66:
        if (isjson(r119) == false) goto L70;
        Object r120 = r102.parse(r119);     // Catch: Exception -> L72
        if ((r120 instanceof JSONObject) == false) goto L70;
        r103.query(getMapFromJson((JSONObject) r120));     // Catch: Exception -> L72
    L72:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        return null;
    }

    private static String toHexString(byte... r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L10;
        int r105 = r100[r103];
        if (r105 >= 0) goto L8;
        r105 = r105 + 256;
    L8:
        int r106 = r104 + 1;
        r102[r104] = r101[r105 >>> 4];
        r104 = r106 + 1;
        r102[r106] = r101[r105 & 15];
        r103 = r103 + 1;
        goto L4
    L10:
        return new String(r102);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MicroSchemaEntity) == true) goto L5;
        return false;
    L5:
        MicroSchemaEntity r101 = (MicroSchemaEntity) r100;
        String r102 = this.protocol;
        if (r102 != null) goto L11;
        if (r101.protocol != null) goto L99;
    L12:
        Host r103 = this.host;
        if (r103 != null) goto L18;
        if (r101.host == null) goto L20;
        return false;
    L20:
        if (Objects.equals(this.appId, r101.appId) == false) goto L103;
        VersionType r104 = this.versionType;
        if (r104 != null) goto L27;
        if (r101.versionType != null) goto L104;
    L28:
        String r105 = this.token;
        if (r105 != null) goto L34;
        if (r101.token != null) goto L106;
    L35:
        Map<String, Object> r106 = this.meta;
        if (r106 != null) goto L41;
        if (r101.meta != null) goto L108;
    L42:
        String r107 = this.scene;
        if (r107 != null) goto L48;
        if (r101.scene != null) goto L110;
    L49:
        LaunchMode r108 = this.launchMode;
        if (r108 != null) goto L55;
        if (r101.launchMode != null) goto L112;
    L56:
        Map<String, Object> r109 = this.refererInfo;
        if (r109 != null) goto L62;
        if (r101.refererInfo != null) goto L114;
    L63:
        String r110 = this.path;
        if (r110 != null) goto L69;
        if (r101.path != null) goto L116;
    L70:
        Map<String, Object> r111 = this.query;
        if (r111 != null) goto L76;
        if (r101.query != null) goto L118;
    L77:
        Map<String, Object> r112 = this.bdpLog;
        if (r112 != null) goto L83;
        if (r101.bdpLog != null) goto L120;
    L84:
        Map<String, Object> r113 = this.inspect;
        if (r113 != null) goto L90;
        if (r101.inspect != null) goto L122;
    L91:
        Map<String, Object> r114 = this.customFields;
        Map<String, Object> r115 = r101.customFields;
        if (r114 != null) goto L96;
        if (r115 != null) goto L124;
    L97:
        return true;
    L124:
        return false;
    L96:
        if (r114.equals(r115) == true) goto L97;
        return false;
    L122:
        return false;
    L90:
        if (r113.equals(r101.inspect) == true) goto L91;
        return false;
    L120:
        return false;
    L83:
        if (r112.equals(r101.bdpLog) == true) goto L84;
        return false;
    L118:
        return false;
    L76:
        if (r111.equals(r101.query) == true) goto L77;
        return false;
    L116:
        return false;
    L69:
        if (r110.equals(r101.path) == true) goto L70;
        return false;
    L114:
        return false;
    L62:
        if (r109.equals(r101.refererInfo) == true) goto L63;
        return false;
    L112:
        return false;
    L55:
        if (r108.equals(r101.launchMode) == true) goto L56;
        return false;
    L110:
        return false;
    L48:
        if (r107.equals(r101.scene) == true) goto L49;
        return false;
    L108:
        return false;
    L41:
        if (r106.equals(r101.meta) == true) goto L42;
        return false;
    L106:
        return false;
    L34:
        if (r105.equals(r101.token) == true) goto L35;
        return false;
    L104:
        return false;
    L27:
        if (r104.equals(r101.versionType) == true) goto L28;
        return false;
    L103:
        return false;
    L18:
        if (r103.equals(r101.host) == true) goto L20;
        return false;
    L99:
        return false;
    L11:
        if (r102.equals(r101.protocol) == true) goto L12;
        return false;
    }

    public boolean removeBdpLogField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.bdpLog;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public boolean removeCustomField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.customFields;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public boolean removeInspectField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.inspect;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public boolean removeMetaField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.meta;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public boolean removeQueryField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.query;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public boolean removeRefererInfoField(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Map<String, Object> r101 = this.refererInfo;
        if (r101 != null) goto L9;
        return true;
    L9:
        r101.remove(r100);
        return true;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setBdpLog(Map<String, Object> r100) {
        this.bdpLog = r100;
    }

    public void setCustomFields(Map<String, Object> r100) {
        this.customFields = r100;
    }

    public void setHost(Host r100) {
        this.host = r100;
    }

    public void setInspect(Map<String, Object> r100) {
        this.inspect = r100;
    }

    public void setLaunchMode(LaunchMode r100) {
        this.launchMode = r100;
    }

    public void setMeta(Map<String, Object> r100) {
        this.meta = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setProtocol(String r100) {
        this.protocol = r100;
    }

    public void setQuery(Map<String, Object> r100) {
        this.query = r100;
    }

    public void setRefererInfo(Map<String, Object> r100) {
        this.refererInfo = r100;
    }

    public void setScene(String r100) {
        this.scene = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setVersionType(VersionType r100) {
        this.versionType = r100;
    }

    public /* synthetic */ MicroSchemaEntity(Builder r100, a r101) {
        this(r100);
    }

    public boolean addBdpLogField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.bdpLog != null) goto L9;
        this.bdpLog = new HashMap();
    L9:
        this.bdpLog.put(r100, r101);
        return true;
    }

    public boolean addCustomField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.customFields != null) goto L9;
        this.customFields = new HashMap();
    L9:
        this.customFields.put(r100, r101);
        return true;
    }

    public boolean addInspectField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.inspect != null) goto L9;
        this.inspect = new HashMap();
    L9:
        this.inspect.put(r100, r101);
        return true;
    }

    public boolean addMetaField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.meta != null) goto L9;
        this.meta = new HashMap();
    L9:
        this.meta.put(r100, r101);
        return true;
    }

    public boolean addQueryField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.query != null) goto L9;
        this.query = new HashMap();
    L9:
        this.query.put(r100, r101);
        return true;
    }

    public boolean addRefererInfoField(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (this.refererInfo != null) goto L9;
        this.refererInfo = new HashMap();
    L9:
        this.refererInfo.put(r100, r101);
        return true;
    }
}
