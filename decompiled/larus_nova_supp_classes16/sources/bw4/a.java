package bw4;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.clip.ClipExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements ValueCallback {
    public final /* synthetic */ ClipExecutor a;

    public a(ClipExecutor r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r3) {
        String r4 = (String) r3;
        tt5.a.h("DocsClip#ClipExecutor", "checkJsReady ret = " + r4);
        if (Intrinsics.areEqual(r4, "true") == true) goto L6;
        this.a.b();
        return;
    }
}
