package mu4;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.bizwidget.shareview.b {
    public final Context a;

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean rF(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        return true;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean U10(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        Toast.showText(this.a, 2131886525);
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        Toast.showText(this.a, 2131886525);
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final void xq(ShareType r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        if (r5 == 12) goto L6;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r5, "");
        return;
    }
}
