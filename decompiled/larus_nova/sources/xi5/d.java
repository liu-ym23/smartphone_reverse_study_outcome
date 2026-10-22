package xi5;

import com.bytedance.ee.bear.middleground.record.privacy.PrivacyViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f563954a;

    public d(PrivacyViewModel.b r100) {
        this.f563954a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("GetPrivacyExecutor", " doAction failed", r100, false);
        e.a r101 = this.f563954a;
        if (r101 == null) goto L6;
        PrivacyViewModel.b r102 = (PrivacyViewModel.b) r101;
        PrivacyViewModel.access$502(r102.f234331a, null);
        PrivacyViewModel.access$200(r102.f234331a).setValue(4);
        return;
    }
}
