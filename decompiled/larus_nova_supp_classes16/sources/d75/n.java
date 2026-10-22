package d75;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ VersionOperationRecordV2Activity a;

    public n(VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        VersionPayLoadData r8 = (VersionPayLoadData) r7;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.getOperation() != 101) goto L8;
    L9:
        SmartRefreshLayout r9 = this.a.g;
        if (r9 != null) goto L12;
        return;
    L12:
        if (r9.E2 == false) goto L14;
        int r0 = 0;
    L15:
        int r2 = r9.f;
        float r3 = (r9.y1 / 2.0f) + 0.5f;
        int r4 = r9.g1;
        float r5 = (r3 * r4) * 1.0f;
        if (r4 != 0) goto L18;
        r4 = 1;
    L18:
        r9.r(r0, r2, r5 / r4, false);
        return;
    L14:
        r0 = 400;
        goto L15
    L8:
        if (r8.getOperation() == 102) goto L9;
    }
}
