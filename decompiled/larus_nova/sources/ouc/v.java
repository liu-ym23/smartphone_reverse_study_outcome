package ouc;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class v extends a {
    public v(f r100, kotlinx.serialization.modules.d r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        super(r100, r101);
        if (Intrinsics.areEqual(r101, kotlinx.serialization.modules.i.f505488a) == true) goto L7;
        r101.a(new kotlinx.serialization.json.internal.i0(r100.f526840i, r100.f526841j));
        return;
    }
}
