package nma;

import android.text.Editable;
import android.text.TextWatcher;
import com.obric.oui.stepper.OSteppers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSteppers f519616a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public g(OSteppers r100) {
        this.f519616a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 != null) goto L4;
        String r101 = null;
    L5:
        int r102 = 0;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        this.f519616a.getOnValueChangeListener();
    L14:
        if (r100 != null) goto L28;
    L23:
        OSteppers.U5(this.f519616a, r102);     // Catch: Exception -> L25
    L26:
        OSteppers r104 = this.f519616a;
        int r105 = OSteppers.f403043q;
        r104.V5();
        return;
    L25:
        int r106 = pla.b.f529795a;
        Intrinsics.checkNotNullParameter("OSteppers", "tag");
        Intrinsics.checkNotNullParameter("input type error", "msg");
        goto L26
    L28:
        String r107 = r100.toString();     // Catch: Exception -> L25
        if (r107 == null) goto L23;
        Integer r108 = StringsKt.toIntOrNull(r107);     // Catch: Exception -> L25
        if (r108 == null) goto L23;
        r102 = r108.intValue();     // Catch: Exception -> L25
        goto L23
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r103 = false;
        goto L12
    L4:
        r101 = r100.toString();
        goto L5
    }
}
