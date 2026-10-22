package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public static final /* synthetic */ int d = 0;
    public final ECUrlModel a;
    public final String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public m(ECUrlModel r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r4, "jumpUrl");
        Intrinsics.checkNotNullParameter("window_private_message", "name");
        this.a = r3;
        this.b = r4;
        this.c = "window_private_message";
    }
}
