package d90;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPortrait");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.get("data_is_portrait", Boolean.TRUE);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return true;
    }
}
