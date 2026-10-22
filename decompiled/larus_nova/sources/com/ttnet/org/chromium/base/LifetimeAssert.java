package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class LifetimeAssert {
    static TestHook sTestHook;
    private final Object mTarget;
    final WrappedReference mWrapper;

    public static class CreationException extends RuntimeException {
        public CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    public static class LifetimeAssertException extends RuntimeException {
        public LifetimeAssertException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public interface TestHook {
        void onCleaned(WrappedReference r100, String r101);
    }

    public static class WrappedReference extends PhantomReference<Object> {
        private static Set<WrappedReference> sActiveWrappers;
        private static ReferenceQueue<Object> sReferenceQueue;
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;

        static {
            sReferenceQueue = new ReferenceQueue();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            final String r100 = "GcStateAssertQueue";
            new AnonymousClass1(r100);
        }

        public static /* synthetic */ ReferenceQueue access$000() {
            return sReferenceQueue;
        }

        public static /* synthetic */ Set access$100() {
            return sActiveWrappers;
        }

        public WrappedReference(Object r100, CreationException r101, boolean r102) {
            super(r100, sReferenceQueue);
            this.mCreationException = r101;
            this.mSafeToGc = r102;
            this.mTargetClass = r100.getClass();
            sActiveWrappers.add(this);
        }
    }

    public static void assertAllInstancesDestroyedForTesting() throws LifetimeAssertException {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        Set r100 = WrappedReference.access$100();
        monitor-enter(r100);
        Iterator r101 = WrappedReference.access$100().iterator();     // Catch: Throwable -> L18
    L9:
        if (r101.hasNext() == false) goto L15;
        WrappedReference r102 = (WrappedReference) r101.next();     // Catch: Throwable -> L18
        if (r102.mSafeToGc == true) goto L9;
        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", new Object[]{r102.mTargetClass.getName()}), r102.mCreationException);     // Catch: Throwable -> L18
    L15:
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L18:
        th = move-exception;
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static void resetForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        WrappedReference.access$100().clear();
    }

    public static LifetimeAssert create(Object r100) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r100, new CreationException(), false), r100);
    }

    private LifetimeAssert(WrappedReference r100, Object r101) {
        this.mWrapper = r100;
        this.mTarget = r101;
    }

    public static LifetimeAssert create(Object r100, boolean r101) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r100, new CreationException(), r101), r100);
    }

    public static void setSafeToGc(LifetimeAssert r100, boolean r101) {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Object r102 = r100.mTarget;
        monitor-enter(r102);
        r100.mWrapper.mSafeToGc = r101;     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
