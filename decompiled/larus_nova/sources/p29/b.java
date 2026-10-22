package p29;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f527469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f527470b;

    public b() {
        this.f527469a = new LinkedHashSet();
        this.f527470b = new LinkedHashSet();
    }

    public static void a(b r210, String r211, String r212, Boolean r213, String r214, String r215, String r310, Boolean r311, Boolean r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412) {
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r210.f527469a.contains(r410) == true) goto L7;
        r210.f527469a.add(r410);
        a4.e(r211, null, r212, r213, r214, "0", null, null, r215, r310, r110, null, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
        return;
    }

    public static void b(b r210, String r211, String r212, Boolean r213, String r214, Long r215, Boolean r310, String r311, String r312, Boolean r313, Boolean r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414) {
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r210.f527470b.contains(r412) == true) goto L7;
        r210.f527470b.add(r412);
        a4.l(r211, null, r212, r213, r214, r215, r310, "0", r311, r312, r110, null, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
        return;
    }
}
