package kn1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.jo0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f504154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f504155b = null;

    public e() {
    }

    static {
        f504155b = new e();
        f504154a = jo0.f120541a.getValue();
    }

    @Override // kn1.d
    public final void a(tw2.b r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        if (f504154a.booleanValue() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isIgnored() == true) goto L29;
        String r103 = r100.getSpm();
        if (r103 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r103, "") == false) goto L14;
        return;
    L14:
        HashMap r104 = new HashMap();
        if ((!r101.isEmpty()) == false) goto L24;
        r104.putAll(r101);
    L24:
        Map<String, Object> r105 = r100.getPropertyParams();     // Catch: IllegalStateException -> L21
        if (r105 == null) goto L28;
        r104.putAll(r105);     // Catch: IllegalStateException -> L21
        Unit r106 = Unit.INSTANCE;     // Catch: IllegalStateException -> L21
        return;
    L28:
        return;
    L21:
        e = move-exception;
        ALogger.w("", e);
        Unit r107 = Unit.INSTANCE;
        return;
    }
}
