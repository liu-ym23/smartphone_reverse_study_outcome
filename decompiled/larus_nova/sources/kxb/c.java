package kxb;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.hang.detect.JSPingCheckSource;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class c<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f506616a;

    public c(b r100) {
        this.f506616a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        Lazy<Handler> r102 = ThreadUtil.f437211a;
        ThreadUtil.a.e(this.f506616a.f506612m);
        if (this.f506616a.f506606g == false) goto L14;
        if (r101 == null) goto L7;
        String r103 = StringsKt.replace$default(r101, "\"", "", false, 4, null);
    L9:
        if (Intrinsics.areEqual(r103, BitableAnalytic.SelectSceneClickType.COMPLETE) == false) goto L11;
        b.a(this.f506616a, JSPingCheckSource.AFTER_READY.getValue());
        return;
    L11:
        j.e("RunJSPingHangDetector", "page is " + r103 + ", not ready, wait " + this.f506616a.f506604e + "ms to ping");
        b r104 = this.f506616a;
        ThreadUtil.a.d(r104.f506611l, r104.f506604e);
        return;
    L7:
        r103 = null;
        goto L9
    }
}
