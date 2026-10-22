package r1a;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements BaseComponentWidget.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseComponentWidget<?> f535681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentStateController f535682b;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget.b
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        BaseComponentWidget<?> r101 = this.f535681a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r101.f375152h.remove(this);
        ComponentStateController r102 = this.f535682b;
        if (r102.f375169e != null) goto L6;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r102.f375169e = r100;
        return;
    }

    public b(BaseComponentWidget<?> r100, ComponentStateController r101) {
        this.f535681a = r100;
        this.f535682b = r101;
    }
}
