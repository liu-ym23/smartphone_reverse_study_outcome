package js2;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f500198a;

    public b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f500198a = r100;
    }

    public void a(int r100) {
        if (r100 != 10) goto L6;
        this.f500198a.put("data_has_commerce_shopping_list", Boolean.TRUE);
        return;
    L6:
        if (r100 != 11) goto L10;
        this.f500198a.put("data_has_commerce_shopping_list", Boolean.FALSE);
        return;
    }
}
