package h05;

import android.view.View;
import com.bytedance.ee.bear.contract.j;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.more.protocol3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f483438a;

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final View.OnClickListener a() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final String b() {
        if (j.a.f217090a.getNetworkState().a() == false) goto L5;
        return "";
    L5:
        return this.f483438a.e(R.string.Doc_List_OperateFailedNoNet);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final boolean isEnable() {
        return j.a.f217090a.getNetworkState().a();
    }

    public b(a r100) {
        this.f483438a = r100;
    }
}
