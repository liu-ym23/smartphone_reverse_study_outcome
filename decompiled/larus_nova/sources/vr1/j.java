package vr1;

import android.content.Context;
import android.net.Uri;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
import com.bytedance.android.livesdk.interactivity.interactive.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public interface j {
    Jsb2MethodFinder A();

    Uri E(Uri r100, DataCenter r101);

    Disposable F(Function1<? super String, Unit> r100);

    Map<String, String> I(DataCenter r100);

    v61.a J(DataCenter r100, boolean r101, Function0 r102, Function0 r103);

    void K();

    <P, R> void a(Object r100, String r101, com.bytedance.ies.web.jsbridge2.g<P, R> r102);

    AnnieXWebKit c(Context r100, Uri r101, Object r102, Map r103, Function1 r104, Function2 r105);

    SSWebView d(Object r100);

    void dataMapping(String r100, String r101, Map<String, String> r102);

    void f(j0 r100);

    com.bytedance.live.datacontext.m<Boolean> g(DataCenter r100);

    HybridCard getHybridCard(Context r100, Uri r101, b7.a r102);

    MutableLiveData<String> getSeiUpdate();

    boolean h();

    void i(Object r100, Object r101);

    void j(DataCenter r100, CompositeDisposable r101, Function0<Unit> r102);

    void k(DataCenter r100, IRoom r101, km1.a r102, LifecycleOwner r103, Function1<? super IBannerInfo, Unit> r104, Function1<? super Throwable, Unit> r105, Function0<Unit> r106);

    void n(Object r100);

    void o(DataCenter r100);

    boolean q();

    void s(Object r100);

    void w(Window r100);

    void x(Object r100, String r101, Object r102);

    com.bytedance.live.datacontext.m<Boolean> y(DataCenter r100);
}
