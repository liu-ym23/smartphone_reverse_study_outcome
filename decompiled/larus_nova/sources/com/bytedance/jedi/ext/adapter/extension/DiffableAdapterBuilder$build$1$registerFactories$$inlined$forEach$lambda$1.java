package com.bytedance.jedi.ext.adapter.extension;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.multitype.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "L;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(L;)Z", "kotlin/Int", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DiffableAdapterBuilder$build$1$registerFactories$$inlined$forEach$lambda$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ Function2 $matcher;
    final /* synthetic */ c $registry$inlined;
    final /* synthetic */ DiffableAdapterBuilder$build$1 this$0;

    public DiffableAdapterBuilder$build$1$registerFactories$$inlined$forEach$lambda$1(Function2 r100, DiffableAdapterBuilder$build$1 r101, c r102) {
        this.$matcher = r100;
        this.this$0 = r101;
        this.$registry$inlined = r102;
        super(1);
    }

    public final boolean invoke(int r100) {
        return ((Boolean) this.$matcher.invoke(Integer.valueOf(r100), this.this$0.getItem(r100, false))).booleanValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer r100) {
        return Boolean.valueOf(invoke(r100.intValue()));
    }
}
