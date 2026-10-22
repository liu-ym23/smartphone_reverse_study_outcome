package pb0;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f528406a;

    public b() {
    }

    static {
    }

    public static void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        a r102 = f528406a;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    public static void c(MusicPanel r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "fromRequestType");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        a r104 = f528406a;
        if (r104 == null) goto L6;
        r104.t(r100, r101, r102, null, r103);
        return;
    }

    public static void a(String r110, String r111, String r112, long r113, String r114, String r115, Integer r116, String r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "liveType");
        Intrinsics.checkNotNullParameter(r111, "roomType");
        Intrinsics.checkNotNullParameter(r112, "buttonActionType");
        Intrinsics.checkNotNullParameter(r114, "userType");
        a r100 = f528406a;
        if (r100 == null) goto L6;
        r100.v(r110, r111, r112, r113, r114, r115, r116, r210, r211);
        return;
    }
}
