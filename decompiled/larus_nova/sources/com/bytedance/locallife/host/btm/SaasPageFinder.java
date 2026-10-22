package com.bytedance.locallife.host.btm;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/host/btm/SaasPageFinder;", "", "", "isEmpty", "<init>", "()V", "Companion", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public final class SaasPageFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f258860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f258861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f258862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f258863d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/host/btm/SaasPageFinder$Companion;", "", "()V", "via", "Lcom/bytedance/locallife/host/btm/SaasPageFinder;", "view", "Landroid/view/View;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "page", "btmPageId", "", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public final SaasPageFinder via(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            SaasPageFinder r101 = new SaasPageFinder();
            r101.f258862c = r100;
            return r101;
        }

        public final SaasPageFinder via(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            SaasPageFinder r101 = new SaasPageFinder();
            r101.f258863d = r100;
            return r101;
        }

        public final SaasPageFinder via(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "page");
            SaasPageFinder r101 = new SaasPageFinder();
            r101.f258861b = r100;
            return r101;
        }

        public final SaasPageFinder via(String r100) {
            Intrinsics.checkNotNullParameter(r100, "btmPageId");
            SaasPageFinder r101 = new SaasPageFinder();
            r101.f258860a = r100;
            return r101;
        }
    }

    public SaasPageFinder() {
    }

    static {
        new Companion();
    }

    public final boolean isEmpty() {
        if (this.f258861b == null) goto L5;
    L11:
        return false;
    L5:
        if (this.f258862c != null) goto L11;
        if (this.f258863d != null) goto L11;
        if (TextUtils.isEmpty(this.f258860a) == false) goto L11;
        return true;
    }
}
