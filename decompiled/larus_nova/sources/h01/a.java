package h01;

import android.view.View;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zr2.k;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends dy0.d {
    String W6(RevToolbarConstants r100, IRoom r101, boolean r102, RevResKeyEnum r103);

    void Ye(RevToolbarConstants r100, k r101, Function1<? super d, Unit> r102);

    void Za(RevToolbarConstants r100);

    void f5(RevToolbarConstants r100, k r101);

    void k1(boolean r100, View r101);

    void s0(RevToolbarConstants r100);

    boolean wk(RevToolbarConstants r100, IRoom r101, boolean r102, RevResKeyEnum r103);

    void y9(DataCenter r100, boolean r101);
}
