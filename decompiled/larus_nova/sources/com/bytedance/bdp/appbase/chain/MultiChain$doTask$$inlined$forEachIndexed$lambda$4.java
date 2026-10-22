package com.bytedance.bdp.appbase.chain;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/bdp/appbase/chain/d0;", "R", "Lcom/bytedance/bdp/appbase/chain/f;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;)V", "com/bytedance/bdp/appbase/chain/MultiChain$doTask$2$6", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class MultiChain$doTask$$inlined$forEachIndexed$lambda$4 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ AtomicInteger $count$inlined;
    final /* synthetic */ f $data$inlined;
    final /* synthetic */ AtomicBoolean $error$inlined;
    final /* synthetic */ int $index;
    final /* synthetic */ Map $parentMap$inlined;
    final /* synthetic */ Object[] $results$inlined;
    final /* synthetic */ q this$0;

    public MultiChain$doTask$$inlined$forEachIndexed$lambda$4(int r100, q r101, AtomicBoolean r102, f r103, Object[] r104, AtomicInteger r105, Map r106) {
        this.$index = r100;
        this.this$0 = r101;
        this.$error$inlined = r102;
        this.$data$inlined = r103;
        this.$results$inlined = r104;
        this.$count$inlined = r105;
        this.$parentMap$inlined = r106;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100) {
        r100.f200696b = Integer.valueOf(this.$data$inlined.f200695a);
        r100.f200717w = Math.min(6, Math.max(0, 0));
        f r101 = this.$data$inlined;
        SparseArray<f> r102 = r101.f200702h;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r101.f200705k == false) goto L9;
        r100.b();     // Catch: Throwable -> L13
        monitor-exit(r102);
    L12:
        throw null;
    L9:
        r101.f200702h.put(r100.f200697c, r100);     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
