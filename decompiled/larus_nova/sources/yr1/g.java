package yr1;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: classes8.dex */
public interface g {
    void A(String r100, long r101, String r102);

    Disposable E(Function1<Object, Unit> r100);

    void F(DataCenter r100);

    void I();

    void J(boolean r100);

    Disposable K(Function4<? super Boolean, ? super Integer, ? super String, ? super Boolean, Unit> r100);

    void a(Episode r100, Map<String, String> r101);

    void c(long r100, String r101, Bundle r102);

    void d(LifecycleOwner r100, Function0<Unit> r101);

    void f();

    Disposable g(Function1<? super vk1.a, Unit> r100);

    Disposable h(Function5<? super Integer, ? super Integer, ? super Integer, ? super String, Object, Unit> r100);

    void i(LifecycleOwner r100, Function1<? super Uri, Unit> r101);

    void j(String r100, SendReplayTextEvent.Sender r101, Map<String, ? extends Object> r102);

    Disposable k(Function1<? super String, Unit> r100);

    Disposable n(Function6<? super Long, ? super String, ? super Bundle, ? super String, ? super Boolean, ? super Boolean, Unit> r100);

    void o();

    void q(LifecycleOwner r100, Function3<? super Integer, ? super Integer, ? super KeyEvent, Unit> r101);

    Disposable s(Function1<? super SendReplayTextEvent, Unit> r100);

    void w();

    void x(int r100, KeyEvent r101);

    void y(SendReplayTextEvent r100, boolean r101);
}
