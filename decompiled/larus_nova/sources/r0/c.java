package r0;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535396a = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f535397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f535398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f535399c;
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f535400a;

        public static void a(Context r100) {
            if (f535400a == true) goto L13;
            if (r100 != null) goto L7;
            return;
        L7:
            if (r100.getResources() == null) goto L11;
            Resources r101 = r100.getResources();
            if (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()) == null) goto L11;
            Resources r102 = r100.getResources();
            int r103 = (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density > 2.0f ? 1 : (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density == 2.0f ? 0 : -1));
            f535400a = true;
        L11:
            int r104 = c.f535396a;
            return;
        }
    }

    static {
        monitor-enter(d.class);
        monitor-exit(d.class);
    }
}
