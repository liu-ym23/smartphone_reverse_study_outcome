package kl3;

import android.content.Context;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f503847a;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f503847a = r100;
    }

    public final void a(JSONObject r100, Function2<? super Integer, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "payParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        int r102 = TTPay.f187579a;
        TTPay.a(this.f503847a, r100, r101);
    }
}
