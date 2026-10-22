package ecc;

import android.view.View;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements mcc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472182a;

    public i(b r100) {
        this.f472182a = r100;
    }

    @Override // mcc.a
    public final void s(View r100, AbbreviationInfo r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "abbreviationInfo");
        mcc.a r104 = this.f472182a.f472175j;
        if (r104 == null) goto L6;
        r104.s(r100, r101, r102, r103);
        return;
    }
}
