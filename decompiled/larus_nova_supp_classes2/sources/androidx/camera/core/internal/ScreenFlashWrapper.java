package androidx.camera.core.internal;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/core/internal/ScreenFlashWrapper;", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "screenFlash", "(Landroidx/camera/core/ImageCapture$ScreenFlash;)V", "isClearScreenFlashPending", "", "lock", "Ljava/lang/Object;", "pendingListener", "Landroidx/camera/core/ImageCapture$ScreenFlashListener;", "apply", "", "expirationTimeMillis", "", "screenFlashListener", "clear", "completePendingScreenFlashClear", "completePendingScreenFlashListener", "completePendingTasks", "getBaseScreenFlash", "Companion", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScreenFlashWrapper implements ImageCapture.ScreenFlash {
    public static final Companion Companion = null;
    private static final String TAG = "ScreenFlashWrapper";
    private boolean isClearScreenFlashPending;
    private final Object lock;
    private ImageCapture.ScreenFlashListener pendingListener;
    private final ImageCapture.ScreenFlash screenFlash;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/camera/core/internal/ScreenFlashWrapper$Companion;", "", "()V", "TAG", "", "from", "Landroidx/camera/core/internal/ScreenFlashWrapper;", "screenFlash", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ScreenFlashWrapper from(ImageCapture.ScreenFlash r3) {
            return new ScreenFlashWrapper(r3, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ScreenFlashWrapper(ImageCapture.ScreenFlash r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ void a(ScreenFlashWrapper r0) {
        apply$lambda$2(r0);
    }

    @JvmStatic
    public static final ScreenFlashWrapper from(ImageCapture.ScreenFlash r1) {
        return Companion.from(r1);
    }

    private final void completePendingScreenFlashClear() {
        Object r0 = this.lock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.isClearScreenFlashPending == false) goto L12;
        ImageCapture.ScreenFlash r1 = this.screenFlash;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.clear();     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L10:
        if (r2 != null) goto L13;
        Logger.e(TAG, "completePendingScreenFlashClear: screenFlash is null!");     // Catch: Throwable -> L16
    L13:
        this.isClearScreenFlashPending = false;     // Catch: Throwable -> L16
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L9:
        r2 = null;
        goto L10
    L12:
        Logger.w(TAG, "completePendingScreenFlashClear: none pending!");     // Catch: Throwable -> L16
        goto L13
    }

    private final void completePendingScreenFlashListener() {
        Object r0 = this.lock;
        monitor-enter(r0);
        ImageCapture.ScreenFlashListener r1 = this.pendingListener;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.onCompleted();     // Catch: Throwable -> L10
    L7:
        this.pendingListener = null;     // Catch: Throwable -> L10
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void completePendingTasks() {
        completePendingScreenFlashListener();
        completePendingScreenFlashClear();
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void clear() {
        completePendingScreenFlashClear();
    }

    public final ImageCapture.ScreenFlash getBaseScreenFlash() {
        return this.screenFlash;
    }

    private ScreenFlashWrapper(ImageCapture.ScreenFlash r1) {
        this.screenFlash = r1;
        this.lock = new Object();
    }

    private static final void apply$lambda$2(ScreenFlashWrapper r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Object r0 = r3.lock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r3.pendingListener != null) goto L7;
        Logger.w(TAG, "apply: pendingListener is null!");     // Catch: Throwable -> L10
    L7:
        r3.completePendingScreenFlashListener();     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void apply(long r3, ImageCapture.ScreenFlashListener r5) {
        Intrinsics.checkNotNullParameter(r5, "screenFlashListener");
        Object r0 = this.lock;
        monitor-enter(r0);
        this.isClearScreenFlashPending = true;     // Catch: Throwable -> L14
        this.pendingListener = r5;     // Catch: Throwable -> L14
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        ImageCapture.ScreenFlash r7 = this.screenFlash;
        if (r7 == null) goto L10;
        r7.apply(r3, new c(this));
        Unit r4 = Unit.INSTANCE;
    L11:
        if (r4 != null) goto L19;
        Logger.e(TAG, "apply: screenFlash is null!");
        completePendingScreenFlashListener();
        return;
    L19:
        return;
    L10:
        r4 = null;
    L14:
        th = move-exception;
        throw th;
    }
}
