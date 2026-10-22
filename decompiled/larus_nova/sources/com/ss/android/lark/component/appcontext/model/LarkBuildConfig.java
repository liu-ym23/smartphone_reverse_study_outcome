package com.ss.android.lark.component.appcontext.model;

import androidx.exifinterface.media.ExifInterface;
import b8b.c;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u00104\u001a\u00020\u0003J\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003J\u001f\u00108\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u000fJ\u001b\u0010=\u001a\u0004\u0018\u0001H>\"\u0004\b\u0000\u0010>2\u0006\u0010?\u001a\u00020\u000b¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020\u000bH\u0016J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÂ\u0003¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010L\u001a\u00020\rHÆ\u0003J\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007HÂ\u0003¢\u0006\u0002\u0010NJ\t\u0010O\u001a\u00020\u000bHÆ\u0003J\t\u0010P\u001a\u00020\u0012HÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u000bHÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u001dHÆ\u0003Jè\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001¢\u0006\u0002\u0010[R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010!R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010!R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010!R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "", "debug", "", "inHouse", "isABI32", "flavors", "", "Lcom/ss/android/lark/component/appcontext/model/Flavor;", "isMiraOpen", "loginType", "", "thirdSdkKeys", "Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;", "enablePlugins", "Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "commitId", "slardarAppId", "", "veSDKVersion", "isHWComponentEnabled", "isLiteBuildMode", "alchemyProjectId", "lynxDebug", "enablePerfTools", "allValues", "", "isOfficeSDKImIntegrated", "appName", "Lcom/ss/android/lark/component/appcontext/model/AppName;", "<init>", "(ZZZ[Lcom/ss/android/lark/component/appcontext/model/Flavor;ZLjava/lang/String;Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;ZZLjava/util/Map;ZLcom/ss/android/lark/component/appcontext/model/AppName;)V", "getDebug", "()Z", "getInHouse", "[Lcom/ss/android/lark/component/appcontext/model/Flavor;", "getLoginType", "()Ljava/lang/String;", "getThirdSdkKeys", "()Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;", "[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "getCommitId", "getSlardarAppId", "()I", "getVeSDKVersion", "getAlchemyProjectId", "getLynxDebug", "getEnablePerfTools", "getAllValues", "()Ljava/util/Map;", "getAppName", "()Lcom/ss/android/lark/component/appcontext/model/AppName;", "isDebug", "isLarkApp", "isMempopeApp", "isOfficeSDK", "isFlavors", "([Lcom/ss/android/lark/component/appcontext/model/Flavor;)Z", "isUsPackage", "isPluginEnable", CloudControlInf.PLUGIN, "getValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "component1", "component2", "component3", "component4", "()[Lcom/ss/android/lark/component/appcontext/model/Flavor;", "component5", "component6", "component7", "component8", "()[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(ZZZ[Lcom/ss/android/lark/component/appcontext/model/Flavor;ZLjava/lang/String;Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;ZZLjava/util/Map;ZLcom/ss/android/lark/component/appcontext/model/AppName;)Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkBuildConfig {
    private final String alchemyProjectId;
    private final Map<String, Object> allValues;
    private final AppName appName;
    private final String commitId;
    private final boolean debug;
    private final boolean enablePerfTools;
    private final DynamicPlugins[] enablePlugins;
    private final Flavor[] flavors;
    private final boolean inHouse;
    private final boolean isABI32;
    private final boolean isHWComponentEnabled;
    private final boolean isLiteBuildMode;
    private final boolean isMiraOpen;
    private final boolean isOfficeSDKImIntegrated;
    private final String loginType;
    private final boolean lynxDebug;
    private final int slardarAppId;
    private final c thirdSdkKeys;
    private final String veSDKVersion;

    private final Flavor[] component4() {
        return this.flavors;
    }

    private final DynamicPlugins[] component8() {
        return this.enablePlugins;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkBuildConfig copy$default(LarkBuildConfig r110, boolean r111, boolean r112, boolean r210, Flavor[] r211, boolean r212, String r213, c r214, DynamicPlugins[] r215, String r216, int r217, String r218, boolean r219, boolean r310, String r311, boolean r312, boolean r313, Map r314, boolean r315, AppName r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        boolean r100 = r110.debug;
    L7:
        if ((r317 & 2) == 0) goto L9;
        boolean r101 = r110.inHouse;
    L11:
        if ((r317 & 4) == 0) goto L13;
        boolean r102 = r110.isABI32;
    L15:
        if ((r317 & 8) == 0) goto L17;
        Flavor[] r103 = r110.flavors;
    L19:
        if ((r317 & 16) == 0) goto L21;
        boolean r104 = r110.isMiraOpen;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r105 = r110.loginType;
    L27:
        if ((r317 & 64) == 0) goto L29;
        c r106 = r110.thirdSdkKeys;
    L31:
        if ((r317 & 128) == 0) goto L33;
        DynamicPlugins[] r107 = r110.enablePlugins;
    L35:
        if ((r317 & 256) == 0) goto L37;
        String r113 = r110.commitId;
    L39:
        if ((r317 & 512) == 0) goto L41;
        int r114 = r110.slardarAppId;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r115 = r110.veSDKVersion;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        boolean r116 = r110.isHWComponentEnabled;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        boolean r117 = r110.isLiteBuildMode;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.alchemyProjectId;
    L58:
        String r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        boolean r119 = r110.lynxDebug;
    L62:
        boolean r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        boolean r120 = r110.enablePerfTools;
    L66:
        boolean r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        Map r121 = r110.allValues;
    L70:
        Map r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        boolean r122 = r110.isOfficeSDKImIntegrated;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        AppName r108 = r110.appName;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
    L77:
        r108 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L75
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

    public final boolean component1() {
        return this.debug;
    }

    public final int component10() {
        return this.slardarAppId;
    }

    public final String component11() {
        return this.veSDKVersion;
    }

    public final boolean component12() {
        return this.isHWComponentEnabled;
    }

    public final boolean component13() {
        return this.isLiteBuildMode;
    }

    public final String component14() {
        return this.alchemyProjectId;
    }

    public final boolean component15() {
        return this.lynxDebug;
    }

    public final boolean component16() {
        return this.enablePerfTools;
    }

    public final Map<String, Object> component17() {
        return this.allValues;
    }

    public final boolean component18() {
        return this.isOfficeSDKImIntegrated;
    }

    public final AppName component19() {
        return this.appName;
    }

    public final boolean component2() {
        return this.inHouse;
    }

    public final boolean component3() {
        return this.isABI32;
    }

    public final boolean component5() {
        return this.isMiraOpen;
    }

    public final String component6() {
        return this.loginType;
    }

    public final c component7() {
        return this.thirdSdkKeys;
    }

    public final String component9() {
        return this.commitId;
    }

    public final LarkBuildConfig copy(boolean r210, boolean r211, boolean r212, Flavor[] r213, boolean r214, String r215, c r216, DynamicPlugins[] r217, String r310, int r311, String r312, boolean r313, boolean r314, String r315, boolean r316, boolean r317, Map<String, ? extends Object> r318, boolean r319, AppName r410) {
        Intrinsics.checkNotNullParameter(r213, "flavors");
        Intrinsics.checkNotNullParameter(r216, "thirdSdkKeys");
        Intrinsics.checkNotNullParameter(r217, "enablePlugins");
        Intrinsics.checkNotNullParameter(r310, "commitId");
        Intrinsics.checkNotNullParameter(r312, "veSDKVersion");
        Intrinsics.checkNotNullParameter(r315, "alchemyProjectId");
        Intrinsics.checkNotNullParameter(r318, "allValues");
        Intrinsics.checkNotNullParameter(r410, "appName");
        return new LarkBuildConfig(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public final boolean isUsPackage() {
        return isFlavors(new Flavor[]{Flavor.REGION_US});
    }

    public int hashCode() {
        if (this.debug == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + Arrays.hashCode(this.flavors)) * 31) + Arrays.hashCode(this.enablePlugins);
    L5:
        r100 = 1237;
        goto L7
    }

    public final boolean isLarkApp() {
        return this.appName.isLark();
    }

    public final boolean isMempopeApp() {
        return this.appName.isMempope();
    }

    public final boolean isOfficeSDK() {
        return this.appName.isOfficeSDK();
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public final String getAlchemyProjectId() {
        return this.alchemyProjectId;
    }

    public final Map<String, Object> getAllValues() {
        return this.allValues;
    }

    public final AppName getAppName() {
        return this.appName;
    }

    public final String getCommitId() {
        return this.commitId;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final boolean getEnablePerfTools() {
        return this.enablePerfTools;
    }

    public final boolean getInHouse() {
        return this.inHouse;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final boolean getLynxDebug() {
        return this.lynxDebug;
    }

    public final int getSlardarAppId() {
        return this.slardarAppId;
    }

    public final c getThirdSdkKeys() {
        return this.thirdSdkKeys;
    }

    public final String getVeSDKVersion() {
        return this.veSDKVersion;
    }

    public final boolean isABI32() {
        return this.isABI32;
    }

    public final boolean isDebug() {
        return this.debug;
    }

    public final boolean isHWComponentEnabled() {
        return this.isHWComponentEnabled;
    }

    public final boolean isLiteBuildMode() {
        return this.isLiteBuildMode;
    }

    public final boolean isMiraOpen() {
        return this.isMiraOpen;
    }

    public final boolean isOfficeSDKImIntegrated() {
        return this.isOfficeSDKImIntegrated;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(LarkBuildConfig.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.component.appcontext.model.LarkBuildConfig");
        LarkBuildConfig r102 = (LarkBuildConfig) r100;
        if (this.debug == r102.debug) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.flavors, r102.flavors) == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.enablePlugins, r102.enablePlugins) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final <T> T getValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) this.allValues.get(r100);
    }

    public final boolean isFlavors(Flavor... r100) {
        Intrinsics.checkNotNullParameter(r100, "flavors");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Flavor r103 = r100[r102];
        if (ArraysKt.contains(this.flavors, r103) == false) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public final boolean isPluginEnable(DynamicPlugins r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        return ArraysKt.contains(this.enablePlugins, r100);
    }

    public LarkBuildConfig(boolean r110, boolean r111, boolean r112, Flavor[] r113, boolean r114, String r115, c r116, DynamicPlugins[] r117, String r118, int r210, String r211, boolean r212, boolean r213, String r214, boolean r215, boolean r216, Map<String, ? extends Object> r217, boolean r218, AppName r219) {
        Intrinsics.checkNotNullParameter(r113, "flavors");
        Intrinsics.checkNotNullParameter(r116, "thirdSdkKeys");
        Intrinsics.checkNotNullParameter(r117, "enablePlugins");
        Intrinsics.checkNotNullParameter(r118, "commitId");
        Intrinsics.checkNotNullParameter(r211, "veSDKVersion");
        Intrinsics.checkNotNullParameter(r214, "alchemyProjectId");
        Intrinsics.checkNotNullParameter(r217, "allValues");
        Intrinsics.checkNotNullParameter(r219, "appName");
        this.debug = r110;
        this.inHouse = r111;
        this.isABI32 = r112;
        this.flavors = r113;
        this.isMiraOpen = r114;
        this.loginType = r115;
        this.thirdSdkKeys = r116;
        this.enablePlugins = r117;
        this.commitId = r118;
        this.slardarAppId = r210;
        this.veSDKVersion = r211;
        this.isHWComponentEnabled = r212;
        this.isLiteBuildMode = r213;
        this.alchemyProjectId = r214;
        this.lynxDebug = r215;
        this.enablePerfTools = r216;
        this.allValues = r217;
        this.isOfficeSDKImIntegrated = r218;
        this.appName = r219;
    }

    public /* synthetic */ LarkBuildConfig(boolean r210, boolean r211, boolean r212, Flavor[] r213, boolean r214, String r215, c r310, DynamicPlugins[] r311, String r312, int r313, String r314, boolean r315, boolean r316, String r317, boolean r318, boolean r319, Map r410, boolean r411, AppName r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r413 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r413 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r413 & 8) == 0) goto L17;
        Flavor[] r103 = {Flavor.REGION_CHINA, Flavor.ENV_PRODUCTION};
    L19:
        if ((r413 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r413 & 128) == 0) goto L25;
        DynamicPlugins[] r110 = new DynamicPlugins[0];
    L27:
        if ((r413 & 256) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r413 & 512) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r413 & 1024) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r413 & 2048) == 0) goto L41;
        boolean r114 = false;
    L43:
        if ((r413 & 4096) == 0) goto L45;
        boolean r115 = false;
    L47:
        if ((r413 & 8192) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r413 & 16384) == 0) goto L53;
        boolean r117 = false;
    L55:
        if ((32768 & r413) == 0) goto L57;
        boolean r118 = false;
    L59:
        if ((65536 & r413) == 0) goto L61;
        Map r216 = MapsKt.emptyMap();
    L63:
        if ((r413 & 131072) == 0) goto L65;
        boolean r217 = false;
    L66:
        this(r100, r101, r102, r103, r104, r215, r310, r110, r111, r112, r113, r114, r115, r116, r117, r118, r216, r217, r412);
        return;
    L65:
        r217 = r411;
        goto L66
    L61:
        r216 = r410;
        goto L63
    L57:
        r118 = r319;
        goto L59
    L53:
        r117 = r318;
        goto L55
    L49:
        r116 = r317;
        goto L51
    L45:
        r115 = r316;
        goto L47
    L41:
        r114 = r315;
        goto L43
    L37:
        r113 = r314;
        goto L39
    L33:
        r112 = r313;
        goto L35
    L29:
        r111 = r312;
        goto L31
    L25:
        r110 = r311;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
