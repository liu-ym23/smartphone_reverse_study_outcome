package com.ss.android.lark.coremd.nonimbiz.asl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.n;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/IMContextExtend;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/facade/bizext/IMContextExtend;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ASLTextMarkdownPlugin$configureClick$1$isFromMe$1 extends Lambda implements Function1<IMContextExtend, Boolean> {
    final /* synthetic */ n.a<a> $this_on;

    public ASLTextMarkdownPlugin$configureClick$1$isFromMe$1(n.a<a> r100) {
        this.$this_on = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(IMContextExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMContextExtend");
        return Boolean.valueOf(r100.s(this.$this_on).f553889d);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(IMContextExtend r100) {
        return invoke2(r100);
    }
}
