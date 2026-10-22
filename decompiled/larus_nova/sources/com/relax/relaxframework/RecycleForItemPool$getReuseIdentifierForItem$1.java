package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RecycleForItemPool$getReuseIdentifierForItem$1 extends Lambda implements Function0<String> {
    final /* synthetic */ int $index;
    final /* synthetic */ Object $item;
    final /* synthetic */ c4<Object> this$0;

    public RecycleForItemPool$getReuseIdentifierForItem$1(c4<Object> r100, Object r101, int r102) {
        this.this$0 = r100;
        this.$item = r101;
        this.$index = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        Function2<? super Object, ? super Integer, String> r100 = this.this$0.f405037d;
        Intrinsics.checkNotNull(r100);
        return r100.invoke(this.$item, Integer.valueOf(this.$index));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
