package com.bytedance.ee.bear.middleground.comment.card;

import com.ss.android.lark.api.bean.ForsetiViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 implements com.ss.android.lark.api.ui.j {
    public final /* synthetic */ FloatCardComment a;

    public g0(FloatCardComment r1) {
        this.a = r1;
    }

    public final void a(ForsetiViewMode r3) {
        Intrinsics.checkNotNullParameter(r3, "viewMode");
        this.a.T = r3;
        tt5.a.h("Comment#CardComment2", "onForsetiViewModeChanged changed: viewMode= " + r3);
    }
}
