package com.ss.android.lark.widget.light.span;

import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.widget.span.PersonInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PersonInfo f446250a;

    public final int hashCode() {
        return this.f446250a.hashCode();
    }

    public l(PersonInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f446250a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f446250a, ((l) r100).f446250a);
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
        ((mcc.k) r100).l(r100, this.f446250a.getUserId());
    }
}
