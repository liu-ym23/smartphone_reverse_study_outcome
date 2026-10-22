package ne0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f518857a;

    public g(e r100) {
        this.f518857a = r100;
    }

    public final <T> T a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.f518857a.f518849a.get(r100);
        if (r101 != null) goto L11;
        e r102 = this.f518857a.f518854f;
        if (r102 == null) goto L12;
        g r103 = r102.f518850b;
        if (r103 != null) goto L13;
        return null;
    L13:
        return (T) r103.a(r100);
    L12:
        return r101;
    L11:
        return r101;
    }

    public final DataCenter b(String r100, Observer<KVData> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518857a.f518849a.observe(r100, r101);
    }
}
