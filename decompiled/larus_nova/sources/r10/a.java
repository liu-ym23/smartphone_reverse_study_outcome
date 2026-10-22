package r10;

import amc.f;
import android.content.Context;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.c10;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import st2.b;
import vlc.d;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535602a = 0;

    static {
    }

    public static d a(Context r110, long r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = ((IUserService) k.n(IUserService.class)).user().n();
        ArrayList r101 = new ArrayList();
        s10.a r102 = new s10.a(r110, r111, r100, r112, r101);
        int r113 = vs1.d.f556977a;
        c10 r114 = c10.f119914a;
        if (r114.getValue().d() == false) goto L6;
        return b.a(r114.getValue().c(), r114.getValue().a(), r102.f(), r101, null, null);
    L6:
        return f.a(r102);
    }
}
