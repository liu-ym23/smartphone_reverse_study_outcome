package qk5;

import androidx.autofill.HintConstants;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements PhoneHelper.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gk5.a f533547a;

    public b(p r100) {
        this.f533547a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper.a
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f533547a.onCancel();
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper.a
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        nk5.b.b(this.f533547a, r100);
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper.a
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        this.f533547a.onSuccess(new org.json.JSONObject().put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, r100));
    }
}
