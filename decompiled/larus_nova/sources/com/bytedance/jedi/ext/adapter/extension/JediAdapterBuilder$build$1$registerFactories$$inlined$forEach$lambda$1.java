package com.bytedance.jedi.ext.adapter.extension;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.multitype.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LLcom/bytedance/jedi/arch/IReceiver;;", "RECEIVER", "L;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(L;)Z", "kotlin/Int", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class JediAdapterBuilder$build$1$registerFactories$$inlined$forEach$lambda$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ Function2 $matcher;
    final /* synthetic */ c $registry$inlined;
    final /* synthetic */ JediAdapterBuilder$build$1 this$0;

    public JediAdapterBuilder$build$1$registerFactories$$inlined$forEach$lambda$1(Function2 r100, JediAdapterBuilder$build$1 r101, c r102) {
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
