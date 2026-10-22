package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<c, d> {
    public View e;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        View r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentView");
        r0 = null;
    L5:
        TextView r1 = (TextView) r0.findViewById(2131375292);
        j54.a r2 = (j54.a) ((d) this.c).a.invoke();
        r1.setText("");
        r1.setOnClickListener(new e(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        View r5 = LayoutInflater.from(getContext()).inflate(2131558605, r4, false);
        this.e = r5;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("componentView");
        return null;
    L6:
        return r5;
    }

    public f(Context r2, c r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
