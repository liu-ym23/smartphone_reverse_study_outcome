package mb0;

import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f512759a;

    static {
    }

    public static void e(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        c r101 = f512759a;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public static void f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        c r102 = f512759a;
        if (r102 == null) goto L6;
        c.a.c(r102, r100, r101);
        return;
    }

    @JvmStatic
    public static final void g(String r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
        c r102 = f512759a;
        if (r102 == null) goto L6;
        r102.b(r100, r101, null);
        return;
    }

    @JvmStatic
    public static final void h(KtvMusic r100, MusicInfoError r101) {
        Intrinsics.checkNotNullParameter(r101, "errorInfo");
        c r102 = f512759a;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    public static void a(LinkMonitorData r100, long r101, Throwable r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r103, "extra");
        c r104 = f512759a;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    public static void b(LinkMonitorData r100, long r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, "logId");
        Intrinsics.checkNotNullParameter(r103, "extra");
        c r104 = f512759a;
        if (r104 == null) goto L6;
        r104.j(r100, r101, r102, r103);
        return;
    }

    @JvmStatic
    public static final void d(MusicPanel r100, String r101, String r102, long r110) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "downloadUrl");
        c r103 = f512759a;
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102, r110);
        return;
    }

    @JvmStatic
    public static final void c(MusicPanel r100, String r101, String r102, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "downloadUrl");
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        c r103 = f512759a;
        if (r103 == null) goto L6;
        r103.f(r100, r101, r102, r110, r111);
        return;
    }
}
