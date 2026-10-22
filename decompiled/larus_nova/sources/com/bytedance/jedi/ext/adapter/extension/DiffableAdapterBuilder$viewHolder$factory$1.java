package com.bytedance.jedi.ext.adapter.extension;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.decorator.internal.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "com/bytedance/jedi/ext/adapter/extension/DiffableAdapterBuilder$viewHolder$factory$1$1", ExifInterface.GPS_DIRECTION_TRUE, "it", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/ViewGroup;)Lcom/bytedance/jedi/ext/adapter/extension/DiffableAdapterBuilder$viewHolder$factory$1$1;"}, k = 3, mv = {1, 1, 16})
final class DiffableAdapterBuilder$viewHolder$factory$1 extends Lambda implements Function1<ViewGroup, AnonymousClass1> {
    final /* synthetic */ int $layout;
    final /* synthetic */ Function3 $onBind;

    public DiffableAdapterBuilder$viewHolder$factory$1(Function3 r100, int r101) {
        this.$onBind = r100;
        this.$layout = r101;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.jedi.ext.adapter.extension.DiffableAdapterBuilder$viewHolder$factory$1$1] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final AnonymousClass1 invoke2(final ViewGroup r100) {
        final View r101 = b.a(r100, this.$layout);
        return new AnonymousClass1(this, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
