package wgb;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<Object> f559626a;

    public c(b<Object> r100) {
        this.f559626a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a<Object> r101 = this.f559626a.f559617e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r101 = null;
    L5:
        r101.e();
    }
}
