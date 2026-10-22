package com.bytedance.bdp.live.livecontainer.base.schema;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo;", "Landroid/os/Parcelable;", "BdpsumCheckResult", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "Host", "LaunchFromCheckResult", "LaunchMode", "LocationCheckResult", "SceneCheckResult", "TTidCheckResult", "VersionType", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
public final class LiveSchemaInfo implements Parcelable {
    public static final Parcelable.Creator<LiveSchemaInfo> CREATOR = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final LruCache<String, LiveSchemaInfo> f201489r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f201490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f201491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f201492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f201493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f201494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f201495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f201496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f201497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f201498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f201499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f201500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f201501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f201502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f201503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f201504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f201505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Uri f201506q;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$BdpsumCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, UserProfileEvent.POSITION_NONE, "ERROR", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum BdpsumCheckResult extends Enum<BdpsumCheckResult> {
        public static final BdpsumCheckResult ERROR = null;
        public static final BdpsumCheckResult NONE = null;
        public static final BdpsumCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpsumCheckResult[] f201507a = null;
        private final String value;

        static {
            BdpsumCheckResult r100 = new BdpsumCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            BdpsumCheckResult r101 = new BdpsumCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            BdpsumCheckResult r102 = new BdpsumCheckResult("ERROR", 2, "error");
            ERROR = r102;
            f201507a = new BdpsumCheckResult[]{r100, r101, r102};
        }

        public static BdpsumCheckResult valueOf(String r100) {
            return (BdpsumCheckResult) r27.a.a(BdpsumCheckResult.class, r100);
        }

        public static BdpsumCheckResult[] values() {
            return (BdpsumCheckResult[]) f201507a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public BdpsumCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$Host;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MICROAPP", "MICROGAME", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum Host extends Enum<Host> {
        public static final a Companion = null;
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Host[] f201508a = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        static {
            Host r100 = new Host("MICROAPP", 0, AppbrandHostConstants.Micro_Host.HOST_APPBRAND);
            MICROAPP = r100;
            Host r101 = new Host("MICROGAME", 1, AppbrandHostConstants.Micro_Host.HOST_GAME);
            MICROGAME = r101;
            f201508a = new Host[]{r100, r101};
            Companion = new a();
        }

        public static Host valueOf(String r100) {
            return (Host) r27.a.a(Host.class, r100);
        }

        public static Host[] values() {
            return (Host[]) f201508a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Host(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$LaunchFromCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum LaunchFromCheckResult extends Enum<LaunchFromCheckResult> {
        public static final LaunchFromCheckResult BOTH = null;
        public static final LaunchFromCheckResult INNER = null;
        public static final LaunchFromCheckResult NEITHER = null;
        public static final LaunchFromCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchFromCheckResult[] f201509a = null;
        private final String value;

        static {
            LaunchFromCheckResult r100 = new LaunchFromCheckResult("INNER", 0, RNParamRegisterEventHandler.SRC_INNER);
            INNER = r100;
            LaunchFromCheckResult r101 = new LaunchFromCheckResult("OUTER", 1, RNParamRegisterEventHandler.SRC_OUTER);
            OUTER = r101;
            LaunchFromCheckResult r102 = new LaunchFromCheckResult("BOTH", 2, "both");
            BOTH = r102;
            LaunchFromCheckResult r103 = new LaunchFromCheckResult("NEITHER", 3, "neither");
            NEITHER = r103;
            f201509a = new LaunchFromCheckResult[]{r100, r101, r102, r103};
        }

        public static LaunchFromCheckResult valueOf(String r100) {
            return (LaunchFromCheckResult) r27.a.a(LaunchFromCheckResult.class, r100);
        }

        public static LaunchFromCheckResult[] values() {
            return (LaunchFromCheckResult[]) f201509a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public LaunchFromCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$LaunchMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HOST_STACK", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final a Companion = null;
        public static final LaunchMode HOST_STACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchMode[] f201510a = null;
        private final String mode;

        public static final class a {
            public a() {
            }
        }

        static {
            LaunchMode r100 = new LaunchMode();
            HOST_STACK = r100;
            f201510a = new LaunchMode[]{r100};
            Companion = new a();
        }

        public static LaunchMode valueOf(String r100) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r100);
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) f201510a.clone();
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public final String getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$LocationCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum LocationCheckResult extends Enum<LocationCheckResult> {
        public static final LocationCheckResult BOTH = null;
        public static final LocationCheckResult INNER = null;
        public static final LocationCheckResult NEITHER = null;
        public static final LocationCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LocationCheckResult[] f201511a = null;
        private final String value;

        static {
            LocationCheckResult r100 = new LocationCheckResult("INNER", 0, RNParamRegisterEventHandler.SRC_INNER);
            INNER = r100;
            LocationCheckResult r101 = new LocationCheckResult("OUTER", 1, RNParamRegisterEventHandler.SRC_OUTER);
            OUTER = r101;
            LocationCheckResult r102 = new LocationCheckResult("BOTH", 2, "both");
            BOTH = r102;
            LocationCheckResult r103 = new LocationCheckResult("NEITHER", 3, "neither");
            NEITHER = r103;
            f201511a = new LocationCheckResult[]{r100, r101, r102, r103};
        }

        public static LocationCheckResult valueOf(String r100) {
            return (LocationCheckResult) r27.a.a(LocationCheckResult.class, r100);
        }

        public static LocationCheckResult[] values() {
            return (LocationCheckResult[]) f201511a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public LocationCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$SceneCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, UserProfileEvent.POSITION_NONE, "DEFAULT", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum SceneCheckResult extends Enum<SceneCheckResult> {
        public static final SceneCheckResult DEFAULT = null;
        public static final SceneCheckResult NONE = null;
        public static final SceneCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneCheckResult[] f201512a = null;
        private final String value;

        static {
            SceneCheckResult r100 = new SceneCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            SceneCheckResult r101 = new SceneCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            SceneCheckResult r102 = new SceneCheckResult("DEFAULT", 2, "0");
            DEFAULT = r102;
            f201512a = new SceneCheckResult[]{r100, r101, r102};
        }

        public static SceneCheckResult valueOf(String r100) {
            return (SceneCheckResult) r27.a.a(SceneCheckResult.class, r100);
        }

        public static SceneCheckResult[] values() {
            return (SceneCheckResult[]) f201512a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public SceneCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$TTidCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum TTidCheckResult extends Enum<TTidCheckResult> {
        public static final TTidCheckResult BOTH = null;
        public static final TTidCheckResult INNER = null;
        public static final TTidCheckResult NEITHER = null;
        public static final TTidCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TTidCheckResult[] f201513a = null;
        private final String value;

        static {
            TTidCheckResult r100 = new TTidCheckResult("INNER", 0, RNParamRegisterEventHandler.SRC_INNER);
            INNER = r100;
            TTidCheckResult r101 = new TTidCheckResult("OUTER", 1, RNParamRegisterEventHandler.SRC_OUTER);
            OUTER = r101;
            TTidCheckResult r102 = new TTidCheckResult("BOTH", 2, "both");
            BOTH = r102;
            TTidCheckResult r103 = new TTidCheckResult("NEITHER", 3, "neither");
            NEITHER = r103;
            f201513a = new TTidCheckResult[]{r100, r101, r102, r103};
        }

        public static TTidCheckResult valueOf(String r100) {
            return (TTidCheckResult) r27.a.a(TTidCheckResult.class, r100);
        }

        public static TTidCheckResult[] values() {
            return (TTidCheckResult[]) f201513a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public TTidCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/live/livecontainer/base/schema/LiveSchemaInfo$VersionType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "current", "latest", "audit", "preview", AppConstants.CHANNEL_LOCAL_DEV, "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum VersionType extends Enum<VersionType> {
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionType[] f201514a = null;
        public static final VersionType audit = null;
        public static final VersionType current = null;
        public static final VersionType latest = null;
        public static final VersionType local_dev = null;
        public static final VersionType preview = null;

        public static final class a {
            public a() {
            }
        }

        static {
            VersionType r100 = new VersionType("current", 0);
            current = r100;
            VersionType r101 = new VersionType("latest", 1);
            latest = r101;
            VersionType r102 = new VersionType("audit", 2);
            audit = r102;
            VersionType r103 = new VersionType("preview", 3);
            preview = r103;
            VersionType r104 = new VersionType(AppConstants.CHANNEL_LOCAL_DEV, 4);
            local_dev = r104;
            f201514a = new VersionType[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public static VersionType valueOf(String r100) {
            return (VersionType) r27.a.a(VersionType.class, r100);
        }

        public static VersionType[] values() {
            return (VersionType[]) f201514a.clone();
        }

        public VersionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f201515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f201516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Host f201517c;

        public final LiveSchemaInfo a() {
            if (TextUtils.isEmpty(this.f201515a.get("app_id")) == false) goto L6;
            return null;
        L6:
            if (TextUtils.isEmpty(this.f201515a.get("version")) == false) goto L9;
            this.f201515a.put("version", "v2");
        L9:
            if (TextUtils.isEmpty(this.f201515a.get("version_type")) == false) goto L12;
            this.f201515a.put("version_type", VersionType.current.name());
        L12:
            if (TextUtils.isEmpty(this.f201515a.get("scene")) == false) goto L14;
            this.f201515a.put("scene", "0");
        L14:
            this.f201515a.remove(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM);
            Uri.Builder r100 = new Uri.Builder().scheme(this.f201516b).authority(this.f201517c.getValue());     // Catch: Exception -> L21
            Iterator<Map.Entry<String, String>> r101 = this.f201515a.entrySet().iterator();     // Catch: Exception -> L21
        L17:
            if (r101.hasNext() == false) goto L19;
            Map.Entry<String, String> r102 = r101.next();     // Catch: Exception -> L21
            r100.appendQueryParameter(r102.getKey(), r102.getValue());     // Catch: Exception -> L21
            goto L17
        L19:
            int r103 = com.bytedance.bdp.live.livecontainer.base.schema.a.f201518a;     // Catch: Exception -> L21
            r100.appendQueryParameter(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM, com.bytedance.bdp.live.livecontainer.base.schema.a.a(r100.toString()));     // Catch: Exception -> L21
            return new LiveSchemaInfo(r100.build());
        L21:
            e = move-exception;
            upc.a.a(new Object[]{e});
            return null;
        }

        public a(String r100) {
            LinkedHashMap<String, String> r101 = new LinkedHashMap();
            this.f201515a = r101;
            String r102 = AppConstants.SCHEME_SS_LOCAL;
            this.f201516b = AppConstants.SCHEME_SS_LOCAL;
            this.f201517c = Host.MICROAPP;
            Uri r103 = UriProtector.parse(r100);
            Iterator<String> r104 = UriProtector.getQueryParameterNames(r103).iterator();
        L4:
            if (r104.hasNext() == false) goto L8;
            String r105 = r104.next();
            String r106 = UriProtector.getQueryParameter(r103, r105);
            if (r106 == null) goto L4;
            r101.put(r105, r106);
            goto L4
        L8:
            String r107 = r103.getScheme();
            if (r107 == null) goto L11;
            r102 = r107;
        L11:
            this.f201516b = r102;
            Host.a r108 = Host.Companion;
            String r109 = r103.getAuthority();
            r108.getClass();
            Host[] r110 = Host.values();
            int r111 = r110.length;
            int r112 = 0;
        L12:
            if (r112 >= r111) goto L17;
            Host r113 = r110[r112];
            if (StringsKt.equals(r113.getValue(), r109, true) == true) goto L18;
            r112 = r112 + 1;
        L18:
            if (r113 != null) goto L21;
            r113 = Host.MICROAPP;
        L21:
            this.f201517c = r113;
            return;
        L17:
            r113 = null;
            goto L18
        }

        public final a query(JSONObject r100) {
            this.f201515a.put("query", r100.toString());
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<LiveSchemaInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final LiveSchemaInfo createFromParcel(Parcel r100) {
            Parcelable r101 = r100.readParcelable(Uri.class.getClassLoader());
            if (r101 != null) goto L6;
            Intrinsics.throwNpe();
        L6:
            return new LiveSchemaInfo((Uri) r101);
        }

        @Override // android.os.Parcelable.Creator
        public final LiveSchemaInfo[] newArray(int r100) {
            return new LiveSchemaInfo[r100];
        }
    }

    public static final class c {
        @JvmStatic
        public static LiveSchemaInfo a(String r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            if (r100.length() != 0) goto L6;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L28;
            LruCache<String, LiveSchemaInfo> r102 = LiveSchemaInfo.f201489r;
            LiveSchemaInfo r103 = r102.get(r100);
            if (r103 != null) goto L23;
            monitor-enter(r102);
            r103 = r102.get(r100);     // Catch: Throwable -> L20
            if (r103 != null) goto L15;
            r103 = new a(r100).a();     // Catch: Throwable -> L20
        L15:
            if (r103 == null) goto L17;
            r102.put(r100, r103);     // Catch: Throwable -> L20
        L17:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r102);
        L20:
            th = move-exception;
            throw th;
        L23:
            return r103;
        L28:
            return null;
        L6:
            r101 = false;
            goto L7
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        f201489r = new LruCache(50);
        CREATOR = new b();
    }

    public final int hashCode() {
        return this.f201506q.hashCode();
    }

    public final String toString() {
        return this.f201506q.toString();
    }

    public LiveSchemaInfo(Uri r100) {
        this.f201506q = r100;
        this.f201490a = LazyKt.lazy(new LiveSchemaInfo$protocol$2(this));
        this.f201491b = LazyKt.lazy(new LiveSchemaInfo$host$2(this));
        this.f201492c = LazyKt.lazy(new LiveSchemaInfo$appId$2(this));
        this.f201493d = LazyKt.lazy(new LiveSchemaInfo$versionType$2(this));
        this.f201494e = LazyKt.lazy(new LiveSchemaInfo$token$2(this));
        this.f201495f = LazyKt.lazy(new LiveSchemaInfo$meta$2(this));
        this.f201496g = LazyKt.lazy(new LiveSchemaInfo$scene$2(this));
        this.f201497h = LazyKt.lazy(new LiveSchemaInfo$launchMode$2(this));
        this.f201498i = LazyKt.lazy(new LiveSchemaInfo$refererInfo$2(this));
        this.f201499j = LazyKt.lazy(new LiveSchemaInfo$bdpLog$2(this));
        this.f201500k = LazyKt.lazy(new LiveSchemaInfo$techType$2(this));
        this.f201501l = LazyKt.lazy(new LiveSchemaInfo$startPage$2(this));
        this.f201502m = LazyKt.lazy(new LiveSchemaInfo$startPagePath$2(this));
        this.f201503n = LazyKt.lazy(new LiveSchemaInfo$startPageQuery$2(this));
        this.f201504o = LazyKt.lazy(new LiveSchemaInfo$startPageQueryEncodedString$2(this));
        this.f201505p = LazyKt.lazy(new LiveSchemaInfo$inspect$2(this));
    }

    public final String b(String r100) {
        return UriProtector.getQueryParameter(this.f201506q, r100);
    L4:
        e = move-exception;
        upc.a.a(new Object[]{e});
        return null;
    }

    public final boolean equals(Object r100) {
        if (Intrinsics.areEqual(r100, this) == false) goto L7;
        return true;
    L7:
        if ((r100 instanceof LiveSchemaInfo) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.f201506q, ((LiveSchemaInfo) r100).f201506q);
    }

    public static final JSONObject a(LiveSchemaInfo r100, String r101) {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (r101 != null) goto L8;
        Intrinsics.throwNpe();     // Catch: Exception -> L11
    L8:
        return new JSONObject(r101);
    L15:
        return null;
    L14:
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f201506q, r101);
    }
}
