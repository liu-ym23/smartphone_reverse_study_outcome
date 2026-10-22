package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import eab.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremd/facade/mdeditor/media/DraftMediaUploadSpan;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMMediaExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorMediaPlugin$configureSpanFactory$1$draftMediaUploadSpan$1 extends Lambda implements Function1<IMMediaExtend, com.ss.android.lark.coremd.facade.mdeditor.media.a> {
    final /* synthetic */ f $node;

    public IMEditorMediaPlugin$configureSpanFactory$1$draftMediaUploadSpan$1(f r100) {
        this.$node = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.coremd.facade.mdeditor.media.a invoke2(IMMediaExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMMediaExtend");
        f r101 = this.$node;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        c r102 = r100.f419682n;
        KProperty<Object>[] r103 = IMMediaExtend.f419670r;
        String r104 = (String) r102.getValue(r101, r103[11]);
        f r105 = this.$node;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        return new com.ss.android.lark.coremd.facade.mdeditor.media.a(r104, (String) r100.f419683o.getValue(r105, r103[12]));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.coremd.facade.mdeditor.media.a invoke(IMMediaExtend r100) {
        return invoke2(r100);
    }
}
