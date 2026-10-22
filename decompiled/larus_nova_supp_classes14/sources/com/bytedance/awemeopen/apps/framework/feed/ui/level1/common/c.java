package com.bytedance.awemeopen.apps.framework.feed.ui.level1.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a, b> {

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ c c;

        public final View f() {
            FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
            final c r2 = this.c;
            Function1<LinearLayout, Unit> r1 = new CommonElementView$createView$1$createView$1(r2);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r1);
        }

        public a(c r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public c(Context r2, com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
