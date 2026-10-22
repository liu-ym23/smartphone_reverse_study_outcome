package xi5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Consumer<Result<PrivacyResult>> {
    public final /* synthetic */ e.a a;

    public c(PrivacyViewModel.b r1) {
        this.a = r1;
    }

    public final void accept(Object r5) throws Exception {
        Result r6 = (Result) r5;
        tt5.a.b("GetPrivacyExecutor", "GetPrivacyExecutor doAction accept  result=" + r6);
        e.a r0 = this.a;
        if (r0 == null) goto L6;
        PrivacyResult r7 = (PrivacyResult) r6.data;
        PrivacyViewModel.b r1 = (PrivacyViewModel.b) r0;
        PrivacyViewModel.access$502(r1.a, null);
        PrivacyViewModel.access$200(r1.a).setValue(1);
        yi5.b.b(r7.getAllowReadListSetting(), "allow_read_list_setting", PrivacyViewModel.access$000(r1.a));
        PrivacyViewModel.access$300(r1.a).setValue(Boolean.valueOf(r7.getAllowReadListSetting()));
        return;
    }
}
