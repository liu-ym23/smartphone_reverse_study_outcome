package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;)Ljava/lang/Integer;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtPlugin$configureSpanFactory$1$color$1 extends Lambda implements Function1<IMAtNodeExtend, Integer> {
    final /* synthetic */ Context $context;
    final /* synthetic */ eab.a $node;

    public IMEditorAtPlugin$configureSpanFactory$1$color$1(eab.a r100, Context r101) {
        this.$node = r100;
        this.$context = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(IMAtNodeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMAtNodeExtend");
        if (r100.a(this.$node) == false) goto L5;
    L8:
        int r101 = UDColorUtils.getColor(this.$context, R.color.text_caption);
    L10:
        return Integer.valueOf(r101);
    L5:
        if (r100.b(this.$node) == true) goto L8;
        r101 = UDColorUtils.getColor(this.$context, R.color.text_link_normal);
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(IMAtNodeExtend r100) {
        return invoke2(r100);
    }
}
