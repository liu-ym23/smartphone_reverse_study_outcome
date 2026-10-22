package x76;

import android.text.Editable;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoCopySpan[] f562826a;

    public c(NoCopySpan... r100) {
        Intrinsics.checkNotNullParameter(r100, "spans");
        this.f562826a = r100;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        SpannableStringBuilder r101 = SpannableStringBuilder.valueOf(r100);
        NoCopySpan[] r102 = this.f562826a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.setSpan(r102[r104], 0, r100.length(), 18);
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }
}
