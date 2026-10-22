package com.relax;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class RelaxJNI {
    private static final String TAG = "RelaxJNI";
    private BackendWorkerJNI mBackendWorkerJNI;
    private Runnable mOnReset;
    private RelaxView.u mOnRootSizeChangedCallback;
    private final CopyOnWriteArrayList<HashMap<String, Object>> mPerformanceEntryCache;
    private long mPlatformShellPtr;
    private long mRelaxEnginePtr;
    private r requestFrame;
    private TimingTracker timingTracker;

    public static /* synthetic */ void a(TimingTracker r100, HashMap r101) {
        lambda$setTimingTracker$0(r100, r101);
    }

    private native ByteBuffer nativeGetAllTimingInfo(long r100);

    private native long nativeGetRawEngine(long r100);

    private native long nativeGetRawWorker(long r100);

    private native String[] nativeGetSources(long r100, String r101);

    private native long nativeInitRelaxEngine(RelaxJNI r100, BackendWorkerJNI r101, int r102);

    private native void nativeOnEnterBackground(long r100);

    private native void nativeOnEnterForeground(long r100);

    private native double[] nativeOnMeasure(long r100, double r101, double r102);

    private native void nativeOnPipelineStart(long r100);

    private native void nativeSetPageConfig(long r100, boolean r101, boolean r102);

    private native void nativeSetTiming(long r100, String r101, String r102, long r103);

    private native void nativeUpdateViewport(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, float r110, float r111, boolean r112);

    public ByteBuffer getAllTimingInfo() {
        return nativeGetAllTimingInfo(this.mPlatformShellPtr);
    }

    public long getBackendWorkerPtr() {
        return nativeGetRawWorker(this.mPlatformShellPtr);
    }

    public void onEnterBackground() {
        nativeOnEnterBackground(this.mPlatformShellPtr);
    }

    public void onEnterForeground() {
        nativeOnEnterForeground(this.mPlatformShellPtr);
    }

    public void onPipelineStart() {
        nativeOnPipelineStart(this.mPlatformShellPtr);
    }

    public void onReportFMP() {
        TimingTracker r100 = this.timingTracker;
        if (r100 == null) goto L6;
        r100.onFirstFMP();
        return;
    }

    public void onRequestFrame() {
        r r100 = this.requestFrame;
        if (r100 == null) goto L6;
        ((RelaxView.n) r100).f404608a.requestLayout();
        return;
    }

    public void onReset() {
        Runnable r100 = this.mOnReset;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    public BackendWorkerJNI getBackendWorkerJNI() {
        return this.mBackendWorkerJNI;
    }

    public long getRelaxEnginePtr() {
        return this.mRelaxEnginePtr;
    }

    public RelaxJNI(RuntimeType r100) {
        this.timingTracker = null;
        this.mPerformanceEntryCache = new CopyOnWriteArrayList();
        this.requestFrame = null;
        this.mOnReset = null;
        this.mPlatformShellPtr = 0;
        this.mRelaxEnginePtr = 0;
        this.mBackendWorkerJNI = null;
        BackendWorkerJNI r101 = new BackendWorkerJNI(true, r100);
        this.mBackendWorkerJNI = r101;
        long r102 = nativeInitRelaxEngine(this, r101, r100.ordinal());
        this.mPlatformShellPtr = r102;
        this.mRelaxEnginePtr = nativeGetRawEngine(r102);
        this.mBackendWorkerJNI.delayInit(this.mPlatformShellPtr);
    }

    public Map<String, Object> getSources(String r100) {
        HashMap r101 = new HashMap();
        String[] r102 = nativeGetSources(this.mPlatformShellPtr, r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        int r103 = r102.length / 2;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        int r105 = r104 * 2;
        r101.put(r102[r105], r102[r105 + 1]);
        r104 = r104 + 1;
        goto L6
    L8:
        return r101;
    }

    public void onPerformanceEvent(ByteBuffer r100) {
        HashMap<String, Object> r101 = (HashMap) ipa.c.a(r100);
        TimingTracker r102 = this.timingTracker;
        if (r102 == null) goto L5;
        r102.onPerformanceEvent(r101);
        return;
    L5:
        this.mPerformanceEntryCache.add(r101);
    }

    public void onReportTimingSetup(ByteBuffer r100) {
        TimingTracker r101 = this.timingTracker;
        if (r101 == null) goto L6;
        r101.onReportTimingSetup(r100);
        return;
    }

    public void setOnResetCallback(Runnable r100) {
        this.mOnReset = r100;
    }

    public void setOnRootSizeChangedCallback(RelaxView.u r100) {
        this.mOnRootSizeChangedCallback = r100;
    }

    public void setRequestFrame(r r100) {
        this.requestFrame = r100;
    }

    public void setTimingTracker(final TimingTracker r100) {
        this.timingTracker = r100;
        this.mPerformanceEntryCache.forEach(new q(r100));
        this.mPerformanceEntryCache.clear();
    }

    public void updateViewport(RelaxEngine.a r110) {
        long r100 = this.mPlatformShellPtr;
        int r101 = r110.f404546a;
        int r102 = r110.f404547b;
        int r103 = r110.f404552g;
        int r104 = r110.f404554i;
        int r105 = r110.f404553h;
        int r106 = r110.f404555j;
        int r107 = r110.f404551f;
        float r111 = r110.f404550e;
        float r112 = r110.f404548c;
        if ((r110.f404549d & 48) != 32) goto L5;
        boolean r113 = true;
    L6:
        nativeUpdateViewport(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113);
        return;
    L5:
        r113 = false;
        goto L6
    }

    private static /* synthetic */ void lambda$setTimingTracker$0(TimingTracker r100, HashMap r101) {
        r100.onPerformanceEvent(r101);
    }

    public double[] onMeasure(double r100, double r110) {
        return nativeOnMeasure(this.mPlatformShellPtr, r100, r110);
    }

    public void onRootSizeChanged(int r100, int r101) {
        RelaxView.u r102 = this.mOnRootSizeChangedCallback;
        if (r102 == null) goto L11;
        RelaxView r103 = ((RelaxView.k) r102).f404605a;
        if (r103.f404579s == r100) goto L7;
    L9:
        r103.f404579s = r100;
        r103.f404578r = r101;
        return;
    L7:
        if (r103.f404578r != r101) goto L9;
        return;
    }

    public void setPageConfig(boolean r100, boolean r101) {
        nativeSetPageConfig(this.mRelaxEnginePtr, r100, r101);
    }

    public void onReportTimingUpdate(ByteBuffer r100, ByteBuffer r101, String r102) {
        TimingTracker r103 = this.timingTracker;
        if (r103 == null) goto L6;
        r103.onReportTimingUpdate(r100, r101, r102);
        return;
    }

    public void setTiming(String r100, String r101, long r110) {
        nativeSetTiming(this.mPlatformShellPtr, r100, r101, r110);
    }
}
