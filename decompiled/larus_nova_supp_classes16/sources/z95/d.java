package z95;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements Observer {
    public final /* synthetic */ FailedToRetryView a;

    public /* synthetic */ d(FailedToRetryView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        FailedToRetryView.a(this.a, (Boolean) r2);
    }
}
