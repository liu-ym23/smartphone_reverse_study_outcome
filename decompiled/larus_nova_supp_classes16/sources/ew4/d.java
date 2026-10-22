package ew4;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final C0222a b = null;

        /* JADX INFO: renamed from: ew4.d$a$a, reason: collision with other inner class name */
        public static final class C0222a implements d {
            public C0222a() {
            }

            @Override // ew4.d
            public final void b(int r1) {
            }

            @Override // ew4.d
            public final void onDetach() {
            }

            @Override // ew4.d
            public final void onPause() {
            }

            @Override // ew4.d
            public final void onResume() {
            }

            @Override // ew4.d
            public final void onStart() {
            }

            @Override // ew4.d
            public final void onStop() {
            }

            @Override // ew4.d
            public final void a(Dialog r2) {
                Intrinsics.checkNotNullParameter(r2, "dialog");
            }
        }

        public a() {
        }

        static {
            a = new a();
            b = new C0222a();
        }
    }

    static {
        a = a.a;
    }

    void a(Dialog r1);

    void b(int r1);

    void onDetach();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
