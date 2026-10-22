package vy0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import wy0.g;

/* JADX INFO: loaded from: classes47.dex */
public interface b extends f80.a, o {
    Observable<g> B0(String r100);

    Disposable Sb(wy0.d r100);

    HybridDialogImpl U0(Context r100, Uri r101, Function1 r102);

    String appendCommonParams(String r100);

    void sendEventToAllJsBridges(String r100, Object r101);
}
