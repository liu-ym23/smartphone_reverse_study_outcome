package jn1;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.n5;
import com.bytedance.android.livesdk.o5;
import com.bytedance.android.livesdkapi.model.GameIntroduceCardResponseNew;
import is2.b;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements b {
    public a() {
    }

    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // is2.b
    public final void d() {
    }

    @Override // is2.b
    public final boolean f() {
        return true;
    }

    @Override // is2.b
    public final String getPath() {
        return "webcast_gamecp_user_enter_introduce";
    }

    @Override // is2.b
    public final boolean enable() {
        if (o5.f154128a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(n5.f153997a.getValue(), Boolean.FALSE) == false) goto L7;
        return true;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return GameIntroduceCardResponseNew.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", enable());
        return r102;
    }
}
