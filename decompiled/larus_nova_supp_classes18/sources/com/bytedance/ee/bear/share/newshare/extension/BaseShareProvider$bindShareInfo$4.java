package com.bytedance.ee.bear.share.newshare.extension;

import com.bytedance.ee.bear.share.export.f;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseShareProvider$bindShareInfo$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<f> $moreInfo;
    final /* synthetic */ BaseShareProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseShareProvider$bindShareInfo$4(BaseShareProvider r1, Function0<? extends f> r2) {
        this.this$0 = r1;
        this.$moreInfo = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m520invoke() {
        BaseShareProvider r0 = this.this$0;
        f r1 = (f) this.$moreInfo.invoke();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "shareInfo");
        r0.g = r1;
        ShareItemList r2 = r0.c;
        if (r2 == null) goto L7;
        tt5.a.h("ShareProvider", "invalidate.");
        d0 r3 = r2.a();
        r0.d.setValue(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m520invoke();
        return Unit.INSTANCE;
    }
}
