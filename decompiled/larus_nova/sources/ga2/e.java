package ga2;

import com.bytedance.android.live.core.network.CustomApiServerException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$prompt");
        if ((r100 instanceof CustomApiServerException) == false) goto L10;
        CustomApiServerException r101 = (CustomApiServerException) r100;
        String r102 = r101.getPrompt();
        if (r102 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r102)) == true) goto L9;
        return null;
    L9:
        return r101.getPrompt();
    L10:
        return null;
    }
}
