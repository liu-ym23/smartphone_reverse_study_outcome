package t1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import x1c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // x1c.d
    public final x1c.b y1() {
        d r100 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r100 != null) goto L7;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getCurrentDoubaoUserInfo implementation");
        return new x1c.b("", "", false, false);
    L7:
        return r100.y1();
    }

    @Override // x1c.d
    public final void A0(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "doubaoUserId");
        d r102 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r102 == null) goto L5;
        r102.A0(r100, r101);
        return;
    L5:
        Log.w("OfficeProfileProtocolProxy", "Using fallback navigateToDoubaoHomepage implementation");
    }

    @Override // x1c.d
    public final Object C(String r100, Continuation<? super x1c.a> r101) {
        d r102 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r102 != null) goto L5;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getDoubaoHomepageData implementation");
        return new x1c.a(CollectionsKt.emptyList());
    L5:
        return r102.C(r100, r101);
    }

    @Override // x1c.d
    public final Object n1(String r100, Continuation<? super x1c.b> r101) {
        d r102 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r102 != null) goto L5;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getDoubaoUserInfo implementation");
        return new x1c.b("", "", false, false);
    L5:
        return r102.n1(r100, r101);
    }
}
