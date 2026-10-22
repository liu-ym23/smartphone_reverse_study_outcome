package uf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface m1 {

    public interface a {
    }

    public interface b {
        public static final a a = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }

            public static b a() {
                ILiveWrappedLivePusher.Companion.getClass();
                ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.newVideoMixerDescription("FILL");
            }
        }

        static {
            a = a.a;
        }

        b a();

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        void m1428a();

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
