package uj0;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f550256a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f550257a = null;

        public a() {
        }

        static {
            f550257a = new a();
        }

        public static String a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100) {
            Intrinsics.checkNotNullParameter(r100, "struct");
            return "micseat_" + r100.f79080f;
        }
    }

    static {
        f550256a = a.f550257a;
    }

    void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100);

    void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100, Bitmap r101);

    void init();

    void release();
}
