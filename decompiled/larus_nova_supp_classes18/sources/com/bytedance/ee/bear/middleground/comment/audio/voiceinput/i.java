package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements UDToast.b {
    public final /* synthetic */ Function0<Unit> a;

    public i(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.compose.foundation.toast.b r2) {
        Intrinsics.checkNotNullParameter(r2, Notice.CLICK_TYPE_TOAST);
        r2.cancel();
        this.a.invoke();
    }
}
