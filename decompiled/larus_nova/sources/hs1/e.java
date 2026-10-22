package hs1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface e {

    public static class a implements e {
        public a() {
        }

        @Override // hs1.e
        public void b(View r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // hs1.e
        public final void c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
        }

        @Override // hs1.e
        public final void onPause() {
        }

        @Override // hs1.e
        public void onResume() {
        }

        @Override // hs1.e
        public final void onStart() {
        }

        @Override // hs1.e
        public final void onStop() {
        }
    }

    void b(View r100, Bundle r101);

    void c(Context r100);

    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
