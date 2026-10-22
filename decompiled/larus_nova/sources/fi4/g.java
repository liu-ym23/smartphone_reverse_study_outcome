package fi4;

import com.bytedance.creativex.mediaimport.preview.internal.main.b1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface g {

    public static class a implements g {
        public a() {
        }

        @Override // fi4.g
        public final void b(b1 r100) {
            Intrinsics.checkNotNullParameter(r100, "player");
        }

        @Override // fi4.g
        public final void onCompletion() {
        }

        @Override // fi4.g
        public final void onStart() {
        }

        @Override // fi4.g
        public final void onStop() {
        }
    }

    void a(b1 r100);

    void b(b1 r100);

    void onCompletion();

    void onError();

    void onRenderStart();

    void onStart();

    void onStop();
}
