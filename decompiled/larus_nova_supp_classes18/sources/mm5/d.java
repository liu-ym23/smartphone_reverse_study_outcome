package mm5;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends e0 {
    public final View b;
    public final String c;
    public final View.OnClickListener d;

    public d(BaseTitleBar r3) {
        Intrinsics.checkNotNullParameter("header", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "titleView");
        super("header");
        this.b = r3;
        this.c = "";
        this.d = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return this.b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r1, List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "itemView");
        Intrinsics.checkNotNullParameter(r1, "itemView");
        if ((this.b instanceof BaseTitleBar) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L7;
        ((BaseTitleBar) this.b).setTitle(this.c);
    L7:
        View.OnClickListener r3 = this.d;
        if (r3 == null) goto L12;
        ((BaseTitleBar) this.b).setLeftClickListener(r3);
        return;
    }
}
