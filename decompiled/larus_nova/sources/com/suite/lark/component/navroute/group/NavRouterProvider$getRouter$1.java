package com.suite.lark.component.navroute.group;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.lark.component.navroute.api.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/suite/lark/component/navroute/api/IRouter;", "it", "Lcom/suite/lark/component/navroute/api/NavRouterFactory;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/suite/lark/component/navroute/api/NavRouterFactory;)Lcom/suite/lark/component/navroute/api/IRouter;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class NavRouterProvider$getRouter$1 extends Lambda implements Function1<h<com.suite.lark.component.navroute.api.a<?, ?>>, com.suite.lark.component.navroute.api.a<?, ?>> {
    final /* synthetic */ Context $context;

    public NavRouterProvider$getRouter$1(Context r100) {
        this.$context = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.suite.lark.component.navroute.api.a<?, ?> invoke2(h<com.suite.lark.component.navroute.api.a<?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.b(this.$context, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.suite.lark.component.navroute.api.a<?, ?> invoke(h<com.suite.lark.component.navroute.api.a<?, ?>> r100) {
        return invoke2(r100);
    }
}
