package khc;

import android.content.Intent;
import android.os.Message;
import com.ss.android.ugc.route_monitor.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f503596b = null;

    static {
        f503596b = new d();
    }

    public d() {
    }

    @Override // khc.c
    public final Intent a(Message r100) {
        int r101 = a.f503593a;
        Intent r102 = (Intent) u.c(r100.obj, "args");
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((!Intrinsics.areEqual("com.vivo.pushclient.action.RECEIVE", r102.getAction())) == true) goto L7;
        return r102;
    L7:
        return null;
    }
}
