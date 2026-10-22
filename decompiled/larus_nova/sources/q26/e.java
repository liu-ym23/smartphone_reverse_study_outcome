package q26;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface e {

    public static class a implements e {
        public a() {
        }

        @Override // q26.e
        public final void a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
        }

        @Override // q26.e
        public final void b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        }

        @Override // q26.e
        public void c(d r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
        }

        @Override // q26.e
        public final void d(d r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
        }
    }

    void a(d r100);

    void b(Throwable r100);

    void c(d r100);

    void d(d r100);
}
