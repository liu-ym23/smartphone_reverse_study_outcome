package kj5;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a {
    public b() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final String a(String r1, int r2, boolean r3) {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final void b(Context r1) {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final String c() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final Uri.Builder getReportHost() {
        return new Uri.Builder();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final Flowable<GetComplaintResult> d(int r1, String r2, boolean r3) {
        GetComplaintResult r4 = new GetComplaintResult();
        r4.setResult(0);
        return Flowable.just(r4);
    }
}
