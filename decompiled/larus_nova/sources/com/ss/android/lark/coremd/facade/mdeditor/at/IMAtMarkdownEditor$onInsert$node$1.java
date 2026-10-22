package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import hob.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMAtMarkdownEditor$onInsert$node$1 extends Lambda implements Function1<IMAtNodeExtend, eab.a> {
    final /* synthetic */ c $data;

    public IMAtMarkdownEditor$onInsert$node$1(c r100) {
        this.$data = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final eab.a invoke2(IMAtNodeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMAtNodeExtend");
        c r101 = this.$data;
        eab.a r102 = new eab.a(r101.f486309b, r101.f486308a);
        r100.d(r102, this.$data.f486312e);
        r100.f(r102, this.$data.f486311d);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ eab.a invoke(IMAtNodeExtend r100) {
        return invoke2(r100);
    }
}
