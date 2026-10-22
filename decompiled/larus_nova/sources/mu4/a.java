package mu4;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.bytedance.ee.bear.bizwidget.shareview.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515745a;

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean rF(ShareItemModel r100) {
        Intrinsics.checkNotNullParameter(r100, "shareItem");
        return true;
    }

    public final Context getContext() {
        return this.f515745a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f515745a = r100;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean U10(ShareItemModel r100) {
        Intrinsics.checkNotNullParameter(r100, "shareItem");
        Toast.showText(this.f515745a, R.string.Bitable_Form_PleaseTurnOnFormShare);
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        Toast.showText(this.f515745a, R.string.Bitable_Form_PleaseTurnOnFormShare);
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final void xq(ShareType r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        if (r102 == 12) goto L6;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r102, "");
        return;
    }
}
