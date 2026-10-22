package com.ss.android.lark.widget.light.span;

import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mcc.d.a f446237a;

    public final int hashCode() {
        return this.f446237a.hashCode();
    }

    public d(mcc.d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f446237a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f446237a, ((d) r100).f446237a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r100.getTag(R.id.tag_long_press) == null) goto L8;
        r100.setTag(R.id.tag_long_press, null);
        return;
    L8:
        ((mcc.d) r100).e(r100, this.f446237a);
    }
}
