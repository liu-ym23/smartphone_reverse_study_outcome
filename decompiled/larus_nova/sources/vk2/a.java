package vk2;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555469a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "innerTag");
        this.f555469a = "Card".concat(r100);
        int r101 = ECSdk.f48106a;
        IECHostService r102 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r102 == null) goto L5;
        vi.a r103 = r102.getIECHostAppInfo();
    L6:
        if (r103 != null) goto L8;
    L9:
        if (r103 == null) goto L13;
        r103.isLocalTest();
        return;
    L13:
        return;
    L8:
        if (r103.isDebug() != true) goto L9;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
