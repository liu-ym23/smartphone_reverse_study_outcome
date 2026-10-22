package k28;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f501621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f501622b;

    public b() {
    }

    @Override // k28.c
    public Context getContext() {
        Context r100 = this.f501622b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L5:
        return r100;
    }
}
