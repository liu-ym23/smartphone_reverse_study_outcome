package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "childId", "Landroid/view/View;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;", "<anonymous parameter 2>", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Landroid/view/View;Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ float $dy;
    final /* synthetic */ ViewGroup $viewGroup;
    final /* synthetic */ a this$0;

    public ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1(a r100, ViewGroup r101, float r102) {
        this.$viewGroup = r101;
        this.$dy = r102;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, View r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "childId");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "<anonymous parameter 2>");
        int r103 = a.f396658a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, View r101, b r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
