package u0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends a {
    @Override // u0b.a
    public final boolean d(Context r100, ChameleonConfig r101) {
        return true;
    }

    public b() {
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use assert");
        return a(r100, r101, r102, r103);
    }
}
