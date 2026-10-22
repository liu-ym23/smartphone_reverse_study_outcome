package f0c;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f475023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f475024b;

    public static final class a {
        public static b a(g r100, UserState r101, h r102, lzb.a r103) {
            Intrinsics.checkNotNullParameter(r101, "initAbsentState");
            Intrinsics.checkNotNullParameter(r102, "statePayload");
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r102.f475035a != UserState.OFFLINE) goto L6;
            return new e(r100, r102.f475036b, r103);
        L6:
            return new f(r100, r102.f475036b, r103);
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{state:");
        r100.append(this.f475024b.f475035a);
        r100.append(", userid:");
        g r101 = a();
        String r102 = null;
        if (r101 == null) goto L7;
        User r103 = r101.f475033a;
        if (r103 == null) goto L7;
        String r104 = r103.userId;
    L8:
        r100.append(r104);
        r100.append(", session:");
        g r105 = a();
        if (r105 == null) goto L13;
        UserSession r106 = r105.f475034b;
        if (r106 == null) goto L13;
        r102 = r106.f438137a;
    L13:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L7:
        r104 = null;
        goto L8
    }

    public g a() {
        return this.f475023a;
    }

    public b(g r100, h r101) {
        this.f475023a = r100;
        this.f475024b = r101;
    }
}
