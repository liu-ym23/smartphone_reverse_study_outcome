package xk2;

import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements j {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        e r0 = this.a.e;
        long r1 = ((long) r6.optInt("delay_seconds", 0)) * 1000;
        if (r0 == null) goto L7;
        Handler r7 = UtilityKotlinExtentionsKt.b;
        r7.removeCallbacks(r0);
        r7.postDelayed(r0, r1);
        return;
    }
}
