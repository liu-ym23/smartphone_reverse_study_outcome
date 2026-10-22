package com.ss.android.lark.coremd.facade.mdeditor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkLinkExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WideCharLinkRegexResolver$parseUrl$1$1 extends Lambda implements Function1<LarkLinkExtend, Unit> {
    final /* synthetic */ n $link;

    public WideCharLinkRegexResolver$parseUrl$1$1(n r100) {
        this.$link = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LarkLinkExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$LarkLinkExtend");
        r100.f(this.$link, LinkType.PossibleLink);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LarkLinkExtend r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
