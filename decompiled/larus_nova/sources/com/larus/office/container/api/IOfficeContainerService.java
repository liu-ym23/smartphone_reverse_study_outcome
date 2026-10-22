package com.larus.office.container.api;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import wn9.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/larus/office/container/api/IOfficeContainerService;", "", "getOfficeContainerRouter", "Lcom/bytedance/router/interceptor/IInterceptor;", "registerAppletApplication", "", "isOfficeContainerFragment", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "bizType", "", "registerArtifactInfoProvider", "artifactInfoProvider", "Lcom/larus/office/container/api/IArtifactInfoProvider;", "unregisterArtifactInfoProvider", "getArtifactInfoProvider", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeContainerService {
    void a();

    void b(a r100);

    xn9.a c();

    void d(a r100);

    a e();

    boolean f(Fragment r100, String r101);
}
