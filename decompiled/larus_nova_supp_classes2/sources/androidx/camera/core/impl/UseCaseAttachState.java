package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap;
    private final String mCameraId;

    public interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo r1);
    }

    public static final class UseCaseAttachInfo {
        private boolean mActive;
        private boolean mAttached;
        private final List<UseCaseConfigFactory.CaptureType> mCaptureTypes;
        private final SessionConfig mSessionConfig;
        private final StreamSpec mStreamSpec;
        private final UseCaseConfig<?> mUseCaseConfig;

        public String toString() {
            return "UseCaseAttachInfo{mSessionConfig=" + this.mSessionConfig + ", mUseCaseConfig=" + this.mUseCaseConfig + ", mStreamSpec=" + this.mStreamSpec + ", mCaptureTypes=" + this.mCaptureTypes + ", mAttached=" + this.mAttached + ", mActive=" + this.mActive + '}';
        }

        public boolean getActive() {
            return this.mActive;
        }

        public boolean getAttached() {
            return this.mAttached;
        }

        public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
            return this.mCaptureTypes;
        }

        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        public StreamSpec getStreamSpec() {
            return this.mStreamSpec;
        }

        public UseCaseConfig<?> getUseCaseConfig() {
            return this.mUseCaseConfig;
        }

        public void setActive(boolean r1) {
            this.mActive = r1;
        }

        public void setAttached(boolean r1) {
            this.mAttached = r1;
        }

        public UseCaseAttachInfo(SessionConfig r2, UseCaseConfig<?> r3, StreamSpec r4, List<UseCaseConfigFactory.CaptureType> r5) {
            this.mAttached = false;
            this.mActive = false;
            this.mSessionConfig = r2;
            this.mUseCaseConfig = r3;
            this.mStreamSpec = r4;
            this.mCaptureTypes = r5;
        }
    }

    public static /* synthetic */ boolean a(UseCaseAttachInfo r0) {
        return lambda$getActiveAndAttachedSessionConfigs$3(r0);
    }

    public static /* synthetic */ boolean b(UseCaseAttachInfo r0) {
        return lambda$getAttachedSessionConfigs$1(r0);
    }

    public static /* synthetic */ boolean c(UseCaseAttachInfo r0) {
        return lambda$getAttachedUseCaseInfo$2(r0);
    }

    public static /* synthetic */ boolean d(UseCaseAttachInfo r0) {
        return lambda$getAttachedUseCaseConfigs$0(r0);
    }

    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder r0 = new SessionConfig.ValidatingBuilder();
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r2 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r3 = r2.next();
        UseCaseAttachInfo r4 = r3.getValue();
        if (r4.getActive() == false) goto L4;
        if (r4.getAttached() == false) goto L4;
        String r5 = r3.getKey();
        r0.add(r4.getSessionConfig());
        r1.add(r5);
        goto L4
    L10:
        Logger.d(TAG, "Active and attached use case: " + r1 + " for camera: " + this.mCameraId);
        return r0;
    }

    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new y()));
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder r0 = new SessionConfig.ValidatingBuilder();
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r2 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, UseCaseAttachInfo> r3 = r2.next();
        UseCaseAttachInfo r4 = r3.getValue();
        if (r4.getAttached() == false) goto L4;
        r0.add(r4.getSessionConfig());
        r1.add(r3.getKey());
        goto L4
    L8:
        Logger.d(TAG, "All use case: " + r1 + " for camera: " + this.mCameraId);
        return r0;
    }

    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new v()));
    }

    public Collection<UseCaseConfig<?>> getAttachedUseCaseConfigs() {
        return Collections.unmodifiableCollection(getUseCaseConfigs(new x()));
    }

    public Collection<UseCaseAttachInfo> getAttachedUseCaseInfo() {
        return Collections.unmodifiableCollection(getUseCaseInfo(new w()));
    }

    public UseCaseAttachState(String r2) {
        this.mAttachedUseCasesToInfoMap = new LinkedHashMap();
        this.mCameraId = r2;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r1 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r2 = r1.next();
        if (r5 == null) goto L9;
        if (r5.filter(r2.getValue()) == false) goto L4;
    L9:
        r0.add(r2.getValue().getSessionConfig());
        goto L4
    L10:
        return r0;
    }

    private Collection<UseCaseConfig<?>> getUseCaseConfigs(AttachStateFilter r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r1 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r2 = r1.next();
        if (r5 == null) goto L9;
        if (r5.filter(r2.getValue()) == false) goto L4;
    L9:
        r0.add(r2.getValue().getUseCaseConfig());
        goto L4
    L10:
        return r0;
    }

    private Collection<UseCaseAttachInfo> getUseCaseInfo(AttachStateFilter r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r1 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r2 = r1.next();
        if (r5 == null) goto L9;
        if (r5.filter(r2.getValue()) == false) goto L4;
    L9:
        r0.add(r2.getValue());
        goto L4
    L10:
        return r0;
    }

    private static /* synthetic */ boolean lambda$getActiveAndAttachedSessionConfigs$3(UseCaseAttachInfo r1) {
        if (r1.getActive() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getAttached() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAttachedSessionConfigs$1(UseCaseAttachInfo r0) {
        return r0.getAttached();
    }

    private static /* synthetic */ boolean lambda$getAttachedUseCaseConfigs$0(UseCaseAttachInfo r0) {
        return r0.getAttached();
    }

    private static /* synthetic */ boolean lambda$getAttachedUseCaseInfo$2(UseCaseAttachInfo r0) {
        return r0.getAttached();
    }

    public boolean isUseCaseAttached(String r2) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r2) == true) goto L7;
        return false;
    L7:
        return this.mAttachedUseCasesToInfoMap.get(r2).getAttached();
    }

    public void removeUseCase(String r2) {
        this.mAttachedUseCasesToInfoMap.remove(r2);
    }

    public void setUseCaseDetached(String r3) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r3) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r0 = this.mAttachedUseCasesToInfoMap.get(r3);
        r0.setAttached(false);
        if (r0.getActive() == true) goto L9;
        this.mAttachedUseCasesToInfoMap.remove(r3);
        return;
    }

    public void setUseCaseInactive(String r3) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r3) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r0 = this.mAttachedUseCasesToInfoMap.get(r3);
        r0.setActive(false);
        if (r0.getAttached() == true) goto L9;
        this.mAttachedUseCasesToInfoMap.remove(r3);
        return;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String r2, SessionConfig r3, UseCaseConfig<?> r4, StreamSpec r5, List<UseCaseConfigFactory.CaptureType> r6) {
        UseCaseAttachInfo r0 = this.mAttachedUseCasesToInfoMap.get(r2);
        if (r0 != null) goto L6;
        UseCaseAttachInfo r1 = new UseCaseAttachInfo(r3, r4, r5, r6);
        this.mAttachedUseCasesToInfoMap.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public void setUseCaseActive(String r1, SessionConfig r2, UseCaseConfig<?> r3, StreamSpec r4, List<UseCaseConfigFactory.CaptureType> r5) {
        getOrCreateUseCaseAttachInfo(r1, r2, r3, r4, r5).setActive(true);
    }

    public void setUseCaseAttached(String r3, SessionConfig r4, UseCaseConfig<?> r5, StreamSpec r6, List<UseCaseConfigFactory.CaptureType> r7) {
        getOrCreateUseCaseAttachInfo(r3, r4, r5, r6, r7).setAttached(true);
        updateUseCase(r3, r4, r5, r6, r7);
    }

    public void updateUseCase(String r2, SessionConfig r3, UseCaseConfig<?> r4, StreamSpec r5, List<UseCaseConfigFactory.CaptureType> r6) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r2) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r0 = new UseCaseAttachInfo(r3, r4, r5, r6);
        UseCaseAttachInfo r7 = this.mAttachedUseCasesToInfoMap.get(r2);
        r0.setAttached(r7.getAttached());
        r0.setActive(r7.getActive());
        this.mAttachedUseCasesToInfoMap.put(r2, r0);
    }
}
