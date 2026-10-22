package com.ss.android.lark.widget.codeblock.preview;

import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import mcc.e;

/* JADX INFO: loaded from: classes38.dex */
public final class CodeBlockV2ClickSpan extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CodeBlockV2Info f445661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f445662b;

    public final int hashCode() {
        return this.f445661a.hashCode();
    }

    public CodeBlockV2ClickSpan(CodeBlockV2Info r100) {
        Intrinsics.checkNotNullParameter(r100, "codeBlockV2Info");
        this.f445661a = r100;
        this.f445662b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CodeBlockV2ClickSpan$clickThrottle$2.INSTANCE);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockV2ClickSpan) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f445661a, ((CodeBlockV2ClickSpan) r100).f445661a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof e) == true) goto L6;
        return;
    L6:
        if (((com.ss.android.lark.widget.light.span.e) this.f445662b.getValue()).a() == true) goto L9;
        return;
    L9:
        if (r100.getTag(R.id.tag_long_press) == null) goto L11;
        r100.setTag(R.id.tag_long_press, null);
        return;
    L11:
        ((e) r100).n(r100, this.f445661a);
    }
}
