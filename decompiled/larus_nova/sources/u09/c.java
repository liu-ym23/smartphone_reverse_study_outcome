package u09;

import com.larus.utils.t0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f548208a = 0;

    static {
    }

    public static void a(final String r100, Integer r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r101 == null) goto L16;
        int r103 = a.f548205a;
        int r104 = r101.intValue();
        if (r104 <= 0) goto L13;
        boolean r105 = true;
        if (r104 != 1) goto L11;
    L14:
        if (r105 == true) goto L16;
        return;
    L11:
        if ((System.currentTimeMillis() % ((long) r104)) == 0) goto L14;
    L13:
        r105 = false;
    L16:
        final JSONObject r106 = (JSONObject) r102.invoke();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r106, "params");
        t0.a(new b(r100, r106));
    }
}
