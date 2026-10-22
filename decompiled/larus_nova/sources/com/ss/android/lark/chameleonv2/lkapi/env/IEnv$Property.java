package com.ss.android.lark.chameleonv2.lkapi.env;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0019\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u009d\u0002\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0005HÆ\u0001J\u0013\u0010X\u001a\u00020\u00072\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0005HÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0013\u0010\u0016\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010)R\u0013\u0010\u0017\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010)R\u0013\u0010\u0018\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010)R\u0013\u0010\u0019\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010)R\u0013\u0010\u001a\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010)R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'¨\u0006]"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "appChannel", "", "appId", "", "boeHeaderWithXUseBoe", "", "boeRPCPersistDyecpFDKey", "boeRPCPersistDyecpFDValue", "boeTTFeatureEnv", "boeUnit", "boeUseBOE", "boeWithExtraHeader", "clientUnit", "customSchema", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$CustomSchema;", "Lkotlin/collections/ArrayList;", "deployMode", "firstRunAfterInstall", "forceSaasLogin", "isDev", "isKA", "isMAS", "isOfficialRelease", "isOverseaPkg", "kaChannel", "logFilter", "logLevel", "nodeEnv", "packageName", "pasChannel", RuleConditionBean.VERSION_CODE_KEY, "<init>", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppChannel", "()Ljava/lang/String;", "getAppId", "()I", "getBoeHeaderWithXUseBoe", "()Z", "getBoeRPCPersistDyecpFDKey", "getBoeRPCPersistDyecpFDValue", "getBoeTTFeatureEnv", "getBoeUnit", "getBoeUseBOE", "getBoeWithExtraHeader", "getClientUnit", "getCustomSchema", "()Ljava/util/ArrayList;", "getDeployMode", "getFirstRunAfterInstall", "getForceSaasLogin", "getKaChannel", "getLogFilter", "getLogLevel", "getNodeEnv", "getPackageName", "getPasChannel", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IEnv$Property implements NonProguard {
    private final String appChannel;
    private final int appId;
    private final boolean boeHeaderWithXUseBoe;
    private final String boeRPCPersistDyecpFDKey;
    private final String boeRPCPersistDyecpFDValue;
    private final String boeTTFeatureEnv;
    private final String boeUnit;
    private final boolean boeUseBOE;
    private final boolean boeWithExtraHeader;
    private final String clientUnit;
    private final ArrayList<IEnv$CustomSchema> customSchema;
    private final String deployMode;
    private final boolean firstRunAfterInstall;
    private final boolean forceSaasLogin;
    private final boolean isDev;
    private final boolean isKA;
    private final boolean isMAS;
    private final boolean isOfficialRelease;
    private final boolean isOverseaPkg;
    private final String kaChannel;
    private final String logFilter;
    private final String logLevel;
    private final String nodeEnv;
    private final String packageName;
    private final String pasChannel;
    private final int versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IEnv$Property copy$default(IEnv$Property r110, String r111, int r112, boolean r210, String r211, String r212, String r213, String r214, boolean r215, boolean r216, String r217, ArrayList r218, String r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, String r317, String r318, String r319, String r410, String r411, String r412, int r413, int r414, Object r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = r110.appChannel;
    L7:
        if ((r414 & 2) == 0) goto L9;
        int r101 = r110.appId;
    L11:
        if ((r414 & 4) == 0) goto L13;
        boolean r102 = r110.boeHeaderWithXUseBoe;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = r110.boeRPCPersistDyecpFDKey;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = r110.boeRPCPersistDyecpFDValue;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = r110.boeTTFeatureEnv;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = r110.boeUnit;
    L31:
        if ((r414 & 128) == 0) goto L33;
        boolean r107 = r110.boeUseBOE;
    L35:
        if ((r414 & 256) == 0) goto L37;
        boolean r113 = r110.boeWithExtraHeader;
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r114 = r110.clientUnit;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        ArrayList r115 = r110.customSchema;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        String r116 = r110.deployMode;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        boolean r117 = r110.firstRunAfterInstall;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        boolean r118 = r110.forceSaasLogin;
    L58:
        boolean r320 = r118;
        if ((r414 & 16384) == 0) goto L61;
        boolean r119 = r110.isDev;
    L62:
        boolean r321 = r119;
        if ((r414 & 32768) == 0) goto L65;
        boolean r120 = r110.isKA;
    L66:
        boolean r322 = r120;
        if ((r414 & 65536) == 0) goto L69;
        boolean r121 = r110.isMAS;
    L70:
        boolean r323 = r121;
        if ((r414 & 131072) == 0) goto L73;
        boolean r122 = r110.isOfficialRelease;
    L74:
        boolean r324 = r122;
        if ((r414 & 262144) == 0) goto L77;
        boolean r123 = r110.isOverseaPkg;
    L78:
        boolean r325 = r123;
        if ((r414 & 524288) == 0) goto L81;
        String r124 = r110.kaChannel;
    L82:
        String r326 = r124;
        if ((r414 & 1048576) == 0) goto L85;
        String r125 = r110.logFilter;
    L86:
        String r327 = r125;
        if ((r414 & 2097152) == 0) goto L89;
        String r126 = r110.logLevel;
    L90:
        String r328 = r126;
        if ((r414 & 4194304) == 0) goto L93;
        String r127 = r110.nodeEnv;
    L94:
        String r416 = r127;
        if ((r414 & 8388608) == 0) goto L97;
        String r128 = r110.packageName;
    L98:
        String r417 = r128;
        if ((r414 & 16777216) == 0) goto L101;
        String r129 = r110.pasChannel;
    L103:
        if ((r414 & 33554432) == 0) goto L105;
        int r108 = r110.versionCode;
    L107:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r416, r417, r129, r108);
    L105:
        r108 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L103
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.appChannel;
    }

    public final String component10() {
        return this.clientUnit;
    }

    public final ArrayList<IEnv$CustomSchema> component11() {
        return this.customSchema;
    }

    public final String component12() {
        return this.deployMode;
    }

    public final boolean component13() {
        return this.firstRunAfterInstall;
    }

    public final boolean component14() {
        return this.forceSaasLogin;
    }

    public final boolean component15() {
        return this.isDev;
    }

    public final boolean component16() {
        return this.isKA;
    }

    public final boolean component17() {
        return this.isMAS;
    }

    public final boolean component18() {
        return this.isOfficialRelease;
    }

    public final boolean component19() {
        return this.isOverseaPkg;
    }

    public final int component2() {
        return this.appId;
    }

    public final String component20() {
        return this.kaChannel;
    }

    public final String component21() {
        return this.logFilter;
    }

    public final String component22() {
        return this.logLevel;
    }

    public final String component23() {
        return this.nodeEnv;
    }

    public final String component24() {
        return this.packageName;
    }

    public final String component25() {
        return this.pasChannel;
    }

    public final int component26() {
        return this.versionCode;
    }

    public final boolean component3() {
        return this.boeHeaderWithXUseBoe;
    }

    public final String component4() {
        return this.boeRPCPersistDyecpFDKey;
    }

    public final String component5() {
        return this.boeRPCPersistDyecpFDValue;
    }

    public final String component6() {
        return this.boeTTFeatureEnv;
    }

    public final String component7() {
        return this.boeUnit;
    }

    public final boolean component8() {
        return this.boeUseBOE;
    }

    public final boolean component9() {
        return this.boeWithExtraHeader;
    }

    public final IEnv$Property copy(String r310, int r311, boolean r312, String r313, String r314, String r315, String r316, boolean r317, boolean r318, String r319, ArrayList<IEnv$CustomSchema> r410, String r411, boolean r412, boolean r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, String r419, String r510, String r511, String r512, String r513, String r514, int r515) {
        Intrinsics.checkNotNullParameter(r310, "appChannel");
        Intrinsics.checkNotNullParameter(r313, "boeRPCPersistDyecpFDKey");
        Intrinsics.checkNotNullParameter(r314, "boeRPCPersistDyecpFDValue");
        Intrinsics.checkNotNullParameter(r315, "boeTTFeatureEnv");
        Intrinsics.checkNotNullParameter(r316, "boeUnit");
        Intrinsics.checkNotNullParameter(r319, "clientUnit");
        Intrinsics.checkNotNullParameter(r410, "customSchema");
        Intrinsics.checkNotNullParameter(r411, "deployMode");
        Intrinsics.checkNotNullParameter(r419, "kaChannel");
        Intrinsics.checkNotNullParameter(r510, "logFilter");
        Intrinsics.checkNotNullParameter(r511, "logLevel");
        Intrinsics.checkNotNullParameter(r512, "nodeEnv");
        Intrinsics.checkNotNullParameter(r513, "packageName");
        Intrinsics.checkNotNullParameter(r514, "pasChannel");
        return new IEnv$Property(r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IEnv$Property) == true) goto L8;
        return false;
    L8:
        IEnv$Property r101 = (IEnv$Property) r100;
        if (Intrinsics.areEqual(this.appChannel, r101.appChannel) == true) goto L12;
        return false;
    L12:
        if (this.appId == r101.appId) goto L15;
        return false;
    L15:
        if (this.boeHeaderWithXUseBoe == r101.boeHeaderWithXUseBoe) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.boeRPCPersistDyecpFDKey, r101.boeRPCPersistDyecpFDKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.boeRPCPersistDyecpFDValue, r101.boeRPCPersistDyecpFDValue) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.boeTTFeatureEnv, r101.boeTTFeatureEnv) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.boeUnit, r101.boeUnit) == true) goto L30;
        return false;
    L30:
        if (this.boeUseBOE == r101.boeUseBOE) goto L33;
        return false;
    L33:
        if (this.boeWithExtraHeader == r101.boeWithExtraHeader) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.clientUnit, r101.clientUnit) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.customSchema, r101.customSchema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.deployMode, r101.deployMode) == true) goto L45;
        return false;
    L45:
        if (this.firstRunAfterInstall == r101.firstRunAfterInstall) goto L48;
        return false;
    L48:
        if (this.forceSaasLogin == r101.forceSaasLogin) goto L51;
        return false;
    L51:
        if (this.isDev == r101.isDev) goto L54;
        return false;
    L54:
        if (this.isKA == r101.isKA) goto L57;
        return false;
    L57:
        if (this.isMAS == r101.isMAS) goto L60;
        return false;
    L60:
        if (this.isOfficialRelease == r101.isOfficialRelease) goto L63;
        return false;
    L63:
        if (this.isOverseaPkg == r101.isOverseaPkg) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.kaChannel, r101.kaChannel) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.logFilter, r101.logFilter) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.logLevel, r101.logLevel) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.nodeEnv, r101.nodeEnv) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.pasChannel, r101.pasChannel) == true) goto L84;
        return false;
    L84:
        if (this.versionCode == r101.versionCode) goto L86;
        return false;
    L86:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.appChannel.hashCode() * 31) + this.appId) * 31;
        int r101 = 1231;
        if (this.boeHeaderWithXUseBoe == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 31) + this.boeRPCPersistDyecpFDKey.hashCode()) * 31) + this.boeRPCPersistDyecpFDValue.hashCode()) * 31) + this.boeTTFeatureEnv.hashCode()) * 31) + this.boeUnit.hashCode()) * 31;
        if (this.boeUseBOE == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.boeWithExtraHeader == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((((((r105 + r106) * 31) + this.clientUnit.hashCode()) * 31) + this.customSchema.hashCode()) * 31) + this.deployMode.hashCode()) * 31;
        if (this.firstRunAfterInstall == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.forceSaasLogin == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.isDev == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.isKA == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (r113 + r114) * 31;
        if (this.isMAS == false) goto L33;
        int r116 = 1231;
    L34:
        int r117 = (r115 + r116) * 31;
        if (this.isOfficialRelease == false) goto L37;
        int r118 = 1231;
    L38:
        int r119 = (r117 + r118) * 31;
        if (this.isOverseaPkg == true) goto L43;
        r101 = 1237;
    L43:
        return ((((((((((((((r119 + r101) * 31) + this.kaChannel.hashCode()) * 31) + this.logFilter.hashCode()) * 31) + this.logLevel.hashCode()) * 31) + this.nodeEnv.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.pasChannel.hashCode()) * 31) + this.versionCode;
    L37:
        r118 = 1237;
        goto L38
    L33:
        r116 = 1237;
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "Property(appChannel=" + this.appChannel + ", appId=" + this.appId + ", boeHeaderWithXUseBoe=" + this.boeHeaderWithXUseBoe + ", boeRPCPersistDyecpFDKey=" + this.boeRPCPersistDyecpFDKey + ", boeRPCPersistDyecpFDValue=" + this.boeRPCPersistDyecpFDValue + ", boeTTFeatureEnv=" + this.boeTTFeatureEnv + ", boeUnit=" + this.boeUnit + ", boeUseBOE=" + this.boeUseBOE + ", boeWithExtraHeader=" + this.boeWithExtraHeader + ", clientUnit=" + this.clientUnit + ", customSchema=" + this.customSchema + ", deployMode=" + this.deployMode + ", firstRunAfterInstall=" + this.firstRunAfterInstall + ", forceSaasLogin=" + this.forceSaasLogin + ", isDev=" + this.isDev + ", isKA=" + this.isKA + ", isMAS=" + this.isMAS + ", isOfficialRelease=" + this.isOfficialRelease + ", isOverseaPkg=" + this.isOverseaPkg + ", kaChannel=" + this.kaChannel + ", logFilter=" + this.logFilter + ", logLevel=" + this.logLevel + ", nodeEnv=" + this.nodeEnv + ", packageName=" + this.packageName + ", pasChannel=" + this.pasChannel + ", versionCode=" + this.versionCode + ')';
    }

    public final String getAppChannel() {
        return this.appChannel;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final boolean getBoeHeaderWithXUseBoe() {
        return this.boeHeaderWithXUseBoe;
    }

    public final String getBoeRPCPersistDyecpFDKey() {
        return this.boeRPCPersistDyecpFDKey;
    }

    public final String getBoeRPCPersistDyecpFDValue() {
        return this.boeRPCPersistDyecpFDValue;
    }

    public final String getBoeTTFeatureEnv() {
        return this.boeTTFeatureEnv;
    }

    public final String getBoeUnit() {
        return this.boeUnit;
    }

    public final boolean getBoeUseBOE() {
        return this.boeUseBOE;
    }

    public final boolean getBoeWithExtraHeader() {
        return this.boeWithExtraHeader;
    }

    public final String getClientUnit() {
        return this.clientUnit;
    }

    public final ArrayList<IEnv$CustomSchema> getCustomSchema() {
        return this.customSchema;
    }

    public final String getDeployMode() {
        return this.deployMode;
    }

    public final boolean getFirstRunAfterInstall() {
        return this.firstRunAfterInstall;
    }

    public final boolean getForceSaasLogin() {
        return this.forceSaasLogin;
    }

    public final String getKaChannel() {
        return this.kaChannel;
    }

    public final String getLogFilter() {
        return this.logFilter;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }

    public final String getNodeEnv() {
        return this.nodeEnv;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPasChannel() {
        return this.pasChannel;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @JSONField(name = "isDev")
    public final boolean isDev() {
        return this.isDev;
    }

    @JSONField(name = "isKA")
    public final boolean isKA() {
        return this.isKA;
    }

    @JSONField(name = "isMAS")
    public final boolean isMAS() {
        return this.isMAS;
    }

    @JSONField(name = "isOfficialRelease")
    public final boolean isOfficialRelease() {
        return this.isOfficialRelease;
    }

    @JSONField(name = "isOverseaPkg")
    public final boolean isOverseaPkg() {
        return this.isOverseaPkg;
    }

    public IEnv$Property(String r110, int r111, boolean r112, String r210, String r211, String r212, String r213, boolean r214, boolean r215, String r216, ArrayList<IEnv$CustomSchema> r217, String r218, boolean r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, String r316, String r317, String r318, String r319, String r410, String r411, int r412) {
        Intrinsics.checkNotNullParameter(r110, "appChannel");
        Intrinsics.checkNotNullParameter(r210, "boeRPCPersistDyecpFDKey");
        Intrinsics.checkNotNullParameter(r211, "boeRPCPersistDyecpFDValue");
        Intrinsics.checkNotNullParameter(r212, "boeTTFeatureEnv");
        Intrinsics.checkNotNullParameter(r213, "boeUnit");
        Intrinsics.checkNotNullParameter(r216, "clientUnit");
        Intrinsics.checkNotNullParameter(r217, "customSchema");
        Intrinsics.checkNotNullParameter(r218, "deployMode");
        Intrinsics.checkNotNullParameter(r316, "kaChannel");
        Intrinsics.checkNotNullParameter(r317, "logFilter");
        Intrinsics.checkNotNullParameter(r318, "logLevel");
        Intrinsics.checkNotNullParameter(r319, "nodeEnv");
        Intrinsics.checkNotNullParameter(r410, "packageName");
        Intrinsics.checkNotNullParameter(r411, "pasChannel");
        this.appChannel = r110;
        this.appId = r111;
        this.boeHeaderWithXUseBoe = r112;
        this.boeRPCPersistDyecpFDKey = r210;
        this.boeRPCPersistDyecpFDValue = r211;
        this.boeTTFeatureEnv = r212;
        this.boeUnit = r213;
        this.boeUseBOE = r214;
        this.boeWithExtraHeader = r215;
        this.clientUnit = r216;
        this.customSchema = r217;
        this.deployMode = r218;
        this.firstRunAfterInstall = r219;
        this.forceSaasLogin = r310;
        this.isDev = r311;
        this.isKA = r312;
        this.isMAS = r313;
        this.isOfficialRelease = r314;
        this.isOverseaPkg = r315;
        this.kaChannel = r316;
        this.logFilter = r317;
        this.logLevel = r318;
        this.nodeEnv = r319;
        this.packageName = r410;
        this.pasChannel = r411;
        this.versionCode = r412;
    }
}
