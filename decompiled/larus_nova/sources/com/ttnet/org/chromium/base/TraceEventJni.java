package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class TraceEventJni implements TraceEvent.Natives {
    public static final JniStaticTestMocker<TraceEvent.Natives> TEST_HOOKS = null;
    private static TraceEvent.Natives testInstance;

    public TraceEventJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static TraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TraceEvent.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new TraceEventJni();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public boolean viewHierarchyDumpEnabled() {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void initViewHierarchyDump() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void registerEnabledObserver() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void stopATrace() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_stopATrace();
    }

    public static /* synthetic */ TraceEvent.Natives access$002(TraceEvent.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void beginToplevel(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_beginToplevel(r100);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void endToplevel(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_endToplevel(r100);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void setupATraceStartupTrace(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(r100);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startATrace(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startATrace(r100);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void begin(String r100, String r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_begin(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void end(String r100, String r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_end(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void finishAsync(String r100, long r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_finishAsync(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instant(String r100, String r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instant(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instantAndroidIPC(String r100, long r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public long startActivityDump(String r100, long r101) {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startActivityDump(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startAsync(String r100, long r101) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startAsync(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void addViewDump(int r100, int r101, boolean r102, boolean r103, String r104, String r105, long r106) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_addViewDump(r100, r101, r102, r103, r104, r105, r106);
    }
}
