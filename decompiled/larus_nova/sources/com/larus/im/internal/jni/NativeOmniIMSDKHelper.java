package com.larus.im.internal.jni;

import com.larus.im.internal.jni.service.OmniServiceGetter;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0082 J\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003J\u0019\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0082 J\u0006\u0010\u0018\u001a\u00020\u0019J\u0011\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0082 J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/im/internal/jni/NativeOmniIMSDKHelper;", "", "uid", "", "userName", "senderId", "secUid", "dbPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "released", "Lkotlinx/atomicfu/AtomicBoolean;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "omniSdkPtr", "", "omniServiceGetter", "Lcom/larus/im/internal/jni/service/OmniServiceGetter;", "initOmniIMSDK", "serviceGetter", "updateDowngradeConfig", "configJson", "omnisdkPtr", "release", "", "nativeRelease", "ptr", "isDestroyed", "", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeOmniIMSDKHelper {
    public static final Companion Companion = null;
    private static final String TAG = "NativeOmniIMSDKHelper";
    private final String dbPath;
    private final ReentrantLock lock;
    private final long omniSdkPtr;
    private final OmniServiceGetter omniServiceGetter;
    private final buc.a released;
    private final String secUid;
    private final String senderId;
    private final String uid;
    private final String userName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/NativeOmniIMSDKHelper$Companion;", "", "<init>", "()V", "TAG", "", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final native long initOmniIMSDK(String r100, String r101, String r102, String r103, String r104);

    private final native void nativeRelease(long r100);

    private final native long updateDowngradeConfig(long r100, String r101);

    public final boolean isDestroyed() {
        ReentrantLock r100 = this.lock;
        r100.lock();
        boolean r101 = this.released.c();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final void release() {
        ReentrantLock r100 = this.lock;
        r100.lock();
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (this.released.c() == false) goto L7;
        r100.unlock();
        return;
    L7:
        nativeRelease(this.omniSdkPtr);     // Catch: Throwable -> L10
        this.released.d(true);     // Catch: Throwable -> L10
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r100.unlock();
    }

    public final OmniServiceGetter serviceGetter() {
        return this.omniServiceGetter;
    }

    public final long updateDowngradeConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "configJson");
        return updateDowngradeConfig(this.omniSdkPtr, r100);
    }

    public NativeOmniIMSDKHelper(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "senderId");
        Intrinsics.checkNotNullParameter(r103, "secUid");
        Intrinsics.checkNotNullParameter(r104, "dbPath");
        this.uid = r100;
        this.userName = r101;
        this.senderId = r102;
        this.secUid = r103;
        this.dbPath = r104;
        this.released = buc.b.a(false);
        this.lock = new ReentrantLock();
        com.larus.im.internal.delegate.a r105 = com.larus.im.internal.delegate.a.f348188b;
        r105.i(TAG, "init omni sdk");
        long r106 = initOmniIMSDK(r100, r101, r102, r103, r104);
        this.omniSdkPtr = r106;
        this.omniServiceGetter = new OmniServiceGetter(r106);
        r105.i(TAG, "init omni sdk success, omni sdk ptr: " + r106);
    }
}
