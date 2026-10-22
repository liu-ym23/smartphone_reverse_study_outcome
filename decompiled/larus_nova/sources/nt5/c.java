package nt5;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.larkwebview.quality.hang.detect.JSPingCheckSource;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f520515a;

    public c(b r100) {
        this.f520515a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        b.RunnableC6973b r102 = this.f520515a.f520511m;
        if (r102 != null) goto L5;
        Handler r103 = mz7.b.f516538a;
    L7:
        if (this.f520515a.f520505g == false) goto L22;
        if (r101 == null) goto L11;
        String r104 = StringsKt.replace$default(r101, "\"", "", false, 4, null);
    L13:
        if (Intrinsics.areEqual(r104, BitableAnalytic.SelectSceneClickType.COMPLETE) == false) goto L15;
        b.a(this.f520515a, JSPingCheckSource.AFTER_READY.getValue());
        return;
    L15:
        Log.i("RunJSPingHangDetector", "page is " + r104 + ", not ready, wait " + this.f520515a.f520503e + "ms to ping");
        b r105 = this.f520515a;
        b.c r106 = r105.f520510l;
        long r107 = r105.f520503e;
        if (r107 > 0) goto L18;
        mz7.b.a(r106);
        return;
    L18:
        mz7.b.f516538a.postDelayed(r106, r107);
        return;
    L11:
        r104 = null;
        goto L13
    L22:
        return;
    L5:
        mz7.b.f516538a.removeCallbacks(r102);
        goto L7
    }
}
