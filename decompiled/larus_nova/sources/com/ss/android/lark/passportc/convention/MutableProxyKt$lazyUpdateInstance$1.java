package com.ss.android.lark.passportc.convention;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import e0c.k;
import e0c.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "it", "Lcom/ss/android/lark/passportc/dwarf/UserComponent;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/passportc/dwarf/UserComponent;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class MutableProxyKt$lazyUpdateInstance$1 extends Lambda implements Function1 {
    public static final MutableProxyKt$lazyUpdateInstance$1 INSTANCE = null;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new MutableProxyKt$lazyUpdateInstance$1();
    }

    public MutableProxyKt$lazyUpdateInstance$1() {
        super(1);
    }

    public final Object invoke(l r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return k.b(r100, Object.class);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((l) r100);
    }
}
