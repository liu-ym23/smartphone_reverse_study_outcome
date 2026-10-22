package x5c;

import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.statistics.Statistics;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class b implements o5c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562572a;

    public static final class a {
    }

    static {
    }

    @Inject
    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f562572a = r100;
    }

    @Override // o5c.b
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        Statistics.sendEvent(r100, r101.put("sub_user_id", this.f562572a));
    }
}
