package ew4;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474535a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f474536a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5825a f474537b = null;

        /* JADX INFO: renamed from: ew4.d$a$a, reason: collision with other inner class name */
        public static final class C5825a implements d {
            public C5825a() {
            }

            @Override // ew4.d
            public final void b(int r100) {
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
            public final void a(Dialog r100) {
                Intrinsics.checkNotNullParameter(r100, "dialog");
            }
        }

        public a() {
        }

        static {
            f474536a = new a();
            f474537b = new C5825a();
        }
    }

    static {
        f474535a = a.f474536a;
    }

    void a(Dialog r100);

    void b(int r100);

    void onDetach();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
