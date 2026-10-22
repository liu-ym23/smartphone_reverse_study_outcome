package uo5;

import android.app.Activity;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends com.ss.android.lark.appcontext.applifecycle.a {
    public final /* synthetic */ FloatViewContainer a;

    public c(FloatViewContainer r1) {
        this.a = r1;
    }

    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        tt5.a.h("FloatViewContainer", "showInTopActivity, onActivityStarted ".concat(r2.getClass().getSimpleName()));
        FloatViewContainer r3 = this.a;
        boolean r0 = FloatViewContainer.k;
        r3.a();
    }

    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        tt5.a.h("FloatViewContainer", "showInTopActivity, onActivityStopped ".concat(r2.getClass().getSimpleName()));
        FloatViewContainer r3 = this.a;
        boolean r0 = FloatViewContainer.k;
        r3.a();
    }
}
