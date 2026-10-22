package ecc;

import android.view.View;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;
import mcc.o;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472177a;

    public d(b r100) {
        this.f472177a = r100;
    }

    @Override // mcc.o
    public final void r(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        o r102 = this.f472177a.f472170e;
        if (r102 == null) goto L6;
        r102.r(r100, r101);
        return;
    }

    @Override // mcc.o
    public final boolean t(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        o r102 = this.f472177a.f472170e;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.t(r100, r101);
    }
}
