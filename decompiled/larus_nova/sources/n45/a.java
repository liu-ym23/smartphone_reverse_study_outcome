package n45;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.web.CommonWebActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonWebActivity f517051a;

    public a(CommonWebActivity r100) {
        this.f517051a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        StringBuilder r102 = new StringBuilder("onChanged: network state = ");
        BaseTitleBar r103 = null;
        if (r101 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r101.a());
    L6:
        r102.append(r104);
        tt5.a.h("CommonWebActivity", r102.toString());
        int r105 = 0;
        if (r101 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        SpaceEmptyState r107 = this.f517051a.f222472f;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
        r107 = null;
    L16:
        if (r106 == false) goto L18;
        int r108 = 8;
    L19:
        r107.setVisibility(r108);
        FrameLayout r109 = this.f517051a.f222473g;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFrameLayout");
        r109 = null;
    L22:
        if (r106 == true) goto L25;
        r105 = 8;
    L25:
        r109.setVisibility(r105);
        if (r106 == false) goto L30;
        CommonWebActivity r110 = this.f517051a;
        if (r106 == r110.f222475i) goto L30;
        r110.C1().reload();
    L30:
        BaseTitleBar r111 = this.f517051a.f222471e;
        if (r111 == null) goto L33;
        r103 = r111;
    L34:
        r103.setMainTitleVisible(r106);
        this.f517051a.f222475i = r106;
        return;
    L33:
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        goto L34
    L18:
        r108 = 0;
        goto L19
    L9:
        if (r101.a() == false) goto L11;
        r106 = true;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
