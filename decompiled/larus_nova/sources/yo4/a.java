package yo4;

import com.bytedance.ee.bear.bitable.baserecord.view.BitableLynxRecordView;
import com.bytedance.lark.lark_bitable_android.t0;
import kotlin.jvm.internal.Intrinsics;
import no4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableLynxRecordView f568665a;

    public a(BitableLynxRecordView r100) {
        this.f568665a = r100;
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordData");
        tt5.a.h("BitableLynxRecordView", "getRecordDataResult success");
        tu4.b.f(this.f568665a.f207071b, "SHARE_RECORD_FETCH_LYNX_DATA_END", System.currentTimeMillis());
        this.f568665a.f207074e.postValue(r100);
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void b(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        tu4.b.f(this.f568665a.f207071b, "SHARE_RECORD_FETCH_LYNX_DATA_END", System.currentTimeMillis());
        d r102 = this.f568665a.f207076g;
        if (r102 == null) goto L6;
        r102.a((int) r100, "fetchDataFailed: " + r101);
        return;
    }
}
