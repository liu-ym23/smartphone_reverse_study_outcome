package com.bytedance.caijing.sdk.infra.base.api.btm;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJPageFinder;", "", "page", "via", "Landroid/view/View;", "view", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "btmPageId", "", "isEmpty", "<init>", "()V", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final class CJPageFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f202206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f202207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f202208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f202209d;

    public CJPageFinder() {
    }

    public final boolean isEmpty() {
        if (this.f202207b == null) goto L5;
    L11:
        return false;
    L5:
        if (this.f202208c != null) goto L11;
        if (this.f202209d != null) goto L11;
        if (TextUtils.isEmpty(this.f202206a) == false) goto L11;
        return true;
    }

    public final CJPageFinder via(View r100) {
        CJPageFinder r101 = new CJPageFinder();
        r101.f202208c = r100;
        return r101;
    }

    public final CJPageFinder via(Fragment r100) {
        CJPageFinder r101 = new CJPageFinder();
        r101.f202209d = r100;
        return r101;
    }

    public final CJPageFinder via(Object r100) {
        CJPageFinder r101 = new CJPageFinder();
        r101.f202207b = r100;
        return r101;
    }

    public final CJPageFinder via(String r100) {
        CJPageFinder r101 = new CJPageFinder();
        r101.f202206a = r100;
        return r101;
    }
}
