package kp2;

import android.view.View;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.livesdkapi.service.IExternalLynxComponent;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IExternalLynxComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridCard f505492a;

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void reload() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void updateData(Map<String, ? extends Object> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "args");
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void release() {
        this.f505492a.release();
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final View getHybridView() {
        return this.f505492a;
    }

    public a(HybridCard r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXHybridCard");
        this.f505492a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        a7.a.a(this.f505492a, r100, null, 2);
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.f505492a.updateData(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final <P, R> void registerStatefulMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        this.f505492a.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final <P, R> void registerStatelessMethod(String r100, g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        this.f505492a.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final void renderTemplate(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f505492a.load(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IExternalLynxComponent
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f505492a.sendJsEvent(r100, r101);
    }
}
