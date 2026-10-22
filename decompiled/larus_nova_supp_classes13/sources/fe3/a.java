package fe3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a implements Runnable {
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: fe3.a$a, reason: collision with other inner class name */
    public static final class C0196a {
    }

    static {
    }

    public a() {
        Intrinsics.checkNotNullParameter("deep_feed_bff_video_pre_warm", "taskName");
        Intrinsics.checkNotNullParameter("deep_feed_bff_video_pre_warm", "group");
        this.a = "deep_feed_bff_video_pre_warm";
        this.b = "deep_feed_bff_video_pre_warm";
    }
}
