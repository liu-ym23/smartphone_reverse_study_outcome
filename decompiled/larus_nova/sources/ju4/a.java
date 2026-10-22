package ju4;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableApplyProFragment f500480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTitleBar f500481b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f500480a.f215142t;
        if (r101 == null) goto L6;
        r101.a(true);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f500480a.f215142t;
        if (r101 == null) goto L5;
        r101.a(false);
    L5:
        this.f500481b.removeOnAttachStateChangeListener(this);
    }

    public a(BitableApplyProFragment r100, BaseTitleBar r101) {
        this.f500480a = r100;
        this.f500481b = r101;
    }
}
