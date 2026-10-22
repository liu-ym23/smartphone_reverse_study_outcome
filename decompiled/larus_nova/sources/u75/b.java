package u75;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface b {

    public interface a {
        <I> void a(InfoCode r100, I r101);

        void b(z r100);

        void c(ErrCode r100);

        void onProgress(int r100);
    }

    /* JADX INFO: renamed from: u75.b$b, reason: collision with other inner class name */
    public static class C7844b implements a {
        public C7844b() {
        }

        @Override // u75.b.a
        public <T> void a(InfoCode r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
        }

        @Override // u75.b.a
        public void b(z r100) {
            Intrinsics.checkNotNullParameter(r100, "previewFileModel");
        }

        @Override // u75.b.a
        public void c(ErrCode r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
        }

        @Override // u75.b.a
        public void onProgress(int r100) {
        }
    }

    void a();

    void b();

    void c(a r100);

    void d(ErrCode r100);

    void e(boolean r100);

    void f();

    void g(a r100);

    void load();

    void onAttach();

    void onDetach();
}
