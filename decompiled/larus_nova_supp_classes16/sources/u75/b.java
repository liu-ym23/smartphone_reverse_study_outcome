package u75;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {

    public interface a {
        <I> void a(InfoCode r1, I r2);

        void b(z r1);

        void c(ErrCode r1);

        void onProgress(int r1);
    }

    /* JADX INFO: renamed from: u75.b$b, reason: collision with other inner class name */
    public static class C0306b implements a {
        public C0306b() {
        }

        @Override // u75.b.a
        public <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
        }

        @Override // u75.b.a
        public void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
        }

        @Override // u75.b.a
        public void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
        }

        @Override // u75.b.a
        public void onProgress(int r1) {
        }
    }

    void a();

    void b();

    void c(a r1);

    void d(ErrCode r1);

    void e(boolean r1);

    void f();

    void g(a r1);

    void load();

    void onAttach();

    void onDetach();
}
