package wgb;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<Object> f559627a;

    public d(b<Object> r100) {
        this.f559627a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f<Object> r101 = this.f559627a.f559616d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r101 = null;
    L5:
        r101.e();
    }
}
