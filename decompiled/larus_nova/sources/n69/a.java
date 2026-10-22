package n69;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f518171a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        c.a();
        this.f518171a.invoke();
        String r100 = UriProtector.parse("sslocal://flow/webview?.product_id=16&link_url=https://www.olafriend.com/alice/w/h5/dorag/reset_instruction").buildUpon().build().toString();
        SmartRouter.buildRoute(AppHost.f326268a.getApplication(), r100).d();
    }

    public a(Function0<Unit> r100) {
        this.f518171a = r100;
    }
}
