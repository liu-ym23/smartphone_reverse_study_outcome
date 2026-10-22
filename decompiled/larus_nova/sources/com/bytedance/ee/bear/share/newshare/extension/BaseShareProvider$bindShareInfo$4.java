package com.bytedance.ee.bear.share.newshare.extension;

import com.bytedance.ee.bear.share.export.f;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseShareProvider$bindShareInfo$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<f> $moreInfo;
    final /* synthetic */ BaseShareProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseShareProvider$bindShareInfo$4(BaseShareProvider r100, Function0<? extends f> r101) {
        this.this$0 = r100;
        this.$moreInfo = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseShareProvider r100 = this.this$0;
        f r101 = this.$moreInfo.invoke();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "shareInfo");
        r100.f237202g = r101;
        ShareItemList r102 = r100.f237198c;
        if (r102 == null) goto L7;
        tt5.a.h("ShareProvider", "invalidate.");
        d0 r103 = r102.a();
        r100.f237199d.setValue(r103);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
