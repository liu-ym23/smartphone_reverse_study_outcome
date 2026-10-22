package xk2;

import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564187a;

    public b(a r100) {
        this.f564187a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        e r101 = this.f564187a.f564184e;
        long r102 = ((long) r100.optInt("delay_seconds", 0)) * 1000;
        if (r101 == null) goto L7;
        Handler r103 = UtilityKotlinExtentionsKt.f153057b;
        r103.removeCallbacks(r101);
        r103.postDelayed(r101, r102);
        return;
    }
}
