package gy0;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.live.base.IService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import dy0.c;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends IService, c {
    void D3(Gson r100, Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r101);

    void P2(DataCenter r100);

    void m5(Gson r100, DataCenter r101, Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r102);
}
