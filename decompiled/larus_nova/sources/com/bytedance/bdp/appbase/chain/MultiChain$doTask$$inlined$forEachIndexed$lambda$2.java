package com.bytedance.bdp.appbase.chain;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\n\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/bdp/appbase/chain/d0;", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Throwable;)Ljava/lang/Void;", "com/bytedance/bdp/appbase/chain/MultiChain$doTask$2$4", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class MultiChain$doTask$$inlined$forEachIndexed$lambda$2 extends Lambda implements Function2 {
    final /* synthetic */ AtomicInteger $count$inlined;
    final /* synthetic */ f $data$inlined;
    final /* synthetic */ AtomicBoolean $error$inlined;
    final /* synthetic */ Map $parentMap$inlined;
    final /* synthetic */ Object[] $results$inlined;
    final /* synthetic */ q this$0;

    public MultiChain$doTask$$inlined$forEachIndexed$lambda$2(q r100, AtomicBoolean r101, f r102, Object[] r103, AtomicInteger r104, Map r105) {
        this.this$0 = r100;
        this.$error$inlined = r101;
        this.$data$inlined = r102;
        this.$results$inlined = r103;
        this.$count$inlined = r104;
        this.$parentMap$inlined = r105;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((f) r100, (Throwable) r101);
    }

    public final Void invoke(f r100, Throwable r101) {
        throw null;
    }
}
