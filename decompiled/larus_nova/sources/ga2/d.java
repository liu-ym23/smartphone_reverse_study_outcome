package ga2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480547a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("PSSelectedAiAgent", r100);
    }

    public static void b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ALogger.i("PSSelectedMessage", "list message batch clear. clear num: " + r100 + ", reason: " + r101);
    }

    public static void c(long r100, int r101, int r102) {
        l.a("chosen_screen_message_refresh_rate", "refresh_interval: " + r100 + ", refresh_quantity: " + r101 + ", scroll_speed: " + r102);
    }
}
