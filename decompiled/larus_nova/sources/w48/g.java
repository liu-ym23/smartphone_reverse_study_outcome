package w48;

import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class g implements v48.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<String, String, Unit> f558261a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function2<? super String, ? super String, Unit> r100) {
        this.f558261a = r100;
    }

    @Override // v48.e
    public final void onGetId(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
        Intrinsics.checkNotNullParameter(r102, "ssid");
        com.larus.applog.impl.a.f(r100, r101, "onGetId");
        this.f558261a.invoke(r100, r101);
        Intrinsics.checkNotNullParameter(this, "listener");
        ((CopyOnWriteArrayList) com.larus.applog.impl.a.f287059b).remove(this);
    }
}
