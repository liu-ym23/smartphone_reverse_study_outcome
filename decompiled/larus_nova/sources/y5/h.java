package y5;

import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.view.popup.RadiusLayout;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f566197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RadiusLayout f566198c;

    @Override // x5.a
    public final void invoke() {
        this.f566198c.setRadiusNew(this.f566196a.getRadius());
    }

    public h(AppletPopupSchemaParam r100, ViewGroup r101, RadiusLayout r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "popupContainer");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f566196a = r100;
        this.f566197b = r101;
        this.f566198c = r102;
    }
}
