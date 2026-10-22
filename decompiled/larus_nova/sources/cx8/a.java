package cx8;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonLoadView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements TTCJPayLoadingAdapter<CommonLoadView> {
    public a() {
    }

    @Override // com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter
    public final void onHide(CommonLoadView r100) {
        CommonLoadView r101 = r100;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter
    public final void onShow(CommonLoadView r100) {
        CommonLoadView r101 = r100;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter
    public final CommonLoadView initLoadingView(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<Activity> r102 = AppHost.f326268a.a().g();
        ListIterator<Activity> r103 = r102.listIterator(r102.size());
    L4:
        if (r103.hasPrevious() == false) goto L8;
        Activity r104 = r103.previous();
        if ((r104 instanceof j4) == false) goto L4;
    L9:
        Activity r105 = r104;
        if (r105 != null) goto L13;
        r105 = AppHost.f326268a.getApplication().getApplicationContext();
    L13:
        Intrinsics.checkNotNull(r105);
        CommonLoadView r106 = new CommonLoadView(f.d(r105), null, 0, true, 6);
        r106.setVisibility(8);
        return r106;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter
    public final void textAndBackgroundVisible(CommonLoadView r100, boolean r101) {
        TTCJPayLoadingAdapter.DefaultImpls.textAndBackgroundVisible(this, r100, r101);
    }
}
