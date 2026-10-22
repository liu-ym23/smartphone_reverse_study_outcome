package com.bytedance.jedi.ext.adapter.decorator;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LLcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;;", "DEC", "Lcom/bytedance/jedi/arch/IReceiver;", "RECEIVER", "Landroid/view/ViewGroup;", "it", "Lcom/bytedance/jedi/ext/adapter/decorator/c;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/ViewGroup;)Lcom/bytedance/jedi/ext/adapter/decorator/c;", "om/bytedance/jedi/ext/adapter/decorator/ViewModelDecoration.attachTo.1.", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ViewModelDecoration$attachTo$$inlined$apply$lambda$1 extends Lambda implements Function1<ViewGroup, c> {
    final /* synthetic */ Function2 $loadingCreator;
    final /* synthetic */ e this$0;

    public ViewModelDecoration$attachTo$$inlined$apply$lambda$1(Function2 r100, e r101) {
        this.$loadingCreator = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c invoke2(ViewGroup r100) {
        return (c) this.$loadingCreator.invoke(r100, new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
