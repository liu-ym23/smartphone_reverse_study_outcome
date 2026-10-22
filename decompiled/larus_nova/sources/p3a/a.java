package p3a;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q3a.p;
import r3a.i;
import r3a.j;
import r3a.l;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements p {

    /* JADX INFO: renamed from: p3a.a$a, reason: collision with other inner class name */
    public static final class C7147a {
    }

    static {
    }

    @Override // q3a.p
    public final void a() {
    }

    @Override // q3a.p
    public final void n() {
    }

    @Override // q3a.p
    public final String o() {
        return "LoggingCameraEventListener";
    }

    @Override // q3a.p
    public final void p(boolean r100, int r101) {
    }

    @Override // q3a.p
    public final void g() {
        FLogger.f375446a.i("LoggingCameraEventListener", "First frame received");
    }

    @Override // q3a.p
    public final void r() {
        FLogger.f375446a.i("LoggingCameraEventListener", "Camera open success");
    }

    public a() {
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "captureParams");
    }

    @Override // q3a.p
    public final void k(int r100) {
        FLogger.f375446a.e("LoggingCameraEventListener", "Camera open failed: cameraType=" + r100);
    }

    @Override // q3a.p
    public final void l(s3a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // q3a.p
    public final void s(i r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("LoggingCameraEventListener", "Camera error: " + r100.f535926a + " - " + r100.f535927b, r100.f535928c);
    }

    @Override // q3a.p
    public final void t(j r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        FLogger.f375446a.d("LoggingCameraEventListener", "Frame captured: textureId=" + r100.f535929a + ", size=" + r100.f535930b + Permission.EXECUTE + r100.f535931c);
    }

    @Override // q3a.p
    public final void h(l r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        FLogger.f375446a.i("LoggingCameraEventListener", "State changed: " + r100.getTag() + " -> " + r101.getTag());
    }
}
