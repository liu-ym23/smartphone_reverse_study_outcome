package z95;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class d implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FailedToRetryView f571013a;

    public /* synthetic */ d(FailedToRetryView r100) {
        this.f571013a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FailedToRetryView.a(this.f571013a, (Boolean) r100);
    }
}
