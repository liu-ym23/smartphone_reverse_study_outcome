package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class CommandLineJni implements CommandLine.Natives {
    public static final JniStaticTestMocker<CommandLine.Natives> TEST_HOOKS = null;
    private static CommandLine.Natives testInstance;

    public CommandLineJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CommandLine.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CommandLine.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.CommandLine.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new CommandLineJni();
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String[] getSwitchesFlattened() {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened();
    }

    public static /* synthetic */ CommandLine.Natives access$002(CommandLine.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitch(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitch(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchesAndArguments(String[] r100) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String getSwitchValue(String r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchValue(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public boolean hasSwitch(String r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_hasSwitch(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void init(String[] r100) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_init(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void removeSwitch(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_removeSwitch(r100);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchWithValue(String r100, String r101) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(r100, r101);
    }
}
