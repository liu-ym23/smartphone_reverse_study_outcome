package com.bytedance.awemeopen.apps.framework.feed.ui.information.tag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<c, d> {

    public static final class a extends IWrittenLayout {
        public final View f() {
            ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-1, -2);
            r0.setMargins(0, g(6), 0, 0);
            Unit r1 = Unit.INSTANCE;
            Function1<LinearLayout, Unit> r2 = new TagElementView$createView$1$createView$2(this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r2);
        }

        public a(Context r1) {
            super(r1);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(getContext()).j();
    }

    public b(Context r2, c r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
