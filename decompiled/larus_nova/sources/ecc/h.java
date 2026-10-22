package ecc;

import android.view.View;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements mcc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472181a;

    public h(b r100) {
        this.f472181a = r100;
    }

    @Override // mcc.e
    public final void n(View r100, CodeBlockV2Info r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "codeBlockV2Info");
        mcc.e r102 = this.f472181a.f472174i;
        if (r102 == null) goto L6;
        r102.n(r100, r101);
        return;
    }
}
