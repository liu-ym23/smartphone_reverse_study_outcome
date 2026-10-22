package com.ss.android.lark.coremdbiz.facade.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/image/ImageGalleryLayout$ImageData;", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkImageExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImageGalleryPlugin$prepareImageGallerySpan$1$onBindView$1$1 extends Lambda implements Function1<LarkImageExtend, com.ss.android.lark.widget.light.image.a.b> {
    final /* synthetic */ v7b.l $it;

    public ImageGalleryPlugin$prepareImageGallerySpan$1$onBindView$1$1(v7b.l r100) {
        this.$it = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.widget.light.image.a.b invoke2(LarkImageExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$LarkImageExtend");
        v7b.l r101 = this.$it;
        return new com.ss.android.lark.widget.light.image.a.b(r101.f553559j, r100.f(r101), r100.d(this.$it), this.$it.f553560k);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.widget.light.image.a.b invoke(LarkImageExtend r100) {
        return invoke2(r100);
    }
}
