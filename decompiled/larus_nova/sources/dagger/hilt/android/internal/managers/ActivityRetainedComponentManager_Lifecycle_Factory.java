package dagger.hilt.android.internal.managers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes41.dex */
public final class ActivityRetainedComponentManager_Lifecycle_Factory implements Factory<ActivityRetainedComponentManager.Lifecycle> {

    public static final class InstanceHolder {
        private static final ActivityRetainedComponentManager_Lifecycle_Factory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new ActivityRetainedComponentManager_Lifecycle_Factory();
        }

        public static /* synthetic */ ActivityRetainedComponentManager_Lifecycle_Factory access$000() {
            return INSTANCE;
        }
    }

    public ActivityRetainedComponentManager_Lifecycle_Factory() {
    }

    public static ActivityRetainedComponentManager.Lifecycle newInstance() {
        return new ActivityRetainedComponentManager.Lifecycle();
    }

    public static ActivityRetainedComponentManager_Lifecycle_Factory create() {
        return InstanceHolder.access$000();
    }

    @Override // javax.inject.Provider
    public ActivityRetainedComponentManager.Lifecycle get() {
        return newInstance();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
