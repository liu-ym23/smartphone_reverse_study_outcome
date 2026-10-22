package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItem;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class CommonMenu$itemClickListener$1 extends Lambda implements Function1<fk5.a, Unit> {
    public static final CommonMenu$itemClickListener$1 INSTANCE = null;

    static {
        INSTANCE = new CommonMenu$itemClickListener$1();
    }

    public CommonMenu$itemClickListener$1() {
        super(1);
    }

    public final void invoke(fk5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((fk5.a) r1);
        return Unit.INSTANCE;
    }
}
