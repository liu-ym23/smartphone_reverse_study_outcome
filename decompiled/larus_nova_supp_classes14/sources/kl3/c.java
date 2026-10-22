package kl3;

import android.content.Context;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final Context a;

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(JSONObject r2, Function2<? super Integer, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "payParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        int r0 = TTPay.a;
        TTPay.a(this.a, r2, r3);
    }
}
