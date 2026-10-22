package d75;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ VersionOperationRecordV2Activity a;

    public m(VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        u55.b r4 = (u55.b) r3;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.c() == true) goto L9;
        Toast.showFailureText(this.a.getApplicationContext(), this.a.getResources().getString(2131888425), 1);
        this.a.finish();
        return;
    }
}
