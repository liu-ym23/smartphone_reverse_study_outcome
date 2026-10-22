package ix7;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface d {

    public static class a implements d {
        public a() {
        }

        @Override // ix7.d
        public void a() {
        }

        @Override // ix7.d
        public final void b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // ix7.d
        public void c(BulletContainerView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ix7.d
        public void d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ix7.d
        public void e(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // ix7.d
        public void f() {
        }

        @Override // ix7.d
        public final void onLoadStart() {
        }

        @Override // ix7.d
        public void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }
    }

    void a();

    void b(Throwable r100);

    void c(BulletContainerView r100);

    void d(View r100);

    void e(Throwable r100);

    void f();

    void onLoadStart();

    void onLoadSuccess(View r100);
}
