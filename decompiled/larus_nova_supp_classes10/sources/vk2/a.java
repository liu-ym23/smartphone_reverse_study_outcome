package vk2;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final String a;

    public a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "innerTag");
        this.a = "Card".concat(r3);
        int r4 = ECSdk.a;
        IECHostService r5 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r5 == null) goto L5;
        vi.a r6 = r5.getIECHostAppInfo();
    L6:
        if (r6 != null) goto L8;
    L9:
        if (r6 == null) goto L13;
        r6.isLocalTest();
        return;
    L13:
        return;
    L8:
        if (r6.isDebug() != true) goto L9;
        return;
    L5:
        r6 = null;
        goto L6
    }
}
