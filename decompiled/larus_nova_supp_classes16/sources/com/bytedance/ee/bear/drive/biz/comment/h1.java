package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h1 implements Function1<Integer, Unit> {
    public final /* synthetic */ a1 a;

    public h1(a1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        DriveCommentVM r0 = this.a.E;
        r0.setCommentPanelDefaultHeight((Integer) r2);
        return null;
    }
}
