package vd5;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.sidebar.model.SidebarDocTabVM;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f554194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ce5.a f554195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SidebarDocTabVM f554196c;

    public c(Fragment r100, ce5.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        this.f554194a = r100;
        this.f554195b = r101;
    }
}
