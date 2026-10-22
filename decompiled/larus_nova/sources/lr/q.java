package lr;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class q implements ri.b {
    public q() {
    }

    @Override // ri.b
    public final void a(Activity r100, String r101, ri.a r102) {
    }

    @Override // ri.b
    public final void b() {
    }

    @Override // ri.b
    public final void c(ECUrlModel r100, Function1 r101) {
    }

    @Override // ri.b
    public final void d() {
    }

    @Override // ri.b
    public final boolean isDownloaded(Uri r100) {
        return false;
    }

    @Override // ri.b
    public final void bindImage(SimpleDraweeView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
    }
}
