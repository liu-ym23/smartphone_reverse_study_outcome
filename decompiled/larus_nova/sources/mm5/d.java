package mm5;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f514468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View.OnClickListener f514470d;

    public d(BaseTitleBar r100) {
        Intrinsics.checkNotNullParameter("header", "id");
        Intrinsics.checkNotNullParameter(r100, "titleView");
        super("header");
        this.f514468b = r100;
        this.f514469c = "";
        this.f514470d = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return this.f514468b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r100, "itemView");
        if ((this.f514468b instanceof BaseTitleBar) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f514469c) == true) goto L7;
        ((BaseTitleBar) this.f514468b).setTitle(this.f514469c);
    L7:
        View.OnClickListener r102 = this.f514470d;
        if (r102 == null) goto L12;
        ((BaseTitleBar) this.f514468b).setLeftClickListener(r102);
        return;
    }
}
