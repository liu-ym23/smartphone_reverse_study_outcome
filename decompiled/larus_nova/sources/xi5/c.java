package xi5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Consumer<Result<PrivacyResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f563953a;

    public c(PrivacyViewModel.b r100) {
        this.f563953a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Result<PrivacyResult> r100) throws Exception {
        Result<PrivacyResult> r101 = r100;
        tt5.a.b("GetPrivacyExecutor", "GetPrivacyExecutor doAction accept  result=" + r101);
        e.a r102 = this.f563953a;
        if (r102 == null) goto L6;
        PrivacyResult r103 = (PrivacyResult) r101.data;
        PrivacyViewModel.b r104 = (PrivacyViewModel.b) r102;
        PrivacyViewModel.access$502(r104.f234331a, null);
        PrivacyViewModel.access$200(r104.f234331a).setValue(1);
        yi5.b.b(r103.getAllowReadListSetting(), "allow_read_list_setting", PrivacyViewModel.access$000(r104.f234331a));
        PrivacyViewModel.access$300(r104.f234331a).setValue(Boolean.valueOf(r103.getAllowReadListSetting()));
        return;
    }
}
