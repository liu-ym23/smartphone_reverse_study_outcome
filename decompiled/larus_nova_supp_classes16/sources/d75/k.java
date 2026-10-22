package d75;

import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements gqa.d {
    public final /* synthetic */ VersionOperationRecordV2Activity a;

    public k(VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    public final void d2(cqa.h r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        VersionOperationRecordV2Activity r4 = this.a;
        int r0 = VersionOperationRecordV2Activity.r;
        i r1 = (i) r4.d;
        if (r1 == null) goto L6;
        r1.j(r4.k, false);
        return;
    }
}
