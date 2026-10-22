package uo5;

import android.app.Activity;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends com.ss.android.lark.appcontext.applifecycle.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatViewContainer f550920a;

    public c(FloatViewContainer r100) {
        this.f550920a = r100;
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        tt5.a.h("FloatViewContainer", "showInTopActivity, onActivityStarted ".concat(r100.getClass().getSimpleName()));
        FloatViewContainer r101 = this.f550920a;
        boolean r102 = FloatViewContainer.f239786k;
        r101.a();
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        tt5.a.h("FloatViewContainer", "showInTopActivity, onActivityStopped ".concat(r100.getClass().getSimpleName()));
        FloatViewContainer r101 = this.f550920a;
        boolean r102 = FloatViewContainer.f239786k;
        r101.a();
    }
}
