package d75;

import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.biz.versions.adapter.VersionOperationRecordAdapter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements gqa.b {
    public final /* synthetic */ VersionOperationRecordV2Activity a;

    public l(VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    public final void O0(cqa.h r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        VersionOperationRecordV2Activity r7 = this.a;
        int r0 = VersionOperationRecordV2Activity.r;
        final i r1 = (i) r7.d;
        if (r1 == null) goto L10;
        String r2 = r7.k;
        VersionOperationRecordAdapter r8 = r7.j;
        if (r8 == null) goto L7;
        long r3 = r8.e;
    L8:
        Disposable r9 = r1.f.a(r2, 20, r3).observeOn(fo5.d.d()).subscribe(new g(r1), new h());
        r1.e.add(r9);
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
