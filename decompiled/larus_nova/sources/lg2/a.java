package lg2;

import com.bytedance.android.livesdk.config.h41;
import com.bytedance.android.livesdk.config.i41;
import com.bytedance.android.livesdk.config.o10;
import com.bytedance.android.livesdk.config.p10;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i41 f509129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h41 f509130b = null;

    static {
        f509129a = p10.f120948a.getValue();
        f509130b = o10.f120875a.getValue();
    }

    public static boolean a(String r100, String r101, boolean r102) {
        if (r102 == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        String r103 = r100 + "_" + r101;
        if (f509129a.c() == 0) goto L18;
        List<String> r104 = f509130b.h();
        if (r104 == null) goto L14;
        boolean r105 = r104.contains(r103);
    L15:
        if (r105 == false) goto L19;
        return true;
    L19:
        return false;
    L14:
        r105 = false;
        goto L15
    L18:
        return false;
    }

    @JvmStatic
    public static final boolean b(String r100, String r101, boolean r102) {
        if (r102 == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        String r103 = r100 + "_" + r101;
        i41 r104 = f509129a;
        if (r104.c() != 0) goto L12;
        return false;
    L12:
        if (r104.f().contains(r103) == false) goto L16;
        return true;
    L16:
        return false;
    }
}
