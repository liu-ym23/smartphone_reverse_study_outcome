package vy0;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wy0.f;
import wy0.g;

/* JADX INFO: loaded from: classes47.dex */
public interface c extends f80.a, dy0.c, b {
    Observable<g> B0(String r100);

    e J8(Context r100, Uri r101, Function1 r102);

    Disposable O3(f r100);

    Uri Q(String r100);

    HybridDialogImpl U0(Context r100, Uri r101, Function1 r102);

    com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a Ui(Context r100, Uri r101, Object r102, Function1 r103);

    void addHybridDebugTool(Context r100, ViewGroup r101, String r102, boolean r103);

    String appendFeedCommonParams(String r100, IRoom r101);

    void j1(Context r100, String r101);

    HybridDialogImpl mg(Context r100, Uri r101, Function1 r102);

    com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a q8(Context r100, Uri r101, Function1 r102);

    void sendEventToAllJsBridges(String r100, Object r101);

    void tn(zy0.b r100);

    Single<String> v8(String r100, Context r101);

    void x6(Context r100, String r101, Function1<? super yy0.e, Unit> r102);
}
