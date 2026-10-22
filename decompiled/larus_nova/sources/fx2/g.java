package fx2;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMarketingLiveLynxViewService f479106a;

    @Override // fx2.f
    public final View getHybridView() {
        IMarketingLiveLynxViewService r100 = this.f479106a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getView();
    }

    @Override // fx2.f
    public final View getKitView() {
        IMarketingLiveLynxViewService r100 = this.f479106a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKitView();
    }

    @Override // fx2.f
    public final void release() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        IMarketingLiveLynxViewService r101 = this.f479106a;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.release();     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // fx2.f
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IMarketingLiveLynxViewService r101 = this.f479106a;
        if (r101 == null) goto L6;
        r101.updateGlobalProps(r100);
        return;
    }

    @Override // fx2.f
    public final void renderTemplate(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IMarketingLiveLynxViewService r102 = this.f479106a;
        if (r102 == null) goto L6;
        r102.renderTemplate(r100, r101);
        return;
    }

    @Override // fx2.f
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        IMarketingLiveLynxViewService r102 = this.f479106a;
        if (r102 == null) goto L6;
        r102.sendJSEvent(r100, r101);
        return;
    }

    public g(Activity r100, String r101, kf.a r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        IMarketingLiveLynxViewService r104 = (IMarketingLiveLynxViewService) ServiceManager.get().getService(IMarketingLiveLynxViewService.class);     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        IMarketingLiveLynxViewService r105 = r104.createLynxComponent(r100, r101, r102);     // Catch: Throwable -> L9
    L7:
        this.f479106a = r105;     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
