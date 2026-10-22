package uf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;

/* JADX INFO: loaded from: classes10.dex */
public interface m1 {

    public interface a {
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f549884a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f549885a = null;

            public a() {
            }

            static {
                f549885a = new a();
            }

            public static b a() {
                ILiveWrappedLivePusher.Companion.getClass();
                ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
                if (r100 != null) goto L7;
                return null;
            L7:
                return r100.newVideoMixerDescription("FILL");
            }
        }

        static {
            f549884a = a.f549885a;
        }

        b a();

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        void m11003a();

        void b();

        void c();

        void copy();

        int d();

        void e();

        void f();

        void g();

        float getBottom();

        float getLeft();

        int getMode();

        float getRight();

        float getTop();

        void h();

        b i();

        boolean isVisible();

        void j();
    }

    public interface c {
    }
}
