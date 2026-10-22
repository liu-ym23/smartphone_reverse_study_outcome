package u80;

import android.text.Editable;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.verify.fragment.CommonVerifyFragment;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonVerifyFragment f549160a;

    public i(CommonVerifyFragment r100) {
        this.f549160a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        CommonVerifyFragment.T90(this.f549160a);
    }
}
