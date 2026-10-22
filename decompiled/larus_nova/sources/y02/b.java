package y02;

import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f565564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f565565b;

    public final void e() {
        if (((ArrayList) this.f565564a).size() != 0) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r100 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d r101 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.NO_CONSUMER, this.f565565b + " no consumer");
        r100.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a(BDLocationException.ERROR_TMAP_CLIENT, this + " triggerNewMessageArrived mListeners.size = 0", "-1", r101);
    L5:
        Iterator r102 = ((ArrayList) this.f565564a).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((e) r102.next()).b();
        goto L7
    }

    public b() {
        this.f565564a = new ArrayList();
        this.f565565b = "BaseMsgQueue";
    }

    @Override // y02.f
    public final void c(com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f565564a).contains(r100) == true) goto L6;
        ((ArrayList) this.f565564a).add(r100);
        return;
    }
}
