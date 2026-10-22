package com.bytedance.bdp.bdpbase.schema;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.bdpbase.core.IBasicGetApiService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.service.interaction.game.BdpInteractionGameService;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.tencent.connect.common.Constants;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo;", "Landroid/os/Parcelable;", "Animation", "BdpsumCheckResult", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "Host", "LaunchFromCheckResult", "LaunchMode", "LocationCheckResult", "SceneCheckResult", "TTidCheckResult", "VersionType", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
public final class SchemaInfo implements Parcelable {
    public static final JSONObject B = null;
    public static final Set<String> C = null;
    public static final Parcelable.Creator<SchemaInfo> CREATOR = null;
    public static final LruCache<String, SchemaInfo> D = null;
    public static final HashSet<String> E = null;
    public static final HashSet<String> F = null;
    public static final c G = null;
    public final Uri A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Host f201272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f201273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f201274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f201275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f201276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f201277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f201278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f201279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f201280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f201281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f201282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f201283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f201284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f201285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f201286o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f201287p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f201288q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f201289r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f201290s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f201291t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f201292u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f201293v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f201294w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f201295x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f201296y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f201297z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$Animation;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "VERTICAL", "LEVEL", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Animation extends Enum<Animation> {
        public static final Animation LEVEL = null;
        public static final Animation VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Animation[] f201298a = null;
        private final String value;

        static {
            Animation r100 = new Animation("VERTICAL", 0, "vertical");
            VERTICAL = r100;
            Animation r101 = new Animation("LEVEL", 1, "level");
            LEVEL = r101;
            f201298a = new Animation[]{r100, r101};
        }

        public static Animation valueOf(String r100) {
            return (Animation) r27.a.a(Animation.class, r100);
        }

        public static Animation[] values() {
            return (Animation[]) f201298a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Animation(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$BdpsumCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, UserProfileEvent.POSITION_NONE, "ERROR", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum BdpsumCheckResult extends Enum<BdpsumCheckResult> {
        public static final BdpsumCheckResult ERROR = null;
        public static final BdpsumCheckResult NONE = null;
        public static final BdpsumCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpsumCheckResult[] f201299a = null;
        private final String value;

        static {
            BdpsumCheckResult r100 = new BdpsumCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            BdpsumCheckResult r101 = new BdpsumCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            BdpsumCheckResult r102 = new BdpsumCheckResult("ERROR", 2, "error");
            ERROR = r102;
            f201299a = new BdpsumCheckResult[]{r100, r101, r102};
        }

        public static BdpsumCheckResult valueOf(String r100) {
            return (BdpsumCheckResult) r27.a.a(BdpsumCheckResult.class, r100);
        }

        public static BdpsumCheckResult[] values() {
            return (BdpsumCheckResult[]) f201299a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public BdpsumCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$Host;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MICROAPP", "MICROGAME", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Host extends Enum<Host> {
        public static final a Companion = null;
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Host[] f201300a = null;
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
            f201300a = new Host[]{r100, r101};
            Companion = new a();
        }

        public static Host valueOf(String r100) {
            return (Host) r27.a.a(Host.class, r100);
        }

        public static Host[] values() {
            return (Host[]) f201300a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Host(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$LaunchFromCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum LaunchFromCheckResult extends Enum<LaunchFromCheckResult> {
        public static final LaunchFromCheckResult BOTH = null;
        public static final LaunchFromCheckResult INNER = null;
        public static final LaunchFromCheckResult NEITHER = null;
        public static final LaunchFromCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchFromCheckResult[] f201301a = null;
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
            f201301a = new LaunchFromCheckResult[]{r100, r101, r102, r103};
        }

        public static LaunchFromCheckResult valueOf(String r100) {
            return (LaunchFromCheckResult) r27.a.a(LaunchFromCheckResult.class, r100);
        }

        public static LaunchFromCheckResult[] values() {
            return (LaunchFromCheckResult[]) f201301a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public LaunchFromCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$LaunchMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HOST_STACK", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final a Companion = null;
        public static final LaunchMode HOST_STACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchMode[] f201302a = null;
        private final String mode;

        public static final class a {
            public a() {
            }
        }

        static {
            LaunchMode r100 = new LaunchMode();
            HOST_STACK = r100;
            f201302a = new LaunchMode[]{r100};
            Companion = new a();
        }

        public static LaunchMode valueOf(String r100) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r100);
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) f201302a.clone();
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public final String getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$LocationCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum LocationCheckResult extends Enum<LocationCheckResult> {
        public static final LocationCheckResult BOTH = null;
        public static final LocationCheckResult INNER = null;
        public static final LocationCheckResult NEITHER = null;
        public static final LocationCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LocationCheckResult[] f201303a = null;
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
            f201303a = new LocationCheckResult[]{r100, r101, r102, r103};
        }

        public static LocationCheckResult valueOf(String r100) {
            return (LocationCheckResult) r27.a.a(LocationCheckResult.class, r100);
        }

        public static LocationCheckResult[] values() {
            return (LocationCheckResult[]) f201303a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public LocationCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$SceneCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, UserProfileEvent.POSITION_NONE, "DEFAULT", "DOUYIN_PREFIX", "HUOSOON_PREFIX", "DOUYINLITE_PREFIX", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum SceneCheckResult extends Enum<SceneCheckResult> {
        public static final SceneCheckResult DEFAULT = null;
        public static final SceneCheckResult DOUYINLITE_PREFIX = null;
        public static final SceneCheckResult DOUYIN_PREFIX = null;
        public static final SceneCheckResult HUOSOON_PREFIX = null;
        public static final SceneCheckResult NONE = null;
        public static final SceneCheckResult NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneCheckResult[] f201304a = null;
        private final String value;

        static {
            SceneCheckResult r100 = new SceneCheckResult(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            SceneCheckResult r101 = new SceneCheckResult(UserProfileEvent.POSITION_NONE, 1, "none");
            NONE = r101;
            SceneCheckResult r102 = new SceneCheckResult("DEFAULT", 2, "0");
            DEFAULT = r102;
            SceneCheckResult r103 = new SceneCheckResult("DOUYIN_PREFIX", 3, "02");
            DOUYIN_PREFIX = r103;
            SceneCheckResult r104 = new SceneCheckResult("HUOSOON_PREFIX", 4, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            HUOSOON_PREFIX = r104;
            SceneCheckResult r105 = new SceneCheckResult("DOUYINLITE_PREFIX", 5, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            DOUYINLITE_PREFIX = r105;
            f201304a = new SceneCheckResult[]{r100, r101, r102, r103, r104, r105};
        }

        public static SceneCheckResult valueOf(String r100) {
            return (SceneCheckResult) r27.a.a(SceneCheckResult.class, r100);
        }

        public static SceneCheckResult[] values() {
            return (SceneCheckResult[]) f201304a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public SceneCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$TTidCheckResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INNER", "OUTER", "BOTH", "NEITHER", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum TTidCheckResult extends Enum<TTidCheckResult> {
        public static final TTidCheckResult BOTH = null;
        public static final TTidCheckResult INNER = null;
        public static final TTidCheckResult NEITHER = null;
        public static final TTidCheckResult OUTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TTidCheckResult[] f201305a = null;
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
            f201305a = new TTidCheckResult[]{r100, r101, r102, r103};
        }

        public static TTidCheckResult valueOf(String r100) {
            return (TTidCheckResult) r27.a.a(TTidCheckResult.class, r100);
        }

        public static TTidCheckResult[] values() {
            return (TTidCheckResult[]) f201305a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public TTidCheckResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/bdpbase/schema/SchemaInfo$VersionType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "current", "latest", "audit", "preview", AppConstants.CHANNEL_LOCAL_DEV, "gray", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
    public static final enum VersionType extends Enum<VersionType> {
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionType[] f201306a = null;
        public static final VersionType audit = null;
        public static final VersionType current = null;
        public static final VersionType gray = null;
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
            VersionType r105 = new VersionType("gray", 5);
            gray = r105;
            f201306a = new VersionType[]{r100, r101, r102, r103, r104, r105};
            Companion = new a();
        }

        public static VersionType valueOf(String r100) {
            return (VersionType) r27.a.a(VersionType.class, r100);
        }

        public static VersionType[] values() {
            return (VersionType[]) f201306a.clone();
        }

        public VersionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f201307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f201308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Host f201309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f201310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public JSONObject f201311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSONObject f201312f;

        public final SchemaInfo a() throws Exception {
            if (this.f201310d != null) goto L9;
            String r100 = this.f201307a.get("bdp_log");
            if (r100 == null) goto L9;
            this.f201310d = new JSONObject(r100);     // Catch: JSONException -> L106
        L7:
            Unit r101 = Unit.INSTANCE;
        L9:
            if (this.f201311e != null) goto L15;
            String r102 = this.f201307a.get("url");
            if (r102 == null) goto L15;
            this.f201311e = new JSONObject(r102);     // Catch: JSONException -> L107
        L13:
            Unit r103 = Unit.INSTANCE;
        L15:
            if (this.f201312f != null) goto L21;
            String r104 = this.f201307a.get("extra");
            if (r104 == null) goto L21;
            this.f201312f = new JSONObject(r104);     // Catch: JSONException -> L108
        L19:
            Unit r105 = Unit.INSTANCE;
        L21:
            if (this.f201308b.length() != 0) goto L23;
            boolean r106 = true;
        L24:
            if (r106 == false) goto L26;
            this.f201308b = AppConstants.SCHEME_SS_LOCAL;
        L26:
            String r107 = this.f201307a.get("app_id");
            if (TextUtils.isEmpty(r107) == true) goto L31;
            if (r107 != null) goto L30;
            Intrinsics.throwNpe();
        L30:
            StringsKt.startsWith$default(r107, "tt", false, 2, null);
        L31:
            String r108 = this.f201307a.get("start_page");
            Host r110 = this.f201309c;
            Host r111 = Host.MICROGAME;
            if (r110 != r111) goto L34;
            r108 = null;
        L34:
            if (r108 == null) goto L36;
            StringsKt.startsWith$default(r108, HTTP.URL_DEFAULT, false, 2, null);
        L36:
            VersionType.a r112 = VersionType.Companion;
            String r113 = this.f201307a.get("version_type");
            r112.getClass();
            VersionType[] r114 = VersionType.values();
            int r109 = r114.length;
            int r115 = 0;
        L37:
            if (r115 >= r109) goto L42;
            VersionType r116 = r114[r115];
            if (StringsKt.equals(r116.name(), r113, true) == true) goto L43;
            r115 = r115 + 1;
        L43:
            if (r116 != null) goto L45;
            r116 = VersionType.current;
        L45:
            VersionType r117 = r116;
            String r118 = this.f201307a.get("version");
            if (TextUtils.isEmpty(r118) == false) goto L48;
            r118 = "v2";
        L48:
            String r119 = this.f201307a.get("scene");
            if (TextUtils.isEmpty(r119) == false) goto L52;
            r119 = "0";
        L52:
            if (r117 == VersionType.preview) goto L57;
            if (r117 == VersionType.local_dev) goto L57;
            this.f201307a.remove(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);
        L57:
            String r120 = this.f201307a.get("token");
            JSONObject r121 = this.f201310d;
            String r122 = r118;
            if (r121 == null) goto L61;
            r121.optString("launch_from");
        L61:
            if (this.f201309c != r111) goto L65;
            BdpInteractionGameService r123 = (BdpInteractionGameService) BdpManager.getInst().getService(BdpInteractionGameService.class);
            if (r123 == null) goto L65;
            r123.s();
        L65:
            Uri.Builder r124 = new Uri.Builder().scheme(this.f201308b).authority(this.f201309c.getValue()).appendQueryParameter("app_id", r107);
            JSONObject r125 = this.f201310d;
            if (r125 == null) goto L68;
            SchemaInfo.G.getClass();
            r124.appendQueryParameter("bdp_log", c.b(r125));
        L68:
            JSONObject r126 = this.f201311e;
            if (r126 == null) goto L71;
            SchemaInfo.G.getClass();
            r124.appendQueryParameter("url", c.b(r126));
        L71:
            JSONObject r127 = this.f201312f;
            if (r127 == null) goto L74;
            SchemaInfo.G.getClass();
            r124.appendQueryParameter("extra", c.b(r127));
        L74:
            Set<String> r128 = SchemaInfo.C;
            Iterator<Map.Entry<String, String>> r129 = this.f201307a.entrySet().iterator();
        L76:
            if (r129.hasNext() == false) goto L80;
            Map.Entry<String, String> r130 = r129.next();
            if (r128.contains(r130.getKey()) == true) goto L76;
            r124.appendQueryParameter(r130.getKey(), r130.getValue());
            goto L76
        L80:
            r124.appendQueryParameter("scene", r119);
            if (r120 != null) goto L83;
        L89:
            if (r108 == null) goto L91;
            r124.appendQueryParameter("start_page", r108);
        L91:
            r124.appendQueryParameter("version", r122);
            r124.appendQueryParameter("version_type", r117.name());
            int r131 = com.bytedance.bdp.bdpbase.schema.a.f201313a;
            String r132 = r124.toString();
            if (TextUtils.isEmpty(r132) == false) goto L95;
        L103:
            String r133 = "";
        L104:
            r124.appendQueryParameter(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM, r133);
            return new SchemaInfo(r124.build());
        L95:
            if (StringsKt.contains$default(r132, "://", false, 2, null) == false) goto L100;
            String[] r134 = (String[]) StringsKt.split$default(r132, new String[]{"://"}, false, 0, 6, null).toArray(new String[0]);
            if (r134.length < 2) goto L103;
            r132 = r134[1];
        L100:
            String r135 = com.bytedance.bdp.bdpbase.util.a.c(r132.substring(0, 10) + AppbrandHostConstants.Schema_BDP_SUM.MD5_SALT + r132.substring(10));
            if (TextUtils.isEmpty(r135) == true) goto L103;
            r133 = r135.substring(2, 6) + r135.substring(20, 23);
            goto L104
        L83:
            if (r120.length() <= 0) goto L85;
            boolean r136 = true;
        L87:
            if (r136 != true) goto L89;
            r124.appendQueryParameter("token", r120);
            goto L89
        L85:
            r136 = false;
            goto L87
        L42:
            r116 = null;
            goto L43
        L23:
            r106 = false;
            goto L24
        }

        public a(String r110) {
            String r100 = "";
            if (r110 != null) goto L5;
            r110 = "";
        L5:
            Uri r111 = UriProtector.parse(r110);
            c r101 = SchemaInfo.G;
            r101.getClass();
            JSONObject r102 = null;
            if (r111 == null) goto L11;
            String r103 = r111.getEncodedQuery();
            if (r103 == null) goto L11;
            LinkedHashMap<String, String> r104 = c.c(r103);
        L12:
            if (r104 != null) goto L14;
            r104 = new LinkedHashMap();
        L14:
            this.f201307a = r104;
            if (r111 == null) goto L18;
            String r105 = r111.getScheme();
            if (r105 == null) goto L18;
        L19:
            this.f201308b = r105;
            Host.a r106 = Host.Companion;
            if (r111 == null) goto L22;
            String r112 = r111.getAuthority();
        L23:
            r106.getClass();
            Host[] r107 = Host.values();
            int r108 = r107.length;
            boolean r109 = false;
            int r113 = 0;
        L25:
            if (r113 >= r108) goto L30;
            Host r114 = r107[r113];
            if (StringsKt.equals(r114.getValue(), r112, true) == true) goto L31;
            r113 = r113 + 1;
        L31:
            if (r114 != null) goto L33;
            r114 = Host.MICROAPP;
        L33:
            this.f201309c = r114;
            String r115 = r104.get("bdp_log");
            if (r115 == null) goto L36;
            JSONObject r116 = c.a(r101, r115);
        L37:
            this.f201310d = r116;
            String r117 = r104.get("url");
            if (r117 == null) goto L40;
            JSONObject r118 = c.a(r101, r117);
        L41:
            this.f201311e = r118;
            String r119 = r104.get("extra");
            if (r119 == null) goto L44;
            r102 = new JSONObject(r119);
        L44:
            this.f201312f = r102;
            String r120 = r104.get("scene");
            if (r120 == null) goto L48;
            r100 = c.d(r120);
        L48:
            if (r100.length() <= 0) goto L50;
            r109 = true;
        L50:
            if (r109 == false) goto L55;
            r104.put("scene", r100);
            return;
        L55:
            return;
        L40:
            r118 = null;
            goto L41
        L36:
            r116 = null;
            goto L37
        L30:
            r114 = null;
            goto L31
        L22:
            r112 = null;
        L18:
            r105 = AppConstants.SCHEME_SS_LOCAL;
        L11:
            r104 = null;
            goto L12
        }

        public final a query(JSONObject r100) {
            LinkedHashMap<String, String> r101 = this.f201307a;
            SchemaInfo.G.getClass();
            r101.put("query", c.b(r100));
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<SchemaInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final SchemaInfo createFromParcel(Parcel r100) {
            Parcelable r101 = r100.readParcelable(Uri.class.getClassLoader());
            if (r101 != null) goto L6;
            Intrinsics.throwNpe();
        L6:
            return new SchemaInfo((Uri) r101);
        }

        @Override // android.os.Parcelable.Creator
        public final SchemaInfo[] newArray(int r100) {
            return new SchemaInfo[r100];
        }
    }

    public static final class c {
        public c() {
        }

        public static String b(JSONObject r100) {
            if (r100 != null) goto L6;
            return "";
        L6:
            return StringsKt.replace$default(r100.toString(), "\\/", HTTP.URL_DEFAULT, false, 4, null);
        }

        public static LinkedHashMap c(String r110) {
            if (r110.length() != 0) goto L5;
            boolean r100 = true;
        L7:
            if (r100 == false) goto L22;
            return null;
        L22:
            LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L19
            Iterator<String> r111 = new Regex("&").split(r110, 0).iterator();     // Catch: Throwable -> L19
        L10:
            if (r111.hasNext() == false) goto L18;
            String r102 = r111.next();     // Catch: Throwable -> L19
            int r103 = StringsKt.indexOf$default(r102, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);     // Catch: Throwable -> L19
            if (r103 >= 0) goto L15;
            r101.put(URLDecoder.decode(r102, "UTF-8"), "");     // Catch: Throwable -> L19
            goto L10
        L15:
            r101.put(URLDecoder.decode(r102.substring(0, r103), "UTF-8"), URLDecoder.decode(r102.substring(r103 + 1), "UTF-8"));     // Catch: Throwable -> L19
            goto L10
        L18:
            return r101;
        L19:
            th = move-exception;
            upc.a.a(new Object[]{th});
            return null;
        L5:
            r100 = false;
            goto L7
        }

        @JvmStatic
        public static String d(String r100) {
            if (((IBasicGetApiService) BdpManager.getInst().getService(IBasicGetApiService.class)).O1() == false) goto L8;
            SceneCheckResult r101 = SceneCheckResult.DOUYIN_PREFIX;
            if (StringsKt.startsWith$default(r100, r101.getValue(), false, 2, null) == true) goto L14;
            return r100;
        L14:
            return SceneCheckResult.HUOSOON_PREFIX.getValue() + StringsKt.removePrefix(r100, r101.getValue());
        L8:
            if (((IBasicGetApiService) BdpManager.getInst().getService(IBasicGetApiService.class)).a2() == false) goto L15;
            SceneCheckResult r102 = SceneCheckResult.DOUYIN_PREFIX;
            if (StringsKt.startsWith$default(r100, r102.getValue(), false, 2, null) == true) goto L12;
            return r100;
        L12:
            return SceneCheckResult.DOUYINLITE_PREFIX.getValue() + StringsKt.removePrefix(r100, r102.getValue());
        L15:
            return r100;
        }

        public static final JSONObject a(c r100, String r101) {
            r100.getClass();
            if (TextUtils.isEmpty(r101) == false) goto L13;
        L10:
            return null;
        L13:
            if (r101 != null) goto L8;
            Intrinsics.throwNpe();     // Catch: Exception -> L12
        L8:
            return new JSONObject(r101);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int o() {
        return ((Number) this.f201282k.getValue()).intValue();
    }

    public final VersionType q() {
        return (VersionType) this.f201274c.getValue();
    }

    static {
        G = new c();
        B = new JSONObject();
        C = SetsKt.setOf(new String[]{"start_page", "token", "version_type", "version", "scene", "app_id", "bdp_log", "url", AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM, "extra"});
        D = new LruCache(50);
        CREATOR = new b();
        E = SetsKt.hashSetOf(new String[]{"ttc9b5bf08568f9ab2", "tt28f55e48b7ce0cb6"});
        F = SetsKt.hashSetOf(new String[]{"tta8e5de5837cfcdb1", "tt9a4aecf7057074ae", "tt9ef0e84d01caffc2", "tte11397ae7e29bfb9", "ttc3efb5525cd59c67", "tt55e42359cade21b0", "tt8061f6dc1f5a2fab", "tt73ae0513ec84350a", "ttb74dc1f028767642", "tt474e31f3d875864e", "tt548f2232cbb4a42c", "tt657413c9fa4f9510", "ttd234a4894d0f218f", "tt65ab1316fa9095bf", "tt75ac0311ea9785b9", "tt25a7531aba9cd5af", "tt35b84305aa83c5b1", "tt45b43309da8fb5b6", "tt8107f7ba1e3c4b0a", "ttb9b7cf0a268c7f27", "ttb74dc1f028767642", "tt474e31f3d875864e", "tt1a0a6cb78531ce0e", "tt700406b9ef3fa3d5", "tt525e24e3cd657323", "tt63ad1510fc87250e", "tt04af72129b94a6af", "ttbb93cd2e24a9c0c0", "ttecd19a6c73eacef7", "ttc1a2b71f5e99ea67", "tt28f25e4fb7c90776", "ttc10db7b05e361b9a", "ttc181b73c5eba1ad6", "tt41883735deb36a55"});
    }

    public final String a() {
        String r100 = this.f201273b;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        String r102 = String.valueOf(c("app_id"));
        this.f201273b = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final JSONObject b() {
        JSONObject r100 = this.f201280i;
        if (r100 == B) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        JSONObject r102 = c.a(G, c("bdp_log"));
        this.f201280i = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String d() {
        String r100 = this.f201291t;
        boolean r101 = true;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r102 = true;
    L6:
        String r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L25;
        JSONObject r104 = b();
        if (r104 == null) goto L14;
        r103 = r104.optString("entrance_form");
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r101 == true) goto L21;
        r100 = r103;
    L24:
        this.f201291t = r100;
        goto L25
    L21:
        r100 = c("entrance_form");
        if (r100 != null) goto L24;
        r100 = "";
        goto L24
    L16:
        if (r103.length() == 0) goto L19;
        r101 = false;
    L25:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public final String g() {
        String r100 = this.f201290s;
        boolean r101 = true;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r102 = true;
    L6:
        String r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L25;
        JSONObject r104 = b();
        if (r104 == null) goto L14;
        r103 = r104.optString("launch_from");
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r101 == true) goto L21;
        r100 = r103;
    L24:
        this.f201290s = r100;
        goto L25
    L21:
        r100 = c("launch_from");
        if (r100 != null) goto L24;
        r100 = "";
        goto L24
    L16:
        if (r103.length() == 0) goto L19;
        r101 = false;
    L25:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public final String h() {
        String r100 = this.f201289r;
        String r101 = null;
        if ((!Intrinsics.areEqual(r100, "UNINITIALIZED_STRING")) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L21;
        JSONObject r102 = i();
        if (r102 == null) goto L19;
        String r103 = r102.optString("ad_params");
        if (r103 == null) goto L19;
        if (TextUtils.isEmpty(r103) == false) goto L14;
        r101 = r103;
        goto L19
    L14:
        JSONObject r104 = c.a(G, URLDecoder.decode(r103, "UTF-8"));
        if (r104 == null) goto L19;
        JSONObject r105 = r104.optJSONObject("log_extra");
        if (r105 == null) goto L19;
        r101 = r105.optString(BdpAppEventConstant.PARAMS_ORIT);
    L19:
        this.f201289r = r101;
        return r101;
    L21:
        return r100;
    }

    public final int hashCode() {
        return this.A.hashCode();
    }

    public final JSONObject i() {
        JSONObject r100 = this.f201287p;
        if (r100 == B) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        JSONObject r102 = c.a(G, c("query"));
        this.f201287p = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String j() {
        String r100 = this.f201288q;
        String r101 = null;
        if ((!Intrinsics.areEqual(r100, "UNINITIALIZED_STRING")) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L21;
        JSONObject r102 = i();
        if (r102 == null) goto L19;
        String r103 = r102.optString("ad_params");
        if (r103 == null) goto L19;
        if (TextUtils.isEmpty(r103) == false) goto L14;
        r101 = r103;
        goto L19
    L14:
        JSONObject r104 = c.a(G, URLDecoder.decode(r103, "UTF-8"));
        if (r104 == null) goto L19;
        JSONObject r105 = r104.optJSONObject("log_extra");
        if (r105 == null) goto L19;
        r101 = r105.optString(BdpAppEventConstant.PARAMS_RIT);
    L19:
        this.f201288q = r101;
        return r101;
    L21:
        return r100;
    }

    public final String k() {
        String r100 = this.f201276e;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        String r102 = String.valueOf(c("scene"));
        this.f201276e = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String s() {
        if (((Boolean) this.f201296y.getValue()).booleanValue() == false) goto L7;
        return (String) this.f201297z.getValue();
    L7:
        return this.A.toString();
    }

    public final String toString() {
        return this.A.toString();
    }

    public final Host e() {
        return this.f201272a;
    }

    public SchemaInfo(Uri r100) {
        this.A = r100;
        if (TextUtils.isEmpty(r100.getScheme()) == false) goto L6;
    L8:
        Host.a r101 = Host.Companion;
        String r102 = r100.getHost();
        r101.getClass();
        Host[] r103 = Host.values();
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L10:
        if (r106 >= r104) goto L15;
        Host r107 = r103[r106];
        if (StringsKt.equals(r107.getValue(), r102, true) == true) goto L16;
        r106 = r106 + 1;
    L16:
        if (r107 != null) goto L18;
        r107 = Host.MICROAPP;
    L18:
        this.f201272a = r107;
        this.f201273b = "UNINITIALIZED_STRING";
        Function0<VersionType> r108 = new SchemaInfo$versionType$2(this);
        LazyThreadSafetyMode r109 = LazyThreadSafetyMode.PUBLICATION;
        this.f201274c = LazyKt.lazy(r109, r108);
        JSONObject r110 = B;
        this.f201275d = r110;
        this.f201276e = "UNINITIALIZED_STRING";
        this.f201277f = LazyKt.lazy(new SchemaInfo$subScene$2(this));
        this.f201278g = LazyKt.lazy(new SchemaInfo$shareTicket$2(this));
        this.f201279h = LazyKt.lazy(r109, new SchemaInfo$launchMode$2(this));
        this.f201280i = r110;
        if (Host.MICROGAME != r107) goto L22;
        r105 = 2;
    L24:
        this.f201281j = r105;
        this.f201282k = LazyKt.lazy(r109, new SchemaInfo$techType$2(this));
        this.f201283l = LazyKt.lazy(r109, new SchemaInfo$mpType$2(this));
        this.f201284m = "UNINITIALIZED_STRING";
        this.f201285n = LazyKt.lazy(r109, new SchemaInfo$startPageQuery$2(this));
        this.f201286o = "UNINITIALIZED_STRING";
        this.f201287p = r110;
        this.f201288q = "UNINITIALIZED_STRING";
        this.f201289r = "UNINITIALIZED_STRING";
        this.f201290s = "UNINITIALIZED_STRING";
        this.f201291t = "UNINITIALIZED_STRING";
        this.f201292u = "UNINITIALIZED_STRING";
        this.f201293v = "UNINITIALIZED_STRING";
        this.f201294w = LazyKt.lazy(r109, new SchemaInfo$bdpMiniAppVersion$2(this));
        this.f201295x = LazyKt.lazy(SchemaInfo$customFieldMap$2.INSTANCE);
        this.f201296y = LazyKt.lazy(SchemaInfo$isOpt$2.INSTANCE);
        this.f201297z = LazyKt.lazy(new SchemaInfo$uriStr$2(this));
        return;
    L22:
        if (Host.MICROAPP != r107) goto L24;
        r105 = 1;
        goto L24
    L15:
        r107 = null;
        goto L16
    L6:
        if (r100.getScheme() != null) goto L8;
        Intrinsics.throwNpe();
        goto L8
    }

    @JvmStatic
    public static final SchemaInfo r(String r100) {
        G.getClass();
        SchemaInfo r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L35;
        LruCache<String, SchemaInfo> r103 = D;
        SchemaInfo r104 = r103.get(r100);
        if (r104 != null) goto L29;
        monitor-enter(r103);
        SchemaInfo r105 = r103.get(r100);     // Catch: Throwable -> L25
        if (r105 == null) goto L32;
        r101 = r105;
    L20:
        if (r101 == null) goto L22;
        r103.put(r100, r101);     // Catch: Throwable -> L25
    L22:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r103);
        return r101;
    L32:
        r101 = new a(r100).a();     // Catch: Exception -> L18 Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L29:
        return r104;
    L35:
        return null;
    L7:
        r102 = false;
        goto L8
    }

    public final String c(String r100) {
        if (((Map) this.f201295x.getValue()).containsKey(r100) == true) goto L5;
        String r101 = UriProtector.getQueryParameter(this.A, r100);     // Catch: Exception -> L8
        ((Map) this.f201295x.getValue()).put(r100, r101);     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        upc.a.a(new Object[]{e});
        return null;
    L5:
        return (String) ((Map) this.f201295x.getValue()).get(r100);
    }

    public final boolean equals(Object r100) {
        if (Intrinsics.areEqual(r100, this) == false) goto L7;
        return true;
    L7:
        if ((r100 instanceof SchemaInfo) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.A, ((SchemaInfo) r100).A);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.A, r101);
    }
}
