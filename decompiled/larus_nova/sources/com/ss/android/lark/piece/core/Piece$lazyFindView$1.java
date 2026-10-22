package com.ss.android.lark.piece.core;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE, "()Landroid/view/View;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class Piece$lazyFindView$1 extends Lambda implements Function0<View> {
    final /* synthetic */ int $id;
    final /* synthetic */ Piece<View> this$0;

    public Piece$lazyFindView$1(Piece<View> r100, int r101) {
        this.this$0 = r100;
        this.$id = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        this.this$0.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }
}
