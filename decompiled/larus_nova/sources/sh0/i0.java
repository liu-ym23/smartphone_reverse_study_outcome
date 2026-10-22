package sh0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i0 extends ne0.e {
    @Override // ne0.e
    public final void f() {
        DataCenter r100 = this.f518849a;
        int r101 = h0.f541915a;
        r100.put("dynamic_biz_state", new LinkedHashMap());
    }

    public final boolean g() {
        ne0.g r100 = this.f518850b;
        if (r100 == null) goto L5;
        int r101 = h0.f541915a;
        Boolean r102 = (Boolean) r100.a("is_danmu_game_on");
    L7:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L5:
        r102 = null;
        goto L7
    }

    public final boolean h() {
        ne0.g r100 = this.f518850b;
        if (r100 == null) goto L5;
        int r101 = h0.f541915a;
        Boolean r102 = (Boolean) r100.a("is_mic_seat_fold");
    L7:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L5:
        r102 = null;
        goto L7
    }

    public i0(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        super(r100);
    }
}
