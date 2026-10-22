package xi5;

import com.bytedance.ee.bear.middleground.record.privacy.PrivacyViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Consumer<Throwable> {
    public final /* synthetic */ e.a a;

    public d(PrivacyViewModel.b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        tt5.a.e("GetPrivacyExecutor", " doAction failed", (Throwable) r4, false);
        e.a r5 = this.a;
        if (r5 == null) goto L6;
        PrivacyViewModel.b r6 = (PrivacyViewModel.b) r5;
        PrivacyViewModel.access$502(r6.a, null);
        PrivacyViewModel.access$200(r6.a).setValue(4);
        return;
    }
}
