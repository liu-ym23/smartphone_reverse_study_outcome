package com.obric.assistant;

import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.obric.assistant.settings.config.ModelSettingsConfig;
import com.obric.assistant.settings.config.ObricImageUploadCompressConfig;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import com.obric.assistant.settings.voiceprint.g;
import com.obric.assistant.settings.voiceprint.v;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.obric.performance.power.monitor.cpu.exception.CPUExceptionDiagnosisConfig;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class t1 implements IObricSettingsApi {
    public static final t1 a = null;
    public static final Lazy b = null;

    public t1() {
    }

    static {
        a = new t1();
        b = LazyKt.lazy(new s1());
    }

    public static IObricSettingsApi X1() {
        return (IObricSettingsApi) b.getValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void A0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.A0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int A1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.A1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean B() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.B();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean D1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.D1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void E0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.E0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long E1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.E1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long G() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.G();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean G0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.G0() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final boolean G1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.G1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int H() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.H();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean I() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.I();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final SecuritySettingsConfig I0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        SecuritySettingsConfig r1 = r0.I0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new SecuritySettingsConfig(false, false, false, false, 0, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean I1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return !r1;
    L5:
        if (r0.I1() == true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean J0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.J0() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void J1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.J1();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean K0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.K0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean K1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.K1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String L() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.L();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final UpdateSettingsConfig L0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        UpdateSettingsConfig r1 = r0.L0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new UpdateSettingsConfig(0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int M() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.M();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean N() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.N();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricThresholdPssUploadFilesConfig N0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricThresholdPssUploadFilesConfig r1 = r0.N0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricThresholdPssUploadFilesConfig(false, 0, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long N1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.N1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @RiskPreferenceSettings
    public final String O() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.O();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "2";
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int O0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.O0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean P() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.P();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean P0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.P0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String Q() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.Q();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "claude-37";
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean Q0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.Q0() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int Q1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.Q1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean R1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.R1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final JsonObject S() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.S();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean S1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.S1() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean T() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.T();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int T0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.T0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.U();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean V1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.V1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int W() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.W();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void W0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.W0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean W1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.W1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void X0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.X0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean Y() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.Y() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ModelSettingsConfig Y0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ModelSettingsConfig r1 = r0.Y0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ModelSettingsConfig(0, false, null, null, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String Z() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.Z();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = Y0().getDefaultModel().getKey();
        if (r2 != null) goto L11;
        return XmlPullParser.NO_NAMESPACE;
    L11:
        return r2;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long Z0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.Z0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final BreathWakeupDataTrackerConfig a0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void a1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.a1();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean b() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void b0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.b0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void b1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.b1();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean c() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean c0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c0() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean d() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String d0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L5;
        String r1 = r0.d0();
    L6:
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int d1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int e0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.e0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int e1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean enableObricSettingsOverride() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.enableObricSettingsOverride();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String f0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.f0();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "planexecute";
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void g() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean g0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.g0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Map<String, String> getAutoExecuteAuthorizationStatusMap() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L5;
        Map<String, String> r1 = r0.getAutoExecuteAuthorizationStatusMap();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return MapsKt.emptyMap();
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getAutoGuiEnabledScene() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.getAutoGuiEnabledScene();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String getAutoGuiFastModeUseSettings() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.getAutoGuiFastModeUseSettings();
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = ObricTaskSkillDelegate.b.i();
        if (r2 != null) goto L11;
        return XmlPullParser.NO_NAMESPACE;
    L11:
        return r2;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final FeatureConfigMap getFeatureConfigMap() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        FeatureConfigMap r1 = r0.getFeatureConfigMap();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new FeatureConfigMap(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMmtVideoHardwareConfig getMmtVideoHardwareConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMmtVideoHardwareConfig();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean getOUseMemoryEnabled() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getOUseMemoryEnabled() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarItemsConfig getObricActionBarItemsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricActionBarItemsConfig r1 = r0.getObricActionBarItemsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.i;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarModelMenuConfig getObricActionBarModelMenuConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricActionBarModelMenuConfig r1 = r0.getObricActionBarModelMenuConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.k;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAiKeyConfig getObricAiKeyConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricAiKeyConfig r1 = r0.getObricAiKeyConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricAiKeyConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAigcGenerationStateConfig getObricAigcGenerationStateConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricAigcGenerationStateConfig r1 = r0.getObricAigcGenerationStateConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricAigcGenerationStateConfig(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAppIntentScreenshotCacheConfig getObricAppIntentScreenshotCacheConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricAppIntentScreenshotCacheConfig r1 = r0.getObricAppIntentScreenshotCacheConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricAppIntentScreenshotCacheConfig(0, 0, false, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAppLogSettingsConfig getObricAppLogSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricAppLogSettingsConfig r1 = r0.getObricAppLogSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricAppLogSettingsConfig(0, 0, 0, 0, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoGuiBlacklistConfig getObricAutoGuiBlacklistConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        AutoGuiBlacklistConfig r1 = r0.getObricAutoGuiBlacklistConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new AutoGuiBlacklistConfig(null, null, null, null, null, null, 63, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoIncreaseDelayedTimeConfig getObricAutoIncreaseDelayedTimeConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        AutoIncreaseDelayedTimeConfig r1 = r0.getObricAutoIncreaseDelayedTimeConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new AutoIncreaseDelayedTimeConfig(0, 0, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricBottomTabConfig getObricBottomTabConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricBottomTabConfig r1 = r0.getObricBottomTabConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.l;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ComplexTaskCaseFromPCConfig getObricComplexTaskCaseFromPC() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ComplexTaskCaseFromPCConfig r1 = r0.getObricComplexTaskCaseFromPC();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ComplexTaskCaseFromPCConfig(0, 0, 0, 0, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricCrashDumpHprofConfig getObricCrashDumpHprofConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricCrashDumpHprofConfig r1 = r0.getObricCrashDumpHprofConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricCrashDumpHprofConfig(false, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricImageUploadCompressConfig getObricImageUploadCompressConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricImageUploadCompressConfig r1 = r0.getObricImageUploadCompressConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricImageUploadCompressConfig(null, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLarkConfirmConfig getObricLarkConfirmSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricLarkConfirmConfig r1 = r0.getObricLarkConfirmSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricLarkConfirmConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLazyInitConfig getObricLazyInitConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricLazyInitConfig r1 = r0.getObricLazyInitConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricLazyInitConfig(false, false, false, false, false, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLogSettingsConfig getObricLogSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricLogSettingsConfig r1 = r0.getObricLogSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricLogSettingsConfig(false, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricMemoryDataCollectConfig r1 = r0.getObricMemoryDataCollectConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricMemoryDataCollectConfig(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMemoryReportConfig getObricMemoryReportConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricMemoryReportConfig r1 = r0.getObricMemoryReportConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricOneLoginConfig getObricOneLoginConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricOneLoginConfig r1 = r0.getObricOneLoginConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricOneLoginConfig(false, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final CPUExceptionDiagnosisConfig getObricPerformanceCPUExceptionDiagnosisSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        CPUExceptionDiagnosisConfig r1 = r0.getObricPerformanceCPUExceptionDiagnosisSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPerformanceMonitorConfig getObricPerformanceMonitorConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricPerformanceMonitorConfig r1 = r0.getObricPerformanceMonitorConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricPerformanceMonitorConfig(false, null, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPerformancePowerMonitorConfig getObricPerformancePowerMonitorSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricPerformancePowerMonitorConfig r1 = r0.getObricPerformancePowerMonitorSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPowerLockConfig getObricPowerLockConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricPowerLockConfig r1 = r0.getObricPowerLockConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricPowerLockConfig(null, null, null, null, null, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getObricPowerLockTimeoutInSeconds() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getObricPowerLockTimeoutInSeconds();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getObricPrivacyLaneType() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.getObricPrivacyLaneType();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricProcessesManagerConfig getObricProcessesManagerConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricProcessesManagerConfig r1 = r0.getObricProcessesManagerConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricProcessesManagerConfig(0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final q1 getObricPromptCellConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        q1 r1 = r0.getObricPromptCellConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.n;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricScreenshotUploadConfig getObricScreenshotUploadConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricScreenshotUploadConfig r1 = r0.getObricScreenshotUploadConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricScreenshotUploadConfig(false, false, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSecuritySettingsPackageWhitelistConfig getObricSecuritySettingsPackageWhitelistConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricSecuritySettingsPackageWhitelistConfig r1 = r0.getObricSecuritySettingsPackageWhitelistConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricSecuritySettingsPackageWhitelistConfig(null, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSettingsConfig getObricSettingsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricSettingsConfig r1 = r0.getObricSettingsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricSettingsConfig(0, false, 0, 0, 0, 0, 0, false, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricStateMachineMultitaskConfig getObricStateMachineMultitaskConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricStateMachineMultitaskConfig r1 = r0.getObricStateMachineMultitaskConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricStateMachineMultitaskConfig(false, false, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricTimeoutConfig getObricTaskTimeoutConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricTimeoutConfig r1 = r0.getObricTaskTimeoutConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricTimeoutConfig(null, null, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricThresholdDumpHprofConfig getObricThresholdDumpHprofConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricThresholdDumpHprofConfig r1 = r0.getObricThresholdDumpHprofConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ZeusAutoFetchConfig getObricZeusAutoFetchConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ZeusAutoFetchConfig r1 = r0.getObricZeusAutoFetchConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ZeusAutoFetchConfig(false, 0, 0, false, 0, 0, 0, 0, 0, 511, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarItemsConfig getWindowActionBarItemsConfig() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricActionBarItemsConfig r1 = r0.getWindowActionBarItemsConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.j;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.h0();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.h1();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean i() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ComplexTaskSettingsConfig i0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ComplexTaskSettingsConfig r1 = r0.i0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.d;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isBypassAdaptiveSid() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isBypassAdaptiveSid();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isCloseAudioConnAppBackGroundOnlyForObric() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCloseAudioConnAppBackGroundOnlyForObric() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isLarkKnowledgeAuthorizationEnable() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLarkKnowledgeAuthorizationEnable();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isObricContTalkPvadSwitchShowEnable() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isObricContTalkPvadSwitchShowEnable();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isReRecordWakeWordGuideEnable() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isReRecordWakeWordGuideEnable();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isTtsPlayBackgroundEnabled() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTtsPlayBackgroundEnabled();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isVoicePrintAuthenticateAutoGuiEnabled() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean j0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.j0() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void k() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int k1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.k1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.l1();
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final List<ObricEnrolledDeviceInfo> m() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        List<ObricEnrolledDeviceInfo> r1 = r0.m();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean m0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.m0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean o0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.o0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean o1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return !r1;
    L5:
        if (r0.o1() == true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String p() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.p();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final QueryAuthenticateConfig p0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        QueryAuthenticateConfig r1 = r0.p0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new QueryAuthenticateConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean p1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.p1() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean q() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.q();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricDeepThinkModeRestTimeConfig q1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricDeepThinkModeRestTimeConfig r1 = r0.q1();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return l.m;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return !r1;
    L5:
        if (r0.r() == true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.r0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.r1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoGuiAppScopeConfig s0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        AutoGuiAppScopeConfig r1 = r0.s0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new AutoGuiAppScopeConfig(false, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean s1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.s1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean t0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.t0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean u() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.u() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean u0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.u0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Integer v() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int v0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.v0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean v1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.v1() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String w0() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r1 = r0.w0();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean w1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.w1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean x0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.x0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricWakeupSoundConfig x1() {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricWakeupSoundConfig r1 = r0.x1();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ObricWakeupSoundConfig(false, null, false, null, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean y1() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.y1();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Object z0() {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.z0();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void A(long r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.A(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void B0(m r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.B0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void B1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.B1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C0(Integer r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.C0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void D(String r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.D(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void D0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.D0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void E(long r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.E(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F(@ObricSettingsAuthenticationType int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.F(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F0(@ObricSettingsAuthenticationType int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.F0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F1(@ObricSettingsAuthenticationType int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.F1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void H0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.H0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void H1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.H1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void J(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.J(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void K(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.K(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void L1(long r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.L1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void M0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "duid");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.M0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @AutoEndConversationTime
    public final long M1(@AutoEndConversationScene int r3) {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L9;
        if (r3 != 0) goto L7;
        return 10000;
    L7:
        return 20000;
    L9:
        return r0.M1(r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void O1(Object r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.O1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSettingsListConfig R(JSONObject r3) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        ObricSettingsListConfig r4 = r0.R(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new ObricSettingsListConfig(null, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void R0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.R0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void S0(m r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.S0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.U0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.U1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void V(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.V(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void V0(@ObricSettingsAuthenticationType int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.V0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void c1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.c1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void e(v r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L5;
        r0.e(r2);
        return;
    L5:
        r2.invoke(Boolean.FALSE);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void f(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void f1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.f1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void g1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.g1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final JsonObject getObricCloudConfig(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getObricCloudConfig(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String getObricFlowSettingsJson(String r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        String r3 = r0.getObricFlowSettingsJson(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void i1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.i1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void j1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.j1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean k0(String r2) {
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.k0(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l0(int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.l0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void m1(int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.m1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n(String r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.n0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.n1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void o(long r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.o(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void q0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.q0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        IObricSettingsApi r0 = X1();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.s(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setAutoGuiEnabledScene(int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.setAutoGuiEnabledScene(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setAutoImageUploadEnabled(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.setAutoImageUploadEnabled(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setOUseMemoryEnabled(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.setOUseMemoryEnabled(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setSemanticScreenShotEnabled(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.setSemanticScreenShotEnabled(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use saveAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final void setVoicePrintAuthenticateAutoGuiEnabled(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.setVoicePrintAuthenticateAutoGuiEnabled(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void t(@ObricSettingsAuthenticationType int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.t(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void t1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "soundId");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.t1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void u1(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.u1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void w(int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.w(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void x(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void y(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.y(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void y0(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.y0(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void z(boolean r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.z(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void z1(int r2) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.z1(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.C(r2, r3);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C1(Integer r2, String r3) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.C1(r2, r3);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String P1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorizationKey");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L7;
        String r4 = r0.P1(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return c.a(r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void T1(@AutoEndConversationScene int r2, @AutoEndConversationTime long r3) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.T1(r2, r3);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void X(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorizationKey");
        Intrinsics.checkNotNullParameter(r3, "status");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.X(r2, c.a(r3));
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void j(String r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L5;
        r0.j(r2, r3);
        return;
    L5:
        r3.invoke(Boolean.FALSE);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l(boolean r2, List<String> r3) {
        IObricSettingsApi r0 = X1();
        if (r0 == null) goto L6;
        r0.l(r2, r3);
        return;
    }
}
