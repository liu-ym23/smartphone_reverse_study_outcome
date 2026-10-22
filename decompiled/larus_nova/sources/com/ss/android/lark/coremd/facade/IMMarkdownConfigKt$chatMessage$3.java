package com.ss.android.lark.coremd.facade;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/IMContextExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMMarkdownConfigKt$chatMessage$3 extends Lambda implements Function2<IMContextExtend, com.ss.android.lark.coremd.base.parse.b, Unit> {
    public static final IMMarkdownConfigKt$chatMessage$3 INSTANCE = null;

    static {
        INSTANCE = new IMMarkdownConfigKt$chatMessage$3();
    }

    public IMMarkdownConfigKt$chatMessage$3() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IMContextExtend r100, com.ss.android.lark.coremd.base.parse.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "it");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IMContextExtend r100, com.ss.android.lark.coremd.base.parse.b r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
