package ecc;

import android.view.View;
import androidx.autofill.HintConstants;
import kotlin.jvm.internal.Intrinsics;
import mcc.l;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472176a;

    public c(b r100) {
        this.f472176a = r100;
    }

    @Override // mcc.l
    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        l r102 = this.f472176a.f472169d;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // mcc.l
    public final void b(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        l r102 = this.f472176a.f472169d;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
