package d75;

import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements EmptyView.a {
    public final /* synthetic */ VersionOperationRecordV2Activity a;

    public j(VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
    public final void onFailedRetry() {
        VersionOperationRecordV2Activity r0 = this.a;
        int r1 = VersionOperationRecordV2Activity.r;
        i r2 = (i) r0.d;
        if (r2 == null) goto L6;
        r2.j(r0.k, true);
        return;
    }
}
