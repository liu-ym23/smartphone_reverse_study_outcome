package com.relax.relaxframework;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/relax/relaxframework/RxElementImpl;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxElementImpl$findNativeChildren$1 extends Lambda implements Function1<RxElementImpl, Unit> {
    final /* synthetic */ ArrayList<RxElementImpl> $result;

    public RxElementImpl$findNativeChildren$1(ArrayList<RxElementImpl> r100) {
        this.$result = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RxElementImpl r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        com.bytedance.rts.foundation.j.j(this.$result, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RxElementImpl r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
