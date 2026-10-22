package kd9;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements com.larus.im.service.audio.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f502901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<com.larus.im.service.audio.n, Unit>> f502902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.im.service.audio.n f502903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f502904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f502905e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function1<com.larus.im.service.audio.n, Unit>> f502906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f502907b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f502906a, r101.f502906a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f502907b, r101.f502907b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f502906a.hashCode() * 31;
            Function0<Unit> r101 = this.f502907b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CaptureBindSnapshot(actions=" + this.f502906a + ", frameProcessorProvider=" + this.f502907b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Function1<? super com.larus.im.service.audio.n, Unit>> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
            this.f502906a = r100;
            this.f502907b = r101;
        }
    }

    @Override // com.larus.im.service.audio.n
    public final void release() {
        ReentrantLock r100 = this.f502901a;
        r100.lock();
        this.f502905e = true;     // Catch: Throwable -> L8
        ((ArrayList) this.f502902b).clear();     // Catch: Throwable -> L8
        com.larus.im.service.audio.n r101 = this.f502903c;     // Catch: Throwable -> L8
        this.f502903c = null;     // Catch: Throwable -> L8
        r100.unlock();
        if (r101 == null) goto L13;
        r101.release();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.n
    public final void setup() {
        a(new d());
    }

    @Override // com.larus.im.service.audio.n
    public final void startCapture() {
        a(new g());
    }

    @Override // com.larus.im.service.audio.n
    public final void stopCapture() {
        a(new e());
    }

    public h() {
        this.f502901a = new ReentrantLock();
        this.f502902b = new ArrayList();
    }

    public final void a(Function1<? super com.larus.im.service.audio.n, Unit> r100) {
        ReentrantLock r101 = this.f502901a;
        r101.lock();
    L14:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (this.f502905e == true) goto L9;
        com.larus.im.service.audio.n r102 = this.f502903c;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
        ((ArrayList) this.f502902b).add(r100);     // Catch: Throwable -> L14
    L10:
        r101.unlock();
        if (r102 == null) goto L19;
        r100.invoke(r102);
        return;
    L19:
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // com.larus.im.service.audio.n
    public final void setBluetoothForceToMedia(final boolean r100) {
        a(new f(r100));
    }
}
