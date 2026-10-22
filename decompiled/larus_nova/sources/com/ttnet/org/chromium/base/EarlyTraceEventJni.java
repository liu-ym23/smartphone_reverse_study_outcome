package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class EarlyTraceEventJni implements EarlyTraceEvent.Natives {
    public static final JniStaticTestMocker<EarlyTraceEvent.Natives> TEST_HOOKS = null;
    private static EarlyTraceEvent.Natives testInstance;

    public EarlyTraceEventJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static EarlyTraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        EarlyTraceEvent.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new EarlyTraceEventJni();
    }

    public static /* synthetic */ EarlyTraceEvent.Natives access$002(EarlyTraceEvent.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncBeginEvent(String r100, long r101, long r102) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncEndEvent(String r100, long r101, long r102) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyBeginEvent(String r100, long r101, int r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyEndEvent(String r100, long r101, int r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelBeginEvent(String r100, long r101, int r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelEndEvent(String r100, long r101, int r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(r100, r101, r102, r103);
    }
}
